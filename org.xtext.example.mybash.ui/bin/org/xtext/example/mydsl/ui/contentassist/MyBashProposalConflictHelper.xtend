package org.xtext.example.mydsl.ui.contentassist

import org.eclipse.xtext.ui.editor.contentassist.ProposalConflictHelper
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext

class MyBashProposalConflictHelper extends ProposalConflictHelper {
	override existsConflict(String lastCompleteText, String proposal, ContentAssistContext context) {
		return false;
	}
}
