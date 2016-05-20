package org.xtext.example.mydsl.ui.semantic.color

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper

class MyBashTokenToAttributeIdMapper extends DefaultAntlrTokenToAttributeIdMapper {

	override protected calculateId(String tokenName, int tokenType) {
		if("RULE_SL_COMMENT".equals(tokenName)) {
			MyBashHighlightingConfiguration.COMMENT_ID
		} else if("RULE_NAME".equals(tokenName)) {
			MyBashHighlightingConfiguration.NAME_ID
		} else if("RULE_HERE_DOC_WORD".equals(tokenName)) {
			MyBashHighlightingConfiguration.HERE_DOC_WORD_ID
		} else if("RULE_HERE_DOC_END".equals(tokenName)) {
			MyBashHighlightingConfiguration.HERE_DOC_END_ID
		} else if("RULE_HERE_DOC_PART".equals(tokenName)) {
			MyBashHighlightingConfiguration.HERE_DOC_LINE_ID
		} else if("RULE_S_WORD_PART".equals(tokenName)) {
			MyBashHighlightingConfiguration.LITERAL_PART_ID
		} else if("RULE_WORD_PART".equals(tokenName)) {
			MyBashHighlightingConfiguration.LITERAL_PART_ID
		} else if("RULE_Q_STRING".equals(tokenName)) {
			MyBashHighlightingConfiguration.LITERAL_PART_ID
		} else {
			super.calculateId(tokenName, tokenType);
		}
	}

}
