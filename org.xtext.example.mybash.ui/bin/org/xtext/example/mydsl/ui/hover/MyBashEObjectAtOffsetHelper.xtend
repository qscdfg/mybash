package org.xtext.example.mydsl.ui.hover

import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.EObjectAtOffsetHelper
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.ITextRegion

class MyBashEObjectAtOffsetHelper extends EObjectAtOffsetHelper {
	override INode getCrossReferenceNode(XtextResource resource, ITextRegion region) {
		var parseResult = resource.getParseResult();
		if(parseResult != null) {
			var leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), region.getOffset());
			var crossRefNode = findCrossReferenceNode(leaf);
			// if not a cross reference position and the cursor is at the beginning of a node try the previous one.
			if(crossRefNode != null && crossRefNode.getEndOffset() >= region.getOffset() + region.getLength()) {
				return crossRefNode;
			}
		}
		return null;
	}
}
