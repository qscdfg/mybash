package org.xtext.example.mydsl.lexer;

import org.antlr.runtime.*;
import static org.xtext.example.mydsl.parser.antlr.lexer.InternalMyBashLexer.*;
import static org.antlr.runtime.Token.*;
import java.util.Stack;
%%


%public
%class MyBashLexer
%extends MyBashLexerBase
%unicode
%char
%type Token
%eofval{
		return newEof();
%eofval}

%{
    public int getCharIndex() {
    	return this.yychar;
    }
%}

Metacharacter		=	[|&;()<> \t]
Space				=	[\t ]
NewLine				=	\r? \n
NotInWord			=	[$\"\'`] | [<>]"("
ContinuedLine = "\\" {NewLine}
EscapedChar = "\\" [^\n\r]
WordFirst = [[^]--[|&;()<> \t\r\n\\\$#\"\'`]] | {EscapedChar}
WordAfter =  {WordFirst} | "#" 
StringPart = {WordAfter} | {Metacharacter} | "=" | "\'" | {NewLine} 
BStringPart = [[^]--[\\\$\"\'\}\/<>`]]
RStringPart = [[^]--[\\\$\"\'()`]]
CStringPart = [[^]--[\\\$\"\'()`]]
CPStringPart = [[^]--[\\\$\"\'()`)]]
Word = {WordFirst}{WordAfter}*
AssignmentWord = [a-zA-Z_][a-zA-Z0-9_]*
Variable = "$" {AssignmentWord} | "$@" | "$$" | "$#" | "$"[0-9] | "$?" | "$!" | "$*" | "$-" | "$_"
IntegerLiteral = [0] | ([1-9][0-9]*)




%state 	S_PE_NAME
%state 	S_DQ_STRING
%state 	S_CS_D
%state 	S_CS
%state 	S_S_TEST
%state 	S_ARITH
%state 	S_B_STRING
%xstate S_PE_START
%state 	S_ARITH
%state 	S_FOR_ARITH
%state 	S_COND
%state 	S_REGULAR
%state 	S_HERE_DOC_E
%state 	S_HERE_DOC
%state 	S_ARITH_P
%xstate S_AFTER_ARITH_NAME
%state 	S_COND_P
%state	S_REGULAR_P
%state S_B_ARITH
%state S_SQ
%state S_ARRAY
%state S_CS_P
%state S_A_ARITH
%state S_A_ARITH_S
%state S_COMMENTS
%state S_HERE_DOC_WORD
%state S_HEREDOC_DQ
%state S_HEREDOC_AE
%state S_HEREDOC_CS
%state S_HEREDOC_CS_P
%state S_HEREDOC_PE
%state S_HEREDOC_Q

%%

<S_COND_P> {
	")"										{ popState(); return conditionExpressionSplit( RightParenthesis ); }
}


<S_COND, S_COND_P> {
	"]]"									{ popUntil( S_COND ); currentLexerState.currentConditionExpression=null; return wordPart( RightSquareBracketRightSquareBracket ); }
	"-"[abcdefghkprstuwxGLNOSovRzn]			{ return unaryOperator( RULE_C_S_OP ); }
	"-ef"									{ return binaryOperator( RULE_C_B_OP ); }
	"-nt"									{ return binaryOperator( RULE_C_B_OP ); }
	"-ot"									{ return binaryOperator( RULE_C_B_OP ); }
	
	
	"=="									{ return binaryOperator( RULE_C_B_OP ); }
	"="										{ return binaryOperator( RULE_C_B_OP ); }
	"!="									{ return binaryOperator( RULE_C_B_OP ); }
	"=~"									{ Token type = binaryOperator( EqualsSignTilde ); pushStateUntilNextWord( S_REGULAR ); return type; }
	
	"<"										{ return binaryOperatorNotWord( RULE_C_B_OP ); }
	">"										{ return binaryOperatorNotWord( RULE_C_B_OP ); }
	"-eq"									{ return binaryOperator( RULE_C_B_OP ); }
	"-ne"									{ return binaryOperator( RULE_C_B_OP ); }
	"-lt"									{ return binaryOperator( RULE_C_B_OP ); }
	"-le"									{ return binaryOperator( RULE_C_B_OP ); }
	"-gt"									{ return binaryOperator( RULE_C_B_OP ); }
	"-ge"									{ return binaryOperator( RULE_C_B_OP ); }
	
	
	"("										{ pushState( S_COND_P ); return conditionExpressionSplit( LeftParenthesis ); }	
	"&&"									{ return conditionExpressionSplit( AmpersandAmpersand ); }
	"||"									{ return conditionExpressionSplit( VerticalLineVerticalLine ); }
	{Space}									{ return spaceInCondition(); }	
}

<S_REGULAR> {
	{Space}									{ return spaceInCondition(); }
	"(" 									{ pushState( S_REGULAR_P ); return wordPart( LeftParenthesis ); }
	"|" 									{ return wordPart( VerticalLine ); }
}

<S_REGULAR_P> {
	"$"										{ return wordPart( RULE_WORD_PART ); }	
	{RStringPart}+							{ return wordPart( RULE_WORD_PART ); }	
	")"										{ popState(); return wordPart( RightParenthesis ); }
}


<S_CS_P> {
	")"										{ popState(); exitSubShell(); return wordPart( RightParenthesis ); }
}

<S_CS_D> {
	")" 									{ popState(); exitSubShell(); return wordPart( RULE_CS_END ); } 											  	
}

<S_CS> {
	"`" 									{ popState(); exitSubShell(); return wordPart( RULE_CS_END ); } 											  	
}

<S_COMMENTS> {
	"#"[^\r\n]*								{ popState(); return comment(); }
}

<YYINITIAL, S_CS, S_CS_D, S_CS_P> {
	"#"										{ if( inWord() ) { return wordPart(RULE_WORD_PART);} else { yypushback(1); pushState(S_COMMENTS); } }
	
	{ContinuedLine}							{ return newToken( RULE_C_LINE, HIDDEN_CHANNEL ); }
	
	{AssignmentWord}/("="|"+="){WordAfter}*{NotInWord}?	{ return name( true ); }
	
	{AssignmentWord} / "["	{WordAfter}*{NotInWord}?	{ 	
												Token token = name(true); 
												if(token.getType() == RULE_NAME) {
													enterSubShell();
													pushState(S_A_ARITH_S);
												}
												return token;
											}
	
	"!" 									{  return keywordNewCommand( ExclamationMark , false );  }
	"case"									{  Token token = keyword( Case ); if(token.getType() == Case) {currentLexerState.inCaseP=true;} return token;}
	"coproc"								{  return keyword( -1 );  }
	"do"									{  return keywordNewCommand( Do );  }
	"done"									{  return keywordNewCommand( Done );  }
	"elif"									{  return keywordNewCommand( Elif );  }
	"else"									{  return keywordNewCommand( Else );  }
	"esac"									{  Token token = keywordNewCommand( Esac ); if(token.getType() == Esac) {currentLexerState.inCaseP=false;} return token;}
	"fi"									{  return keywordNewCommand( Fi );  }
	"for"									{  return keyword( For );  }
	"function"								{  return keyword( Function );  }
	"if"									{  return keywordNewCommand( If );  }
	"in"									{  return keyword( In );  }
	"select"								{  return keyword( -1 );  }
	"then"									{  return keywordNewCommand( Then );  }
	"until"									{  return keywordNewCommand( -1 );  }
	"while"									{  return keywordNewCommand( While );  }	
	"{"										{  return keywordNewCommand( LeftCurlyBracket , false );  }
	"}"										{  return keywordNewCommand( RightCurlyBracket , false );  }
	"[["									{  return keywordNewState( LeftSquareBracketLeftSquareBracket , false , S_COND );  }	
	"]]"									{ currentLexerState.currentConditionExpression=null; return keyword( RightSquareBracketRightSquareBracket ); }
	
	"export"								{ return assignableWord(); }
	"local"									{ return assignableWord(); }
	"eval"									{ return assignableWord(); }
	"declare"								{ return assignableWord(); }
	"let"									{ return assignableWord(); }
	
	
	{AssignmentWord}						{ return name( false ); }
	
	
	
	
	
	{IntegerLiteral} / (">" | "<")          { return wordPart( RULE_I_NUMBER ); }
	
	{IntegerLiteral}						{ return number(RULE_I_NUMBER); }
	
	"|" 									{ return operatorNewCommand( VerticalLine ); }
	"&" 									{ return operatorNewCommand( Ampersand ); }
	";" 									{ return operatorNewCommand( Semicolon ); }
	"(" 									{ currentLexerState.inCaseP=false; return leftParenthesis(); }
	")" 									{ return operatorNewCommand( RightParenthesis ); }
	"<" 									{ return operator( LessThanSign ); }
	">" 									{ return operator( GreaterThanSign ); }
	
	{NewLine} 								{ return newline(); }	
	
	"||"									{ return operatorNewCommand( VerticalLineVerticalLine ); }	
	"&&"									{ return operatorNewCommand( AmpersandAmpersand ); }	
	
	">&"									{ return operator( GreaterThanSignAmpersand ); }
	"<&"									{ return operator( LessThanSignAmpersand ); }
	"<<"									{ pushState(S_HERE_DOC_WORD); return operator( LessThanSignLessThanSign );  }
	">>"									{ return operator( GreaterThanSignGreaterThanSign ); }
	"<>"									{ return operator( LessThanSignGreaterThanSign ); }
	">|"									{ return operator( GreaterThanSignVerticalLine ); }
	"<|"									{ return operator( LessThanSignVerticalLine ); }
	"&>"									{ return operator( AmpersandGreaterThanSign ); }
	"&>>"									{ return operator( AmpersandGreaterThanSignGreaterThanSign ); }
	
	
	";;"									{ currentLexerState.inCaseP=true; return operator( SemicolonSemicolon );}
	";&"									{ currentLexerState.inCaseP=true; return operator( SemicolonAmpersand );}
	";;&"									{ currentLexerState.inCaseP=true; return operator( SemicolonSemicolonAmpersand );}
	
	"(("									{ return operatorDParentheses(); }
	
	<S_B_STRING, S_ARITH, S_A_ARITH, S_FOR_ARITH, S_B_ARITH, S_ARITH_P, S_COND, S_COND_P, S_REGULAR, S_REGULAR_P, S_ARRAY> {
		">("								{ pushState(S_CS_P); enterSubShell(); return wordPart( GreaterThanSignLeftParenthesis ); }	
		"<("								{ pushState(S_CS_P); enterSubShell(); return wordPart( LessThanSignLeftParenthesis ); }	
	}
	<S_DQ_STRING , S_B_STRING, S_ARITH, S_A_ARITH, S_FOR_ARITH, S_B_ARITH, S_ARITH_P, S_COND, S_COND_P, S_REGULAR, S_REGULAR_P, S_ARRAY, S_HERE_DOC_E> {
		{Variable}							{ return wordPart( RULE_VARIABLE ); }	
		
		"${"								{ pushState(S_PE_START); enterSubShell(); return wordPart( DollarSignLeftCurlyBracket ); }
		"$("								{ pushState(S_CS_D); Token token = wordPart( RULE_CS_START ); enterSubShell(); return token; }	
		"`"									{ pushState(S_CS); Token token = wordPart( RULE_CS_START ); enterSubShell(); return token; }
		"$(("								{ pushState(S_ARITH); return wordPart( DollarSignLeftParenthesisLeftParenthesis ); }
	}
	

	
	<S_B_STRING, S_ARITH, S_A_ARITH, S_B_ARITH, S_FOR_ARITH, S_ARITH_P, S_COND, S_COND_P, S_REGULAR, S_REGULAR_P, S_ARRAY> {
		"\""								{ pushState(S_DQ_STRING); return wordPart( QuotationMark ); }		
		\'									{ pushState(S_SQ); return wordPart( Apostrophe );}
	}
	
	("="|"+=")	/ {WordAfter}*	{NotInWord}?		{ return equal(); }
	
	<S_ARRAY> {
		{Space}								{ return space(); }
		
		<S_COND, S_COND_P, S_REGULAR> {		
			"$"								{ return wordPart( RULE_WORD_PART ); }
			{Word}							{ return wordPart( RULE_S_WORD_PART ); }	
			{Word} / {NotInWord}			{ return wordPart( RULE_WORD_PART ); }
		}
	}
}

<S_A_ARITH_S> {
	"["										{ yybegin(S_A_ARITH); return wordPart(LeftSquareBracket); }
}

<S_A_ARITH> {
	"]"										{ popState(); Token token = wordPart(RightSquareBracket); exitSubShell();  return token;}
}

<S_ARRAY> {
	")"										{ popState(); exitSubShell(); return wordPart( RightParenthesis ); }
}

<S_PE_START> {
	"!"										{ yybegin(S_PE_NAME); return wordPart( ExclamationMark); }
	"#"										{ yybegin(S_PE_NAME); return wordPart( NumberSign ); }
	""										{ yybegin(S_PE_NAME); }
}



<S_PE_NAME> {	
	{AssignmentWord}						{ return wordPart( RULE_NAME ); }
	{IntegerLiteral}						{ return wordPart( RULE_I_NUMBER ); }
	"*"										{ return wordPart( Asterisk ); }
	"}"										{ popState(); exitSubShell(); return wordPart( RightCurlyBracket); }
	"["										{ pushState(S_ARITH); return wordPart( LeftSquareBracket ); }
	"[" / [@*]								{ return wordPart( LeftSquareBracket ); }
	"@"										{ return wordPart( CommercialAt ); }	
	"]"										{ return wordPart( RightSquareBracket ); }
	"%"										{ yybegin(S_B_STRING); return wordPart( PercentSign ); }
	"%%"									{ yybegin(S_B_STRING); return wordPart( PercentSignPercentSign ); }	
	"#"										{ yybegin(S_B_STRING); return wordPart( NumberSign ); }
	"##"									{ yybegin(S_B_STRING); return wordPart( NumberSignNumberSign ); }
	","										{ yybegin(S_B_STRING); return wordPart( Comma ); }
	",,"									{ yybegin(S_B_STRING); return wordPart( CommaComma ); }
	"^"										{ yybegin(S_B_STRING); return wordPart( CircumflexAccent ); }
	"^^"									{ yybegin(S_B_STRING); return wordPart( CircumflexAccentCircumflexAccent ); }
	
	"-"										{ yybegin(S_B_STRING); return wordPart( HyphenMinus ); }
	"+"										{ yybegin(S_B_STRING); return wordPart( PlusSign ); }
	":-"									{ yybegin(S_B_STRING); return wordPart( ColonHyphenMinus ); }
	":+"									{ yybegin(S_B_STRING); return wordPart( ColonPlusSign ); }	
	"="										{ yybegin(S_B_STRING); return wordPart( EqualsSign ); }
	"?"										{ yybegin(S_B_STRING); return wordPart( QuestionMark ); }
	":="									{ yybegin(S_B_STRING); return wordPart( ColonEqualsSign ); }
	":?"									{ yybegin(S_B_STRING); return wordPart( ColonQuestionMark ); }	
	
	"/"										{ currentLexerState.canbeSolidus = true; yybegin(S_B_STRING); return wordPart( Solidus ); }
	"//"									{ currentLexerState.canbeSolidus = true; yybegin(S_B_STRING); return wordPart( SolidusSolidus ); }
	":"										{ yybegin(S_B_ARITH); return wordPart( Colon ); }
}


<S_DQ_STRING> {
	"\""									{ popState(); return wordPart( QuotationMark ); }
	"$"										{ return wordPart( RULE_WORD_PART ); }	
	{ContinuedLine}							{ return newToken( RULE_C_LINE, HIDDEN_CHANNEL ); }
	{StringPart}+							{ return wordPart( RULE_WORD_PART ); }	
}

<S_SQ> {
	[^\']+									{ return wordPart( RULE_WORD_PART ); }
	\' 										{ popState(); return wordPart( Apostrophe );}
}


<S_B_STRING> {
	"$"										{ return wordPart( RULE_WORD_PART ); }	
	"<"										{ return wordPart( RULE_WORD_PART ); }	
	">"										{ return wordPart( RULE_WORD_PART ); }	
	"/"										{ return solidusInBString(); }
	{BStringPart}+							{ return wordPart( RULE_WORD_PART ); }
	"}"										{ popState(); exitSubShell(); return wordPart( RightCurlyBracket ); }	
}

<S_FOR_ARITH> {
	";"										{ return wordPart( Semicolon ); }	
}

<S_AFTER_ARITH_NAME> {
	"++"									{ popState(); return wordPart( PlusSignPlusSign ); }
	"--"	 								{ popState(); return wordPart( HyphenMinusHyphenMinus ); }
	{Space}									{ return space(); }
	""										{ popState(); }	
}


<S_ARITH, S_A_ARITH, S_FOR_ARITH, S_ARITH_P, S_B_ARITH> {
	"10#"									{ return wordPart( RULE_A_PREFIX ); }
	{Space}									{ return space(); }		
	{AssignmentWord}						{ pushState( S_AFTER_ARITH_NAME ); return wordPart( RULE_NAME ); }
	{IntegerLiteral}						{ return wordPart( RULE_I_NUMBER ); }
	"("										{ pushState(S_ARITH_P); return wordPart( LeftParenthesis ); }
	"+"										{ return wordPart( PlusSign ); }
	"-"										{ return wordPart( HyphenMinus ); }
	"*"										{ return wordPart( Asterisk ); }
	"/"										{ return wordPart( Solidus ); }
	"%"										{ return wordPart( PercentSign ); }
	"~"										{ return wordPart( Tilde ); }
	"!"										{ return wordPart( ExclamationMark ); }
	
	"++"	/ {AssignmentWord}				{ return wordPart( PlusSignPlusSign ); }
	"--"	/ {AssignmentWord} 				{ return wordPart( HyphenMinusHyphenMinus ); }
	
	"**"									{ return wordPart( AsteriskAsterisk ); }
	"<<"									{ return wordPart( LessThanSignLessThanSign ); }
	">>"									{ return wordPart( GreaterThanSignGreaterThanSign ); }
	"<="									{ return wordPart( LessThanSignEqualsSign ); }
	">="									{ return wordPart( GreaterThanSignEqualsSign ); }
	"<"										{ return wordPart( LessThanSign ); }
	">"										{ return wordPart( GreaterThanSign ); }
	"=="									{ return wordPart( EqualsSignEqualsSign ); }
	"!="									{ return wordPart( ExclamationMarkEqualsSign ); }
	"&"										{ return wordPart( Ampersand ); }
	"^"										{ return wordPart( CircumflexAccent ); }
	"|"										{ return wordPart( VerticalLine ); }
	"&&"									{ return wordPart( AmpersandAmpersand ); }
	"||"									{ return wordPart( VerticalLineVerticalLine ); }
	"?"										{ return wordPart( QuestionMark ); }
	":"										{ return wordPart( Colon ); }
	"="										{ return wordPart( EqualsSign ); }
	"*="									{ return wordPart( AsteriskEqualsSign ); }
	"/="									{ return wordPart( SolidusEqualsSign ); }
	"%="									{ return wordPart( PercentSignEqualsSign ); }
	"+="									{ return wordPart( PlusSignEqualsSign ); }
	"-="									{ return wordPart( HyphenMinusEqualsSign ); }
	"<<="									{ return wordPart( LessThanSignLessThanSignEqualsSign ); }
	">>="									{ return wordPart( GreaterThanSignGreaterThanSignEqualsSign ); }
	"&="									{ return wordPart( AmpersandEqualsSign ); }
	"^="									{ return wordPart( CircumflexAccentEqualsSign ); }
	"|="									{ return wordPart( VerticalLineEqualsSign ); }
	","										{ return wordPart( Comma ); }	
	"]"										{ popState(); return wordPart( RightSquareBracket ); }	
}

<S_ARITH, S_FOR_ARITH> {
	"))"									{ popState(); return wordPart( RightParenthesisRightParenthesis ); }
}

<S_ARITH_P> {
	")"										{ popState(); return wordPart( RightParenthesis ); }
}

<S_B_ARITH> {
	"}"										{ popState(); exitSubShell(); return wordPart( RightCurlyBracket ); }
}

<S_HERE_DOC> {
	[^\r\n]+								{ return hereDocPartLine(); }
	{NewLine}								{ return hereDocNewLine(); }
}

<S_HERE_DOC_E> {
	[^\r\n$`]+								{ return hereDocPart(); }
	"$"										{ return hereDocPart(); }	
	{NewLine}								{ popState(); return hereDocNewLine(); }
}


<S_HERE_DOC_WORD> {
	{Space}									{ return hereDocWordSpace(); }	
	
	<S_HEREDOC_DQ, S_HEREDOC_AE, S_HEREDOC_CS, S_HEREDOC_CS_P, S_HEREDOC_PE> {
		"${"								{ pushState(S_HEREDOC_PE); appendHeredocWordPart(); }
		"$("								{ pushState(S_HEREDOC_CS_P); appendHeredocWordPart(); }	
		"`"									{ pushState(S_HEREDOC_CS); appendHeredocWordPart(); }
		"$(("								{ pushState(S_HEREDOC_AE); appendHeredocWordPart(); }
	}
	
	"\""									{ pushState(S_HEREDOC_DQ); appendHeredocWordLength(); quoteHeredocWord(); }		
	\' 										{ pushState(S_HEREDOC_Q); appendHeredocWordLength(); quoteHeredocWord(); }	
	
	
	"$"										{ appendHeredocWordPart();}
	{Word}									{ appendHeredocWordPart();}
	[|&;()<>] | {NewLine}					{ popState(); yypushback(yylength()); return getHeredocWord(); }
}

<S_HEREDOC_AE, S_HEREDOC_CS, S_HEREDOC_CS_P, S_HEREDOC_PE> {
	"\""									{ pushState(S_HEREDOC_DQ); appendHeredocWordLength(); }		
	\' 										{ pushState(S_HEREDOC_Q);appendHeredocWordLength();}	
}

<S_HEREDOC_DQ> {
	"\""									{ popState();  appendHeredocWordLength(); }
	"$"										{ appendHeredocWordPart(); }	
	{ContinuedLine}							{ }
	{StringPart}+							{ appendHeredocWordPart(); }	
}

<S_HEREDOC_Q> {
	[^\']+									{ appendHeredocWordPart(); }
	\' 										{ popState(); appendHeredocWordLength(); }
}

<S_HEREDOC_PE> {
	"}"										{ popState();  appendHeredocWordPart(); }
	"$"										{ appendHeredocWordPart(); }	
	{ContinuedLine}							{ }
	{BStringPart}+							{ appendHeredocWordPart(); }
}

<S_HEREDOC_CS> {
	"`"										{ popState();  appendHeredocWordPart(); }
	"$"										{ appendHeredocWordPart(); }	
	{ContinuedLine}							{ }
	{CStringPart}+							{ appendHeredocWordPart(); }
}

<S_HEREDOC_CS_P> {
	")"										{ popState();  appendHeredocWordPart(); }
	"$"										{ appendHeredocWordPart(); }	
	{ContinuedLine}							{ }
	{CPStringPart}+							{ appendHeredocWordPart(); }
}

<S_HEREDOC_AE> {
	"))"									{ popState();  /*12345*/ appendHeredocWordPart(); }
	"$"										{ appendHeredocWordPart(); }	
	{ContinuedLine}							{ }
	{CPStringPart}+							{ appendHeredocWordPart(); }
}


[^]											{ return operator( INVALID_TOKEN_TYPE ); }






