package org.xtext.example.mydsl.lexer.model;

public class ConditionExpression {

	int lastTokenType = -1;

	public boolean canBeUnary() {
		return lastTokenType == -1;
	}

	public boolean canBeBinary() {
		return lastTokenType == 3;
	}

	public void appendUnary() {
		lastTokenType = 1;
	}

	public void appendBinary() {
		lastTokenType = 2;
	}

	public void appendOperand() {
		lastTokenType = 3;
	}
}
