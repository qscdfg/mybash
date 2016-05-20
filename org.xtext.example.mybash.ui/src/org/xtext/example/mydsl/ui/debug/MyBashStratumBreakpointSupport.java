package org.xtext.example.mydsl.ui.debug;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.debug.IStratumBreakpointSupport;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.xtext.example.mydsl.myBash.CommandUnit;

public class MyBashStratumBreakpointSupport implements IStratumBreakpointSupport {

	public boolean isValidLineForBreakPoint(XtextResource resource, int line) {
		IParseResult parseResult = resource.getParseResult();
		if (parseResult == null)
			return false;
		ICompositeNode node = parseResult.getRootNode();
		return isValidLineForBreakpoint(node, line);
	}

	protected boolean isValidLineForBreakpoint(ICompositeNode node, int line) {
		for (INode n : node.getChildren()) {
			if (n.getStartLine() <= line && n.getEndLine() >= line) {
				EObject eObject = n.getSemanticElement();
				if (eObject instanceof CommandUnit) {
					return true;
				}
				if (n instanceof ICompositeNode && isValidLineForBreakpoint((ICompositeNode) n, line)) {
					return true;
				}

			}
			if (n.getStartLine() > line) {
				return false;
			}
		}
		return false;
	}

}
