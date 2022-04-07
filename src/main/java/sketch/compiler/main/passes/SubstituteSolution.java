package sketch.compiler.main.passes;

import sketch.compiler.ast.core.Program;
import sketch.compiler.ast.core.TempVarGen;
import sketch.compiler.main.cmdline.SketchOptions;
import sketch.compiler.solvers.constructs.ValueOracle;
import sketch.compiler.stencilSK.EliminateHoleStatic;

/**
 * Substitute a solution into a program, and simplify the program.
 * 
 * @author gatoatigrado (nicholas tung) [email: ntung at ntung]
 * @license This file is licensed under BSD license, available at
 *          http://creativecommons.org/licenses/BSD/. While not required, if you make
 *          changes, please consider contributing back!
 */
public class SubstituteSolution extends MetaStage {
    protected final ValueOracle solution;

    public SubstituteSolution(TempVarGen varGen, SketchOptions options,
            ValueOracle solution)
    {
        super("subst", "Substitute a solution (assignment to ??'s) into the sketch",
                varGen, options);
        this.solution = solution;
    }

    @Override
    public Program visitProgramInner(Program prog) {

		// HERE CALL FMTL TRANSOFRM AST <<<< call the interpreter here.
		// each function: init; clone; replace; concretize will be a class
		// derived from FEReplacer
		// e.g. for clone I
		// class ApplyTransformations:
		// for each line in ftml program
		// calls each of the visitors.

		EliminateHoleStatic eliminate_star = new EliminateHoleStatic(solution);
        Program p = (Program) prog.accept(eliminate_star);

        if (options.feOpts.outputXml != null) {
            eliminate_star.dump_xml(options.feOpts.outputXml);
        }

        return p;
    }
}
