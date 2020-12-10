// $ANTLR 3.5 src/exm/stc/ast/ExM.g 2020-12-10 16:47:39

package exm.stc.ast.antlr;
import exm.stc.ast.FilePosition;
import exm.stc.ast.FilePosition.LineMapping;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ExMLexer extends Lexer {
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

	    /** New token stream for C Preprocessor */
	    public static int CPP = 5;
	    public LineMapping lineMap = null;
	    public boolean quiet = false; // if true, don't report errors

	    public void displayRecognitionError(String[] tokenNames,
	                                    RecognitionException e) {
	      if (quiet) return;
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


	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public ExMLexer() {} 
	public ExMLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public ExMLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "src/exm/stc/ast/ExM.g"; }

	// $ANTLR start "AND"
	public final void mAND() throws RecognitionException {
		try {
			int _type = AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:32:5: ( '&&' )
			// src/exm/stc/ast/ExM.g:32:7: '&&'
			{
			match("&&"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AND"

	// $ANTLR start "APPEND"
	public final void mAPPEND() throws RecognitionException {
		try {
			int _type = APPEND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:33:8: ( '+=' )
			// src/exm/stc/ast/ExM.g:33:10: '+='
			{
			match("+="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "APPEND"

	// $ANTLR start "ASSIGN"
	public final void mASSIGN() throws RecognitionException {
		try {
			int _type = ASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:34:8: ( '=' )
			// src/exm/stc/ast/ExM.g:34:10: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASSIGN"

	// $ANTLR start "DIV"
	public final void mDIV() throws RecognitionException {
		try {
			int _type = DIV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:35:5: ( '/' )
			// src/exm/stc/ast/ExM.g:35:7: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIV"

	// $ANTLR start "EQUALS"
	public final void mEQUALS() throws RecognitionException {
		try {
			int _type = EQUALS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:36:8: ( '==' )
			// src/exm/stc/ast/ExM.g:36:10: '=='
			{
			match("=="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQUALS"

	// $ANTLR start "GT"
	public final void mGT() throws RecognitionException {
		try {
			int _type = GT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:37:4: ( '>' )
			// src/exm/stc/ast/ExM.g:37:6: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GT"

	// $ANTLR start "GTE"
	public final void mGTE() throws RecognitionException {
		try {
			int _type = GTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:38:5: ( '>=' )
			// src/exm/stc/ast/ExM.g:38:7: '>='
			{
			match(">="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GTE"

	// $ANTLR start "INTDIV"
	public final void mINTDIV() throws RecognitionException {
		try {
			int _type = INTDIV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:39:8: ( '%/' )
			// src/exm/stc/ast/ExM.g:39:10: '%/'
			{
			match("%/"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INTDIV"

	// $ANTLR start "LT"
	public final void mLT() throws RecognitionException {
		try {
			int _type = LT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:40:4: ( '<' )
			// src/exm/stc/ast/ExM.g:40:6: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LT"

	// $ANTLR start "LTE"
	public final void mLTE() throws RecognitionException {
		try {
			int _type = LTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:41:5: ( '<=' )
			// src/exm/stc/ast/ExM.g:41:7: '<='
			{
			match("<="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LTE"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:42:7: ( '-' )
			// src/exm/stc/ast/ExM.g:42:9: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINUS"

	// $ANTLR start "MOD"
	public final void mMOD() throws RecognitionException {
		try {
			int _type = MOD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:43:5: ( '%%' )
			// src/exm/stc/ast/ExM.g:43:7: '%%'
			{
			match("%%"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MOD"

	// $ANTLR start "MULT"
	public final void mMULT() throws RecognitionException {
		try {
			int _type = MULT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:44:6: ( '*' )
			// src/exm/stc/ast/ExM.g:44:8: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MULT"

	// $ANTLR start "MUTATE"
	public final void mMUTATE() throws RecognitionException {
		try {
			int _type = MUTATE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:45:8: ( ':=' )
			// src/exm/stc/ast/ExM.g:45:10: ':='
			{
			match(":="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MUTATE"

	// $ANTLR start "NEQUALS"
	public final void mNEQUALS() throws RecognitionException {
		try {
			int _type = NEQUALS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:46:9: ( '!=' )
			// src/exm/stc/ast/ExM.g:46:11: '!='
			{
			match("!="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEQUALS"

	// $ANTLR start "NOT"
	public final void mNOT() throws RecognitionException {
		try {
			int _type = NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:47:5: ( '!' )
			// src/exm/stc/ast/ExM.g:47:7: '!'
			{
			match('!'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOT"

	// $ANTLR start "OR"
	public final void mOR() throws RecognitionException {
		try {
			int _type = OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:48:4: ( '||' )
			// src/exm/stc/ast/ExM.g:48:6: '||'
			{
			match("||"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OR"

	// $ANTLR start "PERCENT"
	public final void mPERCENT() throws RecognitionException {
		try {
			int _type = PERCENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:49:9: ( '%' )
			// src/exm/stc/ast/ExM.g:49:11: '%'
			{
			match('%'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PERCENT"

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:50:6: ( '+' )
			// src/exm/stc/ast/ExM.g:50:8: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUS"

	// $ANTLR start "POW"
	public final void mPOW() throws RecognitionException {
		try {
			int _type = POW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:51:5: ( '**' )
			// src/exm/stc/ast/ExM.g:51:7: '**'
			{
			match("**"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "POW"

	// $ANTLR start "T__150"
	public final void mT__150() throws RecognitionException {
		try {
			int _type = T__150;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:52:8: ( '.' )
			// src/exm/stc/ast/ExM.g:52:10: '.'
			{
			match('.'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__150"

	// $ANTLR start "CPP_LINE"
	public final void mCPP_LINE() throws RecognitionException {
		try {
			int _type = CPP_LINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:795:9: ( HASH (~ ( '\\n' ) )* ( ( '\\n' ) ) )
			// src/exm/stc/ast/ExM.g:795:11: HASH (~ ( '\\n' ) )* ( ( '\\n' ) )
			{
			mHASH(); 

			// src/exm/stc/ast/ExM.g:795:16: (~ ( '\\n' ) )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '\u0000' && LA1_0 <= '\t')||(LA1_0 >= '\u000B' && LA1_0 <= '\uFFFF')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// src/exm/stc/ast/ExM.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop1;
				}
			}

			// src/exm/stc/ast/ExM.g:795:27: ( ( '\\n' ) )
			// src/exm/stc/ast/ExM.g:795:28: ( '\\n' )
			{
			// src/exm/stc/ast/ExM.g:795:28: ( '\\n' )
			// src/exm/stc/ast/ExM.g:795:29: '\\n'
			{
			match('\n'); 
			}

			}

			 _channel = CPP; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CPP_LINE"

	// $ANTLR start "SINGLE_LINE_COMMENT_C"
	public final void mSINGLE_LINE_COMMENT_C() throws RecognitionException {
		try {
			int _type = SINGLE_LINE_COMMENT_C;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:801:5: ( '//' (~ ( '\\n' ) )* ( ( '\\n' ) ) )
			// src/exm/stc/ast/ExM.g:801:10: '//' (~ ( '\\n' ) )* ( ( '\\n' ) )
			{
			match("//"); 

			// src/exm/stc/ast/ExM.g:801:15: (~ ( '\\n' ) )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '\uFFFF')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// src/exm/stc/ast/ExM.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop2;
				}
			}

			// src/exm/stc/ast/ExM.g:801:26: ( ( '\\n' ) )
			// src/exm/stc/ast/ExM.g:801:27: ( '\\n' )
			{
			// src/exm/stc/ast/ExM.g:801:27: ( '\\n' )
			// src/exm/stc/ast/ExM.g:801:28: '\\n'
			{
			match('\n'); 
			}

			}

			 _channel = HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SINGLE_LINE_COMMENT_C"

	// $ANTLR start "MULTI_LINE_COMMENT"
	public final void mMULTI_LINE_COMMENT() throws RecognitionException {
		try {
			int _type = MULTI_LINE_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:807:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
			// src/exm/stc/ast/ExM.g:807:9: '/*' ( options {greedy=false; } : . )* '*/'
			{
			match("/*"); 

			// src/exm/stc/ast/ExM.g:807:14: ( options {greedy=false; } : . )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0=='*') ) {
					int LA3_1 = input.LA(2);
					if ( (LA3_1=='/') ) {
						alt3=2;
					}
					else if ( ((LA3_1 >= '\u0000' && LA3_1 <= '.')||(LA3_1 >= '0' && LA3_1 <= '\uFFFF')) ) {
						alt3=1;
					}

				}
				else if ( ((LA3_0 >= '\u0000' && LA3_0 <= ')')||(LA3_0 >= '+' && LA3_0 <= '\uFFFF')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// src/exm/stc/ast/ExM.g:807:42: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop3;
				}
			}

			match("*/"); 

			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MULTI_LINE_COMMENT"

	// $ANTLR start "APP"
	public final void mAPP() throws RecognitionException {
		try {
			int _type = APP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:816:4: ( 'app' )
			// src/exm/stc/ast/ExM.g:816:7: 'app'
			{
			match("app"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "APP"

	// $ANTLR start "BUILTIN"
	public final void mBUILTIN() throws RecognitionException {
		try {
			int _type = BUILTIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:817:8: ( 'builtin' )
			// src/exm/stc/ast/ExM.g:817:11: 'builtin'
			{
			match("builtin"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BUILTIN"

	// $ANTLR start "IF"
	public final void mIF() throws RecognitionException {
		try {
			int _type = IF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:818:3: ( 'if' )
			// src/exm/stc/ast/ExM.g:818:7: 'if'
			{
			match("if"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IF"

	// $ANTLR start "ELSE"
	public final void mELSE() throws RecognitionException {
		try {
			int _type = ELSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:819:5: ( 'else' )
			// src/exm/stc/ast/ExM.g:819:7: 'else'
			{
			match("else"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ELSE"

	// $ANTLR start "SWITCH"
	public final void mSWITCH() throws RecognitionException {
		try {
			int _type = SWITCH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:820:7: ( 'switch' )
			// src/exm/stc/ast/ExM.g:820:9: 'switch'
			{
			match("switch"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SWITCH"

	// $ANTLR start "CASE"
	public final void mCASE() throws RecognitionException {
		try {
			int _type = CASE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:821:5: ( 'case' )
			// src/exm/stc/ast/ExM.g:821:7: 'case'
			{
			match("case"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CASE"

	// $ANTLR start "DEFAULT"
	public final void mDEFAULT() throws RecognitionException {
		try {
			int _type = DEFAULT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:822:8: ( 'default' )
			// src/exm/stc/ast/ExM.g:822:10: 'default'
			{
			match("default"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DEFAULT"

	// $ANTLR start "FOREACH"
	public final void mFOREACH() throws RecognitionException {
		try {
			int _type = FOREACH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:823:8: ( 'foreach' )
			// src/exm/stc/ast/ExM.g:823:10: 'foreach'
			{
			match("foreach"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FOREACH"

	// $ANTLR start "IN"
	public final void mIN() throws RecognitionException {
		try {
			int _type = IN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:824:3: ( 'in' )
			// src/exm/stc/ast/ExM.g:824:5: 'in'
			{
			match("in"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IN"

	// $ANTLR start "FOR"
	public final void mFOR() throws RecognitionException {
		try {
			int _type = FOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:825:4: ( 'for' )
			// src/exm/stc/ast/ExM.g:825:6: 'for'
			{
			match("for"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FOR"

	// $ANTLR start "ITERATE"
	public final void mITERATE() throws RecognitionException {
		try {
			int _type = ITERATE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:826:8: ( 'iterate' )
			// src/exm/stc/ast/ExM.g:826:10: 'iterate'
			{
			match("iterate"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ITERATE"

	// $ANTLR start "UNTIL"
	public final void mUNTIL() throws RecognitionException {
		try {
			int _type = UNTIL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:827:6: ( 'until' )
			// src/exm/stc/ast/ExM.g:827:8: 'until'
			{
			match("until"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UNTIL"

	// $ANTLR start "WAIT"
	public final void mWAIT() throws RecognitionException {
		try {
			int _type = WAIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:828:5: ( 'wait' )
			// src/exm/stc/ast/ExM.g:828:7: 'wait'
			{
			match("wait"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WAIT"

	// $ANTLR start "DEEP"
	public final void mDEEP() throws RecognitionException {
		try {
			int _type = DEEP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:829:5: ( 'deep' )
			// src/exm/stc/ast/ExM.g:829:7: 'deep'
			{
			match("deep"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DEEP"

	// $ANTLR start "TRUE"
	public final void mTRUE() throws RecognitionException {
		try {
			int _type = TRUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:830:5: ( 'true' )
			// src/exm/stc/ast/ExM.g:830:7: 'true'
			{
			match("true"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TRUE"

	// $ANTLR start "FALSE"
	public final void mFALSE() throws RecognitionException {
		try {
			int _type = FALSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:831:6: ( 'false' )
			// src/exm/stc/ast/ExM.g:831:8: 'false'
			{
			match("false"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FALSE"

	// $ANTLR start "GLOBAL"
	public final void mGLOBAL() throws RecognitionException {
		try {
			int _type = GLOBAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:832:7: ( 'global' )
			// src/exm/stc/ast/ExM.g:832:9: 'global'
			{
			match("global"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GLOBAL"

	// $ANTLR start "CONST"
	public final void mCONST() throws RecognitionException {
		try {
			int _type = CONST;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:833:6: ( 'const' )
			// src/exm/stc/ast/ExM.g:833:8: 'const'
			{
			match("const"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CONST"

	// $ANTLR start "TYPE"
	public final void mTYPE() throws RecognitionException {
		try {
			int _type = TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:834:5: ( 'type' )
			// src/exm/stc/ast/ExM.g:834:8: 'type'
			{
			match("type"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TYPE"

	// $ANTLR start "TYPEDEF"
	public final void mTYPEDEF() throws RecognitionException {
		try {
			int _type = TYPEDEF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:835:8: ( 'typedef' )
			// src/exm/stc/ast/ExM.g:835:11: 'typedef'
			{
			match("typedef"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TYPEDEF"

	// $ANTLR start "IMPORT"
	public final void mIMPORT() throws RecognitionException {
		try {
			int _type = IMPORT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:836:7: ( 'import' )
			// src/exm/stc/ast/ExM.g:836:9: 'import'
			{
			match("import"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IMPORT"

	// $ANTLR start "PRAGMA"
	public final void mPRAGMA() throws RecognitionException {
		try {
			int _type = PRAGMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:837:7: ( 'pragma' )
			// src/exm/stc/ast/ExM.g:837:9: 'pragma'
			{
			match("pragma"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PRAGMA"

	// $ANTLR start "STDIN"
	public final void mSTDIN() throws RecognitionException {
		try {
			int _type = STDIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:839:6: ( 'stdin' )
			// src/exm/stc/ast/ExM.g:839:8: 'stdin'
			{
			match("stdin"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STDIN"

	// $ANTLR start "STDOUT"
	public final void mSTDOUT() throws RecognitionException {
		try {
			int _type = STDOUT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:840:7: ( 'stdout' )
			// src/exm/stc/ast/ExM.g:840:9: 'stdout'
			{
			match("stdout"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STDOUT"

	// $ANTLR start "STDERR"
	public final void mSTDERR() throws RecognitionException {
		try {
			int _type = STDERR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:841:7: ( 'stderr' )
			// src/exm/stc/ast/ExM.g:841:9: 'stderr'
			{
			match("stderr"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STDERR"

	// $ANTLR start "NUM_FRAG"
	public final void mNUM_FRAG() throws RecognitionException {
		try {
			// src/exm/stc/ast/ExM.g:847:9: ( ( DIGIT )+ )
			// src/exm/stc/ast/ExM.g:847:11: ( DIGIT )+
			{
			// src/exm/stc/ast/ExM.g:847:11: ( DIGIT )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// src/exm/stc/ast/ExM.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NUM_FRAG"

	// $ANTLR start "DEC_FRAG"
	public final void mDEC_FRAG() throws RecognitionException {
		try {
			// src/exm/stc/ast/ExM.g:850:9: ( NUM_FRAG '.' NUM_FRAG )
			// src/exm/stc/ast/ExM.g:850:11: NUM_FRAG '.' NUM_FRAG
			{
			mNUM_FRAG(); 

			match('.'); 
			mNUM_FRAG(); 

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DEC_FRAG"

	// $ANTLR start "DECIMAL_INT"
	public final void mDECIMAL_INT() throws RecognitionException {
		try {
			int _type = DECIMAL_INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:852:12: ( NUM_FRAG )
			// src/exm/stc/ast/ExM.g:852:14: NUM_FRAG
			{
			mNUM_FRAG(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DECIMAL_INT"

	// $ANTLR start "OCTAL_INT"
	public final void mOCTAL_INT() throws RecognitionException {
		try {
			int _type = OCTAL_INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:853:10: ( '0o' NUM_FRAG )
			// src/exm/stc/ast/ExM.g:853:12: '0o' NUM_FRAG
			{
			match("0o"); 

			mNUM_FRAG(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OCTAL_INT"

	// $ANTLR start "HEX_INT"
	public final void mHEX_INT() throws RecognitionException {
		try {
			int _type = HEX_INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:854:8: ( '0x' ( DIGIT | ALPHA )+ )
			// src/exm/stc/ast/ExM.g:854:10: '0x' ( DIGIT | ALPHA )+
			{
			match("0x"); 

			// src/exm/stc/ast/ExM.g:854:15: ( DIGIT | ALPHA )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= '0' && LA5_0 <= '9')||(LA5_0 >= 'A' && LA5_0 <= 'Z')||(LA5_0 >= 'a' && LA5_0 <= 'z')) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// src/exm/stc/ast/ExM.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt5 >= 1 ) break loop5;
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HEX_INT"

	// $ANTLR start "DECIMAL"
	public final void mDECIMAL() throws RecognitionException {
		try {
			int _type = DECIMAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:855:8: ( DEC_FRAG )
			// src/exm/stc/ast/ExM.g:855:10: DEC_FRAG
			{
			mDEC_FRAG(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DECIMAL"

	// $ANTLR start "SCI_DECIMAL"
	public final void mSCI_DECIMAL() throws RecognitionException {
		try {
			int _type = SCI_DECIMAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:856:12: ( NUM_FRAG ( '.' NUM_FRAG )? ( 'e' | 'E' ) ( '-' )? NUM_FRAG )
			// src/exm/stc/ast/ExM.g:856:14: NUM_FRAG ( '.' NUM_FRAG )? ( 'e' | 'E' ) ( '-' )? NUM_FRAG
			{
			mNUM_FRAG(); 

			// src/exm/stc/ast/ExM.g:856:23: ( '.' NUM_FRAG )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0=='.') ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// src/exm/stc/ast/ExM.g:856:24: '.' NUM_FRAG
					{
					match('.'); 
					mNUM_FRAG(); 

					}
					break;

			}

			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// src/exm/stc/ast/ExM.g:856:49: ( '-' )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0=='-') ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// src/exm/stc/ast/ExM.g:856:49: '-'
					{
					match('-'); 
					}
					break;

			}

			mNUM_FRAG(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SCI_DECIMAL"

	// $ANTLR start "NOTANUMBER"
	public final void mNOTANUMBER() throws RecognitionException {
		try {
			int _type = NOTANUMBER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:857:11: ( 'NaN' )
			// src/exm/stc/ast/ExM.g:857:13: 'NaN'
			{
			match("NaN"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOTANUMBER"

	// $ANTLR start "INFINITY"
	public final void mINFINITY() throws RecognitionException {
		try {
			int _type = INFINITY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:858:9: ( 'inf' )
			// src/exm/stc/ast/ExM.g:858:11: 'inf'
			{
			match("inf"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INFINITY"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:860:3: ( ( ALPHA | UNDER ) ( ALPHA | UNDER | DIGIT )* )
			// src/exm/stc/ast/ExM.g:860:5: ( ALPHA | UNDER ) ( ALPHA | UNDER | DIGIT )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// src/exm/stc/ast/ExM.g:860:18: ( ALPHA | UNDER | DIGIT )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= '0' && LA8_0 <= '9')||(LA8_0 >= 'A' && LA8_0 <= 'Z')||LA8_0=='_'||(LA8_0 >= 'a' && LA8_0 <= 'z')) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// src/exm/stc/ast/ExM.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop8;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "LPAREN"
	public final void mLPAREN() throws RecognitionException {
		try {
			int _type = LPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:862:7: ( '(' )
			// src/exm/stc/ast/ExM.g:862:12: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LPAREN"

	// $ANTLR start "RPAREN"
	public final void mRPAREN() throws RecognitionException {
		try {
			int _type = RPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:863:7: ( ')' )
			// src/exm/stc/ast/ExM.g:863:12: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RPAREN"

	// $ANTLR start "LBRACE"
	public final void mLBRACE() throws RecognitionException {
		try {
			int _type = LBRACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:864:7: ( '{' )
			// src/exm/stc/ast/ExM.g:864:12: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LBRACE"

	// $ANTLR start "RBRACE"
	public final void mRBRACE() throws RecognitionException {
		try {
			int _type = RBRACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:865:7: ( '}' )
			// src/exm/stc/ast/ExM.g:865:12: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RBRACE"

	// $ANTLR start "LSQUARE"
	public final void mLSQUARE() throws RecognitionException {
		try {
			int _type = LSQUARE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:866:8: ( '[' )
			// src/exm/stc/ast/ExM.g:866:12: '['
			{
			match('['); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LSQUARE"

	// $ANTLR start "RSQUARE"
	public final void mRSQUARE() throws RecognitionException {
		try {
			int _type = RSQUARE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:867:8: ( ']' )
			// src/exm/stc/ast/ExM.g:867:12: ']'
			{
			match(']'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RSQUARE"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:869:6: ( ',' )
			// src/exm/stc/ast/ExM.g:869:12: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMA"

	// $ANTLR start "HASH"
	public final void mHASH() throws RecognitionException {
		try {
			int _type = HASH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:870:5: ( '#' )
			// src/exm/stc/ast/ExM.g:870:12: '#'
			{
			match('#'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HASH"

	// $ANTLR start "SEMICOLON"
	public final void mSEMICOLON() throws RecognitionException {
		try {
			int _type = SEMICOLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:871:10: ( ';' )
			// src/exm/stc/ast/ExM.g:871:12: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMICOLON"

	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		try {
			int _type = COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:872:6: ( ':' )
			// src/exm/stc/ast/ExM.g:872:8: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COLON"

	// $ANTLR start "ATSIGN"
	public final void mATSIGN() throws RecognitionException {
		try {
			int _type = ATSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:873:7: ( '@' )
			// src/exm/stc/ast/ExM.g:873:9: '@'
			{
			match('@'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ATSIGN"

	// $ANTLR start "VARARGS"
	public final void mVARARGS() throws RecognitionException {
		try {
			int _type = VARARGS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:874:8: ( '...' )
			// src/exm/stc/ast/ExM.g:874:10: '...'
			{
			match("..."); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VARARGS"

	// $ANTLR start "PIPE"
	public final void mPIPE() throws RecognitionException {
		try {
			int _type = PIPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:875:5: ( '|' )
			// src/exm/stc/ast/ExM.g:875:7: '|'
			{
			match('|'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PIPE"

	// $ANTLR start "WHITESPACE"
	public final void mWHITESPACE() throws RecognitionException {
		try {
			int _type = WHITESPACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:877:12: ( ( '\\t' | ' ' | '\\n' | '\\r' | '\\u000C' )+ )
			// src/exm/stc/ast/ExM.g:878:9: ( '\\t' | ' ' | '\\n' | '\\r' | '\\u000C' )+
			{
			// src/exm/stc/ast/ExM.g:878:9: ( '\\t' | ' ' | '\\n' | '\\r' | '\\u000C' )+
			int cnt9=0;
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= '\t' && LA9_0 <= '\n')||(LA9_0 >= '\f' && LA9_0 <= '\r')||LA9_0==' ') ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// src/exm/stc/ast/ExM.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt9 >= 1 ) break loop9;
					EarlyExitException eee = new EarlyExitException(9, input);
					throw eee;
				}
				cnt9++;
			}

			 _channel = HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHITESPACE"

	// $ANTLR start "DIGIT"
	public final void mDIGIT() throws RecognitionException {
		try {
			// src/exm/stc/ast/ExM.g:882:17: ( '0' .. '9' )
			// src/exm/stc/ast/ExM.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIGIT"

	// $ANTLR start "ALPHA"
	public final void mALPHA() throws RecognitionException {
		try {
			// src/exm/stc/ast/ExM.g:883:17: ( 'a' .. 'z' | 'A' .. 'Z' )
			// src/exm/stc/ast/ExM.g:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ALPHA"

	// $ANTLR start "UNDER"
	public final void mUNDER() throws RecognitionException {
		try {
			// src/exm/stc/ast/ExM.g:884:17: ( '_' )
			// src/exm/stc/ast/ExM.g:884:19: '_'
			{
			match('_'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UNDER"

	// $ANTLR start "CHAR"
	public final void mCHAR() throws RecognitionException {
		try {
			// src/exm/stc/ast/ExM.g:889:6: ( ESCAPE_CODE |~ ( '\\\\' | '\"' ) )
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0=='\\') ) {
				alt10=1;
			}
			else if ( ((LA10_0 >= '\u0000' && LA10_0 <= '!')||(LA10_0 >= '#' && LA10_0 <= '[')||(LA10_0 >= ']' && LA10_0 <= '\uFFFF')) ) {
				alt10=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// src/exm/stc/ast/ExM.g:889:8: ESCAPE_CODE
					{
					mESCAPE_CODE(); 

					}
					break;
				case 2 :
					// src/exm/stc/ast/ExM.g:889:22: ~ ( '\\\\' | '\"' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CHAR"

	// $ANTLR start "ESCAPE_CODE"
	public final void mESCAPE_CODE() throws RecognitionException {
		try {
			// src/exm/stc/ast/ExM.g:892:12: ( '\\\\' . )
			// src/exm/stc/ast/ExM.g:893:9: '\\\\' .
			{
			match('\\'); 
			matchAny(); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ESCAPE_CODE"

	// $ANTLR start "STRING"
	public final void mSTRING() throws RecognitionException {
		try {
			int _type = STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:896:7: ( '\"' ( CHAR )* '\"' )
			// src/exm/stc/ast/ExM.g:896:9: '\"' ( CHAR )* '\"'
			{
			match('\"'); 
			// src/exm/stc/ast/ExM.g:896:13: ( CHAR )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( ((LA11_0 >= '\u0000' && LA11_0 <= '!')||(LA11_0 >= '#' && LA11_0 <= '\uFFFF')) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// src/exm/stc/ast/ExM.g:896:13: CHAR
					{
					mCHAR(); 

					}
					break;

				default :
					break loop11;
				}
			}

			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING"

	// $ANTLR start "STRING_MULTI_LINE_1"
	public final void mSTRING_MULTI_LINE_1() throws RecognitionException {
		try {
			int _type = STRING_MULTI_LINE_1;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:900:5: ( '----\\n' ( options {greedy=false; } : . )* '----' )
			// src/exm/stc/ast/ExM.g:900:9: '----\\n' ( options {greedy=false; } : . )* '----'
			{
			match("----\n"); 

			// src/exm/stc/ast/ExM.g:900:18: ( options {greedy=false; } : . )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0=='-') ) {
					int LA12_1 = input.LA(2);
					if ( (LA12_1=='-') ) {
						int LA12_3 = input.LA(3);
						if ( (LA12_3=='-') ) {
							int LA12_4 = input.LA(4);
							if ( (LA12_4=='-') ) {
								alt12=2;
							}
							else if ( ((LA12_4 >= '\u0000' && LA12_4 <= ',')||(LA12_4 >= '.' && LA12_4 <= '\uFFFF')) ) {
								alt12=1;
							}

						}
						else if ( ((LA12_3 >= '\u0000' && LA12_3 <= ',')||(LA12_3 >= '.' && LA12_3 <= '\uFFFF')) ) {
							alt12=1;
						}

					}
					else if ( ((LA12_1 >= '\u0000' && LA12_1 <= ',')||(LA12_1 >= '.' && LA12_1 <= '\uFFFF')) ) {
						alt12=1;
					}

				}
				else if ( ((LA12_0 >= '\u0000' && LA12_0 <= ',')||(LA12_0 >= '.' && LA12_0 <= '\uFFFF')) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// src/exm/stc/ast/ExM.g:900:46: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop12;
				}
			}

			match("----"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING_MULTI_LINE_1"

	// $ANTLR start "STRING_MULTI_LINE_2"
	public final void mSTRING_MULTI_LINE_2() throws RecognitionException {
		try {
			int _type = STRING_MULTI_LINE_2;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/exm/stc/ast/ExM.g:905:5: ( '\"\"\"\\n' ( options {greedy=false; } : . )* '\"\"\"' )
			// src/exm/stc/ast/ExM.g:905:9: '\"\"\"\\n' ( options {greedy=false; } : . )* '\"\"\"'
			{
			match("\"\"\"\n"); 

			// src/exm/stc/ast/ExM.g:905:17: ( options {greedy=false; } : . )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0=='\"') ) {
					int LA13_1 = input.LA(2);
					if ( (LA13_1=='\"') ) {
						int LA13_3 = input.LA(3);
						if ( (LA13_3=='\"') ) {
							alt13=2;
						}
						else if ( ((LA13_3 >= '\u0000' && LA13_3 <= '!')||(LA13_3 >= '#' && LA13_3 <= '\uFFFF')) ) {
							alt13=1;
						}

					}
					else if ( ((LA13_1 >= '\u0000' && LA13_1 <= '!')||(LA13_1 >= '#' && LA13_1 <= '\uFFFF')) ) {
						alt13=1;
					}

				}
				else if ( ((LA13_0 >= '\u0000' && LA13_0 <= '!')||(LA13_0 >= '#' && LA13_0 <= '\uFFFF')) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// src/exm/stc/ast/ExM.g:905:45: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop13;
				}
			}

			match("\"\"\""); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING_MULTI_LINE_2"

	@Override
	public void mTokens() throws RecognitionException {
		// src/exm/stc/ast/ExM.g:1:8: ( AND | APPEND | ASSIGN | DIV | EQUALS | GT | GTE | INTDIV | LT | LTE | MINUS | MOD | MULT | MUTATE | NEQUALS | NOT | OR | PERCENT | PLUS | POW | T__150 | CPP_LINE | SINGLE_LINE_COMMENT_C | MULTI_LINE_COMMENT | APP | BUILTIN | IF | ELSE | SWITCH | CASE | DEFAULT | FOREACH | IN | FOR | ITERATE | UNTIL | WAIT | DEEP | TRUE | FALSE | GLOBAL | CONST | TYPE | TYPEDEF | IMPORT | PRAGMA | STDIN | STDOUT | STDERR | DECIMAL_INT | OCTAL_INT | HEX_INT | DECIMAL | SCI_DECIMAL | NOTANUMBER | INFINITY | ID | LPAREN | RPAREN | LBRACE | RBRACE | LSQUARE | RSQUARE | COMMA | HASH | SEMICOLON | COLON | ATSIGN | VARARGS | PIPE | WHITESPACE | STRING | STRING_MULTI_LINE_1 | STRING_MULTI_LINE_2 )
		int alt14=74;
		alt14 = dfa14.predict(input);
		switch (alt14) {
			case 1 :
				// src/exm/stc/ast/ExM.g:1:10: AND
				{
				mAND(); 

				}
				break;
			case 2 :
				// src/exm/stc/ast/ExM.g:1:14: APPEND
				{
				mAPPEND(); 

				}
				break;
			case 3 :
				// src/exm/stc/ast/ExM.g:1:21: ASSIGN
				{
				mASSIGN(); 

				}
				break;
			case 4 :
				// src/exm/stc/ast/ExM.g:1:28: DIV
				{
				mDIV(); 

				}
				break;
			case 5 :
				// src/exm/stc/ast/ExM.g:1:32: EQUALS
				{
				mEQUALS(); 

				}
				break;
			case 6 :
				// src/exm/stc/ast/ExM.g:1:39: GT
				{
				mGT(); 

				}
				break;
			case 7 :
				// src/exm/stc/ast/ExM.g:1:42: GTE
				{
				mGTE(); 

				}
				break;
			case 8 :
				// src/exm/stc/ast/ExM.g:1:46: INTDIV
				{
				mINTDIV(); 

				}
				break;
			case 9 :
				// src/exm/stc/ast/ExM.g:1:53: LT
				{
				mLT(); 

				}
				break;
			case 10 :
				// src/exm/stc/ast/ExM.g:1:56: LTE
				{
				mLTE(); 

				}
				break;
			case 11 :
				// src/exm/stc/ast/ExM.g:1:60: MINUS
				{
				mMINUS(); 

				}
				break;
			case 12 :
				// src/exm/stc/ast/ExM.g:1:66: MOD
				{
				mMOD(); 

				}
				break;
			case 13 :
				// src/exm/stc/ast/ExM.g:1:70: MULT
				{
				mMULT(); 

				}
				break;
			case 14 :
				// src/exm/stc/ast/ExM.g:1:75: MUTATE
				{
				mMUTATE(); 

				}
				break;
			case 15 :
				// src/exm/stc/ast/ExM.g:1:82: NEQUALS
				{
				mNEQUALS(); 

				}
				break;
			case 16 :
				// src/exm/stc/ast/ExM.g:1:90: NOT
				{
				mNOT(); 

				}
				break;
			case 17 :
				// src/exm/stc/ast/ExM.g:1:94: OR
				{
				mOR(); 

				}
				break;
			case 18 :
				// src/exm/stc/ast/ExM.g:1:97: PERCENT
				{
				mPERCENT(); 

				}
				break;
			case 19 :
				// src/exm/stc/ast/ExM.g:1:105: PLUS
				{
				mPLUS(); 

				}
				break;
			case 20 :
				// src/exm/stc/ast/ExM.g:1:110: POW
				{
				mPOW(); 

				}
				break;
			case 21 :
				// src/exm/stc/ast/ExM.g:1:114: T__150
				{
				mT__150(); 

				}
				break;
			case 22 :
				// src/exm/stc/ast/ExM.g:1:121: CPP_LINE
				{
				mCPP_LINE(); 

				}
				break;
			case 23 :
				// src/exm/stc/ast/ExM.g:1:130: SINGLE_LINE_COMMENT_C
				{
				mSINGLE_LINE_COMMENT_C(); 

				}
				break;
			case 24 :
				// src/exm/stc/ast/ExM.g:1:152: MULTI_LINE_COMMENT
				{
				mMULTI_LINE_COMMENT(); 

				}
				break;
			case 25 :
				// src/exm/stc/ast/ExM.g:1:171: APP
				{
				mAPP(); 

				}
				break;
			case 26 :
				// src/exm/stc/ast/ExM.g:1:175: BUILTIN
				{
				mBUILTIN(); 

				}
				break;
			case 27 :
				// src/exm/stc/ast/ExM.g:1:183: IF
				{
				mIF(); 

				}
				break;
			case 28 :
				// src/exm/stc/ast/ExM.g:1:186: ELSE
				{
				mELSE(); 

				}
				break;
			case 29 :
				// src/exm/stc/ast/ExM.g:1:191: SWITCH
				{
				mSWITCH(); 

				}
				break;
			case 30 :
				// src/exm/stc/ast/ExM.g:1:198: CASE
				{
				mCASE(); 

				}
				break;
			case 31 :
				// src/exm/stc/ast/ExM.g:1:203: DEFAULT
				{
				mDEFAULT(); 

				}
				break;
			case 32 :
				// src/exm/stc/ast/ExM.g:1:211: FOREACH
				{
				mFOREACH(); 

				}
				break;
			case 33 :
				// src/exm/stc/ast/ExM.g:1:219: IN
				{
				mIN(); 

				}
				break;
			case 34 :
				// src/exm/stc/ast/ExM.g:1:222: FOR
				{
				mFOR(); 

				}
				break;
			case 35 :
				// src/exm/stc/ast/ExM.g:1:226: ITERATE
				{
				mITERATE(); 

				}
				break;
			case 36 :
				// src/exm/stc/ast/ExM.g:1:234: UNTIL
				{
				mUNTIL(); 

				}
				break;
			case 37 :
				// src/exm/stc/ast/ExM.g:1:240: WAIT
				{
				mWAIT(); 

				}
				break;
			case 38 :
				// src/exm/stc/ast/ExM.g:1:245: DEEP
				{
				mDEEP(); 

				}
				break;
			case 39 :
				// src/exm/stc/ast/ExM.g:1:250: TRUE
				{
				mTRUE(); 

				}
				break;
			case 40 :
				// src/exm/stc/ast/ExM.g:1:255: FALSE
				{
				mFALSE(); 

				}
				break;
			case 41 :
				// src/exm/stc/ast/ExM.g:1:261: GLOBAL
				{
				mGLOBAL(); 

				}
				break;
			case 42 :
				// src/exm/stc/ast/ExM.g:1:268: CONST
				{
				mCONST(); 

				}
				break;
			case 43 :
				// src/exm/stc/ast/ExM.g:1:274: TYPE
				{
				mTYPE(); 

				}
				break;
			case 44 :
				// src/exm/stc/ast/ExM.g:1:279: TYPEDEF
				{
				mTYPEDEF(); 

				}
				break;
			case 45 :
				// src/exm/stc/ast/ExM.g:1:287: IMPORT
				{
				mIMPORT(); 

				}
				break;
			case 46 :
				// src/exm/stc/ast/ExM.g:1:294: PRAGMA
				{
				mPRAGMA(); 

				}
				break;
			case 47 :
				// src/exm/stc/ast/ExM.g:1:301: STDIN
				{
				mSTDIN(); 

				}
				break;
			case 48 :
				// src/exm/stc/ast/ExM.g:1:307: STDOUT
				{
				mSTDOUT(); 

				}
				break;
			case 49 :
				// src/exm/stc/ast/ExM.g:1:314: STDERR
				{
				mSTDERR(); 

				}
				break;
			case 50 :
				// src/exm/stc/ast/ExM.g:1:321: DECIMAL_INT
				{
				mDECIMAL_INT(); 

				}
				break;
			case 51 :
				// src/exm/stc/ast/ExM.g:1:333: OCTAL_INT
				{
				mOCTAL_INT(); 

				}
				break;
			case 52 :
				// src/exm/stc/ast/ExM.g:1:343: HEX_INT
				{
				mHEX_INT(); 

				}
				break;
			case 53 :
				// src/exm/stc/ast/ExM.g:1:351: DECIMAL
				{
				mDECIMAL(); 

				}
				break;
			case 54 :
				// src/exm/stc/ast/ExM.g:1:359: SCI_DECIMAL
				{
				mSCI_DECIMAL(); 

				}
				break;
			case 55 :
				// src/exm/stc/ast/ExM.g:1:371: NOTANUMBER
				{
				mNOTANUMBER(); 

				}
				break;
			case 56 :
				// src/exm/stc/ast/ExM.g:1:382: INFINITY
				{
				mINFINITY(); 

				}
				break;
			case 57 :
				// src/exm/stc/ast/ExM.g:1:391: ID
				{
				mID(); 

				}
				break;
			case 58 :
				// src/exm/stc/ast/ExM.g:1:394: LPAREN
				{
				mLPAREN(); 

				}
				break;
			case 59 :
				// src/exm/stc/ast/ExM.g:1:401: RPAREN
				{
				mRPAREN(); 

				}
				break;
			case 60 :
				// src/exm/stc/ast/ExM.g:1:408: LBRACE
				{
				mLBRACE(); 

				}
				break;
			case 61 :
				// src/exm/stc/ast/ExM.g:1:415: RBRACE
				{
				mRBRACE(); 

				}
				break;
			case 62 :
				// src/exm/stc/ast/ExM.g:1:422: LSQUARE
				{
				mLSQUARE(); 

				}
				break;
			case 63 :
				// src/exm/stc/ast/ExM.g:1:430: RSQUARE
				{
				mRSQUARE(); 

				}
				break;
			case 64 :
				// src/exm/stc/ast/ExM.g:1:438: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 65 :
				// src/exm/stc/ast/ExM.g:1:444: HASH
				{
				mHASH(); 

				}
				break;
			case 66 :
				// src/exm/stc/ast/ExM.g:1:449: SEMICOLON
				{
				mSEMICOLON(); 

				}
				break;
			case 67 :
				// src/exm/stc/ast/ExM.g:1:459: COLON
				{
				mCOLON(); 

				}
				break;
			case 68 :
				// src/exm/stc/ast/ExM.g:1:465: ATSIGN
				{
				mATSIGN(); 

				}
				break;
			case 69 :
				// src/exm/stc/ast/ExM.g:1:472: VARARGS
				{
				mVARARGS(); 

				}
				break;
			case 70 :
				// src/exm/stc/ast/ExM.g:1:480: PIPE
				{
				mPIPE(); 

				}
				break;
			case 71 :
				// src/exm/stc/ast/ExM.g:1:485: WHITESPACE
				{
				mWHITESPACE(); 

				}
				break;
			case 72 :
				// src/exm/stc/ast/ExM.g:1:496: STRING
				{
				mSTRING(); 

				}
				break;
			case 73 :
				// src/exm/stc/ast/ExM.g:1:503: STRING_MULTI_LINE_1
				{
				mSTRING_MULTI_LINE_1(); 

				}
				break;
			case 74 :
				// src/exm/stc/ast/ExM.g:1:523: STRING_MULTI_LINE_2
				{
				mSTRING_MULTI_LINE_2(); 

				}
				break;

		}
	}


	protected DFA14 dfa14 = new DFA14(this);
	static final String DFA14_eotS =
		"\2\uffff\1\54\1\56\1\61\1\63\1\66\1\70\1\72\1\74\1\76\1\100\1\102\1\104"+
		"\1\105\15\37\2\135\1\37\50\uffff\2\37\1\145\1\147\20\37\5\uffff\1\37\1"+
		"\142\1\uffff\1\174\1\37\1\uffff\1\176\1\uffff\11\37\1\u008b\7\37\1\u0093"+
		"\1\u0094\2\uffff\1\37\1\uffff\2\37\1\u0098\4\37\1\u009d\2\37\1\u00a0\1"+
		"\37\1\uffff\2\37\1\u00a4\1\u00a5\1\u00a7\2\37\2\uffff\3\37\1\uffff\1\37"+
		"\1\u00ae\2\37\1\uffff\1\u00b1\1\37\1\uffff\1\37\1\u00b4\1\u00b5\2\uffff"+
		"\1\37\1\uffff\4\37\1\u00bb\1\u00bc\1\uffff\1\u00bd\1\u00be\1\uffff\2\37"+
		"\2\uffff\1\37\1\u00c2\1\u00c3\1\u00c4\1\u00c5\4\uffff\1\u00c6\1\u00c7"+
		"\1\u00c8\7\uffff";
	static final String DFA14_eofS =
		"\u00c9\uffff";
	static final String DFA14_minS =
		"\1\11\1\uffff\2\75\1\52\1\75\1\45\1\75\1\55\1\52\2\75\1\174\1\56\1\0\1"+
		"\160\1\165\1\146\1\154\1\164\1\141\1\145\1\141\1\156\1\141\1\162\1\154"+
		"\1\162\2\56\1\141\13\uffff\1\0\34\uffff\1\160\1\151\2\60\1\145\1\160\1"+
		"\163\1\151\1\144\1\163\1\156\1\145\1\162\1\154\1\164\1\151\1\165\1\160"+
		"\1\157\1\141\3\uffff\1\60\1\uffff\1\116\1\42\1\uffff\1\60\1\154\1\uffff"+
		"\1\60\1\uffff\1\162\1\157\1\145\1\164\2\145\1\163\1\141\1\160\1\60\1\163"+
		"\1\151\1\164\2\145\1\142\1\147\2\60\2\uffff\1\164\1\uffff\1\141\1\162"+
		"\1\60\1\143\1\156\1\165\1\162\1\60\1\164\1\165\1\60\1\141\1\uffff\1\145"+
		"\1\154\3\60\1\141\1\155\2\uffff\1\151\2\164\1\uffff\1\150\1\60\1\164\1"+
		"\162\1\uffff\1\60\1\154\1\uffff\1\143\2\60\2\uffff\1\145\1\uffff\1\154"+
		"\1\141\1\156\1\145\2\60\1\uffff\2\60\1\uffff\1\164\1\150\2\uffff\1\146"+
		"\4\60\4\uffff\3\60\7\uffff";
	static final String DFA14_maxS =
		"\1\175\1\uffff\2\75\1\57\1\75\1\57\1\75\1\55\1\52\2\75\1\174\1\56\1\uffff"+
		"\1\160\1\165\1\164\1\154\1\167\1\157\1\145\1\157\1\156\1\141\1\171\1\154"+
		"\1\162\1\170\1\145\1\141\13\uffff\1\uffff\34\uffff\1\160\1\151\2\172\1"+
		"\145\1\160\1\163\1\151\1\144\1\163\1\156\1\146\1\162\1\154\1\164\1\151"+
		"\1\165\1\160\1\157\1\141\3\uffff\1\71\1\uffff\1\116\1\42\1\uffff\1\172"+
		"\1\154\1\uffff\1\172\1\uffff\1\162\1\157\1\145\1\164\1\157\1\145\1\163"+
		"\1\141\1\160\1\172\1\163\1\151\1\164\2\145\1\142\1\147\1\145\1\172\2\uffff"+
		"\1\164\1\uffff\1\141\1\162\1\172\1\143\1\156\1\165\1\162\1\172\1\164\1"+
		"\165\1\172\1\141\1\uffff\1\145\1\154\3\172\1\141\1\155\2\uffff\1\151\2"+
		"\164\1\uffff\1\150\1\172\1\164\1\162\1\uffff\1\172\1\154\1\uffff\1\143"+
		"\2\172\2\uffff\1\145\1\uffff\1\154\1\141\1\156\1\145\2\172\1\uffff\2\172"+
		"\1\uffff\1\164\1\150\2\uffff\1\146\4\172\4\uffff\3\172\7\uffff";
	static final String DFA14_acceptS =
		"\1\uffff\1\1\35\uffff\1\71\1\72\1\73\1\74\1\75\1\76\1\77\1\100\1\102\1"+
		"\104\1\107\1\uffff\1\2\1\23\1\5\1\3\1\27\1\30\1\4\1\7\1\6\1\10\1\14\1"+
		"\22\1\12\1\11\1\111\1\13\1\24\1\15\1\16\1\103\1\17\1\20\1\21\1\106\1\105"+
		"\1\25\1\101\1\26\24\uffff\1\63\1\64\1\62\1\uffff\1\66\2\uffff\1\110\2"+
		"\uffff\1\33\1\uffff\1\41\23\uffff\1\112\1\31\1\uffff\1\70\14\uffff\1\42"+
		"\7\uffff\1\65\1\67\3\uffff\1\34\4\uffff\1\36\2\uffff\1\46\3\uffff\1\45"+
		"\1\47\1\uffff\1\53\6\uffff\1\57\2\uffff\1\52\2\uffff\1\50\1\44\5\uffff"+
		"\1\55\1\35\1\60\1\61\3\uffff\1\51\1\56\1\32\1\43\1\37\1\40\1\54";
	static final String DFA14_specialS =
		"\16\uffff\1\1\33\uffff\1\0\u009e\uffff}>";
	static final String[] DFA14_transitionS = {
			"\2\51\1\uffff\2\51\22\uffff\1\51\1\13\1\52\1\16\1\uffff\1\6\1\1\1\uffff"+
			"\1\40\1\41\1\11\1\2\1\46\1\10\1\15\1\4\1\34\11\35\1\12\1\47\1\7\1\3\1"+
			"\5\1\uffff\1\50\15\37\1\36\14\37\1\44\1\uffff\1\45\1\uffff\1\37\1\uffff"+
			"\1\17\1\20\1\24\1\25\1\22\1\26\1\32\1\37\1\21\6\37\1\33\2\37\1\23\1\31"+
			"\1\27\1\37\1\30\3\37\1\42\1\14\1\43",
			"",
			"\1\53",
			"\1\55",
			"\1\60\4\uffff\1\57",
			"\1\62",
			"\1\65\11\uffff\1\64",
			"\1\67",
			"\1\71",
			"\1\73",
			"\1\75",
			"\1\77",
			"\1\101",
			"\1\103",
			"\0\106",
			"\1\107",
			"\1\110",
			"\1\111\6\uffff\1\114\1\112\5\uffff\1\113",
			"\1\115",
			"\1\117\2\uffff\1\116",
			"\1\120\15\uffff\1\121",
			"\1\122",
			"\1\124\15\uffff\1\123",
			"\1\125",
			"\1\126",
			"\1\127\6\uffff\1\130",
			"\1\131",
			"\1\132",
			"\1\136\1\uffff\12\35\13\uffff\1\137\37\uffff\1\137\11\uffff\1\133\10"+
			"\uffff\1\134",
			"\1\136\1\uffff\12\35\13\uffff\1\137\37\uffff\1\137",
			"\1\140",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\42\142\1\141\uffdd\142",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\143",
			"\1\144",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\5\37\1\146\24\37",
			"\1\150",
			"\1\151",
			"\1\152",
			"\1\153",
			"\1\154",
			"\1\155",
			"\1\156",
			"\1\160\1\157",
			"\1\161",
			"\1\162",
			"\1\163",
			"\1\164",
			"\1\165",
			"\1\166",
			"\1\167",
			"\1\170",
			"",
			"",
			"",
			"\12\171",
			"",
			"\1\172",
			"\1\173",
			"",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\1\175",
			"",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"",
			"\1\177",
			"\1\u0080",
			"\1\u0081",
			"\1\u0082",
			"\1\u0085\3\uffff\1\u0083\5\uffff\1\u0084",
			"\1\u0086",
			"\1\u0087",
			"\1\u0088",
			"\1\u0089",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\4\37\1\u008a\25\37",
			"\1\u008c",
			"\1\u008d",
			"\1\u008e",
			"\1\u008f",
			"\1\u0090",
			"\1\u0091",
			"\1\u0092",
			"\12\171\13\uffff\1\137\37\uffff\1\137",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"",
			"",
			"\1\u0095",
			"",
			"\1\u0096",
			"\1\u0097",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\1\u0099",
			"\1\u009a",
			"\1\u009b",
			"\1\u009c",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\1\u009e",
			"\1\u009f",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\1\u00a1",
			"",
			"\1\u00a2",
			"\1\u00a3",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\3\37\1\u00a6\26\37",
			"\1\u00a8",
			"\1\u00a9",
			"",
			"",
			"\1\u00aa",
			"\1\u00ab",
			"\1\u00ac",
			"",
			"\1\u00ad",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\1\u00af",
			"\1\u00b0",
			"",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\1\u00b2",
			"",
			"\1\u00b3",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"",
			"",
			"\1\u00b6",
			"",
			"\1\u00b7",
			"\1\u00b8",
			"\1\u00b9",
			"\1\u00ba",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"",
			"\1\u00bf",
			"\1\u00c0",
			"",
			"",
			"\1\u00c1",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"",
			"",
			"",
			"",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"",
			"",
			"",
			"",
			"",
			"",
			""
	};

	static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
	static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
	static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
	static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
	static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
	static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
	static final short[][] DFA14_transition;

	static {
		int numStates = DFA14_transitionS.length;
		DFA14_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
		}
	}

	protected class DFA14 extends DFA {

		public DFA14(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 14;
			this.eot = DFA14_eot;
			this.eof = DFA14_eof;
			this.min = DFA14_min;
			this.max = DFA14_max;
			this.accept = DFA14_accept;
			this.special = DFA14_special;
			this.transition = DFA14_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( AND | APPEND | ASSIGN | DIV | EQUALS | GT | GTE | INTDIV | LT | LTE | MINUS | MOD | MULT | MUTATE | NEQUALS | NOT | OR | PERCENT | PLUS | POW | T__150 | CPP_LINE | SINGLE_LINE_COMMENT_C | MULTI_LINE_COMMENT | APP | BUILTIN | IF | ELSE | SWITCH | CASE | DEFAULT | FOREACH | IN | FOR | ITERATE | UNTIL | WAIT | DEEP | TRUE | FALSE | GLOBAL | CONST | TYPE | TYPEDEF | IMPORT | PRAGMA | STDIN | STDOUT | STDERR | DECIMAL_INT | OCTAL_INT | HEX_INT | DECIMAL | SCI_DECIMAL | NOTANUMBER | INFINITY | ID | LPAREN | RPAREN | LBRACE | RBRACE | LSQUARE | RSQUARE | COMMA | HASH | SEMICOLON | COLON | ATSIGN | VARARGS | PIPE | WHITESPACE | STRING | STRING_MULTI_LINE_1 | STRING_MULTI_LINE_2 );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA14_42 = input.LA(1);
						s = -1;
						if ( (LA14_42=='\"') ) {s = 97;}
						else if ( ((LA14_42 >= '\u0000' && LA14_42 <= '!')||(LA14_42 >= '#' && LA14_42 <= '\uFFFF')) ) {s = 98;}
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA14_14 = input.LA(1);
						s = -1;
						if ( ((LA14_14 >= '\u0000' && LA14_14 <= '\uFFFF')) ) {s = 70;}
						else s = 69;
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 14, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
