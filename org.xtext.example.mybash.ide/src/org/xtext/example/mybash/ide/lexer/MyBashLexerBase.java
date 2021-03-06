package org.xtext.example.mybash.ide.lexer;

import static org.xtext.example.mydsl.lexer.MyBashLexer.S_ARITH;
import static org.xtext.example.mydsl.lexer.MyBashLexer.S_FOR_ARITH;
import static org.xtext.example.mydsl.parser.antlr.lexer.InternalMyBashLexer.Apostrophe;
import static org.xtext.example.mydsl.parser.antlr.lexer.InternalMyBashLexer.For;
import static org.xtext.example.mydsl.parser.antlr.lexer.InternalMyBashLexer.LeftParenthesisLeftParenthesis;
import static org.xtext.example.mydsl.parser.antlr.lexer.InternalMyBashLexer.QuotationMark;
import static org.xtext.example.mydsl.parser.antlr.lexer.InternalMyBashLexer.RULE_HERE_DOC_WORD;
import static org.xtext.example.mydsl.parser.antlr.lexer.InternalMyBashLexer.RULE_SL_COMMENT;
import static org.xtext.example.mydsl.parser.antlr.lexer.InternalMyBashLexer.RULE_S_WORD_PART;

import java.util.Stack;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.xtext.example.mydsl.lexer.model.HeredocState;
import org.xtext.example.mydsl.lexer.model.Word;

import com.google.common.base.Strings;

public abstract class MyBashLexerBase {

	private Stack<Integer> stateStack = new Stack<>();
	private Stack<BashLexerState> lexerStateStack = new Stack<>();

	protected BashLexerState currentLexerState = new BashLexerState(this);

	private Token nextToken = null;

	public Token nextToken() {
		try {
			Token token = null;
			if (nextToken != null) {
				token = nextToken;
				nextToken = null;
			}

			while (token == null) {
				token = yylex();
			}
			//if (token.getText() != null) {
			//	System.out.println("[" + token.getType() + "]["
			//			+ org.eclipse.xtext.util.Strings.convertToJavaString(token.getText(), false) + "][s="
			//			+ ((CommonToken) token).getStartIndex() + "][e=" + ((CommonToken) token).getStopIndex() + "]");
			//}
			return token;
		} catch (java.io.IOException e) {
			System.err.println("shouldn't happen: " + e.getMessage());
			return Token.EOF_TOKEN;
		}
	}

	protected boolean inWord() {
		return currentLexerState.currentWord != null;
	}

	protected Token comment() {
		currentLexerState.newComment();
		return newToken(RULE_SL_COMMENT, Token.HIDDEN_CHANNEL);
	}

	protected Token hereDocPart() {
		int newType = currentLexerState.newHereDocPart();
		return newToken(newType);
	}

	protected void appendHeredocWordPart() {
		currentLexerState.appendHeredocWordPart();
	}

	protected void appendHeredocWordLength() {
		currentLexerState.appendHeredocWordLength();
	}

	protected void quoteHeredocWord() {
		if (currentLexerState.currentHeredocWord != null) {
			currentLexerState.currentHeredocWord.setQuote(true);
		}
	}

	protected Token hereDocWordSpace() {
		if (currentLexerState.currentHeredocWord != null) {
			popState();
			nextToken = space();
			return getHeredocWord();
		} else {
			return space();
		}
	}

	protected Token hereDocPartLine() {
		int newType = currentLexerState.newHereDocPartLine();
		if (newType != -1) {
			return newToken(newType);
		}
		return null;
	}

	protected Token getHeredocWord() {
		if (currentLexerState.currentHeredocWord != null) {
			Token token = currentLexerState.currentHeredocWord.createToken();
			currentLexerState.hereDocQueue
					.add(new HeredocState(token.getText(), currentLexerState.currentHeredocWord.isQuote()));
			currentLexerState.currentHeredocWord = null;
			return token;
		}
		return null;
	}

	protected Token hereDocNewLine() {
		int newType = currentLexerState.newHereDocNewLine();
		return newToken(newType);
	}

	protected Token solidusInBString() {
		int newType = currentLexerState.solidusInBString();
		return wordPart(newType);
	}

	protected Token assignableWord() {
		int newType = currentLexerState.newAssignableWord(RULE_S_WORD_PART);
		return newToken(newType);
	}

	protected Token newEof() {
		currentLexerState.gotWordSplit();
		if (currentLexerState.currentHeredocWord != null) {
			Token token = currentLexerState.currentHeredocWord.createToken();
			nextToken = Token.EOF_TOKEN;
			return token;
		}
		return Token.EOF_TOKEN;
	}

	protected Token newline() {
		int newType = currentLexerState.newNewLine();
		return newToken(newType);
	}

