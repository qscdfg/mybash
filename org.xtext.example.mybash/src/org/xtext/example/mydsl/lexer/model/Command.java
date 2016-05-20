package org.xtext.example.mydsl.lexer.model;

import static org.xtext.example.mydsl.parser.antlr.lexer.InternalMyBashLexer.*;

public class Command {
	public static final int WORD_TOKEN_TYPE = -999;
	public static final int ASSIGNMENT_TOKEN_TYPE = -9999;

	public boolean start = true;
	public int lastTokenType = -1;
	public boolean commandAssignable = false;

	public void appendKeyword(int type) {
		start = false;
		lastTokenType = type;
	}

	public void appendOperator(int type) {
		start = false;
		lastTokenType = type;
	}

	public void appendWord(int type) {
		start = false;
		lastTokenType = type;
	}

	public void appendAssignable() {
		if (lastTokenType == -1 || lastTokenType == ASSIGNMENT_TOKEN_TYPE) {
			commandAssignable = true;
		}
	}

	public boolean canBeName(boolean followEqual) {
		if ((lastTokenType == -1 || lastTokenType == ASSIGNMENT_TOKEN_TYPE) && followEqual) {
			return true;
		}
		if (lastTokenType == For) {
			return true;
		}
		if (commandAssignable) {
			return true;
		}
		return false;
	}

	public boolean canBeKeyword() {
		return start;
	}
}
