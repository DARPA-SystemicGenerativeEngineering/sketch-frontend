package sketch.transformer;

import java.util.Map;
import java.util.TreeMap;

import sketch.compiler.ast.core.Program;

public class State {
	Map<String, Param> state = new TreeMap<String, Param>();
	private Program program;

	public Program get_program() {
		return program;
	}

	public void set_program(Program new_program) {
		program = new_program;
	}

	public State(Program _program) {
		program = _program;
	}

	public void add(Identifier identifier, Param param)
	{
		String key = identifier.toString();
		assert (!state.containsKey(key));
		state.put(key, param);
	}

	public Param get(Identifier identifier) {
		assert (state.containsKey(identifier.get_name()));
		return state.get(identifier.get_name());
	}
}
