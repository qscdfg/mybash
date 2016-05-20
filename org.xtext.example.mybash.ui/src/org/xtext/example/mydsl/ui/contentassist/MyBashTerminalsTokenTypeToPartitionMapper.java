package org.xtext.example.mydsl.ui.contentassist;

import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.ui.editor.model.TerminalsTokenTypeToPartitionMapper;

public class MyBashTerminalsTokenTypeToPartitionMapper extends TerminalsTokenTypeToPartitionMapper {
	@Override
	protected String calculateId(String tokenName, int tokenType) {
		if ("RULE_ML_COMMENT".equals(tokenName)) {
			return COMMENT_PARTITION;
		} else if ("RULE_SL_COMMENT".equals(tokenName)) {
			return SL_COMMENT_PARTITION;
		} else if ("RULE_Q_STRING".equals(tokenName)) {
			return STRING_LITERAL_PARTITION;
		} else if ("RULE_HERE_DOC_PART".equals(tokenName)) {
			return STRING_LITERAL_PARTITION;
		} else if ("RULE_WORD_PART".equals(tokenName)) {
			return STRING_LITERAL_PARTITION;
		} else if ("RULE_S_WORD_PART".equals(tokenName)) {
			return STRING_LITERAL_PARTITION;
		}
		return IDocument.DEFAULT_CONTENT_TYPE;
	}
}
