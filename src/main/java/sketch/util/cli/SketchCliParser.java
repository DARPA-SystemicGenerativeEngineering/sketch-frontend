package sketch.util.cli;

import java.util.Vector;

import org.apache.commons.cli.Options;

/**
 * append all shortargs ("-name") to a vector, so that they will be passed to the backend.
 * 
 * @author gatoatigrado (nicholas tung) [email: ntung at ntung]
 * @license This file is licensed under BSD license, available at
 *          http://creativecommons.org/licenses/BSD/. While not required, if you make
 *          changes, please consider contributing back!
 */
public class SketchCliParser extends CliParser {
    public Vector<String> backendArgs = new Vector<String>();

    public SketchCliParser(String[] args, String usage, boolean errorOnUnknown) {
        super(args, usage, errorOnUnknown);
    }

    public SketchCliParser(String[] inArgs) {
        super(inArgs);
    }

    public SketchCliParser(String[] array, boolean errorOnUnknown) {
        super(array, errorOnUnknown);
    }

    /** returns true if the argument $next was consumed */
    @Override
    protected boolean handleUnknownLongarg(String arg, String next, Options options) {
        if (!arg.startsWith("--be")) {
            return super.handleUnknownLongarg(arg, next, options);
        }
        if (arg.startsWith("--beopt:")) {
            backendArgs.add("-" + arg.substring(8));
            assert next != null : "beopt args require another argument";
            backendArgs.add(next);
            return true;
        } else if (arg.startsWith("--be:")) {
            backendArgs.add("-" + arg.substring(5));
            return false;
        } else {
            System.err.println("WARNING -- ignoring unknown option " + arg);
            return false;
        }
    }
}
