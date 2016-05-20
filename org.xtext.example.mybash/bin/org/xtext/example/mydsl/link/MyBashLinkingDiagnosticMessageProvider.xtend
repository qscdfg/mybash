package org.xtext.example.mydsl.link

import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider
import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider.ILinkingDiagnosticContext

class MyBashLinkingDiagnosticMessageProvider extends LinkingDiagnosticMessageProvider {
	
	override getUnresolvedProxyMessage(ILinkingDiagnosticContext context) {
		return null
	}
	
}