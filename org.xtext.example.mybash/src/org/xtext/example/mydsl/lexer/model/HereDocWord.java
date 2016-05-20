package org.xtext.example.mydsl.lexer.model;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import static org.xtext.example.mydsl.parser.antlr.lexer.InternalMyBashLexer.*;

public class HereDocWord {
	private StringBuilder builder = new StringBuilder();
	private int start = -1;
	private int length = 0;
	private boolean quote = false;

	public void setQuote(boolean quote) {
		this.quote = quote;
	}

	public boolean isQuote() {
		return quote;
	}

	public void append(String text) {
		builder.append(text);
	}

	public void update(int start, int length) {
		if (this.start == -1) {
			this.start = start;
		}
		this.length += length;
	}

	public Token createToken() {
		return newToken(RULE_HERE_DOC_WORD, builder.toString(), start, start + length - 1);
	}

	protected Token newToken(int type, String text, int start, int end) {
		CommonToken token = new CommonToken(type, text);
		token.setChannel(Token.DEFAULT_CHANNEL);
		token.setStartIndex(start);
		token.setStopIndex(end);
		return token;
	}

}
