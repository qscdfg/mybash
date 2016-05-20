package org.xtext.example.mydsl.ui.semantic.color;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.TextPresentation;
import org.eclipse.jface.text.TypedRegion;
import org.eclipse.jface.text.presentation.IPresentationRepairer;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.xtext.ui.editor.XtextPresentationReconciler;

public class MyBashPresentationReconciler extends XtextPresentationReconciler {
	/** Last used document */
	private IDocument fLastDocument;

	public TextPresentation createRepairDescription(IRegion damage, IDocument document) {
		if (document != fLastDocument) {
			setDocumentToDamagers(document);
			setDocumentToRepairers(document);
			fLastDocument = document;
		}
		return createPresentation(damage, document);
	}

	protected TextPresentation createPresentation(IRegion damage, IDocument document) {
		if (getRepairer(IDocument.DEFAULT_CONTENT_TYPE) == null) {
			TextPresentation presentation = new TextPresentation(damage, 100);
			presentation.setDefaultStyleRange(new StyleRange(damage.getOffset(), damage.getLength(), null, null));
			return presentation;
		}

		TextPresentation presentation = new TextPresentation(damage, 1000);

		TypedRegion region = new TypedRegion(damage.getOffset(), damage.getLength(), IDocument.DEFAULT_CONTENT_TYPE);
		IPresentationRepairer repairer = getRepairer(region.getType());
		repairer.createPresentation(presentation, region);
		return presentation;
	}
}
