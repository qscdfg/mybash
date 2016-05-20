package org.xtext.example.mydsl.ui.semantic.color;

import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.ui.editor.model.DocumentTokenSource;

public class FullDocumentTokenSource extends DocumentTokenSource {
	protected IRegion computeDamageRegion(final DocumentEvent e) {
		setTokens(createTokenInfos(e.fDocument.get()));
		return new Region(0, e.getDocument().getLength());
	}
}
