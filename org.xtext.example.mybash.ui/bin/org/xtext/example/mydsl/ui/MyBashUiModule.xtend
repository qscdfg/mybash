/*
 * generated by Xtext 2.9.1
 */
package org.xtext.example.mydsl.ui

import com.google.inject.Binder
import com.google.inject.name.Names
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.ide.LexerIdeBindings
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator
import org.eclipse.xtext.parser.antlr.Lexer
import org.eclipse.xtext.ui.editor.model.DocumentTokenSource
import org.eclipse.xtext.ui.editor.model.ITokenTypeToPartitionTypeMapper
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration
import org.xtext.example.mydsl.lexer.MyInnerLexer
import org.xtext.example.mydsl.ui.contentassist.MyBashTerminalsTokenTypeToPartitionMapper
import org.xtext.example.mydsl.ui.semantic.color.FullDocumentTokenSource
import org.xtext.example.mydsl.ui.semantic.color.MyBashHighlightingConfiguration
import org.xtext.example.mydsl.ui.semantic.color.MyBashSemanticHighlightingCalculator
import org.xtext.example.mydsl.ui.semantic.color.MyBashTokenToAttributeIdMapper
import org.xtext.example.mydsl.ide.contentassist.antlr.lexer.InternalMyBashLexer
import org.eclipse.xtext.parser.antlr.LexerProvider
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.xtext.example.mydsl.ui.documentation.MyBashDocumentationProvider
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider
import org.xtext.example.mydsl.ui.hover.MyBashEObjectHoverProvider
import org.eclipse.xtext.ui.editor.hover.IEObjectHover
import org.eclipse.xtext.ui.editor.hover.DispatchingEObjectTextHover
import org.xtext.example.mydsl.ui.hover.MyBashDispatchingEObjectTextHover
import org.eclipse.xtext.resource.EObjectAtOffsetHelper
import org.xtext.example.mydsl.ui.hover.MyBashEObjectAtOffsetHelper
import org.eclipse.xtext.ui.editor.contentassist.IProposalConflictHelper
import org.eclipse.xtext.ui.editor.contentassist.antlr.AntlrProposalConflictHelper
import org.xtext.example.mydsl.ui.contentassist.MyBashProposalConflictHelper
import org.eclipse.xtext.ui.editor.XtextPresentationReconciler
import org.xtext.example.mydsl.ui.semantic.color.MyBashPresentationReconciler

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
@FinalFieldsConstructor
class MyBashUiModule extends AbstractMyBashUiModule {

	def Class<? extends AbstractAntlrTokenToAttributeIdMapper> bindAbstractAntlrTokenToAttributeIdMapper() {
		MyBashTokenToAttributeIdMapper
	}

	def Class<? extends ISemanticHighlightingCalculator> bindIdeSemanticHighlightingCalculator() {
		MyBashSemanticHighlightingCalculator
	}

	override configureHighlightingLexer(Binder binder) {
		binder.bind(Lexer).annotatedWith(Names.named(LexerIdeBindings.HIGHLIGHTING)).to(MyInnerLexer);
	}

	def Class<? extends DocumentTokenSource> bindDocumentTokenSource() {
		FullDocumentTokenSource
	}

	def Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		MyBashHighlightingConfiguration
	}

	def Class<? extends ITokenTypeToPartitionTypeMapper> bindITokenTypeToPartitionTypeMapper() {
		MyBashTerminalsTokenTypeToPartitionMapper
	}

	override void configureContentAssistLexer(Binder binder) {
		binder.bind(org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer).annotatedWith(Names.named(LexerIdeBindings.CONTENT_ASSIST)).to(org.xtext.example.mybash.ide.lexer.MyInnerLexer);
	}

	override void configureContentAssistLexerProvider(Binder binder) {
		binder.bind(InternalMyBashLexer).toProvider(LexerProvider.create(org.xtext.example.mybash.ide.lexer.MyInnerLexer));
	}

	override Class<? extends IEObjectHover> bindIEObjectHover() {
		return MyBashDispatchingEObjectTextHover;
	}

	def Class<? extends IEObjectDocumentationProvider> bindIEObjectDocumentationProvider() {
		MyBashDocumentationProvider
	}

	def Class<? extends IEObjectHoverProvider> bindIEObjectHoverProvider() {
		MyBashEObjectHoverProvider
	}

	def Class<? extends EObjectAtOffsetHelper> bindEObjectAtOffsetHelper() {
		MyBashEObjectAtOffsetHelper
	}

	override Class<? extends IProposalConflictHelper> bindIProposalConflictHelper() {
		return MyBashProposalConflictHelper;
	}

	def Class<? extends XtextPresentationReconciler> bindXtextPresentationReconciler() {
		MyBashPresentationReconciler
	}

}
