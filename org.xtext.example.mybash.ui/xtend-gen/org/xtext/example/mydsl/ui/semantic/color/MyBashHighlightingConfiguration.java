package org.xtext.example.mydsl.ui.semantic.color;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class MyBashHighlightingConfiguration implements IHighlightingConfiguration {
  public interface TextStyleModifier {
    public abstract TextStyle modify(final TextStyle textStyle);
  }
  
  public static class TextStyleExtention {
    public TextStyle name(final TextStyle textStyle) {
      TextStyle _xblockexpression = null;
      {
        int _style = textStyle.getStyle();
        int _bitwiseOr = (_style | SWT.ITALIC);
        textStyle.setStyle(_bitwiseOr);
        int _style_1 = textStyle.getStyle();
        int _bitwiseOr_1 = (_style_1 | SWT.BOLD);
        textStyle.setStyle(_bitwiseOr_1);
        _xblockexpression = textStyle;
      }
      return _xblockexpression;
    }
    
    public TextStyle link(final TextStyle textStyle) {
      TextStyle _xblockexpression = null;
      {
        int _style = textStyle.getStyle();
        int _bitwiseOr = (_style | TextAttribute.UNDERLINE);
        textStyle.setStyle(_bitwiseOr);
        _xblockexpression = textStyle;
      }
      return _xblockexpression;
    }
    
    public TextStyle color(final TextStyle textStyle, final int r, final int g, final int b) {
      TextStyle _xblockexpression = null;
      {
        RGB _rGB = new RGB(r, g, b);
        textStyle.setColor(_rGB);
        _xblockexpression = textStyle;
      }
      return _xblockexpression;
    }
    
    public TextStyle bcolor(final TextStyle textStyle, final int r, final int g, final int b) {
      TextStyle _xblockexpression = null;
      {
        RGB _rGB = new RGB(r, g, b);
        textStyle.setBackgroundColor(_rGB);
        _xblockexpression = textStyle;
      }
      return _xblockexpression;
    }
  }
  
  public final static String DEFAULT_ID = HighlightingStyles.DEFAULT_ID;
  
  public final static String KEYWORD_ID = HighlightingStyles.KEYWORD_ID;
  
  public final static String COMMENT_ID = HighlightingStyles.COMMENT_ID;
  
  public final static String NUMBER_ID = HighlightingStyles.NUMBER_ID;
  
  public final static String TASK_ID = HighlightingStyles.TASK_ID;
  
  public final static String INVALID_TOKEN_ID = HighlightingStyles.INVALID_TOKEN_ID;
  
  public final static String HERE_DOC_WORD_ID = "mybash.here_doc_word";
  
  public final static String HERE_DOC_END_ID = "mybash.here_doc_end";
  
  public final static String HERE_DOC_LINE_ID = "mybash.here_doc_line";
  
  public final static String NAME_ID = "mybash.name";
  
  public final static String LITERAL_PART_ID = "mybash.literal";
  
  public final static String VALID_COMMAND_NAME_ID = "mybash.command.name.valid";
  
  public final static String VALID_VARIABLE_NAME_ID = "mybash.variable.name.valid";
  
  public final static String INVALID_COMMAND_NAME_ID = "mybash.command.name.invalid";
  
  public final static String INVALID_VARIABLE_NAME_ID = "mybash.variable.name.invalid";
  
  public final static String FUNCTION_NAME_ID = "mybash.function.name";
  
  public final static String REDIRECT_ID = "mybash.redirect";
  
  public final static String REGULAR_EXPRESSION_ID = "mybash.regular.expression";
  
  @Extension
  private MyBashHighlightingConfiguration.TextStyleExtention textStyleExtention = new MyBashHighlightingConfiguration.TextStyleExtention();
  
  @Override
  public void configure(final IHighlightingConfigurationAcceptor acceptor) {
    TextStyle _keywordTextStyle = this.keywordTextStyle();
    acceptor.acceptDefaultHighlighting(MyBashHighlightingConfiguration.KEYWORD_ID, "Keyword", _keywordTextStyle);
    TextStyle _commentTextStyle = this.commentTextStyle();
    acceptor.acceptDefaultHighlighting(MyBashHighlightingConfiguration.COMMENT_ID, "Comment", _commentTextStyle);
    TextStyle _numberTextStyle = this.numberTextStyle();
    acceptor.acceptDefaultHighlighting(MyBashHighlightingConfiguration.NUMBER_ID, "Number", _numberTextStyle);
    TextStyle _defaultTextStyle = this.defaultTextStyle();
    acceptor.acceptDefaultHighlighting(MyBashHighlightingConfiguration.DEFAULT_ID, "Default", _defaultTextStyle);
    TextStyle _taskTextStyle = this.taskTextStyle();
    acceptor.acceptDefaultHighlighting(MyBashHighlightingConfiguration.TASK_ID, "Task", _taskTextStyle);
    final MyBashHighlightingConfiguration.TextStyleModifier _function = (TextStyle it) -> {
      return this.textStyleExtention.color(it, 255, 0, 0);
    };
    TextStyle _textStyle = this.textStyle(_function);
    acceptor.acceptDefaultHighlighting(MyBashHighlightingConfiguration.INVALID_TOKEN_ID, "Invalid Symbol", _textStyle);
    final MyBashHighlightingConfiguration.TextStyleModifier _function_1 = (TextStyle it) -> {
      return this.textStyleExtention.bcolor(it, 173, 216, 230);
    };
    TextStyle _textStyle_1 = this.textStyle(_function_1);
    acceptor.acceptDefaultHighlighting(MyBashHighlightingConfiguration.HERE_DOC_WORD_ID, "Here Document Word", _textStyle_1);
    final MyBashHighlightingConfiguration.TextStyleModifier _function_2 = (TextStyle it) -> {
      return this.textStyleExtention.bcolor(it, 173, 216, 230);
    };
    TextStyle _textStyle_2 = this.textStyle(_function_2);
    acceptor.acceptDefaultHighlighting(MyBashHighlightingConfiguration.HERE_DOC_END_ID, "Here Document End", _textStyle_2);
    final MyBashHighlightingConfiguration.TextStyleModifier _function_3 = (TextStyle it) -> {
      return this.textStyleExtention.bcolor(it, 192, 255, 62);
    };
    TextStyle _textStyle_3 = this.textStyle(_function_3);
    acceptor.acceptDefaultHighlighting(MyBashHighlightingConfiguration.HERE_DOC_LINE_ID, "Here Document Content", _textStyle_3);
    final MyBashHighlightingConfiguration.TextStyleModifier _function_4 = (TextStyle it) -> {
      TextStyle _xblockexpression = null;
      {
        this.textStyleExtention.name(it);
        _xblockexpression = this.textStyleExtention.color(it, 0, 0, 255);
      }
      return _xblockexpression;
    };
    TextStyle _textStyle_4 = this.textStyle(_function_4);
    acceptor.acceptDefaultHighlighting(MyBashHighlightingConfiguration.NAME_ID, "Name", _textStyle_4);
    final MyBashHighlightingConfiguration.TextStyleModifier _function_5 = (TextStyle it) -> {
      TextStyle _xblockexpression = null;
      {
        this.textStyleExtention.name(it);
        this.textStyleExtention.link(it);
        _xblockexpression = this.textStyleExtention.color(it, 139, 101, 8);
      }
      return _xblockexpression;
    };
    TextStyle _textStyle_5 = this.textStyle(_function_5);
    acceptor.acceptDefaultHighlighting(MyBashHighlightingConfiguration.VALID_COMMAND_NAME_ID, "Valid Command Name", _textStyle_5);
    final MyBashHighlightingConfiguration.TextStyleModifier _function_6 = (TextStyle it) -> {
      TextStyle _xblockexpression = null;
      {
        this.textStyleExtention.name(it);
        this.textStyleExtention.link(it);
        _xblockexpression = this.textStyleExtention.color(it, 0, 0, 255);
      }
      return _xblockexpression;
    };
    TextStyle _textStyle_6 = this.textStyle(_function_6);
    acceptor.acceptDefaultHighlighting(MyBashHighlightingConfiguration.VALID_VARIABLE_NAME_ID, "Valid Variable Name", _textStyle_6);
    final MyBashHighlightingConfiguration.TextStyleModifier _function_7 = (TextStyle it) -> {
      TextStyle _xblockexpression = null;
      {
        this.textStyleExtention.name(it);
        _xblockexpression = this.textStyleExtention.color(it, 139, 101, 8);
      }
      return _xblockexpression;
    };
    TextStyle _textStyle_7 = this.textStyle(_function_7);
    acceptor.acceptDefaultHighlighting(MyBashHighlightingConfiguration.INVALID_COMMAND_NAME_ID, "Invalid Command Name", _textStyle_7);
    final MyBashHighlightingConfiguration.TextStyleModifier _function_8 = (TextStyle it) -> {
      TextStyle _xblockexpression = null;
      {
        this.textStyleExtention.name(it);
        _xblockexpression = this.textStyleExtention.color(it, 0, 0, 255);
      }
      return _xblockexpression;
    };
    TextStyle _textStyle_8 = this.textStyle(_function_8);
    acceptor.acceptDefaultHighlighting(MyBashHighlightingConfiguration.INVALID_VARIABLE_NAME_ID, "Invalid Variable Name", _textStyle_8);
    final MyBashHighlightingConfiguration.TextStyleModifier _function_9 = (TextStyle it) -> {
      TextStyle _xblockexpression = null;
      {
        this.textStyleExtention.name(it);
        _xblockexpression = this.textStyleExtention.color(it, 139, 101, 8);
      }
      return _xblockexpression;
    };
    TextStyle _textStyle_9 = this.textStyle(_function_9);
    acceptor.acceptDefaultHighlighting(MyBashHighlightingConfiguration.FUNCTION_NAME_ID, "Function Name", _textStyle_9);
    final MyBashHighlightingConfiguration.TextStyleModifier _function_10 = (TextStyle it) -> {
      return this.textStyleExtention.bcolor(it, 238, 149, 114);
    };
    TextStyle _textStyle_10 = this.textStyle(_function_10);
    acceptor.acceptDefaultHighlighting(MyBashHighlightingConfiguration.REDIRECT_ID, "Redirect", _textStyle_10);
    final MyBashHighlightingConfiguration.TextStyleModifier _function_11 = (TextStyle it) -> {
      return this.textStyleExtention.bcolor(it, 148, 0, 211);
    };
    TextStyle _textStyle_11 = this.textStyle(_function_11);
    acceptor.acceptDefaultHighlighting(MyBashHighlightingConfiguration.REGULAR_EXPRESSION_ID, "Regular Expression", _textStyle_11);
    final MyBashHighlightingConfiguration.TextStyleModifier _function_12 = (TextStyle it) -> {
      return this.textStyleExtention.bcolor(it, 224, 224, 224);
    };
    TextStyle _textStyle_12 = this.textStyle(_function_12);
    acceptor.acceptDefaultHighlighting(MyBashHighlightingConfiguration.LITERAL_PART_ID, "Literal", _textStyle_12);
  }
  
  public TextStyle textStyle(final MyBashHighlightingConfiguration.TextStyleModifier modifier) {
    final TextStyle textStyle = new TextStyle();
    modifier.modify(textStyle);
    return textStyle;
  }
  
  public TextStyle defaultTextStyle() {
    TextStyle textStyle = new TextStyle();
    return textStyle;
  }
  
  public TextStyle errorTextStyle() {
    TextStyle _defaultTextStyle = this.defaultTextStyle();
    TextStyle textStyle = _defaultTextStyle.copy();
    return textStyle;
  }
  
  public TextStyle numberTextStyle() {
    TextStyle _defaultTextStyle = this.defaultTextStyle();
    TextStyle textStyle = _defaultTextStyle.copy();
    RGB _rGB = new RGB(125, 125, 125);
    textStyle.setColor(_rGB);
    return textStyle;
  }
  
  public TextStyle stringTextStyle() {
    TextStyle _defaultTextStyle = this.defaultTextStyle();
    TextStyle textStyle = _defaultTextStyle.copy();
    RGB _rGB = new RGB(42, 0, 255);
    textStyle.setColor(_rGB);
    return textStyle;
  }
  
  public TextStyle commentTextStyle() {
    TextStyle _defaultTextStyle = this.defaultTextStyle();
    TextStyle textStyle = _defaultTextStyle.copy();
    RGB _rGB = new RGB(63, 127, 95);
    textStyle.setColor(_rGB);
    return textStyle;
  }
  
  /**
   * @since 2.6
   */
  public TextStyle taskTextStyle() {
    TextStyle _defaultTextStyle = this.defaultTextStyle();
    TextStyle textStyle = _defaultTextStyle.copy();
    RGB _rGB = new RGB(127, 159, 191);
    textStyle.setColor(_rGB);
    textStyle.setStyle(SWT.BOLD);
    return textStyle;
  }
  
  public TextStyle keywordTextStyle() {
    TextStyle _defaultTextStyle = this.defaultTextStyle();
    TextStyle textStyle = _defaultTextStyle.copy();
    RGB _rGB = new RGB(127, 0, 85);
    textStyle.setColor(_rGB);
    textStyle.setStyle(SWT.BOLD);
    return textStyle;
  }
  
  public TextStyle punctuationTextStyle() {
    TextStyle _defaultTextStyle = this.defaultTextStyle();
    TextStyle textStyle = _defaultTextStyle.copy();
    return textStyle;
  }
}
