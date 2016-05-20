package org.xtext.example.mydsl.ui.contentassist;

import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ProposalConflictHelper;

@SuppressWarnings("all")
public class MyBashProposalConflictHelper extends ProposalConflictHelper {
  @Override
  public boolean existsConflict(final String lastCompleteText, final String proposal, final ContentAssistContext context) {
    return false;
  }
}
