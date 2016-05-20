package org.xtext.example.mydsl.formatting2

import org.eclipse.xtext.formatting2.IHiddenRegionFormatting
import org.eclipse.xtext.formatting2.ITextReplacerContext
import org.eclipse.xtext.formatting2.internal.WhitespaceReplacer
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment

class MyBashWhitespaceReplacer extends WhitespaceReplacer {

	new(ITextSegment whitespace, IHiddenRegionFormatting formatting) {
		super(whitespace, formatting)
	}

	override protected computeNewLineCount(ITextReplacerContext context) {
		var newLineDefault = formatting.getNewLineDefault();
		var newLineMin = formatting.getNewLineMin();
		var newLineMax = formatting.getNewLineMax();
		if (newLineMin != null || newLineDefault != null || newLineMax != null) {
			if (region instanceof IHiddenRegion && ((region as IHiddenRegion).isUndefined())) {
				if (newLineDefault != null)
					return newLineDefault;
				if (newLineMin != null)
					return newLineMin;
				if (newLineMax != null)
					return newLineMax;
			} else {
				var lineCount = region.getLineCount() - 1 + trailingNewLinesOfPreviousRegion;
				if (newLineMin != null && newLineMin > lineCount)
					lineCount = newLineMin;
				if (newLineMax != null && newLineMax < lineCount)
					lineCount = newLineMax;
				return lineCount;
			}
		}
		return 0;
	}

	override int trailingNewLinesOfPreviousRegion() {
		var offset = region.getOffset();
		if (offset < 1)
			return 1;
		var previous = region.getTextRegionAccess().textForOffset(offset - 1, 1);
		if ("\n".equals(previous))
			return 1;
		return 0;
	}

}
