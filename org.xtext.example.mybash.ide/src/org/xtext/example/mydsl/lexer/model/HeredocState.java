package org.xtext.example.mydsl.lexer.model;

public class HeredocState {
	private String text;
	private boolean queto;

	public HeredocState(String text, boolean queto) {
		super();
		this.text = text;
		this.queto = queto;
	}

	public boolean isQueto() {
		return queto;
	}

	public String getText() {
		return text;
	}
}
