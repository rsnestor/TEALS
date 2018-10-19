/**
 * 
 */
package edu.loudoun.jchs.exercises.chap3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.loudoun.jchs.CommandLineRunner;

/**
 * Pig Latin - Rule leading consonants are moved to the back of the word,
 * followed by "ay" (e.g., rich = ichray).
 * 
 * Key Concepts: 
 * 1) Implementing an interface (GoF facade pattern) 
 * 2) Enumeration declaration and usage 
 * 3) Regular expression matching String.matches(String regex)
 * 4) Regular expression 'capture' groups
 * 
 * @author scottnestor - TEALS, 2015
 *
 */
public class PigLatinTranslator extends CommandLineRunner implements LanguageProcessor {

	private String vowels = "aeiouy";
	public static final String ERROR = "***INVALID***";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		println("Pig Latin Translator.");
		PigLatinTranslator translator = new PigLatinTranslator();
		String word = "";
		try {
			do {
				print("Enter an English word > ");
				word = stdin.nextLine();
				if (word.length() > 0) {
					printf("%s\n", translator.translate(word, Language.PIG_LATIN));
				}
			} while (word.length() > 0);
		} catch (Exception e) {
			println(e.getMessage());
		} finally {
			stdin.close();
		}
	}

	public String translate(String word) {
		return translate(word, Language.PIG_LATIN);
	}

	@Override
	/**
	 * Pig latin language translation rules: 
	 * <ol><li> Move leading consonants to the end of the word 
	 * <li> If the word begins with a vowel, do not change 
	 * <li> If the word begins with "qu", move both letters 
	 * <li> Letter "y" is treated as a consonant if it's the 1st char only
	 * <li> If the first character is capitalized, retain capitalization, all others to lower 
	 * <li> If the word begins with a vowel append "way" to then end, otherwise append"ay"
	 * </ol>
	 * 
	 * Note: words without vowels are invalid.
	 */
	public String translate(String word, Language lang) {
		if (lang != Language.PIG_LATIN) {
			throw new RuntimeException("Un-supported language.");
		}
		String result = "";
		String suffix = "";
		boolean capFirst = false;
		int ix = 0;
		WordMeta meta = new WordMeta(word);
		word = meta.getCoreWord();
		if (word!=null) {
			//check 1st letter for capitalization
			capFirst = (word.charAt(0)<='Z');
			word = word.toLowerCase();
			char letters[] = word.toCharArray();
			
			//loop through until a vowel is discovered (preceding consonants become the suffix)
			for (char letter : letters) {
				// exception for "qu" and 'y'
				if (vowels.indexOf(letter) >= 0 && (!(meta.isQWord() && letter == 'u'))
						&& (!(letter == 'y' && ix == 0))) {
					break;
				}
				suffix += letter;
				ix++;
			}
			
			if (suffix.length() < word.length()) {
				if (capFirst){ //capitalize 1st char if necessary
					result += word.substring(ix, ix+1).toUpperCase();
					ix++;
				}
				if (ix<word.length()) result += word.substring(ix);
				result += suffix + ((meta.isVowelFirst())?"way":"ay");
				
				//final formatting
				if (meta.hasPunctuation()) result += meta.getPunctuationMark(); 
				if (meta.hasQuotes()) {
					result = meta.getQuotationMark() + result + meta.getQuotationMark();
				}
			} // else no vowels, which is invalid
			
		}
		return (result.length()>0 ? result : ERROR);
	}

	public class WordMeta {
		
		boolean vowelFirst = false;
		boolean qWord = false;
		String coreWord = null;
		Character quotationMark = null;
		Character punctuationMark = null;
		
		public WordMeta (String word) {
			/* Regex Explanation
			 * ^ Beginning of String
			 * ([\"']?)     Optional opening quotation mark (capture group 1)
			 * (([A-Za-z]+) One or more alphabetic characters (group 2)
			 * [.!?]?       Optional punctuation mark
			 * ([\"']?)     Optional ending quotation mark (group 3)
			 * $ End of String
			 */
			Pattern p = Pattern.compile("^([\"']?)([A-Za-z]+)([.!?]?)([\"']?)$");
			Matcher m = p.matcher(word.trim());
			if (m.matches() && (m.group(1).equals(m.group(4)))) {
				if (!m.group(1).isEmpty()) quotationMark = m.group(1).charAt(0);
				if(!m.group(3).isEmpty()) punctuationMark = m.group(3).charAt(0);
				setCoreWord(m.group(2));
				setQWord(m.group(2).matches("^[Qq][Uu].*$"));
				setVowelFirst(m.group(2).toLowerCase().matches("^[a,e,i,o,u]+.*?"));
			}
			
		}
		
		public boolean isVowelFirst() {
			return vowelFirst;
		}
		protected void setVowelFirst(boolean vowelFirst) {
			this.vowelFirst = vowelFirst;
		}
		public boolean hasQuotes() {
			return quotationMark!=null;
		}
		public char getQuotationMark() {
			return quotationMark;
		}
		protected void setQuotationMark(char quote) {
			this.quotationMark = quote;
		}
		public boolean hasPunctuation() {
			return punctuationMark!=null;
		}
		public char getPunctuationMark() {
			return punctuationMark;
		}
		protected void setPunctuationMark(char punctuation) {
			this.punctuationMark = punctuation;
		}
		public boolean isQWord() {
			return qWord;
		}
		protected void setQWord(boolean qWord) {
			this.qWord = qWord;
		}
		public String getCoreWord() {
			return coreWord;
		}
		protected void setCoreWord(String coreWord) {
			this.coreWord = coreWord;
		}
		
		
	}
}
