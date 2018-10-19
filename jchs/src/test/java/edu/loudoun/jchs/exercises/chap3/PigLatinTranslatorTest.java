package edu.loudoun.jchs.exercises.chap3;

import edu.loudoun.jchs.exercises.chap3.LanguageProcessor.Language;
import junit.framework.TestCase;

public class PigLatinTranslatorTest extends TestCase {

	LanguageProcessor lp = new PigLatinTranslator();
	
	protected void setUp() throws Exception {
		super.setUp();
		lp = new PigLatinTranslator();
	}
	
	public void testTranslate() {
		assertEquals("BASIC","oobarfay",lp.translate("foobar", Language.PIG_LATIN));
		assertEquals("BASIC","igpay",lp.translate("pig"));
	}
	
	public void testTranslateLeadingVowels() {
		//leading vowel
		assertEquals("LEADING VOWEL","oopsway",lp.translate("oops"));
	}
	
	public void testTranslateQWords() {
		//q test
		assertEquals("Q WORDS","ietquay",lp.translate("quiet"));
		assertEquals("NON WORD",PigLatinTranslator.ERROR,lp.translate("zzz"));
	}
	
	public void testTranslateYWords() {
		//y tests
		assertEquals("Y WORDS","esyay",lp.translate("yes"));
		assertEquals("Y WORDS","ymerhay",lp.translate("rhyme"));
		assertEquals("Y WORDS","exysay",lp.translate("sexy"));
	}
	
	public void testCaps() {
		//capitalization testing
		assertEquals("CAPS","Aquay",lp.translate("Qua"));
		assertEquals("CAPS","Otequay",lp.translate("Quote"));
		assertEquals("CAPS","Oobarway",lp.translate("OoBaR"));
	}
	
	public void testQuotes() {
		assertEquals("QUOTES","\"Elloworldhay\"",lp.translate("\"HelloWorld\""));
		assertEquals("SINGLE QUOTES","'uberway'",lp.translate("'uber'"));
		assertEquals("MIS-QUOTE",PigLatinTranslator.ERROR,lp.translate("\"Missing"));
		assertEquals("NON WORD QUOTED",PigLatinTranslator.ERROR,lp.translate("\"xjhtxvv\""));
	}
	
	public void testPunctuation() {
		assertEquals("PUNCT ?","Elloworldhay?",lp.translate("HelloWorld?"));
		assertEquals("QUOTED PUNCT","'uberway!'",lp.translate("'uber!'"));
		assertEquals("REPEATING PUNCT",PigLatinTranslator.ERROR,lp.translate("\"Missing!!!\""));
		assertEquals("NON WORD PUNCT",PigLatinTranslator.ERROR,lp.translate("xjhtxvv."));
	}	

}
