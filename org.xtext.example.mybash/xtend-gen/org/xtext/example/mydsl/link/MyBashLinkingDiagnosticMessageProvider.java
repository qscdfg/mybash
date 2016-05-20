package org.xtext.example.mydsl.link;

import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider;
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider;

@SuppressWarnings("all")
public class MyBashLinkingDiagnosticMessageProvider extends LinkingDiagnosticMessageProvider {
  @Override
  public DiagnosticMessage getUnresolvedProxyMessage(final ILinkingDiagnosticMessageProvider.ILinkingDiagnosticContext context) {
    return null;
  }
}
