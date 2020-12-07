// $ANTLR 3.5 src/exm/stc/ast/ExM.g 2020-12-07 12:55:15

package exm.stc.ast.antlr;
import exm.stc.ast.FilePosition;
import exm.stc.ast.FilePosition.LineMapping;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class ExMParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ALPHA", "AND", "ANNOTATION", 
		"APP", "APPEND", "APP_BODY", "APP_FILENAME", "APP_REDIRECTION", "ARGUMENT_LIST", 
		"ARRAY", "ARRAY_ELEMS", "ARRAY_KV_ELEM", "ARRAY_KV_ELEMS", "ARRAY_LOAD", 
		"ARRAY_PATH", "ARRAY_RANGE", "ASSIGN", "ASSIGN_EXPRESSION", "ASSIGN_TARGET", 
		"ATSIGN", "BLOCK", "BOOL_LITERAL", "BUILTIN", "CALL_ANNOTATION", "CALL_FUNCTION", 
		"CASE", "CHAR", "COLON", "COMMA", "COMMAND", "CONST", "CPP_LINE", "DECIMAL", 
		"DECIMAL_INT", "DECLARATION", "DECLARE_ASSIGN", "DECLARE_VARIABLE_REST", 
		"DEC_FRAG", "DEEP", "DEFAULT", "DEFINE_APP_FUNCTION", "DEFINE_BUILTIN_FUNCTION", 
		"DEFINE_FUNCTION", "DEFINE_NEW_STRUCT_TYPE", "DEFINE_NEW_TYPE", "DEPRECATED", 
		"DIGIT", "DIV", "ELSE", "EQUALS", "ESCAPE_CODE", "EXPR", "EXPR_STMT", 
		"FALSE", "FLOAT_LITERAL", "FOR", "FOREACH", "FOREACH_LOOP", "FORMAL_ARGUMENT_LIST", 
		"FOR_LOOP", "FOR_LOOP_ASSIGN", "FOR_LOOP_INIT", "FOR_LOOP_UPDATE", "GLOBAL", 
		"GLOBAL_CONST", "GT", "GTE", "HASH", "HEX_INT", "ID", "IDENTIFIER_LIST", 
		"IF", "IF_STATEMENT", "IMPORT", "IMPORT_PATH", "IN", "INFINITY", "INLINE_TCL", 
		"INTDIV", "INT_LITERAL", "ITERATE", "KW_ARGUMENT", "LBRACE", "LPAREN", 
		"LSQUARE", "LT", "LTE", "MAPPING", "MINUS", "MOD", "MULT", "MULTI_LINE_COMMENT", 
		"MULTI_TYPE", "MUTATE", "NEGATE", "NEQUALS", "NOT", "NOTANUMBER", "NUM_FRAG", 
		"OCTAL_ESCAPE", "OCTAL_INT", "OPERATOR", "OR", "PARAM_TYPE", "PERCENT", 
		"PIPE", "PLUS", "POW", "PRAGMA", "PROGRAM", "RBRACE", "RPAREN", "RSQUARE", 
		"SCI_DECIMAL", "SEMICOLON", "SINGLE_LINE_COMMENT_C", "STANDALONE_TYPE", 
		"STATEMENT_CHAIN", "STDERR", "STDIN", "STDOUT", "STRING", "STRING_LITERAL", 
		"STRING_MULTI_LINE_1", "STRING_MULTI_LINE_2", "STRUCT_FIELD_DEF", "STRUCT_LOAD", 
		"STRUCT_PATH", "SWITCH", "SWITCH_STATEMENT", "TCL_FUN_REF", "TCL_PACKAGE", 
		"TRUE", "TUPLE", "TYPE", "TYPEDEF", "TYPE_PARAMETERS", "UNDER", "UNTIL", 
		"UPDATE", "VARARGS", "VARIABLE", "WAIT", "WAIT_DEEP_STATEMENT", "WAIT_STATEMENT", 
		"WHITESPACE", "'.'"
	};
	public static final int EOF=-1;
	public static final int T__150=150;
	public static final int ALPHA=4;
	public static final int AND=5;
	public static final int ANNOTATION=6;
	public static final int APP=7;
	public static final int APPEND=8;
	public static final int APP_BODY=9;
	public static final int APP_FILENAME=10;
	public static final int APP_REDIRECTION=11;
	public static final int ARGUMENT_LIST=12;
	public static final int ARRAY=13;
	public static final int ARRAY_ELEMS=14;
	public static final int ARRAY_KV_ELEM=15;
	public static final int ARRAY_KV_ELEMS=16;
	public static final int ARRAY_LOAD=17;
	public static final int ARRAY_PATH=18;
	public static final int ARRAY_RANGE=19;
	public static final int ASSIGN=20;
	public static final int ASSIGN_EXPRESSION=21;
	public static final int ASSIGN_TARGET=22;
	public static final int ATSIGN=23;
	public static final int BLOCK=24;
	public static final int BOOL_LITERAL=25;
	public static final int BUILTIN=26;
	public static final int CALL_ANNOTATION=27;
	public static final int CALL_FUNCTION=28;
	public static final int CASE=29;
	public static final int CHAR=30;
	public static final int COLON=31;
	public static final int COMMA=32;
	public static final int COMMAND=33;
	public static final int CONST=34;
	public static final int CPP_LINE=35;
	public static final int DECIMAL=36;
	public static final int DECIMAL_INT=37;
	public static final int DECLARATION=38;
	public static final int DECLARE_ASSIGN=39;
	public static final int DECLARE_VARIABLE_REST=40;
	public static final int DEC_FRAG=41;
	public static final int DEEP=42;
	public static final int DEFAULT=43;
	public static final int DEFINE_APP_FUNCTION=44;
	public static final int DEFINE_BUILTIN_FUNCTION=45;
	public static final int DEFINE_FUNCTION=46;
	public static final int DEFINE_NEW_STRUCT_TYPE=47;
	public static final int DEFINE_NEW_TYPE=48;
	public static final int DEPRECATED=49;
	public static final int DIGIT=50;
	public static final int DIV=51;
	public static final int ELSE=52;
	public static final int EQUALS=53;
	public static final int ESCAPE_CODE=54;
	public static final int EXPR=55;
	public static final int EXPR_STMT=56;
	public static final int FALSE=57;
	public static final int FLOAT_LITERAL=58;
	public static final int FOR=59;
	public static final int FOREACH=60;
	public static final int FOREACH_LOOP=61;
	public static final int FORMAL_ARGUMENT_LIST=62;
	public static final int FOR_LOOP=63;
	public static final int FOR_LOOP_ASSIGN=64;
	public static final int FOR_LOOP_INIT=65;
	public static final int FOR_LOOP_UPDATE=66;
	public static final int GLOBAL=67;
	public static final int GLOBAL_CONST=68;
	public static final int GT=69;
	public static final int GTE=70;
	public static final int HASH=71;
	public static final int HEX_INT=72;
	public static final int ID=73;
	public static final int IDENTIFIER_LIST=74;
	public static final int IF=75;
	public static final int IF_STATEMENT=76;
	public static final int IMPORT=77;
	public static final int IMPORT_PATH=78;
	public static final int IN=79;
	public static final int INFINITY=80;
	public static final int INLINE_TCL=81;
	public static final int INTDIV=82;
	public static final int INT_LITERAL=83;
	public static final int ITERATE=84;
	public static final int KW_ARGUMENT=85;
	public static final int LBRACE=86;
	public static final int LPAREN=87;
	public static final int LSQUARE=88;
	public static final int LT=89;
	public static final int LTE=90;
	public static final int MAPPING=91;
	public static final int MINUS=92;
	public static final int MOD=93;
	public static final int MULT=94;
	public static final int MULTI_LINE_COMMENT=95;
	public static final int MULTI_TYPE=96;
	public static final int MUTATE=97;
	public static final int NEGATE=98;
	public static final int NEQUALS=99;
	public static final int NOT=100;
	public static final int NOTANUMBER=101;
	public static final int NUM_FRAG=102;
	public static final int OCTAL_ESCAPE=103;
	public static final int OCTAL_INT=104;
	public static final int OPERATOR=105;
	public static final int OR=106;
	public static final int PARAM_TYPE=107;
	public static final int PERCENT=108;
	public static final int PIPE=109;
	public static final int PLUS=110;
	public static final int POW=111;
	public static final int PRAGMA=112;
	public static final int PROGRAM=113;
	public static final int RBRACE=114;
	public static final int RPAREN=115;
	public static final int RSQUARE=116;
	public static final int SCI_DECIMAL=117;
	public static final int SEMICOLON=118;
	public static final int SINGLE_LINE_COMMENT_C=119;
	public static final int STANDALONE_TYPE=120;
	public static final int STATEMENT_CHAIN=121;
	public static final int STDERR=122;
	public static final int STDIN=123;
	public static final int STDOUT=124;
	public static final int STRING=125;
	public static final int STRING_LITERAL=126;
	public static final int STRING_MULTI_LINE_1=127;
	public static final int STRING_MULTI_LINE_2=128;
	public static final int STRUCT_FIELD_DEF=129;
	public static final int STRUCT_LOAD=130;
	public static final int STRUCT_PATH=131;
	public static final int SWITCH=132;
	public static final int SWITCH_STATEMENT=133;
	public static final int TCL_FUN_REF=134;
	public static final int TCL_PACKAGE=135;
	public static final int TRUE=136;
	public static final int TUPLE=137;
	public static final int TYPE=138;
	public static final int TYPEDEF=139;
	public static final int TYPE_PARAMETERS=140;
	public static final int UNDER=141;
	public static final int UNTIL=142;
	public static final int UPDATE=143;
	public static final int VARARGS=144;
	public static final int VARIABLE=145;
	public static final int WAIT=146;
	public static final int WAIT_DEEP_STATEMENT=147;
	public static final int WAIT_STATEMENT=148;
	public static final int WHITESPACE=149;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public ExMParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public ExMParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return ExMParser.tokenNames; }
	@Override public String getGrammarFileName() { return "src/exm/stc/ast/ExM.g"; }


	    public boolean parserError = false;
	    public LineMapping lineMap = null;

	    public void displayRecognitionError(String[] tokenNames,
	                                    RecognitionException e) {
	      // Log that there was an error, otherwise antlr might
	      // recover silently
	      parserError = true;
	      String hdr;
	      /* Use lineMap if available */
	      if (lineMap != null) {
	        FilePosition realPos = lineMap.getFilePosition(e.line);
	        hdr = realPos.file + " l." +
	                    realPos.line + ":" + e.charPositionInLine;

	      } else {
	        hdr = "<preprocessor output> l." +
	                    e.line + ":" + e.charPositionInLine;
	      }
	      String msg = getErrorMessage(e, tokenNames);
	      emitErrorMessage(hdr + " " + msg);
	    }

	    protected Object recoverFromMismatchedToken(IntStream input,
	                                            int ttype,
	                                            BitSet follow)
	    throws RecognitionException {
	        throw new MismatchedTokenException(ttype, input);
	    }


	public static class program_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "program"
	// src/exm/stc/ast/ExM.g:182:1: program : ( stmt )* EOF -> ^( PROGRAM ( stmt )* EOF ) ;
	public final ExMParser.program_return program() throws RecognitionException {
		ExMParser.program_return retval = new ExMParser.program_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token EOF2=null;
		ParserRuleReturnScope stmt1 =null;

		Object EOF2_tree=null;
		RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
		RewriteRuleSubtreeStream stream_stmt=new RewriteRuleSubtreeStream(adaptor,"rule stmt");

		try {
			// src/exm/stc/ast/ExM.g:182:8: ( ( stmt )* EOF -> ^( PROGRAM ( stmt )* EOF ) )
			// src/exm/stc/ast/ExM.g:183:9: ( stmt )* EOF
			{
			// src/exm/stc/ast/ExM.g:183:9: ( stmt )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==APP||LA1_0==ATSIGN||(LA1_0 >= FOR && LA1_0 <= FOREACH)||LA1_0==GLOBAL||LA1_0==ID||LA1_0==IF||LA1_0==IMPORT||LA1_0==ITERATE||(LA1_0 >= LBRACE && LA1_0 <= LPAREN)||LA1_0==LT||LA1_0==PRAGMA||LA1_0==SEMICOLON||LA1_0==STRING||LA1_0==SWITCH||(LA1_0 >= TYPE && LA1_0 <= TYPEDEF)||LA1_0==WAIT) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// src/exm/stc/ast/ExM.g:183:9: stmt
					{
					pushFollow(FOLLOW_stmt_in_program808);
					stmt1=stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_stmt.add(stmt1.getTree());
					}
					break;

				default :
					break loop1;
				}
			}

			EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_program811); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_EOF.add(EOF2);

			// AST REWRITE
			// elements: EOF, stmt
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 183:19: -> ^( PROGRAM ( stmt )* EOF )
			{
				// src/exm/stc/ast/ExM.g:183:22: ^( PROGRAM ( stmt )* EOF )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROGRAM, "PROGRAM"), root_1);
				// src/exm/stc/ast/ExM.g:183:33: ( stmt )*
				while ( stream_stmt.hasNext() ) {
					adaptor.addChild(root_1, stream_stmt.nextTree());
				}
				stream_stmt.reset();

				adaptor.addChild(root_1, stream_EOF.nextNode());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "program"


	public static class stmt_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "stmt"
	// src/exm/stc/ast/ExM.g:186:1: stmt : ( SEMICOLON ->| ( real_stmt ) -> real_stmt );
	public final ExMParser.stmt_return stmt() throws RecognitionException {
		ExMParser.stmt_return retval = new ExMParser.stmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SEMICOLON3=null;
		ParserRuleReturnScope real_stmt4 =null;

		Object SEMICOLON3_tree=null;
		RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
		RewriteRuleSubtreeStream stream_real_stmt=new RewriteRuleSubtreeStream(adaptor,"rule real_stmt");

		try {
			// src/exm/stc/ast/ExM.g:186:5: ( SEMICOLON ->| ( real_stmt ) -> real_stmt )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==SEMICOLON) ) {
				alt2=1;
			}
			else if ( (LA2_0==APP||LA2_0==ATSIGN||(LA2_0 >= FOR && LA2_0 <= FOREACH)||LA2_0==GLOBAL||LA2_0==ID||LA2_0==IF||LA2_0==IMPORT||LA2_0==ITERATE||(LA2_0 >= LBRACE && LA2_0 <= LPAREN)||LA2_0==LT||LA2_0==PRAGMA||LA2_0==STRING||LA2_0==SWITCH||(LA2_0 >= TYPE && LA2_0 <= TYPEDEF)||LA2_0==WAIT) ) {
				alt2=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// src/exm/stc/ast/ExM.g:187:9: SEMICOLON
					{
					SEMICOLON3=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_stmt844); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON3);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 187:19: ->
					{
						root_0 = null;
					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:188:9: ( real_stmt )
					{
					// src/exm/stc/ast/ExM.g:188:9: ( real_stmt )
					// src/exm/stc/ast/ExM.g:188:10: real_stmt
					{
					pushFollow(FOLLOW_real_stmt_in_stmt857);
					real_stmt4=real_stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_real_stmt.add(real_stmt4.getTree());
					}

					// AST REWRITE
					// elements: real_stmt
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 188:21: -> real_stmt
					{
						adaptor.addChild(root_0, stream_real_stmt.nextTree());
					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "stmt"


	public static class real_stmt_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "real_stmt"
	// src/exm/stc/ast/ExM.g:191:1: real_stmt : ( ( function_definition ) | ( new_type_definition ) | ( global_const_definition ) | ( import_statement ) | ( pragma_stmt ) | ( stmt_chain ) | ( if_stmt ) | ( switch_stmt ) | ( block ) | ( foreach_loop ) | ( for_loop ) | ( iterate_loop ) | ( wait_stmt ) | ( update_stmt ) );
	public final ExMParser.real_stmt_return real_stmt() throws RecognitionException {
		ExMParser.real_stmt_return retval = new ExMParser.real_stmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope function_definition5 =null;
		ParserRuleReturnScope new_type_definition6 =null;
		ParserRuleReturnScope global_const_definition7 =null;
		ParserRuleReturnScope import_statement8 =null;
		ParserRuleReturnScope pragma_stmt9 =null;
		ParserRuleReturnScope stmt_chain10 =null;
		ParserRuleReturnScope if_stmt11 =null;
		ParserRuleReturnScope switch_stmt12 =null;
		ParserRuleReturnScope block13 =null;
		ParserRuleReturnScope foreach_loop14 =null;
		ParserRuleReturnScope for_loop15 =null;
		ParserRuleReturnScope iterate_loop16 =null;
		ParserRuleReturnScope wait_stmt17 =null;
		ParserRuleReturnScope update_stmt18 =null;


		try {
			// src/exm/stc/ast/ExM.g:191:10: ( ( function_definition ) | ( new_type_definition ) | ( global_const_definition ) | ( import_statement ) | ( pragma_stmt ) | ( stmt_chain ) | ( if_stmt ) | ( switch_stmt ) | ( block ) | ( foreach_loop ) | ( for_loop ) | ( iterate_loop ) | ( wait_stmt ) | ( update_stmt ) )
			int alt3=14;
			switch ( input.LA(1) ) {
			case ATSIGN:
				{
				int LA3_1 = input.LA(2);
				if ( (synpred3_ExM()) ) {
					alt3=1;
				}
				else if ( (synpred8_ExM()) ) {
					alt3=6;
				}
				else if ( (synpred12_ExM()) ) {
					alt3=10;
				}
				else if ( (synpred13_ExM()) ) {
					alt3=11;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 3, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case APP:
			case LT:
				{
				alt3=1;
				}
				break;
			case ID:
				{
				int LA3_3 = input.LA(2);
				if ( (synpred3_ExM()) ) {
					alt3=1;
				}
				else if ( (synpred8_ExM()) ) {
					alt3=6;
				}
				else if ( (true) ) {
					alt3=14;
				}

				}
				break;
			case LPAREN:
				{
				int LA3_4 = input.LA(2);
				if ( (synpred3_ExM()) ) {
					alt3=1;
				}
				else if ( (synpred8_ExM()) ) {
					alt3=6;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 3, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case TYPE:
			case TYPEDEF:
				{
				alt3=2;
				}
				break;
			case GLOBAL:
				{
				alt3=3;
				}
				break;
			case IMPORT:
				{
				alt3=4;
				}
				break;
			case PRAGMA:
				{
				alt3=5;
				}
				break;
			case IF:
				{
				alt3=7;
				}
				break;
			case SWITCH:
				{
				alt3=8;
				}
				break;
			case LBRACE:
				{
				alt3=9;
				}
				break;
			case FOREACH:
				{
				alt3=10;
				}
				break;
			case FOR:
				{
				alt3=11;
				}
				break;
			case ITERATE:
				{
				alt3=12;
				}
				break;
			case WAIT:
				{
				alt3=13;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// src/exm/stc/ast/ExM.g:192:9: ( function_definition )
					{
					root_0 = (Object)adaptor.nil();


					// src/exm/stc/ast/ExM.g:192:9: ( function_definition )
					// src/exm/stc/ast/ExM.g:192:10: function_definition
					{
					pushFollow(FOLLOW_function_definition_in_real_stmt883);
					function_definition5=function_definition();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, function_definition5.getTree());

					}

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:193:9: ( new_type_definition )
					{
					root_0 = (Object)adaptor.nil();


					// src/exm/stc/ast/ExM.g:193:9: ( new_type_definition )
					// src/exm/stc/ast/ExM.g:193:10: new_type_definition
					{
					pushFollow(FOLLOW_new_type_definition_in_real_stmt895);
					new_type_definition6=new_type_definition();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, new_type_definition6.getTree());

					}

					}
					break;
				case 3 :
					// src/exm/stc/ast/ExM.g:194:9: ( global_const_definition )
					{
					root_0 = (Object)adaptor.nil();


					// src/exm/stc/ast/ExM.g:194:9: ( global_const_definition )
					// src/exm/stc/ast/ExM.g:194:10: global_const_definition
					{
					pushFollow(FOLLOW_global_const_definition_in_real_stmt907);
					global_const_definition7=global_const_definition();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, global_const_definition7.getTree());

					}

					}
					break;
				case 4 :
					// src/exm/stc/ast/ExM.g:195:9: ( import_statement )
					{
					root_0 = (Object)adaptor.nil();


					// src/exm/stc/ast/ExM.g:195:9: ( import_statement )
					// src/exm/stc/ast/ExM.g:195:10: import_statement
					{
					pushFollow(FOLLOW_import_statement_in_real_stmt919);
					import_statement8=import_statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, import_statement8.getTree());

					}

					}
					break;
				case 5 :
					// src/exm/stc/ast/ExM.g:196:9: ( pragma_stmt )
					{
					root_0 = (Object)adaptor.nil();


					// src/exm/stc/ast/ExM.g:196:9: ( pragma_stmt )
					// src/exm/stc/ast/ExM.g:196:10: pragma_stmt
					{
					pushFollow(FOLLOW_pragma_stmt_in_real_stmt931);
					pragma_stmt9=pragma_stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pragma_stmt9.getTree());

					}

					}
					break;
				case 6 :
					// src/exm/stc/ast/ExM.g:197:9: ( stmt_chain )
					{
					root_0 = (Object)adaptor.nil();


					// src/exm/stc/ast/ExM.g:197:9: ( stmt_chain )
					// src/exm/stc/ast/ExM.g:197:10: stmt_chain
					{
					pushFollow(FOLLOW_stmt_chain_in_real_stmt943);
					stmt_chain10=stmt_chain();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, stmt_chain10.getTree());

					}

					}
					break;
				case 7 :
					// src/exm/stc/ast/ExM.g:198:9: ( if_stmt )
					{
					root_0 = (Object)adaptor.nil();


					// src/exm/stc/ast/ExM.g:198:9: ( if_stmt )
					// src/exm/stc/ast/ExM.g:198:10: if_stmt
					{
					pushFollow(FOLLOW_if_stmt_in_real_stmt955);
					if_stmt11=if_stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, if_stmt11.getTree());

					}

					}
					break;
				case 8 :
					// src/exm/stc/ast/ExM.g:199:9: ( switch_stmt )
					{
					root_0 = (Object)adaptor.nil();


					// src/exm/stc/ast/ExM.g:199:9: ( switch_stmt )
					// src/exm/stc/ast/ExM.g:199:10: switch_stmt
					{
					pushFollow(FOLLOW_switch_stmt_in_real_stmt967);
					switch_stmt12=switch_stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, switch_stmt12.getTree());

					}

					}
					break;
				case 9 :
					// src/exm/stc/ast/ExM.g:200:9: ( block )
					{
					root_0 = (Object)adaptor.nil();


					// src/exm/stc/ast/ExM.g:200:9: ( block )
					// src/exm/stc/ast/ExM.g:200:10: block
					{
					pushFollow(FOLLOW_block_in_real_stmt979);
					block13=block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, block13.getTree());

					}

					}
					break;
				case 10 :
					// src/exm/stc/ast/ExM.g:201:9: ( foreach_loop )
					{
					root_0 = (Object)adaptor.nil();


					// src/exm/stc/ast/ExM.g:201:9: ( foreach_loop )
					// src/exm/stc/ast/ExM.g:201:10: foreach_loop
					{
					pushFollow(FOLLOW_foreach_loop_in_real_stmt991);
					foreach_loop14=foreach_loop();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, foreach_loop14.getTree());

					}

					}
					break;
				case 11 :
					// src/exm/stc/ast/ExM.g:202:9: ( for_loop )
					{
					root_0 = (Object)adaptor.nil();


					// src/exm/stc/ast/ExM.g:202:9: ( for_loop )
					// src/exm/stc/ast/ExM.g:202:10: for_loop
					{
					pushFollow(FOLLOW_for_loop_in_real_stmt1003);
					for_loop15=for_loop();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, for_loop15.getTree());

					}

					}
					break;
				case 12 :
					// src/exm/stc/ast/ExM.g:203:9: ( iterate_loop )
					{
					root_0 = (Object)adaptor.nil();


					// src/exm/stc/ast/ExM.g:203:9: ( iterate_loop )
					// src/exm/stc/ast/ExM.g:203:10: iterate_loop
					{
					pushFollow(FOLLOW_iterate_loop_in_real_stmt1015);
					iterate_loop16=iterate_loop();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, iterate_loop16.getTree());

					}

					}
					break;
				case 13 :
					// src/exm/stc/ast/ExM.g:204:9: ( wait_stmt )
					{
					root_0 = (Object)adaptor.nil();


					// src/exm/stc/ast/ExM.g:204:9: ( wait_stmt )
					// src/exm/stc/ast/ExM.g:204:10: wait_stmt
					{
					pushFollow(FOLLOW_wait_stmt_in_real_stmt1027);
					wait_stmt17=wait_stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, wait_stmt17.getTree());

					}

					}
					break;
				case 14 :
					// src/exm/stc/ast/ExM.g:205:9: ( update_stmt )
					{
					root_0 = (Object)adaptor.nil();


					// src/exm/stc/ast/ExM.g:205:9: ( update_stmt )
					// src/exm/stc/ast/ExM.g:205:10: update_stmt
					{
					pushFollow(FOLLOW_update_stmt_in_real_stmt1039);
					update_stmt18=update_stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, update_stmt18.getTree());

					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "real_stmt"


	public static class stmt_chain_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "stmt_chain"
	// src/exm/stc/ast/ExM.g:208:1: stmt_chain : chainable_stmt ( SEMICOLON -> chainable_stmt | stmt_chain_op real_stmt -> ^( STATEMENT_CHAIN chainable_stmt real_stmt ) ) ;
	public final ExMParser.stmt_chain_return stmt_chain() throws RecognitionException {
		ExMParser.stmt_chain_return retval = new ExMParser.stmt_chain_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SEMICOLON20=null;
		ParserRuleReturnScope chainable_stmt19 =null;
		ParserRuleReturnScope stmt_chain_op21 =null;
		ParserRuleReturnScope real_stmt22 =null;

		Object SEMICOLON20_tree=null;
		RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
		RewriteRuleSubtreeStream stream_real_stmt=new RewriteRuleSubtreeStream(adaptor,"rule real_stmt");
		RewriteRuleSubtreeStream stream_stmt_chain_op=new RewriteRuleSubtreeStream(adaptor,"rule stmt_chain_op");
		RewriteRuleSubtreeStream stream_chainable_stmt=new RewriteRuleSubtreeStream(adaptor,"rule chainable_stmt");

		try {
			// src/exm/stc/ast/ExM.g:208:11: ( chainable_stmt ( SEMICOLON -> chainable_stmt | stmt_chain_op real_stmt -> ^( STATEMENT_CHAIN chainable_stmt real_stmt ) ) )
			// src/exm/stc/ast/ExM.g:209:9: chainable_stmt ( SEMICOLON -> chainable_stmt | stmt_chain_op real_stmt -> ^( STATEMENT_CHAIN chainable_stmt real_stmt ) )
			{
			pushFollow(FOLLOW_chainable_stmt_in_stmt_chain1060);
			chainable_stmt19=chainable_stmt();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_chainable_stmt.add(chainable_stmt19.getTree());
			// src/exm/stc/ast/ExM.g:210:11: ( SEMICOLON -> chainable_stmt | stmt_chain_op real_stmt -> ^( STATEMENT_CHAIN chainable_stmt real_stmt ) )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==SEMICOLON) ) {
				alt4=1;
			}
			else if ( (LA4_0==ASSIGN) ) {
				alt4=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// src/exm/stc/ast/ExM.g:210:14: SEMICOLON
					{
					SEMICOLON20=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_stmt_chain1075); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON20);

					// AST REWRITE
					// elements: chainable_stmt
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 211:21: -> chainable_stmt
					{
						adaptor.addChild(root_0, stream_chainable_stmt.nextTree());
					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:212:13: stmt_chain_op real_stmt
					{
					pushFollow(FOLLOW_stmt_chain_op_in_stmt_chain1113);
					stmt_chain_op21=stmt_chain_op();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_stmt_chain_op.add(stmt_chain_op21.getTree());
					pushFollow(FOLLOW_real_stmt_in_stmt_chain1115);
					real_stmt22=real_stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_real_stmt.add(real_stmt22.getTree());
					// AST REWRITE
					// elements: chainable_stmt, real_stmt
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 213:21: -> ^( STATEMENT_CHAIN chainable_stmt real_stmt )
					{
						// src/exm/stc/ast/ExM.g:213:25: ^( STATEMENT_CHAIN chainable_stmt real_stmt )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(STATEMENT_CHAIN, "STATEMENT_CHAIN"), root_1);
						adaptor.addChild(root_1, stream_chainable_stmt.nextTree());
						adaptor.addChild(root_1, stream_real_stmt.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "stmt_chain"


	public static class chainable_stmt_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "chainable_stmt"
	// src/exm/stc/ast/ExM.g:216:1: chainable_stmt : ( ( declaration_multi ) | ( assignment_expr ) | ( expr_stmt ) );
	public final ExMParser.chainable_stmt_return chainable_stmt() throws RecognitionException {
		ExMParser.chainable_stmt_return retval = new ExMParser.chainable_stmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope declaration_multi23 =null;
		ParserRuleReturnScope assignment_expr24 =null;
		ParserRuleReturnScope expr_stmt25 =null;


		try {
			// src/exm/stc/ast/ExM.g:216:15: ( ( declaration_multi ) | ( assignment_expr ) | ( expr_stmt ) )
			int alt5=3;
			switch ( input.LA(1) ) {
			case ID:
				{
				switch ( input.LA(2) ) {
				case ID:
				case LT:
					{
					alt5=1;
					}
					break;
				case APPEND:
				case COMMA:
				case LSQUARE:
				case 150:
					{
					alt5=2;
					}
					break;
				case ASSIGN:
					{
					int LA5_5 = input.LA(3);
					if ( (LA5_5==GT) ) {
						alt5=3;
					}
					else if ( (LA5_5==ATSIGN||(LA5_5 >= DECIMAL && LA5_5 <= DECIMAL_INT)||LA5_5==FALSE||(LA5_5 >= HEX_INT && LA5_5 <= ID)||LA5_5==INFINITY||(LA5_5 >= LBRACE && LA5_5 <= LSQUARE)||LA5_5==MINUS||(LA5_5 >= NOT && LA5_5 <= NOTANUMBER)||LA5_5==OCTAL_INT||LA5_5==SCI_DECIMAL||LA5_5==STRING||(LA5_5 >= STRING_MULTI_LINE_1 && LA5_5 <= STRING_MULTI_LINE_2)||LA5_5==TRUE) ) {
						alt5=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 5, 5, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case LPAREN:
				case SEMICOLON:
					{
					alt5=3;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 5, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
				}
				break;
			case LPAREN:
				{
				alt5=2;
				}
				break;
			case ATSIGN:
				{
				alt5=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}
			switch (alt5) {
				case 1 :
					// src/exm/stc/ast/ExM.g:217:9: ( declaration_multi )
					{
					root_0 = (Object)adaptor.nil();


					// src/exm/stc/ast/ExM.g:217:9: ( declaration_multi )
					// src/exm/stc/ast/ExM.g:217:10: declaration_multi
					{
					pushFollow(FOLLOW_declaration_multi_in_chainable_stmt1170);
					declaration_multi23=declaration_multi();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, declaration_multi23.getTree());

					}

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:218:9: ( assignment_expr )
					{
					root_0 = (Object)adaptor.nil();


					// src/exm/stc/ast/ExM.g:218:9: ( assignment_expr )
					// src/exm/stc/ast/ExM.g:218:10: assignment_expr
					{
					pushFollow(FOLLOW_assignment_expr_in_chainable_stmt1182);
					assignment_expr24=assignment_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, assignment_expr24.getTree());

					}

					}
					break;
				case 3 :
					// src/exm/stc/ast/ExM.g:219:9: ( expr_stmt )
					{
					root_0 = (Object)adaptor.nil();


					// src/exm/stc/ast/ExM.g:219:9: ( expr_stmt )
					// src/exm/stc/ast/ExM.g:219:10: expr_stmt
					{
					pushFollow(FOLLOW_expr_stmt_in_chainable_stmt1194);
					expr_stmt25=expr_stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_stmt25.getTree());

					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "chainable_stmt"


	public static class stmt_chain_op_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "stmt_chain_op"
	// src/exm/stc/ast/ExM.g:222:2: stmt_chain_op : '=' '>' ;
	public final ExMParser.stmt_chain_op_return stmt_chain_op() throws RecognitionException {
		ExMParser.stmt_chain_op_return retval = new ExMParser.stmt_chain_op_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal26=null;
		Token char_literal27=null;

		Object char_literal26_tree=null;
		Object char_literal27_tree=null;

		try {
			// src/exm/stc/ast/ExM.g:222:15: ( '=' '>' )
			// src/exm/stc/ast/ExM.g:223:9: '=' '>'
			{
			root_0 = (Object)adaptor.nil();


			char_literal26=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_stmt_chain_op1216); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal26_tree = (Object)adaptor.create(char_literal26);
			adaptor.addChild(root_0, char_literal26_tree);
			}

			char_literal27=(Token)match(input,GT,FOLLOW_GT_in_stmt_chain_op1218); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal27_tree = (Object)adaptor.create(char_literal27);
			adaptor.addChild(root_0, char_literal27_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "stmt_chain_op"


	public static class new_type_definition_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "new_type_definition"
	// src/exm/stc/ast/ExM.g:226:1: new_type_definition : ( TYPE tname= ID LBRACE ( type_field )* RBRACE -> ^( DEFINE_NEW_STRUCT_TYPE $tname ( type_field )* ) | TYPE tname= ID SEMICOLON -> ^( DEFINE_NEW_TYPE $tname) | TYPE tname= ID baset= standalone_type SEMICOLON -> ^( DEFINE_NEW_TYPE $tname $baset) | TYPEDEF tname= ID baset= standalone_type SEMICOLON -> ^( TYPEDEF $tname $baset) );
	public final ExMParser.new_type_definition_return new_type_definition() throws RecognitionException {
		ExMParser.new_type_definition_return retval = new ExMParser.new_type_definition_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token tname=null;
		Token TYPE28=null;
		Token LBRACE29=null;
		Token RBRACE31=null;
		Token TYPE32=null;
		Token SEMICOLON33=null;
		Token TYPE34=null;
		Token SEMICOLON35=null;
		Token TYPEDEF36=null;
		Token SEMICOLON37=null;
		ParserRuleReturnScope baset =null;
		ParserRuleReturnScope type_field30 =null;

		Object tname_tree=null;
		Object TYPE28_tree=null;
		Object LBRACE29_tree=null;
		Object RBRACE31_tree=null;
		Object TYPE32_tree=null;
		Object SEMICOLON33_tree=null;
		Object TYPE34_tree=null;
		Object SEMICOLON35_tree=null;
		Object TYPEDEF36_tree=null;
		Object SEMICOLON37_tree=null;
		RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
		RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
		RewriteRuleTokenStream stream_TYPEDEF=new RewriteRuleTokenStream(adaptor,"token TYPEDEF");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_TYPE=new RewriteRuleTokenStream(adaptor,"token TYPE");
		RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
		RewriteRuleSubtreeStream stream_type_field=new RewriteRuleSubtreeStream(adaptor,"rule type_field");
		RewriteRuleSubtreeStream stream_standalone_type=new RewriteRuleSubtreeStream(adaptor,"rule standalone_type");

		try {
			// src/exm/stc/ast/ExM.g:226:20: ( TYPE tname= ID LBRACE ( type_field )* RBRACE -> ^( DEFINE_NEW_STRUCT_TYPE $tname ( type_field )* ) | TYPE tname= ID SEMICOLON -> ^( DEFINE_NEW_TYPE $tname) | TYPE tname= ID baset= standalone_type SEMICOLON -> ^( DEFINE_NEW_TYPE $tname $baset) | TYPEDEF tname= ID baset= standalone_type SEMICOLON -> ^( TYPEDEF $tname $baset) )
			int alt7=4;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==TYPE) ) {
				int LA7_1 = input.LA(2);
				if ( (LA7_1==ID) ) {
					switch ( input.LA(3) ) {
					case LBRACE:
						{
						alt7=1;
						}
						break;
					case SEMICOLON:
						{
						alt7=2;
						}
						break;
					case ID:
						{
						alt7=3;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 7, 3, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 7, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA7_0==TYPEDEF) ) {
				alt7=4;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// src/exm/stc/ast/ExM.g:227:9: TYPE tname= ID LBRACE ( type_field )* RBRACE
					{
					TYPE28=(Token)match(input,TYPE,FOLLOW_TYPE_in_new_type_definition1238); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_TYPE.add(TYPE28);

					tname=(Token)match(input,ID,FOLLOW_ID_in_new_type_definition1242); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ID.add(tname);

					LBRACE29=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_new_type_definition1244); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE29);

					// src/exm/stc/ast/ExM.g:227:30: ( type_field )*
					loop6:
					while (true) {
						int alt6=2;
						int LA6_0 = input.LA(1);
						if ( (LA6_0==ID) ) {
							alt6=1;
						}

						switch (alt6) {
						case 1 :
							// src/exm/stc/ast/ExM.g:227:30: type_field
							{
							pushFollow(FOLLOW_type_field_in_new_type_definition1246);
							type_field30=type_field();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_type_field.add(type_field30.getTree());
							}
							break;

						default :
							break loop6;
						}
					}

					RBRACE31=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_new_type_definition1249); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE31);

					// AST REWRITE
					// elements: tname, type_field
					// token labels: tname
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleTokenStream stream_tname=new RewriteRuleTokenStream(adaptor,"token tname",tname);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 227:49: -> ^( DEFINE_NEW_STRUCT_TYPE $tname ( type_field )* )
					{
						// src/exm/stc/ast/ExM.g:228:13: ^( DEFINE_NEW_STRUCT_TYPE $tname ( type_field )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DEFINE_NEW_STRUCT_TYPE, "DEFINE_NEW_STRUCT_TYPE"), root_1);
						adaptor.addChild(root_1, stream_tname.nextNode());
						// src/exm/stc/ast/ExM.g:228:46: ( type_field )*
						while ( stream_type_field.hasNext() ) {
							adaptor.addChild(root_1, stream_type_field.nextTree());
						}
						stream_type_field.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:229:9: TYPE tname= ID SEMICOLON
					{
					TYPE32=(Token)match(input,TYPE,FOLLOW_TYPE_in_new_type_definition1284); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_TYPE.add(TYPE32);

					tname=(Token)match(input,ID,FOLLOW_ID_in_new_type_definition1288); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ID.add(tname);

					SEMICOLON33=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_new_type_definition1290); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON33);

					// AST REWRITE
					// elements: tname
					// token labels: tname
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleTokenStream stream_tname=new RewriteRuleTokenStream(adaptor,"token tname",tname);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 229:33: -> ^( DEFINE_NEW_TYPE $tname)
					{
						// src/exm/stc/ast/ExM.g:230:13: ^( DEFINE_NEW_TYPE $tname)
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DEFINE_NEW_TYPE, "DEFINE_NEW_TYPE"), root_1);
						adaptor.addChild(root_1, stream_tname.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// src/exm/stc/ast/ExM.g:231:9: TYPE tname= ID baset= standalone_type SEMICOLON
					{
					TYPE34=(Token)match(input,TYPE,FOLLOW_TYPE_in_new_type_definition1323); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_TYPE.add(TYPE34);

					tname=(Token)match(input,ID,FOLLOW_ID_in_new_type_definition1327); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ID.add(tname);

					pushFollow(FOLLOW_standalone_type_in_new_type_definition1331);
					baset=standalone_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_standalone_type.add(baset.getTree());
					SEMICOLON35=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_new_type_definition1333); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON35);

					// AST REWRITE
					// elements: tname, baset
					// token labels: tname
					// rule labels: baset, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleTokenStream stream_tname=new RewriteRuleTokenStream(adaptor,"token tname",tname);
					RewriteRuleSubtreeStream stream_baset=new RewriteRuleSubtreeStream(adaptor,"rule baset",baset!=null?baset.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 231:55: -> ^( DEFINE_NEW_TYPE $tname $baset)
					{
						// src/exm/stc/ast/ExM.g:232:13: ^( DEFINE_NEW_TYPE $tname $baset)
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DEFINE_NEW_TYPE, "DEFINE_NEW_TYPE"), root_1);
						adaptor.addChild(root_1, stream_tname.nextNode());
						adaptor.addChild(root_1, stream_baset.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// src/exm/stc/ast/ExM.g:233:9: TYPEDEF tname= ID baset= standalone_type SEMICOLON
					{
					TYPEDEF36=(Token)match(input,TYPEDEF,FOLLOW_TYPEDEF_in_new_type_definition1369); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_TYPEDEF.add(TYPEDEF36);

					tname=(Token)match(input,ID,FOLLOW_ID_in_new_type_definition1373); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ID.add(tname);

					pushFollow(FOLLOW_standalone_type_in_new_type_definition1377);
					baset=standalone_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_standalone_type.add(baset.getTree());
					SEMICOLON37=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_new_type_definition1379); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON37);

					// AST REWRITE
					// elements: tname, baset, TYPEDEF
					// token labels: tname
					// rule labels: baset, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleTokenStream stream_tname=new RewriteRuleTokenStream(adaptor,"token tname",tname);
					RewriteRuleSubtreeStream stream_baset=new RewriteRuleSubtreeStream(adaptor,"rule baset",baset!=null?baset.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 233:58: -> ^( TYPEDEF $tname $baset)
					{
						// src/exm/stc/ast/ExM.g:234:13: ^( TYPEDEF $tname $baset)
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot(stream_TYPEDEF.nextNode(), root_1);
						adaptor.addChild(root_1, stream_tname.nextNode());
						adaptor.addChild(root_1, stream_baset.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "new_type_definition"


	public static class import_statement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "import_statement"
	// src/exm/stc/ast/ExM.g:238:1: import_statement : IMPORT ( import_path -> ^( IMPORT import_path ) | STRING -> ^( IMPORT STRING ) ) SEMICOLON ;
	public final ExMParser.import_statement_return import_statement() throws RecognitionException {
		ExMParser.import_statement_return retval = new ExMParser.import_statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token IMPORT38=null;
		Token STRING40=null;
		Token SEMICOLON41=null;
		ParserRuleReturnScope import_path39 =null;

		Object IMPORT38_tree=null;
		Object STRING40_tree=null;
		Object SEMICOLON41_tree=null;
		RewriteRuleTokenStream stream_IMPORT=new RewriteRuleTokenStream(adaptor,"token IMPORT");
		RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
		RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
		RewriteRuleSubtreeStream stream_import_path=new RewriteRuleSubtreeStream(adaptor,"rule import_path");

		try {
			// src/exm/stc/ast/ExM.g:238:17: ( IMPORT ( import_path -> ^( IMPORT import_path ) | STRING -> ^( IMPORT STRING ) ) SEMICOLON )
			// src/exm/stc/ast/ExM.g:239:9: IMPORT ( import_path -> ^( IMPORT import_path ) | STRING -> ^( IMPORT STRING ) ) SEMICOLON
			{
			IMPORT38=(Token)match(input,IMPORT,FOLLOW_IMPORT_in_import_statement1426); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IMPORT.add(IMPORT38);

			// src/exm/stc/ast/ExM.g:239:16: ( import_path -> ^( IMPORT import_path ) | STRING -> ^( IMPORT STRING ) )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==ID) ) {
				alt8=1;
			}
			else if ( (LA8_0==STRING) ) {
				alt8=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// src/exm/stc/ast/ExM.g:240:13: import_path
					{
					pushFollow(FOLLOW_import_path_in_import_statement1442);
					import_path39=import_path();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_import_path.add(import_path39.getTree());
					// AST REWRITE
					// elements: import_path, IMPORT
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 240:25: -> ^( IMPORT import_path )
					{
						// src/exm/stc/ast/ExM.g:240:28: ^( IMPORT import_path )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot(stream_IMPORT.nextNode(), root_1);
						adaptor.addChild(root_1, stream_import_path.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:241:13: STRING
					{
					STRING40=(Token)match(input,STRING,FOLLOW_STRING_in_import_statement1468); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_STRING.add(STRING40);

					// AST REWRITE
					// elements: STRING, IMPORT
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 241:20: -> ^( IMPORT STRING )
					{
						// src/exm/stc/ast/ExM.g:241:23: ^( IMPORT STRING )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot(stream_IMPORT.nextNode(), root_1);
						adaptor.addChild(root_1, stream_STRING.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}

			SEMICOLON41=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_import_statement1482); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON41);

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "import_statement"


	public static class import_path_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "import_path"
	// src/exm/stc/ast/ExM.g:245:1: import_path : m= module_name ( module_subscript )* -> ^( IMPORT_PATH $m ( module_subscript )* ) ;
	public final ExMParser.import_path_return import_path() throws RecognitionException {
		ExMParser.import_path_return retval = new ExMParser.import_path_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope m =null;
		ParserRuleReturnScope module_subscript42 =null;

		RewriteRuleSubtreeStream stream_module_subscript=new RewriteRuleSubtreeStream(adaptor,"rule module_subscript");
		RewriteRuleSubtreeStream stream_module_name=new RewriteRuleSubtreeStream(adaptor,"rule module_name");

		try {
			// src/exm/stc/ast/ExM.g:245:12: (m= module_name ( module_subscript )* -> ^( IMPORT_PATH $m ( module_subscript )* ) )
			// src/exm/stc/ast/ExM.g:246:9: m= module_name ( module_subscript )*
			{
			pushFollow(FOLLOW_module_name_in_import_path1505);
			m=module_name();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_module_name.add(m.getTree());
			// src/exm/stc/ast/ExM.g:246:23: ( module_subscript )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==150) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// src/exm/stc/ast/ExM.g:246:23: module_subscript
					{
					pushFollow(FOLLOW_module_subscript_in_import_path1507);
					module_subscript42=module_subscript();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_module_subscript.add(module_subscript42.getTree());
					}
					break;

				default :
					break loop9;
				}
			}

			// AST REWRITE
			// elements: module_subscript, m
			// token labels: 
			// rule labels: m, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_m=new RewriteRuleSubtreeStream(adaptor,"rule m",m!=null?m.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 247:10: -> ^( IMPORT_PATH $m ( module_subscript )* )
			{
				// src/exm/stc/ast/ExM.g:247:13: ^( IMPORT_PATH $m ( module_subscript )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IMPORT_PATH, "IMPORT_PATH"), root_1);
				adaptor.addChild(root_1, stream_m.nextTree());
				// src/exm/stc/ast/ExM.g:247:31: ( module_subscript )*
				while ( stream_module_subscript.hasNext() ) {
					adaptor.addChild(root_1, stream_module_subscript.nextTree());
				}
				stream_module_subscript.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "import_path"


	public static class module_name_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "module_name"
	// src/exm/stc/ast/ExM.g:250:1: module_name : ID ;
	public final ExMParser.module_name_return module_name() throws RecognitionException {
		ExMParser.module_name_return retval = new ExMParser.module_name_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID43=null;

		Object ID43_tree=null;

		try {
			// src/exm/stc/ast/ExM.g:250:12: ( ID )
			// src/exm/stc/ast/ExM.g:250:14: ID
			{
			root_0 = (Object)adaptor.nil();


			ID43=(Token)match(input,ID,FOLLOW_ID_in_module_name1543); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID43_tree = (Object)adaptor.create(ID43);
			adaptor.addChild(root_0, ID43_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "module_name"


	public static class module_subscript_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "module_subscript"
	// src/exm/stc/ast/ExM.g:252:1: module_subscript : '.' module_name -> module_name ;
	public final ExMParser.module_subscript_return module_subscript() throws RecognitionException {
		ExMParser.module_subscript_return retval = new ExMParser.module_subscript_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal44=null;
		ParserRuleReturnScope module_name45 =null;

		Object char_literal44_tree=null;
		RewriteRuleTokenStream stream_150=new RewriteRuleTokenStream(adaptor,"token 150");
		RewriteRuleSubtreeStream stream_module_name=new RewriteRuleSubtreeStream(adaptor,"rule module_name");

		try {
			// src/exm/stc/ast/ExM.g:252:17: ( '.' module_name -> module_name )
			// src/exm/stc/ast/ExM.g:253:9: '.' module_name
			{
			char_literal44=(Token)match(input,150,FOLLOW_150_in_module_subscript1558); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_150.add(char_literal44);

			pushFollow(FOLLOW_module_name_in_module_subscript1560);
			module_name45=module_name();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_module_name.add(module_name45.getTree());
			// AST REWRITE
			// elements: module_name
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 253:25: -> module_name
			{
				adaptor.addChild(root_0, stream_module_name.nextTree());
			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "module_subscript"


	public static class pragma_stmt_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "pragma_stmt"
	// src/exm/stc/ast/ExM.g:256:1: pragma_stmt : PRAGMA ID ( expr )* SEMICOLON -> ^( PRAGMA ID ( expr )* ) ;
	public final ExMParser.pragma_stmt_return pragma_stmt() throws RecognitionException {
		ExMParser.pragma_stmt_return retval = new ExMParser.pragma_stmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token PRAGMA46=null;
		Token ID47=null;
		Token SEMICOLON49=null;
		ParserRuleReturnScope expr48 =null;

		Object PRAGMA46_tree=null;
		Object ID47_tree=null;
		Object SEMICOLON49_tree=null;
		RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
		RewriteRuleTokenStream stream_PRAGMA=new RewriteRuleTokenStream(adaptor,"token PRAGMA");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// src/exm/stc/ast/ExM.g:256:12: ( PRAGMA ID ( expr )* SEMICOLON -> ^( PRAGMA ID ( expr )* ) )
			// src/exm/stc/ast/ExM.g:257:9: PRAGMA ID ( expr )* SEMICOLON
			{
			PRAGMA46=(Token)match(input,PRAGMA,FOLLOW_PRAGMA_in_pragma_stmt1584); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_PRAGMA.add(PRAGMA46);

			ID47=(Token)match(input,ID,FOLLOW_ID_in_pragma_stmt1586); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ID.add(ID47);

			// src/exm/stc/ast/ExM.g:257:19: ( expr )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==ATSIGN||(LA10_0 >= DECIMAL && LA10_0 <= DECIMAL_INT)||LA10_0==FALSE||(LA10_0 >= HEX_INT && LA10_0 <= ID)||LA10_0==INFINITY||(LA10_0 >= LBRACE && LA10_0 <= LSQUARE)||LA10_0==MINUS||(LA10_0 >= NOT && LA10_0 <= NOTANUMBER)||LA10_0==OCTAL_INT||LA10_0==SCI_DECIMAL||LA10_0==STRING||(LA10_0 >= STRING_MULTI_LINE_1 && LA10_0 <= STRING_MULTI_LINE_2)||LA10_0==TRUE) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// src/exm/stc/ast/ExM.g:257:19: expr
					{
					pushFollow(FOLLOW_expr_in_pragma_stmt1588);
					expr48=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr48.getTree());
					}
					break;

				default :
					break loop10;
				}
			}

			SEMICOLON49=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pragma_stmt1591); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON49);

			// AST REWRITE
			// elements: ID, PRAGMA, expr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 257:35: -> ^( PRAGMA ID ( expr )* )
			{
				// src/exm/stc/ast/ExM.g:258:13: ^( PRAGMA ID ( expr )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot(stream_PRAGMA.nextNode(), root_1);
				adaptor.addChild(root_1, stream_ID.nextNode());
				// src/exm/stc/ast/ExM.g:258:26: ( expr )*
				while ( stream_expr.hasNext() ) {
					adaptor.addChild(root_1, stream_expr.nextTree());
				}
				stream_expr.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "pragma_stmt"


	public static class type_field_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "type_field"
	// src/exm/stc/ast/ExM.g:261:1: type_field : type= type_prefix name= var_name ( array_marker )* SEMICOLON -> ^( STRUCT_FIELD_DEF $type $name ( array_marker )* ) ;
	public final ExMParser.type_field_return type_field() throws RecognitionException {
		ExMParser.type_field_return retval = new ExMParser.type_field_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SEMICOLON51=null;
		ParserRuleReturnScope type =null;
		ParserRuleReturnScope name =null;
		ParserRuleReturnScope array_marker50 =null;

		Object SEMICOLON51_tree=null;
		RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
		RewriteRuleSubtreeStream stream_type_prefix=new RewriteRuleSubtreeStream(adaptor,"rule type_prefix");
		RewriteRuleSubtreeStream stream_array_marker=new RewriteRuleSubtreeStream(adaptor,"rule array_marker");
		RewriteRuleSubtreeStream stream_var_name=new RewriteRuleSubtreeStream(adaptor,"rule var_name");

		try {
			// src/exm/stc/ast/ExM.g:261:11: (type= type_prefix name= var_name ( array_marker )* SEMICOLON -> ^( STRUCT_FIELD_DEF $type $name ( array_marker )* ) )
			// src/exm/stc/ast/ExM.g:262:9: type= type_prefix name= var_name ( array_marker )* SEMICOLON
			{
			pushFollow(FOLLOW_type_prefix_in_type_field1638);
			type=type_prefix();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_type_prefix.add(type.getTree());
			pushFollow(FOLLOW_var_name_in_type_field1642);
			name=var_name();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_var_name.add(name.getTree());
			// src/exm/stc/ast/ExM.g:262:40: ( array_marker )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==LSQUARE) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// src/exm/stc/ast/ExM.g:262:40: array_marker
					{
					pushFollow(FOLLOW_array_marker_in_type_field1644);
					array_marker50=array_marker();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_array_marker.add(array_marker50.getTree());
					}
					break;

				default :
					break loop11;
				}
			}

			SEMICOLON51=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_type_field1647); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON51);

			// AST REWRITE
			// elements: array_marker, type, name
			// token labels: 
			// rule labels: name, type, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_name=new RewriteRuleSubtreeStream(adaptor,"rule name",name!=null?name.getTree():null);
			RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type",type!=null?type.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 262:64: -> ^( STRUCT_FIELD_DEF $type $name ( array_marker )* )
			{
				// src/exm/stc/ast/ExM.g:263:13: ^( STRUCT_FIELD_DEF $type $name ( array_marker )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(STRUCT_FIELD_DEF, "STRUCT_FIELD_DEF"), root_1);
				adaptor.addChild(root_1, stream_type.nextTree());
				adaptor.addChild(root_1, stream_name.nextTree());
				// src/exm/stc/ast/ExM.g:263:45: ( array_marker )*
				while ( stream_array_marker.hasNext() ) {
					adaptor.addChild(root_1, stream_array_marker.nextTree());
				}
				stream_array_marker.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "type_field"


	public static class function_definition_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "function_definition"
	// src/exm/stc/ast/ExM.g:267:1: function_definition : ( annotation )* ( APP o= formal_argument_list f= func_name i= formal_argument_list LBRACE app_body ( SEMICOLON )? RBRACE -> ^( DEFINE_APP_FUNCTION $f $o $i app_body ( annotation )* ) |tp= type_parameters o= formal_argument_list f= func_name i= formal_argument_list (b= block -> ^( DEFINE_FUNCTION $f $tp $o $i $b ( annotation )* ) | tcl_body SEMICOLON -> ^( DEFINE_BUILTIN_FUNCTION $f $tp $o $i tcl_body ( annotation )* ) ) ) ;
	public final ExMParser.function_definition_return function_definition() throws RecognitionException {
		ExMParser.function_definition_return retval = new ExMParser.function_definition_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token APP53=null;
		Token LBRACE54=null;
		Token SEMICOLON56=null;
		Token RBRACE57=null;
		Token SEMICOLON59=null;
		ParserRuleReturnScope o =null;
		ParserRuleReturnScope f =null;
		ParserRuleReturnScope i =null;
		ParserRuleReturnScope tp =null;
		ParserRuleReturnScope b =null;
		ParserRuleReturnScope annotation52 =null;
		ParserRuleReturnScope app_body55 =null;
		ParserRuleReturnScope tcl_body58 =null;

		Object APP53_tree=null;
		Object LBRACE54_tree=null;
		Object SEMICOLON56_tree=null;
		Object RBRACE57_tree=null;
		Object SEMICOLON59_tree=null;
		RewriteRuleTokenStream stream_APP=new RewriteRuleTokenStream(adaptor,"token APP");
		RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
		RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
		RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
		RewriteRuleSubtreeStream stream_annotation=new RewriteRuleSubtreeStream(adaptor,"rule annotation");
		RewriteRuleSubtreeStream stream_type_parameters=new RewriteRuleSubtreeStream(adaptor,"rule type_parameters");
		RewriteRuleSubtreeStream stream_tcl_body=new RewriteRuleSubtreeStream(adaptor,"rule tcl_body");
		RewriteRuleSubtreeStream stream_app_body=new RewriteRuleSubtreeStream(adaptor,"rule app_body");
		RewriteRuleSubtreeStream stream_formal_argument_list=new RewriteRuleSubtreeStream(adaptor,"rule formal_argument_list");
		RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
		RewriteRuleSubtreeStream stream_func_name=new RewriteRuleSubtreeStream(adaptor,"rule func_name");

		try {
			// src/exm/stc/ast/ExM.g:267:20: ( ( annotation )* ( APP o= formal_argument_list f= func_name i= formal_argument_list LBRACE app_body ( SEMICOLON )? RBRACE -> ^( DEFINE_APP_FUNCTION $f $o $i app_body ( annotation )* ) |tp= type_parameters o= formal_argument_list f= func_name i= formal_argument_list (b= block -> ^( DEFINE_FUNCTION $f $tp $o $i $b ( annotation )* ) | tcl_body SEMICOLON -> ^( DEFINE_BUILTIN_FUNCTION $f $tp $o $i tcl_body ( annotation )* ) ) ) )
			// src/exm/stc/ast/ExM.g:268:2: ( annotation )* ( APP o= formal_argument_list f= func_name i= formal_argument_list LBRACE app_body ( SEMICOLON )? RBRACE -> ^( DEFINE_APP_FUNCTION $f $o $i app_body ( annotation )* ) |tp= type_parameters o= formal_argument_list f= func_name i= formal_argument_list (b= block -> ^( DEFINE_FUNCTION $f $tp $o $i $b ( annotation )* ) | tcl_body SEMICOLON -> ^( DEFINE_BUILTIN_FUNCTION $f $tp $o $i tcl_body ( annotation )* ) ) )
			{
			// src/exm/stc/ast/ExM.g:268:2: ( annotation )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==ATSIGN) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// src/exm/stc/ast/ExM.g:268:2: annotation
					{
					pushFollow(FOLLOW_annotation_in_function_definition1690);
					annotation52=annotation();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_annotation.add(annotation52.getTree());
					}
					break;

				default :
					break loop12;
				}
			}

			// src/exm/stc/ast/ExM.g:268:14: ( APP o= formal_argument_list f= func_name i= formal_argument_list LBRACE app_body ( SEMICOLON )? RBRACE -> ^( DEFINE_APP_FUNCTION $f $o $i app_body ( annotation )* ) |tp= type_parameters o= formal_argument_list f= func_name i= formal_argument_list (b= block -> ^( DEFINE_FUNCTION $f $tp $o $i $b ( annotation )* ) | tcl_body SEMICOLON -> ^( DEFINE_BUILTIN_FUNCTION $f $tp $o $i tcl_body ( annotation )* ) ) )
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==APP) ) {
				alt15=1;
			}
			else if ( (LA15_0==ID||(LA15_0 >= LBRACE && LA15_0 <= LPAREN)||LA15_0==LT||LA15_0==STRING) ) {
				alt15=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}

			switch (alt15) {
				case 1 :
					// src/exm/stc/ast/ExM.g:270:3: APP o= formal_argument_list f= func_name i= formal_argument_list LBRACE app_body ( SEMICOLON )? RBRACE
					{
					APP53=(Token)match(input,APP,FOLLOW_APP_in_function_definition1700); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_APP.add(APP53);

					pushFollow(FOLLOW_formal_argument_list_in_function_definition1704);
					o=formal_argument_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_formal_argument_list.add(o.getTree());
					pushFollow(FOLLOW_func_name_in_function_definition1708);
					f=func_name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_func_name.add(f.getTree());
					pushFollow(FOLLOW_formal_argument_list_in_function_definition1712);
					i=formal_argument_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_formal_argument_list.add(i.getTree());
					LBRACE54=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_function_definition1723); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE54);

					pushFollow(FOLLOW_app_body_in_function_definition1725);
					app_body55=app_body();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_app_body.add(app_body55.getTree());
					// src/exm/stc/ast/ExM.g:271:26: ( SEMICOLON )?
					int alt13=2;
					int LA13_0 = input.LA(1);
					if ( (LA13_0==SEMICOLON) ) {
						alt13=1;
					}
					switch (alt13) {
						case 1 :
							// src/exm/stc/ast/ExM.g:271:26: SEMICOLON
							{
							SEMICOLON56=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_function_definition1727); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON56);

							}
							break;

					}

					RBRACE57=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_function_definition1730); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE57);

					// AST REWRITE
					// elements: o, app_body, f, i, annotation
					// token labels: 
					// rule labels: f, i, retval, o
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_f=new RewriteRuleSubtreeStream(adaptor,"rule f",f!=null?f.getTree():null);
					RewriteRuleSubtreeStream stream_i=new RewriteRuleSubtreeStream(adaptor,"rule i",i!=null?i.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);
					RewriteRuleSubtreeStream stream_o=new RewriteRuleSubtreeStream(adaptor,"rule o",o!=null?o.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 271:44: -> ^( DEFINE_APP_FUNCTION $f $o $i app_body ( annotation )* )
					{
						// src/exm/stc/ast/ExM.g:272:10: ^( DEFINE_APP_FUNCTION $f $o $i app_body ( annotation )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DEFINE_APP_FUNCTION, "DEFINE_APP_FUNCTION"), root_1);
						adaptor.addChild(root_1, stream_f.nextTree());
						adaptor.addChild(root_1, stream_o.nextTree());
						adaptor.addChild(root_1, stream_i.nextTree());
						adaptor.addChild(root_1, stream_app_body.nextTree());
						// src/exm/stc/ast/ExM.g:272:51: ( annotation )*
						while ( stream_annotation.hasNext() ) {
							adaptor.addChild(root_1, stream_annotation.nextTree());
						}
						stream_annotation.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:273:9: tp= type_parameters o= formal_argument_list f= func_name i= formal_argument_list (b= block -> ^( DEFINE_FUNCTION $f $tp $o $i $b ( annotation )* ) | tcl_body SEMICOLON -> ^( DEFINE_BUILTIN_FUNCTION $f $tp $o $i tcl_body ( annotation )* ) )
					{
					pushFollow(FOLLOW_type_parameters_in_function_definition1773);
					tp=type_parameters();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_type_parameters.add(tp.getTree());
					pushFollow(FOLLOW_formal_argument_list_in_function_definition1777);
					o=formal_argument_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_formal_argument_list.add(o.getTree());
					pushFollow(FOLLOW_func_name_in_function_definition1781);
					f=func_name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_func_name.add(f.getTree());
					pushFollow(FOLLOW_formal_argument_list_in_function_definition1785);
					i=formal_argument_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_formal_argument_list.add(i.getTree());
					// src/exm/stc/ast/ExM.g:273:86: (b= block -> ^( DEFINE_FUNCTION $f $tp $o $i $b ( annotation )* ) | tcl_body SEMICOLON -> ^( DEFINE_BUILTIN_FUNCTION $f $tp $o $i tcl_body ( annotation )* ) )
					int alt14=2;
					int LA14_0 = input.LA(1);
					if ( (LA14_0==LBRACE) ) {
						alt14=1;
					}
					else if ( (LA14_0==STRING) ) {
						alt14=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 14, 0, input);
						throw nvae;
					}

					switch (alt14) {
						case 1 :
							// src/exm/stc/ast/ExM.g:275:10: b= block
							{
							pushFollow(FOLLOW_block_in_function_definition1807);
							b=block();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_block.add(b.getTree());
							// AST REWRITE
							// elements: i, annotation, f, tp, o, b
							// token labels: 
							// rule labels: b, f, i, tp, retval, o
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							if ( state.backtracking==0 ) {
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.getTree():null);
							RewriteRuleSubtreeStream stream_f=new RewriteRuleSubtreeStream(adaptor,"rule f",f!=null?f.getTree():null);
							RewriteRuleSubtreeStream stream_i=new RewriteRuleSubtreeStream(adaptor,"rule i",i!=null?i.getTree():null);
							RewriteRuleSubtreeStream stream_tp=new RewriteRuleSubtreeStream(adaptor,"rule tp",tp!=null?tp.getTree():null);
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);
							RewriteRuleSubtreeStream stream_o=new RewriteRuleSubtreeStream(adaptor,"rule o",o!=null?o.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 275:18: -> ^( DEFINE_FUNCTION $f $tp $o $i $b ( annotation )* )
							{
								// src/exm/stc/ast/ExM.g:276:11: ^( DEFINE_FUNCTION $f $tp $o $i $b ( annotation )* )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DEFINE_FUNCTION, "DEFINE_FUNCTION"), root_1);
								adaptor.addChild(root_1, stream_f.nextTree());
								adaptor.addChild(root_1, stream_tp.nextTree());
								adaptor.addChild(root_1, stream_o.nextTree());
								adaptor.addChild(root_1, stream_i.nextTree());
								adaptor.addChild(root_1, stream_b.nextTree());
								// src/exm/stc/ast/ExM.g:276:46: ( annotation )*
								while ( stream_annotation.hasNext() ) {
									adaptor.addChild(root_1, stream_annotation.nextTree());
								}
								stream_annotation.reset();

								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;
							}

							}
							break;
						case 2 :
							// src/exm/stc/ast/ExM.g:278:10: tcl_body SEMICOLON
							{
							pushFollow(FOLLOW_tcl_body_in_function_definition1867);
							tcl_body58=tcl_body();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_tcl_body.add(tcl_body58.getTree());
							SEMICOLON59=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_function_definition1869); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON59);

							// AST REWRITE
							// elements: f, o, tp, i, annotation, tcl_body
							// token labels: 
							// rule labels: f, i, tp, retval, o
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							if ( state.backtracking==0 ) {
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_f=new RewriteRuleSubtreeStream(adaptor,"rule f",f!=null?f.getTree():null);
							RewriteRuleSubtreeStream stream_i=new RewriteRuleSubtreeStream(adaptor,"rule i",i!=null?i.getTree():null);
							RewriteRuleSubtreeStream stream_tp=new RewriteRuleSubtreeStream(adaptor,"rule tp",tp!=null?tp.getTree():null);
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);
							RewriteRuleSubtreeStream stream_o=new RewriteRuleSubtreeStream(adaptor,"rule o",o!=null?o.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 278:29: -> ^( DEFINE_BUILTIN_FUNCTION $f $tp $o $i tcl_body ( annotation )* )
							{
								// src/exm/stc/ast/ExM.g:279:11: ^( DEFINE_BUILTIN_FUNCTION $f $tp $o $i tcl_body ( annotation )* )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DEFINE_BUILTIN_FUNCTION, "DEFINE_BUILTIN_FUNCTION"), root_1);
								adaptor.addChild(root_1, stream_f.nextTree());
								adaptor.addChild(root_1, stream_tp.nextTree());
								adaptor.addChild(root_1, stream_o.nextTree());
								adaptor.addChild(root_1, stream_i.nextTree());
								adaptor.addChild(root_1, stream_tcl_body.nextTree());
								// src/exm/stc/ast/ExM.g:279:60: ( annotation )*
								while ( stream_annotation.hasNext() ) {
									adaptor.addChild(root_1, stream_annotation.nextTree());
								}
								stream_annotation.reset();

								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;
							}

							}
							break;

					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "function_definition"


	public static class func_name_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "func_name"
	// src/exm/stc/ast/ExM.g:283:1: func_name : ID ;
	public final ExMParser.func_name_return func_name() throws RecognitionException {
		ExMParser.func_name_return retval = new ExMParser.func_name_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID60=null;

		Object ID60_tree=null;

		try {
			// src/exm/stc/ast/ExM.g:283:10: ( ID )
			// src/exm/stc/ast/ExM.g:283:12: ID
			{
			root_0 = (Object)adaptor.nil();


			ID60=(Token)match(input,ID,FOLLOW_ID_in_func_name1927); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID60_tree = (Object)adaptor.create(ID60);
			adaptor.addChild(root_0, ID60_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "func_name"


	public static class app_body_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "app_body"
	// src/exm/stc/ast/ExM.g:285:1: app_body : command ( app_redirection )* -> ^( APP_BODY command ( app_redirection )* ) ;
	public final ExMParser.app_body_return app_body() throws RecognitionException {
		ExMParser.app_body_return retval = new ExMParser.app_body_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope command61 =null;
		ParserRuleReturnScope app_redirection62 =null;

		RewriteRuleSubtreeStream stream_app_redirection=new RewriteRuleSubtreeStream(adaptor,"rule app_redirection");
		RewriteRuleSubtreeStream stream_command=new RewriteRuleSubtreeStream(adaptor,"rule command");

		try {
			// src/exm/stc/ast/ExM.g:285:9: ( command ( app_redirection )* -> ^( APP_BODY command ( app_redirection )* ) )
			// src/exm/stc/ast/ExM.g:286:5: command ( app_redirection )*
			{
			pushFollow(FOLLOW_command_in_app_body1938);
			command61=command();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_command.add(command61.getTree());
			// src/exm/stc/ast/ExM.g:286:13: ( app_redirection )*
			loop16:
			while (true) {
				int alt16=2;
				int LA16_0 = input.LA(1);
				if ( (LA16_0==ATSIGN) ) {
					alt16=1;
				}

				switch (alt16) {
				case 1 :
					// src/exm/stc/ast/ExM.g:286:13: app_redirection
					{
					pushFollow(FOLLOW_app_redirection_in_app_body1940);
					app_redirection62=app_redirection();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_app_redirection.add(app_redirection62.getTree());
					}
					break;

				default :
					break loop16;
				}
			}

			// AST REWRITE
			// elements: app_redirection, command
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 287:9: -> ^( APP_BODY command ( app_redirection )* )
			{
				// src/exm/stc/ast/ExM.g:287:12: ^( APP_BODY command ( app_redirection )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(APP_BODY, "APP_BODY"), root_1);
				adaptor.addChild(root_1, stream_command.nextTree());
				// src/exm/stc/ast/ExM.g:287:32: ( app_redirection )*
				while ( stream_app_redirection.hasNext() ) {
					adaptor.addChild(root_1, stream_app_redirection.nextTree());
				}
				stream_app_redirection.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "app_body"


	public static class command_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "command"
	// src/exm/stc/ast/ExM.g:290:1: command : command_args -> ^( COMMAND command_args ) ;
	public final ExMParser.command_return command() throws RecognitionException {
		ExMParser.command_return retval = new ExMParser.command_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope command_args63 =null;

		RewriteRuleSubtreeStream stream_command_args=new RewriteRuleSubtreeStream(adaptor,"rule command_args");

		try {
			// src/exm/stc/ast/ExM.g:290:8: ( command_args -> ^( COMMAND command_args ) )
			// src/exm/stc/ast/ExM.g:291:9: command_args
			{
			pushFollow(FOLLOW_command_args_in_command1978);
			command_args63=command_args();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_command_args.add(command_args63.getTree());
			// AST REWRITE
			// elements: command_args
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 291:22: -> ^( COMMAND command_args )
			{
				// src/exm/stc/ast/ExM.g:291:25: ^( COMMAND command_args )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMMAND, "COMMAND"), root_1);
				adaptor.addChild(root_1, stream_command_args.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "command"


	public static class command_args_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "command_args"
	// src/exm/stc/ast/ExM.g:294:1: command_args : command_arg command_args_more ;
	public final ExMParser.command_args_return command_args() throws RecognitionException {
		ExMParser.command_args_return retval = new ExMParser.command_args_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope command_arg64 =null;
		ParserRuleReturnScope command_args_more65 =null;


		try {
			// src/exm/stc/ast/ExM.g:294:13: ( command_arg command_args_more )
			// src/exm/stc/ast/ExM.g:295:9: command_arg command_args_more
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_command_arg_in_command_args2008);
			command_arg64=command_arg();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, command_arg64.getTree());

			pushFollow(FOLLOW_command_args_more_in_command_args2010);
			command_args_more65=command_args_more();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, command_args_more65.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "command_args"


	public static class command_args_more_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "command_args_more"
	// src/exm/stc/ast/ExM.g:298:1: command_args_more : ( command_args |);
	public final ExMParser.command_args_more_return command_args_more() throws RecognitionException {
		ExMParser.command_args_more_return retval = new ExMParser.command_args_more_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope command_args66 =null;


		try {
			// src/exm/stc/ast/ExM.g:298:18: ( command_args |)
			int alt17=2;
			switch ( input.LA(1) ) {
			case DECIMAL:
			case DECIMAL_INT:
			case FALSE:
			case HEX_INT:
			case ID:
			case INFINITY:
			case LBRACE:
			case LPAREN:
			case LSQUARE:
			case NOTANUMBER:
			case OCTAL_INT:
			case SCI_DECIMAL:
			case STRING:
			case STRING_MULTI_LINE_1:
			case STRING_MULTI_LINE_2:
			case TRUE:
				{
				alt17=1;
				}
				break;
			case ATSIGN:
				{
				int LA17_2 = input.LA(2);
				if ( (LA17_2==ID) ) {
					alt17=1;
				}
				else if ( ((LA17_2 >= STDERR && LA17_2 <= STDOUT)) ) {
					alt17=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 17, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case EOF:
			case RBRACE:
			case SEMICOLON:
				{
				alt17=2;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}
			switch (alt17) {
				case 1 :
					// src/exm/stc/ast/ExM.g:299:9: command_args
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_command_args_in_command_args_more2030);
					command_args66=command_args();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, command_args66.getTree());

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:300:5: 
					{
					root_0 = (Object)adaptor.nil();


					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "command_args_more"


	public static class command_arg_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "command_arg"
	// src/exm/stc/ast/ExM.g:302:1: command_arg : ( variable | literal | array_constructor | array_kv_constructor | LPAREN expr RPAREN -> expr | ATSIGN var_name -> ^( APP_FILENAME var_name ) );
	public final ExMParser.command_arg_return command_arg() throws RecognitionException {
		ExMParser.command_arg_return retval = new ExMParser.command_arg_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LPAREN71=null;
		Token RPAREN73=null;
		Token ATSIGN74=null;
		ParserRuleReturnScope variable67 =null;
		ParserRuleReturnScope literal68 =null;
		ParserRuleReturnScope array_constructor69 =null;
		ParserRuleReturnScope array_kv_constructor70 =null;
		ParserRuleReturnScope expr72 =null;
		ParserRuleReturnScope var_name75 =null;

		Object LPAREN71_tree=null;
		Object RPAREN73_tree=null;
		Object ATSIGN74_tree=null;
		RewriteRuleTokenStream stream_ATSIGN=new RewriteRuleTokenStream(adaptor,"token ATSIGN");
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_var_name=new RewriteRuleSubtreeStream(adaptor,"rule var_name");

		try {
			// src/exm/stc/ast/ExM.g:302:12: ( variable | literal | array_constructor | array_kv_constructor | LPAREN expr RPAREN -> expr | ATSIGN var_name -> ^( APP_FILENAME var_name ) )
			int alt18=6;
			switch ( input.LA(1) ) {
			case ID:
				{
				alt18=1;
				}
				break;
			case DECIMAL:
			case DECIMAL_INT:
			case FALSE:
			case HEX_INT:
			case INFINITY:
			case NOTANUMBER:
			case OCTAL_INT:
			case SCI_DECIMAL:
			case STRING:
			case STRING_MULTI_LINE_1:
			case STRING_MULTI_LINE_2:
			case TRUE:
				{
				alt18=2;
				}
				break;
			case LSQUARE:
				{
				alt18=3;
				}
				break;
			case LBRACE:
				{
				alt18=4;
				}
				break;
			case LPAREN:
				{
				alt18=5;
				}
				break;
			case ATSIGN:
				{
				alt18=6;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				throw nvae;
			}
			switch (alt18) {
				case 1 :
					// src/exm/stc/ast/ExM.g:303:9: variable
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_variable_in_command_arg2052);
					variable67=variable();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, variable67.getTree());

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:304:9: literal
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_literal_in_command_arg2062);
					literal68=literal();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, literal68.getTree());

					}
					break;
				case 3 :
					// src/exm/stc/ast/ExM.g:305:9: array_constructor
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_array_constructor_in_command_arg2072);
					array_constructor69=array_constructor();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, array_constructor69.getTree());

					}
					break;
				case 4 :
					// src/exm/stc/ast/ExM.g:306:9: array_kv_constructor
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_array_kv_constructor_in_command_arg2082);
					array_kv_constructor70=array_kv_constructor();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, array_kv_constructor70.getTree());

					}
					break;
				case 5 :
					// src/exm/stc/ast/ExM.g:307:9: LPAREN expr RPAREN
					{
					LPAREN71=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_command_arg2092); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN71);

					pushFollow(FOLLOW_expr_in_command_arg2094);
					expr72=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr72.getTree());
					RPAREN73=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_command_arg2096); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN73);

					// AST REWRITE
					// elements: expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 307:28: -> expr
					{
						adaptor.addChild(root_0, stream_expr.nextTree());
					}


					retval.tree = root_0;
					}

					}
					break;
				case 6 :
					// src/exm/stc/ast/ExM.g:308:9: ATSIGN var_name
					{
					ATSIGN74=(Token)match(input,ATSIGN,FOLLOW_ATSIGN_in_command_arg2110); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ATSIGN.add(ATSIGN74);

					pushFollow(FOLLOW_var_name_in_command_arg2112);
					var_name75=var_name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_var_name.add(var_name75.getTree());
					// AST REWRITE
					// elements: var_name
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 308:25: -> ^( APP_FILENAME var_name )
					{
						// src/exm/stc/ast/ExM.g:308:28: ^( APP_FILENAME var_name )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(APP_FILENAME, "APP_FILENAME"), root_1);
						adaptor.addChild(root_1, stream_var_name.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "command_arg"


	public static class app_redirection_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "app_redirection"
	// src/exm/stc/ast/ExM.g:311:1: app_redirection : ATSIGN redirect_type ASSIGN expr -> ^( APP_REDIRECTION redirect_type expr ) ;
	public final ExMParser.app_redirection_return app_redirection() throws RecognitionException {
		ExMParser.app_redirection_return retval = new ExMParser.app_redirection_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ATSIGN76=null;
		Token ASSIGN78=null;
		ParserRuleReturnScope redirect_type77 =null;
		ParserRuleReturnScope expr79 =null;

		Object ATSIGN76_tree=null;
		Object ASSIGN78_tree=null;
		RewriteRuleTokenStream stream_ATSIGN=new RewriteRuleTokenStream(adaptor,"token ATSIGN");
		RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_redirect_type=new RewriteRuleSubtreeStream(adaptor,"rule redirect_type");

		try {
			// src/exm/stc/ast/ExM.g:311:16: ( ATSIGN redirect_type ASSIGN expr -> ^( APP_REDIRECTION redirect_type expr ) )
			// src/exm/stc/ast/ExM.g:312:7: ATSIGN redirect_type ASSIGN expr
			{
			ATSIGN76=(Token)match(input,ATSIGN,FOLLOW_ATSIGN_in_app_redirection2140); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ATSIGN.add(ATSIGN76);

			pushFollow(FOLLOW_redirect_type_in_app_redirection2142);
			redirect_type77=redirect_type();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_redirect_type.add(redirect_type77.getTree());
			ASSIGN78=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_app_redirection2144); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN78);

			pushFollow(FOLLOW_expr_in_app_redirection2146);
			expr79=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(expr79.getTree());
			// AST REWRITE
			// elements: expr, redirect_type
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 312:40: -> ^( APP_REDIRECTION redirect_type expr )
			{
				// src/exm/stc/ast/ExM.g:313:9: ^( APP_REDIRECTION redirect_type expr )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(APP_REDIRECTION, "APP_REDIRECTION"), root_1);
				adaptor.addChild(root_1, stream_redirect_type.nextTree());
				adaptor.addChild(root_1, stream_expr.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "app_redirection"


	public static class redirect_type_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "redirect_type"
	// src/exm/stc/ast/ExM.g:316:1: redirect_type : ( STDIN | STDOUT | STDERR ) ;
	public final ExMParser.redirect_type_return redirect_type() throws RecognitionException {
		ExMParser.redirect_type_return retval = new ExMParser.redirect_type_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set80=null;

		Object set80_tree=null;

		try {
			// src/exm/stc/ast/ExM.g:316:14: ( ( STDIN | STDOUT | STDERR ) )
			// src/exm/stc/ast/ExM.g:
			{
			root_0 = (Object)adaptor.nil();


			set80=input.LT(1);
			if ( (input.LA(1) >= STDERR && input.LA(1) <= STDOUT) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set80));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "redirect_type"


	public static class tcl_body_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "tcl_body"
	// src/exm/stc/ast/ExM.g:320:1: tcl_body : tcl_package ( tcl_fun_ref )? ( inline_tcl )? ;
	public final ExMParser.tcl_body_return tcl_body() throws RecognitionException {
		ExMParser.tcl_body_return retval = new ExMParser.tcl_body_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope tcl_package81 =null;
		ParserRuleReturnScope tcl_fun_ref82 =null;
		ParserRuleReturnScope inline_tcl83 =null;


		try {
			// src/exm/stc/ast/ExM.g:320:9: ( tcl_package ( tcl_fun_ref )? ( inline_tcl )? )
			// src/exm/stc/ast/ExM.g:321:3: tcl_package ( tcl_fun_ref )? ( inline_tcl )?
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_tcl_package_in_tcl_body2206);
			tcl_package81=tcl_package();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, tcl_package81.getTree());

			// src/exm/stc/ast/ExM.g:321:15: ( tcl_fun_ref )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==STRING) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// src/exm/stc/ast/ExM.g:321:15: tcl_fun_ref
					{
					pushFollow(FOLLOW_tcl_fun_ref_in_tcl_body2208);
					tcl_fun_ref82=tcl_fun_ref();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, tcl_fun_ref82.getTree());

					}
					break;

			}

			// src/exm/stc/ast/ExM.g:321:28: ( inline_tcl )?
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==LSQUARE) ) {
				alt20=1;
			}
			switch (alt20) {
				case 1 :
					// src/exm/stc/ast/ExM.g:321:28: inline_tcl
					{
					pushFollow(FOLLOW_inline_tcl_in_tcl_body2211);
					inline_tcl83=inline_tcl();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, inline_tcl83.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "tcl_body"


	public static class tcl_package_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "tcl_package"
	// src/exm/stc/ast/ExM.g:324:1: tcl_package : pkg= STRING version= STRING -> ^( TCL_PACKAGE $pkg $version) ;
	public final ExMParser.tcl_package_return tcl_package() throws RecognitionException {
		ExMParser.tcl_package_return retval = new ExMParser.tcl_package_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token pkg=null;
		Token version=null;

		Object pkg_tree=null;
		Object version_tree=null;
		RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

		try {
			// src/exm/stc/ast/ExM.g:324:12: (pkg= STRING version= STRING -> ^( TCL_PACKAGE $pkg $version) )
			// src/exm/stc/ast/ExM.g:325:9: pkg= STRING version= STRING
			{
			pkg=(Token)match(input,STRING,FOLLOW_STRING_in_tcl_package2232); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_STRING.add(pkg);

			version=(Token)match(input,STRING,FOLLOW_STRING_in_tcl_package2236); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_STRING.add(version);

			// AST REWRITE
			// elements: version, pkg
			// token labels: version, pkg
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleTokenStream stream_version=new RewriteRuleTokenStream(adaptor,"token version",version);
			RewriteRuleTokenStream stream_pkg=new RewriteRuleTokenStream(adaptor,"token pkg",pkg);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 325:35: -> ^( TCL_PACKAGE $pkg $version)
			{
				// src/exm/stc/ast/ExM.g:325:38: ^( TCL_PACKAGE $pkg $version)
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TCL_PACKAGE, "TCL_PACKAGE"), root_1);
				adaptor.addChild(root_1, stream_pkg.nextNode());
				adaptor.addChild(root_1, stream_version.nextNode());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "tcl_package"


	public static class tcl_fun_ref_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "tcl_fun_ref"
	// src/exm/stc/ast/ExM.g:328:1: tcl_fun_ref : symbol= STRING -> ^( TCL_FUN_REF $symbol) ;
	public final ExMParser.tcl_fun_ref_return tcl_fun_ref() throws RecognitionException {
		ExMParser.tcl_fun_ref_return retval = new ExMParser.tcl_fun_ref_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token symbol=null;

		Object symbol_tree=null;
		RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

		try {
			// src/exm/stc/ast/ExM.g:328:12: (symbol= STRING -> ^( TCL_FUN_REF $symbol) )
			// src/exm/stc/ast/ExM.g:329:9: symbol= STRING
			{
			symbol=(Token)match(input,STRING,FOLLOW_STRING_in_tcl_fun_ref2272); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_STRING.add(symbol);

			// AST REWRITE
			// elements: symbol
			// token labels: symbol
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleTokenStream stream_symbol=new RewriteRuleTokenStream(adaptor,"token symbol",symbol);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 329:23: -> ^( TCL_FUN_REF $symbol)
			{
				// src/exm/stc/ast/ExM.g:329:26: ^( TCL_FUN_REF $symbol)
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TCL_FUN_REF, "TCL_FUN_REF"), root_1);
				adaptor.addChild(root_1, stream_symbol.nextNode());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "tcl_fun_ref"


	public static class type_parameters_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "type_parameters"
	// src/exm/stc/ast/ExM.g:332:1: type_parameters : ( -> ^( TYPE_PARAMETERS ) | LT var_name_list GT -> ^( TYPE_PARAMETERS var_name_list ) );
	public final ExMParser.type_parameters_return type_parameters() throws RecognitionException {
		ExMParser.type_parameters_return retval = new ExMParser.type_parameters_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LT84=null;
		Token GT86=null;
		ParserRuleReturnScope var_name_list85 =null;

		Object LT84_tree=null;
		Object GT86_tree=null;
		RewriteRuleTokenStream stream_LT=new RewriteRuleTokenStream(adaptor,"token LT");
		RewriteRuleTokenStream stream_GT=new RewriteRuleTokenStream(adaptor,"token GT");
		RewriteRuleSubtreeStream stream_var_name_list=new RewriteRuleSubtreeStream(adaptor,"rule var_name_list");

		try {
			// src/exm/stc/ast/ExM.g:332:16: ( -> ^( TYPE_PARAMETERS ) | LT var_name_list GT -> ^( TYPE_PARAMETERS var_name_list ) )
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==ID||(LA21_0 >= LBRACE && LA21_0 <= LPAREN)||LA21_0==STRING) ) {
				alt21=1;
			}
			else if ( (LA21_0==LT) ) {
				alt21=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}

			switch (alt21) {
				case 1 :
					// src/exm/stc/ast/ExM.g:333:21: 
					{
					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 333:21: -> ^( TYPE_PARAMETERS )
					{
						// src/exm/stc/ast/ExM.g:333:24: ^( TYPE_PARAMETERS )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TYPE_PARAMETERS, "TYPE_PARAMETERS"), root_1);
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:334:9: LT var_name_list GT
					{
					LT84=(Token)match(input,LT,FOLLOW_LT_in_type_parameters2321); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LT.add(LT84);

					pushFollow(FOLLOW_var_name_list_in_type_parameters2323);
					var_name_list85=var_name_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_var_name_list.add(var_name_list85.getTree());
					GT86=(Token)match(input,GT,FOLLOW_GT_in_type_parameters2325); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_GT.add(GT86);

					// AST REWRITE
					// elements: var_name_list
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 334:29: -> ^( TYPE_PARAMETERS var_name_list )
					{
						// src/exm/stc/ast/ExM.g:334:32: ^( TYPE_PARAMETERS var_name_list )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TYPE_PARAMETERS, "TYPE_PARAMETERS"), root_1);
						adaptor.addChild(root_1, stream_var_name_list.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "type_parameters"


	public static class var_name_list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "var_name_list"
	// src/exm/stc/ast/ExM.g:337:1: var_name_list : var_name var_name_list_more ;
	public final ExMParser.var_name_list_return var_name_list() throws RecognitionException {
		ExMParser.var_name_list_return retval = new ExMParser.var_name_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope var_name87 =null;
		ParserRuleReturnScope var_name_list_more88 =null;


		try {
			// src/exm/stc/ast/ExM.g:337:14: ( var_name var_name_list_more )
			// src/exm/stc/ast/ExM.g:338:9: var_name var_name_list_more
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_var_name_in_var_name_list2355);
			var_name87=var_name();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, var_name87.getTree());

			pushFollow(FOLLOW_var_name_list_more_in_var_name_list2357);
			var_name_list_more88=var_name_list_more();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, var_name_list_more88.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "var_name_list"


	public static class var_name_list_more_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "var_name_list_more"
	// src/exm/stc/ast/ExM.g:341:1: var_name_list_more : (| COMMA var_name_list -> var_name_list );
	public final ExMParser.var_name_list_more_return var_name_list_more() throws RecognitionException {
		ExMParser.var_name_list_more_return retval = new ExMParser.var_name_list_more_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMA89=null;
		ParserRuleReturnScope var_name_list90 =null;

		Object COMMA89_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_var_name_list=new RewriteRuleSubtreeStream(adaptor,"rule var_name_list");

		try {
			// src/exm/stc/ast/ExM.g:341:19: (| COMMA var_name_list -> var_name_list )
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==GT) ) {
				alt22=1;
			}
			else if ( (LA22_0==COMMA) ) {
				alt22=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}

			switch (alt22) {
				case 1 :
					// src/exm/stc/ast/ExM.g:343:5: 
					{
					root_0 = (Object)adaptor.nil();


					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:343:9: COMMA var_name_list
					{
					COMMA89=(Token)match(input,COMMA,FOLLOW_COMMA_in_var_name_list_more2387); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_COMMA.add(COMMA89);

					pushFollow(FOLLOW_var_name_list_in_var_name_list_more2389);
					var_name_list90=var_name_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_var_name_list.add(var_name_list90.getTree());
					// AST REWRITE
					// elements: var_name_list
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 343:29: -> var_name_list
					{
						adaptor.addChild(root_0, stream_var_name_list.nextTree());
					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "var_name_list_more"


	public static class inline_tcl_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "inline_tcl"
	// src/exm/stc/ast/ExM.g:346:1: inline_tcl : LSQUARE tcl= ( STRING | STRING_MULTI_LINE_1 | STRING_MULTI_LINE_2 ) RSQUARE -> ^( INLINE_TCL $tcl) ;
	public final ExMParser.inline_tcl_return inline_tcl() throws RecognitionException {
		ExMParser.inline_tcl_return retval = new ExMParser.inline_tcl_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token tcl=null;
		Token LSQUARE91=null;
		Token RSQUARE92=null;

		Object tcl_tree=null;
		Object LSQUARE91_tree=null;
		Object RSQUARE92_tree=null;
		RewriteRuleTokenStream stream_LSQUARE=new RewriteRuleTokenStream(adaptor,"token LSQUARE");
		RewriteRuleTokenStream stream_RSQUARE=new RewriteRuleTokenStream(adaptor,"token RSQUARE");
		RewriteRuleTokenStream stream_STRING_MULTI_LINE_2=new RewriteRuleTokenStream(adaptor,"token STRING_MULTI_LINE_2");
		RewriteRuleTokenStream stream_STRING_MULTI_LINE_1=new RewriteRuleTokenStream(adaptor,"token STRING_MULTI_LINE_1");
		RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

		try {
			// src/exm/stc/ast/ExM.g:346:11: ( LSQUARE tcl= ( STRING | STRING_MULTI_LINE_1 | STRING_MULTI_LINE_2 ) RSQUARE -> ^( INLINE_TCL $tcl) )
			// src/exm/stc/ast/ExM.g:347:5: LSQUARE tcl= ( STRING | STRING_MULTI_LINE_1 | STRING_MULTI_LINE_2 ) RSQUARE
			{
			LSQUARE91=(Token)match(input,LSQUARE,FOLLOW_LSQUARE_in_inline_tcl2409); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LSQUARE.add(LSQUARE91);

			// src/exm/stc/ast/ExM.g:347:17: ( STRING | STRING_MULTI_LINE_1 | STRING_MULTI_LINE_2 )
			int alt23=3;
			switch ( input.LA(1) ) {
			case STRING:
				{
				alt23=1;
				}
				break;
			case STRING_MULTI_LINE_1:
				{
				alt23=2;
				}
				break;
			case STRING_MULTI_LINE_2:
				{
				alt23=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 23, 0, input);
				throw nvae;
			}
			switch (alt23) {
				case 1 :
					// src/exm/stc/ast/ExM.g:347:18: STRING
					{
					tcl=(Token)match(input,STRING,FOLLOW_STRING_in_inline_tcl2414); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_STRING.add(tcl);

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:347:25: STRING_MULTI_LINE_1
					{
					tcl=(Token)match(input,STRING_MULTI_LINE_1,FOLLOW_STRING_MULTI_LINE_1_in_inline_tcl2416); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_STRING_MULTI_LINE_1.add(tcl);

					}
					break;
				case 3 :
					// src/exm/stc/ast/ExM.g:347:45: STRING_MULTI_LINE_2
					{
					tcl=(Token)match(input,STRING_MULTI_LINE_2,FOLLOW_STRING_MULTI_LINE_2_in_inline_tcl2418); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_STRING_MULTI_LINE_2.add(tcl);

					}
					break;

			}

			RSQUARE92=(Token)match(input,RSQUARE,FOLLOW_RSQUARE_in_inline_tcl2421); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RSQUARE.add(RSQUARE92);

			// AST REWRITE
			// elements: tcl
			// token labels: tcl
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleTokenStream stream_tcl=new RewriteRuleTokenStream(adaptor,"token tcl",tcl);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 348:11: -> ^( INLINE_TCL $tcl)
			{
				// src/exm/stc/ast/ExM.g:348:14: ^( INLINE_TCL $tcl)
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INLINE_TCL, "INLINE_TCL"), root_1);
				adaptor.addChild(root_1, stream_tcl.nextNode());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "inline_tcl"


	public static class global_const_definition_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "global_const_definition"
	// src/exm/stc/ast/ExM.g:350:1: global_const_definition : GLOBAL CONST v= declare_assign_single SEMICOLON -> ^( GLOBAL_CONST $v) ;
	public final ExMParser.global_const_definition_return global_const_definition() throws RecognitionException {
		ExMParser.global_const_definition_return retval = new ExMParser.global_const_definition_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token GLOBAL93=null;
		Token CONST94=null;
		Token SEMICOLON95=null;
		ParserRuleReturnScope v =null;

		Object GLOBAL93_tree=null;
		Object CONST94_tree=null;
		Object SEMICOLON95_tree=null;
		RewriteRuleTokenStream stream_CONST=new RewriteRuleTokenStream(adaptor,"token CONST");
		RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
		RewriteRuleTokenStream stream_GLOBAL=new RewriteRuleTokenStream(adaptor,"token GLOBAL");
		RewriteRuleSubtreeStream stream_declare_assign_single=new RewriteRuleSubtreeStream(adaptor,"rule declare_assign_single");

		try {
			// src/exm/stc/ast/ExM.g:350:24: ( GLOBAL CONST v= declare_assign_single SEMICOLON -> ^( GLOBAL_CONST $v) )
			// src/exm/stc/ast/ExM.g:351:9: GLOBAL CONST v= declare_assign_single SEMICOLON
			{
			GLOBAL93=(Token)match(input,GLOBAL,FOLLOW_GLOBAL_in_global_const_definition2457); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_GLOBAL.add(GLOBAL93);

			CONST94=(Token)match(input,CONST,FOLLOW_CONST_in_global_const_definition2459); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_CONST.add(CONST94);

			pushFollow(FOLLOW_declare_assign_single_in_global_const_definition2463);
			v=declare_assign_single();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_declare_assign_single.add(v.getTree());
			SEMICOLON95=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_global_const_definition2465); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON95);

			// AST REWRITE
			// elements: v
			// token labels: 
			// rule labels: v, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_v=new RewriteRuleSubtreeStream(adaptor,"rule v",v!=null?v.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 352:13: -> ^( GLOBAL_CONST $v)
			{
				// src/exm/stc/ast/ExM.g:352:16: ^( GLOBAL_CONST $v)
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(GLOBAL_CONST, "GLOBAL_CONST"), root_1);
				adaptor.addChild(root_1, stream_v.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "global_const_definition"


	public static class formal_argument_list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "formal_argument_list"
	// src/exm/stc/ast/ExM.g:355:1: formal_argument_list : ( -> ^( FORMAL_ARGUMENT_LIST ) | LPAREN ( formal_arguments )? RPAREN -> ^( FORMAL_ARGUMENT_LIST ( formal_arguments )? ) );
	public final ExMParser.formal_argument_list_return formal_argument_list() throws RecognitionException {
		ExMParser.formal_argument_list_return retval = new ExMParser.formal_argument_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LPAREN96=null;
		Token RPAREN98=null;
		ParserRuleReturnScope formal_arguments97 =null;

		Object LPAREN96_tree=null;
		Object RPAREN98_tree=null;
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleSubtreeStream stream_formal_arguments=new RewriteRuleSubtreeStream(adaptor,"rule formal_arguments");

		try {
			// src/exm/stc/ast/ExM.g:355:21: ( -> ^( FORMAL_ARGUMENT_LIST ) | LPAREN ( formal_arguments )? RPAREN -> ^( FORMAL_ARGUMENT_LIST ( formal_arguments )? ) )
			int alt25=2;
			int LA25_0 = input.LA(1);
			if ( (LA25_0==ID||LA25_0==LBRACE||LA25_0==STRING) ) {
				alt25=1;
			}
			else if ( (LA25_0==LPAREN) ) {
				alt25=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 25, 0, input);
				throw nvae;
			}

			switch (alt25) {
				case 1 :
					// src/exm/stc/ast/ExM.g:356:21: 
					{
					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 356:21: -> ^( FORMAL_ARGUMENT_LIST )
					{
						// src/exm/stc/ast/ExM.g:356:24: ^( FORMAL_ARGUMENT_LIST )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FORMAL_ARGUMENT_LIST, "FORMAL_ARGUMENT_LIST"), root_1);
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:357:9: LPAREN ( formal_arguments )? RPAREN
					{
					LPAREN96=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_formal_argument_list2526); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN96);

					// src/exm/stc/ast/ExM.g:357:16: ( formal_arguments )?
					int alt24=2;
					int LA24_0 = input.LA(1);
					if ( (LA24_0==ID) ) {
						alt24=1;
					}
					switch (alt24) {
						case 1 :
							// src/exm/stc/ast/ExM.g:357:16: formal_arguments
							{
							pushFollow(FOLLOW_formal_arguments_in_formal_argument_list2528);
							formal_arguments97=formal_arguments();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_formal_arguments.add(formal_arguments97.getTree());
							}
							break;

					}

					RPAREN98=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_formal_argument_list2531); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN98);

					// AST REWRITE
					// elements: formal_arguments
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 357:41: -> ^( FORMAL_ARGUMENT_LIST ( formal_arguments )? )
					{
						// src/exm/stc/ast/ExM.g:358:13: ^( FORMAL_ARGUMENT_LIST ( formal_arguments )? )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FORMAL_ARGUMENT_LIST, "FORMAL_ARGUMENT_LIST"), root_1);
						// src/exm/stc/ast/ExM.g:358:37: ( formal_arguments )?
						if ( stream_formal_arguments.hasNext() ) {
							adaptor.addChild(root_1, stream_formal_arguments.nextTree());
						}
						stream_formal_arguments.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "formal_argument_list"


	public static class formal_arguments_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "formal_arguments"
	// src/exm/stc/ast/ExM.g:361:1: formal_arguments : arg_decl ( formal_arguments_rest )* ;
	public final ExMParser.formal_arguments_return formal_arguments() throws RecognitionException {
		ExMParser.formal_arguments_return retval = new ExMParser.formal_arguments_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope arg_decl99 =null;
		ParserRuleReturnScope formal_arguments_rest100 =null;


		try {
			// src/exm/stc/ast/ExM.g:361:17: ( arg_decl ( formal_arguments_rest )* )
			// src/exm/stc/ast/ExM.g:362:9: arg_decl ( formal_arguments_rest )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_arg_decl_in_formal_arguments2574);
			arg_decl99=arg_decl();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, arg_decl99.getTree());

			// src/exm/stc/ast/ExM.g:362:18: ( formal_arguments_rest )*
			loop26:
			while (true) {
				int alt26=2;
				int LA26_0 = input.LA(1);
				if ( (LA26_0==COMMA) ) {
					alt26=1;
				}

				switch (alt26) {
				case 1 :
					// src/exm/stc/ast/ExM.g:362:18: formal_arguments_rest
					{
					pushFollow(FOLLOW_formal_arguments_rest_in_formal_arguments2576);
					formal_arguments_rest100=formal_arguments_rest();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, formal_arguments_rest100.getTree());

					}
					break;

				default :
					break loop26;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "formal_arguments"


	public static class formal_arguments_rest_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "formal_arguments_rest"
	// src/exm/stc/ast/ExM.g:365:1: formal_arguments_rest : COMMA arg_decl -> arg_decl ;
	public final ExMParser.formal_arguments_rest_return formal_arguments_rest() throws RecognitionException {
		ExMParser.formal_arguments_rest_return retval = new ExMParser.formal_arguments_rest_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMA101=null;
		ParserRuleReturnScope arg_decl102 =null;

		Object COMMA101_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_arg_decl=new RewriteRuleSubtreeStream(adaptor,"rule arg_decl");

		try {
			// src/exm/stc/ast/ExM.g:365:22: ( COMMA arg_decl -> arg_decl )
			// src/exm/stc/ast/ExM.g:366:9: COMMA arg_decl
			{
			COMMA101=(Token)match(input,COMMA,FOLLOW_COMMA_in_formal_arguments_rest2597); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_COMMA.add(COMMA101);

			pushFollow(FOLLOW_arg_decl_in_formal_arguments_rest2599);
			arg_decl102=arg_decl();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_arg_decl.add(arg_decl102.getTree());
			// AST REWRITE
			// elements: arg_decl
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 367:9: -> arg_decl
			{
				adaptor.addChild(root_0, stream_arg_decl.nextTree());
			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "formal_arguments_rest"


	public static class arg_decl_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "arg_decl"
	// src/exm/stc/ast/ExM.g:370:1: arg_decl : type= multi_type_prefix ( VARARGS )? v= var_name ( array_marker )* ( arg_decl_val )? -> ^( DECLARATION $type ^( DECLARE_VARIABLE_REST $v ( array_marker )* ) ( VARARGS )? ( arg_decl_val )? ) ;
	public final ExMParser.arg_decl_return arg_decl() throws RecognitionException {
		ExMParser.arg_decl_return retval = new ExMParser.arg_decl_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token VARARGS103=null;
		ParserRuleReturnScope type =null;
		ParserRuleReturnScope v =null;
		ParserRuleReturnScope array_marker104 =null;
		ParserRuleReturnScope arg_decl_val105 =null;

		Object VARARGS103_tree=null;
		RewriteRuleTokenStream stream_VARARGS=new RewriteRuleTokenStream(adaptor,"token VARARGS");
		RewriteRuleSubtreeStream stream_array_marker=new RewriteRuleSubtreeStream(adaptor,"rule array_marker");
		RewriteRuleSubtreeStream stream_arg_decl_val=new RewriteRuleSubtreeStream(adaptor,"rule arg_decl_val");
		RewriteRuleSubtreeStream stream_multi_type_prefix=new RewriteRuleSubtreeStream(adaptor,"rule multi_type_prefix");
		RewriteRuleSubtreeStream stream_var_name=new RewriteRuleSubtreeStream(adaptor,"rule var_name");

		try {
			// src/exm/stc/ast/ExM.g:370:9: (type= multi_type_prefix ( VARARGS )? v= var_name ( array_marker )* ( arg_decl_val )? -> ^( DECLARATION $type ^( DECLARE_VARIABLE_REST $v ( array_marker )* ) ( VARARGS )? ( arg_decl_val )? ) )
			// src/exm/stc/ast/ExM.g:372:9: type= multi_type_prefix ( VARARGS )? v= var_name ( array_marker )* ( arg_decl_val )?
			{
			pushFollow(FOLLOW_multi_type_prefix_in_arg_decl2638);
			type=multi_type_prefix();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_multi_type_prefix.add(type.getTree());
			// src/exm/stc/ast/ExM.g:372:32: ( VARARGS )?
			int alt27=2;
			int LA27_0 = input.LA(1);
			if ( (LA27_0==VARARGS) ) {
				alt27=1;
			}
			switch (alt27) {
				case 1 :
					// src/exm/stc/ast/ExM.g:372:32: VARARGS
					{
					VARARGS103=(Token)match(input,VARARGS,FOLLOW_VARARGS_in_arg_decl2640); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_VARARGS.add(VARARGS103);

					}
					break;

			}

			pushFollow(FOLLOW_var_name_in_arg_decl2645);
			v=var_name();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_var_name.add(v.getTree());
			// src/exm/stc/ast/ExM.g:372:52: ( array_marker )*
			loop28:
			while (true) {
				int alt28=2;
				int LA28_0 = input.LA(1);
				if ( (LA28_0==LSQUARE) ) {
					alt28=1;
				}

				switch (alt28) {
				case 1 :
					// src/exm/stc/ast/ExM.g:372:52: array_marker
					{
					pushFollow(FOLLOW_array_marker_in_arg_decl2647);
					array_marker104=array_marker();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_array_marker.add(array_marker104.getTree());
					}
					break;

				default :
					break loop28;
				}
			}

			// src/exm/stc/ast/ExM.g:372:66: ( arg_decl_val )?
			int alt29=2;
			int LA29_0 = input.LA(1);
			if ( (LA29_0==ASSIGN) ) {
				alt29=1;
			}
			switch (alt29) {
				case 1 :
					// src/exm/stc/ast/ExM.g:372:66: arg_decl_val
					{
					pushFollow(FOLLOW_arg_decl_val_in_arg_decl2650);
					arg_decl_val105=arg_decl_val();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_arg_decl_val.add(arg_decl_val105.getTree());
					}
					break;

			}

			// AST REWRITE
			// elements: arg_decl_val, v, VARARGS, type, array_marker
			// token labels: 
			// rule labels: v, type, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_v=new RewriteRuleSubtreeStream(adaptor,"rule v",v!=null?v.getTree():null);
			RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type",type!=null?type.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 373:13: -> ^( DECLARATION $type ^( DECLARE_VARIABLE_REST $v ( array_marker )* ) ( VARARGS )? ( arg_decl_val )? )
			{
				// src/exm/stc/ast/ExM.g:373:16: ^( DECLARATION $type ^( DECLARE_VARIABLE_REST $v ( array_marker )* ) ( VARARGS )? ( arg_decl_val )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DECLARATION, "DECLARATION"), root_1);
				adaptor.addChild(root_1, stream_type.nextTree());
				// src/exm/stc/ast/ExM.g:374:17: ^( DECLARE_VARIABLE_REST $v ( array_marker )* )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(DECLARE_VARIABLE_REST, "DECLARE_VARIABLE_REST"), root_2);
				adaptor.addChild(root_2, stream_v.nextTree());
				// src/exm/stc/ast/ExM.g:374:45: ( array_marker )*
				while ( stream_array_marker.hasNext() ) {
					adaptor.addChild(root_2, stream_array_marker.nextTree());
				}
				stream_array_marker.reset();

				adaptor.addChild(root_1, root_2);
				}

				// src/exm/stc/ast/ExM.g:375:17: ( VARARGS )?
				if ( stream_VARARGS.hasNext() ) {
					adaptor.addChild(root_1, stream_VARARGS.nextNode());
				}
				stream_VARARGS.reset();

				// src/exm/stc/ast/ExM.g:375:26: ( arg_decl_val )?
				if ( stream_arg_decl_val.hasNext() ) {
					adaptor.addChild(root_1, stream_arg_decl_val.nextTree());
				}
				stream_arg_decl_val.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "arg_decl"


	public static class arg_decl_val_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "arg_decl_val"
	// src/exm/stc/ast/ExM.g:378:1: arg_decl_val : ASSIGN expr -> expr ;
	public final ExMParser.arg_decl_val_return arg_decl_val() throws RecognitionException {
		ExMParser.arg_decl_val_return retval = new ExMParser.arg_decl_val_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ASSIGN106=null;
		ParserRuleReturnScope expr107 =null;

		Object ASSIGN106_tree=null;
		RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// src/exm/stc/ast/ExM.g:378:13: ( ASSIGN expr -> expr )
			// src/exm/stc/ast/ExM.g:379:5: ASSIGN expr
			{
			ASSIGN106=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_arg_decl_val2740); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN106);

			pushFollow(FOLLOW_expr_in_arg_decl_val2742);
			expr107=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(expr107.getTree());
			// AST REWRITE
			// elements: expr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 379:17: -> expr
			{
				adaptor.addChild(root_0, stream_expr.nextTree());
			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "arg_decl_val"


	public static class type_prefix_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "type_prefix"
	// src/exm/stc/ast/ExM.g:383:1: type_prefix : ( type_name | type_name LT standalone_type GT -> ^( PARAM_TYPE type_name standalone_type ) );
	public final ExMParser.type_prefix_return type_prefix() throws RecognitionException {
		ExMParser.type_prefix_return retval = new ExMParser.type_prefix_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LT110=null;
		Token GT112=null;
		ParserRuleReturnScope type_name108 =null;
		ParserRuleReturnScope type_name109 =null;
		ParserRuleReturnScope standalone_type111 =null;

		Object LT110_tree=null;
		Object GT112_tree=null;
		RewriteRuleTokenStream stream_LT=new RewriteRuleTokenStream(adaptor,"token LT");
		RewriteRuleTokenStream stream_GT=new RewriteRuleTokenStream(adaptor,"token GT");
		RewriteRuleSubtreeStream stream_type_name=new RewriteRuleSubtreeStream(adaptor,"rule type_name");
		RewriteRuleSubtreeStream stream_standalone_type=new RewriteRuleSubtreeStream(adaptor,"rule standalone_type");

		try {
			// src/exm/stc/ast/ExM.g:383:12: ( type_name | type_name LT standalone_type GT -> ^( PARAM_TYPE type_name standalone_type ) )
			int alt30=2;
			int LA30_0 = input.LA(1);
			if ( (LA30_0==ID) ) {
				int LA30_1 = input.LA(2);
				if ( (LA30_1==EOF||LA30_1==GT||LA30_1==ID||LA30_1==LSQUARE||LA30_1==PIPE||LA30_1==RSQUARE||LA30_1==SEMICOLON||LA30_1==VARARGS) ) {
					alt30=1;
				}
				else if ( (LA30_1==LT) ) {
					alt30=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 30, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 30, 0, input);
				throw nvae;
			}

			switch (alt30) {
				case 1 :
					// src/exm/stc/ast/ExM.g:384:5: type_name
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_type_name_in_type_prefix2759);
					type_name108=type_name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, type_name108.getTree());

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:385:6: type_name LT standalone_type GT
					{
					pushFollow(FOLLOW_type_name_in_type_prefix2766);
					type_name109=type_name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_type_name.add(type_name109.getTree());
					LT110=(Token)match(input,LT,FOLLOW_LT_in_type_prefix2768); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LT.add(LT110);

					pushFollow(FOLLOW_standalone_type_in_type_prefix2770);
					standalone_type111=standalone_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_standalone_type.add(standalone_type111.getTree());
					GT112=(Token)match(input,GT,FOLLOW_GT_in_type_prefix2772); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_GT.add(GT112);

					// AST REWRITE
					// elements: standalone_type, type_name
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 386:4: -> ^( PARAM_TYPE type_name standalone_type )
					{
						// src/exm/stc/ast/ExM.g:386:7: ^( PARAM_TYPE type_name standalone_type )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PARAM_TYPE, "PARAM_TYPE"), root_1);
						adaptor.addChild(root_1, stream_type_name.nextTree());
						adaptor.addChild(root_1, stream_standalone_type.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "type_prefix"


	public static class multi_type_prefix_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "multi_type_prefix"
	// src/exm/stc/ast/ExM.g:389:1: multi_type_prefix : type_prefix ( another_type )* -> ^( MULTI_TYPE type_prefix ( another_type )* ) ;
	public final ExMParser.multi_type_prefix_return multi_type_prefix() throws RecognitionException {
		ExMParser.multi_type_prefix_return retval = new ExMParser.multi_type_prefix_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope type_prefix113 =null;
		ParserRuleReturnScope another_type114 =null;

		RewriteRuleSubtreeStream stream_type_prefix=new RewriteRuleSubtreeStream(adaptor,"rule type_prefix");
		RewriteRuleSubtreeStream stream_another_type=new RewriteRuleSubtreeStream(adaptor,"rule another_type");

		try {
			// src/exm/stc/ast/ExM.g:389:18: ( type_prefix ( another_type )* -> ^( MULTI_TYPE type_prefix ( another_type )* ) )
			// src/exm/stc/ast/ExM.g:390:9: type_prefix ( another_type )*
			{
			pushFollow(FOLLOW_type_prefix_in_multi_type_prefix2804);
			type_prefix113=type_prefix();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_type_prefix.add(type_prefix113.getTree());
			// src/exm/stc/ast/ExM.g:390:21: ( another_type )*
			loop31:
			while (true) {
				int alt31=2;
				int LA31_0 = input.LA(1);
				if ( (LA31_0==PIPE) ) {
					alt31=1;
				}

				switch (alt31) {
				case 1 :
					// src/exm/stc/ast/ExM.g:390:21: another_type
					{
					pushFollow(FOLLOW_another_type_in_multi_type_prefix2806);
					another_type114=another_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_another_type.add(another_type114.getTree());
					}
					break;

				default :
					break loop31;
				}
			}

			// AST REWRITE
			// elements: another_type, type_prefix
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 391:13: -> ^( MULTI_TYPE type_prefix ( another_type )* )
			{
				// src/exm/stc/ast/ExM.g:391:16: ^( MULTI_TYPE type_prefix ( another_type )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MULTI_TYPE, "MULTI_TYPE"), root_1);
				adaptor.addChild(root_1, stream_type_prefix.nextTree());
				// src/exm/stc/ast/ExM.g:391:42: ( another_type )*
				while ( stream_another_type.hasNext() ) {
					adaptor.addChild(root_1, stream_another_type.nextTree());
				}
				stream_another_type.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "multi_type_prefix"


	public static class another_type_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "another_type"
	// src/exm/stc/ast/ExM.g:394:1: another_type : PIPE type_prefix -> type_prefix ;
	public final ExMParser.another_type_return another_type() throws RecognitionException {
		ExMParser.another_type_return retval = new ExMParser.another_type_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token PIPE115=null;
		ParserRuleReturnScope type_prefix116 =null;

		Object PIPE115_tree=null;
		RewriteRuleTokenStream stream_PIPE=new RewriteRuleTokenStream(adaptor,"token PIPE");
		RewriteRuleSubtreeStream stream_type_prefix=new RewriteRuleSubtreeStream(adaptor,"rule type_prefix");

		try {
			// src/exm/stc/ast/ExM.g:394:13: ( PIPE type_prefix -> type_prefix )
			// src/exm/stc/ast/ExM.g:395:9: PIPE type_prefix
			{
			PIPE115=(Token)match(input,PIPE,FOLLOW_PIPE_in_another_type2852); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_PIPE.add(PIPE115);

			pushFollow(FOLLOW_type_prefix_in_another_type2854);
			type_prefix116=type_prefix();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_type_prefix.add(type_prefix116.getTree());
			// AST REWRITE
			// elements: type_prefix
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 395:26: -> type_prefix
			{
				adaptor.addChild(root_0, stream_type_prefix.nextTree());
			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "another_type"


	public static class standalone_type_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "standalone_type"
	// src/exm/stc/ast/ExM.g:399:1: standalone_type : type= type_prefix ( array_marker )* -> ^( STANDALONE_TYPE $type ( array_marker )* ) ;
	public final ExMParser.standalone_type_return standalone_type() throws RecognitionException {
		ExMParser.standalone_type_return retval = new ExMParser.standalone_type_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope type =null;
		ParserRuleReturnScope array_marker117 =null;

		RewriteRuleSubtreeStream stream_type_prefix=new RewriteRuleSubtreeStream(adaptor,"rule type_prefix");
		RewriteRuleSubtreeStream stream_array_marker=new RewriteRuleSubtreeStream(adaptor,"rule array_marker");

		try {
			// src/exm/stc/ast/ExM.g:399:16: (type= type_prefix ( array_marker )* -> ^( STANDALONE_TYPE $type ( array_marker )* ) )
			// src/exm/stc/ast/ExM.g:400:2: type= type_prefix ( array_marker )*
			{
			pushFollow(FOLLOW_type_prefix_in_standalone_type2874);
			type=type_prefix();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_type_prefix.add(type.getTree());
			// src/exm/stc/ast/ExM.g:400:19: ( array_marker )*
			loop32:
			while (true) {
				int alt32=2;
				int LA32_0 = input.LA(1);
				if ( (LA32_0==LSQUARE) ) {
					alt32=1;
				}

				switch (alt32) {
				case 1 :
					// src/exm/stc/ast/ExM.g:400:19: array_marker
					{
					pushFollow(FOLLOW_array_marker_in_standalone_type2876);
					array_marker117=array_marker();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_array_marker.add(array_marker117.getTree());
					}
					break;

				default :
					break loop32;
				}
			}

			// AST REWRITE
			// elements: array_marker, type
			// token labels: 
			// rule labels: type, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type",type!=null?type.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 401:3: -> ^( STANDALONE_TYPE $type ( array_marker )* )
			{
				// src/exm/stc/ast/ExM.g:401:6: ^( STANDALONE_TYPE $type ( array_marker )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(STANDALONE_TYPE, "STANDALONE_TYPE"), root_1);
				adaptor.addChild(root_1, stream_type.nextTree());
				// src/exm/stc/ast/ExM.g:401:31: ( array_marker )*
				while ( stream_array_marker.hasNext() ) {
					adaptor.addChild(root_1, stream_array_marker.nextTree());
				}
				stream_array_marker.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "standalone_type"


	public static class block_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "block"
	// src/exm/stc/ast/ExM.g:404:1: block : LBRACE ( stmt )* RBRACE -> ^( BLOCK ( stmt )* ) ;
	public final ExMParser.block_return block() throws RecognitionException {
		ExMParser.block_return retval = new ExMParser.block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LBRACE118=null;
		Token RBRACE120=null;
		ParserRuleReturnScope stmt119 =null;

		Object LBRACE118_tree=null;
		Object RBRACE120_tree=null;
		RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
		RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
		RewriteRuleSubtreeStream stream_stmt=new RewriteRuleSubtreeStream(adaptor,"rule stmt");

		try {
			// src/exm/stc/ast/ExM.g:404:6: ( LBRACE ( stmt )* RBRACE -> ^( BLOCK ( stmt )* ) )
			// src/exm/stc/ast/ExM.g:404:8: LBRACE ( stmt )* RBRACE
			{
			LBRACE118=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_block2902); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE118);

			// src/exm/stc/ast/ExM.g:404:15: ( stmt )*
			loop33:
			while (true) {
				int alt33=2;
				int LA33_0 = input.LA(1);
				if ( (LA33_0==APP||LA33_0==ATSIGN||(LA33_0 >= FOR && LA33_0 <= FOREACH)||LA33_0==GLOBAL||LA33_0==ID||LA33_0==IF||LA33_0==IMPORT||LA33_0==ITERATE||(LA33_0 >= LBRACE && LA33_0 <= LPAREN)||LA33_0==LT||LA33_0==PRAGMA||LA33_0==SEMICOLON||LA33_0==STRING||LA33_0==SWITCH||(LA33_0 >= TYPE && LA33_0 <= TYPEDEF)||LA33_0==WAIT) ) {
					alt33=1;
				}

				switch (alt33) {
				case 1 :
					// src/exm/stc/ast/ExM.g:404:15: stmt
					{
					pushFollow(FOLLOW_stmt_in_block2904);
					stmt119=stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_stmt.add(stmt119.getTree());
					}
					break;

				default :
					break loop33;
				}
			}

			RBRACE120=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_block2907); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE120);

			// AST REWRITE
			// elements: stmt
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 404:28: -> ^( BLOCK ( stmt )* )
			{
				// src/exm/stc/ast/ExM.g:404:31: ^( BLOCK ( stmt )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BLOCK, "BLOCK"), root_1);
				// src/exm/stc/ast/ExM.g:404:40: ( stmt )*
				while ( stream_stmt.hasNext() ) {
					adaptor.addChild(root_1, stream_stmt.nextTree());
				}
				stream_stmt.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "block"


	public static class if_stmt_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "if_stmt"
	// src/exm/stc/ast/ExM.g:407:1: if_stmt : IF LPAREN c= expr RPAREN b= block ( else_block )? -> ^( IF_STATEMENT $c $b ( else_block )? ) ;
	public final ExMParser.if_stmt_return if_stmt() throws RecognitionException {
		ExMParser.if_stmt_return retval = new ExMParser.if_stmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token IF121=null;
		Token LPAREN122=null;
		Token RPAREN123=null;
		ParserRuleReturnScope c =null;
		ParserRuleReturnScope b =null;
		ParserRuleReturnScope else_block124 =null;

		Object IF121_tree=null;
		Object LPAREN122_tree=null;
		Object RPAREN123_tree=null;
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleTokenStream stream_IF=new RewriteRuleTokenStream(adaptor,"token IF");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
		RewriteRuleSubtreeStream stream_else_block=new RewriteRuleSubtreeStream(adaptor,"rule else_block");

		try {
			// src/exm/stc/ast/ExM.g:407:8: ( IF LPAREN c= expr RPAREN b= block ( else_block )? -> ^( IF_STATEMENT $c $b ( else_block )? ) )
			// src/exm/stc/ast/ExM.g:408:9: IF LPAREN c= expr RPAREN b= block ( else_block )?
			{
			IF121=(Token)match(input,IF,FOLLOW_IF_in_if_stmt2938); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IF.add(IF121);

			LPAREN122=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_if_stmt2940); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN122);

			pushFollow(FOLLOW_expr_in_if_stmt2944);
			c=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(c.getTree());
			RPAREN123=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_if_stmt2946); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN123);

			pushFollow(FOLLOW_block_in_if_stmt2950);
			b=block();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_block.add(b.getTree());
			// src/exm/stc/ast/ExM.g:408:41: ( else_block )?
			int alt34=2;
			int LA34_0 = input.LA(1);
			if ( (LA34_0==ELSE) ) {
				alt34=1;
			}
			switch (alt34) {
				case 1 :
					// src/exm/stc/ast/ExM.g:408:41: else_block
					{
					pushFollow(FOLLOW_else_block_in_if_stmt2952);
					else_block124=else_block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_else_block.add(else_block124.getTree());
					}
					break;

			}

			// AST REWRITE
			// elements: b, else_block, c
			// token labels: 
			// rule labels: b, c, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.getTree():null);
			RewriteRuleSubtreeStream stream_c=new RewriteRuleSubtreeStream(adaptor,"rule c",c!=null?c.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 408:53: -> ^( IF_STATEMENT $c $b ( else_block )? )
			{
				// src/exm/stc/ast/ExM.g:409:9: ^( IF_STATEMENT $c $b ( else_block )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_STATEMENT, "IF_STATEMENT"), root_1);
				adaptor.addChild(root_1, stream_c.nextTree());
				adaptor.addChild(root_1, stream_b.nextTree());
				// src/exm/stc/ast/ExM.g:409:31: ( else_block )?
				if ( stream_else_block.hasNext() ) {
					adaptor.addChild(root_1, stream_else_block.nextTree());
				}
				stream_else_block.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "if_stmt"


	public static class else_block_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "else_block"
	// src/exm/stc/ast/ExM.g:412:1: else_block : ( ELSE b= block -> $b| ELSE if_stmt -> ^( BLOCK if_stmt ) );
	public final ExMParser.else_block_return else_block() throws RecognitionException {
		ExMParser.else_block_return retval = new ExMParser.else_block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ELSE125=null;
		Token ELSE126=null;
		ParserRuleReturnScope b =null;
		ParserRuleReturnScope if_stmt127 =null;

		Object ELSE125_tree=null;
		Object ELSE126_tree=null;
		RewriteRuleTokenStream stream_ELSE=new RewriteRuleTokenStream(adaptor,"token ELSE");
		RewriteRuleSubtreeStream stream_if_stmt=new RewriteRuleSubtreeStream(adaptor,"rule if_stmt");
		RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");

		try {
			// src/exm/stc/ast/ExM.g:412:11: ( ELSE b= block -> $b| ELSE if_stmt -> ^( BLOCK if_stmt ) )
			int alt35=2;
			int LA35_0 = input.LA(1);
			if ( (LA35_0==ELSE) ) {
				int LA35_1 = input.LA(2);
				if ( (LA35_1==LBRACE) ) {
					alt35=1;
				}
				else if ( (LA35_1==IF) ) {
					alt35=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 35, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 35, 0, input);
				throw nvae;
			}

			switch (alt35) {
				case 1 :
					// src/exm/stc/ast/ExM.g:413:9: ELSE b= block
					{
					ELSE125=(Token)match(input,ELSE,FOLLOW_ELSE_in_else_block2998); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ELSE.add(ELSE125);

					pushFollow(FOLLOW_block_in_else_block3002);
					b=block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_block.add(b.getTree());
					// AST REWRITE
					// elements: b
					// token labels: 
					// rule labels: b, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 413:22: -> $b
					{
						adaptor.addChild(root_0, stream_b.nextTree());
					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:414:9: ELSE if_stmt
					{
					ELSE126=(Token)match(input,ELSE,FOLLOW_ELSE_in_else_block3017); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ELSE.add(ELSE126);

					pushFollow(FOLLOW_if_stmt_in_else_block3019);
					if_stmt127=if_stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_if_stmt.add(if_stmt127.getTree());
					// AST REWRITE
					// elements: if_stmt
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 414:22: -> ^( BLOCK if_stmt )
					{
						// src/exm/stc/ast/ExM.g:414:25: ^( BLOCK if_stmt )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BLOCK, "BLOCK"), root_1);
						adaptor.addChild(root_1, stream_if_stmt.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "else_block"


	public static class switch_stmt_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "switch_stmt"
	// src/exm/stc/ast/ExM.g:417:1: switch_stmt : SWITCH LPAREN e= expr RPAREN LBRACE ( switch_case )* RBRACE -> ^( SWITCH_STATEMENT $e ( switch_case )* ) ;
	public final ExMParser.switch_stmt_return switch_stmt() throws RecognitionException {
		ExMParser.switch_stmt_return retval = new ExMParser.switch_stmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SWITCH128=null;
		Token LPAREN129=null;
		Token RPAREN130=null;
		Token LBRACE131=null;
		Token RBRACE133=null;
		ParserRuleReturnScope e =null;
		ParserRuleReturnScope switch_case132 =null;

		Object SWITCH128_tree=null;
		Object LPAREN129_tree=null;
		Object RPAREN130_tree=null;
		Object LBRACE131_tree=null;
		Object RBRACE133_tree=null;
		RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleTokenStream stream_SWITCH=new RewriteRuleTokenStream(adaptor,"token SWITCH");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
		RewriteRuleSubtreeStream stream_switch_case=new RewriteRuleSubtreeStream(adaptor,"rule switch_case");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// src/exm/stc/ast/ExM.g:417:12: ( SWITCH LPAREN e= expr RPAREN LBRACE ( switch_case )* RBRACE -> ^( SWITCH_STATEMENT $e ( switch_case )* ) )
			// src/exm/stc/ast/ExM.g:418:9: SWITCH LPAREN e= expr RPAREN LBRACE ( switch_case )* RBRACE
			{
			SWITCH128=(Token)match(input,SWITCH,FOLLOW_SWITCH_in_switch_stmt3049); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SWITCH.add(SWITCH128);

			LPAREN129=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_switch_stmt3051); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN129);

			pushFollow(FOLLOW_expr_in_switch_stmt3055);
			e=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(e.getTree());
			RPAREN130=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_switch_stmt3057); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN130);

			LBRACE131=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_switch_stmt3059); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE131);

			// src/exm/stc/ast/ExM.g:418:44: ( switch_case )*
			loop36:
			while (true) {
				int alt36=2;
				int LA36_0 = input.LA(1);
				if ( (LA36_0==CASE||LA36_0==DEFAULT) ) {
					alt36=1;
				}

				switch (alt36) {
				case 1 :
					// src/exm/stc/ast/ExM.g:418:44: switch_case
					{
					pushFollow(FOLLOW_switch_case_in_switch_stmt3061);
					switch_case132=switch_case();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_switch_case.add(switch_case132.getTree());
					}
					break;

				default :
					break loop36;
				}
			}

			RBRACE133=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_switch_stmt3064); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE133);

			// AST REWRITE
			// elements: e, switch_case
			// token labels: 
			// rule labels: e, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_e=new RewriteRuleSubtreeStream(adaptor,"rule e",e!=null?e.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 419:9: -> ^( SWITCH_STATEMENT $e ( switch_case )* )
			{
				// src/exm/stc/ast/ExM.g:419:12: ^( SWITCH_STATEMENT $e ( switch_case )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SWITCH_STATEMENT, "SWITCH_STATEMENT"), root_1);
				adaptor.addChild(root_1, stream_e.nextTree());
				// src/exm/stc/ast/ExM.g:419:35: ( switch_case )*
				while ( stream_switch_case.hasNext() ) {
					adaptor.addChild(root_1, stream_switch_case.nextTree());
				}
				stream_switch_case.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "switch_stmt"


	public static class switch_case_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "switch_case"
	// src/exm/stc/ast/ExM.g:422:1: switch_case : ( CASE integer COLON ( stmt )* -> ^( CASE integer ^( BLOCK ( stmt )* ) ) | DEFAULT COLON ( stmt )* -> ^( DEFAULT ^( BLOCK ( stmt )* ) ) );
	public final ExMParser.switch_case_return switch_case() throws RecognitionException {
		ExMParser.switch_case_return retval = new ExMParser.switch_case_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token CASE134=null;
		Token COLON136=null;
		Token DEFAULT138=null;
		Token COLON139=null;
		ParserRuleReturnScope integer135 =null;
		ParserRuleReturnScope stmt137 =null;
		ParserRuleReturnScope stmt140 =null;

		Object CASE134_tree=null;
		Object COLON136_tree=null;
		Object DEFAULT138_tree=null;
		Object COLON139_tree=null;
		RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
		RewriteRuleTokenStream stream_DEFAULT=new RewriteRuleTokenStream(adaptor,"token DEFAULT");
		RewriteRuleTokenStream stream_CASE=new RewriteRuleTokenStream(adaptor,"token CASE");
		RewriteRuleSubtreeStream stream_integer=new RewriteRuleSubtreeStream(adaptor,"rule integer");
		RewriteRuleSubtreeStream stream_stmt=new RewriteRuleSubtreeStream(adaptor,"rule stmt");

		try {
			// src/exm/stc/ast/ExM.g:422:12: ( CASE integer COLON ( stmt )* -> ^( CASE integer ^( BLOCK ( stmt )* ) ) | DEFAULT COLON ( stmt )* -> ^( DEFAULT ^( BLOCK ( stmt )* ) ) )
			int alt39=2;
			int LA39_0 = input.LA(1);
			if ( (LA39_0==CASE) ) {
				alt39=1;
			}
			else if ( (LA39_0==DEFAULT) ) {
				alt39=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 39, 0, input);
				throw nvae;
			}

			switch (alt39) {
				case 1 :
					// src/exm/stc/ast/ExM.g:423:9: CASE integer COLON ( stmt )*
					{
					CASE134=(Token)match(input,CASE,FOLLOW_CASE_in_switch_case3106); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CASE.add(CASE134);

					pushFollow(FOLLOW_integer_in_switch_case3108);
					integer135=integer();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_integer.add(integer135.getTree());
					COLON136=(Token)match(input,COLON,FOLLOW_COLON_in_switch_case3110); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_COLON.add(COLON136);

					// src/exm/stc/ast/ExM.g:423:28: ( stmt )*
					loop37:
					while (true) {
						int alt37=2;
						int LA37_0 = input.LA(1);
						if ( (LA37_0==APP||LA37_0==ATSIGN||(LA37_0 >= FOR && LA37_0 <= FOREACH)||LA37_0==GLOBAL||LA37_0==ID||LA37_0==IF||LA37_0==IMPORT||LA37_0==ITERATE||(LA37_0 >= LBRACE && LA37_0 <= LPAREN)||LA37_0==LT||LA37_0==PRAGMA||LA37_0==SEMICOLON||LA37_0==STRING||LA37_0==SWITCH||(LA37_0 >= TYPE && LA37_0 <= TYPEDEF)||LA37_0==WAIT) ) {
							alt37=1;
						}

						switch (alt37) {
						case 1 :
							// src/exm/stc/ast/ExM.g:423:28: stmt
							{
							pushFollow(FOLLOW_stmt_in_switch_case3112);
							stmt137=stmt();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_stmt.add(stmt137.getTree());
							}
							break;

						default :
							break loop37;
						}
					}

					// AST REWRITE
					// elements: stmt, integer, CASE
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 424:9: -> ^( CASE integer ^( BLOCK ( stmt )* ) )
					{
						// src/exm/stc/ast/ExM.g:424:12: ^( CASE integer ^( BLOCK ( stmt )* ) )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot(stream_CASE.nextNode(), root_1);
						adaptor.addChild(root_1, stream_integer.nextTree());
						// src/exm/stc/ast/ExM.g:424:28: ^( BLOCK ( stmt )* )
						{
						Object root_2 = (Object)adaptor.nil();
						root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(BLOCK, "BLOCK"), root_2);
						// src/exm/stc/ast/ExM.g:424:37: ( stmt )*
						while ( stream_stmt.hasNext() ) {
							adaptor.addChild(root_2, stream_stmt.nextTree());
						}
						stream_stmt.reset();

						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:425:9: DEFAULT COLON ( stmt )*
					{
					DEFAULT138=(Token)match(input,DEFAULT,FOLLOW_DEFAULT_in_switch_case3150); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_DEFAULT.add(DEFAULT138);

					COLON139=(Token)match(input,COLON,FOLLOW_COLON_in_switch_case3152); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_COLON.add(COLON139);

					// src/exm/stc/ast/ExM.g:425:23: ( stmt )*
					loop38:
					while (true) {
						int alt38=2;
						int LA38_0 = input.LA(1);
						if ( (LA38_0==APP||LA38_0==ATSIGN||(LA38_0 >= FOR && LA38_0 <= FOREACH)||LA38_0==GLOBAL||LA38_0==ID||LA38_0==IF||LA38_0==IMPORT||LA38_0==ITERATE||(LA38_0 >= LBRACE && LA38_0 <= LPAREN)||LA38_0==LT||LA38_0==PRAGMA||LA38_0==SEMICOLON||LA38_0==STRING||LA38_0==SWITCH||(LA38_0 >= TYPE && LA38_0 <= TYPEDEF)||LA38_0==WAIT) ) {
							alt38=1;
						}

						switch (alt38) {
						case 1 :
							// src/exm/stc/ast/ExM.g:425:23: stmt
							{
							pushFollow(FOLLOW_stmt_in_switch_case3154);
							stmt140=stmt();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_stmt.add(stmt140.getTree());
							}
							break;

						default :
							break loop38;
						}
					}

					// AST REWRITE
					// elements: DEFAULT, stmt
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 426:9: -> ^( DEFAULT ^( BLOCK ( stmt )* ) )
					{
						// src/exm/stc/ast/ExM.g:426:12: ^( DEFAULT ^( BLOCK ( stmt )* ) )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot(stream_DEFAULT.nextNode(), root_1);
						// src/exm/stc/ast/ExM.g:426:23: ^( BLOCK ( stmt )* )
						{
						Object root_2 = (Object)adaptor.nil();
						root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(BLOCK, "BLOCK"), root_2);
						// src/exm/stc/ast/ExM.g:426:32: ( stmt )*
						while ( stream_stmt.hasNext() ) {
							adaptor.addChild(root_2, stream_stmt.nextTree());
						}
						stream_stmt.reset();

						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "switch_case"


	public static class foreach_loop_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "foreach_loop"
	// src/exm/stc/ast/ExM.g:429:1: foreach_loop : ( ( annotation )* FOREACH v= var_name COMMA i= var_name IN e= expr b= block -> ^( FOREACH_LOOP $e $b $v $i ( annotation )* ) | ( annotation )* FOREACH v= var_name IN e= expr b= block -> ^( FOREACH_LOOP $e $b $v ( annotation )* ) );
	public final ExMParser.foreach_loop_return foreach_loop() throws RecognitionException {
		ExMParser.foreach_loop_return retval = new ExMParser.foreach_loop_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token FOREACH142=null;
		Token COMMA143=null;
		Token IN144=null;
		Token FOREACH146=null;
		Token IN147=null;
		ParserRuleReturnScope v =null;
		ParserRuleReturnScope i =null;
		ParserRuleReturnScope e =null;
		ParserRuleReturnScope b =null;
		ParserRuleReturnScope annotation141 =null;
		ParserRuleReturnScope annotation145 =null;

		Object FOREACH142_tree=null;
		Object COMMA143_tree=null;
		Object IN144_tree=null;
		Object FOREACH146_tree=null;
		Object IN147_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleTokenStream stream_IN=new RewriteRuleTokenStream(adaptor,"token IN");
		RewriteRuleTokenStream stream_FOREACH=new RewriteRuleTokenStream(adaptor,"token FOREACH");
		RewriteRuleSubtreeStream stream_annotation=new RewriteRuleSubtreeStream(adaptor,"rule annotation");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
		RewriteRuleSubtreeStream stream_var_name=new RewriteRuleSubtreeStream(adaptor,"rule var_name");

		try {
			// src/exm/stc/ast/ExM.g:429:13: ( ( annotation )* FOREACH v= var_name COMMA i= var_name IN e= expr b= block -> ^( FOREACH_LOOP $e $b $v $i ( annotation )* ) | ( annotation )* FOREACH v= var_name IN e= expr b= block -> ^( FOREACH_LOOP $e $b $v ( annotation )* ) )
			int alt42=2;
			alt42 = dfa42.predict(input);
			switch (alt42) {
				case 1 :
					// src/exm/stc/ast/ExM.g:430:9: ( annotation )* FOREACH v= var_name COMMA i= var_name IN e= expr b= block
					{
					// src/exm/stc/ast/ExM.g:430:9: ( annotation )*
					loop40:
					while (true) {
						int alt40=2;
						int LA40_0 = input.LA(1);
						if ( (LA40_0==ATSIGN) ) {
							alt40=1;
						}

						switch (alt40) {
						case 1 :
							// src/exm/stc/ast/ExM.g:430:9: annotation
							{
							pushFollow(FOLLOW_annotation_in_foreach_loop3200);
							annotation141=annotation();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_annotation.add(annotation141.getTree());
							}
							break;

						default :
							break loop40;
						}
					}

					FOREACH142=(Token)match(input,FOREACH,FOLLOW_FOREACH_in_foreach_loop3203); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_FOREACH.add(FOREACH142);

					pushFollow(FOLLOW_var_name_in_foreach_loop3207);
					v=var_name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_var_name.add(v.getTree());
					COMMA143=(Token)match(input,COMMA,FOLLOW_COMMA_in_foreach_loop3209); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_COMMA.add(COMMA143);

					pushFollow(FOLLOW_var_name_in_foreach_loop3213);
					i=var_name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_var_name.add(i.getTree());
					IN144=(Token)match(input,IN,FOLLOW_IN_in_foreach_loop3215); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_IN.add(IN144);

					pushFollow(FOLLOW_expr_in_foreach_loop3219);
					e=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(e.getTree());
					pushFollow(FOLLOW_block_in_foreach_loop3223);
					b=block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_block.add(b.getTree());
					// AST REWRITE
					// elements: annotation, v, b, e, i
					// token labels: 
					// rule labels: b, e, v, i, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.getTree():null);
					RewriteRuleSubtreeStream stream_e=new RewriteRuleSubtreeStream(adaptor,"rule e",e!=null?e.getTree():null);
					RewriteRuleSubtreeStream stream_v=new RewriteRuleSubtreeStream(adaptor,"rule v",v!=null?v.getTree():null);
					RewriteRuleSubtreeStream stream_i=new RewriteRuleSubtreeStream(adaptor,"rule i",i!=null?i.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 431:9: -> ^( FOREACH_LOOP $e $b $v $i ( annotation )* )
					{
						// src/exm/stc/ast/ExM.g:431:12: ^( FOREACH_LOOP $e $b $v $i ( annotation )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FOREACH_LOOP, "FOREACH_LOOP"), root_1);
						adaptor.addChild(root_1, stream_e.nextTree());
						adaptor.addChild(root_1, stream_b.nextTree());
						adaptor.addChild(root_1, stream_v.nextTree());
						adaptor.addChild(root_1, stream_i.nextTree());
						// src/exm/stc/ast/ExM.g:431:40: ( annotation )*
						while ( stream_annotation.hasNext() ) {
							adaptor.addChild(root_1, stream_annotation.nextTree());
						}
						stream_annotation.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:432:9: ( annotation )* FOREACH v= var_name IN e= expr b= block
					{
					// src/exm/stc/ast/ExM.g:432:9: ( annotation )*
					loop41:
					while (true) {
						int alt41=2;
						int LA41_0 = input.LA(1);
						if ( (LA41_0==ATSIGN) ) {
							alt41=1;
						}

						switch (alt41) {
						case 1 :
							// src/exm/stc/ast/ExM.g:432:9: annotation
							{
							pushFollow(FOLLOW_annotation_in_foreach_loop3264);
							annotation145=annotation();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_annotation.add(annotation145.getTree());
							}
							break;

						default :
							break loop41;
						}
					}

					FOREACH146=(Token)match(input,FOREACH,FOLLOW_FOREACH_in_foreach_loop3267); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_FOREACH.add(FOREACH146);

					pushFollow(FOLLOW_var_name_in_foreach_loop3271);
					v=var_name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_var_name.add(v.getTree());
					IN147=(Token)match(input,IN,FOLLOW_IN_in_foreach_loop3273); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_IN.add(IN147);

					pushFollow(FOLLOW_expr_in_foreach_loop3277);
					e=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(e.getTree());
					pushFollow(FOLLOW_block_in_foreach_loop3281);
					b=block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_block.add(b.getTree());
					// AST REWRITE
					// elements: annotation, b, v, e
					// token labels: 
					// rule labels: b, e, v, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.getTree():null);
					RewriteRuleSubtreeStream stream_e=new RewriteRuleSubtreeStream(adaptor,"rule e",e!=null?e.getTree():null);
					RewriteRuleSubtreeStream stream_v=new RewriteRuleSubtreeStream(adaptor,"rule v",v!=null?v.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 433:9: -> ^( FOREACH_LOOP $e $b $v ( annotation )* )
					{
						// src/exm/stc/ast/ExM.g:433:12: ^( FOREACH_LOOP $e $b $v ( annotation )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FOREACH_LOOP, "FOREACH_LOOP"), root_1);
						adaptor.addChild(root_1, stream_e.nextTree());
						adaptor.addChild(root_1, stream_b.nextTree());
						adaptor.addChild(root_1, stream_v.nextTree());
						// src/exm/stc/ast/ExM.g:433:37: ( annotation )*
						while ( stream_annotation.hasNext() ) {
							adaptor.addChild(root_1, stream_annotation.nextTree());
						}
						stream_annotation.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "foreach_loop"


	public static class for_loop_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "for_loop"
	// src/exm/stc/ast/ExM.g:436:1: for_loop : ( annotation )* FOR LPAREN i= for_loop_init SEMICOLON c= expr SEMICOLON u= for_loop_update RPAREN b= block -> ^( FOR_LOOP $i $c $u $b ( annotation )* ) ;
	public final ExMParser.for_loop_return for_loop() throws RecognitionException {
		ExMParser.for_loop_return retval = new ExMParser.for_loop_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token FOR149=null;
		Token LPAREN150=null;
		Token SEMICOLON151=null;
		Token SEMICOLON152=null;
		Token RPAREN153=null;
		ParserRuleReturnScope i =null;
		ParserRuleReturnScope c =null;
		ParserRuleReturnScope u =null;
		ParserRuleReturnScope b =null;
		ParserRuleReturnScope annotation148 =null;

		Object FOR149_tree=null;
		Object LPAREN150_tree=null;
		Object SEMICOLON151_tree=null;
		Object SEMICOLON152_tree=null;
		Object RPAREN153_tree=null;
		RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
		RewriteRuleTokenStream stream_FOR=new RewriteRuleTokenStream(adaptor,"token FOR");
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleSubtreeStream stream_annotation=new RewriteRuleSubtreeStream(adaptor,"rule annotation");
		RewriteRuleSubtreeStream stream_for_loop_update=new RewriteRuleSubtreeStream(adaptor,"rule for_loop_update");
		RewriteRuleSubtreeStream stream_for_loop_init=new RewriteRuleSubtreeStream(adaptor,"rule for_loop_init");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");

		try {
			// src/exm/stc/ast/ExM.g:436:9: ( ( annotation )* FOR LPAREN i= for_loop_init SEMICOLON c= expr SEMICOLON u= for_loop_update RPAREN b= block -> ^( FOR_LOOP $i $c $u $b ( annotation )* ) )
			// src/exm/stc/ast/ExM.g:437:9: ( annotation )* FOR LPAREN i= for_loop_init SEMICOLON c= expr SEMICOLON u= for_loop_update RPAREN b= block
			{
			// src/exm/stc/ast/ExM.g:437:9: ( annotation )*
			loop43:
			while (true) {
				int alt43=2;
				int LA43_0 = input.LA(1);
				if ( (LA43_0==ATSIGN) ) {
					alt43=1;
				}

				switch (alt43) {
				case 1 :
					// src/exm/stc/ast/ExM.g:437:9: annotation
					{
					pushFollow(FOLLOW_annotation_in_for_loop3329);
					annotation148=annotation();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_annotation.add(annotation148.getTree());
					}
					break;

				default :
					break loop43;
				}
			}

			FOR149=(Token)match(input,FOR,FOLLOW_FOR_in_for_loop3340); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_FOR.add(FOR149);

			LPAREN150=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_for_loop3342); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN150);

			pushFollow(FOLLOW_for_loop_init_in_for_loop3346);
			i=for_loop_init();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_for_loop_init.add(i.getTree());
			SEMICOLON151=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_for_loop3348); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON151);

			pushFollow(FOLLOW_expr_in_for_loop3352);
			c=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(c.getTree());
			SEMICOLON152=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_for_loop3354); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON152);

			pushFollow(FOLLOW_for_loop_update_in_for_loop3374);
			u=for_loop_update();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_for_loop_update.add(u.getTree());
			RPAREN153=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_for_loop3376); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN153);

			pushFollow(FOLLOW_block_in_for_loop3380);
			b=block();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_block.add(b.getTree());
			// AST REWRITE
			// elements: b, c, annotation, u, i
			// token labels: 
			// rule labels: b, c, u, i, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.getTree():null);
			RewriteRuleSubtreeStream stream_c=new RewriteRuleSubtreeStream(adaptor,"rule c",c!=null?c.getTree():null);
			RewriteRuleSubtreeStream stream_u=new RewriteRuleSubtreeStream(adaptor,"rule u",u!=null?u.getTree():null);
			RewriteRuleSubtreeStream stream_i=new RewriteRuleSubtreeStream(adaptor,"rule i",i!=null?i.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 440:13: -> ^( FOR_LOOP $i $c $u $b ( annotation )* )
			{
				// src/exm/stc/ast/ExM.g:440:16: ^( FOR_LOOP $i $c $u $b ( annotation )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FOR_LOOP, "FOR_LOOP"), root_1);
				adaptor.addChild(root_1, stream_i.nextTree());
				adaptor.addChild(root_1, stream_c.nextTree());
				adaptor.addChild(root_1, stream_u.nextTree());
				adaptor.addChild(root_1, stream_b.nextTree());
				// src/exm/stc/ast/ExM.g:440:40: ( annotation )*
				while ( stream_annotation.hasNext() ) {
					adaptor.addChild(root_1, stream_annotation.nextTree());
				}
				stream_annotation.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "for_loop"


	public static class for_loop_init_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "for_loop_init"
	// src/exm/stc/ast/ExM.g:443:1: for_loop_init : ( for_loop_init_items )? -> ^( FOR_LOOP_INIT ( for_loop_init_items )? ) ;
	public final ExMParser.for_loop_init_return for_loop_init() throws RecognitionException {
		ExMParser.for_loop_init_return retval = new ExMParser.for_loop_init_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope for_loop_init_items154 =null;

		RewriteRuleSubtreeStream stream_for_loop_init_items=new RewriteRuleSubtreeStream(adaptor,"rule for_loop_init_items");

		try {
			// src/exm/stc/ast/ExM.g:443:14: ( ( for_loop_init_items )? -> ^( FOR_LOOP_INIT ( for_loop_init_items )? ) )
			// src/exm/stc/ast/ExM.g:444:9: ( for_loop_init_items )?
			{
			// src/exm/stc/ast/ExM.g:444:9: ( for_loop_init_items )?
			int alt44=2;
			int LA44_0 = input.LA(1);
			if ( (LA44_0==ID) ) {
				alt44=1;
			}
			switch (alt44) {
				case 1 :
					// src/exm/stc/ast/ExM.g:444:9: for_loop_init_items
					{
					pushFollow(FOLLOW_for_loop_init_items_in_for_loop_init3435);
					for_loop_init_items154=for_loop_init_items();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_for_loop_init_items.add(for_loop_init_items154.getTree());
					}
					break;

			}

			// AST REWRITE
			// elements: for_loop_init_items
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 445:13: -> ^( FOR_LOOP_INIT ( for_loop_init_items )? )
			{
				// src/exm/stc/ast/ExM.g:445:16: ^( FOR_LOOP_INIT ( for_loop_init_items )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FOR_LOOP_INIT, "FOR_LOOP_INIT"), root_1);
				// src/exm/stc/ast/ExM.g:445:33: ( for_loop_init_items )?
				if ( stream_for_loop_init_items.hasNext() ) {
					adaptor.addChild(root_1, stream_for_loop_init_items.nextTree());
				}
				stream_for_loop_init_items.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "for_loop_init"


	public static class for_loop_init_items_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "for_loop_init_items"
	// src/exm/stc/ast/ExM.g:448:1: for_loop_init_items : ( for_loop_declaration | for_loop_assignment ) ( for_loop_init_more )* ;
	public final ExMParser.for_loop_init_items_return for_loop_init_items() throws RecognitionException {
		ExMParser.for_loop_init_items_return retval = new ExMParser.for_loop_init_items_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope for_loop_declaration155 =null;
		ParserRuleReturnScope for_loop_assignment156 =null;
		ParserRuleReturnScope for_loop_init_more157 =null;


		try {
			// src/exm/stc/ast/ExM.g:448:20: ( ( for_loop_declaration | for_loop_assignment ) ( for_loop_init_more )* )
			// src/exm/stc/ast/ExM.g:449:9: ( for_loop_declaration | for_loop_assignment ) ( for_loop_init_more )*
			{
			root_0 = (Object)adaptor.nil();


			// src/exm/stc/ast/ExM.g:449:9: ( for_loop_declaration | for_loop_assignment )
			int alt45=2;
			int LA45_0 = input.LA(1);
			if ( (LA45_0==ID) ) {
				int LA45_1 = input.LA(2);
				if ( (LA45_1==ID||LA45_1==LT) ) {
					alt45=1;
				}
				else if ( (LA45_1==ASSIGN) ) {
					alt45=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 45, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 45, 0, input);
				throw nvae;
			}

			switch (alt45) {
				case 1 :
					// src/exm/stc/ast/ExM.g:449:10: for_loop_declaration
					{
					pushFollow(FOLLOW_for_loop_declaration_in_for_loop_init_items3479);
					for_loop_declaration155=for_loop_declaration();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, for_loop_declaration155.getTree());

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:449:31: for_loop_assignment
					{
					pushFollow(FOLLOW_for_loop_assignment_in_for_loop_init_items3481);
					for_loop_assignment156=for_loop_assignment();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, for_loop_assignment156.getTree());

					}
					break;

			}

			// src/exm/stc/ast/ExM.g:449:52: ( for_loop_init_more )*
			loop46:
			while (true) {
				int alt46=2;
				int LA46_0 = input.LA(1);
				if ( (LA46_0==COMMA) ) {
					alt46=1;
				}

				switch (alt46) {
				case 1 :
					// src/exm/stc/ast/ExM.g:449:53: for_loop_init_more
					{
					pushFollow(FOLLOW_for_loop_init_more_in_for_loop_init_items3485);
					for_loop_init_more157=for_loop_init_more();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, for_loop_init_more157.getTree());

					}
					break;

				default :
					break loop46;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "for_loop_init_items"


	public static class for_loop_init_more_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "for_loop_init_more"
	// src/exm/stc/ast/ExM.g:452:1: for_loop_init_more : ( COMMA for_loop_declaration -> for_loop_declaration | COMMA for_loop_assignment -> for_loop_assignment );
	public final ExMParser.for_loop_init_more_return for_loop_init_more() throws RecognitionException {
		ExMParser.for_loop_init_more_return retval = new ExMParser.for_loop_init_more_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMA158=null;
		Token COMMA160=null;
		ParserRuleReturnScope for_loop_declaration159 =null;
		ParserRuleReturnScope for_loop_assignment161 =null;

		Object COMMA158_tree=null;
		Object COMMA160_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_for_loop_assignment=new RewriteRuleSubtreeStream(adaptor,"rule for_loop_assignment");
		RewriteRuleSubtreeStream stream_for_loop_declaration=new RewriteRuleSubtreeStream(adaptor,"rule for_loop_declaration");

		try {
			// src/exm/stc/ast/ExM.g:452:19: ( COMMA for_loop_declaration -> for_loop_declaration | COMMA for_loop_assignment -> for_loop_assignment )
			int alt47=2;
			int LA47_0 = input.LA(1);
			if ( (LA47_0==COMMA) ) {
				int LA47_1 = input.LA(2);
				if ( (LA47_1==ID) ) {
					int LA47_2 = input.LA(3);
					if ( (LA47_2==ID||LA47_2==LT) ) {
						alt47=1;
					}
					else if ( (LA47_2==ASSIGN) ) {
						alt47=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 47, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 47, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 47, 0, input);
				throw nvae;
			}

			switch (alt47) {
				case 1 :
					// src/exm/stc/ast/ExM.g:453:9: COMMA for_loop_declaration
					{
					COMMA158=(Token)match(input,COMMA,FOLLOW_COMMA_in_for_loop_init_more3507); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_COMMA.add(COMMA158);

					pushFollow(FOLLOW_for_loop_declaration_in_for_loop_init_more3509);
					for_loop_declaration159=for_loop_declaration();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_for_loop_declaration.add(for_loop_declaration159.getTree());
					// AST REWRITE
					// elements: for_loop_declaration
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 453:36: -> for_loop_declaration
					{
						adaptor.addChild(root_0, stream_for_loop_declaration.nextTree());
					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:454:9: COMMA for_loop_assignment
					{
					COMMA160=(Token)match(input,COMMA,FOLLOW_COMMA_in_for_loop_init_more3523); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_COMMA.add(COMMA160);

					pushFollow(FOLLOW_for_loop_assignment_in_for_loop_init_more3525);
					for_loop_assignment161=for_loop_assignment();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_for_loop_assignment.add(for_loop_assignment161.getTree());
					// AST REWRITE
					// elements: for_loop_assignment
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 454:35: -> for_loop_assignment
					{
						adaptor.addChild(root_0, stream_for_loop_assignment.nextTree());
					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "for_loop_init_more"


	public static class for_loop_update_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "for_loop_update"
	// src/exm/stc/ast/ExM.g:457:1: for_loop_update : ( for_loop_update_items )? -> ^( FOR_LOOP_UPDATE ( for_loop_update_items )? ) ;
	public final ExMParser.for_loop_update_return for_loop_update() throws RecognitionException {
		ExMParser.for_loop_update_return retval = new ExMParser.for_loop_update_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope for_loop_update_items162 =null;

		RewriteRuleSubtreeStream stream_for_loop_update_items=new RewriteRuleSubtreeStream(adaptor,"rule for_loop_update_items");

		try {
			// src/exm/stc/ast/ExM.g:457:16: ( ( for_loop_update_items )? -> ^( FOR_LOOP_UPDATE ( for_loop_update_items )? ) )
			// src/exm/stc/ast/ExM.g:458:9: ( for_loop_update_items )?
			{
			// src/exm/stc/ast/ExM.g:458:9: ( for_loop_update_items )?
			int alt48=2;
			int LA48_0 = input.LA(1);
			if ( (LA48_0==ID) ) {
				alt48=1;
			}
			switch (alt48) {
				case 1 :
					// src/exm/stc/ast/ExM.g:458:9: for_loop_update_items
					{
					pushFollow(FOLLOW_for_loop_update_items_in_for_loop_update3549);
					for_loop_update_items162=for_loop_update_items();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_for_loop_update_items.add(for_loop_update_items162.getTree());
					}
					break;

			}

			// AST REWRITE
			// elements: for_loop_update_items
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 459:13: -> ^( FOR_LOOP_UPDATE ( for_loop_update_items )? )
			{
				// src/exm/stc/ast/ExM.g:459:16: ^( FOR_LOOP_UPDATE ( for_loop_update_items )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FOR_LOOP_UPDATE, "FOR_LOOP_UPDATE"), root_1);
				// src/exm/stc/ast/ExM.g:459:35: ( for_loop_update_items )?
				if ( stream_for_loop_update_items.hasNext() ) {
					adaptor.addChild(root_1, stream_for_loop_update_items.nextTree());
				}
				stream_for_loop_update_items.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "for_loop_update"


	public static class for_loop_update_items_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "for_loop_update_items"
	// src/exm/stc/ast/ExM.g:462:1: for_loop_update_items : for_loop_assignment ( for_loop_update_more )* ;
	public final ExMParser.for_loop_update_items_return for_loop_update_items() throws RecognitionException {
		ExMParser.for_loop_update_items_return retval = new ExMParser.for_loop_update_items_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope for_loop_assignment163 =null;
		ParserRuleReturnScope for_loop_update_more164 =null;


		try {
			// src/exm/stc/ast/ExM.g:462:22: ( for_loop_assignment ( for_loop_update_more )* )
			// src/exm/stc/ast/ExM.g:463:9: for_loop_assignment ( for_loop_update_more )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_for_loop_assignment_in_for_loop_update_items3593);
			for_loop_assignment163=for_loop_assignment();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, for_loop_assignment163.getTree());

			// src/exm/stc/ast/ExM.g:463:29: ( for_loop_update_more )*
			loop49:
			while (true) {
				int alt49=2;
				int LA49_0 = input.LA(1);
				if ( (LA49_0==COMMA) ) {
					alt49=1;
				}

				switch (alt49) {
				case 1 :
					// src/exm/stc/ast/ExM.g:463:29: for_loop_update_more
					{
					pushFollow(FOLLOW_for_loop_update_more_in_for_loop_update_items3595);
					for_loop_update_more164=for_loop_update_more();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, for_loop_update_more164.getTree());

					}
					break;

				default :
					break loop49;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "for_loop_update_items"


	public static class for_loop_update_more_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "for_loop_update_more"
	// src/exm/stc/ast/ExM.g:466:1: for_loop_update_more : COMMA for_loop_assignment -> for_loop_assignment ;
	public final ExMParser.for_loop_update_more_return for_loop_update_more() throws RecognitionException {
		ExMParser.for_loop_update_more_return retval = new ExMParser.for_loop_update_more_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMA165=null;
		ParserRuleReturnScope for_loop_assignment166 =null;

		Object COMMA165_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_for_loop_assignment=new RewriteRuleSubtreeStream(adaptor,"rule for_loop_assignment");

		try {
			// src/exm/stc/ast/ExM.g:466:21: ( COMMA for_loop_assignment -> for_loop_assignment )
			// src/exm/stc/ast/ExM.g:467:9: COMMA for_loop_assignment
			{
			COMMA165=(Token)match(input,COMMA,FOLLOW_COMMA_in_for_loop_update_more3616); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_COMMA.add(COMMA165);

			pushFollow(FOLLOW_for_loop_assignment_in_for_loop_update_more3618);
			for_loop_assignment166=for_loop_assignment();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_for_loop_assignment.add(for_loop_assignment166.getTree());
			// AST REWRITE
			// elements: for_loop_assignment
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 467:35: -> for_loop_assignment
			{
				adaptor.addChild(root_0, stream_for_loop_assignment.nextTree());
			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "for_loop_update_more"


	public static class for_loop_declaration_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "for_loop_declaration"
	// src/exm/stc/ast/ExM.g:470:1: for_loop_declaration : declare_assign_single ;
	public final ExMParser.for_loop_declaration_return for_loop_declaration() throws RecognitionException {
		ExMParser.for_loop_declaration_return retval = new ExMParser.for_loop_declaration_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope declare_assign_single167 =null;


		try {
			// src/exm/stc/ast/ExM.g:470:21: ( declare_assign_single )
			// src/exm/stc/ast/ExM.g:470:23: declare_assign_single
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_declare_assign_single_in_for_loop_declaration3634);
			declare_assign_single167=declare_assign_single();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, declare_assign_single167.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "for_loop_declaration"


	public static class for_loop_assignment_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "for_loop_assignment"
	// src/exm/stc/ast/ExM.g:472:1: for_loop_assignment : var_name ASSIGN expr -> ^( FOR_LOOP_ASSIGN var_name expr ) ;
	public final ExMParser.for_loop_assignment_return for_loop_assignment() throws RecognitionException {
		ExMParser.for_loop_assignment_return retval = new ExMParser.for_loop_assignment_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ASSIGN169=null;
		ParserRuleReturnScope var_name168 =null;
		ParserRuleReturnScope expr170 =null;

		Object ASSIGN169_tree=null;
		RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_var_name=new RewriteRuleSubtreeStream(adaptor,"rule var_name");

		try {
			// src/exm/stc/ast/ExM.g:472:20: ( var_name ASSIGN expr -> ^( FOR_LOOP_ASSIGN var_name expr ) )
			// src/exm/stc/ast/ExM.g:473:9: var_name ASSIGN expr
			{
			pushFollow(FOLLOW_var_name_in_for_loop_assignment3649);
			var_name168=var_name();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_var_name.add(var_name168.getTree());
			ASSIGN169=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_for_loop_assignment3651); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN169);

			pushFollow(FOLLOW_expr_in_for_loop_assignment3653);
			expr170=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(expr170.getTree());
			// AST REWRITE
			// elements: var_name, expr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 473:30: -> ^( FOR_LOOP_ASSIGN var_name expr )
			{
				// src/exm/stc/ast/ExM.g:473:33: ^( FOR_LOOP_ASSIGN var_name expr )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FOR_LOOP_ASSIGN, "FOR_LOOP_ASSIGN"), root_1);
				adaptor.addChild(root_1, stream_var_name.nextTree());
				adaptor.addChild(root_1, stream_expr.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "for_loop_assignment"


	public static class iterate_loop_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "iterate_loop"
	// src/exm/stc/ast/ExM.g:476:1: iterate_loop : ITERATE v= var_name b= block UNTIL LPAREN e= expr RPAREN -> ^( ITERATE $v $b $e) ;
	public final ExMParser.iterate_loop_return iterate_loop() throws RecognitionException {
		ExMParser.iterate_loop_return retval = new ExMParser.iterate_loop_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ITERATE171=null;
		Token UNTIL172=null;
		Token LPAREN173=null;
		Token RPAREN174=null;
		ParserRuleReturnScope v =null;
		ParserRuleReturnScope b =null;
		ParserRuleReturnScope e =null;

		Object ITERATE171_tree=null;
		Object UNTIL172_tree=null;
		Object LPAREN173_tree=null;
		Object RPAREN174_tree=null;
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleTokenStream stream_ITERATE=new RewriteRuleTokenStream(adaptor,"token ITERATE");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleTokenStream stream_UNTIL=new RewriteRuleTokenStream(adaptor,"token UNTIL");
		RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_var_name=new RewriteRuleSubtreeStream(adaptor,"rule var_name");

		try {
			// src/exm/stc/ast/ExM.g:476:13: ( ITERATE v= var_name b= block UNTIL LPAREN e= expr RPAREN -> ^( ITERATE $v $b $e) )
			// src/exm/stc/ast/ExM.g:477:9: ITERATE v= var_name b= block UNTIL LPAREN e= expr RPAREN
			{
			ITERATE171=(Token)match(input,ITERATE,FOLLOW_ITERATE_in_iterate_loop3685); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ITERATE.add(ITERATE171);

			pushFollow(FOLLOW_var_name_in_iterate_loop3689);
			v=var_name();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_var_name.add(v.getTree());
			pushFollow(FOLLOW_block_in_iterate_loop3693);
			b=block();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_block.add(b.getTree());
			UNTIL172=(Token)match(input,UNTIL,FOLLOW_UNTIL_in_iterate_loop3695); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_UNTIL.add(UNTIL172);

			LPAREN173=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_iterate_loop3697); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN173);

			pushFollow(FOLLOW_expr_in_iterate_loop3701);
			e=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(e.getTree());
			RPAREN174=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_iterate_loop3703); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN174);

			// AST REWRITE
			// elements: e, b, ITERATE, v
			// token labels: 
			// rule labels: b, e, v, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.getTree():null);
			RewriteRuleSubtreeStream stream_e=new RewriteRuleSubtreeStream(adaptor,"rule e",e!=null?e.getTree():null);
			RewriteRuleSubtreeStream stream_v=new RewriteRuleSubtreeStream(adaptor,"rule v",v!=null?v.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 478:17: -> ^( ITERATE $v $b $e)
			{
				// src/exm/stc/ast/ExM.g:478:20: ^( ITERATE $v $b $e)
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot(stream_ITERATE.nextNode(), root_1);
				adaptor.addChild(root_1, stream_v.nextTree());
				adaptor.addChild(root_1, stream_b.nextTree());
				adaptor.addChild(root_1, stream_e.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "iterate_loop"


	public static class wait_stmt_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "wait_stmt"
	// src/exm/stc/ast/ExM.g:480:1: wait_stmt : ( WAIT a= expr_argument_list b= block -> ^( WAIT_STATEMENT $a $b) | WAIT DEEP a= expr_argument_list b= block -> ^( WAIT_DEEP_STATEMENT $a $b) );
	public final ExMParser.wait_stmt_return wait_stmt() throws RecognitionException {
		ExMParser.wait_stmt_return retval = new ExMParser.wait_stmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token WAIT175=null;
		Token WAIT176=null;
		Token DEEP177=null;
		ParserRuleReturnScope a =null;
		ParserRuleReturnScope b =null;

		Object WAIT175_tree=null;
		Object WAIT176_tree=null;
		Object DEEP177_tree=null;
		RewriteRuleTokenStream stream_DEEP=new RewriteRuleTokenStream(adaptor,"token DEEP");
		RewriteRuleTokenStream stream_WAIT=new RewriteRuleTokenStream(adaptor,"token WAIT");
		RewriteRuleSubtreeStream stream_expr_argument_list=new RewriteRuleSubtreeStream(adaptor,"rule expr_argument_list");
		RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");

		try {
			// src/exm/stc/ast/ExM.g:480:10: ( WAIT a= expr_argument_list b= block -> ^( WAIT_STATEMENT $a $b) | WAIT DEEP a= expr_argument_list b= block -> ^( WAIT_DEEP_STATEMENT $a $b) )
			int alt50=2;
			int LA50_0 = input.LA(1);
			if ( (LA50_0==WAIT) ) {
				int LA50_1 = input.LA(2);
				if ( (LA50_1==DEEP) ) {
					alt50=2;
				}
				else if ( (LA50_1==LPAREN) ) {
					alt50=1;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 50, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 50, 0, input);
				throw nvae;
			}

			switch (alt50) {
				case 1 :
					// src/exm/stc/ast/ExM.g:481:9: WAIT a= expr_argument_list b= block
					{
					WAIT175=(Token)match(input,WAIT,FOLLOW_WAIT_in_wait_stmt3755); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_WAIT.add(WAIT175);

					pushFollow(FOLLOW_expr_argument_list_in_wait_stmt3759);
					a=expr_argument_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr_argument_list.add(a.getTree());
					pushFollow(FOLLOW_block_in_wait_stmt3763);
					b=block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_block.add(b.getTree());
					// AST REWRITE
					// elements: b, a
					// token labels: 
					// rule labels: a, b, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.getTree():null);
					RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 482:13: -> ^( WAIT_STATEMENT $a $b)
					{
						// src/exm/stc/ast/ExM.g:482:16: ^( WAIT_STATEMENT $a $b)
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(WAIT_STATEMENT, "WAIT_STATEMENT"), root_1);
						adaptor.addChild(root_1, stream_a.nextTree());
						adaptor.addChild(root_1, stream_b.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:483:9: WAIT DEEP a= expr_argument_list b= block
					{
					WAIT176=(Token)match(input,WAIT,FOLLOW_WAIT_in_wait_stmt3798); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_WAIT.add(WAIT176);

					DEEP177=(Token)match(input,DEEP,FOLLOW_DEEP_in_wait_stmt3800); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_DEEP.add(DEEP177);

					pushFollow(FOLLOW_expr_argument_list_in_wait_stmt3804);
					a=expr_argument_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr_argument_list.add(a.getTree());
					pushFollow(FOLLOW_block_in_wait_stmt3808);
					b=block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_block.add(b.getTree());
					// AST REWRITE
					// elements: a, b
					// token labels: 
					// rule labels: a, b, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.getTree():null);
					RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 484:13: -> ^( WAIT_DEEP_STATEMENT $a $b)
					{
						// src/exm/stc/ast/ExM.g:484:16: ^( WAIT_DEEP_STATEMENT $a $b)
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(WAIT_DEEP_STATEMENT, "WAIT_DEEP_STATEMENT"), root_1);
						adaptor.addChild(root_1, stream_a.nextTree());
						adaptor.addChild(root_1, stream_b.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "wait_stmt"


	public static class declaration_multi_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "declaration_multi"
	// src/exm/stc/ast/ExM.g:487:1: declaration_multi : type= type_prefix declare_rest ( declare_rest_more )* -> ^( DECLARATION $type declare_rest ( declare_rest_more )* ) ;
	public final ExMParser.declaration_multi_return declaration_multi() throws RecognitionException {
		ExMParser.declaration_multi_return retval = new ExMParser.declaration_multi_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope type =null;
		ParserRuleReturnScope declare_rest178 =null;
		ParserRuleReturnScope declare_rest_more179 =null;

		RewriteRuleSubtreeStream stream_declare_rest_more=new RewriteRuleSubtreeStream(adaptor,"rule declare_rest_more");
		RewriteRuleSubtreeStream stream_type_prefix=new RewriteRuleSubtreeStream(adaptor,"rule type_prefix");
		RewriteRuleSubtreeStream stream_declare_rest=new RewriteRuleSubtreeStream(adaptor,"rule declare_rest");

		try {
			// src/exm/stc/ast/ExM.g:487:18: (type= type_prefix declare_rest ( declare_rest_more )* -> ^( DECLARATION $type declare_rest ( declare_rest_more )* ) )
			// src/exm/stc/ast/ExM.g:488:9: type= type_prefix declare_rest ( declare_rest_more )*
			{
			pushFollow(FOLLOW_type_prefix_in_declaration_multi3855);
			type=type_prefix();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_type_prefix.add(type.getTree());
			pushFollow(FOLLOW_declare_rest_in_declaration_multi3857);
			declare_rest178=declare_rest();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_declare_rest.add(declare_rest178.getTree());
			// src/exm/stc/ast/ExM.g:488:39: ( declare_rest_more )*
			loop51:
			while (true) {
				int alt51=2;
				int LA51_0 = input.LA(1);
				if ( (LA51_0==COMMA) ) {
					alt51=1;
				}

				switch (alt51) {
				case 1 :
					// src/exm/stc/ast/ExM.g:488:39: declare_rest_more
					{
					pushFollow(FOLLOW_declare_rest_more_in_declaration_multi3859);
					declare_rest_more179=declare_rest_more();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_declare_rest_more.add(declare_rest_more179.getTree());
					}
					break;

				default :
					break loop51;
				}
			}

			// AST REWRITE
			// elements: type, declare_rest, declare_rest_more
			// token labels: 
			// rule labels: type, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type",type!=null?type.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 489:13: -> ^( DECLARATION $type declare_rest ( declare_rest_more )* )
			{
				// src/exm/stc/ast/ExM.g:489:16: ^( DECLARATION $type declare_rest ( declare_rest_more )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DECLARATION, "DECLARATION"), root_1);
				adaptor.addChild(root_1, stream_type.nextTree());
				adaptor.addChild(root_1, stream_declare_rest.nextTree());
				// src/exm/stc/ast/ExM.g:489:50: ( declare_rest_more )*
				while ( stream_declare_rest_more.hasNext() ) {
					adaptor.addChild(root_1, stream_declare_rest_more.nextTree());
				}
				stream_declare_rest_more.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "declaration_multi"


	public static class declare_rest_more_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "declare_rest_more"
	// src/exm/stc/ast/ExM.g:492:1: declare_rest_more : COMMA declare_rest -> declare_rest ;
	public final ExMParser.declare_rest_more_return declare_rest_more() throws RecognitionException {
		ExMParser.declare_rest_more_return retval = new ExMParser.declare_rest_more_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMA180=null;
		ParserRuleReturnScope declare_rest181 =null;

		Object COMMA180_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_declare_rest=new RewriteRuleSubtreeStream(adaptor,"rule declare_rest");

		try {
			// src/exm/stc/ast/ExM.g:492:18: ( COMMA declare_rest -> declare_rest )
			// src/exm/stc/ast/ExM.g:493:9: COMMA declare_rest
			{
			COMMA180=(Token)match(input,COMMA,FOLLOW_COMMA_in_declare_rest_more3908); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_COMMA.add(COMMA180);

			pushFollow(FOLLOW_declare_rest_in_declare_rest_more3910);
			declare_rest181=declare_rest();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_declare_rest.add(declare_rest181.getTree());
			// AST REWRITE
			// elements: declare_rest
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 493:28: -> declare_rest
			{
				adaptor.addChild(root_0, stream_declare_rest.nextTree());
			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "declare_rest_more"


	public static class declare_assign_single_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "declare_assign_single"
	// src/exm/stc/ast/ExM.g:498:1: declare_assign_single : type= type_prefix v= var_name ( array_marker )* ( mapping )? ASSIGN expr -> ^( DECLARATION $type ^( DECLARE_ASSIGN ^( DECLARE_VARIABLE_REST $v ( mapping )? ( array_marker )* ) expr ) ) ;
	public final ExMParser.declare_assign_single_return declare_assign_single() throws RecognitionException {
		ExMParser.declare_assign_single_return retval = new ExMParser.declare_assign_single_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ASSIGN184=null;
		ParserRuleReturnScope type =null;
		ParserRuleReturnScope v =null;
		ParserRuleReturnScope array_marker182 =null;
		ParserRuleReturnScope mapping183 =null;
		ParserRuleReturnScope expr185 =null;

		Object ASSIGN184_tree=null;
		RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
		RewriteRuleSubtreeStream stream_mapping=new RewriteRuleSubtreeStream(adaptor,"rule mapping");
		RewriteRuleSubtreeStream stream_type_prefix=new RewriteRuleSubtreeStream(adaptor,"rule type_prefix");
		RewriteRuleSubtreeStream stream_array_marker=new RewriteRuleSubtreeStream(adaptor,"rule array_marker");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_var_name=new RewriteRuleSubtreeStream(adaptor,"rule var_name");

		try {
			// src/exm/stc/ast/ExM.g:498:22: (type= type_prefix v= var_name ( array_marker )* ( mapping )? ASSIGN expr -> ^( DECLARATION $type ^( DECLARE_ASSIGN ^( DECLARE_VARIABLE_REST $v ( mapping )? ( array_marker )* ) expr ) ) )
			// src/exm/stc/ast/ExM.g:499:9: type= type_prefix v= var_name ( array_marker )* ( mapping )? ASSIGN expr
			{
			pushFollow(FOLLOW_type_prefix_in_declare_assign_single3938);
			type=type_prefix();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_type_prefix.add(type.getTree());
			pushFollow(FOLLOW_var_name_in_declare_assign_single3942);
			v=var_name();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_var_name.add(v.getTree());
			// src/exm/stc/ast/ExM.g:499:37: ( array_marker )*
			loop52:
			while (true) {
				int alt52=2;
				int LA52_0 = input.LA(1);
				if ( (LA52_0==LSQUARE) ) {
					alt52=1;
				}

				switch (alt52) {
				case 1 :
					// src/exm/stc/ast/ExM.g:499:37: array_marker
					{
					pushFollow(FOLLOW_array_marker_in_declare_assign_single3944);
					array_marker182=array_marker();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_array_marker.add(array_marker182.getTree());
					}
					break;

				default :
					break loop52;
				}
			}

			// src/exm/stc/ast/ExM.g:499:51: ( mapping )?
			int alt53=2;
			int LA53_0 = input.LA(1);
			if ( (LA53_0==LT) ) {
				alt53=1;
			}
			switch (alt53) {
				case 1 :
					// src/exm/stc/ast/ExM.g:499:51: mapping
					{
					pushFollow(FOLLOW_mapping_in_declare_assign_single3947);
					mapping183=mapping();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_mapping.add(mapping183.getTree());
					}
					break;

			}

			ASSIGN184=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_declare_assign_single3950); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN184);

			pushFollow(FOLLOW_expr_in_declare_assign_single3952);
			expr185=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(expr185.getTree());
			// AST REWRITE
			// elements: mapping, array_marker, expr, v, type
			// token labels: 
			// rule labels: v, type, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_v=new RewriteRuleSubtreeStream(adaptor,"rule v",v!=null?v.getTree():null);
			RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type",type!=null?type.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 500:13: -> ^( DECLARATION $type ^( DECLARE_ASSIGN ^( DECLARE_VARIABLE_REST $v ( mapping )? ( array_marker )* ) expr ) )
			{
				// src/exm/stc/ast/ExM.g:500:16: ^( DECLARATION $type ^( DECLARE_ASSIGN ^( DECLARE_VARIABLE_REST $v ( mapping )? ( array_marker )* ) expr ) )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DECLARATION, "DECLARATION"), root_1);
				adaptor.addChild(root_1, stream_type.nextTree());
				// src/exm/stc/ast/ExM.g:501:19: ^( DECLARE_ASSIGN ^( DECLARE_VARIABLE_REST $v ( mapping )? ( array_marker )* ) expr )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(DECLARE_ASSIGN, "DECLARE_ASSIGN"), root_2);
				// src/exm/stc/ast/ExM.g:502:21: ^( DECLARE_VARIABLE_REST $v ( mapping )? ( array_marker )* )
				{
				Object root_3 = (Object)adaptor.nil();
				root_3 = (Object)adaptor.becomeRoot((Object)adaptor.create(DECLARE_VARIABLE_REST, "DECLARE_VARIABLE_REST"), root_3);
				adaptor.addChild(root_3, stream_v.nextTree());
				// src/exm/stc/ast/ExM.g:502:49: ( mapping )?
				if ( stream_mapping.hasNext() ) {
					adaptor.addChild(root_3, stream_mapping.nextTree());
				}
				stream_mapping.reset();

				// src/exm/stc/ast/ExM.g:502:58: ( array_marker )*
				while ( stream_array_marker.hasNext() ) {
					adaptor.addChild(root_3, stream_array_marker.nextTree());
				}
				stream_array_marker.reset();

				adaptor.addChild(root_2, root_3);
				}

				adaptor.addChild(root_2, stream_expr.nextTree());
				adaptor.addChild(root_1, root_2);
				}

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "declare_assign_single"


	public static class declare_rest_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "declare_rest"
	// src/exm/stc/ast/ExM.g:506:1: declare_rest : v= var_name ( array_marker )* ( mapping )? ( -> ^( DECLARE_VARIABLE_REST $v ( array_marker )* ( mapping )? ) | ASSIGN expr -> ^( DECLARE_ASSIGN ^( DECLARE_VARIABLE_REST $v ( array_marker )* ( mapping )? ) expr ) ) ;
	public final ExMParser.declare_rest_return declare_rest() throws RecognitionException {
		ExMParser.declare_rest_return retval = new ExMParser.declare_rest_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ASSIGN188=null;
		ParserRuleReturnScope v =null;
		ParserRuleReturnScope array_marker186 =null;
		ParserRuleReturnScope mapping187 =null;
		ParserRuleReturnScope expr189 =null;

		Object ASSIGN188_tree=null;
		RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
		RewriteRuleSubtreeStream stream_mapping=new RewriteRuleSubtreeStream(adaptor,"rule mapping");
		RewriteRuleSubtreeStream stream_array_marker=new RewriteRuleSubtreeStream(adaptor,"rule array_marker");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_var_name=new RewriteRuleSubtreeStream(adaptor,"rule var_name");

		try {
			// src/exm/stc/ast/ExM.g:506:13: (v= var_name ( array_marker )* ( mapping )? ( -> ^( DECLARE_VARIABLE_REST $v ( array_marker )* ( mapping )? ) | ASSIGN expr -> ^( DECLARE_ASSIGN ^( DECLARE_VARIABLE_REST $v ( array_marker )* ( mapping )? ) expr ) ) )
			// src/exm/stc/ast/ExM.g:507:5: v= var_name ( array_marker )* ( mapping )? ( -> ^( DECLARE_VARIABLE_REST $v ( array_marker )* ( mapping )? ) | ASSIGN expr -> ^( DECLARE_ASSIGN ^( DECLARE_VARIABLE_REST $v ( array_marker )* ( mapping )? ) expr ) )
			{
			pushFollow(FOLLOW_var_name_in_declare_rest4074);
			v=var_name();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_var_name.add(v.getTree());
			// src/exm/stc/ast/ExM.g:507:16: ( array_marker )*
			loop54:
			while (true) {
				int alt54=2;
				int LA54_0 = input.LA(1);
				if ( (LA54_0==LSQUARE) ) {
					alt54=1;
				}

				switch (alt54) {
				case 1 :
					// src/exm/stc/ast/ExM.g:507:16: array_marker
					{
					pushFollow(FOLLOW_array_marker_in_declare_rest4076);
					array_marker186=array_marker();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_array_marker.add(array_marker186.getTree());
					}
					break;

				default :
					break loop54;
				}
			}

			// src/exm/stc/ast/ExM.g:507:30: ( mapping )?
			int alt55=2;
			int LA55_0 = input.LA(1);
			if ( (LA55_0==LT) ) {
				alt55=1;
			}
			switch (alt55) {
				case 1 :
					// src/exm/stc/ast/ExM.g:507:30: mapping
					{
					pushFollow(FOLLOW_mapping_in_declare_rest4079);
					mapping187=mapping();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_mapping.add(mapping187.getTree());
					}
					break;

			}

			// src/exm/stc/ast/ExM.g:507:39: ( -> ^( DECLARE_VARIABLE_REST $v ( array_marker )* ( mapping )? ) | ASSIGN expr -> ^( DECLARE_ASSIGN ^( DECLARE_VARIABLE_REST $v ( array_marker )* ( mapping )? ) expr ) )
			int alt56=2;
			int LA56_0 = input.LA(1);
			if ( (LA56_0==EOF||LA56_0==COMMA||LA56_0==SEMICOLON) ) {
				alt56=1;
			}
			else if ( (LA56_0==ASSIGN) ) {
				int LA56_2 = input.LA(2);
				if ( (LA56_2==GT) ) {
					alt56=1;
				}
				else if ( (LA56_2==ATSIGN||(LA56_2 >= DECIMAL && LA56_2 <= DECIMAL_INT)||LA56_2==FALSE||(LA56_2 >= HEX_INT && LA56_2 <= ID)||LA56_2==INFINITY||(LA56_2 >= LBRACE && LA56_2 <= LSQUARE)||LA56_2==MINUS||(LA56_2 >= NOT && LA56_2 <= NOTANUMBER)||LA56_2==OCTAL_INT||LA56_2==SCI_DECIMAL||LA56_2==STRING||(LA56_2 >= STRING_MULTI_LINE_1 && LA56_2 <= STRING_MULTI_LINE_2)||LA56_2==TRUE) ) {
					alt56=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 56, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 56, 0, input);
				throw nvae;
			}

			switch (alt56) {
				case 1 :
					// src/exm/stc/ast/ExM.g:508:23: 
					{
					// AST REWRITE
					// elements: array_marker, mapping, v
					// token labels: 
					// rule labels: v, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_v=new RewriteRuleSubtreeStream(adaptor,"rule v",v!=null?v.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 508:23: -> ^( DECLARE_VARIABLE_REST $v ( array_marker )* ( mapping )? )
					{
						// src/exm/stc/ast/ExM.g:508:27: ^( DECLARE_VARIABLE_REST $v ( array_marker )* ( mapping )? )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DECLARE_VARIABLE_REST, "DECLARE_VARIABLE_REST"), root_1);
						adaptor.addChild(root_1, stream_v.nextTree());
						// src/exm/stc/ast/ExM.g:508:55: ( array_marker )*
						while ( stream_array_marker.hasNext() ) {
							adaptor.addChild(root_1, stream_array_marker.nextTree());
						}
						stream_array_marker.reset();

						// src/exm/stc/ast/ExM.g:509:30: ( mapping )?
						if ( stream_mapping.hasNext() ) {
							adaptor.addChild(root_1, stream_mapping.nextTree());
						}
						stream_mapping.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:510:11: ASSIGN expr
					{
					ASSIGN188=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_declare_rest4152); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN188);

					pushFollow(FOLLOW_expr_in_declare_rest4154);
					expr189=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr189.getTree());
					// AST REWRITE
					// elements: array_marker, v, mapping, expr
					// token labels: 
					// rule labels: v, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_v=new RewriteRuleSubtreeStream(adaptor,"rule v",v!=null?v.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 510:23: -> ^( DECLARE_ASSIGN ^( DECLARE_VARIABLE_REST $v ( array_marker )* ( mapping )? ) expr )
					{
						// src/exm/stc/ast/ExM.g:510:27: ^( DECLARE_ASSIGN ^( DECLARE_VARIABLE_REST $v ( array_marker )* ( mapping )? ) expr )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DECLARE_ASSIGN, "DECLARE_ASSIGN"), root_1);
						// src/exm/stc/ast/ExM.g:511:12: ^( DECLARE_VARIABLE_REST $v ( array_marker )* ( mapping )? )
						{
						Object root_2 = (Object)adaptor.nil();
						root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(DECLARE_VARIABLE_REST, "DECLARE_VARIABLE_REST"), root_2);
						adaptor.addChild(root_2, stream_v.nextTree());
						// src/exm/stc/ast/ExM.g:511:40: ( array_marker )*
						while ( stream_array_marker.hasNext() ) {
							adaptor.addChild(root_2, stream_array_marker.nextTree());
						}
						stream_array_marker.reset();

						// src/exm/stc/ast/ExM.g:511:54: ( mapping )?
						if ( stream_mapping.hasNext() ) {
							adaptor.addChild(root_2, stream_mapping.nextTree());
						}
						stream_mapping.reset();

						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_1, stream_expr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "declare_rest"


	public static class array_marker_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "array_marker"
	// src/exm/stc/ast/ExM.g:514:1: array_marker : LSQUARE ( standalone_type )? RSQUARE -> ^( ARRAY ( standalone_type )? ) ;
	public final ExMParser.array_marker_return array_marker() throws RecognitionException {
		ExMParser.array_marker_return retval = new ExMParser.array_marker_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LSQUARE190=null;
		Token RSQUARE192=null;
		ParserRuleReturnScope standalone_type191 =null;

		Object LSQUARE190_tree=null;
		Object RSQUARE192_tree=null;
		RewriteRuleTokenStream stream_LSQUARE=new RewriteRuleTokenStream(adaptor,"token LSQUARE");
		RewriteRuleTokenStream stream_RSQUARE=new RewriteRuleTokenStream(adaptor,"token RSQUARE");
		RewriteRuleSubtreeStream stream_standalone_type=new RewriteRuleSubtreeStream(adaptor,"rule standalone_type");

		try {
			// src/exm/stc/ast/ExM.g:514:13: ( LSQUARE ( standalone_type )? RSQUARE -> ^( ARRAY ( standalone_type )? ) )
			// src/exm/stc/ast/ExM.g:515:9: LSQUARE ( standalone_type )? RSQUARE
			{
			LSQUARE190=(Token)match(input,LSQUARE,FOLLOW_LSQUARE_in_array_marker4211); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LSQUARE.add(LSQUARE190);

			// src/exm/stc/ast/ExM.g:515:17: ( standalone_type )?
			int alt57=2;
			int LA57_0 = input.LA(1);
			if ( (LA57_0==ID) ) {
				alt57=1;
			}
			switch (alt57) {
				case 1 :
					// src/exm/stc/ast/ExM.g:515:17: standalone_type
					{
					pushFollow(FOLLOW_standalone_type_in_array_marker4213);
					standalone_type191=standalone_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_standalone_type.add(standalone_type191.getTree());
					}
					break;

			}

			RSQUARE192=(Token)match(input,RSQUARE,FOLLOW_RSQUARE_in_array_marker4216); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RSQUARE.add(RSQUARE192);

			// AST REWRITE
			// elements: standalone_type
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 515:42: -> ^( ARRAY ( standalone_type )? )
			{
				// src/exm/stc/ast/ExM.g:515:45: ^( ARRAY ( standalone_type )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARRAY, "ARRAY"), root_1);
				// src/exm/stc/ast/ExM.g:515:54: ( standalone_type )?
				if ( stream_standalone_type.hasNext() ) {
					adaptor.addChild(root_1, stream_standalone_type.nextTree());
				}
				stream_standalone_type.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "array_marker"


	public static class mapping_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "mapping"
	// src/exm/stc/ast/ExM.g:518:1: mapping : LT s= expr GT -> ^( MAPPING $s) ;
	public final ExMParser.mapping_return mapping() throws RecognitionException {
		ExMParser.mapping_return retval = new ExMParser.mapping_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LT193=null;
		Token GT194=null;
		ParserRuleReturnScope s =null;

		Object LT193_tree=null;
		Object GT194_tree=null;
		RewriteRuleTokenStream stream_LT=new RewriteRuleTokenStream(adaptor,"token LT");
		RewriteRuleTokenStream stream_GT=new RewriteRuleTokenStream(adaptor,"token GT");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// src/exm/stc/ast/ExM.g:518:8: ( LT s= expr GT -> ^( MAPPING $s) )
			// src/exm/stc/ast/ExM.g:519:5: LT s= expr GT
			{
			LT193=(Token)match(input,LT,FOLLOW_LT_in_mapping4243); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LT.add(LT193);

			pushFollow(FOLLOW_expr_in_mapping4247);
			s=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(s.getTree());
			GT194=(Token)match(input,GT,FOLLOW_GT_in_mapping4249); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_GT.add(GT194);

			// AST REWRITE
			// elements: s
			// token labels: 
			// rule labels: s, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_s=new RewriteRuleSubtreeStream(adaptor,"rule s",s!=null?s.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 520:9: -> ^( MAPPING $s)
			{
				// src/exm/stc/ast/ExM.g:520:12: ^( MAPPING $s)
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MAPPING, "MAPPING"), root_1);
				adaptor.addChild(root_1, stream_s.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "mapping"


	public static class expr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr"
	// src/exm/stc/ast/ExM.g:523:1: expr : orexpr ;
	public final ExMParser.expr_return expr() throws RecognitionException {
		ExMParser.expr_return retval = new ExMParser.expr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope orexpr195 =null;


		try {
			// src/exm/stc/ast/ExM.g:523:5: ( orexpr )
			// src/exm/stc/ast/ExM.g:523:7: orexpr
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_orexpr_in_expr4280);
			orexpr195=orexpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, orexpr195.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr"


	public static class orexpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "orexpr"
	// src/exm/stc/ast/ExM.g:529:1: orexpr : ( andexpr -> andexpr ) ( OR b= andexpr -> ^( OPERATOR OR $orexpr $b) )* ;
	public final ExMParser.orexpr_return orexpr() throws RecognitionException {
		ExMParser.orexpr_return retval = new ExMParser.orexpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token OR197=null;
		ParserRuleReturnScope b =null;
		ParserRuleReturnScope andexpr196 =null;

		Object OR197_tree=null;
		RewriteRuleTokenStream stream_OR=new RewriteRuleTokenStream(adaptor,"token OR");
		RewriteRuleSubtreeStream stream_andexpr=new RewriteRuleSubtreeStream(adaptor,"rule andexpr");

		try {
			// src/exm/stc/ast/ExM.g:529:7: ( ( andexpr -> andexpr ) ( OR b= andexpr -> ^( OPERATOR OR $orexpr $b) )* )
			// src/exm/stc/ast/ExM.g:530:9: ( andexpr -> andexpr ) ( OR b= andexpr -> ^( OPERATOR OR $orexpr $b) )*
			{
			// src/exm/stc/ast/ExM.g:530:9: ( andexpr -> andexpr )
			// src/exm/stc/ast/ExM.g:530:10: andexpr
			{
			pushFollow(FOLLOW_andexpr_in_orexpr4299);
			andexpr196=andexpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_andexpr.add(andexpr196.getTree());
			// AST REWRITE
			// elements: andexpr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 530:17: -> andexpr
			{
				adaptor.addChild(root_0, stream_andexpr.nextTree());
			}


			retval.tree = root_0;
			}

			}

			// src/exm/stc/ast/ExM.g:531:9: ( OR b= andexpr -> ^( OPERATOR OR $orexpr $b) )*
			loop58:
			while (true) {
				int alt58=2;
				int LA58_0 = input.LA(1);
				if ( (LA58_0==OR) ) {
					alt58=1;
				}

				switch (alt58) {
				case 1 :
					// src/exm/stc/ast/ExM.g:531:15: OR b= andexpr
					{
					OR197=(Token)match(input,OR,FOLLOW_OR_in_orexpr4318); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OR.add(OR197);

					pushFollow(FOLLOW_andexpr_in_orexpr4322);
					b=andexpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_andexpr.add(b.getTree());
					// AST REWRITE
					// elements: OR, b, orexpr
					// token labels: 
					// rule labels: b, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 532:13: -> ^( OPERATOR OR $orexpr $b)
					{
						// src/exm/stc/ast/ExM.g:532:16: ^( OPERATOR OR $orexpr $b)
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OPERATOR, "OPERATOR"), root_1);
						adaptor.addChild(root_1, stream_OR.nextNode());
						adaptor.addChild(root_1, stream_retval.nextTree());
						adaptor.addChild(root_1, stream_b.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

				default :
					break loop58;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "orexpr"


	public static class andexpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "andexpr"
	// src/exm/stc/ast/ExM.g:536:1: andexpr : ( eqexpr -> eqexpr ) ( AND b= eqexpr -> ^( OPERATOR AND $andexpr $b) )* ;
	public final ExMParser.andexpr_return andexpr() throws RecognitionException {
		ExMParser.andexpr_return retval = new ExMParser.andexpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token AND199=null;
		ParserRuleReturnScope b =null;
		ParserRuleReturnScope eqexpr198 =null;

		Object AND199_tree=null;
		RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
		RewriteRuleSubtreeStream stream_eqexpr=new RewriteRuleSubtreeStream(adaptor,"rule eqexpr");

		try {
			// src/exm/stc/ast/ExM.g:536:8: ( ( eqexpr -> eqexpr ) ( AND b= eqexpr -> ^( OPERATOR AND $andexpr $b) )* )
			// src/exm/stc/ast/ExM.g:537:9: ( eqexpr -> eqexpr ) ( AND b= eqexpr -> ^( OPERATOR AND $andexpr $b) )*
			{
			// src/exm/stc/ast/ExM.g:537:9: ( eqexpr -> eqexpr )
			// src/exm/stc/ast/ExM.g:537:10: eqexpr
			{
			pushFollow(FOLLOW_eqexpr_in_andexpr4380);
			eqexpr198=eqexpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_eqexpr.add(eqexpr198.getTree());
			// AST REWRITE
			// elements: eqexpr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 537:16: -> eqexpr
			{
				adaptor.addChild(root_0, stream_eqexpr.nextTree());
			}


			retval.tree = root_0;
			}

			}

			// src/exm/stc/ast/ExM.g:538:9: ( AND b= eqexpr -> ^( OPERATOR AND $andexpr $b) )*
			loop59:
			while (true) {
				int alt59=2;
				int LA59_0 = input.LA(1);
				if ( (LA59_0==AND) ) {
					alt59=1;
				}

				switch (alt59) {
				case 1 :
					// src/exm/stc/ast/ExM.g:538:15: AND b= eqexpr
					{
					AND199=(Token)match(input,AND,FOLLOW_AND_in_andexpr4399); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_AND.add(AND199);

					pushFollow(FOLLOW_eqexpr_in_andexpr4403);
					b=eqexpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_eqexpr.add(b.getTree());
					// AST REWRITE
					// elements: andexpr, b, AND
					// token labels: 
					// rule labels: b, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 539:13: -> ^( OPERATOR AND $andexpr $b)
					{
						// src/exm/stc/ast/ExM.g:539:16: ^( OPERATOR AND $andexpr $b)
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OPERATOR, "OPERATOR"), root_1);
						adaptor.addChild(root_1, stream_AND.nextNode());
						adaptor.addChild(root_1, stream_retval.nextTree());
						adaptor.addChild(root_1, stream_b.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

				default :
					break loop59;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "andexpr"


	public static class eqexpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "eqexpr"
	// src/exm/stc/ast/ExM.g:543:1: eqexpr : ( cmpexpr -> cmpexpr ) ( eqexpr_op b= cmpexpr -> ^( OPERATOR eqexpr_op $eqexpr $b) )* ;
	public final ExMParser.eqexpr_return eqexpr() throws RecognitionException {
		ExMParser.eqexpr_return retval = new ExMParser.eqexpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope b =null;
		ParserRuleReturnScope cmpexpr200 =null;
		ParserRuleReturnScope eqexpr_op201 =null;

		RewriteRuleSubtreeStream stream_eqexpr_op=new RewriteRuleSubtreeStream(adaptor,"rule eqexpr_op");
		RewriteRuleSubtreeStream stream_cmpexpr=new RewriteRuleSubtreeStream(adaptor,"rule cmpexpr");

		try {
			// src/exm/stc/ast/ExM.g:543:7: ( ( cmpexpr -> cmpexpr ) ( eqexpr_op b= cmpexpr -> ^( OPERATOR eqexpr_op $eqexpr $b) )* )
			// src/exm/stc/ast/ExM.g:544:9: ( cmpexpr -> cmpexpr ) ( eqexpr_op b= cmpexpr -> ^( OPERATOR eqexpr_op $eqexpr $b) )*
			{
			// src/exm/stc/ast/ExM.g:544:9: ( cmpexpr -> cmpexpr )
			// src/exm/stc/ast/ExM.g:544:10: cmpexpr
			{
			pushFollow(FOLLOW_cmpexpr_in_eqexpr4461);
			cmpexpr200=cmpexpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_cmpexpr.add(cmpexpr200.getTree());
			// AST REWRITE
			// elements: cmpexpr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 544:17: -> cmpexpr
			{
				adaptor.addChild(root_0, stream_cmpexpr.nextTree());
			}


			retval.tree = root_0;
			}

			}

			// src/exm/stc/ast/ExM.g:545:9: ( eqexpr_op b= cmpexpr -> ^( OPERATOR eqexpr_op $eqexpr $b) )*
			loop60:
			while (true) {
				int alt60=2;
				int LA60_0 = input.LA(1);
				if ( (LA60_0==EQUALS||LA60_0==NEQUALS) ) {
					alt60=1;
				}

				switch (alt60) {
				case 1 :
					// src/exm/stc/ast/ExM.g:545:15: eqexpr_op b= cmpexpr
					{
					pushFollow(FOLLOW_eqexpr_op_in_eqexpr4480);
					eqexpr_op201=eqexpr_op();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_eqexpr_op.add(eqexpr_op201.getTree());
					pushFollow(FOLLOW_cmpexpr_in_eqexpr4484);
					b=cmpexpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_cmpexpr.add(b.getTree());
					// AST REWRITE
					// elements: b, eqexpr, eqexpr_op
					// token labels: 
					// rule labels: b, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 546:13: -> ^( OPERATOR eqexpr_op $eqexpr $b)
					{
						// src/exm/stc/ast/ExM.g:546:16: ^( OPERATOR eqexpr_op $eqexpr $b)
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OPERATOR, "OPERATOR"), root_1);
						adaptor.addChild(root_1, stream_eqexpr_op.nextTree());
						adaptor.addChild(root_1, stream_retval.nextTree());
						adaptor.addChild(root_1, stream_b.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

				default :
					break loop60;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "eqexpr"


	public static class eqexpr_op_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "eqexpr_op"
	// src/exm/stc/ast/ExM.g:549:1: eqexpr_op : ( EQUALS | NEQUALS );
	public final ExMParser.eqexpr_op_return eqexpr_op() throws RecognitionException {
		ExMParser.eqexpr_op_return retval = new ExMParser.eqexpr_op_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set202=null;

		Object set202_tree=null;

		try {
			// src/exm/stc/ast/ExM.g:549:11: ( EQUALS | NEQUALS )
			// src/exm/stc/ast/ExM.g:
			{
			root_0 = (Object)adaptor.nil();


			set202=input.LT(1);
			if ( input.LA(1)==EQUALS||input.LA(1)==NEQUALS ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set202));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "eqexpr_op"


	public static class cmpexpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "cmpexpr"
	// src/exm/stc/ast/ExM.g:552:1: cmpexpr : ( aexpr -> aexpr ) ( cmpexpr_op b= aexpr -> ^( OPERATOR cmpexpr_op $cmpexpr $b) )* ;
	public final ExMParser.cmpexpr_return cmpexpr() throws RecognitionException {
		ExMParser.cmpexpr_return retval = new ExMParser.cmpexpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope b =null;
		ParserRuleReturnScope aexpr203 =null;
		ParserRuleReturnScope cmpexpr_op204 =null;

		RewriteRuleSubtreeStream stream_aexpr=new RewriteRuleSubtreeStream(adaptor,"rule aexpr");
		RewriteRuleSubtreeStream stream_cmpexpr_op=new RewriteRuleSubtreeStream(adaptor,"rule cmpexpr_op");

		try {
			// src/exm/stc/ast/ExM.g:552:8: ( ( aexpr -> aexpr ) ( cmpexpr_op b= aexpr -> ^( OPERATOR cmpexpr_op $cmpexpr $b) )* )
			// src/exm/stc/ast/ExM.g:553:9: ( aexpr -> aexpr ) ( cmpexpr_op b= aexpr -> ^( OPERATOR cmpexpr_op $cmpexpr $b) )*
			{
			// src/exm/stc/ast/ExM.g:553:9: ( aexpr -> aexpr )
			// src/exm/stc/ast/ExM.g:553:10: aexpr
			{
			pushFollow(FOLLOW_aexpr_in_cmpexpr4556);
			aexpr203=aexpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_aexpr.add(aexpr203.getTree());
			// AST REWRITE
			// elements: aexpr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 553:15: -> aexpr
			{
				adaptor.addChild(root_0, stream_aexpr.nextTree());
			}


			retval.tree = root_0;
			}

			}

			// src/exm/stc/ast/ExM.g:554:9: ( cmpexpr_op b= aexpr -> ^( OPERATOR cmpexpr_op $cmpexpr $b) )*
			loop61:
			while (true) {
				int alt61=2;
				int LA61_0 = input.LA(1);
				if ( (LA61_0==GT) ) {
					int LA61_2 = input.LA(2);
					if ( (LA61_2==ATSIGN||(LA61_2 >= DECIMAL && LA61_2 <= DECIMAL_INT)||LA61_2==FALSE||(LA61_2 >= HEX_INT && LA61_2 <= ID)||LA61_2==INFINITY||(LA61_2 >= LBRACE && LA61_2 <= LSQUARE)||LA61_2==MINUS||(LA61_2 >= NOT && LA61_2 <= NOTANUMBER)||LA61_2==OCTAL_INT||LA61_2==SCI_DECIMAL||LA61_2==STRING||(LA61_2 >= STRING_MULTI_LINE_1 && LA61_2 <= STRING_MULTI_LINE_2)||LA61_2==TRUE) ) {
						alt61=1;
					}

				}
				else if ( (LA61_0==GTE||(LA61_0 >= LT && LA61_0 <= LTE)) ) {
					alt61=1;
				}

				switch (alt61) {
				case 1 :
					// src/exm/stc/ast/ExM.g:554:15: cmpexpr_op b= aexpr
					{
					pushFollow(FOLLOW_cmpexpr_op_in_cmpexpr4575);
					cmpexpr_op204=cmpexpr_op();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_cmpexpr_op.add(cmpexpr_op204.getTree());
					pushFollow(FOLLOW_aexpr_in_cmpexpr4579);
					b=aexpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_aexpr.add(b.getTree());
					// AST REWRITE
					// elements: b, cmpexpr, cmpexpr_op
					// token labels: 
					// rule labels: b, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 555:13: -> ^( OPERATOR cmpexpr_op $cmpexpr $b)
					{
						// src/exm/stc/ast/ExM.g:555:16: ^( OPERATOR cmpexpr_op $cmpexpr $b)
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OPERATOR, "OPERATOR"), root_1);
						adaptor.addChild(root_1, stream_cmpexpr_op.nextTree());
						adaptor.addChild(root_1, stream_retval.nextTree());
						adaptor.addChild(root_1, stream_b.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

				default :
					break loop61;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "cmpexpr"


	public static class cmpexpr_op_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "cmpexpr_op"
	// src/exm/stc/ast/ExM.g:558:1: cmpexpr_op : ( LT | LTE | GT | GTE );
	public final ExMParser.cmpexpr_op_return cmpexpr_op() throws RecognitionException {
		ExMParser.cmpexpr_op_return retval = new ExMParser.cmpexpr_op_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set205=null;

		Object set205_tree=null;

		try {
			// src/exm/stc/ast/ExM.g:558:11: ( LT | LTE | GT | GTE )
			// src/exm/stc/ast/ExM.g:
			{
			root_0 = (Object)adaptor.nil();


			set205=input.LT(1);
			if ( (input.LA(1) >= GT && input.LA(1) <= GTE)||(input.LA(1) >= LT && input.LA(1) <= LTE) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set205));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "cmpexpr_op"


	public static class aexpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "aexpr"
	// src/exm/stc/ast/ExM.g:561:1: aexpr : ( mexpr -> mexpr ) ( aexpr_op b= mexpr -> ^( OPERATOR aexpr_op $aexpr $b) )* ;
	public final ExMParser.aexpr_return aexpr() throws RecognitionException {
		ExMParser.aexpr_return retval = new ExMParser.aexpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope b =null;
		ParserRuleReturnScope mexpr206 =null;
		ParserRuleReturnScope aexpr_op207 =null;

		RewriteRuleSubtreeStream stream_aexpr_op=new RewriteRuleSubtreeStream(adaptor,"rule aexpr_op");
		RewriteRuleSubtreeStream stream_mexpr=new RewriteRuleSubtreeStream(adaptor,"rule mexpr");

		try {
			// src/exm/stc/ast/ExM.g:561:6: ( ( mexpr -> mexpr ) ( aexpr_op b= mexpr -> ^( OPERATOR aexpr_op $aexpr $b) )* )
			// src/exm/stc/ast/ExM.g:562:9: ( mexpr -> mexpr ) ( aexpr_op b= mexpr -> ^( OPERATOR aexpr_op $aexpr $b) )*
			{
			// src/exm/stc/ast/ExM.g:562:9: ( mexpr -> mexpr )
			// src/exm/stc/ast/ExM.g:562:10: mexpr
			{
			pushFollow(FOLLOW_mexpr_in_aexpr4654);
			mexpr206=mexpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_mexpr.add(mexpr206.getTree());
			// AST REWRITE
			// elements: mexpr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 562:15: -> mexpr
			{
				adaptor.addChild(root_0, stream_mexpr.nextTree());
			}


			retval.tree = root_0;
			}

			}

			// src/exm/stc/ast/ExM.g:563:9: ( aexpr_op b= mexpr -> ^( OPERATOR aexpr_op $aexpr $b) )*
			loop62:
			while (true) {
				int alt62=2;
				int LA62_0 = input.LA(1);
				if ( (LA62_0==MINUS) ) {
					int LA62_21 = input.LA(2);
					if ( (synpred88_ExM()) ) {
						alt62=1;
					}

				}
				else if ( (LA62_0==PLUS) ) {
					alt62=1;
				}

				switch (alt62) {
				case 1 :
					// src/exm/stc/ast/ExM.g:563:15: aexpr_op b= mexpr
					{
					pushFollow(FOLLOW_aexpr_op_in_aexpr4673);
					aexpr_op207=aexpr_op();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_aexpr_op.add(aexpr_op207.getTree());
					pushFollow(FOLLOW_mexpr_in_aexpr4677);
					b=mexpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_mexpr.add(b.getTree());
					// AST REWRITE
					// elements: aexpr_op, aexpr, b
					// token labels: 
					// rule labels: b, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 564:13: -> ^( OPERATOR aexpr_op $aexpr $b)
					{
						// src/exm/stc/ast/ExM.g:564:16: ^( OPERATOR aexpr_op $aexpr $b)
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OPERATOR, "OPERATOR"), root_1);
						adaptor.addChild(root_1, stream_aexpr_op.nextTree());
						adaptor.addChild(root_1, stream_retval.nextTree());
						adaptor.addChild(root_1, stream_b.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

				default :
					break loop62;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "aexpr"


	public static class aexpr_op_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "aexpr_op"
	// src/exm/stc/ast/ExM.g:568:1: aexpr_op : ( PLUS | MINUS );
	public final ExMParser.aexpr_op_return aexpr_op() throws RecognitionException {
		ExMParser.aexpr_op_return retval = new ExMParser.aexpr_op_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set208=null;

		Object set208_tree=null;

		try {
			// src/exm/stc/ast/ExM.g:568:9: ( PLUS | MINUS )
			// src/exm/stc/ast/ExM.g:
			{
			root_0 = (Object)adaptor.nil();


			set208=input.LT(1);
			if ( input.LA(1)==MINUS||input.LA(1)==PLUS ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set208));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "aexpr_op"


	public static class mexpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "mexpr"
	// src/exm/stc/ast/ExM.g:571:1: mexpr : ( powexpr -> powexpr ) ( mexpr_op e= powexpr -> ^( OPERATOR mexpr_op $mexpr $e) )* ;
	public final ExMParser.mexpr_return mexpr() throws RecognitionException {
		ExMParser.mexpr_return retval = new ExMParser.mexpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope e =null;
		ParserRuleReturnScope powexpr209 =null;
		ParserRuleReturnScope mexpr_op210 =null;

		RewriteRuleSubtreeStream stream_mexpr_op=new RewriteRuleSubtreeStream(adaptor,"rule mexpr_op");
		RewriteRuleSubtreeStream stream_powexpr=new RewriteRuleSubtreeStream(adaptor,"rule powexpr");

		try {
			// src/exm/stc/ast/ExM.g:571:6: ( ( powexpr -> powexpr ) ( mexpr_op e= powexpr -> ^( OPERATOR mexpr_op $mexpr $e) )* )
			// src/exm/stc/ast/ExM.g:572:9: ( powexpr -> powexpr ) ( mexpr_op e= powexpr -> ^( OPERATOR mexpr_op $mexpr $e) )*
			{
			// src/exm/stc/ast/ExM.g:572:9: ( powexpr -> powexpr )
			// src/exm/stc/ast/ExM.g:572:10: powexpr
			{
			pushFollow(FOLLOW_powexpr_in_mexpr4751);
			powexpr209=powexpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_powexpr.add(powexpr209.getTree());
			// AST REWRITE
			// elements: powexpr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 572:17: -> powexpr
			{
				adaptor.addChild(root_0, stream_powexpr.nextTree());
			}


			retval.tree = root_0;
			}

			}

			// src/exm/stc/ast/ExM.g:573:9: ( mexpr_op e= powexpr -> ^( OPERATOR mexpr_op $mexpr $e) )*
			loop63:
			while (true) {
				int alt63=2;
				int LA63_0 = input.LA(1);
				if ( (LA63_0==DIV||LA63_0==INTDIV||(LA63_0 >= MOD && LA63_0 <= MULT)||LA63_0==PERCENT) ) {
					alt63=1;
				}

				switch (alt63) {
				case 1 :
					// src/exm/stc/ast/ExM.g:573:15: mexpr_op e= powexpr
					{
					pushFollow(FOLLOW_mexpr_op_in_mexpr4770);
					mexpr_op210=mexpr_op();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_mexpr_op.add(mexpr_op210.getTree());
					pushFollow(FOLLOW_powexpr_in_mexpr4774);
					e=powexpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_powexpr.add(e.getTree());
					// AST REWRITE
					// elements: mexpr, e, mexpr_op
					// token labels: 
					// rule labels: e, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_e=new RewriteRuleSubtreeStream(adaptor,"rule e",e!=null?e.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 574:13: -> ^( OPERATOR mexpr_op $mexpr $e)
					{
						// src/exm/stc/ast/ExM.g:574:16: ^( OPERATOR mexpr_op $mexpr $e)
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OPERATOR, "OPERATOR"), root_1);
						adaptor.addChild(root_1, stream_mexpr_op.nextTree());
						adaptor.addChild(root_1, stream_retval.nextTree());
						adaptor.addChild(root_1, stream_e.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

				default :
					break loop63;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "mexpr"


	public static class mexpr_op_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "mexpr_op"
	// src/exm/stc/ast/ExM.g:578:1: mexpr_op : ( MULT | DIV | INTDIV | MOD | PERCENT );
	public final ExMParser.mexpr_op_return mexpr_op() throws RecognitionException {
		ExMParser.mexpr_op_return retval = new ExMParser.mexpr_op_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set211=null;

		Object set211_tree=null;

		try {
			// src/exm/stc/ast/ExM.g:578:9: ( MULT | DIV | INTDIV | MOD | PERCENT )
			// src/exm/stc/ast/ExM.g:
			{
			root_0 = (Object)adaptor.nil();


			set211=input.LT(1);
			if ( input.LA(1)==DIV||input.LA(1)==INTDIV||(input.LA(1) >= MOD && input.LA(1) <= MULT)||input.LA(1)==PERCENT ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set211));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "mexpr_op"


	public static class powexpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "powexpr"
	// src/exm/stc/ast/ExM.g:582:1: powexpr : ( uexpr -> uexpr ) ( POW e= uexpr -> ^( OPERATOR POW $powexpr $e) )* ;
	public final ExMParser.powexpr_return powexpr() throws RecognitionException {
		ExMParser.powexpr_return retval = new ExMParser.powexpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token POW213=null;
		ParserRuleReturnScope e =null;
		ParserRuleReturnScope uexpr212 =null;

		Object POW213_tree=null;
		RewriteRuleTokenStream stream_POW=new RewriteRuleTokenStream(adaptor,"token POW");
		RewriteRuleSubtreeStream stream_uexpr=new RewriteRuleSubtreeStream(adaptor,"rule uexpr");

		try {
			// src/exm/stc/ast/ExM.g:582:8: ( ( uexpr -> uexpr ) ( POW e= uexpr -> ^( OPERATOR POW $powexpr $e) )* )
			// src/exm/stc/ast/ExM.g:583:9: ( uexpr -> uexpr ) ( POW e= uexpr -> ^( OPERATOR POW $powexpr $e) )*
			{
			// src/exm/stc/ast/ExM.g:583:9: ( uexpr -> uexpr )
			// src/exm/stc/ast/ExM.g:583:10: uexpr
			{
			pushFollow(FOLLOW_uexpr_in_powexpr4861);
			uexpr212=uexpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_uexpr.add(uexpr212.getTree());
			// AST REWRITE
			// elements: uexpr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 583:15: -> uexpr
			{
				adaptor.addChild(root_0, stream_uexpr.nextTree());
			}


			retval.tree = root_0;
			}

			}

			// src/exm/stc/ast/ExM.g:584:9: ( POW e= uexpr -> ^( OPERATOR POW $powexpr $e) )*
			loop64:
			while (true) {
				int alt64=2;
				int LA64_0 = input.LA(1);
				if ( (LA64_0==POW) ) {
					alt64=1;
				}

				switch (alt64) {
				case 1 :
					// src/exm/stc/ast/ExM.g:584:15: POW e= uexpr
					{
					POW213=(Token)match(input,POW,FOLLOW_POW_in_powexpr4880); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_POW.add(POW213);

					pushFollow(FOLLOW_uexpr_in_powexpr4884);
					e=uexpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_uexpr.add(e.getTree());
					// AST REWRITE
					// elements: POW, e, powexpr
					// token labels: 
					// rule labels: e, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_e=new RewriteRuleSubtreeStream(adaptor,"rule e",e!=null?e.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 585:13: -> ^( OPERATOR POW $powexpr $e)
					{
						// src/exm/stc/ast/ExM.g:585:16: ^( OPERATOR POW $powexpr $e)
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OPERATOR, "OPERATOR"), root_1);
						adaptor.addChild(root_1, stream_POW.nextNode());
						adaptor.addChild(root_1, stream_retval.nextTree());
						adaptor.addChild(root_1, stream_e.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

				default :
					break loop64;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "powexpr"


	public static class uexpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "uexpr"
	// src/exm/stc/ast/ExM.g:590:1: uexpr : ( pfexpr | uexpr_op uexpr -> ^( OPERATOR uexpr_op uexpr ) );
	public final ExMParser.uexpr_return uexpr() throws RecognitionException {
		ExMParser.uexpr_return retval = new ExMParser.uexpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope pfexpr214 =null;
		ParserRuleReturnScope uexpr_op215 =null;
		ParserRuleReturnScope uexpr216 =null;

		RewriteRuleSubtreeStream stream_uexpr_op=new RewriteRuleSubtreeStream(adaptor,"rule uexpr_op");
		RewriteRuleSubtreeStream stream_uexpr=new RewriteRuleSubtreeStream(adaptor,"rule uexpr");

		try {
			// src/exm/stc/ast/ExM.g:590:6: ( pfexpr | uexpr_op uexpr -> ^( OPERATOR uexpr_op uexpr ) )
			int alt65=2;
			int LA65_0 = input.LA(1);
			if ( (LA65_0==ATSIGN||(LA65_0 >= DECIMAL && LA65_0 <= DECIMAL_INT)||LA65_0==FALSE||(LA65_0 >= HEX_INT && LA65_0 <= ID)||LA65_0==INFINITY||(LA65_0 >= LBRACE && LA65_0 <= LSQUARE)||LA65_0==NOTANUMBER||LA65_0==OCTAL_INT||LA65_0==SCI_DECIMAL||LA65_0==STRING||(LA65_0 >= STRING_MULTI_LINE_1 && LA65_0 <= STRING_MULTI_LINE_2)||LA65_0==TRUE) ) {
				alt65=1;
			}
			else if ( (LA65_0==MINUS||LA65_0==NOT) ) {
				alt65=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 65, 0, input);
				throw nvae;
			}

			switch (alt65) {
				case 1 :
					// src/exm/stc/ast/ExM.g:591:9: pfexpr
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_pfexpr_in_uexpr4942);
					pfexpr214=pfexpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pfexpr214.getTree());

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:592:9: uexpr_op uexpr
					{
					pushFollow(FOLLOW_uexpr_op_in_uexpr4952);
					uexpr_op215=uexpr_op();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_uexpr_op.add(uexpr_op215.getTree());
					pushFollow(FOLLOW_uexpr_in_uexpr4954);
					uexpr216=uexpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_uexpr.add(uexpr216.getTree());
					// AST REWRITE
					// elements: uexpr_op, uexpr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 592:24: -> ^( OPERATOR uexpr_op uexpr )
					{
						// src/exm/stc/ast/ExM.g:592:27: ^( OPERATOR uexpr_op uexpr )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OPERATOR, "OPERATOR"), root_1);
						adaptor.addChild(root_1, stream_uexpr_op.nextTree());
						adaptor.addChild(root_1, stream_uexpr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "uexpr"


	public static class uexpr_op_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "uexpr_op"
	// src/exm/stc/ast/ExM.g:595:1: uexpr_op : ( NOT | MINUS -> NEGATE );
	public final ExMParser.uexpr_op_return uexpr_op() throws RecognitionException {
		ExMParser.uexpr_op_return retval = new ExMParser.uexpr_op_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NOT217=null;
		Token MINUS218=null;

		Object NOT217_tree=null;
		Object MINUS218_tree=null;
		RewriteRuleTokenStream stream_MINUS=new RewriteRuleTokenStream(adaptor,"token MINUS");

		try {
			// src/exm/stc/ast/ExM.g:595:9: ( NOT | MINUS -> NEGATE )
			int alt66=2;
			int LA66_0 = input.LA(1);
			if ( (LA66_0==NOT) ) {
				alt66=1;
			}
			else if ( (LA66_0==MINUS) ) {
				alt66=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 66, 0, input);
				throw nvae;
			}

			switch (alt66) {
				case 1 :
					// src/exm/stc/ast/ExM.g:595:11: NOT
					{
					root_0 = (Object)adaptor.nil();


					NOT217=(Token)match(input,NOT,FOLLOW_NOT_in_uexpr_op4978); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NOT217_tree = (Object)adaptor.create(NOT217);
					adaptor.addChild(root_0, NOT217_tree);
					}

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:596:7: MINUS
					{
					MINUS218=(Token)match(input,MINUS,FOLLOW_MINUS_in_uexpr_op4986); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_MINUS.add(MINUS218);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 596:13: -> NEGATE
					{
						adaptor.addChild(root_0, (Object)adaptor.create(NEGATE, "NEGATE"));
					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "uexpr_op"


	public static class pfexpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "pfexpr"
	// src/exm/stc/ast/ExM.g:600:1: pfexpr : ( base_expr -> base_expr ) ( array_index -> ^( ARRAY_LOAD $pfexpr array_index ) | var_subscript -> ^( STRUCT_LOAD $pfexpr var_subscript ) )* ;
	public final ExMParser.pfexpr_return pfexpr() throws RecognitionException {
		ExMParser.pfexpr_return retval = new ExMParser.pfexpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope base_expr219 =null;
		ParserRuleReturnScope array_index220 =null;
		ParserRuleReturnScope var_subscript221 =null;

		RewriteRuleSubtreeStream stream_base_expr=new RewriteRuleSubtreeStream(adaptor,"rule base_expr");
		RewriteRuleSubtreeStream stream_array_index=new RewriteRuleSubtreeStream(adaptor,"rule array_index");
		RewriteRuleSubtreeStream stream_var_subscript=new RewriteRuleSubtreeStream(adaptor,"rule var_subscript");

		try {
			// src/exm/stc/ast/ExM.g:600:7: ( ( base_expr -> base_expr ) ( array_index -> ^( ARRAY_LOAD $pfexpr array_index ) | var_subscript -> ^( STRUCT_LOAD $pfexpr var_subscript ) )* )
			// src/exm/stc/ast/ExM.g:601:9: ( base_expr -> base_expr ) ( array_index -> ^( ARRAY_LOAD $pfexpr array_index ) | var_subscript -> ^( STRUCT_LOAD $pfexpr var_subscript ) )*
			{
			// src/exm/stc/ast/ExM.g:601:9: ( base_expr -> base_expr )
			// src/exm/stc/ast/ExM.g:601:10: base_expr
			{
			pushFollow(FOLLOW_base_expr_in_pfexpr5012);
			base_expr219=base_expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_base_expr.add(base_expr219.getTree());
			// AST REWRITE
			// elements: base_expr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 601:19: -> base_expr
			{
				adaptor.addChild(root_0, stream_base_expr.nextTree());
			}


			retval.tree = root_0;
			}

			}

			// src/exm/stc/ast/ExM.g:602:9: ( array_index -> ^( ARRAY_LOAD $pfexpr array_index ) | var_subscript -> ^( STRUCT_LOAD $pfexpr var_subscript ) )*
			loop67:
			while (true) {
				int alt67=3;
				int LA67_0 = input.LA(1);
				if ( (LA67_0==LSQUARE) ) {
					int LA67_21 = input.LA(2);
					if ( (synpred98_ExM()) ) {
						alt67=1;
					}

				}
				else if ( (LA67_0==150) ) {
					alt67=2;
				}

				switch (alt67) {
				case 1 :
					// src/exm/stc/ast/ExM.g:602:13: array_index
					{
					pushFollow(FOLLOW_array_index_in_pfexpr5029);
					array_index220=array_index();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_array_index.add(array_index220.getTree());
					// AST REWRITE
					// elements: array_index, pfexpr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 602:25: -> ^( ARRAY_LOAD $pfexpr array_index )
					{
						// src/exm/stc/ast/ExM.g:602:28: ^( ARRAY_LOAD $pfexpr array_index )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARRAY_LOAD, "ARRAY_LOAD"), root_1);
						adaptor.addChild(root_1, stream_retval.nextTree());
						adaptor.addChild(root_1, stream_array_index.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:603:13: var_subscript
					{
					pushFollow(FOLLOW_var_subscript_in_pfexpr5055);
					var_subscript221=var_subscript();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_var_subscript.add(var_subscript221.getTree());
					// AST REWRITE
					// elements: pfexpr, var_subscript
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 603:27: -> ^( STRUCT_LOAD $pfexpr var_subscript )
					{
						// src/exm/stc/ast/ExM.g:603:30: ^( STRUCT_LOAD $pfexpr var_subscript )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(STRUCT_LOAD, "STRUCT_LOAD"), root_1);
						adaptor.addChild(root_1, stream_retval.nextTree());
						adaptor.addChild(root_1, stream_var_subscript.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

				default :
					break loop67;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "pfexpr"


	public static class var_name_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "var_name"
	// src/exm/stc/ast/ExM.g:607:1: var_name : ID ;
	public final ExMParser.var_name_return var_name() throws RecognitionException {
		ExMParser.var_name_return retval = new ExMParser.var_name_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID222=null;

		Object ID222_tree=null;

		try {
			// src/exm/stc/ast/ExM.g:607:9: ( ID )
			// src/exm/stc/ast/ExM.g:607:11: ID
			{
			root_0 = (Object)adaptor.nil();


			ID222=(Token)match(input,ID,FOLLOW_ID_in_var_name5090); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID222_tree = (Object)adaptor.create(ID222);
			adaptor.addChild(root_0, ID222_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "var_name"


	public static class type_name_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "type_name"
	// src/exm/stc/ast/ExM.g:609:1: type_name : ID ;
	public final ExMParser.type_name_return type_name() throws RecognitionException {
		ExMParser.type_name_return retval = new ExMParser.type_name_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID223=null;

		Object ID223_tree=null;

		try {
			// src/exm/stc/ast/ExM.g:609:10: ( ID )
			// src/exm/stc/ast/ExM.g:609:12: ID
			{
			root_0 = (Object)adaptor.nil();


			ID223=(Token)match(input,ID,FOLLOW_ID_in_type_name5097); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID223_tree = (Object)adaptor.create(ID223);
			adaptor.addChild(root_0, ID223_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "type_name"


	public static class array_index_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "array_index"
	// src/exm/stc/ast/ExM.g:611:1: array_index : LSQUARE expr RSQUARE -> expr ;
	public final ExMParser.array_index_return array_index() throws RecognitionException {
		ExMParser.array_index_return retval = new ExMParser.array_index_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LSQUARE224=null;
		Token RSQUARE226=null;
		ParserRuleReturnScope expr225 =null;

		Object LSQUARE224_tree=null;
		Object RSQUARE226_tree=null;
		RewriteRuleTokenStream stream_LSQUARE=new RewriteRuleTokenStream(adaptor,"token LSQUARE");
		RewriteRuleTokenStream stream_RSQUARE=new RewriteRuleTokenStream(adaptor,"token RSQUARE");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// src/exm/stc/ast/ExM.g:611:12: ( LSQUARE expr RSQUARE -> expr )
			// src/exm/stc/ast/ExM.g:612:9: LSQUARE expr RSQUARE
			{
			LSQUARE224=(Token)match(input,LSQUARE,FOLLOW_LSQUARE_in_array_index5112); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LSQUARE.add(LSQUARE224);

			pushFollow(FOLLOW_expr_in_array_index5114);
			expr225=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(expr225.getTree());
			RSQUARE226=(Token)match(input,RSQUARE,FOLLOW_RSQUARE_in_array_index5116); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RSQUARE.add(RSQUARE226);

			// AST REWRITE
			// elements: expr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 612:30: -> expr
			{
				adaptor.addChild(root_0, stream_expr.nextTree());
			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "array_index"


	public static class var_subscript_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "var_subscript"
	// src/exm/stc/ast/ExM.g:615:1: var_subscript : '.' ID -> ID ;
	public final ExMParser.var_subscript_return var_subscript() throws RecognitionException {
		ExMParser.var_subscript_return retval = new ExMParser.var_subscript_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal227=null;
		Token ID228=null;

		Object char_literal227_tree=null;
		Object ID228_tree=null;
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_150=new RewriteRuleTokenStream(adaptor,"token 150");

		try {
			// src/exm/stc/ast/ExM.g:615:14: ( '.' ID -> ID )
			// src/exm/stc/ast/ExM.g:616:9: '.' ID
			{
			char_literal227=(Token)match(input,150,FOLLOW_150_in_var_subscript5140); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_150.add(char_literal227);

			ID228=(Token)match(input,ID,FOLLOW_ID_in_var_subscript5142); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ID.add(ID228);

			// AST REWRITE
			// elements: ID
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 616:16: -> ID
			{
				adaptor.addChild(root_0, stream_ID.nextNode());
			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "var_subscript"


	public static class base_expr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "base_expr"
	// src/exm/stc/ast/ExM.g:619:1: base_expr : ( literal | function_call | variable | paren_expr | array_constructor | array_kv_constructor );
	public final ExMParser.base_expr_return base_expr() throws RecognitionException {
		ExMParser.base_expr_return retval = new ExMParser.base_expr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope literal229 =null;
		ParserRuleReturnScope function_call230 =null;
		ParserRuleReturnScope variable231 =null;
		ParserRuleReturnScope paren_expr232 =null;
		ParserRuleReturnScope array_constructor233 =null;
		ParserRuleReturnScope array_kv_constructor234 =null;


		try {
			// src/exm/stc/ast/ExM.g:619:10: ( literal | function_call | variable | paren_expr | array_constructor | array_kv_constructor )
			int alt68=6;
			switch ( input.LA(1) ) {
			case DECIMAL:
			case DECIMAL_INT:
			case FALSE:
			case HEX_INT:
			case INFINITY:
			case NOTANUMBER:
			case OCTAL_INT:
			case SCI_DECIMAL:
			case STRING:
			case STRING_MULTI_LINE_1:
			case STRING_MULTI_LINE_2:
			case TRUE:
				{
				alt68=1;
				}
				break;
			case ATSIGN:
				{
				alt68=2;
				}
				break;
			case ID:
				{
				int LA68_11 = input.LA(2);
				if ( (synpred101_ExM()) ) {
					alt68=2;
				}
				else if ( (synpred102_ExM()) ) {
					alt68=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 68, 11, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case LPAREN:
				{
				alt68=4;
				}
				break;
			case LSQUARE:
				{
				alt68=5;
				}
				break;
			case LBRACE:
				{
				alt68=6;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 68, 0, input);
				throw nvae;
			}
			switch (alt68) {
				case 1 :
					// src/exm/stc/ast/ExM.g:620:13: literal
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_literal_in_base_expr5170);
					literal229=literal();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, literal229.getTree());

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:621:13: function_call
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_function_call_in_base_expr5184);
					function_call230=function_call();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, function_call230.getTree());

					}
					break;
				case 3 :
					// src/exm/stc/ast/ExM.g:622:13: variable
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_variable_in_base_expr5198);
					variable231=variable();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, variable231.getTree());

					}
					break;
				case 4 :
					// src/exm/stc/ast/ExM.g:623:13: paren_expr
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_paren_expr_in_base_expr5212);
					paren_expr232=paren_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, paren_expr232.getTree());

					}
					break;
				case 5 :
					// src/exm/stc/ast/ExM.g:624:13: array_constructor
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_array_constructor_in_base_expr5226);
					array_constructor233=array_constructor();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, array_constructor233.getTree());

					}
					break;
				case 6 :
					// src/exm/stc/ast/ExM.g:625:13: array_kv_constructor
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_array_kv_constructor_in_base_expr5240);
					array_kv_constructor234=array_kv_constructor();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, array_kv_constructor234.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "base_expr"


	public static class literal_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "literal"
	// src/exm/stc/ast/ExM.g:628:1: literal : (n= integer -> ^( INT_LITERAL $n) |d= ( DECIMAL | SCI_DECIMAL | INFINITY | NOTANUMBER ) -> ^( FLOAT_LITERAL $d) |s= STRING -> ^( STRING_LITERAL $s) |s= STRING_MULTI_LINE_1 -> ^( STRING_LITERAL $s) |s= STRING_MULTI_LINE_2 -> ^( STRING_LITERAL $s) |b= bool_lit -> ^( BOOL_LITERAL $b) );
	public final ExMParser.literal_return literal() throws RecognitionException {
		ExMParser.literal_return retval = new ExMParser.literal_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token d=null;
		Token s=null;
		ParserRuleReturnScope n =null;
		ParserRuleReturnScope b =null;

		Object d_tree=null;
		Object s_tree=null;
		RewriteRuleTokenStream stream_INFINITY=new RewriteRuleTokenStream(adaptor,"token INFINITY");
		RewriteRuleTokenStream stream_SCI_DECIMAL=new RewriteRuleTokenStream(adaptor,"token SCI_DECIMAL");
		RewriteRuleTokenStream stream_STRING_MULTI_LINE_2=new RewriteRuleTokenStream(adaptor,"token STRING_MULTI_LINE_2");
		RewriteRuleTokenStream stream_STRING_MULTI_LINE_1=new RewriteRuleTokenStream(adaptor,"token STRING_MULTI_LINE_1");
		RewriteRuleTokenStream stream_NOTANUMBER=new RewriteRuleTokenStream(adaptor,"token NOTANUMBER");
		RewriteRuleTokenStream stream_DECIMAL=new RewriteRuleTokenStream(adaptor,"token DECIMAL");
		RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
		RewriteRuleSubtreeStream stream_integer=new RewriteRuleSubtreeStream(adaptor,"rule integer");
		RewriteRuleSubtreeStream stream_bool_lit=new RewriteRuleSubtreeStream(adaptor,"rule bool_lit");

		try {
			// src/exm/stc/ast/ExM.g:628:8: (n= integer -> ^( INT_LITERAL $n) |d= ( DECIMAL | SCI_DECIMAL | INFINITY | NOTANUMBER ) -> ^( FLOAT_LITERAL $d) |s= STRING -> ^( STRING_LITERAL $s) |s= STRING_MULTI_LINE_1 -> ^( STRING_LITERAL $s) |s= STRING_MULTI_LINE_2 -> ^( STRING_LITERAL $s) |b= bool_lit -> ^( BOOL_LITERAL $b) )
			int alt70=6;
			switch ( input.LA(1) ) {
			case DECIMAL_INT:
			case HEX_INT:
			case OCTAL_INT:
				{
				alt70=1;
				}
				break;
			case DECIMAL:
			case INFINITY:
			case NOTANUMBER:
			case SCI_DECIMAL:
				{
				alt70=2;
				}
				break;
			case STRING:
				{
				alt70=3;
				}
				break;
			case STRING_MULTI_LINE_1:
				{
				alt70=4;
				}
				break;
			case STRING_MULTI_LINE_2:
				{
				alt70=5;
				}
				break;
			case FALSE:
			case TRUE:
				{
				alt70=6;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 70, 0, input);
				throw nvae;
			}
			switch (alt70) {
				case 1 :
					// src/exm/stc/ast/ExM.g:629:9: n= integer
					{
					pushFollow(FOLLOW_integer_in_literal5262);
					n=integer();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_integer.add(n.getTree());
					// AST REWRITE
					// elements: n
					// token labels: 
					// rule labels: n, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_n=new RewriteRuleSubtreeStream(adaptor,"rule n",n!=null?n.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 629:19: -> ^( INT_LITERAL $n)
					{
						// src/exm/stc/ast/ExM.g:629:22: ^( INT_LITERAL $n)
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INT_LITERAL, "INT_LITERAL"), root_1);
						adaptor.addChild(root_1, stream_n.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:630:17: d= ( DECIMAL | SCI_DECIMAL | INFINITY | NOTANUMBER )
					{
					// src/exm/stc/ast/ExM.g:630:19: ( DECIMAL | SCI_DECIMAL | INFINITY | NOTANUMBER )
					int alt69=4;
					switch ( input.LA(1) ) {
					case DECIMAL:
						{
						alt69=1;
						}
						break;
					case SCI_DECIMAL:
						{
						alt69=2;
						}
						break;
					case INFINITY:
						{
						alt69=3;
						}
						break;
					case NOTANUMBER:
						{
						alt69=4;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 69, 0, input);
						throw nvae;
					}
					switch (alt69) {
						case 1 :
							// src/exm/stc/ast/ExM.g:630:20: DECIMAL
							{
							d=(Token)match(input,DECIMAL,FOLLOW_DECIMAL_in_literal5294); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_DECIMAL.add(d);

							}
							break;
						case 2 :
							// src/exm/stc/ast/ExM.g:630:30: SCI_DECIMAL
							{
							d=(Token)match(input,SCI_DECIMAL,FOLLOW_SCI_DECIMAL_in_literal5298); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_SCI_DECIMAL.add(d);

							}
							break;
						case 3 :
							// src/exm/stc/ast/ExM.g:630:44: INFINITY
							{
							d=(Token)match(input,INFINITY,FOLLOW_INFINITY_in_literal5302); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_INFINITY.add(d);

							}
							break;
						case 4 :
							// src/exm/stc/ast/ExM.g:630:55: NOTANUMBER
							{
							d=(Token)match(input,NOTANUMBER,FOLLOW_NOTANUMBER_in_literal5306); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_NOTANUMBER.add(d);

							}
							break;

					}

					// AST REWRITE
					// elements: d
					// token labels: d
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleTokenStream stream_d=new RewriteRuleTokenStream(adaptor,"token d",d);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 631:18: -> ^( FLOAT_LITERAL $d)
					{
						// src/exm/stc/ast/ExM.g:631:21: ^( FLOAT_LITERAL $d)
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FLOAT_LITERAL, "FLOAT_LITERAL"), root_1);
						adaptor.addChild(root_1, stream_d.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// src/exm/stc/ast/ExM.g:632:17: s= STRING
					{
					s=(Token)match(input,STRING,FOLLOW_STRING_in_literal5354); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_STRING.add(s);

					// AST REWRITE
					// elements: s
					// token labels: s
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleTokenStream stream_s=new RewriteRuleTokenStream(adaptor,"token s",s);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 632:26: -> ^( STRING_LITERAL $s)
					{
						// src/exm/stc/ast/ExM.g:632:29: ^( STRING_LITERAL $s)
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(STRING_LITERAL, "STRING_LITERAL"), root_1);
						adaptor.addChild(root_1, stream_s.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// src/exm/stc/ast/ExM.g:633:17: s= STRING_MULTI_LINE_1
					{
					s=(Token)match(input,STRING_MULTI_LINE_1,FOLLOW_STRING_MULTI_LINE_1_in_literal5384); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_STRING_MULTI_LINE_1.add(s);

					// AST REWRITE
					// elements: s
					// token labels: s
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleTokenStream stream_s=new RewriteRuleTokenStream(adaptor,"token s",s);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 633:39: -> ^( STRING_LITERAL $s)
					{
						// src/exm/stc/ast/ExM.g:633:42: ^( STRING_LITERAL $s)
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(STRING_LITERAL, "STRING_LITERAL"), root_1);
						adaptor.addChild(root_1, stream_s.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 5 :
					// src/exm/stc/ast/ExM.g:634:17: s= STRING_MULTI_LINE_2
					{
					s=(Token)match(input,STRING_MULTI_LINE_2,FOLLOW_STRING_MULTI_LINE_2_in_literal5414); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_STRING_MULTI_LINE_2.add(s);

					// AST REWRITE
					// elements: s
					// token labels: s
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleTokenStream stream_s=new RewriteRuleTokenStream(adaptor,"token s",s);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 634:39: -> ^( STRING_LITERAL $s)
					{
						// src/exm/stc/ast/ExM.g:634:42: ^( STRING_LITERAL $s)
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(STRING_LITERAL, "STRING_LITERAL"), root_1);
						adaptor.addChild(root_1, stream_s.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 6 :
					// src/exm/stc/ast/ExM.g:635:17: b= bool_lit
					{
					pushFollow(FOLLOW_bool_lit_in_literal5444);
					b=bool_lit();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_bool_lit.add(b.getTree());
					// AST REWRITE
					// elements: b
					// token labels: 
					// rule labels: b, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 635:28: -> ^( BOOL_LITERAL $b)
					{
						// src/exm/stc/ast/ExM.g:635:31: ^( BOOL_LITERAL $b)
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BOOL_LITERAL, "BOOL_LITERAL"), root_1);
						adaptor.addChild(root_1, stream_b.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "literal"


	public static class integer_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "integer"
	// src/exm/stc/ast/ExM.g:638:1: integer : ( DECIMAL_INT | OCTAL_INT | HEX_INT );
	public final ExMParser.integer_return integer() throws RecognitionException {
		ExMParser.integer_return retval = new ExMParser.integer_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set235=null;

		Object set235_tree=null;

		try {
			// src/exm/stc/ast/ExM.g:638:8: ( DECIMAL_INT | OCTAL_INT | HEX_INT )
			// src/exm/stc/ast/ExM.g:
			{
			root_0 = (Object)adaptor.nil();


			set235=input.LT(1);
			if ( input.LA(1)==DECIMAL_INT||input.LA(1)==HEX_INT||input.LA(1)==OCTAL_INT ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set235));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "integer"


	public static class variable_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "variable"
	// src/exm/stc/ast/ExM.g:640:1: variable : var_name -> ^( VARIABLE var_name ) ;
	public final ExMParser.variable_return variable() throws RecognitionException {
		ExMParser.variable_return retval = new ExMParser.variable_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope var_name236 =null;

		RewriteRuleSubtreeStream stream_var_name=new RewriteRuleSubtreeStream(adaptor,"rule var_name");

		try {
			// src/exm/stc/ast/ExM.g:640:9: ( var_name -> ^( VARIABLE var_name ) )
			// src/exm/stc/ast/ExM.g:641:9: var_name
			{
			pushFollow(FOLLOW_var_name_in_variable5489);
			var_name236=var_name();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_var_name.add(var_name236.getTree());
			// AST REWRITE
			// elements: var_name
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 641:18: -> ^( VARIABLE var_name )
			{
				// src/exm/stc/ast/ExM.g:641:21: ^( VARIABLE var_name )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VARIABLE, "VARIABLE"), root_1);
				adaptor.addChild(root_1, stream_var_name.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "variable"


	public static class bool_lit_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "bool_lit"
	// src/exm/stc/ast/ExM.g:644:1: bool_lit : ( TRUE | FALSE );
	public final ExMParser.bool_lit_return bool_lit() throws RecognitionException {
		ExMParser.bool_lit_return retval = new ExMParser.bool_lit_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set237=null;

		Object set237_tree=null;

		try {
			// src/exm/stc/ast/ExM.g:644:9: ( TRUE | FALSE )
			// src/exm/stc/ast/ExM.g:
			{
			root_0 = (Object)adaptor.nil();


			set237=input.LT(1);
			if ( input.LA(1)==FALSE||input.LA(1)==TRUE ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set237));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "bool_lit"


	public static class function_call_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "function_call"
	// src/exm/stc/ast/ExM.g:647:1: function_call : ( call_annotation )* f= function_call_name a= expr_kw_pos_argument_list -> ^( CALL_FUNCTION $f $a ( call_annotation )* ) ;
	public final ExMParser.function_call_return function_call() throws RecognitionException {
		ExMParser.function_call_return retval = new ExMParser.function_call_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope f =null;
		ParserRuleReturnScope a =null;
		ParserRuleReturnScope call_annotation238 =null;

		RewriteRuleSubtreeStream stream_function_call_name=new RewriteRuleSubtreeStream(adaptor,"rule function_call_name");
		RewriteRuleSubtreeStream stream_call_annotation=new RewriteRuleSubtreeStream(adaptor,"rule call_annotation");
		RewriteRuleSubtreeStream stream_expr_kw_pos_argument_list=new RewriteRuleSubtreeStream(adaptor,"rule expr_kw_pos_argument_list");

		try {
			// src/exm/stc/ast/ExM.g:647:14: ( ( call_annotation )* f= function_call_name a= expr_kw_pos_argument_list -> ^( CALL_FUNCTION $f $a ( call_annotation )* ) )
			// src/exm/stc/ast/ExM.g:648:10: ( call_annotation )* f= function_call_name a= expr_kw_pos_argument_list
			{
			// src/exm/stc/ast/ExM.g:648:10: ( call_annotation )*
			loop71:
			while (true) {
				int alt71=2;
				int LA71_0 = input.LA(1);
				if ( (LA71_0==ATSIGN) ) {
					int LA71_2 = input.LA(2);
					if ( (LA71_2==ID) ) {
						int LA71_3 = input.LA(3);
						if ( (LA71_3==ASSIGN) ) {
							alt71=1;
						}

					}

				}

				switch (alt71) {
				case 1 :
					// src/exm/stc/ast/ExM.g:648:10: call_annotation
					{
					pushFollow(FOLLOW_call_annotation_in_function_call5536);
					call_annotation238=call_annotation();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_call_annotation.add(call_annotation238.getTree());
					}
					break;

				default :
					break loop71;
				}
			}

			pushFollow(FOLLOW_function_call_name_in_function_call5541);
			f=function_call_name();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_function_call_name.add(f.getTree());
			pushFollow(FOLLOW_expr_kw_pos_argument_list_in_function_call5545);
			a=expr_kw_pos_argument_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr_kw_pos_argument_list.add(a.getTree());
			// AST REWRITE
			// elements: f, a, call_annotation
			// token labels: 
			// rule labels: a, f, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.getTree():null);
			RewriteRuleSubtreeStream stream_f=new RewriteRuleSubtreeStream(adaptor,"rule f",f!=null?f.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 648:76: -> ^( CALL_FUNCTION $f $a ( call_annotation )* )
			{
				// src/exm/stc/ast/ExM.g:649:13: ^( CALL_FUNCTION $f $a ( call_annotation )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CALL_FUNCTION, "CALL_FUNCTION"), root_1);
				adaptor.addChild(root_1, stream_f.nextTree());
				adaptor.addChild(root_1, stream_a.nextTree());
				// src/exm/stc/ast/ExM.g:649:36: ( call_annotation )*
				while ( stream_call_annotation.hasNext() ) {
					adaptor.addChild(root_1, stream_call_annotation.nextTree());
				}
				stream_call_annotation.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "function_call"


	public static class function_call_name_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "function_call_name"
	// src/exm/stc/ast/ExM.g:652:1: function_call_name : ( ID | ATSIGN ID -> ^( DEPRECATED ID ) );
	public final ExMParser.function_call_name_return function_call_name() throws RecognitionException {
		ExMParser.function_call_name_return retval = new ExMParser.function_call_name_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID239=null;
		Token ATSIGN240=null;
		Token ID241=null;

		Object ID239_tree=null;
		Object ATSIGN240_tree=null;
		Object ID241_tree=null;
		RewriteRuleTokenStream stream_ATSIGN=new RewriteRuleTokenStream(adaptor,"token ATSIGN");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");

		try {
			// src/exm/stc/ast/ExM.g:652:19: ( ID | ATSIGN ID -> ^( DEPRECATED ID ) )
			int alt72=2;
			int LA72_0 = input.LA(1);
			if ( (LA72_0==ID) ) {
				alt72=1;
			}
			else if ( (LA72_0==ATSIGN) ) {
				alt72=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 72, 0, input);
				throw nvae;
			}

			switch (alt72) {
				case 1 :
					// src/exm/stc/ast/ExM.g:653:10: ID
					{
					root_0 = (Object)adaptor.nil();


					ID239=(Token)match(input,ID,FOLLOW_ID_in_function_call_name5594); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID239_tree = (Object)adaptor.create(ID239);
					adaptor.addChild(root_0, ID239_tree);
					}

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:654:10: ATSIGN ID
					{
					ATSIGN240=(Token)match(input,ATSIGN,FOLLOW_ATSIGN_in_function_call_name5605); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ATSIGN.add(ATSIGN240);

					ID241=(Token)match(input,ID,FOLLOW_ID_in_function_call_name5607); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ID.add(ID241);

					// AST REWRITE
					// elements: ID
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 654:20: -> ^( DEPRECATED ID )
					{
						// src/exm/stc/ast/ExM.g:654:23: ^( DEPRECATED ID )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DEPRECATED, "DEPRECATED"), root_1);
						adaptor.addChild(root_1, stream_ID.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "function_call_name"


	public static class call_annotation_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "call_annotation"
	// src/exm/stc/ast/ExM.g:657:1: call_annotation : ATSIGN ann= ID ASSIGN e= expr -> ^( CALL_ANNOTATION $ann $e) ;
	public final ExMParser.call_annotation_return call_annotation() throws RecognitionException {
		ExMParser.call_annotation_return retval = new ExMParser.call_annotation_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ann=null;
		Token ATSIGN242=null;
		Token ASSIGN243=null;
		ParserRuleReturnScope e =null;

		Object ann_tree=null;
		Object ATSIGN242_tree=null;
		Object ASSIGN243_tree=null;
		RewriteRuleTokenStream stream_ATSIGN=new RewriteRuleTokenStream(adaptor,"token ATSIGN");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// src/exm/stc/ast/ExM.g:657:16: ( ATSIGN ann= ID ASSIGN e= expr -> ^( CALL_ANNOTATION $ann $e) )
			// src/exm/stc/ast/ExM.g:658:3: ATSIGN ann= ID ASSIGN e= expr
			{
			ATSIGN242=(Token)match(input,ATSIGN,FOLLOW_ATSIGN_in_call_annotation5631); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ATSIGN.add(ATSIGN242);

			ann=(Token)match(input,ID,FOLLOW_ID_in_call_annotation5635); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ID.add(ann);

			ASSIGN243=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_call_annotation5637); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN243);

			pushFollow(FOLLOW_expr_in_call_annotation5641);
			e=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(e.getTree());
			// AST REWRITE
			// elements: e, ann
			// token labels: ann
			// rule labels: e, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleTokenStream stream_ann=new RewriteRuleTokenStream(adaptor,"token ann",ann);
			RewriteRuleSubtreeStream stream_e=new RewriteRuleSubtreeStream(adaptor,"rule e",e!=null?e.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 659:4: -> ^( CALL_ANNOTATION $ann $e)
			{
				// src/exm/stc/ast/ExM.g:659:7: ^( CALL_ANNOTATION $ann $e)
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CALL_ANNOTATION, "CALL_ANNOTATION"), root_1);
				adaptor.addChild(root_1, stream_ann.nextNode());
				adaptor.addChild(root_1, stream_e.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "call_annotation"


	public static class expr_kw_pos_argument_list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr_kw_pos_argument_list"
	// src/exm/stc/ast/ExM.g:662:1: expr_kw_pos_argument_list : LPAREN ( expr_kw_pos_arguments )? RPAREN -> ^( ARGUMENT_LIST ( expr_kw_pos_arguments )? ) ;
	public final ExMParser.expr_kw_pos_argument_list_return expr_kw_pos_argument_list() throws RecognitionException {
		ExMParser.expr_kw_pos_argument_list_return retval = new ExMParser.expr_kw_pos_argument_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LPAREN244=null;
		Token RPAREN246=null;
		ParserRuleReturnScope expr_kw_pos_arguments245 =null;

		Object LPAREN244_tree=null;
		Object RPAREN246_tree=null;
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleSubtreeStream stream_expr_kw_pos_arguments=new RewriteRuleSubtreeStream(adaptor,"rule expr_kw_pos_arguments");

		try {
			// src/exm/stc/ast/ExM.g:662:26: ( LPAREN ( expr_kw_pos_arguments )? RPAREN -> ^( ARGUMENT_LIST ( expr_kw_pos_arguments )? ) )
			// src/exm/stc/ast/ExM.g:663:9: LPAREN ( expr_kw_pos_arguments )? RPAREN
			{
			LPAREN244=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_expr_kw_pos_argument_list5675); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN244);

			// src/exm/stc/ast/ExM.g:663:16: ( expr_kw_pos_arguments )?
			int alt73=2;
			int LA73_0 = input.LA(1);
			if ( (LA73_0==ATSIGN||(LA73_0 >= DECIMAL && LA73_0 <= DECIMAL_INT)||LA73_0==FALSE||(LA73_0 >= HEX_INT && LA73_0 <= ID)||LA73_0==INFINITY||(LA73_0 >= LBRACE && LA73_0 <= LSQUARE)||LA73_0==MINUS||(LA73_0 >= NOT && LA73_0 <= NOTANUMBER)||LA73_0==OCTAL_INT||LA73_0==SCI_DECIMAL||LA73_0==STRING||(LA73_0 >= STRING_MULTI_LINE_1 && LA73_0 <= STRING_MULTI_LINE_2)||LA73_0==TRUE) ) {
				alt73=1;
			}
			switch (alt73) {
				case 1 :
					// src/exm/stc/ast/ExM.g:663:16: expr_kw_pos_arguments
					{
					pushFollow(FOLLOW_expr_kw_pos_arguments_in_expr_kw_pos_argument_list5677);
					expr_kw_pos_arguments245=expr_kw_pos_arguments();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr_kw_pos_arguments.add(expr_kw_pos_arguments245.getTree());
					}
					break;

			}

			RPAREN246=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_expr_kw_pos_argument_list5680); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN246);

			// AST REWRITE
			// elements: expr_kw_pos_arguments
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 663:46: -> ^( ARGUMENT_LIST ( expr_kw_pos_arguments )? )
			{
				// src/exm/stc/ast/ExM.g:663:49: ^( ARGUMENT_LIST ( expr_kw_pos_arguments )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARGUMENT_LIST, "ARGUMENT_LIST"), root_1);
				// src/exm/stc/ast/ExM.g:663:66: ( expr_kw_pos_arguments )?
				if ( stream_expr_kw_pos_arguments.hasNext() ) {
					adaptor.addChild(root_1, stream_expr_kw_pos_arguments.nextTree());
				}
				stream_expr_kw_pos_arguments.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr_kw_pos_argument_list"


	public static class expr_kw_pos_arguments_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr_kw_pos_arguments"
	// src/exm/stc/ast/ExM.g:666:1: expr_kw_pos_arguments : ( expr | kw_argument ) ( expr_kw_pos_arguments_rest )* ;
	public final ExMParser.expr_kw_pos_arguments_return expr_kw_pos_arguments() throws RecognitionException {
		ExMParser.expr_kw_pos_arguments_return retval = new ExMParser.expr_kw_pos_arguments_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope expr247 =null;
		ParserRuleReturnScope kw_argument248 =null;
		ParserRuleReturnScope expr_kw_pos_arguments_rest249 =null;


		try {
			// src/exm/stc/ast/ExM.g:666:22: ( ( expr | kw_argument ) ( expr_kw_pos_arguments_rest )* )
			// src/exm/stc/ast/ExM.g:667:9: ( expr | kw_argument ) ( expr_kw_pos_arguments_rest )*
			{
			root_0 = (Object)adaptor.nil();


			// src/exm/stc/ast/ExM.g:667:9: ( expr | kw_argument )
			int alt74=2;
			int LA74_0 = input.LA(1);
			if ( (LA74_0==ATSIGN||(LA74_0 >= DECIMAL && LA74_0 <= DECIMAL_INT)||LA74_0==FALSE||LA74_0==HEX_INT||LA74_0==INFINITY||(LA74_0 >= LBRACE && LA74_0 <= LSQUARE)||LA74_0==MINUS||(LA74_0 >= NOT && LA74_0 <= NOTANUMBER)||LA74_0==OCTAL_INT||LA74_0==SCI_DECIMAL||LA74_0==STRING||(LA74_0 >= STRING_MULTI_LINE_1 && LA74_0 <= STRING_MULTI_LINE_2)||LA74_0==TRUE) ) {
				alt74=1;
			}
			else if ( (LA74_0==ID) ) {
				int LA74_2 = input.LA(2);
				if ( (LA74_2==ASSIGN) ) {
					alt74=2;
				}
				else if ( (LA74_2==EOF||LA74_2==AND||LA74_2==COMMA||LA74_2==DIV||LA74_2==EQUALS||(LA74_2 >= GT && LA74_2 <= GTE)||LA74_2==INTDIV||(LA74_2 >= LPAREN && LA74_2 <= LTE)||(LA74_2 >= MINUS && LA74_2 <= MULT)||LA74_2==NEQUALS||LA74_2==OR||LA74_2==PERCENT||(LA74_2 >= PLUS && LA74_2 <= POW)||LA74_2==RPAREN||LA74_2==150) ) {
					alt74=1;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 74, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 74, 0, input);
				throw nvae;
			}

			switch (alt74) {
				case 1 :
					// src/exm/stc/ast/ExM.g:667:10: expr
					{
					pushFollow(FOLLOW_expr_in_expr_kw_pos_arguments5712);
					expr247=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr247.getTree());

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:667:15: kw_argument
					{
					pushFollow(FOLLOW_kw_argument_in_expr_kw_pos_arguments5714);
					kw_argument248=kw_argument();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, kw_argument248.getTree());

					}
					break;

			}

			// src/exm/stc/ast/ExM.g:667:28: ( expr_kw_pos_arguments_rest )*
			loop75:
			while (true) {
				int alt75=2;
				int LA75_0 = input.LA(1);
				if ( (LA75_0==COMMA) ) {
					alt75=1;
				}

				switch (alt75) {
				case 1 :
					// src/exm/stc/ast/ExM.g:667:28: expr_kw_pos_arguments_rest
					{
					pushFollow(FOLLOW_expr_kw_pos_arguments_rest_in_expr_kw_pos_arguments5717);
					expr_kw_pos_arguments_rest249=expr_kw_pos_arguments_rest();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_kw_pos_arguments_rest249.getTree());

					}
					break;

				default :
					break loop75;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr_kw_pos_arguments"


	public static class expr_kw_pos_arguments_rest_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr_kw_pos_arguments_rest"
	// src/exm/stc/ast/ExM.g:670:1: expr_kw_pos_arguments_rest : COMMA ( expr -> expr | kw_argument -> kw_argument ) ;
	public final ExMParser.expr_kw_pos_arguments_rest_return expr_kw_pos_arguments_rest() throws RecognitionException {
		ExMParser.expr_kw_pos_arguments_rest_return retval = new ExMParser.expr_kw_pos_arguments_rest_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMA250=null;
		ParserRuleReturnScope expr251 =null;
		ParserRuleReturnScope kw_argument252 =null;

		Object COMMA250_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_kw_argument=new RewriteRuleSubtreeStream(adaptor,"rule kw_argument");

		try {
			// src/exm/stc/ast/ExM.g:670:27: ( COMMA ( expr -> expr | kw_argument -> kw_argument ) )
			// src/exm/stc/ast/ExM.g:671:10: COMMA ( expr -> expr | kw_argument -> kw_argument )
			{
			COMMA250=(Token)match(input,COMMA,FOLLOW_COMMA_in_expr_kw_pos_arguments_rest5739); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_COMMA.add(COMMA250);

			// src/exm/stc/ast/ExM.g:671:16: ( expr -> expr | kw_argument -> kw_argument )
			int alt76=2;
			int LA76_0 = input.LA(1);
			if ( (LA76_0==ATSIGN||(LA76_0 >= DECIMAL && LA76_0 <= DECIMAL_INT)||LA76_0==FALSE||LA76_0==HEX_INT||LA76_0==INFINITY||(LA76_0 >= LBRACE && LA76_0 <= LSQUARE)||LA76_0==MINUS||(LA76_0 >= NOT && LA76_0 <= NOTANUMBER)||LA76_0==OCTAL_INT||LA76_0==SCI_DECIMAL||LA76_0==STRING||(LA76_0 >= STRING_MULTI_LINE_1 && LA76_0 <= STRING_MULTI_LINE_2)||LA76_0==TRUE) ) {
				alt76=1;
			}
			else if ( (LA76_0==ID) ) {
				int LA76_2 = input.LA(2);
				if ( (LA76_2==ASSIGN) ) {
					alt76=2;
				}
				else if ( (LA76_2==EOF||LA76_2==AND||LA76_2==COMMA||LA76_2==DIV||LA76_2==EQUALS||(LA76_2 >= GT && LA76_2 <= GTE)||LA76_2==INTDIV||(LA76_2 >= LPAREN && LA76_2 <= LTE)||(LA76_2 >= MINUS && LA76_2 <= MULT)||LA76_2==NEQUALS||LA76_2==OR||LA76_2==PERCENT||(LA76_2 >= PLUS && LA76_2 <= POW)||LA76_2==RPAREN||LA76_2==150) ) {
					alt76=1;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 76, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 76, 0, input);
				throw nvae;
			}

			switch (alt76) {
				case 1 :
					// src/exm/stc/ast/ExM.g:672:13: expr
					{
					pushFollow(FOLLOW_expr_in_expr_kw_pos_arguments_rest5755);
					expr251=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr251.getTree());
					// AST REWRITE
					// elements: expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 672:18: -> expr
					{
						adaptor.addChild(root_0, stream_expr.nextTree());
					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:673:13: kw_argument
					{
					pushFollow(FOLLOW_kw_argument_in_expr_kw_pos_arguments_rest5773);
					kw_argument252=kw_argument();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_kw_argument.add(kw_argument252.getTree());
					// AST REWRITE
					// elements: kw_argument
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 673:25: -> kw_argument
					{
						adaptor.addChild(root_0, stream_kw_argument.nextTree());
					}


					retval.tree = root_0;
					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr_kw_pos_arguments_rest"


	public static class kw_argument_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "kw_argument"
	// src/exm/stc/ast/ExM.g:676:1: kw_argument : ID ASSIGN expr -> ^( KW_ARGUMENT ID expr ) ;
	public final ExMParser.kw_argument_return kw_argument() throws RecognitionException {
		ExMParser.kw_argument_return retval = new ExMParser.kw_argument_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID253=null;
		Token ASSIGN254=null;
		ParserRuleReturnScope expr255 =null;

		Object ID253_tree=null;
		Object ASSIGN254_tree=null;
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// src/exm/stc/ast/ExM.g:676:12: ( ID ASSIGN expr -> ^( KW_ARGUMENT ID expr ) )
			// src/exm/stc/ast/ExM.g:677:9: ID ASSIGN expr
			{
			ID253=(Token)match(input,ID,FOLLOW_ID_in_kw_argument5798); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ID.add(ID253);

			ASSIGN254=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_kw_argument5800); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN254);

			pushFollow(FOLLOW_expr_in_kw_argument5802);
			expr255=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(expr255.getTree());
			// AST REWRITE
			// elements: expr, ID
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 677:24: -> ^( KW_ARGUMENT ID expr )
			{
				// src/exm/stc/ast/ExM.g:677:27: ^( KW_ARGUMENT ID expr )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(KW_ARGUMENT, "KW_ARGUMENT"), root_1);
				adaptor.addChild(root_1, stream_ID.nextNode());
				adaptor.addChild(root_1, stream_expr.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "kw_argument"


	public static class expr_argument_list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr_argument_list"
	// src/exm/stc/ast/ExM.g:680:1: expr_argument_list : LPAREN ( expr_arguments )? RPAREN -> ^( ARGUMENT_LIST ( expr_arguments )? ) ;
	public final ExMParser.expr_argument_list_return expr_argument_list() throws RecognitionException {
		ExMParser.expr_argument_list_return retval = new ExMParser.expr_argument_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LPAREN256=null;
		Token RPAREN258=null;
		ParserRuleReturnScope expr_arguments257 =null;

		Object LPAREN256_tree=null;
		Object RPAREN258_tree=null;
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleSubtreeStream stream_expr_arguments=new RewriteRuleSubtreeStream(adaptor,"rule expr_arguments");

		try {
			// src/exm/stc/ast/ExM.g:680:19: ( LPAREN ( expr_arguments )? RPAREN -> ^( ARGUMENT_LIST ( expr_arguments )? ) )
			// src/exm/stc/ast/ExM.g:681:9: LPAREN ( expr_arguments )? RPAREN
			{
			LPAREN256=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_expr_argument_list5834); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN256);

			// src/exm/stc/ast/ExM.g:681:16: ( expr_arguments )?
			int alt77=2;
			int LA77_0 = input.LA(1);
			if ( (LA77_0==ATSIGN||(LA77_0 >= DECIMAL && LA77_0 <= DECIMAL_INT)||LA77_0==FALSE||(LA77_0 >= HEX_INT && LA77_0 <= ID)||LA77_0==INFINITY||(LA77_0 >= LBRACE && LA77_0 <= LSQUARE)||LA77_0==MINUS||(LA77_0 >= NOT && LA77_0 <= NOTANUMBER)||LA77_0==OCTAL_INT||LA77_0==SCI_DECIMAL||LA77_0==STRING||(LA77_0 >= STRING_MULTI_LINE_1 && LA77_0 <= STRING_MULTI_LINE_2)||LA77_0==TRUE) ) {
				alt77=1;
			}
			switch (alt77) {
				case 1 :
					// src/exm/stc/ast/ExM.g:681:16: expr_arguments
					{
					pushFollow(FOLLOW_expr_arguments_in_expr_argument_list5836);
					expr_arguments257=expr_arguments();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr_arguments.add(expr_arguments257.getTree());
					}
					break;

			}

			RPAREN258=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_expr_argument_list5839); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN258);

			// AST REWRITE
			// elements: expr_arguments
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 681:39: -> ^( ARGUMENT_LIST ( expr_arguments )? )
			{
				// src/exm/stc/ast/ExM.g:681:42: ^( ARGUMENT_LIST ( expr_arguments )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARGUMENT_LIST, "ARGUMENT_LIST"), root_1);
				// src/exm/stc/ast/ExM.g:681:59: ( expr_arguments )?
				if ( stream_expr_arguments.hasNext() ) {
					adaptor.addChild(root_1, stream_expr_arguments.nextTree());
				}
				stream_expr_arguments.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr_argument_list"


	public static class expr_arguments_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr_arguments"
	// src/exm/stc/ast/ExM.g:684:1: expr_arguments : expr ( expr_arguments_rest )* ;
	public final ExMParser.expr_arguments_return expr_arguments() throws RecognitionException {
		ExMParser.expr_arguments_return retval = new ExMParser.expr_arguments_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope expr259 =null;
		ParserRuleReturnScope expr_arguments_rest260 =null;


		try {
			// src/exm/stc/ast/ExM.g:684:15: ( expr ( expr_arguments_rest )* )
			// src/exm/stc/ast/ExM.g:685:9: expr ( expr_arguments_rest )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_expr_in_expr_arguments5870);
			expr259=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expr259.getTree());

			// src/exm/stc/ast/ExM.g:685:14: ( expr_arguments_rest )*
			loop78:
			while (true) {
				int alt78=2;
				int LA78_0 = input.LA(1);
				if ( (LA78_0==COMMA) ) {
					alt78=1;
				}

				switch (alt78) {
				case 1 :
					// src/exm/stc/ast/ExM.g:685:14: expr_arguments_rest
					{
					pushFollow(FOLLOW_expr_arguments_rest_in_expr_arguments5872);
					expr_arguments_rest260=expr_arguments_rest();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_arguments_rest260.getTree());

					}
					break;

				default :
					break loop78;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr_arguments"


	public static class expr_arguments_rest_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr_arguments_rest"
	// src/exm/stc/ast/ExM.g:688:1: expr_arguments_rest : COMMA expr -> expr ;
	public final ExMParser.expr_arguments_rest_return expr_arguments_rest() throws RecognitionException {
		ExMParser.expr_arguments_rest_return retval = new ExMParser.expr_arguments_rest_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMA261=null;
		ParserRuleReturnScope expr262 =null;

		Object COMMA261_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// src/exm/stc/ast/ExM.g:688:20: ( COMMA expr -> expr )
			// src/exm/stc/ast/ExM.g:688:22: COMMA expr
			{
			COMMA261=(Token)match(input,COMMA,FOLLOW_COMMA_in_expr_arguments_rest5885); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_COMMA.add(COMMA261);

			pushFollow(FOLLOW_expr_in_expr_arguments_rest5887);
			expr262=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(expr262.getTree());
			// AST REWRITE
			// elements: expr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 688:33: -> expr
			{
				adaptor.addChild(root_0, stream_expr.nextTree());
			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr_arguments_rest"


	public static class array_constructor_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "array_constructor"
	// src/exm/stc/ast/ExM.g:693:1: array_constructor : LSQUARE ( RSQUARE -> ^( ARRAY_ELEMS ) |e1= expr ( COLON e2= expr ( array_range_more )* RSQUARE -> ^( ARRAY_RANGE $e1 $e2 ( array_range_more )* ) | ( array_elems_more )* RSQUARE -> ^( ARRAY_ELEMS $e1 ( array_elems_more )* ) ) ) ;
	public final ExMParser.array_constructor_return array_constructor() throws RecognitionException {
		ExMParser.array_constructor_return retval = new ExMParser.array_constructor_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LSQUARE263=null;
		Token RSQUARE264=null;
		Token COLON265=null;
		Token RSQUARE267=null;
		Token RSQUARE269=null;
		ParserRuleReturnScope e1 =null;
		ParserRuleReturnScope e2 =null;
		ParserRuleReturnScope array_range_more266 =null;
		ParserRuleReturnScope array_elems_more268 =null;

		Object LSQUARE263_tree=null;
		Object RSQUARE264_tree=null;
		Object COLON265_tree=null;
		Object RSQUARE267_tree=null;
		Object RSQUARE269_tree=null;
		RewriteRuleTokenStream stream_LSQUARE=new RewriteRuleTokenStream(adaptor,"token LSQUARE");
		RewriteRuleTokenStream stream_RSQUARE=new RewriteRuleTokenStream(adaptor,"token RSQUARE");
		RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_array_range_more=new RewriteRuleSubtreeStream(adaptor,"rule array_range_more");
		RewriteRuleSubtreeStream stream_array_elems_more=new RewriteRuleSubtreeStream(adaptor,"rule array_elems_more");

		try {
			// src/exm/stc/ast/ExM.g:693:18: ( LSQUARE ( RSQUARE -> ^( ARRAY_ELEMS ) |e1= expr ( COLON e2= expr ( array_range_more )* RSQUARE -> ^( ARRAY_RANGE $e1 $e2 ( array_range_more )* ) | ( array_elems_more )* RSQUARE -> ^( ARRAY_ELEMS $e1 ( array_elems_more )* ) ) ) )
			// src/exm/stc/ast/ExM.g:694:9: LSQUARE ( RSQUARE -> ^( ARRAY_ELEMS ) |e1= expr ( COLON e2= expr ( array_range_more )* RSQUARE -> ^( ARRAY_RANGE $e1 $e2 ( array_range_more )* ) | ( array_elems_more )* RSQUARE -> ^( ARRAY_ELEMS $e1 ( array_elems_more )* ) ) )
			{
			LSQUARE263=(Token)match(input,LSQUARE,FOLLOW_LSQUARE_in_array_constructor5913); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LSQUARE.add(LSQUARE263);

			// src/exm/stc/ast/ExM.g:694:17: ( RSQUARE -> ^( ARRAY_ELEMS ) |e1= expr ( COLON e2= expr ( array_range_more )* RSQUARE -> ^( ARRAY_RANGE $e1 $e2 ( array_range_more )* ) | ( array_elems_more )* RSQUARE -> ^( ARRAY_ELEMS $e1 ( array_elems_more )* ) ) )
			int alt82=2;
			int LA82_0 = input.LA(1);
			if ( (LA82_0==RSQUARE) ) {
				alt82=1;
			}
			else if ( (LA82_0==ATSIGN||(LA82_0 >= DECIMAL && LA82_0 <= DECIMAL_INT)||LA82_0==FALSE||(LA82_0 >= HEX_INT && LA82_0 <= ID)||LA82_0==INFINITY||(LA82_0 >= LBRACE && LA82_0 <= LSQUARE)||LA82_0==MINUS||(LA82_0 >= NOT && LA82_0 <= NOTANUMBER)||LA82_0==OCTAL_INT||LA82_0==SCI_DECIMAL||LA82_0==STRING||(LA82_0 >= STRING_MULTI_LINE_1 && LA82_0 <= STRING_MULTI_LINE_2)||LA82_0==TRUE) ) {
				alt82=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 82, 0, input);
				throw nvae;
			}

			switch (alt82) {
				case 1 :
					// src/exm/stc/ast/ExM.g:695:11: RSQUARE
					{
					RSQUARE264=(Token)match(input,RSQUARE,FOLLOW_RSQUARE_in_array_constructor5927); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RSQUARE.add(RSQUARE264);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 696:14: -> ^( ARRAY_ELEMS )
					{
						// src/exm/stc/ast/ExM.g:696:17: ^( ARRAY_ELEMS )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARRAY_ELEMS, "ARRAY_ELEMS"), root_1);
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:697:11: e1= expr ( COLON e2= expr ( array_range_more )* RSQUARE -> ^( ARRAY_RANGE $e1 $e2 ( array_range_more )* ) | ( array_elems_more )* RSQUARE -> ^( ARRAY_ELEMS $e1 ( array_elems_more )* ) )
					{
					pushFollow(FOLLOW_expr_in_array_constructor5962);
					e1=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(e1.getTree());
					// src/exm/stc/ast/ExM.g:697:19: ( COLON e2= expr ( array_range_more )* RSQUARE -> ^( ARRAY_RANGE $e1 $e2 ( array_range_more )* ) | ( array_elems_more )* RSQUARE -> ^( ARRAY_ELEMS $e1 ( array_elems_more )* ) )
					int alt81=2;
					int LA81_0 = input.LA(1);
					if ( (LA81_0==COLON) ) {
						alt81=1;
					}
					else if ( (LA81_0==COMMA||LA81_0==RSQUARE) ) {
						alt81=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 81, 0, input);
						throw nvae;
					}

					switch (alt81) {
						case 1 :
							// src/exm/stc/ast/ExM.g:698:17: COLON e2= expr ( array_range_more )* RSQUARE
							{
							COLON265=(Token)match(input,COLON,FOLLOW_COLON_in_array_constructor5982); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COLON.add(COLON265);

							pushFollow(FOLLOW_expr_in_array_constructor5986);
							e2=expr();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_expr.add(e2.getTree());
							// src/exm/stc/ast/ExM.g:698:31: ( array_range_more )*
							loop79:
							while (true) {
								int alt79=2;
								int LA79_0 = input.LA(1);
								if ( (LA79_0==COLON) ) {
									alt79=1;
								}

								switch (alt79) {
								case 1 :
									// src/exm/stc/ast/ExM.g:698:31: array_range_more
									{
									pushFollow(FOLLOW_array_range_more_in_array_constructor5988);
									array_range_more266=array_range_more();
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) stream_array_range_more.add(array_range_more266.getTree());
									}
									break;

								default :
									break loop79;
								}
							}

							RSQUARE267=(Token)match(input,RSQUARE,FOLLOW_RSQUARE_in_array_constructor5991); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_RSQUARE.add(RSQUARE267);

							// AST REWRITE
							// elements: e2, array_range_more, e1
							// token labels: 
							// rule labels: e1, e2, retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							if ( state.backtracking==0 ) {
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_e1=new RewriteRuleSubtreeStream(adaptor,"rule e1",e1!=null?e1.getTree():null);
							RewriteRuleSubtreeStream stream_e2=new RewriteRuleSubtreeStream(adaptor,"rule e2",e2!=null?e2.getTree():null);
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 699:21: -> ^( ARRAY_RANGE $e1 $e2 ( array_range_more )* )
							{
								// src/exm/stc/ast/ExM.g:699:24: ^( ARRAY_RANGE $e1 $e2 ( array_range_more )* )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARRAY_RANGE, "ARRAY_RANGE"), root_1);
								adaptor.addChild(root_1, stream_e1.nextTree());
								adaptor.addChild(root_1, stream_e2.nextTree());
								// src/exm/stc/ast/ExM.g:699:47: ( array_range_more )*
								while ( stream_array_range_more.hasNext() ) {
									adaptor.addChild(root_1, stream_array_range_more.nextTree());
								}
								stream_array_range_more.reset();

								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;
							}

							}
							break;
						case 2 :
							// src/exm/stc/ast/ExM.g:700:17: ( array_elems_more )* RSQUARE
							{
							// src/exm/stc/ast/ExM.g:700:17: ( array_elems_more )*
							loop80:
							while (true) {
								int alt80=2;
								int LA80_0 = input.LA(1);
								if ( (LA80_0==COMMA) ) {
									alt80=1;
								}

								switch (alt80) {
								case 1 :
									// src/exm/stc/ast/ExM.g:700:17: array_elems_more
									{
									pushFollow(FOLLOW_array_elems_more_in_array_constructor6046);
									array_elems_more268=array_elems_more();
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) stream_array_elems_more.add(array_elems_more268.getTree());
									}
									break;

								default :
									break loop80;
								}
							}

							RSQUARE269=(Token)match(input,RSQUARE,FOLLOW_RSQUARE_in_array_constructor6049); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_RSQUARE.add(RSQUARE269);

							// AST REWRITE
							// elements: array_elems_more, e1
							// token labels: 
							// rule labels: e1, retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							if ( state.backtracking==0 ) {
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_e1=new RewriteRuleSubtreeStream(adaptor,"rule e1",e1!=null?e1.getTree():null);
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 701:21: -> ^( ARRAY_ELEMS $e1 ( array_elems_more )* )
							{
								// src/exm/stc/ast/ExM.g:701:24: ^( ARRAY_ELEMS $e1 ( array_elems_more )* )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARRAY_ELEMS, "ARRAY_ELEMS"), root_1);
								adaptor.addChild(root_1, stream_e1.nextTree());
								// src/exm/stc/ast/ExM.g:701:43: ( array_elems_more )*
								while ( stream_array_elems_more.hasNext() ) {
									adaptor.addChild(root_1, stream_array_elems_more.nextTree());
								}
								stream_array_elems_more.reset();

								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;
							}

							}
							break;

					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "array_constructor"


	public static class array_range_more_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "array_range_more"
	// src/exm/stc/ast/ExM.g:704:1: array_range_more : COLON expr -> expr ;
	public final ExMParser.array_range_more_return array_range_more() throws RecognitionException {
		ExMParser.array_range_more_return retval = new ExMParser.array_range_more_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COLON270=null;
		ParserRuleReturnScope expr271 =null;

		Object COLON270_tree=null;
		RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// src/exm/stc/ast/ExM.g:704:17: ( COLON expr -> expr )
			// src/exm/stc/ast/ExM.g:705:9: COLON expr
			{
			COLON270=(Token)match(input,COLON,FOLLOW_COLON_in_array_range_more6105); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_COLON.add(COLON270);

			pushFollow(FOLLOW_expr_in_array_range_more6107);
			expr271=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(expr271.getTree());
			// AST REWRITE
			// elements: expr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 705:20: -> expr
			{
				adaptor.addChild(root_0, stream_expr.nextTree());
			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "array_range_more"


	public static class array_elems_more_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "array_elems_more"
	// src/exm/stc/ast/ExM.g:708:1: array_elems_more : COMMA expr -> expr ;
	public final ExMParser.array_elems_more_return array_elems_more() throws RecognitionException {
		ExMParser.array_elems_more_return retval = new ExMParser.array_elems_more_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMA272=null;
		ParserRuleReturnScope expr273 =null;

		Object COMMA272_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// src/exm/stc/ast/ExM.g:708:17: ( COMMA expr -> expr )
			// src/exm/stc/ast/ExM.g:709:9: COMMA expr
			{
			COMMA272=(Token)match(input,COMMA,FOLLOW_COMMA_in_array_elems_more6131); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_COMMA.add(COMMA272);

			pushFollow(FOLLOW_expr_in_array_elems_more6133);
			expr273=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(expr273.getTree());
			// AST REWRITE
			// elements: expr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 709:20: -> expr
			{
				adaptor.addChild(root_0, stream_expr.nextTree());
			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "array_elems_more"


	public static class array_kv_constructor_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "array_kv_constructor"
	// src/exm/stc/ast/ExM.g:712:1: array_kv_constructor : ( LBRACE RBRACE -> ^( ARRAY_KV_ELEMS ) | LBRACE e= array_kv_elem ( array_kv_elems_more )* RBRACE -> ^( ARRAY_KV_ELEMS $e ( array_kv_elems_more )* ) );
	public final ExMParser.array_kv_constructor_return array_kv_constructor() throws RecognitionException {
		ExMParser.array_kv_constructor_return retval = new ExMParser.array_kv_constructor_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LBRACE274=null;
		Token RBRACE275=null;
		Token LBRACE276=null;
		Token RBRACE278=null;
		ParserRuleReturnScope e =null;
		ParserRuleReturnScope array_kv_elems_more277 =null;

		Object LBRACE274_tree=null;
		Object RBRACE275_tree=null;
		Object LBRACE276_tree=null;
		Object RBRACE278_tree=null;
		RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
		RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
		RewriteRuleSubtreeStream stream_array_kv_elems_more=new RewriteRuleSubtreeStream(adaptor,"rule array_kv_elems_more");
		RewriteRuleSubtreeStream stream_array_kv_elem=new RewriteRuleSubtreeStream(adaptor,"rule array_kv_elem");

		try {
			// src/exm/stc/ast/ExM.g:712:21: ( LBRACE RBRACE -> ^( ARRAY_KV_ELEMS ) | LBRACE e= array_kv_elem ( array_kv_elems_more )* RBRACE -> ^( ARRAY_KV_ELEMS $e ( array_kv_elems_more )* ) )
			int alt84=2;
			int LA84_0 = input.LA(1);
			if ( (LA84_0==LBRACE) ) {
				int LA84_1 = input.LA(2);
				if ( (LA84_1==RBRACE) ) {
					alt84=1;
				}
				else if ( (LA84_1==ATSIGN||(LA84_1 >= DECIMAL && LA84_1 <= DECIMAL_INT)||LA84_1==FALSE||(LA84_1 >= HEX_INT && LA84_1 <= ID)||LA84_1==INFINITY||(LA84_1 >= LBRACE && LA84_1 <= LSQUARE)||LA84_1==MINUS||(LA84_1 >= NOT && LA84_1 <= NOTANUMBER)||LA84_1==OCTAL_INT||LA84_1==SCI_DECIMAL||LA84_1==STRING||(LA84_1 >= STRING_MULTI_LINE_1 && LA84_1 <= STRING_MULTI_LINE_2)||LA84_1==TRUE) ) {
					alt84=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 84, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 84, 0, input);
				throw nvae;
			}

			switch (alt84) {
				case 1 :
					// src/exm/stc/ast/ExM.g:713:3: LBRACE RBRACE
					{
					LBRACE274=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_array_kv_constructor6151); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE274);

					RBRACE275=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_array_kv_constructor6153); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE275);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 713:17: -> ^( ARRAY_KV_ELEMS )
					{
						// src/exm/stc/ast/ExM.g:713:20: ^( ARRAY_KV_ELEMS )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARRAY_KV_ELEMS, "ARRAY_KV_ELEMS"), root_1);
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:714:6: LBRACE e= array_kv_elem ( array_kv_elems_more )* RBRACE
					{
					LBRACE276=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_array_kv_constructor6168); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE276);

					pushFollow(FOLLOW_array_kv_elem_in_array_kv_constructor6172);
					e=array_kv_elem();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_array_kv_elem.add(e.getTree());
					// src/exm/stc/ast/ExM.g:714:29: ( array_kv_elems_more )*
					loop83:
					while (true) {
						int alt83=2;
						int LA83_0 = input.LA(1);
						if ( (LA83_0==COMMA) ) {
							alt83=1;
						}

						switch (alt83) {
						case 1 :
							// src/exm/stc/ast/ExM.g:714:29: array_kv_elems_more
							{
							pushFollow(FOLLOW_array_kv_elems_more_in_array_kv_constructor6174);
							array_kv_elems_more277=array_kv_elems_more();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_array_kv_elems_more.add(array_kv_elems_more277.getTree());
							}
							break;

						default :
							break loop83;
						}
					}

					RBRACE278=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_array_kv_constructor6177); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE278);

					// AST REWRITE
					// elements: e, array_kv_elems_more
					// token labels: 
					// rule labels: e, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_e=new RewriteRuleSubtreeStream(adaptor,"rule e",e!=null?e.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 715:4: -> ^( ARRAY_KV_ELEMS $e ( array_kv_elems_more )* )
					{
						// src/exm/stc/ast/ExM.g:715:7: ^( ARRAY_KV_ELEMS $e ( array_kv_elems_more )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARRAY_KV_ELEMS, "ARRAY_KV_ELEMS"), root_1);
						adaptor.addChild(root_1, stream_e.nextTree());
						// src/exm/stc/ast/ExM.g:715:28: ( array_kv_elems_more )*
						while ( stream_array_kv_elems_more.hasNext() ) {
							adaptor.addChild(root_1, stream_array_kv_elems_more.nextTree());
						}
						stream_array_kv_elems_more.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "array_kv_constructor"


	public static class array_kv_elem_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "array_kv_elem"
	// src/exm/stc/ast/ExM.g:718:1: array_kv_elem : k= expr COLON v= expr -> ^( ARRAY_KV_ELEM $k $v) ;
	public final ExMParser.array_kv_elem_return array_kv_elem() throws RecognitionException {
		ExMParser.array_kv_elem_return retval = new ExMParser.array_kv_elem_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COLON279=null;
		ParserRuleReturnScope k =null;
		ParserRuleReturnScope v =null;

		Object COLON279_tree=null;
		RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// src/exm/stc/ast/ExM.g:718:14: (k= expr COLON v= expr -> ^( ARRAY_KV_ELEM $k $v) )
			// src/exm/stc/ast/ExM.g:719:3: k= expr COLON v= expr
			{
			pushFollow(FOLLOW_expr_in_array_kv_elem6208);
			k=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(k.getTree());
			COLON279=(Token)match(input,COLON,FOLLOW_COLON_in_array_kv_elem6210); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_COLON.add(COLON279);

			pushFollow(FOLLOW_expr_in_array_kv_elem6214);
			v=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(v.getTree());
			// AST REWRITE
			// elements: v, k
			// token labels: 
			// rule labels: v, k, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_v=new RewriteRuleSubtreeStream(adaptor,"rule v",v!=null?v.getTree():null);
			RewriteRuleSubtreeStream stream_k=new RewriteRuleSubtreeStream(adaptor,"rule k",k!=null?k.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 720:4: -> ^( ARRAY_KV_ELEM $k $v)
			{
				// src/exm/stc/ast/ExM.g:720:7: ^( ARRAY_KV_ELEM $k $v)
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARRAY_KV_ELEM, "ARRAY_KV_ELEM"), root_1);
				adaptor.addChild(root_1, stream_k.nextTree());
				adaptor.addChild(root_1, stream_v.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "array_kv_elem"


	public static class array_kv_elems_more_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "array_kv_elems_more"
	// src/exm/stc/ast/ExM.g:723:1: array_kv_elems_more : COMMA array_kv_elem -> array_kv_elem ;
	public final ExMParser.array_kv_elems_more_return array_kv_elems_more() throws RecognitionException {
		ExMParser.array_kv_elems_more_return retval = new ExMParser.array_kv_elems_more_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMA280=null;
		ParserRuleReturnScope array_kv_elem281 =null;

		Object COMMA280_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_array_kv_elem=new RewriteRuleSubtreeStream(adaptor,"rule array_kv_elem");

		try {
			// src/exm/stc/ast/ExM.g:723:20: ( COMMA array_kv_elem -> array_kv_elem )
			// src/exm/stc/ast/ExM.g:724:3: COMMA array_kv_elem
			{
			COMMA280=(Token)match(input,COMMA,FOLLOW_COMMA_in_array_kv_elems_more6243); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_COMMA.add(COMMA280);

			pushFollow(FOLLOW_array_kv_elem_in_array_kv_elems_more6245);
			array_kv_elem281=array_kv_elem();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_array_kv_elem.add(array_kv_elem281.getTree());
			// AST REWRITE
			// elements: array_kv_elem
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 724:23: -> array_kv_elem
			{
				adaptor.addChild(root_0, stream_array_kv_elem.nextTree());
			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "array_kv_elems_more"


	public static class assignment_expr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "assignment_expr"
	// src/exm/stc/ast/ExM.g:727:1: assignment_expr : i= assignment_list assign_op e= expr ( more_expr )* -> ^( ASSIGN_EXPRESSION assign_op $i $e ( more_expr )* ) ;
	public final ExMParser.assignment_expr_return assignment_expr() throws RecognitionException {
		ExMParser.assignment_expr_return retval = new ExMParser.assignment_expr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope i =null;
		ParserRuleReturnScope e =null;
		ParserRuleReturnScope assign_op282 =null;
		ParserRuleReturnScope more_expr283 =null;

		RewriteRuleSubtreeStream stream_assignment_list=new RewriteRuleSubtreeStream(adaptor,"rule assignment_list");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_assign_op=new RewriteRuleSubtreeStream(adaptor,"rule assign_op");
		RewriteRuleSubtreeStream stream_more_expr=new RewriteRuleSubtreeStream(adaptor,"rule more_expr");

		try {
			// src/exm/stc/ast/ExM.g:727:16: (i= assignment_list assign_op e= expr ( more_expr )* -> ^( ASSIGN_EXPRESSION assign_op $i $e ( more_expr )* ) )
			// src/exm/stc/ast/ExM.g:728:9: i= assignment_list assign_op e= expr ( more_expr )*
			{
			pushFollow(FOLLOW_assignment_list_in_assignment_expr6269);
			i=assignment_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_assignment_list.add(i.getTree());
			pushFollow(FOLLOW_assign_op_in_assignment_expr6271);
			assign_op282=assign_op();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_assign_op.add(assign_op282.getTree());
			pushFollow(FOLLOW_expr_in_assignment_expr6275);
			e=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(e.getTree());
			// src/exm/stc/ast/ExM.g:728:44: ( more_expr )*
			loop85:
			while (true) {
				int alt85=2;
				int LA85_0 = input.LA(1);
				if ( (LA85_0==COMMA) ) {
					alt85=1;
				}

				switch (alt85) {
				case 1 :
					// src/exm/stc/ast/ExM.g:728:44: more_expr
					{
					pushFollow(FOLLOW_more_expr_in_assignment_expr6277);
					more_expr283=more_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_more_expr.add(more_expr283.getTree());
					}
					break;

				default :
					break loop85;
				}
			}

			// AST REWRITE
			// elements: more_expr, assign_op, i, e
			// token labels: 
			// rule labels: e, i, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_e=new RewriteRuleSubtreeStream(adaptor,"rule e",e!=null?e.getTree():null);
			RewriteRuleSubtreeStream stream_i=new RewriteRuleSubtreeStream(adaptor,"rule i",i!=null?i.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 728:55: -> ^( ASSIGN_EXPRESSION assign_op $i $e ( more_expr )* )
			{
				// src/exm/stc/ast/ExM.g:729:11: ^( ASSIGN_EXPRESSION assign_op $i $e ( more_expr )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGN_EXPRESSION, "ASSIGN_EXPRESSION"), root_1);
				adaptor.addChild(root_1, stream_assign_op.nextTree());
				adaptor.addChild(root_1, stream_i.nextTree());
				adaptor.addChild(root_1, stream_e.nextTree());
				// src/exm/stc/ast/ExM.g:729:48: ( more_expr )*
				while ( stream_more_expr.hasNext() ) {
					adaptor.addChild(root_1, stream_more_expr.nextTree());
				}
				stream_more_expr.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "assignment_expr"


	public static class assign_op_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "assign_op"
	// src/exm/stc/ast/ExM.g:733:1: assign_op : ( ASSIGN | APPEND );
	public final ExMParser.assign_op_return assign_op() throws RecognitionException {
		ExMParser.assign_op_return retval = new ExMParser.assign_op_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set284=null;

		Object set284_tree=null;

		try {
			// src/exm/stc/ast/ExM.g:733:10: ( ASSIGN | APPEND )
			// src/exm/stc/ast/ExM.g:
			{
			root_0 = (Object)adaptor.nil();


			set284=input.LT(1);
			if ( input.LA(1)==APPEND||input.LA(1)==ASSIGN ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set284));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "assign_op"


	public static class more_expr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "more_expr"
	// src/exm/stc/ast/ExM.g:737:1: more_expr : COMMA expr -> expr ;
	public final ExMParser.more_expr_return more_expr() throws RecognitionException {
		ExMParser.more_expr_return retval = new ExMParser.more_expr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMA285=null;
		ParserRuleReturnScope expr286 =null;

		Object COMMA285_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// src/exm/stc/ast/ExM.g:737:10: ( COMMA expr -> expr )
			// src/exm/stc/ast/ExM.g:738:9: COMMA expr
			{
			COMMA285=(Token)match(input,COMMA,FOLLOW_COMMA_in_more_expr6352); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_COMMA.add(COMMA285);

			pushFollow(FOLLOW_expr_in_more_expr6354);
			expr286=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(expr286.getTree());
			// AST REWRITE
			// elements: expr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 738:20: -> expr
			{
				adaptor.addChild(root_0, stream_expr.nextTree());
			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "more_expr"


	public static class paren_expr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "paren_expr"
	// src/exm/stc/ast/ExM.g:742:1: paren_expr : LPAREN e= expr ( -> $e| ( more_expr )* -> ^( TUPLE $e ( more_expr )* ) ) RPAREN ;
	public final ExMParser.paren_expr_return paren_expr() throws RecognitionException {
		ExMParser.paren_expr_return retval = new ExMParser.paren_expr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LPAREN287=null;
		Token RPAREN289=null;
		ParserRuleReturnScope e =null;
		ParserRuleReturnScope more_expr288 =null;

		Object LPAREN287_tree=null;
		Object RPAREN289_tree=null;
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_more_expr=new RewriteRuleSubtreeStream(adaptor,"rule more_expr");

		try {
			// src/exm/stc/ast/ExM.g:742:11: ( LPAREN e= expr ( -> $e| ( more_expr )* -> ^( TUPLE $e ( more_expr )* ) ) RPAREN )
			// src/exm/stc/ast/ExM.g:743:5: LPAREN e= expr ( -> $e| ( more_expr )* -> ^( TUPLE $e ( more_expr )* ) ) RPAREN
			{
			LPAREN287=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_paren_expr6375); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN287);

			pushFollow(FOLLOW_expr_in_paren_expr6379);
			e=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(e.getTree());
			// src/exm/stc/ast/ExM.g:743:19: ( -> $e| ( more_expr )* -> ^( TUPLE $e ( more_expr )* ) )
			int alt87=2;
			int LA87_0 = input.LA(1);
			if ( (LA87_0==RPAREN) ) {
				int LA87_1 = input.LA(2);
				if ( (synpred132_ExM()) ) {
					alt87=1;
				}
				else if ( (true) ) {
					alt87=2;
				}

			}
			else if ( (LA87_0==COMMA) ) {
				alt87=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 87, 0, input);
				throw nvae;
			}

			switch (alt87) {
				case 1 :
					// src/exm/stc/ast/ExM.g:744:9: 
					{
					// AST REWRITE
					// elements: e
					// token labels: 
					// rule labels: e, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_e=new RewriteRuleSubtreeStream(adaptor,"rule e",e!=null?e.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 744:9: -> $e
					{
						adaptor.addChild(root_0, stream_e.nextTree());
					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:745:9: ( more_expr )*
					{
					// src/exm/stc/ast/ExM.g:745:9: ( more_expr )*
					loop86:
					while (true) {
						int alt86=2;
						int LA86_0 = input.LA(1);
						if ( (LA86_0==COMMA) ) {
							alt86=1;
						}

						switch (alt86) {
						case 1 :
							// src/exm/stc/ast/ExM.g:745:9: more_expr
							{
							pushFollow(FOLLOW_more_expr_in_paren_expr6404);
							more_expr288=more_expr();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_more_expr.add(more_expr288.getTree());
							}
							break;

						default :
							break loop86;
						}
					}

					// AST REWRITE
					// elements: e, more_expr
					// token labels: 
					// rule labels: e, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_e=new RewriteRuleSubtreeStream(adaptor,"rule e",e!=null?e.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 745:20: -> ^( TUPLE $e ( more_expr )* )
					{
						// src/exm/stc/ast/ExM.g:745:23: ^( TUPLE $e ( more_expr )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TUPLE, "TUPLE"), root_1);
						adaptor.addChild(root_1, stream_e.nextTree());
						// src/exm/stc/ast/ExM.g:745:35: ( more_expr )*
						while ( stream_more_expr.hasNext() ) {
							adaptor.addChild(root_1, stream_more_expr.nextTree());
						}
						stream_more_expr.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}

			RPAREN289=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_paren_expr6427); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN289);

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "paren_expr"


	public static class assignment_list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "assignment_list"
	// src/exm/stc/ast/ExM.g:748:1: assignment_list : ( LPAREN a= assignment_list_arguments RPAREN -> ^( IDENTIFIER_LIST $a) |a= assignment_list_arguments -> ^( IDENTIFIER_LIST $a) );
	public final ExMParser.assignment_list_return assignment_list() throws RecognitionException {
		ExMParser.assignment_list_return retval = new ExMParser.assignment_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LPAREN290=null;
		Token RPAREN291=null;
		ParserRuleReturnScope a =null;

		Object LPAREN290_tree=null;
		Object RPAREN291_tree=null;
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleSubtreeStream stream_assignment_list_arguments=new RewriteRuleSubtreeStream(adaptor,"rule assignment_list_arguments");

		try {
			// src/exm/stc/ast/ExM.g:748:16: ( LPAREN a= assignment_list_arguments RPAREN -> ^( IDENTIFIER_LIST $a) |a= assignment_list_arguments -> ^( IDENTIFIER_LIST $a) )
			int alt88=2;
			int LA88_0 = input.LA(1);
			if ( (LA88_0==LPAREN) ) {
				alt88=1;
			}
			else if ( (LA88_0==ID) ) {
				alt88=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 88, 0, input);
				throw nvae;
			}

			switch (alt88) {
				case 1 :
					// src/exm/stc/ast/ExM.g:749:9: LPAREN a= assignment_list_arguments RPAREN
					{
					LPAREN290=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_assignment_list6442); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN290);

					pushFollow(FOLLOW_assignment_list_arguments_in_assignment_list6446);
					a=assignment_list_arguments();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_assignment_list_arguments.add(a.getTree());
					RPAREN291=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_assignment_list6448); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN291);

					// AST REWRITE
					// elements: a
					// token labels: 
					// rule labels: a, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 749:51: -> ^( IDENTIFIER_LIST $a)
					{
						// src/exm/stc/ast/ExM.g:750:13: ^( IDENTIFIER_LIST $a)
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IDENTIFIER_LIST, "IDENTIFIER_LIST"), root_1);
						adaptor.addChild(root_1, stream_a.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:751:14: a= assignment_list_arguments
					{
					pushFollow(FOLLOW_assignment_list_arguments_in_assignment_list6488);
					a=assignment_list_arguments();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_assignment_list_arguments.add(a.getTree());
					// AST REWRITE
					// elements: a
					// token labels: 
					// rule labels: a, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 751:42: -> ^( IDENTIFIER_LIST $a)
					{
						// src/exm/stc/ast/ExM.g:752:13: ^( IDENTIFIER_LIST $a)
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IDENTIFIER_LIST, "IDENTIFIER_LIST"), root_1);
						adaptor.addChild(root_1, stream_a.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "assignment_list"


	public static class assignment_list_arguments_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "assignment_list_arguments"
	// src/exm/stc/ast/ExM.g:755:1: assignment_list_arguments : assign_target ( assignment_list_arguments_rest )* ;
	public final ExMParser.assignment_list_arguments_return assignment_list_arguments() throws RecognitionException {
		ExMParser.assignment_list_arguments_return retval = new ExMParser.assignment_list_arguments_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope assign_target292 =null;
		ParserRuleReturnScope assignment_list_arguments_rest293 =null;


		try {
			// src/exm/stc/ast/ExM.g:755:26: ( assign_target ( assignment_list_arguments_rest )* )
			// src/exm/stc/ast/ExM.g:757:9: assign_target ( assignment_list_arguments_rest )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_assign_target_in_assignment_list_arguments6541);
			assign_target292=assign_target();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, assign_target292.getTree());

			// src/exm/stc/ast/ExM.g:757:23: ( assignment_list_arguments_rest )*
			loop89:
			while (true) {
				int alt89=2;
				int LA89_0 = input.LA(1);
				if ( (LA89_0==COMMA) ) {
					alt89=1;
				}

				switch (alt89) {
				case 1 :
					// src/exm/stc/ast/ExM.g:757:23: assignment_list_arguments_rest
					{
					pushFollow(FOLLOW_assignment_list_arguments_rest_in_assignment_list_arguments6543);
					assignment_list_arguments_rest293=assignment_list_arguments_rest();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, assignment_list_arguments_rest293.getTree());

					}
					break;

				default :
					break loop89;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "assignment_list_arguments"


	public static class assignment_list_arguments_rest_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "assignment_list_arguments_rest"
	// src/exm/stc/ast/ExM.g:760:1: assignment_list_arguments_rest : COMMA assign_target -> assign_target ;
	public final ExMParser.assignment_list_arguments_rest_return assignment_list_arguments_rest() throws RecognitionException {
		ExMParser.assignment_list_arguments_rest_return retval = new ExMParser.assignment_list_arguments_rest_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMA294=null;
		ParserRuleReturnScope assign_target295 =null;

		Object COMMA294_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_assign_target=new RewriteRuleSubtreeStream(adaptor,"rule assign_target");

		try {
			// src/exm/stc/ast/ExM.g:760:31: ( COMMA assign_target -> assign_target )
			// src/exm/stc/ast/ExM.g:760:33: COMMA assign_target
			{
			COMMA294=(Token)match(input,COMMA,FOLLOW_COMMA_in_assignment_list_arguments_rest6556); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_COMMA.add(COMMA294);

			pushFollow(FOLLOW_assign_target_in_assignment_list_arguments_rest6558);
			assign_target295=assign_target();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_assign_target.add(assign_target295.getTree());
			// AST REWRITE
			// elements: assign_target
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 760:53: -> assign_target
			{
				adaptor.addChild(root_0, stream_assign_target.nextTree());
			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "assignment_list_arguments_rest"


	public static class assign_target_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "assign_target"
	// src/exm/stc/ast/ExM.g:763:1: assign_target : ID ( assign_path_element )* -> ^( ASSIGN_TARGET ^( VARIABLE ID ) ( assign_path_element )* ) ;
	public final ExMParser.assign_target_return assign_target() throws RecognitionException {
		ExMParser.assign_target_return retval = new ExMParser.assign_target_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID296=null;
		ParserRuleReturnScope assign_path_element297 =null;

		Object ID296_tree=null;
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_assign_path_element=new RewriteRuleSubtreeStream(adaptor,"rule assign_path_element");

		try {
			// src/exm/stc/ast/ExM.g:763:14: ( ID ( assign_path_element )* -> ^( ASSIGN_TARGET ^( VARIABLE ID ) ( assign_path_element )* ) )
			// src/exm/stc/ast/ExM.g:764:9: ID ( assign_path_element )*
			{
			ID296=(Token)match(input,ID,FOLLOW_ID_in_assign_target6582); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ID.add(ID296);

			// src/exm/stc/ast/ExM.g:764:12: ( assign_path_element )*
			loop90:
			while (true) {
				int alt90=2;
				int LA90_0 = input.LA(1);
				if ( (LA90_0==LSQUARE||LA90_0==150) ) {
					alt90=1;
				}

				switch (alt90) {
				case 1 :
					// src/exm/stc/ast/ExM.g:764:12: assign_path_element
					{
					pushFollow(FOLLOW_assign_path_element_in_assign_target6584);
					assign_path_element297=assign_path_element();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_assign_path_element.add(assign_path_element297.getTree());
					}
					break;

				default :
					break loop90;
				}
			}

			// AST REWRITE
			// elements: ID, assign_path_element
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 764:33: -> ^( ASSIGN_TARGET ^( VARIABLE ID ) ( assign_path_element )* )
			{
				// src/exm/stc/ast/ExM.g:765:13: ^( ASSIGN_TARGET ^( VARIABLE ID ) ( assign_path_element )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGN_TARGET, "ASSIGN_TARGET"), root_1);
				// src/exm/stc/ast/ExM.g:765:30: ^( VARIABLE ID )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(VARIABLE, "VARIABLE"), root_2);
				adaptor.addChild(root_2, stream_ID.nextNode());
				adaptor.addChild(root_1, root_2);
				}

				// src/exm/stc/ast/ExM.g:765:47: ( assign_path_element )*
				while ( stream_assign_path_element.hasNext() ) {
					adaptor.addChild(root_1, stream_assign_path_element.nextTree());
				}
				stream_assign_path_element.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "assign_target"


	public static class assign_path_element_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "assign_path_element"
	// src/exm/stc/ast/ExM.g:768:1: assign_path_element : ( var_subscript -> ^( STRUCT_PATH var_subscript ) | array_index -> ^( ARRAY_PATH array_index ) );
	public final ExMParser.assign_path_element_return assign_path_element() throws RecognitionException {
		ExMParser.assign_path_element_return retval = new ExMParser.assign_path_element_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope var_subscript298 =null;
		ParserRuleReturnScope array_index299 =null;

		RewriteRuleSubtreeStream stream_array_index=new RewriteRuleSubtreeStream(adaptor,"rule array_index");
		RewriteRuleSubtreeStream stream_var_subscript=new RewriteRuleSubtreeStream(adaptor,"rule var_subscript");

		try {
			// src/exm/stc/ast/ExM.g:768:20: ( var_subscript -> ^( STRUCT_PATH var_subscript ) | array_index -> ^( ARRAY_PATH array_index ) )
			int alt91=2;
			int LA91_0 = input.LA(1);
			if ( (LA91_0==150) ) {
				alt91=1;
			}
			else if ( (LA91_0==LSQUARE) ) {
				alt91=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 91, 0, input);
				throw nvae;
			}

			switch (alt91) {
				case 1 :
					// src/exm/stc/ast/ExM.g:769:9: var_subscript
					{
					pushFollow(FOLLOW_var_subscript_in_assign_path_element6636);
					var_subscript298=var_subscript();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_var_subscript.add(var_subscript298.getTree());
					// AST REWRITE
					// elements: var_subscript
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 769:23: -> ^( STRUCT_PATH var_subscript )
					{
						// src/exm/stc/ast/ExM.g:769:26: ^( STRUCT_PATH var_subscript )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(STRUCT_PATH, "STRUCT_PATH"), root_1);
						adaptor.addChild(root_1, stream_var_subscript.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:770:9: array_index
					{
					pushFollow(FOLLOW_array_index_in_assign_path_element6655);
					array_index299=array_index();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_array_index.add(array_index299.getTree());
					// AST REWRITE
					// elements: array_index
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 770:23: -> ^( ARRAY_PATH array_index )
					{
						// src/exm/stc/ast/ExM.g:770:26: ^( ARRAY_PATH array_index )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARRAY_PATH, "ARRAY_PATH"), root_1);
						adaptor.addChild(root_1, stream_array_index.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "assign_path_element"


	public static class expr_stmt_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr_stmt"
	// src/exm/stc/ast/ExM.g:774:1: expr_stmt : (e= function_call -> ^( EXPR_STMT $e) |e= variable -> ^( EXPR_STMT $e) );
	public final ExMParser.expr_stmt_return expr_stmt() throws RecognitionException {
		ExMParser.expr_stmt_return retval = new ExMParser.expr_stmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope e =null;

		RewriteRuleSubtreeStream stream_function_call=new RewriteRuleSubtreeStream(adaptor,"rule function_call");
		RewriteRuleSubtreeStream stream_variable=new RewriteRuleSubtreeStream(adaptor,"rule variable");

		try {
			// src/exm/stc/ast/ExM.g:774:10: (e= function_call -> ^( EXPR_STMT $e) |e= variable -> ^( EXPR_STMT $e) )
			int alt92=2;
			int LA92_0 = input.LA(1);
			if ( (LA92_0==ATSIGN) ) {
				alt92=1;
			}
			else if ( (LA92_0==ID) ) {
				int LA92_2 = input.LA(2);
				if ( (LA92_2==LPAREN) ) {
					alt92=1;
				}
				else if ( (LA92_2==ASSIGN||LA92_2==SEMICOLON) ) {
					alt92=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 92, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 92, 0, input);
				throw nvae;
			}

			switch (alt92) {
				case 1 :
					// src/exm/stc/ast/ExM.g:775:7: e= function_call
					{
					pushFollow(FOLLOW_function_call_in_expr_stmt6688);
					e=function_call();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_function_call.add(e.getTree());
					// AST REWRITE
					// elements: e
					// token labels: 
					// rule labels: e, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_e=new RewriteRuleSubtreeStream(adaptor,"rule e",e!=null?e.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 775:23: -> ^( EXPR_STMT $e)
					{
						// src/exm/stc/ast/ExM.g:775:26: ^( EXPR_STMT $e)
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPR_STMT, "EXPR_STMT"), root_1);
						adaptor.addChild(root_1, stream_e.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:776:7: e= variable
					{
					pushFollow(FOLLOW_variable_in_expr_stmt6709);
					e=variable();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_variable.add(e.getTree());
					// AST REWRITE
					// elements: e
					// token labels: 
					// rule labels: e, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_e=new RewriteRuleSubtreeStream(adaptor,"rule e",e!=null?e.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 776:18: -> ^( EXPR_STMT $e)
					{
						// src/exm/stc/ast/ExM.g:776:21: ^( EXPR_STMT $e)
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPR_STMT, "EXPR_STMT"), root_1);
						adaptor.addChild(root_1, stream_e.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr_stmt"


	public static class update_stmt_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "update_stmt"
	// src/exm/stc/ast/ExM.g:779:1: update_stmt : v= ID LT cmd= ID GT MUTATE expr SEMICOLON -> ^( UPDATE $cmd $v expr ) ;
	public final ExMParser.update_stmt_return update_stmt() throws RecognitionException {
		ExMParser.update_stmt_return retval = new ExMParser.update_stmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token v=null;
		Token cmd=null;
		Token LT300=null;
		Token GT301=null;
		Token MUTATE302=null;
		Token SEMICOLON304=null;
		ParserRuleReturnScope expr303 =null;

		Object v_tree=null;
		Object cmd_tree=null;
		Object LT300_tree=null;
		Object GT301_tree=null;
		Object MUTATE302_tree=null;
		Object SEMICOLON304_tree=null;
		RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
		RewriteRuleTokenStream stream_LT=new RewriteRuleTokenStream(adaptor,"token LT");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_MUTATE=new RewriteRuleTokenStream(adaptor,"token MUTATE");
		RewriteRuleTokenStream stream_GT=new RewriteRuleTokenStream(adaptor,"token GT");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// src/exm/stc/ast/ExM.g:779:12: (v= ID LT cmd= ID GT MUTATE expr SEMICOLON -> ^( UPDATE $cmd $v expr ) )
			// src/exm/stc/ast/ExM.g:779:14: v= ID LT cmd= ID GT MUTATE expr SEMICOLON
			{
			v=(Token)match(input,ID,FOLLOW_ID_in_update_stmt6734); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ID.add(v);

			LT300=(Token)match(input,LT,FOLLOW_LT_in_update_stmt6736); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LT.add(LT300);

			cmd=(Token)match(input,ID,FOLLOW_ID_in_update_stmt6740); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ID.add(cmd);

			GT301=(Token)match(input,GT,FOLLOW_GT_in_update_stmt6742); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_GT.add(GT301);

			MUTATE302=(Token)match(input,MUTATE,FOLLOW_MUTATE_in_update_stmt6744); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_MUTATE.add(MUTATE302);

			pushFollow(FOLLOW_expr_in_update_stmt6746);
			expr303=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(expr303.getTree());
			SEMICOLON304=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_update_stmt6748); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON304);

			// AST REWRITE
			// elements: cmd, expr, v
			// token labels: v, cmd
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleTokenStream stream_v=new RewriteRuleTokenStream(adaptor,"token v",v);
			RewriteRuleTokenStream stream_cmd=new RewriteRuleTokenStream(adaptor,"token cmd",cmd);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 780:16: -> ^( UPDATE $cmd $v expr )
			{
				// src/exm/stc/ast/ExM.g:780:19: ^( UPDATE $cmd $v expr )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(UPDATE, "UPDATE"), root_1);
				adaptor.addChild(root_1, stream_cmd.nextNode());
				adaptor.addChild(root_1, stream_v.nextNode());
				adaptor.addChild(root_1, stream_expr.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "update_stmt"


	public static class annotation_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "annotation"
	// src/exm/stc/ast/ExM.g:783:1: annotation : ( ATSIGN a= ID -> ^( ANNOTATION $a) | ATSIGN a= ID ASSIGN annotation_val -> ^( ANNOTATION $a annotation_val ) );
	public final ExMParser.annotation_return annotation() throws RecognitionException {
		ExMParser.annotation_return retval = new ExMParser.annotation_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token a=null;
		Token ATSIGN305=null;
		Token ATSIGN306=null;
		Token ASSIGN307=null;
		ParserRuleReturnScope annotation_val308 =null;

		Object a_tree=null;
		Object ATSIGN305_tree=null;
		Object ATSIGN306_tree=null;
		Object ASSIGN307_tree=null;
		RewriteRuleTokenStream stream_ATSIGN=new RewriteRuleTokenStream(adaptor,"token ATSIGN");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
		RewriteRuleSubtreeStream stream_annotation_val=new RewriteRuleSubtreeStream(adaptor,"rule annotation_val");

		try {
			// src/exm/stc/ast/ExM.g:783:11: ( ATSIGN a= ID -> ^( ANNOTATION $a) | ATSIGN a= ID ASSIGN annotation_val -> ^( ANNOTATION $a annotation_val ) )
			int alt93=2;
			int LA93_0 = input.LA(1);
			if ( (LA93_0==ATSIGN) ) {
				int LA93_1 = input.LA(2);
				if ( (LA93_1==ID) ) {
					int LA93_2 = input.LA(3);
					if ( (LA93_2==ASSIGN) ) {
						alt93=2;
					}
					else if ( (LA93_2==EOF||LA93_2==APP||LA93_2==ATSIGN||(LA93_2 >= FOR && LA93_2 <= FOREACH)||LA93_2==ID||LA93_2==LPAREN||LA93_2==LT) ) {
						alt93=1;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 93, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 93, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 93, 0, input);
				throw nvae;
			}

			switch (alt93) {
				case 1 :
					// src/exm/stc/ast/ExM.g:784:9: ATSIGN a= ID
					{
					ATSIGN305=(Token)match(input,ATSIGN,FOLLOW_ATSIGN_in_annotation6798); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ATSIGN.add(ATSIGN305);

					a=(Token)match(input,ID,FOLLOW_ID_in_annotation6802); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ID.add(a);

					// AST REWRITE
					// elements: a
					// token labels: a
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleTokenStream stream_a=new RewriteRuleTokenStream(adaptor,"token a",a);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 785:13: -> ^( ANNOTATION $a)
					{
						// src/exm/stc/ast/ExM.g:785:16: ^( ANNOTATION $a)
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ANNOTATION, "ANNOTATION"), root_1);
						adaptor.addChild(root_1, stream_a.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:786:9: ATSIGN a= ID ASSIGN annotation_val
					{
					ATSIGN306=(Token)match(input,ATSIGN,FOLLOW_ATSIGN_in_annotation6835); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ATSIGN.add(ATSIGN306);

					a=(Token)match(input,ID,FOLLOW_ID_in_annotation6839); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ID.add(a);

					ASSIGN307=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_annotation6841); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN307);

					pushFollow(FOLLOW_annotation_val_in_annotation6843);
					annotation_val308=annotation_val();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_annotation_val.add(annotation_val308.getTree());
					// AST REWRITE
					// elements: annotation_val, a
					// token labels: a
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleTokenStream stream_a=new RewriteRuleTokenStream(adaptor,"token a",a);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 787:13: -> ^( ANNOTATION $a annotation_val )
					{
						// src/exm/stc/ast/ExM.g:787:16: ^( ANNOTATION $a annotation_val )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ANNOTATION, "ANNOTATION"), root_1);
						adaptor.addChild(root_1, stream_a.nextNode());
						adaptor.addChild(root_1, stream_annotation_val.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "annotation"


	public static class annotation_val_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "annotation_val"
	// src/exm/stc/ast/ExM.g:790:1: annotation_val : ( ID | integer );
	public final ExMParser.annotation_val_return annotation_val() throws RecognitionException {
		ExMParser.annotation_val_return retval = new ExMParser.annotation_val_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID309=null;
		ParserRuleReturnScope integer310 =null;

		Object ID309_tree=null;

		try {
			// src/exm/stc/ast/ExM.g:790:15: ( ID | integer )
			int alt94=2;
			int LA94_0 = input.LA(1);
			if ( (LA94_0==ID) ) {
				alt94=1;
			}
			else if ( (LA94_0==DECIMAL_INT||LA94_0==HEX_INT||LA94_0==OCTAL_INT) ) {
				alt94=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 94, 0, input);
				throw nvae;
			}

			switch (alt94) {
				case 1 :
					// src/exm/stc/ast/ExM.g:790:17: ID
					{
					root_0 = (Object)adaptor.nil();


					ID309=(Token)match(input,ID,FOLLOW_ID_in_annotation_val6880); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID309_tree = (Object)adaptor.create(ID309);
					adaptor.addChild(root_0, ID309_tree);
					}

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:790:22: integer
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_integer_in_annotation_val6884);
					integer310=integer();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, integer310.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "annotation_val"

	// $ANTLR start synpred3_ExM
	public final void synpred3_ExM_fragment() throws RecognitionException {
		// src/exm/stc/ast/ExM.g:192:9: ( ( function_definition ) )
		// src/exm/stc/ast/ExM.g:192:9: ( function_definition )
		{
		// src/exm/stc/ast/ExM.g:192:9: ( function_definition )
		// src/exm/stc/ast/ExM.g:192:10: function_definition
		{
		pushFollow(FOLLOW_function_definition_in_synpred3_ExM883);
		function_definition();
		state._fsp--;
		if (state.failed) return;

		}

		}

	}
	// $ANTLR end synpred3_ExM

	// $ANTLR start synpred8_ExM
	public final void synpred8_ExM_fragment() throws RecognitionException {
		// src/exm/stc/ast/ExM.g:197:9: ( ( stmt_chain ) )
		// src/exm/stc/ast/ExM.g:197:9: ( stmt_chain )
		{
		// src/exm/stc/ast/ExM.g:197:9: ( stmt_chain )
		// src/exm/stc/ast/ExM.g:197:10: stmt_chain
		{
		pushFollow(FOLLOW_stmt_chain_in_synpred8_ExM943);
		stmt_chain();
		state._fsp--;
		if (state.failed) return;

		}

		}

	}
	// $ANTLR end synpred8_ExM

	// $ANTLR start synpred12_ExM
	public final void synpred12_ExM_fragment() throws RecognitionException {
		// src/exm/stc/ast/ExM.g:201:9: ( ( foreach_loop ) )
		// src/exm/stc/ast/ExM.g:201:9: ( foreach_loop )
		{
		// src/exm/stc/ast/ExM.g:201:9: ( foreach_loop )
		// src/exm/stc/ast/ExM.g:201:10: foreach_loop
		{
		pushFollow(FOLLOW_foreach_loop_in_synpred12_ExM991);
		foreach_loop();
		state._fsp--;
		if (state.failed) return;

		}

		}

	}
	// $ANTLR end synpred12_ExM

	// $ANTLR start synpred13_ExM
	public final void synpred13_ExM_fragment() throws RecognitionException {
		// src/exm/stc/ast/ExM.g:202:9: ( ( for_loop ) )
		// src/exm/stc/ast/ExM.g:202:9: ( for_loop )
		{
		// src/exm/stc/ast/ExM.g:202:9: ( for_loop )
		// src/exm/stc/ast/ExM.g:202:10: for_loop
		{
		pushFollow(FOLLOW_for_loop_in_synpred13_ExM1003);
		for_loop();
		state._fsp--;
		if (state.failed) return;

		}

		}

	}
	// $ANTLR end synpred13_ExM

	// $ANTLR start synpred88_ExM
	public final void synpred88_ExM_fragment() throws RecognitionException {
		ParserRuleReturnScope b =null;


		// src/exm/stc/ast/ExM.g:563:15: ( aexpr_op b= mexpr )
		// src/exm/stc/ast/ExM.g:563:15: aexpr_op b= mexpr
		{
		pushFollow(FOLLOW_aexpr_op_in_synpred88_ExM4673);
		aexpr_op();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_mexpr_in_synpred88_ExM4677);
		b=mexpr();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred88_ExM

	// $ANTLR start synpred98_ExM
	public final void synpred98_ExM_fragment() throws RecognitionException {
		// src/exm/stc/ast/ExM.g:602:13: ( array_index )
		// src/exm/stc/ast/ExM.g:602:13: array_index
		{
		pushFollow(FOLLOW_array_index_in_synpred98_ExM5029);
		array_index();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred98_ExM

	// $ANTLR start synpred101_ExM
	public final void synpred101_ExM_fragment() throws RecognitionException {
		// src/exm/stc/ast/ExM.g:621:13: ( function_call )
		// src/exm/stc/ast/ExM.g:621:13: function_call
		{
		pushFollow(FOLLOW_function_call_in_synpred101_ExM5184);
		function_call();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred101_ExM

	// $ANTLR start synpred102_ExM
	public final void synpred102_ExM_fragment() throws RecognitionException {
		// src/exm/stc/ast/ExM.g:622:13: ( variable )
		// src/exm/stc/ast/ExM.g:622:13: variable
		{
		pushFollow(FOLLOW_variable_in_synpred102_ExM5198);
		variable();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred102_ExM

	// $ANTLR start synpred132_ExM
	public final void synpred132_ExM_fragment() throws RecognitionException {
		// src/exm/stc/ast/ExM.g:744:9: ()
		// src/exm/stc/ast/ExM.g:744:9: 
		{
		}

	}
	// $ANTLR end synpred132_ExM

	// Delegated rules

	public final boolean synpred101_ExM() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred101_ExM_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred132_ExM() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred132_ExM_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred102_ExM() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred102_ExM_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred12_ExM() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred12_ExM_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred13_ExM() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred13_ExM_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred3_ExM() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred3_ExM_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred8_ExM() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred8_ExM_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred88_ExM() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred88_ExM_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred98_ExM() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred98_ExM_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}


	protected DFA42 dfa42 = new DFA42(this);
	static final String DFA42_eotS =
		"\12\uffff";
	static final String DFA42_eofS =
		"\12\uffff";
	static final String DFA42_minS =
		"\1\27\2\111\1\24\1\40\1\45\2\uffff\2\27";
	static final String DFA42_maxS =
		"\1\74\2\111\1\74\1\117\1\150\2\uffff\2\74";
	static final String DFA42_acceptS =
		"\6\uffff\1\1\1\2\2\uffff";
	static final String DFA42_specialS =
		"\12\uffff}>";
	static final String[] DFA42_transitionS = {
			"\1\1\44\uffff\1\2",
			"\1\3",
			"\1\4",
			"\1\5\2\uffff\1\1\44\uffff\1\2",
			"\1\6\56\uffff\1\7",
			"\1\11\42\uffff\1\11\1\10\36\uffff\1\11",
			"",
			"",
			"\1\1\44\uffff\1\2",
			"\1\1\44\uffff\1\2"
	};

	static final short[] DFA42_eot = DFA.unpackEncodedString(DFA42_eotS);
	static final short[] DFA42_eof = DFA.unpackEncodedString(DFA42_eofS);
	static final char[] DFA42_min = DFA.unpackEncodedStringToUnsignedChars(DFA42_minS);
	static final char[] DFA42_max = DFA.unpackEncodedStringToUnsignedChars(DFA42_maxS);
	static final short[] DFA42_accept = DFA.unpackEncodedString(DFA42_acceptS);
	static final short[] DFA42_special = DFA.unpackEncodedString(DFA42_specialS);
	static final short[][] DFA42_transition;

	static {
		int numStates = DFA42_transitionS.length;
		DFA42_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA42_transition[i] = DFA.unpackEncodedString(DFA42_transitionS[i]);
		}
	}

	protected class DFA42 extends DFA {

		public DFA42(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 42;
			this.eot = DFA42_eot;
			this.eof = DFA42_eof;
			this.min = DFA42_min;
			this.max = DFA42_max;
			this.accept = DFA42_accept;
			this.special = DFA42_special;
			this.transition = DFA42_transition;
		}
		@Override
		public String getDescription() {
			return "429:1: foreach_loop : ( ( annotation )* FOREACH v= var_name COMMA i= var_name IN e= expr b= block -> ^( FOREACH_LOOP $e $b $v $i ( annotation )* ) | ( annotation )* FOREACH v= var_name IN e= expr b= block -> ^( FOREACH_LOOP $e $b $v ( annotation )* ) );";
		}
	}

	public static final BitSet FOLLOW_stmt_in_program808 = new BitSet(new long[]{0x1800000000800080L,0x0041000002D02A08L,0x0000000000040C10L});
	public static final BitSet FOLLOW_EOF_in_program811 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEMICOLON_in_stmt844 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_real_stmt_in_stmt857 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_definition_in_real_stmt883 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_new_type_definition_in_real_stmt895 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_global_const_definition_in_real_stmt907 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_import_statement_in_real_stmt919 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pragma_stmt_in_real_stmt931 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stmt_chain_in_real_stmt943 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_if_stmt_in_real_stmt955 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_switch_stmt_in_real_stmt967 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_real_stmt979 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_foreach_loop_in_real_stmt991 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_for_loop_in_real_stmt1003 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_iterate_loop_in_real_stmt1015 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_wait_stmt_in_real_stmt1027 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_update_stmt_in_real_stmt1039 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_chainable_stmt_in_stmt_chain1060 = new BitSet(new long[]{0x0000000000100000L,0x0040000000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_stmt_chain1075 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stmt_chain_op_in_stmt_chain1113 = new BitSet(new long[]{0x1800000000800080L,0x0001000002D02A08L,0x0000000000040C10L});
	public static final BitSet FOLLOW_real_stmt_in_stmt_chain1115 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declaration_multi_in_chainable_stmt1170 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignment_expr_in_chainable_stmt1182 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_stmt_in_chainable_stmt1194 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSIGN_in_stmt_chain_op1216 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_GT_in_stmt_chain_op1218 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TYPE_in_new_type_definition1238 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_ID_in_new_type_definition1242 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_LBRACE_in_new_type_definition1244 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000200L});
	public static final BitSet FOLLOW_type_field_in_new_type_definition1246 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000200L});
	public static final BitSet FOLLOW_RBRACE_in_new_type_definition1249 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TYPE_in_new_type_definition1284 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_ID_in_new_type_definition1288 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_new_type_definition1290 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TYPE_in_new_type_definition1323 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_ID_in_new_type_definition1327 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_standalone_type_in_new_type_definition1331 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_new_type_definition1333 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TYPEDEF_in_new_type_definition1369 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_ID_in_new_type_definition1373 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_standalone_type_in_new_type_definition1377 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_new_type_definition1379 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IMPORT_in_import_statement1426 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000200L});
	public static final BitSet FOLLOW_import_path_in_import_statement1442 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_STRING_in_import_statement1468 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_import_statement1482 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_module_name_in_import_path1505 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_module_subscript_in_import_path1507 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_module_name1543 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_150_in_module_subscript1558 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_module_name_in_module_subscript1560 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRAGMA_in_pragma_stmt1584 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_ID_in_pragma_stmt1586 = new BitSet(new long[]{0x0200003000800000L,0xA060013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_expr_in_pragma_stmt1588 = new BitSet(new long[]{0x0200003000800000L,0xA060013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_SEMICOLON_in_pragma_stmt1591 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_prefix_in_type_field1638 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_var_name_in_type_field1642 = new BitSet(new long[]{0x0000000000000000L,0x0040000001000000L});
	public static final BitSet FOLLOW_array_marker_in_type_field1644 = new BitSet(new long[]{0x0000000000000000L,0x0040000001000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_type_field1647 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_annotation_in_function_definition1690 = new BitSet(new long[]{0x0000000000800080L,0x0000000002800200L});
	public static final BitSet FOLLOW_APP_in_function_definition1700 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800200L});
	public static final BitSet FOLLOW_formal_argument_list_in_function_definition1704 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_func_name_in_function_definition1708 = new BitSet(new long[]{0x0000000000000000L,0x0000000000C00000L});
	public static final BitSet FOLLOW_formal_argument_list_in_function_definition1712 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_LBRACE_in_function_definition1723 = new BitSet(new long[]{0x0200003000800000L,0xA020012001C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_app_body_in_function_definition1725 = new BitSet(new long[]{0x0000000000000000L,0x0044000000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_function_definition1727 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
	public static final BitSet FOLLOW_RBRACE_in_function_definition1730 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_parameters_in_function_definition1773 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800200L});
	public static final BitSet FOLLOW_formal_argument_list_in_function_definition1777 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_func_name_in_function_definition1781 = new BitSet(new long[]{0x0000000000000000L,0x2000000000C00000L});
	public static final BitSet FOLLOW_formal_argument_list_in_function_definition1785 = new BitSet(new long[]{0x0000000000000000L,0x2000000000400000L});
	public static final BitSet FOLLOW_block_in_function_definition1807 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tcl_body_in_function_definition1867 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_function_definition1869 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_func_name1927 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_command_in_app_body1938 = new BitSet(new long[]{0x0000000000800002L});
	public static final BitSet FOLLOW_app_redirection_in_app_body1940 = new BitSet(new long[]{0x0000000000800002L});
	public static final BitSet FOLLOW_command_args_in_command1978 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_command_arg_in_command_args2008 = new BitSet(new long[]{0x0200003000800000L,0xA020012001C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_command_args_more_in_command_args2010 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_command_args_in_command_args_more2030 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_variable_in_command_arg2052 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_literal_in_command_arg2062 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_array_constructor_in_command_arg2072 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_array_kv_constructor_in_command_arg2082 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_command_arg2092 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_expr_in_command_arg2094 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_command_arg2096 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ATSIGN_in_command_arg2110 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_var_name_in_command_arg2112 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ATSIGN_in_app_redirection2140 = new BitSet(new long[]{0x0000000000000000L,0x1C00000000000000L});
	public static final BitSet FOLLOW_redirect_type_in_app_redirection2142 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ASSIGN_in_app_redirection2144 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_expr_in_app_redirection2146 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tcl_package_in_tcl_body2206 = new BitSet(new long[]{0x0000000000000002L,0x2000000001000000L});
	public static final BitSet FOLLOW_tcl_fun_ref_in_tcl_body2208 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
	public static final BitSet FOLLOW_inline_tcl_in_tcl_body2211 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_tcl_package2232 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_STRING_in_tcl_package2236 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_tcl_fun_ref2272 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LT_in_type_parameters2321 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_var_name_list_in_type_parameters2323 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_GT_in_type_parameters2325 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_name_in_var_name_list2355 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_var_name_list_more_in_var_name_list2357 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMA_in_var_name_list_more2387 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_var_name_list_in_var_name_list_more2389 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LSQUARE_in_inline_tcl2409 = new BitSet(new long[]{0x0000000000000000L,0xA000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_STRING_in_inline_tcl2414 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L});
	public static final BitSet FOLLOW_STRING_MULTI_LINE_1_in_inline_tcl2416 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L});
	public static final BitSet FOLLOW_STRING_MULTI_LINE_2_in_inline_tcl2418 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L});
	public static final BitSet FOLLOW_RSQUARE_in_inline_tcl2421 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GLOBAL_in_global_const_definition2457 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_CONST_in_global_const_definition2459 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_declare_assign_single_in_global_const_definition2463 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_global_const_definition2465 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_formal_argument_list2526 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000200L});
	public static final BitSet FOLLOW_formal_arguments_in_formal_argument_list2528 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_formal_argument_list2531 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arg_decl_in_formal_arguments2574 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_formal_arguments_rest_in_formal_arguments2576 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_COMMA_in_formal_arguments_rest2597 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_arg_decl_in_formal_arguments_rest2599 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multi_type_prefix_in_arg_decl2638 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L,0x0000000000010000L});
	public static final BitSet FOLLOW_VARARGS_in_arg_decl2640 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_var_name_in_arg_decl2645 = new BitSet(new long[]{0x0000000000100002L,0x0000000001000000L});
	public static final BitSet FOLLOW_array_marker_in_arg_decl2647 = new BitSet(new long[]{0x0000000000100002L,0x0000000001000000L});
	public static final BitSet FOLLOW_arg_decl_val_in_arg_decl2650 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSIGN_in_arg_decl_val2740 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_expr_in_arg_decl_val2742 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_name_in_type_prefix2759 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_name_in_type_prefix2766 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_LT_in_type_prefix2768 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_standalone_type_in_type_prefix2770 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_GT_in_type_prefix2772 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_prefix_in_multi_type_prefix2804 = new BitSet(new long[]{0x0000000000000002L,0x0000200000000000L});
	public static final BitSet FOLLOW_another_type_in_multi_type_prefix2806 = new BitSet(new long[]{0x0000000000000002L,0x0000200000000000L});
	public static final BitSet FOLLOW_PIPE_in_another_type2852 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_type_prefix_in_another_type2854 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_prefix_in_standalone_type2874 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
	public static final BitSet FOLLOW_array_marker_in_standalone_type2876 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
	public static final BitSet FOLLOW_LBRACE_in_block2902 = new BitSet(new long[]{0x1800000000800080L,0x0045000002D02A08L,0x0000000000040C10L});
	public static final BitSet FOLLOW_stmt_in_block2904 = new BitSet(new long[]{0x1800000000800080L,0x0045000002D02A08L,0x0000000000040C10L});
	public static final BitSet FOLLOW_RBRACE_in_block2907 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_if_stmt2938 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_LPAREN_in_if_stmt2940 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_expr_in_if_stmt2944 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_if_stmt2946 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_block_in_if_stmt2950 = new BitSet(new long[]{0x0010000000000002L});
	public static final BitSet FOLLOW_else_block_in_if_stmt2952 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ELSE_in_else_block2998 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_block_in_else_block3002 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ELSE_in_else_block3017 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_if_stmt_in_else_block3019 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SWITCH_in_switch_stmt3049 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_LPAREN_in_switch_stmt3051 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_expr_in_switch_stmt3055 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_switch_stmt3057 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_LBRACE_in_switch_stmt3059 = new BitSet(new long[]{0x0000080020000000L,0x0004000000000000L});
	public static final BitSet FOLLOW_switch_case_in_switch_stmt3061 = new BitSet(new long[]{0x0000080020000000L,0x0004000000000000L});
	public static final BitSet FOLLOW_RBRACE_in_switch_stmt3064 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CASE_in_switch_case3106 = new BitSet(new long[]{0x0000002000000000L,0x0000010000000100L});
	public static final BitSet FOLLOW_integer_in_switch_case3108 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_COLON_in_switch_case3110 = new BitSet(new long[]{0x1800000000800082L,0x0041000002D02A08L,0x0000000000040C10L});
	public static final BitSet FOLLOW_stmt_in_switch_case3112 = new BitSet(new long[]{0x1800000000800082L,0x0041000002D02A08L,0x0000000000040C10L});
	public static final BitSet FOLLOW_DEFAULT_in_switch_case3150 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_COLON_in_switch_case3152 = new BitSet(new long[]{0x1800000000800082L,0x0041000002D02A08L,0x0000000000040C10L});
	public static final BitSet FOLLOW_stmt_in_switch_case3154 = new BitSet(new long[]{0x1800000000800082L,0x0041000002D02A08L,0x0000000000040C10L});
	public static final BitSet FOLLOW_annotation_in_foreach_loop3200 = new BitSet(new long[]{0x1000000000800000L});
	public static final BitSet FOLLOW_FOREACH_in_foreach_loop3203 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_var_name_in_foreach_loop3207 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_COMMA_in_foreach_loop3209 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_var_name_in_foreach_loop3213 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
	public static final BitSet FOLLOW_IN_in_foreach_loop3215 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_expr_in_foreach_loop3219 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_block_in_foreach_loop3223 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_annotation_in_foreach_loop3264 = new BitSet(new long[]{0x1000000000800000L});
	public static final BitSet FOLLOW_FOREACH_in_foreach_loop3267 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_var_name_in_foreach_loop3271 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
	public static final BitSet FOLLOW_IN_in_foreach_loop3273 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_expr_in_foreach_loop3277 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_block_in_foreach_loop3281 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_annotation_in_for_loop3329 = new BitSet(new long[]{0x0800000000800000L});
	public static final BitSet FOLLOW_FOR_in_for_loop3340 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_LPAREN_in_for_loop3342 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000200L});
	public static final BitSet FOLLOW_for_loop_init_in_for_loop3346 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_for_loop3348 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_expr_in_for_loop3352 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_for_loop3354 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000200L});
	public static final BitSet FOLLOW_for_loop_update_in_for_loop3374 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_for_loop3376 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_block_in_for_loop3380 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_for_loop_init_items_in_for_loop_init3435 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_for_loop_declaration_in_for_loop_init_items3479 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_for_loop_assignment_in_for_loop_init_items3481 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_for_loop_init_more_in_for_loop_init_items3485 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_COMMA_in_for_loop_init_more3507 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_for_loop_declaration_in_for_loop_init_more3509 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMA_in_for_loop_init_more3523 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_for_loop_assignment_in_for_loop_init_more3525 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_for_loop_update_items_in_for_loop_update3549 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_for_loop_assignment_in_for_loop_update_items3593 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_for_loop_update_more_in_for_loop_update_items3595 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_COMMA_in_for_loop_update_more3616 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_for_loop_assignment_in_for_loop_update_more3618 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declare_assign_single_in_for_loop_declaration3634 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_name_in_for_loop_assignment3649 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ASSIGN_in_for_loop_assignment3651 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_expr_in_for_loop_assignment3653 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ITERATE_in_iterate_loop3685 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_var_name_in_iterate_loop3689 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_block_in_iterate_loop3693 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000004000L});
	public static final BitSet FOLLOW_UNTIL_in_iterate_loop3695 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_LPAREN_in_iterate_loop3697 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_expr_in_iterate_loop3701 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_iterate_loop3703 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WAIT_in_wait_stmt3755 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_expr_argument_list_in_wait_stmt3759 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_block_in_wait_stmt3763 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WAIT_in_wait_stmt3798 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_DEEP_in_wait_stmt3800 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_expr_argument_list_in_wait_stmt3804 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_block_in_wait_stmt3808 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_prefix_in_declaration_multi3855 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_declare_rest_in_declaration_multi3857 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_declare_rest_more_in_declaration_multi3859 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_COMMA_in_declare_rest_more3908 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_declare_rest_in_declare_rest_more3910 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_prefix_in_declare_assign_single3938 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_var_name_in_declare_assign_single3942 = new BitSet(new long[]{0x0000000000100000L,0x0000000003000000L});
	public static final BitSet FOLLOW_array_marker_in_declare_assign_single3944 = new BitSet(new long[]{0x0000000000100000L,0x0000000003000000L});
	public static final BitSet FOLLOW_mapping_in_declare_assign_single3947 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ASSIGN_in_declare_assign_single3950 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_expr_in_declare_assign_single3952 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_name_in_declare_rest4074 = new BitSet(new long[]{0x0000000000100002L,0x0000000003000000L});
	public static final BitSet FOLLOW_array_marker_in_declare_rest4076 = new BitSet(new long[]{0x0000000000100002L,0x0000000003000000L});
	public static final BitSet FOLLOW_mapping_in_declare_rest4079 = new BitSet(new long[]{0x0000000000100002L});
	public static final BitSet FOLLOW_ASSIGN_in_declare_rest4152 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_expr_in_declare_rest4154 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LSQUARE_in_array_marker4211 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000200L});
	public static final BitSet FOLLOW_standalone_type_in_array_marker4213 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L});
	public static final BitSet FOLLOW_RSQUARE_in_array_marker4216 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LT_in_mapping4243 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_expr_in_mapping4247 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_GT_in_mapping4249 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_orexpr_in_expr4280 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_andexpr_in_orexpr4299 = new BitSet(new long[]{0x0000000000000002L,0x0000040000000000L});
	public static final BitSet FOLLOW_OR_in_orexpr4318 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_andexpr_in_orexpr4322 = new BitSet(new long[]{0x0000000000000002L,0x0000040000000000L});
	public static final BitSet FOLLOW_eqexpr_in_andexpr4380 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_AND_in_andexpr4399 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_eqexpr_in_andexpr4403 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_cmpexpr_in_eqexpr4461 = new BitSet(new long[]{0x0020000000000002L,0x0000000800000000L});
	public static final BitSet FOLLOW_eqexpr_op_in_eqexpr4480 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_cmpexpr_in_eqexpr4484 = new BitSet(new long[]{0x0020000000000002L,0x0000000800000000L});
	public static final BitSet FOLLOW_aexpr_in_cmpexpr4556 = new BitSet(new long[]{0x0000000000000002L,0x0000000006000060L});
	public static final BitSet FOLLOW_cmpexpr_op_in_cmpexpr4575 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_aexpr_in_cmpexpr4579 = new BitSet(new long[]{0x0000000000000002L,0x0000000006000060L});
	public static final BitSet FOLLOW_mexpr_in_aexpr4654 = new BitSet(new long[]{0x0000000000000002L,0x0000400010000000L});
	public static final BitSet FOLLOW_aexpr_op_in_aexpr4673 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_mexpr_in_aexpr4677 = new BitSet(new long[]{0x0000000000000002L,0x0000400010000000L});
	public static final BitSet FOLLOW_powexpr_in_mexpr4751 = new BitSet(new long[]{0x0008000000000002L,0x0000100060040000L});
	public static final BitSet FOLLOW_mexpr_op_in_mexpr4770 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_powexpr_in_mexpr4774 = new BitSet(new long[]{0x0008000000000002L,0x0000100060040000L});
	public static final BitSet FOLLOW_uexpr_in_powexpr4861 = new BitSet(new long[]{0x0000000000000002L,0x0000800000000000L});
	public static final BitSet FOLLOW_POW_in_powexpr4880 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_uexpr_in_powexpr4884 = new BitSet(new long[]{0x0000000000000002L,0x0000800000000000L});
	public static final BitSet FOLLOW_pfexpr_in_uexpr4942 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_uexpr_op_in_uexpr4952 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_uexpr_in_uexpr4954 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_uexpr_op4978 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_uexpr_op4986 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_base_expr_in_pfexpr5012 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_array_index_in_pfexpr5029 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_var_subscript_in_pfexpr5055 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_var_name5090 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_type_name5097 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LSQUARE_in_array_index5112 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_expr_in_array_index5114 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L});
	public static final BitSet FOLLOW_RSQUARE_in_array_index5116 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_150_in_var_subscript5140 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_ID_in_var_subscript5142 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_literal_in_base_expr5170 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_call_in_base_expr5184 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_variable_in_base_expr5198 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_paren_expr_in_base_expr5212 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_array_constructor_in_base_expr5226 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_array_kv_constructor_in_base_expr5240 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_integer_in_literal5262 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DECIMAL_in_literal5294 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SCI_DECIMAL_in_literal5298 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INFINITY_in_literal5302 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOTANUMBER_in_literal5306 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_literal5354 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_MULTI_LINE_1_in_literal5384 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_MULTI_LINE_2_in_literal5414 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_bool_lit_in_literal5444 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_name_in_variable5489 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_call_annotation_in_function_call5536 = new BitSet(new long[]{0x0000000000800000L,0x0000000000000200L});
	public static final BitSet FOLLOW_function_call_name_in_function_call5541 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_expr_kw_pos_argument_list_in_function_call5545 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_function_call_name5594 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ATSIGN_in_function_call_name5605 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_ID_in_function_call_name5607 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ATSIGN_in_call_annotation5631 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_ID_in_call_annotation5635 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ASSIGN_in_call_annotation5637 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_expr_in_call_annotation5641 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_expr_kw_pos_argument_list5675 = new BitSet(new long[]{0x0200003000800000L,0xA028013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_expr_kw_pos_arguments_in_expr_kw_pos_argument_list5677 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_expr_kw_pos_argument_list5680 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_expr_kw_pos_arguments5712 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_kw_argument_in_expr_kw_pos_arguments5714 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_expr_kw_pos_arguments_rest_in_expr_kw_pos_arguments5717 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_COMMA_in_expr_kw_pos_arguments_rest5739 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_expr_in_expr_kw_pos_arguments_rest5755 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_kw_argument_in_expr_kw_pos_arguments_rest5773 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_kw_argument5798 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ASSIGN_in_kw_argument5800 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_expr_in_kw_argument5802 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_expr_argument_list5834 = new BitSet(new long[]{0x0200003000800000L,0xA028013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_expr_arguments_in_expr_argument_list5836 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_expr_argument_list5839 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_expr_arguments5870 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_expr_arguments_rest_in_expr_arguments5872 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_COMMA_in_expr_arguments_rest5885 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_expr_in_expr_arguments_rest5887 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LSQUARE_in_array_constructor5913 = new BitSet(new long[]{0x0200003000800000L,0xA030013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_RSQUARE_in_array_constructor5927 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_array_constructor5962 = new BitSet(new long[]{0x0000000180000000L,0x0010000000000000L});
	public static final BitSet FOLLOW_COLON_in_array_constructor5982 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_expr_in_array_constructor5986 = new BitSet(new long[]{0x0000000080000000L,0x0010000000000000L});
	public static final BitSet FOLLOW_array_range_more_in_array_constructor5988 = new BitSet(new long[]{0x0000000080000000L,0x0010000000000000L});
	public static final BitSet FOLLOW_RSQUARE_in_array_constructor5991 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_array_elems_more_in_array_constructor6046 = new BitSet(new long[]{0x0000000100000000L,0x0010000000000000L});
	public static final BitSet FOLLOW_RSQUARE_in_array_constructor6049 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COLON_in_array_range_more6105 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_expr_in_array_range_more6107 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMA_in_array_elems_more6131 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_expr_in_array_elems_more6133 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LBRACE_in_array_kv_constructor6151 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
	public static final BitSet FOLLOW_RBRACE_in_array_kv_constructor6153 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LBRACE_in_array_kv_constructor6168 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_array_kv_elem_in_array_kv_constructor6172 = new BitSet(new long[]{0x0000000100000000L,0x0004000000000000L});
	public static final BitSet FOLLOW_array_kv_elems_more_in_array_kv_constructor6174 = new BitSet(new long[]{0x0000000100000000L,0x0004000000000000L});
	public static final BitSet FOLLOW_RBRACE_in_array_kv_constructor6177 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_array_kv_elem6208 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_COLON_in_array_kv_elem6210 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_expr_in_array_kv_elem6214 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMA_in_array_kv_elems_more6243 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_array_kv_elem_in_array_kv_elems_more6245 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignment_list_in_assignment_expr6269 = new BitSet(new long[]{0x0000000000100100L});
	public static final BitSet FOLLOW_assign_op_in_assignment_expr6271 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_expr_in_assignment_expr6275 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_more_expr_in_assignment_expr6277 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_COMMA_in_more_expr6352 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_expr_in_more_expr6354 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_paren_expr6375 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_expr_in_paren_expr6379 = new BitSet(new long[]{0x0000000100000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_more_expr_in_paren_expr6404 = new BitSet(new long[]{0x0000000100000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_paren_expr6427 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_assignment_list6442 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_assignment_list_arguments_in_assignment_list6446 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_assignment_list6448 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignment_list_arguments_in_assignment_list6488 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assign_target_in_assignment_list_arguments6541 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_assignment_list_arguments_rest_in_assignment_list_arguments6543 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_COMMA_in_assignment_list_arguments_rest6556 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_assign_target_in_assignment_list_arguments_rest6558 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_assign_target6582 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_assign_path_element_in_assign_target6584 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_var_subscript_in_assign_path_element6636 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_array_index_in_assign_path_element6655 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_call_in_expr_stmt6688 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_variable_in_expr_stmt6709 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_update_stmt6734 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_LT_in_update_stmt6736 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_ID_in_update_stmt6740 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_GT_in_update_stmt6742 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_MUTATE_in_update_stmt6744 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_expr_in_update_stmt6746 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_update_stmt6748 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ATSIGN_in_annotation6798 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_ID_in_annotation6802 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ATSIGN_in_annotation6835 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_ID_in_annotation6839 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ASSIGN_in_annotation6841 = new BitSet(new long[]{0x0000002000000000L,0x0000010000000300L});
	public static final BitSet FOLLOW_annotation_val_in_annotation6843 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_annotation_val6880 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_integer_in_annotation_val6884 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_definition_in_synpred3_ExM883 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stmt_chain_in_synpred8_ExM943 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_foreach_loop_in_synpred12_ExM991 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_for_loop_in_synpred13_ExM1003 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_aexpr_op_in_synpred88_ExM4673 = new BitSet(new long[]{0x0200003000800000L,0xA020013011C10300L,0x0000000000000101L});
	public static final BitSet FOLLOW_mexpr_in_synpred88_ExM4677 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_array_index_in_synpred98_ExM5029 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_call_in_synpred101_ExM5184 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_variable_in_synpred102_ExM5198 = new BitSet(new long[]{0x0000000000000002L});
}
