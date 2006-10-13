#!/bin/bash

# Set classpath, solver path, and source path; adjust for Cygwin as necessary
#
TMPCLASSPATH="$FRONTEND/antlr-2.7.5.jar#$FRONTEND/bin#."
TMPSBITPATH="$SOLVER/"
TMPSOURCEPATH="${0%/*}"
TMPSOURCEPATH="${TMPSOURCEPATH%/*}"
if [ $OSTYPE == cygwin ]; then
  TMPCLASSPATH=${TMPCLASSPATH//\//\\}
  TMPCLASSPATH=${TMPCLASSPATH//\#/\;}
  TMPSBITPATH=${TMPSBITPATH//\//\\}
  TMPSBITPATH=${TMPSBITPATH//\#/\;}
  TMPSOURCEPATH=${TMPSOURCEPATH//\//\\}
  TMPSOURCEPATH=${TMPSOURCEPATH//\#/\;}
elif [ $OSTYPE == darwin8.0 ]; then
  TMPCLASSPATH=${TMPCLASSPATH//\\\#/\:}
  TMPSBITPATH=${TMPSBITPATH//\\\#/\:}
  TMPSOURCEPATH=${TMPSOURCEPATH//\\\#/\:}
else
  TMPCLASSPATH=${TMPCLASSPATH//\#/\:}
  TMPSBITPATH=${TMPSBITPATH//\#/\:}
  TMPSOURCEPATH=${TMPSOURCEPATH//\#/\:}
fi

# Get the last command-line argument as INFILE
#
for INFILE; do continue; done

# Launch
#
java -ea \
  -classpath "$TMPCLASSPATH" \
  streamit.frontend.ToStencilSK --output "$INFILE.tmp" \
  --sbitpath "$TMPSBITPATH" "$@"
