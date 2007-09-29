package streamit.frontend.nodes;

public class ExprNew extends Expression {

	Type typeToConstruct;


	public ExprNew(FEContext context, Type typeToConstruct) {
		super(context);
		this.typeToConstruct = typeToConstruct;
		// TODO Auto-generated constructor stub
	}

	public Type getTypeToConstruct () {
		return typeToConstruct;
	}

	@Override
	public Object accept(FEVisitor v) {
		return v.visitExprNew(this);
	}

	public String toString(){
		return "new " + typeToConstruct + "()";
	}

}

