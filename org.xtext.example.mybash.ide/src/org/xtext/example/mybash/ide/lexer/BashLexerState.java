package org.xtext.example.mybash.ide.lexer;

import static org.xtext.example.mydsl.lexer.MyBashLexer.*;
import static org.xtext.example.mydsl.lexer.MyBashLexer.S_HERE_DOC;
import static org.xtext.example.mydsl.parser.antlr.lexer.InternalMyBashLexer.Case;
import static org.xtext.example.mydsl.parser.antlr.lexer.InternalMyBashLexer.EqualsSign;
import static org.xtext.example.mydsl.parser.antlr.lexer.InternalMyBashLexer.For;
import static org.xtext.example.mydsl.parser.antlr.lexer.InternalMyBashLexer.Function;
import static org.xtext.example.mydsl.parser.antlr.lexer.InternalMyBashLexer.GreaterThanSignAmpersand;
import static org.xtext.example.mydsl.parser.antlr.lexer.InternalMyBashLexer.LeftParenthesis;
import static org.xtext.example.mydsl.parser.antlr.lexer.InternalMyBashLexer.LessThanSignAmpersand;
import static org.xtext.example.mydsl.parser.antlr.lexer.InternalMyBashLexer.RULE_HERE_DOC_END;
import static org.xtext.example.mydsl.parser.antlr.lexer.InternalMyBashLexer.RULE_HERE_DOC_PART;
import static org.xtext.example.mydsl.parser.antlr.lexer.InternalMyBashLexer.RULE_HERE_DOC_START;
import static org.xtext.example.mydsl.parser.antlr.lexer.InternalMyBashLexer.RULE_HIDEN_NEW_LINE;
import static org.xtext.example.mydsl.parser.antlr.lexer.InternalMyBashLexer.RULE_I_NUMBER;
import static org.xtext.example.mydsl.parser.antlr.lexer.InternalMyBashLexer.RULE_NAME;
import static org.xtext.example.mydsl.parser.antlr.lexer.InternalMyBashLexer.RULE_NEW_LINE;
import static org.xtext.example.mydsl.parser.antlr.lexer.InternalMyBashLexer.RULE_S_WORD_PART;
import static org.xtext.example.mydsl.parser.antlr.lexer.InternalMyBashLexer.RULE_WORD_PART;
import static org.xtext.example.mydsl.parser.antlr.lexer.InternalMyBashLexer.RULE_WS;
import static org.xtext.example.mydsl.parser.antlr.lexer.InternalMyBashLexer.Solidus;

import java.util.LinkedList;
import java.util.Queue;

import org.xtext.example.mydsl.lexer.model.Command;
import org.xtext.example.mydsl.lexer.model.ConditionExpression;
import org.xtext.example.mydsl.lexer.model.HereDocWord;
import org.xtext.example.mydsl.lexer.model.HeredocState;
import org.xtext.example.mydsl.lexer.model.Word;

public class BashLexerState {

	public Command currentCommand;
	public Word currentWord;
	public Word nextWord;
	public ConditionExpression currentConditionExpression;
	public HereDocWord currentHeredocWord;

	private int lastTokenType;
	private int tokenBeforLastType;
	protected Queue<HeredocState> hereDocQueue = new LinkedList<>();

	private boolean hereDocEndFound = false;
	private int lastNewLineType = RULE_NEW_LINE;

	protected boolean canbeSolidus;
	protected boolean inCaseP;

	private MyBashLexerBase lexer;

	protected int solidusInBString() {
		if (canbeSolidus) {
			canbeSolidus = false;
			return newWordPart(Solidus);
		}
		return newWordPart(RULE_WORD_PART);
	}

	public BashLexerState(MyBashLexerBase lexer) {
		super();
		this.lexer = lexer;
	}

	public boolean lastTokenMatch(int type) {
		return lastTokenType == type;
	}

	public void reEnter() {
		gotWordPart();
	}

	public int newUnaryOperator(int type) {
		if (getCurrentConditionExpression().canBeUnary()) {
			getCurrentConditionExpression().appendUnary();
			return type;
		}
		return newWordPart(RULE_WORD_PART);
	}

	public int newBinaryOperator(int type) {
		if (getCurrentConditionExpression().canBeBinary()) {
			getCurrentConditionExpression().appendBinary();
			return type;
		}
		return newWordPart(RULE_WORD_PART);
	}

	public int newBinaryOperatorNotWord(int type) {
		getCurrentConditionExpression().appendBinary();
		return type;
	}

	public int newSpaceInCondition() {
		if (currentWord != null) {
			getCurrentConditionExpression().appendOperand();
		}
		return newSpace();
	}

	public int newConditionExpressionSplit(int type) {
		if (currentWord != null) {
			getCurrentConditionExpression().appendOperand();
		}
		currentConditionExpression = null;
		gotOperator(type);
		return type;
	}

	public int newWordPart(int type) {
		if (currentWord != null && type == RULE_S_WORD_PART) {
			type = RULE_WORD_PART;
		}
		gotWordPart();
		return type;
	}

	public int newEqual() {
		if (canBeEqual()) {
			gotEqual();
			return EqualsSign;
		}
		return newWordPart(RULE_WORD_PART);
	}

	public int newLeftParenthesis() {
		if (currentWord != null && currentWord.canBeArrayStart()) {
			lexer.pushState(S_ARRAY);
			lexer.enterSubShell();
			return newWordPart(LeftParenthesis);
		}
		return newOperator(LeftParenthesis, true);
	}

	public int newName(boolean followEqual) {
		if (canBeName(followEqual)) {
			gotName();
			return RULE_NAME;
		}
		int newType = followEqual ? RULE_WORD_PART : RULE_S_WORD_PART;
		return newWordPart(newType);
	}

