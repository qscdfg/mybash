package org.xtext.example.mydsl.lexer;

import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.xbase.parser.TokenSequencePreservingPartialParsingHelper;

@SuppressWarnings("all")
public class MyBashPartialParsingHelper extends TokenSequencePreservingPartialParsingHelper {
  @Override
  public IParseResult reparse(final IParser parser, final IParseResult previousParseResult, final ReplaceRegion replaceRegion) {
    return this.fullyReparse(parser, previousParseResult, replaceRegion);
  }
}
