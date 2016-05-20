package org.xtext.example.mydsl.ui.semantic.color

import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor
import org.eclipse.xtext.ui.editor.utils.TextStyle
import org.eclipse.swt.SWT
import org.eclipse.swt.graphics.RGB
import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles
import org.eclipse.jface.text.TextAttribute

class MyBashHighlightingConfiguration implements IHighlightingConfiguration {

	public static final String DEFAULT_ID = HighlightingStyles.DEFAULT_ID;

	public static final String KEYWORD_ID = HighlightingStyles.KEYWORD_ID;

	public static final String COMMENT_ID = HighlightingStyles.COMMENT_ID;

	public static final String NUMBER_ID = HighlightingStyles.NUMBER_ID;
	public static final String TASK_ID = HighlightingStyles.TASK_ID;

	public static final String INVALID_TOKEN_ID = HighlightingStyles.INVALID_TOKEN_ID;

	public static final String HERE_DOC_WORD_ID = "mybash.here_doc_word";
	public static final String HERE_DOC_END_ID = "mybash.here_doc_end";
	public static final String HERE_DOC_LINE_ID = "mybash.here_doc_line";
	public static final String NAME_ID = "mybash.name";
	public static final String LITERAL_PART_ID = "mybash.literal";

	// ///////////////////////////////////////////////////////////////////////////////
	public static final String VALID_COMMAND_NAME_ID = "mybash.command.name.valid";
	public static final String VALID_VARIABLE_NAME_ID = "mybash.variable.name.valid";
	public static final String INVALID_COMMAND_NAME_ID = "mybash.command.name.invalid";
	public static final String INVALID_VARIABLE_NAME_ID = "mybash.variable.name.invalid";
	public static final String FUNCTION_NAME_ID = "mybash.function.name";
	public static final String REDIRECT_ID = "mybash.redirect";
	public static final String REGULAR_EXPRESSION_ID = "mybash.regular.expression";

	extension  TextStyleExtention textStyleExtention = new TextStyleExtention();

	override configure(IHighlightingConfigurationAcceptor acceptor) {
		acceptor.acceptDefaultHighlighting(KEYWORD_ID, "Keyword", keywordTextStyle());
		acceptor.acceptDefaultHighlighting(COMMENT_ID, "Comment", commentTextStyle());
		acceptor.acceptDefaultHighlighting(NUMBER_ID, "Number", numberTextStyle());
		acceptor.acceptDefaultHighlighting(DEFAULT_ID, "Default", defaultTextStyle());
		acceptor.acceptDefaultHighlighting(TASK_ID, "Task", taskTextStyle());
		acceptor.acceptDefaultHighlighting(INVALID_TOKEN_ID, "Invalid Symbol", textStyle[color(255, 0, 0);]);
		acceptor.acceptDefaultHighlighting(HERE_DOC_WORD_ID, "Here Document Word", textStyle[bcolor(173, 216, 230);]);
		acceptor.acceptDefaultHighlighting(HERE_DOC_END_ID, "Here Document End", textStyle[bcolor(173, 216, 230);]);
		acceptor.acceptDefaultHighlighting(HERE_DOC_LINE_ID, "Here Document Content", textStyle[bcolor(192, 255, 62);]);
		acceptor.acceptDefaultHighlighting(NAME_ID, "Name", textStyle[name; color(0, 0, 255);]);
		acceptor.acceptDefaultHighlighting(VALID_COMMAND_NAME_ID, "Valid Command Name", textStyle[
			name;
			link;
			color(139, 101, 8);
		]);
		acceptor.acceptDefaultHighlighting(VALID_VARIABLE_NAME_ID, "Valid Variable Name", textStyle[
			name
			link
			color(0, 0, 255)
		]);
		acceptor.acceptDefaultHighlighting(INVALID_COMMAND_NAME_ID, "Invalid Command Name", textStyle[
			name;
			color(139, 101, 8);
		]);
		acceptor.acceptDefaultHighlighting(INVALID_VARIABLE_NAME_ID, "Invalid Variable Name", textStyle[
			name;
			color(0, 0, 255);
		]);
		acceptor.acceptDefaultHighlighting(FUNCTION_NAME_ID, "Function Name", textStyle[name; color(139, 101, 8);]);
		acceptor.acceptDefaultHighlighting(REDIRECT_ID, "Redirect", textStyle[bcolor(238, 149, 114);]);
		acceptor.acceptDefaultHighlighting(REGULAR_EXPRESSION_ID, "Regular Expression", textStyle[bcolor(148, 0, 211);]);

		acceptor.acceptDefaultHighlighting(LITERAL_PART_ID, "Literal", textStyle[bcolor(224, 224, 224);]);
	}

	interface TextStyleModifier {
		def TextStyle modify(TextStyle textStyle);
	}

	static class TextStyleExtention {
		def TextStyle name(TextStyle textStyle) {
			textStyle.style = textStyle.style.bitwiseOr(SWT.ITALIC);
			textStyle.style = textStyle.style.bitwiseOr(SWT.BOLD);
			textStyle
		}

		def TextStyle link(TextStyle textStyle) {
			textStyle.style = textStyle.style.bitwiseOr(TextAttribute.UNDERLINE);
			textStyle
		}

		def TextStyle color(TextStyle textStyle, int r, int g, int b) {
			textStyle.setColor(new RGB(r, g, b));
			textStyle
		}

		def TextStyle bcolor(TextStyle textStyle, int r, int g, int b) {
			textStyle.backgroundColor = new RGB(r, g, b);
			textStyle
		}
	}

	def TextStyle textStyle(TextStyleModifier modifier) {
		val TextStyle textStyle = new TextStyle();
		modifier.modify(textStyle);
		return textStyle;
	}

	def TextStyle defaultTextStyle() {
		var TextStyle textStyle = new TextStyle();
		return textStyle;
	}

	def TextStyle errorTextStyle() {
		var TextStyle textStyle = defaultTextStyle().copy();
		return textStyle;
	}

	def TextStyle numberTextStyle() {
		var TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(125, 125, 125));
		return textStyle;
	}

	def TextStyle stringTextStyle() {
		var TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(42, 0, 255));
		return textStyle;
	}

	def TextStyle commentTextStyle() {
		var TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(63, 127, 95));
		return textStyle;
	}

	/**
	 * @since 2.6
	 */
	def TextStyle taskTextStyle() {
		var TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(127, 159, 191));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	def TextStyle keywordTextStyle() {
		var TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(127, 0, 85));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	def TextStyle punctuationTextStyle() {
		var TextStyle textStyle = defaultTextStyle().copy();
		return textStyle;
	}

}
