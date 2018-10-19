/**
 * 
 */
package edu.loudoun.jchs.exercises.chap3;

/**
 * @author scottnestor - TEALS, 2015
 *
 */
public interface LanguageProcessor {
	
	/**
	 * Translate a word into the target language
	 * @param word
	 * @return
	 */
	
	public String translate (String word, Language lang);
	
	/**
	 * Default language translation method
	 * @param word
	 * @return
	 */
	public String translate (String word);
	
	public enum Language {
		PIG_LATIN
	}

}
