package org.xtext.example.mydsl.lexer.model;

public class Word {

	private WordPartType startTokenType = WordPartType.EMPTY;
	private WordPartType lastTokenType = WordPartType.EMPTY;

	public static enum WordPartType {
		WORD_PART, ASSIGNMENT_PART, EQUAL, EMPTY
	}

	public void start() {

	}

	public void appendName() {
		if (startTokenType == WordPartType.EMPTY) {
			startTokenType = WordPartType.ASSIGNMENT_PART;
		}
		lastTokenType = WordPartType.ASSIGNMENT_PART;
	}

	public void appendWordPart() {
		lastTokenType = WordPartType.WORD_PART;
	}

	public void appendEqual() {
		lastTokenType = WordPartType.EQUAL;
	}

	public boolean canBeKeyword() {
		return lastTokenType == WordPartType.EMPTY;
	}

	public boolean canBeName(boolean followEqual) {
		return lastTokenType == WordPartType.EMPTY;
	}

	public boolean canBeEqual() {
		return lastTokenType == WordPartType.ASSIGNMENT_PART;
	}

	public boolean canBeArrayStart() {
		return lastTokenType == WordPartType.EQUAL;
	}

	public boolean isAssignment() {
		return startTokenType == WordPartType.ASSIGNMENT_PART;
	}

	public void endWord() {

	}

}
