// $ANTLR : "StreamItParserFE.g" -> "StreamItParserFE.java"$

	package streamit.frontend;

	import streamit.frontend.nodes.*;

	import java.util.Collections;
	import java.io.DataInputStream;
	import java.util.List;

	import java.util.ArrayList;

import antlr.TokenBuffer;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.ANTLRException;
import antlr.LLkParser;
import antlr.Token;
import antlr.TokenStream;
import antlr.RecognitionException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.ParserSharedInputState;
import antlr.collections.impl.BitSet;

public class StreamItParserFE extends antlr.LLkParser       implements StreamItParserFETokenTypes
 {

	public static void main(String[] args)
	{
		try
		{
			DataInputStream dis = new DataInputStream(System.in);
			StreamItLex lexer = new StreamItLex(dis);
			StreamItParserFE parser = new StreamItParserFE(lexer);
			parser.program();
		}
		catch (Exception e)
		{
			e.printStackTrace(System.err);
		}
	}

	public FEContext getContext(Token t)
	{
		int line = t.getLine();
		if (line == 0) line = -1;
		int col = t.getColumn();
		if (col == 0) col = -1;
		return new FEContext(getFilename(), line, col);
	}

	private boolean hasError = false;

	public void reportError(RecognitionException ex)
	{
		hasError = true;
		super.reportError(ex);
	}

	public void  reportError(String s)
	{
		hasError = true;
		super.reportError(s);
	}

protected StreamItParserFE(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
}

public StreamItParserFE(TokenBuffer tokenBuf) {
  this(tokenBuf,1);
}

protected StreamItParserFE(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
}

public StreamItParserFE(TokenStream lexer) {
  this(lexer,1);
}

public StreamItParserFE(ParserSharedInputState state) {
  super(state,1);
  tokenNames = _tokenNames;
}

	public final Program  program() throws RecognitionException, TokenStreamException {
		Program p;
		
		p = null; List vars = new ArrayList();  List streams = new ArrayList();
			List funcs=new ArrayList(); Function f; FieldDecl fd;
		
		
		try {      // for error handling
			{
			_loop7090:
			do {
				if ((_tokenSet_0.member(LA(1)))) {
					f=function_decl();
					if ( inputState.guessing==0 ) {
						funcs.add(f);
					}
				}
				else if ((_tokenSet_0.member(LA(1)))) {
					fd=field_decl();
					if ( inputState.guessing==0 ) {
						vars.add(fd);
					}
				}
				else {
					break _loop7090;
				}
				
			} while (true);
			}
			match(Token.EOF_TYPE);
			if ( inputState.guessing==0 ) {
				
							 StreamSpec ss=new StreamSpec(null, StreamSpec.STREAM_FILTER,
								new StreamType(null, TypePrimitive.bittype, TypePrimitive.bittype), "MAIN", 
								Collections.EMPTY_LIST, vars, funcs);
								streams.add(ss);
								 if (!hasError) p = new Program(null, streams, Collections.EMPTY_LIST /*structs*/);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_1);
			} else {
			  throw ex;
			}
		}
		return p;
	}
	
	public final Function  function_decl() throws RecognitionException, TokenStreamException {
		Function f;
		
		Token  id = null;
		Token  impl = null;
		ReturnAssembly r; List l; StmtBlock s; f = null;
		
		
		try {      // for error handling
			r=return_assembly();
			id = LT(1);
			match(ID);
			l=param_decl_list();
			{
			switch ( LA(1)) {
			case TK_implements:
			{
				match(TK_implements);
				impl = LT(1);
				match(ID);
				break;
			}
			case LCURLY:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			s=function_block(r);
			if ( inputState.guessing==0 ) {
				for(int i=0;i<r.count();i++) l.add(new Parameter(r.getType(i),r.getName(i),true));
							f = Function.newHelper(getContext(id), id.getText(), TypePrimitive.voidtype, l, 
							impl==null?null:impl.getText(), s);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_2);
			} else {
			  throw ex;
			}
		}
		return f;
	}
	
	public final FieldDecl  field_decl() throws RecognitionException, TokenStreamException {
		FieldDecl f;
		
		Token  id = null;
		Token  id2 = null;
		f = null; Type t; Expression x = null;
			List ts = new ArrayList(); List ns = new ArrayList();
			List xs = new ArrayList(); FEContext ctx = null;
		
		try {      // for error handling
			t=data_type();
			id = LT(1);
			match(ID);
			{
			switch ( LA(1)) {
			case ASSIGN:
			{
				match(ASSIGN);
				x=var_initializer();
				break;
			}
			case EOF:
			case TK_portal:
			case TK_boolean:
			case TK_float:
			case TK_bit:
			case TK_int:
			case TK_void:
			case TK_double:
			case TK_complex:
			case SEMI:
			case COMMA:
			case ID:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				ctx = getContext(id); ts.add(t); ns.add(id.getText()); xs.add(x);
			}
			{
			_loop7104:
			do {
				if ((LA(1)==COMMA)) {
					if ( inputState.guessing==0 ) {
						x = null;
					}
					match(COMMA);
					id2 = LT(1);
					match(ID);
					{
					switch ( LA(1)) {
					case ASSIGN:
					{
						match(ASSIGN);
						x=var_initializer();
						break;
					}
					case EOF:
					case TK_portal:
					case TK_boolean:
					case TK_float:
					case TK_bit:
					case TK_int:
					case TK_void:
					case TK_double:
					case TK_complex:
					case SEMI:
					case COMMA:
					case ID:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					if ( inputState.guessing==0 ) {
						ts.add(t); ns.add(id2.getText()); xs.add(x);
					}
				}
				else {
					break _loop7104;
				}
				
			} while (true);
			}
			if ( inputState.guessing==0 ) {
				f = new FieldDecl(ctx, ts, ns, xs);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_3);
			} else {
			  throw ex;
			}
		}
		return f;
	}
	
	public final StreamSpec  stream_decl() throws RecognitionException, TokenStreamException {
		StreamSpec ss;
		
		ss = null; StreamType st;
		
		try {      // for error handling
			st=stream_type_decl();
			{
			switch ( LA(1)) {
			case TK_filter:
			{
				ss=filter_decl(st);
				break;
			}
			case TK_pipeline:
			case TK_splitjoin:
			case TK_sbox:
			case TK_feedbackloop:
			{
				ss=struct_stream_decl(st);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_1);
			} else {
			  throw ex;
			}
		}
		return ss;
	}
	
	public final StreamType  stream_type_decl() throws RecognitionException, TokenStreamException {
		StreamType st;
		
		Token  t = null;
		st = null; Type in, out;
		
		try {      // for error handling
			in=data_type();
			t = LT(1);
			match(ARROW);
			out=data_type();
			if ( inputState.guessing==0 ) {
				st = new StreamType(getContext(t), in, out);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_4);
			} else {
			  throw ex;
			}
		}
		return st;
	}
	
	public final StreamSpec  filter_decl(
		StreamType st
	) throws RecognitionException, TokenStreamException {
		StreamSpec ss;
		
		Token  tf = null;
		Token  id = null;
		ss = null; List params = Collections.EMPTY_LIST; FEContext context = null;
		
		try {      // for error handling
			tf = LT(1);
			match(TK_filter);
			if ( inputState.guessing==0 ) {
				if (st != null) context = st.getContext();
							else context = getContext(tf);
			}
			id = LT(1);
			match(ID);
			{
			switch ( LA(1)) {
			case LPAREN:
			{
				params=param_decl_list();
				break;
			}
			case LCURLY:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			ss=filter_body(context, st, id.getText(), params);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_1);
			} else {
			  throw ex;
			}
		}
		return ss;
	}
	
	public final StreamSpec  struct_stream_decl(
		StreamType st
	) throws RecognitionException, TokenStreamException {
		StreamSpec ss;
		
		Token  id = null;
		ss = null; int type = 0;
			List params = Collections.EMPTY_LIST; Statement body;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case TK_pipeline:
			{
				match(TK_pipeline);
				if ( inputState.guessing==0 ) {
					type = StreamSpec.STREAM_PIPELINE;
				}
				break;
			}
			case TK_splitjoin:
			{
				match(TK_splitjoin);
				if ( inputState.guessing==0 ) {
					type = StreamSpec.STREAM_SPLITJOIN;
				}
				break;
			}
			case TK_feedbackloop:
			{
				match(TK_feedbackloop);
				if ( inputState.guessing==0 ) {
					type = StreamSpec.STREAM_FEEDBACKLOOP;
				}
				break;
			}
			case TK_sbox:
			{
				match(TK_sbox);
				if ( inputState.guessing==0 ) {
					type = StreamSpec.STREAM_TABLE;
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			id = LT(1);
			match(ID);
			{
			switch ( LA(1)) {
			case LPAREN:
			{
				params=param_decl_list();
				break;
			}
			case LCURLY:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			body=block();
			if ( inputState.guessing==0 ) {
				ss = new StreamSpec(st.getContext(), type, st, id.getText(),
								params, body);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_1);
			} else {
			  throw ex;
			}
		}
		return ss;
	}
	
	public final List  param_decl_list() throws RecognitionException, TokenStreamException {
		List l;
		
		l = new ArrayList(); Parameter p;
		
		try {      // for error handling
			match(LPAREN);
			{
			switch ( LA(1)) {
			case TK_portal:
			case TK_boolean:
			case TK_float:
			case TK_bit:
			case TK_int:
			case TK_void:
			case TK_double:
			case TK_complex:
			case ID:
			{
				p=param_decl();
				if ( inputState.guessing==0 ) {
					l.add(p);
				}
				{
				_loop7175:
				do {
					if ((LA(1)==COMMA)) {
						match(COMMA);
						p=param_decl();
						if ( inputState.guessing==0 ) {
							l.add(p);
						}
					}
					else {
						break _loop7175;
					}
					
				} while (true);
				}
				break;
			}
			case RPAREN:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(RPAREN);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_5);
			} else {
			  throw ex;
			}
		}
		return l;
	}
	
	public final StreamSpec  filter_body(
		FEContext context, StreamType st, String name, List params
	) throws RecognitionException, TokenStreamException {
		StreamSpec ss;
		
		ss = null; List vars = new ArrayList(); List funcs = new ArrayList();
			Function fn; FieldDecl decl;
		
		try {      // for error handling
			match(LCURLY);
			{
			_loop7099:
			do {
				switch ( LA(1)) {
				case TK_init:
				{
					fn=init_decl();
					if ( inputState.guessing==0 ) {
						funcs.add(fn);
					}
					break;
				}
				case TK_prework:
				case TK_work:
				case TK_phase:
				{
					fn=work_decl();
					if ( inputState.guessing==0 ) {
						funcs.add(fn);
					}
					break;
				}
				case TK_handler:
				{
					fn=handler_decl();
					if ( inputState.guessing==0 ) {
						funcs.add(fn);
					}
					break;
				}
				default:
					boolean synPredMatched7098 = false;
					if (((_tokenSet_0.member(LA(1))))) {
						int _m7098 = mark();
						synPredMatched7098 = true;
						inputState.guessing++;
						try {
							{
							data_type();
							match(ID);
							match(LPAREN);
							}
						}
						catch (RecognitionException pe) {
							synPredMatched7098 = false;
						}
						rewind(_m7098);
						inputState.guessing--;
					}
					if ( synPredMatched7098 ) {
						fn=function_decl();
						if ( inputState.guessing==0 ) {
							funcs.add(fn);
						}
					}
					else if ((_tokenSet_0.member(LA(1)))) {
						decl=field_decl();
						match(SEMI);
						if ( inputState.guessing==0 ) {
							vars.add(decl);
						}
					}
				else {
					break _loop7099;
				}
				}
			} while (true);
			}
			match(RCURLY);
			if ( inputState.guessing==0 ) {
				ss = new StreamSpec(context, StreamSpec.STREAM_FILTER,
								st, name, params, vars, funcs);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_6);
			} else {
			  throw ex;
			}
		}
		return ss;
	}
	
	public final Function  init_decl() throws RecognitionException, TokenStreamException {
		Function f;
		
		Token  t = null;
		Statement s; f = null;
		
		try {      // for error handling
			t = LT(1);
			match(TK_init);
			s=block();
			if ( inputState.guessing==0 ) {
				f = Function.newInit(getContext(t), s);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_7);
			} else {
			  throw ex;
			}
		}
		return f;
	}
	
	public final FuncWork  work_decl() throws RecognitionException, TokenStreamException {
		FuncWork f;
		
		Token  tw = null;
		Token  tpw = null;
		Token  tp = null;
		Token  id = null;
			f = null;
			Expression pop = null, peek = null, push = null;
			Statement s; FEContext c = null; String name = null;
			int type = 0;
		
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case TK_work:
			{
				tw = LT(1);
				match(TK_work);
				if ( inputState.guessing==0 ) {
					c = getContext(tw); type = Function.FUNC_WORK;
				}
				break;
			}
			case TK_prework:
			{
				tpw = LT(1);
				match(TK_prework);
				if ( inputState.guessing==0 ) {
					c = getContext(tpw);
												 type = Function.FUNC_PREWORK;
				}
				break;
			}
			case TK_phase:
			{
				tp = LT(1);
				match(TK_phase);
				id = LT(1);
				match(ID);
				if ( inputState.guessing==0 ) {
					c = getContext(tp); name = id.getText();
								                    type = Function.FUNC_PHASE;
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			_loop7112:
			do {
				switch ( LA(1)) {
				case TK_push:
				{
					match(TK_push);
					push=right_expr();
					break;
				}
				case TK_pop:
				{
					match(TK_pop);
					pop=right_expr();
					break;
				}
				case TK_peek:
				{
					match(TK_peek);
					peek=right_expr();
					break;
				}
				default:
				{
					break _loop7112;
				}
				}
			} while (true);
			}
			s=block();
			if ( inputState.guessing==0 ) {
				f = new FuncWork(c, type, name, s, peek, pop, push);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_7);
			} else {
			  throw ex;
			}
		}
		return f;
	}
	
	public final Type  data_type() throws RecognitionException, TokenStreamException {
		Type t;
		
		Token  id = null;
		Token  l = null;
		Token  pn = null;
		t = null; Expression x;
		
		try {      // for error handling
			switch ( LA(1)) {
			case TK_boolean:
			case TK_float:
			case TK_bit:
			case TK_int:
			case TK_double:
			case TK_complex:
			case ID:
			{
				{
				switch ( LA(1)) {
				case TK_boolean:
				case TK_float:
				case TK_bit:
				case TK_int:
				case TK_double:
				case TK_complex:
				{
					t=primitive_type();
					break;
				}
				case ID:
				{
					id = LT(1);
					match(ID);
					if ( inputState.guessing==0 ) {
						t = new TypeStructRef(id.getText());
					}
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				{
				_loop7158:
				do {
					if ((LA(1)==LSQUARE)) {
						l = LT(1);
						match(LSQUARE);
						{
						switch ( LA(1)) {
						case TK_peek:
						case TK_pop:
						case TK_pi:
						case TK_true:
						case TK_false:
						case LPAREN:
						case INCREMENT:
						case MINUS:
						case DECREMENT:
						case BANG:
						case NDVAL:
						case CHAR_LITERAL:
						case STRING_LITERAL:
						case HQUAN:
						case NUMBER:
						case ID:
						{
							x=right_expr();
							if ( inputState.guessing==0 ) {
								t = new TypeArray(t, x);
							}
							break;
						}
						case RSQUARE:
						{
							if ( inputState.guessing==0 ) {
								throw new SemanticException("missing array bounds in type declaration", getFilename(), l.getLine());
							}
							break;
						}
						default:
						{
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
						}
						match(RSQUARE);
					}
					else {
						break _loop7158;
					}
					
				} while (true);
				}
				break;
			}
			case TK_void:
			{
				match(TK_void);
				if ( inputState.guessing==0 ) {
					t = new TypePrimitive(TypePrimitive.TYPE_VOID);
				}
				break;
			}
			case TK_portal:
			{
				match(TK_portal);
				match(LESS_THAN);
				pn = LT(1);
				match(ID);
				match(MORE_THAN);
				if ( inputState.guessing==0 ) {
					t = new TypePortal(pn.getText());
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_8);
			} else {
			  throw ex;
			}
		}
		return t;
	}
	
	public final Function  handler_decl() throws RecognitionException, TokenStreamException {
		Function f;
		
		Token  id = null;
		List l; Statement s; f = null;
		Type t = new TypePrimitive(TypePrimitive.TYPE_VOID);
		int cls = Function.FUNC_HANDLER;
		
		try {      // for error handling
			match(TK_handler);
			id = LT(1);
			match(ID);
			l=param_decl_list();
			s=block();
			if ( inputState.guessing==0 ) {
				f = new Function(getContext(id), cls, id.getText(), t, l, s);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_7);
			} else {
			  throw ex;
			}
		}
		return f;
	}
	
	public final Expression  var_initializer() throws RecognitionException, TokenStreamException {
		Expression x;
		
		x = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case TK_peek:
			case TK_pop:
			case TK_pi:
			case TK_true:
			case TK_false:
			case LPAREN:
			case INCREMENT:
			case MINUS:
			case DECREMENT:
			case BANG:
			case NDVAL:
			case CHAR_LITERAL:
			case STRING_LITERAL:
			case HQUAN:
			case NUMBER:
			case ID:
			{
				x=right_expr();
				break;
			}
			case LCURLY:
			{
				x=arr_initializer();
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_9);
			} else {
			  throw ex;
			}
		}
		return x;
	}
	
	public final StmtBlock  block() throws RecognitionException, TokenStreamException {
		StmtBlock sb;
		
		Token  t = null;
		sb=null; Statement s; List l = new ArrayList();
		
		try {      // for error handling
			t = LT(1);
			match(LCURLY);
			{
			_loop7179:
			do {
				if ((_tokenSet_10.member(LA(1)))) {
					s=statement();
					if ( inputState.guessing==0 ) {
						if (s != null) l.add(s);
					}
				}
				else {
					break _loop7179;
				}
				
			} while (true);
			}
			match(RCURLY);
			if ( inputState.guessing==0 ) {
				sb = new StmtBlock(getContext(t), l);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_11);
			} else {
			  throw ex;
			}
		}
		return sb;
	}
	
	public final Expression  right_expr() throws RecognitionException, TokenStreamException {
		Expression x;
		
		x = null;
		
		try {      // for error handling
			x=ternaryExpr();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_12);
			} else {
			  throw ex;
			}
		}
		return x;
	}
	
	public final Statement  push_statement() throws RecognitionException, TokenStreamException {
		Statement s;
		
		Token  t = null;
		s = null; Expression x;
		
		try {      // for error handling
			t = LT(1);
			match(TK_push);
			match(LPAREN);
			x=right_expr();
			match(RPAREN);
			if ( inputState.guessing==0 ) {
				s = new StmtPush(getContext(t), x);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_13);
			} else {
			  throw ex;
			}
		}
		return s;
	}
	
	public final Statement  msg_statement() throws RecognitionException, TokenStreamException {
		Statement s;
		
		Token  p = null;
		Token  m = null;
		s = null; List l;
		Expression minl = null, maxl = null;
		
		try {      // for error handling
			p = LT(1);
			match(ID);
			match(DOT);
			m = LT(1);
			match(ID);
			l=func_call_params();
			{
			switch ( LA(1)) {
			case LSQUARE:
			{
				match(LSQUARE);
				{
				switch ( LA(1)) {
				case TK_peek:
				case TK_pop:
				case TK_pi:
				case TK_true:
				case TK_false:
				case LPAREN:
				case INCREMENT:
				case MINUS:
				case DECREMENT:
				case BANG:
				case NDVAL:
				case CHAR_LITERAL:
				case STRING_LITERAL:
				case HQUAN:
				case NUMBER:
				case ID:
				{
					minl=right_expr();
					break;
				}
				case COLON:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				match(COLON);
				{
				switch ( LA(1)) {
				case TK_peek:
				case TK_pop:
				case TK_pi:
				case TK_true:
				case TK_false:
				case LPAREN:
				case INCREMENT:
				case MINUS:
				case DECREMENT:
				case BANG:
				case NDVAL:
				case CHAR_LITERAL:
				case STRING_LITERAL:
				case HQUAN:
				case NUMBER:
				case ID:
				{
					maxl=right_expr();
					break;
				}
				case RSQUARE:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				match(RSQUARE);
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				s = new StmtSendMessage(getContext(p),
								new ExprVar(getContext(p), p.getText()),
								m.getText(), l, minl, maxl);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_13);
			} else {
			  throw ex;
			}
		}
		return s;
	}
	
	public final List  func_call_params() throws RecognitionException, TokenStreamException {
		List l;
		
		l = new ArrayList(); Expression x;
		
		try {      // for error handling
			match(LPAREN);
			{
			switch ( LA(1)) {
			case TK_peek:
			case TK_pop:
			case TK_pi:
			case TK_true:
			case TK_false:
			case LPAREN:
			case INCREMENT:
			case MINUS:
			case DECREMENT:
			case BANG:
			case NDVAL:
			case CHAR_LITERAL:
			case STRING_LITERAL:
			case HQUAN:
			case NUMBER:
			case ID:
			{
				x=right_expr();
				if ( inputState.guessing==0 ) {
					l.add(x);
				}
				{
				_loop7213:
				do {
					if ((LA(1)==COMMA)) {
						match(COMMA);
						x=right_expr();
						if ( inputState.guessing==0 ) {
							l.add(x);
						}
					}
					else {
						break _loop7213;
					}
					
				} while (true);
				}
				break;
			}
			case RPAREN:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(RPAREN);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_14);
			} else {
			  throw ex;
			}
		}
		return l;
	}
	
	public final Statement  statement() throws RecognitionException, TokenStreamException {
		Statement s;
		
		Token  tb = null;
		Token  tc = null;
		s = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case TK_add:
			{
				s=add_statement();
				break;
			}
			case TK_body:
			{
				s=body_statement();
				break;
			}
			case TK_loop:
			{
				s=loop_statement();
				break;
			}
			case TK_split:
			{
				s=split_statement();
				match(SEMI);
				break;
			}
			case TK_join:
			{
				s=join_statement();
				match(SEMI);
				break;
			}
			case TK_enqueue:
			{
				s=enqueue_statement();
				match(SEMI);
				break;
			}
			case TK_push:
			{
				s=push_statement();
				match(SEMI);
				break;
			}
			case LCURLY:
			{
				s=block();
				break;
			}
			case TK_break:
			{
				tb = LT(1);
				match(TK_break);
				match(SEMI);
				if ( inputState.guessing==0 ) {
					s = new StmtBreak(getContext(tb));
				}
				break;
			}
			case TK_continue:
			{
				tc = LT(1);
				match(TK_continue);
				match(SEMI);
				if ( inputState.guessing==0 ) {
					s = new StmtContinue(getContext(tc));
				}
				break;
			}
			case TK_if:
			{
				s=if_else_statement();
				break;
			}
			case TK_while:
			{
				s=while_statement();
				break;
			}
			case TK_do:
			{
				s=do_while_statement();
				match(SEMI);
				break;
			}
			case TK_for:
			{
				s=for_statement();
				break;
			}
			case SEMI:
			{
				match(SEMI);
				break;
			}
			default:
				boolean synPredMatched7121 = false;
				if (((_tokenSet_0.member(LA(1))))) {
					int _m7121 = mark();
					synPredMatched7121 = true;
					inputState.guessing++;
					try {
						{
						data_type();
						match(ID);
						}
					}
					catch (RecognitionException pe) {
						synPredMatched7121 = false;
					}
					rewind(_m7121);
					inputState.guessing--;
				}
				if ( synPredMatched7121 ) {
					s=variable_decl();
					match(SEMI);
				}
				else {
					boolean synPredMatched7123 = false;
					if (((_tokenSet_15.member(LA(1))))) {
						int _m7123 = mark();
						synPredMatched7123 = true;
						inputState.guessing++;
						try {
							{
							expr_statement();
							}
						}
						catch (RecognitionException pe) {
							synPredMatched7123 = false;
						}
						rewind(_m7123);
						inputState.guessing--;
					}
					if ( synPredMatched7123 ) {
						s=expr_statement();
						match(SEMI);
					}
					else if ((LA(1)==ID)) {
						s=msg_statement();
						match(SEMI);
					}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					consume();
					consumeUntil(_tokenSet_16);
				} else {
				  throw ex;
				}
			}
			return s;
		}
		
	public final Statement  add_statement() throws RecognitionException, TokenStreamException {
		Statement s;
		
		Token  t = null;
		s = null; StreamCreator sc;
		
		try {      // for error handling
			t = LT(1);
			match(TK_add);
			sc=stream_creator();
			if ( inputState.guessing==0 ) {
				s = new StmtAdd(getContext(t), sc);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_16);
			} else {
			  throw ex;
			}
		}
		return s;
	}
	
	public final Statement  body_statement() throws RecognitionException, TokenStreamException {
		Statement s;
		
		Token  t = null;
		s = null; StreamCreator sc;
		
		try {      // for error handling
			t = LT(1);
			match(TK_body);
			sc=stream_creator();
			if ( inputState.guessing==0 ) {
				s = new StmtBody(getContext(t), sc);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_16);
			} else {
			  throw ex;
			}
		}
		return s;
	}
	
	public final Statement  loop_statement() throws RecognitionException, TokenStreamException {
		Statement s;
		
		Token  t = null;
		s = null; StreamCreator sc;
		
		try {      // for error handling
			t = LT(1);
			match(TK_loop);
			sc=stream_creator();
			if ( inputState.guessing==0 ) {
				s = new StmtLoop(getContext(t), sc);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_16);
			} else {
			  throw ex;
			}
		}
		return s;
	}
	
	public final Statement  split_statement() throws RecognitionException, TokenStreamException {
		Statement s;
		
		Token  t = null;
		s = null; SplitterJoiner sj;
		
		try {      // for error handling
			t = LT(1);
			match(TK_split);
			sj=splitter_or_joiner();
			if ( inputState.guessing==0 ) {
				s = new StmtSplit(getContext(t), sj);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_13);
			} else {
			  throw ex;
			}
		}
		return s;
	}
	
	public final Statement  join_statement() throws RecognitionException, TokenStreamException {
		Statement s;
		
		Token  t = null;
		s = null; SplitterJoiner sj;
		
		try {      // for error handling
			t = LT(1);
			match(TK_join);
			sj=splitter_or_joiner();
			if ( inputState.guessing==0 ) {
				s = new StmtJoin(getContext(t), sj);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_13);
			} else {
			  throw ex;
			}
		}
		return s;
	}
	
	public final Statement  enqueue_statement() throws RecognitionException, TokenStreamException {
		Statement s;
		
		Token  t = null;
		s = null; Expression x;
		
		try {      // for error handling
			t = LT(1);
			match(TK_enqueue);
			x=right_expr();
			if ( inputState.guessing==0 ) {
				s = new StmtEnqueue(getContext(t), x);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_13);
			} else {
			  throw ex;
			}
		}
		return s;
	}
	
	public final Statement  variable_decl() throws RecognitionException, TokenStreamException {
		Statement s;
		
		Token  id = null;
		Token  id2 = null;
		s = null; Type t; Expression x = null; 
			List ts = new ArrayList(); List ns = new ArrayList();
			List xs = new ArrayList(); FEContext ctx = null;
		
		try {      // for error handling
			t=data_type();
			id = LT(1);
			match(ID);
			if ( inputState.guessing==0 ) {
				ctx = getContext(id);
			}
			{
			switch ( LA(1)) {
			case ASSIGN:
			{
				match(ASSIGN);
				x=var_initializer();
				break;
			}
			case SEMI:
			case COMMA:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				ts.add(t); ns.add(id.getText()); xs.add(x);
			}
			{
			_loop7164:
			do {
				if ((LA(1)==COMMA)) {
					if ( inputState.guessing==0 ) {
						x = null;
					}
					match(COMMA);
					id2 = LT(1);
					match(ID);
					{
					switch ( LA(1)) {
					case ASSIGN:
					{
						match(ASSIGN);
						x=var_initializer();
						break;
					}
					case SEMI:
					case COMMA:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					if ( inputState.guessing==0 ) {
						ts.add(t); ns.add(id2.getText()); xs.add(x);
					}
				}
				else {
					break _loop7164;
				}
				
			} while (true);
			}
			if ( inputState.guessing==0 ) {
				s = new StmtVarDecl(ctx, ts, ns, xs);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_13);
			} else {
			  throw ex;
			}
		}
		return s;
	}
	
	public final Statement  expr_statement() throws RecognitionException, TokenStreamException {
		Statement s;
		
		s = null; Expression x;
		
		try {      // for error handling
			boolean synPredMatched7201 = false;
			if (((LA(1)==INCREMENT||LA(1)==DECREMENT||LA(1)==ID))) {
				int _m7201 = mark();
				synPredMatched7201 = true;
				inputState.guessing++;
				try {
					{
					incOrDec();
					}
				}
				catch (RecognitionException pe) {
					synPredMatched7201 = false;
				}
				rewind(_m7201);
				inputState.guessing--;
			}
			if ( synPredMatched7201 ) {
				x=incOrDec();
				if ( inputState.guessing==0 ) {
					s = new StmtExpr(x);
				}
			}
			else {
				boolean synPredMatched7204 = false;
				if (((LA(1)==ID))) {
					int _m7204 = mark();
					synPredMatched7204 = true;
					inputState.guessing++;
					try {
						{
						left_expr();
						{
						switch ( LA(1)) {
						case ASSIGN:
						{
							match(ASSIGN);
							break;
						}
						case PLUS_EQUALS:
						{
							match(PLUS_EQUALS);
							break;
						}
						case MINUS_EQUALS:
						{
							match(MINUS_EQUALS);
							break;
						}
						case STAR_EQUALS:
						{
							match(STAR_EQUALS);
							break;
						}
						case DIV_EQUALS:
						{
							match(DIV_EQUALS);
							break;
						}
						default:
						{
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
						}
						}
					}
					catch (RecognitionException pe) {
						synPredMatched7204 = false;
					}
					rewind(_m7204);
					inputState.guessing--;
				}
				if ( synPredMatched7204 ) {
					s=assign_expr();
				}
				else {
					boolean synPredMatched7206 = false;
					if (((LA(1)==ID))) {
						int _m7206 = mark();
						synPredMatched7206 = true;
						inputState.guessing++;
						try {
							{
							match(ID);
							match(LPAREN);
							}
						}
						catch (RecognitionException pe) {
							synPredMatched7206 = false;
						}
						rewind(_m7206);
						inputState.guessing--;
					}
					if ( synPredMatched7206 ) {
						x=func_call();
						if ( inputState.guessing==0 ) {
							s = new StmtExpr(x);
						}
					}
					else if ((LA(1)==TK_peek||LA(1)==TK_pop)) {
						x=streamit_value_expr();
						if ( inputState.guessing==0 ) {
							s = new StmtExpr(x);
						}
					}
					else {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}}
				}
				catch (RecognitionException ex) {
					if (inputState.guessing==0) {
						reportError(ex);
						consume();
						consumeUntil(_tokenSet_17);
					} else {
					  throw ex;
					}
				}
				return s;
			}
			
	public final Statement  if_else_statement() throws RecognitionException, TokenStreamException {
		Statement s;
		
		Token  u = null;
		s = null; Expression x; Statement t, f = null;
		
		try {      // for error handling
			u = LT(1);
			match(TK_if);
			match(LPAREN);
			x=right_expr();
			match(RPAREN);
			t=statement();
			{
			boolean synPredMatched7185 = false;
			if (((LA(1)==TK_else))) {
				int _m7185 = mark();
				synPredMatched7185 = true;
				inputState.guessing++;
				try {
					{
					match(TK_else);
					}
				}
				catch (RecognitionException pe) {
					synPredMatched7185 = false;
				}
				rewind(_m7185);
				inputState.guessing--;
			}
			if ( synPredMatched7185 ) {
				{
				match(TK_else);
				f=statement();
				}
			}
			else if ((_tokenSet_16.member(LA(1)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			if ( inputState.guessing==0 ) {
				s = new StmtIfThen(getContext(u), x, t, f);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_16);
			} else {
			  throw ex;
			}
		}
		return s;
	}
	
	public final Statement  while_statement() throws RecognitionException, TokenStreamException {
		Statement s;
		
		Token  t = null;
		s = null; Expression x; Statement b;
		
		try {      // for error handling
			t = LT(1);
			match(TK_while);
			match(LPAREN);
			x=right_expr();
			match(RPAREN);
			b=statement();
			if ( inputState.guessing==0 ) {
				s = new StmtWhile(getContext(t), x, b);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_16);
			} else {
			  throw ex;
			}
		}
		return s;
	}
	
	public final Statement  do_while_statement() throws RecognitionException, TokenStreamException {
		Statement s;
		
		Token  t = null;
		s = null; Expression x; Statement b;
		
		try {      // for error handling
			t = LT(1);
			match(TK_do);
			b=statement();
			match(TK_while);
			match(LPAREN);
			x=right_expr();
			match(RPAREN);
			if ( inputState.guessing==0 ) {
				s = new StmtDoWhile(getContext(t), b, x);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_13);
			} else {
			  throw ex;
			}
		}
		return s;
	}
	
	public final Statement  for_statement() throws RecognitionException, TokenStreamException {
		Statement s;
		
		Token  t = null;
		s = null; Expression x=null; Statement a, b, c;
		
		try {      // for error handling
			t = LT(1);
			match(TK_for);
			match(LPAREN);
			a=for_init_statement();
			match(SEMI);
			{
			switch ( LA(1)) {
			case TK_peek:
			case TK_pop:
			case TK_pi:
			case TK_true:
			case TK_false:
			case LPAREN:
			case INCREMENT:
			case MINUS:
			case DECREMENT:
			case BANG:
			case NDVAL:
			case CHAR_LITERAL:
			case STRING_LITERAL:
			case HQUAN:
			case NUMBER:
			case ID:
			{
				x=right_expr();
				break;
			}
			case SEMI:
			{
				if ( inputState.guessing==0 ) {
					x = new ExprConstBoolean(getContext(t), true);
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(SEMI);
			b=for_incr_statement();
			match(RPAREN);
			c=statement();
			if ( inputState.guessing==0 ) {
				s = new StmtFor(getContext(t), a, x, b, c);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_16);
			} else {
			  throw ex;
			}
		}
		return s;
	}
	
	public final StreamCreator  stream_creator() throws RecognitionException, TokenStreamException {
		StreamCreator sc;
		
		sc = null;
		
		try {      // for error handling
			boolean synPredMatched7129 = false;
			if (((_tokenSet_18.member(LA(1))))) {
				int _m7129 = mark();
				synPredMatched7129 = true;
				inputState.guessing++;
				try {
					{
					switch ( LA(1)) {
					case ID:
					{
						match(ID);
						match(ARROW);
						break;
					}
					case TK_filter:
					case TK_pipeline:
					case TK_splitjoin:
					case TK_sbox:
					case TK_feedbackloop:
					case TK_portal:
					case TK_to:
					case TK_handler:
					case TK_add:
					case TK_split:
					case TK_join:
					case TK_duplicate:
					case TK_roundrobin:
					case TK_body:
					case TK_loop:
					case TK_enqueue:
					case TK_init:
					case TK_prework:
					case TK_work:
					case TK_phase:
					case TK_peek:
					case TK_pop:
					case TK_push:
					case TK_boolean:
					case TK_float:
					case TK_bit:
					case TK_int:
					case TK_void:
					case TK_double:
					case TK_complex:
					case TK_struct:
					case TK_template:
					case TK_if:
					case TK_else:
					case TK_while:
					case TK_for:
					case TK_switch:
					case TK_case:
					case TK_default:
					case TK_break:
					case TK_continue:
					case TK_return:
					case TK_pi:
					case TK_true:
					case TK_false:
					case TK_implements:
					case TK_overrides:
					case ARROW:
					case WS:
					case SL_COMMENT:
					case ML_COMMENT:
					case LPAREN:
					case RPAREN:
					case LCURLY:
					case RCURLY:
					case LSQUARE:
					case RSQUARE:
					case PLUS:
					case PLUS_EQUALS:
					case INCREMENT:
					case MINUS:
					case MINUS_EQUALS:
					case DECREMENT:
					case STAR:
					case STAR_EQUALS:
					case DIV:
					case DIV_EQUALS:
					case MOD:
					case LOGIC_AND:
					case LOGIC_OR:
					case BITWISE_AND:
					case BITWISE_OR:
					case BITWISE_XOR:
					case ASSIGN:
					case EQUAL:
					case NOT_EQUAL:
					case LESS_THAN:
					case LESS_EQUAL:
					case MORE_THAN:
					case MORE_EQUAL:
					case QUESTION:
					case COLON:
					case SEMI:
					case COMMA:
					case DOT:
					case BANG:
					case LSHIFT:
					case RSHIFT:
					case NDVAL:
					case SELECT:
					case CHAR_LITERAL:
					case STRING_LITERAL:
					case ESC:
					case DIGIT:
					case HQUAN:
					case NUMBER:
					case TK_do:
					{
						matchNot(ID);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
				}
				catch (RecognitionException pe) {
					synPredMatched7129 = false;
				}
				rewind(_m7129);
				inputState.guessing--;
			}
			if ( synPredMatched7129 ) {
				sc=anonymous_stream();
			}
			else if ((LA(1)==ID)) {
				sc=named_stream();
				match(SEMI);
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_16);
			} else {
			  throw ex;
			}
		}
		return sc;
	}
	
	public final StreamCreator  anonymous_stream() throws RecognitionException, TokenStreamException {
		StreamCreator sc;
		
		Token  tf = null;
		Token  tp = null;
		Token  ts = null;
		Token  tl = null;
		Token  tt = null;
			sc = null; 
			StreamType st = null; 
			List params = new ArrayList();
			Statement body; List types = new ArrayList(); 
			Type t; StreamSpec ss = null;
			List p = null; int sst = 0; FEContext ctx = null; 
		
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case TK_portal:
			case TK_boolean:
			case TK_float:
			case TK_bit:
			case TK_int:
			case TK_void:
			case TK_double:
			case TK_complex:
			case ID:
			{
				st=stream_type_decl();
				break;
			}
			case TK_filter:
			case TK_pipeline:
			case TK_splitjoin:
			case TK_sbox:
			case TK_feedbackloop:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case TK_filter:
			{
				tf = LT(1);
				match(TK_filter);
				ss=filter_body(getContext(tf), st, null, Collections.EMPTY_LIST);
				{
				if ((LA(1)==TK_to||LA(1)==SEMI)) {
					{
					switch ( LA(1)) {
					case TK_to:
					{
						p=portal_spec();
						break;
					}
					case SEMI:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					match(SEMI);
				}
				else if ((_tokenSet_16.member(LA(1)))) {
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				
				}
				if ( inputState.guessing==0 ) {
					sc = new SCAnon(getContext(tf), ss, p);
				}
				break;
			}
			case TK_pipeline:
			case TK_splitjoin:
			case TK_sbox:
			case TK_feedbackloop:
			{
				{
				switch ( LA(1)) {
				case TK_pipeline:
				{
					tp = LT(1);
					match(TK_pipeline);
					if ( inputState.guessing==0 ) {
						ctx = getContext(tp); sst = StreamSpec.STREAM_PIPELINE;
					}
					break;
				}
				case TK_splitjoin:
				{
					ts = LT(1);
					match(TK_splitjoin);
					if ( inputState.guessing==0 ) {
						ctx = getContext(ts); sst = StreamSpec.STREAM_SPLITJOIN;
					}
					break;
				}
				case TK_feedbackloop:
				{
					tl = LT(1);
					match(TK_feedbackloop);
					if ( inputState.guessing==0 ) {
						ctx = getContext(tl); sst = StreamSpec.STREAM_FEEDBACKLOOP;
					}
					break;
				}
				case TK_sbox:
				{
					tt = LT(1);
					match(TK_sbox);
					if ( inputState.guessing==0 ) {
						ctx = getContext(tt); sst = StreamSpec.STREAM_TABLE;
					}
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				body=block();
				{
				if ((LA(1)==TK_to||LA(1)==SEMI)) {
					{
					switch ( LA(1)) {
					case TK_to:
					{
						p=portal_spec();
						break;
					}
					case SEMI:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					match(SEMI);
				}
				else if ((_tokenSet_16.member(LA(1)))) {
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				
				}
				if ( inputState.guessing==0 ) {
					sc = new SCAnon(ctx, sst, body, p);
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_16);
			} else {
			  throw ex;
			}
		}
		return sc;
	}
	
	public final StreamCreator  named_stream() throws RecognitionException, TokenStreamException {
		StreamCreator sc;
		
		Token  id = null;
		sc = null; List params = new ArrayList(); List types = new ArrayList();
		Type t; List p = null;
		
		try {      // for error handling
			id = LT(1);
			match(ID);
			{
			switch ( LA(1)) {
			case LESS_THAN:
			{
				match(LESS_THAN);
				t=data_type();
				match(MORE_THAN);
				if ( inputState.guessing==0 ) {
					types.add(t);
				}
				break;
			}
			case TK_to:
			case LPAREN:
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LPAREN:
			{
				params=func_call_params();
				break;
			}
			case TK_to:
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case TK_to:
			{
				p=portal_spec();
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				sc = new SCSimple(getContext(id), id.getText(), types, params, p);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_13);
			} else {
			  throw ex;
			}
		}
		return sc;
	}
	
	public final List  portal_spec() throws RecognitionException, TokenStreamException {
		List p;
		
		Token  id = null;
		p = null; Expression pn;
		
		try {      // for error handling
			match(TK_to);
			id = LT(1);
			match(ID);
			if ( inputState.guessing==0 ) {
				pn = new ExprVar(getContext(id), id.getText());
							  p = Collections.singletonList(pn);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_13);
			} else {
			  throw ex;
			}
		}
		return p;
	}
	
	public final SplitterJoiner  splitter_or_joiner() throws RecognitionException, TokenStreamException {
		SplitterJoiner sj;
		
		Token  tr = null;
		Token  td = null;
		Token  tag = null;
		sj = null; Expression x; List l;
		
		try {      // for error handling
			switch ( LA(1)) {
			case TK_roundrobin:
			{
				tr = LT(1);
				match(TK_roundrobin);
				{
				boolean synPredMatched7148 = false;
				if (((LA(1)==LPAREN))) {
					int _m7148 = mark();
					synPredMatched7148 = true;
					inputState.guessing++;
					try {
						{
						match(LPAREN);
						match(RPAREN);
						}
					}
					catch (RecognitionException pe) {
						synPredMatched7148 = false;
					}
					rewind(_m7148);
					inputState.guessing--;
				}
				if ( synPredMatched7148 ) {
					match(LPAREN);
					match(RPAREN);
					if ( inputState.guessing==0 ) {
						sj = new SJRoundRobin(getContext(tr));
					}
				}
				else {
					boolean synPredMatched7150 = false;
					if (((LA(1)==LPAREN))) {
						int _m7150 = mark();
						synPredMatched7150 = true;
						inputState.guessing++;
						try {
							{
							match(LPAREN);
							right_expr();
							match(RPAREN);
							}
						}
						catch (RecognitionException pe) {
							synPredMatched7150 = false;
						}
						rewind(_m7150);
						inputState.guessing--;
					}
					if ( synPredMatched7150 ) {
						match(LPAREN);
						x=right_expr();
						match(RPAREN);
						if ( inputState.guessing==0 ) {
							sj = new SJRoundRobin(getContext(tr), x);
						}
					}
					else if ((LA(1)==LPAREN)) {
						l=func_call_params();
						if ( inputState.guessing==0 ) {
							sj = new SJWeightedRR(getContext(tr), l);
						}
					}
					else if ((LA(1)==SEMI)) {
						if ( inputState.guessing==0 ) {
							sj = new SJRoundRobin(getContext(tr));
						}
					}
					else {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					break;
				}
				case TK_duplicate:
				{
					td = LT(1);
					match(TK_duplicate);
					{
					switch ( LA(1)) {
					case LPAREN:
					{
						match(LPAREN);
						match(RPAREN);
						break;
					}
					case SEMI:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					if ( inputState.guessing==0 ) {
						sj = new SJDuplicate(getContext(td));
					}
					break;
				}
				case ID:
				{
					tag = LT(1);
					match(ID);
					{
					switch ( LA(1)) {
					case LPAREN:
					{
						match(LPAREN);
						match(RPAREN);
						break;
					}
					case SEMI:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					if ( inputState.guessing==0 ) {
							
									if( tag.getText().equals("xor") ){
										sj = new SJDuplicate(getContext(tag), SJDuplicate.XOR ); 
									}else if( tag.getText().equals("or") ){
										sj = new SJDuplicate(getContext(tag), SJDuplicate.OR ); 
									}else if( tag.getText().equals("and") ){
										sj = new SJDuplicate(getContext(tag), SJDuplicate.AND ); 
									}else{
										assert false: tag.getText()+ " is not a valid splitter";
									}
								
					}
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					consume();
					consumeUntil(_tokenSet_13);
				} else {
				  throw ex;
				}
			}
			return sj;
		}
		
	public final Type  primitive_type() throws RecognitionException, TokenStreamException {
		Type t;
		
		t = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case TK_boolean:
			{
				match(TK_boolean);
				if ( inputState.guessing==0 ) {
					t = new TypePrimitive(TypePrimitive.TYPE_BOOLEAN);
				}
				break;
			}
			case TK_bit:
			{
				match(TK_bit);
				if ( inputState.guessing==0 ) {
					t = new TypePrimitive(TypePrimitive.TYPE_BIT);
				}
				break;
			}
			case TK_int:
			{
				match(TK_int);
				if ( inputState.guessing==0 ) {
					t = new TypePrimitive(TypePrimitive.TYPE_INT);
				}
				break;
			}
			case TK_float:
			{
				match(TK_float);
				if ( inputState.guessing==0 ) {
					t = new TypePrimitive(TypePrimitive.TYPE_FLOAT);
				}
				break;
			}
			case TK_double:
			{
				match(TK_double);
				if ( inputState.guessing==0 ) {
					t =  new TypePrimitive(TypePrimitive.TYPE_DOUBLE);
				}
				break;
			}
			case TK_complex:
			{
				match(TK_complex);
				if ( inputState.guessing==0 ) {
					t = new TypePrimitive(TypePrimitive.TYPE_COMPLEX);
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_19);
			} else {
			  throw ex;
			}
		}
		return t;
	}
	
	public final ReturnAssembly  return_assembly() throws RecognitionException, TokenStreamException {
		ReturnAssembly r;
		
		r=null; Type t;
		
		try {      // for error handling
			t=data_type();
			if ( inputState.guessing==0 ) {
				r=new ReturnAssembly(Collections.singletonList(t));
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_20);
			} else {
			  throw ex;
			}
		}
		return r;
	}
	
	public final StmtBlock  function_block(
		ReturnAssembly r
	) throws RecognitionException, TokenStreamException {
		StmtBlock sb;
		
		Token  tok = null;
		sb=null; Statement s; 
			  StmtReturn rs; List l = new ArrayList();
		
		try {      // for error handling
			tok = LT(1);
			match(LCURLY);
			{
			_loop7170:
			do {
				if ((_tokenSet_10.member(LA(1)))) {
					s=statement();
					if ( inputState.guessing==0 ) {
						if (s != null) l.add(s);
					}
				}
				else {
					break _loop7170;
				}
				
			} while (true);
			}
			rs=return_statement();
			match(SEMI);
			match(RCURLY);
			if ( inputState.guessing==0 ) {
				for(int i=0;i<r.count();i++) {
				String name=r.getName(i); Type t=r.getType(i);
							Statement assignRet=new StmtAssign(rs.getContext(), new ExprVar(rs.getContext(), name), rs.getValue(), 0);
							l.add(assignRet);
						  }
						  			sb = new StmtBlock(getContext(tok), l); 
				
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_2);
			} else {
			  throw ex;
			}
		}
		return sb;
	}
	
	public final StmtReturn  return_statement() throws RecognitionException, TokenStreamException {
		StmtReturn s;
		
		Token  t = null;
		s = null; Expression x = null;
		
		try {      // for error handling
			t = LT(1);
			match(TK_return);
			{
			switch ( LA(1)) {
			case TK_peek:
			case TK_pop:
			case TK_pi:
			case TK_true:
			case TK_false:
			case LPAREN:
			case INCREMENT:
			case MINUS:
			case DECREMENT:
			case BANG:
			case NDVAL:
			case CHAR_LITERAL:
			case STRING_LITERAL:
			case HQUAN:
			case NUMBER:
			case ID:
			{
				x=right_expr();
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				s = new StmtReturn(getContext(t), x);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_13);
			} else {
			  throw ex;
			}
		}
		return s;
	}
	
	public final Parameter  param_decl() throws RecognitionException, TokenStreamException {
		Parameter p;
		
		Token  id = null;
		Type t; p = null;
		
		try {      // for error handling
			t=data_type();
			id = LT(1);
			match(ID);
			if ( inputState.guessing==0 ) {
				p = new Parameter(t, id.getText());
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_21);
			} else {
			  throw ex;
			}
		}
		return p;
	}
	
	public final Statement  for_init_statement() throws RecognitionException, TokenStreamException {
		Statement s;
		
		s = null;
		
		try {      // for error handling
			boolean synPredMatched7193 = false;
			if (((_tokenSet_0.member(LA(1))))) {
				int _m7193 = mark();
				synPredMatched7193 = true;
				inputState.guessing++;
				try {
					{
					variable_decl();
					}
				}
				catch (RecognitionException pe) {
					synPredMatched7193 = false;
				}
				rewind(_m7193);
				inputState.guessing--;
			}
			if ( synPredMatched7193 ) {
				s=variable_decl();
			}
			else {
				boolean synPredMatched7195 = false;
				if (((_tokenSet_15.member(LA(1))))) {
					int _m7195 = mark();
					synPredMatched7195 = true;
					inputState.guessing++;
					try {
						{
						expr_statement();
						}
					}
					catch (RecognitionException pe) {
						synPredMatched7195 = false;
					}
					rewind(_m7195);
					inputState.guessing--;
				}
				if ( synPredMatched7195 ) {
					s=expr_statement();
				}
				else {
					boolean synPredMatched7197 = false;
					if (((LA(1)==SEMI))) {
						int _m7197 = mark();
						synPredMatched7197 = true;
						inputState.guessing++;
						try {
							{
							match(SEMI);
							}
						}
						catch (RecognitionException pe) {
							synPredMatched7197 = false;
						}
						rewind(_m7197);
						inputState.guessing--;
					}
					if ( synPredMatched7197 ) {
						if ( inputState.guessing==0 ) {
							s = new StmtEmpty(null);
						}
					}
					else {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}}
				}
				catch (RecognitionException ex) {
					if (inputState.guessing==0) {
						reportError(ex);
						consume();
						consumeUntil(_tokenSet_13);
					} else {
					  throw ex;
					}
				}
				return s;
			}
			
	public final Statement  for_incr_statement() throws RecognitionException, TokenStreamException {
		Statement s;
		
		s = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case TK_peek:
			case TK_pop:
			case INCREMENT:
			case DECREMENT:
			case ID:
			{
				s=expr_statement();
				break;
			}
			case RPAREN:
			{
				if ( inputState.guessing==0 ) {
					s = new StmtEmpty(null);
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_22);
			} else {
			  throw ex;
			}
		}
		return s;
	}
	
	public final Expression  incOrDec() throws RecognitionException, TokenStreamException {
		Expression x;
		
		Token  i = null;
		Token  d = null;
		x = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case ID:
			{
				x=left_expr();
				{
				switch ( LA(1)) {
				case INCREMENT:
				{
					match(INCREMENT);
					if ( inputState.guessing==0 ) {
						x = new ExprUnary(x.getContext(), ExprUnary.UNOP_POSTINC, x);
					}
					break;
				}
				case DECREMENT:
				{
					match(DECREMENT);
					if ( inputState.guessing==0 ) {
						x = new ExprUnary(x.getContext(), ExprUnary.UNOP_POSTDEC, x);
					}
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				break;
			}
			case INCREMENT:
			{
				i = LT(1);
				match(INCREMENT);
				x=left_expr();
				if ( inputState.guessing==0 ) {
					x = new ExprUnary(getContext(i), ExprUnary.UNOP_PREINC, x);
				}
				break;
			}
			case DECREMENT:
			{
				d = LT(1);
				match(DECREMENT);
				x=left_expr();
				if ( inputState.guessing==0 ) {
					x = new ExprUnary(getContext(d), ExprUnary.UNOP_PREDEC, x);
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_23);
			} else {
			  throw ex;
			}
		}
		return x;
	}
	
	public final Expression  left_expr() throws RecognitionException, TokenStreamException {
		Expression x;
		
		x = null;
		
		try {      // for error handling
			x=value();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_24);
			} else {
			  throw ex;
			}
		}
		return x;
	}
	
	public final Statement  assign_expr() throws RecognitionException, TokenStreamException {
		Statement s;
		
		s = null; Expression l, r; int o = 0;
		
		try {      // for error handling
			l=left_expr();
			{
			switch ( LA(1)) {
			case ASSIGN:
			{
				match(ASSIGN);
				if ( inputState.guessing==0 ) {
					o = 0;
				}
				break;
			}
			case PLUS_EQUALS:
			{
				match(PLUS_EQUALS);
				if ( inputState.guessing==0 ) {
					o = ExprBinary.BINOP_ADD;
				}
				break;
			}
			case MINUS_EQUALS:
			{
				match(MINUS_EQUALS);
				if ( inputState.guessing==0 ) {
					o = ExprBinary.BINOP_SUB;
				}
				break;
			}
			case STAR_EQUALS:
			{
				match(STAR_EQUALS);
				if ( inputState.guessing==0 ) {
					o = ExprBinary.BINOP_MUL;
				}
				break;
			}
			case DIV_EQUALS:
			{
				match(DIV_EQUALS);
				if ( inputState.guessing==0 ) {
					o = ExprBinary.BINOP_DIV;
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			r=right_expr();
			if ( inputState.guessing==0 ) {
				s = new StmtAssign(l.getContext(), l, r, o);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_17);
			} else {
			  throw ex;
			}
		}
		return s;
	}
	
	public final Expression  func_call() throws RecognitionException, TokenStreamException {
		Expression x;
		
		Token  name = null;
		x = null; List l;
		
		try {      // for error handling
			name = LT(1);
			match(ID);
			l=func_call_params();
			if ( inputState.guessing==0 ) {
				x = new ExprFunCall(getContext(name), name.getText(), l);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_23);
			} else {
			  throw ex;
			}
		}
		return x;
	}
	
	public final Expression  streamit_value_expr() throws RecognitionException, TokenStreamException {
		Expression x;
		
		Token  t = null;
		Token  u = null;
		x = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case TK_pop:
			{
				t = LT(1);
				match(TK_pop);
				match(LPAREN);
				match(RPAREN);
				if ( inputState.guessing==0 ) {
					x = new ExprPop(getContext(t));
				}
				break;
			}
			case TK_peek:
			{
				u = LT(1);
				match(TK_peek);
				match(LPAREN);
				x=right_expr();
				match(RPAREN);
				if ( inputState.guessing==0 ) {
					x = new ExprPeek(getContext(u), x);
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_23);
			} else {
			  throw ex;
			}
		}
		return x;
	}
	
	public final Expression  value() throws RecognitionException, TokenStreamException {
		Expression x;
		
		Token  name = null;
		Token  field = null;
		Token  l = null;
		x = null; Expression array;
		
		try {      // for error handling
			name = LT(1);
			match(ID);
			if ( inputState.guessing==0 ) {
				x = new ExprVar(getContext(name), name.getText());
			}
			{
			_loop7276:
			do {
				switch ( LA(1)) {
				case DOT:
				{
					match(DOT);
					field = LT(1);
					match(ID);
					if ( inputState.guessing==0 ) {
						x = new ExprField(x.getContext(), x, field.getText());
					}
					break;
				}
				case LSQUARE:
				{
					l = LT(1);
					match(LSQUARE);
					{
					switch ( LA(1)) {
					case TK_peek:
					case TK_pop:
					case TK_pi:
					case TK_true:
					case TK_false:
					case LPAREN:
					case INCREMENT:
					case MINUS:
					case DECREMENT:
					case BANG:
					case NDVAL:
					case CHAR_LITERAL:
					case STRING_LITERAL:
					case HQUAN:
					case NUMBER:
					case ID:
					{
						array=right_expr();
						if ( inputState.guessing==0 ) {
							x = new ExprArray(x.getContext(), x, array);
						}
						break;
					}
					case RSQUARE:
					{
						if ( inputState.guessing==0 ) {
							throw new SemanticException("missing array index",
													getFilename(), l.getLine());
						}
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					match(RSQUARE);
					break;
				}
				default:
				{
					break _loop7276;
				}
				}
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_24);
			} else {
			  throw ex;
			}
		}
		return x;
	}
	
	public final Expression  ternaryExpr() throws RecognitionException, TokenStreamException {
		Expression x;
		
		x = null; Expression b, c;
		
		try {      // for error handling
			x=logicOrExpr();
			{
			switch ( LA(1)) {
			case QUESTION:
			{
				match(QUESTION);
				b=ternaryExpr();
				match(COLON);
				c=ternaryExpr();
				if ( inputState.guessing==0 ) {
					x = new ExprTernary(x.getContext(), ExprTernary.TEROP_COND,
										x, b, c);
				}
				break;
			}
			case EOF:
			case TK_portal:
			case TK_peek:
			case TK_pop:
			case TK_push:
			case TK_boolean:
			case TK_float:
			case TK_bit:
			case TK_int:
			case TK_void:
			case TK_double:
			case TK_complex:
			case RPAREN:
			case LCURLY:
			case RCURLY:
			case RSQUARE:
			case COLON:
			case SEMI:
			case COMMA:
			case ID:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_12);
			} else {
			  throw ex;
			}
		}
		return x;
	}
	
	public final Expression  arr_initializer() throws RecognitionException, TokenStreamException {
		Expression x;
		
		Token  lc = null;
		ArrayList l = new ArrayList(); 
		x = null;
		Expression y;
		
		try {      // for error handling
			lc = LT(1);
			match(LCURLY);
			{
			switch ( LA(1)) {
			case TK_peek:
			case TK_pop:
			case TK_pi:
			case TK_true:
			case TK_false:
			case LPAREN:
			case LCURLY:
			case INCREMENT:
			case MINUS:
			case DECREMENT:
			case BANG:
			case NDVAL:
			case CHAR_LITERAL:
			case STRING_LITERAL:
			case HQUAN:
			case NUMBER:
			case ID:
			{
				y=var_initializer();
				if ( inputState.guessing==0 ) {
					l.add(y);
				}
				{
				_loop7220:
				do {
					if ((LA(1)==COMMA)) {
						match(COMMA);
						y=var_initializer();
						if ( inputState.guessing==0 ) {
							l.add(y);
						}
					}
					else {
						break _loop7220;
					}
					
				} while (true);
				}
				break;
			}
			case RCURLY:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(RCURLY);
			if ( inputState.guessing==0 ) {
				x = new ExprArrayInit(getContext(lc), l);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_9);
			} else {
			  throw ex;
			}
		}
		return x;
	}
	
	public final Expression  logicOrExpr() throws RecognitionException, TokenStreamException {
		Expression x;
		
		x = null; Expression r; int o = 0;
		
		try {      // for error handling
			x=logicAndExpr();
			{
			_loop7225:
			do {
				if ((LA(1)==LOGIC_OR)) {
					match(LOGIC_OR);
					r=logicAndExpr();
					if ( inputState.guessing==0 ) {
						x = new ExprBinary(x.getContext(), ExprBinary.BINOP_OR, x, r);
					}
				}
				else {
					break _loop7225;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_25);
			} else {
			  throw ex;
			}
		}
		return x;
	}
	
	public final Expression  logicAndExpr() throws RecognitionException, TokenStreamException {
		Expression x;
		
		x = null; Expression r;
		
		try {      // for error handling
			x=bitwiseExpr();
			{
			_loop7228:
			do {
				if ((LA(1)==LOGIC_AND)) {
					match(LOGIC_AND);
					r=bitwiseExpr();
					if ( inputState.guessing==0 ) {
						x = new ExprBinary(x.getContext(), ExprBinary.BINOP_AND, x, r);
					}
				}
				else {
					break _loop7228;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_26);
			} else {
			  throw ex;
			}
		}
		return x;
	}
	
	public final Expression  bitwiseExpr() throws RecognitionException, TokenStreamException {
		Expression x;
		
		x = null; Expression r; int o = 0;
		
		try {      // for error handling
			x=equalExpr();
			{
			_loop7232:
			do {
				if (((LA(1) >= BITWISE_AND && LA(1) <= BITWISE_XOR))) {
					{
					switch ( LA(1)) {
					case BITWISE_OR:
					{
						match(BITWISE_OR);
						if ( inputState.guessing==0 ) {
							o = ExprBinary.BINOP_BOR;
						}
						break;
					}
					case BITWISE_AND:
					{
						match(BITWISE_AND);
						if ( inputState.guessing==0 ) {
							o = ExprBinary.BINOP_BAND;
						}
						break;
					}
					case BITWISE_XOR:
					{
						match(BITWISE_XOR);
						if ( inputState.guessing==0 ) {
							o = ExprBinary.BINOP_BXOR;
						}
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					r=equalExpr();
					if ( inputState.guessing==0 ) {
						x = new ExprBinary(x.getContext(), o, x, r);
					}
				}
				else {
					break _loop7232;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_27);
			} else {
			  throw ex;
			}
		}
		return x;
	}
	
	public final Expression  equalExpr() throws RecognitionException, TokenStreamException {
		Expression x;
		
		x = null; Expression r; int o = 0;
		
		try {      // for error handling
			x=compareExpr();
			{
			_loop7236:
			do {
				if ((LA(1)==EQUAL||LA(1)==NOT_EQUAL)) {
					{
					switch ( LA(1)) {
					case EQUAL:
					{
						match(EQUAL);
						if ( inputState.guessing==0 ) {
							o = ExprBinary.BINOP_EQ;
						}
						break;
					}
					case NOT_EQUAL:
					{
						match(NOT_EQUAL);
						if ( inputState.guessing==0 ) {
							o = ExprBinary.BINOP_NEQ;
						}
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					r=compareExpr();
					if ( inputState.guessing==0 ) {
						x = new ExprBinary(x.getContext(), o, x, r);
					}
				}
				else {
					break _loop7236;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_28);
			} else {
			  throw ex;
			}
		}
		return x;
	}
	
	public final Expression  compareExpr() throws RecognitionException, TokenStreamException {
		Expression x;
		
		x = null; Expression r; int o = 0;
		
		try {      // for error handling
			x=addExpr();
			{
			_loop7240:
			do {
				if (((LA(1) >= LESS_THAN && LA(1) <= MORE_EQUAL))) {
					{
					switch ( LA(1)) {
					case LESS_THAN:
					{
						match(LESS_THAN);
						if ( inputState.guessing==0 ) {
							o = ExprBinary.BINOP_LT;
						}
						break;
					}
					case LESS_EQUAL:
					{
						match(LESS_EQUAL);
						if ( inputState.guessing==0 ) {
							o = ExprBinary.BINOP_LE;
						}
						break;
					}
					case MORE_THAN:
					{
						match(MORE_THAN);
						if ( inputState.guessing==0 ) {
							o = ExprBinary.BINOP_GT;
						}
						break;
					}
					case MORE_EQUAL:
					{
						match(MORE_EQUAL);
						if ( inputState.guessing==0 ) {
							o = ExprBinary.BINOP_GE;
						}
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					r=addExpr();
					if ( inputState.guessing==0 ) {
						x = new ExprBinary(x.getContext(), o, x, r);
					}
				}
				else {
					break _loop7240;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_29);
			} else {
			  throw ex;
			}
		}
		return x;
	}
	
	public final Expression  addExpr() throws RecognitionException, TokenStreamException {
		Expression x;
		
		x = null; Expression r; int o = 0;
		
		try {      // for error handling
			x=multExpr();
			{
			_loop7244:
			do {
				if ((LA(1)==PLUS||LA(1)==MINUS||LA(1)==SELECT)) {
					{
					switch ( LA(1)) {
					case PLUS:
					{
						match(PLUS);
						if ( inputState.guessing==0 ) {
							o = ExprBinary.BINOP_ADD;
						}
						break;
					}
					case MINUS:
					{
						match(MINUS);
						if ( inputState.guessing==0 ) {
							o = ExprBinary.BINOP_SUB;
						}
						break;
					}
					case SELECT:
					{
						match(SELECT);
						if ( inputState.guessing==0 ) {
							o = ExprBinary.BINOP_SELECT;
						}
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					r=multExpr();
					if ( inputState.guessing==0 ) {
						x = new ExprBinary(x.getContext(), o, x, r);
					}
				}
				else {
					break _loop7244;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_30);
			} else {
			  throw ex;
			}
		}
		return x;
	}
	
	public final Expression  multExpr() throws RecognitionException, TokenStreamException {
		Expression x;
		
		x = null; Expression r; int o = 0;
		
		try {      // for error handling
			x=castExpr();
			{
			_loop7248:
			do {
				if ((LA(1)==STAR||LA(1)==DIV||LA(1)==MOD)) {
					{
					switch ( LA(1)) {
					case STAR:
					{
						match(STAR);
						if ( inputState.guessing==0 ) {
							o = ExprBinary.BINOP_MUL;
						}
						break;
					}
					case DIV:
					{
						match(DIV);
						if ( inputState.guessing==0 ) {
							o = ExprBinary.BINOP_DIV;
						}
						break;
					}
					case MOD:
					{
						match(MOD);
						if ( inputState.guessing==0 ) {
							o = ExprBinary.BINOP_MOD;
						}
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					r=castExpr();
					if ( inputState.guessing==0 ) {
						x = new ExprBinary(x.getContext(), o, x, r);
					}
				}
				else {
					break _loop7248;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_31);
			} else {
			  throw ex;
			}
		}
		return x;
	}
	
	public final Expression  castExpr() throws RecognitionException, TokenStreamException {
		Expression x;
		
		Token  l = null;
		x = null; Type t=null;
		
		try {      // for error handling
			boolean synPredMatched7251 = false;
			if (((LA(1)==LPAREN))) {
				int _m7251 = mark();
				synPredMatched7251 = true;
				inputState.guessing++;
				try {
					{
					match(LPAREN);
					primitive_type();
					}
				}
				catch (RecognitionException pe) {
					synPredMatched7251 = false;
				}
				rewind(_m7251);
				inputState.guessing--;
			}
			if ( synPredMatched7251 ) {
				{
				l = LT(1);
				match(LPAREN);
				t=primitive_type();
				match(RPAREN);
				}
				x=inc_dec_expr();
				if ( inputState.guessing==0 ) {
					x = new ExprTypeCast(getContext(l), t, x);
				}
			}
			else if ((_tokenSet_32.member(LA(1)))) {
				x=shiftExpr();
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_23);
			} else {
			  throw ex;
			}
		}
		return x;
	}
	
	public final Expression  inc_dec_expr() throws RecognitionException, TokenStreamException {
		Expression x;
		
		Token  b = null;
		x = null;
		
		try {      // for error handling
			boolean synPredMatched7260 = false;
			if (((LA(1)==INCREMENT||LA(1)==DECREMENT||LA(1)==ID))) {
				int _m7260 = mark();
				synPredMatched7260 = true;
				inputState.guessing++;
				try {
					{
					incOrDec();
					}
				}
				catch (RecognitionException pe) {
					synPredMatched7260 = false;
				}
				rewind(_m7260);
				inputState.guessing--;
			}
			if ( synPredMatched7260 ) {
				x=incOrDec();
			}
			else if ((LA(1)==BANG)) {
				b = LT(1);
				match(BANG);
				x=value_expr();
				if ( inputState.guessing==0 ) {
					x = new ExprUnary(getContext(b),
																	ExprUnary.UNOP_NOT, x);
				}
			}
			else if ((_tokenSet_33.member(LA(1)))) {
				x=value_expr();
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_23);
			} else {
			  throw ex;
			}
		}
		return x;
	}
	
	public final Expression  shiftExpr() throws RecognitionException, TokenStreamException {
		Expression x;
		
		x=null; Expression amt; Type t=null;
		
		try {      // for error handling
			boolean synPredMatched7255 = false;
			if (((LA(1)==ID))) {
				int _m7255 = mark();
				synPredMatched7255 = true;
				inputState.guessing++;
				try {
					{
					left_expr();
					match(RSHIFT);
					}
				}
				catch (RecognitionException pe) {
					synPredMatched7255 = false;
				}
				rewind(_m7255);
				inputState.guessing--;
			}
			if ( synPredMatched7255 ) {
				x=left_expr();
				match(RSHIFT);
				amt=value_expr();
				if ( inputState.guessing==0 ) {
					x=new ExprBinary(x.getContext(), ExprBinary.BINOP_RSHIFT, x, amt);
				}
			}
			else {
				boolean synPredMatched7257 = false;
				if (((LA(1)==ID))) {
					int _m7257 = mark();
					synPredMatched7257 = true;
					inputState.guessing++;
					try {
						{
						left_expr();
						match(LSHIFT);
						}
					}
					catch (RecognitionException pe) {
						synPredMatched7257 = false;
					}
					rewind(_m7257);
					inputState.guessing--;
				}
				if ( synPredMatched7257 ) {
					x=left_expr();
					match(LSHIFT);
					amt=value_expr();
					if ( inputState.guessing==0 ) {
						x=new ExprBinary(x.getContext(), ExprBinary.BINOP_LSHIFT, x, amt);
					}
				}
				else if ((_tokenSet_32.member(LA(1)))) {
					x=inc_dec_expr();
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					consume();
					consumeUntil(_tokenSet_23);
				} else {
				  throw ex;
				}
			}
			return x;
		}
		
	public final Expression  value_expr() throws RecognitionException, TokenStreamException {
		Expression x;
		
		Token  t = null;
		Token  m = null;
		x = null; boolean neg = false;
		
		try {      // for error handling
			switch ( LA(1)) {
			case NDVAL:
			{
				t = LT(1);
				match(NDVAL);
				if ( inputState.guessing==0 ) {
					x=new ExprStar(getContext(t));
				}
				break;
			}
			case TK_peek:
			case TK_pop:
			case TK_pi:
			case TK_true:
			case TK_false:
			case LPAREN:
			case MINUS:
			case CHAR_LITERAL:
			case STRING_LITERAL:
			case HQUAN:
			case NUMBER:
			case ID:
			{
				{
				{
				switch ( LA(1)) {
				case MINUS:
				{
					m = LT(1);
					match(MINUS);
					if ( inputState.guessing==0 ) {
						neg = true;
					}
					break;
				}
				case TK_peek:
				case TK_pop:
				case TK_pi:
				case TK_true:
				case TK_false:
				case LPAREN:
				case CHAR_LITERAL:
				case STRING_LITERAL:
				case HQUAN:
				case NUMBER:
				case ID:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				{
				switch ( LA(1)) {
				case TK_pi:
				case TK_true:
				case TK_false:
				case LPAREN:
				case CHAR_LITERAL:
				case STRING_LITERAL:
				case HQUAN:
				case NUMBER:
				case ID:
				{
					x=minic_value_expr();
					break;
				}
				case TK_peek:
				case TK_pop:
				{
					x=streamit_value_expr();
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				if ( inputState.guessing==0 ) {
					if (neg) x = new ExprUnary(getContext(m), ExprUnary.UNOP_NEG, x);
				}
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_23);
			} else {
			  throw ex;
			}
		}
		return x;
	}
	
	public final Expression  minic_value_expr() throws RecognitionException, TokenStreamException {
		Expression x;
		
		x = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LPAREN:
			{
				match(LPAREN);
				x=right_expr();
				match(RPAREN);
				break;
			}
			case TK_pi:
			case TK_true:
			case TK_false:
			case CHAR_LITERAL:
			case STRING_LITERAL:
			case HQUAN:
			case NUMBER:
			{
				x=constantExpr();
				break;
			}
			default:
				boolean synPredMatched7272 = false;
				if (((LA(1)==ID))) {
					int _m7272 = mark();
					synPredMatched7272 = true;
					inputState.guessing++;
					try {
						{
						func_call();
						}
					}
					catch (RecognitionException pe) {
						synPredMatched7272 = false;
					}
					rewind(_m7272);
					inputState.guessing--;
				}
				if ( synPredMatched7272 ) {
					x=func_call();
				}
				else if ((LA(1)==ID)) {
					x=value();
				}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_23);
			} else {
			  throw ex;
			}
		}
		return x;
	}
	
	public final Expression  constantExpr() throws RecognitionException, TokenStreamException {
		Expression x;
		
		Token  h = null;
		Token  n = null;
		Token  c = null;
		Token  s = null;
		Token  pi = null;
		Token  t = null;
		Token  f = null;
		x = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case HQUAN:
			{
				h = LT(1);
				match(HQUAN);
				if ( inputState.guessing==0 ) {
					String tmp = h.getText().substring(2);
								   Integer iti = new Integer(
						 (int ) ( ( Long.parseLong(tmp, 16) - (long) Integer.MIN_VALUE ) 
							  % ( (long)Integer.MAX_VALUE - (long) Integer.MIN_VALUE + 1) 
							  + Integer.MIN_VALUE) );
									x = ExprConstant.createConstant(getContext(h), iti.toString() );
				}
				break;
			}
			case NUMBER:
			{
				n = LT(1);
				match(NUMBER);
				if ( inputState.guessing==0 ) {
					x = ExprConstant.createConstant(getContext(n), n.getText());
				}
				break;
			}
			case CHAR_LITERAL:
			{
				c = LT(1);
				match(CHAR_LITERAL);
				if ( inputState.guessing==0 ) {
					x = new ExprConstChar(getContext(c), c.getText());
				}
				break;
			}
			case STRING_LITERAL:
			{
				s = LT(1);
				match(STRING_LITERAL);
				if ( inputState.guessing==0 ) {
					x = new ExprConstStr(getContext(s), s.getText());
				}
				break;
			}
			case TK_pi:
			{
				pi = LT(1);
				match(TK_pi);
				if ( inputState.guessing==0 ) {
					x = new ExprConstFloat(getContext(pi), Math.PI);
				}
				break;
			}
			case TK_true:
			{
				t = LT(1);
				match(TK_true);
				if ( inputState.guessing==0 ) {
					x = new ExprConstBoolean(getContext(t), true);
				}
				break;
			}
			case TK_false:
			{
				f = LT(1);
				match(TK_false);
				if ( inputState.guessing==0 ) {
					x = new ExprConstBoolean(getContext(f), false);
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_23);
			} else {
			  throw ex;
			}
		}
		return x;
	}
	
	public final TypeStruct  struct_decl() throws RecognitionException, TokenStreamException {
		TypeStruct ts;
		
		Token  t = null;
		Token  id = null;
		ts = null; Parameter p; List names = new ArrayList();
			List types = new ArrayList();
		
		try {      // for error handling
			t = LT(1);
			match(TK_struct);
			id = LT(1);
			match(ID);
			match(LCURLY);
			{
			_loop7280:
			do {
				if ((_tokenSet_0.member(LA(1)))) {
					p=param_decl();
					match(SEMI);
					if ( inputState.guessing==0 ) {
						names.add(p.getName()); types.add(p.getType());
					}
				}
				else {
					break _loop7280;
				}
				
			} while (true);
			}
			match(RCURLY);
			if ( inputState.guessing==0 ) {
				ts = new TypeStruct(getContext(t), id.getText(), names, types);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_1);
			} else {
			  throw ex;
			}
		}
		return ts;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"\"filter\"",
		"\"pipeline\"",
		"\"splitjoin\"",
		"\"sbox\"",
		"\"feedbackloop\"",
		"\"portal\"",
		"\"to\"",
		"\"handler\"",
		"\"add\"",
		"\"split\"",
		"\"join\"",
		"\"duplicate\"",
		"\"roundrobin\"",
		"\"body\"",
		"\"loop\"",
		"\"enqueue\"",
		"\"init\"",
		"\"prework\"",
		"\"work\"",
		"\"phase\"",
		"\"peek\"",
		"\"pop\"",
		"\"push\"",
		"\"boolean\"",
		"\"float\"",
		"\"bit\"",
		"\"int\"",
		"\"void\"",
		"\"double\"",
		"\"complex\"",
		"\"struct\"",
		"\"template\"",
		"\"if\"",
		"\"else\"",
		"\"while\"",
		"\"for\"",
		"\"switch\"",
		"\"case\"",
		"\"default\"",
		"\"break\"",
		"\"continue\"",
		"\"return\"",
		"\"pi\"",
		"\"true\"",
		"\"false\"",
		"\"implements\"",
		"\"overrides\"",
		"ARROW",
		"WS",
		"SL_COMMENT",
		"ML_COMMENT",
		"LPAREN",
		"RPAREN",
		"LCURLY",
		"RCURLY",
		"LSQUARE",
		"RSQUARE",
		"PLUS",
		"PLUS_EQUALS",
		"INCREMENT",
		"MINUS",
		"MINUS_EQUALS",
		"DECREMENT",
		"STAR",
		"STAR_EQUALS",
		"DIV",
		"DIV_EQUALS",
		"MOD",
		"LOGIC_AND",
		"LOGIC_OR",
		"BITWISE_AND",
		"BITWISE_OR",
		"BITWISE_XOR",
		"ASSIGN",
		"EQUAL",
		"NOT_EQUAL",
		"LESS_THAN",
		"LESS_EQUAL",
		"MORE_THAN",
		"MORE_EQUAL",
		"QUESTION",
		"COLON",
		"SEMI",
		"COMMA",
		"DOT",
		"BANG",
		"LSHIFT",
		"RSHIFT",
		"NDVAL",
		"SELECT",
		"CHAR_LITERAL",
		"STRING_LITERAL",
		"ESC",
		"DIGIT",
		"HQUAN",
		"NUMBER",
		"an identifier",
		"TK_do"
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 17045651968L, 68719476736L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 2L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 288230393213094402L, 68719476736L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { 17045651970L, 68723671040L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 496L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { 144678138029277184L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = { -8790963852019862014L, 206162624516L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = { 288230393213094400L, 68719476736L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	private static final long[] mk_tokenSet_8() {
		long[] data = { 2251799813685744L, 68719738880L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());
	private static final long[] mk_tokenSet_9() {
		long[] data = { 288230393197363714L, 68732059648L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_9 = new BitSet(mk_tokenSet_9());
	private static final long[] mk_tokenSet_10() {
		long[] data = { -9079229549982617088L, 206162624516L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_10 = new BitSet(mk_tokenSet_10());
	private static final long[] mk_tokenSet_11() {
		long[] data = { -8790963852004131326L, 206162624516L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_11 = new BitSet(mk_tokenSet_11());
	private static final long[] mk_tokenSet_12() {
		long[] data = { 1657324680035435010L, 68734156800L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_12 = new BitSet(mk_tokenSet_12());
	private static final long[] mk_tokenSet_13() {
		long[] data = { 0L, 4194304L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_13 = new BitSet(mk_tokenSet_13());
	private static final long[] mk_tokenSet_14() {
		long[] data = { 4539628441552553474L, 69273116585L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_14 = new BitSet(mk_tokenSet_14());
	private static final long[] mk_tokenSet_15() {
		long[] data = { -9223372036804444160L, 68719476740L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_15 = new BitSet(mk_tokenSet_15());
	private static final long[] mk_tokenSet_16() {
		long[] data = { -8790963852019863040L, 206162624516L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_16 = new BitSet(mk_tokenSet_16());
	private static final long[] mk_tokenSet_17() {
		long[] data = { 72057594037927936L, 4194304L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_17 = new BitSet(mk_tokenSet_17());
	private static final long[] mk_tokenSet_18() {
		long[] data = { 17045652464L, 68719476736L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_18 = new BitSet(mk_tokenSet_18());
	private static final long[] mk_tokenSet_19() {
		long[] data = { 650770146155037168L, 68719738880L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_19 = new BitSet(mk_tokenSet_19());
	private static final long[] mk_tokenSet_20() {
		long[] data = { 0L, 68719476736L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_20 = new BitSet(mk_tokenSet_20());
	private static final long[] mk_tokenSet_21() {
		long[] data = { 72057594037927936L, 12582912L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_21 = new BitSet(mk_tokenSet_21());
	private static final long[] mk_tokenSet_22() {
		long[] data = { 72057594037927936L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_22 = new BitSet(mk_tokenSet_22());
	private static final long[] mk_tokenSet_23() {
		long[] data = { 3963167689249128962L, 69273116585L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_23 = new BitSet(mk_tokenSet_23());
	private static final long[] mk_tokenSet_24() {
		long[] data = { -648518329178258942L, 69474451455L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_24 = new BitSet(mk_tokenSet_24());
	private static final long[] mk_tokenSet_25() {
		long[] data = { 1657324680035435010L, 68735205376L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_25 = new BitSet(mk_tokenSet_25());
	private static final long[] mk_tokenSet_26() {
		long[] data = { 1657324680035435010L, 68735205888L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_26 = new BitSet(mk_tokenSet_26());
	private static final long[] mk_tokenSet_27() {
		long[] data = { 1657324680035435010L, 68735206144L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_27 = new BitSet(mk_tokenSet_27());
	private static final long[] mk_tokenSet_28() {
		long[] data = { 1657324680035435010L, 68735213312L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_28 = new BitSet(mk_tokenSet_28());
	private static final long[] mk_tokenSet_29() {
		long[] data = { 1657324680035435010L, 68735262464L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_29 = new BitSet(mk_tokenSet_29());
	private static final long[] mk_tokenSet_30() {
		long[] data = { 1657324680035435010L, 68736245504L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_30 = new BitSet(mk_tokenSet_30());
	private static final long[] mk_tokenSet_31() {
		long[] data = { 3963167689249128962L, 69273116417L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_31 = new BitSet(mk_tokenSet_31());
	private static final long[] mk_tokenSet_32() {
		long[] data = { -9186850658576236544L, 123782299653L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_32 = new BitSet(mk_tokenSet_32());
	private static final long[] mk_tokenSet_33() {
		long[] data = { 36521378278539264L, 123748745217L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_33 = new BitSet(mk_tokenSet_33());
	
	}