	public int newSpace() {
		gotSpace();
		return RULE_WS;
	}

	public int newNewLine() {
		int newType = RULE_NEW_LINE;

		if (currentWord == null && (lastTokenMatch(RULE_NEW_LINE) || lastTokenMatch(RULE_HIDEN_NEW_LINE))) {
			newType = RULE_HIDEN_NEW_LINE;
		}
		newType = newOperator(newType, true);
		if (!hereDocQueue.isEmpty()) {
			lexer.pushState(S_HERE_DOC);
			lastNewLineType = newType;
			return RULE_HERE_DOC_START;
		}
		return newType;
	}

	public int newHereDocNewLine() {
		if (hereDocEndFound) {
			hereDocEndFound = false;
			hereDocQueue.remove();
			lexer.popState();
			if (!hereDocQueue.isEmpty()) {
				lexer.pushState(S_HERE_DOC);
				return RULE_HERE_DOC_START;
			}
		}
		return newOperator(lastNewLineType, true);
	}

	public int newHereDocPart() {
		return RULE_HERE_DOC_PART;
	}

	public int newHereDocPartLine() {
		HeredocState heredocState = hereDocQueue.peek();
		String currentWord = lexer.yytext();
		if (heredocState.getText().equals(currentWord)) {
			hereDocEndFound = true;
			return RULE_HERE_DOC_END;
		} else {
			if (!heredocState.isQueto()) {
				lexer.yypushback(lexer.yylength());
				lexer.pushState(S_HERE_DOC_E);
				return -1;
			}
		}
		return RULE_HERE_DOC_PART;
	}

	public int newOperator(int type, boolean newCommand) {
		gotOperator(type);
		if (newCommand) {
			gotNewCommand();
		}
		return type;
	}

	public int newKeyword(int type, boolean newCommand, boolean name) {
		if (canBeKeyword()) {
			gotKeyword(type);
			if (newCommand) {
				gotNewCommand();
			}
			return type;
		}
		if (name) {
			return newName(false);
		}
		return newWordPart(RULE_S_WORD_PART);
	}

	public boolean canBeEqual() {
		if (getCurrentWord().canBeEqual()) {
			return true;
		}
		return false;
	}

	public boolean canBeName(boolean followEqual) {
		if (getCurrentCommand().canBeName(followEqual)) {
			if (getCurrentWord().canBeName(followEqual)) {
				if (!inCaseP) {
					return true;
				}
			}
		}
		return false;
	}

	protected boolean canBeKeyword() {
		if (getCurrentCommand().canBeKeyword()) {
			if (getCurrentWord().canBeKeyword()) {
				return true;
			}
		}
		if (tokenBeforLastType == Case && lastTokenType == Command.WORD_TOKEN_TYPE) {
			return true;
		}
		if (tokenBeforLastType == For && lastTokenType == Command.WORD_TOKEN_TYPE) {
			return true;
		}
		if (tokenBeforLastType == Function && lastTokenType == Command.WORD_TOKEN_TYPE) {
			return true;
		}
		return false;
	}

	private void gotWordPart() {
		getCurrentWord().appendWordPart();
	}

	private void gotName() {
		getCurrentWord().appendName();
	}

	private void gotEqual() {
		getCurrentWord().appendEqual();
	}

	private void gotKeyword(int type) {
		pushLastToken(type);
		getCurrentCommand().appendKeyword(type);
		currentWord = null;
	}

	private void gotOperator(int type) {
		gotWordSplit();
		nextWord = null;
		pushLastToken(type);
		getCurrentCommand().appendOperator(type);
	}

	private void gotSpace() {
		gotWordSplit();
	}

	public void gotWordSplit() {
		if (currentWord != null) {
			pushLastToken(Command.WORD_TOKEN_TYPE);
			if (currentWord.isAssignment()) {
				getCurrentCommand().appendWord(Command.ASSIGNMENT_TOKEN_TYPE);
			} else {
				getCurrentCommand().appendWord(Command.WORD_TOKEN_TYPE);
			}
			currentWord.endWord();
			currentWord = null;
		}
	}

	private void gotNewCommand() {
		currentCommand = null;
	}

	public Command getCurrentCommand() {
		if (currentCommand == null) {
			currentCommand = new Command();
		}
		return currentCommand;
	}

	public Word getCurrentWord() {
		if (currentWord == null) {
			if (nextWord != null) {
				currentWord = nextWord;
				nextWord = null;
			} else {
				currentWord = new Word();
			}
		}
		return currentWord;
	}

	public ConditionExpression getCurrentConditionExpression() {
		if (currentConditionExpression == null) {
			currentConditionExpression = new ConditionExpression();
		}
		return currentConditionExpression;
	}

	private void pushLastToken(int type) {
		tokenBeforLastType = lastTokenType;
		lastTokenType = type;
	}

	public int newNumber(int type) {
		if (lastTokenMatch(LessThanSignAmpersand) || lastTokenMatch(GreaterThanSignAmpersand)) {
			return newWordPart(RULE_I_NUMBER);
		}
		return newWordPart(RULE_S_WORD_PART);
	}

	public void newComment() {

	}

	public int newAssignableWord(int ruleWordPart) {
		getCurrentCommand().appendAssignable();
		return ruleWordPart;
	}

	public void appendHeredocWordPart() {
		getCurrentHeredocWord().append(lexer.yytext());
		getCurrentHeredocWord().update(lexer.getCharIndex(), lexer.yylength());
	}

	public HereDocWord getCurrentHeredocWord() {
		if (currentHeredocWord == null) {
			currentHeredocWord = new HereDocWord();
		}
		return currentHeredocWord;
	}

	public void appendHeredocWordLength() {
		getCurrentHeredocWord().update(lexer.getCharIndex(), lexer.yylength());
	}

}
