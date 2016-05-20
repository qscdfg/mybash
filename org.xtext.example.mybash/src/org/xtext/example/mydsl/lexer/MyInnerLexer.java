package org.xtext.example.mydsl.lexer;

import java.io.CharArrayReader;
import java.lang.reflect.Field;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.Token;
import org.xtext.example.mydsl.parser.antlr.lexer.InternalMyBashLexer;

public class MyInnerLexer extends InternalMyBashLexer {
	private MyBashLexer delegate = new MyBashLexer(null);

	@Override
	public CharStream getCharStream() {
		return new ANTLRStringStream(data, data.length);
	}

	@Override
	public Token nextToken() {
		Token token = delegate.nextToken();
		// System.out.println("type: [" + token.getType() + "](" +
		// token.getText() + ")");
		return token;
	}

	@Override
	public String getErrorMessage(Token t) {
		return "Invalid token " + t.getText() + " type:[" + t.getType() + "]";
	}

	char[] data = null;
	int data_length = -1;

	@Override
	public void setCharStream(CharStream input) {
		try {
			Field field = ANTLRStringStream.class.getDeclaredField("data");
			Field field_n = ANTLRStringStream.class.getDeclaredField("n");
			field.setAccessible(true);
			field_n.setAccessible(true);
			data = (char[]) field.get(input);
			data_length = (Integer) field_n.get(input);
			reset();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void changeState(int state) {
		delegate.yybegin(state);
	}

	@Override
	public void reset() {
		delegate.yyreset(new CharArrayReader(data, 0, data_length));
	}
}
