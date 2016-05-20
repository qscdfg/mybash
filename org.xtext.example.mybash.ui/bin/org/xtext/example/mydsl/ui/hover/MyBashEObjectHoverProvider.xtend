package org.xtext.example.mydsl.ui.hover

import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider
import org.xtext.example.mydsl.myBash.ParameterExpansion
import org.eclipse.emf.ecore.EObject
import org.xtext.example.mydsl.myBash.CommandName
import org.xtext.example.mydsl.myBash.ParameterProcessor
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.nodemodel.INode
import java.util.List
import org.xtext.example.mydsl.myBash.SingleProcessor

class MyBashEObjectHoverProvider extends DefaultEObjectHoverProvider {
	override boolean hasHover(EObject o) {
		if(o instanceof ParameterProcessor) {
			return true;
		}
		if(o instanceof ParameterExpansion) {
			return true;
		}
		if(o instanceof CommandName) {
			return true;
		}
		return super.hasHover(o);
	}

	override String getFirstLine(EObject o) {
		var String result = null
		result = innerGetFirstLine(o)
		if(result == null) {
			result = super.getFirstLine(o)
		}
		result
	}

	def dispatch String innerGetFirstLine(EObject object) {
		null
	}

	def dispatch String innerGetFirstLine(SingleProcessor object) {
		'''ParameterExpansion Operator : <b>«object.op»</b>'''
	}

	def dispatch String innerGetFirstLine(ParameterExpansion object) {
		'''ParameterExpansion : <b>«object.refName»</b>'''
	}

	def static String getRefName(EObject object) {
		var refFeature = object.eClass.getEStructuralFeature('ref')
		var ref = object.eGet(refFeature)
		if(ref instanceof EObject && !(ref as EObject).eIsProxy) {
			var nameFeature = (ref as EObject).eClass.getEStructuralFeature('name')
			return (ref as EObject).eGet(nameFeature) as String
		}
		NodeModelUtils.findNodesForFeature(object, refFeature)?.getNodesString
	}

	def static String getNodesString(List<INode> nodes) {
		var builder = new StringBuilder
		for (node : nodes) {
			builder.append(node.text)
		}
		builder.toString
	}

}
