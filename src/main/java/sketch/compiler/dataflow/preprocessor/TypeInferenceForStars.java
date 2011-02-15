package sketch.compiler.dataflow.preprocessor;

import sketch.compiler.ast.core.FEReplacer;
import sketch.compiler.ast.core.exprs.ExprArrayRange;
import sketch.compiler.ast.core.exprs.ExprArrayRange.RangeLen;
import sketch.compiler.ast.core.exprs.ExprBinary;
import sketch.compiler.ast.core.exprs.ExprStar;
import sketch.compiler.ast.core.exprs.ExprTernary;
import sketch.compiler.ast.core.exprs.ExprVar;
import sketch.compiler.ast.core.exprs.Expression;
import sketch.compiler.ast.core.stmts.*;
import sketch.compiler.ast.core.typs.Type;
import sketch.compiler.ast.core.typs.TypeArray;
import sketch.compiler.ast.core.typs.TypePrimitive;
import sketch.compiler.passes.lowering.SymbolTableVisitor;
/**
 * This visitor distinguishes between int stars and bit stars, and labels each star with its
 * appropriate type.
 *
 *
 * @author asolar
 *
 */
public class TypeInferenceForStars extends SymbolTableVisitor {

	public TypeInferenceForStars(){
		super(null);
	}

	public Object visitStmtAtomicBlock(StmtAtomicBlock stmt){
		if(stmt.isCond()){
			Expression ie = stmt.getCond();
	    	ie.accept(new UpgradeStarToInt(this, TypePrimitive.bittype) );
		}
		return super.visitStmtAtomicBlock(stmt);
	}
	
    public Object visitStmtIfThen(StmtIfThen stmt){
    	Expression ie = stmt.getCond();
    	ie.accept(new UpgradeStarToInt(this, TypePrimitive.bittype) );
    	return super.visitStmtIfThen(stmt);
    }

    public Object visitStmtWhile(StmtWhile stmt){
      Expression ie = stmt.getCond();
      ie.accept(new UpgradeStarToInt(this, TypePrimitive.bittype) );
      return super.visitStmtWhile(stmt);
    }

    public Object visitStmtDoWhile(StmtDoWhile stmt){
      Expression ie = stmt.getCond();
      ie.accept(new UpgradeStarToInt(this, TypePrimitive.bittype) );
      return super.visitStmtDoWhile(stmt);
    }

    @Override
    public Object visitStmtAssert(StmtAssert a){
    	a.getCond().accept(new UpgradeStarToInt(this, TypePrimitive.bittype) );
    	return a;
    }


    public Object visitStmtFor(StmtFor stmt)
    {
    	if( stmt.getCond() != null){
    		stmt.getCond().accept( new UpgradeStarToInt(this, TypePrimitive.bittype)  );
    	}
       return super.visitStmtFor(stmt);
    }

    public Object visitStmtLoop(StmtLoop stmt){
    	Expression ie = stmt.getIter();
    	ie.accept(new UpgradeStarToInt(this, TypePrimitive.inttype) );
    	return super.visitStmtLoop(stmt);
    }

    private Type matchTypes(Statement stmt,String lhsn, Type lt, Type rt){
//    	if((lt != null && rt != null && !rt.promotesTo(lt)))
//    	{
//        	if((lt != null && rt != null && !rt.promotesTo(lt)))
//        		System.out.println("CRAP");
//    	}
    	stmt.assertTrue (
    			lt !=null && rt != null,
    			"internal error: " + lt + "   " + rt);
    	stmt.assertTrue (
    			rt.promotesTo(lt),
    			"Type missmatch " + lt +" !>= " + rt);
        return lt;
    }
    public void upgradeStarToInt(Expression exp, Type ftype){
     	   exp.accept(new UpgradeStarToInt(this, ftype) );
    }
	public Object visitStmtAssign(StmtAssign stmt)
    {
	   Type lt = getType(stmt.getLHS());
       Type rt = getType(stmt.getRHS());
       String lhsn = null;
       Expression lhsExp = stmt.getLHS();
       while(lhsExp instanceof ExprArrayRange){
          	lhsExp = ((ExprArrayRange)lhsExp).getBase();
       }
       if(lhsExp instanceof ExprVar){
       	lhsn = ( (ExprVar) lhsExp).getName();
       }
       Type ftype = matchTypes(stmt, lhsn, lt, rt);
       upgradeStarToInt(stmt.getRHS(), ftype);
       upgradeStarToInt(stmt.getLHS(), ftype);
        // recurse:
        Statement result = (Statement)super.visitStmtAssign(stmt);
        return result;
    }
	public Object visitStmtVarDecl(StmtVarDecl stmt)
    {
    	Object result = super.visitStmtVarDecl(stmt);
        for (int i = 0; i < stmt.getNumVars(); i++){
        	Expression ie = stmt.getInit(i);
        	if(ie != null){
        		Type rt = getType(ie);
        		Type ftype = matchTypes(stmt, stmt.getName(i), actualType(stmt.getType(i)), rt);
        		upgradeStarToInt(ie, ftype);
        	}
        }
        return result;
    }
	@Override
	public Object visitTypeArray(TypeArray ta){
	    Expression ie = ta.getLength();
        ie.accept(new UpgradeStarToInt(this, TypePrimitive.inttype) );
	    return super.visitTypeArray(ta);
	}
	
}

