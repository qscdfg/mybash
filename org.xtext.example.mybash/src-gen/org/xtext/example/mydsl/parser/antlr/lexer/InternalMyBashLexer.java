package org.xtext.example.mydsl.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMyBashLexer extends Lexer {
    public static final int LessThanSignGreaterThanSign=47;
    public static final int RULE_HERE_DOC_START=110;
    public static final int Elif=8;
    public static final int LessThanSign=82;
    public static final int CircumflexAccentCircumflexAccent=59;
    public static final int AmpersandGreaterThanSign=25;
    public static final int LeftParenthesis=73;
    public static final int CommaComma=32;
    public static final int Then=11;
    public static final int EqualsSignTilde=50;
    public static final int ExclamationMark=67;
    public static final int LessThanSignAmpersand=43;
    public static final int GreaterThanSign=84;
    public static final int SolidusSolidus=35;
    public static final int RULE_CS_END=108;
    public static final int DollarSignLeftParenthesisLeftParenthesis=12;
    public static final int GreaterThanSignEqualsSign=53;
    public static final int EqualsSignEqualsSign=49;
    public static final int VerticalLine=91;
    public static final int PlusSign=76;
    public static final int PercentSignPercentSign=21;
    public static final int LeftSquareBracketLeftSquareBracket=56;
    public static final int LeftSquareBracket=87;
    public static final int VerticalLineAmpersand=64;
    public static final int LessThanSignLessThanSign=45;
    public static final int If=62;
    public static final int In=63;
    public static final int VerticalLineVerticalLine=66;
    public static final int QuotationMark=68;
    public static final int Case=6;
    public static final int Esac=10;
    public static final int Comma=77;
    public static final int HyphenMinus=78;
    public static final int LeftParenthesisLeftParenthesis=26;
    public static final int LessThanSignEqualsSign=46;
    public static final int Solidus=79;
    public static final int RightCurlyBracket=92;
    public static final int Apostrophe=72;
    public static final int PercentSignEqualsSign=22;
    public static final int NumberSignNumberSign=19;
    public static final int RULE_VARIABLE=102;
    public static final int CommercialAt=86;
    public static final int Semicolon=81;
    public static final int RightParenthesisRightParenthesis=27;
    public static final int PlusSignPlusSign=30;
    public static final int QuestionMark=85;
    public static final int Else=9;
    public static final int ColonPlusSign=37;
    public static final int GreaterThanSignLeftParenthesis=52;
    public static final int RULE_I_NUMBER=94;
    public static final int ExclamationMarkEqualsSign=18;
    public static final int AmpersandGreaterThanSignGreaterThanSign=13;
    public static final int RULE_HERE_DOC_END=111;
    public static final int HyphenMinusHyphenMinus=33;
    public static final int Done=7;
    public static final int AmpersandEqualsSign=24;
    public static final int DollarSignLeftCurlyBracket=20;
    public static final int SolidusEqualsSign=36;
    public static final int RULE_HIDEN_NEW_LINE=97;
    public static final int RULE_WORD_PART=100;
    public static final int PercentSign=70;
    public static final int RightSquareBracketRightSquareBracket=57;
    public static final int Ampersand=71;
    public static final int AsteriskEqualsSign=29;
    public static final int VerticalLineEqualsSign=65;
    public static final int SemicolonAmpersand=41;
    public static final int RightSquareBracket=88;
    public static final int RULE_HERE_DOC_WORD=109;
    public static final int RULE_C_S_OP=104;
    public static final int For=17;
    public static final int RightParenthesis=74;
    public static final int SemicolonSemicolon=42;
    public static final int Do=60;
    public static final int ColonEqualsSign=39;
    public static final int RULE_S_WORD_PART=99;
    public static final int RULE_NEW_LINE=95;
    public static final int GreaterThanSignAmpersand=51;
    public static final int NumberSign=69;
    public static final int AsteriskAsterisk=28;
    public static final int RULE_HERE_DOC_PART=112;
    public static final int CircumflexAccentEqualsSign=58;
    public static final int LessThanSignLessThanSignEqualsSign=15;
    public static final int RULE_NAME=98;
    public static final int RULE_SL_COMMENT=101;
    public static final int Function=4;
    public static final int EqualsSign=83;
    public static final int AmpersandAmpersand=23;
    public static final int LessThanSignVerticalLine=48;
    public static final int RULE_C_B_OP=105;
    public static final int HyphenMinusEqualsSign=34;
    public static final int LessThanSignLeftParenthesis=44;
    public static final int Colon=80;
    public static final int RULE_C_LINE=106;
    public static final int EOF=-1;
    public static final int Asterisk=75;
    public static final int PlusSignEqualsSign=31;
    public static final int Fi=61;
    public static final int RULE_CS_START=107;
    public static final int RULE_WS=96;
    public static final int LeftCurlyBracket=90;
    public static final int Tilde=93;
    public static final int While=5;
    public static final int GreaterThanSignVerticalLine=55;
    public static final int GreaterThanSignGreaterThanSign=54;
    public static final int ColonHyphenMinus=38;
    public static final int CircumflexAccent=89;
    public static final int ColonQuestionMark=40;
    public static final int SemicolonSemicolonAmpersand=14;
    public static final int GreaterThanSignGreaterThanSignEqualsSign=16;
    public static final int RULE_A_PREFIX=103;

    // delegates
    // delegators

    public InternalMyBashLexer() {;} 
    public InternalMyBashLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalMyBashLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalMyBashLexer.g"; }

    // $ANTLR start "Function"
    public final void mFunction() throws RecognitionException {
        try {
            int _type = Function;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:14:10: ( 'function' )
            // InternalMyBashLexer.g:14:12: 'function'
            {
            match("function"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Function"

    // $ANTLR start "While"
    public final void mWhile() throws RecognitionException {
        try {
            int _type = While;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:16:7: ( 'while' )
            // InternalMyBashLexer.g:16:9: 'while'
            {
            match("while"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "While"

    // $ANTLR start "Case"
    public final void mCase() throws RecognitionException {
        try {
            int _type = Case;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:18:6: ( 'case' )
            // InternalMyBashLexer.g:18:8: 'case'
            {
            match("case"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Case"

    // $ANTLR start "Done"
    public final void mDone() throws RecognitionException {
        try {
            int _type = Done;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:20:6: ( 'done' )
            // InternalMyBashLexer.g:20:8: 'done'
            {
            match("done"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Done"

    // $ANTLR start "Elif"
    public final void mElif() throws RecognitionException {
        try {
            int _type = Elif;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:22:6: ( 'elif' )
            // InternalMyBashLexer.g:22:8: 'elif'
            {
            match("elif"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Elif"

    // $ANTLR start "Else"
    public final void mElse() throws RecognitionException {
        try {
            int _type = Else;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:24:6: ( 'else' )
            // InternalMyBashLexer.g:24:8: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Else"

    // $ANTLR start "Esac"
    public final void mEsac() throws RecognitionException {
        try {
            int _type = Esac;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:26:6: ( 'esac' )
            // InternalMyBashLexer.g:26:8: 'esac'
            {
            match("esac"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Esac"

    // $ANTLR start "Then"
    public final void mThen() throws RecognitionException {
        try {
            int _type = Then;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:28:6: ( 'then' )
            // InternalMyBashLexer.g:28:8: 'then'
            {
            match("then"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Then"

    // $ANTLR start "DollarSignLeftParenthesisLeftParenthesis"
    public final void mDollarSignLeftParenthesisLeftParenthesis() throws RecognitionException {
        try {
            int _type = DollarSignLeftParenthesisLeftParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:30:42: ( '$((' )
            // InternalMyBashLexer.g:30:44: '$(('
            {
            match("$(("); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DollarSignLeftParenthesisLeftParenthesis"

    // $ANTLR start "AmpersandGreaterThanSignGreaterThanSign"
    public final void mAmpersandGreaterThanSignGreaterThanSign() throws RecognitionException {
        try {
            int _type = AmpersandGreaterThanSignGreaterThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:32:41: ( '&>>' )
            // InternalMyBashLexer.g:32:43: '&>>'
            {
            match("&>>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AmpersandGreaterThanSignGreaterThanSign"

    // $ANTLR start "SemicolonSemicolonAmpersand"
    public final void mSemicolonSemicolonAmpersand() throws RecognitionException {
        try {
            int _type = SemicolonSemicolonAmpersand;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:34:29: ( ';;&' )
            // InternalMyBashLexer.g:34:31: ';;&'
            {
            match(";;&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SemicolonSemicolonAmpersand"

    // $ANTLR start "LessThanSignLessThanSignEqualsSign"
    public final void mLessThanSignLessThanSignEqualsSign() throws RecognitionException {
        try {
            int _type = LessThanSignLessThanSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:36:36: ( '<<=' )
            // InternalMyBashLexer.g:36:38: '<<='
            {
            match("<<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LessThanSignLessThanSignEqualsSign"

    // $ANTLR start "GreaterThanSignGreaterThanSignEqualsSign"
    public final void mGreaterThanSignGreaterThanSignEqualsSign() throws RecognitionException {
        try {
            int _type = GreaterThanSignGreaterThanSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:38:42: ( '>>=' )
            // InternalMyBashLexer.g:38:44: '>>='
            {
            match(">>="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GreaterThanSignGreaterThanSignEqualsSign"

    // $ANTLR start "For"
    public final void mFor() throws RecognitionException {
        try {
            int _type = For;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:40:5: ( 'for' )
            // InternalMyBashLexer.g:40:7: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "For"

    // $ANTLR start "ExclamationMarkEqualsSign"
    public final void mExclamationMarkEqualsSign() throws RecognitionException {
        try {
            int _type = ExclamationMarkEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:42:27: ( '!=' )
            // InternalMyBashLexer.g:42:29: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ExclamationMarkEqualsSign"

    // $ANTLR start "NumberSignNumberSign"
    public final void mNumberSignNumberSign() throws RecognitionException {
        try {
            int _type = NumberSignNumberSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:44:22: ( '##' )
            // InternalMyBashLexer.g:44:24: '##'
            {
            match("##"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NumberSignNumberSign"

    // $ANTLR start "DollarSignLeftCurlyBracket"
    public final void mDollarSignLeftCurlyBracket() throws RecognitionException {
        try {
            int _type = DollarSignLeftCurlyBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:46:28: ( '${' )
            // InternalMyBashLexer.g:46:30: '${'
            {
            match("${"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DollarSignLeftCurlyBracket"

    // $ANTLR start "PercentSignPercentSign"
    public final void mPercentSignPercentSign() throws RecognitionException {
        try {
            int _type = PercentSignPercentSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:48:24: ( '%%' )
            // InternalMyBashLexer.g:48:26: '%%'
            {
            match("%%"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PercentSignPercentSign"

    // $ANTLR start "PercentSignEqualsSign"
    public final void mPercentSignEqualsSign() throws RecognitionException {
        try {
            int _type = PercentSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:50:23: ( '%=' )
            // InternalMyBashLexer.g:50:25: '%='
            {
            match("%="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PercentSignEqualsSign"

    // $ANTLR start "AmpersandAmpersand"
    public final void mAmpersandAmpersand() throws RecognitionException {
        try {
            int _type = AmpersandAmpersand;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:52:20: ( '&&' )
            // InternalMyBashLexer.g:52:22: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AmpersandAmpersand"

    // $ANTLR start "AmpersandEqualsSign"
    public final void mAmpersandEqualsSign() throws RecognitionException {
        try {
            int _type = AmpersandEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:54:21: ( '&=' )
            // InternalMyBashLexer.g:54:23: '&='
            {
            match("&="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AmpersandEqualsSign"

    // $ANTLR start "AmpersandGreaterThanSign"
    public final void mAmpersandGreaterThanSign() throws RecognitionException {
        try {
            int _type = AmpersandGreaterThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:56:26: ( '&>' )
            // InternalMyBashLexer.g:56:28: '&>'
            {
            match("&>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AmpersandGreaterThanSign"

    // $ANTLR start "LeftParenthesisLeftParenthesis"
    public final void mLeftParenthesisLeftParenthesis() throws RecognitionException {
        try {
            int _type = LeftParenthesisLeftParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:58:32: ( '((' )
            // InternalMyBashLexer.g:58:34: '(('
            {
            match("(("); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftParenthesisLeftParenthesis"

    // $ANTLR start "RightParenthesisRightParenthesis"
    public final void mRightParenthesisRightParenthesis() throws RecognitionException {
        try {
            int _type = RightParenthesisRightParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:60:34: ( '))' )
            // InternalMyBashLexer.g:60:36: '))'
            {
            match("))"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightParenthesisRightParenthesis"

    // $ANTLR start "AsteriskAsterisk"
    public final void mAsteriskAsterisk() throws RecognitionException {
        try {
            int _type = AsteriskAsterisk;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:62:18: ( '**' )
            // InternalMyBashLexer.g:62:20: '**'
            {
            match("**"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AsteriskAsterisk"

    // $ANTLR start "AsteriskEqualsSign"
    public final void mAsteriskEqualsSign() throws RecognitionException {
        try {
            int _type = AsteriskEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:64:20: ( '*=' )
            // InternalMyBashLexer.g:64:22: '*='
            {
            match("*="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AsteriskEqualsSign"

    // $ANTLR start "PlusSignPlusSign"
    public final void mPlusSignPlusSign() throws RecognitionException {
        try {
            int _type = PlusSignPlusSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:66:18: ( '++' )
            // InternalMyBashLexer.g:66:20: '++'
            {
            match("++"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PlusSignPlusSign"

    // $ANTLR start "PlusSignEqualsSign"
    public final void mPlusSignEqualsSign() throws RecognitionException {
        try {
            int _type = PlusSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:68:20: ( '+=' )
            // InternalMyBashLexer.g:68:22: '+='
            {
            match("+="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PlusSignEqualsSign"

    // $ANTLR start "CommaComma"
    public final void mCommaComma() throws RecognitionException {
        try {
            int _type = CommaComma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:70:12: ( ',,' )
            // InternalMyBashLexer.g:70:14: ',,'
            {
            match(",,"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CommaComma"

    // $ANTLR start "HyphenMinusHyphenMinus"
    public final void mHyphenMinusHyphenMinus() throws RecognitionException {
        try {
            int _type = HyphenMinusHyphenMinus;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:72:24: ( '--' )
            // InternalMyBashLexer.g:72:26: '--'
            {
            match("--"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HyphenMinusHyphenMinus"

    // $ANTLR start "HyphenMinusEqualsSign"
    public final void mHyphenMinusEqualsSign() throws RecognitionException {
        try {
            int _type = HyphenMinusEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:74:23: ( '-=' )
            // InternalMyBashLexer.g:74:25: '-='
            {
            match("-="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HyphenMinusEqualsSign"

    // $ANTLR start "SolidusSolidus"
    public final void mSolidusSolidus() throws RecognitionException {
        try {
            int _type = SolidusSolidus;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:76:16: ( '//' )
            // InternalMyBashLexer.g:76:18: '//'
            {
            match("//"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SolidusSolidus"

    // $ANTLR start "SolidusEqualsSign"
    public final void mSolidusEqualsSign() throws RecognitionException {
        try {
            int _type = SolidusEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:78:19: ( '/=' )
            // InternalMyBashLexer.g:78:21: '/='
            {
            match("/="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SolidusEqualsSign"

    // $ANTLR start "ColonPlusSign"
    public final void mColonPlusSign() throws RecognitionException {
        try {
            int _type = ColonPlusSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:80:15: ( ':+' )
            // InternalMyBashLexer.g:80:17: ':+'
            {
            match(":+"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ColonPlusSign"

    // $ANTLR start "ColonHyphenMinus"
    public final void mColonHyphenMinus() throws RecognitionException {
        try {
            int _type = ColonHyphenMinus;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:82:18: ( ':-' )
            // InternalMyBashLexer.g:82:20: ':-'
            {
            match(":-"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ColonHyphenMinus"

    // $ANTLR start "ColonEqualsSign"
    public final void mColonEqualsSign() throws RecognitionException {
        try {
            int _type = ColonEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:84:17: ( ':=' )
            // InternalMyBashLexer.g:84:19: ':='
            {
            match(":="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ColonEqualsSign"

    // $ANTLR start "ColonQuestionMark"
    public final void mColonQuestionMark() throws RecognitionException {
        try {
            int _type = ColonQuestionMark;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:86:19: ( ':?' )
            // InternalMyBashLexer.g:86:21: ':?'
            {
            match(":?"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ColonQuestionMark"

    // $ANTLR start "SemicolonAmpersand"
    public final void mSemicolonAmpersand() throws RecognitionException {
        try {
            int _type = SemicolonAmpersand;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:88:20: ( ';&' )
            // InternalMyBashLexer.g:88:22: ';&'
            {
            match(";&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SemicolonAmpersand"

    // $ANTLR start "SemicolonSemicolon"
    public final void mSemicolonSemicolon() throws RecognitionException {
        try {
            int _type = SemicolonSemicolon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:90:20: ( ';;' )
            // InternalMyBashLexer.g:90:22: ';;'
            {
            match(";;"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SemicolonSemicolon"

    // $ANTLR start "LessThanSignAmpersand"
    public final void mLessThanSignAmpersand() throws RecognitionException {
        try {
            int _type = LessThanSignAmpersand;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:92:23: ( '<&' )
            // InternalMyBashLexer.g:92:25: '<&'
            {
            match("<&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LessThanSignAmpersand"

    // $ANTLR start "LessThanSignLeftParenthesis"
    public final void mLessThanSignLeftParenthesis() throws RecognitionException {
        try {
            int _type = LessThanSignLeftParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:94:29: ( '<(' )
            // InternalMyBashLexer.g:94:31: '<('
            {
            match("<("); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LessThanSignLeftParenthesis"

    // $ANTLR start "LessThanSignLessThanSign"
    public final void mLessThanSignLessThanSign() throws RecognitionException {
        try {
            int _type = LessThanSignLessThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:96:26: ( '<<' )
            // InternalMyBashLexer.g:96:28: '<<'
            {
            match("<<"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LessThanSignLessThanSign"

    // $ANTLR start "LessThanSignEqualsSign"
    public final void mLessThanSignEqualsSign() throws RecognitionException {
        try {
            int _type = LessThanSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:98:24: ( '<=' )
            // InternalMyBashLexer.g:98:26: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LessThanSignEqualsSign"

    // $ANTLR start "LessThanSignGreaterThanSign"
    public final void mLessThanSignGreaterThanSign() throws RecognitionException {
        try {
            int _type = LessThanSignGreaterThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:100:29: ( '<>' )
            // InternalMyBashLexer.g:100:31: '<>'
            {
            match("<>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LessThanSignGreaterThanSign"

    // $ANTLR start "LessThanSignVerticalLine"
    public final void mLessThanSignVerticalLine() throws RecognitionException {
        try {
            int _type = LessThanSignVerticalLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:102:26: ( '<|' )
            // InternalMyBashLexer.g:102:28: '<|'
            {
            match("<|"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LessThanSignVerticalLine"

    // $ANTLR start "EqualsSignEqualsSign"
    public final void mEqualsSignEqualsSign() throws RecognitionException {
        try {
            int _type = EqualsSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:104:22: ( '==' )
            // InternalMyBashLexer.g:104:24: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EqualsSignEqualsSign"

    // $ANTLR start "EqualsSignTilde"
    public final void mEqualsSignTilde() throws RecognitionException {
        try {
            int _type = EqualsSignTilde;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:106:17: ( '=~' )
            // InternalMyBashLexer.g:106:19: '=~'
            {
            match("=~"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EqualsSignTilde"

    // $ANTLR start "GreaterThanSignAmpersand"
    public final void mGreaterThanSignAmpersand() throws RecognitionException {
        try {
            int _type = GreaterThanSignAmpersand;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:108:26: ( '>&' )
            // InternalMyBashLexer.g:108:28: '>&'
            {
            match(">&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GreaterThanSignAmpersand"

    // $ANTLR start "GreaterThanSignLeftParenthesis"
    public final void mGreaterThanSignLeftParenthesis() throws RecognitionException {
        try {
            int _type = GreaterThanSignLeftParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:110:32: ( '>(' )
            // InternalMyBashLexer.g:110:34: '>('
            {
            match(">("); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GreaterThanSignLeftParenthesis"

    // $ANTLR start "GreaterThanSignEqualsSign"
    public final void mGreaterThanSignEqualsSign() throws RecognitionException {
        try {
            int _type = GreaterThanSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:112:27: ( '>=' )
            // InternalMyBashLexer.g:112:29: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GreaterThanSignEqualsSign"

    // $ANTLR start "GreaterThanSignGreaterThanSign"
    public final void mGreaterThanSignGreaterThanSign() throws RecognitionException {
        try {
            int _type = GreaterThanSignGreaterThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:114:32: ( '>>' )
            // InternalMyBashLexer.g:114:34: '>>'
            {
            match(">>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GreaterThanSignGreaterThanSign"

    // $ANTLR start "GreaterThanSignVerticalLine"
    public final void mGreaterThanSignVerticalLine() throws RecognitionException {
        try {
            int _type = GreaterThanSignVerticalLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:116:29: ( '>|' )
            // InternalMyBashLexer.g:116:31: '>|'
            {
            match(">|"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GreaterThanSignVerticalLine"

    // $ANTLR start "LeftSquareBracketLeftSquareBracket"
    public final void mLeftSquareBracketLeftSquareBracket() throws RecognitionException {
        try {
            int _type = LeftSquareBracketLeftSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:118:36: ( '[[' )
            // InternalMyBashLexer.g:118:38: '[['
            {
            match("[["); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftSquareBracketLeftSquareBracket"

    // $ANTLR start "RightSquareBracketRightSquareBracket"
    public final void mRightSquareBracketRightSquareBracket() throws RecognitionException {
        try {
            int _type = RightSquareBracketRightSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:120:38: ( ']]' )
            // InternalMyBashLexer.g:120:40: ']]'
            {
            match("]]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightSquareBracketRightSquareBracket"

    // $ANTLR start "CircumflexAccentEqualsSign"
    public final void mCircumflexAccentEqualsSign() throws RecognitionException {
        try {
            int _type = CircumflexAccentEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:122:28: ( '^=' )
            // InternalMyBashLexer.g:122:30: '^='
            {
            match("^="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CircumflexAccentEqualsSign"

    // $ANTLR start "CircumflexAccentCircumflexAccent"
    public final void mCircumflexAccentCircumflexAccent() throws RecognitionException {
        try {
            int _type = CircumflexAccentCircumflexAccent;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:124:34: ( '^^' )
            // InternalMyBashLexer.g:124:36: '^^'
            {
            match("^^"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CircumflexAccentCircumflexAccent"

    // $ANTLR start "Do"
    public final void mDo() throws RecognitionException {
        try {
            int _type = Do;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:126:4: ( 'do' )
            // InternalMyBashLexer.g:126:6: 'do'
            {
            match("do"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Do"

    // $ANTLR start "Fi"
    public final void mFi() throws RecognitionException {
        try {
            int _type = Fi;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:128:4: ( 'fi' )
            // InternalMyBashLexer.g:128:6: 'fi'
            {
            match("fi"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Fi"

    // $ANTLR start "If"
    public final void mIf() throws RecognitionException {
        try {
            int _type = If;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:130:4: ( 'if' )
            // InternalMyBashLexer.g:130:6: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "If"

    // $ANTLR start "In"
    public final void mIn() throws RecognitionException {
        try {
            int _type = In;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:132:4: ( 'in' )
            // InternalMyBashLexer.g:132:6: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "In"

    // $ANTLR start "VerticalLineAmpersand"
    public final void mVerticalLineAmpersand() throws RecognitionException {
        try {
            int _type = VerticalLineAmpersand;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:134:23: ( '|&' )
            // InternalMyBashLexer.g:134:25: '|&'
            {
            match("|&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VerticalLineAmpersand"

    // $ANTLR start "VerticalLineEqualsSign"
    public final void mVerticalLineEqualsSign() throws RecognitionException {
        try {
            int _type = VerticalLineEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:136:24: ( '|=' )
            // InternalMyBashLexer.g:136:26: '|='
            {
            match("|="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VerticalLineEqualsSign"

    // $ANTLR start "VerticalLineVerticalLine"
    public final void mVerticalLineVerticalLine() throws RecognitionException {
        try {
            int _type = VerticalLineVerticalLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:138:26: ( '||' )
            // InternalMyBashLexer.g:138:28: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VerticalLineVerticalLine"

    // $ANTLR start "ExclamationMark"
    public final void mExclamationMark() throws RecognitionException {
        try {
            int _type = ExclamationMark;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:140:17: ( '!' )
            // InternalMyBashLexer.g:140:19: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ExclamationMark"

    // $ANTLR start "QuotationMark"
    public final void mQuotationMark() throws RecognitionException {
        try {
            int _type = QuotationMark;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:142:15: ( '\"' )
            // InternalMyBashLexer.g:142:17: '\"'
            {
            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QuotationMark"

    // $ANTLR start "NumberSign"
    public final void mNumberSign() throws RecognitionException {
        try {
            int _type = NumberSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:144:12: ( '#' )
            // InternalMyBashLexer.g:144:14: '#'
            {
            match('#'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NumberSign"

    // $ANTLR start "PercentSign"
    public final void mPercentSign() throws RecognitionException {
        try {
            int _type = PercentSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:146:13: ( '%' )
            // InternalMyBashLexer.g:146:15: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PercentSign"

    // $ANTLR start "Ampersand"
    public final void mAmpersand() throws RecognitionException {
        try {
            int _type = Ampersand;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:148:11: ( '&' )
            // InternalMyBashLexer.g:148:13: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Ampersand"

    // $ANTLR start "Apostrophe"
    public final void mApostrophe() throws RecognitionException {
        try {
            int _type = Apostrophe;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:150:12: ( '\\'' )
            // InternalMyBashLexer.g:150:14: '\\''
            {
            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Apostrophe"

    // $ANTLR start "LeftParenthesis"
    public final void mLeftParenthesis() throws RecognitionException {
        try {
            int _type = LeftParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:152:17: ( '(' )
            // InternalMyBashLexer.g:152:19: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftParenthesis"

    // $ANTLR start "RightParenthesis"
    public final void mRightParenthesis() throws RecognitionException {
        try {
            int _type = RightParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:154:18: ( ')' )
            // InternalMyBashLexer.g:154:20: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightParenthesis"

    // $ANTLR start "Asterisk"
    public final void mAsterisk() throws RecognitionException {
        try {
            int _type = Asterisk;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:156:10: ( '*' )
            // InternalMyBashLexer.g:156:12: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Asterisk"

    // $ANTLR start "PlusSign"
    public final void mPlusSign() throws RecognitionException {
        try {
            int _type = PlusSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:158:10: ( '+' )
            // InternalMyBashLexer.g:158:12: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PlusSign"

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:160:7: ( ',' )
            // InternalMyBashLexer.g:160:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Comma"

    // $ANTLR start "HyphenMinus"
    public final void mHyphenMinus() throws RecognitionException {
        try {
            int _type = HyphenMinus;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:162:13: ( '-' )
            // InternalMyBashLexer.g:162:15: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HyphenMinus"

    // $ANTLR start "Solidus"
    public final void mSolidus() throws RecognitionException {
        try {
            int _type = Solidus;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:164:9: ( '/' )
            // InternalMyBashLexer.g:164:11: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Solidus"

    // $ANTLR start "Colon"
    public final void mColon() throws RecognitionException {
        try {
            int _type = Colon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:166:7: ( ':' )
            // InternalMyBashLexer.g:166:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Colon"

    // $ANTLR start "Semicolon"
    public final void mSemicolon() throws RecognitionException {
        try {
            int _type = Semicolon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:168:11: ( ';' )
            // InternalMyBashLexer.g:168:13: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Semicolon"

    // $ANTLR start "LessThanSign"
    public final void mLessThanSign() throws RecognitionException {
        try {
            int _type = LessThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:170:14: ( '<' )
            // InternalMyBashLexer.g:170:16: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LessThanSign"

    // $ANTLR start "EqualsSign"
    public final void mEqualsSign() throws RecognitionException {
        try {
            int _type = EqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:172:12: ( '=' )
            // InternalMyBashLexer.g:172:14: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EqualsSign"

    // $ANTLR start "GreaterThanSign"
    public final void mGreaterThanSign() throws RecognitionException {
        try {
            int _type = GreaterThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:174:17: ( '>' )
            // InternalMyBashLexer.g:174:19: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GreaterThanSign"

    // $ANTLR start "QuestionMark"
    public final void mQuestionMark() throws RecognitionException {
        try {
            int _type = QuestionMark;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:176:14: ( '?' )
            // InternalMyBashLexer.g:176:16: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QuestionMark"

    // $ANTLR start "CommercialAt"
    public final void mCommercialAt() throws RecognitionException {
        try {
            int _type = CommercialAt;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:178:14: ( '@' )
            // InternalMyBashLexer.g:178:16: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CommercialAt"

    // $ANTLR start "LeftSquareBracket"
    public final void mLeftSquareBracket() throws RecognitionException {
        try {
            int _type = LeftSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:180:19: ( '[' )
            // InternalMyBashLexer.g:180:21: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftSquareBracket"

    // $ANTLR start "RightSquareBracket"
    public final void mRightSquareBracket() throws RecognitionException {
        try {
            int _type = RightSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:182:20: ( ']' )
            // InternalMyBashLexer.g:182:22: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightSquareBracket"

    // $ANTLR start "CircumflexAccent"
    public final void mCircumflexAccent() throws RecognitionException {
        try {
            int _type = CircumflexAccent;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:184:18: ( '^' )
            // InternalMyBashLexer.g:184:20: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CircumflexAccent"

    // $ANTLR start "LeftCurlyBracket"
    public final void mLeftCurlyBracket() throws RecognitionException {
        try {
            int _type = LeftCurlyBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:186:18: ( '{' )
            // InternalMyBashLexer.g:186:20: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftCurlyBracket"

    // $ANTLR start "VerticalLine"
    public final void mVerticalLine() throws RecognitionException {
        try {
            int _type = VerticalLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:188:14: ( '|' )
            // InternalMyBashLexer.g:188:16: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VerticalLine"

    // $ANTLR start "RightCurlyBracket"
    public final void mRightCurlyBracket() throws RecognitionException {
        try {
            int _type = RightCurlyBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:190:19: ( '}' )
            // InternalMyBashLexer.g:190:21: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightCurlyBracket"

    // $ANTLR start "Tilde"
    public final void mTilde() throws RecognitionException {
        try {
            int _type = Tilde;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:192:7: ( '~' )
            // InternalMyBashLexer.g:192:9: '~'
            {
            match('~'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Tilde"

    // $ANTLR start "RULE_I_NUMBER"
    public final void mRULE_I_NUMBER() throws RecognitionException {
        try {
            int _type = RULE_I_NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:196:15: ( ( '0' .. '9' )+ )
            // InternalMyBashLexer.g:196:17: ( '0' .. '9' )+
            {
            // InternalMyBashLexer.g:196:17: ( '0' .. '9' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMyBashLexer.g:196:18: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_I_NUMBER"

    // $ANTLR start "RULE_NEW_LINE"
    public final void mRULE_NEW_LINE() throws RecognitionException {
        try {
            int _type = RULE_NEW_LINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:198:15: ( ( '\\r' )? '\\n' )
            // InternalMyBashLexer.g:198:17: ( '\\r' )? '\\n'
            {
            // InternalMyBashLexer.g:198:17: ( '\\r' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\r') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalMyBashLexer.g:198:17: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NEW_LINE"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:200:9: ( ( ' ' | '\\t' ) )
            // InternalMyBashLexer.g:200:11: ( ' ' | '\\t' )
            {
            if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_HIDEN_NEW_LINE"
    public final void mRULE_HIDEN_NEW_LINE() throws RecognitionException {
        try {
            int _type = RULE_HIDEN_NEW_LINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:202:21: ( '__HIDEN_NEW_LINE__' )
            // InternalMyBashLexer.g:202:23: '__HIDEN_NEW_LINE__'
            {
            match("__HIDEN_NEW_LINE__"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_HIDEN_NEW_LINE"

    // $ANTLR start "RULE_NAME"
    public final void mRULE_NAME() throws RecognitionException {
        try {
            int _type = RULE_NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:204:11: ( '__NAME__' )
            // InternalMyBashLexer.g:204:13: '__NAME__'
            {
            match("__NAME__"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NAME"

    // $ANTLR start "RULE_S_WORD_PART"
    public final void mRULE_S_WORD_PART() throws RecognitionException {
        try {
            int _type = RULE_S_WORD_PART;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:206:18: ( '__S_WORD_PART__' )
            // InternalMyBashLexer.g:206:20: '__S_WORD_PART__'
            {
            match("__S_WORD_PART__"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_S_WORD_PART"

    // $ANTLR start "RULE_WORD_PART"
    public final void mRULE_WORD_PART() throws RecognitionException {
        try {
            int _type = RULE_WORD_PART;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:208:16: ( '__WORD_PART__' )
            // InternalMyBashLexer.g:208:18: '__WORD_PART__'
            {
            match("__WORD_PART__"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WORD_PART"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:210:17: ( '__SL_COMMENT__' )
            // InternalMyBashLexer.g:210:19: '__SL_COMMENT__'
            {
            match("__SL_COMMENT__"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_VARIABLE"
    public final void mRULE_VARIABLE() throws RecognitionException {
        try {
            int _type = RULE_VARIABLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:212:15: ( '__VARIABLE__' )
            // InternalMyBashLexer.g:212:17: '__VARIABLE__'
            {
            match("__VARIABLE__"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_VARIABLE"

    // $ANTLR start "RULE_A_PREFIX"
    public final void mRULE_A_PREFIX() throws RecognitionException {
        try {
            int _type = RULE_A_PREFIX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:214:15: ( '__A_PREFIX__' )
            // InternalMyBashLexer.g:214:17: '__A_PREFIX__'
            {
            match("__A_PREFIX__"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_A_PREFIX"

    // $ANTLR start "RULE_C_S_OP"
    public final void mRULE_C_S_OP() throws RecognitionException {
        try {
            int _type = RULE_C_S_OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:216:13: ( '__C_S_OP__' )
            // InternalMyBashLexer.g:216:15: '__C_S_OP__'
            {
            match("__C_S_OP__"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_C_S_OP"

    // $ANTLR start "RULE_C_B_OP"
    public final void mRULE_C_B_OP() throws RecognitionException {
        try {
            int _type = RULE_C_B_OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:218:13: ( '__C_B_OP__' )
            // InternalMyBashLexer.g:218:15: '__C_B_OP__'
            {
            match("__C_B_OP__"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_C_B_OP"

    // $ANTLR start "RULE_C_LINE"
    public final void mRULE_C_LINE() throws RecognitionException {
        try {
            int _type = RULE_C_LINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:220:13: ( '__C_LINE__' )
            // InternalMyBashLexer.g:220:15: '__C_LINE__'
            {
            match("__C_LINE__"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_C_LINE"

    // $ANTLR start "RULE_CS_START"
    public final void mRULE_CS_START() throws RecognitionException {
        try {
            int _type = RULE_CS_START;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:222:15: ( '__CS_START__' )
            // InternalMyBashLexer.g:222:17: '__CS_START__'
            {
            match("__CS_START__"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_CS_START"

    // $ANTLR start "RULE_CS_END"
    public final void mRULE_CS_END() throws RecognitionException {
        try {
            int _type = RULE_CS_END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:224:13: ( '__CS_END__' )
            // InternalMyBashLexer.g:224:15: '__CS_END__'
            {
            match("__CS_END__"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_CS_END"

    // $ANTLR start "RULE_HERE_DOC_WORD"
    public final void mRULE_HERE_DOC_WORD() throws RecognitionException {
        try {
            int _type = RULE_HERE_DOC_WORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:226:20: ( '__HERE_DOC_WORD__' )
            // InternalMyBashLexer.g:226:22: '__HERE_DOC_WORD__'
            {
            match("__HERE_DOC_WORD__"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_HERE_DOC_WORD"

    // $ANTLR start "RULE_HERE_DOC_START"
    public final void mRULE_HERE_DOC_START() throws RecognitionException {
        try {
            int _type = RULE_HERE_DOC_START;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:228:21: ( '__HERE_DOC_START__' )
            // InternalMyBashLexer.g:228:23: '__HERE_DOC_START__'
            {
            match("__HERE_DOC_START__"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_HERE_DOC_START"

    // $ANTLR start "RULE_HERE_DOC_END"
    public final void mRULE_HERE_DOC_END() throws RecognitionException {
        try {
            int _type = RULE_HERE_DOC_END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:230:19: ( '__HERE_DOC_END__' )
            // InternalMyBashLexer.g:230:21: '__HERE_DOC_END__'
            {
            match("__HERE_DOC_END__"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_HERE_DOC_END"

    // $ANTLR start "RULE_HERE_DOC_PART"
    public final void mRULE_HERE_DOC_PART() throws RecognitionException {
        try {
            int _type = RULE_HERE_DOC_PART;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyBashLexer.g:232:20: ( '__HERE_DOC_PART__' )
            // InternalMyBashLexer.g:232:22: '__HERE_DOC_PART__'
            {
            match("__HERE_DOC_PART__"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_HERE_DOC_PART"

    public void mTokens() throws RecognitionException {
        // InternalMyBashLexer.g:1:8: ( Function | While | Case | Done | Elif | Else | Esac | Then | DollarSignLeftParenthesisLeftParenthesis | AmpersandGreaterThanSignGreaterThanSign | SemicolonSemicolonAmpersand | LessThanSignLessThanSignEqualsSign | GreaterThanSignGreaterThanSignEqualsSign | For | ExclamationMarkEqualsSign | NumberSignNumberSign | DollarSignLeftCurlyBracket | PercentSignPercentSign | PercentSignEqualsSign | AmpersandAmpersand | AmpersandEqualsSign | AmpersandGreaterThanSign | LeftParenthesisLeftParenthesis | RightParenthesisRightParenthesis | AsteriskAsterisk | AsteriskEqualsSign | PlusSignPlusSign | PlusSignEqualsSign | CommaComma | HyphenMinusHyphenMinus | HyphenMinusEqualsSign | SolidusSolidus | SolidusEqualsSign | ColonPlusSign | ColonHyphenMinus | ColonEqualsSign | ColonQuestionMark | SemicolonAmpersand | SemicolonSemicolon | LessThanSignAmpersand | LessThanSignLeftParenthesis | LessThanSignLessThanSign | LessThanSignEqualsSign | LessThanSignGreaterThanSign | LessThanSignVerticalLine | EqualsSignEqualsSign | EqualsSignTilde | GreaterThanSignAmpersand | GreaterThanSignLeftParenthesis | GreaterThanSignEqualsSign | GreaterThanSignGreaterThanSign | GreaterThanSignVerticalLine | LeftSquareBracketLeftSquareBracket | RightSquareBracketRightSquareBracket | CircumflexAccentEqualsSign | CircumflexAccentCircumflexAccent | Do | Fi | If | In | VerticalLineAmpersand | VerticalLineEqualsSign | VerticalLineVerticalLine | ExclamationMark | QuotationMark | NumberSign | PercentSign | Ampersand | Apostrophe | LeftParenthesis | RightParenthesis | Asterisk | PlusSign | Comma | HyphenMinus | Solidus | Colon | Semicolon | LessThanSign | EqualsSign | GreaterThanSign | QuestionMark | CommercialAt | LeftSquareBracket | RightSquareBracket | CircumflexAccent | LeftCurlyBracket | VerticalLine | RightCurlyBracket | Tilde | RULE_I_NUMBER | RULE_NEW_LINE | RULE_WS | RULE_HIDEN_NEW_LINE | RULE_NAME | RULE_S_WORD_PART | RULE_WORD_PART | RULE_SL_COMMENT | RULE_VARIABLE | RULE_A_PREFIX | RULE_C_S_OP | RULE_C_B_OP | RULE_C_LINE | RULE_CS_START | RULE_CS_END | RULE_HERE_DOC_WORD | RULE_HERE_DOC_START | RULE_HERE_DOC_END | RULE_HERE_DOC_PART )
        int alt3=109;
        alt3 = dfa3.predict(input);
        switch (alt3) {
            case 1 :
                // InternalMyBashLexer.g:1:10: Function
                {
                mFunction(); 

                }
                break;
            case 2 :
                // InternalMyBashLexer.g:1:19: While
                {
                mWhile(); 

                }
                break;
            case 3 :
                // InternalMyBashLexer.g:1:25: Case
                {
                mCase(); 

                }
                break;
            case 4 :
                // InternalMyBashLexer.g:1:30: Done
                {
                mDone(); 

                }
                break;
            case 5 :
                // InternalMyBashLexer.g:1:35: Elif
                {
                mElif(); 

                }
                break;
            case 6 :
                // InternalMyBashLexer.g:1:40: Else
                {
                mElse(); 

                }
                break;
            case 7 :
                // InternalMyBashLexer.g:1:45: Esac
                {
                mEsac(); 

                }
                break;
            case 8 :
                // InternalMyBashLexer.g:1:50: Then
                {
                mThen(); 

                }
                break;
            case 9 :
                // InternalMyBashLexer.g:1:55: DollarSignLeftParenthesisLeftParenthesis
                {
                mDollarSignLeftParenthesisLeftParenthesis(); 

                }
                break;
            case 10 :
                // InternalMyBashLexer.g:1:96: AmpersandGreaterThanSignGreaterThanSign
                {
                mAmpersandGreaterThanSignGreaterThanSign(); 

                }
                break;
            case 11 :
                // InternalMyBashLexer.g:1:136: SemicolonSemicolonAmpersand
                {
                mSemicolonSemicolonAmpersand(); 

                }
                break;
            case 12 :
                // InternalMyBashLexer.g:1:164: LessThanSignLessThanSignEqualsSign
                {
                mLessThanSignLessThanSignEqualsSign(); 

                }
                break;
            case 13 :
                // InternalMyBashLexer.g:1:199: GreaterThanSignGreaterThanSignEqualsSign
                {
                mGreaterThanSignGreaterThanSignEqualsSign(); 

                }
                break;
            case 14 :
                // InternalMyBashLexer.g:1:240: For
                {
                mFor(); 

                }
                break;
            case 15 :
                // InternalMyBashLexer.g:1:244: ExclamationMarkEqualsSign
                {
                mExclamationMarkEqualsSign(); 

                }
                break;
            case 16 :
                // InternalMyBashLexer.g:1:270: NumberSignNumberSign
                {
                mNumberSignNumberSign(); 

                }
                break;
            case 17 :
                // InternalMyBashLexer.g:1:291: DollarSignLeftCurlyBracket
                {
                mDollarSignLeftCurlyBracket(); 

                }
                break;
            case 18 :
                // InternalMyBashLexer.g:1:318: PercentSignPercentSign
                {
                mPercentSignPercentSign(); 

                }
                break;
            case 19 :
                // InternalMyBashLexer.g:1:341: PercentSignEqualsSign
                {
                mPercentSignEqualsSign(); 

                }
                break;
            case 20 :
                // InternalMyBashLexer.g:1:363: AmpersandAmpersand
                {
                mAmpersandAmpersand(); 

                }
                break;
            case 21 :
                // InternalMyBashLexer.g:1:382: AmpersandEqualsSign
                {
                mAmpersandEqualsSign(); 

                }
                break;
            case 22 :
                // InternalMyBashLexer.g:1:402: AmpersandGreaterThanSign
                {
                mAmpersandGreaterThanSign(); 

                }
                break;
            case 23 :
                // InternalMyBashLexer.g:1:427: LeftParenthesisLeftParenthesis
                {
                mLeftParenthesisLeftParenthesis(); 

                }
                break;
            case 24 :
                // InternalMyBashLexer.g:1:458: RightParenthesisRightParenthesis
                {
                mRightParenthesisRightParenthesis(); 

                }
                break;
            case 25 :
                // InternalMyBashLexer.g:1:491: AsteriskAsterisk
                {
                mAsteriskAsterisk(); 

                }
                break;
            case 26 :
                // InternalMyBashLexer.g:1:508: AsteriskEqualsSign
                {
                mAsteriskEqualsSign(); 

                }
                break;
            case 27 :
                // InternalMyBashLexer.g:1:527: PlusSignPlusSign
                {
                mPlusSignPlusSign(); 

                }
                break;
            case 28 :
                // InternalMyBashLexer.g:1:544: PlusSignEqualsSign
                {
                mPlusSignEqualsSign(); 

                }
                break;
            case 29 :
                // InternalMyBashLexer.g:1:563: CommaComma
                {
                mCommaComma(); 

                }
                break;
            case 30 :
                // InternalMyBashLexer.g:1:574: HyphenMinusHyphenMinus
                {
                mHyphenMinusHyphenMinus(); 

                }
                break;
            case 31 :
                // InternalMyBashLexer.g:1:597: HyphenMinusEqualsSign
                {
                mHyphenMinusEqualsSign(); 

                }
                break;
            case 32 :
                // InternalMyBashLexer.g:1:619: SolidusSolidus
                {
                mSolidusSolidus(); 

                }
                break;
            case 33 :
                // InternalMyBashLexer.g:1:634: SolidusEqualsSign
                {
                mSolidusEqualsSign(); 

                }
                break;
            case 34 :
                // InternalMyBashLexer.g:1:652: ColonPlusSign
                {
                mColonPlusSign(); 

                }
                break;
            case 35 :
                // InternalMyBashLexer.g:1:666: ColonHyphenMinus
                {
                mColonHyphenMinus(); 

                }
                break;
            case 36 :
                // InternalMyBashLexer.g:1:683: ColonEqualsSign
                {
                mColonEqualsSign(); 

                }
                break;
            case 37 :
                // InternalMyBashLexer.g:1:699: ColonQuestionMark
                {
                mColonQuestionMark(); 

                }
                break;
            case 38 :
                // InternalMyBashLexer.g:1:717: SemicolonAmpersand
                {
                mSemicolonAmpersand(); 

                }
                break;
            case 39 :
                // InternalMyBashLexer.g:1:736: SemicolonSemicolon
                {
                mSemicolonSemicolon(); 

                }
                break;
            case 40 :
                // InternalMyBashLexer.g:1:755: LessThanSignAmpersand
                {
                mLessThanSignAmpersand(); 

                }
                break;
            case 41 :
                // InternalMyBashLexer.g:1:777: LessThanSignLeftParenthesis
                {
                mLessThanSignLeftParenthesis(); 

                }
                break;
            case 42 :
                // InternalMyBashLexer.g:1:805: LessThanSignLessThanSign
                {
                mLessThanSignLessThanSign(); 

                }
                break;
            case 43 :
                // InternalMyBashLexer.g:1:830: LessThanSignEqualsSign
                {
                mLessThanSignEqualsSign(); 

                }
                break;
            case 44 :
                // InternalMyBashLexer.g:1:853: LessThanSignGreaterThanSign
                {
                mLessThanSignGreaterThanSign(); 

                }
                break;
            case 45 :
                // InternalMyBashLexer.g:1:881: LessThanSignVerticalLine
                {
                mLessThanSignVerticalLine(); 

                }
                break;
            case 46 :
                // InternalMyBashLexer.g:1:906: EqualsSignEqualsSign
                {
                mEqualsSignEqualsSign(); 

                }
                break;
            case 47 :
                // InternalMyBashLexer.g:1:927: EqualsSignTilde
                {
                mEqualsSignTilde(); 

                }
                break;
            case 48 :
                // InternalMyBashLexer.g:1:943: GreaterThanSignAmpersand
                {
                mGreaterThanSignAmpersand(); 

                }
                break;
            case 49 :
                // InternalMyBashLexer.g:1:968: GreaterThanSignLeftParenthesis
                {
                mGreaterThanSignLeftParenthesis(); 

                }
                break;
            case 50 :
                // InternalMyBashLexer.g:1:999: GreaterThanSignEqualsSign
                {
                mGreaterThanSignEqualsSign(); 

                }
                break;
            case 51 :
                // InternalMyBashLexer.g:1:1025: GreaterThanSignGreaterThanSign
                {
                mGreaterThanSignGreaterThanSign(); 

                }
                break;
            case 52 :
                // InternalMyBashLexer.g:1:1056: GreaterThanSignVerticalLine
                {
                mGreaterThanSignVerticalLine(); 

                }
                break;
            case 53 :
                // InternalMyBashLexer.g:1:1084: LeftSquareBracketLeftSquareBracket
                {
                mLeftSquareBracketLeftSquareBracket(); 

                }
                break;
            case 54 :
                // InternalMyBashLexer.g:1:1119: RightSquareBracketRightSquareBracket
                {
                mRightSquareBracketRightSquareBracket(); 

                }
                break;
            case 55 :
                // InternalMyBashLexer.g:1:1156: CircumflexAccentEqualsSign
                {
                mCircumflexAccentEqualsSign(); 

                }
                break;
            case 56 :
                // InternalMyBashLexer.g:1:1183: CircumflexAccentCircumflexAccent
                {
                mCircumflexAccentCircumflexAccent(); 

                }
                break;
            case 57 :
                // InternalMyBashLexer.g:1:1216: Do
                {
                mDo(); 

                }
                break;
            case 58 :
                // InternalMyBashLexer.g:1:1219: Fi
                {
                mFi(); 

                }
                break;
            case 59 :
                // InternalMyBashLexer.g:1:1222: If
                {
                mIf(); 

                }
                break;
            case 60 :
                // InternalMyBashLexer.g:1:1225: In
                {
                mIn(); 

                }
                break;
            case 61 :
                // InternalMyBashLexer.g:1:1228: VerticalLineAmpersand
                {
                mVerticalLineAmpersand(); 

                }
                break;
            case 62 :
                // InternalMyBashLexer.g:1:1250: VerticalLineEqualsSign
                {
                mVerticalLineEqualsSign(); 

                }
                break;
            case 63 :
                // InternalMyBashLexer.g:1:1273: VerticalLineVerticalLine
                {
                mVerticalLineVerticalLine(); 

                }
                break;
            case 64 :
                // InternalMyBashLexer.g:1:1298: ExclamationMark
                {
                mExclamationMark(); 

                }
                break;
            case 65 :
                // InternalMyBashLexer.g:1:1314: QuotationMark
                {
                mQuotationMark(); 

                }
                break;
            case 66 :
                // InternalMyBashLexer.g:1:1328: NumberSign
                {
                mNumberSign(); 

                }
                break;
            case 67 :
                // InternalMyBashLexer.g:1:1339: PercentSign
                {
                mPercentSign(); 

                }
                break;
            case 68 :
                // InternalMyBashLexer.g:1:1351: Ampersand
                {
                mAmpersand(); 

                }
                break;
            case 69 :
                // InternalMyBashLexer.g:1:1361: Apostrophe
                {
                mApostrophe(); 

                }
                break;
            case 70 :
                // InternalMyBashLexer.g:1:1372: LeftParenthesis
                {
                mLeftParenthesis(); 

                }
                break;
            case 71 :
                // InternalMyBashLexer.g:1:1388: RightParenthesis
                {
                mRightParenthesis(); 

                }
                break;
            case 72 :
                // InternalMyBashLexer.g:1:1405: Asterisk
                {
                mAsterisk(); 

                }
                break;
            case 73 :
                // InternalMyBashLexer.g:1:1414: PlusSign
                {
                mPlusSign(); 

                }
                break;
            case 74 :
                // InternalMyBashLexer.g:1:1423: Comma
                {
                mComma(); 

                }
                break;
            case 75 :
                // InternalMyBashLexer.g:1:1429: HyphenMinus
                {
                mHyphenMinus(); 

                }
                break;
            case 76 :
                // InternalMyBashLexer.g:1:1441: Solidus
                {
                mSolidus(); 

                }
                break;
            case 77 :
                // InternalMyBashLexer.g:1:1449: Colon
                {
                mColon(); 

                }
                break;
            case 78 :
                // InternalMyBashLexer.g:1:1455: Semicolon
                {
                mSemicolon(); 

                }
                break;
            case 79 :
                // InternalMyBashLexer.g:1:1465: LessThanSign
                {
                mLessThanSign(); 

                }
                break;
            case 80 :
                // InternalMyBashLexer.g:1:1478: EqualsSign
                {
                mEqualsSign(); 

                }
                break;
            case 81 :
                // InternalMyBashLexer.g:1:1489: GreaterThanSign
                {
                mGreaterThanSign(); 

                }
                break;
            case 82 :
                // InternalMyBashLexer.g:1:1505: QuestionMark
                {
                mQuestionMark(); 

                }
                break;
            case 83 :
                // InternalMyBashLexer.g:1:1518: CommercialAt
                {
                mCommercialAt(); 

                }
                break;
            case 84 :
                // InternalMyBashLexer.g:1:1531: LeftSquareBracket
                {
                mLeftSquareBracket(); 

                }
                break;
            case 85 :
                // InternalMyBashLexer.g:1:1549: RightSquareBracket
                {
                mRightSquareBracket(); 

                }
                break;
            case 86 :
                // InternalMyBashLexer.g:1:1568: CircumflexAccent
                {
                mCircumflexAccent(); 

                }
                break;
            case 87 :
                // InternalMyBashLexer.g:1:1585: LeftCurlyBracket
                {
                mLeftCurlyBracket(); 

                }
                break;
            case 88 :
                // InternalMyBashLexer.g:1:1602: VerticalLine
                {
                mVerticalLine(); 

                }
                break;
            case 89 :
                // InternalMyBashLexer.g:1:1615: RightCurlyBracket
                {
                mRightCurlyBracket(); 

                }
                break;
            case 90 :
                // InternalMyBashLexer.g:1:1633: Tilde
                {
                mTilde(); 

                }
                break;
            case 91 :
                // InternalMyBashLexer.g:1:1639: RULE_I_NUMBER
                {
                mRULE_I_NUMBER(); 

                }
                break;
            case 92 :
                // InternalMyBashLexer.g:1:1653: RULE_NEW_LINE
                {
                mRULE_NEW_LINE(); 

                }
                break;
            case 93 :
                // InternalMyBashLexer.g:1:1667: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 94 :
                // InternalMyBashLexer.g:1:1675: RULE_HIDEN_NEW_LINE
                {
                mRULE_HIDEN_NEW_LINE(); 

                }
                break;
            case 95 :
                // InternalMyBashLexer.g:1:1695: RULE_NAME
                {
                mRULE_NAME(); 

                }
                break;
            case 96 :
                // InternalMyBashLexer.g:1:1705: RULE_S_WORD_PART
                {
                mRULE_S_WORD_PART(); 

                }
                break;
            case 97 :
                // InternalMyBashLexer.g:1:1722: RULE_WORD_PART
                {
                mRULE_WORD_PART(); 

                }
                break;
            case 98 :
                // InternalMyBashLexer.g:1:1737: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 99 :
                // InternalMyBashLexer.g:1:1753: RULE_VARIABLE
                {
                mRULE_VARIABLE(); 

                }
                break;
            case 100 :
                // InternalMyBashLexer.g:1:1767: RULE_A_PREFIX
                {
                mRULE_A_PREFIX(); 

                }
                break;
            case 101 :
                // InternalMyBashLexer.g:1:1781: RULE_C_S_OP
                {
                mRULE_C_S_OP(); 

                }
                break;
            case 102 :
                // InternalMyBashLexer.g:1:1793: RULE_C_B_OP
                {
                mRULE_C_B_OP(); 

                }
                break;
            case 103 :
                // InternalMyBashLexer.g:1:1805: RULE_C_LINE
                {
                mRULE_C_LINE(); 

                }
                break;
            case 104 :
                // InternalMyBashLexer.g:1:1817: RULE_CS_START
                {
                mRULE_CS_START(); 

                }
                break;
            case 105 :
                // InternalMyBashLexer.g:1:1831: RULE_CS_END
                {
                mRULE_CS_END(); 

                }
                break;
            case 106 :
                // InternalMyBashLexer.g:1:1843: RULE_HERE_DOC_WORD
                {
                mRULE_HERE_DOC_WORD(); 

                }
                break;
            case 107 :
                // InternalMyBashLexer.g:1:1862: RULE_HERE_DOC_START
                {
                mRULE_HERE_DOC_START(); 

                }
                break;
            case 108 :
                // InternalMyBashLexer.g:1:1882: RULE_HERE_DOC_END
                {
                mRULE_HERE_DOC_END(); 

                }
                break;
            case 109 :
                // InternalMyBashLexer.g:1:1900: RULE_HERE_DOC_PART
                {
                mRULE_HERE_DOC_PART(); 

                }
                break;

        }

    }


    protected DFA3 dfa3 = new DFA3(this);
    static final String DFA3_eotS =
        "\10\uffff\1\63\1\66\1\75\1\103\1\105\1\107\1\112\1\114\1\116\1\121\1\124\1\126\1\131\1\134\1\141\1\144\1\146\1\150\1\153\1\uffff\1\161\16\uffff\1\164\4\uffff\1\170\3\uffff\1\172\2\uffff\1\174\6\uffff\1\176\136\uffff";
    static final String DFA3_eofS =
        "\u009d\uffff";
    static final String DFA3_minS =
        "\1\11\1\151\2\uffff\1\157\1\154\1\uffff\1\50\4\46\1\75\1\43\1\45\1\50\1\51\1\52\1\53\1\54\1\55\1\57\1\53\1\75\1\133\1\135\1\75\1\146\1\46\12\uffff\1\137\3\uffff\1\156\1\151\3\uffff\1\76\3\uffff\1\46\2\uffff\1\75\6\uffff\1\75\63\uffff\1\101\14\uffff\1\105\1\uffff\1\114\3\uffff\1\123\1\uffff\1\122\2\uffff\1\102\1\137\1\105\3\uffff\1\105\1\137\2\uffff\1\104\1\117\1\103\1\137\1\105\4\uffff";
    static final String DFA3_maxS =
        "\1\176\1\165\2\uffff\1\157\1\163\1\uffff\1\173\1\76\1\73\2\174\1\75\1\43\1\75\1\50\1\51\2\75\1\54\2\75\1\77\1\176\1\133\1\135\1\136\1\156\1\174\12\uffff\1\137\3\uffff\1\156\1\163\3\uffff\1\76\3\uffff\1\46\2\uffff\1\75\6\uffff\1\75\63\uffff\1\127\14\uffff\1\111\1\uffff\1\137\3\uffff\1\137\1\uffff\1\122\2\uffff\1\123\1\137\1\105\3\uffff\1\123\1\137\2\uffff\1\104\1\117\1\103\1\137\1\127\4\uffff";
    static final String DFA3_acceptS =
        "\2\uffff\1\2\1\3\2\uffff\1\10\26\uffff\1\101\1\105\1\122\1\123\1\127\1\131\1\132\1\133\1\134\1\135\1\uffff\1\1\1\16\1\72\2\uffff\1\7\1\11\1\21\1\uffff\1\24\1\25\1\104\1\uffff\1\46\1\116\1\uffff\1\50\1\51\1\53\1\54\1\55\1\117\1\uffff\1\60\1\61\1\62\1\64\1\121\1\17\1\100\1\20\1\102\1\22\1\23\1\103\1\27\1\106\1\30\1\107\1\31\1\32\1\110\1\33\1\34\1\111\1\35\1\112\1\36\1\37\1\113\1\40\1\41\1\114\1\42\1\43\1\44\1\45\1\115\1\56\1\57\1\120\1\65\1\124\1\66\1\125\1\67\1\70\1\126\1\73\1\74\1\75\1\76\1\77\1\130\1\uffff\1\4\1\71\1\5\1\6\1\12\1\26\1\13\1\47\1\14\1\52\1\15\1\63\1\uffff\1\137\1\uffff\1\141\1\143\1\144\1\uffff\1\136\1\uffff\1\140\1\142\3\uffff\1\145\1\146\1\147\2\uffff\1\150\1\151\5\uffff\1\152\1\153\1\154\1\155";
    static final String DFA3_specialS =
        "\u009d\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\46\1\45\2\uffff\1\45\22\uffff\1\46\1\14\1\35\1\15\1\7\1\16\1\10\1\36\1\17\1\20\1\21\1\22\1\23\1\24\1\uffff\1\25\12\44\1\26\1\11\1\12\1\27\1\13\1\37\1\40\32\uffff\1\30\1\uffff\1\31\1\32\1\47\3\uffff\1\3\1\4\1\5\1\1\2\uffff\1\33\12\uffff\1\6\2\uffff\1\2\3\uffff\1\41\1\34\1\42\1\43",
            "\1\52\5\uffff\1\51\5\uffff\1\50",
            "",
            "",
            "\1\53",
            "\1\54\6\uffff\1\55",
            "",
            "\1\56\122\uffff\1\57",
            "\1\61\26\uffff\1\62\1\60",
            "\1\65\24\uffff\1\64",
            "\1\70\1\uffff\1\71\23\uffff\1\67\1\72\1\73\75\uffff\1\74",
            "\1\77\1\uffff\1\100\24\uffff\1\101\1\76\75\uffff\1\102",
            "\1\104",
            "\1\106",
            "\1\110\27\uffff\1\111",
            "\1\113",
            "\1\115",
            "\1\117\22\uffff\1\120",
            "\1\122\21\uffff\1\123",
            "\1\125",
            "\1\127\17\uffff\1\130",
            "\1\132\15\uffff\1\133",
            "\1\135\1\uffff\1\136\17\uffff\1\137\1\uffff\1\140",
            "\1\142\100\uffff\1\143",
            "\1\145",
            "\1\147",
            "\1\151\40\uffff\1\152",
            "\1\154\7\uffff\1\155",
            "\1\156\26\uffff\1\157\76\uffff\1\160",
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
            "\1\162",
            "",
            "",
            "",
            "\1\163",
            "\1\165\11\uffff\1\166",
            "",
            "",
            "",
            "\1\167",
            "",
            "",
            "",
            "\1\171",
            "",
            "",
            "\1\173",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\175",
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
            "\1\u0084\1\uffff\1\u0085\4\uffff\1\177\5\uffff\1\u0080\4\uffff\1\u0081\2\uffff\1\u0083\1\u0082",
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
            "\1\u0087\3\uffff\1\u0086",
            "",
            "\1\u0089\22\uffff\1\u0088",
            "",
            "",
            "",
            "\1\u008b\13\uffff\1\u008a",
            "",
            "\1\u008c",
            "",
            "",
            "\1\u008e\11\uffff\1\u008f\6\uffff\1\u008d",
            "\1\u0090",
            "\1\u0091",
            "",
            "",
            "",
            "\1\u0093\15\uffff\1\u0092",
            "\1\u0094",
            "",
            "",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u009b\12\uffff\1\u009c\2\uffff\1\u009a\3\uffff\1\u0099",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( Function | While | Case | Done | Elif | Else | Esac | Then | DollarSignLeftParenthesisLeftParenthesis | AmpersandGreaterThanSignGreaterThanSign | SemicolonSemicolonAmpersand | LessThanSignLessThanSignEqualsSign | GreaterThanSignGreaterThanSignEqualsSign | For | ExclamationMarkEqualsSign | NumberSignNumberSign | DollarSignLeftCurlyBracket | PercentSignPercentSign | PercentSignEqualsSign | AmpersandAmpersand | AmpersandEqualsSign | AmpersandGreaterThanSign | LeftParenthesisLeftParenthesis | RightParenthesisRightParenthesis | AsteriskAsterisk | AsteriskEqualsSign | PlusSignPlusSign | PlusSignEqualsSign | CommaComma | HyphenMinusHyphenMinus | HyphenMinusEqualsSign | SolidusSolidus | SolidusEqualsSign | ColonPlusSign | ColonHyphenMinus | ColonEqualsSign | ColonQuestionMark | SemicolonAmpersand | SemicolonSemicolon | LessThanSignAmpersand | LessThanSignLeftParenthesis | LessThanSignLessThanSign | LessThanSignEqualsSign | LessThanSignGreaterThanSign | LessThanSignVerticalLine | EqualsSignEqualsSign | EqualsSignTilde | GreaterThanSignAmpersand | GreaterThanSignLeftParenthesis | GreaterThanSignEqualsSign | GreaterThanSignGreaterThanSign | GreaterThanSignVerticalLine | LeftSquareBracketLeftSquareBracket | RightSquareBracketRightSquareBracket | CircumflexAccentEqualsSign | CircumflexAccentCircumflexAccent | Do | Fi | If | In | VerticalLineAmpersand | VerticalLineEqualsSign | VerticalLineVerticalLine | ExclamationMark | QuotationMark | NumberSign | PercentSign | Ampersand | Apostrophe | LeftParenthesis | RightParenthesis | Asterisk | PlusSign | Comma | HyphenMinus | Solidus | Colon | Semicolon | LessThanSign | EqualsSign | GreaterThanSign | QuestionMark | CommercialAt | LeftSquareBracket | RightSquareBracket | CircumflexAccent | LeftCurlyBracket | VerticalLine | RightCurlyBracket | Tilde | RULE_I_NUMBER | RULE_NEW_LINE | RULE_WS | RULE_HIDEN_NEW_LINE | RULE_NAME | RULE_S_WORD_PART | RULE_WORD_PART | RULE_SL_COMMENT | RULE_VARIABLE | RULE_A_PREFIX | RULE_C_S_OP | RULE_C_B_OP | RULE_C_LINE | RULE_CS_START | RULE_CS_END | RULE_HERE_DOC_WORD | RULE_HERE_DOC_START | RULE_HERE_DOC_END | RULE_HERE_DOC_PART );";
        }
    }
 

}