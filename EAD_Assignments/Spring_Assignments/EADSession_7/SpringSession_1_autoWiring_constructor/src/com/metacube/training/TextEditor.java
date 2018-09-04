package com.metacube.training;

/**
 * class containing methods for texteditor functionality
 * created on September 04, 2018
 */
public class TextEditor {
	
	private SpellChecker spellChecker = null;
	private String word = "";
	
	public TextEditor(String word, SpellChecker spellChecker) {
		this.word = word;
		this.spellChecker = spellChecker;
	}
	
	public SpellChecker getSpellChecker() {
		return spellChecker;
	}
	
	public String getWord() {
		return word;
	}
	
	public void check() {
		System.out.println(spellChecker.checkSpelling()+" of "+getWord());
	}
	
}
