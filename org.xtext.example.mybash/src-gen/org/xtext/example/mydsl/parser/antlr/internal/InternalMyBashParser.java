package org.xtext.example.mydsl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.example.mydsl.services.MyBashGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalMyBashParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Function", "While", "Case", "Done", "Elif", "Else", "Esac", "Then", "DollarSignLeftParenthesisLeftParenthesis", "AmpersandGreaterThanSignGreaterThanSign", "SemicolonSemicolonAmpersand", "LessThanSignLessThanSignEqualsSign", "GreaterThanSignGreaterThanSignEqualsSign", "For", "ExclamationMarkEqualsSign", "NumberSignNumberSign", "DollarSignLeftCurlyBracket", "PercentSignPercentSign", "PercentSignEqualsSign", "AmpersandAmpersand", "AmpersandEqualsSign", "AmpersandGreaterThanSign", "LeftParenthesisLeftParenthesis", "RightParenthesisRightParenthesis", "AsteriskAsterisk", "AsteriskEqualsSign", "PlusSignPlusSign", "PlusSignEqualsSign", "CommaComma", "HyphenMinusHyphenMinus", "HyphenMinusEqualsSign", "SolidusSolidus", "SolidusEqualsSign", "ColonPlusSign", "ColonHyphenMinus", "ColonEqualsSign", "ColonQuestionMark", "SemicolonAmpersand", "SemicolonSemicolon", "LessThanSignAmpersand", "LessThanSignLeftParenthesis", "LessThanSignLessThanSign", "LessThanSignEqualsSign", "LessThanSignGreaterThanSign", "LessThanSignVerticalLine", "EqualsSignEqualsSign", "EqualsSignTilde", "GreaterThanSignAmpersand", "GreaterThanSignLeftParenthesis", "GreaterThanSignEqualsSign", "GreaterThanSignGreaterThanSign", "GreaterThanSignVerticalLine", "LeftSquareBracketLeftSquareBracket", "RightSquareBracketRightSquareBracket", "CircumflexAccentEqualsSign", "CircumflexAccentCircumflexAccent", "Do", "Fi", "If", "In", "VerticalLineAmpersand", "VerticalLineEqualsSign", "VerticalLineVerticalLine", "ExclamationMark", "QuotationMark", "NumberSign", "PercentSign", "Ampersand", "Apostrophe", "LeftParenthesis", "RightParenthesis", "Asterisk", "PlusSign", "Comma", "HyphenMinus", "Solidus", "Colon", "Semicolon", "LessThanSign", "EqualsSign", "GreaterThanSign", "QuestionMark", "CommercialAt", "LeftSquareBracket", "RightSquareBracket", "CircumflexAccent", "LeftCurlyBracket", "VerticalLine", "RightCurlyBracket", "Tilde", "RULE_I_NUMBER", "RULE_NEW_LINE", "RULE_WS", "RULE_HIDEN_NEW_LINE", "RULE_NAME", "RULE_S_WORD_PART", "RULE_WORD_PART", "RULE_SL_COMMENT", "RULE_VARIABLE", "RULE_A_PREFIX", "RULE_C_S_OP", "RULE_C_B_OP", "RULE_C_LINE", "RULE_CS_START", "RULE_CS_END", "RULE_HERE_DOC_WORD", "RULE_HERE_DOC_START", "RULE_HERE_DOC_END", "RULE_HERE_DOC_PART"
    };
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


        public InternalMyBashParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMyBashParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMyBashParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMyBashParser.g"; }



     	private MyBashGrammarAccess grammarAccess;

        public InternalMyBashParser(TokenStream input, MyBashGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Bash";
       	}

       	@Override
       	protected MyBashGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleBash"
    // InternalMyBashParser.g:58:1: entryRuleBash returns [EObject current=null] : iv_ruleBash= ruleBash EOF ;
    public final EObject entryRuleBash() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBash = null;


        try {
            // InternalMyBashParser.g:58:45: (iv_ruleBash= ruleBash EOF )
            // InternalMyBashParser.g:59:2: iv_ruleBash= ruleBash EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBashRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBash=ruleBash();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBash; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBash"


    // $ANTLR start "ruleBash"
    // InternalMyBashParser.g:65:1: ruleBash returns [EObject current=null] : ( ( () ruleMaybeNewLine ( ( (lv_commands_2_0= ruleSimpleList ) ) ( ruleNewLine ( (lv_commands_4_0= ruleSimpleList ) ) )* ruleMaybeNewLine )? ) | (this_WS_6= RULE_WS ( ( (lv_error_7_0= ruleWord ) ) | ( (lv_error_8_0= ruleAssignment ) ) ) this_WS_9= RULE_WS ) ) ;
    public final EObject ruleBash() throws RecognitionException {
        EObject current = null;

        Token this_WS_6=null;
        Token this_WS_9=null;
        EObject lv_commands_2_0 = null;

        EObject lv_commands_4_0 = null;

        EObject lv_error_7_0 = null;

        EObject lv_error_8_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:71:2: ( ( ( () ruleMaybeNewLine ( ( (lv_commands_2_0= ruleSimpleList ) ) ( ruleNewLine ( (lv_commands_4_0= ruleSimpleList ) ) )* ruleMaybeNewLine )? ) | (this_WS_6= RULE_WS ( ( (lv_error_7_0= ruleWord ) ) | ( (lv_error_8_0= ruleAssignment ) ) ) this_WS_9= RULE_WS ) ) )
            // InternalMyBashParser.g:72:2: ( ( () ruleMaybeNewLine ( ( (lv_commands_2_0= ruleSimpleList ) ) ( ruleNewLine ( (lv_commands_4_0= ruleSimpleList ) ) )* ruleMaybeNewLine )? ) | (this_WS_6= RULE_WS ( ( (lv_error_7_0= ruleWord ) ) | ( (lv_error_8_0= ruleAssignment ) ) ) this_WS_9= RULE_WS ) )
            {
            // InternalMyBashParser.g:72:2: ( ( () ruleMaybeNewLine ( ( (lv_commands_2_0= ruleSimpleList ) ) ( ruleNewLine ( (lv_commands_4_0= ruleSimpleList ) ) )* ruleMaybeNewLine )? ) | (this_WS_6= RULE_WS ( ( (lv_error_7_0= ruleWord ) ) | ( (lv_error_8_0= ruleAssignment ) ) ) this_WS_9= RULE_WS ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==EOF||(LA4_0>=Function && LA4_0<=SemicolonSemicolonAmpersand)||LA4_0==For||LA4_0==DollarSignLeftCurlyBracket||(LA4_0>=AmpersandGreaterThanSign && LA4_0<=LeftParenthesisLeftParenthesis)||(LA4_0>=SemicolonAmpersand && LA4_0<=LessThanSignLessThanSign)||(LA4_0>=LessThanSignGreaterThanSign && LA4_0<=LessThanSignVerticalLine)||(LA4_0>=GreaterThanSignAmpersand && LA4_0<=GreaterThanSignLeftParenthesis)||(LA4_0>=GreaterThanSignGreaterThanSign && LA4_0<=LeftSquareBracketLeftSquareBracket)||(LA4_0>=Do && LA4_0<=In)||(LA4_0>=ExclamationMark && LA4_0<=QuotationMark)||(LA4_0>=Apostrophe && LA4_0<=RightParenthesis)||LA4_0==LessThanSign||LA4_0==GreaterThanSign||LA4_0==LeftCurlyBracket||LA4_0==RightCurlyBracket||(LA4_0>=RULE_I_NUMBER && LA4_0<=RULE_NEW_LINE)||(LA4_0>=RULE_NAME && LA4_0<=RULE_WORD_PART)||LA4_0==RULE_VARIABLE||(LA4_0>=RULE_CS_START && LA4_0<=RULE_CS_END)||LA4_0==RULE_HERE_DOC_START) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_WS) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalMyBashParser.g:73:3: ( () ruleMaybeNewLine ( ( (lv_commands_2_0= ruleSimpleList ) ) ( ruleNewLine ( (lv_commands_4_0= ruleSimpleList ) ) )* ruleMaybeNewLine )? )
                    {
                    // InternalMyBashParser.g:73:3: ( () ruleMaybeNewLine ( ( (lv_commands_2_0= ruleSimpleList ) ) ( ruleNewLine ( (lv_commands_4_0= ruleSimpleList ) ) )* ruleMaybeNewLine )? )
                    // InternalMyBashParser.g:74:4: () ruleMaybeNewLine ( ( (lv_commands_2_0= ruleSimpleList ) ) ( ruleNewLine ( (lv_commands_4_0= ruleSimpleList ) ) )* ruleMaybeNewLine )?
                    {
                    // InternalMyBashParser.g:74:4: ()
                    // InternalMyBashParser.g:75:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getBashAccess().getBashAction_0_0(),
                      						current);
                      				
                    }

                    }

                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getBashAccess().getMaybeNewLineParserRuleCall_0_1());
                      			
                    }
                    pushFollow(FOLLOW_3);
                    ruleMaybeNewLine();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalMyBashParser.g:88:4: ( ( (lv_commands_2_0= ruleSimpleList ) ) ( ruleNewLine ( (lv_commands_4_0= ruleSimpleList ) ) )* ruleMaybeNewLine )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( ((LA2_0>=Function && LA2_0<=Case)||(LA2_0>=DollarSignLeftParenthesisLeftParenthesis && LA2_0<=AmpersandGreaterThanSignGreaterThanSign)||LA2_0==For||LA2_0==DollarSignLeftCurlyBracket||(LA2_0>=AmpersandGreaterThanSign && LA2_0<=LeftParenthesisLeftParenthesis)||(LA2_0>=LessThanSignAmpersand && LA2_0<=LessThanSignLessThanSign)||(LA2_0>=LessThanSignGreaterThanSign && LA2_0<=LessThanSignVerticalLine)||(LA2_0>=GreaterThanSignAmpersand && LA2_0<=GreaterThanSignLeftParenthesis)||(LA2_0>=GreaterThanSignGreaterThanSign && LA2_0<=LeftSquareBracketLeftSquareBracket)||LA2_0==If||(LA2_0>=ExclamationMark && LA2_0<=QuotationMark)||(LA2_0>=Apostrophe && LA2_0<=LeftParenthesis)||LA2_0==LessThanSign||LA2_0==GreaterThanSign||LA2_0==LeftCurlyBracket||LA2_0==RULE_I_NUMBER||(LA2_0>=RULE_NAME && LA2_0<=RULE_WORD_PART)||LA2_0==RULE_VARIABLE||LA2_0==RULE_CS_START) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // InternalMyBashParser.g:89:5: ( (lv_commands_2_0= ruleSimpleList ) ) ( ruleNewLine ( (lv_commands_4_0= ruleSimpleList ) ) )* ruleMaybeNewLine
                            {
                            // InternalMyBashParser.g:89:5: ( (lv_commands_2_0= ruleSimpleList ) )
                            // InternalMyBashParser.g:90:6: (lv_commands_2_0= ruleSimpleList )
                            {
                            // InternalMyBashParser.g:90:6: (lv_commands_2_0= ruleSimpleList )
                            // InternalMyBashParser.g:91:7: lv_commands_2_0= ruleSimpleList
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getBashAccess().getCommandsSimpleListParserRuleCall_0_2_0_0());
                              						
                            }
                            pushFollow(FOLLOW_4);
                            lv_commands_2_0=ruleSimpleList();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getBashRule());
                              							}
                              							add(
                              								current,
                              								"commands",
                              								lv_commands_2_0,
                              								"org.xtext.example.mydsl.MyBash.SimpleList");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }

                            // InternalMyBashParser.g:108:5: ( ruleNewLine ( (lv_commands_4_0= ruleSimpleList ) ) )*
                            loop1:
                            do {
                                int alt1=2;
                                alt1 = dfa1.predict(input);
                                switch (alt1) {
                            	case 1 :
                            	    // InternalMyBashParser.g:109:6: ruleNewLine ( (lv_commands_4_0= ruleSimpleList ) )
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      						newCompositeNode(grammarAccess.getBashAccess().getNewLineParserRuleCall_0_2_1_0());
                            	      					
                            	    }
                            	    pushFollow(FOLLOW_5);
                            	    ruleNewLine();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      						afterParserOrEnumRuleCall();
                            	      					
                            	    }
                            	    // InternalMyBashParser.g:116:6: ( (lv_commands_4_0= ruleSimpleList ) )
                            	    // InternalMyBashParser.g:117:7: (lv_commands_4_0= ruleSimpleList )
                            	    {
                            	    // InternalMyBashParser.g:117:7: (lv_commands_4_0= ruleSimpleList )
                            	    // InternalMyBashParser.g:118:8: lv_commands_4_0= ruleSimpleList
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								newCompositeNode(grammarAccess.getBashAccess().getCommandsSimpleListParserRuleCall_0_2_1_1_0());
                            	      							
                            	    }
                            	    pushFollow(FOLLOW_4);
                            	    lv_commands_4_0=ruleSimpleList();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      								if (current==null) {
                            	      									current = createModelElementForParent(grammarAccess.getBashRule());
                            	      								}
                            	      								add(
                            	      									current,
                            	      									"commands",
                            	      									lv_commands_4_0,
                            	      									"org.xtext.example.mydsl.MyBash.SimpleList");
                            	      								afterParserOrEnumRuleCall();
                            	      							
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop1;
                                }
                            } while (true);

                            if ( state.backtracking==0 ) {

                              					newCompositeNode(grammarAccess.getBashAccess().getMaybeNewLineParserRuleCall_0_2_2());
                              				
                            }
                            pushFollow(FOLLOW_2);
                            ruleMaybeNewLine();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					afterParserOrEnumRuleCall();
                              				
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMyBashParser.g:146:3: (this_WS_6= RULE_WS ( ( (lv_error_7_0= ruleWord ) ) | ( (lv_error_8_0= ruleAssignment ) ) ) this_WS_9= RULE_WS )
                    {
                    // InternalMyBashParser.g:146:3: (this_WS_6= RULE_WS ( ( (lv_error_7_0= ruleWord ) ) | ( (lv_error_8_0= ruleAssignment ) ) ) this_WS_9= RULE_WS )
                    // InternalMyBashParser.g:147:4: this_WS_6= RULE_WS ( ( (lv_error_7_0= ruleWord ) ) | ( (lv_error_8_0= ruleAssignment ) ) ) this_WS_9= RULE_WS
                    {
                    this_WS_6=(Token)match(input,RULE_WS,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_6, grammarAccess.getBashAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalMyBashParser.g:151:4: ( ( (lv_error_7_0= ruleWord ) ) | ( (lv_error_8_0= ruleAssignment ) ) )
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==DollarSignLeftParenthesisLeftParenthesis||LA3_0==DollarSignLeftCurlyBracket||LA3_0==LessThanSignLeftParenthesis||LA3_0==GreaterThanSignLeftParenthesis||LA3_0==QuotationMark||LA3_0==Apostrophe||(LA3_0>=RULE_S_WORD_PART && LA3_0<=RULE_WORD_PART)||LA3_0==RULE_VARIABLE||LA3_0==RULE_CS_START) ) {
                        alt3=1;
                    }
                    else if ( (LA3_0==RULE_NAME) ) {
                        alt3=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 0, input);

                        throw nvae;
                    }
                    switch (alt3) {
                        case 1 :
                            // InternalMyBashParser.g:152:5: ( (lv_error_7_0= ruleWord ) )
                            {
                            // InternalMyBashParser.g:152:5: ( (lv_error_7_0= ruleWord ) )
                            // InternalMyBashParser.g:153:6: (lv_error_7_0= ruleWord )
                            {
                            // InternalMyBashParser.g:153:6: (lv_error_7_0= ruleWord )
                            // InternalMyBashParser.g:154:7: lv_error_7_0= ruleWord
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getBashAccess().getErrorWordParserRuleCall_1_1_0_0());
                              						
                            }
                            pushFollow(FOLLOW_7);
                            lv_error_7_0=ruleWord();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getBashRule());
                              							}
                              							set(
                              								current,
                              								"error",
                              								true,
                              								"org.xtext.example.mydsl.MyBash.Word");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalMyBashParser.g:172:5: ( (lv_error_8_0= ruleAssignment ) )
                            {
                            // InternalMyBashParser.g:172:5: ( (lv_error_8_0= ruleAssignment ) )
                            // InternalMyBashParser.g:173:6: (lv_error_8_0= ruleAssignment )
                            {
                            // InternalMyBashParser.g:173:6: (lv_error_8_0= ruleAssignment )
                            // InternalMyBashParser.g:174:7: lv_error_8_0= ruleAssignment
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getBashAccess().getErrorAssignmentParserRuleCall_1_1_1_0());
                              						
                            }
                            pushFollow(FOLLOW_7);
                            lv_error_8_0=ruleAssignment();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getBashRule());
                              							}
                              							set(
                              								current,
                              								"error",
                              								true,
                              								"org.xtext.example.mydsl.MyBash.Assignment");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }


                            }
                            break;

                    }

                    this_WS_9=(Token)match(input,RULE_WS,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_9, grammarAccess.getBashAccess().getWSTerminalRuleCall_1_2());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBash"


    // $ANTLR start "entryRuleCompoundList"
    // InternalMyBashParser.g:201:1: entryRuleCompoundList returns [EObject current=null] : iv_ruleCompoundList= ruleCompoundList EOF ;
    public final EObject entryRuleCompoundList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompoundList = null;


        try {
            // InternalMyBashParser.g:201:53: (iv_ruleCompoundList= ruleCompoundList EOF )
            // InternalMyBashParser.g:202:2: iv_ruleCompoundList= ruleCompoundList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCompoundListRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCompoundList=ruleCompoundList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCompoundList; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCompoundList"


    // $ANTLR start "ruleCompoundList"
    // InternalMyBashParser.g:208:1: ruleCompoundList returns [EObject current=null] : ( ruleMaybeNewLine ( ( (lv_commands_1_0= ruleSimpleList ) ) ( ruleNewLine ( (lv_commands_3_0= ruleSimpleList ) ) )* ruleMaybeNewLine ) ) ;
    public final EObject ruleCompoundList() throws RecognitionException {
        EObject current = null;

        EObject lv_commands_1_0 = null;

        EObject lv_commands_3_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:214:2: ( ( ruleMaybeNewLine ( ( (lv_commands_1_0= ruleSimpleList ) ) ( ruleNewLine ( (lv_commands_3_0= ruleSimpleList ) ) )* ruleMaybeNewLine ) ) )
            // InternalMyBashParser.g:215:2: ( ruleMaybeNewLine ( ( (lv_commands_1_0= ruleSimpleList ) ) ( ruleNewLine ( (lv_commands_3_0= ruleSimpleList ) ) )* ruleMaybeNewLine ) )
            {
            // InternalMyBashParser.g:215:2: ( ruleMaybeNewLine ( ( (lv_commands_1_0= ruleSimpleList ) ) ( ruleNewLine ( (lv_commands_3_0= ruleSimpleList ) ) )* ruleMaybeNewLine ) )
            // InternalMyBashParser.g:216:3: ruleMaybeNewLine ( ( (lv_commands_1_0= ruleSimpleList ) ) ( ruleNewLine ( (lv_commands_3_0= ruleSimpleList ) ) )* ruleMaybeNewLine )
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getCompoundListAccess().getMaybeNewLineParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_5);
            ruleMaybeNewLine();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMyBashParser.g:223:3: ( ( (lv_commands_1_0= ruleSimpleList ) ) ( ruleNewLine ( (lv_commands_3_0= ruleSimpleList ) ) )* ruleMaybeNewLine )
            // InternalMyBashParser.g:224:4: ( (lv_commands_1_0= ruleSimpleList ) ) ( ruleNewLine ( (lv_commands_3_0= ruleSimpleList ) ) )* ruleMaybeNewLine
            {
            // InternalMyBashParser.g:224:4: ( (lv_commands_1_0= ruleSimpleList ) )
            // InternalMyBashParser.g:225:5: (lv_commands_1_0= ruleSimpleList )
            {
            // InternalMyBashParser.g:225:5: (lv_commands_1_0= ruleSimpleList )
            // InternalMyBashParser.g:226:6: lv_commands_1_0= ruleSimpleList
            {
            if ( state.backtracking==0 ) {

              						newCompositeNode(grammarAccess.getCompoundListAccess().getCommandsSimpleListParserRuleCall_1_0_0());
              					
            }
            pushFollow(FOLLOW_4);
            lv_commands_1_0=ruleSimpleList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElementForParent(grammarAccess.getCompoundListRule());
              						}
              						add(
              							current,
              							"commands",
              							lv_commands_1_0,
              							"org.xtext.example.mydsl.MyBash.SimpleList");
              						afterParserOrEnumRuleCall();
              					
            }

            }


            }

            // InternalMyBashParser.g:243:4: ( ruleNewLine ( (lv_commands_3_0= ruleSimpleList ) ) )*
            loop5:
            do {
                int alt5=2;
                alt5 = dfa5.predict(input);
                switch (alt5) {
            	case 1 :
            	    // InternalMyBashParser.g:244:5: ruleNewLine ( (lv_commands_3_0= ruleSimpleList ) )
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getCompoundListAccess().getNewLineParserRuleCall_1_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_5);
            	    ruleNewLine();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					afterParserOrEnumRuleCall();
            	      				
            	    }
            	    // InternalMyBashParser.g:251:5: ( (lv_commands_3_0= ruleSimpleList ) )
            	    // InternalMyBashParser.g:252:6: (lv_commands_3_0= ruleSimpleList )
            	    {
            	    // InternalMyBashParser.g:252:6: (lv_commands_3_0= ruleSimpleList )
            	    // InternalMyBashParser.g:253:7: lv_commands_3_0= ruleSimpleList
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getCompoundListAccess().getCommandsSimpleListParserRuleCall_1_1_1_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_commands_3_0=ruleSimpleList();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getCompoundListRule());
            	      							}
            	      							add(
            	      								current,
            	      								"commands",
            	      								lv_commands_3_0,
            	      								"org.xtext.example.mydsl.MyBash.SimpleList");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getCompoundListAccess().getMaybeNewLineParserRuleCall_1_2());
              			
            }
            pushFollow(FOLLOW_2);
            ruleMaybeNewLine();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompoundList"


    // $ANTLR start "entryRuleSimpleList"
    // InternalMyBashParser.g:283:1: entryRuleSimpleList returns [EObject current=null] : iv_ruleSimpleList= ruleSimpleList EOF ;
    public final EObject entryRuleSimpleList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleList = null;


        try {
            // InternalMyBashParser.g:283:51: (iv_ruleSimpleList= ruleSimpleList EOF )
            // InternalMyBashParser.g:284:2: iv_ruleSimpleList= ruleSimpleList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSimpleListRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSimpleList=ruleSimpleList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSimpleList; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleList"


    // $ANTLR start "ruleSimpleList"
    // InternalMyBashParser.g:290:1: ruleSimpleList returns [EObject current=null] : (this_PipelineCommand_0= rulePipelineCommand ( () ( ( ( ( (lv_op_2_1= AmpersandAmpersand | lv_op_2_2= VerticalLineVerticalLine ) ) ) ruleMaybeNewLine ) | ( ( (lv_op_4_1= Ampersand | lv_op_4_2= Semicolon ) ) ) ) ( (lv_right_5_0= rulePipelineCommand ) ) )* ( ( (lv_backend_6_0= Ampersand ) ) | otherlv_7= Semicolon )? ) ;
    public final EObject ruleSimpleList() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_4_1=null;
        Token lv_op_4_2=null;
        Token lv_backend_6_0=null;
        Token otherlv_7=null;
        EObject this_PipelineCommand_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:296:2: ( (this_PipelineCommand_0= rulePipelineCommand ( () ( ( ( ( (lv_op_2_1= AmpersandAmpersand | lv_op_2_2= VerticalLineVerticalLine ) ) ) ruleMaybeNewLine ) | ( ( (lv_op_4_1= Ampersand | lv_op_4_2= Semicolon ) ) ) ) ( (lv_right_5_0= rulePipelineCommand ) ) )* ( ( (lv_backend_6_0= Ampersand ) ) | otherlv_7= Semicolon )? ) )
            // InternalMyBashParser.g:297:2: (this_PipelineCommand_0= rulePipelineCommand ( () ( ( ( ( (lv_op_2_1= AmpersandAmpersand | lv_op_2_2= VerticalLineVerticalLine ) ) ) ruleMaybeNewLine ) | ( ( (lv_op_4_1= Ampersand | lv_op_4_2= Semicolon ) ) ) ) ( (lv_right_5_0= rulePipelineCommand ) ) )* ( ( (lv_backend_6_0= Ampersand ) ) | otherlv_7= Semicolon )? )
            {
            // InternalMyBashParser.g:297:2: (this_PipelineCommand_0= rulePipelineCommand ( () ( ( ( ( (lv_op_2_1= AmpersandAmpersand | lv_op_2_2= VerticalLineVerticalLine ) ) ) ruleMaybeNewLine ) | ( ( (lv_op_4_1= Ampersand | lv_op_4_2= Semicolon ) ) ) ) ( (lv_right_5_0= rulePipelineCommand ) ) )* ( ( (lv_backend_6_0= Ampersand ) ) | otherlv_7= Semicolon )? )
            // InternalMyBashParser.g:298:3: this_PipelineCommand_0= rulePipelineCommand ( () ( ( ( ( (lv_op_2_1= AmpersandAmpersand | lv_op_2_2= VerticalLineVerticalLine ) ) ) ruleMaybeNewLine ) | ( ( (lv_op_4_1= Ampersand | lv_op_4_2= Semicolon ) ) ) ) ( (lv_right_5_0= rulePipelineCommand ) ) )* ( ( (lv_backend_6_0= Ampersand ) ) | otherlv_7= Semicolon )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getSimpleListAccess().getPipelineCommandParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_8);
            this_PipelineCommand_0=rulePipelineCommand();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PipelineCommand_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMyBashParser.g:306:3: ( () ( ( ( ( (lv_op_2_1= AmpersandAmpersand | lv_op_2_2= VerticalLineVerticalLine ) ) ) ruleMaybeNewLine ) | ( ( (lv_op_4_1= Ampersand | lv_op_4_2= Semicolon ) ) ) ) ( (lv_right_5_0= rulePipelineCommand ) ) )*
            loop9:
            do {
                int alt9=2;
                switch ( input.LA(1) ) {
                case Ampersand:
                    {
                    int LA9_1 = input.LA(2);

                    if ( ((LA9_1>=Function && LA9_1<=Case)||(LA9_1>=DollarSignLeftParenthesisLeftParenthesis && LA9_1<=AmpersandGreaterThanSignGreaterThanSign)||LA9_1==For||LA9_1==DollarSignLeftCurlyBracket||(LA9_1>=AmpersandGreaterThanSign && LA9_1<=LeftParenthesisLeftParenthesis)||(LA9_1>=LessThanSignAmpersand && LA9_1<=LessThanSignLessThanSign)||(LA9_1>=LessThanSignGreaterThanSign && LA9_1<=LessThanSignVerticalLine)||(LA9_1>=GreaterThanSignAmpersand && LA9_1<=GreaterThanSignLeftParenthesis)||(LA9_1>=GreaterThanSignGreaterThanSign && LA9_1<=LeftSquareBracketLeftSquareBracket)||LA9_1==If||(LA9_1>=ExclamationMark && LA9_1<=QuotationMark)||(LA9_1>=Apostrophe && LA9_1<=LeftParenthesis)||LA9_1==LessThanSign||LA9_1==GreaterThanSign||LA9_1==LeftCurlyBracket||LA9_1==RULE_I_NUMBER||(LA9_1>=RULE_NAME && LA9_1<=RULE_WORD_PART)||LA9_1==RULE_VARIABLE||LA9_1==RULE_CS_START) ) {
                        alt9=1;
                    }


                    }
                    break;
                case Semicolon:
                    {
                    int LA9_2 = input.LA(2);

                    if ( ((LA9_2>=Function && LA9_2<=Case)||(LA9_2>=DollarSignLeftParenthesisLeftParenthesis && LA9_2<=AmpersandGreaterThanSignGreaterThanSign)||LA9_2==For||LA9_2==DollarSignLeftCurlyBracket||(LA9_2>=AmpersandGreaterThanSign && LA9_2<=LeftParenthesisLeftParenthesis)||(LA9_2>=LessThanSignAmpersand && LA9_2<=LessThanSignLessThanSign)||(LA9_2>=LessThanSignGreaterThanSign && LA9_2<=LessThanSignVerticalLine)||(LA9_2>=GreaterThanSignAmpersand && LA9_2<=GreaterThanSignLeftParenthesis)||(LA9_2>=GreaterThanSignGreaterThanSign && LA9_2<=LeftSquareBracketLeftSquareBracket)||LA9_2==If||(LA9_2>=ExclamationMark && LA9_2<=QuotationMark)||(LA9_2>=Apostrophe && LA9_2<=LeftParenthesis)||LA9_2==LessThanSign||LA9_2==GreaterThanSign||LA9_2==LeftCurlyBracket||LA9_2==RULE_I_NUMBER||(LA9_2>=RULE_NAME && LA9_2<=RULE_WORD_PART)||LA9_2==RULE_VARIABLE||LA9_2==RULE_CS_START) ) {
                        alt9=1;
                    }


                    }
                    break;
                case AmpersandAmpersand:
                case VerticalLineVerticalLine:
                    {
                    alt9=1;
                    }
                    break;

                }

                switch (alt9) {
            	case 1 :
            	    // InternalMyBashParser.g:307:4: () ( ( ( ( (lv_op_2_1= AmpersandAmpersand | lv_op_2_2= VerticalLineVerticalLine ) ) ) ruleMaybeNewLine ) | ( ( (lv_op_4_1= Ampersand | lv_op_4_2= Semicolon ) ) ) ) ( (lv_right_5_0= rulePipelineCommand ) )
            	    {
            	    // InternalMyBashParser.g:307:4: ()
            	    // InternalMyBashParser.g:308:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getSimpleListAccess().getSimpleListLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalMyBashParser.g:314:4: ( ( ( ( (lv_op_2_1= AmpersandAmpersand | lv_op_2_2= VerticalLineVerticalLine ) ) ) ruleMaybeNewLine ) | ( ( (lv_op_4_1= Ampersand | lv_op_4_2= Semicolon ) ) ) )
            	    int alt8=2;
            	    int LA8_0 = input.LA(1);

            	    if ( (LA8_0==AmpersandAmpersand||LA8_0==VerticalLineVerticalLine) ) {
            	        alt8=1;
            	    }
            	    else if ( (LA8_0==Ampersand||LA8_0==Semicolon) ) {
            	        alt8=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 8, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt8) {
            	        case 1 :
            	            // InternalMyBashParser.g:315:5: ( ( ( (lv_op_2_1= AmpersandAmpersand | lv_op_2_2= VerticalLineVerticalLine ) ) ) ruleMaybeNewLine )
            	            {
            	            // InternalMyBashParser.g:315:5: ( ( ( (lv_op_2_1= AmpersandAmpersand | lv_op_2_2= VerticalLineVerticalLine ) ) ) ruleMaybeNewLine )
            	            // InternalMyBashParser.g:316:6: ( ( (lv_op_2_1= AmpersandAmpersand | lv_op_2_2= VerticalLineVerticalLine ) ) ) ruleMaybeNewLine
            	            {
            	            // InternalMyBashParser.g:316:6: ( ( (lv_op_2_1= AmpersandAmpersand | lv_op_2_2= VerticalLineVerticalLine ) ) )
            	            // InternalMyBashParser.g:317:7: ( (lv_op_2_1= AmpersandAmpersand | lv_op_2_2= VerticalLineVerticalLine ) )
            	            {
            	            // InternalMyBashParser.g:317:7: ( (lv_op_2_1= AmpersandAmpersand | lv_op_2_2= VerticalLineVerticalLine ) )
            	            // InternalMyBashParser.g:318:8: (lv_op_2_1= AmpersandAmpersand | lv_op_2_2= VerticalLineVerticalLine )
            	            {
            	            // InternalMyBashParser.g:318:8: (lv_op_2_1= AmpersandAmpersand | lv_op_2_2= VerticalLineVerticalLine )
            	            int alt6=2;
            	            int LA6_0 = input.LA(1);

            	            if ( (LA6_0==AmpersandAmpersand) ) {
            	                alt6=1;
            	            }
            	            else if ( (LA6_0==VerticalLineVerticalLine) ) {
            	                alt6=2;
            	            }
            	            else {
            	                if (state.backtracking>0) {state.failed=true; return current;}
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 6, 0, input);

            	                throw nvae;
            	            }
            	            switch (alt6) {
            	                case 1 :
            	                    // InternalMyBashParser.g:319:9: lv_op_2_1= AmpersandAmpersand
            	                    {
            	                    lv_op_2_1=(Token)match(input,AmpersandAmpersand,FOLLOW_9); if (state.failed) return current;
            	                    if ( state.backtracking==0 ) {

            	                      									newLeafNode(lv_op_2_1, grammarAccess.getSimpleListAccess().getOpAmpersandAmpersandKeyword_1_1_0_0_0_0());
            	                      								
            	                    }
            	                    if ( state.backtracking==0 ) {

            	                      									if (current==null) {
            	                      										current = createModelElement(grammarAccess.getSimpleListRule());
            	                      									}
            	                      									setWithLastConsumed(current, "op", lv_op_2_1, null);
            	                      								
            	                    }

            	                    }
            	                    break;
            	                case 2 :
            	                    // InternalMyBashParser.g:330:9: lv_op_2_2= VerticalLineVerticalLine
            	                    {
            	                    lv_op_2_2=(Token)match(input,VerticalLineVerticalLine,FOLLOW_9); if (state.failed) return current;
            	                    if ( state.backtracking==0 ) {

            	                      									newLeafNode(lv_op_2_2, grammarAccess.getSimpleListAccess().getOpVerticalLineVerticalLineKeyword_1_1_0_0_0_1());
            	                      								
            	                    }
            	                    if ( state.backtracking==0 ) {

            	                      									if (current==null) {
            	                      										current = createModelElement(grammarAccess.getSimpleListRule());
            	                      									}
            	                      									setWithLastConsumed(current, "op", lv_op_2_2, null);
            	                      								
            	                    }

            	                    }
            	                    break;

            	            }


            	            }


            	            }

            	            if ( state.backtracking==0 ) {

            	              						newCompositeNode(grammarAccess.getSimpleListAccess().getMaybeNewLineParserRuleCall_1_1_0_1());
            	              					
            	            }
            	            pushFollow(FOLLOW_5);
            	            ruleMaybeNewLine();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              						afterParserOrEnumRuleCall();
            	              					
            	            }

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalMyBashParser.g:352:5: ( ( (lv_op_4_1= Ampersand | lv_op_4_2= Semicolon ) ) )
            	            {
            	            // InternalMyBashParser.g:352:5: ( ( (lv_op_4_1= Ampersand | lv_op_4_2= Semicolon ) ) )
            	            // InternalMyBashParser.g:353:6: ( (lv_op_4_1= Ampersand | lv_op_4_2= Semicolon ) )
            	            {
            	            // InternalMyBashParser.g:353:6: ( (lv_op_4_1= Ampersand | lv_op_4_2= Semicolon ) )
            	            // InternalMyBashParser.g:354:7: (lv_op_4_1= Ampersand | lv_op_4_2= Semicolon )
            	            {
            	            // InternalMyBashParser.g:354:7: (lv_op_4_1= Ampersand | lv_op_4_2= Semicolon )
            	            int alt7=2;
            	            int LA7_0 = input.LA(1);

            	            if ( (LA7_0==Ampersand) ) {
            	                alt7=1;
            	            }
            	            else if ( (LA7_0==Semicolon) ) {
            	                alt7=2;
            	            }
            	            else {
            	                if (state.backtracking>0) {state.failed=true; return current;}
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 7, 0, input);

            	                throw nvae;
            	            }
            	            switch (alt7) {
            	                case 1 :
            	                    // InternalMyBashParser.g:355:8: lv_op_4_1= Ampersand
            	                    {
            	                    lv_op_4_1=(Token)match(input,Ampersand,FOLLOW_5); if (state.failed) return current;
            	                    if ( state.backtracking==0 ) {

            	                      								newLeafNode(lv_op_4_1, grammarAccess.getSimpleListAccess().getOpAmpersandKeyword_1_1_1_0_0());
            	                      							
            	                    }
            	                    if ( state.backtracking==0 ) {

            	                      								if (current==null) {
            	                      									current = createModelElement(grammarAccess.getSimpleListRule());
            	                      								}
            	                      								setWithLastConsumed(current, "op", lv_op_4_1, null);
            	                      							
            	                    }

            	                    }
            	                    break;
            	                case 2 :
            	                    // InternalMyBashParser.g:366:8: lv_op_4_2= Semicolon
            	                    {
            	                    lv_op_4_2=(Token)match(input,Semicolon,FOLLOW_5); if (state.failed) return current;
            	                    if ( state.backtracking==0 ) {

            	                      								newLeafNode(lv_op_4_2, grammarAccess.getSimpleListAccess().getOpSemicolonKeyword_1_1_1_0_1());
            	                      							
            	                    }
            	                    if ( state.backtracking==0 ) {

            	                      								if (current==null) {
            	                      									current = createModelElement(grammarAccess.getSimpleListRule());
            	                      								}
            	                      								setWithLastConsumed(current, "op", lv_op_4_2, null);
            	                      							
            	                    }

            	                    }
            	                    break;

            	            }


            	            }


            	            }


            	            }
            	            break;

            	    }

            	    // InternalMyBashParser.g:380:4: ( (lv_right_5_0= rulePipelineCommand ) )
            	    // InternalMyBashParser.g:381:5: (lv_right_5_0= rulePipelineCommand )
            	    {
            	    // InternalMyBashParser.g:381:5: (lv_right_5_0= rulePipelineCommand )
            	    // InternalMyBashParser.g:382:6: lv_right_5_0= rulePipelineCommand
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getSimpleListAccess().getRightPipelineCommandParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_8);
            	    lv_right_5_0=rulePipelineCommand();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getSimpleListRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_5_0,
            	      							"org.xtext.example.mydsl.MyBash.PipelineCommand");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // InternalMyBashParser.g:400:3: ( ( (lv_backend_6_0= Ampersand ) ) | otherlv_7= Semicolon )?
            int alt10=3;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==Ampersand) ) {
                alt10=1;
            }
            else if ( (LA10_0==Semicolon) ) {
                alt10=2;
            }
            switch (alt10) {
                case 1 :
                    // InternalMyBashParser.g:401:4: ( (lv_backend_6_0= Ampersand ) )
                    {
                    // InternalMyBashParser.g:401:4: ( (lv_backend_6_0= Ampersand ) )
                    // InternalMyBashParser.g:402:5: (lv_backend_6_0= Ampersand )
                    {
                    // InternalMyBashParser.g:402:5: (lv_backend_6_0= Ampersand )
                    // InternalMyBashParser.g:403:6: lv_backend_6_0= Ampersand
                    {
                    lv_backend_6_0=(Token)match(input,Ampersand,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_backend_6_0, grammarAccess.getSimpleListAccess().getBackendAmpersandKeyword_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getSimpleListRule());
                      						}
                      						setWithLastConsumed(current, "backend", true, "&");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMyBashParser.g:416:4: otherlv_7= Semicolon
                    {
                    otherlv_7=(Token)match(input,Semicolon,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getSimpleListAccess().getSemicolonKeyword_2_1());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpleList"


    // $ANTLR start "entryRulePipelineCommand"
    // InternalMyBashParser.g:425:1: entryRulePipelineCommand returns [EObject current=null] : iv_rulePipelineCommand= rulePipelineCommand EOF ;
    public final EObject entryRulePipelineCommand() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipelineCommand = null;


        try {
            // InternalMyBashParser.g:425:56: (iv_rulePipelineCommand= rulePipelineCommand EOF )
            // InternalMyBashParser.g:426:2: iv_rulePipelineCommand= rulePipelineCommand EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPipelineCommandRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePipelineCommand=rulePipelineCommand();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePipelineCommand; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePipelineCommand"


    // $ANTLR start "rulePipelineCommand"
    // InternalMyBashParser.g:432:1: rulePipelineCommand returns [EObject current=null] : ( ( () ( (lv_not_1_0= ExclamationMark ) ) ( (lv_pipeline_2_0= rulePipeline ) ) ) | this_Pipeline_3= rulePipeline ) ;
    public final EObject rulePipelineCommand() throws RecognitionException {
        EObject current = null;

        Token lv_not_1_0=null;
        EObject lv_pipeline_2_0 = null;

        EObject this_Pipeline_3 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:438:2: ( ( ( () ( (lv_not_1_0= ExclamationMark ) ) ( (lv_pipeline_2_0= rulePipeline ) ) ) | this_Pipeline_3= rulePipeline ) )
            // InternalMyBashParser.g:439:2: ( ( () ( (lv_not_1_0= ExclamationMark ) ) ( (lv_pipeline_2_0= rulePipeline ) ) ) | this_Pipeline_3= rulePipeline )
            {
            // InternalMyBashParser.g:439:2: ( ( () ( (lv_not_1_0= ExclamationMark ) ) ( (lv_pipeline_2_0= rulePipeline ) ) ) | this_Pipeline_3= rulePipeline )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==ExclamationMark) ) {
                alt11=1;
            }
            else if ( ((LA11_0>=Function && LA11_0<=Case)||(LA11_0>=DollarSignLeftParenthesisLeftParenthesis && LA11_0<=AmpersandGreaterThanSignGreaterThanSign)||LA11_0==For||LA11_0==DollarSignLeftCurlyBracket||(LA11_0>=AmpersandGreaterThanSign && LA11_0<=LeftParenthesisLeftParenthesis)||(LA11_0>=LessThanSignAmpersand && LA11_0<=LessThanSignLessThanSign)||(LA11_0>=LessThanSignGreaterThanSign && LA11_0<=LessThanSignVerticalLine)||(LA11_0>=GreaterThanSignAmpersand && LA11_0<=GreaterThanSignLeftParenthesis)||(LA11_0>=GreaterThanSignGreaterThanSign && LA11_0<=LeftSquareBracketLeftSquareBracket)||LA11_0==If||LA11_0==QuotationMark||(LA11_0>=Apostrophe && LA11_0<=LeftParenthesis)||LA11_0==LessThanSign||LA11_0==GreaterThanSign||LA11_0==LeftCurlyBracket||LA11_0==RULE_I_NUMBER||(LA11_0>=RULE_NAME && LA11_0<=RULE_WORD_PART)||LA11_0==RULE_VARIABLE||LA11_0==RULE_CS_START) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalMyBashParser.g:440:3: ( () ( (lv_not_1_0= ExclamationMark ) ) ( (lv_pipeline_2_0= rulePipeline ) ) )
                    {
                    // InternalMyBashParser.g:440:3: ( () ( (lv_not_1_0= ExclamationMark ) ) ( (lv_pipeline_2_0= rulePipeline ) ) )
                    // InternalMyBashParser.g:441:4: () ( (lv_not_1_0= ExclamationMark ) ) ( (lv_pipeline_2_0= rulePipeline ) )
                    {
                    // InternalMyBashParser.g:441:4: ()
                    // InternalMyBashParser.g:442:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPipelineCommandAccess().getPipelineCommandAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalMyBashParser.g:448:4: ( (lv_not_1_0= ExclamationMark ) )
                    // InternalMyBashParser.g:449:5: (lv_not_1_0= ExclamationMark )
                    {
                    // InternalMyBashParser.g:449:5: (lv_not_1_0= ExclamationMark )
                    // InternalMyBashParser.g:450:6: lv_not_1_0= ExclamationMark
                    {
                    lv_not_1_0=(Token)match(input,ExclamationMark,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_not_1_0, grammarAccess.getPipelineCommandAccess().getNotExclamationMarkKeyword_0_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPipelineCommandRule());
                      						}
                      						setWithLastConsumed(current, "not", true, "!");
                      					
                    }

                    }


                    }

                    // InternalMyBashParser.g:462:4: ( (lv_pipeline_2_0= rulePipeline ) )
                    // InternalMyBashParser.g:463:5: (lv_pipeline_2_0= rulePipeline )
                    {
                    // InternalMyBashParser.g:463:5: (lv_pipeline_2_0= rulePipeline )
                    // InternalMyBashParser.g:464:6: lv_pipeline_2_0= rulePipeline
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPipelineCommandAccess().getPipelinePipelineParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_pipeline_2_0=rulePipeline();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPipelineCommandRule());
                      						}
                      						set(
                      							current,
                      							"pipeline",
                      							lv_pipeline_2_0,
                      							"org.xtext.example.mydsl.MyBash.Pipeline");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMyBashParser.g:483:3: this_Pipeline_3= rulePipeline
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPipelineCommandAccess().getPipelineParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Pipeline_3=rulePipeline();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Pipeline_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePipelineCommand"


    // $ANTLR start "entryRulePipeline"
    // InternalMyBashParser.g:495:1: entryRulePipeline returns [EObject current=null] : iv_rulePipeline= rulePipeline EOF ;
    public final EObject entryRulePipeline() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipeline = null;


        try {
            // InternalMyBashParser.g:495:49: (iv_rulePipeline= rulePipeline EOF )
            // InternalMyBashParser.g:496:2: iv_rulePipeline= rulePipeline EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPipelineRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePipeline=rulePipeline();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePipeline; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePipeline"


    // $ANTLR start "rulePipeline"
    // InternalMyBashParser.g:502:1: rulePipeline returns [EObject current=null] : (this_Command_0= ruleCommand ( () ( ( (lv_op_2_1= VerticalLine | lv_op_2_2= VerticalLineAmpersand ) ) ) ruleMaybeNewLine ( (lv_right_4_0= ruleCommand ) ) )* ) ;
    public final EObject rulePipeline() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_Command_0 = null;

        EObject lv_right_4_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:508:2: ( (this_Command_0= ruleCommand ( () ( ( (lv_op_2_1= VerticalLine | lv_op_2_2= VerticalLineAmpersand ) ) ) ruleMaybeNewLine ( (lv_right_4_0= ruleCommand ) ) )* ) )
            // InternalMyBashParser.g:509:2: (this_Command_0= ruleCommand ( () ( ( (lv_op_2_1= VerticalLine | lv_op_2_2= VerticalLineAmpersand ) ) ) ruleMaybeNewLine ( (lv_right_4_0= ruleCommand ) ) )* )
            {
            // InternalMyBashParser.g:509:2: (this_Command_0= ruleCommand ( () ( ( (lv_op_2_1= VerticalLine | lv_op_2_2= VerticalLineAmpersand ) ) ) ruleMaybeNewLine ( (lv_right_4_0= ruleCommand ) ) )* )
            // InternalMyBashParser.g:510:3: this_Command_0= ruleCommand ( () ( ( (lv_op_2_1= VerticalLine | lv_op_2_2= VerticalLineAmpersand ) ) ) ruleMaybeNewLine ( (lv_right_4_0= ruleCommand ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getPipelineAccess().getCommandParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_10);
            this_Command_0=ruleCommand();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Command_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMyBashParser.g:518:3: ( () ( ( (lv_op_2_1= VerticalLine | lv_op_2_2= VerticalLineAmpersand ) ) ) ruleMaybeNewLine ( (lv_right_4_0= ruleCommand ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==VerticalLineAmpersand||LA13_0==VerticalLine) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalMyBashParser.g:519:4: () ( ( (lv_op_2_1= VerticalLine | lv_op_2_2= VerticalLineAmpersand ) ) ) ruleMaybeNewLine ( (lv_right_4_0= ruleCommand ) )
            	    {
            	    // InternalMyBashParser.g:519:4: ()
            	    // InternalMyBashParser.g:520:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getPipelineAccess().getPipelineLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalMyBashParser.g:526:4: ( ( (lv_op_2_1= VerticalLine | lv_op_2_2= VerticalLineAmpersand ) ) )
            	    // InternalMyBashParser.g:527:5: ( (lv_op_2_1= VerticalLine | lv_op_2_2= VerticalLineAmpersand ) )
            	    {
            	    // InternalMyBashParser.g:527:5: ( (lv_op_2_1= VerticalLine | lv_op_2_2= VerticalLineAmpersand ) )
            	    // InternalMyBashParser.g:528:6: (lv_op_2_1= VerticalLine | lv_op_2_2= VerticalLineAmpersand )
            	    {
            	    // InternalMyBashParser.g:528:6: (lv_op_2_1= VerticalLine | lv_op_2_2= VerticalLineAmpersand )
            	    int alt12=2;
            	    int LA12_0 = input.LA(1);

            	    if ( (LA12_0==VerticalLine) ) {
            	        alt12=1;
            	    }
            	    else if ( (LA12_0==VerticalLineAmpersand) ) {
            	        alt12=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 12, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt12) {
            	        case 1 :
            	            // InternalMyBashParser.g:529:7: lv_op_2_1= VerticalLine
            	            {
            	            lv_op_2_1=(Token)match(input,VerticalLine,FOLLOW_9); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_1, grammarAccess.getPipelineAccess().getOpVerticalLineKeyword_1_1_0_0());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getPipelineRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalMyBashParser.g:540:7: lv_op_2_2= VerticalLineAmpersand
            	            {
            	            lv_op_2_2=(Token)match(input,VerticalLineAmpersand,FOLLOW_9); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_2, grammarAccess.getPipelineAccess().getOpVerticalLineAmpersandKeyword_1_1_0_1());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getPipelineRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getPipelineAccess().getMaybeNewLineParserRuleCall_1_2());
            	      			
            	    }
            	    pushFollow(FOLLOW_5);
            	    ruleMaybeNewLine();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				afterParserOrEnumRuleCall();
            	      			
            	    }
            	    // InternalMyBashParser.g:560:4: ( (lv_right_4_0= ruleCommand ) )
            	    // InternalMyBashParser.g:561:5: (lv_right_4_0= ruleCommand )
            	    {
            	    // InternalMyBashParser.g:561:5: (lv_right_4_0= ruleCommand )
            	    // InternalMyBashParser.g:562:6: lv_right_4_0= ruleCommand
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPipelineAccess().getRightCommandParserRuleCall_1_3_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_right_4_0=ruleCommand();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getPipelineRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_4_0,
            	      							"org.xtext.example.mydsl.MyBash.Command");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePipeline"


    // $ANTLR start "entryRuleCommand"
    // InternalMyBashParser.g:584:1: entryRuleCommand returns [EObject current=null] : iv_ruleCommand= ruleCommand EOF ;
    public final EObject entryRuleCommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommand = null;


        try {
            // InternalMyBashParser.g:584:48: (iv_ruleCommand= ruleCommand EOF )
            // InternalMyBashParser.g:585:2: iv_ruleCommand= ruleCommand EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCommandRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCommand=ruleCommand();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCommand; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCommand"


    // $ANTLR start "ruleCommand"
    // InternalMyBashParser.g:591:1: ruleCommand returns [EObject current=null] : (this_FunctionDefine_0= ruleFunctionDefine | this_SimpleCommand_1= ruleSimpleCommand | (this_ShellCommand_2= ruleShellCommand ( (lv_redirects_3_0= ruleRedirection ) )* ) ) ;
    public final EObject ruleCommand() throws RecognitionException {
        EObject current = null;

        EObject this_FunctionDefine_0 = null;

        EObject this_SimpleCommand_1 = null;

        EObject this_ShellCommand_2 = null;

        EObject lv_redirects_3_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:597:2: ( (this_FunctionDefine_0= ruleFunctionDefine | this_SimpleCommand_1= ruleSimpleCommand | (this_ShellCommand_2= ruleShellCommand ( (lv_redirects_3_0= ruleRedirection ) )* ) ) )
            // InternalMyBashParser.g:598:2: (this_FunctionDefine_0= ruleFunctionDefine | this_SimpleCommand_1= ruleSimpleCommand | (this_ShellCommand_2= ruleShellCommand ( (lv_redirects_3_0= ruleRedirection ) )* ) )
            {
            // InternalMyBashParser.g:598:2: (this_FunctionDefine_0= ruleFunctionDefine | this_SimpleCommand_1= ruleSimpleCommand | (this_ShellCommand_2= ruleShellCommand ( (lv_redirects_3_0= ruleRedirection ) )* ) )
            int alt15=3;
            switch ( input.LA(1) ) {
            case Function:
                {
                alt15=1;
                }
                break;
            case RULE_S_WORD_PART:
                {
                int LA15_2 = input.LA(2);

                if ( (LA15_2==EOF||(LA15_2>=Done && LA15_2<=SemicolonSemicolonAmpersand)||LA15_2==DollarSignLeftCurlyBracket||LA15_2==AmpersandAmpersand||LA15_2==AmpersandGreaterThanSign||(LA15_2>=SemicolonAmpersand && LA15_2<=LessThanSignLessThanSign)||(LA15_2>=LessThanSignGreaterThanSign && LA15_2<=LessThanSignVerticalLine)||(LA15_2>=GreaterThanSignAmpersand && LA15_2<=GreaterThanSignLeftParenthesis)||(LA15_2>=GreaterThanSignGreaterThanSign && LA15_2<=GreaterThanSignVerticalLine)||(LA15_2>=Do && LA15_2<=Fi)||LA15_2==VerticalLineAmpersand||LA15_2==VerticalLineVerticalLine||LA15_2==QuotationMark||(LA15_2>=Ampersand && LA15_2<=Apostrophe)||LA15_2==RightParenthesis||(LA15_2>=Semicolon && LA15_2<=LessThanSign)||LA15_2==GreaterThanSign||(LA15_2>=VerticalLine && LA15_2<=RightCurlyBracket)||(LA15_2>=RULE_I_NUMBER && LA15_2<=RULE_NEW_LINE)||(LA15_2>=RULE_NAME && LA15_2<=RULE_WORD_PART)||LA15_2==RULE_VARIABLE||(LA15_2>=RULE_CS_START && LA15_2<=RULE_CS_END)||LA15_2==RULE_HERE_DOC_START) ) {
                    alt15=2;
                }
                else if ( (LA15_2==LeftParenthesis) ) {
                    alt15=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 2, input);

                    throw nvae;
                }
                }
                break;
            case DollarSignLeftParenthesisLeftParenthesis:
            case AmpersandGreaterThanSignGreaterThanSign:
            case DollarSignLeftCurlyBracket:
            case AmpersandGreaterThanSign:
            case LessThanSignAmpersand:
            case LessThanSignLeftParenthesis:
            case LessThanSignLessThanSign:
            case LessThanSignGreaterThanSign:
            case LessThanSignVerticalLine:
            case GreaterThanSignAmpersand:
            case GreaterThanSignLeftParenthesis:
            case GreaterThanSignGreaterThanSign:
            case GreaterThanSignVerticalLine:
            case QuotationMark:
            case Apostrophe:
            case LessThanSign:
            case GreaterThanSign:
            case RULE_I_NUMBER:
            case RULE_NAME:
            case RULE_WORD_PART:
            case RULE_VARIABLE:
            case RULE_CS_START:
                {
                alt15=2;
                }
                break;
            case While:
            case Case:
            case For:
            case LeftParenthesisLeftParenthesis:
            case LeftSquareBracketLeftSquareBracket:
            case If:
            case LeftParenthesis:
            case LeftCurlyBracket:
                {
                alt15=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalMyBashParser.g:599:3: this_FunctionDefine_0= ruleFunctionDefine
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getCommandAccess().getFunctionDefineParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_FunctionDefine_0=ruleFunctionDefine();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_FunctionDefine_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalMyBashParser.g:608:3: this_SimpleCommand_1= ruleSimpleCommand
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getCommandAccess().getSimpleCommandParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_SimpleCommand_1=ruleSimpleCommand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SimpleCommand_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalMyBashParser.g:617:3: (this_ShellCommand_2= ruleShellCommand ( (lv_redirects_3_0= ruleRedirection ) )* )
                    {
                    // InternalMyBashParser.g:617:3: (this_ShellCommand_2= ruleShellCommand ( (lv_redirects_3_0= ruleRedirection ) )* )
                    // InternalMyBashParser.g:618:4: this_ShellCommand_2= ruleShellCommand ( (lv_redirects_3_0= ruleRedirection ) )*
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getCommandAccess().getShellCommandParserRuleCall_2_0());
                      			
                    }
                    pushFollow(FOLLOW_11);
                    this_ShellCommand_2=ruleShellCommand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_ShellCommand_2;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalMyBashParser.g:626:4: ( (lv_redirects_3_0= ruleRedirection ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==AmpersandGreaterThanSignGreaterThanSign||LA14_0==AmpersandGreaterThanSign||LA14_0==LessThanSignAmpersand||LA14_0==LessThanSignLessThanSign||(LA14_0>=LessThanSignGreaterThanSign && LA14_0<=LessThanSignVerticalLine)||LA14_0==GreaterThanSignAmpersand||(LA14_0>=GreaterThanSignGreaterThanSign && LA14_0<=GreaterThanSignVerticalLine)||LA14_0==LessThanSign||LA14_0==GreaterThanSign||LA14_0==RULE_I_NUMBER) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalMyBashParser.g:627:5: (lv_redirects_3_0= ruleRedirection )
                    	    {
                    	    // InternalMyBashParser.g:627:5: (lv_redirects_3_0= ruleRedirection )
                    	    // InternalMyBashParser.g:628:6: lv_redirects_3_0= ruleRedirection
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getCommandAccess().getRedirectsRedirectionParserRuleCall_2_1_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_11);
                    	    lv_redirects_3_0=ruleRedirection();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getCommandRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"redirects",
                    	      							lv_redirects_3_0,
                    	      							"org.xtext.example.mydsl.MyBash.Redirection");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCommand"


    // $ANTLR start "entryRuleFunctionDefine"
    // InternalMyBashParser.g:650:1: entryRuleFunctionDefine returns [EObject current=null] : iv_ruleFunctionDefine= ruleFunctionDefine EOF ;
    public final EObject entryRuleFunctionDefine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDefine = null;


        try {
            // InternalMyBashParser.g:650:55: (iv_ruleFunctionDefine= ruleFunctionDefine EOF )
            // InternalMyBashParser.g:651:2: iv_ruleFunctionDefine= ruleFunctionDefine EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionDefineRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFunctionDefine=ruleFunctionDefine();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunctionDefine; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionDefine"


    // $ANTLR start "ruleFunctionDefine"
    // InternalMyBashParser.g:657:1: ruleFunctionDefine returns [EObject current=null] : ( ( () otherlv_1= Function ( (lv_name_2_0= ruleFunctionName ) ) ( ( ( ( LeftParenthesis )=>otherlv_3= LeftParenthesis ) otherlv_4= RightParenthesis )? ruleMaybeNewLine ) ( (lv_body_6_0= ruleShellCommand ) ) ) | ( () ( (lv_name_8_0= ruleFunctionName ) ) (otherlv_9= LeftParenthesis otherlv_10= RightParenthesis ruleMaybeNewLine ) ( (lv_body_12_0= ruleShellCommand ) ) ) ) ;
    public final EObject ruleFunctionDefine() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_body_6_0 = null;

        AntlrDatatypeRuleToken lv_name_8_0 = null;

        EObject lv_body_12_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:663:2: ( ( ( () otherlv_1= Function ( (lv_name_2_0= ruleFunctionName ) ) ( ( ( ( LeftParenthesis )=>otherlv_3= LeftParenthesis ) otherlv_4= RightParenthesis )? ruleMaybeNewLine ) ( (lv_body_6_0= ruleShellCommand ) ) ) | ( () ( (lv_name_8_0= ruleFunctionName ) ) (otherlv_9= LeftParenthesis otherlv_10= RightParenthesis ruleMaybeNewLine ) ( (lv_body_12_0= ruleShellCommand ) ) ) ) )
            // InternalMyBashParser.g:664:2: ( ( () otherlv_1= Function ( (lv_name_2_0= ruleFunctionName ) ) ( ( ( ( LeftParenthesis )=>otherlv_3= LeftParenthesis ) otherlv_4= RightParenthesis )? ruleMaybeNewLine ) ( (lv_body_6_0= ruleShellCommand ) ) ) | ( () ( (lv_name_8_0= ruleFunctionName ) ) (otherlv_9= LeftParenthesis otherlv_10= RightParenthesis ruleMaybeNewLine ) ( (lv_body_12_0= ruleShellCommand ) ) ) )
            {
            // InternalMyBashParser.g:664:2: ( ( () otherlv_1= Function ( (lv_name_2_0= ruleFunctionName ) ) ( ( ( ( LeftParenthesis )=>otherlv_3= LeftParenthesis ) otherlv_4= RightParenthesis )? ruleMaybeNewLine ) ( (lv_body_6_0= ruleShellCommand ) ) ) | ( () ( (lv_name_8_0= ruleFunctionName ) ) (otherlv_9= LeftParenthesis otherlv_10= RightParenthesis ruleMaybeNewLine ) ( (lv_body_12_0= ruleShellCommand ) ) ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==Function) ) {
                alt17=1;
            }
            else if ( (LA17_0==RULE_S_WORD_PART) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalMyBashParser.g:665:3: ( () otherlv_1= Function ( (lv_name_2_0= ruleFunctionName ) ) ( ( ( ( LeftParenthesis )=>otherlv_3= LeftParenthesis ) otherlv_4= RightParenthesis )? ruleMaybeNewLine ) ( (lv_body_6_0= ruleShellCommand ) ) )
                    {
                    // InternalMyBashParser.g:665:3: ( () otherlv_1= Function ( (lv_name_2_0= ruleFunctionName ) ) ( ( ( ( LeftParenthesis )=>otherlv_3= LeftParenthesis ) otherlv_4= RightParenthesis )? ruleMaybeNewLine ) ( (lv_body_6_0= ruleShellCommand ) ) )
                    // InternalMyBashParser.g:666:4: () otherlv_1= Function ( (lv_name_2_0= ruleFunctionName ) ) ( ( ( ( LeftParenthesis )=>otherlv_3= LeftParenthesis ) otherlv_4= RightParenthesis )? ruleMaybeNewLine ) ( (lv_body_6_0= ruleShellCommand ) )
                    {
                    // InternalMyBashParser.g:666:4: ()
                    // InternalMyBashParser.g:667:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getFunctionDefineAccess().getFunctionDefineAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,Function,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getFunctionDefineAccess().getFunctionKeyword_0_1());
                      			
                    }
                    // InternalMyBashParser.g:677:4: ( (lv_name_2_0= ruleFunctionName ) )
                    // InternalMyBashParser.g:678:5: (lv_name_2_0= ruleFunctionName )
                    {
                    // InternalMyBashParser.g:678:5: (lv_name_2_0= ruleFunctionName )
                    // InternalMyBashParser.g:679:6: lv_name_2_0= ruleFunctionName
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFunctionDefineAccess().getNameFunctionNameParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FOLLOW_9);
                    lv_name_2_0=ruleFunctionName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFunctionDefineRule());
                      						}
                      						set(
                      							current,
                      							"name",
                      							lv_name_2_0,
                      							"org.xtext.example.mydsl.MyBash.FunctionName");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalMyBashParser.g:696:4: ( ( ( ( LeftParenthesis )=>otherlv_3= LeftParenthesis ) otherlv_4= RightParenthesis )? ruleMaybeNewLine )
                    // InternalMyBashParser.g:697:5: ( ( ( LeftParenthesis )=>otherlv_3= LeftParenthesis ) otherlv_4= RightParenthesis )? ruleMaybeNewLine
                    {
                    // InternalMyBashParser.g:697:5: ( ( ( LeftParenthesis )=>otherlv_3= LeftParenthesis ) otherlv_4= RightParenthesis )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==LeftParenthesis) ) {
                        int LA16_1 = input.LA(2);

                        if ( (LA16_1==RightParenthesis) && (synpred1_InternalMyBashParser())) {
                            alt16=1;
                        }
                    }
                    switch (alt16) {
                        case 1 :
                            // InternalMyBashParser.g:698:6: ( ( LeftParenthesis )=>otherlv_3= LeftParenthesis ) otherlv_4= RightParenthesis
                            {
                            // InternalMyBashParser.g:698:6: ( ( LeftParenthesis )=>otherlv_3= LeftParenthesis )
                            // InternalMyBashParser.g:699:7: ( LeftParenthesis )=>otherlv_3= LeftParenthesis
                            {
                            otherlv_3=(Token)match(input,LeftParenthesis,FOLLOW_13); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_3, grammarAccess.getFunctionDefineAccess().getLeftParenthesisKeyword_0_3_0_0());
                              						
                            }

                            }

                            otherlv_4=(Token)match(input,RightParenthesis,FOLLOW_9); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_4, grammarAccess.getFunctionDefineAccess().getRightParenthesisKeyword_0_3_0_1());
                              					
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getFunctionDefineAccess().getMaybeNewLineParserRuleCall_0_3_1());
                      				
                    }
                    pushFollow(FOLLOW_5);
                    ruleMaybeNewLine();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }

                    // InternalMyBashParser.g:718:4: ( (lv_body_6_0= ruleShellCommand ) )
                    // InternalMyBashParser.g:719:5: (lv_body_6_0= ruleShellCommand )
                    {
                    // InternalMyBashParser.g:719:5: (lv_body_6_0= ruleShellCommand )
                    // InternalMyBashParser.g:720:6: lv_body_6_0= ruleShellCommand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFunctionDefineAccess().getBodyShellCommandParserRuleCall_0_4_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_body_6_0=ruleShellCommand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFunctionDefineRule());
                      						}
                      						set(
                      							current,
                      							"body",
                      							lv_body_6_0,
                      							"org.xtext.example.mydsl.MyBash.ShellCommand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMyBashParser.g:739:3: ( () ( (lv_name_8_0= ruleFunctionName ) ) (otherlv_9= LeftParenthesis otherlv_10= RightParenthesis ruleMaybeNewLine ) ( (lv_body_12_0= ruleShellCommand ) ) )
                    {
                    // InternalMyBashParser.g:739:3: ( () ( (lv_name_8_0= ruleFunctionName ) ) (otherlv_9= LeftParenthesis otherlv_10= RightParenthesis ruleMaybeNewLine ) ( (lv_body_12_0= ruleShellCommand ) ) )
                    // InternalMyBashParser.g:740:4: () ( (lv_name_8_0= ruleFunctionName ) ) (otherlv_9= LeftParenthesis otherlv_10= RightParenthesis ruleMaybeNewLine ) ( (lv_body_12_0= ruleShellCommand ) )
                    {
                    // InternalMyBashParser.g:740:4: ()
                    // InternalMyBashParser.g:741:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getFunctionDefineAccess().getFunctionDefineAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalMyBashParser.g:747:4: ( (lv_name_8_0= ruleFunctionName ) )
                    // InternalMyBashParser.g:748:5: (lv_name_8_0= ruleFunctionName )
                    {
                    // InternalMyBashParser.g:748:5: (lv_name_8_0= ruleFunctionName )
                    // InternalMyBashParser.g:749:6: lv_name_8_0= ruleFunctionName
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFunctionDefineAccess().getNameFunctionNameParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_14);
                    lv_name_8_0=ruleFunctionName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFunctionDefineRule());
                      						}
                      						set(
                      							current,
                      							"name",
                      							lv_name_8_0,
                      							"org.xtext.example.mydsl.MyBash.FunctionName");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalMyBashParser.g:766:4: (otherlv_9= LeftParenthesis otherlv_10= RightParenthesis ruleMaybeNewLine )
                    // InternalMyBashParser.g:767:5: otherlv_9= LeftParenthesis otherlv_10= RightParenthesis ruleMaybeNewLine
                    {
                    otherlv_9=(Token)match(input,LeftParenthesis,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_9, grammarAccess.getFunctionDefineAccess().getLeftParenthesisKeyword_1_2_0());
                      				
                    }
                    otherlv_10=(Token)match(input,RightParenthesis,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_10, grammarAccess.getFunctionDefineAccess().getRightParenthesisKeyword_1_2_1());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getFunctionDefineAccess().getMaybeNewLineParserRuleCall_1_2_2());
                      				
                    }
                    pushFollow(FOLLOW_5);
                    ruleMaybeNewLine();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }

                    // InternalMyBashParser.g:783:4: ( (lv_body_12_0= ruleShellCommand ) )
                    // InternalMyBashParser.g:784:5: (lv_body_12_0= ruleShellCommand )
                    {
                    // InternalMyBashParser.g:784:5: (lv_body_12_0= ruleShellCommand )
                    // InternalMyBashParser.g:785:6: lv_body_12_0= ruleShellCommand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFunctionDefineAccess().getBodyShellCommandParserRuleCall_1_3_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_body_12_0=ruleShellCommand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFunctionDefineRule());
                      						}
                      						set(
                      							current,
                      							"body",
                      							lv_body_12_0,
                      							"org.xtext.example.mydsl.MyBash.ShellCommand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionDefine"


    // $ANTLR start "entryRuleSimpleCommand"
    // InternalMyBashParser.g:807:1: entryRuleSimpleCommand returns [EObject current=null] : iv_ruleSimpleCommand= ruleSimpleCommand EOF ;
    public final EObject entryRuleSimpleCommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleCommand = null;


        try {
            // InternalMyBashParser.g:807:54: (iv_ruleSimpleCommand= ruleSimpleCommand EOF )
            // InternalMyBashParser.g:808:2: iv_ruleSimpleCommand= ruleSimpleCommand EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSimpleCommandRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSimpleCommand=ruleSimpleCommand();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSimpleCommand; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleCommand"


    // $ANTLR start "ruleSimpleCommand"
    // InternalMyBashParser.g:814:1: ruleSimpleCommand returns [EObject current=null] : ( ( ( (lv_assignments_0_0= ruleAssignment ) )+ ( ( (lv_command_1_0= ruleCommandName ) ) ( ( (lv_parameters_2_0= ruleWord ) ) | ( (lv_r_3_0= ruleRedirection ) ) )* )? ) | ( ( (lv_command_4_0= ruleCommandName ) ) ( ( ( (lv_parameters_5_1= ruleWord | lv_parameters_5_2= ruleLAssignment ) ) ) | ( (lv_r_6_0= ruleRedirection ) ) )* ) | ( (lv_r_7_0= ruleRedirection ) )+ ) ;
    public final EObject ruleSimpleCommand() throws RecognitionException {
        EObject current = null;

        EObject lv_assignments_0_0 = null;

        EObject lv_command_1_0 = null;

        EObject lv_parameters_2_0 = null;

        EObject lv_r_3_0 = null;

        EObject lv_command_4_0 = null;

        EObject lv_parameters_5_1 = null;

        EObject lv_parameters_5_2 = null;

        EObject lv_r_6_0 = null;

        EObject lv_r_7_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:820:2: ( ( ( ( (lv_assignments_0_0= ruleAssignment ) )+ ( ( (lv_command_1_0= ruleCommandName ) ) ( ( (lv_parameters_2_0= ruleWord ) ) | ( (lv_r_3_0= ruleRedirection ) ) )* )? ) | ( ( (lv_command_4_0= ruleCommandName ) ) ( ( ( (lv_parameters_5_1= ruleWord | lv_parameters_5_2= ruleLAssignment ) ) ) | ( (lv_r_6_0= ruleRedirection ) ) )* ) | ( (lv_r_7_0= ruleRedirection ) )+ ) )
            // InternalMyBashParser.g:821:2: ( ( ( (lv_assignments_0_0= ruleAssignment ) )+ ( ( (lv_command_1_0= ruleCommandName ) ) ( ( (lv_parameters_2_0= ruleWord ) ) | ( (lv_r_3_0= ruleRedirection ) ) )* )? ) | ( ( (lv_command_4_0= ruleCommandName ) ) ( ( ( (lv_parameters_5_1= ruleWord | lv_parameters_5_2= ruleLAssignment ) ) ) | ( (lv_r_6_0= ruleRedirection ) ) )* ) | ( (lv_r_7_0= ruleRedirection ) )+ )
            {
            // InternalMyBashParser.g:821:2: ( ( ( (lv_assignments_0_0= ruleAssignment ) )+ ( ( (lv_command_1_0= ruleCommandName ) ) ( ( (lv_parameters_2_0= ruleWord ) ) | ( (lv_r_3_0= ruleRedirection ) ) )* )? ) | ( ( (lv_command_4_0= ruleCommandName ) ) ( ( ( (lv_parameters_5_1= ruleWord | lv_parameters_5_2= ruleLAssignment ) ) ) | ( (lv_r_6_0= ruleRedirection ) ) )* ) | ( (lv_r_7_0= ruleRedirection ) )+ )
            int alt24=3;
            switch ( input.LA(1) ) {
            case RULE_NAME:
                {
                alt24=1;
                }
                break;
            case DollarSignLeftParenthesisLeftParenthesis:
            case DollarSignLeftCurlyBracket:
            case LessThanSignLeftParenthesis:
            case GreaterThanSignLeftParenthesis:
            case QuotationMark:
            case Apostrophe:
            case RULE_S_WORD_PART:
            case RULE_WORD_PART:
            case RULE_VARIABLE:
            case RULE_CS_START:
                {
                alt24=2;
                }
                break;
            case AmpersandGreaterThanSignGreaterThanSign:
            case AmpersandGreaterThanSign:
            case LessThanSignAmpersand:
            case LessThanSignLessThanSign:
            case LessThanSignGreaterThanSign:
            case LessThanSignVerticalLine:
            case GreaterThanSignAmpersand:
            case GreaterThanSignGreaterThanSign:
            case GreaterThanSignVerticalLine:
            case LessThanSign:
            case GreaterThanSign:
            case RULE_I_NUMBER:
                {
                alt24=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // InternalMyBashParser.g:822:3: ( ( (lv_assignments_0_0= ruleAssignment ) )+ ( ( (lv_command_1_0= ruleCommandName ) ) ( ( (lv_parameters_2_0= ruleWord ) ) | ( (lv_r_3_0= ruleRedirection ) ) )* )? )
                    {
                    // InternalMyBashParser.g:822:3: ( ( (lv_assignments_0_0= ruleAssignment ) )+ ( ( (lv_command_1_0= ruleCommandName ) ) ( ( (lv_parameters_2_0= ruleWord ) ) | ( (lv_r_3_0= ruleRedirection ) ) )* )? )
                    // InternalMyBashParser.g:823:4: ( (lv_assignments_0_0= ruleAssignment ) )+ ( ( (lv_command_1_0= ruleCommandName ) ) ( ( (lv_parameters_2_0= ruleWord ) ) | ( (lv_r_3_0= ruleRedirection ) ) )* )?
                    {
                    // InternalMyBashParser.g:823:4: ( (lv_assignments_0_0= ruleAssignment ) )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==RULE_NAME) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalMyBashParser.g:824:5: (lv_assignments_0_0= ruleAssignment )
                    	    {
                    	    // InternalMyBashParser.g:824:5: (lv_assignments_0_0= ruleAssignment )
                    	    // InternalMyBashParser.g:825:6: lv_assignments_0_0= ruleAssignment
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getSimpleCommandAccess().getAssignmentsAssignmentParserRuleCall_0_0_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_15);
                    	    lv_assignments_0_0=ruleAssignment();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getSimpleCommandRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"assignments",
                    	      							lv_assignments_0_0,
                    	      							"org.xtext.example.mydsl.MyBash.Assignment");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt18 >= 1 ) break loop18;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(18, input);
                                throw eee;
                        }
                        cnt18++;
                    } while (true);

                    // InternalMyBashParser.g:842:4: ( ( (lv_command_1_0= ruleCommandName ) ) ( ( (lv_parameters_2_0= ruleWord ) ) | ( (lv_r_3_0= ruleRedirection ) ) )* )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==DollarSignLeftParenthesisLeftParenthesis||LA20_0==DollarSignLeftCurlyBracket||LA20_0==LessThanSignLeftParenthesis||LA20_0==GreaterThanSignLeftParenthesis||LA20_0==QuotationMark||LA20_0==Apostrophe||(LA20_0>=RULE_S_WORD_PART && LA20_0<=RULE_WORD_PART)||LA20_0==RULE_VARIABLE||LA20_0==RULE_CS_START) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // InternalMyBashParser.g:843:5: ( (lv_command_1_0= ruleCommandName ) ) ( ( (lv_parameters_2_0= ruleWord ) ) | ( (lv_r_3_0= ruleRedirection ) ) )*
                            {
                            // InternalMyBashParser.g:843:5: ( (lv_command_1_0= ruleCommandName ) )
                            // InternalMyBashParser.g:844:6: (lv_command_1_0= ruleCommandName )
                            {
                            // InternalMyBashParser.g:844:6: (lv_command_1_0= ruleCommandName )
                            // InternalMyBashParser.g:845:7: lv_command_1_0= ruleCommandName
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getSimpleCommandAccess().getCommandCommandNameParserRuleCall_0_1_0_0());
                              						
                            }
                            pushFollow(FOLLOW_11);
                            lv_command_1_0=ruleCommandName();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getSimpleCommandRule());
                              							}
                              							set(
                              								current,
                              								"command",
                              								lv_command_1_0,
                              								"org.xtext.example.mydsl.MyBash.CommandName");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }

                            // InternalMyBashParser.g:862:5: ( ( (lv_parameters_2_0= ruleWord ) ) | ( (lv_r_3_0= ruleRedirection ) ) )*
                            loop19:
                            do {
                                int alt19=3;
                                int LA19_0 = input.LA(1);

                                if ( (LA19_0==DollarSignLeftParenthesisLeftParenthesis||LA19_0==DollarSignLeftCurlyBracket||LA19_0==LessThanSignLeftParenthesis||LA19_0==GreaterThanSignLeftParenthesis||LA19_0==QuotationMark||LA19_0==Apostrophe||(LA19_0>=RULE_S_WORD_PART && LA19_0<=RULE_WORD_PART)||LA19_0==RULE_VARIABLE||LA19_0==RULE_CS_START) ) {
                                    alt19=1;
                                }
                                else if ( (LA19_0==AmpersandGreaterThanSignGreaterThanSign||LA19_0==AmpersandGreaterThanSign||LA19_0==LessThanSignAmpersand||LA19_0==LessThanSignLessThanSign||(LA19_0>=LessThanSignGreaterThanSign && LA19_0<=LessThanSignVerticalLine)||LA19_0==GreaterThanSignAmpersand||(LA19_0>=GreaterThanSignGreaterThanSign && LA19_0<=GreaterThanSignVerticalLine)||LA19_0==LessThanSign||LA19_0==GreaterThanSign||LA19_0==RULE_I_NUMBER) ) {
                                    alt19=2;
                                }


                                switch (alt19) {
                            	case 1 :
                            	    // InternalMyBashParser.g:863:6: ( (lv_parameters_2_0= ruleWord ) )
                            	    {
                            	    // InternalMyBashParser.g:863:6: ( (lv_parameters_2_0= ruleWord ) )
                            	    // InternalMyBashParser.g:864:7: (lv_parameters_2_0= ruleWord )
                            	    {
                            	    // InternalMyBashParser.g:864:7: (lv_parameters_2_0= ruleWord )
                            	    // InternalMyBashParser.g:865:8: lv_parameters_2_0= ruleWord
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								newCompositeNode(grammarAccess.getSimpleCommandAccess().getParametersWordParserRuleCall_0_1_1_0_0());
                            	      							
                            	    }
                            	    pushFollow(FOLLOW_11);
                            	    lv_parameters_2_0=ruleWord();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      								if (current==null) {
                            	      									current = createModelElementForParent(grammarAccess.getSimpleCommandRule());
                            	      								}
                            	      								add(
                            	      									current,
                            	      									"parameters",
                            	      									lv_parameters_2_0,
                            	      									"org.xtext.example.mydsl.MyBash.Word");
                            	      								afterParserOrEnumRuleCall();
                            	      							
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;
                            	case 2 :
                            	    // InternalMyBashParser.g:883:6: ( (lv_r_3_0= ruleRedirection ) )
                            	    {
                            	    // InternalMyBashParser.g:883:6: ( (lv_r_3_0= ruleRedirection ) )
                            	    // InternalMyBashParser.g:884:7: (lv_r_3_0= ruleRedirection )
                            	    {
                            	    // InternalMyBashParser.g:884:7: (lv_r_3_0= ruleRedirection )
                            	    // InternalMyBashParser.g:885:8: lv_r_3_0= ruleRedirection
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								newCompositeNode(grammarAccess.getSimpleCommandAccess().getRRedirectionParserRuleCall_0_1_1_1_0());
                            	      							
                            	    }
                            	    pushFollow(FOLLOW_11);
                            	    lv_r_3_0=ruleRedirection();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      								if (current==null) {
                            	      									current = createModelElementForParent(grammarAccess.getSimpleCommandRule());
                            	      								}
                            	      								add(
                            	      									current,
                            	      									"r",
                            	      									lv_r_3_0,
                            	      									"org.xtext.example.mydsl.MyBash.Redirection");
                            	      								afterParserOrEnumRuleCall();
                            	      							
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop19;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMyBashParser.g:906:3: ( ( (lv_command_4_0= ruleCommandName ) ) ( ( ( (lv_parameters_5_1= ruleWord | lv_parameters_5_2= ruleLAssignment ) ) ) | ( (lv_r_6_0= ruleRedirection ) ) )* )
                    {
                    // InternalMyBashParser.g:906:3: ( ( (lv_command_4_0= ruleCommandName ) ) ( ( ( (lv_parameters_5_1= ruleWord | lv_parameters_5_2= ruleLAssignment ) ) ) | ( (lv_r_6_0= ruleRedirection ) ) )* )
                    // InternalMyBashParser.g:907:4: ( (lv_command_4_0= ruleCommandName ) ) ( ( ( (lv_parameters_5_1= ruleWord | lv_parameters_5_2= ruleLAssignment ) ) ) | ( (lv_r_6_0= ruleRedirection ) ) )*
                    {
                    // InternalMyBashParser.g:907:4: ( (lv_command_4_0= ruleCommandName ) )
                    // InternalMyBashParser.g:908:5: (lv_command_4_0= ruleCommandName )
                    {
                    // InternalMyBashParser.g:908:5: (lv_command_4_0= ruleCommandName )
                    // InternalMyBashParser.g:909:6: lv_command_4_0= ruleCommandName
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSimpleCommandAccess().getCommandCommandNameParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FOLLOW_11);
                    lv_command_4_0=ruleCommandName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getSimpleCommandRule());
                      						}
                      						set(
                      							current,
                      							"command",
                      							lv_command_4_0,
                      							"org.xtext.example.mydsl.MyBash.CommandName");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalMyBashParser.g:926:4: ( ( ( (lv_parameters_5_1= ruleWord | lv_parameters_5_2= ruleLAssignment ) ) ) | ( (lv_r_6_0= ruleRedirection ) ) )*
                    loop22:
                    do {
                        int alt22=3;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==DollarSignLeftParenthesisLeftParenthesis||LA22_0==DollarSignLeftCurlyBracket||LA22_0==LessThanSignLeftParenthesis||LA22_0==GreaterThanSignLeftParenthesis||LA22_0==QuotationMark||LA22_0==Apostrophe||(LA22_0>=RULE_NAME && LA22_0<=RULE_WORD_PART)||LA22_0==RULE_VARIABLE||LA22_0==RULE_CS_START) ) {
                            alt22=1;
                        }
                        else if ( (LA22_0==AmpersandGreaterThanSignGreaterThanSign||LA22_0==AmpersandGreaterThanSign||LA22_0==LessThanSignAmpersand||LA22_0==LessThanSignLessThanSign||(LA22_0>=LessThanSignGreaterThanSign && LA22_0<=LessThanSignVerticalLine)||LA22_0==GreaterThanSignAmpersand||(LA22_0>=GreaterThanSignGreaterThanSign && LA22_0<=GreaterThanSignVerticalLine)||LA22_0==LessThanSign||LA22_0==GreaterThanSign||LA22_0==RULE_I_NUMBER) ) {
                            alt22=2;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // InternalMyBashParser.g:927:5: ( ( (lv_parameters_5_1= ruleWord | lv_parameters_5_2= ruleLAssignment ) ) )
                    	    {
                    	    // InternalMyBashParser.g:927:5: ( ( (lv_parameters_5_1= ruleWord | lv_parameters_5_2= ruleLAssignment ) ) )
                    	    // InternalMyBashParser.g:928:6: ( (lv_parameters_5_1= ruleWord | lv_parameters_5_2= ruleLAssignment ) )
                    	    {
                    	    // InternalMyBashParser.g:928:6: ( (lv_parameters_5_1= ruleWord | lv_parameters_5_2= ruleLAssignment ) )
                    	    // InternalMyBashParser.g:929:7: (lv_parameters_5_1= ruleWord | lv_parameters_5_2= ruleLAssignment )
                    	    {
                    	    // InternalMyBashParser.g:929:7: (lv_parameters_5_1= ruleWord | lv_parameters_5_2= ruleLAssignment )
                    	    int alt21=2;
                    	    int LA21_0 = input.LA(1);

                    	    if ( (LA21_0==DollarSignLeftParenthesisLeftParenthesis||LA21_0==DollarSignLeftCurlyBracket||LA21_0==LessThanSignLeftParenthesis||LA21_0==GreaterThanSignLeftParenthesis||LA21_0==QuotationMark||LA21_0==Apostrophe||(LA21_0>=RULE_S_WORD_PART && LA21_0<=RULE_WORD_PART)||LA21_0==RULE_VARIABLE||LA21_0==RULE_CS_START) ) {
                    	        alt21=1;
                    	    }
                    	    else if ( (LA21_0==RULE_NAME) ) {
                    	        alt21=2;
                    	    }
                    	    else {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 21, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt21) {
                    	        case 1 :
                    	            // InternalMyBashParser.g:930:8: lv_parameters_5_1= ruleWord
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              								newCompositeNode(grammarAccess.getSimpleCommandAccess().getParametersWordParserRuleCall_1_1_0_0_0());
                    	              							
                    	            }
                    	            pushFollow(FOLLOW_11);
                    	            lv_parameters_5_1=ruleWord();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								if (current==null) {
                    	              									current = createModelElementForParent(grammarAccess.getSimpleCommandRule());
                    	              								}
                    	              								add(
                    	              									current,
                    	              									"parameters",
                    	              									lv_parameters_5_1,
                    	              									"org.xtext.example.mydsl.MyBash.Word");
                    	              								afterParserOrEnumRuleCall();
                    	              							
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // InternalMyBashParser.g:946:8: lv_parameters_5_2= ruleLAssignment
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              								newCompositeNode(grammarAccess.getSimpleCommandAccess().getParametersLAssignmentParserRuleCall_1_1_0_0_1());
                    	              							
                    	            }
                    	            pushFollow(FOLLOW_11);
                    	            lv_parameters_5_2=ruleLAssignment();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								if (current==null) {
                    	              									current = createModelElementForParent(grammarAccess.getSimpleCommandRule());
                    	              								}
                    	              								add(
                    	              									current,
                    	              									"parameters",
                    	              									lv_parameters_5_2,
                    	              									"org.xtext.example.mydsl.MyBash.LAssignment");
                    	              								afterParserOrEnumRuleCall();
                    	              							
                    	            }

                    	            }
                    	            break;

                    	    }


                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalMyBashParser.g:965:5: ( (lv_r_6_0= ruleRedirection ) )
                    	    {
                    	    // InternalMyBashParser.g:965:5: ( (lv_r_6_0= ruleRedirection ) )
                    	    // InternalMyBashParser.g:966:6: (lv_r_6_0= ruleRedirection )
                    	    {
                    	    // InternalMyBashParser.g:966:6: (lv_r_6_0= ruleRedirection )
                    	    // InternalMyBashParser.g:967:7: lv_r_6_0= ruleRedirection
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getSimpleCommandAccess().getRRedirectionParserRuleCall_1_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_11);
                    	    lv_r_6_0=ruleRedirection();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getSimpleCommandRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"r",
                    	      								lv_r_6_0,
                    	      								"org.xtext.example.mydsl.MyBash.Redirection");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 3 :
                    // InternalMyBashParser.g:987:3: ( (lv_r_7_0= ruleRedirection ) )+
                    {
                    // InternalMyBashParser.g:987:3: ( (lv_r_7_0= ruleRedirection ) )+
                    int cnt23=0;
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==AmpersandGreaterThanSignGreaterThanSign||LA23_0==AmpersandGreaterThanSign||LA23_0==LessThanSignAmpersand||LA23_0==LessThanSignLessThanSign||(LA23_0>=LessThanSignGreaterThanSign && LA23_0<=LessThanSignVerticalLine)||LA23_0==GreaterThanSignAmpersand||(LA23_0>=GreaterThanSignGreaterThanSign && LA23_0<=GreaterThanSignVerticalLine)||LA23_0==LessThanSign||LA23_0==GreaterThanSign||LA23_0==RULE_I_NUMBER) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // InternalMyBashParser.g:988:4: (lv_r_7_0= ruleRedirection )
                    	    {
                    	    // InternalMyBashParser.g:988:4: (lv_r_7_0= ruleRedirection )
                    	    // InternalMyBashParser.g:989:5: lv_r_7_0= ruleRedirection
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					newCompositeNode(grammarAccess.getSimpleCommandAccess().getRRedirectionParserRuleCall_2_0());
                    	      				
                    	    }
                    	    pushFollow(FOLLOW_11);
                    	    lv_r_7_0=ruleRedirection();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					if (current==null) {
                    	      						current = createModelElementForParent(grammarAccess.getSimpleCommandRule());
                    	      					}
                    	      					add(
                    	      						current,
                    	      						"r",
                    	      						lv_r_7_0,
                    	      						"org.xtext.example.mydsl.MyBash.Redirection");
                    	      					afterParserOrEnumRuleCall();
                    	      				
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt23 >= 1 ) break loop23;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(23, input);
                                throw eee;
                        }
                        cnt23++;
                    } while (true);


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpleCommand"


    // $ANTLR start "entryRuleShellCommand"
    // InternalMyBashParser.g:1010:1: entryRuleShellCommand returns [EObject current=null] : iv_ruleShellCommand= ruleShellCommand EOF ;
    public final EObject entryRuleShellCommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShellCommand = null;


        try {
            // InternalMyBashParser.g:1010:53: (iv_ruleShellCommand= ruleShellCommand EOF )
            // InternalMyBashParser.g:1011:2: iv_ruleShellCommand= ruleShellCommand EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getShellCommandRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleShellCommand=ruleShellCommand();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleShellCommand; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleShellCommand"


    // $ANTLR start "ruleShellCommand"
    // InternalMyBashParser.g:1017:1: ruleShellCommand returns [EObject current=null] : (this_GroupCommand_0= ruleGroupCommand | this_IfStatement_1= ruleIfStatement | this_WhileStatement_2= ruleWhileStatement | this_ForStatement_3= ruleForStatement | this_CaseStatement_4= ruleCaseStatement | this_Subshell_5= ruleSubshell | this_CondCommand_6= ruleCondCommand | this_ArithmeticCommand_7= ruleArithmeticCommand ) ;
    public final EObject ruleShellCommand() throws RecognitionException {
        EObject current = null;

        EObject this_GroupCommand_0 = null;

        EObject this_IfStatement_1 = null;

        EObject this_WhileStatement_2 = null;

        EObject this_ForStatement_3 = null;

        EObject this_CaseStatement_4 = null;

        EObject this_Subshell_5 = null;

        EObject this_CondCommand_6 = null;

        EObject this_ArithmeticCommand_7 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:1023:2: ( (this_GroupCommand_0= ruleGroupCommand | this_IfStatement_1= ruleIfStatement | this_WhileStatement_2= ruleWhileStatement | this_ForStatement_3= ruleForStatement | this_CaseStatement_4= ruleCaseStatement | this_Subshell_5= ruleSubshell | this_CondCommand_6= ruleCondCommand | this_ArithmeticCommand_7= ruleArithmeticCommand ) )
            // InternalMyBashParser.g:1024:2: (this_GroupCommand_0= ruleGroupCommand | this_IfStatement_1= ruleIfStatement | this_WhileStatement_2= ruleWhileStatement | this_ForStatement_3= ruleForStatement | this_CaseStatement_4= ruleCaseStatement | this_Subshell_5= ruleSubshell | this_CondCommand_6= ruleCondCommand | this_ArithmeticCommand_7= ruleArithmeticCommand )
            {
            // InternalMyBashParser.g:1024:2: (this_GroupCommand_0= ruleGroupCommand | this_IfStatement_1= ruleIfStatement | this_WhileStatement_2= ruleWhileStatement | this_ForStatement_3= ruleForStatement | this_CaseStatement_4= ruleCaseStatement | this_Subshell_5= ruleSubshell | this_CondCommand_6= ruleCondCommand | this_ArithmeticCommand_7= ruleArithmeticCommand )
            int alt25=8;
            switch ( input.LA(1) ) {
            case LeftCurlyBracket:
                {
                alt25=1;
                }
                break;
            case If:
                {
                alt25=2;
                }
                break;
            case While:
                {
                alt25=3;
                }
                break;
            case For:
                {
                alt25=4;
                }
                break;
            case Case:
                {
                alt25=5;
                }
                break;
            case LeftParenthesis:
                {
                alt25=6;
                }
                break;
            case LeftSquareBracketLeftSquareBracket:
                {
                alt25=7;
                }
                break;
            case LeftParenthesisLeftParenthesis:
                {
                alt25=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // InternalMyBashParser.g:1025:3: this_GroupCommand_0= ruleGroupCommand
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getShellCommandAccess().getGroupCommandParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_GroupCommand_0=ruleGroupCommand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_GroupCommand_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalMyBashParser.g:1034:3: this_IfStatement_1= ruleIfStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getShellCommandAccess().getIfStatementParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_IfStatement_1=ruleIfStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_IfStatement_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalMyBashParser.g:1043:3: this_WhileStatement_2= ruleWhileStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getShellCommandAccess().getWhileStatementParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_WhileStatement_2=ruleWhileStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_WhileStatement_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalMyBashParser.g:1052:3: this_ForStatement_3= ruleForStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getShellCommandAccess().getForStatementParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ForStatement_3=ruleForStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ForStatement_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalMyBashParser.g:1061:3: this_CaseStatement_4= ruleCaseStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getShellCommandAccess().getCaseStatementParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_CaseStatement_4=ruleCaseStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_CaseStatement_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalMyBashParser.g:1070:3: this_Subshell_5= ruleSubshell
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getShellCommandAccess().getSubshellParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Subshell_5=ruleSubshell();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Subshell_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalMyBashParser.g:1079:3: this_CondCommand_6= ruleCondCommand
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getShellCommandAccess().getCondCommandParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_CondCommand_6=ruleCondCommand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_CondCommand_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalMyBashParser.g:1088:3: this_ArithmeticCommand_7= ruleArithmeticCommand
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getShellCommandAccess().getArithmeticCommandParserRuleCall_7());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ArithmeticCommand_7=ruleArithmeticCommand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ArithmeticCommand_7;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleShellCommand"


    // $ANTLR start "entryRuleGroupCommand"
    // InternalMyBashParser.g:1100:1: entryRuleGroupCommand returns [EObject current=null] : iv_ruleGroupCommand= ruleGroupCommand EOF ;
    public final EObject entryRuleGroupCommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupCommand = null;


        try {
            // InternalMyBashParser.g:1100:53: (iv_ruleGroupCommand= ruleGroupCommand EOF )
            // InternalMyBashParser.g:1101:2: iv_ruleGroupCommand= ruleGroupCommand EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGroupCommandRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleGroupCommand=ruleGroupCommand();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGroupCommand; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGroupCommand"


    // $ANTLR start "ruleGroupCommand"
    // InternalMyBashParser.g:1107:1: ruleGroupCommand returns [EObject current=null] : ( () otherlv_1= LeftCurlyBracket ( (lv_body_2_0= ruleCompoundList ) ) otherlv_3= RightCurlyBracket ) ;
    public final EObject ruleGroupCommand() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_body_2_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:1113:2: ( ( () otherlv_1= LeftCurlyBracket ( (lv_body_2_0= ruleCompoundList ) ) otherlv_3= RightCurlyBracket ) )
            // InternalMyBashParser.g:1114:2: ( () otherlv_1= LeftCurlyBracket ( (lv_body_2_0= ruleCompoundList ) ) otherlv_3= RightCurlyBracket )
            {
            // InternalMyBashParser.g:1114:2: ( () otherlv_1= LeftCurlyBracket ( (lv_body_2_0= ruleCompoundList ) ) otherlv_3= RightCurlyBracket )
            // InternalMyBashParser.g:1115:3: () otherlv_1= LeftCurlyBracket ( (lv_body_2_0= ruleCompoundList ) ) otherlv_3= RightCurlyBracket
            {
            // InternalMyBashParser.g:1115:3: ()
            // InternalMyBashParser.g:1116:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getGroupCommandAccess().getGroupCommandAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,LeftCurlyBracket,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getGroupCommandAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalMyBashParser.g:1126:3: ( (lv_body_2_0= ruleCompoundList ) )
            // InternalMyBashParser.g:1127:4: (lv_body_2_0= ruleCompoundList )
            {
            // InternalMyBashParser.g:1127:4: (lv_body_2_0= ruleCompoundList )
            // InternalMyBashParser.g:1128:5: lv_body_2_0= ruleCompoundList
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getGroupCommandAccess().getBodyCompoundListParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_16);
            lv_body_2_0=ruleCompoundList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getGroupCommandRule());
              					}
              					set(
              						current,
              						"body",
              						lv_body_2_0,
              						"org.xtext.example.mydsl.MyBash.CompoundList");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,RightCurlyBracket,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getGroupCommandAccess().getRightCurlyBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGroupCommand"


    // $ANTLR start "entryRuleCondCommand"
    // InternalMyBashParser.g:1153:1: entryRuleCondCommand returns [EObject current=null] : iv_ruleCondCommand= ruleCondCommand EOF ;
    public final EObject entryRuleCondCommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondCommand = null;


        try {
            // InternalMyBashParser.g:1153:52: (iv_ruleCondCommand= ruleCondCommand EOF )
            // InternalMyBashParser.g:1154:2: iv_ruleCondCommand= ruleCondCommand EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCondCommandRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCondCommand=ruleCondCommand();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCondCommand; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCondCommand"


    // $ANTLR start "ruleCondCommand"
    // InternalMyBashParser.g:1160:1: ruleCondCommand returns [EObject current=null] : (otherlv_0= LeftSquareBracketLeftSquareBracket ( (lv_expression_1_0= ruleCondOrAnd ) ) otherlv_2= RightSquareBracketRightSquareBracket ) ;
    public final EObject ruleCondCommand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_expression_1_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:1166:2: ( (otherlv_0= LeftSquareBracketLeftSquareBracket ( (lv_expression_1_0= ruleCondOrAnd ) ) otherlv_2= RightSquareBracketRightSquareBracket ) )
            // InternalMyBashParser.g:1167:2: (otherlv_0= LeftSquareBracketLeftSquareBracket ( (lv_expression_1_0= ruleCondOrAnd ) ) otherlv_2= RightSquareBracketRightSquareBracket )
            {
            // InternalMyBashParser.g:1167:2: (otherlv_0= LeftSquareBracketLeftSquareBracket ( (lv_expression_1_0= ruleCondOrAnd ) ) otherlv_2= RightSquareBracketRightSquareBracket )
            // InternalMyBashParser.g:1168:3: otherlv_0= LeftSquareBracketLeftSquareBracket ( (lv_expression_1_0= ruleCondOrAnd ) ) otherlv_2= RightSquareBracketRightSquareBracket
            {
            otherlv_0=(Token)match(input,LeftSquareBracketLeftSquareBracket,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getCondCommandAccess().getLeftSquareBracketLeftSquareBracketKeyword_0());
              		
            }
            // InternalMyBashParser.g:1172:3: ( (lv_expression_1_0= ruleCondOrAnd ) )
            // InternalMyBashParser.g:1173:4: (lv_expression_1_0= ruleCondOrAnd )
            {
            // InternalMyBashParser.g:1173:4: (lv_expression_1_0= ruleCondOrAnd )
            // InternalMyBashParser.g:1174:5: lv_expression_1_0= ruleCondOrAnd
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCondCommandAccess().getExpressionCondOrAndParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_18);
            lv_expression_1_0=ruleCondOrAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCondCommandRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_1_0,
              						"org.xtext.example.mydsl.MyBash.CondOrAnd");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,RightSquareBracketRightSquareBracket,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getCondCommandAccess().getRightSquareBracketRightSquareBracketKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCondCommand"


    // $ANTLR start "entryRuleArithmeticCommand"
    // InternalMyBashParser.g:1199:1: entryRuleArithmeticCommand returns [EObject current=null] : iv_ruleArithmeticCommand= ruleArithmeticCommand EOF ;
    public final EObject entryRuleArithmeticCommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArithmeticCommand = null;


        try {
            // InternalMyBashParser.g:1199:58: (iv_ruleArithmeticCommand= ruleArithmeticCommand EOF )
            // InternalMyBashParser.g:1200:2: iv_ruleArithmeticCommand= ruleArithmeticCommand EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArithmeticCommandRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleArithmeticCommand=ruleArithmeticCommand();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArithmeticCommand; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArithmeticCommand"


    // $ANTLR start "ruleArithmeticCommand"
    // InternalMyBashParser.g:1206:1: ruleArithmeticCommand returns [EObject current=null] : (otherlv_0= LeftParenthesisLeftParenthesis ( (lv_expression_1_0= ruleEvaluation ) ) otherlv_2= RightParenthesisRightParenthesis ) ;
    public final EObject ruleArithmeticCommand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_expression_1_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:1212:2: ( (otherlv_0= LeftParenthesisLeftParenthesis ( (lv_expression_1_0= ruleEvaluation ) ) otherlv_2= RightParenthesisRightParenthesis ) )
            // InternalMyBashParser.g:1213:2: (otherlv_0= LeftParenthesisLeftParenthesis ( (lv_expression_1_0= ruleEvaluation ) ) otherlv_2= RightParenthesisRightParenthesis )
            {
            // InternalMyBashParser.g:1213:2: (otherlv_0= LeftParenthesisLeftParenthesis ( (lv_expression_1_0= ruleEvaluation ) ) otherlv_2= RightParenthesisRightParenthesis )
            // InternalMyBashParser.g:1214:3: otherlv_0= LeftParenthesisLeftParenthesis ( (lv_expression_1_0= ruleEvaluation ) ) otherlv_2= RightParenthesisRightParenthesis
            {
            otherlv_0=(Token)match(input,LeftParenthesisLeftParenthesis,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getArithmeticCommandAccess().getLeftParenthesisLeftParenthesisKeyword_0());
              		
            }
            // InternalMyBashParser.g:1218:3: ( (lv_expression_1_0= ruleEvaluation ) )
            // InternalMyBashParser.g:1219:4: (lv_expression_1_0= ruleEvaluation )
            {
            // InternalMyBashParser.g:1219:4: (lv_expression_1_0= ruleEvaluation )
            // InternalMyBashParser.g:1220:5: lv_expression_1_0= ruleEvaluation
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getArithmeticCommandAccess().getExpressionEvaluationParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_20);
            lv_expression_1_0=ruleEvaluation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getArithmeticCommandRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_1_0,
              						"org.xtext.example.mydsl.MyBash.Evaluation");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,RightParenthesisRightParenthesis,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getArithmeticCommandAccess().getRightParenthesisRightParenthesisKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArithmeticCommand"


    // $ANTLR start "entryRuleSubshell"
    // InternalMyBashParser.g:1245:1: entryRuleSubshell returns [EObject current=null] : iv_ruleSubshell= ruleSubshell EOF ;
    public final EObject entryRuleSubshell() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubshell = null;


        try {
            // InternalMyBashParser.g:1245:49: (iv_ruleSubshell= ruleSubshell EOF )
            // InternalMyBashParser.g:1246:2: iv_ruleSubshell= ruleSubshell EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSubshellRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSubshell=ruleSubshell();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSubshell; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubshell"


    // $ANTLR start "ruleSubshell"
    // InternalMyBashParser.g:1252:1: ruleSubshell returns [EObject current=null] : (otherlv_0= LeftParenthesis ( (lv_body_1_0= ruleCompoundList ) ) otherlv_2= RightParenthesis ) ;
    public final EObject ruleSubshell() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_body_1_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:1258:2: ( (otherlv_0= LeftParenthesis ( (lv_body_1_0= ruleCompoundList ) ) otherlv_2= RightParenthesis ) )
            // InternalMyBashParser.g:1259:2: (otherlv_0= LeftParenthesis ( (lv_body_1_0= ruleCompoundList ) ) otherlv_2= RightParenthesis )
            {
            // InternalMyBashParser.g:1259:2: (otherlv_0= LeftParenthesis ( (lv_body_1_0= ruleCompoundList ) ) otherlv_2= RightParenthesis )
            // InternalMyBashParser.g:1260:3: otherlv_0= LeftParenthesis ( (lv_body_1_0= ruleCompoundList ) ) otherlv_2= RightParenthesis
            {
            otherlv_0=(Token)match(input,LeftParenthesis,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSubshellAccess().getLeftParenthesisKeyword_0());
              		
            }
            // InternalMyBashParser.g:1264:3: ( (lv_body_1_0= ruleCompoundList ) )
            // InternalMyBashParser.g:1265:4: (lv_body_1_0= ruleCompoundList )
            {
            // InternalMyBashParser.g:1265:4: (lv_body_1_0= ruleCompoundList )
            // InternalMyBashParser.g:1266:5: lv_body_1_0= ruleCompoundList
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSubshellAccess().getBodyCompoundListParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_13);
            lv_body_1_0=ruleCompoundList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getSubshellRule());
              					}
              					set(
              						current,
              						"body",
              						lv_body_1_0,
              						"org.xtext.example.mydsl.MyBash.CompoundList");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,RightParenthesis,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getSubshellAccess().getRightParenthesisKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubshell"


    // $ANTLR start "entryRuleCommandName"
    // InternalMyBashParser.g:1291:1: entryRuleCommandName returns [EObject current=null] : iv_ruleCommandName= ruleCommandName EOF ;
    public final EObject entryRuleCommandName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommandName = null;


        try {
            // InternalMyBashParser.g:1291:52: (iv_ruleCommandName= ruleCommandName EOF )
            // InternalMyBashParser.g:1292:2: iv_ruleCommandName= ruleCommandName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCommandNameRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCommandName=ruleCommandName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCommandName; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCommandName"


    // $ANTLR start "ruleCommandName"
    // InternalMyBashParser.g:1298:1: ruleCommandName returns [EObject current=null] : ( ( () ( ( ruleFunctionName ) ) ) | this_Words_2= ruleWords ) ;
    public final EObject ruleCommandName() throws RecognitionException {
        EObject current = null;

        EObject this_Words_2 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:1304:2: ( ( ( () ( ( ruleFunctionName ) ) ) | this_Words_2= ruleWords ) )
            // InternalMyBashParser.g:1305:2: ( ( () ( ( ruleFunctionName ) ) ) | this_Words_2= ruleWords )
            {
            // InternalMyBashParser.g:1305:2: ( ( () ( ( ruleFunctionName ) ) ) | this_Words_2= ruleWords )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_S_WORD_PART) ) {
                alt26=1;
            }
            else if ( (LA26_0==DollarSignLeftParenthesisLeftParenthesis||LA26_0==DollarSignLeftCurlyBracket||LA26_0==LessThanSignLeftParenthesis||LA26_0==GreaterThanSignLeftParenthesis||LA26_0==QuotationMark||LA26_0==Apostrophe||LA26_0==RULE_WORD_PART||LA26_0==RULE_VARIABLE||LA26_0==RULE_CS_START) ) {
                alt26=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // InternalMyBashParser.g:1306:3: ( () ( ( ruleFunctionName ) ) )
                    {
                    // InternalMyBashParser.g:1306:3: ( () ( ( ruleFunctionName ) ) )
                    // InternalMyBashParser.g:1307:4: () ( ( ruleFunctionName ) )
                    {
                    // InternalMyBashParser.g:1307:4: ()
                    // InternalMyBashParser.g:1308:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getCommandNameAccess().getCommandNameAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalMyBashParser.g:1314:4: ( ( ruleFunctionName ) )
                    // InternalMyBashParser.g:1315:5: ( ruleFunctionName )
                    {
                    // InternalMyBashParser.g:1315:5: ( ruleFunctionName )
                    // InternalMyBashParser.g:1316:6: ruleFunctionName
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getCommandNameRule());
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCommandNameAccess().getRefFunctionDefineCrossReference_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    ruleFunctionName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMyBashParser.g:1332:3: this_Words_2= ruleWords
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getCommandNameAccess().getWordsParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Words_2=ruleWords();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Words_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCommandName"


    // $ANTLR start "entryRuleCaseStatement"
    // InternalMyBashParser.g:1344:1: entryRuleCaseStatement returns [EObject current=null] : iv_ruleCaseStatement= ruleCaseStatement EOF ;
    public final EObject entryRuleCaseStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseStatement = null;


        try {
            // InternalMyBashParser.g:1344:54: (iv_ruleCaseStatement= ruleCaseStatement EOF )
            // InternalMyBashParser.g:1345:2: iv_ruleCaseStatement= ruleCaseStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCaseStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCaseStatement=ruleCaseStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCaseStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCaseStatement"


    // $ANTLR start "ruleCaseStatement"
    // InternalMyBashParser.g:1351:1: ruleCaseStatement returns [EObject current=null] : ( () otherlv_1= Case ( (lv_variable_2_0= ruleWord ) ) ruleMaybeNewLine otherlv_4= In ruleMaybeNewLine ( ( (lv_patterns_6_0= ruleCasePattern ) ) ( (lv_patterns_7_0= ruleCasePatternContinue ) )* ( (otherlv_8= SemicolonSemicolon | otherlv_9= SemicolonAmpersand | otherlv_10= SemicolonSemicolonAmpersand ) ruleMaybeNewLine )? )? otherlv_12= Esac ) ;
    public final EObject ruleCaseStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_variable_2_0 = null;

        EObject lv_patterns_6_0 = null;

        EObject lv_patterns_7_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:1357:2: ( ( () otherlv_1= Case ( (lv_variable_2_0= ruleWord ) ) ruleMaybeNewLine otherlv_4= In ruleMaybeNewLine ( ( (lv_patterns_6_0= ruleCasePattern ) ) ( (lv_patterns_7_0= ruleCasePatternContinue ) )* ( (otherlv_8= SemicolonSemicolon | otherlv_9= SemicolonAmpersand | otherlv_10= SemicolonSemicolonAmpersand ) ruleMaybeNewLine )? )? otherlv_12= Esac ) )
            // InternalMyBashParser.g:1358:2: ( () otherlv_1= Case ( (lv_variable_2_0= ruleWord ) ) ruleMaybeNewLine otherlv_4= In ruleMaybeNewLine ( ( (lv_patterns_6_0= ruleCasePattern ) ) ( (lv_patterns_7_0= ruleCasePatternContinue ) )* ( (otherlv_8= SemicolonSemicolon | otherlv_9= SemicolonAmpersand | otherlv_10= SemicolonSemicolonAmpersand ) ruleMaybeNewLine )? )? otherlv_12= Esac )
            {
            // InternalMyBashParser.g:1358:2: ( () otherlv_1= Case ( (lv_variable_2_0= ruleWord ) ) ruleMaybeNewLine otherlv_4= In ruleMaybeNewLine ( ( (lv_patterns_6_0= ruleCasePattern ) ) ( (lv_patterns_7_0= ruleCasePatternContinue ) )* ( (otherlv_8= SemicolonSemicolon | otherlv_9= SemicolonAmpersand | otherlv_10= SemicolonSemicolonAmpersand ) ruleMaybeNewLine )? )? otherlv_12= Esac )
            // InternalMyBashParser.g:1359:3: () otherlv_1= Case ( (lv_variable_2_0= ruleWord ) ) ruleMaybeNewLine otherlv_4= In ruleMaybeNewLine ( ( (lv_patterns_6_0= ruleCasePattern ) ) ( (lv_patterns_7_0= ruleCasePatternContinue ) )* ( (otherlv_8= SemicolonSemicolon | otherlv_9= SemicolonAmpersand | otherlv_10= SemicolonSemicolonAmpersand ) ruleMaybeNewLine )? )? otherlv_12= Esac
            {
            // InternalMyBashParser.g:1359:3: ()
            // InternalMyBashParser.g:1360:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getCaseStatementAccess().getCaseStatementAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Case,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCaseStatementAccess().getCaseKeyword_1());
              		
            }
            // InternalMyBashParser.g:1370:3: ( (lv_variable_2_0= ruleWord ) )
            // InternalMyBashParser.g:1371:4: (lv_variable_2_0= ruleWord )
            {
            // InternalMyBashParser.g:1371:4: (lv_variable_2_0= ruleWord )
            // InternalMyBashParser.g:1372:5: lv_variable_2_0= ruleWord
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCaseStatementAccess().getVariableWordParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_22);
            lv_variable_2_0=ruleWord();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCaseStatementRule());
              					}
              					set(
              						current,
              						"variable",
              						lv_variable_2_0,
              						"org.xtext.example.mydsl.MyBash.Word");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getCaseStatementAccess().getMaybeNewLineParserRuleCall_3());
              		
            }
            pushFollow(FOLLOW_23);
            ruleMaybeNewLine();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }
            otherlv_4=(Token)match(input,In,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getCaseStatementAccess().getInKeyword_4());
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getCaseStatementAccess().getMaybeNewLineParserRuleCall_5());
              		
            }
            pushFollow(FOLLOW_25);
            ruleMaybeNewLine();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMyBashParser.g:1407:3: ( ( (lv_patterns_6_0= ruleCasePattern ) ) ( (lv_patterns_7_0= ruleCasePatternContinue ) )* ( (otherlv_8= SemicolonSemicolon | otherlv_9= SemicolonAmpersand | otherlv_10= SemicolonSemicolonAmpersand ) ruleMaybeNewLine )? )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==DollarSignLeftParenthesisLeftParenthesis||LA30_0==DollarSignLeftCurlyBracket||LA30_0==LessThanSignLeftParenthesis||LA30_0==GreaterThanSignLeftParenthesis||LA30_0==QuotationMark||(LA30_0>=Apostrophe && LA30_0<=LeftParenthesis)||(LA30_0>=RULE_S_WORD_PART && LA30_0<=RULE_WORD_PART)||LA30_0==RULE_VARIABLE||LA30_0==RULE_CS_START) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalMyBashParser.g:1408:4: ( (lv_patterns_6_0= ruleCasePattern ) ) ( (lv_patterns_7_0= ruleCasePatternContinue ) )* ( (otherlv_8= SemicolonSemicolon | otherlv_9= SemicolonAmpersand | otherlv_10= SemicolonSemicolonAmpersand ) ruleMaybeNewLine )?
                    {
                    // InternalMyBashParser.g:1408:4: ( (lv_patterns_6_0= ruleCasePattern ) )
                    // InternalMyBashParser.g:1409:5: (lv_patterns_6_0= ruleCasePattern )
                    {
                    // InternalMyBashParser.g:1409:5: (lv_patterns_6_0= ruleCasePattern )
                    // InternalMyBashParser.g:1410:6: lv_patterns_6_0= ruleCasePattern
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCaseStatementAccess().getPatternsCasePatternParserRuleCall_6_0_0());
                      					
                    }
                    pushFollow(FOLLOW_26);
                    lv_patterns_6_0=ruleCasePattern();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getCaseStatementRule());
                      						}
                      						add(
                      							current,
                      							"patterns",
                      							lv_patterns_6_0,
                      							"org.xtext.example.mydsl.MyBash.CasePattern");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalMyBashParser.g:1427:4: ( (lv_patterns_7_0= ruleCasePatternContinue ) )*
                    loop27:
                    do {
                        int alt27=2;
                        alt27 = dfa27.predict(input);
                        switch (alt27) {
                    	case 1 :
                    	    // InternalMyBashParser.g:1428:5: (lv_patterns_7_0= ruleCasePatternContinue )
                    	    {
                    	    // InternalMyBashParser.g:1428:5: (lv_patterns_7_0= ruleCasePatternContinue )
                    	    // InternalMyBashParser.g:1429:6: lv_patterns_7_0= ruleCasePatternContinue
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getCaseStatementAccess().getPatternsCasePatternContinueParserRuleCall_6_1_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_26);
                    	    lv_patterns_7_0=ruleCasePatternContinue();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getCaseStatementRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"patterns",
                    	      							lv_patterns_7_0,
                    	      							"org.xtext.example.mydsl.MyBash.CasePatternContinue");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);

                    // InternalMyBashParser.g:1446:4: ( (otherlv_8= SemicolonSemicolon | otherlv_9= SemicolonAmpersand | otherlv_10= SemicolonSemicolonAmpersand ) ruleMaybeNewLine )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==SemicolonSemicolonAmpersand||(LA29_0>=SemicolonAmpersand && LA29_0<=SemicolonSemicolon)) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // InternalMyBashParser.g:1447:5: (otherlv_8= SemicolonSemicolon | otherlv_9= SemicolonAmpersand | otherlv_10= SemicolonSemicolonAmpersand ) ruleMaybeNewLine
                            {
                            // InternalMyBashParser.g:1447:5: (otherlv_8= SemicolonSemicolon | otherlv_9= SemicolonAmpersand | otherlv_10= SemicolonSemicolonAmpersand )
                            int alt28=3;
                            switch ( input.LA(1) ) {
                            case SemicolonSemicolon:
                                {
                                alt28=1;
                                }
                                break;
                            case SemicolonAmpersand:
                                {
                                alt28=2;
                                }
                                break;
                            case SemicolonSemicolonAmpersand:
                                {
                                alt28=3;
                                }
                                break;
                            default:
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 28, 0, input);

                                throw nvae;
                            }

                            switch (alt28) {
                                case 1 :
                                    // InternalMyBashParser.g:1448:6: otherlv_8= SemicolonSemicolon
                                    {
                                    otherlv_8=(Token)match(input,SemicolonSemicolon,FOLLOW_27); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      						newLeafNode(otherlv_8, grammarAccess.getCaseStatementAccess().getSemicolonSemicolonKeyword_6_2_0_0());
                                      					
                                    }

                                    }
                                    break;
                                case 2 :
                                    // InternalMyBashParser.g:1453:6: otherlv_9= SemicolonAmpersand
                                    {
                                    otherlv_9=(Token)match(input,SemicolonAmpersand,FOLLOW_27); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      						newLeafNode(otherlv_9, grammarAccess.getCaseStatementAccess().getSemicolonAmpersandKeyword_6_2_0_1());
                                      					
                                    }

                                    }
                                    break;
                                case 3 :
                                    // InternalMyBashParser.g:1458:6: otherlv_10= SemicolonSemicolonAmpersand
                                    {
                                    otherlv_10=(Token)match(input,SemicolonSemicolonAmpersand,FOLLOW_27); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      						newLeafNode(otherlv_10, grammarAccess.getCaseStatementAccess().getSemicolonSemicolonAmpersandKeyword_6_2_0_2());
                                      					
                                    }

                                    }
                                    break;

                            }

                            if ( state.backtracking==0 ) {

                              					newCompositeNode(grammarAccess.getCaseStatementAccess().getMaybeNewLineParserRuleCall_6_2_1());
                              				
                            }
                            pushFollow(FOLLOW_28);
                            ruleMaybeNewLine();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					afterParserOrEnumRuleCall();
                              				
                            }

                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_12=(Token)match(input,Esac,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_12, grammarAccess.getCaseStatementAccess().getEsacKeyword_7());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCaseStatement"


    // $ANTLR start "entryRuleCasePattern"
    // InternalMyBashParser.g:1480:1: entryRuleCasePattern returns [EObject current=null] : iv_ruleCasePattern= ruleCasePattern EOF ;
    public final EObject entryRuleCasePattern() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCasePattern = null;


        try {
            // InternalMyBashParser.g:1480:52: (iv_ruleCasePattern= ruleCasePattern EOF )
            // InternalMyBashParser.g:1481:2: iv_ruleCasePattern= ruleCasePattern EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCasePatternRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCasePattern=ruleCasePattern();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCasePattern; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCasePattern"


    // $ANTLR start "ruleCasePattern"
    // InternalMyBashParser.g:1487:1: ruleCasePattern returns [EObject current=null] : ( (otherlv_0= LeftParenthesis )? ( (lv_condition_1_0= rulePattern ) ) otherlv_2= RightParenthesis ( (lv_body_3_0= ruleCompoundList ) ) ) ;
    public final EObject ruleCasePattern() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_condition_1_0 = null;

        EObject lv_body_3_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:1493:2: ( ( (otherlv_0= LeftParenthesis )? ( (lv_condition_1_0= rulePattern ) ) otherlv_2= RightParenthesis ( (lv_body_3_0= ruleCompoundList ) ) ) )
            // InternalMyBashParser.g:1494:2: ( (otherlv_0= LeftParenthesis )? ( (lv_condition_1_0= rulePattern ) ) otherlv_2= RightParenthesis ( (lv_body_3_0= ruleCompoundList ) ) )
            {
            // InternalMyBashParser.g:1494:2: ( (otherlv_0= LeftParenthesis )? ( (lv_condition_1_0= rulePattern ) ) otherlv_2= RightParenthesis ( (lv_body_3_0= ruleCompoundList ) ) )
            // InternalMyBashParser.g:1495:3: (otherlv_0= LeftParenthesis )? ( (lv_condition_1_0= rulePattern ) ) otherlv_2= RightParenthesis ( (lv_body_3_0= ruleCompoundList ) )
            {
            // InternalMyBashParser.g:1495:3: (otherlv_0= LeftParenthesis )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==LeftParenthesis) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalMyBashParser.g:1496:4: otherlv_0= LeftParenthesis
                    {
                    otherlv_0=(Token)match(input,LeftParenthesis,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getCasePatternAccess().getLeftParenthesisKeyword_0());
                      			
                    }

                    }
                    break;

            }

            // InternalMyBashParser.g:1501:3: ( (lv_condition_1_0= rulePattern ) )
            // InternalMyBashParser.g:1502:4: (lv_condition_1_0= rulePattern )
            {
            // InternalMyBashParser.g:1502:4: (lv_condition_1_0= rulePattern )
            // InternalMyBashParser.g:1503:5: lv_condition_1_0= rulePattern
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCasePatternAccess().getConditionPatternParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_13);
            lv_condition_1_0=rulePattern();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCasePatternRule());
              					}
              					set(
              						current,
              						"condition",
              						lv_condition_1_0,
              						"org.xtext.example.mydsl.MyBash.Pattern");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,RightParenthesis,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getCasePatternAccess().getRightParenthesisKeyword_2());
              		
            }
            // InternalMyBashParser.g:1524:3: ( (lv_body_3_0= ruleCompoundList ) )
            // InternalMyBashParser.g:1525:4: (lv_body_3_0= ruleCompoundList )
            {
            // InternalMyBashParser.g:1525:4: (lv_body_3_0= ruleCompoundList )
            // InternalMyBashParser.g:1526:5: lv_body_3_0= ruleCompoundList
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCasePatternAccess().getBodyCompoundListParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_body_3_0=ruleCompoundList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCasePatternRule());
              					}
              					set(
              						current,
              						"body",
              						lv_body_3_0,
              						"org.xtext.example.mydsl.MyBash.CompoundList");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCasePattern"


    // $ANTLR start "entryRuleCasePatternContinue"
    // InternalMyBashParser.g:1547:1: entryRuleCasePatternContinue returns [EObject current=null] : iv_ruleCasePatternContinue= ruleCasePatternContinue EOF ;
    public final EObject entryRuleCasePatternContinue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCasePatternContinue = null;


        try {
            // InternalMyBashParser.g:1547:60: (iv_ruleCasePatternContinue= ruleCasePatternContinue EOF )
            // InternalMyBashParser.g:1548:2: iv_ruleCasePatternContinue= ruleCasePatternContinue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCasePatternContinueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCasePatternContinue=ruleCasePatternContinue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCasePatternContinue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCasePatternContinue"


    // $ANTLR start "ruleCasePatternContinue"
    // InternalMyBashParser.g:1554:1: ruleCasePatternContinue returns [EObject current=null] : ( ( ( ( (lv_follow_0_1= SemicolonSemicolon | lv_follow_0_2= SemicolonAmpersand | lv_follow_0_3= SemicolonSemicolonAmpersand ) ) ) ruleMaybeNewLine ) (otherlv_2= LeftParenthesis )? ( (lv_condition_3_0= rulePattern ) ) otherlv_4= RightParenthesis ( (lv_body_5_0= ruleCompoundList ) ) ) ;
    public final EObject ruleCasePatternContinue() throws RecognitionException {
        EObject current = null;

        Token lv_follow_0_1=null;
        Token lv_follow_0_2=null;
        Token lv_follow_0_3=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_condition_3_0 = null;

        EObject lv_body_5_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:1560:2: ( ( ( ( ( (lv_follow_0_1= SemicolonSemicolon | lv_follow_0_2= SemicolonAmpersand | lv_follow_0_3= SemicolonSemicolonAmpersand ) ) ) ruleMaybeNewLine ) (otherlv_2= LeftParenthesis )? ( (lv_condition_3_0= rulePattern ) ) otherlv_4= RightParenthesis ( (lv_body_5_0= ruleCompoundList ) ) ) )
            // InternalMyBashParser.g:1561:2: ( ( ( ( (lv_follow_0_1= SemicolonSemicolon | lv_follow_0_2= SemicolonAmpersand | lv_follow_0_3= SemicolonSemicolonAmpersand ) ) ) ruleMaybeNewLine ) (otherlv_2= LeftParenthesis )? ( (lv_condition_3_0= rulePattern ) ) otherlv_4= RightParenthesis ( (lv_body_5_0= ruleCompoundList ) ) )
            {
            // InternalMyBashParser.g:1561:2: ( ( ( ( (lv_follow_0_1= SemicolonSemicolon | lv_follow_0_2= SemicolonAmpersand | lv_follow_0_3= SemicolonSemicolonAmpersand ) ) ) ruleMaybeNewLine ) (otherlv_2= LeftParenthesis )? ( (lv_condition_3_0= rulePattern ) ) otherlv_4= RightParenthesis ( (lv_body_5_0= ruleCompoundList ) ) )
            // InternalMyBashParser.g:1562:3: ( ( ( (lv_follow_0_1= SemicolonSemicolon | lv_follow_0_2= SemicolonAmpersand | lv_follow_0_3= SemicolonSemicolonAmpersand ) ) ) ruleMaybeNewLine ) (otherlv_2= LeftParenthesis )? ( (lv_condition_3_0= rulePattern ) ) otherlv_4= RightParenthesis ( (lv_body_5_0= ruleCompoundList ) )
            {
            // InternalMyBashParser.g:1562:3: ( ( ( (lv_follow_0_1= SemicolonSemicolon | lv_follow_0_2= SemicolonAmpersand | lv_follow_0_3= SemicolonSemicolonAmpersand ) ) ) ruleMaybeNewLine )
            // InternalMyBashParser.g:1563:4: ( ( (lv_follow_0_1= SemicolonSemicolon | lv_follow_0_2= SemicolonAmpersand | lv_follow_0_3= SemicolonSemicolonAmpersand ) ) ) ruleMaybeNewLine
            {
            // InternalMyBashParser.g:1563:4: ( ( (lv_follow_0_1= SemicolonSemicolon | lv_follow_0_2= SemicolonAmpersand | lv_follow_0_3= SemicolonSemicolonAmpersand ) ) )
            // InternalMyBashParser.g:1564:5: ( (lv_follow_0_1= SemicolonSemicolon | lv_follow_0_2= SemicolonAmpersand | lv_follow_0_3= SemicolonSemicolonAmpersand ) )
            {
            // InternalMyBashParser.g:1564:5: ( (lv_follow_0_1= SemicolonSemicolon | lv_follow_0_2= SemicolonAmpersand | lv_follow_0_3= SemicolonSemicolonAmpersand ) )
            // InternalMyBashParser.g:1565:6: (lv_follow_0_1= SemicolonSemicolon | lv_follow_0_2= SemicolonAmpersand | lv_follow_0_3= SemicolonSemicolonAmpersand )
            {
            // InternalMyBashParser.g:1565:6: (lv_follow_0_1= SemicolonSemicolon | lv_follow_0_2= SemicolonAmpersand | lv_follow_0_3= SemicolonSemicolonAmpersand )
            int alt32=3;
            switch ( input.LA(1) ) {
            case SemicolonSemicolon:
                {
                alt32=1;
                }
                break;
            case SemicolonAmpersand:
                {
                alt32=2;
                }
                break;
            case SemicolonSemicolonAmpersand:
                {
                alt32=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // InternalMyBashParser.g:1566:7: lv_follow_0_1= SemicolonSemicolon
                    {
                    lv_follow_0_1=(Token)match(input,SemicolonSemicolon,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_follow_0_1, grammarAccess.getCasePatternContinueAccess().getFollowSemicolonSemicolonKeyword_0_0_0_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getCasePatternContinueRule());
                      							}
                      							setWithLastConsumed(current, "follow", lv_follow_0_1, null);
                      						
                    }

                    }
                    break;
                case 2 :
                    // InternalMyBashParser.g:1577:7: lv_follow_0_2= SemicolonAmpersand
                    {
                    lv_follow_0_2=(Token)match(input,SemicolonAmpersand,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_follow_0_2, grammarAccess.getCasePatternContinueAccess().getFollowSemicolonAmpersandKeyword_0_0_0_1());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getCasePatternContinueRule());
                      							}
                      							setWithLastConsumed(current, "follow", lv_follow_0_2, null);
                      						
                    }

                    }
                    break;
                case 3 :
                    // InternalMyBashParser.g:1588:7: lv_follow_0_3= SemicolonSemicolonAmpersand
                    {
                    lv_follow_0_3=(Token)match(input,SemicolonSemicolonAmpersand,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_follow_0_3, grammarAccess.getCasePatternContinueAccess().getFollowSemicolonSemicolonAmpersandKeyword_0_0_0_2());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getCasePatternContinueRule());
                      							}
                      							setWithLastConsumed(current, "follow", lv_follow_0_3, null);
                      						
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getCasePatternContinueAccess().getMaybeNewLineParserRuleCall_0_1());
              			
            }
            pushFollow(FOLLOW_29);
            ruleMaybeNewLine();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				afterParserOrEnumRuleCall();
              			
            }

            }

            // InternalMyBashParser.g:1609:3: (otherlv_2= LeftParenthesis )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==LeftParenthesis) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalMyBashParser.g:1610:4: otherlv_2= LeftParenthesis
                    {
                    otherlv_2=(Token)match(input,LeftParenthesis,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getCasePatternContinueAccess().getLeftParenthesisKeyword_1());
                      			
                    }

                    }
                    break;

            }

            // InternalMyBashParser.g:1615:3: ( (lv_condition_3_0= rulePattern ) )
            // InternalMyBashParser.g:1616:4: (lv_condition_3_0= rulePattern )
            {
            // InternalMyBashParser.g:1616:4: (lv_condition_3_0= rulePattern )
            // InternalMyBashParser.g:1617:5: lv_condition_3_0= rulePattern
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCasePatternContinueAccess().getConditionPatternParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_13);
            lv_condition_3_0=rulePattern();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCasePatternContinueRule());
              					}
              					set(
              						current,
              						"condition",
              						lv_condition_3_0,
              						"org.xtext.example.mydsl.MyBash.Pattern");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,RightParenthesis,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getCasePatternContinueAccess().getRightParenthesisKeyword_3());
              		
            }
            // InternalMyBashParser.g:1638:3: ( (lv_body_5_0= ruleCompoundList ) )
            // InternalMyBashParser.g:1639:4: (lv_body_5_0= ruleCompoundList )
            {
            // InternalMyBashParser.g:1639:4: (lv_body_5_0= ruleCompoundList )
            // InternalMyBashParser.g:1640:5: lv_body_5_0= ruleCompoundList
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCasePatternContinueAccess().getBodyCompoundListParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_body_5_0=ruleCompoundList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCasePatternContinueRule());
              					}
              					set(
              						current,
              						"body",
              						lv_body_5_0,
              						"org.xtext.example.mydsl.MyBash.CompoundList");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCasePatternContinue"


    // $ANTLR start "entryRulePattern"
    // InternalMyBashParser.g:1661:1: entryRulePattern returns [EObject current=null] : iv_rulePattern= rulePattern EOF ;
    public final EObject entryRulePattern() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePattern = null;


        try {
            // InternalMyBashParser.g:1661:48: (iv_rulePattern= rulePattern EOF )
            // InternalMyBashParser.g:1662:2: iv_rulePattern= rulePattern EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPatternRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePattern=rulePattern();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePattern; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePattern"


    // $ANTLR start "rulePattern"
    // InternalMyBashParser.g:1668:1: rulePattern returns [EObject current=null] : ( ( (lv_parts_0_0= ruleWord ) ) (otherlv_1= VerticalLine ( (lv_parts_2_0= ruleWord ) ) )* ) ;
    public final EObject rulePattern() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_parts_0_0 = null;

        EObject lv_parts_2_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:1674:2: ( ( ( (lv_parts_0_0= ruleWord ) ) (otherlv_1= VerticalLine ( (lv_parts_2_0= ruleWord ) ) )* ) )
            // InternalMyBashParser.g:1675:2: ( ( (lv_parts_0_0= ruleWord ) ) (otherlv_1= VerticalLine ( (lv_parts_2_0= ruleWord ) ) )* )
            {
            // InternalMyBashParser.g:1675:2: ( ( (lv_parts_0_0= ruleWord ) ) (otherlv_1= VerticalLine ( (lv_parts_2_0= ruleWord ) ) )* )
            // InternalMyBashParser.g:1676:3: ( (lv_parts_0_0= ruleWord ) ) (otherlv_1= VerticalLine ( (lv_parts_2_0= ruleWord ) ) )*
            {
            // InternalMyBashParser.g:1676:3: ( (lv_parts_0_0= ruleWord ) )
            // InternalMyBashParser.g:1677:4: (lv_parts_0_0= ruleWord )
            {
            // InternalMyBashParser.g:1677:4: (lv_parts_0_0= ruleWord )
            // InternalMyBashParser.g:1678:5: lv_parts_0_0= ruleWord
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPatternAccess().getPartsWordParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_31);
            lv_parts_0_0=ruleWord();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPatternRule());
              					}
              					add(
              						current,
              						"parts",
              						lv_parts_0_0,
              						"org.xtext.example.mydsl.MyBash.Word");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMyBashParser.g:1695:3: (otherlv_1= VerticalLine ( (lv_parts_2_0= ruleWord ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==VerticalLine) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalMyBashParser.g:1696:4: otherlv_1= VerticalLine ( (lv_parts_2_0= ruleWord ) )
            	    {
            	    otherlv_1=(Token)match(input,VerticalLine,FOLLOW_21); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getPatternAccess().getVerticalLineKeyword_1_0());
            	      			
            	    }
            	    // InternalMyBashParser.g:1700:4: ( (lv_parts_2_0= ruleWord ) )
            	    // InternalMyBashParser.g:1701:5: (lv_parts_2_0= ruleWord )
            	    {
            	    // InternalMyBashParser.g:1701:5: (lv_parts_2_0= ruleWord )
            	    // InternalMyBashParser.g:1702:6: lv_parts_2_0= ruleWord
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPatternAccess().getPartsWordParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_31);
            	    lv_parts_2_0=ruleWord();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getPatternRule());
            	      						}
            	      						add(
            	      							current,
            	      							"parts",
            	      							lv_parts_2_0,
            	      							"org.xtext.example.mydsl.MyBash.Word");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePattern"


    // $ANTLR start "entryRuleIfStatement"
    // InternalMyBashParser.g:1724:1: entryRuleIfStatement returns [EObject current=null] : iv_ruleIfStatement= ruleIfStatement EOF ;
    public final EObject entryRuleIfStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfStatement = null;


        try {
            // InternalMyBashParser.g:1724:52: (iv_ruleIfStatement= ruleIfStatement EOF )
            // InternalMyBashParser.g:1725:2: iv_ruleIfStatement= ruleIfStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIfStatement=ruleIfStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIfStatement"


    // $ANTLR start "ruleIfStatement"
    // InternalMyBashParser.g:1731:1: ruleIfStatement returns [EObject current=null] : ( () otherlv_1= If ( (lv_condition_2_0= ruleCompoundList ) ) otherlv_3= Then ( (lv_then_4_0= ruleCompoundList ) ) ( (lv_elseIfBlock_5_0= ruleElseIfBlock ) )* (otherlv_6= Else ( (lv_else_7_0= ruleCompoundList ) ) )? otherlv_8= Fi ) ;
    public final EObject ruleIfStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_condition_2_0 = null;

        EObject lv_then_4_0 = null;

        EObject lv_elseIfBlock_5_0 = null;

        EObject lv_else_7_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:1737:2: ( ( () otherlv_1= If ( (lv_condition_2_0= ruleCompoundList ) ) otherlv_3= Then ( (lv_then_4_0= ruleCompoundList ) ) ( (lv_elseIfBlock_5_0= ruleElseIfBlock ) )* (otherlv_6= Else ( (lv_else_7_0= ruleCompoundList ) ) )? otherlv_8= Fi ) )
            // InternalMyBashParser.g:1738:2: ( () otherlv_1= If ( (lv_condition_2_0= ruleCompoundList ) ) otherlv_3= Then ( (lv_then_4_0= ruleCompoundList ) ) ( (lv_elseIfBlock_5_0= ruleElseIfBlock ) )* (otherlv_6= Else ( (lv_else_7_0= ruleCompoundList ) ) )? otherlv_8= Fi )
            {
            // InternalMyBashParser.g:1738:2: ( () otherlv_1= If ( (lv_condition_2_0= ruleCompoundList ) ) otherlv_3= Then ( (lv_then_4_0= ruleCompoundList ) ) ( (lv_elseIfBlock_5_0= ruleElseIfBlock ) )* (otherlv_6= Else ( (lv_else_7_0= ruleCompoundList ) ) )? otherlv_8= Fi )
            // InternalMyBashParser.g:1739:3: () otherlv_1= If ( (lv_condition_2_0= ruleCompoundList ) ) otherlv_3= Then ( (lv_then_4_0= ruleCompoundList ) ) ( (lv_elseIfBlock_5_0= ruleElseIfBlock ) )* (otherlv_6= Else ( (lv_else_7_0= ruleCompoundList ) ) )? otherlv_8= Fi
            {
            // InternalMyBashParser.g:1739:3: ()
            // InternalMyBashParser.g:1740:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getIfStatementAccess().getIfStatementAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,If,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getIfStatementAccess().getIfKeyword_1());
              		
            }
            // InternalMyBashParser.g:1750:3: ( (lv_condition_2_0= ruleCompoundList ) )
            // InternalMyBashParser.g:1751:4: (lv_condition_2_0= ruleCompoundList )
            {
            // InternalMyBashParser.g:1751:4: (lv_condition_2_0= ruleCompoundList )
            // InternalMyBashParser.g:1752:5: lv_condition_2_0= ruleCompoundList
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfStatementAccess().getConditionCompoundListParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_32);
            lv_condition_2_0=ruleCompoundList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIfStatementRule());
              					}
              					set(
              						current,
              						"condition",
              						lv_condition_2_0,
              						"org.xtext.example.mydsl.MyBash.CompoundList");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,Then,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getIfStatementAccess().getThenKeyword_3());
              		
            }
            // InternalMyBashParser.g:1773:3: ( (lv_then_4_0= ruleCompoundList ) )
            // InternalMyBashParser.g:1774:4: (lv_then_4_0= ruleCompoundList )
            {
            // InternalMyBashParser.g:1774:4: (lv_then_4_0= ruleCompoundList )
            // InternalMyBashParser.g:1775:5: lv_then_4_0= ruleCompoundList
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfStatementAccess().getThenCompoundListParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_33);
            lv_then_4_0=ruleCompoundList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIfStatementRule());
              					}
              					set(
              						current,
              						"then",
              						lv_then_4_0,
              						"org.xtext.example.mydsl.MyBash.CompoundList");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMyBashParser.g:1792:3: ( (lv_elseIfBlock_5_0= ruleElseIfBlock ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==Elif) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalMyBashParser.g:1793:4: (lv_elseIfBlock_5_0= ruleElseIfBlock )
            	    {
            	    // InternalMyBashParser.g:1793:4: (lv_elseIfBlock_5_0= ruleElseIfBlock )
            	    // InternalMyBashParser.g:1794:5: lv_elseIfBlock_5_0= ruleElseIfBlock
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getIfStatementAccess().getElseIfBlockElseIfBlockParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_33);
            	    lv_elseIfBlock_5_0=ruleElseIfBlock();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getIfStatementRule());
            	      					}
            	      					add(
            	      						current,
            	      						"elseIfBlock",
            	      						lv_elseIfBlock_5_0,
            	      						"org.xtext.example.mydsl.MyBash.ElseIfBlock");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

            // InternalMyBashParser.g:1811:3: (otherlv_6= Else ( (lv_else_7_0= ruleCompoundList ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==Else) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalMyBashParser.g:1812:4: otherlv_6= Else ( (lv_else_7_0= ruleCompoundList ) )
                    {
                    otherlv_6=(Token)match(input,Else,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getIfStatementAccess().getElseKeyword_6_0());
                      			
                    }
                    // InternalMyBashParser.g:1816:4: ( (lv_else_7_0= ruleCompoundList ) )
                    // InternalMyBashParser.g:1817:5: (lv_else_7_0= ruleCompoundList )
                    {
                    // InternalMyBashParser.g:1817:5: (lv_else_7_0= ruleCompoundList )
                    // InternalMyBashParser.g:1818:6: lv_else_7_0= ruleCompoundList
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getIfStatementAccess().getElseCompoundListParserRuleCall_6_1_0());
                      					
                    }
                    pushFollow(FOLLOW_34);
                    lv_else_7_0=ruleCompoundList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getIfStatementRule());
                      						}
                      						set(
                      							current,
                      							"else",
                      							lv_else_7_0,
                      							"org.xtext.example.mydsl.MyBash.CompoundList");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,Fi,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getIfStatementAccess().getFiKeyword_7());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIfStatement"


    // $ANTLR start "entryRuleElseIfBlock"
    // InternalMyBashParser.g:1844:1: entryRuleElseIfBlock returns [EObject current=null] : iv_ruleElseIfBlock= ruleElseIfBlock EOF ;
    public final EObject entryRuleElseIfBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElseIfBlock = null;


        try {
            // InternalMyBashParser.g:1844:52: (iv_ruleElseIfBlock= ruleElseIfBlock EOF )
            // InternalMyBashParser.g:1845:2: iv_ruleElseIfBlock= ruleElseIfBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getElseIfBlockRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleElseIfBlock=ruleElseIfBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleElseIfBlock; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElseIfBlock"


    // $ANTLR start "ruleElseIfBlock"
    // InternalMyBashParser.g:1851:1: ruleElseIfBlock returns [EObject current=null] : ( () otherlv_1= Elif ( (lv_condition_2_0= ruleCompoundList ) ) otherlv_3= Then ( (lv_then_4_0= ruleCompoundList ) ) ) ;
    public final EObject ruleElseIfBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_condition_2_0 = null;

        EObject lv_then_4_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:1857:2: ( ( () otherlv_1= Elif ( (lv_condition_2_0= ruleCompoundList ) ) otherlv_3= Then ( (lv_then_4_0= ruleCompoundList ) ) ) )
            // InternalMyBashParser.g:1858:2: ( () otherlv_1= Elif ( (lv_condition_2_0= ruleCompoundList ) ) otherlv_3= Then ( (lv_then_4_0= ruleCompoundList ) ) )
            {
            // InternalMyBashParser.g:1858:2: ( () otherlv_1= Elif ( (lv_condition_2_0= ruleCompoundList ) ) otherlv_3= Then ( (lv_then_4_0= ruleCompoundList ) ) )
            // InternalMyBashParser.g:1859:3: () otherlv_1= Elif ( (lv_condition_2_0= ruleCompoundList ) ) otherlv_3= Then ( (lv_then_4_0= ruleCompoundList ) )
            {
            // InternalMyBashParser.g:1859:3: ()
            // InternalMyBashParser.g:1860:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getElseIfBlockAccess().getElseIfBlockAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Elif,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getElseIfBlockAccess().getElifKeyword_1());
              		
            }
            // InternalMyBashParser.g:1870:3: ( (lv_condition_2_0= ruleCompoundList ) )
            // InternalMyBashParser.g:1871:4: (lv_condition_2_0= ruleCompoundList )
            {
            // InternalMyBashParser.g:1871:4: (lv_condition_2_0= ruleCompoundList )
            // InternalMyBashParser.g:1872:5: lv_condition_2_0= ruleCompoundList
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getElseIfBlockAccess().getConditionCompoundListParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_32);
            lv_condition_2_0=ruleCompoundList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getElseIfBlockRule());
              					}
              					set(
              						current,
              						"condition",
              						lv_condition_2_0,
              						"org.xtext.example.mydsl.MyBash.CompoundList");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,Then,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getElseIfBlockAccess().getThenKeyword_3());
              		
            }
            // InternalMyBashParser.g:1893:3: ( (lv_then_4_0= ruleCompoundList ) )
            // InternalMyBashParser.g:1894:4: (lv_then_4_0= ruleCompoundList )
            {
            // InternalMyBashParser.g:1894:4: (lv_then_4_0= ruleCompoundList )
            // InternalMyBashParser.g:1895:5: lv_then_4_0= ruleCompoundList
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getElseIfBlockAccess().getThenCompoundListParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_then_4_0=ruleCompoundList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getElseIfBlockRule());
              					}
              					set(
              						current,
              						"then",
              						lv_then_4_0,
              						"org.xtext.example.mydsl.MyBash.CompoundList");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleElseIfBlock"


    // $ANTLR start "entryRuleForStatement"
    // InternalMyBashParser.g:1916:1: entryRuleForStatement returns [EObject current=null] : iv_ruleForStatement= ruleForStatement EOF ;
    public final EObject entryRuleForStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForStatement = null;


        try {
            // InternalMyBashParser.g:1916:53: (iv_ruleForStatement= ruleForStatement EOF )
            // InternalMyBashParser.g:1917:2: iv_ruleForStatement= ruleForStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getForStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleForStatement=ruleForStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleForStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleForStatement"


    // $ANTLR start "ruleForStatement"
    // InternalMyBashParser.g:1923:1: ruleForStatement returns [EObject current=null] : (otherlv_0= For ( ( () otherlv_2= LeftParenthesisLeftParenthesis ( (lv_init_3_0= ruleEvaluation ) )? otherlv_4= Semicolon ( (lv_condition_5_0= ruleEvaluation ) )? otherlv_6= Semicolon ( (lv_step_7_0= ruleEvaluation ) )? otherlv_8= RightParenthesisRightParenthesis ( ruleListTerminator ruleMaybeNewLine )? ) | ( () ( (lv_variable_12_0= RULE_NAME ) ) otherlv_13= In ( (lv_words_14_0= ruleWord ) )+ ruleListTerminator ruleMaybeNewLine ) ) otherlv_17= Do ( (lv_body_18_0= ruleCompoundList ) ) otherlv_19= Done ) ;
    public final EObject ruleForStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_variable_12_0=null;
        Token otherlv_13=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        EObject lv_init_3_0 = null;

        EObject lv_condition_5_0 = null;

        EObject lv_step_7_0 = null;

        EObject lv_words_14_0 = null;

        EObject lv_body_18_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:1929:2: ( (otherlv_0= For ( ( () otherlv_2= LeftParenthesisLeftParenthesis ( (lv_init_3_0= ruleEvaluation ) )? otherlv_4= Semicolon ( (lv_condition_5_0= ruleEvaluation ) )? otherlv_6= Semicolon ( (lv_step_7_0= ruleEvaluation ) )? otherlv_8= RightParenthesisRightParenthesis ( ruleListTerminator ruleMaybeNewLine )? ) | ( () ( (lv_variable_12_0= RULE_NAME ) ) otherlv_13= In ( (lv_words_14_0= ruleWord ) )+ ruleListTerminator ruleMaybeNewLine ) ) otherlv_17= Do ( (lv_body_18_0= ruleCompoundList ) ) otherlv_19= Done ) )
            // InternalMyBashParser.g:1930:2: (otherlv_0= For ( ( () otherlv_2= LeftParenthesisLeftParenthesis ( (lv_init_3_0= ruleEvaluation ) )? otherlv_4= Semicolon ( (lv_condition_5_0= ruleEvaluation ) )? otherlv_6= Semicolon ( (lv_step_7_0= ruleEvaluation ) )? otherlv_8= RightParenthesisRightParenthesis ( ruleListTerminator ruleMaybeNewLine )? ) | ( () ( (lv_variable_12_0= RULE_NAME ) ) otherlv_13= In ( (lv_words_14_0= ruleWord ) )+ ruleListTerminator ruleMaybeNewLine ) ) otherlv_17= Do ( (lv_body_18_0= ruleCompoundList ) ) otherlv_19= Done )
            {
            // InternalMyBashParser.g:1930:2: (otherlv_0= For ( ( () otherlv_2= LeftParenthesisLeftParenthesis ( (lv_init_3_0= ruleEvaluation ) )? otherlv_4= Semicolon ( (lv_condition_5_0= ruleEvaluation ) )? otherlv_6= Semicolon ( (lv_step_7_0= ruleEvaluation ) )? otherlv_8= RightParenthesisRightParenthesis ( ruleListTerminator ruleMaybeNewLine )? ) | ( () ( (lv_variable_12_0= RULE_NAME ) ) otherlv_13= In ( (lv_words_14_0= ruleWord ) )+ ruleListTerminator ruleMaybeNewLine ) ) otherlv_17= Do ( (lv_body_18_0= ruleCompoundList ) ) otherlv_19= Done )
            // InternalMyBashParser.g:1931:3: otherlv_0= For ( ( () otherlv_2= LeftParenthesisLeftParenthesis ( (lv_init_3_0= ruleEvaluation ) )? otherlv_4= Semicolon ( (lv_condition_5_0= ruleEvaluation ) )? otherlv_6= Semicolon ( (lv_step_7_0= ruleEvaluation ) )? otherlv_8= RightParenthesisRightParenthesis ( ruleListTerminator ruleMaybeNewLine )? ) | ( () ( (lv_variable_12_0= RULE_NAME ) ) otherlv_13= In ( (lv_words_14_0= ruleWord ) )+ ruleListTerminator ruleMaybeNewLine ) ) otherlv_17= Do ( (lv_body_18_0= ruleCompoundList ) ) otherlv_19= Done
            {
            otherlv_0=(Token)match(input,For,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getForStatementAccess().getForKeyword_0());
              		
            }
            // InternalMyBashParser.g:1935:3: ( ( () otherlv_2= LeftParenthesisLeftParenthesis ( (lv_init_3_0= ruleEvaluation ) )? otherlv_4= Semicolon ( (lv_condition_5_0= ruleEvaluation ) )? otherlv_6= Semicolon ( (lv_step_7_0= ruleEvaluation ) )? otherlv_8= RightParenthesisRightParenthesis ( ruleListTerminator ruleMaybeNewLine )? ) | ( () ( (lv_variable_12_0= RULE_NAME ) ) otherlv_13= In ( (lv_words_14_0= ruleWord ) )+ ruleListTerminator ruleMaybeNewLine ) )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==LeftParenthesisLeftParenthesis) ) {
                alt42=1;
            }
            else if ( (LA42_0==RULE_NAME) ) {
                alt42=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // InternalMyBashParser.g:1936:4: ( () otherlv_2= LeftParenthesisLeftParenthesis ( (lv_init_3_0= ruleEvaluation ) )? otherlv_4= Semicolon ( (lv_condition_5_0= ruleEvaluation ) )? otherlv_6= Semicolon ( (lv_step_7_0= ruleEvaluation ) )? otherlv_8= RightParenthesisRightParenthesis ( ruleListTerminator ruleMaybeNewLine )? )
                    {
                    // InternalMyBashParser.g:1936:4: ( () otherlv_2= LeftParenthesisLeftParenthesis ( (lv_init_3_0= ruleEvaluation ) )? otherlv_4= Semicolon ( (lv_condition_5_0= ruleEvaluation ) )? otherlv_6= Semicolon ( (lv_step_7_0= ruleEvaluation ) )? otherlv_8= RightParenthesisRightParenthesis ( ruleListTerminator ruleMaybeNewLine )? )
                    // InternalMyBashParser.g:1937:5: () otherlv_2= LeftParenthesisLeftParenthesis ( (lv_init_3_0= ruleEvaluation ) )? otherlv_4= Semicolon ( (lv_condition_5_0= ruleEvaluation ) )? otherlv_6= Semicolon ( (lv_step_7_0= ruleEvaluation ) )? otherlv_8= RightParenthesisRightParenthesis ( ruleListTerminator ruleMaybeNewLine )?
                    {
                    // InternalMyBashParser.g:1937:5: ()
                    // InternalMyBashParser.g:1938:6: 
                    {
                    if ( state.backtracking==0 ) {

                      						current = forceCreateModelElement(
                      							grammarAccess.getForStatementAccess().getArithmeticForStatementAction_1_0_0(),
                      							current);
                      					
                    }

                    }

                    otherlv_2=(Token)match(input,LeftParenthesisLeftParenthesis,FOLLOW_36); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_2, grammarAccess.getForStatementAccess().getLeftParenthesisLeftParenthesisKeyword_1_0_1());
                      				
                    }
                    // InternalMyBashParser.g:1948:5: ( (lv_init_3_0= ruleEvaluation ) )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==DollarSignLeftParenthesisLeftParenthesis||LA37_0==DollarSignLeftCurlyBracket||LA37_0==PlusSignPlusSign||LA37_0==HyphenMinusHyphenMinus||LA37_0==LessThanSignLeftParenthesis||LA37_0==GreaterThanSignLeftParenthesis||LA37_0==ExclamationMark||LA37_0==LeftParenthesis||LA37_0==PlusSign||LA37_0==HyphenMinus||(LA37_0>=Tilde && LA37_0<=RULE_I_NUMBER)||LA37_0==RULE_NAME||(LA37_0>=RULE_VARIABLE && LA37_0<=RULE_A_PREFIX)||LA37_0==RULE_CS_START) ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // InternalMyBashParser.g:1949:6: (lv_init_3_0= ruleEvaluation )
                            {
                            // InternalMyBashParser.g:1949:6: (lv_init_3_0= ruleEvaluation )
                            // InternalMyBashParser.g:1950:7: lv_init_3_0= ruleEvaluation
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getForStatementAccess().getInitEvaluationParserRuleCall_1_0_2_0());
                              						
                            }
                            pushFollow(FOLLOW_37);
                            lv_init_3_0=ruleEvaluation();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getForStatementRule());
                              							}
                              							set(
                              								current,
                              								"init",
                              								lv_init_3_0,
                              								"org.xtext.example.mydsl.MyBash.Evaluation");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }
                            break;

                    }

                    otherlv_4=(Token)match(input,Semicolon,FOLLOW_36); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_4, grammarAccess.getForStatementAccess().getSemicolonKeyword_1_0_3());
                      				
                    }
                    // InternalMyBashParser.g:1971:5: ( (lv_condition_5_0= ruleEvaluation ) )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==DollarSignLeftParenthesisLeftParenthesis||LA38_0==DollarSignLeftCurlyBracket||LA38_0==PlusSignPlusSign||LA38_0==HyphenMinusHyphenMinus||LA38_0==LessThanSignLeftParenthesis||LA38_0==GreaterThanSignLeftParenthesis||LA38_0==ExclamationMark||LA38_0==LeftParenthesis||LA38_0==PlusSign||LA38_0==HyphenMinus||(LA38_0>=Tilde && LA38_0<=RULE_I_NUMBER)||LA38_0==RULE_NAME||(LA38_0>=RULE_VARIABLE && LA38_0<=RULE_A_PREFIX)||LA38_0==RULE_CS_START) ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // InternalMyBashParser.g:1972:6: (lv_condition_5_0= ruleEvaluation )
                            {
                            // InternalMyBashParser.g:1972:6: (lv_condition_5_0= ruleEvaluation )
                            // InternalMyBashParser.g:1973:7: lv_condition_5_0= ruleEvaluation
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getForStatementAccess().getConditionEvaluationParserRuleCall_1_0_4_0());
                              						
                            }
                            pushFollow(FOLLOW_37);
                            lv_condition_5_0=ruleEvaluation();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getForStatementRule());
                              							}
                              							set(
                              								current,
                              								"condition",
                              								lv_condition_5_0,
                              								"org.xtext.example.mydsl.MyBash.Evaluation");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }
                            break;

                    }

                    otherlv_6=(Token)match(input,Semicolon,FOLLOW_38); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_6, grammarAccess.getForStatementAccess().getSemicolonKeyword_1_0_5());
                      				
                    }
                    // InternalMyBashParser.g:1994:5: ( (lv_step_7_0= ruleEvaluation ) )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==DollarSignLeftParenthesisLeftParenthesis||LA39_0==DollarSignLeftCurlyBracket||LA39_0==PlusSignPlusSign||LA39_0==HyphenMinusHyphenMinus||LA39_0==LessThanSignLeftParenthesis||LA39_0==GreaterThanSignLeftParenthesis||LA39_0==ExclamationMark||LA39_0==LeftParenthesis||LA39_0==PlusSign||LA39_0==HyphenMinus||(LA39_0>=Tilde && LA39_0<=RULE_I_NUMBER)||LA39_0==RULE_NAME||(LA39_0>=RULE_VARIABLE && LA39_0<=RULE_A_PREFIX)||LA39_0==RULE_CS_START) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // InternalMyBashParser.g:1995:6: (lv_step_7_0= ruleEvaluation )
                            {
                            // InternalMyBashParser.g:1995:6: (lv_step_7_0= ruleEvaluation )
                            // InternalMyBashParser.g:1996:7: lv_step_7_0= ruleEvaluation
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getForStatementAccess().getStepEvaluationParserRuleCall_1_0_6_0());
                              						
                            }
                            pushFollow(FOLLOW_20);
                            lv_step_7_0=ruleEvaluation();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getForStatementRule());
                              							}
                              							set(
                              								current,
                              								"step",
                              								lv_step_7_0,
                              								"org.xtext.example.mydsl.MyBash.Evaluation");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }
                            break;

                    }

                    otherlv_8=(Token)match(input,RightParenthesisRightParenthesis,FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_8, grammarAccess.getForStatementAccess().getRightParenthesisRightParenthesisKeyword_1_0_7());
                      				
                    }
                    // InternalMyBashParser.g:2017:5: ( ruleListTerminator ruleMaybeNewLine )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==Semicolon||LA40_0==RULE_NEW_LINE||LA40_0==RULE_HERE_DOC_START) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // InternalMyBashParser.g:2018:6: ruleListTerminator ruleMaybeNewLine
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getForStatementAccess().getListTerminatorParserRuleCall_1_0_8_0());
                              					
                            }
                            pushFollow(FOLLOW_40);
                            ruleListTerminator();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						afterParserOrEnumRuleCall();
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getForStatementAccess().getMaybeNewLineParserRuleCall_1_0_8_1());
                              					
                            }
                            pushFollow(FOLLOW_41);
                            ruleMaybeNewLine();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						afterParserOrEnumRuleCall();
                              					
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMyBashParser.g:2035:4: ( () ( (lv_variable_12_0= RULE_NAME ) ) otherlv_13= In ( (lv_words_14_0= ruleWord ) )+ ruleListTerminator ruleMaybeNewLine )
                    {
                    // InternalMyBashParser.g:2035:4: ( () ( (lv_variable_12_0= RULE_NAME ) ) otherlv_13= In ( (lv_words_14_0= ruleWord ) )+ ruleListTerminator ruleMaybeNewLine )
                    // InternalMyBashParser.g:2036:5: () ( (lv_variable_12_0= RULE_NAME ) ) otherlv_13= In ( (lv_words_14_0= ruleWord ) )+ ruleListTerminator ruleMaybeNewLine
                    {
                    // InternalMyBashParser.g:2036:5: ()
                    // InternalMyBashParser.g:2037:6: 
                    {
                    if ( state.backtracking==0 ) {

                      						current = forceCreateModelElement(
                      							grammarAccess.getForStatementAccess().getForStatementAction_1_1_0(),
                      							current);
                      					
                    }

                    }

                    // InternalMyBashParser.g:2043:5: ( (lv_variable_12_0= RULE_NAME ) )
                    // InternalMyBashParser.g:2044:6: (lv_variable_12_0= RULE_NAME )
                    {
                    // InternalMyBashParser.g:2044:6: (lv_variable_12_0= RULE_NAME )
                    // InternalMyBashParser.g:2045:7: lv_variable_12_0= RULE_NAME
                    {
                    lv_variable_12_0=(Token)match(input,RULE_NAME,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_variable_12_0, grammarAccess.getForStatementAccess().getVariableNAMETerminalRuleCall_1_1_1_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getForStatementRule());
                      							}
                      							setWithLastConsumed(
                      								current,
                      								"variable",
                      								lv_variable_12_0,
                      								"org.xtext.example.mydsl.MyBash.NAME");
                      						
                    }

                    }


                    }

                    otherlv_13=(Token)match(input,In,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_13, grammarAccess.getForStatementAccess().getInKeyword_1_1_2());
                      				
                    }
                    // InternalMyBashParser.g:2065:5: ( (lv_words_14_0= ruleWord ) )+
                    int cnt41=0;
                    loop41:
                    do {
                        int alt41=2;
                        int LA41_0 = input.LA(1);

                        if ( (LA41_0==DollarSignLeftParenthesisLeftParenthesis||LA41_0==DollarSignLeftCurlyBracket||LA41_0==LessThanSignLeftParenthesis||LA41_0==GreaterThanSignLeftParenthesis||LA41_0==QuotationMark||LA41_0==Apostrophe||(LA41_0>=RULE_S_WORD_PART && LA41_0<=RULE_WORD_PART)||LA41_0==RULE_VARIABLE||LA41_0==RULE_CS_START) ) {
                            alt41=1;
                        }


                        switch (alt41) {
                    	case 1 :
                    	    // InternalMyBashParser.g:2066:6: (lv_words_14_0= ruleWord )
                    	    {
                    	    // InternalMyBashParser.g:2066:6: (lv_words_14_0= ruleWord )
                    	    // InternalMyBashParser.g:2067:7: lv_words_14_0= ruleWord
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getForStatementAccess().getWordsWordParserRuleCall_1_1_3_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_42);
                    	    lv_words_14_0=ruleWord();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getForStatementRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"words",
                    	      								lv_words_14_0,
                    	      								"org.xtext.example.mydsl.MyBash.Word");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt41 >= 1 ) break loop41;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(41, input);
                                throw eee;
                        }
                        cnt41++;
                    } while (true);

                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getForStatementAccess().getListTerminatorParserRuleCall_1_1_4());
                      				
                    }
                    pushFollow(FOLLOW_40);
                    ruleListTerminator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					afterParserOrEnumRuleCall();
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getForStatementAccess().getMaybeNewLineParserRuleCall_1_1_5());
                      				
                    }
                    pushFollow(FOLLOW_41);
                    ruleMaybeNewLine();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_17=(Token)match(input,Do,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_17, grammarAccess.getForStatementAccess().getDoKeyword_2());
              		
            }
            // InternalMyBashParser.g:2104:3: ( (lv_body_18_0= ruleCompoundList ) )
            // InternalMyBashParser.g:2105:4: (lv_body_18_0= ruleCompoundList )
            {
            // InternalMyBashParser.g:2105:4: (lv_body_18_0= ruleCompoundList )
            // InternalMyBashParser.g:2106:5: lv_body_18_0= ruleCompoundList
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getForStatementAccess().getBodyCompoundListParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_43);
            lv_body_18_0=ruleCompoundList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getForStatementRule());
              					}
              					set(
              						current,
              						"body",
              						lv_body_18_0,
              						"org.xtext.example.mydsl.MyBash.CompoundList");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_19=(Token)match(input,Done,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_19, grammarAccess.getForStatementAccess().getDoneKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleForStatement"


    // $ANTLR start "entryRuleWhileStatement"
    // InternalMyBashParser.g:2131:1: entryRuleWhileStatement returns [EObject current=null] : iv_ruleWhileStatement= ruleWhileStatement EOF ;
    public final EObject entryRuleWhileStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhileStatement = null;


        try {
            // InternalMyBashParser.g:2131:55: (iv_ruleWhileStatement= ruleWhileStatement EOF )
            // InternalMyBashParser.g:2132:2: iv_ruleWhileStatement= ruleWhileStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWhileStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleWhileStatement=ruleWhileStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWhileStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWhileStatement"


    // $ANTLR start "ruleWhileStatement"
    // InternalMyBashParser.g:2138:1: ruleWhileStatement returns [EObject current=null] : (otherlv_0= While ( (lv_c_1_0= ruleCompoundList ) ) otherlv_2= Do ( (lv_d_3_0= ruleCompoundList ) ) otherlv_4= Done ) ;
    public final EObject ruleWhileStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_c_1_0 = null;

        EObject lv_d_3_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:2144:2: ( (otherlv_0= While ( (lv_c_1_0= ruleCompoundList ) ) otherlv_2= Do ( (lv_d_3_0= ruleCompoundList ) ) otherlv_4= Done ) )
            // InternalMyBashParser.g:2145:2: (otherlv_0= While ( (lv_c_1_0= ruleCompoundList ) ) otherlv_2= Do ( (lv_d_3_0= ruleCompoundList ) ) otherlv_4= Done )
            {
            // InternalMyBashParser.g:2145:2: (otherlv_0= While ( (lv_c_1_0= ruleCompoundList ) ) otherlv_2= Do ( (lv_d_3_0= ruleCompoundList ) ) otherlv_4= Done )
            // InternalMyBashParser.g:2146:3: otherlv_0= While ( (lv_c_1_0= ruleCompoundList ) ) otherlv_2= Do ( (lv_d_3_0= ruleCompoundList ) ) otherlv_4= Done
            {
            otherlv_0=(Token)match(input,While,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getWhileStatementAccess().getWhileKeyword_0());
              		
            }
            // InternalMyBashParser.g:2150:3: ( (lv_c_1_0= ruleCompoundList ) )
            // InternalMyBashParser.g:2151:4: (lv_c_1_0= ruleCompoundList )
            {
            // InternalMyBashParser.g:2151:4: (lv_c_1_0= ruleCompoundList )
            // InternalMyBashParser.g:2152:5: lv_c_1_0= ruleCompoundList
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getWhileStatementAccess().getCCompoundListParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_41);
            lv_c_1_0=ruleCompoundList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getWhileStatementRule());
              					}
              					set(
              						current,
              						"c",
              						lv_c_1_0,
              						"org.xtext.example.mydsl.MyBash.CompoundList");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,Do,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getWhileStatementAccess().getDoKeyword_2());
              		
            }
            // InternalMyBashParser.g:2173:3: ( (lv_d_3_0= ruleCompoundList ) )
            // InternalMyBashParser.g:2174:4: (lv_d_3_0= ruleCompoundList )
            {
            // InternalMyBashParser.g:2174:4: (lv_d_3_0= ruleCompoundList )
            // InternalMyBashParser.g:2175:5: lv_d_3_0= ruleCompoundList
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getWhileStatementAccess().getDCompoundListParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_43);
            lv_d_3_0=ruleCompoundList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getWhileStatementRule());
              					}
              					set(
              						current,
              						"d",
              						lv_d_3_0,
              						"org.xtext.example.mydsl.MyBash.CompoundList");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,Done,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getWhileStatementAccess().getDoneKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWhileStatement"


    // $ANTLR start "entryRuleRedirection"
    // InternalMyBashParser.g:2200:1: entryRuleRedirection returns [EObject current=null] : iv_ruleRedirection= ruleRedirection EOF ;
    public final EObject entryRuleRedirection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRedirection = null;


        try {
            // InternalMyBashParser.g:2200:52: (iv_ruleRedirection= ruleRedirection EOF )
            // InternalMyBashParser.g:2201:2: iv_ruleRedirection= ruleRedirection EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRedirectionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRedirection=ruleRedirection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRedirection; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRedirection"


    // $ANTLR start "ruleRedirection"
    // InternalMyBashParser.g:2207:1: ruleRedirection returns [EObject current=null] : ( () ( ( (this_I_NUMBER_1= RULE_I_NUMBER )? ( ( (lv_op_2_1= GreaterThanSignAmpersand | lv_op_2_2= GreaterThanSign | lv_op_2_3= GreaterThanSignGreaterThanSign | lv_op_2_4= LessThanSign | lv_op_2_5= LessThanSignAmpersand | lv_op_2_6= AmpersandGreaterThanSignGreaterThanSign | lv_op_2_7= LessThanSignGreaterThanSign | lv_op_2_8= AmpersandGreaterThanSign | lv_op_2_9= LessThanSignVerticalLine | lv_op_2_10= GreaterThanSignVerticalLine ) ) ) ( ( (lv_target_3_0= ruleWord ) ) | this_I_NUMBER_4= RULE_I_NUMBER ) ) | ( ( (lv_op_5_0= LessThanSignLessThanSign ) ) this_HERE_DOC_WORD_6= RULE_HERE_DOC_WORD ) ) ) ;
    public final EObject ruleRedirection() throws RecognitionException {
        EObject current = null;

        Token this_I_NUMBER_1=null;
        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        Token lv_op_2_4=null;
        Token lv_op_2_5=null;
        Token lv_op_2_6=null;
        Token lv_op_2_7=null;
        Token lv_op_2_8=null;
        Token lv_op_2_9=null;
        Token lv_op_2_10=null;
        Token this_I_NUMBER_4=null;
        Token lv_op_5_0=null;
        Token this_HERE_DOC_WORD_6=null;
        EObject lv_target_3_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:2213:2: ( ( () ( ( (this_I_NUMBER_1= RULE_I_NUMBER )? ( ( (lv_op_2_1= GreaterThanSignAmpersand | lv_op_2_2= GreaterThanSign | lv_op_2_3= GreaterThanSignGreaterThanSign | lv_op_2_4= LessThanSign | lv_op_2_5= LessThanSignAmpersand | lv_op_2_6= AmpersandGreaterThanSignGreaterThanSign | lv_op_2_7= LessThanSignGreaterThanSign | lv_op_2_8= AmpersandGreaterThanSign | lv_op_2_9= LessThanSignVerticalLine | lv_op_2_10= GreaterThanSignVerticalLine ) ) ) ( ( (lv_target_3_0= ruleWord ) ) | this_I_NUMBER_4= RULE_I_NUMBER ) ) | ( ( (lv_op_5_0= LessThanSignLessThanSign ) ) this_HERE_DOC_WORD_6= RULE_HERE_DOC_WORD ) ) ) )
            // InternalMyBashParser.g:2214:2: ( () ( ( (this_I_NUMBER_1= RULE_I_NUMBER )? ( ( (lv_op_2_1= GreaterThanSignAmpersand | lv_op_2_2= GreaterThanSign | lv_op_2_3= GreaterThanSignGreaterThanSign | lv_op_2_4= LessThanSign | lv_op_2_5= LessThanSignAmpersand | lv_op_2_6= AmpersandGreaterThanSignGreaterThanSign | lv_op_2_7= LessThanSignGreaterThanSign | lv_op_2_8= AmpersandGreaterThanSign | lv_op_2_9= LessThanSignVerticalLine | lv_op_2_10= GreaterThanSignVerticalLine ) ) ) ( ( (lv_target_3_0= ruleWord ) ) | this_I_NUMBER_4= RULE_I_NUMBER ) ) | ( ( (lv_op_5_0= LessThanSignLessThanSign ) ) this_HERE_DOC_WORD_6= RULE_HERE_DOC_WORD ) ) )
            {
            // InternalMyBashParser.g:2214:2: ( () ( ( (this_I_NUMBER_1= RULE_I_NUMBER )? ( ( (lv_op_2_1= GreaterThanSignAmpersand | lv_op_2_2= GreaterThanSign | lv_op_2_3= GreaterThanSignGreaterThanSign | lv_op_2_4= LessThanSign | lv_op_2_5= LessThanSignAmpersand | lv_op_2_6= AmpersandGreaterThanSignGreaterThanSign | lv_op_2_7= LessThanSignGreaterThanSign | lv_op_2_8= AmpersandGreaterThanSign | lv_op_2_9= LessThanSignVerticalLine | lv_op_2_10= GreaterThanSignVerticalLine ) ) ) ( ( (lv_target_3_0= ruleWord ) ) | this_I_NUMBER_4= RULE_I_NUMBER ) ) | ( ( (lv_op_5_0= LessThanSignLessThanSign ) ) this_HERE_DOC_WORD_6= RULE_HERE_DOC_WORD ) ) )
            // InternalMyBashParser.g:2215:3: () ( ( (this_I_NUMBER_1= RULE_I_NUMBER )? ( ( (lv_op_2_1= GreaterThanSignAmpersand | lv_op_2_2= GreaterThanSign | lv_op_2_3= GreaterThanSignGreaterThanSign | lv_op_2_4= LessThanSign | lv_op_2_5= LessThanSignAmpersand | lv_op_2_6= AmpersandGreaterThanSignGreaterThanSign | lv_op_2_7= LessThanSignGreaterThanSign | lv_op_2_8= AmpersandGreaterThanSign | lv_op_2_9= LessThanSignVerticalLine | lv_op_2_10= GreaterThanSignVerticalLine ) ) ) ( ( (lv_target_3_0= ruleWord ) ) | this_I_NUMBER_4= RULE_I_NUMBER ) ) | ( ( (lv_op_5_0= LessThanSignLessThanSign ) ) this_HERE_DOC_WORD_6= RULE_HERE_DOC_WORD ) )
            {
            // InternalMyBashParser.g:2215:3: ()
            // InternalMyBashParser.g:2216:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRedirectionAccess().getRedirectionAction_0(),
              					current);
              			
            }

            }

            // InternalMyBashParser.g:2222:3: ( ( (this_I_NUMBER_1= RULE_I_NUMBER )? ( ( (lv_op_2_1= GreaterThanSignAmpersand | lv_op_2_2= GreaterThanSign | lv_op_2_3= GreaterThanSignGreaterThanSign | lv_op_2_4= LessThanSign | lv_op_2_5= LessThanSignAmpersand | lv_op_2_6= AmpersandGreaterThanSignGreaterThanSign | lv_op_2_7= LessThanSignGreaterThanSign | lv_op_2_8= AmpersandGreaterThanSign | lv_op_2_9= LessThanSignVerticalLine | lv_op_2_10= GreaterThanSignVerticalLine ) ) ) ( ( (lv_target_3_0= ruleWord ) ) | this_I_NUMBER_4= RULE_I_NUMBER ) ) | ( ( (lv_op_5_0= LessThanSignLessThanSign ) ) this_HERE_DOC_WORD_6= RULE_HERE_DOC_WORD ) )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==AmpersandGreaterThanSignGreaterThanSign||LA46_0==AmpersandGreaterThanSign||LA46_0==LessThanSignAmpersand||(LA46_0>=LessThanSignGreaterThanSign && LA46_0<=LessThanSignVerticalLine)||LA46_0==GreaterThanSignAmpersand||(LA46_0>=GreaterThanSignGreaterThanSign && LA46_0<=GreaterThanSignVerticalLine)||LA46_0==LessThanSign||LA46_0==GreaterThanSign||LA46_0==RULE_I_NUMBER) ) {
                alt46=1;
            }
            else if ( (LA46_0==LessThanSignLessThanSign) ) {
                alt46=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // InternalMyBashParser.g:2223:4: ( (this_I_NUMBER_1= RULE_I_NUMBER )? ( ( (lv_op_2_1= GreaterThanSignAmpersand | lv_op_2_2= GreaterThanSign | lv_op_2_3= GreaterThanSignGreaterThanSign | lv_op_2_4= LessThanSign | lv_op_2_5= LessThanSignAmpersand | lv_op_2_6= AmpersandGreaterThanSignGreaterThanSign | lv_op_2_7= LessThanSignGreaterThanSign | lv_op_2_8= AmpersandGreaterThanSign | lv_op_2_9= LessThanSignVerticalLine | lv_op_2_10= GreaterThanSignVerticalLine ) ) ) ( ( (lv_target_3_0= ruleWord ) ) | this_I_NUMBER_4= RULE_I_NUMBER ) )
                    {
                    // InternalMyBashParser.g:2223:4: ( (this_I_NUMBER_1= RULE_I_NUMBER )? ( ( (lv_op_2_1= GreaterThanSignAmpersand | lv_op_2_2= GreaterThanSign | lv_op_2_3= GreaterThanSignGreaterThanSign | lv_op_2_4= LessThanSign | lv_op_2_5= LessThanSignAmpersand | lv_op_2_6= AmpersandGreaterThanSignGreaterThanSign | lv_op_2_7= LessThanSignGreaterThanSign | lv_op_2_8= AmpersandGreaterThanSign | lv_op_2_9= LessThanSignVerticalLine | lv_op_2_10= GreaterThanSignVerticalLine ) ) ) ( ( (lv_target_3_0= ruleWord ) ) | this_I_NUMBER_4= RULE_I_NUMBER ) )
                    // InternalMyBashParser.g:2224:5: (this_I_NUMBER_1= RULE_I_NUMBER )? ( ( (lv_op_2_1= GreaterThanSignAmpersand | lv_op_2_2= GreaterThanSign | lv_op_2_3= GreaterThanSignGreaterThanSign | lv_op_2_4= LessThanSign | lv_op_2_5= LessThanSignAmpersand | lv_op_2_6= AmpersandGreaterThanSignGreaterThanSign | lv_op_2_7= LessThanSignGreaterThanSign | lv_op_2_8= AmpersandGreaterThanSign | lv_op_2_9= LessThanSignVerticalLine | lv_op_2_10= GreaterThanSignVerticalLine ) ) ) ( ( (lv_target_3_0= ruleWord ) ) | this_I_NUMBER_4= RULE_I_NUMBER )
                    {
                    // InternalMyBashParser.g:2224:5: (this_I_NUMBER_1= RULE_I_NUMBER )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==RULE_I_NUMBER) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // InternalMyBashParser.g:2225:6: this_I_NUMBER_1= RULE_I_NUMBER
                            {
                            this_I_NUMBER_1=(Token)match(input,RULE_I_NUMBER,FOLLOW_44); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(this_I_NUMBER_1, grammarAccess.getRedirectionAccess().getI_NUMBERTerminalRuleCall_1_0_0());
                              					
                            }

                            }
                            break;

                    }

                    // InternalMyBashParser.g:2230:5: ( ( (lv_op_2_1= GreaterThanSignAmpersand | lv_op_2_2= GreaterThanSign | lv_op_2_3= GreaterThanSignGreaterThanSign | lv_op_2_4= LessThanSign | lv_op_2_5= LessThanSignAmpersand | lv_op_2_6= AmpersandGreaterThanSignGreaterThanSign | lv_op_2_7= LessThanSignGreaterThanSign | lv_op_2_8= AmpersandGreaterThanSign | lv_op_2_9= LessThanSignVerticalLine | lv_op_2_10= GreaterThanSignVerticalLine ) ) )
                    // InternalMyBashParser.g:2231:6: ( (lv_op_2_1= GreaterThanSignAmpersand | lv_op_2_2= GreaterThanSign | lv_op_2_3= GreaterThanSignGreaterThanSign | lv_op_2_4= LessThanSign | lv_op_2_5= LessThanSignAmpersand | lv_op_2_6= AmpersandGreaterThanSignGreaterThanSign | lv_op_2_7= LessThanSignGreaterThanSign | lv_op_2_8= AmpersandGreaterThanSign | lv_op_2_9= LessThanSignVerticalLine | lv_op_2_10= GreaterThanSignVerticalLine ) )
                    {
                    // InternalMyBashParser.g:2231:6: ( (lv_op_2_1= GreaterThanSignAmpersand | lv_op_2_2= GreaterThanSign | lv_op_2_3= GreaterThanSignGreaterThanSign | lv_op_2_4= LessThanSign | lv_op_2_5= LessThanSignAmpersand | lv_op_2_6= AmpersandGreaterThanSignGreaterThanSign | lv_op_2_7= LessThanSignGreaterThanSign | lv_op_2_8= AmpersandGreaterThanSign | lv_op_2_9= LessThanSignVerticalLine | lv_op_2_10= GreaterThanSignVerticalLine ) )
                    // InternalMyBashParser.g:2232:7: (lv_op_2_1= GreaterThanSignAmpersand | lv_op_2_2= GreaterThanSign | lv_op_2_3= GreaterThanSignGreaterThanSign | lv_op_2_4= LessThanSign | lv_op_2_5= LessThanSignAmpersand | lv_op_2_6= AmpersandGreaterThanSignGreaterThanSign | lv_op_2_7= LessThanSignGreaterThanSign | lv_op_2_8= AmpersandGreaterThanSign | lv_op_2_9= LessThanSignVerticalLine | lv_op_2_10= GreaterThanSignVerticalLine )
                    {
                    // InternalMyBashParser.g:2232:7: (lv_op_2_1= GreaterThanSignAmpersand | lv_op_2_2= GreaterThanSign | lv_op_2_3= GreaterThanSignGreaterThanSign | lv_op_2_4= LessThanSign | lv_op_2_5= LessThanSignAmpersand | lv_op_2_6= AmpersandGreaterThanSignGreaterThanSign | lv_op_2_7= LessThanSignGreaterThanSign | lv_op_2_8= AmpersandGreaterThanSign | lv_op_2_9= LessThanSignVerticalLine | lv_op_2_10= GreaterThanSignVerticalLine )
                    int alt44=10;
                    switch ( input.LA(1) ) {
                    case GreaterThanSignAmpersand:
                        {
                        alt44=1;
                        }
                        break;
                    case GreaterThanSign:
                        {
                        alt44=2;
                        }
                        break;
                    case GreaterThanSignGreaterThanSign:
                        {
                        alt44=3;
                        }
                        break;
                    case LessThanSign:
                        {
                        alt44=4;
                        }
                        break;
                    case LessThanSignAmpersand:
                        {
                        alt44=5;
                        }
                        break;
                    case AmpersandGreaterThanSignGreaterThanSign:
                        {
                        alt44=6;
                        }
                        break;
                    case LessThanSignGreaterThanSign:
                        {
                        alt44=7;
                        }
                        break;
                    case AmpersandGreaterThanSign:
                        {
                        alt44=8;
                        }
                        break;
                    case LessThanSignVerticalLine:
                        {
                        alt44=9;
                        }
                        break;
                    case GreaterThanSignVerticalLine:
                        {
                        alt44=10;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 44, 0, input);

                        throw nvae;
                    }

                    switch (alt44) {
                        case 1 :
                            // InternalMyBashParser.g:2233:8: lv_op_2_1= GreaterThanSignAmpersand
                            {
                            lv_op_2_1=(Token)match(input,GreaterThanSignAmpersand,FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_op_2_1, grammarAccess.getRedirectionAccess().getOpGreaterThanSignAmpersandKeyword_1_0_1_0_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getRedirectionRule());
                              								}
                              								setWithLastConsumed(current, "op", lv_op_2_1, null);
                              							
                            }

                            }
                            break;
                        case 2 :
                            // InternalMyBashParser.g:2244:8: lv_op_2_2= GreaterThanSign
                            {
                            lv_op_2_2=(Token)match(input,GreaterThanSign,FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_op_2_2, grammarAccess.getRedirectionAccess().getOpGreaterThanSignKeyword_1_0_1_0_1());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getRedirectionRule());
                              								}
                              								setWithLastConsumed(current, "op", lv_op_2_2, null);
                              							
                            }

                            }
                            break;
                        case 3 :
                            // InternalMyBashParser.g:2255:8: lv_op_2_3= GreaterThanSignGreaterThanSign
                            {
                            lv_op_2_3=(Token)match(input,GreaterThanSignGreaterThanSign,FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_op_2_3, grammarAccess.getRedirectionAccess().getOpGreaterThanSignGreaterThanSignKeyword_1_0_1_0_2());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getRedirectionRule());
                              								}
                              								setWithLastConsumed(current, "op", lv_op_2_3, null);
                              							
                            }

                            }
                            break;
                        case 4 :
                            // InternalMyBashParser.g:2266:8: lv_op_2_4= LessThanSign
                            {
                            lv_op_2_4=(Token)match(input,LessThanSign,FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_op_2_4, grammarAccess.getRedirectionAccess().getOpLessThanSignKeyword_1_0_1_0_3());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getRedirectionRule());
                              								}
                              								setWithLastConsumed(current, "op", lv_op_2_4, null);
                              							
                            }

                            }
                            break;
                        case 5 :
                            // InternalMyBashParser.g:2277:8: lv_op_2_5= LessThanSignAmpersand
                            {
                            lv_op_2_5=(Token)match(input,LessThanSignAmpersand,FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_op_2_5, grammarAccess.getRedirectionAccess().getOpLessThanSignAmpersandKeyword_1_0_1_0_4());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getRedirectionRule());
                              								}
                              								setWithLastConsumed(current, "op", lv_op_2_5, null);
                              							
                            }

                            }
                            break;
                        case 6 :
                            // InternalMyBashParser.g:2288:8: lv_op_2_6= AmpersandGreaterThanSignGreaterThanSign
                            {
                            lv_op_2_6=(Token)match(input,AmpersandGreaterThanSignGreaterThanSign,FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_op_2_6, grammarAccess.getRedirectionAccess().getOpAmpersandGreaterThanSignGreaterThanSignKeyword_1_0_1_0_5());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getRedirectionRule());
                              								}
                              								setWithLastConsumed(current, "op", lv_op_2_6, null);
                              							
                            }

                            }
                            break;
                        case 7 :
                            // InternalMyBashParser.g:2299:8: lv_op_2_7= LessThanSignGreaterThanSign
                            {
                            lv_op_2_7=(Token)match(input,LessThanSignGreaterThanSign,FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_op_2_7, grammarAccess.getRedirectionAccess().getOpLessThanSignGreaterThanSignKeyword_1_0_1_0_6());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getRedirectionRule());
                              								}
                              								setWithLastConsumed(current, "op", lv_op_2_7, null);
                              							
                            }

                            }
                            break;
                        case 8 :
                            // InternalMyBashParser.g:2310:8: lv_op_2_8= AmpersandGreaterThanSign
                            {
                            lv_op_2_8=(Token)match(input,AmpersandGreaterThanSign,FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_op_2_8, grammarAccess.getRedirectionAccess().getOpAmpersandGreaterThanSignKeyword_1_0_1_0_7());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getRedirectionRule());
                              								}
                              								setWithLastConsumed(current, "op", lv_op_2_8, null);
                              							
                            }

                            }
                            break;
                        case 9 :
                            // InternalMyBashParser.g:2321:8: lv_op_2_9= LessThanSignVerticalLine
                            {
                            lv_op_2_9=(Token)match(input,LessThanSignVerticalLine,FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_op_2_9, grammarAccess.getRedirectionAccess().getOpLessThanSignVerticalLineKeyword_1_0_1_0_8());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getRedirectionRule());
                              								}
                              								setWithLastConsumed(current, "op", lv_op_2_9, null);
                              							
                            }

                            }
                            break;
                        case 10 :
                            // InternalMyBashParser.g:2332:8: lv_op_2_10= GreaterThanSignVerticalLine
                            {
                            lv_op_2_10=(Token)match(input,GreaterThanSignVerticalLine,FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_op_2_10, grammarAccess.getRedirectionAccess().getOpGreaterThanSignVerticalLineKeyword_1_0_1_0_9());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getRedirectionRule());
                              								}
                              								setWithLastConsumed(current, "op", lv_op_2_10, null);
                              							
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalMyBashParser.g:2345:5: ( ( (lv_target_3_0= ruleWord ) ) | this_I_NUMBER_4= RULE_I_NUMBER )
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==DollarSignLeftParenthesisLeftParenthesis||LA45_0==DollarSignLeftCurlyBracket||LA45_0==LessThanSignLeftParenthesis||LA45_0==GreaterThanSignLeftParenthesis||LA45_0==QuotationMark||LA45_0==Apostrophe||(LA45_0>=RULE_S_WORD_PART && LA45_0<=RULE_WORD_PART)||LA45_0==RULE_VARIABLE||LA45_0==RULE_CS_START) ) {
                        alt45=1;
                    }
                    else if ( (LA45_0==RULE_I_NUMBER) ) {
                        alt45=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 45, 0, input);

                        throw nvae;
                    }
                    switch (alt45) {
                        case 1 :
                            // InternalMyBashParser.g:2346:6: ( (lv_target_3_0= ruleWord ) )
                            {
                            // InternalMyBashParser.g:2346:6: ( (lv_target_3_0= ruleWord ) )
                            // InternalMyBashParser.g:2347:7: (lv_target_3_0= ruleWord )
                            {
                            // InternalMyBashParser.g:2347:7: (lv_target_3_0= ruleWord )
                            // InternalMyBashParser.g:2348:8: lv_target_3_0= ruleWord
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getRedirectionAccess().getTargetWordParserRuleCall_1_0_2_0_0());
                              							
                            }
                            pushFollow(FOLLOW_2);
                            lv_target_3_0=ruleWord();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getRedirectionRule());
                              								}
                              								set(
                              									current,
                              									"target",
                              									lv_target_3_0,
                              									"org.xtext.example.mydsl.MyBash.Word");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalMyBashParser.g:2366:6: this_I_NUMBER_4= RULE_I_NUMBER
                            {
                            this_I_NUMBER_4=(Token)match(input,RULE_I_NUMBER,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(this_I_NUMBER_4, grammarAccess.getRedirectionAccess().getI_NUMBERTerminalRuleCall_1_0_2_1());
                              					
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMyBashParser.g:2373:4: ( ( (lv_op_5_0= LessThanSignLessThanSign ) ) this_HERE_DOC_WORD_6= RULE_HERE_DOC_WORD )
                    {
                    // InternalMyBashParser.g:2373:4: ( ( (lv_op_5_0= LessThanSignLessThanSign ) ) this_HERE_DOC_WORD_6= RULE_HERE_DOC_WORD )
                    // InternalMyBashParser.g:2374:5: ( (lv_op_5_0= LessThanSignLessThanSign ) ) this_HERE_DOC_WORD_6= RULE_HERE_DOC_WORD
                    {
                    // InternalMyBashParser.g:2374:5: ( (lv_op_5_0= LessThanSignLessThanSign ) )
                    // InternalMyBashParser.g:2375:6: (lv_op_5_0= LessThanSignLessThanSign )
                    {
                    // InternalMyBashParser.g:2375:6: (lv_op_5_0= LessThanSignLessThanSign )
                    // InternalMyBashParser.g:2376:7: lv_op_5_0= LessThanSignLessThanSign
                    {
                    lv_op_5_0=(Token)match(input,LessThanSignLessThanSign,FOLLOW_46); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_op_5_0, grammarAccess.getRedirectionAccess().getOpLessThanSignLessThanSignKeyword_1_1_0_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getRedirectionRule());
                      							}
                      							setWithLastConsumed(current, "op", lv_op_5_0, "<<");
                      						
                    }

                    }


                    }

                    this_HERE_DOC_WORD_6=(Token)match(input,RULE_HERE_DOC_WORD,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_HERE_DOC_WORD_6, grammarAccess.getRedirectionAccess().getHERE_DOC_WORDTerminalRuleCall_1_1_1());
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRedirection"


    // $ANTLR start "entryRuleArray"
    // InternalMyBashParser.g:2398:1: entryRuleArray returns [EObject current=null] : iv_ruleArray= ruleArray EOF ;
    public final EObject entryRuleArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArray = null;


        try {
            // InternalMyBashParser.g:2398:46: (iv_ruleArray= ruleArray EOF )
            // InternalMyBashParser.g:2399:2: iv_ruleArray= ruleArray EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArrayRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleArray=ruleArray();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArray; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArray"


    // $ANTLR start "ruleArray"
    // InternalMyBashParser.g:2405:1: ruleArray returns [EObject current=null] : (this_ArrayStart_0= ruleArrayStart ruleArrayEnd ) ;
    public final EObject ruleArray() throws RecognitionException {
        EObject current = null;

        EObject this_ArrayStart_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:2411:2: ( (this_ArrayStart_0= ruleArrayStart ruleArrayEnd ) )
            // InternalMyBashParser.g:2412:2: (this_ArrayStart_0= ruleArrayStart ruleArrayEnd )
            {
            // InternalMyBashParser.g:2412:2: (this_ArrayStart_0= ruleArrayStart ruleArrayEnd )
            // InternalMyBashParser.g:2413:3: this_ArrayStart_0= ruleArrayStart ruleArrayEnd
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getArrayAccess().getArrayStartParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_13);
            this_ArrayStart_0=ruleArrayStart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ArrayStart_0;
              			afterParserOrEnumRuleCall();
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getArrayAccess().getArrayEndParserRuleCall_1());
              		
            }
            pushFollow(FOLLOW_2);
            ruleArrayEnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArray"


    // $ANTLR start "entryRuleArrayStart"
    // InternalMyBashParser.g:2432:1: entryRuleArrayStart returns [EObject current=null] : iv_ruleArrayStart= ruleArrayStart EOF ;
    public final EObject entryRuleArrayStart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayStart = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_SL_COMMENT", "RULE_C_LINE", "RULE_WS", "RULE_HIDEN_NEW_LINE");

        try {
            // InternalMyBashParser.g:2434:2: (iv_ruleArrayStart= ruleArrayStart EOF )
            // InternalMyBashParser.g:2435:2: iv_ruleArrayStart= ruleArrayStart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArrayStartRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleArrayStart=ruleArrayStart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArrayStart; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleArrayStart"


    // $ANTLR start "ruleArrayStart"
    // InternalMyBashParser.g:2444:1: ruleArrayStart returns [EObject current=null] : ( () otherlv_1= LeftParenthesis ( ruleMaybeNewLine ( (lv_words_3_0= ruleWord ) ) )* ruleMaybeNewLine ) ;
    public final EObject ruleArrayStart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_words_3_0 = null;



        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_SL_COMMENT", "RULE_C_LINE", "RULE_WS", "RULE_HIDEN_NEW_LINE");

        try {
            // InternalMyBashParser.g:2451:2: ( ( () otherlv_1= LeftParenthesis ( ruleMaybeNewLine ( (lv_words_3_0= ruleWord ) ) )* ruleMaybeNewLine ) )
            // InternalMyBashParser.g:2452:2: ( () otherlv_1= LeftParenthesis ( ruleMaybeNewLine ( (lv_words_3_0= ruleWord ) ) )* ruleMaybeNewLine )
            {
            // InternalMyBashParser.g:2452:2: ( () otherlv_1= LeftParenthesis ( ruleMaybeNewLine ( (lv_words_3_0= ruleWord ) ) )* ruleMaybeNewLine )
            // InternalMyBashParser.g:2453:3: () otherlv_1= LeftParenthesis ( ruleMaybeNewLine ( (lv_words_3_0= ruleWord ) ) )* ruleMaybeNewLine
            {
            // InternalMyBashParser.g:2453:3: ()
            // InternalMyBashParser.g:2454:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getArrayStartAccess().getArrayAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,LeftParenthesis,FOLLOW_47); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getArrayStartAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalMyBashParser.g:2464:3: ( ruleMaybeNewLine ( (lv_words_3_0= ruleWord ) ) )*
            loop47:
            do {
                int alt47=2;
                alt47 = dfa47.predict(input);
                switch (alt47) {
            	case 1 :
            	    // InternalMyBashParser.g:2465:4: ruleMaybeNewLine ( (lv_words_3_0= ruleWord ) )
            	    {
            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getArrayStartAccess().getMaybeNewLineParserRuleCall_2_0());
            	      			
            	    }
            	    pushFollow(FOLLOW_21);
            	    ruleMaybeNewLine();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				afterParserOrEnumRuleCall();
            	      			
            	    }
            	    // InternalMyBashParser.g:2472:4: ( (lv_words_3_0= ruleWord ) )
            	    // InternalMyBashParser.g:2473:5: (lv_words_3_0= ruleWord )
            	    {
            	    // InternalMyBashParser.g:2473:5: (lv_words_3_0= ruleWord )
            	    // InternalMyBashParser.g:2474:6: lv_words_3_0= ruleWord
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getArrayStartAccess().getWordsWordParserRuleCall_2_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_47);
            	    lv_words_3_0=ruleWord();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getArrayStartRule());
            	      						}
            	      						add(
            	      							current,
            	      							"words",
            	      							lv_words_3_0,
            	      							"org.xtext.example.mydsl.MyBash.Word");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getArrayStartAccess().getMaybeNewLineParserRuleCall_3());
              		
            }
            pushFollow(FOLLOW_2);
            ruleMaybeNewLine();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleArrayStart"


    // $ANTLR start "entryRuleArrayEnd"
    // InternalMyBashParser.g:2506:1: entryRuleArrayEnd returns [String current=null] : iv_ruleArrayEnd= ruleArrayEnd EOF ;
    public final String entryRuleArrayEnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleArrayEnd = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_C_LINE");

        try {
            // InternalMyBashParser.g:2508:2: (iv_ruleArrayEnd= ruleArrayEnd EOF )
            // InternalMyBashParser.g:2509:2: iv_ruleArrayEnd= ruleArrayEnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArrayEndRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleArrayEnd=ruleArrayEnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArrayEnd.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleArrayEnd"


    // $ANTLR start "ruleArrayEnd"
    // InternalMyBashParser.g:2518:1: ruleArrayEnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= RightParenthesis ;
    public final AntlrDatatypeRuleToken ruleArrayEnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_C_LINE");

        try {
            // InternalMyBashParser.g:2525:2: (kw= RightParenthesis )
            // InternalMyBashParser.g:2526:2: kw= RightParenthesis
            {
            kw=(Token)match(input,RightParenthesis,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.getArrayEndAccess().getRightParenthesisKeyword());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleArrayEnd"


    // $ANTLR start "entryRuleWord"
    // InternalMyBashParser.g:2537:1: entryRuleWord returns [EObject current=null] : iv_ruleWord= ruleWord EOF ;
    public final EObject entryRuleWord() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWord = null;


        try {
            // InternalMyBashParser.g:2537:45: (iv_ruleWord= ruleWord EOF )
            // InternalMyBashParser.g:2538:2: iv_ruleWord= ruleWord EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWordRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleWord=ruleWord();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWord; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWord"


    // $ANTLR start "ruleWord"
    // InternalMyBashParser.g:2544:1: ruleWord returns [EObject current=null] : (this_Words_0= ruleWords | ( (lv_elements_1_0= ruleLiteralWord ) ) ) ;
    public final EObject ruleWord() throws RecognitionException {
        EObject current = null;

        EObject this_Words_0 = null;

        EObject lv_elements_1_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:2550:2: ( (this_Words_0= ruleWords | ( (lv_elements_1_0= ruleLiteralWord ) ) ) )
            // InternalMyBashParser.g:2551:2: (this_Words_0= ruleWords | ( (lv_elements_1_0= ruleLiteralWord ) ) )
            {
            // InternalMyBashParser.g:2551:2: (this_Words_0= ruleWords | ( (lv_elements_1_0= ruleLiteralWord ) ) )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==DollarSignLeftParenthesisLeftParenthesis||LA48_0==DollarSignLeftCurlyBracket||LA48_0==LessThanSignLeftParenthesis||LA48_0==GreaterThanSignLeftParenthesis||LA48_0==QuotationMark||LA48_0==Apostrophe||LA48_0==RULE_WORD_PART||LA48_0==RULE_VARIABLE||LA48_0==RULE_CS_START) ) {
                alt48=1;
            }
            else if ( (LA48_0==RULE_S_WORD_PART) ) {
                alt48=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // InternalMyBashParser.g:2552:3: this_Words_0= ruleWords
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getWordAccess().getWordsParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Words_0=ruleWords();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Words_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalMyBashParser.g:2561:3: ( (lv_elements_1_0= ruleLiteralWord ) )
                    {
                    // InternalMyBashParser.g:2561:3: ( (lv_elements_1_0= ruleLiteralWord ) )
                    // InternalMyBashParser.g:2562:4: (lv_elements_1_0= ruleLiteralWord )
                    {
                    // InternalMyBashParser.g:2562:4: (lv_elements_1_0= ruleLiteralWord )
                    // InternalMyBashParser.g:2563:5: lv_elements_1_0= ruleLiteralWord
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getWordAccess().getElementsLiteralWordParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_elements_1_0=ruleLiteralWord();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getWordRule());
                      					}
                      					add(
                      						current,
                      						"elements",
                      						lv_elements_1_0,
                      						"org.xtext.example.mydsl.MyBash.LiteralWord");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWord"


    // $ANTLR start "entryRuleLiteralWord"
    // InternalMyBashParser.g:2584:1: entryRuleLiteralWord returns [EObject current=null] : iv_ruleLiteralWord= ruleLiteralWord EOF ;
    public final EObject entryRuleLiteralWord() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralWord = null;


        try {
            // InternalMyBashParser.g:2584:52: (iv_ruleLiteralWord= ruleLiteralWord EOF )
            // InternalMyBashParser.g:2585:2: iv_ruleLiteralWord= ruleLiteralWord EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralWordRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLiteralWord=ruleLiteralWord();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralWord; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralWord"


    // $ANTLR start "ruleLiteralWord"
    // InternalMyBashParser.g:2591:1: ruleLiteralWord returns [EObject current=null] : ( () ( (lv_values_1_0= RULE_S_WORD_PART ) ) ) ;
    public final EObject ruleLiteralWord() throws RecognitionException {
        EObject current = null;

        Token lv_values_1_0=null;


        	enterRule();

        try {
            // InternalMyBashParser.g:2597:2: ( ( () ( (lv_values_1_0= RULE_S_WORD_PART ) ) ) )
            // InternalMyBashParser.g:2598:2: ( () ( (lv_values_1_0= RULE_S_WORD_PART ) ) )
            {
            // InternalMyBashParser.g:2598:2: ( () ( (lv_values_1_0= RULE_S_WORD_PART ) ) )
            // InternalMyBashParser.g:2599:3: () ( (lv_values_1_0= RULE_S_WORD_PART ) )
            {
            // InternalMyBashParser.g:2599:3: ()
            // InternalMyBashParser.g:2600:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getLiteralWordAccess().getLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalMyBashParser.g:2606:3: ( (lv_values_1_0= RULE_S_WORD_PART ) )
            // InternalMyBashParser.g:2607:4: (lv_values_1_0= RULE_S_WORD_PART )
            {
            // InternalMyBashParser.g:2607:4: (lv_values_1_0= RULE_S_WORD_PART )
            // InternalMyBashParser.g:2608:5: lv_values_1_0= RULE_S_WORD_PART
            {
            lv_values_1_0=(Token)match(input,RULE_S_WORD_PART,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_values_1_0, grammarAccess.getLiteralWordAccess().getValuesS_WORD_PARTTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getLiteralWordRule());
              					}
              					addWithLastConsumed(
              						current,
              						"values",
              						lv_values_1_0,
              						"org.xtext.example.mydsl.MyBash.S_WORD_PART");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralWord"


    // $ANTLR start "entryRuleAssignment"
    // InternalMyBashParser.g:2628:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_C_LINE");

        try {
            // InternalMyBashParser.g:2630:2: (iv_ruleAssignment= ruleAssignment EOF )
            // InternalMyBashParser.g:2631:2: iv_ruleAssignment= ruleAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAssignment=ruleAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignment; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleAssignment"


    // $ANTLR start "ruleAssignment"
    // InternalMyBashParser.g:2640:1: ruleAssignment returns [EObject current=null] : ( ( (lv_name_0_0= RULE_NAME ) ) ( (lv_index_1_0= ruleIndexEvaluation ) )? otherlv_2= EqualsSign ( ( Apostrophe | QuotationMark | DollarSignLeftCurlyBracket | DollarSignLeftParenthesisLeftParenthesis | LessThanSignLeftParenthesis | GreaterThanSignLeftParenthesis | LeftParenthesis | RULE_WORD_PART | RULE_VARIABLE | RULE_CS_START | RULE_S_WORD_PART )=> (lv_value_3_0= ruleAssignable ) )? ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_2=null;
        EObject lv_index_1_0 = null;

        EObject lv_value_3_0 = null;



        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_C_LINE");

        try {
            // InternalMyBashParser.g:2647:2: ( ( ( (lv_name_0_0= RULE_NAME ) ) ( (lv_index_1_0= ruleIndexEvaluation ) )? otherlv_2= EqualsSign ( ( Apostrophe | QuotationMark | DollarSignLeftCurlyBracket | DollarSignLeftParenthesisLeftParenthesis | LessThanSignLeftParenthesis | GreaterThanSignLeftParenthesis | LeftParenthesis | RULE_WORD_PART | RULE_VARIABLE | RULE_CS_START | RULE_S_WORD_PART )=> (lv_value_3_0= ruleAssignable ) )? ) )
            // InternalMyBashParser.g:2648:2: ( ( (lv_name_0_0= RULE_NAME ) ) ( (lv_index_1_0= ruleIndexEvaluation ) )? otherlv_2= EqualsSign ( ( Apostrophe | QuotationMark | DollarSignLeftCurlyBracket | DollarSignLeftParenthesisLeftParenthesis | LessThanSignLeftParenthesis | GreaterThanSignLeftParenthesis | LeftParenthesis | RULE_WORD_PART | RULE_VARIABLE | RULE_CS_START | RULE_S_WORD_PART )=> (lv_value_3_0= ruleAssignable ) )? )
            {
            // InternalMyBashParser.g:2648:2: ( ( (lv_name_0_0= RULE_NAME ) ) ( (lv_index_1_0= ruleIndexEvaluation ) )? otherlv_2= EqualsSign ( ( Apostrophe | QuotationMark | DollarSignLeftCurlyBracket | DollarSignLeftParenthesisLeftParenthesis | LessThanSignLeftParenthesis | GreaterThanSignLeftParenthesis | LeftParenthesis | RULE_WORD_PART | RULE_VARIABLE | RULE_CS_START | RULE_S_WORD_PART )=> (lv_value_3_0= ruleAssignable ) )? )
            // InternalMyBashParser.g:2649:3: ( (lv_name_0_0= RULE_NAME ) ) ( (lv_index_1_0= ruleIndexEvaluation ) )? otherlv_2= EqualsSign ( ( Apostrophe | QuotationMark | DollarSignLeftCurlyBracket | DollarSignLeftParenthesisLeftParenthesis | LessThanSignLeftParenthesis | GreaterThanSignLeftParenthesis | LeftParenthesis | RULE_WORD_PART | RULE_VARIABLE | RULE_CS_START | RULE_S_WORD_PART )=> (lv_value_3_0= ruleAssignable ) )?
            {
            // InternalMyBashParser.g:2649:3: ( (lv_name_0_0= RULE_NAME ) )
            // InternalMyBashParser.g:2650:4: (lv_name_0_0= RULE_NAME )
            {
            // InternalMyBashParser.g:2650:4: (lv_name_0_0= RULE_NAME )
            // InternalMyBashParser.g:2651:5: lv_name_0_0= RULE_NAME
            {
            lv_name_0_0=(Token)match(input,RULE_NAME,FOLLOW_48); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_0_0, grammarAccess.getAssignmentAccess().getNameNAMETerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getAssignmentRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_0_0,
              						"org.xtext.example.mydsl.MyBash.NAME");
              				
            }

            }


            }

            // InternalMyBashParser.g:2667:3: ( (lv_index_1_0= ruleIndexEvaluation ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==LeftSquareBracket) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalMyBashParser.g:2668:4: (lv_index_1_0= ruleIndexEvaluation )
                    {
                    // InternalMyBashParser.g:2668:4: (lv_index_1_0= ruleIndexEvaluation )
                    // InternalMyBashParser.g:2669:5: lv_index_1_0= ruleIndexEvaluation
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getAssignmentAccess().getIndexIndexEvaluationParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_49);
                    lv_index_1_0=ruleIndexEvaluation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getAssignmentRule());
                      					}
                      					set(
                      						current,
                      						"index",
                      						lv_index_1_0,
                      						"org.xtext.example.mydsl.MyBash.IndexEvaluation");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,EqualsSign,FOLLOW_50); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getAssignmentAccess().getEqualsSignKeyword_2());
              		
            }
            // InternalMyBashParser.g:2690:3: ( ( Apostrophe | QuotationMark | DollarSignLeftCurlyBracket | DollarSignLeftParenthesisLeftParenthesis | LessThanSignLeftParenthesis | GreaterThanSignLeftParenthesis | LeftParenthesis | RULE_WORD_PART | RULE_VARIABLE | RULE_CS_START | RULE_S_WORD_PART )=> (lv_value_3_0= ruleAssignable ) )?
            int alt50=2;
            alt50 = dfa50.predict(input);
            switch (alt50) {
                case 1 :
                    // InternalMyBashParser.g:2691:4: ( Apostrophe | QuotationMark | DollarSignLeftCurlyBracket | DollarSignLeftParenthesisLeftParenthesis | LessThanSignLeftParenthesis | GreaterThanSignLeftParenthesis | LeftParenthesis | RULE_WORD_PART | RULE_VARIABLE | RULE_CS_START | RULE_S_WORD_PART )=> (lv_value_3_0= ruleAssignable )
                    {
                    // InternalMyBashParser.g:2692:4: (lv_value_3_0= ruleAssignable )
                    // InternalMyBashParser.g:2693:5: lv_value_3_0= ruleAssignable
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getAssignmentAccess().getValueAssignableParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_3_0=ruleAssignable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getAssignmentRule());
                      					}
                      					set(
                      						current,
                      						"value",
                      						lv_value_3_0,
                      						"org.xtext.example.mydsl.MyBash.Assignable");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "entryRuleLAssignment"
    // InternalMyBashParser.g:2717:1: entryRuleLAssignment returns [EObject current=null] : iv_ruleLAssignment= ruleLAssignment EOF ;
    public final EObject entryRuleLAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLAssignment = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_C_LINE");

        try {
            // InternalMyBashParser.g:2719:2: (iv_ruleLAssignment= ruleLAssignment EOF )
            // InternalMyBashParser.g:2720:2: iv_ruleLAssignment= ruleLAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLAssignmentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLAssignment=ruleLAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLAssignment; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleLAssignment"


    // $ANTLR start "ruleLAssignment"
    // InternalMyBashParser.g:2729:1: ruleLAssignment returns [EObject current=null] : ( ( (lv_name_0_0= RULE_NAME ) ) ( (lv_index_1_0= ruleIndexEvaluation ) )? (otherlv_2= EqualsSign ( ( Apostrophe | QuotationMark | DollarSignLeftCurlyBracket | DollarSignLeftParenthesisLeftParenthesis | LessThanSignLeftParenthesis | GreaterThanSignLeftParenthesis | LeftParenthesis | RULE_WORD_PART | RULE_VARIABLE | RULE_CS_START | RULE_S_WORD_PART )=> (lv_value_3_0= ruleAssignable ) ) )? ) ;
    public final EObject ruleLAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_2=null;
        EObject lv_index_1_0 = null;

        EObject lv_value_3_0 = null;



        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_C_LINE");

        try {
            // InternalMyBashParser.g:2736:2: ( ( ( (lv_name_0_0= RULE_NAME ) ) ( (lv_index_1_0= ruleIndexEvaluation ) )? (otherlv_2= EqualsSign ( ( Apostrophe | QuotationMark | DollarSignLeftCurlyBracket | DollarSignLeftParenthesisLeftParenthesis | LessThanSignLeftParenthesis | GreaterThanSignLeftParenthesis | LeftParenthesis | RULE_WORD_PART | RULE_VARIABLE | RULE_CS_START | RULE_S_WORD_PART )=> (lv_value_3_0= ruleAssignable ) ) )? ) )
            // InternalMyBashParser.g:2737:2: ( ( (lv_name_0_0= RULE_NAME ) ) ( (lv_index_1_0= ruleIndexEvaluation ) )? (otherlv_2= EqualsSign ( ( Apostrophe | QuotationMark | DollarSignLeftCurlyBracket | DollarSignLeftParenthesisLeftParenthesis | LessThanSignLeftParenthesis | GreaterThanSignLeftParenthesis | LeftParenthesis | RULE_WORD_PART | RULE_VARIABLE | RULE_CS_START | RULE_S_WORD_PART )=> (lv_value_3_0= ruleAssignable ) ) )? )
            {
            // InternalMyBashParser.g:2737:2: ( ( (lv_name_0_0= RULE_NAME ) ) ( (lv_index_1_0= ruleIndexEvaluation ) )? (otherlv_2= EqualsSign ( ( Apostrophe | QuotationMark | DollarSignLeftCurlyBracket | DollarSignLeftParenthesisLeftParenthesis | LessThanSignLeftParenthesis | GreaterThanSignLeftParenthesis | LeftParenthesis | RULE_WORD_PART | RULE_VARIABLE | RULE_CS_START | RULE_S_WORD_PART )=> (lv_value_3_0= ruleAssignable ) ) )? )
            // InternalMyBashParser.g:2738:3: ( (lv_name_0_0= RULE_NAME ) ) ( (lv_index_1_0= ruleIndexEvaluation ) )? (otherlv_2= EqualsSign ( ( Apostrophe | QuotationMark | DollarSignLeftCurlyBracket | DollarSignLeftParenthesisLeftParenthesis | LessThanSignLeftParenthesis | GreaterThanSignLeftParenthesis | LeftParenthesis | RULE_WORD_PART | RULE_VARIABLE | RULE_CS_START | RULE_S_WORD_PART )=> (lv_value_3_0= ruleAssignable ) ) )?
            {
            // InternalMyBashParser.g:2738:3: ( (lv_name_0_0= RULE_NAME ) )
            // InternalMyBashParser.g:2739:4: (lv_name_0_0= RULE_NAME )
            {
            // InternalMyBashParser.g:2739:4: (lv_name_0_0= RULE_NAME )
            // InternalMyBashParser.g:2740:5: lv_name_0_0= RULE_NAME
            {
            lv_name_0_0=(Token)match(input,RULE_NAME,FOLLOW_51); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_0_0, grammarAccess.getLAssignmentAccess().getNameNAMETerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getLAssignmentRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_0_0,
              						"org.xtext.example.mydsl.MyBash.NAME");
              				
            }

            }


            }

            // InternalMyBashParser.g:2756:3: ( (lv_index_1_0= ruleIndexEvaluation ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==LeftSquareBracket) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalMyBashParser.g:2757:4: (lv_index_1_0= ruleIndexEvaluation )
                    {
                    // InternalMyBashParser.g:2757:4: (lv_index_1_0= ruleIndexEvaluation )
                    // InternalMyBashParser.g:2758:5: lv_index_1_0= ruleIndexEvaluation
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getLAssignmentAccess().getIndexIndexEvaluationParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_52);
                    lv_index_1_0=ruleIndexEvaluation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getLAssignmentRule());
                      					}
                      					set(
                      						current,
                      						"index",
                      						lv_index_1_0,
                      						"org.xtext.example.mydsl.MyBash.IndexEvaluation");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalMyBashParser.g:2775:3: (otherlv_2= EqualsSign ( ( Apostrophe | QuotationMark | DollarSignLeftCurlyBracket | DollarSignLeftParenthesisLeftParenthesis | LessThanSignLeftParenthesis | GreaterThanSignLeftParenthesis | LeftParenthesis | RULE_WORD_PART | RULE_VARIABLE | RULE_CS_START | RULE_S_WORD_PART )=> (lv_value_3_0= ruleAssignable ) ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==EqualsSign) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalMyBashParser.g:2776:4: otherlv_2= EqualsSign ( ( Apostrophe | QuotationMark | DollarSignLeftCurlyBracket | DollarSignLeftParenthesisLeftParenthesis | LessThanSignLeftParenthesis | GreaterThanSignLeftParenthesis | LeftParenthesis | RULE_WORD_PART | RULE_VARIABLE | RULE_CS_START | RULE_S_WORD_PART )=> (lv_value_3_0= ruleAssignable ) )
                    {
                    otherlv_2=(Token)match(input,EqualsSign,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getLAssignmentAccess().getEqualsSignKeyword_2_0());
                      			
                    }
                    // InternalMyBashParser.g:2780:4: ( ( Apostrophe | QuotationMark | DollarSignLeftCurlyBracket | DollarSignLeftParenthesisLeftParenthesis | LessThanSignLeftParenthesis | GreaterThanSignLeftParenthesis | LeftParenthesis | RULE_WORD_PART | RULE_VARIABLE | RULE_CS_START | RULE_S_WORD_PART )=> (lv_value_3_0= ruleAssignable ) )
                    // InternalMyBashParser.g:2781:5: ( Apostrophe | QuotationMark | DollarSignLeftCurlyBracket | DollarSignLeftParenthesisLeftParenthesis | LessThanSignLeftParenthesis | GreaterThanSignLeftParenthesis | LeftParenthesis | RULE_WORD_PART | RULE_VARIABLE | RULE_CS_START | RULE_S_WORD_PART )=> (lv_value_3_0= ruleAssignable )
                    {
                    // InternalMyBashParser.g:2782:5: (lv_value_3_0= ruleAssignable )
                    // InternalMyBashParser.g:2783:6: lv_value_3_0= ruleAssignable
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getLAssignmentAccess().getValueAssignableParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_3_0=ruleAssignable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getLAssignmentRule());
                      						}
                      						set(
                      							current,
                      							"value",
                      							lv_value_3_0,
                      							"org.xtext.example.mydsl.MyBash.Assignable");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleLAssignment"


    // $ANTLR start "entryRuleAssignable"
    // InternalMyBashParser.g:2808:1: entryRuleAssignable returns [EObject current=null] : iv_ruleAssignable= ruleAssignable EOF ;
    public final EObject entryRuleAssignable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignable = null;


        try {
            // InternalMyBashParser.g:2808:51: (iv_ruleAssignable= ruleAssignable EOF )
            // InternalMyBashParser.g:2809:2: iv_ruleAssignable= ruleAssignable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAssignable=ruleAssignable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignable; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignable"


    // $ANTLR start "ruleAssignable"
    // InternalMyBashParser.g:2815:1: ruleAssignable returns [EObject current=null] : (this_Word_0= ruleWord | this_Array_1= ruleArray ) ;
    public final EObject ruleAssignable() throws RecognitionException {
        EObject current = null;

        EObject this_Word_0 = null;

        EObject this_Array_1 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:2821:2: ( (this_Word_0= ruleWord | this_Array_1= ruleArray ) )
            // InternalMyBashParser.g:2822:2: (this_Word_0= ruleWord | this_Array_1= ruleArray )
            {
            // InternalMyBashParser.g:2822:2: (this_Word_0= ruleWord | this_Array_1= ruleArray )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==DollarSignLeftParenthesisLeftParenthesis||LA53_0==DollarSignLeftCurlyBracket||LA53_0==LessThanSignLeftParenthesis||LA53_0==GreaterThanSignLeftParenthesis||LA53_0==QuotationMark||LA53_0==Apostrophe||(LA53_0>=RULE_S_WORD_PART && LA53_0<=RULE_WORD_PART)||LA53_0==RULE_VARIABLE||LA53_0==RULE_CS_START) ) {
                alt53=1;
            }
            else if ( (LA53_0==LeftParenthesis) ) {
                alt53=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // InternalMyBashParser.g:2823:3: this_Word_0= ruleWord
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAssignableAccess().getWordParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Word_0=ruleWord();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Word_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalMyBashParser.g:2832:3: this_Array_1= ruleArray
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAssignableAccess().getArrayParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Array_1=ruleArray();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Array_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignable"


    // $ANTLR start "entryRuleWords"
    // InternalMyBashParser.g:2844:1: entryRuleWords returns [EObject current=null] : iv_ruleWords= ruleWords EOF ;
    public final EObject entryRuleWords() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWords = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_C_LINE");

        try {
            // InternalMyBashParser.g:2846:2: (iv_ruleWords= ruleWords EOF )
            // InternalMyBashParser.g:2847:2: iv_ruleWords= ruleWords EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWordsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleWords=ruleWords();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWords; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleWords"


    // $ANTLR start "ruleWords"
    // InternalMyBashParser.g:2856:1: ruleWords returns [EObject current=null] : ( ( Apostrophe | QuotationMark | DollarSignLeftCurlyBracket | DollarSignLeftParenthesisLeftParenthesis | LessThanSignLeftParenthesis | GreaterThanSignLeftParenthesis | RULE_WORD_PART | RULE_VARIABLE | RULE_CS_START )=> (lv_elements_0_0= ruleWordElement ) )+ ;
    public final EObject ruleWords() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;



        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_C_LINE");

        try {
            // InternalMyBashParser.g:2863:2: ( ( ( Apostrophe | QuotationMark | DollarSignLeftCurlyBracket | DollarSignLeftParenthesisLeftParenthesis | LessThanSignLeftParenthesis | GreaterThanSignLeftParenthesis | RULE_WORD_PART | RULE_VARIABLE | RULE_CS_START )=> (lv_elements_0_0= ruleWordElement ) )+ )
            // InternalMyBashParser.g:2864:2: ( ( Apostrophe | QuotationMark | DollarSignLeftCurlyBracket | DollarSignLeftParenthesisLeftParenthesis | LessThanSignLeftParenthesis | GreaterThanSignLeftParenthesis | RULE_WORD_PART | RULE_VARIABLE | RULE_CS_START )=> (lv_elements_0_0= ruleWordElement ) )+
            {
            // InternalMyBashParser.g:2864:2: ( ( Apostrophe | QuotationMark | DollarSignLeftCurlyBracket | DollarSignLeftParenthesisLeftParenthesis | LessThanSignLeftParenthesis | GreaterThanSignLeftParenthesis | RULE_WORD_PART | RULE_VARIABLE | RULE_CS_START )=> (lv_elements_0_0= ruleWordElement ) )+
            int cnt54=0;
            loop54:
            do {
                int alt54=2;
                alt54 = dfa54.predict(input);
                switch (alt54) {
            	case 1 :
            	    // InternalMyBashParser.g:2865:3: ( Apostrophe | QuotationMark | DollarSignLeftCurlyBracket | DollarSignLeftParenthesisLeftParenthesis | LessThanSignLeftParenthesis | GreaterThanSignLeftParenthesis | RULE_WORD_PART | RULE_VARIABLE | RULE_CS_START )=> (lv_elements_0_0= ruleWordElement )
            	    {
            	    // InternalMyBashParser.g:2866:3: (lv_elements_0_0= ruleWordElement )
            	    // InternalMyBashParser.g:2867:4: lv_elements_0_0= ruleWordElement
            	    {
            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getWordsAccess().getElementsWordElementParserRuleCall_0());
            	      			
            	    }
            	    pushFollow(FOLLOW_53);
            	    lv_elements_0_0=ruleWordElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				if (current==null) {
            	      					current = createModelElementForParent(grammarAccess.getWordsRule());
            	      				}
            	      				add(
            	      					current,
            	      					"elements",
            	      					lv_elements_0_0,
            	      					"org.xtext.example.mydsl.MyBash.WordElement");
            	      				afterParserOrEnumRuleCall();
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt54 >= 1 ) break loop54;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(54, input);
                        throw eee;
                }
                cnt54++;
            } while (true);


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleWords"


    // $ANTLR start "entryRuleDQString"
    // InternalMyBashParser.g:2890:1: entryRuleDQString returns [EObject current=null] : iv_ruleDQString= ruleDQString EOF ;
    public final EObject entryRuleDQString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDQString = null;


        try {
            // InternalMyBashParser.g:2890:49: (iv_ruleDQString= ruleDQString EOF )
            // InternalMyBashParser.g:2891:2: iv_ruleDQString= ruleDQString EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDQStringRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDQString=ruleDQString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDQString; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDQString"


    // $ANTLR start "ruleDQString"
    // InternalMyBashParser.g:2897:1: ruleDQString returns [EObject current=null] : ( () otherlv_1= QuotationMark ( (lv_elements_2_0= ruleStringElement ) )* otherlv_3= QuotationMark ) ;
    public final EObject ruleDQString() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_elements_2_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:2903:2: ( ( () otherlv_1= QuotationMark ( (lv_elements_2_0= ruleStringElement ) )* otherlv_3= QuotationMark ) )
            // InternalMyBashParser.g:2904:2: ( () otherlv_1= QuotationMark ( (lv_elements_2_0= ruleStringElement ) )* otherlv_3= QuotationMark )
            {
            // InternalMyBashParser.g:2904:2: ( () otherlv_1= QuotationMark ( (lv_elements_2_0= ruleStringElement ) )* otherlv_3= QuotationMark )
            // InternalMyBashParser.g:2905:3: () otherlv_1= QuotationMark ( (lv_elements_2_0= ruleStringElement ) )* otherlv_3= QuotationMark
            {
            // InternalMyBashParser.g:2905:3: ()
            // InternalMyBashParser.g:2906:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getDQStringAccess().getDQStringAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,QuotationMark,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getDQStringAccess().getQuotationMarkKeyword_1());
              		
            }
            // InternalMyBashParser.g:2916:3: ( (lv_elements_2_0= ruleStringElement ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==DollarSignLeftParenthesisLeftParenthesis||LA55_0==DollarSignLeftCurlyBracket||LA55_0==LessThanSignLeftParenthesis||LA55_0==GreaterThanSignLeftParenthesis||LA55_0==RULE_WORD_PART||LA55_0==RULE_VARIABLE||LA55_0==RULE_CS_START) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalMyBashParser.g:2917:4: (lv_elements_2_0= ruleStringElement )
            	    {
            	    // InternalMyBashParser.g:2917:4: (lv_elements_2_0= ruleStringElement )
            	    // InternalMyBashParser.g:2918:5: lv_elements_2_0= ruleStringElement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getDQStringAccess().getElementsStringElementParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_21);
            	    lv_elements_2_0=ruleStringElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getDQStringRule());
            	      					}
            	      					add(
            	      						current,
            	      						"elements",
            	      						lv_elements_2_0,
            	      						"org.xtext.example.mydsl.MyBash.StringElement");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);

            otherlv_3=(Token)match(input,QuotationMark,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getDQStringAccess().getQuotationMarkKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDQString"


    // $ANTLR start "entryRuleExpansion"
    // InternalMyBashParser.g:2943:1: entryRuleExpansion returns [EObject current=null] : iv_ruleExpansion= ruleExpansion EOF ;
    public final EObject entryRuleExpansion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpansion = null;


        try {
            // InternalMyBashParser.g:2943:50: (iv_ruleExpansion= ruleExpansion EOF )
            // InternalMyBashParser.g:2944:2: iv_ruleExpansion= ruleExpansion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpansionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpansion=ruleExpansion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpansion; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpansion"


    // $ANTLR start "ruleExpansion"
    // InternalMyBashParser.g:2950:1: ruleExpansion returns [EObject current=null] : (this_ParameterExpansion_0= ruleParameterExpansion | this_CommandSubstitution_1= ruleCommandSubstitution | this_ArithmeticExpansion_2= ruleArithmeticExpansion | this_ProcessSubstitution_3= ruleProcessSubstitution ) ;
    public final EObject ruleExpansion() throws RecognitionException {
        EObject current = null;

        EObject this_ParameterExpansion_0 = null;

        EObject this_CommandSubstitution_1 = null;

        EObject this_ArithmeticExpansion_2 = null;

        EObject this_ProcessSubstitution_3 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:2956:2: ( (this_ParameterExpansion_0= ruleParameterExpansion | this_CommandSubstitution_1= ruleCommandSubstitution | this_ArithmeticExpansion_2= ruleArithmeticExpansion | this_ProcessSubstitution_3= ruleProcessSubstitution ) )
            // InternalMyBashParser.g:2957:2: (this_ParameterExpansion_0= ruleParameterExpansion | this_CommandSubstitution_1= ruleCommandSubstitution | this_ArithmeticExpansion_2= ruleArithmeticExpansion | this_ProcessSubstitution_3= ruleProcessSubstitution )
            {
            // InternalMyBashParser.g:2957:2: (this_ParameterExpansion_0= ruleParameterExpansion | this_CommandSubstitution_1= ruleCommandSubstitution | this_ArithmeticExpansion_2= ruleArithmeticExpansion | this_ProcessSubstitution_3= ruleProcessSubstitution )
            int alt56=4;
            switch ( input.LA(1) ) {
            case DollarSignLeftCurlyBracket:
            case RULE_VARIABLE:
                {
                alt56=1;
                }
                break;
            case RULE_CS_START:
                {
                alt56=2;
                }
                break;
            case DollarSignLeftParenthesisLeftParenthesis:
                {
                alt56=3;
                }
                break;
            case LessThanSignLeftParenthesis:
            case GreaterThanSignLeftParenthesis:
                {
                alt56=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // InternalMyBashParser.g:2958:3: this_ParameterExpansion_0= ruleParameterExpansion
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpansionAccess().getParameterExpansionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ParameterExpansion_0=ruleParameterExpansion();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ParameterExpansion_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalMyBashParser.g:2967:3: this_CommandSubstitution_1= ruleCommandSubstitution
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpansionAccess().getCommandSubstitutionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_CommandSubstitution_1=ruleCommandSubstitution();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_CommandSubstitution_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalMyBashParser.g:2976:3: this_ArithmeticExpansion_2= ruleArithmeticExpansion
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpansionAccess().getArithmeticExpansionParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ArithmeticExpansion_2=ruleArithmeticExpansion();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ArithmeticExpansion_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalMyBashParser.g:2985:3: this_ProcessSubstitution_3= ruleProcessSubstitution
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpansionAccess().getProcessSubstitutionParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ProcessSubstitution_3=ruleProcessSubstitution();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ProcessSubstitution_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpansion"


    // $ANTLR start "entryRuleWordElement"
    // InternalMyBashParser.g:2997:1: entryRuleWordElement returns [EObject current=null] : iv_ruleWordElement= ruleWordElement EOF ;
    public final EObject entryRuleWordElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWordElement = null;


        try {
            // InternalMyBashParser.g:2997:52: (iv_ruleWordElement= ruleWordElement EOF )
            // InternalMyBashParser.g:2998:2: iv_ruleWordElement= ruleWordElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWordElementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleWordElement=ruleWordElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWordElement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWordElement"


    // $ANTLR start "ruleWordElement"
    // InternalMyBashParser.g:3004:1: ruleWordElement returns [EObject current=null] : ( ( ( ruleLiteralWordPart )=>this_LiteralWordPart_0= ruleLiteralWordPart ) | this_DQString_1= ruleDQString | this_Expansion_2= ruleExpansion ) ;
    public final EObject ruleWordElement() throws RecognitionException {
        EObject current = null;

        EObject this_LiteralWordPart_0 = null;

        EObject this_DQString_1 = null;

        EObject this_Expansion_2 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:3010:2: ( ( ( ( ruleLiteralWordPart )=>this_LiteralWordPart_0= ruleLiteralWordPart ) | this_DQString_1= ruleDQString | this_Expansion_2= ruleExpansion ) )
            // InternalMyBashParser.g:3011:2: ( ( ( ruleLiteralWordPart )=>this_LiteralWordPart_0= ruleLiteralWordPart ) | this_DQString_1= ruleDQString | this_Expansion_2= ruleExpansion )
            {
            // InternalMyBashParser.g:3011:2: ( ( ( ruleLiteralWordPart )=>this_LiteralWordPart_0= ruleLiteralWordPart ) | this_DQString_1= ruleDQString | this_Expansion_2= ruleExpansion )
            int alt57=3;
            alt57 = dfa57.predict(input);
            switch (alt57) {
                case 1 :
                    // InternalMyBashParser.g:3012:3: ( ( ruleLiteralWordPart )=>this_LiteralWordPart_0= ruleLiteralWordPart )
                    {
                    // InternalMyBashParser.g:3012:3: ( ( ruleLiteralWordPart )=>this_LiteralWordPart_0= ruleLiteralWordPart )
                    // InternalMyBashParser.g:3013:4: ( ruleLiteralWordPart )=>this_LiteralWordPart_0= ruleLiteralWordPart
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getWordElementAccess().getLiteralWordPartParserRuleCall_0());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_LiteralWordPart_0=ruleLiteralWordPart();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_LiteralWordPart_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMyBashParser.g:3024:3: this_DQString_1= ruleDQString
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getWordElementAccess().getDQStringParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_DQString_1=ruleDQString();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_DQString_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalMyBashParser.g:3033:3: this_Expansion_2= ruleExpansion
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getWordElementAccess().getExpansionParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Expansion_2=ruleExpansion();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Expansion_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWordElement"


    // $ANTLR start "entryRuleStringElement"
    // InternalMyBashParser.g:3045:1: entryRuleStringElement returns [EObject current=null] : iv_ruleStringElement= ruleStringElement EOF ;
    public final EObject entryRuleStringElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringElement = null;


        try {
            // InternalMyBashParser.g:3045:54: (iv_ruleStringElement= ruleStringElement EOF )
            // InternalMyBashParser.g:3046:2: iv_ruleStringElement= ruleStringElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringElementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStringElement=ruleStringElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringElement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringElement"


    // $ANTLR start "ruleStringElement"
    // InternalMyBashParser.g:3052:1: ruleStringElement returns [EObject current=null] : (this_LiteralStringPart_0= ruleLiteralStringPart | this_Expansion_1= ruleExpansion ) ;
    public final EObject ruleStringElement() throws RecognitionException {
        EObject current = null;

        EObject this_LiteralStringPart_0 = null;

        EObject this_Expansion_1 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:3058:2: ( (this_LiteralStringPart_0= ruleLiteralStringPart | this_Expansion_1= ruleExpansion ) )
            // InternalMyBashParser.g:3059:2: (this_LiteralStringPart_0= ruleLiteralStringPart | this_Expansion_1= ruleExpansion )
            {
            // InternalMyBashParser.g:3059:2: (this_LiteralStringPart_0= ruleLiteralStringPart | this_Expansion_1= ruleExpansion )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==RULE_WORD_PART) ) {
                alt58=1;
            }
            else if ( (LA58_0==DollarSignLeftParenthesisLeftParenthesis||LA58_0==DollarSignLeftCurlyBracket||LA58_0==LessThanSignLeftParenthesis||LA58_0==GreaterThanSignLeftParenthesis||LA58_0==RULE_VARIABLE||LA58_0==RULE_CS_START) ) {
                alt58=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // InternalMyBashParser.g:3060:3: this_LiteralStringPart_0= ruleLiteralStringPart
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStringElementAccess().getLiteralStringPartParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_LiteralStringPart_0=ruleLiteralStringPart();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralStringPart_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalMyBashParser.g:3069:3: this_Expansion_1= ruleExpansion
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStringElementAccess().getExpansionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Expansion_1=ruleExpansion();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Expansion_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringElement"


    // $ANTLR start "entryRuleLiteralStringPart"
    // InternalMyBashParser.g:3081:1: entryRuleLiteralStringPart returns [EObject current=null] : iv_ruleLiteralStringPart= ruleLiteralStringPart EOF ;
    public final EObject entryRuleLiteralStringPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralStringPart = null;


        try {
            // InternalMyBashParser.g:3081:58: (iv_ruleLiteralStringPart= ruleLiteralStringPart EOF )
            // InternalMyBashParser.g:3082:2: iv_ruleLiteralStringPart= ruleLiteralStringPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralStringPartRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLiteralStringPart=ruleLiteralStringPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralStringPart; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralStringPart"


    // $ANTLR start "ruleLiteralStringPart"
    // InternalMyBashParser.g:3088:1: ruleLiteralStringPart returns [EObject current=null] : ( () ( ( ( RULE_WORD_PART ) )=> (lv_values_1_0= RULE_WORD_PART ) )+ ) ;
    public final EObject ruleLiteralStringPart() throws RecognitionException {
        EObject current = null;

        Token lv_values_1_0=null;


        	enterRule();

        try {
            // InternalMyBashParser.g:3094:2: ( ( () ( ( ( RULE_WORD_PART ) )=> (lv_values_1_0= RULE_WORD_PART ) )+ ) )
            // InternalMyBashParser.g:3095:2: ( () ( ( ( RULE_WORD_PART ) )=> (lv_values_1_0= RULE_WORD_PART ) )+ )
            {
            // InternalMyBashParser.g:3095:2: ( () ( ( ( RULE_WORD_PART ) )=> (lv_values_1_0= RULE_WORD_PART ) )+ )
            // InternalMyBashParser.g:3096:3: () ( ( ( RULE_WORD_PART ) )=> (lv_values_1_0= RULE_WORD_PART ) )+
            {
            // InternalMyBashParser.g:3096:3: ()
            // InternalMyBashParser.g:3097:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getLiteralStringPartAccess().getLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalMyBashParser.g:3103:3: ( ( ( RULE_WORD_PART ) )=> (lv_values_1_0= RULE_WORD_PART ) )+
            int cnt59=0;
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==RULE_WORD_PART) ) {
                    int LA59_2 = input.LA(2);

                    if ( (synpred6_InternalMyBashParser()) ) {
                        alt59=1;
                    }


                }


                switch (alt59) {
            	case 1 :
            	    // InternalMyBashParser.g:3104:4: ( ( RULE_WORD_PART ) )=> (lv_values_1_0= RULE_WORD_PART )
            	    {
            	    // InternalMyBashParser.g:3108:4: (lv_values_1_0= RULE_WORD_PART )
            	    // InternalMyBashParser.g:3109:5: lv_values_1_0= RULE_WORD_PART
            	    {
            	    lv_values_1_0=(Token)match(input,RULE_WORD_PART,FOLLOW_54); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(lv_values_1_0, grammarAccess.getLiteralStringPartAccess().getValuesWORD_PARTTerminalRuleCall_1_0());
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElement(grammarAccess.getLiteralStringPartRule());
            	      					}
            	      					addWithLastConsumed(
            	      						current,
            	      						"values",
            	      						lv_values_1_0,
            	      						"org.xtext.example.mydsl.MyBash.WORD_PART");
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt59 >= 1 ) break loop59;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(59, input);
                        throw eee;
                }
                cnt59++;
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralStringPart"


    // $ANTLR start "entryRuleLiteralWordPart"
    // InternalMyBashParser.g:3129:1: entryRuleLiteralWordPart returns [EObject current=null] : iv_ruleLiteralWordPart= ruleLiteralWordPart EOF ;
    public final EObject entryRuleLiteralWordPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralWordPart = null;


        try {
            // InternalMyBashParser.g:3129:56: (iv_ruleLiteralWordPart= ruleLiteralWordPart EOF )
            // InternalMyBashParser.g:3130:2: iv_ruleLiteralWordPart= ruleLiteralWordPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralWordPartRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLiteralWordPart=ruleLiteralWordPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralWordPart; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralWordPart"


    // $ANTLR start "ruleLiteralWordPart"
    // InternalMyBashParser.g:3136:1: ruleLiteralWordPart returns [EObject current=null] : ( () ( ( ( ( ( RULE_WORD_PART ) ) | ( Apostrophe ( ( RULE_WORD_PART ) )? Apostrophe ) | ( QuotationMark ( ( RULE_WORD_PART ) )* QuotationMark ) ) )=> ( ( (lv_values_1_0= RULE_WORD_PART ) ) | (otherlv_2= Apostrophe ( (lv_values_3_0= RULE_WORD_PART ) )? otherlv_4= Apostrophe ) | (otherlv_5= QuotationMark ( (lv_values_6_0= RULE_WORD_PART ) )* otherlv_7= QuotationMark ) ) )+ ) ;
    public final EObject ruleLiteralWordPart() throws RecognitionException {
        EObject current = null;

        Token lv_values_1_0=null;
        Token otherlv_2=null;
        Token lv_values_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_values_6_0=null;
        Token otherlv_7=null;


        	enterRule();

        try {
            // InternalMyBashParser.g:3142:2: ( ( () ( ( ( ( ( RULE_WORD_PART ) ) | ( Apostrophe ( ( RULE_WORD_PART ) )? Apostrophe ) | ( QuotationMark ( ( RULE_WORD_PART ) )* QuotationMark ) ) )=> ( ( (lv_values_1_0= RULE_WORD_PART ) ) | (otherlv_2= Apostrophe ( (lv_values_3_0= RULE_WORD_PART ) )? otherlv_4= Apostrophe ) | (otherlv_5= QuotationMark ( (lv_values_6_0= RULE_WORD_PART ) )* otherlv_7= QuotationMark ) ) )+ ) )
            // InternalMyBashParser.g:3143:2: ( () ( ( ( ( ( RULE_WORD_PART ) ) | ( Apostrophe ( ( RULE_WORD_PART ) )? Apostrophe ) | ( QuotationMark ( ( RULE_WORD_PART ) )* QuotationMark ) ) )=> ( ( (lv_values_1_0= RULE_WORD_PART ) ) | (otherlv_2= Apostrophe ( (lv_values_3_0= RULE_WORD_PART ) )? otherlv_4= Apostrophe ) | (otherlv_5= QuotationMark ( (lv_values_6_0= RULE_WORD_PART ) )* otherlv_7= QuotationMark ) ) )+ )
            {
            // InternalMyBashParser.g:3143:2: ( () ( ( ( ( ( RULE_WORD_PART ) ) | ( Apostrophe ( ( RULE_WORD_PART ) )? Apostrophe ) | ( QuotationMark ( ( RULE_WORD_PART ) )* QuotationMark ) ) )=> ( ( (lv_values_1_0= RULE_WORD_PART ) ) | (otherlv_2= Apostrophe ( (lv_values_3_0= RULE_WORD_PART ) )? otherlv_4= Apostrophe ) | (otherlv_5= QuotationMark ( (lv_values_6_0= RULE_WORD_PART ) )* otherlv_7= QuotationMark ) ) )+ )
            // InternalMyBashParser.g:3144:3: () ( ( ( ( ( RULE_WORD_PART ) ) | ( Apostrophe ( ( RULE_WORD_PART ) )? Apostrophe ) | ( QuotationMark ( ( RULE_WORD_PART ) )* QuotationMark ) ) )=> ( ( (lv_values_1_0= RULE_WORD_PART ) ) | (otherlv_2= Apostrophe ( (lv_values_3_0= RULE_WORD_PART ) )? otherlv_4= Apostrophe ) | (otherlv_5= QuotationMark ( (lv_values_6_0= RULE_WORD_PART ) )* otherlv_7= QuotationMark ) ) )+
            {
            // InternalMyBashParser.g:3144:3: ()
            // InternalMyBashParser.g:3145:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getLiteralWordPartAccess().getLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalMyBashParser.g:3151:3: ( ( ( ( ( RULE_WORD_PART ) ) | ( Apostrophe ( ( RULE_WORD_PART ) )? Apostrophe ) | ( QuotationMark ( ( RULE_WORD_PART ) )* QuotationMark ) ) )=> ( ( (lv_values_1_0= RULE_WORD_PART ) ) | (otherlv_2= Apostrophe ( (lv_values_3_0= RULE_WORD_PART ) )? otherlv_4= Apostrophe ) | (otherlv_5= QuotationMark ( (lv_values_6_0= RULE_WORD_PART ) )* otherlv_7= QuotationMark ) ) )+
            int cnt63=0;
            loop63:
            do {
                int alt63=2;
                switch ( input.LA(1) ) {
                case RULE_WORD_PART:
                    {
                    int LA63_1 = input.LA(2);

                    if ( (synpred7_InternalMyBashParser()) ) {
                        alt63=1;
                    }


                    }
                    break;
                case Apostrophe:
                    {
                    int LA63_2 = input.LA(2);

                    if ( (synpred7_InternalMyBashParser()) ) {
                        alt63=1;
                    }


                    }
                    break;
                case QuotationMark:
                    {
                    int LA63_3 = input.LA(2);

                    if ( (synpred7_InternalMyBashParser()) ) {
                        alt63=1;
                    }


                    }
                    break;

                }

                switch (alt63) {
            	case 1 :
            	    // InternalMyBashParser.g:3152:4: ( ( ( ( RULE_WORD_PART ) ) | ( Apostrophe ( ( RULE_WORD_PART ) )? Apostrophe ) | ( QuotationMark ( ( RULE_WORD_PART ) )* QuotationMark ) ) )=> ( ( (lv_values_1_0= RULE_WORD_PART ) ) | (otherlv_2= Apostrophe ( (lv_values_3_0= RULE_WORD_PART ) )? otherlv_4= Apostrophe ) | (otherlv_5= QuotationMark ( (lv_values_6_0= RULE_WORD_PART ) )* otherlv_7= QuotationMark ) )
            	    {
            	    // InternalMyBashParser.g:3180:4: ( ( (lv_values_1_0= RULE_WORD_PART ) ) | (otherlv_2= Apostrophe ( (lv_values_3_0= RULE_WORD_PART ) )? otherlv_4= Apostrophe ) | (otherlv_5= QuotationMark ( (lv_values_6_0= RULE_WORD_PART ) )* otherlv_7= QuotationMark ) )
            	    int alt62=3;
            	    switch ( input.LA(1) ) {
            	    case RULE_WORD_PART:
            	        {
            	        alt62=1;
            	        }
            	        break;
            	    case Apostrophe:
            	        {
            	        alt62=2;
            	        }
            	        break;
            	    case QuotationMark:
            	        {
            	        alt62=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 62, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt62) {
            	        case 1 :
            	            // InternalMyBashParser.g:3181:5: ( (lv_values_1_0= RULE_WORD_PART ) )
            	            {
            	            // InternalMyBashParser.g:3181:5: ( (lv_values_1_0= RULE_WORD_PART ) )
            	            // InternalMyBashParser.g:3182:6: (lv_values_1_0= RULE_WORD_PART )
            	            {
            	            // InternalMyBashParser.g:3182:6: (lv_values_1_0= RULE_WORD_PART )
            	            // InternalMyBashParser.g:3183:7: lv_values_1_0= RULE_WORD_PART
            	            {
            	            lv_values_1_0=(Token)match(input,RULE_WORD_PART,FOLLOW_55); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_values_1_0, grammarAccess.getLiteralWordPartAccess().getValuesWORD_PARTTerminalRuleCall_1_0_0_0());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getLiteralWordPartRule());
            	              							}
            	              							addWithLastConsumed(
            	              								current,
            	              								"values",
            	              								lv_values_1_0,
            	              								"org.xtext.example.mydsl.MyBash.WORD_PART");
            	              						
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalMyBashParser.g:3200:5: (otherlv_2= Apostrophe ( (lv_values_3_0= RULE_WORD_PART ) )? otherlv_4= Apostrophe )
            	            {
            	            // InternalMyBashParser.g:3200:5: (otherlv_2= Apostrophe ( (lv_values_3_0= RULE_WORD_PART ) )? otherlv_4= Apostrophe )
            	            // InternalMyBashParser.g:3201:6: otherlv_2= Apostrophe ( (lv_values_3_0= RULE_WORD_PART ) )? otherlv_4= Apostrophe
            	            {
            	            otherlv_2=(Token)match(input,Apostrophe,FOLLOW_56); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              						newLeafNode(otherlv_2, grammarAccess.getLiteralWordPartAccess().getApostropheKeyword_1_0_1_0());
            	              					
            	            }
            	            // InternalMyBashParser.g:3205:6: ( (lv_values_3_0= RULE_WORD_PART ) )?
            	            int alt60=2;
            	            int LA60_0 = input.LA(1);

            	            if ( (LA60_0==RULE_WORD_PART) ) {
            	                alt60=1;
            	            }
            	            switch (alt60) {
            	                case 1 :
            	                    // InternalMyBashParser.g:3206:7: (lv_values_3_0= RULE_WORD_PART )
            	                    {
            	                    // InternalMyBashParser.g:3206:7: (lv_values_3_0= RULE_WORD_PART )
            	                    // InternalMyBashParser.g:3207:8: lv_values_3_0= RULE_WORD_PART
            	                    {
            	                    lv_values_3_0=(Token)match(input,RULE_WORD_PART,FOLLOW_57); if (state.failed) return current;
            	                    if ( state.backtracking==0 ) {

            	                      								newLeafNode(lv_values_3_0, grammarAccess.getLiteralWordPartAccess().getValuesWORD_PARTTerminalRuleCall_1_0_1_1_0());
            	                      							
            	                    }
            	                    if ( state.backtracking==0 ) {

            	                      								if (current==null) {
            	                      									current = createModelElement(grammarAccess.getLiteralWordPartRule());
            	                      								}
            	                      								addWithLastConsumed(
            	                      									current,
            	                      									"values",
            	                      									lv_values_3_0,
            	                      									"org.xtext.example.mydsl.MyBash.WORD_PART");
            	                      							
            	                    }

            	                    }


            	                    }
            	                    break;

            	            }

            	            otherlv_4=(Token)match(input,Apostrophe,FOLLOW_55); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              						newLeafNode(otherlv_4, grammarAccess.getLiteralWordPartAccess().getApostropheKeyword_1_0_1_2());
            	              					
            	            }

            	            }


            	            }
            	            break;
            	        case 3 :
            	            // InternalMyBashParser.g:3229:5: (otherlv_5= QuotationMark ( (lv_values_6_0= RULE_WORD_PART ) )* otherlv_7= QuotationMark )
            	            {
            	            // InternalMyBashParser.g:3229:5: (otherlv_5= QuotationMark ( (lv_values_6_0= RULE_WORD_PART ) )* otherlv_7= QuotationMark )
            	            // InternalMyBashParser.g:3230:6: otherlv_5= QuotationMark ( (lv_values_6_0= RULE_WORD_PART ) )* otherlv_7= QuotationMark
            	            {
            	            otherlv_5=(Token)match(input,QuotationMark,FOLLOW_58); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              						newLeafNode(otherlv_5, grammarAccess.getLiteralWordPartAccess().getQuotationMarkKeyword_1_0_2_0());
            	              					
            	            }
            	            // InternalMyBashParser.g:3234:6: ( (lv_values_6_0= RULE_WORD_PART ) )*
            	            loop61:
            	            do {
            	                int alt61=2;
            	                int LA61_0 = input.LA(1);

            	                if ( (LA61_0==RULE_WORD_PART) ) {
            	                    alt61=1;
            	                }


            	                switch (alt61) {
            	            	case 1 :
            	            	    // InternalMyBashParser.g:3235:7: (lv_values_6_0= RULE_WORD_PART )
            	            	    {
            	            	    // InternalMyBashParser.g:3235:7: (lv_values_6_0= RULE_WORD_PART )
            	            	    // InternalMyBashParser.g:3236:8: lv_values_6_0= RULE_WORD_PART
            	            	    {
            	            	    lv_values_6_0=(Token)match(input,RULE_WORD_PART,FOLLOW_58); if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	      								newLeafNode(lv_values_6_0, grammarAccess.getLiteralWordPartAccess().getValuesWORD_PARTTerminalRuleCall_1_0_2_1_0());
            	            	      							
            	            	    }
            	            	    if ( state.backtracking==0 ) {

            	            	      								if (current==null) {
            	            	      									current = createModelElement(grammarAccess.getLiteralWordPartRule());
            	            	      								}
            	            	      								addWithLastConsumed(
            	            	      									current,
            	            	      									"values",
            	            	      									lv_values_6_0,
            	            	      									"org.xtext.example.mydsl.MyBash.WORD_PART");
            	            	      							
            	            	    }

            	            	    }


            	            	    }
            	            	    break;

            	            	default :
            	            	    break loop61;
            	                }
            	            } while (true);

            	            otherlv_7=(Token)match(input,QuotationMark,FOLLOW_55); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              						newLeafNode(otherlv_7, grammarAccess.getLiteralWordPartAccess().getQuotationMarkKeyword_1_0_2_2());
            	              					
            	            }

            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt63 >= 1 ) break loop63;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(63, input);
                        throw eee;
                }
                cnt63++;
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralWordPart"


    // $ANTLR start "entryRuleCondOrAnd"
    // InternalMyBashParser.g:3263:1: entryRuleCondOrAnd returns [EObject current=null] : iv_ruleCondOrAnd= ruleCondOrAnd EOF ;
    public final EObject entryRuleCondOrAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondOrAnd = null;


        try {
            // InternalMyBashParser.g:3263:50: (iv_ruleCondOrAnd= ruleCondOrAnd EOF )
            // InternalMyBashParser.g:3264:2: iv_ruleCondOrAnd= ruleCondOrAnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCondOrAndRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCondOrAnd=ruleCondOrAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCondOrAnd; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCondOrAnd"


    // $ANTLR start "ruleCondOrAnd"
    // InternalMyBashParser.g:3270:1: ruleCondOrAnd returns [EObject current=null] : (this_CondExp_0= ruleCondExp ( () (otherlv_2= VerticalLineVerticalLine | otherlv_3= AmpersandAmpersand ) ( (lv_right_4_0= ruleCondExp ) ) )* ) ;
    public final EObject ruleCondOrAnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject this_CondExp_0 = null;

        EObject lv_right_4_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:3276:2: ( (this_CondExp_0= ruleCondExp ( () (otherlv_2= VerticalLineVerticalLine | otherlv_3= AmpersandAmpersand ) ( (lv_right_4_0= ruleCondExp ) ) )* ) )
            // InternalMyBashParser.g:3277:2: (this_CondExp_0= ruleCondExp ( () (otherlv_2= VerticalLineVerticalLine | otherlv_3= AmpersandAmpersand ) ( (lv_right_4_0= ruleCondExp ) ) )* )
            {
            // InternalMyBashParser.g:3277:2: (this_CondExp_0= ruleCondExp ( () (otherlv_2= VerticalLineVerticalLine | otherlv_3= AmpersandAmpersand ) ( (lv_right_4_0= ruleCondExp ) ) )* )
            // InternalMyBashParser.g:3278:3: this_CondExp_0= ruleCondExp ( () (otherlv_2= VerticalLineVerticalLine | otherlv_3= AmpersandAmpersand ) ( (lv_right_4_0= ruleCondExp ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getCondOrAndAccess().getCondExpParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_59);
            this_CondExp_0=ruleCondExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_CondExp_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMyBashParser.g:3286:3: ( () (otherlv_2= VerticalLineVerticalLine | otherlv_3= AmpersandAmpersand ) ( (lv_right_4_0= ruleCondExp ) ) )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==AmpersandAmpersand||LA65_0==VerticalLineVerticalLine) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // InternalMyBashParser.g:3287:4: () (otherlv_2= VerticalLineVerticalLine | otherlv_3= AmpersandAmpersand ) ( (lv_right_4_0= ruleCondExp ) )
            	    {
            	    // InternalMyBashParser.g:3287:4: ()
            	    // InternalMyBashParser.g:3288:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getCondOrAndAccess().getCondUnaryExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalMyBashParser.g:3294:4: (otherlv_2= VerticalLineVerticalLine | otherlv_3= AmpersandAmpersand )
            	    int alt64=2;
            	    int LA64_0 = input.LA(1);

            	    if ( (LA64_0==VerticalLineVerticalLine) ) {
            	        alt64=1;
            	    }
            	    else if ( (LA64_0==AmpersandAmpersand) ) {
            	        alt64=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 64, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt64) {
            	        case 1 :
            	            // InternalMyBashParser.g:3295:5: otherlv_2= VerticalLineVerticalLine
            	            {
            	            otherlv_2=(Token)match(input,VerticalLineVerticalLine,FOLLOW_17); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              					newLeafNode(otherlv_2, grammarAccess.getCondOrAndAccess().getVerticalLineVerticalLineKeyword_1_1_0());
            	              				
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalMyBashParser.g:3300:5: otherlv_3= AmpersandAmpersand
            	            {
            	            otherlv_3=(Token)match(input,AmpersandAmpersand,FOLLOW_17); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              					newLeafNode(otherlv_3, grammarAccess.getCondOrAndAccess().getAmpersandAmpersandKeyword_1_1_1());
            	              				
            	            }

            	            }
            	            break;

            	    }

            	    // InternalMyBashParser.g:3305:4: ( (lv_right_4_0= ruleCondExp ) )
            	    // InternalMyBashParser.g:3306:5: (lv_right_4_0= ruleCondExp )
            	    {
            	    // InternalMyBashParser.g:3306:5: (lv_right_4_0= ruleCondExp )
            	    // InternalMyBashParser.g:3307:6: lv_right_4_0= ruleCondExp
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getCondOrAndAccess().getRightCondExpParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_59);
            	    lv_right_4_0=ruleCondExp();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getCondOrAndRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_4_0,
            	      							"org.xtext.example.mydsl.MyBash.CondExp");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop65;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCondOrAnd"


    // $ANTLR start "entryRuleCondExp"
    // InternalMyBashParser.g:3329:1: entryRuleCondExp returns [EObject current=null] : iv_ruleCondExp= ruleCondExp EOF ;
    public final EObject entryRuleCondExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondExp = null;


        try {
            // InternalMyBashParser.g:3329:48: (iv_ruleCondExp= ruleCondExp EOF )
            // InternalMyBashParser.g:3330:2: iv_ruleCondExp= ruleCondExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCondExpRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCondExp=ruleCondExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCondExp; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCondExp"


    // $ANTLR start "ruleCondExp"
    // InternalMyBashParser.g:3336:1: ruleCondExp returns [EObject current=null] : ( ( () ( (lv_op_1_0= RULE_C_S_OP ) ) ( (lv_operand_2_0= ruleWord ) ) ) | (this_CondConst_3= ruleCondConst ( () ( ( ( (lv_op_5_0= RULE_C_B_OP ) ) ( (lv_right_6_0= ruleWord ) ) ) | ( ( (lv_op_7_0= EqualsSignTilde ) ) ( (lv_right_8_0= ruleRegularExpression ) ) ) ) )? ) | (otherlv_9= LeftParenthesis this_CondOrAnd_10= ruleCondOrAnd otherlv_11= RightParenthesis ) ) ;
    public final EObject ruleCondExp() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_0=null;
        Token lv_op_5_0=null;
        Token lv_op_7_0=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_operand_2_0 = null;

        EObject this_CondConst_3 = null;

        EObject lv_right_6_0 = null;

        EObject lv_right_8_0 = null;

        EObject this_CondOrAnd_10 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:3342:2: ( ( ( () ( (lv_op_1_0= RULE_C_S_OP ) ) ( (lv_operand_2_0= ruleWord ) ) ) | (this_CondConst_3= ruleCondConst ( () ( ( ( (lv_op_5_0= RULE_C_B_OP ) ) ( (lv_right_6_0= ruleWord ) ) ) | ( ( (lv_op_7_0= EqualsSignTilde ) ) ( (lv_right_8_0= ruleRegularExpression ) ) ) ) )? ) | (otherlv_9= LeftParenthesis this_CondOrAnd_10= ruleCondOrAnd otherlv_11= RightParenthesis ) ) )
            // InternalMyBashParser.g:3343:2: ( ( () ( (lv_op_1_0= RULE_C_S_OP ) ) ( (lv_operand_2_0= ruleWord ) ) ) | (this_CondConst_3= ruleCondConst ( () ( ( ( (lv_op_5_0= RULE_C_B_OP ) ) ( (lv_right_6_0= ruleWord ) ) ) | ( ( (lv_op_7_0= EqualsSignTilde ) ) ( (lv_right_8_0= ruleRegularExpression ) ) ) ) )? ) | (otherlv_9= LeftParenthesis this_CondOrAnd_10= ruleCondOrAnd otherlv_11= RightParenthesis ) )
            {
            // InternalMyBashParser.g:3343:2: ( ( () ( (lv_op_1_0= RULE_C_S_OP ) ) ( (lv_operand_2_0= ruleWord ) ) ) | (this_CondConst_3= ruleCondConst ( () ( ( ( (lv_op_5_0= RULE_C_B_OP ) ) ( (lv_right_6_0= ruleWord ) ) ) | ( ( (lv_op_7_0= EqualsSignTilde ) ) ( (lv_right_8_0= ruleRegularExpression ) ) ) ) )? ) | (otherlv_9= LeftParenthesis this_CondOrAnd_10= ruleCondOrAnd otherlv_11= RightParenthesis ) )
            int alt68=3;
            switch ( input.LA(1) ) {
            case RULE_C_S_OP:
                {
                alt68=1;
                }
                break;
            case DollarSignLeftParenthesisLeftParenthesis:
            case DollarSignLeftCurlyBracket:
            case LessThanSignLeftParenthesis:
            case GreaterThanSignLeftParenthesis:
            case QuotationMark:
            case Apostrophe:
            case RULE_S_WORD_PART:
            case RULE_WORD_PART:
            case RULE_VARIABLE:
            case RULE_CS_START:
                {
                alt68=2;
                }
                break;
            case LeftParenthesis:
                {
                alt68=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }

            switch (alt68) {
                case 1 :
                    // InternalMyBashParser.g:3344:3: ( () ( (lv_op_1_0= RULE_C_S_OP ) ) ( (lv_operand_2_0= ruleWord ) ) )
                    {
                    // InternalMyBashParser.g:3344:3: ( () ( (lv_op_1_0= RULE_C_S_OP ) ) ( (lv_operand_2_0= ruleWord ) ) )
                    // InternalMyBashParser.g:3345:4: () ( (lv_op_1_0= RULE_C_S_OP ) ) ( (lv_operand_2_0= ruleWord ) )
                    {
                    // InternalMyBashParser.g:3345:4: ()
                    // InternalMyBashParser.g:3346:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getCondExpAccess().getCondUnaryExpressionAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalMyBashParser.g:3352:4: ( (lv_op_1_0= RULE_C_S_OP ) )
                    // InternalMyBashParser.g:3353:5: (lv_op_1_0= RULE_C_S_OP )
                    {
                    // InternalMyBashParser.g:3353:5: (lv_op_1_0= RULE_C_S_OP )
                    // InternalMyBashParser.g:3354:6: lv_op_1_0= RULE_C_S_OP
                    {
                    lv_op_1_0=(Token)match(input,RULE_C_S_OP,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_1_0, grammarAccess.getCondExpAccess().getOpC_S_OPTerminalRuleCall_0_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getCondExpRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"op",
                      							lv_op_1_0,
                      							"org.xtext.example.mydsl.MyBash.C_S_OP");
                      					
                    }

                    }


                    }

                    // InternalMyBashParser.g:3370:4: ( (lv_operand_2_0= ruleWord ) )
                    // InternalMyBashParser.g:3371:5: (lv_operand_2_0= ruleWord )
                    {
                    // InternalMyBashParser.g:3371:5: (lv_operand_2_0= ruleWord )
                    // InternalMyBashParser.g:3372:6: lv_operand_2_0= ruleWord
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCondExpAccess().getOperandWordParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_0=ruleWord();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getCondExpRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_0,
                      							"org.xtext.example.mydsl.MyBash.Word");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMyBashParser.g:3391:3: (this_CondConst_3= ruleCondConst ( () ( ( ( (lv_op_5_0= RULE_C_B_OP ) ) ( (lv_right_6_0= ruleWord ) ) ) | ( ( (lv_op_7_0= EqualsSignTilde ) ) ( (lv_right_8_0= ruleRegularExpression ) ) ) ) )? )
                    {
                    // InternalMyBashParser.g:3391:3: (this_CondConst_3= ruleCondConst ( () ( ( ( (lv_op_5_0= RULE_C_B_OP ) ) ( (lv_right_6_0= ruleWord ) ) ) | ( ( (lv_op_7_0= EqualsSignTilde ) ) ( (lv_right_8_0= ruleRegularExpression ) ) ) ) )? )
                    // InternalMyBashParser.g:3392:4: this_CondConst_3= ruleCondConst ( () ( ( ( (lv_op_5_0= RULE_C_B_OP ) ) ( (lv_right_6_0= ruleWord ) ) ) | ( ( (lv_op_7_0= EqualsSignTilde ) ) ( (lv_right_8_0= ruleRegularExpression ) ) ) ) )?
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getCondExpAccess().getCondConstParserRuleCall_1_0());
                      			
                    }
                    pushFollow(FOLLOW_60);
                    this_CondConst_3=ruleCondConst();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_CondConst_3;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalMyBashParser.g:3400:4: ( () ( ( ( (lv_op_5_0= RULE_C_B_OP ) ) ( (lv_right_6_0= ruleWord ) ) ) | ( ( (lv_op_7_0= EqualsSignTilde ) ) ( (lv_right_8_0= ruleRegularExpression ) ) ) ) )?
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( (LA67_0==EqualsSignTilde||LA67_0==RULE_C_B_OP) ) {
                        alt67=1;
                    }
                    switch (alt67) {
                        case 1 :
                            // InternalMyBashParser.g:3401:5: () ( ( ( (lv_op_5_0= RULE_C_B_OP ) ) ( (lv_right_6_0= ruleWord ) ) ) | ( ( (lv_op_7_0= EqualsSignTilde ) ) ( (lv_right_8_0= ruleRegularExpression ) ) ) )
                            {
                            // InternalMyBashParser.g:3401:5: ()
                            // InternalMyBashParser.g:3402:6: 
                            {
                            if ( state.backtracking==0 ) {

                              						current = forceCreateModelElementAndSet(
                              							grammarAccess.getCondExpAccess().getCondBinaryExpressionLeftAction_1_1_0(),
                              							current);
                              					
                            }

                            }

                            // InternalMyBashParser.g:3408:5: ( ( ( (lv_op_5_0= RULE_C_B_OP ) ) ( (lv_right_6_0= ruleWord ) ) ) | ( ( (lv_op_7_0= EqualsSignTilde ) ) ( (lv_right_8_0= ruleRegularExpression ) ) ) )
                            int alt66=2;
                            int LA66_0 = input.LA(1);

                            if ( (LA66_0==RULE_C_B_OP) ) {
                                alt66=1;
                            }
                            else if ( (LA66_0==EqualsSignTilde) ) {
                                alt66=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 66, 0, input);

                                throw nvae;
                            }
                            switch (alt66) {
                                case 1 :
                                    // InternalMyBashParser.g:3409:6: ( ( (lv_op_5_0= RULE_C_B_OP ) ) ( (lv_right_6_0= ruleWord ) ) )
                                    {
                                    // InternalMyBashParser.g:3409:6: ( ( (lv_op_5_0= RULE_C_B_OP ) ) ( (lv_right_6_0= ruleWord ) ) )
                                    // InternalMyBashParser.g:3410:7: ( (lv_op_5_0= RULE_C_B_OP ) ) ( (lv_right_6_0= ruleWord ) )
                                    {
                                    // InternalMyBashParser.g:3410:7: ( (lv_op_5_0= RULE_C_B_OP ) )
                                    // InternalMyBashParser.g:3411:8: (lv_op_5_0= RULE_C_B_OP )
                                    {
                                    // InternalMyBashParser.g:3411:8: (lv_op_5_0= RULE_C_B_OP )
                                    // InternalMyBashParser.g:3412:9: lv_op_5_0= RULE_C_B_OP
                                    {
                                    lv_op_5_0=(Token)match(input,RULE_C_B_OP,FOLLOW_21); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      									newLeafNode(lv_op_5_0, grammarAccess.getCondExpAccess().getOpC_B_OPTerminalRuleCall_1_1_1_0_0_0());
                                      								
                                    }
                                    if ( state.backtracking==0 ) {

                                      									if (current==null) {
                                      										current = createModelElement(grammarAccess.getCondExpRule());
                                      									}
                                      									setWithLastConsumed(
                                      										current,
                                      										"op",
                                      										lv_op_5_0,
                                      										"org.xtext.example.mydsl.MyBash.C_B_OP");
                                      								
                                    }

                                    }


                                    }

                                    // InternalMyBashParser.g:3428:7: ( (lv_right_6_0= ruleWord ) )
                                    // InternalMyBashParser.g:3429:8: (lv_right_6_0= ruleWord )
                                    {
                                    // InternalMyBashParser.g:3429:8: (lv_right_6_0= ruleWord )
                                    // InternalMyBashParser.g:3430:9: lv_right_6_0= ruleWord
                                    {
                                    if ( state.backtracking==0 ) {

                                      									newCompositeNode(grammarAccess.getCondExpAccess().getRightWordParserRuleCall_1_1_1_0_1_0());
                                      								
                                    }
                                    pushFollow(FOLLOW_2);
                                    lv_right_6_0=ruleWord();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      									if (current==null) {
                                      										current = createModelElementForParent(grammarAccess.getCondExpRule());
                                      									}
                                      									set(
                                      										current,
                                      										"right",
                                      										lv_right_6_0,
                                      										"org.xtext.example.mydsl.MyBash.Word");
                                      									afterParserOrEnumRuleCall();
                                      								
                                    }

                                    }


                                    }


                                    }


                                    }
                                    break;
                                case 2 :
                                    // InternalMyBashParser.g:3449:6: ( ( (lv_op_7_0= EqualsSignTilde ) ) ( (lv_right_8_0= ruleRegularExpression ) ) )
                                    {
                                    // InternalMyBashParser.g:3449:6: ( ( (lv_op_7_0= EqualsSignTilde ) ) ( (lv_right_8_0= ruleRegularExpression ) ) )
                                    // InternalMyBashParser.g:3450:7: ( (lv_op_7_0= EqualsSignTilde ) ) ( (lv_right_8_0= ruleRegularExpression ) )
                                    {
                                    // InternalMyBashParser.g:3450:7: ( (lv_op_7_0= EqualsSignTilde ) )
                                    // InternalMyBashParser.g:3451:8: (lv_op_7_0= EqualsSignTilde )
                                    {
                                    // InternalMyBashParser.g:3451:8: (lv_op_7_0= EqualsSignTilde )
                                    // InternalMyBashParser.g:3452:9: lv_op_7_0= EqualsSignTilde
                                    {
                                    lv_op_7_0=(Token)match(input,EqualsSignTilde,FOLLOW_29); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      									newLeafNode(lv_op_7_0, grammarAccess.getCondExpAccess().getOpEqualsSignTildeKeyword_1_1_1_1_0_0());
                                      								
                                    }
                                    if ( state.backtracking==0 ) {

                                      									if (current==null) {
                                      										current = createModelElement(grammarAccess.getCondExpRule());
                                      									}
                                      									setWithLastConsumed(current, "op", lv_op_7_0, "=~");
                                      								
                                    }

                                    }


                                    }

                                    // InternalMyBashParser.g:3464:7: ( (lv_right_8_0= ruleRegularExpression ) )
                                    // InternalMyBashParser.g:3465:8: (lv_right_8_0= ruleRegularExpression )
                                    {
                                    // InternalMyBashParser.g:3465:8: (lv_right_8_0= ruleRegularExpression )
                                    // InternalMyBashParser.g:3466:9: lv_right_8_0= ruleRegularExpression
                                    {
                                    if ( state.backtracking==0 ) {

                                      									newCompositeNode(grammarAccess.getCondExpAccess().getRightRegularExpressionParserRuleCall_1_1_1_1_1_0());
                                      								
                                    }
                                    pushFollow(FOLLOW_2);
                                    lv_right_8_0=ruleRegularExpression();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      									if (current==null) {
                                      										current = createModelElementForParent(grammarAccess.getCondExpRule());
                                      									}
                                      									set(
                                      										current,
                                      										"right",
                                      										lv_right_8_0,
                                      										"org.xtext.example.mydsl.MyBash.RegularExpression");
                                      									afterParserOrEnumRuleCall();
                                      								
                                    }

                                    }


                                    }


                                    }


                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalMyBashParser.g:3488:3: (otherlv_9= LeftParenthesis this_CondOrAnd_10= ruleCondOrAnd otherlv_11= RightParenthesis )
                    {
                    // InternalMyBashParser.g:3488:3: (otherlv_9= LeftParenthesis this_CondOrAnd_10= ruleCondOrAnd otherlv_11= RightParenthesis )
                    // InternalMyBashParser.g:3489:4: otherlv_9= LeftParenthesis this_CondOrAnd_10= ruleCondOrAnd otherlv_11= RightParenthesis
                    {
                    otherlv_9=(Token)match(input,LeftParenthesis,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getCondExpAccess().getLeftParenthesisKeyword_2_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getCondExpAccess().getCondOrAndParserRuleCall_2_1());
                      			
                    }
                    pushFollow(FOLLOW_13);
                    this_CondOrAnd_10=ruleCondOrAnd();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_CondOrAnd_10;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_11=(Token)match(input,RightParenthesis,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getCondExpAccess().getRightParenthesisKeyword_2_2());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCondExp"


    // $ANTLR start "entryRuleCondConst"
    // InternalMyBashParser.g:3510:1: entryRuleCondConst returns [EObject current=null] : iv_ruleCondConst= ruleCondConst EOF ;
    public final EObject entryRuleCondConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondConst = null;


        try {
            // InternalMyBashParser.g:3510:50: (iv_ruleCondConst= ruleCondConst EOF )
            // InternalMyBashParser.g:3511:2: iv_ruleCondConst= ruleCondConst EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCondConstRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCondConst=ruleCondConst();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCondConst; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCondConst"


    // $ANTLR start "ruleCondConst"
    // InternalMyBashParser.g:3517:1: ruleCondConst returns [EObject current=null] : ( (lv_value_0_0= ruleWord ) ) ;
    public final EObject ruleCondConst() throws RecognitionException {
        EObject current = null;

        EObject lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:3523:2: ( ( (lv_value_0_0= ruleWord ) ) )
            // InternalMyBashParser.g:3524:2: ( (lv_value_0_0= ruleWord ) )
            {
            // InternalMyBashParser.g:3524:2: ( (lv_value_0_0= ruleWord ) )
            // InternalMyBashParser.g:3525:3: (lv_value_0_0= ruleWord )
            {
            // InternalMyBashParser.g:3525:3: (lv_value_0_0= ruleWord )
            // InternalMyBashParser.g:3526:4: lv_value_0_0= ruleWord
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getCondConstAccess().getValueWordParserRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleWord();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getCondConstRule());
              				}
              				set(
              					current,
              					"value",
              					lv_value_0_0,
              					"org.xtext.example.mydsl.MyBash.Word");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCondConst"


    // $ANTLR start "entryRuleRegularExpression"
    // InternalMyBashParser.g:3546:1: entryRuleRegularExpression returns [EObject current=null] : iv_ruleRegularExpression= ruleRegularExpression EOF ;
    public final EObject entryRuleRegularExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegularExpression = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_C_LINE");

        try {
            // InternalMyBashParser.g:3548:2: (iv_ruleRegularExpression= ruleRegularExpression EOF )
            // InternalMyBashParser.g:3549:2: iv_ruleRegularExpression= ruleRegularExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRegularExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRegularExpression=ruleRegularExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRegularExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleRegularExpression"


    // $ANTLR start "ruleRegularExpression"
    // InternalMyBashParser.g:3558:1: ruleRegularExpression returns [EObject current=null] : (this_RegularElements_0= ruleRegularElements ( () ( (lv_op_2_0= VerticalLine ) ) ( (lv_right_3_0= ruleRegularElements ) ) )* ) ;
    public final EObject ruleRegularExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_RegularElements_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_C_LINE");

        try {
            // InternalMyBashParser.g:3565:2: ( (this_RegularElements_0= ruleRegularElements ( () ( (lv_op_2_0= VerticalLine ) ) ( (lv_right_3_0= ruleRegularElements ) ) )* ) )
            // InternalMyBashParser.g:3566:2: (this_RegularElements_0= ruleRegularElements ( () ( (lv_op_2_0= VerticalLine ) ) ( (lv_right_3_0= ruleRegularElements ) ) )* )
            {
            // InternalMyBashParser.g:3566:2: (this_RegularElements_0= ruleRegularElements ( () ( (lv_op_2_0= VerticalLine ) ) ( (lv_right_3_0= ruleRegularElements ) ) )* )
            // InternalMyBashParser.g:3567:3: this_RegularElements_0= ruleRegularElements ( () ( (lv_op_2_0= VerticalLine ) ) ( (lv_right_3_0= ruleRegularElements ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRegularExpressionAccess().getRegularElementsParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_31);
            this_RegularElements_0=ruleRegularElements();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_RegularElements_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMyBashParser.g:3575:3: ( () ( (lv_op_2_0= VerticalLine ) ) ( (lv_right_3_0= ruleRegularElements ) ) )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==VerticalLine) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // InternalMyBashParser.g:3576:4: () ( (lv_op_2_0= VerticalLine ) ) ( (lv_right_3_0= ruleRegularElements ) )
            	    {
            	    // InternalMyBashParser.g:3576:4: ()
            	    // InternalMyBashParser.g:3577:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getRegularExpressionAccess().getRegularExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalMyBashParser.g:3583:4: ( (lv_op_2_0= VerticalLine ) )
            	    // InternalMyBashParser.g:3584:5: (lv_op_2_0= VerticalLine )
            	    {
            	    // InternalMyBashParser.g:3584:5: (lv_op_2_0= VerticalLine )
            	    // InternalMyBashParser.g:3585:6: lv_op_2_0= VerticalLine
            	    {
            	    lv_op_2_0=(Token)match(input,VerticalLine,FOLLOW_29); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(lv_op_2_0, grammarAccess.getRegularExpressionAccess().getOpVerticalLineKeyword_1_1_0());
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getRegularExpressionRule());
            	      						}
            	      						setWithLastConsumed(current, "op", lv_op_2_0, "|");
            	      					
            	    }

            	    }


            	    }

            	    // InternalMyBashParser.g:3597:4: ( (lv_right_3_0= ruleRegularElements ) )
            	    // InternalMyBashParser.g:3598:5: (lv_right_3_0= ruleRegularElements )
            	    {
            	    // InternalMyBashParser.g:3598:5: (lv_right_3_0= ruleRegularElements )
            	    // InternalMyBashParser.g:3599:6: lv_right_3_0= ruleRegularElements
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getRegularExpressionAccess().getRightRegularElementsParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_31);
            	    lv_right_3_0=ruleRegularElements();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getRegularExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.xtext.example.mydsl.MyBash.RegularElements");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop69;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleRegularExpression"


    // $ANTLR start "entryRuleRegularElements"
    // InternalMyBashParser.g:3624:1: entryRuleRegularElements returns [EObject current=null] : iv_ruleRegularElements= ruleRegularElements EOF ;
    public final EObject entryRuleRegularElements() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegularElements = null;


        try {
            // InternalMyBashParser.g:3624:56: (iv_ruleRegularElements= ruleRegularElements EOF )
            // InternalMyBashParser.g:3625:2: iv_ruleRegularElements= ruleRegularElements EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRegularElementsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRegularElements=ruleRegularElements();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRegularElements; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRegularElements"


    // $ANTLR start "ruleRegularElements"
    // InternalMyBashParser.g:3631:1: ruleRegularElements returns [EObject current=null] : ( () ( (otherlv_1= LeftParenthesis ( (lv_parts_2_0= ruleWord ) )? otherlv_3= RightParenthesis ) | ( (lv_parts_4_0= ruleWord ) ) )+ ) ;
    public final EObject ruleRegularElements() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_parts_2_0 = null;

        EObject lv_parts_4_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:3637:2: ( ( () ( (otherlv_1= LeftParenthesis ( (lv_parts_2_0= ruleWord ) )? otherlv_3= RightParenthesis ) | ( (lv_parts_4_0= ruleWord ) ) )+ ) )
            // InternalMyBashParser.g:3638:2: ( () ( (otherlv_1= LeftParenthesis ( (lv_parts_2_0= ruleWord ) )? otherlv_3= RightParenthesis ) | ( (lv_parts_4_0= ruleWord ) ) )+ )
            {
            // InternalMyBashParser.g:3638:2: ( () ( (otherlv_1= LeftParenthesis ( (lv_parts_2_0= ruleWord ) )? otherlv_3= RightParenthesis ) | ( (lv_parts_4_0= ruleWord ) ) )+ )
            // InternalMyBashParser.g:3639:3: () ( (otherlv_1= LeftParenthesis ( (lv_parts_2_0= ruleWord ) )? otherlv_3= RightParenthesis ) | ( (lv_parts_4_0= ruleWord ) ) )+
            {
            // InternalMyBashParser.g:3639:3: ()
            // InternalMyBashParser.g:3640:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRegularElementsAccess().getRegularConstAction_0(),
              					current);
              			
            }

            }

            // InternalMyBashParser.g:3646:3: ( (otherlv_1= LeftParenthesis ( (lv_parts_2_0= ruleWord ) )? otherlv_3= RightParenthesis ) | ( (lv_parts_4_0= ruleWord ) ) )+
            int cnt71=0;
            loop71:
            do {
                int alt71=3;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==LeftParenthesis) ) {
                    alt71=1;
                }
                else if ( (LA71_0==DollarSignLeftParenthesisLeftParenthesis||LA71_0==DollarSignLeftCurlyBracket||LA71_0==LessThanSignLeftParenthesis||LA71_0==GreaterThanSignLeftParenthesis||LA71_0==QuotationMark||LA71_0==Apostrophe||(LA71_0>=RULE_S_WORD_PART && LA71_0<=RULE_WORD_PART)||LA71_0==RULE_VARIABLE||LA71_0==RULE_CS_START) ) {
                    alt71=2;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalMyBashParser.g:3647:4: (otherlv_1= LeftParenthesis ( (lv_parts_2_0= ruleWord ) )? otherlv_3= RightParenthesis )
            	    {
            	    // InternalMyBashParser.g:3647:4: (otherlv_1= LeftParenthesis ( (lv_parts_2_0= ruleWord ) )? otherlv_3= RightParenthesis )
            	    // InternalMyBashParser.g:3648:5: otherlv_1= LeftParenthesis ( (lv_parts_2_0= ruleWord ) )? otherlv_3= RightParenthesis
            	    {
            	    otherlv_1=(Token)match(input,LeftParenthesis,FOLLOW_61); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_1, grammarAccess.getRegularElementsAccess().getLeftParenthesisKeyword_1_0_0());
            	      				
            	    }
            	    // InternalMyBashParser.g:3652:5: ( (lv_parts_2_0= ruleWord ) )?
            	    int alt70=2;
            	    int LA70_0 = input.LA(1);

            	    if ( (LA70_0==DollarSignLeftParenthesisLeftParenthesis||LA70_0==DollarSignLeftCurlyBracket||LA70_0==LessThanSignLeftParenthesis||LA70_0==GreaterThanSignLeftParenthesis||LA70_0==QuotationMark||LA70_0==Apostrophe||(LA70_0>=RULE_S_WORD_PART && LA70_0<=RULE_WORD_PART)||LA70_0==RULE_VARIABLE||LA70_0==RULE_CS_START) ) {
            	        alt70=1;
            	    }
            	    switch (alt70) {
            	        case 1 :
            	            // InternalMyBashParser.g:3653:6: (lv_parts_2_0= ruleWord )
            	            {
            	            // InternalMyBashParser.g:3653:6: (lv_parts_2_0= ruleWord )
            	            // InternalMyBashParser.g:3654:7: lv_parts_2_0= ruleWord
            	            {
            	            if ( state.backtracking==0 ) {

            	              							newCompositeNode(grammarAccess.getRegularElementsAccess().getPartsWordParserRuleCall_1_0_1_0());
            	              						
            	            }
            	            pushFollow(FOLLOW_13);
            	            lv_parts_2_0=ruleWord();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElementForParent(grammarAccess.getRegularElementsRule());
            	              							}
            	              							add(
            	              								current,
            	              								"parts",
            	              								lv_parts_2_0,
            	              								"org.xtext.example.mydsl.MyBash.Word");
            	              							afterParserOrEnumRuleCall();
            	              						
            	            }

            	            }


            	            }
            	            break;

            	    }

            	    otherlv_3=(Token)match(input,RightParenthesis,FOLLOW_50); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_3, grammarAccess.getRegularElementsAccess().getRightParenthesisKeyword_1_0_2());
            	      				
            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalMyBashParser.g:3677:4: ( (lv_parts_4_0= ruleWord ) )
            	    {
            	    // InternalMyBashParser.g:3677:4: ( (lv_parts_4_0= ruleWord ) )
            	    // InternalMyBashParser.g:3678:5: (lv_parts_4_0= ruleWord )
            	    {
            	    // InternalMyBashParser.g:3678:5: (lv_parts_4_0= ruleWord )
            	    // InternalMyBashParser.g:3679:6: lv_parts_4_0= ruleWord
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getRegularElementsAccess().getPartsWordParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_50);
            	    lv_parts_4_0=ruleWord();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getRegularElementsRule());
            	      						}
            	      						add(
            	      							current,
            	      							"parts",
            	      							lv_parts_4_0,
            	      							"org.xtext.example.mydsl.MyBash.Word");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt71 >= 1 ) break loop71;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(71, input);
                        throw eee;
                }
                cnt71++;
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegularElements"


    // $ANTLR start "entryRuleArithmeticExpansion"
    // InternalMyBashParser.g:3701:1: entryRuleArithmeticExpansion returns [EObject current=null] : iv_ruleArithmeticExpansion= ruleArithmeticExpansion EOF ;
    public final EObject entryRuleArithmeticExpansion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArithmeticExpansion = null;


        try {
            // InternalMyBashParser.g:3701:60: (iv_ruleArithmeticExpansion= ruleArithmeticExpansion EOF )
            // InternalMyBashParser.g:3702:2: iv_ruleArithmeticExpansion= ruleArithmeticExpansion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArithmeticExpansionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleArithmeticExpansion=ruleArithmeticExpansion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArithmeticExpansion; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArithmeticExpansion"


    // $ANTLR start "ruleArithmeticExpansion"
    // InternalMyBashParser.g:3708:1: ruleArithmeticExpansion returns [EObject current=null] : (this_ArithmeticExpansionStart_0= ruleArithmeticExpansionStart ruleArithmeticExpansionEnd ) ;
    public final EObject ruleArithmeticExpansion() throws RecognitionException {
        EObject current = null;

        EObject this_ArithmeticExpansionStart_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:3714:2: ( (this_ArithmeticExpansionStart_0= ruleArithmeticExpansionStart ruleArithmeticExpansionEnd ) )
            // InternalMyBashParser.g:3715:2: (this_ArithmeticExpansionStart_0= ruleArithmeticExpansionStart ruleArithmeticExpansionEnd )
            {
            // InternalMyBashParser.g:3715:2: (this_ArithmeticExpansionStart_0= ruleArithmeticExpansionStart ruleArithmeticExpansionEnd )
            // InternalMyBashParser.g:3716:3: this_ArithmeticExpansionStart_0= ruleArithmeticExpansionStart ruleArithmeticExpansionEnd
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getArithmeticExpansionAccess().getArithmeticExpansionStartParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_20);
            this_ArithmeticExpansionStart_0=ruleArithmeticExpansionStart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ArithmeticExpansionStart_0;
              			afterParserOrEnumRuleCall();
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getArithmeticExpansionAccess().getArithmeticExpansionEndParserRuleCall_1());
              		
            }
            pushFollow(FOLLOW_2);
            ruleArithmeticExpansionEnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArithmeticExpansion"


    // $ANTLR start "entryRuleIndexEvaluation"
    // InternalMyBashParser.g:3735:1: entryRuleIndexEvaluation returns [EObject current=null] : iv_ruleIndexEvaluation= ruleIndexEvaluation EOF ;
    public final EObject entryRuleIndexEvaluation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndexEvaluation = null;


        try {
            // InternalMyBashParser.g:3735:56: (iv_ruleIndexEvaluation= ruleIndexEvaluation EOF )
            // InternalMyBashParser.g:3736:2: iv_ruleIndexEvaluation= ruleIndexEvaluation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIndexEvaluationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIndexEvaluation=ruleIndexEvaluation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIndexEvaluation; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIndexEvaluation"


    // $ANTLR start "ruleIndexEvaluation"
    // InternalMyBashParser.g:3742:1: ruleIndexEvaluation returns [EObject current=null] : (this_IndexEvaluationStart_0= ruleIndexEvaluationStart ( (lv_end_1_0= ruleIndexEvaluationEnd ) ) ) ;
    public final EObject ruleIndexEvaluation() throws RecognitionException {
        EObject current = null;

        EObject this_IndexEvaluationStart_0 = null;

        AntlrDatatypeRuleToken lv_end_1_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:3748:2: ( (this_IndexEvaluationStart_0= ruleIndexEvaluationStart ( (lv_end_1_0= ruleIndexEvaluationEnd ) ) ) )
            // InternalMyBashParser.g:3749:2: (this_IndexEvaluationStart_0= ruleIndexEvaluationStart ( (lv_end_1_0= ruleIndexEvaluationEnd ) ) )
            {
            // InternalMyBashParser.g:3749:2: (this_IndexEvaluationStart_0= ruleIndexEvaluationStart ( (lv_end_1_0= ruleIndexEvaluationEnd ) ) )
            // InternalMyBashParser.g:3750:3: this_IndexEvaluationStart_0= ruleIndexEvaluationStart ( (lv_end_1_0= ruleIndexEvaluationEnd ) )
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getIndexEvaluationAccess().getIndexEvaluationStartParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_62);
            this_IndexEvaluationStart_0=ruleIndexEvaluationStart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_IndexEvaluationStart_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMyBashParser.g:3758:3: ( (lv_end_1_0= ruleIndexEvaluationEnd ) )
            // InternalMyBashParser.g:3759:4: (lv_end_1_0= ruleIndexEvaluationEnd )
            {
            // InternalMyBashParser.g:3759:4: (lv_end_1_0= ruleIndexEvaluationEnd )
            // InternalMyBashParser.g:3760:5: lv_end_1_0= ruleIndexEvaluationEnd
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIndexEvaluationAccess().getEndIndexEvaluationEndParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_end_1_0=ruleIndexEvaluationEnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIndexEvaluationRule());
              					}
              					set(
              						current,
              						"end",
              						lv_end_1_0,
              						"org.xtext.example.mydsl.MyBash.IndexEvaluationEnd");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIndexEvaluation"


    // $ANTLR start "entryRuleIndexEvaluationStart"
    // InternalMyBashParser.g:3781:1: entryRuleIndexEvaluationStart returns [EObject current=null] : iv_ruleIndexEvaluationStart= ruleIndexEvaluationStart EOF ;
    public final EObject entryRuleIndexEvaluationStart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndexEvaluationStart = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_SL_COMMENT", "RULE_C_LINE", "RULE_WS", "RULE_HIDEN_NEW_LINE");

        try {
            // InternalMyBashParser.g:3783:2: (iv_ruleIndexEvaluationStart= ruleIndexEvaluationStart EOF )
            // InternalMyBashParser.g:3784:2: iv_ruleIndexEvaluationStart= ruleIndexEvaluationStart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIndexEvaluationStartRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIndexEvaluationStart=ruleIndexEvaluationStart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIndexEvaluationStart; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleIndexEvaluationStart"


    // $ANTLR start "ruleIndexEvaluationStart"
    // InternalMyBashParser.g:3793:1: ruleIndexEvaluationStart returns [EObject current=null] : (otherlv_0= LeftSquareBracket ( (lv_expression_1_0= ruleEvaluation ) ) ) ;
    public final EObject ruleIndexEvaluationStart() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_expression_1_0 = null;



        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_SL_COMMENT", "RULE_C_LINE", "RULE_WS", "RULE_HIDEN_NEW_LINE");

        try {
            // InternalMyBashParser.g:3800:2: ( (otherlv_0= LeftSquareBracket ( (lv_expression_1_0= ruleEvaluation ) ) ) )
            // InternalMyBashParser.g:3801:2: (otherlv_0= LeftSquareBracket ( (lv_expression_1_0= ruleEvaluation ) ) )
            {
            // InternalMyBashParser.g:3801:2: (otherlv_0= LeftSquareBracket ( (lv_expression_1_0= ruleEvaluation ) ) )
            // InternalMyBashParser.g:3802:3: otherlv_0= LeftSquareBracket ( (lv_expression_1_0= ruleEvaluation ) )
            {
            otherlv_0=(Token)match(input,LeftSquareBracket,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getIndexEvaluationStartAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalMyBashParser.g:3806:3: ( (lv_expression_1_0= ruleEvaluation ) )
            // InternalMyBashParser.g:3807:4: (lv_expression_1_0= ruleEvaluation )
            {
            // InternalMyBashParser.g:3807:4: (lv_expression_1_0= ruleEvaluation )
            // InternalMyBashParser.g:3808:5: lv_expression_1_0= ruleEvaluation
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIndexEvaluationStartAccess().getExpressionEvaluationParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expression_1_0=ruleEvaluation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIndexEvaluationStartRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_1_0,
              						"org.xtext.example.mydsl.MyBash.Evaluation");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleIndexEvaluationStart"


    // $ANTLR start "entryRuleIndexEvaluationEnd"
    // InternalMyBashParser.g:3832:1: entryRuleIndexEvaluationEnd returns [String current=null] : iv_ruleIndexEvaluationEnd= ruleIndexEvaluationEnd EOF ;
    public final String entryRuleIndexEvaluationEnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIndexEvaluationEnd = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_C_LINE");

        try {
            // InternalMyBashParser.g:3834:2: (iv_ruleIndexEvaluationEnd= ruleIndexEvaluationEnd EOF )
            // InternalMyBashParser.g:3835:2: iv_ruleIndexEvaluationEnd= ruleIndexEvaluationEnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIndexEvaluationEndRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIndexEvaluationEnd=ruleIndexEvaluationEnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIndexEvaluationEnd.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleIndexEvaluationEnd"


    // $ANTLR start "ruleIndexEvaluationEnd"
    // InternalMyBashParser.g:3844:1: ruleIndexEvaluationEnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= RightSquareBracket ;
    public final AntlrDatatypeRuleToken ruleIndexEvaluationEnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_C_LINE");

        try {
            // InternalMyBashParser.g:3851:2: (kw= RightSquareBracket )
            // InternalMyBashParser.g:3852:2: kw= RightSquareBracket
            {
            kw=(Token)match(input,RightSquareBracket,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.getIndexEvaluationEndAccess().getRightSquareBracketKeyword());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleIndexEvaluationEnd"


    // $ANTLR start "entryRuleArithmeticExpansionStart"
    // InternalMyBashParser.g:3863:1: entryRuleArithmeticExpansionStart returns [EObject current=null] : iv_ruleArithmeticExpansionStart= ruleArithmeticExpansionStart EOF ;
    public final EObject entryRuleArithmeticExpansionStart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArithmeticExpansionStart = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_SL_COMMENT", "RULE_C_LINE", "RULE_WS", "RULE_HIDEN_NEW_LINE");

        try {
            // InternalMyBashParser.g:3865:2: (iv_ruleArithmeticExpansionStart= ruleArithmeticExpansionStart EOF )
            // InternalMyBashParser.g:3866:2: iv_ruleArithmeticExpansionStart= ruleArithmeticExpansionStart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArithmeticExpansionStartRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleArithmeticExpansionStart=ruleArithmeticExpansionStart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArithmeticExpansionStart; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleArithmeticExpansionStart"


    // $ANTLR start "ruleArithmeticExpansionStart"
    // InternalMyBashParser.g:3875:1: ruleArithmeticExpansionStart returns [EObject current=null] : (otherlv_0= DollarSignLeftParenthesisLeftParenthesis ( (lv_expression_1_0= ruleEvaluation ) ) ) ;
    public final EObject ruleArithmeticExpansionStart() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_expression_1_0 = null;



        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_SL_COMMENT", "RULE_C_LINE", "RULE_WS", "RULE_HIDEN_NEW_LINE");

        try {
            // InternalMyBashParser.g:3882:2: ( (otherlv_0= DollarSignLeftParenthesisLeftParenthesis ( (lv_expression_1_0= ruleEvaluation ) ) ) )
            // InternalMyBashParser.g:3883:2: (otherlv_0= DollarSignLeftParenthesisLeftParenthesis ( (lv_expression_1_0= ruleEvaluation ) ) )
            {
            // InternalMyBashParser.g:3883:2: (otherlv_0= DollarSignLeftParenthesisLeftParenthesis ( (lv_expression_1_0= ruleEvaluation ) ) )
            // InternalMyBashParser.g:3884:3: otherlv_0= DollarSignLeftParenthesisLeftParenthesis ( (lv_expression_1_0= ruleEvaluation ) )
            {
            otherlv_0=(Token)match(input,DollarSignLeftParenthesisLeftParenthesis,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getArithmeticExpansionStartAccess().getDollarSignLeftParenthesisLeftParenthesisKeyword_0());
              		
            }
            // InternalMyBashParser.g:3888:3: ( (lv_expression_1_0= ruleEvaluation ) )
            // InternalMyBashParser.g:3889:4: (lv_expression_1_0= ruleEvaluation )
            {
            // InternalMyBashParser.g:3889:4: (lv_expression_1_0= ruleEvaluation )
            // InternalMyBashParser.g:3890:5: lv_expression_1_0= ruleEvaluation
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getArithmeticExpansionStartAccess().getExpressionEvaluationParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expression_1_0=ruleEvaluation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getArithmeticExpansionStartRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_1_0,
              						"org.xtext.example.mydsl.MyBash.Evaluation");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleArithmeticExpansionStart"


    // $ANTLR start "entryRuleArithmeticExpansionEnd"
    // InternalMyBashParser.g:3914:1: entryRuleArithmeticExpansionEnd returns [String current=null] : iv_ruleArithmeticExpansionEnd= ruleArithmeticExpansionEnd EOF ;
    public final String entryRuleArithmeticExpansionEnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleArithmeticExpansionEnd = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_C_LINE");

        try {
            // InternalMyBashParser.g:3916:2: (iv_ruleArithmeticExpansionEnd= ruleArithmeticExpansionEnd EOF )
            // InternalMyBashParser.g:3917:2: iv_ruleArithmeticExpansionEnd= ruleArithmeticExpansionEnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArithmeticExpansionEndRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleArithmeticExpansionEnd=ruleArithmeticExpansionEnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArithmeticExpansionEnd.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleArithmeticExpansionEnd"


    // $ANTLR start "ruleArithmeticExpansionEnd"
    // InternalMyBashParser.g:3926:1: ruleArithmeticExpansionEnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= RightParenthesisRightParenthesis ;
    public final AntlrDatatypeRuleToken ruleArithmeticExpansionEnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_C_LINE");

        try {
            // InternalMyBashParser.g:3933:2: (kw= RightParenthesisRightParenthesis )
            // InternalMyBashParser.g:3934:2: kw= RightParenthesisRightParenthesis
            {
            kw=(Token)match(input,RightParenthesisRightParenthesis,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.getArithmeticExpansionEndAccess().getRightParenthesisRightParenthesisKeyword());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleArithmeticExpansionEnd"


    // $ANTLR start "entryRuleParameterExpansion"
    // InternalMyBashParser.g:3945:1: entryRuleParameterExpansion returns [EObject current=null] : iv_ruleParameterExpansion= ruleParameterExpansion EOF ;
    public final EObject entryRuleParameterExpansion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterExpansion = null;


        try {
            // InternalMyBashParser.g:3945:59: (iv_ruleParameterExpansion= ruleParameterExpansion EOF )
            // InternalMyBashParser.g:3946:2: iv_ruleParameterExpansion= ruleParameterExpansion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterExpansionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameterExpansion=ruleParameterExpansion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterExpansion; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterExpansion"


    // $ANTLR start "ruleParameterExpansion"
    // InternalMyBashParser.g:3952:1: ruleParameterExpansion returns [EObject current=null] : ( (this_ParameterExpansionStart_0= ruleParameterExpansionStart ( (lv_end_1_0= ruleParameterExpansionEnd ) ) ) | ( () ( (otherlv_3= RULE_VARIABLE ) ) ) ) ;
    public final EObject ruleParameterExpansion() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        EObject this_ParameterExpansionStart_0 = null;

        AntlrDatatypeRuleToken lv_end_1_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:3958:2: ( ( (this_ParameterExpansionStart_0= ruleParameterExpansionStart ( (lv_end_1_0= ruleParameterExpansionEnd ) ) ) | ( () ( (otherlv_3= RULE_VARIABLE ) ) ) ) )
            // InternalMyBashParser.g:3959:2: ( (this_ParameterExpansionStart_0= ruleParameterExpansionStart ( (lv_end_1_0= ruleParameterExpansionEnd ) ) ) | ( () ( (otherlv_3= RULE_VARIABLE ) ) ) )
            {
            // InternalMyBashParser.g:3959:2: ( (this_ParameterExpansionStart_0= ruleParameterExpansionStart ( (lv_end_1_0= ruleParameterExpansionEnd ) ) ) | ( () ( (otherlv_3= RULE_VARIABLE ) ) ) )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==DollarSignLeftCurlyBracket) ) {
                alt72=1;
            }
            else if ( (LA72_0==RULE_VARIABLE) ) {
                alt72=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }
            switch (alt72) {
                case 1 :
                    // InternalMyBashParser.g:3960:3: (this_ParameterExpansionStart_0= ruleParameterExpansionStart ( (lv_end_1_0= ruleParameterExpansionEnd ) ) )
                    {
                    // InternalMyBashParser.g:3960:3: (this_ParameterExpansionStart_0= ruleParameterExpansionStart ( (lv_end_1_0= ruleParameterExpansionEnd ) ) )
                    // InternalMyBashParser.g:3961:4: this_ParameterExpansionStart_0= ruleParameterExpansionStart ( (lv_end_1_0= ruleParameterExpansionEnd ) )
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getParameterExpansionAccess().getParameterExpansionStartParserRuleCall_0_0());
                      			
                    }
                    pushFollow(FOLLOW_16);
                    this_ParameterExpansionStart_0=ruleParameterExpansionStart();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_ParameterExpansionStart_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalMyBashParser.g:3969:4: ( (lv_end_1_0= ruleParameterExpansionEnd ) )
                    // InternalMyBashParser.g:3970:5: (lv_end_1_0= ruleParameterExpansionEnd )
                    {
                    // InternalMyBashParser.g:3970:5: (lv_end_1_0= ruleParameterExpansionEnd )
                    // InternalMyBashParser.g:3971:6: lv_end_1_0= ruleParameterExpansionEnd
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getParameterExpansionAccess().getEndParameterExpansionEndParserRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_end_1_0=ruleParameterExpansionEnd();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getParameterExpansionRule());
                      						}
                      						set(
                      							current,
                      							"end",
                      							lv_end_1_0,
                      							"org.xtext.example.mydsl.MyBash.ParameterExpansionEnd");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMyBashParser.g:3990:3: ( () ( (otherlv_3= RULE_VARIABLE ) ) )
                    {
                    // InternalMyBashParser.g:3990:3: ( () ( (otherlv_3= RULE_VARIABLE ) ) )
                    // InternalMyBashParser.g:3991:4: () ( (otherlv_3= RULE_VARIABLE ) )
                    {
                    // InternalMyBashParser.g:3991:4: ()
                    // InternalMyBashParser.g:3992:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getParameterExpansionAccess().getParameterExpansionAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalMyBashParser.g:3998:4: ( (otherlv_3= RULE_VARIABLE ) )
                    // InternalMyBashParser.g:3999:5: (otherlv_3= RULE_VARIABLE )
                    {
                    // InternalMyBashParser.g:3999:5: (otherlv_3= RULE_VARIABLE )
                    // InternalMyBashParser.g:4000:6: otherlv_3= RULE_VARIABLE
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getParameterExpansionRule());
                      						}
                      					
                    }
                    otherlv_3=(Token)match(input,RULE_VARIABLE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_3, grammarAccess.getParameterExpansionAccess().getRefAssignmentCrossReference_1_1_0());
                      					
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterExpansion"


    // $ANTLR start "entryRuleParameterExpansionStart"
    // InternalMyBashParser.g:4016:1: entryRuleParameterExpansionStart returns [EObject current=null] : iv_ruleParameterExpansionStart= ruleParameterExpansionStart EOF ;
    public final EObject entryRuleParameterExpansionStart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterExpansionStart = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_SL_COMMENT", "RULE_C_LINE", "RULE_WS", "RULE_HIDEN_NEW_LINE");

        try {
            // InternalMyBashParser.g:4018:2: (iv_ruleParameterExpansionStart= ruleParameterExpansionStart EOF )
            // InternalMyBashParser.g:4019:2: iv_ruleParameterExpansionStart= ruleParameterExpansionStart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterExpansionStartRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameterExpansionStart=ruleParameterExpansionStart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterExpansionStart; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleParameterExpansionStart"


    // $ANTLR start "ruleParameterExpansionStart"
    // InternalMyBashParser.g:4028:1: ruleParameterExpansionStart returns [EObject current=null] : ( () otherlv_1= DollarSignLeftCurlyBracket ( (lv_hash_2_0= NumberSign ) )? ( ( (otherlv_3= RULE_NAME ) ) | ( (lv_value_4_0= RULE_I_NUMBER ) ) | ( (lv_value_5_0= QuestionMark ) ) | ( (lv_value_6_0= CommercialAt ) ) | ( (lv_value_7_0= Asterisk ) ) ) (otherlv_8= LeftSquareBracket (otherlv_9= CommercialAt | otherlv_10= Asterisk | ( (lv_index_11_0= ruleEvaluation ) ) ) otherlv_12= RightSquareBracket )? ( (lv_replacer_13_0= ruleParameterProcessor ) )? ) ;
    public final EObject ruleParameterExpansionStart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_hash_2_0=null;
        Token otherlv_3=null;
        Token lv_value_4_0=null;
        Token lv_value_5_0=null;
        Token lv_value_6_0=null;
        Token lv_value_7_0=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_index_11_0 = null;

        EObject lv_replacer_13_0 = null;



        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_SL_COMMENT", "RULE_C_LINE", "RULE_WS", "RULE_HIDEN_NEW_LINE");

        try {
            // InternalMyBashParser.g:4035:2: ( ( () otherlv_1= DollarSignLeftCurlyBracket ( (lv_hash_2_0= NumberSign ) )? ( ( (otherlv_3= RULE_NAME ) ) | ( (lv_value_4_0= RULE_I_NUMBER ) ) | ( (lv_value_5_0= QuestionMark ) ) | ( (lv_value_6_0= CommercialAt ) ) | ( (lv_value_7_0= Asterisk ) ) ) (otherlv_8= LeftSquareBracket (otherlv_9= CommercialAt | otherlv_10= Asterisk | ( (lv_index_11_0= ruleEvaluation ) ) ) otherlv_12= RightSquareBracket )? ( (lv_replacer_13_0= ruleParameterProcessor ) )? ) )
            // InternalMyBashParser.g:4036:2: ( () otherlv_1= DollarSignLeftCurlyBracket ( (lv_hash_2_0= NumberSign ) )? ( ( (otherlv_3= RULE_NAME ) ) | ( (lv_value_4_0= RULE_I_NUMBER ) ) | ( (lv_value_5_0= QuestionMark ) ) | ( (lv_value_6_0= CommercialAt ) ) | ( (lv_value_7_0= Asterisk ) ) ) (otherlv_8= LeftSquareBracket (otherlv_9= CommercialAt | otherlv_10= Asterisk | ( (lv_index_11_0= ruleEvaluation ) ) ) otherlv_12= RightSquareBracket )? ( (lv_replacer_13_0= ruleParameterProcessor ) )? )
            {
            // InternalMyBashParser.g:4036:2: ( () otherlv_1= DollarSignLeftCurlyBracket ( (lv_hash_2_0= NumberSign ) )? ( ( (otherlv_3= RULE_NAME ) ) | ( (lv_value_4_0= RULE_I_NUMBER ) ) | ( (lv_value_5_0= QuestionMark ) ) | ( (lv_value_6_0= CommercialAt ) ) | ( (lv_value_7_0= Asterisk ) ) ) (otherlv_8= LeftSquareBracket (otherlv_9= CommercialAt | otherlv_10= Asterisk | ( (lv_index_11_0= ruleEvaluation ) ) ) otherlv_12= RightSquareBracket )? ( (lv_replacer_13_0= ruleParameterProcessor ) )? )
            // InternalMyBashParser.g:4037:3: () otherlv_1= DollarSignLeftCurlyBracket ( (lv_hash_2_0= NumberSign ) )? ( ( (otherlv_3= RULE_NAME ) ) | ( (lv_value_4_0= RULE_I_NUMBER ) ) | ( (lv_value_5_0= QuestionMark ) ) | ( (lv_value_6_0= CommercialAt ) ) | ( (lv_value_7_0= Asterisk ) ) ) (otherlv_8= LeftSquareBracket (otherlv_9= CommercialAt | otherlv_10= Asterisk | ( (lv_index_11_0= ruleEvaluation ) ) ) otherlv_12= RightSquareBracket )? ( (lv_replacer_13_0= ruleParameterProcessor ) )?
            {
            // InternalMyBashParser.g:4037:3: ()
            // InternalMyBashParser.g:4038:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParameterExpansionStartAccess().getParameterExpansionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,DollarSignLeftCurlyBracket,FOLLOW_63); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParameterExpansionStartAccess().getDollarSignLeftCurlyBracketKeyword_1());
              		
            }
            // InternalMyBashParser.g:4048:3: ( (lv_hash_2_0= NumberSign ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==NumberSign) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalMyBashParser.g:4049:4: (lv_hash_2_0= NumberSign )
                    {
                    // InternalMyBashParser.g:4049:4: (lv_hash_2_0= NumberSign )
                    // InternalMyBashParser.g:4050:5: lv_hash_2_0= NumberSign
                    {
                    lv_hash_2_0=(Token)match(input,NumberSign,FOLLOW_64); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_hash_2_0, grammarAccess.getParameterExpansionStartAccess().getHashNumberSignKeyword_2_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getParameterExpansionStartRule());
                      					}
                      					setWithLastConsumed(current, "hash", true, "#");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalMyBashParser.g:4062:3: ( ( (otherlv_3= RULE_NAME ) ) | ( (lv_value_4_0= RULE_I_NUMBER ) ) | ( (lv_value_5_0= QuestionMark ) ) | ( (lv_value_6_0= CommercialAt ) ) | ( (lv_value_7_0= Asterisk ) ) )
            int alt74=5;
            switch ( input.LA(1) ) {
            case RULE_NAME:
                {
                alt74=1;
                }
                break;
            case RULE_I_NUMBER:
                {
                alt74=2;
                }
                break;
            case QuestionMark:
                {
                alt74=3;
                }
                break;
            case CommercialAt:
                {
                alt74=4;
                }
                break;
            case Asterisk:
                {
                alt74=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }

            switch (alt74) {
                case 1 :
                    // InternalMyBashParser.g:4063:4: ( (otherlv_3= RULE_NAME ) )
                    {
                    // InternalMyBashParser.g:4063:4: ( (otherlv_3= RULE_NAME ) )
                    // InternalMyBashParser.g:4064:5: (otherlv_3= RULE_NAME )
                    {
                    // InternalMyBashParser.g:4064:5: (otherlv_3= RULE_NAME )
                    // InternalMyBashParser.g:4065:6: otherlv_3= RULE_NAME
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getParameterExpansionStartRule());
                      						}
                      					
                    }
                    otherlv_3=(Token)match(input,RULE_NAME,FOLLOW_65); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_3, grammarAccess.getParameterExpansionStartAccess().getRefAssignmentCrossReference_3_0_0());
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMyBashParser.g:4077:4: ( (lv_value_4_0= RULE_I_NUMBER ) )
                    {
                    // InternalMyBashParser.g:4077:4: ( (lv_value_4_0= RULE_I_NUMBER ) )
                    // InternalMyBashParser.g:4078:5: (lv_value_4_0= RULE_I_NUMBER )
                    {
                    // InternalMyBashParser.g:4078:5: (lv_value_4_0= RULE_I_NUMBER )
                    // InternalMyBashParser.g:4079:6: lv_value_4_0= RULE_I_NUMBER
                    {
                    lv_value_4_0=(Token)match(input,RULE_I_NUMBER,FOLLOW_65); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_4_0, grammarAccess.getParameterExpansionStartAccess().getValueI_NUMBERTerminalRuleCall_3_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getParameterExpansionStartRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_4_0,
                      							"org.xtext.example.mydsl.MyBash.I_NUMBER");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalMyBashParser.g:4096:4: ( (lv_value_5_0= QuestionMark ) )
                    {
                    // InternalMyBashParser.g:4096:4: ( (lv_value_5_0= QuestionMark ) )
                    // InternalMyBashParser.g:4097:5: (lv_value_5_0= QuestionMark )
                    {
                    // InternalMyBashParser.g:4097:5: (lv_value_5_0= QuestionMark )
                    // InternalMyBashParser.g:4098:6: lv_value_5_0= QuestionMark
                    {
                    lv_value_5_0=(Token)match(input,QuestionMark,FOLLOW_65); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_5_0, grammarAccess.getParameterExpansionStartAccess().getValueQuestionMarkKeyword_3_2_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getParameterExpansionStartRule());
                      						}
                      						setWithLastConsumed(current, "value", lv_value_5_0, "?");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalMyBashParser.g:4111:4: ( (lv_value_6_0= CommercialAt ) )
                    {
                    // InternalMyBashParser.g:4111:4: ( (lv_value_6_0= CommercialAt ) )
                    // InternalMyBashParser.g:4112:5: (lv_value_6_0= CommercialAt )
                    {
                    // InternalMyBashParser.g:4112:5: (lv_value_6_0= CommercialAt )
                    // InternalMyBashParser.g:4113:6: lv_value_6_0= CommercialAt
                    {
                    lv_value_6_0=(Token)match(input,CommercialAt,FOLLOW_65); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_6_0, grammarAccess.getParameterExpansionStartAccess().getValueCommercialAtKeyword_3_3_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getParameterExpansionStartRule());
                      						}
                      						setWithLastConsumed(current, "value", lv_value_6_0, "@");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalMyBashParser.g:4126:4: ( (lv_value_7_0= Asterisk ) )
                    {
                    // InternalMyBashParser.g:4126:4: ( (lv_value_7_0= Asterisk ) )
                    // InternalMyBashParser.g:4127:5: (lv_value_7_0= Asterisk )
                    {
                    // InternalMyBashParser.g:4127:5: (lv_value_7_0= Asterisk )
                    // InternalMyBashParser.g:4128:6: lv_value_7_0= Asterisk
                    {
                    lv_value_7_0=(Token)match(input,Asterisk,FOLLOW_65); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_7_0, grammarAccess.getParameterExpansionStartAccess().getValueAsteriskKeyword_3_4_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getParameterExpansionStartRule());
                      						}
                      						setWithLastConsumed(current, "value", lv_value_7_0, "*");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalMyBashParser.g:4141:3: (otherlv_8= LeftSquareBracket (otherlv_9= CommercialAt | otherlv_10= Asterisk | ( (lv_index_11_0= ruleEvaluation ) ) ) otherlv_12= RightSquareBracket )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==LeftSquareBracket) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalMyBashParser.g:4142:4: otherlv_8= LeftSquareBracket (otherlv_9= CommercialAt | otherlv_10= Asterisk | ( (lv_index_11_0= ruleEvaluation ) ) ) otherlv_12= RightSquareBracket
                    {
                    otherlv_8=(Token)match(input,LeftSquareBracket,FOLLOW_66); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getParameterExpansionStartAccess().getLeftSquareBracketKeyword_4_0());
                      			
                    }
                    // InternalMyBashParser.g:4146:4: (otherlv_9= CommercialAt | otherlv_10= Asterisk | ( (lv_index_11_0= ruleEvaluation ) ) )
                    int alt75=3;
                    switch ( input.LA(1) ) {
                    case CommercialAt:
                        {
                        alt75=1;
                        }
                        break;
                    case Asterisk:
                        {
                        alt75=2;
                        }
                        break;
                    case DollarSignLeftParenthesisLeftParenthesis:
                    case DollarSignLeftCurlyBracket:
                    case PlusSignPlusSign:
                    case HyphenMinusHyphenMinus:
                    case LessThanSignLeftParenthesis:
                    case GreaterThanSignLeftParenthesis:
                    case ExclamationMark:
                    case LeftParenthesis:
                    case PlusSign:
                    case HyphenMinus:
                    case Tilde:
                    case RULE_I_NUMBER:
                    case RULE_NAME:
                    case RULE_VARIABLE:
                    case RULE_A_PREFIX:
                    case RULE_CS_START:
                        {
                        alt75=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 75, 0, input);

                        throw nvae;
                    }

                    switch (alt75) {
                        case 1 :
                            // InternalMyBashParser.g:4147:5: otherlv_9= CommercialAt
                            {
                            otherlv_9=(Token)match(input,CommercialAt,FOLLOW_62); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_9, grammarAccess.getParameterExpansionStartAccess().getCommercialAtKeyword_4_1_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalMyBashParser.g:4152:5: otherlv_10= Asterisk
                            {
                            otherlv_10=(Token)match(input,Asterisk,FOLLOW_62); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_10, grammarAccess.getParameterExpansionStartAccess().getAsteriskKeyword_4_1_1());
                              				
                            }

                            }
                            break;
                        case 3 :
                            // InternalMyBashParser.g:4157:5: ( (lv_index_11_0= ruleEvaluation ) )
                            {
                            // InternalMyBashParser.g:4157:5: ( (lv_index_11_0= ruleEvaluation ) )
                            // InternalMyBashParser.g:4158:6: (lv_index_11_0= ruleEvaluation )
                            {
                            // InternalMyBashParser.g:4158:6: (lv_index_11_0= ruleEvaluation )
                            // InternalMyBashParser.g:4159:7: lv_index_11_0= ruleEvaluation
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getParameterExpansionStartAccess().getIndexEvaluationParserRuleCall_4_1_2_0());
                              						
                            }
                            pushFollow(FOLLOW_62);
                            lv_index_11_0=ruleEvaluation();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getParameterExpansionStartRule());
                              							}
                              							set(
                              								current,
                              								"index",
                              								lv_index_11_0,
                              								"org.xtext.example.mydsl.MyBash.Evaluation");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }


                            }
                            break;

                    }

                    otherlv_12=(Token)match(input,RightSquareBracket,FOLLOW_67); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getParameterExpansionStartAccess().getRightSquareBracketKeyword_4_2());
                      			
                    }

                    }
                    break;

            }

            // InternalMyBashParser.g:4182:3: ( (lv_replacer_13_0= ruleParameterProcessor ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==NumberSignNumberSign||LA77_0==PercentSignPercentSign||LA77_0==CommaComma||LA77_0==SolidusSolidus||(LA77_0>=ColonPlusSign && LA77_0<=ColonQuestionMark)||LA77_0==CircumflexAccentCircumflexAccent||(LA77_0>=NumberSign && LA77_0<=PercentSign)||(LA77_0>=PlusSign && LA77_0<=Colon)||LA77_0==EqualsSign||LA77_0==QuestionMark||LA77_0==CircumflexAccent) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalMyBashParser.g:4183:4: (lv_replacer_13_0= ruleParameterProcessor )
                    {
                    // InternalMyBashParser.g:4183:4: (lv_replacer_13_0= ruleParameterProcessor )
                    // InternalMyBashParser.g:4184:5: lv_replacer_13_0= ruleParameterProcessor
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getParameterExpansionStartAccess().getReplacerParameterProcessorParserRuleCall_5_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_replacer_13_0=ruleParameterProcessor();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getParameterExpansionStartRule());
                      					}
                      					set(
                      						current,
                      						"replacer",
                      						lv_replacer_13_0,
                      						"org.xtext.example.mydsl.MyBash.ParameterProcessor");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleParameterExpansionStart"


    // $ANTLR start "entryRuleParameterExpansionEnd"
    // InternalMyBashParser.g:4208:1: entryRuleParameterExpansionEnd returns [String current=null] : iv_ruleParameterExpansionEnd= ruleParameterExpansionEnd EOF ;
    public final String entryRuleParameterExpansionEnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleParameterExpansionEnd = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_C_LINE");

        try {
            // InternalMyBashParser.g:4210:2: (iv_ruleParameterExpansionEnd= ruleParameterExpansionEnd EOF )
            // InternalMyBashParser.g:4211:2: iv_ruleParameterExpansionEnd= ruleParameterExpansionEnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterExpansionEndRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameterExpansionEnd=ruleParameterExpansionEnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterExpansionEnd.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleParameterExpansionEnd"


    // $ANTLR start "ruleParameterExpansionEnd"
    // InternalMyBashParser.g:4220:1: ruleParameterExpansionEnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= RightCurlyBracket ;
    public final AntlrDatatypeRuleToken ruleParameterExpansionEnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_C_LINE");

        try {
            // InternalMyBashParser.g:4227:2: (kw= RightCurlyBracket )
            // InternalMyBashParser.g:4228:2: kw= RightCurlyBracket
            {
            kw=(Token)match(input,RightCurlyBracket,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.getParameterExpansionEndAccess().getRightCurlyBracketKeyword());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleParameterExpansionEnd"


    // $ANTLR start "entryRuleParameterProcessor"
    // InternalMyBashParser.g:4239:1: entryRuleParameterProcessor returns [EObject current=null] : iv_ruleParameterProcessor= ruleParameterProcessor EOF ;
    public final EObject entryRuleParameterProcessor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterProcessor = null;


        try {
            // InternalMyBashParser.g:4239:59: (iv_ruleParameterProcessor= ruleParameterProcessor EOF )
            // InternalMyBashParser.g:4240:2: iv_ruleParameterProcessor= ruleParameterProcessor EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterProcessorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameterProcessor=ruleParameterProcessor();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterProcessor; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterProcessor"


    // $ANTLR start "ruleParameterProcessor"
    // InternalMyBashParser.g:4246:1: ruleParameterProcessor returns [EObject current=null] : ( ( () ( (lv_op_1_0= ruleFollowWordOp ) ) ( (lv_word_2_0= ruleWord ) )? ) | ( () ( ( (lv_op_4_1= SolidusSolidus | lv_op_4_2= Solidus ) ) ) ( ( (lv_original_5_0= ruleWord ) ) (otherlv_6= Solidus ( (lv_replace_7_0= ruleWord ) )? )? )? ) | ( () ( ( (lv_op_9_1= SolidusSolidus | lv_op_9_2= Solidus ) ) ) otherlv_10= Solidus ( (lv_replace_11_0= ruleWord ) )? ) | ( () otherlv_13= Colon ( ( (lv_start_14_0= ruleEvaluation ) ) (otherlv_15= Colon ( (lv_length_16_0= ruleEvaluation ) )? )? )? ) | ( () otherlv_18= Colon otherlv_19= Colon ( (lv_length_20_0= ruleEvaluation ) )? ) ) ;
    public final EObject ruleParameterProcessor() throws RecognitionException {
        EObject current = null;

        Token lv_op_4_1=null;
        Token lv_op_4_2=null;
        Token otherlv_6=null;
        Token lv_op_9_1=null;
        Token lv_op_9_2=null;
        Token otherlv_10=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Enumerator lv_op_1_0 = null;

        EObject lv_word_2_0 = null;

        EObject lv_original_5_0 = null;

        EObject lv_replace_7_0 = null;

        EObject lv_replace_11_0 = null;

        EObject lv_start_14_0 = null;

        EObject lv_length_16_0 = null;

        EObject lv_length_20_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:4252:2: ( ( ( () ( (lv_op_1_0= ruleFollowWordOp ) ) ( (lv_word_2_0= ruleWord ) )? ) | ( () ( ( (lv_op_4_1= SolidusSolidus | lv_op_4_2= Solidus ) ) ) ( ( (lv_original_5_0= ruleWord ) ) (otherlv_6= Solidus ( (lv_replace_7_0= ruleWord ) )? )? )? ) | ( () ( ( (lv_op_9_1= SolidusSolidus | lv_op_9_2= Solidus ) ) ) otherlv_10= Solidus ( (lv_replace_11_0= ruleWord ) )? ) | ( () otherlv_13= Colon ( ( (lv_start_14_0= ruleEvaluation ) ) (otherlv_15= Colon ( (lv_length_16_0= ruleEvaluation ) )? )? )? ) | ( () otherlv_18= Colon otherlv_19= Colon ( (lv_length_20_0= ruleEvaluation ) )? ) ) )
            // InternalMyBashParser.g:4253:2: ( ( () ( (lv_op_1_0= ruleFollowWordOp ) ) ( (lv_word_2_0= ruleWord ) )? ) | ( () ( ( (lv_op_4_1= SolidusSolidus | lv_op_4_2= Solidus ) ) ) ( ( (lv_original_5_0= ruleWord ) ) (otherlv_6= Solidus ( (lv_replace_7_0= ruleWord ) )? )? )? ) | ( () ( ( (lv_op_9_1= SolidusSolidus | lv_op_9_2= Solidus ) ) ) otherlv_10= Solidus ( (lv_replace_11_0= ruleWord ) )? ) | ( () otherlv_13= Colon ( ( (lv_start_14_0= ruleEvaluation ) ) (otherlv_15= Colon ( (lv_length_16_0= ruleEvaluation ) )? )? )? ) | ( () otherlv_18= Colon otherlv_19= Colon ( (lv_length_20_0= ruleEvaluation ) )? ) )
            {
            // InternalMyBashParser.g:4253:2: ( ( () ( (lv_op_1_0= ruleFollowWordOp ) ) ( (lv_word_2_0= ruleWord ) )? ) | ( () ( ( (lv_op_4_1= SolidusSolidus | lv_op_4_2= Solidus ) ) ) ( ( (lv_original_5_0= ruleWord ) ) (otherlv_6= Solidus ( (lv_replace_7_0= ruleWord ) )? )? )? ) | ( () ( ( (lv_op_9_1= SolidusSolidus | lv_op_9_2= Solidus ) ) ) otherlv_10= Solidus ( (lv_replace_11_0= ruleWord ) )? ) | ( () otherlv_13= Colon ( ( (lv_start_14_0= ruleEvaluation ) ) (otherlv_15= Colon ( (lv_length_16_0= ruleEvaluation ) )? )? )? ) | ( () otherlv_18= Colon otherlv_19= Colon ( (lv_length_20_0= ruleEvaluation ) )? ) )
            int alt89=5;
            switch ( input.LA(1) ) {
            case NumberSignNumberSign:
            case PercentSignPercentSign:
            case CommaComma:
            case ColonPlusSign:
            case ColonHyphenMinus:
            case ColonEqualsSign:
            case ColonQuestionMark:
            case CircumflexAccentCircumflexAccent:
            case NumberSign:
            case PercentSign:
            case PlusSign:
            case Comma:
            case HyphenMinus:
            case EqualsSign:
            case QuestionMark:
            case CircumflexAccent:
                {
                alt89=1;
                }
                break;
            case SolidusSolidus:
                {
                int LA89_2 = input.LA(2);

                if ( (LA89_2==EOF||LA89_2==DollarSignLeftParenthesisLeftParenthesis||LA89_2==DollarSignLeftCurlyBracket||LA89_2==LessThanSignLeftParenthesis||LA89_2==GreaterThanSignLeftParenthesis||LA89_2==QuotationMark||LA89_2==Apostrophe||LA89_2==RightCurlyBracket||(LA89_2>=RULE_S_WORD_PART && LA89_2<=RULE_WORD_PART)||LA89_2==RULE_VARIABLE||LA89_2==RULE_CS_START) ) {
                    alt89=2;
                }
                else if ( (LA89_2==Solidus) ) {
                    alt89=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 89, 2, input);

                    throw nvae;
                }
                }
                break;
            case Solidus:
                {
                int LA89_3 = input.LA(2);

                if ( (LA89_3==EOF||LA89_3==DollarSignLeftParenthesisLeftParenthesis||LA89_3==DollarSignLeftCurlyBracket||LA89_3==LessThanSignLeftParenthesis||LA89_3==GreaterThanSignLeftParenthesis||LA89_3==QuotationMark||LA89_3==Apostrophe||LA89_3==RightCurlyBracket||(LA89_3>=RULE_S_WORD_PART && LA89_3<=RULE_WORD_PART)||LA89_3==RULE_VARIABLE||LA89_3==RULE_CS_START) ) {
                    alt89=2;
                }
                else if ( (LA89_3==Solidus) ) {
                    alt89=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 89, 3, input);

                    throw nvae;
                }
                }
                break;
            case Colon:
                {
                int LA89_4 = input.LA(2);

                if ( (LA89_4==Colon) ) {
                    alt89=5;
                }
                else if ( (LA89_4==EOF||LA89_4==DollarSignLeftParenthesisLeftParenthesis||LA89_4==DollarSignLeftCurlyBracket||LA89_4==PlusSignPlusSign||LA89_4==HyphenMinusHyphenMinus||LA89_4==LessThanSignLeftParenthesis||LA89_4==GreaterThanSignLeftParenthesis||LA89_4==ExclamationMark||LA89_4==LeftParenthesis||LA89_4==PlusSign||LA89_4==HyphenMinus||(LA89_4>=RightCurlyBracket && LA89_4<=RULE_I_NUMBER)||LA89_4==RULE_NAME||(LA89_4>=RULE_VARIABLE && LA89_4<=RULE_A_PREFIX)||LA89_4==RULE_CS_START) ) {
                    alt89=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 89, 4, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;
            }

            switch (alt89) {
                case 1 :
                    // InternalMyBashParser.g:4254:3: ( () ( (lv_op_1_0= ruleFollowWordOp ) ) ( (lv_word_2_0= ruleWord ) )? )
                    {
                    // InternalMyBashParser.g:4254:3: ( () ( (lv_op_1_0= ruleFollowWordOp ) ) ( (lv_word_2_0= ruleWord ) )? )
                    // InternalMyBashParser.g:4255:4: () ( (lv_op_1_0= ruleFollowWordOp ) ) ( (lv_word_2_0= ruleWord ) )?
                    {
                    // InternalMyBashParser.g:4255:4: ()
                    // InternalMyBashParser.g:4256:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getParameterProcessorAccess().getSingleProcessorAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalMyBashParser.g:4262:4: ( (lv_op_1_0= ruleFollowWordOp ) )
                    // InternalMyBashParser.g:4263:5: (lv_op_1_0= ruleFollowWordOp )
                    {
                    // InternalMyBashParser.g:4263:5: (lv_op_1_0= ruleFollowWordOp )
                    // InternalMyBashParser.g:4264:6: lv_op_1_0= ruleFollowWordOp
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getParameterProcessorAccess().getOpFollowWordOpEnumRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_53);
                    lv_op_1_0=ruleFollowWordOp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getParameterProcessorRule());
                      						}
                      						set(
                      							current,
                      							"op",
                      							lv_op_1_0,
                      							"org.xtext.example.mydsl.MyBash.FollowWordOp");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalMyBashParser.g:4281:4: ( (lv_word_2_0= ruleWord ) )?
                    int alt78=2;
                    int LA78_0 = input.LA(1);

                    if ( (LA78_0==DollarSignLeftParenthesisLeftParenthesis||LA78_0==DollarSignLeftCurlyBracket||LA78_0==LessThanSignLeftParenthesis||LA78_0==GreaterThanSignLeftParenthesis||LA78_0==QuotationMark||LA78_0==Apostrophe||(LA78_0>=RULE_S_WORD_PART && LA78_0<=RULE_WORD_PART)||LA78_0==RULE_VARIABLE||LA78_0==RULE_CS_START) ) {
                        alt78=1;
                    }
                    switch (alt78) {
                        case 1 :
                            // InternalMyBashParser.g:4282:5: (lv_word_2_0= ruleWord )
                            {
                            // InternalMyBashParser.g:4282:5: (lv_word_2_0= ruleWord )
                            // InternalMyBashParser.g:4283:6: lv_word_2_0= ruleWord
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getParameterProcessorAccess().getWordWordParserRuleCall_0_2_0());
                              					
                            }
                            pushFollow(FOLLOW_2);
                            lv_word_2_0=ruleWord();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElementForParent(grammarAccess.getParameterProcessorRule());
                              						}
                              						set(
                              							current,
                              							"word",
                              							lv_word_2_0,
                              							"org.xtext.example.mydsl.MyBash.Word");
                              						afterParserOrEnumRuleCall();
                              					
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMyBashParser.g:4302:3: ( () ( ( (lv_op_4_1= SolidusSolidus | lv_op_4_2= Solidus ) ) ) ( ( (lv_original_5_0= ruleWord ) ) (otherlv_6= Solidus ( (lv_replace_7_0= ruleWord ) )? )? )? )
                    {
                    // InternalMyBashParser.g:4302:3: ( () ( ( (lv_op_4_1= SolidusSolidus | lv_op_4_2= Solidus ) ) ) ( ( (lv_original_5_0= ruleWord ) ) (otherlv_6= Solidus ( (lv_replace_7_0= ruleWord ) )? )? )? )
                    // InternalMyBashParser.g:4303:4: () ( ( (lv_op_4_1= SolidusSolidus | lv_op_4_2= Solidus ) ) ) ( ( (lv_original_5_0= ruleWord ) ) (otherlv_6= Solidus ( (lv_replace_7_0= ruleWord ) )? )? )?
                    {
                    // InternalMyBashParser.g:4303:4: ()
                    // InternalMyBashParser.g:4304:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getParameterProcessorAccess().getReplaceProcessorAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalMyBashParser.g:4310:4: ( ( (lv_op_4_1= SolidusSolidus | lv_op_4_2= Solidus ) ) )
                    // InternalMyBashParser.g:4311:5: ( (lv_op_4_1= SolidusSolidus | lv_op_4_2= Solidus ) )
                    {
                    // InternalMyBashParser.g:4311:5: ( (lv_op_4_1= SolidusSolidus | lv_op_4_2= Solidus ) )
                    // InternalMyBashParser.g:4312:6: (lv_op_4_1= SolidusSolidus | lv_op_4_2= Solidus )
                    {
                    // InternalMyBashParser.g:4312:6: (lv_op_4_1= SolidusSolidus | lv_op_4_2= Solidus )
                    int alt79=2;
                    int LA79_0 = input.LA(1);

                    if ( (LA79_0==SolidusSolidus) ) {
                        alt79=1;
                    }
                    else if ( (LA79_0==Solidus) ) {
                        alt79=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 79, 0, input);

                        throw nvae;
                    }
                    switch (alt79) {
                        case 1 :
                            // InternalMyBashParser.g:4313:7: lv_op_4_1= SolidusSolidus
                            {
                            lv_op_4_1=(Token)match(input,SolidusSolidus,FOLLOW_53); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_4_1, grammarAccess.getParameterProcessorAccess().getOpSolidusSolidusKeyword_1_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getParameterProcessorRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_4_1, null);
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalMyBashParser.g:4324:7: lv_op_4_2= Solidus
                            {
                            lv_op_4_2=(Token)match(input,Solidus,FOLLOW_53); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_4_2, grammarAccess.getParameterProcessorAccess().getOpSolidusKeyword_1_1_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getParameterProcessorRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_4_2, null);
                              						
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalMyBashParser.g:4337:4: ( ( (lv_original_5_0= ruleWord ) ) (otherlv_6= Solidus ( (lv_replace_7_0= ruleWord ) )? )? )?
                    int alt82=2;
                    int LA82_0 = input.LA(1);

                    if ( (LA82_0==DollarSignLeftParenthesisLeftParenthesis||LA82_0==DollarSignLeftCurlyBracket||LA82_0==LessThanSignLeftParenthesis||LA82_0==GreaterThanSignLeftParenthesis||LA82_0==QuotationMark||LA82_0==Apostrophe||(LA82_0>=RULE_S_WORD_PART && LA82_0<=RULE_WORD_PART)||LA82_0==RULE_VARIABLE||LA82_0==RULE_CS_START) ) {
                        alt82=1;
                    }
                    switch (alt82) {
                        case 1 :
                            // InternalMyBashParser.g:4338:5: ( (lv_original_5_0= ruleWord ) ) (otherlv_6= Solidus ( (lv_replace_7_0= ruleWord ) )? )?
                            {
                            // InternalMyBashParser.g:4338:5: ( (lv_original_5_0= ruleWord ) )
                            // InternalMyBashParser.g:4339:6: (lv_original_5_0= ruleWord )
                            {
                            // InternalMyBashParser.g:4339:6: (lv_original_5_0= ruleWord )
                            // InternalMyBashParser.g:4340:7: lv_original_5_0= ruleWord
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getParameterProcessorAccess().getOriginalWordParserRuleCall_1_2_0_0());
                              						
                            }
                            pushFollow(FOLLOW_68);
                            lv_original_5_0=ruleWord();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getParameterProcessorRule());
                              							}
                              							set(
                              								current,
                              								"original",
                              								lv_original_5_0,
                              								"org.xtext.example.mydsl.MyBash.Word");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }

                            // InternalMyBashParser.g:4357:5: (otherlv_6= Solidus ( (lv_replace_7_0= ruleWord ) )? )?
                            int alt81=2;
                            int LA81_0 = input.LA(1);

                            if ( (LA81_0==Solidus) ) {
                                alt81=1;
                            }
                            switch (alt81) {
                                case 1 :
                                    // InternalMyBashParser.g:4358:6: otherlv_6= Solidus ( (lv_replace_7_0= ruleWord ) )?
                                    {
                                    otherlv_6=(Token)match(input,Solidus,FOLLOW_53); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      						newLeafNode(otherlv_6, grammarAccess.getParameterProcessorAccess().getSolidusKeyword_1_2_1_0());
                                      					
                                    }
                                    // InternalMyBashParser.g:4362:6: ( (lv_replace_7_0= ruleWord ) )?
                                    int alt80=2;
                                    int LA80_0 = input.LA(1);

                                    if ( (LA80_0==DollarSignLeftParenthesisLeftParenthesis||LA80_0==DollarSignLeftCurlyBracket||LA80_0==LessThanSignLeftParenthesis||LA80_0==GreaterThanSignLeftParenthesis||LA80_0==QuotationMark||LA80_0==Apostrophe||(LA80_0>=RULE_S_WORD_PART && LA80_0<=RULE_WORD_PART)||LA80_0==RULE_VARIABLE||LA80_0==RULE_CS_START) ) {
                                        alt80=1;
                                    }
                                    switch (alt80) {
                                        case 1 :
                                            // InternalMyBashParser.g:4363:7: (lv_replace_7_0= ruleWord )
                                            {
                                            // InternalMyBashParser.g:4363:7: (lv_replace_7_0= ruleWord )
                                            // InternalMyBashParser.g:4364:8: lv_replace_7_0= ruleWord
                                            {
                                            if ( state.backtracking==0 ) {

                                              								newCompositeNode(grammarAccess.getParameterProcessorAccess().getReplaceWordParserRuleCall_1_2_1_1_0());
                                              							
                                            }
                                            pushFollow(FOLLOW_2);
                                            lv_replace_7_0=ruleWord();

                                            state._fsp--;
                                            if (state.failed) return current;
                                            if ( state.backtracking==0 ) {

                                              								if (current==null) {
                                              									current = createModelElementForParent(grammarAccess.getParameterProcessorRule());
                                              								}
                                              								set(
                                              									current,
                                              									"replace",
                                              									lv_replace_7_0,
                                              									"org.xtext.example.mydsl.MyBash.Word");
                                              								afterParserOrEnumRuleCall();
                                              							
                                            }

                                            }


                                            }
                                            break;

                                    }


                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalMyBashParser.g:4385:3: ( () ( ( (lv_op_9_1= SolidusSolidus | lv_op_9_2= Solidus ) ) ) otherlv_10= Solidus ( (lv_replace_11_0= ruleWord ) )? )
                    {
                    // InternalMyBashParser.g:4385:3: ( () ( ( (lv_op_9_1= SolidusSolidus | lv_op_9_2= Solidus ) ) ) otherlv_10= Solidus ( (lv_replace_11_0= ruleWord ) )? )
                    // InternalMyBashParser.g:4386:4: () ( ( (lv_op_9_1= SolidusSolidus | lv_op_9_2= Solidus ) ) ) otherlv_10= Solidus ( (lv_replace_11_0= ruleWord ) )?
                    {
                    // InternalMyBashParser.g:4386:4: ()
                    // InternalMyBashParser.g:4387:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getParameterProcessorAccess().getReplaceProcessorAction_2_0(),
                      						current);
                      				
                    }

                    }

                    // InternalMyBashParser.g:4393:4: ( ( (lv_op_9_1= SolidusSolidus | lv_op_9_2= Solidus ) ) )
                    // InternalMyBashParser.g:4394:5: ( (lv_op_9_1= SolidusSolidus | lv_op_9_2= Solidus ) )
                    {
                    // InternalMyBashParser.g:4394:5: ( (lv_op_9_1= SolidusSolidus | lv_op_9_2= Solidus ) )
                    // InternalMyBashParser.g:4395:6: (lv_op_9_1= SolidusSolidus | lv_op_9_2= Solidus )
                    {
                    // InternalMyBashParser.g:4395:6: (lv_op_9_1= SolidusSolidus | lv_op_9_2= Solidus )
                    int alt83=2;
                    int LA83_0 = input.LA(1);

                    if ( (LA83_0==SolidusSolidus) ) {
                        alt83=1;
                    }
                    else if ( (LA83_0==Solidus) ) {
                        alt83=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 83, 0, input);

                        throw nvae;
                    }
                    switch (alt83) {
                        case 1 :
                            // InternalMyBashParser.g:4396:7: lv_op_9_1= SolidusSolidus
                            {
                            lv_op_9_1=(Token)match(input,SolidusSolidus,FOLLOW_69); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_9_1, grammarAccess.getParameterProcessorAccess().getOpSolidusSolidusKeyword_2_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getParameterProcessorRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_9_1, null);
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalMyBashParser.g:4407:7: lv_op_9_2= Solidus
                            {
                            lv_op_9_2=(Token)match(input,Solidus,FOLLOW_69); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_9_2, grammarAccess.getParameterProcessorAccess().getOpSolidusKeyword_2_1_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getParameterProcessorRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_9_2, null);
                              						
                            }

                            }
                            break;

                    }


                    }


                    }

                    otherlv_10=(Token)match(input,Solidus,FOLLOW_53); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getParameterProcessorAccess().getSolidusKeyword_2_2());
                      			
                    }
                    // InternalMyBashParser.g:4424:4: ( (lv_replace_11_0= ruleWord ) )?
                    int alt84=2;
                    int LA84_0 = input.LA(1);

                    if ( (LA84_0==DollarSignLeftParenthesisLeftParenthesis||LA84_0==DollarSignLeftCurlyBracket||LA84_0==LessThanSignLeftParenthesis||LA84_0==GreaterThanSignLeftParenthesis||LA84_0==QuotationMark||LA84_0==Apostrophe||(LA84_0>=RULE_S_WORD_PART && LA84_0<=RULE_WORD_PART)||LA84_0==RULE_VARIABLE||LA84_0==RULE_CS_START) ) {
                        alt84=1;
                    }
                    switch (alt84) {
                        case 1 :
                            // InternalMyBashParser.g:4425:5: (lv_replace_11_0= ruleWord )
                            {
                            // InternalMyBashParser.g:4425:5: (lv_replace_11_0= ruleWord )
                            // InternalMyBashParser.g:4426:6: lv_replace_11_0= ruleWord
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getParameterProcessorAccess().getReplaceWordParserRuleCall_2_3_0());
                              					
                            }
                            pushFollow(FOLLOW_2);
                            lv_replace_11_0=ruleWord();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElementForParent(grammarAccess.getParameterProcessorRule());
                              						}
                              						set(
                              							current,
                              							"replace",
                              							lv_replace_11_0,
                              							"org.xtext.example.mydsl.MyBash.Word");
                              						afterParserOrEnumRuleCall();
                              					
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalMyBashParser.g:4445:3: ( () otherlv_13= Colon ( ( (lv_start_14_0= ruleEvaluation ) ) (otherlv_15= Colon ( (lv_length_16_0= ruleEvaluation ) )? )? )? )
                    {
                    // InternalMyBashParser.g:4445:3: ( () otherlv_13= Colon ( ( (lv_start_14_0= ruleEvaluation ) ) (otherlv_15= Colon ( (lv_length_16_0= ruleEvaluation ) )? )? )? )
                    // InternalMyBashParser.g:4446:4: () otherlv_13= Colon ( ( (lv_start_14_0= ruleEvaluation ) ) (otherlv_15= Colon ( (lv_length_16_0= ruleEvaluation ) )? )? )?
                    {
                    // InternalMyBashParser.g:4446:4: ()
                    // InternalMyBashParser.g:4447:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getParameterProcessorAccess().getSubStringProcessorAction_3_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_13=(Token)match(input,Colon,FOLLOW_70); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getParameterProcessorAccess().getColonKeyword_3_1());
                      			
                    }
                    // InternalMyBashParser.g:4457:4: ( ( (lv_start_14_0= ruleEvaluation ) ) (otherlv_15= Colon ( (lv_length_16_0= ruleEvaluation ) )? )? )?
                    int alt87=2;
                    int LA87_0 = input.LA(1);

                    if ( (LA87_0==DollarSignLeftParenthesisLeftParenthesis||LA87_0==DollarSignLeftCurlyBracket||LA87_0==PlusSignPlusSign||LA87_0==HyphenMinusHyphenMinus||LA87_0==LessThanSignLeftParenthesis||LA87_0==GreaterThanSignLeftParenthesis||LA87_0==ExclamationMark||LA87_0==LeftParenthesis||LA87_0==PlusSign||LA87_0==HyphenMinus||(LA87_0>=Tilde && LA87_0<=RULE_I_NUMBER)||LA87_0==RULE_NAME||(LA87_0>=RULE_VARIABLE && LA87_0<=RULE_A_PREFIX)||LA87_0==RULE_CS_START) ) {
                        alt87=1;
                    }
                    switch (alt87) {
                        case 1 :
                            // InternalMyBashParser.g:4458:5: ( (lv_start_14_0= ruleEvaluation ) ) (otherlv_15= Colon ( (lv_length_16_0= ruleEvaluation ) )? )?
                            {
                            // InternalMyBashParser.g:4458:5: ( (lv_start_14_0= ruleEvaluation ) )
                            // InternalMyBashParser.g:4459:6: (lv_start_14_0= ruleEvaluation )
                            {
                            // InternalMyBashParser.g:4459:6: (lv_start_14_0= ruleEvaluation )
                            // InternalMyBashParser.g:4460:7: lv_start_14_0= ruleEvaluation
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getParameterProcessorAccess().getStartEvaluationParserRuleCall_3_2_0_0());
                              						
                            }
                            pushFollow(FOLLOW_71);
                            lv_start_14_0=ruleEvaluation();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getParameterProcessorRule());
                              							}
                              							set(
                              								current,
                              								"start",
                              								lv_start_14_0,
                              								"org.xtext.example.mydsl.MyBash.Evaluation");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }

                            // InternalMyBashParser.g:4477:5: (otherlv_15= Colon ( (lv_length_16_0= ruleEvaluation ) )? )?
                            int alt86=2;
                            int LA86_0 = input.LA(1);

                            if ( (LA86_0==Colon) ) {
                                alt86=1;
                            }
                            switch (alt86) {
                                case 1 :
                                    // InternalMyBashParser.g:4478:6: otherlv_15= Colon ( (lv_length_16_0= ruleEvaluation ) )?
                                    {
                                    otherlv_15=(Token)match(input,Colon,FOLLOW_70); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      						newLeafNode(otherlv_15, grammarAccess.getParameterProcessorAccess().getColonKeyword_3_2_1_0());
                                      					
                                    }
                                    // InternalMyBashParser.g:4482:6: ( (lv_length_16_0= ruleEvaluation ) )?
                                    int alt85=2;
                                    int LA85_0 = input.LA(1);

                                    if ( (LA85_0==DollarSignLeftParenthesisLeftParenthesis||LA85_0==DollarSignLeftCurlyBracket||LA85_0==PlusSignPlusSign||LA85_0==HyphenMinusHyphenMinus||LA85_0==LessThanSignLeftParenthesis||LA85_0==GreaterThanSignLeftParenthesis||LA85_0==ExclamationMark||LA85_0==LeftParenthesis||LA85_0==PlusSign||LA85_0==HyphenMinus||(LA85_0>=Tilde && LA85_0<=RULE_I_NUMBER)||LA85_0==RULE_NAME||(LA85_0>=RULE_VARIABLE && LA85_0<=RULE_A_PREFIX)||LA85_0==RULE_CS_START) ) {
                                        alt85=1;
                                    }
                                    switch (alt85) {
                                        case 1 :
                                            // InternalMyBashParser.g:4483:7: (lv_length_16_0= ruleEvaluation )
                                            {
                                            // InternalMyBashParser.g:4483:7: (lv_length_16_0= ruleEvaluation )
                                            // InternalMyBashParser.g:4484:8: lv_length_16_0= ruleEvaluation
                                            {
                                            if ( state.backtracking==0 ) {

                                              								newCompositeNode(grammarAccess.getParameterProcessorAccess().getLengthEvaluationParserRuleCall_3_2_1_1_0());
                                              							
                                            }
                                            pushFollow(FOLLOW_2);
                                            lv_length_16_0=ruleEvaluation();

                                            state._fsp--;
                                            if (state.failed) return current;
                                            if ( state.backtracking==0 ) {

                                              								if (current==null) {
                                              									current = createModelElementForParent(grammarAccess.getParameterProcessorRule());
                                              								}
                                              								set(
                                              									current,
                                              									"length",
                                              									lv_length_16_0,
                                              									"org.xtext.example.mydsl.MyBash.Evaluation");
                                              								afterParserOrEnumRuleCall();
                                              							
                                            }

                                            }


                                            }
                                            break;

                                    }


                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalMyBashParser.g:4505:3: ( () otherlv_18= Colon otherlv_19= Colon ( (lv_length_20_0= ruleEvaluation ) )? )
                    {
                    // InternalMyBashParser.g:4505:3: ( () otherlv_18= Colon otherlv_19= Colon ( (lv_length_20_0= ruleEvaluation ) )? )
                    // InternalMyBashParser.g:4506:4: () otherlv_18= Colon otherlv_19= Colon ( (lv_length_20_0= ruleEvaluation ) )?
                    {
                    // InternalMyBashParser.g:4506:4: ()
                    // InternalMyBashParser.g:4507:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getParameterProcessorAccess().getSubStringProcessorAction_4_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_18=(Token)match(input,Colon,FOLLOW_72); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_18, grammarAccess.getParameterProcessorAccess().getColonKeyword_4_1());
                      			
                    }
                    otherlv_19=(Token)match(input,Colon,FOLLOW_70); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_19, grammarAccess.getParameterProcessorAccess().getColonKeyword_4_2());
                      			
                    }
                    // InternalMyBashParser.g:4521:4: ( (lv_length_20_0= ruleEvaluation ) )?
                    int alt88=2;
                    int LA88_0 = input.LA(1);

                    if ( (LA88_0==DollarSignLeftParenthesisLeftParenthesis||LA88_0==DollarSignLeftCurlyBracket||LA88_0==PlusSignPlusSign||LA88_0==HyphenMinusHyphenMinus||LA88_0==LessThanSignLeftParenthesis||LA88_0==GreaterThanSignLeftParenthesis||LA88_0==ExclamationMark||LA88_0==LeftParenthesis||LA88_0==PlusSign||LA88_0==HyphenMinus||(LA88_0>=Tilde && LA88_0<=RULE_I_NUMBER)||LA88_0==RULE_NAME||(LA88_0>=RULE_VARIABLE && LA88_0<=RULE_A_PREFIX)||LA88_0==RULE_CS_START) ) {
                        alt88=1;
                    }
                    switch (alt88) {
                        case 1 :
                            // InternalMyBashParser.g:4522:5: (lv_length_20_0= ruleEvaluation )
                            {
                            // InternalMyBashParser.g:4522:5: (lv_length_20_0= ruleEvaluation )
                            // InternalMyBashParser.g:4523:6: lv_length_20_0= ruleEvaluation
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getParameterProcessorAccess().getLengthEvaluationParserRuleCall_4_3_0());
                              					
                            }
                            pushFollow(FOLLOW_2);
                            lv_length_20_0=ruleEvaluation();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElementForParent(grammarAccess.getParameterProcessorRule());
                              						}
                              						set(
                              							current,
                              							"length",
                              							lv_length_20_0,
                              							"org.xtext.example.mydsl.MyBash.Evaluation");
                              						afterParserOrEnumRuleCall();
                              					
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterProcessor"


    // $ANTLR start "entryRuleCommandSubstitution"
    // InternalMyBashParser.g:4545:1: entryRuleCommandSubstitution returns [EObject current=null] : iv_ruleCommandSubstitution= ruleCommandSubstitution EOF ;
    public final EObject entryRuleCommandSubstitution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommandSubstitution = null;


        try {
            // InternalMyBashParser.g:4545:60: (iv_ruleCommandSubstitution= ruleCommandSubstitution EOF )
            // InternalMyBashParser.g:4546:2: iv_ruleCommandSubstitution= ruleCommandSubstitution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCommandSubstitutionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCommandSubstitution=ruleCommandSubstitution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCommandSubstitution; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCommandSubstitution"


    // $ANTLR start "ruleCommandSubstitution"
    // InternalMyBashParser.g:4552:1: ruleCommandSubstitution returns [EObject current=null] : (this_CommandSubstitutionStart_0= ruleCommandSubstitutionStart ( (lv_end_1_0= ruleCommandSubstitutionStartEnd ) ) ) ;
    public final EObject ruleCommandSubstitution() throws RecognitionException {
        EObject current = null;

        EObject this_CommandSubstitutionStart_0 = null;

        AntlrDatatypeRuleToken lv_end_1_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:4558:2: ( (this_CommandSubstitutionStart_0= ruleCommandSubstitutionStart ( (lv_end_1_0= ruleCommandSubstitutionStartEnd ) ) ) )
            // InternalMyBashParser.g:4559:2: (this_CommandSubstitutionStart_0= ruleCommandSubstitutionStart ( (lv_end_1_0= ruleCommandSubstitutionStartEnd ) ) )
            {
            // InternalMyBashParser.g:4559:2: (this_CommandSubstitutionStart_0= ruleCommandSubstitutionStart ( (lv_end_1_0= ruleCommandSubstitutionStartEnd ) ) )
            // InternalMyBashParser.g:4560:3: this_CommandSubstitutionStart_0= ruleCommandSubstitutionStart ( (lv_end_1_0= ruleCommandSubstitutionStartEnd ) )
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getCommandSubstitutionAccess().getCommandSubstitutionStartParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_73);
            this_CommandSubstitutionStart_0=ruleCommandSubstitutionStart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_CommandSubstitutionStart_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMyBashParser.g:4568:3: ( (lv_end_1_0= ruleCommandSubstitutionStartEnd ) )
            // InternalMyBashParser.g:4569:4: (lv_end_1_0= ruleCommandSubstitutionStartEnd )
            {
            // InternalMyBashParser.g:4569:4: (lv_end_1_0= ruleCommandSubstitutionStartEnd )
            // InternalMyBashParser.g:4570:5: lv_end_1_0= ruleCommandSubstitutionStartEnd
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCommandSubstitutionAccess().getEndCommandSubstitutionStartEndParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_end_1_0=ruleCommandSubstitutionStartEnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCommandSubstitutionRule());
              					}
              					set(
              						current,
              						"end",
              						lv_end_1_0,
              						"org.xtext.example.mydsl.MyBash.CommandSubstitutionStartEnd");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCommandSubstitution"


    // $ANTLR start "entryRuleCommandSubstitutionStart"
    // InternalMyBashParser.g:4591:1: entryRuleCommandSubstitutionStart returns [EObject current=null] : iv_ruleCommandSubstitutionStart= ruleCommandSubstitutionStart EOF ;
    public final EObject entryRuleCommandSubstitutionStart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommandSubstitutionStart = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_SL_COMMENT", "RULE_C_LINE", "RULE_WS", "RULE_HIDEN_NEW_LINE");

        try {
            // InternalMyBashParser.g:4593:2: (iv_ruleCommandSubstitutionStart= ruleCommandSubstitutionStart EOF )
            // InternalMyBashParser.g:4594:2: iv_ruleCommandSubstitutionStart= ruleCommandSubstitutionStart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCommandSubstitutionStartRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCommandSubstitutionStart=ruleCommandSubstitutionStart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCommandSubstitutionStart; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleCommandSubstitutionStart"


    // $ANTLR start "ruleCommandSubstitutionStart"
    // InternalMyBashParser.g:4603:1: ruleCommandSubstitutionStart returns [EObject current=null] : (this_CS_START_0= RULE_CS_START ( (lv_commands_1_0= ruleCompoundList ) ) ) ;
    public final EObject ruleCommandSubstitutionStart() throws RecognitionException {
        EObject current = null;

        Token this_CS_START_0=null;
        EObject lv_commands_1_0 = null;



        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_SL_COMMENT", "RULE_C_LINE", "RULE_WS", "RULE_HIDEN_NEW_LINE");

        try {
            // InternalMyBashParser.g:4610:2: ( (this_CS_START_0= RULE_CS_START ( (lv_commands_1_0= ruleCompoundList ) ) ) )
            // InternalMyBashParser.g:4611:2: (this_CS_START_0= RULE_CS_START ( (lv_commands_1_0= ruleCompoundList ) ) )
            {
            // InternalMyBashParser.g:4611:2: (this_CS_START_0= RULE_CS_START ( (lv_commands_1_0= ruleCompoundList ) ) )
            // InternalMyBashParser.g:4612:3: this_CS_START_0= RULE_CS_START ( (lv_commands_1_0= ruleCompoundList ) )
            {
            this_CS_START_0=(Token)match(input,RULE_CS_START,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_CS_START_0, grammarAccess.getCommandSubstitutionStartAccess().getCS_STARTTerminalRuleCall_0());
              		
            }
            // InternalMyBashParser.g:4616:3: ( (lv_commands_1_0= ruleCompoundList ) )
            // InternalMyBashParser.g:4617:4: (lv_commands_1_0= ruleCompoundList )
            {
            // InternalMyBashParser.g:4617:4: (lv_commands_1_0= ruleCompoundList )
            // InternalMyBashParser.g:4618:5: lv_commands_1_0= ruleCompoundList
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCommandSubstitutionStartAccess().getCommandsCompoundListParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_commands_1_0=ruleCompoundList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCommandSubstitutionStartRule());
              					}
              					set(
              						current,
              						"commands",
              						lv_commands_1_0,
              						"org.xtext.example.mydsl.MyBash.CompoundList");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleCommandSubstitutionStart"


    // $ANTLR start "entryRuleCommandSubstitutionStartEnd"
    // InternalMyBashParser.g:4642:1: entryRuleCommandSubstitutionStartEnd returns [String current=null] : iv_ruleCommandSubstitutionStartEnd= ruleCommandSubstitutionStartEnd EOF ;
    public final String entryRuleCommandSubstitutionStartEnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCommandSubstitutionStartEnd = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_C_LINE");

        try {
            // InternalMyBashParser.g:4644:2: (iv_ruleCommandSubstitutionStartEnd= ruleCommandSubstitutionStartEnd EOF )
            // InternalMyBashParser.g:4645:2: iv_ruleCommandSubstitutionStartEnd= ruleCommandSubstitutionStartEnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCommandSubstitutionStartEndRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCommandSubstitutionStartEnd=ruleCommandSubstitutionStartEnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCommandSubstitutionStartEnd.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleCommandSubstitutionStartEnd"


    // $ANTLR start "ruleCommandSubstitutionStartEnd"
    // InternalMyBashParser.g:4654:1: ruleCommandSubstitutionStartEnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_CS_END_0= RULE_CS_END ;
    public final AntlrDatatypeRuleToken ruleCommandSubstitutionStartEnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_CS_END_0=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_C_LINE");

        try {
            // InternalMyBashParser.g:4661:2: (this_CS_END_0= RULE_CS_END )
            // InternalMyBashParser.g:4662:2: this_CS_END_0= RULE_CS_END
            {
            this_CS_END_0=(Token)match(input,RULE_CS_END,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_CS_END_0);
              	
            }
            if ( state.backtracking==0 ) {

              		newLeafNode(this_CS_END_0, grammarAccess.getCommandSubstitutionStartEndAccess().getCS_ENDTerminalRuleCall());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleCommandSubstitutionStartEnd"


    // $ANTLR start "entryRuleProcessSubstitution"
    // InternalMyBashParser.g:4675:1: entryRuleProcessSubstitution returns [EObject current=null] : iv_ruleProcessSubstitution= ruleProcessSubstitution EOF ;
    public final EObject entryRuleProcessSubstitution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcessSubstitution = null;


        try {
            // InternalMyBashParser.g:4675:60: (iv_ruleProcessSubstitution= ruleProcessSubstitution EOF )
            // InternalMyBashParser.g:4676:2: iv_ruleProcessSubstitution= ruleProcessSubstitution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProcessSubstitutionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleProcessSubstitution=ruleProcessSubstitution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProcessSubstitution; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProcessSubstitution"


    // $ANTLR start "ruleProcessSubstitution"
    // InternalMyBashParser.g:4682:1: ruleProcessSubstitution returns [EObject current=null] : (this_ProcessSubstitutionStart_0= ruleProcessSubstitutionStart ( (lv_end_1_0= ruleProcessSubstitutionEnd ) ) ) ;
    public final EObject ruleProcessSubstitution() throws RecognitionException {
        EObject current = null;

        EObject this_ProcessSubstitutionStart_0 = null;

        AntlrDatatypeRuleToken lv_end_1_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:4688:2: ( (this_ProcessSubstitutionStart_0= ruleProcessSubstitutionStart ( (lv_end_1_0= ruleProcessSubstitutionEnd ) ) ) )
            // InternalMyBashParser.g:4689:2: (this_ProcessSubstitutionStart_0= ruleProcessSubstitutionStart ( (lv_end_1_0= ruleProcessSubstitutionEnd ) ) )
            {
            // InternalMyBashParser.g:4689:2: (this_ProcessSubstitutionStart_0= ruleProcessSubstitutionStart ( (lv_end_1_0= ruleProcessSubstitutionEnd ) ) )
            // InternalMyBashParser.g:4690:3: this_ProcessSubstitutionStart_0= ruleProcessSubstitutionStart ( (lv_end_1_0= ruleProcessSubstitutionEnd ) )
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getProcessSubstitutionAccess().getProcessSubstitutionStartParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_13);
            this_ProcessSubstitutionStart_0=ruleProcessSubstitutionStart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ProcessSubstitutionStart_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMyBashParser.g:4698:3: ( (lv_end_1_0= ruleProcessSubstitutionEnd ) )
            // InternalMyBashParser.g:4699:4: (lv_end_1_0= ruleProcessSubstitutionEnd )
            {
            // InternalMyBashParser.g:4699:4: (lv_end_1_0= ruleProcessSubstitutionEnd )
            // InternalMyBashParser.g:4700:5: lv_end_1_0= ruleProcessSubstitutionEnd
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getProcessSubstitutionAccess().getEndProcessSubstitutionEndParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_end_1_0=ruleProcessSubstitutionEnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getProcessSubstitutionRule());
              					}
              					set(
              						current,
              						"end",
              						lv_end_1_0,
              						"org.xtext.example.mydsl.MyBash.ProcessSubstitutionEnd");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProcessSubstitution"


    // $ANTLR start "entryRuleProcessSubstitutionStart"
    // InternalMyBashParser.g:4721:1: entryRuleProcessSubstitutionStart returns [EObject current=null] : iv_ruleProcessSubstitutionStart= ruleProcessSubstitutionStart EOF ;
    public final EObject entryRuleProcessSubstitutionStart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcessSubstitutionStart = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_SL_COMMENT", "RULE_C_LINE", "RULE_WS", "RULE_HIDEN_NEW_LINE");

        try {
            // InternalMyBashParser.g:4723:2: (iv_ruleProcessSubstitutionStart= ruleProcessSubstitutionStart EOF )
            // InternalMyBashParser.g:4724:2: iv_ruleProcessSubstitutionStart= ruleProcessSubstitutionStart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProcessSubstitutionStartRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleProcessSubstitutionStart=ruleProcessSubstitutionStart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProcessSubstitutionStart; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleProcessSubstitutionStart"


    // $ANTLR start "ruleProcessSubstitutionStart"
    // InternalMyBashParser.g:4733:1: ruleProcessSubstitutionStart returns [EObject current=null] : ( ( ( (lv_op_0_1= LessThanSignLeftParenthesis | lv_op_0_2= GreaterThanSignLeftParenthesis ) ) ) ( (lv_body_1_0= ruleCompoundList ) ) ) ;
    public final EObject ruleProcessSubstitutionStart() throws RecognitionException {
        EObject current = null;

        Token lv_op_0_1=null;
        Token lv_op_0_2=null;
        EObject lv_body_1_0 = null;



        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_SL_COMMENT", "RULE_C_LINE", "RULE_WS", "RULE_HIDEN_NEW_LINE");

        try {
            // InternalMyBashParser.g:4740:2: ( ( ( ( (lv_op_0_1= LessThanSignLeftParenthesis | lv_op_0_2= GreaterThanSignLeftParenthesis ) ) ) ( (lv_body_1_0= ruleCompoundList ) ) ) )
            // InternalMyBashParser.g:4741:2: ( ( ( (lv_op_0_1= LessThanSignLeftParenthesis | lv_op_0_2= GreaterThanSignLeftParenthesis ) ) ) ( (lv_body_1_0= ruleCompoundList ) ) )
            {
            // InternalMyBashParser.g:4741:2: ( ( ( (lv_op_0_1= LessThanSignLeftParenthesis | lv_op_0_2= GreaterThanSignLeftParenthesis ) ) ) ( (lv_body_1_0= ruleCompoundList ) ) )
            // InternalMyBashParser.g:4742:3: ( ( (lv_op_0_1= LessThanSignLeftParenthesis | lv_op_0_2= GreaterThanSignLeftParenthesis ) ) ) ( (lv_body_1_0= ruleCompoundList ) )
            {
            // InternalMyBashParser.g:4742:3: ( ( (lv_op_0_1= LessThanSignLeftParenthesis | lv_op_0_2= GreaterThanSignLeftParenthesis ) ) )
            // InternalMyBashParser.g:4743:4: ( (lv_op_0_1= LessThanSignLeftParenthesis | lv_op_0_2= GreaterThanSignLeftParenthesis ) )
            {
            // InternalMyBashParser.g:4743:4: ( (lv_op_0_1= LessThanSignLeftParenthesis | lv_op_0_2= GreaterThanSignLeftParenthesis ) )
            // InternalMyBashParser.g:4744:5: (lv_op_0_1= LessThanSignLeftParenthesis | lv_op_0_2= GreaterThanSignLeftParenthesis )
            {
            // InternalMyBashParser.g:4744:5: (lv_op_0_1= LessThanSignLeftParenthesis | lv_op_0_2= GreaterThanSignLeftParenthesis )
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==LessThanSignLeftParenthesis) ) {
                alt90=1;
            }
            else if ( (LA90_0==GreaterThanSignLeftParenthesis) ) {
                alt90=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;
            }
            switch (alt90) {
                case 1 :
                    // InternalMyBashParser.g:4745:6: lv_op_0_1= LessThanSignLeftParenthesis
                    {
                    lv_op_0_1=(Token)match(input,LessThanSignLeftParenthesis,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_0_1, grammarAccess.getProcessSubstitutionStartAccess().getOpLessThanSignLeftParenthesisKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getProcessSubstitutionStartRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_0_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalMyBashParser.g:4756:6: lv_op_0_2= GreaterThanSignLeftParenthesis
                    {
                    lv_op_0_2=(Token)match(input,GreaterThanSignLeftParenthesis,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_0_2, grammarAccess.getProcessSubstitutionStartAccess().getOpGreaterThanSignLeftParenthesisKeyword_0_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getProcessSubstitutionStartRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_0_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            // InternalMyBashParser.g:4769:3: ( (lv_body_1_0= ruleCompoundList ) )
            // InternalMyBashParser.g:4770:4: (lv_body_1_0= ruleCompoundList )
            {
            // InternalMyBashParser.g:4770:4: (lv_body_1_0= ruleCompoundList )
            // InternalMyBashParser.g:4771:5: lv_body_1_0= ruleCompoundList
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getProcessSubstitutionStartAccess().getBodyCompoundListParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_body_1_0=ruleCompoundList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getProcessSubstitutionStartRule());
              					}
              					set(
              						current,
              						"body",
              						lv_body_1_0,
              						"org.xtext.example.mydsl.MyBash.CompoundList");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleProcessSubstitutionStart"


    // $ANTLR start "entryRuleProcessSubstitutionEnd"
    // InternalMyBashParser.g:4795:1: entryRuleProcessSubstitutionEnd returns [String current=null] : iv_ruleProcessSubstitutionEnd= ruleProcessSubstitutionEnd EOF ;
    public final String entryRuleProcessSubstitutionEnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleProcessSubstitutionEnd = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_C_LINE");

        try {
            // InternalMyBashParser.g:4797:2: (iv_ruleProcessSubstitutionEnd= ruleProcessSubstitutionEnd EOF )
            // InternalMyBashParser.g:4798:2: iv_ruleProcessSubstitutionEnd= ruleProcessSubstitutionEnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProcessSubstitutionEndRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleProcessSubstitutionEnd=ruleProcessSubstitutionEnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProcessSubstitutionEnd.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleProcessSubstitutionEnd"


    // $ANTLR start "ruleProcessSubstitutionEnd"
    // InternalMyBashParser.g:4807:1: ruleProcessSubstitutionEnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= RightParenthesis ;
    public final AntlrDatatypeRuleToken ruleProcessSubstitutionEnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_C_LINE");

        try {
            // InternalMyBashParser.g:4814:2: (kw= RightParenthesis )
            // InternalMyBashParser.g:4815:2: kw= RightParenthesis
            {
            kw=(Token)match(input,RightParenthesis,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.getProcessSubstitutionEndAccess().getRightParenthesisKeyword());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleProcessSubstitutionEnd"


    // $ANTLR start "entryRuleEvaluation"
    // InternalMyBashParser.g:4826:1: entryRuleEvaluation returns [EObject current=null] : iv_ruleEvaluation= ruleEvaluation EOF ;
    public final EObject entryRuleEvaluation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvaluation = null;


        try {
            // InternalMyBashParser.g:4826:51: (iv_ruleEvaluation= ruleEvaluation EOF )
            // InternalMyBashParser.g:4827:2: iv_ruleEvaluation= ruleEvaluation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEvaluationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEvaluation=ruleEvaluation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEvaluation; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEvaluation"


    // $ANTLR start "ruleEvaluation"
    // InternalMyBashParser.g:4833:1: ruleEvaluation returns [EObject current=null] : (this_Arithmetic_0= ruleArithmetic ( () ( (lv_op_2_0= Comma ) ) ( (lv_right_3_0= ruleArithmetic ) ) )* ) ;
    public final EObject ruleEvaluation() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_Arithmetic_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:4839:2: ( (this_Arithmetic_0= ruleArithmetic ( () ( (lv_op_2_0= Comma ) ) ( (lv_right_3_0= ruleArithmetic ) ) )* ) )
            // InternalMyBashParser.g:4840:2: (this_Arithmetic_0= ruleArithmetic ( () ( (lv_op_2_0= Comma ) ) ( (lv_right_3_0= ruleArithmetic ) ) )* )
            {
            // InternalMyBashParser.g:4840:2: (this_Arithmetic_0= ruleArithmetic ( () ( (lv_op_2_0= Comma ) ) ( (lv_right_3_0= ruleArithmetic ) ) )* )
            // InternalMyBashParser.g:4841:3: this_Arithmetic_0= ruleArithmetic ( () ( (lv_op_2_0= Comma ) ) ( (lv_right_3_0= ruleArithmetic ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getEvaluationAccess().getArithmeticParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_74);
            this_Arithmetic_0=ruleArithmetic();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Arithmetic_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMyBashParser.g:4849:3: ( () ( (lv_op_2_0= Comma ) ) ( (lv_right_3_0= ruleArithmetic ) ) )*
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==Comma) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // InternalMyBashParser.g:4850:4: () ( (lv_op_2_0= Comma ) ) ( (lv_right_3_0= ruleArithmetic ) )
            	    {
            	    // InternalMyBashParser.g:4850:4: ()
            	    // InternalMyBashParser.g:4851:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getEvaluationAccess().getBinaryExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalMyBashParser.g:4857:4: ( (lv_op_2_0= Comma ) )
            	    // InternalMyBashParser.g:4858:5: (lv_op_2_0= Comma )
            	    {
            	    // InternalMyBashParser.g:4858:5: (lv_op_2_0= Comma )
            	    // InternalMyBashParser.g:4859:6: lv_op_2_0= Comma
            	    {
            	    lv_op_2_0=(Token)match(input,Comma,FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(lv_op_2_0, grammarAccess.getEvaluationAccess().getOpCommaKeyword_1_1_0());
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getEvaluationRule());
            	      						}
            	      						setWithLastConsumed(current, "op", lv_op_2_0, ",");
            	      					
            	    }

            	    }


            	    }

            	    // InternalMyBashParser.g:4871:4: ( (lv_right_3_0= ruleArithmetic ) )
            	    // InternalMyBashParser.g:4872:5: (lv_right_3_0= ruleArithmetic )
            	    {
            	    // InternalMyBashParser.g:4872:5: (lv_right_3_0= ruleArithmetic )
            	    // InternalMyBashParser.g:4873:6: lv_right_3_0= ruleArithmetic
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEvaluationAccess().getRightArithmeticParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_74);
            	    lv_right_3_0=ruleArithmetic();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getEvaluationRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.xtext.example.mydsl.MyBash.Arithmetic");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop91;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEvaluation"


    // $ANTLR start "entryRuleArithmetic"
    // InternalMyBashParser.g:4895:1: entryRuleArithmetic returns [EObject current=null] : iv_ruleArithmetic= ruleArithmetic EOF ;
    public final EObject entryRuleArithmetic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArithmetic = null;


        try {
            // InternalMyBashParser.g:4895:51: (iv_ruleArithmetic= ruleArithmetic EOF )
            // InternalMyBashParser.g:4896:2: iv_ruleArithmetic= ruleArithmetic EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArithmeticRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleArithmetic=ruleArithmetic();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArithmetic; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArithmetic"


    // $ANTLR start "ruleArithmetic"
    // InternalMyBashParser.g:4902:1: ruleArithmetic returns [EObject current=null] : ( ( () ( (lv_left_1_0= ruleVariableId ) ) ( ( (lv_op_2_1= EqualsSign | lv_op_2_2= AsteriskEqualsSign | lv_op_2_3= SolidusEqualsSign | lv_op_2_4= PercentSignEqualsSign | lv_op_2_5= PlusSignEqualsSign | lv_op_2_6= HyphenMinusEqualsSign | lv_op_2_7= LessThanSignLessThanSignEqualsSign | lv_op_2_8= GreaterThanSignGreaterThanSignEqualsSign | lv_op_2_9= AmpersandEqualsSign | lv_op_2_10= CircumflexAccentEqualsSign | lv_op_2_11= VerticalLineEqualsSign ) ) ) ( (lv_right_3_0= ruleArithmetic ) ) ) | this_ConditionalOperator_4= ruleConditionalOperator ) ;
    public final EObject ruleArithmetic() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        Token lv_op_2_4=null;
        Token lv_op_2_5=null;
        Token lv_op_2_6=null;
        Token lv_op_2_7=null;
        Token lv_op_2_8=null;
        Token lv_op_2_9=null;
        Token lv_op_2_10=null;
        Token lv_op_2_11=null;
        EObject lv_left_1_0 = null;

        EObject lv_right_3_0 = null;

        EObject this_ConditionalOperator_4 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:4908:2: ( ( ( () ( (lv_left_1_0= ruleVariableId ) ) ( ( (lv_op_2_1= EqualsSign | lv_op_2_2= AsteriskEqualsSign | lv_op_2_3= SolidusEqualsSign | lv_op_2_4= PercentSignEqualsSign | lv_op_2_5= PlusSignEqualsSign | lv_op_2_6= HyphenMinusEqualsSign | lv_op_2_7= LessThanSignLessThanSignEqualsSign | lv_op_2_8= GreaterThanSignGreaterThanSignEqualsSign | lv_op_2_9= AmpersandEqualsSign | lv_op_2_10= CircumflexAccentEqualsSign | lv_op_2_11= VerticalLineEqualsSign ) ) ) ( (lv_right_3_0= ruleArithmetic ) ) ) | this_ConditionalOperator_4= ruleConditionalOperator ) )
            // InternalMyBashParser.g:4909:2: ( ( () ( (lv_left_1_0= ruleVariableId ) ) ( ( (lv_op_2_1= EqualsSign | lv_op_2_2= AsteriskEqualsSign | lv_op_2_3= SolidusEqualsSign | lv_op_2_4= PercentSignEqualsSign | lv_op_2_5= PlusSignEqualsSign | lv_op_2_6= HyphenMinusEqualsSign | lv_op_2_7= LessThanSignLessThanSignEqualsSign | lv_op_2_8= GreaterThanSignGreaterThanSignEqualsSign | lv_op_2_9= AmpersandEqualsSign | lv_op_2_10= CircumflexAccentEqualsSign | lv_op_2_11= VerticalLineEqualsSign ) ) ) ( (lv_right_3_0= ruleArithmetic ) ) ) | this_ConditionalOperator_4= ruleConditionalOperator )
            {
            // InternalMyBashParser.g:4909:2: ( ( () ( (lv_left_1_0= ruleVariableId ) ) ( ( (lv_op_2_1= EqualsSign | lv_op_2_2= AsteriskEqualsSign | lv_op_2_3= SolidusEqualsSign | lv_op_2_4= PercentSignEqualsSign | lv_op_2_5= PlusSignEqualsSign | lv_op_2_6= HyphenMinusEqualsSign | lv_op_2_7= LessThanSignLessThanSignEqualsSign | lv_op_2_8= GreaterThanSignGreaterThanSignEqualsSign | lv_op_2_9= AmpersandEqualsSign | lv_op_2_10= CircumflexAccentEqualsSign | lv_op_2_11= VerticalLineEqualsSign ) ) ) ( (lv_right_3_0= ruleArithmetic ) ) ) | this_ConditionalOperator_4= ruleConditionalOperator )
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==RULE_NAME) ) {
                int LA93_1 = input.LA(2);

                if ( ((LA93_1>=LessThanSignLessThanSignEqualsSign && LA93_1<=GreaterThanSignGreaterThanSignEqualsSign)||LA93_1==PercentSignEqualsSign||LA93_1==AmpersandEqualsSign||LA93_1==AsteriskEqualsSign||LA93_1==PlusSignEqualsSign||LA93_1==HyphenMinusEqualsSign||LA93_1==SolidusEqualsSign||LA93_1==CircumflexAccentEqualsSign||LA93_1==VerticalLineEqualsSign||LA93_1==EqualsSign) ) {
                    alt93=1;
                }
                else if ( (LA93_1==EOF||LA93_1==ExclamationMarkEqualsSign||LA93_1==AmpersandAmpersand||(LA93_1>=RightParenthesisRightParenthesis && LA93_1<=AsteriskAsterisk)||LA93_1==PlusSignPlusSign||LA93_1==HyphenMinusHyphenMinus||(LA93_1>=LessThanSignLessThanSign && LA93_1<=LessThanSignEqualsSign)||LA93_1==EqualsSignEqualsSign||(LA93_1>=GreaterThanSignEqualsSign && LA93_1<=GreaterThanSignGreaterThanSign)||LA93_1==VerticalLineVerticalLine||(LA93_1>=PercentSign && LA93_1<=Ampersand)||(LA93_1>=RightParenthesis && LA93_1<=LessThanSign)||(LA93_1>=GreaterThanSign && LA93_1<=QuestionMark)||(LA93_1>=RightSquareBracket && LA93_1<=CircumflexAccent)||(LA93_1>=VerticalLine && LA93_1<=RightCurlyBracket)) ) {
                    alt93=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 93, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA93_0==DollarSignLeftParenthesisLeftParenthesis||LA93_0==DollarSignLeftCurlyBracket||LA93_0==PlusSignPlusSign||LA93_0==HyphenMinusHyphenMinus||LA93_0==LessThanSignLeftParenthesis||LA93_0==GreaterThanSignLeftParenthesis||LA93_0==ExclamationMark||LA93_0==LeftParenthesis||LA93_0==PlusSign||LA93_0==HyphenMinus||(LA93_0>=Tilde && LA93_0<=RULE_I_NUMBER)||(LA93_0>=RULE_VARIABLE && LA93_0<=RULE_A_PREFIX)||LA93_0==RULE_CS_START) ) {
                alt93=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;
            }
            switch (alt93) {
                case 1 :
                    // InternalMyBashParser.g:4910:3: ( () ( (lv_left_1_0= ruleVariableId ) ) ( ( (lv_op_2_1= EqualsSign | lv_op_2_2= AsteriskEqualsSign | lv_op_2_3= SolidusEqualsSign | lv_op_2_4= PercentSignEqualsSign | lv_op_2_5= PlusSignEqualsSign | lv_op_2_6= HyphenMinusEqualsSign | lv_op_2_7= LessThanSignLessThanSignEqualsSign | lv_op_2_8= GreaterThanSignGreaterThanSignEqualsSign | lv_op_2_9= AmpersandEqualsSign | lv_op_2_10= CircumflexAccentEqualsSign | lv_op_2_11= VerticalLineEqualsSign ) ) ) ( (lv_right_3_0= ruleArithmetic ) ) )
                    {
                    // InternalMyBashParser.g:4910:3: ( () ( (lv_left_1_0= ruleVariableId ) ) ( ( (lv_op_2_1= EqualsSign | lv_op_2_2= AsteriskEqualsSign | lv_op_2_3= SolidusEqualsSign | lv_op_2_4= PercentSignEqualsSign | lv_op_2_5= PlusSignEqualsSign | lv_op_2_6= HyphenMinusEqualsSign | lv_op_2_7= LessThanSignLessThanSignEqualsSign | lv_op_2_8= GreaterThanSignGreaterThanSignEqualsSign | lv_op_2_9= AmpersandEqualsSign | lv_op_2_10= CircumflexAccentEqualsSign | lv_op_2_11= VerticalLineEqualsSign ) ) ) ( (lv_right_3_0= ruleArithmetic ) ) )
                    // InternalMyBashParser.g:4911:4: () ( (lv_left_1_0= ruleVariableId ) ) ( ( (lv_op_2_1= EqualsSign | lv_op_2_2= AsteriskEqualsSign | lv_op_2_3= SolidusEqualsSign | lv_op_2_4= PercentSignEqualsSign | lv_op_2_5= PlusSignEqualsSign | lv_op_2_6= HyphenMinusEqualsSign | lv_op_2_7= LessThanSignLessThanSignEqualsSign | lv_op_2_8= GreaterThanSignGreaterThanSignEqualsSign | lv_op_2_9= AmpersandEqualsSign | lv_op_2_10= CircumflexAccentEqualsSign | lv_op_2_11= VerticalLineEqualsSign ) ) ) ( (lv_right_3_0= ruleArithmetic ) )
                    {
                    // InternalMyBashParser.g:4911:4: ()
                    // InternalMyBashParser.g:4912:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getArithmeticAccess().getBinaryExpressionAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalMyBashParser.g:4918:4: ( (lv_left_1_0= ruleVariableId ) )
                    // InternalMyBashParser.g:4919:5: (lv_left_1_0= ruleVariableId )
                    {
                    // InternalMyBashParser.g:4919:5: (lv_left_1_0= ruleVariableId )
                    // InternalMyBashParser.g:4920:6: lv_left_1_0= ruleVariableId
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getArithmeticAccess().getLeftVariableIdParserRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_75);
                    lv_left_1_0=ruleVariableId();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getArithmeticRule());
                      						}
                      						set(
                      							current,
                      							"left",
                      							lv_left_1_0,
                      							"org.xtext.example.mydsl.MyBash.VariableId");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalMyBashParser.g:4937:4: ( ( (lv_op_2_1= EqualsSign | lv_op_2_2= AsteriskEqualsSign | lv_op_2_3= SolidusEqualsSign | lv_op_2_4= PercentSignEqualsSign | lv_op_2_5= PlusSignEqualsSign | lv_op_2_6= HyphenMinusEqualsSign | lv_op_2_7= LessThanSignLessThanSignEqualsSign | lv_op_2_8= GreaterThanSignGreaterThanSignEqualsSign | lv_op_2_9= AmpersandEqualsSign | lv_op_2_10= CircumflexAccentEqualsSign | lv_op_2_11= VerticalLineEqualsSign ) ) )
                    // InternalMyBashParser.g:4938:5: ( (lv_op_2_1= EqualsSign | lv_op_2_2= AsteriskEqualsSign | lv_op_2_3= SolidusEqualsSign | lv_op_2_4= PercentSignEqualsSign | lv_op_2_5= PlusSignEqualsSign | lv_op_2_6= HyphenMinusEqualsSign | lv_op_2_7= LessThanSignLessThanSignEqualsSign | lv_op_2_8= GreaterThanSignGreaterThanSignEqualsSign | lv_op_2_9= AmpersandEqualsSign | lv_op_2_10= CircumflexAccentEqualsSign | lv_op_2_11= VerticalLineEqualsSign ) )
                    {
                    // InternalMyBashParser.g:4938:5: ( (lv_op_2_1= EqualsSign | lv_op_2_2= AsteriskEqualsSign | lv_op_2_3= SolidusEqualsSign | lv_op_2_4= PercentSignEqualsSign | lv_op_2_5= PlusSignEqualsSign | lv_op_2_6= HyphenMinusEqualsSign | lv_op_2_7= LessThanSignLessThanSignEqualsSign | lv_op_2_8= GreaterThanSignGreaterThanSignEqualsSign | lv_op_2_9= AmpersandEqualsSign | lv_op_2_10= CircumflexAccentEqualsSign | lv_op_2_11= VerticalLineEqualsSign ) )
                    // InternalMyBashParser.g:4939:6: (lv_op_2_1= EqualsSign | lv_op_2_2= AsteriskEqualsSign | lv_op_2_3= SolidusEqualsSign | lv_op_2_4= PercentSignEqualsSign | lv_op_2_5= PlusSignEqualsSign | lv_op_2_6= HyphenMinusEqualsSign | lv_op_2_7= LessThanSignLessThanSignEqualsSign | lv_op_2_8= GreaterThanSignGreaterThanSignEqualsSign | lv_op_2_9= AmpersandEqualsSign | lv_op_2_10= CircumflexAccentEqualsSign | lv_op_2_11= VerticalLineEqualsSign )
                    {
                    // InternalMyBashParser.g:4939:6: (lv_op_2_1= EqualsSign | lv_op_2_2= AsteriskEqualsSign | lv_op_2_3= SolidusEqualsSign | lv_op_2_4= PercentSignEqualsSign | lv_op_2_5= PlusSignEqualsSign | lv_op_2_6= HyphenMinusEqualsSign | lv_op_2_7= LessThanSignLessThanSignEqualsSign | lv_op_2_8= GreaterThanSignGreaterThanSignEqualsSign | lv_op_2_9= AmpersandEqualsSign | lv_op_2_10= CircumflexAccentEqualsSign | lv_op_2_11= VerticalLineEqualsSign )
                    int alt92=11;
                    switch ( input.LA(1) ) {
                    case EqualsSign:
                        {
                        alt92=1;
                        }
                        break;
                    case AsteriskEqualsSign:
                        {
                        alt92=2;
                        }
                        break;
                    case SolidusEqualsSign:
                        {
                        alt92=3;
                        }
                        break;
                    case PercentSignEqualsSign:
                        {
                        alt92=4;
                        }
                        break;
                    case PlusSignEqualsSign:
                        {
                        alt92=5;
                        }
                        break;
                    case HyphenMinusEqualsSign:
                        {
                        alt92=6;
                        }
                        break;
                    case LessThanSignLessThanSignEqualsSign:
                        {
                        alt92=7;
                        }
                        break;
                    case GreaterThanSignGreaterThanSignEqualsSign:
                        {
                        alt92=8;
                        }
                        break;
                    case AmpersandEqualsSign:
                        {
                        alt92=9;
                        }
                        break;
                    case CircumflexAccentEqualsSign:
                        {
                        alt92=10;
                        }
                        break;
                    case VerticalLineEqualsSign:
                        {
                        alt92=11;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 92, 0, input);

                        throw nvae;
                    }

                    switch (alt92) {
                        case 1 :
                            // InternalMyBashParser.g:4940:7: lv_op_2_1= EqualsSign
                            {
                            lv_op_2_1=(Token)match(input,EqualsSign,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_2_1, grammarAccess.getArithmeticAccess().getOpEqualsSignKeyword_0_2_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getArithmeticRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_2_1, null);
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalMyBashParser.g:4951:7: lv_op_2_2= AsteriskEqualsSign
                            {
                            lv_op_2_2=(Token)match(input,AsteriskEqualsSign,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_2_2, grammarAccess.getArithmeticAccess().getOpAsteriskEqualsSignKeyword_0_2_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getArithmeticRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_2_2, null);
                              						
                            }

                            }
                            break;
                        case 3 :
                            // InternalMyBashParser.g:4962:7: lv_op_2_3= SolidusEqualsSign
                            {
                            lv_op_2_3=(Token)match(input,SolidusEqualsSign,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_2_3, grammarAccess.getArithmeticAccess().getOpSolidusEqualsSignKeyword_0_2_0_2());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getArithmeticRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_2_3, null);
                              						
                            }

                            }
                            break;
                        case 4 :
                            // InternalMyBashParser.g:4973:7: lv_op_2_4= PercentSignEqualsSign
                            {
                            lv_op_2_4=(Token)match(input,PercentSignEqualsSign,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_2_4, grammarAccess.getArithmeticAccess().getOpPercentSignEqualsSignKeyword_0_2_0_3());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getArithmeticRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_2_4, null);
                              						
                            }

                            }
                            break;
                        case 5 :
                            // InternalMyBashParser.g:4984:7: lv_op_2_5= PlusSignEqualsSign
                            {
                            lv_op_2_5=(Token)match(input,PlusSignEqualsSign,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_2_5, grammarAccess.getArithmeticAccess().getOpPlusSignEqualsSignKeyword_0_2_0_4());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getArithmeticRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_2_5, null);
                              						
                            }

                            }
                            break;
                        case 6 :
                            // InternalMyBashParser.g:4995:7: lv_op_2_6= HyphenMinusEqualsSign
                            {
                            lv_op_2_6=(Token)match(input,HyphenMinusEqualsSign,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_2_6, grammarAccess.getArithmeticAccess().getOpHyphenMinusEqualsSignKeyword_0_2_0_5());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getArithmeticRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_2_6, null);
                              						
                            }

                            }
                            break;
                        case 7 :
                            // InternalMyBashParser.g:5006:7: lv_op_2_7= LessThanSignLessThanSignEqualsSign
                            {
                            lv_op_2_7=(Token)match(input,LessThanSignLessThanSignEqualsSign,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_2_7, grammarAccess.getArithmeticAccess().getOpLessThanSignLessThanSignEqualsSignKeyword_0_2_0_6());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getArithmeticRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_2_7, null);
                              						
                            }

                            }
                            break;
                        case 8 :
                            // InternalMyBashParser.g:5017:7: lv_op_2_8= GreaterThanSignGreaterThanSignEqualsSign
                            {
                            lv_op_2_8=(Token)match(input,GreaterThanSignGreaterThanSignEqualsSign,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_2_8, grammarAccess.getArithmeticAccess().getOpGreaterThanSignGreaterThanSignEqualsSignKeyword_0_2_0_7());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getArithmeticRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_2_8, null);
                              						
                            }

                            }
                            break;
                        case 9 :
                            // InternalMyBashParser.g:5028:7: lv_op_2_9= AmpersandEqualsSign
                            {
                            lv_op_2_9=(Token)match(input,AmpersandEqualsSign,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_2_9, grammarAccess.getArithmeticAccess().getOpAmpersandEqualsSignKeyword_0_2_0_8());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getArithmeticRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_2_9, null);
                              						
                            }

                            }
                            break;
                        case 10 :
                            // InternalMyBashParser.g:5039:7: lv_op_2_10= CircumflexAccentEqualsSign
                            {
                            lv_op_2_10=(Token)match(input,CircumflexAccentEqualsSign,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_2_10, grammarAccess.getArithmeticAccess().getOpCircumflexAccentEqualsSignKeyword_0_2_0_9());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getArithmeticRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_2_10, null);
                              						
                            }

                            }
                            break;
                        case 11 :
                            // InternalMyBashParser.g:5050:7: lv_op_2_11= VerticalLineEqualsSign
                            {
                            lv_op_2_11=(Token)match(input,VerticalLineEqualsSign,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_2_11, grammarAccess.getArithmeticAccess().getOpVerticalLineEqualsSignKeyword_0_2_0_10());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getArithmeticRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_2_11, null);
                              						
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalMyBashParser.g:5063:4: ( (lv_right_3_0= ruleArithmetic ) )
                    // InternalMyBashParser.g:5064:5: (lv_right_3_0= ruleArithmetic )
                    {
                    // InternalMyBashParser.g:5064:5: (lv_right_3_0= ruleArithmetic )
                    // InternalMyBashParser.g:5065:6: lv_right_3_0= ruleArithmetic
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getArithmeticAccess().getRightArithmeticParserRuleCall_0_3_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=ruleArithmetic();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getArithmeticRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_3_0,
                      							"org.xtext.example.mydsl.MyBash.Arithmetic");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMyBashParser.g:5084:3: this_ConditionalOperator_4= ruleConditionalOperator
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getArithmeticAccess().getConditionalOperatorParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ConditionalOperator_4=ruleConditionalOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ConditionalOperator_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArithmetic"


    // $ANTLR start "entryRuleConditionalOperator"
    // InternalMyBashParser.g:5096:1: entryRuleConditionalOperator returns [EObject current=null] : iv_ruleConditionalOperator= ruleConditionalOperator EOF ;
    public final EObject entryRuleConditionalOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalOperator = null;


        try {
            // InternalMyBashParser.g:5096:60: (iv_ruleConditionalOperator= ruleConditionalOperator EOF )
            // InternalMyBashParser.g:5097:2: iv_ruleConditionalOperator= ruleConditionalOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConditionalOperatorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConditionalOperator=ruleConditionalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConditionalOperator; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConditionalOperator"


    // $ANTLR start "ruleConditionalOperator"
    // InternalMyBashParser.g:5103:1: ruleConditionalOperator returns [EObject current=null] : (this_LogicOr_0= ruleLogicOr (otherlv_1= QuestionMark () ( (lv_first_3_0= ruleConditionalOperator ) ) otherlv_4= Colon ( (lv_right_5_0= ruleConditionalOperator ) ) )? ) ;
    public final EObject ruleConditionalOperator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject this_LogicOr_0 = null;

        EObject lv_first_3_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:5109:2: ( (this_LogicOr_0= ruleLogicOr (otherlv_1= QuestionMark () ( (lv_first_3_0= ruleConditionalOperator ) ) otherlv_4= Colon ( (lv_right_5_0= ruleConditionalOperator ) ) )? ) )
            // InternalMyBashParser.g:5110:2: (this_LogicOr_0= ruleLogicOr (otherlv_1= QuestionMark () ( (lv_first_3_0= ruleConditionalOperator ) ) otherlv_4= Colon ( (lv_right_5_0= ruleConditionalOperator ) ) )? )
            {
            // InternalMyBashParser.g:5110:2: (this_LogicOr_0= ruleLogicOr (otherlv_1= QuestionMark () ( (lv_first_3_0= ruleConditionalOperator ) ) otherlv_4= Colon ( (lv_right_5_0= ruleConditionalOperator ) ) )? )
            // InternalMyBashParser.g:5111:3: this_LogicOr_0= ruleLogicOr (otherlv_1= QuestionMark () ( (lv_first_3_0= ruleConditionalOperator ) ) otherlv_4= Colon ( (lv_right_5_0= ruleConditionalOperator ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getConditionalOperatorAccess().getLogicOrParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_76);
            this_LogicOr_0=ruleLogicOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_LogicOr_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMyBashParser.g:5119:3: (otherlv_1= QuestionMark () ( (lv_first_3_0= ruleConditionalOperator ) ) otherlv_4= Colon ( (lv_right_5_0= ruleConditionalOperator ) ) )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==QuestionMark) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // InternalMyBashParser.g:5120:4: otherlv_1= QuestionMark () ( (lv_first_3_0= ruleConditionalOperator ) ) otherlv_4= Colon ( (lv_right_5_0= ruleConditionalOperator ) )
                    {
                    otherlv_1=(Token)match(input,QuestionMark,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getConditionalOperatorAccess().getQuestionMarkKeyword_1_0());
                      			
                    }
                    // InternalMyBashParser.g:5124:4: ()
                    // InternalMyBashParser.g:5125:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getConditionalOperatorAccess().getConditionalOperatorConditionAction_1_1(),
                      						current);
                      				
                    }

                    }

                    // InternalMyBashParser.g:5131:4: ( (lv_first_3_0= ruleConditionalOperator ) )
                    // InternalMyBashParser.g:5132:5: (lv_first_3_0= ruleConditionalOperator )
                    {
                    // InternalMyBashParser.g:5132:5: (lv_first_3_0= ruleConditionalOperator )
                    // InternalMyBashParser.g:5133:6: lv_first_3_0= ruleConditionalOperator
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getConditionalOperatorAccess().getFirstConditionalOperatorParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_72);
                    lv_first_3_0=ruleConditionalOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getConditionalOperatorRule());
                      						}
                      						set(
                      							current,
                      							"first",
                      							lv_first_3_0,
                      							"org.xtext.example.mydsl.MyBash.ConditionalOperator");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,Colon,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getConditionalOperatorAccess().getColonKeyword_1_3());
                      			
                    }
                    // InternalMyBashParser.g:5154:4: ( (lv_right_5_0= ruleConditionalOperator ) )
                    // InternalMyBashParser.g:5155:5: (lv_right_5_0= ruleConditionalOperator )
                    {
                    // InternalMyBashParser.g:5155:5: (lv_right_5_0= ruleConditionalOperator )
                    // InternalMyBashParser.g:5156:6: lv_right_5_0= ruleConditionalOperator
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getConditionalOperatorAccess().getRightConditionalOperatorParserRuleCall_1_4_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_5_0=ruleConditionalOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getConditionalOperatorRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_5_0,
                      							"org.xtext.example.mydsl.MyBash.ConditionalOperator");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConditionalOperator"


    // $ANTLR start "entryRuleLogicOr"
    // InternalMyBashParser.g:5178:1: entryRuleLogicOr returns [EObject current=null] : iv_ruleLogicOr= ruleLogicOr EOF ;
    public final EObject entryRuleLogicOr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicOr = null;


        try {
            // InternalMyBashParser.g:5178:48: (iv_ruleLogicOr= ruleLogicOr EOF )
            // InternalMyBashParser.g:5179:2: iv_ruleLogicOr= ruleLogicOr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicOrRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLogicOr=ruleLogicOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicOr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogicOr"


    // $ANTLR start "ruleLogicOr"
    // InternalMyBashParser.g:5185:1: ruleLogicOr returns [EObject current=null] : (this_LogicAnd_0= ruleLogicAnd ( () ( (lv_op_2_0= VerticalLineVerticalLine ) ) ( (lv_right_3_0= ruleLogicAnd ) ) )* ) ;
    public final EObject ruleLogicOr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_LogicAnd_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:5191:2: ( (this_LogicAnd_0= ruleLogicAnd ( () ( (lv_op_2_0= VerticalLineVerticalLine ) ) ( (lv_right_3_0= ruleLogicAnd ) ) )* ) )
            // InternalMyBashParser.g:5192:2: (this_LogicAnd_0= ruleLogicAnd ( () ( (lv_op_2_0= VerticalLineVerticalLine ) ) ( (lv_right_3_0= ruleLogicAnd ) ) )* )
            {
            // InternalMyBashParser.g:5192:2: (this_LogicAnd_0= ruleLogicAnd ( () ( (lv_op_2_0= VerticalLineVerticalLine ) ) ( (lv_right_3_0= ruleLogicAnd ) ) )* )
            // InternalMyBashParser.g:5193:3: this_LogicAnd_0= ruleLogicAnd ( () ( (lv_op_2_0= VerticalLineVerticalLine ) ) ( (lv_right_3_0= ruleLogicAnd ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLogicOrAccess().getLogicAndParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_77);
            this_LogicAnd_0=ruleLogicAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_LogicAnd_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMyBashParser.g:5201:3: ( () ( (lv_op_2_0= VerticalLineVerticalLine ) ) ( (lv_right_3_0= ruleLogicAnd ) ) )*
            loop95:
            do {
                int alt95=2;
                int LA95_0 = input.LA(1);

                if ( (LA95_0==VerticalLineVerticalLine) ) {
                    alt95=1;
                }


                switch (alt95) {
            	case 1 :
            	    // InternalMyBashParser.g:5202:4: () ( (lv_op_2_0= VerticalLineVerticalLine ) ) ( (lv_right_3_0= ruleLogicAnd ) )
            	    {
            	    // InternalMyBashParser.g:5202:4: ()
            	    // InternalMyBashParser.g:5203:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getLogicOrAccess().getBinaryExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalMyBashParser.g:5209:4: ( (lv_op_2_0= VerticalLineVerticalLine ) )
            	    // InternalMyBashParser.g:5210:5: (lv_op_2_0= VerticalLineVerticalLine )
            	    {
            	    // InternalMyBashParser.g:5210:5: (lv_op_2_0= VerticalLineVerticalLine )
            	    // InternalMyBashParser.g:5211:6: lv_op_2_0= VerticalLineVerticalLine
            	    {
            	    lv_op_2_0=(Token)match(input,VerticalLineVerticalLine,FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(lv_op_2_0, grammarAccess.getLogicOrAccess().getOpVerticalLineVerticalLineKeyword_1_1_0());
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getLogicOrRule());
            	      						}
            	      						setWithLastConsumed(current, "op", lv_op_2_0, "||");
            	      					
            	    }

            	    }


            	    }

            	    // InternalMyBashParser.g:5223:4: ( (lv_right_3_0= ruleLogicAnd ) )
            	    // InternalMyBashParser.g:5224:5: (lv_right_3_0= ruleLogicAnd )
            	    {
            	    // InternalMyBashParser.g:5224:5: (lv_right_3_0= ruleLogicAnd )
            	    // InternalMyBashParser.g:5225:6: lv_right_3_0= ruleLogicAnd
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLogicOrAccess().getRightLogicAndParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_77);
            	    lv_right_3_0=ruleLogicAnd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getLogicOrRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.xtext.example.mydsl.MyBash.LogicAnd");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop95;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogicOr"


    // $ANTLR start "entryRuleLogicAnd"
    // InternalMyBashParser.g:5247:1: entryRuleLogicAnd returns [EObject current=null] : iv_ruleLogicAnd= ruleLogicAnd EOF ;
    public final EObject entryRuleLogicAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicAnd = null;


        try {
            // InternalMyBashParser.g:5247:49: (iv_ruleLogicAnd= ruleLogicAnd EOF )
            // InternalMyBashParser.g:5248:2: iv_ruleLogicAnd= ruleLogicAnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicAndRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLogicAnd=ruleLogicAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicAnd; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogicAnd"


    // $ANTLR start "ruleLogicAnd"
    // InternalMyBashParser.g:5254:1: ruleLogicAnd returns [EObject current=null] : (this_BitwiseOR_0= ruleBitwiseOR ( () ( (lv_op_2_0= AmpersandAmpersand ) ) ( (lv_right_3_0= ruleBitwiseOR ) ) )* ) ;
    public final EObject ruleLogicAnd() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_BitwiseOR_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:5260:2: ( (this_BitwiseOR_0= ruleBitwiseOR ( () ( (lv_op_2_0= AmpersandAmpersand ) ) ( (lv_right_3_0= ruleBitwiseOR ) ) )* ) )
            // InternalMyBashParser.g:5261:2: (this_BitwiseOR_0= ruleBitwiseOR ( () ( (lv_op_2_0= AmpersandAmpersand ) ) ( (lv_right_3_0= ruleBitwiseOR ) ) )* )
            {
            // InternalMyBashParser.g:5261:2: (this_BitwiseOR_0= ruleBitwiseOR ( () ( (lv_op_2_0= AmpersandAmpersand ) ) ( (lv_right_3_0= ruleBitwiseOR ) ) )* )
            // InternalMyBashParser.g:5262:3: this_BitwiseOR_0= ruleBitwiseOR ( () ( (lv_op_2_0= AmpersandAmpersand ) ) ( (lv_right_3_0= ruleBitwiseOR ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLogicAndAccess().getBitwiseORParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_78);
            this_BitwiseOR_0=ruleBitwiseOR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_BitwiseOR_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMyBashParser.g:5270:3: ( () ( (lv_op_2_0= AmpersandAmpersand ) ) ( (lv_right_3_0= ruleBitwiseOR ) ) )*
            loop96:
            do {
                int alt96=2;
                int LA96_0 = input.LA(1);

                if ( (LA96_0==AmpersandAmpersand) ) {
                    alt96=1;
                }


                switch (alt96) {
            	case 1 :
            	    // InternalMyBashParser.g:5271:4: () ( (lv_op_2_0= AmpersandAmpersand ) ) ( (lv_right_3_0= ruleBitwiseOR ) )
            	    {
            	    // InternalMyBashParser.g:5271:4: ()
            	    // InternalMyBashParser.g:5272:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getLogicAndAccess().getBinaryExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalMyBashParser.g:5278:4: ( (lv_op_2_0= AmpersandAmpersand ) )
            	    // InternalMyBashParser.g:5279:5: (lv_op_2_0= AmpersandAmpersand )
            	    {
            	    // InternalMyBashParser.g:5279:5: (lv_op_2_0= AmpersandAmpersand )
            	    // InternalMyBashParser.g:5280:6: lv_op_2_0= AmpersandAmpersand
            	    {
            	    lv_op_2_0=(Token)match(input,AmpersandAmpersand,FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(lv_op_2_0, grammarAccess.getLogicAndAccess().getOpAmpersandAmpersandKeyword_1_1_0());
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getLogicAndRule());
            	      						}
            	      						setWithLastConsumed(current, "op", lv_op_2_0, "&&");
            	      					
            	    }

            	    }


            	    }

            	    // InternalMyBashParser.g:5292:4: ( (lv_right_3_0= ruleBitwiseOR ) )
            	    // InternalMyBashParser.g:5293:5: (lv_right_3_0= ruleBitwiseOR )
            	    {
            	    // InternalMyBashParser.g:5293:5: (lv_right_3_0= ruleBitwiseOR )
            	    // InternalMyBashParser.g:5294:6: lv_right_3_0= ruleBitwiseOR
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLogicAndAccess().getRightBitwiseORParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_78);
            	    lv_right_3_0=ruleBitwiseOR();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getLogicAndRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.xtext.example.mydsl.MyBash.BitwiseOR");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop96;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogicAnd"


    // $ANTLR start "entryRuleBitwiseOR"
    // InternalMyBashParser.g:5316:1: entryRuleBitwiseOR returns [EObject current=null] : iv_ruleBitwiseOR= ruleBitwiseOR EOF ;
    public final EObject entryRuleBitwiseOR() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitwiseOR = null;


        try {
            // InternalMyBashParser.g:5316:50: (iv_ruleBitwiseOR= ruleBitwiseOR EOF )
            // InternalMyBashParser.g:5317:2: iv_ruleBitwiseOR= ruleBitwiseOR EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitwiseORRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBitwiseOR=ruleBitwiseOR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitwiseOR; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitwiseOR"


    // $ANTLR start "ruleBitwiseOR"
    // InternalMyBashParser.g:5323:1: ruleBitwiseOR returns [EObject current=null] : (this_BitwiseExclusiveOR_0= ruleBitwiseExclusiveOR ( () ( (lv_op_2_0= VerticalLine ) ) ( (lv_right_3_0= ruleBitwiseExclusiveOR ) ) )* ) ;
    public final EObject ruleBitwiseOR() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_BitwiseExclusiveOR_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:5329:2: ( (this_BitwiseExclusiveOR_0= ruleBitwiseExclusiveOR ( () ( (lv_op_2_0= VerticalLine ) ) ( (lv_right_3_0= ruleBitwiseExclusiveOR ) ) )* ) )
            // InternalMyBashParser.g:5330:2: (this_BitwiseExclusiveOR_0= ruleBitwiseExclusiveOR ( () ( (lv_op_2_0= VerticalLine ) ) ( (lv_right_3_0= ruleBitwiseExclusiveOR ) ) )* )
            {
            // InternalMyBashParser.g:5330:2: (this_BitwiseExclusiveOR_0= ruleBitwiseExclusiveOR ( () ( (lv_op_2_0= VerticalLine ) ) ( (lv_right_3_0= ruleBitwiseExclusiveOR ) ) )* )
            // InternalMyBashParser.g:5331:3: this_BitwiseExclusiveOR_0= ruleBitwiseExclusiveOR ( () ( (lv_op_2_0= VerticalLine ) ) ( (lv_right_3_0= ruleBitwiseExclusiveOR ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBitwiseORAccess().getBitwiseExclusiveORParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_31);
            this_BitwiseExclusiveOR_0=ruleBitwiseExclusiveOR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_BitwiseExclusiveOR_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMyBashParser.g:5339:3: ( () ( (lv_op_2_0= VerticalLine ) ) ( (lv_right_3_0= ruleBitwiseExclusiveOR ) ) )*
            loop97:
            do {
                int alt97=2;
                int LA97_0 = input.LA(1);

                if ( (LA97_0==VerticalLine) ) {
                    alt97=1;
                }


                switch (alt97) {
            	case 1 :
            	    // InternalMyBashParser.g:5340:4: () ( (lv_op_2_0= VerticalLine ) ) ( (lv_right_3_0= ruleBitwiseExclusiveOR ) )
            	    {
            	    // InternalMyBashParser.g:5340:4: ()
            	    // InternalMyBashParser.g:5341:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getBitwiseORAccess().getBinaryExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalMyBashParser.g:5347:4: ( (lv_op_2_0= VerticalLine ) )
            	    // InternalMyBashParser.g:5348:5: (lv_op_2_0= VerticalLine )
            	    {
            	    // InternalMyBashParser.g:5348:5: (lv_op_2_0= VerticalLine )
            	    // InternalMyBashParser.g:5349:6: lv_op_2_0= VerticalLine
            	    {
            	    lv_op_2_0=(Token)match(input,VerticalLine,FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(lv_op_2_0, grammarAccess.getBitwiseORAccess().getOpVerticalLineKeyword_1_1_0());
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getBitwiseORRule());
            	      						}
            	      						setWithLastConsumed(current, "op", lv_op_2_0, "|");
            	      					
            	    }

            	    }


            	    }

            	    // InternalMyBashParser.g:5361:4: ( (lv_right_3_0= ruleBitwiseExclusiveOR ) )
            	    // InternalMyBashParser.g:5362:5: (lv_right_3_0= ruleBitwiseExclusiveOR )
            	    {
            	    // InternalMyBashParser.g:5362:5: (lv_right_3_0= ruleBitwiseExclusiveOR )
            	    // InternalMyBashParser.g:5363:6: lv_right_3_0= ruleBitwiseExclusiveOR
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBitwiseORAccess().getRightBitwiseExclusiveORParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_31);
            	    lv_right_3_0=ruleBitwiseExclusiveOR();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBitwiseORRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.xtext.example.mydsl.MyBash.BitwiseExclusiveOR");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop97;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitwiseOR"


    // $ANTLR start "entryRuleBitwiseExclusiveOR"
    // InternalMyBashParser.g:5385:1: entryRuleBitwiseExclusiveOR returns [EObject current=null] : iv_ruleBitwiseExclusiveOR= ruleBitwiseExclusiveOR EOF ;
    public final EObject entryRuleBitwiseExclusiveOR() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitwiseExclusiveOR = null;


        try {
            // InternalMyBashParser.g:5385:59: (iv_ruleBitwiseExclusiveOR= ruleBitwiseExclusiveOR EOF )
            // InternalMyBashParser.g:5386:2: iv_ruleBitwiseExclusiveOR= ruleBitwiseExclusiveOR EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitwiseExclusiveORRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBitwiseExclusiveOR=ruleBitwiseExclusiveOR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitwiseExclusiveOR; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitwiseExclusiveOR"


    // $ANTLR start "ruleBitwiseExclusiveOR"
    // InternalMyBashParser.g:5392:1: ruleBitwiseExclusiveOR returns [EObject current=null] : (this_BitwiseAND_0= ruleBitwiseAND ( () ( (lv_op_2_0= CircumflexAccent ) ) ( (lv_right_3_0= ruleBitwiseAND ) ) )* ) ;
    public final EObject ruleBitwiseExclusiveOR() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_BitwiseAND_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:5398:2: ( (this_BitwiseAND_0= ruleBitwiseAND ( () ( (lv_op_2_0= CircumflexAccent ) ) ( (lv_right_3_0= ruleBitwiseAND ) ) )* ) )
            // InternalMyBashParser.g:5399:2: (this_BitwiseAND_0= ruleBitwiseAND ( () ( (lv_op_2_0= CircumflexAccent ) ) ( (lv_right_3_0= ruleBitwiseAND ) ) )* )
            {
            // InternalMyBashParser.g:5399:2: (this_BitwiseAND_0= ruleBitwiseAND ( () ( (lv_op_2_0= CircumflexAccent ) ) ( (lv_right_3_0= ruleBitwiseAND ) ) )* )
            // InternalMyBashParser.g:5400:3: this_BitwiseAND_0= ruleBitwiseAND ( () ( (lv_op_2_0= CircumflexAccent ) ) ( (lv_right_3_0= ruleBitwiseAND ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBitwiseExclusiveORAccess().getBitwiseANDParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_79);
            this_BitwiseAND_0=ruleBitwiseAND();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_BitwiseAND_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMyBashParser.g:5408:3: ( () ( (lv_op_2_0= CircumflexAccent ) ) ( (lv_right_3_0= ruleBitwiseAND ) ) )*
            loop98:
            do {
                int alt98=2;
                int LA98_0 = input.LA(1);

                if ( (LA98_0==CircumflexAccent) ) {
                    alt98=1;
                }


                switch (alt98) {
            	case 1 :
            	    // InternalMyBashParser.g:5409:4: () ( (lv_op_2_0= CircumflexAccent ) ) ( (lv_right_3_0= ruleBitwiseAND ) )
            	    {
            	    // InternalMyBashParser.g:5409:4: ()
            	    // InternalMyBashParser.g:5410:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getBitwiseExclusiveORAccess().getBinaryExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalMyBashParser.g:5416:4: ( (lv_op_2_0= CircumflexAccent ) )
            	    // InternalMyBashParser.g:5417:5: (lv_op_2_0= CircumflexAccent )
            	    {
            	    // InternalMyBashParser.g:5417:5: (lv_op_2_0= CircumflexAccent )
            	    // InternalMyBashParser.g:5418:6: lv_op_2_0= CircumflexAccent
            	    {
            	    lv_op_2_0=(Token)match(input,CircumflexAccent,FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(lv_op_2_0, grammarAccess.getBitwiseExclusiveORAccess().getOpCircumflexAccentKeyword_1_1_0());
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getBitwiseExclusiveORRule());
            	      						}
            	      						setWithLastConsumed(current, "op", lv_op_2_0, "^");
            	      					
            	    }

            	    }


            	    }

            	    // InternalMyBashParser.g:5430:4: ( (lv_right_3_0= ruleBitwiseAND ) )
            	    // InternalMyBashParser.g:5431:5: (lv_right_3_0= ruleBitwiseAND )
            	    {
            	    // InternalMyBashParser.g:5431:5: (lv_right_3_0= ruleBitwiseAND )
            	    // InternalMyBashParser.g:5432:6: lv_right_3_0= ruleBitwiseAND
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBitwiseExclusiveORAccess().getRightBitwiseANDParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_79);
            	    lv_right_3_0=ruleBitwiseAND();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBitwiseExclusiveORRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.xtext.example.mydsl.MyBash.BitwiseAND");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop98;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitwiseExclusiveOR"


    // $ANTLR start "entryRuleBitwiseAND"
    // InternalMyBashParser.g:5454:1: entryRuleBitwiseAND returns [EObject current=null] : iv_ruleBitwiseAND= ruleBitwiseAND EOF ;
    public final EObject entryRuleBitwiseAND() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitwiseAND = null;


        try {
            // InternalMyBashParser.g:5454:51: (iv_ruleBitwiseAND= ruleBitwiseAND EOF )
            // InternalMyBashParser.g:5455:2: iv_ruleBitwiseAND= ruleBitwiseAND EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitwiseANDRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBitwiseAND=ruleBitwiseAND();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitwiseAND; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitwiseAND"


    // $ANTLR start "ruleBitwiseAND"
    // InternalMyBashParser.g:5461:1: ruleBitwiseAND returns [EObject current=null] : (this_EqualityAndInequality_0= ruleEqualityAndInequality ( () ( (lv_op_2_0= Ampersand ) ) ( (lv_right_3_0= ruleEqualityAndInequality ) ) )* ) ;
    public final EObject ruleBitwiseAND() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_EqualityAndInequality_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:5467:2: ( (this_EqualityAndInequality_0= ruleEqualityAndInequality ( () ( (lv_op_2_0= Ampersand ) ) ( (lv_right_3_0= ruleEqualityAndInequality ) ) )* ) )
            // InternalMyBashParser.g:5468:2: (this_EqualityAndInequality_0= ruleEqualityAndInequality ( () ( (lv_op_2_0= Ampersand ) ) ( (lv_right_3_0= ruleEqualityAndInequality ) ) )* )
            {
            // InternalMyBashParser.g:5468:2: (this_EqualityAndInequality_0= ruleEqualityAndInequality ( () ( (lv_op_2_0= Ampersand ) ) ( (lv_right_3_0= ruleEqualityAndInequality ) ) )* )
            // InternalMyBashParser.g:5469:3: this_EqualityAndInequality_0= ruleEqualityAndInequality ( () ( (lv_op_2_0= Ampersand ) ) ( (lv_right_3_0= ruleEqualityAndInequality ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBitwiseANDAccess().getEqualityAndInequalityParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_80);
            this_EqualityAndInequality_0=ruleEqualityAndInequality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_EqualityAndInequality_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMyBashParser.g:5477:3: ( () ( (lv_op_2_0= Ampersand ) ) ( (lv_right_3_0= ruleEqualityAndInequality ) ) )*
            loop99:
            do {
                int alt99=2;
                int LA99_0 = input.LA(1);

                if ( (LA99_0==Ampersand) ) {
                    alt99=1;
                }


                switch (alt99) {
            	case 1 :
            	    // InternalMyBashParser.g:5478:4: () ( (lv_op_2_0= Ampersand ) ) ( (lv_right_3_0= ruleEqualityAndInequality ) )
            	    {
            	    // InternalMyBashParser.g:5478:4: ()
            	    // InternalMyBashParser.g:5479:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getBitwiseANDAccess().getBinaryExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalMyBashParser.g:5485:4: ( (lv_op_2_0= Ampersand ) )
            	    // InternalMyBashParser.g:5486:5: (lv_op_2_0= Ampersand )
            	    {
            	    // InternalMyBashParser.g:5486:5: (lv_op_2_0= Ampersand )
            	    // InternalMyBashParser.g:5487:6: lv_op_2_0= Ampersand
            	    {
            	    lv_op_2_0=(Token)match(input,Ampersand,FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(lv_op_2_0, grammarAccess.getBitwiseANDAccess().getOpAmpersandKeyword_1_1_0());
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getBitwiseANDRule());
            	      						}
            	      						setWithLastConsumed(current, "op", lv_op_2_0, "&");
            	      					
            	    }

            	    }


            	    }

            	    // InternalMyBashParser.g:5499:4: ( (lv_right_3_0= ruleEqualityAndInequality ) )
            	    // InternalMyBashParser.g:5500:5: (lv_right_3_0= ruleEqualityAndInequality )
            	    {
            	    // InternalMyBashParser.g:5500:5: (lv_right_3_0= ruleEqualityAndInequality )
            	    // InternalMyBashParser.g:5501:6: lv_right_3_0= ruleEqualityAndInequality
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBitwiseANDAccess().getRightEqualityAndInequalityParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_80);
            	    lv_right_3_0=ruleEqualityAndInequality();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBitwiseANDRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.xtext.example.mydsl.MyBash.EqualityAndInequality");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop99;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitwiseAND"


    // $ANTLR start "entryRuleEqualityAndInequality"
    // InternalMyBashParser.g:5523:1: entryRuleEqualityAndInequality returns [EObject current=null] : iv_ruleEqualityAndInequality= ruleEqualityAndInequality EOF ;
    public final EObject entryRuleEqualityAndInequality() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityAndInequality = null;


        try {
            // InternalMyBashParser.g:5523:62: (iv_ruleEqualityAndInequality= ruleEqualityAndInequality EOF )
            // InternalMyBashParser.g:5524:2: iv_ruleEqualityAndInequality= ruleEqualityAndInequality EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityAndInequalityRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEqualityAndInequality=ruleEqualityAndInequality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityAndInequality; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEqualityAndInequality"


    // $ANTLR start "ruleEqualityAndInequality"
    // InternalMyBashParser.g:5530:1: ruleEqualityAndInequality returns [EObject current=null] : (this_Comparison_0= ruleComparison ( () ( ( (lv_op_2_1= EqualsSignEqualsSign | lv_op_2_2= ExclamationMarkEqualsSign ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* ) ;
    public final EObject ruleEqualityAndInequality() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_Comparison_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:5536:2: ( (this_Comparison_0= ruleComparison ( () ( ( (lv_op_2_1= EqualsSignEqualsSign | lv_op_2_2= ExclamationMarkEqualsSign ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* ) )
            // InternalMyBashParser.g:5537:2: (this_Comparison_0= ruleComparison ( () ( ( (lv_op_2_1= EqualsSignEqualsSign | lv_op_2_2= ExclamationMarkEqualsSign ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* )
            {
            // InternalMyBashParser.g:5537:2: (this_Comparison_0= ruleComparison ( () ( ( (lv_op_2_1= EqualsSignEqualsSign | lv_op_2_2= ExclamationMarkEqualsSign ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* )
            // InternalMyBashParser.g:5538:3: this_Comparison_0= ruleComparison ( () ( ( (lv_op_2_1= EqualsSignEqualsSign | lv_op_2_2= ExclamationMarkEqualsSign ) ) ) ( (lv_right_3_0= ruleComparison ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getEqualityAndInequalityAccess().getComparisonParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_81);
            this_Comparison_0=ruleComparison();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Comparison_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMyBashParser.g:5546:3: ( () ( ( (lv_op_2_1= EqualsSignEqualsSign | lv_op_2_2= ExclamationMarkEqualsSign ) ) ) ( (lv_right_3_0= ruleComparison ) ) )*
            loop101:
            do {
                int alt101=2;
                int LA101_0 = input.LA(1);

                if ( (LA101_0==ExclamationMarkEqualsSign||LA101_0==EqualsSignEqualsSign) ) {
                    alt101=1;
                }


                switch (alt101) {
            	case 1 :
            	    // InternalMyBashParser.g:5547:4: () ( ( (lv_op_2_1= EqualsSignEqualsSign | lv_op_2_2= ExclamationMarkEqualsSign ) ) ) ( (lv_right_3_0= ruleComparison ) )
            	    {
            	    // InternalMyBashParser.g:5547:4: ()
            	    // InternalMyBashParser.g:5548:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getEqualityAndInequalityAccess().getBinaryExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalMyBashParser.g:5554:4: ( ( (lv_op_2_1= EqualsSignEqualsSign | lv_op_2_2= ExclamationMarkEqualsSign ) ) )
            	    // InternalMyBashParser.g:5555:5: ( (lv_op_2_1= EqualsSignEqualsSign | lv_op_2_2= ExclamationMarkEqualsSign ) )
            	    {
            	    // InternalMyBashParser.g:5555:5: ( (lv_op_2_1= EqualsSignEqualsSign | lv_op_2_2= ExclamationMarkEqualsSign ) )
            	    // InternalMyBashParser.g:5556:6: (lv_op_2_1= EqualsSignEqualsSign | lv_op_2_2= ExclamationMarkEqualsSign )
            	    {
            	    // InternalMyBashParser.g:5556:6: (lv_op_2_1= EqualsSignEqualsSign | lv_op_2_2= ExclamationMarkEqualsSign )
            	    int alt100=2;
            	    int LA100_0 = input.LA(1);

            	    if ( (LA100_0==EqualsSignEqualsSign) ) {
            	        alt100=1;
            	    }
            	    else if ( (LA100_0==ExclamationMarkEqualsSign) ) {
            	        alt100=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 100, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt100) {
            	        case 1 :
            	            // InternalMyBashParser.g:5557:7: lv_op_2_1= EqualsSignEqualsSign
            	            {
            	            lv_op_2_1=(Token)match(input,EqualsSignEqualsSign,FOLLOW_19); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_1, grammarAccess.getEqualityAndInequalityAccess().getOpEqualsSignEqualsSignKeyword_1_1_0_0());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getEqualityAndInequalityRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalMyBashParser.g:5568:7: lv_op_2_2= ExclamationMarkEqualsSign
            	            {
            	            lv_op_2_2=(Token)match(input,ExclamationMarkEqualsSign,FOLLOW_19); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_2, grammarAccess.getEqualityAndInequalityAccess().getOpExclamationMarkEqualsSignKeyword_1_1_0_1());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getEqualityAndInequalityRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalMyBashParser.g:5581:4: ( (lv_right_3_0= ruleComparison ) )
            	    // InternalMyBashParser.g:5582:5: (lv_right_3_0= ruleComparison )
            	    {
            	    // InternalMyBashParser.g:5582:5: (lv_right_3_0= ruleComparison )
            	    // InternalMyBashParser.g:5583:6: lv_right_3_0= ruleComparison
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEqualityAndInequalityAccess().getRightComparisonParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_81);
            	    lv_right_3_0=ruleComparison();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getEqualityAndInequalityRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.xtext.example.mydsl.MyBash.Comparison");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop101;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEqualityAndInequality"


    // $ANTLR start "entryRuleComparison"
    // InternalMyBashParser.g:5605:1: entryRuleComparison returns [EObject current=null] : iv_ruleComparison= ruleComparison EOF ;
    public final EObject entryRuleComparison() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparison = null;


        try {
            // InternalMyBashParser.g:5605:51: (iv_ruleComparison= ruleComparison EOF )
            // InternalMyBashParser.g:5606:2: iv_ruleComparison= ruleComparison EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComparisonRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleComparison=ruleComparison();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComparison; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComparison"


    // $ANTLR start "ruleComparison"
    // InternalMyBashParser.g:5612:1: ruleComparison returns [EObject current=null] : (this_BitwiseShifts_0= ruleBitwiseShifts ( () ( ( (lv_op_2_1= LessThanSignEqualsSign | lv_op_2_2= GreaterThanSignEqualsSign | lv_op_2_3= LessThanSign | lv_op_2_4= GreaterThanSign ) ) ) ( (lv_right_3_0= ruleBitwiseShifts ) ) )* ) ;
    public final EObject ruleComparison() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        Token lv_op_2_4=null;
        EObject this_BitwiseShifts_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:5618:2: ( (this_BitwiseShifts_0= ruleBitwiseShifts ( () ( ( (lv_op_2_1= LessThanSignEqualsSign | lv_op_2_2= GreaterThanSignEqualsSign | lv_op_2_3= LessThanSign | lv_op_2_4= GreaterThanSign ) ) ) ( (lv_right_3_0= ruleBitwiseShifts ) ) )* ) )
            // InternalMyBashParser.g:5619:2: (this_BitwiseShifts_0= ruleBitwiseShifts ( () ( ( (lv_op_2_1= LessThanSignEqualsSign | lv_op_2_2= GreaterThanSignEqualsSign | lv_op_2_3= LessThanSign | lv_op_2_4= GreaterThanSign ) ) ) ( (lv_right_3_0= ruleBitwiseShifts ) ) )* )
            {
            // InternalMyBashParser.g:5619:2: (this_BitwiseShifts_0= ruleBitwiseShifts ( () ( ( (lv_op_2_1= LessThanSignEqualsSign | lv_op_2_2= GreaterThanSignEqualsSign | lv_op_2_3= LessThanSign | lv_op_2_4= GreaterThanSign ) ) ) ( (lv_right_3_0= ruleBitwiseShifts ) ) )* )
            // InternalMyBashParser.g:5620:3: this_BitwiseShifts_0= ruleBitwiseShifts ( () ( ( (lv_op_2_1= LessThanSignEqualsSign | lv_op_2_2= GreaterThanSignEqualsSign | lv_op_2_3= LessThanSign | lv_op_2_4= GreaterThanSign ) ) ) ( (lv_right_3_0= ruleBitwiseShifts ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getComparisonAccess().getBitwiseShiftsParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_82);
            this_BitwiseShifts_0=ruleBitwiseShifts();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_BitwiseShifts_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMyBashParser.g:5628:3: ( () ( ( (lv_op_2_1= LessThanSignEqualsSign | lv_op_2_2= GreaterThanSignEqualsSign | lv_op_2_3= LessThanSign | lv_op_2_4= GreaterThanSign ) ) ) ( (lv_right_3_0= ruleBitwiseShifts ) ) )*
            loop103:
            do {
                int alt103=2;
                int LA103_0 = input.LA(1);

                if ( (LA103_0==LessThanSignEqualsSign||LA103_0==GreaterThanSignEqualsSign||LA103_0==LessThanSign||LA103_0==GreaterThanSign) ) {
                    alt103=1;
                }


                switch (alt103) {
            	case 1 :
            	    // InternalMyBashParser.g:5629:4: () ( ( (lv_op_2_1= LessThanSignEqualsSign | lv_op_2_2= GreaterThanSignEqualsSign | lv_op_2_3= LessThanSign | lv_op_2_4= GreaterThanSign ) ) ) ( (lv_right_3_0= ruleBitwiseShifts ) )
            	    {
            	    // InternalMyBashParser.g:5629:4: ()
            	    // InternalMyBashParser.g:5630:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getComparisonAccess().getBinaryExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalMyBashParser.g:5636:4: ( ( (lv_op_2_1= LessThanSignEqualsSign | lv_op_2_2= GreaterThanSignEqualsSign | lv_op_2_3= LessThanSign | lv_op_2_4= GreaterThanSign ) ) )
            	    // InternalMyBashParser.g:5637:5: ( (lv_op_2_1= LessThanSignEqualsSign | lv_op_2_2= GreaterThanSignEqualsSign | lv_op_2_3= LessThanSign | lv_op_2_4= GreaterThanSign ) )
            	    {
            	    // InternalMyBashParser.g:5637:5: ( (lv_op_2_1= LessThanSignEqualsSign | lv_op_2_2= GreaterThanSignEqualsSign | lv_op_2_3= LessThanSign | lv_op_2_4= GreaterThanSign ) )
            	    // InternalMyBashParser.g:5638:6: (lv_op_2_1= LessThanSignEqualsSign | lv_op_2_2= GreaterThanSignEqualsSign | lv_op_2_3= LessThanSign | lv_op_2_4= GreaterThanSign )
            	    {
            	    // InternalMyBashParser.g:5638:6: (lv_op_2_1= LessThanSignEqualsSign | lv_op_2_2= GreaterThanSignEqualsSign | lv_op_2_3= LessThanSign | lv_op_2_4= GreaterThanSign )
            	    int alt102=4;
            	    switch ( input.LA(1) ) {
            	    case LessThanSignEqualsSign:
            	        {
            	        alt102=1;
            	        }
            	        break;
            	    case GreaterThanSignEqualsSign:
            	        {
            	        alt102=2;
            	        }
            	        break;
            	    case LessThanSign:
            	        {
            	        alt102=3;
            	        }
            	        break;
            	    case GreaterThanSign:
            	        {
            	        alt102=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 102, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt102) {
            	        case 1 :
            	            // InternalMyBashParser.g:5639:7: lv_op_2_1= LessThanSignEqualsSign
            	            {
            	            lv_op_2_1=(Token)match(input,LessThanSignEqualsSign,FOLLOW_19); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_1, grammarAccess.getComparisonAccess().getOpLessThanSignEqualsSignKeyword_1_1_0_0());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getComparisonRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalMyBashParser.g:5650:7: lv_op_2_2= GreaterThanSignEqualsSign
            	            {
            	            lv_op_2_2=(Token)match(input,GreaterThanSignEqualsSign,FOLLOW_19); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_2, grammarAccess.getComparisonAccess().getOpGreaterThanSignEqualsSignKeyword_1_1_0_1());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getComparisonRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // InternalMyBashParser.g:5661:7: lv_op_2_3= LessThanSign
            	            {
            	            lv_op_2_3=(Token)match(input,LessThanSign,FOLLOW_19); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_3, grammarAccess.getComparisonAccess().getOpLessThanSignKeyword_1_1_0_2());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getComparisonRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_3, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // InternalMyBashParser.g:5672:7: lv_op_2_4= GreaterThanSign
            	            {
            	            lv_op_2_4=(Token)match(input,GreaterThanSign,FOLLOW_19); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_4, grammarAccess.getComparisonAccess().getOpGreaterThanSignKeyword_1_1_0_3());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getComparisonRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_4, null);
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalMyBashParser.g:5685:4: ( (lv_right_3_0= ruleBitwiseShifts ) )
            	    // InternalMyBashParser.g:5686:5: (lv_right_3_0= ruleBitwiseShifts )
            	    {
            	    // InternalMyBashParser.g:5686:5: (lv_right_3_0= ruleBitwiseShifts )
            	    // InternalMyBashParser.g:5687:6: lv_right_3_0= ruleBitwiseShifts
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getComparisonAccess().getRightBitwiseShiftsParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_82);
            	    lv_right_3_0=ruleBitwiseShifts();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getComparisonRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.xtext.example.mydsl.MyBash.BitwiseShifts");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop103;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComparison"


    // $ANTLR start "entryRuleBitwiseShifts"
    // InternalMyBashParser.g:5709:1: entryRuleBitwiseShifts returns [EObject current=null] : iv_ruleBitwiseShifts= ruleBitwiseShifts EOF ;
    public final EObject entryRuleBitwiseShifts() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitwiseShifts = null;


        try {
            // InternalMyBashParser.g:5709:54: (iv_ruleBitwiseShifts= ruleBitwiseShifts EOF )
            // InternalMyBashParser.g:5710:2: iv_ruleBitwiseShifts= ruleBitwiseShifts EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitwiseShiftsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBitwiseShifts=ruleBitwiseShifts();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitwiseShifts; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitwiseShifts"


    // $ANTLR start "ruleBitwiseShifts"
    // InternalMyBashParser.g:5716:1: ruleBitwiseShifts returns [EObject current=null] : (this_AdditionSubtraction_0= ruleAdditionSubtraction ( () ( ( (lv_op_2_1= LessThanSignLessThanSign | lv_op_2_2= GreaterThanSignGreaterThanSign ) ) ) ( (lv_right_3_0= ruleAdditionSubtraction ) ) )* ) ;
    public final EObject ruleBitwiseShifts() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_AdditionSubtraction_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:5722:2: ( (this_AdditionSubtraction_0= ruleAdditionSubtraction ( () ( ( (lv_op_2_1= LessThanSignLessThanSign | lv_op_2_2= GreaterThanSignGreaterThanSign ) ) ) ( (lv_right_3_0= ruleAdditionSubtraction ) ) )* ) )
            // InternalMyBashParser.g:5723:2: (this_AdditionSubtraction_0= ruleAdditionSubtraction ( () ( ( (lv_op_2_1= LessThanSignLessThanSign | lv_op_2_2= GreaterThanSignGreaterThanSign ) ) ) ( (lv_right_3_0= ruleAdditionSubtraction ) ) )* )
            {
            // InternalMyBashParser.g:5723:2: (this_AdditionSubtraction_0= ruleAdditionSubtraction ( () ( ( (lv_op_2_1= LessThanSignLessThanSign | lv_op_2_2= GreaterThanSignGreaterThanSign ) ) ) ( (lv_right_3_0= ruleAdditionSubtraction ) ) )* )
            // InternalMyBashParser.g:5724:3: this_AdditionSubtraction_0= ruleAdditionSubtraction ( () ( ( (lv_op_2_1= LessThanSignLessThanSign | lv_op_2_2= GreaterThanSignGreaterThanSign ) ) ) ( (lv_right_3_0= ruleAdditionSubtraction ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBitwiseShiftsAccess().getAdditionSubtractionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_83);
            this_AdditionSubtraction_0=ruleAdditionSubtraction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AdditionSubtraction_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMyBashParser.g:5732:3: ( () ( ( (lv_op_2_1= LessThanSignLessThanSign | lv_op_2_2= GreaterThanSignGreaterThanSign ) ) ) ( (lv_right_3_0= ruleAdditionSubtraction ) ) )*
            loop105:
            do {
                int alt105=2;
                int LA105_0 = input.LA(1);

                if ( (LA105_0==LessThanSignLessThanSign||LA105_0==GreaterThanSignGreaterThanSign) ) {
                    alt105=1;
                }


                switch (alt105) {
            	case 1 :
            	    // InternalMyBashParser.g:5733:4: () ( ( (lv_op_2_1= LessThanSignLessThanSign | lv_op_2_2= GreaterThanSignGreaterThanSign ) ) ) ( (lv_right_3_0= ruleAdditionSubtraction ) )
            	    {
            	    // InternalMyBashParser.g:5733:4: ()
            	    // InternalMyBashParser.g:5734:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getBitwiseShiftsAccess().getBinaryExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalMyBashParser.g:5740:4: ( ( (lv_op_2_1= LessThanSignLessThanSign | lv_op_2_2= GreaterThanSignGreaterThanSign ) ) )
            	    // InternalMyBashParser.g:5741:5: ( (lv_op_2_1= LessThanSignLessThanSign | lv_op_2_2= GreaterThanSignGreaterThanSign ) )
            	    {
            	    // InternalMyBashParser.g:5741:5: ( (lv_op_2_1= LessThanSignLessThanSign | lv_op_2_2= GreaterThanSignGreaterThanSign ) )
            	    // InternalMyBashParser.g:5742:6: (lv_op_2_1= LessThanSignLessThanSign | lv_op_2_2= GreaterThanSignGreaterThanSign )
            	    {
            	    // InternalMyBashParser.g:5742:6: (lv_op_2_1= LessThanSignLessThanSign | lv_op_2_2= GreaterThanSignGreaterThanSign )
            	    int alt104=2;
            	    int LA104_0 = input.LA(1);

            	    if ( (LA104_0==LessThanSignLessThanSign) ) {
            	        alt104=1;
            	    }
            	    else if ( (LA104_0==GreaterThanSignGreaterThanSign) ) {
            	        alt104=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 104, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt104) {
            	        case 1 :
            	            // InternalMyBashParser.g:5743:7: lv_op_2_1= LessThanSignLessThanSign
            	            {
            	            lv_op_2_1=(Token)match(input,LessThanSignLessThanSign,FOLLOW_19); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_1, grammarAccess.getBitwiseShiftsAccess().getOpLessThanSignLessThanSignKeyword_1_1_0_0());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getBitwiseShiftsRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalMyBashParser.g:5754:7: lv_op_2_2= GreaterThanSignGreaterThanSign
            	            {
            	            lv_op_2_2=(Token)match(input,GreaterThanSignGreaterThanSign,FOLLOW_19); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_2, grammarAccess.getBitwiseShiftsAccess().getOpGreaterThanSignGreaterThanSignKeyword_1_1_0_1());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getBitwiseShiftsRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalMyBashParser.g:5767:4: ( (lv_right_3_0= ruleAdditionSubtraction ) )
            	    // InternalMyBashParser.g:5768:5: (lv_right_3_0= ruleAdditionSubtraction )
            	    {
            	    // InternalMyBashParser.g:5768:5: (lv_right_3_0= ruleAdditionSubtraction )
            	    // InternalMyBashParser.g:5769:6: lv_right_3_0= ruleAdditionSubtraction
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBitwiseShiftsAccess().getRightAdditionSubtractionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_83);
            	    lv_right_3_0=ruleAdditionSubtraction();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBitwiseShiftsRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.xtext.example.mydsl.MyBash.AdditionSubtraction");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop105;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitwiseShifts"


    // $ANTLR start "entryRuleAdditionSubtraction"
    // InternalMyBashParser.g:5791:1: entryRuleAdditionSubtraction returns [EObject current=null] : iv_ruleAdditionSubtraction= ruleAdditionSubtraction EOF ;
    public final EObject entryRuleAdditionSubtraction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditionSubtraction = null;


        try {
            // InternalMyBashParser.g:5791:60: (iv_ruleAdditionSubtraction= ruleAdditionSubtraction EOF )
            // InternalMyBashParser.g:5792:2: iv_ruleAdditionSubtraction= ruleAdditionSubtraction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditionSubtractionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAdditionSubtraction=ruleAdditionSubtraction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditionSubtraction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAdditionSubtraction"


    // $ANTLR start "ruleAdditionSubtraction"
    // InternalMyBashParser.g:5798:1: ruleAdditionSubtraction returns [EObject current=null] : (this_MultiplicationDivisionRemainder_0= ruleMultiplicationDivisionRemainder ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ( (lv_right_3_0= ruleMultiplicationDivisionRemainder ) ) )* ) ;
    public final EObject ruleAdditionSubtraction() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_MultiplicationDivisionRemainder_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:5804:2: ( (this_MultiplicationDivisionRemainder_0= ruleMultiplicationDivisionRemainder ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ( (lv_right_3_0= ruleMultiplicationDivisionRemainder ) ) )* ) )
            // InternalMyBashParser.g:5805:2: (this_MultiplicationDivisionRemainder_0= ruleMultiplicationDivisionRemainder ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ( (lv_right_3_0= ruleMultiplicationDivisionRemainder ) ) )* )
            {
            // InternalMyBashParser.g:5805:2: (this_MultiplicationDivisionRemainder_0= ruleMultiplicationDivisionRemainder ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ( (lv_right_3_0= ruleMultiplicationDivisionRemainder ) ) )* )
            // InternalMyBashParser.g:5806:3: this_MultiplicationDivisionRemainder_0= ruleMultiplicationDivisionRemainder ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ( (lv_right_3_0= ruleMultiplicationDivisionRemainder ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAdditionSubtractionAccess().getMultiplicationDivisionRemainderParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_84);
            this_MultiplicationDivisionRemainder_0=ruleMultiplicationDivisionRemainder();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_MultiplicationDivisionRemainder_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMyBashParser.g:5814:3: ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ( (lv_right_3_0= ruleMultiplicationDivisionRemainder ) ) )*
            loop107:
            do {
                int alt107=2;
                int LA107_0 = input.LA(1);

                if ( (LA107_0==PlusSign||LA107_0==HyphenMinus) ) {
                    alt107=1;
                }


                switch (alt107) {
            	case 1 :
            	    // InternalMyBashParser.g:5815:4: () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ( (lv_right_3_0= ruleMultiplicationDivisionRemainder ) )
            	    {
            	    // InternalMyBashParser.g:5815:4: ()
            	    // InternalMyBashParser.g:5816:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAdditionSubtractionAccess().getBinaryExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalMyBashParser.g:5822:4: ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) )
            	    // InternalMyBashParser.g:5823:5: ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) )
            	    {
            	    // InternalMyBashParser.g:5823:5: ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) )
            	    // InternalMyBashParser.g:5824:6: (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus )
            	    {
            	    // InternalMyBashParser.g:5824:6: (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus )
            	    int alt106=2;
            	    int LA106_0 = input.LA(1);

            	    if ( (LA106_0==PlusSign) ) {
            	        alt106=1;
            	    }
            	    else if ( (LA106_0==HyphenMinus) ) {
            	        alt106=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 106, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt106) {
            	        case 1 :
            	            // InternalMyBashParser.g:5825:7: lv_op_2_1= PlusSign
            	            {
            	            lv_op_2_1=(Token)match(input,PlusSign,FOLLOW_19); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_1, grammarAccess.getAdditionSubtractionAccess().getOpPlusSignKeyword_1_1_0_0());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getAdditionSubtractionRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalMyBashParser.g:5836:7: lv_op_2_2= HyphenMinus
            	            {
            	            lv_op_2_2=(Token)match(input,HyphenMinus,FOLLOW_19); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_2, grammarAccess.getAdditionSubtractionAccess().getOpHyphenMinusKeyword_1_1_0_1());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getAdditionSubtractionRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalMyBashParser.g:5849:4: ( (lv_right_3_0= ruleMultiplicationDivisionRemainder ) )
            	    // InternalMyBashParser.g:5850:5: (lv_right_3_0= ruleMultiplicationDivisionRemainder )
            	    {
            	    // InternalMyBashParser.g:5850:5: (lv_right_3_0= ruleMultiplicationDivisionRemainder )
            	    // InternalMyBashParser.g:5851:6: lv_right_3_0= ruleMultiplicationDivisionRemainder
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAdditionSubtractionAccess().getRightMultiplicationDivisionRemainderParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_84);
            	    lv_right_3_0=ruleMultiplicationDivisionRemainder();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAdditionSubtractionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.xtext.example.mydsl.MyBash.MultiplicationDivisionRemainder");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop107;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdditionSubtraction"


    // $ANTLR start "entryRuleMultiplicationDivisionRemainder"
    // InternalMyBashParser.g:5873:1: entryRuleMultiplicationDivisionRemainder returns [EObject current=null] : iv_ruleMultiplicationDivisionRemainder= ruleMultiplicationDivisionRemainder EOF ;
    public final EObject entryRuleMultiplicationDivisionRemainder() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicationDivisionRemainder = null;


        try {
            // InternalMyBashParser.g:5873:72: (iv_ruleMultiplicationDivisionRemainder= ruleMultiplicationDivisionRemainder EOF )
            // InternalMyBashParser.g:5874:2: iv_ruleMultiplicationDivisionRemainder= ruleMultiplicationDivisionRemainder EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicationDivisionRemainderRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMultiplicationDivisionRemainder=ruleMultiplicationDivisionRemainder();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicationDivisionRemainder; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicationDivisionRemainder"


    // $ANTLR start "ruleMultiplicationDivisionRemainder"
    // InternalMyBashParser.g:5880:1: ruleMultiplicationDivisionRemainder returns [EObject current=null] : (this_Exponentiation_0= ruleExponentiation ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ( (lv_right_3_0= ruleExponentiation ) ) )* ) ;
    public final EObject ruleMultiplicationDivisionRemainder() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        EObject this_Exponentiation_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:5886:2: ( (this_Exponentiation_0= ruleExponentiation ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ( (lv_right_3_0= ruleExponentiation ) ) )* ) )
            // InternalMyBashParser.g:5887:2: (this_Exponentiation_0= ruleExponentiation ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ( (lv_right_3_0= ruleExponentiation ) ) )* )
            {
            // InternalMyBashParser.g:5887:2: (this_Exponentiation_0= ruleExponentiation ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ( (lv_right_3_0= ruleExponentiation ) ) )* )
            // InternalMyBashParser.g:5888:3: this_Exponentiation_0= ruleExponentiation ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ( (lv_right_3_0= ruleExponentiation ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getMultiplicationDivisionRemainderAccess().getExponentiationParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_85);
            this_Exponentiation_0=ruleExponentiation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Exponentiation_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMyBashParser.g:5896:3: ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ( (lv_right_3_0= ruleExponentiation ) ) )*
            loop109:
            do {
                int alt109=2;
                int LA109_0 = input.LA(1);

                if ( (LA109_0==PercentSign||LA109_0==Asterisk||LA109_0==Solidus) ) {
                    alt109=1;
                }


                switch (alt109) {
            	case 1 :
            	    // InternalMyBashParser.g:5897:4: () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ( (lv_right_3_0= ruleExponentiation ) )
            	    {
            	    // InternalMyBashParser.g:5897:4: ()
            	    // InternalMyBashParser.g:5898:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getMultiplicationDivisionRemainderAccess().getBinaryExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalMyBashParser.g:5904:4: ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) )
            	    // InternalMyBashParser.g:5905:5: ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) )
            	    {
            	    // InternalMyBashParser.g:5905:5: ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) )
            	    // InternalMyBashParser.g:5906:6: (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign )
            	    {
            	    // InternalMyBashParser.g:5906:6: (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign )
            	    int alt108=3;
            	    switch ( input.LA(1) ) {
            	    case Asterisk:
            	        {
            	        alt108=1;
            	        }
            	        break;
            	    case Solidus:
            	        {
            	        alt108=2;
            	        }
            	        break;
            	    case PercentSign:
            	        {
            	        alt108=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 108, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt108) {
            	        case 1 :
            	            // InternalMyBashParser.g:5907:7: lv_op_2_1= Asterisk
            	            {
            	            lv_op_2_1=(Token)match(input,Asterisk,FOLLOW_19); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_1, grammarAccess.getMultiplicationDivisionRemainderAccess().getOpAsteriskKeyword_1_1_0_0());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getMultiplicationDivisionRemainderRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalMyBashParser.g:5918:7: lv_op_2_2= Solidus
            	            {
            	            lv_op_2_2=(Token)match(input,Solidus,FOLLOW_19); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_2, grammarAccess.getMultiplicationDivisionRemainderAccess().getOpSolidusKeyword_1_1_0_1());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getMultiplicationDivisionRemainderRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // InternalMyBashParser.g:5929:7: lv_op_2_3= PercentSign
            	            {
            	            lv_op_2_3=(Token)match(input,PercentSign,FOLLOW_19); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_3, grammarAccess.getMultiplicationDivisionRemainderAccess().getOpPercentSignKeyword_1_1_0_2());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getMultiplicationDivisionRemainderRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_3, null);
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalMyBashParser.g:5942:4: ( (lv_right_3_0= ruleExponentiation ) )
            	    // InternalMyBashParser.g:5943:5: (lv_right_3_0= ruleExponentiation )
            	    {
            	    // InternalMyBashParser.g:5943:5: (lv_right_3_0= ruleExponentiation )
            	    // InternalMyBashParser.g:5944:6: lv_right_3_0= ruleExponentiation
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplicationDivisionRemainderAccess().getRightExponentiationParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_85);
            	    lv_right_3_0=ruleExponentiation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getMultiplicationDivisionRemainderRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.xtext.example.mydsl.MyBash.Exponentiation");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop109;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicationDivisionRemainder"


    // $ANTLR start "entryRuleExponentiation"
    // InternalMyBashParser.g:5966:1: entryRuleExponentiation returns [EObject current=null] : iv_ruleExponentiation= ruleExponentiation EOF ;
    public final EObject entryRuleExponentiation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExponentiation = null;


        try {
            // InternalMyBashParser.g:5966:55: (iv_ruleExponentiation= ruleExponentiation EOF )
            // InternalMyBashParser.g:5967:2: iv_ruleExponentiation= ruleExponentiation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExponentiationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExponentiation=ruleExponentiation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExponentiation; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExponentiation"


    // $ANTLR start "ruleExponentiation"
    // InternalMyBashParser.g:5973:1: ruleExponentiation returns [EObject current=null] : (this_LogicalAndBitwiseNegation_0= ruleLogicalAndBitwiseNegation ( () ( (lv_op_2_0= AsteriskAsterisk ) ) ( (lv_right_3_0= ruleExponentiation ) ) )? ) ;
    public final EObject ruleExponentiation() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_LogicalAndBitwiseNegation_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:5979:2: ( (this_LogicalAndBitwiseNegation_0= ruleLogicalAndBitwiseNegation ( () ( (lv_op_2_0= AsteriskAsterisk ) ) ( (lv_right_3_0= ruleExponentiation ) ) )? ) )
            // InternalMyBashParser.g:5980:2: (this_LogicalAndBitwiseNegation_0= ruleLogicalAndBitwiseNegation ( () ( (lv_op_2_0= AsteriskAsterisk ) ) ( (lv_right_3_0= ruleExponentiation ) ) )? )
            {
            // InternalMyBashParser.g:5980:2: (this_LogicalAndBitwiseNegation_0= ruleLogicalAndBitwiseNegation ( () ( (lv_op_2_0= AsteriskAsterisk ) ) ( (lv_right_3_0= ruleExponentiation ) ) )? )
            // InternalMyBashParser.g:5981:3: this_LogicalAndBitwiseNegation_0= ruleLogicalAndBitwiseNegation ( () ( (lv_op_2_0= AsteriskAsterisk ) ) ( (lv_right_3_0= ruleExponentiation ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getExponentiationAccess().getLogicalAndBitwiseNegationParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_86);
            this_LogicalAndBitwiseNegation_0=ruleLogicalAndBitwiseNegation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_LogicalAndBitwiseNegation_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMyBashParser.g:5989:3: ( () ( (lv_op_2_0= AsteriskAsterisk ) ) ( (lv_right_3_0= ruleExponentiation ) ) )?
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==AsteriskAsterisk) ) {
                alt110=1;
            }
            switch (alt110) {
                case 1 :
                    // InternalMyBashParser.g:5990:4: () ( (lv_op_2_0= AsteriskAsterisk ) ) ( (lv_right_3_0= ruleExponentiation ) )
                    {
                    // InternalMyBashParser.g:5990:4: ()
                    // InternalMyBashParser.g:5991:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getExponentiationAccess().getBinaryExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalMyBashParser.g:5997:4: ( (lv_op_2_0= AsteriskAsterisk ) )
                    // InternalMyBashParser.g:5998:5: (lv_op_2_0= AsteriskAsterisk )
                    {
                    // InternalMyBashParser.g:5998:5: (lv_op_2_0= AsteriskAsterisk )
                    // InternalMyBashParser.g:5999:6: lv_op_2_0= AsteriskAsterisk
                    {
                    lv_op_2_0=(Token)match(input,AsteriskAsterisk,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_2_0, grammarAccess.getExponentiationAccess().getOpAsteriskAsteriskKeyword_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getExponentiationRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_2_0, "**");
                      					
                    }

                    }


                    }

                    // InternalMyBashParser.g:6011:4: ( (lv_right_3_0= ruleExponentiation ) )
                    // InternalMyBashParser.g:6012:5: (lv_right_3_0= ruleExponentiation )
                    {
                    // InternalMyBashParser.g:6012:5: (lv_right_3_0= ruleExponentiation )
                    // InternalMyBashParser.g:6013:6: lv_right_3_0= ruleExponentiation
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getExponentiationAccess().getRightExponentiationParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=ruleExponentiation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getExponentiationRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_3_0,
                      							"org.xtext.example.mydsl.MyBash.Exponentiation");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExponentiation"


    // $ANTLR start "entryRuleLogicalAndBitwiseNegation"
    // InternalMyBashParser.g:6035:1: entryRuleLogicalAndBitwiseNegation returns [EObject current=null] : iv_ruleLogicalAndBitwiseNegation= ruleLogicalAndBitwiseNegation EOF ;
    public final EObject entryRuleLogicalAndBitwiseNegation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndBitwiseNegation = null;


        try {
            // InternalMyBashParser.g:6035:66: (iv_ruleLogicalAndBitwiseNegation= ruleLogicalAndBitwiseNegation EOF )
            // InternalMyBashParser.g:6036:2: iv_ruleLogicalAndBitwiseNegation= ruleLogicalAndBitwiseNegation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalAndBitwiseNegationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLogicalAndBitwiseNegation=ruleLogicalAndBitwiseNegation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalAndBitwiseNegation; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogicalAndBitwiseNegation"


    // $ANTLR start "ruleLogicalAndBitwiseNegation"
    // InternalMyBashParser.g:6042:1: ruleLogicalAndBitwiseNegation returns [EObject current=null] : ( ( () ( ( (lv_op_1_1= ExclamationMark | lv_op_1_2= Tilde ) ) ) ( (lv_operand_2_0= ruleLogicalAndBitwiseNegation ) ) ) | this_UnaryMinusAndPlus_3= ruleUnaryMinusAndPlus ) ;
    public final EObject ruleLogicalAndBitwiseNegation() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        EObject lv_operand_2_0 = null;

        EObject this_UnaryMinusAndPlus_3 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:6048:2: ( ( ( () ( ( (lv_op_1_1= ExclamationMark | lv_op_1_2= Tilde ) ) ) ( (lv_operand_2_0= ruleLogicalAndBitwiseNegation ) ) ) | this_UnaryMinusAndPlus_3= ruleUnaryMinusAndPlus ) )
            // InternalMyBashParser.g:6049:2: ( ( () ( ( (lv_op_1_1= ExclamationMark | lv_op_1_2= Tilde ) ) ) ( (lv_operand_2_0= ruleLogicalAndBitwiseNegation ) ) ) | this_UnaryMinusAndPlus_3= ruleUnaryMinusAndPlus )
            {
            // InternalMyBashParser.g:6049:2: ( ( () ( ( (lv_op_1_1= ExclamationMark | lv_op_1_2= Tilde ) ) ) ( (lv_operand_2_0= ruleLogicalAndBitwiseNegation ) ) ) | this_UnaryMinusAndPlus_3= ruleUnaryMinusAndPlus )
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==ExclamationMark||LA112_0==Tilde) ) {
                alt112=1;
            }
            else if ( (LA112_0==DollarSignLeftParenthesisLeftParenthesis||LA112_0==DollarSignLeftCurlyBracket||LA112_0==PlusSignPlusSign||LA112_0==HyphenMinusHyphenMinus||LA112_0==LessThanSignLeftParenthesis||LA112_0==GreaterThanSignLeftParenthesis||LA112_0==LeftParenthesis||LA112_0==PlusSign||LA112_0==HyphenMinus||LA112_0==RULE_I_NUMBER||LA112_0==RULE_NAME||(LA112_0>=RULE_VARIABLE && LA112_0<=RULE_A_PREFIX)||LA112_0==RULE_CS_START) ) {
                alt112=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 112, 0, input);

                throw nvae;
            }
            switch (alt112) {
                case 1 :
                    // InternalMyBashParser.g:6050:3: ( () ( ( (lv_op_1_1= ExclamationMark | lv_op_1_2= Tilde ) ) ) ( (lv_operand_2_0= ruleLogicalAndBitwiseNegation ) ) )
                    {
                    // InternalMyBashParser.g:6050:3: ( () ( ( (lv_op_1_1= ExclamationMark | lv_op_1_2= Tilde ) ) ) ( (lv_operand_2_0= ruleLogicalAndBitwiseNegation ) ) )
                    // InternalMyBashParser.g:6051:4: () ( ( (lv_op_1_1= ExclamationMark | lv_op_1_2= Tilde ) ) ) ( (lv_operand_2_0= ruleLogicalAndBitwiseNegation ) )
                    {
                    // InternalMyBashParser.g:6051:4: ()
                    // InternalMyBashParser.g:6052:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getLogicalAndBitwiseNegationAccess().getPrefixExpressionAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalMyBashParser.g:6058:4: ( ( (lv_op_1_1= ExclamationMark | lv_op_1_2= Tilde ) ) )
                    // InternalMyBashParser.g:6059:5: ( (lv_op_1_1= ExclamationMark | lv_op_1_2= Tilde ) )
                    {
                    // InternalMyBashParser.g:6059:5: ( (lv_op_1_1= ExclamationMark | lv_op_1_2= Tilde ) )
                    // InternalMyBashParser.g:6060:6: (lv_op_1_1= ExclamationMark | lv_op_1_2= Tilde )
                    {
                    // InternalMyBashParser.g:6060:6: (lv_op_1_1= ExclamationMark | lv_op_1_2= Tilde )
                    int alt111=2;
                    int LA111_0 = input.LA(1);

                    if ( (LA111_0==ExclamationMark) ) {
                        alt111=1;
                    }
                    else if ( (LA111_0==Tilde) ) {
                        alt111=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 111, 0, input);

                        throw nvae;
                    }
                    switch (alt111) {
                        case 1 :
                            // InternalMyBashParser.g:6061:7: lv_op_1_1= ExclamationMark
                            {
                            lv_op_1_1=(Token)match(input,ExclamationMark,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_1_1, grammarAccess.getLogicalAndBitwiseNegationAccess().getOpExclamationMarkKeyword_0_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getLogicalAndBitwiseNegationRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_1_1, null);
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalMyBashParser.g:6072:7: lv_op_1_2= Tilde
                            {
                            lv_op_1_2=(Token)match(input,Tilde,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_1_2, grammarAccess.getLogicalAndBitwiseNegationAccess().getOpTildeKeyword_0_1_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getLogicalAndBitwiseNegationRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_1_2, null);
                              						
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalMyBashParser.g:6085:4: ( (lv_operand_2_0= ruleLogicalAndBitwiseNegation ) )
                    // InternalMyBashParser.g:6086:5: (lv_operand_2_0= ruleLogicalAndBitwiseNegation )
                    {
                    // InternalMyBashParser.g:6086:5: (lv_operand_2_0= ruleLogicalAndBitwiseNegation )
                    // InternalMyBashParser.g:6087:6: lv_operand_2_0= ruleLogicalAndBitwiseNegation
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getLogicalAndBitwiseNegationAccess().getOperandLogicalAndBitwiseNegationParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_0=ruleLogicalAndBitwiseNegation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getLogicalAndBitwiseNegationRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_0,
                      							"org.xtext.example.mydsl.MyBash.LogicalAndBitwiseNegation");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMyBashParser.g:6106:3: this_UnaryMinusAndPlus_3= ruleUnaryMinusAndPlus
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLogicalAndBitwiseNegationAccess().getUnaryMinusAndPlusParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_UnaryMinusAndPlus_3=ruleUnaryMinusAndPlus();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_UnaryMinusAndPlus_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogicalAndBitwiseNegation"


    // $ANTLR start "entryRuleUnaryMinusAndPlus"
    // InternalMyBashParser.g:6118:1: entryRuleUnaryMinusAndPlus returns [EObject current=null] : iv_ruleUnaryMinusAndPlus= ruleUnaryMinusAndPlus EOF ;
    public final EObject entryRuleUnaryMinusAndPlus() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryMinusAndPlus = null;


        try {
            // InternalMyBashParser.g:6118:58: (iv_ruleUnaryMinusAndPlus= ruleUnaryMinusAndPlus EOF )
            // InternalMyBashParser.g:6119:2: iv_ruleUnaryMinusAndPlus= ruleUnaryMinusAndPlus EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryMinusAndPlusRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnaryMinusAndPlus=ruleUnaryMinusAndPlus();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryMinusAndPlus; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryMinusAndPlus"


    // $ANTLR start "ruleUnaryMinusAndPlus"
    // InternalMyBashParser.g:6125:1: ruleUnaryMinusAndPlus returns [EObject current=null] : ( ( () ( ( (lv_op_1_1= PlusSign | lv_op_1_2= HyphenMinus ) ) ) ( (lv_operand_2_0= ruleUnaryMinusAndPlus ) ) ) | this_PrimaryItem_3= rulePrimaryItem ) ;
    public final EObject ruleUnaryMinusAndPlus() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        EObject lv_operand_2_0 = null;

        EObject this_PrimaryItem_3 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:6131:2: ( ( ( () ( ( (lv_op_1_1= PlusSign | lv_op_1_2= HyphenMinus ) ) ) ( (lv_operand_2_0= ruleUnaryMinusAndPlus ) ) ) | this_PrimaryItem_3= rulePrimaryItem ) )
            // InternalMyBashParser.g:6132:2: ( ( () ( ( (lv_op_1_1= PlusSign | lv_op_1_2= HyphenMinus ) ) ) ( (lv_operand_2_0= ruleUnaryMinusAndPlus ) ) ) | this_PrimaryItem_3= rulePrimaryItem )
            {
            // InternalMyBashParser.g:6132:2: ( ( () ( ( (lv_op_1_1= PlusSign | lv_op_1_2= HyphenMinus ) ) ) ( (lv_operand_2_0= ruleUnaryMinusAndPlus ) ) ) | this_PrimaryItem_3= rulePrimaryItem )
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==PlusSign||LA114_0==HyphenMinus) ) {
                alt114=1;
            }
            else if ( (LA114_0==DollarSignLeftParenthesisLeftParenthesis||LA114_0==DollarSignLeftCurlyBracket||LA114_0==PlusSignPlusSign||LA114_0==HyphenMinusHyphenMinus||LA114_0==LessThanSignLeftParenthesis||LA114_0==GreaterThanSignLeftParenthesis||LA114_0==LeftParenthesis||LA114_0==RULE_I_NUMBER||LA114_0==RULE_NAME||(LA114_0>=RULE_VARIABLE && LA114_0<=RULE_A_PREFIX)||LA114_0==RULE_CS_START) ) {
                alt114=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 114, 0, input);

                throw nvae;
            }
            switch (alt114) {
                case 1 :
                    // InternalMyBashParser.g:6133:3: ( () ( ( (lv_op_1_1= PlusSign | lv_op_1_2= HyphenMinus ) ) ) ( (lv_operand_2_0= ruleUnaryMinusAndPlus ) ) )
                    {
                    // InternalMyBashParser.g:6133:3: ( () ( ( (lv_op_1_1= PlusSign | lv_op_1_2= HyphenMinus ) ) ) ( (lv_operand_2_0= ruleUnaryMinusAndPlus ) ) )
                    // InternalMyBashParser.g:6134:4: () ( ( (lv_op_1_1= PlusSign | lv_op_1_2= HyphenMinus ) ) ) ( (lv_operand_2_0= ruleUnaryMinusAndPlus ) )
                    {
                    // InternalMyBashParser.g:6134:4: ()
                    // InternalMyBashParser.g:6135:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getUnaryMinusAndPlusAccess().getPrefixExpressionAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalMyBashParser.g:6141:4: ( ( (lv_op_1_1= PlusSign | lv_op_1_2= HyphenMinus ) ) )
                    // InternalMyBashParser.g:6142:5: ( (lv_op_1_1= PlusSign | lv_op_1_2= HyphenMinus ) )
                    {
                    // InternalMyBashParser.g:6142:5: ( (lv_op_1_1= PlusSign | lv_op_1_2= HyphenMinus ) )
                    // InternalMyBashParser.g:6143:6: (lv_op_1_1= PlusSign | lv_op_1_2= HyphenMinus )
                    {
                    // InternalMyBashParser.g:6143:6: (lv_op_1_1= PlusSign | lv_op_1_2= HyphenMinus )
                    int alt113=2;
                    int LA113_0 = input.LA(1);

                    if ( (LA113_0==PlusSign) ) {
                        alt113=1;
                    }
                    else if ( (LA113_0==HyphenMinus) ) {
                        alt113=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 113, 0, input);

                        throw nvae;
                    }
                    switch (alt113) {
                        case 1 :
                            // InternalMyBashParser.g:6144:7: lv_op_1_1= PlusSign
                            {
                            lv_op_1_1=(Token)match(input,PlusSign,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_1_1, grammarAccess.getUnaryMinusAndPlusAccess().getOpPlusSignKeyword_0_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getUnaryMinusAndPlusRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_1_1, null);
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalMyBashParser.g:6155:7: lv_op_1_2= HyphenMinus
                            {
                            lv_op_1_2=(Token)match(input,HyphenMinus,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_1_2, grammarAccess.getUnaryMinusAndPlusAccess().getOpHyphenMinusKeyword_0_1_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getUnaryMinusAndPlusRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_1_2, null);
                              						
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalMyBashParser.g:6168:4: ( (lv_operand_2_0= ruleUnaryMinusAndPlus ) )
                    // InternalMyBashParser.g:6169:5: (lv_operand_2_0= ruleUnaryMinusAndPlus )
                    {
                    // InternalMyBashParser.g:6169:5: (lv_operand_2_0= ruleUnaryMinusAndPlus )
                    // InternalMyBashParser.g:6170:6: lv_operand_2_0= ruleUnaryMinusAndPlus
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getUnaryMinusAndPlusAccess().getOperandUnaryMinusAndPlusParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_0=ruleUnaryMinusAndPlus();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getUnaryMinusAndPlusRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_0,
                      							"org.xtext.example.mydsl.MyBash.UnaryMinusAndPlus");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMyBashParser.g:6189:3: this_PrimaryItem_3= rulePrimaryItem
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getUnaryMinusAndPlusAccess().getPrimaryItemParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PrimaryItem_3=rulePrimaryItem();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PrimaryItem_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryMinusAndPlus"


    // $ANTLR start "entryRulePreDecrement"
    // InternalMyBashParser.g:6201:1: entryRulePreDecrement returns [EObject current=null] : iv_rulePreDecrement= rulePreDecrement EOF ;
    public final EObject entryRulePreDecrement() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePreDecrement = null;


        try {
            // InternalMyBashParser.g:6201:53: (iv_rulePreDecrement= rulePreDecrement EOF )
            // InternalMyBashParser.g:6202:2: iv_rulePreDecrement= rulePreDecrement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPreDecrementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePreDecrement=rulePreDecrement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePreDecrement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePreDecrement"


    // $ANTLR start "rulePreDecrement"
    // InternalMyBashParser.g:6208:1: rulePreDecrement returns [EObject current=null] : ( ( () ( ( (lv_op_1_1= PlusSignPlusSign | lv_op_1_2= HyphenMinusHyphenMinus ) ) ) ( (lv_operand_2_0= rulePostDecrement ) ) ) | this_PostDecrement_3= rulePostDecrement ) ;
    public final EObject rulePreDecrement() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        EObject lv_operand_2_0 = null;

        EObject this_PostDecrement_3 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:6214:2: ( ( ( () ( ( (lv_op_1_1= PlusSignPlusSign | lv_op_1_2= HyphenMinusHyphenMinus ) ) ) ( (lv_operand_2_0= rulePostDecrement ) ) ) | this_PostDecrement_3= rulePostDecrement ) )
            // InternalMyBashParser.g:6215:2: ( ( () ( ( (lv_op_1_1= PlusSignPlusSign | lv_op_1_2= HyphenMinusHyphenMinus ) ) ) ( (lv_operand_2_0= rulePostDecrement ) ) ) | this_PostDecrement_3= rulePostDecrement )
            {
            // InternalMyBashParser.g:6215:2: ( ( () ( ( (lv_op_1_1= PlusSignPlusSign | lv_op_1_2= HyphenMinusHyphenMinus ) ) ) ( (lv_operand_2_0= rulePostDecrement ) ) ) | this_PostDecrement_3= rulePostDecrement )
            int alt116=2;
            int LA116_0 = input.LA(1);

            if ( (LA116_0==PlusSignPlusSign||LA116_0==HyphenMinusHyphenMinus) ) {
                alt116=1;
            }
            else if ( (LA116_0==RULE_NAME) ) {
                alt116=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 116, 0, input);

                throw nvae;
            }
            switch (alt116) {
                case 1 :
                    // InternalMyBashParser.g:6216:3: ( () ( ( (lv_op_1_1= PlusSignPlusSign | lv_op_1_2= HyphenMinusHyphenMinus ) ) ) ( (lv_operand_2_0= rulePostDecrement ) ) )
                    {
                    // InternalMyBashParser.g:6216:3: ( () ( ( (lv_op_1_1= PlusSignPlusSign | lv_op_1_2= HyphenMinusHyphenMinus ) ) ) ( (lv_operand_2_0= rulePostDecrement ) ) )
                    // InternalMyBashParser.g:6217:4: () ( ( (lv_op_1_1= PlusSignPlusSign | lv_op_1_2= HyphenMinusHyphenMinus ) ) ) ( (lv_operand_2_0= rulePostDecrement ) )
                    {
                    // InternalMyBashParser.g:6217:4: ()
                    // InternalMyBashParser.g:6218:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPreDecrementAccess().getPrefixExpressionAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalMyBashParser.g:6224:4: ( ( (lv_op_1_1= PlusSignPlusSign | lv_op_1_2= HyphenMinusHyphenMinus ) ) )
                    // InternalMyBashParser.g:6225:5: ( (lv_op_1_1= PlusSignPlusSign | lv_op_1_2= HyphenMinusHyphenMinus ) )
                    {
                    // InternalMyBashParser.g:6225:5: ( (lv_op_1_1= PlusSignPlusSign | lv_op_1_2= HyphenMinusHyphenMinus ) )
                    // InternalMyBashParser.g:6226:6: (lv_op_1_1= PlusSignPlusSign | lv_op_1_2= HyphenMinusHyphenMinus )
                    {
                    // InternalMyBashParser.g:6226:6: (lv_op_1_1= PlusSignPlusSign | lv_op_1_2= HyphenMinusHyphenMinus )
                    int alt115=2;
                    int LA115_0 = input.LA(1);

                    if ( (LA115_0==PlusSignPlusSign) ) {
                        alt115=1;
                    }
                    else if ( (LA115_0==HyphenMinusHyphenMinus) ) {
                        alt115=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 115, 0, input);

                        throw nvae;
                    }
                    switch (alt115) {
                        case 1 :
                            // InternalMyBashParser.g:6227:7: lv_op_1_1= PlusSignPlusSign
                            {
                            lv_op_1_1=(Token)match(input,PlusSignPlusSign,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_1_1, grammarAccess.getPreDecrementAccess().getOpPlusSignPlusSignKeyword_0_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getPreDecrementRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_1_1, null);
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalMyBashParser.g:6238:7: lv_op_1_2= HyphenMinusHyphenMinus
                            {
                            lv_op_1_2=(Token)match(input,HyphenMinusHyphenMinus,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_1_2, grammarAccess.getPreDecrementAccess().getOpHyphenMinusHyphenMinusKeyword_0_1_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getPreDecrementRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_1_2, null);
                              						
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalMyBashParser.g:6251:4: ( (lv_operand_2_0= rulePostDecrement ) )
                    // InternalMyBashParser.g:6252:5: (lv_operand_2_0= rulePostDecrement )
                    {
                    // InternalMyBashParser.g:6252:5: (lv_operand_2_0= rulePostDecrement )
                    // InternalMyBashParser.g:6253:6: lv_operand_2_0= rulePostDecrement
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPreDecrementAccess().getOperandPostDecrementParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_0=rulePostDecrement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPreDecrementRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_0,
                      							"org.xtext.example.mydsl.MyBash.PostDecrement");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMyBashParser.g:6272:3: this_PostDecrement_3= rulePostDecrement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPreDecrementAccess().getPostDecrementParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PostDecrement_3=rulePostDecrement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PostDecrement_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePreDecrement"


    // $ANTLR start "entryRulePostDecrement"
    // InternalMyBashParser.g:6284:1: entryRulePostDecrement returns [EObject current=null] : iv_rulePostDecrement= rulePostDecrement EOF ;
    public final EObject entryRulePostDecrement() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostDecrement = null;


        try {
            // InternalMyBashParser.g:6284:54: (iv_rulePostDecrement= rulePostDecrement EOF )
            // InternalMyBashParser.g:6285:2: iv_rulePostDecrement= rulePostDecrement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPostDecrementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePostDecrement=rulePostDecrement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePostDecrement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePostDecrement"


    // $ANTLR start "rulePostDecrement"
    // InternalMyBashParser.g:6291:1: rulePostDecrement returns [EObject current=null] : (this_VariableId_0= ruleVariableId ( () ( ( (lv_op_2_1= PlusSignPlusSign | lv_op_2_2= HyphenMinusHyphenMinus ) ) ) )? ) ;
    public final EObject rulePostDecrement() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_VariableId_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:6297:2: ( (this_VariableId_0= ruleVariableId ( () ( ( (lv_op_2_1= PlusSignPlusSign | lv_op_2_2= HyphenMinusHyphenMinus ) ) ) )? ) )
            // InternalMyBashParser.g:6298:2: (this_VariableId_0= ruleVariableId ( () ( ( (lv_op_2_1= PlusSignPlusSign | lv_op_2_2= HyphenMinusHyphenMinus ) ) ) )? )
            {
            // InternalMyBashParser.g:6298:2: (this_VariableId_0= ruleVariableId ( () ( ( (lv_op_2_1= PlusSignPlusSign | lv_op_2_2= HyphenMinusHyphenMinus ) ) ) )? )
            // InternalMyBashParser.g:6299:3: this_VariableId_0= ruleVariableId ( () ( ( (lv_op_2_1= PlusSignPlusSign | lv_op_2_2= HyphenMinusHyphenMinus ) ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getPostDecrementAccess().getVariableIdParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_87);
            this_VariableId_0=ruleVariableId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_VariableId_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMyBashParser.g:6307:3: ( () ( ( (lv_op_2_1= PlusSignPlusSign | lv_op_2_2= HyphenMinusHyphenMinus ) ) ) )?
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==PlusSignPlusSign||LA118_0==HyphenMinusHyphenMinus) ) {
                alt118=1;
            }
            switch (alt118) {
                case 1 :
                    // InternalMyBashParser.g:6308:4: () ( ( (lv_op_2_1= PlusSignPlusSign | lv_op_2_2= HyphenMinusHyphenMinus ) ) )
                    {
                    // InternalMyBashParser.g:6308:4: ()
                    // InternalMyBashParser.g:6309:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getPostDecrementAccess().getSuffixExpressionOperandAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalMyBashParser.g:6315:4: ( ( (lv_op_2_1= PlusSignPlusSign | lv_op_2_2= HyphenMinusHyphenMinus ) ) )
                    // InternalMyBashParser.g:6316:5: ( (lv_op_2_1= PlusSignPlusSign | lv_op_2_2= HyphenMinusHyphenMinus ) )
                    {
                    // InternalMyBashParser.g:6316:5: ( (lv_op_2_1= PlusSignPlusSign | lv_op_2_2= HyphenMinusHyphenMinus ) )
                    // InternalMyBashParser.g:6317:6: (lv_op_2_1= PlusSignPlusSign | lv_op_2_2= HyphenMinusHyphenMinus )
                    {
                    // InternalMyBashParser.g:6317:6: (lv_op_2_1= PlusSignPlusSign | lv_op_2_2= HyphenMinusHyphenMinus )
                    int alt117=2;
                    int LA117_0 = input.LA(1);

                    if ( (LA117_0==PlusSignPlusSign) ) {
                        alt117=1;
                    }
                    else if ( (LA117_0==HyphenMinusHyphenMinus) ) {
                        alt117=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 117, 0, input);

                        throw nvae;
                    }
                    switch (alt117) {
                        case 1 :
                            // InternalMyBashParser.g:6318:7: lv_op_2_1= PlusSignPlusSign
                            {
                            lv_op_2_1=(Token)match(input,PlusSignPlusSign,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_2_1, grammarAccess.getPostDecrementAccess().getOpPlusSignPlusSignKeyword_1_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getPostDecrementRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_2_1, null);
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalMyBashParser.g:6329:7: lv_op_2_2= HyphenMinusHyphenMinus
                            {
                            lv_op_2_2=(Token)match(input,HyphenMinusHyphenMinus,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_2_2, grammarAccess.getPostDecrementAccess().getOpHyphenMinusHyphenMinusKeyword_1_1_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getPostDecrementRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_2_2, null);
                              						
                            }

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePostDecrement"


    // $ANTLR start "entryRulePrimaryItem"
    // InternalMyBashParser.g:6347:1: entryRulePrimaryItem returns [EObject current=null] : iv_rulePrimaryItem= rulePrimaryItem EOF ;
    public final EObject entryRulePrimaryItem() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryItem = null;


        try {
            // InternalMyBashParser.g:6347:52: (iv_rulePrimaryItem= rulePrimaryItem EOF )
            // InternalMyBashParser.g:6348:2: iv_rulePrimaryItem= rulePrimaryItem EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryItemRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePrimaryItem=rulePrimaryItem();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryItem; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryItem"


    // $ANTLR start "rulePrimaryItem"
    // InternalMyBashParser.g:6354:1: rulePrimaryItem returns [EObject current=null] : ( ( () ( (lv_prefix_1_0= RULE_A_PREFIX ) )? ( (lv_value_2_0= RULE_I_NUMBER ) ) ) | (otherlv_3= LeftParenthesis this_Evaluation_4= ruleEvaluation otherlv_5= RightParenthesis ) | ( () ( (lv_prefix_7_0= RULE_A_PREFIX ) )? ( (lv_value_8_0= ruleExpansion ) ) ) | this_PreDecrement_9= rulePreDecrement ) ;
    public final EObject rulePrimaryItem() throws RecognitionException {
        EObject current = null;

        Token lv_prefix_1_0=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_prefix_7_0=null;
        EObject this_Evaluation_4 = null;

        EObject lv_value_8_0 = null;

        EObject this_PreDecrement_9 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:6360:2: ( ( ( () ( (lv_prefix_1_0= RULE_A_PREFIX ) )? ( (lv_value_2_0= RULE_I_NUMBER ) ) ) | (otherlv_3= LeftParenthesis this_Evaluation_4= ruleEvaluation otherlv_5= RightParenthesis ) | ( () ( (lv_prefix_7_0= RULE_A_PREFIX ) )? ( (lv_value_8_0= ruleExpansion ) ) ) | this_PreDecrement_9= rulePreDecrement ) )
            // InternalMyBashParser.g:6361:2: ( ( () ( (lv_prefix_1_0= RULE_A_PREFIX ) )? ( (lv_value_2_0= RULE_I_NUMBER ) ) ) | (otherlv_3= LeftParenthesis this_Evaluation_4= ruleEvaluation otherlv_5= RightParenthesis ) | ( () ( (lv_prefix_7_0= RULE_A_PREFIX ) )? ( (lv_value_8_0= ruleExpansion ) ) ) | this_PreDecrement_9= rulePreDecrement )
            {
            // InternalMyBashParser.g:6361:2: ( ( () ( (lv_prefix_1_0= RULE_A_PREFIX ) )? ( (lv_value_2_0= RULE_I_NUMBER ) ) ) | (otherlv_3= LeftParenthesis this_Evaluation_4= ruleEvaluation otherlv_5= RightParenthesis ) | ( () ( (lv_prefix_7_0= RULE_A_PREFIX ) )? ( (lv_value_8_0= ruleExpansion ) ) ) | this_PreDecrement_9= rulePreDecrement )
            int alt121=4;
            switch ( input.LA(1) ) {
            case RULE_A_PREFIX:
                {
                int LA121_1 = input.LA(2);

                if ( (LA121_1==DollarSignLeftParenthesisLeftParenthesis||LA121_1==DollarSignLeftCurlyBracket||LA121_1==LessThanSignLeftParenthesis||LA121_1==GreaterThanSignLeftParenthesis||LA121_1==RULE_VARIABLE||LA121_1==RULE_CS_START) ) {
                    alt121=3;
                }
                else if ( (LA121_1==RULE_I_NUMBER) ) {
                    alt121=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 121, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_I_NUMBER:
                {
                alt121=1;
                }
                break;
            case LeftParenthesis:
                {
                alt121=2;
                }
                break;
            case DollarSignLeftParenthesisLeftParenthesis:
            case DollarSignLeftCurlyBracket:
            case LessThanSignLeftParenthesis:
            case GreaterThanSignLeftParenthesis:
            case RULE_VARIABLE:
            case RULE_CS_START:
                {
                alt121=3;
                }
                break;
            case PlusSignPlusSign:
            case HyphenMinusHyphenMinus:
            case RULE_NAME:
                {
                alt121=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 121, 0, input);

                throw nvae;
            }

            switch (alt121) {
                case 1 :
                    // InternalMyBashParser.g:6362:3: ( () ( (lv_prefix_1_0= RULE_A_PREFIX ) )? ( (lv_value_2_0= RULE_I_NUMBER ) ) )
                    {
                    // InternalMyBashParser.g:6362:3: ( () ( (lv_prefix_1_0= RULE_A_PREFIX ) )? ( (lv_value_2_0= RULE_I_NUMBER ) ) )
                    // InternalMyBashParser.g:6363:4: () ( (lv_prefix_1_0= RULE_A_PREFIX ) )? ( (lv_value_2_0= RULE_I_NUMBER ) )
                    {
                    // InternalMyBashParser.g:6363:4: ()
                    // InternalMyBashParser.g:6364:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrimaryItemAccess().getConstPrimaryItemAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalMyBashParser.g:6370:4: ( (lv_prefix_1_0= RULE_A_PREFIX ) )?
                    int alt119=2;
                    int LA119_0 = input.LA(1);

                    if ( (LA119_0==RULE_A_PREFIX) ) {
                        alt119=1;
                    }
                    switch (alt119) {
                        case 1 :
                            // InternalMyBashParser.g:6371:5: (lv_prefix_1_0= RULE_A_PREFIX )
                            {
                            // InternalMyBashParser.g:6371:5: (lv_prefix_1_0= RULE_A_PREFIX )
                            // InternalMyBashParser.g:6372:6: lv_prefix_1_0= RULE_A_PREFIX
                            {
                            lv_prefix_1_0=(Token)match(input,RULE_A_PREFIX,FOLLOW_88); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_prefix_1_0, grammarAccess.getPrimaryItemAccess().getPrefixA_PREFIXTerminalRuleCall_0_1_0());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getPrimaryItemRule());
                              						}
                              						setWithLastConsumed(
                              							current,
                              							"prefix",
                              							lv_prefix_1_0,
                              							"org.xtext.example.mydsl.MyBash.A_PREFIX");
                              					
                            }

                            }


                            }
                            break;

                    }

                    // InternalMyBashParser.g:6388:4: ( (lv_value_2_0= RULE_I_NUMBER ) )
                    // InternalMyBashParser.g:6389:5: (lv_value_2_0= RULE_I_NUMBER )
                    {
                    // InternalMyBashParser.g:6389:5: (lv_value_2_0= RULE_I_NUMBER )
                    // InternalMyBashParser.g:6390:6: lv_value_2_0= RULE_I_NUMBER
                    {
                    lv_value_2_0=(Token)match(input,RULE_I_NUMBER,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_2_0, grammarAccess.getPrimaryItemAccess().getValueI_NUMBERTerminalRuleCall_0_2_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPrimaryItemRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_2_0,
                      							"org.xtext.example.mydsl.MyBash.I_NUMBER");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMyBashParser.g:6408:3: (otherlv_3= LeftParenthesis this_Evaluation_4= ruleEvaluation otherlv_5= RightParenthesis )
                    {
                    // InternalMyBashParser.g:6408:3: (otherlv_3= LeftParenthesis this_Evaluation_4= ruleEvaluation otherlv_5= RightParenthesis )
                    // InternalMyBashParser.g:6409:4: otherlv_3= LeftParenthesis this_Evaluation_4= ruleEvaluation otherlv_5= RightParenthesis
                    {
                    otherlv_3=(Token)match(input,LeftParenthesis,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getPrimaryItemAccess().getLeftParenthesisKeyword_1_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getPrimaryItemAccess().getEvaluationParserRuleCall_1_1());
                      			
                    }
                    pushFollow(FOLLOW_13);
                    this_Evaluation_4=ruleEvaluation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_Evaluation_4;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_5=(Token)match(input,RightParenthesis,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getPrimaryItemAccess().getRightParenthesisKeyword_1_2());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalMyBashParser.g:6427:3: ( () ( (lv_prefix_7_0= RULE_A_PREFIX ) )? ( (lv_value_8_0= ruleExpansion ) ) )
                    {
                    // InternalMyBashParser.g:6427:3: ( () ( (lv_prefix_7_0= RULE_A_PREFIX ) )? ( (lv_value_8_0= ruleExpansion ) ) )
                    // InternalMyBashParser.g:6428:4: () ( (lv_prefix_7_0= RULE_A_PREFIX ) )? ( (lv_value_8_0= ruleExpansion ) )
                    {
                    // InternalMyBashParser.g:6428:4: ()
                    // InternalMyBashParser.g:6429:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrimaryItemAccess().getPrimaryItemAction_2_0(),
                      						current);
                      				
                    }

                    }

                    // InternalMyBashParser.g:6435:4: ( (lv_prefix_7_0= RULE_A_PREFIX ) )?
                    int alt120=2;
                    int LA120_0 = input.LA(1);

                    if ( (LA120_0==RULE_A_PREFIX) ) {
                        alt120=1;
                    }
                    switch (alt120) {
                        case 1 :
                            // InternalMyBashParser.g:6436:5: (lv_prefix_7_0= RULE_A_PREFIX )
                            {
                            // InternalMyBashParser.g:6436:5: (lv_prefix_7_0= RULE_A_PREFIX )
                            // InternalMyBashParser.g:6437:6: lv_prefix_7_0= RULE_A_PREFIX
                            {
                            lv_prefix_7_0=(Token)match(input,RULE_A_PREFIX,FOLLOW_21); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_prefix_7_0, grammarAccess.getPrimaryItemAccess().getPrefixA_PREFIXTerminalRuleCall_2_1_0());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getPrimaryItemRule());
                              						}
                              						setWithLastConsumed(
                              							current,
                              							"prefix",
                              							lv_prefix_7_0,
                              							"org.xtext.example.mydsl.MyBash.A_PREFIX");
                              					
                            }

                            }


                            }
                            break;

                    }

                    // InternalMyBashParser.g:6453:4: ( (lv_value_8_0= ruleExpansion ) )
                    // InternalMyBashParser.g:6454:5: (lv_value_8_0= ruleExpansion )
                    {
                    // InternalMyBashParser.g:6454:5: (lv_value_8_0= ruleExpansion )
                    // InternalMyBashParser.g:6455:6: lv_value_8_0= ruleExpansion
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPrimaryItemAccess().getValueExpansionParserRuleCall_2_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_8_0=ruleExpansion();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPrimaryItemRule());
                      						}
                      						set(
                      							current,
                      							"value",
                      							lv_value_8_0,
                      							"org.xtext.example.mydsl.MyBash.Expansion");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalMyBashParser.g:6474:3: this_PreDecrement_9= rulePreDecrement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryItemAccess().getPreDecrementParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PreDecrement_9=rulePreDecrement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PreDecrement_9;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryItem"


    // $ANTLR start "entryRuleVariableId"
    // InternalMyBashParser.g:6486:1: entryRuleVariableId returns [EObject current=null] : iv_ruleVariableId= ruleVariableId EOF ;
    public final EObject entryRuleVariableId() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableId = null;


        try {
            // InternalMyBashParser.g:6486:51: (iv_ruleVariableId= ruleVariableId EOF )
            // InternalMyBashParser.g:6487:2: iv_ruleVariableId= ruleVariableId EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableIdRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVariableId=ruleVariableId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableId; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableId"


    // $ANTLR start "ruleVariableId"
    // InternalMyBashParser.g:6493:1: ruleVariableId returns [EObject current=null] : ( () ( (otherlv_1= RULE_NAME ) ) ) ;
    public final EObject ruleVariableId() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMyBashParser.g:6499:2: ( ( () ( (otherlv_1= RULE_NAME ) ) ) )
            // InternalMyBashParser.g:6500:2: ( () ( (otherlv_1= RULE_NAME ) ) )
            {
            // InternalMyBashParser.g:6500:2: ( () ( (otherlv_1= RULE_NAME ) ) )
            // InternalMyBashParser.g:6501:3: () ( (otherlv_1= RULE_NAME ) )
            {
            // InternalMyBashParser.g:6501:3: ()
            // InternalMyBashParser.g:6502:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVariableIdAccess().getVariableIdAction_0(),
              					current);
              			
            }

            }

            // InternalMyBashParser.g:6508:3: ( (otherlv_1= RULE_NAME ) )
            // InternalMyBashParser.g:6509:4: (otherlv_1= RULE_NAME )
            {
            // InternalMyBashParser.g:6509:4: (otherlv_1= RULE_NAME )
            // InternalMyBashParser.g:6510:5: otherlv_1= RULE_NAME
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getVariableIdRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_NAME,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getVariableIdAccess().getRefAssignmentCrossReference_1_0());
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableId"


    // $ANTLR start "entryRuleFunctionName"
    // InternalMyBashParser.g:6525:1: entryRuleFunctionName returns [String current=null] : iv_ruleFunctionName= ruleFunctionName EOF ;
    public final String entryRuleFunctionName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFunctionName = null;


        try {
            // InternalMyBashParser.g:6525:52: (iv_ruleFunctionName= ruleFunctionName EOF )
            // InternalMyBashParser.g:6526:2: iv_ruleFunctionName= ruleFunctionName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionNameRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFunctionName=ruleFunctionName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunctionName.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionName"


    // $ANTLR start "ruleFunctionName"
    // InternalMyBashParser.g:6532:1: ruleFunctionName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_S_WORD_PART_0= RULE_S_WORD_PART ;
    public final AntlrDatatypeRuleToken ruleFunctionName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_S_WORD_PART_0=null;


        	enterRule();

        try {
            // InternalMyBashParser.g:6538:2: (this_S_WORD_PART_0= RULE_S_WORD_PART )
            // InternalMyBashParser.g:6539:2: this_S_WORD_PART_0= RULE_S_WORD_PART
            {
            this_S_WORD_PART_0=(Token)match(input,RULE_S_WORD_PART,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_S_WORD_PART_0);
              	
            }
            if ( state.backtracking==0 ) {

              		newLeafNode(this_S_WORD_PART_0, grammarAccess.getFunctionNameAccess().getS_WORD_PARTTerminalRuleCall());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionName"


    // $ANTLR start "entryRuleNewLine"
    // InternalMyBashParser.g:6549:1: entryRuleNewLine returns [String current=null] : iv_ruleNewLine= ruleNewLine EOF ;
    public final String entryRuleNewLine() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNewLine = null;


        try {
            // InternalMyBashParser.g:6549:47: (iv_ruleNewLine= ruleNewLine EOF )
            // InternalMyBashParser.g:6550:2: iv_ruleNewLine= ruleNewLine EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNewLineRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNewLine=ruleNewLine();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNewLine.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNewLine"


    // $ANTLR start "ruleNewLine"
    // InternalMyBashParser.g:6556:1: ruleNewLine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_HereDoc_0= ruleHereDoc )* this_NEW_LINE_1= RULE_NEW_LINE ) ;
    public final AntlrDatatypeRuleToken ruleNewLine() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_NEW_LINE_1=null;
        AntlrDatatypeRuleToken this_HereDoc_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:6562:2: ( ( (this_HereDoc_0= ruleHereDoc )* this_NEW_LINE_1= RULE_NEW_LINE ) )
            // InternalMyBashParser.g:6563:2: ( (this_HereDoc_0= ruleHereDoc )* this_NEW_LINE_1= RULE_NEW_LINE )
            {
            // InternalMyBashParser.g:6563:2: ( (this_HereDoc_0= ruleHereDoc )* this_NEW_LINE_1= RULE_NEW_LINE )
            // InternalMyBashParser.g:6564:3: (this_HereDoc_0= ruleHereDoc )* this_NEW_LINE_1= RULE_NEW_LINE
            {
            // InternalMyBashParser.g:6564:3: (this_HereDoc_0= ruleHereDoc )*
            loop122:
            do {
                int alt122=2;
                int LA122_0 = input.LA(1);

                if ( (LA122_0==RULE_HERE_DOC_START) ) {
                    alt122=1;
                }


                switch (alt122) {
            	case 1 :
            	    // InternalMyBashParser.g:6565:4: this_HereDoc_0= ruleHereDoc
            	    {
            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getNewLineAccess().getHereDocParserRuleCall_0());
            	      			
            	    }
            	    pushFollow(FOLLOW_4);
            	    this_HereDoc_0=ruleHereDoc();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_HereDoc_0);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				afterParserOrEnumRuleCall();
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop122;
                }
            } while (true);

            this_NEW_LINE_1=(Token)match(input,RULE_NEW_LINE,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_NEW_LINE_1);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_NEW_LINE_1, grammarAccess.getNewLineAccess().getNEW_LINETerminalRuleCall_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNewLine"


    // $ANTLR start "entryRuleListTerminator"
    // InternalMyBashParser.g:6587:1: entryRuleListTerminator returns [String current=null] : iv_ruleListTerminator= ruleListTerminator EOF ;
    public final String entryRuleListTerminator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleListTerminator = null;


        try {
            // InternalMyBashParser.g:6587:54: (iv_ruleListTerminator= ruleListTerminator EOF )
            // InternalMyBashParser.g:6588:2: iv_ruleListTerminator= ruleListTerminator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getListTerminatorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleListTerminator=ruleListTerminator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleListTerminator.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleListTerminator"


    // $ANTLR start "ruleListTerminator"
    // InternalMyBashParser.g:6594:1: ruleListTerminator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_NewLine_0= ruleNewLine | kw= Semicolon ) ;
    public final AntlrDatatypeRuleToken ruleListTerminator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_NewLine_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:6600:2: ( (this_NewLine_0= ruleNewLine | kw= Semicolon ) )
            // InternalMyBashParser.g:6601:2: (this_NewLine_0= ruleNewLine | kw= Semicolon )
            {
            // InternalMyBashParser.g:6601:2: (this_NewLine_0= ruleNewLine | kw= Semicolon )
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==RULE_NEW_LINE||LA123_0==RULE_HERE_DOC_START) ) {
                alt123=1;
            }
            else if ( (LA123_0==Semicolon) ) {
                alt123=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 123, 0, input);

                throw nvae;
            }
            switch (alt123) {
                case 1 :
                    // InternalMyBashParser.g:6602:3: this_NewLine_0= ruleNewLine
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getListTerminatorAccess().getNewLineParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_NewLine_0=ruleNewLine();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_NewLine_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalMyBashParser.g:6613:3: kw= Semicolon
                    {
                    kw=(Token)match(input,Semicolon,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getListTerminatorAccess().getSemicolonKeyword_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleListTerminator"


    // $ANTLR start "entryRuleMaybeNewLine"
    // InternalMyBashParser.g:6622:1: entryRuleMaybeNewLine returns [String current=null] : iv_ruleMaybeNewLine= ruleMaybeNewLine EOF ;
    public final String entryRuleMaybeNewLine() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMaybeNewLine = null;


        try {
            // InternalMyBashParser.g:6622:52: (iv_ruleMaybeNewLine= ruleMaybeNewLine EOF )
            // InternalMyBashParser.g:6623:2: iv_ruleMaybeNewLine= ruleMaybeNewLine EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMaybeNewLineRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMaybeNewLine=ruleMaybeNewLine();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMaybeNewLine.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMaybeNewLine"


    // $ANTLR start "ruleMaybeNewLine"
    // InternalMyBashParser.g:6629:1: ruleMaybeNewLine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_NewLine_0= ruleNewLine )? ;
    public final AntlrDatatypeRuleToken ruleMaybeNewLine() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_NewLine_0 = null;



        	enterRule();

        try {
            // InternalMyBashParser.g:6635:2: ( (this_NewLine_0= ruleNewLine )? )
            // InternalMyBashParser.g:6636:2: (this_NewLine_0= ruleNewLine )?
            {
            // InternalMyBashParser.g:6636:2: (this_NewLine_0= ruleNewLine )?
            int alt124=2;
            int LA124_0 = input.LA(1);

            if ( (LA124_0==RULE_NEW_LINE||LA124_0==RULE_HERE_DOC_START) ) {
                alt124=1;
            }
            switch (alt124) {
                case 1 :
                    // InternalMyBashParser.g:6637:3: this_NewLine_0= ruleNewLine
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getMaybeNewLineAccess().getNewLineParserRuleCall());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_NewLine_0=ruleNewLine();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_NewLine_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMaybeNewLine"


    // $ANTLR start "entryRuleHereDoc"
    // InternalMyBashParser.g:6651:1: entryRuleHereDoc returns [String current=null] : iv_ruleHereDoc= ruleHereDoc EOF ;
    public final String entryRuleHereDoc() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleHereDoc = null;


        try {
            // InternalMyBashParser.g:6651:47: (iv_ruleHereDoc= ruleHereDoc EOF )
            // InternalMyBashParser.g:6652:2: iv_ruleHereDoc= ruleHereDoc EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHereDocRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHereDoc=ruleHereDoc();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHereDoc.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHereDoc"


    // $ANTLR start "ruleHereDoc"
    // InternalMyBashParser.g:6658:1: ruleHereDoc returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_HERE_DOC_START_0= RULE_HERE_DOC_START (this_HERE_DOC_PART_1= RULE_HERE_DOC_PART | this_NEW_LINE_2= RULE_NEW_LINE )* this_HERE_DOC_END_3= RULE_HERE_DOC_END ) ;
    public final AntlrDatatypeRuleToken ruleHereDoc() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_HERE_DOC_START_0=null;
        Token this_HERE_DOC_PART_1=null;
        Token this_NEW_LINE_2=null;
        Token this_HERE_DOC_END_3=null;


        	enterRule();

        try {
            // InternalMyBashParser.g:6664:2: ( (this_HERE_DOC_START_0= RULE_HERE_DOC_START (this_HERE_DOC_PART_1= RULE_HERE_DOC_PART | this_NEW_LINE_2= RULE_NEW_LINE )* this_HERE_DOC_END_3= RULE_HERE_DOC_END ) )
            // InternalMyBashParser.g:6665:2: (this_HERE_DOC_START_0= RULE_HERE_DOC_START (this_HERE_DOC_PART_1= RULE_HERE_DOC_PART | this_NEW_LINE_2= RULE_NEW_LINE )* this_HERE_DOC_END_3= RULE_HERE_DOC_END )
            {
            // InternalMyBashParser.g:6665:2: (this_HERE_DOC_START_0= RULE_HERE_DOC_START (this_HERE_DOC_PART_1= RULE_HERE_DOC_PART | this_NEW_LINE_2= RULE_NEW_LINE )* this_HERE_DOC_END_3= RULE_HERE_DOC_END )
            // InternalMyBashParser.g:6666:3: this_HERE_DOC_START_0= RULE_HERE_DOC_START (this_HERE_DOC_PART_1= RULE_HERE_DOC_PART | this_NEW_LINE_2= RULE_NEW_LINE )* this_HERE_DOC_END_3= RULE_HERE_DOC_END
            {
            this_HERE_DOC_START_0=(Token)match(input,RULE_HERE_DOC_START,FOLLOW_89); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_HERE_DOC_START_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_HERE_DOC_START_0, grammarAccess.getHereDocAccess().getHERE_DOC_STARTTerminalRuleCall_0());
              		
            }
            // InternalMyBashParser.g:6673:3: (this_HERE_DOC_PART_1= RULE_HERE_DOC_PART | this_NEW_LINE_2= RULE_NEW_LINE )*
            loop125:
            do {
                int alt125=3;
                int LA125_0 = input.LA(1);

                if ( (LA125_0==RULE_HERE_DOC_PART) ) {
                    alt125=1;
                }
                else if ( (LA125_0==RULE_NEW_LINE) ) {
                    alt125=2;
                }


                switch (alt125) {
            	case 1 :
            	    // InternalMyBashParser.g:6674:4: this_HERE_DOC_PART_1= RULE_HERE_DOC_PART
            	    {
            	    this_HERE_DOC_PART_1=(Token)match(input,RULE_HERE_DOC_PART,FOLLOW_89); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_HERE_DOC_PART_1);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_HERE_DOC_PART_1, grammarAccess.getHereDocAccess().getHERE_DOC_PARTTerminalRuleCall_1_0());
            	      			
            	    }

            	    }
            	    break;
            	case 2 :
            	    // InternalMyBashParser.g:6682:4: this_NEW_LINE_2= RULE_NEW_LINE
            	    {
            	    this_NEW_LINE_2=(Token)match(input,RULE_NEW_LINE,FOLLOW_89); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_NEW_LINE_2);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_NEW_LINE_2, grammarAccess.getHereDocAccess().getNEW_LINETerminalRuleCall_1_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop125;
                }
            } while (true);

            this_HERE_DOC_END_3=(Token)match(input,RULE_HERE_DOC_END,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_HERE_DOC_END_3);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_HERE_DOC_END_3, grammarAccess.getHereDocAccess().getHERE_DOC_ENDTerminalRuleCall_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHereDoc"


    // $ANTLR start "ruleFollowWordOp"
    // InternalMyBashParser.g:6701:1: ruleFollowWordOp returns [Enumerator current=null] : ( (enumLiteral_0= PercentSignPercentSign ) | (enumLiteral_1= PercentSign ) | (enumLiteral_2= NumberSignNumberSign ) | (enumLiteral_3= NumberSign ) | (enumLiteral_4= CommaComma ) | (enumLiteral_5= Comma ) | (enumLiteral_6= CircumflexAccentCircumflexAccent ) | (enumLiteral_7= CircumflexAccent ) | (enumLiteral_8= ColonPlusSign ) | (enumLiteral_9= PlusSign ) | (enumLiteral_10= ColonHyphenMinus ) | (enumLiteral_11= HyphenMinus ) | (enumLiteral_12= ColonEqualsSign ) | (enumLiteral_13= EqualsSign ) | (enumLiteral_14= ColonQuestionMark ) | (enumLiteral_15= QuestionMark ) ) ;
    public final Enumerator ruleFollowWordOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;
        Token enumLiteral_11=null;
        Token enumLiteral_12=null;
        Token enumLiteral_13=null;
        Token enumLiteral_14=null;
        Token enumLiteral_15=null;


        	enterRule();

        try {
            // InternalMyBashParser.g:6707:2: ( ( (enumLiteral_0= PercentSignPercentSign ) | (enumLiteral_1= PercentSign ) | (enumLiteral_2= NumberSignNumberSign ) | (enumLiteral_3= NumberSign ) | (enumLiteral_4= CommaComma ) | (enumLiteral_5= Comma ) | (enumLiteral_6= CircumflexAccentCircumflexAccent ) | (enumLiteral_7= CircumflexAccent ) | (enumLiteral_8= ColonPlusSign ) | (enumLiteral_9= PlusSign ) | (enumLiteral_10= ColonHyphenMinus ) | (enumLiteral_11= HyphenMinus ) | (enumLiteral_12= ColonEqualsSign ) | (enumLiteral_13= EqualsSign ) | (enumLiteral_14= ColonQuestionMark ) | (enumLiteral_15= QuestionMark ) ) )
            // InternalMyBashParser.g:6708:2: ( (enumLiteral_0= PercentSignPercentSign ) | (enumLiteral_1= PercentSign ) | (enumLiteral_2= NumberSignNumberSign ) | (enumLiteral_3= NumberSign ) | (enumLiteral_4= CommaComma ) | (enumLiteral_5= Comma ) | (enumLiteral_6= CircumflexAccentCircumflexAccent ) | (enumLiteral_7= CircumflexAccent ) | (enumLiteral_8= ColonPlusSign ) | (enumLiteral_9= PlusSign ) | (enumLiteral_10= ColonHyphenMinus ) | (enumLiteral_11= HyphenMinus ) | (enumLiteral_12= ColonEqualsSign ) | (enumLiteral_13= EqualsSign ) | (enumLiteral_14= ColonQuestionMark ) | (enumLiteral_15= QuestionMark ) )
            {
            // InternalMyBashParser.g:6708:2: ( (enumLiteral_0= PercentSignPercentSign ) | (enumLiteral_1= PercentSign ) | (enumLiteral_2= NumberSignNumberSign ) | (enumLiteral_3= NumberSign ) | (enumLiteral_4= CommaComma ) | (enumLiteral_5= Comma ) | (enumLiteral_6= CircumflexAccentCircumflexAccent ) | (enumLiteral_7= CircumflexAccent ) | (enumLiteral_8= ColonPlusSign ) | (enumLiteral_9= PlusSign ) | (enumLiteral_10= ColonHyphenMinus ) | (enumLiteral_11= HyphenMinus ) | (enumLiteral_12= ColonEqualsSign ) | (enumLiteral_13= EqualsSign ) | (enumLiteral_14= ColonQuestionMark ) | (enumLiteral_15= QuestionMark ) )
            int alt126=16;
            switch ( input.LA(1) ) {
            case PercentSignPercentSign:
                {
                alt126=1;
                }
                break;
            case PercentSign:
                {
                alt126=2;
                }
                break;
            case NumberSignNumberSign:
                {
                alt126=3;
                }
                break;
            case NumberSign:
                {
                alt126=4;
                }
                break;
            case CommaComma:
                {
                alt126=5;
                }
                break;
            case Comma:
                {
                alt126=6;
                }
                break;
            case CircumflexAccentCircumflexAccent:
                {
                alt126=7;
                }
                break;
            case CircumflexAccent:
                {
                alt126=8;
                }
                break;
            case ColonPlusSign:
                {
                alt126=9;
                }
                break;
            case PlusSign:
                {
                alt126=10;
                }
                break;
            case ColonHyphenMinus:
                {
                alt126=11;
                }
                break;
            case HyphenMinus:
                {
                alt126=12;
                }
                break;
            case ColonEqualsSign:
                {
                alt126=13;
                }
                break;
            case EqualsSign:
                {
                alt126=14;
                }
                break;
            case ColonQuestionMark:
                {
                alt126=15;
                }
                break;
            case QuestionMark:
                {
                alt126=16;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 126, 0, input);

                throw nvae;
            }

            switch (alt126) {
                case 1 :
                    // InternalMyBashParser.g:6709:3: (enumLiteral_0= PercentSignPercentSign )
                    {
                    // InternalMyBashParser.g:6709:3: (enumLiteral_0= PercentSignPercentSign )
                    // InternalMyBashParser.g:6710:4: enumLiteral_0= PercentSignPercentSign
                    {
                    enumLiteral_0=(Token)match(input,PercentSignPercentSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFollowWordOpAccess().getGreedyRemoveSuffixEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getFollowWordOpAccess().getGreedyRemoveSuffixEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMyBashParser.g:6717:3: (enumLiteral_1= PercentSign )
                    {
                    // InternalMyBashParser.g:6717:3: (enumLiteral_1= PercentSign )
                    // InternalMyBashParser.g:6718:4: enumLiteral_1= PercentSign
                    {
                    enumLiteral_1=(Token)match(input,PercentSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFollowWordOpAccess().getRemoveSuffixEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getFollowWordOpAccess().getRemoveSuffixEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalMyBashParser.g:6725:3: (enumLiteral_2= NumberSignNumberSign )
                    {
                    // InternalMyBashParser.g:6725:3: (enumLiteral_2= NumberSignNumberSign )
                    // InternalMyBashParser.g:6726:4: enumLiteral_2= NumberSignNumberSign
                    {
                    enumLiteral_2=(Token)match(input,NumberSignNumberSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFollowWordOpAccess().getGreeyRemovePrefixEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getFollowWordOpAccess().getGreeyRemovePrefixEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalMyBashParser.g:6733:3: (enumLiteral_3= NumberSign )
                    {
                    // InternalMyBashParser.g:6733:3: (enumLiteral_3= NumberSign )
                    // InternalMyBashParser.g:6734:4: enumLiteral_3= NumberSign
                    {
                    enumLiteral_3=(Token)match(input,NumberSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFollowWordOpAccess().getRemovePrefixEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getFollowWordOpAccess().getRemovePrefixEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalMyBashParser.g:6741:3: (enumLiteral_4= CommaComma )
                    {
                    // InternalMyBashParser.g:6741:3: (enumLiteral_4= CommaComma )
                    // InternalMyBashParser.g:6742:4: enumLiteral_4= CommaComma
                    {
                    enumLiteral_4=(Token)match(input,CommaComma,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFollowWordOpAccess().getGreedyLowercaseEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getFollowWordOpAccess().getGreedyLowercaseEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalMyBashParser.g:6749:3: (enumLiteral_5= Comma )
                    {
                    // InternalMyBashParser.g:6749:3: (enumLiteral_5= Comma )
                    // InternalMyBashParser.g:6750:4: enumLiteral_5= Comma
                    {
                    enumLiteral_5=(Token)match(input,Comma,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFollowWordOpAccess().getLowercaseEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getFollowWordOpAccess().getLowercaseEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalMyBashParser.g:6757:3: (enumLiteral_6= CircumflexAccentCircumflexAccent )
                    {
                    // InternalMyBashParser.g:6757:3: (enumLiteral_6= CircumflexAccentCircumflexAccent )
                    // InternalMyBashParser.g:6758:4: enumLiteral_6= CircumflexAccentCircumflexAccent
                    {
                    enumLiteral_6=(Token)match(input,CircumflexAccentCircumflexAccent,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFollowWordOpAccess().getGreedyUppercaseEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getFollowWordOpAccess().getGreedyUppercaseEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalMyBashParser.g:6765:3: (enumLiteral_7= CircumflexAccent )
                    {
                    // InternalMyBashParser.g:6765:3: (enumLiteral_7= CircumflexAccent )
                    // InternalMyBashParser.g:6766:4: enumLiteral_7= CircumflexAccent
                    {
                    enumLiteral_7=(Token)match(input,CircumflexAccent,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFollowWordOpAccess().getUppercaseEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_7, grammarAccess.getFollowWordOpAccess().getUppercaseEnumLiteralDeclaration_7());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalMyBashParser.g:6773:3: (enumLiteral_8= ColonPlusSign )
                    {
                    // InternalMyBashParser.g:6773:3: (enumLiteral_8= ColonPlusSign )
                    // InternalMyBashParser.g:6774:4: enumLiteral_8= ColonPlusSign
                    {
                    enumLiteral_8=(Token)match(input,ColonPlusSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFollowWordOpAccess().getUseAlternateEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_8, grammarAccess.getFollowWordOpAccess().getUseAlternateEnumLiteralDeclaration_8());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalMyBashParser.g:6781:3: (enumLiteral_9= PlusSign )
                    {
                    // InternalMyBashParser.g:6781:3: (enumLiteral_9= PlusSign )
                    // InternalMyBashParser.g:6782:4: enumLiteral_9= PlusSign
                    {
                    enumLiteral_9=(Token)match(input,PlusSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFollowWordOpAccess().getUseAlternateEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_9, grammarAccess.getFollowWordOpAccess().getUseAlternateEnumLiteralDeclaration_9());
                      			
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalMyBashParser.g:6789:3: (enumLiteral_10= ColonHyphenMinus )
                    {
                    // InternalMyBashParser.g:6789:3: (enumLiteral_10= ColonHyphenMinus )
                    // InternalMyBashParser.g:6790:4: enumLiteral_10= ColonHyphenMinus
                    {
                    enumLiteral_10=(Token)match(input,ColonHyphenMinus,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFollowWordOpAccess().getUseDefaultEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_10, grammarAccess.getFollowWordOpAccess().getUseDefaultEnumLiteralDeclaration_10());
                      			
                    }

                    }


                    }
                    break;
                case 12 :
                    // InternalMyBashParser.g:6797:3: (enumLiteral_11= HyphenMinus )
                    {
                    // InternalMyBashParser.g:6797:3: (enumLiteral_11= HyphenMinus )
                    // InternalMyBashParser.g:6798:4: enumLiteral_11= HyphenMinus
                    {
                    enumLiteral_11=(Token)match(input,HyphenMinus,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFollowWordOpAccess().getUseDefaultEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_11, grammarAccess.getFollowWordOpAccess().getUseDefaultEnumLiteralDeclaration_11());
                      			
                    }

                    }


                    }
                    break;
                case 13 :
                    // InternalMyBashParser.g:6805:3: (enumLiteral_12= ColonEqualsSign )
                    {
                    // InternalMyBashParser.g:6805:3: (enumLiteral_12= ColonEqualsSign )
                    // InternalMyBashParser.g:6806:4: enumLiteral_12= ColonEqualsSign
                    {
                    enumLiteral_12=(Token)match(input,ColonEqualsSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFollowWordOpAccess().getAssignDefaultEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_12, grammarAccess.getFollowWordOpAccess().getAssignDefaultEnumLiteralDeclaration_12());
                      			
                    }

                    }


                    }
                    break;
                case 14 :
                    // InternalMyBashParser.g:6813:3: (enumLiteral_13= EqualsSign )
                    {
                    // InternalMyBashParser.g:6813:3: (enumLiteral_13= EqualsSign )
                    // InternalMyBashParser.g:6814:4: enumLiteral_13= EqualsSign
                    {
                    enumLiteral_13=(Token)match(input,EqualsSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFollowWordOpAccess().getAssignDefaultEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_13, grammarAccess.getFollowWordOpAccess().getAssignDefaultEnumLiteralDeclaration_13());
                      			
                    }

                    }


                    }
                    break;
                case 15 :
                    // InternalMyBashParser.g:6821:3: (enumLiteral_14= ColonQuestionMark )
                    {
                    // InternalMyBashParser.g:6821:3: (enumLiteral_14= ColonQuestionMark )
                    // InternalMyBashParser.g:6822:4: enumLiteral_14= ColonQuestionMark
                    {
                    enumLiteral_14=(Token)match(input,ColonQuestionMark,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFollowWordOpAccess().getErrorDefaultEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_14, grammarAccess.getFollowWordOpAccess().getErrorDefaultEnumLiteralDeclaration_14());
                      			
                    }

                    }


                    }
                    break;
                case 16 :
                    // InternalMyBashParser.g:6829:3: (enumLiteral_15= QuestionMark )
                    {
                    // InternalMyBashParser.g:6829:3: (enumLiteral_15= QuestionMark )
                    // InternalMyBashParser.g:6830:4: enumLiteral_15= QuestionMark
                    {
                    enumLiteral_15=(Token)match(input,QuestionMark,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFollowWordOpAccess().getErrorDefaultEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_15, grammarAccess.getFollowWordOpAccess().getErrorDefaultEnumLiteralDeclaration_15());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFollowWordOp"

    // $ANTLR start synpred1_InternalMyBashParser
    public final void synpred1_InternalMyBashParser_fragment() throws RecognitionException {   
        // InternalMyBashParser.g:699:7: ( LeftParenthesis )
        // InternalMyBashParser.g:699:8: LeftParenthesis
        {
        match(input,LeftParenthesis,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalMyBashParser

    // $ANTLR start synpred2_InternalMyBashParser
    public final void synpred2_InternalMyBashParser_fragment() throws RecognitionException {   
        // InternalMyBashParser.g:2691:4: ( Apostrophe | QuotationMark | DollarSignLeftCurlyBracket | DollarSignLeftParenthesisLeftParenthesis | LessThanSignLeftParenthesis | GreaterThanSignLeftParenthesis | LeftParenthesis | RULE_WORD_PART | RULE_VARIABLE | RULE_CS_START | RULE_S_WORD_PART )
        // InternalMyBashParser.g:
        {
        if ( input.LA(1)==DollarSignLeftParenthesisLeftParenthesis||input.LA(1)==DollarSignLeftCurlyBracket||input.LA(1)==LessThanSignLeftParenthesis||input.LA(1)==GreaterThanSignLeftParenthesis||input.LA(1)==QuotationMark||(input.LA(1)>=Apostrophe && input.LA(1)<=LeftParenthesis)||(input.LA(1)>=RULE_S_WORD_PART && input.LA(1)<=RULE_WORD_PART)||input.LA(1)==RULE_VARIABLE||input.LA(1)==RULE_CS_START ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }
    }
    // $ANTLR end synpred2_InternalMyBashParser

    // $ANTLR start synpred4_InternalMyBashParser
    public final void synpred4_InternalMyBashParser_fragment() throws RecognitionException {   
        // InternalMyBashParser.g:2865:3: ( Apostrophe | QuotationMark | DollarSignLeftCurlyBracket | DollarSignLeftParenthesisLeftParenthesis | LessThanSignLeftParenthesis | GreaterThanSignLeftParenthesis | RULE_WORD_PART | RULE_VARIABLE | RULE_CS_START )
        // InternalMyBashParser.g:
        {
        if ( input.LA(1)==DollarSignLeftParenthesisLeftParenthesis||input.LA(1)==DollarSignLeftCurlyBracket||input.LA(1)==LessThanSignLeftParenthesis||input.LA(1)==GreaterThanSignLeftParenthesis||input.LA(1)==QuotationMark||input.LA(1)==Apostrophe||input.LA(1)==RULE_WORD_PART||input.LA(1)==RULE_VARIABLE||input.LA(1)==RULE_CS_START ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }
    }
    // $ANTLR end synpred4_InternalMyBashParser

    // $ANTLR start synpred5_InternalMyBashParser
    public final void synpred5_InternalMyBashParser_fragment() throws RecognitionException {   
        // InternalMyBashParser.g:3013:4: ( ruleLiteralWordPart )
        // InternalMyBashParser.g:3013:5: ruleLiteralWordPart
        {
        pushFollow(FOLLOW_2);
        ruleLiteralWordPart();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_InternalMyBashParser

    // $ANTLR start synpred6_InternalMyBashParser
    public final void synpred6_InternalMyBashParser_fragment() throws RecognitionException {   
        // InternalMyBashParser.g:3104:4: ( ( RULE_WORD_PART ) )
        // InternalMyBashParser.g:3104:5: ( RULE_WORD_PART )
        {
        // InternalMyBashParser.g:3104:5: ( RULE_WORD_PART )
        // InternalMyBashParser.g:3105:5: RULE_WORD_PART
        {
        match(input,RULE_WORD_PART,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred6_InternalMyBashParser

    // $ANTLR start synpred7_InternalMyBashParser
    public final void synpred7_InternalMyBashParser_fragment() throws RecognitionException {   
        // InternalMyBashParser.g:3152:4: ( ( ( ( RULE_WORD_PART ) ) | ( Apostrophe ( ( RULE_WORD_PART ) )? Apostrophe ) | ( QuotationMark ( ( RULE_WORD_PART ) )* QuotationMark ) ) )
        // InternalMyBashParser.g:3152:5: ( ( ( RULE_WORD_PART ) ) | ( Apostrophe ( ( RULE_WORD_PART ) )? Apostrophe ) | ( QuotationMark ( ( RULE_WORD_PART ) )* QuotationMark ) )
        {
        // InternalMyBashParser.g:3152:5: ( ( ( RULE_WORD_PART ) ) | ( Apostrophe ( ( RULE_WORD_PART ) )? Apostrophe ) | ( QuotationMark ( ( RULE_WORD_PART ) )* QuotationMark ) )
        int alt129=3;
        switch ( input.LA(1) ) {
        case RULE_WORD_PART:
            {
            alt129=1;
            }
            break;
        case Apostrophe:
            {
            alt129=2;
            }
            break;
        case QuotationMark:
            {
            alt129=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 129, 0, input);

            throw nvae;
        }

        switch (alt129) {
            case 1 :
                // InternalMyBashParser.g:3153:5: ( ( RULE_WORD_PART ) )
                {
                // InternalMyBashParser.g:3153:5: ( ( RULE_WORD_PART ) )
                // InternalMyBashParser.g:3154:6: ( RULE_WORD_PART )
                {
                // InternalMyBashParser.g:3154:6: ( RULE_WORD_PART )
                // InternalMyBashParser.g:3155:7: RULE_WORD_PART
                {
                match(input,RULE_WORD_PART,FOLLOW_2); if (state.failed) return ;

                }


                }


                }
                break;
            case 2 :
                // InternalMyBashParser.g:3159:5: ( Apostrophe ( ( RULE_WORD_PART ) )? Apostrophe )
                {
                // InternalMyBashParser.g:3159:5: ( Apostrophe ( ( RULE_WORD_PART ) )? Apostrophe )
                // InternalMyBashParser.g:3160:6: Apostrophe ( ( RULE_WORD_PART ) )? Apostrophe
                {
                match(input,Apostrophe,FOLLOW_56); if (state.failed) return ;
                // InternalMyBashParser.g:3161:6: ( ( RULE_WORD_PART ) )?
                int alt127=2;
                int LA127_0 = input.LA(1);

                if ( (LA127_0==RULE_WORD_PART) ) {
                    alt127=1;
                }
                switch (alt127) {
                    case 1 :
                        // InternalMyBashParser.g:3162:7: ( RULE_WORD_PART )
                        {
                        // InternalMyBashParser.g:3162:7: ( RULE_WORD_PART )
                        // InternalMyBashParser.g:3163:8: RULE_WORD_PART
                        {
                        match(input,RULE_WORD_PART,FOLLOW_57); if (state.failed) return ;

                        }


                        }
                        break;

                }

                match(input,Apostrophe,FOLLOW_2); if (state.failed) return ;

                }


                }
                break;
            case 3 :
                // InternalMyBashParser.g:3169:5: ( QuotationMark ( ( RULE_WORD_PART ) )* QuotationMark )
                {
                // InternalMyBashParser.g:3169:5: ( QuotationMark ( ( RULE_WORD_PART ) )* QuotationMark )
                // InternalMyBashParser.g:3170:6: QuotationMark ( ( RULE_WORD_PART ) )* QuotationMark
                {
                match(input,QuotationMark,FOLLOW_58); if (state.failed) return ;
                // InternalMyBashParser.g:3171:6: ( ( RULE_WORD_PART ) )*
                loop128:
                do {
                    int alt128=2;
                    int LA128_0 = input.LA(1);

                    if ( (LA128_0==RULE_WORD_PART) ) {
                        alt128=1;
                    }


                    switch (alt128) {
                	case 1 :
                	    // InternalMyBashParser.g:3172:7: ( RULE_WORD_PART )
                	    {
                	    // InternalMyBashParser.g:3172:7: ( RULE_WORD_PART )
                	    // InternalMyBashParser.g:3173:8: RULE_WORD_PART
                	    {
                	    match(input,RULE_WORD_PART,FOLLOW_58); if (state.failed) return ;

                	    }


                	    }
                	    break;

                	default :
                	    break loop128;
                    }
                } while (true);

                match(input,QuotationMark,FOLLOW_2); if (state.failed) return ;

                }


                }
                break;

        }


        }
    }
    // $ANTLR end synpred7_InternalMyBashParser

    // Delegated rules

    public final boolean synpred4_InternalMyBashParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalMyBashParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalMyBashParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalMyBashParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalMyBashParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalMyBashParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalMyBashParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalMyBashParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalMyBashParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalMyBashParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalMyBashParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalMyBashParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA5 dfa5 = new DFA5(this);
    protected DFA27 dfa27 = new DFA27(this);
    protected DFA47 dfa47 = new DFA47(this);
    protected DFA50 dfa50 = new DFA50(this);
    protected DFA54 dfa54 = new DFA54(this);
    protected DFA57 dfa57 = new DFA57(this);
    static final String dfa_1s = "\10\uffff";
    static final String dfa_2s = "\1\3\1\uffff\1\3\5\uffff";
    static final String dfa_3s = "\2\137\1\4\1\uffff\3\137\1\uffff";
    static final String dfa_4s = "\1\156\1\160\1\153\1\uffff\2\160\1\156\1\uffff";
    static final String dfa_5s = "\3\uffff\1\2\3\uffff\1\1";
    static final String dfa_6s = "\10\uffff}>";
    static final String[] dfa_7s = {
            "\1\2\16\uffff\1\1",
            "\1\5\17\uffff\1\6\1\4",
            "\3\7\5\uffff\2\7\3\uffff\1\7\2\uffff\1\7\4\uffff\2\7\20\uffff\3\7\1\uffff\2\7\2\uffff\2\7\1\uffff\3\7\5\uffff\1\7\4\uffff\2\7\3\uffff\2\7\10\uffff\1\7\1\uffff\1\7\5\uffff\1\7\3\uffff\1\7\3\uffff\3\7\1\uffff\1\7\4\uffff\1\7",
            "",
            "\1\5\17\uffff\1\6\1\4",
            "\1\5\17\uffff\1\6\1\4",
            "\1\2\16\uffff\1\1",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 108:5: ( ruleNewLine ( (lv_commands_4_0= ruleSimpleList ) ) )*";
        }
    }
    static final String dfa_8s = "\1\7\1\137\1\4\1\uffff\3\137\1\uffff";
    static final String dfa_9s = "\1\156\1\160\1\154\1\uffff\2\160\1\156\1\uffff";
    static final String[] dfa_10s = {
            "\5\3\2\uffff\1\3\32\uffff\2\3\21\uffff\2\3\14\uffff\1\3\21\uffff\1\3\2\uffff\1\2\14\uffff\1\3\1\uffff\1\1",
            "\1\5\17\uffff\1\6\1\4",
            "\3\7\5\3\2\7\1\3\2\uffff\1\7\2\uffff\1\7\4\uffff\2\7\16\uffff\2\3\3\7\1\uffff\2\7\2\uffff\2\7\1\uffff\3\7\3\uffff\2\3\1\7\4\uffff\2\7\3\uffff\2\7\1\3\7\uffff\1\7\1\uffff\1\7\5\uffff\1\7\1\uffff\1\3\1\uffff\1\7\3\uffff\3\7\1\uffff\1\7\4\uffff\1\7\1\3",
            "",
            "\1\5\17\uffff\1\6\1\4",
            "\1\5\17\uffff\1\6\1\4",
            "\1\2\16\uffff\1\1",
            ""
    };
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[][] dfa_10 = unpackEncodedStringArray(dfa_10s);

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_10;
        }
        public String getDescription() {
            return "()* loopback of 243:4: ( ruleNewLine ( (lv_commands_3_0= ruleSimpleList ) ) )*";
        }
    }
    static final String dfa_11s = "\13\uffff";
    static final String dfa_12s = "\4\12\1\uffff\1\137\1\12\1\uffff\3\137";
    static final String dfa_13s = "\1\52\3\156\1\uffff\1\160\1\153\1\uffff\2\160\1\156";
    static final String dfa_14s = "\4\uffff\1\2\2\uffff\1\1\3\uffff";
    static final String dfa_15s = "\13\uffff}>";
    static final String[] dfa_16s = {
            "\1\4\3\uffff\1\3\32\uffff\1\2\1\1",
            "\1\4\1\uffff\1\7\7\uffff\1\7\27\uffff\1\7\7\uffff\1\7\17\uffff\1\7\3\uffff\2\7\25\uffff\1\6\3\uffff\2\7\1\uffff\1\7\4\uffff\1\7\2\uffff\1\5",
            "\1\4\1\uffff\1\7\7\uffff\1\7\27\uffff\1\7\7\uffff\1\7\17\uffff\1\7\3\uffff\2\7\25\uffff\1\6\3\uffff\2\7\1\uffff\1\7\4\uffff\1\7\2\uffff\1\5",
            "\1\4\1\uffff\1\7\7\uffff\1\7\27\uffff\1\7\7\uffff\1\7\17\uffff\1\7\3\uffff\2\7\25\uffff\1\6\3\uffff\2\7\1\uffff\1\7\4\uffff\1\7\2\uffff\1\5",
            "",
            "\1\11\17\uffff\1\12\1\10",
            "\1\4\1\uffff\1\7\7\uffff\1\7\27\uffff\1\7\7\uffff\1\7\17\uffff\1\7\3\uffff\2\7\31\uffff\2\7\1\uffff\1\7\4\uffff\1\7",
            "",
            "\1\11\17\uffff\1\12\1\10",
            "\1\11\17\uffff\1\12\1\10",
            "\1\6\16\uffff\1\5"
    };

    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final char[] dfa_12 = DFA.unpackEncodedStringToUnsignedChars(dfa_12s);
    static final char[] dfa_13 = DFA.unpackEncodedStringToUnsignedChars(dfa_13s);
    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final short[] dfa_15 = DFA.unpackEncodedString(dfa_15s);
    static final short[][] dfa_16 = unpackEncodedStringArray(dfa_16s);

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = dfa_11;
            this.eof = dfa_11;
            this.min = dfa_12;
            this.max = dfa_13;
            this.accept = dfa_14;
            this.special = dfa_15;
            this.transition = dfa_16;
        }
        public String getDescription() {
            return "()* loopback of 1427:4: ( (lv_patterns_7_0= ruleCasePatternContinue ) )*";
        }
    }
    static final String dfa_17s = "\1\14\1\137\1\14\2\uffff\3\137";
    static final String dfa_18s = "\1\156\1\160\1\153\2\uffff\2\160\1\156";
    static final String dfa_19s = "\3\uffff\1\2\1\1\3\uffff";
    static final String[] dfa_20s = {
            "\1\4\7\uffff\1\4\27\uffff\1\4\7\uffff\1\4\17\uffff\1\4\3\uffff\1\4\1\uffff\1\3\24\uffff\1\2\3\uffff\2\4\1\uffff\1\4\4\uffff\1\4\2\uffff\1\1",
            "\1\6\17\uffff\1\7\1\5",
            "\1\4\7\uffff\1\4\27\uffff\1\4\7\uffff\1\4\17\uffff\1\4\3\uffff\1\4\1\uffff\1\3\30\uffff\2\4\1\uffff\1\4\4\uffff\1\4",
            "",
            "",
            "\1\6\17\uffff\1\7\1\5",
            "\1\6\17\uffff\1\7\1\5",
            "\1\2\16\uffff\1\1"
    };
    static final char[] dfa_17 = DFA.unpackEncodedStringToUnsignedChars(dfa_17s);
    static final char[] dfa_18 = DFA.unpackEncodedStringToUnsignedChars(dfa_18s);
    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final short[][] dfa_20 = unpackEncodedStringArray(dfa_20s);

    class DFA47 extends DFA {

        public DFA47(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 47;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_17;
            this.max = dfa_18;
            this.accept = dfa_19;
            this.special = dfa_6;
            this.transition = dfa_20;
        }
        public String getDescription() {
            return "()* loopback of 2464:3: ( ruleMaybeNewLine ( (lv_words_3_0= ruleWord ) ) )*";
        }
    }
    static final String dfa_21s = "\44\uffff";
    static final String dfa_22s = "\1\14\43\uffff";
    static final String dfa_23s = "\1\7\12\0\31\uffff";
    static final String dfa_24s = "\1\156\12\0\31\uffff";
    static final String dfa_25s = "\13\uffff\1\1\1\2\27\uffff";
    static final String dfa_26s = "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\31\uffff}>";
    static final String[] dfa_27s = {
            "\5\14\1\7\1\uffff\1\14\5\uffff\1\4\2\uffff\1\14\21\uffff\2\14\1\uffff\1\10\7\uffff\1\11\7\uffff\2\14\2\uffff\1\14\1\uffff\1\14\1\uffff\1\3\2\uffff\1\14\1\2\1\13\1\14\6\uffff\1\14\11\uffff\2\14\2\uffff\2\14\1\uffff\1\14\1\12\1\1\1\uffff\1\5\4\uffff\1\6\1\14\1\uffff\1\14",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            ""
    };

    static final short[] dfa_21 = DFA.unpackEncodedString(dfa_21s);
    static final short[] dfa_22 = DFA.unpackEncodedString(dfa_22s);
    static final char[] dfa_23 = DFA.unpackEncodedStringToUnsignedChars(dfa_23s);
    static final char[] dfa_24 = DFA.unpackEncodedStringToUnsignedChars(dfa_24s);
    static final short[] dfa_25 = DFA.unpackEncodedString(dfa_25s);
    static final short[] dfa_26 = DFA.unpackEncodedString(dfa_26s);
    static final short[][] dfa_27 = unpackEncodedStringArray(dfa_27s);

    class DFA50 extends DFA {

        public DFA50(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 50;
            this.eot = dfa_21;
            this.eof = dfa_22;
            this.min = dfa_23;
            this.max = dfa_24;
            this.accept = dfa_25;
            this.special = dfa_26;
            this.transition = dfa_27;
        }
        public String getDescription() {
            return "2690:3: ( ( Apostrophe | QuotationMark | DollarSignLeftCurlyBracket | DollarSignLeftParenthesisLeftParenthesis | LessThanSignLeftParenthesis | GreaterThanSignLeftParenthesis | LeftParenthesis | RULE_WORD_PART | RULE_VARIABLE | RULE_CS_START | RULE_S_WORD_PART )=> (lv_value_3_0= ruleAssignable ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA50_0 = input.LA(1);

                         
                        int index50_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA50_0==RULE_WORD_PART) ) {s = 1;}

                        else if ( (LA50_0==Apostrophe) ) {s = 2;}

                        else if ( (LA50_0==QuotationMark) ) {s = 3;}

                        else if ( (LA50_0==DollarSignLeftCurlyBracket) ) {s = 4;}

                        else if ( (LA50_0==RULE_VARIABLE) ) {s = 5;}

                        else if ( (LA50_0==RULE_CS_START) ) {s = 6;}

                        else if ( (LA50_0==DollarSignLeftParenthesisLeftParenthesis) ) {s = 7;}

                        else if ( (LA50_0==LessThanSignLeftParenthesis) ) {s = 8;}

                        else if ( (LA50_0==GreaterThanSignLeftParenthesis) ) {s = 9;}

                        else if ( (LA50_0==RULE_S_WORD_PART) ) {s = 10;}

                        else if ( (LA50_0==LeftParenthesis) && (synpred2_InternalMyBashParser())) {s = 11;}

                        else if ( (LA50_0==EOF||(LA50_0>=Done && LA50_0<=Then)||LA50_0==SemicolonSemicolonAmpersand||LA50_0==AmpersandAmpersand||(LA50_0>=SemicolonAmpersand && LA50_0<=SemicolonSemicolon)||(LA50_0>=Do && LA50_0<=Fi)||LA50_0==VerticalLineAmpersand||LA50_0==VerticalLineVerticalLine||LA50_0==Ampersand||LA50_0==RightParenthesis||LA50_0==Semicolon||(LA50_0>=VerticalLine && LA50_0<=RightCurlyBracket)||(LA50_0>=RULE_NEW_LINE && LA50_0<=RULE_WS)||LA50_0==RULE_NAME||LA50_0==RULE_CS_END||LA50_0==RULE_HERE_DOC_START) ) {s = 12;}

                         
                        input.seek(index50_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA50_1 = input.LA(1);

                         
                        int index50_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalMyBashParser()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index50_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA50_2 = input.LA(1);

                         
                        int index50_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalMyBashParser()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index50_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA50_3 = input.LA(1);

                         
                        int index50_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalMyBashParser()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index50_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA50_4 = input.LA(1);

                         
                        int index50_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalMyBashParser()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index50_4);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA50_5 = input.LA(1);

                         
                        int index50_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalMyBashParser()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index50_5);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA50_6 = input.LA(1);

                         
                        int index50_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalMyBashParser()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index50_6);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA50_7 = input.LA(1);

                         
                        int index50_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalMyBashParser()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index50_7);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA50_8 = input.LA(1);

                         
                        int index50_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalMyBashParser()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index50_8);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA50_9 = input.LA(1);

                         
                        int index50_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalMyBashParser()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index50_9);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA50_10 = input.LA(1);

                         
                        int index50_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalMyBashParser()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index50_10);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 50, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_28s = "\66\uffff";
    static final String dfa_29s = "\1\12\65\uffff";
    static final String dfa_30s = "\1\7\11\0\54\uffff";
    static final String dfa_31s = "\1\156\11\0\54\uffff";
    static final String dfa_32s = "\12\uffff\1\2\52\uffff\1\1";
    static final String dfa_33s = "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\54\uffff}>";
    static final String[] dfa_34s = {
            "\5\12\1\7\2\12\5\uffff\1\4\2\uffff\1\12\1\uffff\1\12\17\uffff\3\12\1\10\1\12\1\uffff\2\12\1\uffff\2\12\1\11\1\uffff\2\12\1\uffff\1\12\2\uffff\2\12\1\uffff\2\12\1\uffff\1\12\1\uffff\1\3\2\uffff\1\12\1\2\2\12\4\uffff\1\12\1\uffff\2\12\1\uffff\1\12\6\uffff\2\12\1\uffff\3\12\1\uffff\2\12\1\1\1\uffff\1\5\2\uffff\1\12\1\uffff\1\6\1\12\1\uffff\1\12",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            ""
    };

    static final short[] dfa_28 = DFA.unpackEncodedString(dfa_28s);
    static final short[] dfa_29 = DFA.unpackEncodedString(dfa_29s);
    static final char[] dfa_30 = DFA.unpackEncodedStringToUnsignedChars(dfa_30s);
    static final char[] dfa_31 = DFA.unpackEncodedStringToUnsignedChars(dfa_31s);
    static final short[] dfa_32 = DFA.unpackEncodedString(dfa_32s);
    static final short[] dfa_33 = DFA.unpackEncodedString(dfa_33s);
    static final short[][] dfa_34 = unpackEncodedStringArray(dfa_34s);

    class DFA54 extends DFA {

        public DFA54(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 54;
            this.eot = dfa_28;
            this.eof = dfa_29;
            this.min = dfa_30;
            this.max = dfa_31;
            this.accept = dfa_32;
            this.special = dfa_33;
            this.transition = dfa_34;
        }
        public String getDescription() {
            return "()+ loopback of 2864:2: ( ( Apostrophe | QuotationMark | DollarSignLeftCurlyBracket | DollarSignLeftParenthesisLeftParenthesis | LessThanSignLeftParenthesis | GreaterThanSignLeftParenthesis | RULE_WORD_PART | RULE_VARIABLE | RULE_CS_START )=> (lv_elements_0_0= ruleWordElement ) )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA54_1 = input.LA(1);

                         
                        int index54_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalMyBashParser()) ) {s = 53;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index54_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA54_2 = input.LA(1);

                         
                        int index54_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalMyBashParser()) ) {s = 53;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index54_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA54_3 = input.LA(1);

                         
                        int index54_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalMyBashParser()) ) {s = 53;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index54_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA54_4 = input.LA(1);

                         
                        int index54_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalMyBashParser()) ) {s = 53;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index54_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA54_5 = input.LA(1);

                         
                        int index54_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalMyBashParser()) ) {s = 53;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index54_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA54_6 = input.LA(1);

                         
                        int index54_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalMyBashParser()) ) {s = 53;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index54_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA54_7 = input.LA(1);

                         
                        int index54_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalMyBashParser()) ) {s = 53;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index54_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA54_8 = input.LA(1);

                         
                        int index54_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalMyBashParser()) ) {s = 53;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index54_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA54_9 = input.LA(1);

                         
                        int index54_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalMyBashParser()) ) {s = 53;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index54_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 54, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_35s = "\1\14\2\uffff\1\14\1\uffff\1\14\1\0\1\uffff";
    static final String dfa_36s = "\1\153\2\uffff\1\153\1\uffff\1\153\1\0\1\uffff";
    static final String dfa_37s = "\1\uffff\2\1\1\uffff\1\3\2\uffff\1\2";
    static final String dfa_38s = "\1\0\5\uffff\1\1\1\uffff}>";
    static final String[] dfa_39s = {
            "\1\4\7\uffff\1\4\27\uffff\1\4\7\uffff\1\4\17\uffff\1\3\3\uffff\1\2\33\uffff\1\1\1\uffff\1\4\4\uffff\1\4",
            "",
            "",
            "\1\7\7\uffff\1\7\27\uffff\1\7\7\uffff\1\7\17\uffff\1\6\37\uffff\1\5\1\uffff\1\7\4\uffff\1\7",
            "",
            "\1\7\7\uffff\1\7\27\uffff\1\7\7\uffff\1\7\17\uffff\1\6\37\uffff\1\5\1\uffff\1\7\4\uffff\1\7",
            "\1\uffff",
            ""
    };
    static final char[] dfa_35 = DFA.unpackEncodedStringToUnsignedChars(dfa_35s);
    static final char[] dfa_36 = DFA.unpackEncodedStringToUnsignedChars(dfa_36s);
    static final short[] dfa_37 = DFA.unpackEncodedString(dfa_37s);
    static final short[] dfa_38 = DFA.unpackEncodedString(dfa_38s);
    static final short[][] dfa_39 = unpackEncodedStringArray(dfa_39s);

    class DFA57 extends DFA {

        public DFA57(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 57;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_35;
            this.max = dfa_36;
            this.accept = dfa_37;
            this.special = dfa_38;
            this.transition = dfa_39;
        }
        public String getDescription() {
            return "3011:2: ( ( ( ruleLiteralWordPart )=>this_LiteralWordPart_0= ruleLiteralWordPart ) | this_DQString_1= ruleDQString | this_Expansion_2= ruleExpansion )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA57_0 = input.LA(1);

                         
                        int index57_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA57_0==RULE_WORD_PART) && (synpred5_InternalMyBashParser())) {s = 1;}

                        else if ( (LA57_0==Apostrophe) && (synpred5_InternalMyBashParser())) {s = 2;}

                        else if ( (LA57_0==QuotationMark) ) {s = 3;}

                        else if ( (LA57_0==DollarSignLeftParenthesisLeftParenthesis||LA57_0==DollarSignLeftCurlyBracket||LA57_0==LessThanSignLeftParenthesis||LA57_0==GreaterThanSignLeftParenthesis||LA57_0==RULE_VARIABLE||LA57_0==RULE_CS_START) ) {s = 4;}

                         
                        input.seek(index57_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA57_6 = input.LA(1);

                         
                        int index57_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_InternalMyBashParser()) ) {s = 2;}

                        else if ( (true) ) {s = 7;}

                         
                        input.seek(index57_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 57, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x41D9B80006123072L,0x0000085C44140318L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000000L,0x0000400080000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x41D9B80006123070L,0x0000085C44140318L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0010100000101010L,0x0000085C00000110L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000800002L,0x0000000000020084L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x41D9B80006123070L,0x0000485CC4140318L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000002L,0x0000000008000001L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00D9B80002103012L,0x0000085C40140110L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000010L,0x0000000800000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0010100000101012L,0x0000085C00000110L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0010100000101010L,0x0000095800000310L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0010100240101010L,0x000008DC60005318L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0010100000101010L,0x0000085800000110L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x8000000000000000L,0x0000400080000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0010100000101410L,0x0000485880000310L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0010100000101410L,0x0000085800000310L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000060000004400L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000400L,0x0000400080000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0010100000101010L,0x0000085800000310L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0010100000101010L,0x0000485880000310L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000002L,0x0000000008000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x2000000000000300L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000004000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0010100240101010L,0x000008DC60025318L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0010100248101010L,0x000008DC60005318L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x1000000000000000L,0x0000400080020000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x1000000000000000L,0x0000400080000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0010100000101010L,0x0000485880020110L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x00C9880002002000L,0x0000000000140000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0010100000101010L,0x0000085840000110L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0010100000101010L,0x0000485880000110L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000000000880000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0010100000101012L,0x0000085800000310L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000002L,0x0000000000880000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0010100000101012L,0x0000085800000110L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000002L,0x0000001000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000002L,0x0000001000000110L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000100L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000010L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000800002L,0x0000000000000004L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0004000000000002L,0x0000020000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0010100000101010L,0x0000085800000510L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x0000000440600820L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000000L,0x0000000440600800L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x080001E900280002L,0x0000000002A9F060L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0010100240101010L,0x000008DC60405B18L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x080001E900280002L,0x000000000229F060L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0010100240101012L,0x000008DC60005318L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x04000014A1418000L,0x0000000000080002L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200000L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0002000000040002L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0020400000000002L,0x0000000000140000L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0040200000000002L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000000000002L,0x0000000000005000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008840L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000240000002L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000000000000000L,0x0001800080000000L});

}