class UpgradeStarToInt extends FEReplacer{
	private final SymbolTableVisitor stv;
	Type type;
	UpgradeStarToInt(SymbolTableVisitor stv, Type type){
		this.stv = stv;
		this.type = type;
	}

	public Object visitExprStar(ExprStar star) {
	    star.setType(type);
		return star;
	}

    public Object visitExprTernary(ExprTernary exp)
    {
    	Type oldType = type;
    	type = TypePrimitive.bittype;
        Expression a = doExpression(exp.getA());
        type = oldType;
        Expression b = doExpression(exp.getB());
        Expression c = doExpression(exp.getC());
        if (a == exp.getA() && b == exp.getB() && c == exp.getC())
            return exp;
        else
            return new ExprTernary(exp, exp.getOp(), a, b, c);
    }
    public Object visitExprBinary(ExprBinary exp)
    {
		switch(exp.getOp()){
        case ExprBinary.BINOP_GE:
        case ExprBinary.BINOP_GT:
        case ExprBinary.BINOP_LE:
        case ExprBinary.BINOP_LT:{
        	Type oldType = type;
        	type = TypePrimitive.inttype;
        	Expression left = doExpression(exp.getLeft());
            Expression right = doExpression(exp.getRight());
            type = oldType;
            if (left == exp.getLeft() && right == exp.getRight())
                return exp;
            else
                return new ExprBinary(exp, exp.getOp(), left, right,  exp.getAlias());
        }
        case ExprBinary.BINOP_LSHIFT:
        case ExprBinary.BINOP_RSHIFT:{
        	Expression left = doExpression(exp.getLeft());
        	Type oldType = type;
        	type = TypePrimitive.inttype;
            Expression right = doExpression(exp.getRight());
            type = oldType;
            if (left == exp.getLeft() && right == exp.getRight())
                return exp;
            else
                return new ExprBinary(exp, exp.getOp(), left, right,  exp.getAlias());
        }
        case ExprBinary.BINOP_NEQ:
        case ExprBinary.BINOP_EQ:{
        	Type tleft = stv.getType(exp.getLeft());
        	Type tright = stv.getType(exp.getRight());
        	Type tboth = tleft.leastCommonPromotion(tright);
        	Type oldType = type;
        	type = tboth;
        	Expression left = doExpression(exp.getLeft());
            Expression right = doExpression(exp.getRight());
            type = oldType;
            if (left == exp.getLeft() && right == exp.getRight())
                return exp;
            else
                return new ExprBinary(exp, exp.getOp(), left, right,  exp.getAlias());
        }


        default:
        	return super.visitExprBinary(exp);
		}
    }
    public Object visitStmtLoop(StmtLoop stmt)
    {
    	Type oldType = type;
    	type = TypePrimitive.inttype;
        Expression newIter = doExpression(stmt.getIter());
        type = oldType;
        Statement newBody = (Statement)stmt.getBody().accept(this);
        if (newIter == stmt.getIter() && newBody == stmt.getBody())
            return stmt;
        return new StmtLoop(stmt, newIter, newBody);
    }


    public Object visitExprArrayRange(ExprArrayRange exp){
    	boolean change=false;
		Expression newBase=doExpression(exp.getBase());
		if(newBase!=exp.getBase()) change=true;
		
		RangeLen range=exp.getSelection();
        Expression newStart = null;
        {
            Type oldType = type;
            type = TypePrimitive.inttype;
            newStart=doExpression(range.start());
            type = oldType;
        }
        if(newStart!=range.start()) change=true;
        
        Expression newLen = null;
        if(range.hasLen()){
            Type oldType = type;
            type = TypePrimitive.inttype;
            newLen=doExpression(range.getLenExpression());
            type = oldType;
        }
        if(range.getLenExpression() != newLen) change = true;
		
		if(!change) return exp;
		return new ExprArrayRange(exp, newBase,new RangeLen(newStart, newLen));
    }
}
