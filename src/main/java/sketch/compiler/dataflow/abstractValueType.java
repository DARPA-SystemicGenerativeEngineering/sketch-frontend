package streamit.frontend.experimental;

import java.util.List;

import streamit.frontend.nodes.ExprStar;
import streamit.frontend.nodes.Type;


public abstract class abstractValueType{
	public PartialEvaluator eval;
	
	public void setPeval(PartialEvaluator eval){
		this.eval = eval;
	}
	
	abstract public abstractValue STAR(ExprStar star);
	abstract public abstractValue BOTTOM(); // == BOTTOM(TypePrimitive);
	abstract public abstractValue BOTTOM(Type t);	
	/**
	 * Called by varDeclare. Used to create the state that goes on the left hand side.
	 * @param var the name of the variable we are declaring.
	 * @param t the type.
	 * @return
	 */
	abstract public varState cleanState(String var, Type t);
	abstract public abstractValue CONST(int v);
	abstract public abstractValue ARR(List<abstractValue> vals);
	
	
	abstract public abstractValue plus(abstractValue v1, abstractValue v2);
	abstract public abstractValue minus(abstractValue v1, abstractValue v2);
	abstract public abstractValue times(abstractValue v1, abstractValue v2);
	abstract public abstractValue over(abstractValue v1, abstractValue v2);
	abstract public abstractValue mod(abstractValue v1, abstractValue v2);
	
	abstract public abstractValue and(abstractValue v1, abstractValue v2);
	abstract public abstractValue or(abstractValue v1, abstractValue v2);
	abstract public abstractValue xor(abstractValue v1, abstractValue v2);
	abstract public abstractValue gt(abstractValue v1, abstractValue v2);
	abstract public abstractValue lt(abstractValue v1, abstractValue v2);
	abstract public abstractValue ge(abstractValue v1, abstractValue v2);
	abstract public abstractValue le(abstractValue v1, abstractValue v2);
	abstract public abstractValue eq(abstractValue v1, abstractValue v2);
	
	abstract public abstractValue arracc(abstractValue arr, abstractValue idx);
	abstract public abstractValue arracc(abstractValue arr, abstractValue idx, abstractValue len);
	
	abstract public abstractValue cast(abstractValue v1, Type t);
	
	abstract public abstractValue not(abstractValue v1);
	abstract public abstractValue neg(abstractValue v1);
	
	abstract public abstractValue join(abstractValue v1, abstractValue v2);
	abstract public abstractValue condjoin(abstractValue cond, abstractValue vtrue, abstractValue vfalse);
	abstract public void Assert(abstractValue val);
	abstract public abstractValue funcall(String name, List<abstractValue> params , List<String> outputs);
}

