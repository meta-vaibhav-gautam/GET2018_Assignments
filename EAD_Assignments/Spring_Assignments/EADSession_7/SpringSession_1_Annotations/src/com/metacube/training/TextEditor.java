package com.metacube.training;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * class containing methods for texteditor functionality created on September
 * 04, 2018
 */
public class TextEditor {
	
	@Autowired
	private SpellChecker spellChecker;
	
	private String word;

	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}

	public String getWord() {
		return word;
	}

	public void check() {
		System.out.println(spellChecker.checkSpelling() + " of " + getWord());
	}

}
