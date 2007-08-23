package streamit.frontend.codegenerators;

import java.util.*;

import streamit.frontend.nodes.*;
import streamit.frontend.tojava.NodesToJava;

public class NodesToH extends NodesToJava {

	private NodesToC _converter;
	private String filename; 
	
	public NodesToH(String filename) {
		super(false,null);
		_converter=new NodesToC(null,filename);
		this.filename=filename;
	}
	
	@Override
	public Object visitProgram(Program prog)
	{
		String defname=filename.toUpperCase()+"_H";
		String ret="#ifndef "+defname+"\n";
		ret+="#define "+defname+"\n\n";
		ret+=super.visitProgram(prog);
		ret+="\n#endif\n";
		return ret;
	}

	public Object visitStreamSpec(StreamSpec spec){
		String result = "";
		ss = spec;
		for (Iterator iter = spec.getFuncs().iterator(); iter.hasNext(); )
		{
			Function oldFunc = (Function)iter.next();            
			result += (String)oldFunc.accept(this);            
		}
		return result;
	}
	
	public Object visitFunction(Function func)
	{
		String result = indent + "extern ";
		result += _converter.convertType(func.getReturnType()) + " ";
		result += func.getName();
		String prefix = null;
		result += _converter.doParams(func.getParams(), prefix) + ";\n";
		return result;
    }

}
