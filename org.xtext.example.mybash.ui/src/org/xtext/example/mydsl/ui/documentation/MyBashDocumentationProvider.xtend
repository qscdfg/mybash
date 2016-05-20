package org.xtext.example.mydsl.ui.documentation

import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.xtext.example.mydsl.myBash.CommandName
import org.xtext.example.mydsl.myBash.ParameterExpansion
import org.xtext.example.mydsl.myBash.ReplaceProcessor
import org.xtext.example.mydsl.myBash.SingleProcessor

class MyBashDocumentationProvider implements IEObjectDocumentationProvider {

	override getDocumentation(EObject o) {
		innerGetDocumentation(o) // throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	def dispatch String innerGetDocumentation(EObject obj) {
		println(obj.eClass.name)
	}

	def dispatch String innerGetDocumentation(SingleProcessor obj) {
		'''«obj.op»'''
	}

	def dispatch String innerGetDocumentation(ReplaceProcessor obj) {
		'''«obj.op»'''
	}

	def dispatch String innerGetDocumentation(CommandName obj) {
		'''«obj.refName»'''
	}

	def dispatch String innerGetDocumentation(ParameterExpansion obj) {
		'''«obj.refName»'''
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
