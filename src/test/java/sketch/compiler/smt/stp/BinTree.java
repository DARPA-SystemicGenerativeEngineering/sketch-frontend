package sketch.compiler.smt.stp;

import java.util.HashMap;

public class BinTree extends sketch.compiler.smt.tests.BinTree {

	@Override
	protected HashMap<String, String> initCmdArgs(String input) {
		HashMap<String, String> argsMap = super.initCmdArgs(input);
		argsMap.put("--backend", "stp");
		
//		argsMap.put("--verbosity", "4");
//		argsMap.put("--showphase", "parse");

		System.out.print(input + "\tstp");
		return argsMap;
	}
}
