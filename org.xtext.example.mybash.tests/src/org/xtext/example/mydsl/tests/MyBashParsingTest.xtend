/*
 * generated by Xtext 2.9.1
 */
package org.xtext.example.mydsl.tests

import com.google.inject.Inject

import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.xtext.example.mydsl.myBash.Bash
import org.xtext.example.mydsl.myBash.Word
import static extension org.eclipse.xtext.EcoreUtil2.*
import org.xtext.example.mydsl.myBash.SimpleCommand

@RunWith(XtextRunner)
@InjectWith(MyBashInjectorProvider)
class MyBashParsingTest {

	@Inject
	extension ParseHelper<Bash>;
	@Inject
	extension ValidationTestHelper;

	@Test
	def void loadModel() {
	}

	@Test
	def void testWord() {
		val result = '''
			a $a $(a) ${a} a$a$(a)${a} a$a$(a) a$(a)${a} a
		'''.parse
		result.assertNoErrors
		result.assertNoIssues
		var wordList = result.getAllContentsOfType(Word);
		var simpleCommands = result.getAllContentsOfType(SimpleCommand)
		Assert.assertEquals(5, simpleCommands.size);

		Assert.assertEquals(7, wordList.size);
	}

}