	protected Token newToken(int type, String text, int start, int end) {
		CommonToken token = new CommonToken(type, text);
		token.setChannel(Token.DEFAULT_CHANNEL);
		token.setStartIndex(start);
		token.setStopIndex(end);
		return token;
	}

	protected void enterSubShell() {
		lexerStateStack.push(currentLexerState);
		currentLexerState = new BashLexerState(this);
	}

	protected void exitSubShell() {
		currentLexerState = lexerStateStack.pop();
	}

	protected Token number(int type) {
		int newType = currentLexerState.newNumber(type);
		return newToken(newType);
	}

	protected Token unaryOperator(int type) {
		int newType = currentLexerState.newUnaryOperator(type);
		return newToken(newType);
	}

	protected Token binaryOperator(int type) {
		int newType = currentLexerState.newBinaryOperator(type);
		return newToken(newType);
	}

	protected Token binaryOperatorNotWord(int type) {
		int newType = currentLexerState.newBinaryOperatorNotWord(type);
		return newToken(newType);
	}

	protected Token spaceInCondition() {
		int newType = currentLexerState.newSpaceInCondition();
		return newToken(newType, Token.HIDDEN_CHANNEL);
	}

	protected Token leftParenthesis() {
		int newType = currentLexerState.newLeftParenthesis();
		return newToken(newType);
	}

	protected Token conditionExpressionSplit(int type) {
		int newType = currentLexerState.newConditionExpressionSplit(type);
		return newToken(newType);
	}

	protected Token operator(int type) {
		int newType = currentLexerState.newOperator(type, false);
		return newToken(newType);
	}

	protected Token operatorNewCommand(int type) {
		int newType = currentLexerState.newOperator(type, true);
		return newToken(newType);
	}

	protected Token space() {
		int newType = currentLexerState.newSpace();
		return newToken(newType, Token.HIDDEN_CHANNEL);
	}

	protected Token operatorDParentheses() {
		if (currentLexerState.lastTokenMatch(For)) {
			pushState(S_FOR_ARITH);
		} else {
			pushState(S_ARITH);
		}
		return newToken(LeftParenthesisLeftParenthesis);
	}

	protected Token wordPart(int type) {
		int newType = currentLexerState.newWordPart(type);
		return newToken(newType);
	}

	protected Token name(boolean followEqual) {
		int newType = currentLexerState.newName(followEqual);
		return newToken(newType);
	}

	protected Token equal() {
		int newType = currentLexerState.newEqual();
		return newToken(newType);
	}

	protected Token keyword(int type, boolean name) {
		int newType = currentLexerState.newKeyword(type, false, name);
		return newToken(newType);
	}

	protected Token keywordNewState(int type, boolean name, int newState) {
		int newType = currentLexerState.newKeyword(type, false, name);
		if (newType == type) {
			pushState(newState);
		}
		return newToken(newType);
	}

	protected Token keywordNewCommand(int type, boolean name) {
		int newType = currentLexerState.newKeyword(type, true, name);
		return newToken(newType);
	}

	protected Token keyword(int type) {
		return keyword(type, true);
	}

	protected Token keywordNewCommand(int type) {
		return keywordNewCommand(type, true);
	}

	protected Token newToken(int type, String text, int channel) {
		if (type == QuotationMark || type == Apostrophe) {
			text = "";
		}

		CommonToken token = new CommonToken(type, text);
		token.setChannel(channel);
		token.setStartIndex(this.getCharIndex());
		token.setStopIndex(this.getCharIndex() + yylength() - 1);
		return token;
	}

	protected Token newToken(int type, String text) {
		return newToken(type, text, Token.DEFAULT_CHANNEL);
	}

	protected Token newToken(int type, int channel) {
		return newToken(type, yytext(), channel);
	}

	protected Token newToken(int type) {
		return newToken(type, yytext());
	}

	protected void pushState(int state) {
		int oldState = yystate();
		yybegin(state);
		stateStack.push(oldState);
	}

	protected void pushStateUntilNextWord(int state) {
		currentLexerState.nextWord = new Word() {
			@Override
			public void endWord() {
				super.endWord();
				popState();
			}
		};

		pushState(state);
	}

	protected void popState() {
		int oldState = stateStack.pop();
		yybegin(oldState);
	}

	protected void popUntil(int state) {

		while (!stateStack.isEmpty()) {
			if (yystate() != state) {
				popState();
			} else {
				popState();
				return;
			}
		}
		System.out.println(yystate());
	}

	protected abstract int yylength();

	protected abstract int getCharIndex();

	protected abstract String yytext();

	protected abstract int yystate();

	protected abstract void yybegin(int state);
	
	protected abstract void yypushback(int length);

	protected abstract Token yylex() throws java.io.IOException;

}
