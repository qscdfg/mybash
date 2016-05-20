package org.xtext.example.mydsl.ui.semantic.color;

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;
import org.xtext.example.mydsl.ui.semantic.color.MyBashHighlightingConfiguration;

@SuppressWarnings("all")
public class MyBashTokenToAttributeIdMapper extends DefaultAntlrTokenToAttributeIdMapper {
  @Override
  protected String calculateId(final String tokenName, final int tokenType) {
    String _xifexpression = null;
    boolean _equals = "RULE_SL_COMMENT".equals(tokenName);
    if (_equals) {
      _xifexpression = MyBashHighlightingConfiguration.COMMENT_ID;
    } else {
      String _xifexpression_1 = null;
      boolean _equals_1 = "RULE_NAME".equals(tokenName);
      if (_equals_1) {
        _xifexpression_1 = MyBashHighlightingConfiguration.NAME_ID;
      } else {
        String _xifexpression_2 = null;
        boolean _equals_2 = "RULE_HERE_DOC_WORD".equals(tokenName);
        if (_equals_2) {
          _xifexpression_2 = MyBashHighlightingConfiguration.HERE_DOC_WORD_ID;
        } else {
          String _xifexpression_3 = null;
          boolean _equals_3 = "RULE_HERE_DOC_END".equals(tokenName);
          if (_equals_3) {
            _xifexpression_3 = MyBashHighlightingConfiguration.HERE_DOC_END_ID;
          } else {
            String _xifexpression_4 = null;
            boolean _equals_4 = "RULE_HERE_DOC_PART".equals(tokenName);
            if (_equals_4) {
              _xifexpression_4 = MyBashHighlightingConfiguration.HERE_DOC_LINE_ID;
            } else {
              String _xifexpression_5 = null;
              boolean _equals_5 = "RULE_S_WORD_PART".equals(tokenName);
              if (_equals_5) {
                _xifexpression_5 = MyBashHighlightingConfiguration.LITERAL_PART_ID;
              } else {
                String _xifexpression_6 = null;
                boolean _equals_6 = "RULE_WORD_PART".equals(tokenName);
                if (_equals_6) {
                  _xifexpression_6 = MyBashHighlightingConfiguration.LITERAL_PART_ID;
                } else {
                  String _xifexpression_7 = null;
                  boolean _equals_7 = "RULE_Q_STRING".equals(tokenName);
                  if (_equals_7) {
                    _xifexpression_7 = MyBashHighlightingConfiguration.LITERAL_PART_ID;
                  } else {
                    _xifexpression_7 = super.calculateId(tokenName, tokenType);
                  }
                  _xifexpression_6 = _xifexpression_7;
                }
                _xifexpression_5 = _xifexpression_6;
              }
              _xifexpression_4 = _xifexpression_5;
            }
            _xifexpression_3 = _xifexpression_4;
          }
          _xifexpression_2 = _xifexpression_3;
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
}
