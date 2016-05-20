package org.xtext.example.mydsl.lexer

import org.eclipse.xtext.parser.IParseResult
import org.eclipse.xtext.parser.IParser
import org.eclipse.xtext.util.ReplaceRegion
import org.eclipse.xtext.xbase.parser.TokenSequencePreservingPartialParsingHelper

class MyBashPartialParsingHelper extends TokenSequencePreservingPartialParsingHelper{
	
	override reparse(IParser parser, IParseResult previousParseResult, ReplaceRegion replaceRegion) {
		fullyReparse(parser, previousParseResult, replaceRegion);
	}
	
}