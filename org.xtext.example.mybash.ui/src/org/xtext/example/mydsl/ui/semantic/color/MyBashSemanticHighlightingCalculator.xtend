package org.xtext.example.mydsl.ui.semantic.color

import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.util.CancelIndicator
import org.xtext.example.mydsl.myBash.Assignment
import org.xtext.example.mydsl.myBash.CommandName
import org.xtext.example.mydsl.myBash.CondBinaryExpression
import org.xtext.example.mydsl.myBash.FunctionDefine
import org.xtext.example.mydsl.myBash.ParameterExpansion
import org.xtext.example.mydsl.myBash.Redirection

class MyBashSemanticHighlightingCalculator extends DefaultSemanticHighlightingCalculator {

	override protected highlightElement(EObject object, IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {
		highlit(object, acceptor, cancelIndicator)
	}

	def void highlightFeatures(IHighlightedPositionAcceptor acceptor, EObject object, String featuresName, String ... styleIds) {
		var List<INode> children = NodeModelUtils.findNodesForFeature(object, object.eClass.getEStructuralFeature(featuresName));
		for (node : children) {
			highlightNode(acceptor, node, styleIds);
		}
	}

	def dispatch boolean highlit(EObject object, IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {
		super.highlightElement(object, acceptor, cancelIndicator)
	}

	def dispatch boolean highlit(CommandName commandName, IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {
		var fd = commandName.ref
		if(fd != null) {
			if(fd.name != null) {
				highlightFeatures(acceptor, commandName, "ref", MyBashHighlightingConfiguration.VALID_COMMAND_NAME_ID)
			} else {
				highlightFeatures(acceptor, commandName, "ref", MyBashHighlightingConfiguration.INVALID_COMMAND_NAME_ID)
			}
		}
		return false
	}

	def dispatch boolean highlit(CondBinaryExpression condExp, IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {
		var operation = condExp.op
		if("=~".equals(operation)) {
			highlightFeatures(acceptor, condExp, "right", MyBashHighlightingConfiguration.REGULAR_EXPRESSION_ID)
		}
		return false
	}

	def dispatch boolean highlit(Redirection redirection, IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {
		acceptor.highlightNode(NodeModelUtils.getNode(redirection), MyBashHighlightingConfiguration.REDIRECT_ID)
		return true
	}

	def dispatch boolean highlit(FunctionDefine functionDefine, IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {
		highlightFeatures(acceptor, functionDefine, "name", MyBashHighlightingConfiguration.FUNCTION_NAME_ID)
		return false
	}

	def dispatch boolean highlit(ParameterExpansion parameterExpansion, IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {
		var Assignment fd = parameterExpansion.ref as Assignment
		if(fd != null) {
			if(fd.name != null) {
				highlightFeatures(acceptor, parameterExpansion, "ref", MyBashHighlightingConfiguration.VALID_VARIABLE_NAME_ID)
			} else {
				highlightFeatures(acceptor, parameterExpansion, "ref", MyBashHighlightingConfiguration.INVALID_VARIABLE_NAME_ID)
			}
		}
		return false
	}

}
