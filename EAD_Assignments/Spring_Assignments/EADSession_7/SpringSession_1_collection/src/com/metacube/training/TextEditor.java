package com.metacube.training;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * class containing methods for texteditor functionality
 * created on September 04, 2018
 */
public class TextEditor {
	
	private List<SpellChecker> spellCheckerList = null;
	private Set<SpellChecker> spellCheckerSet = null;
	private Map<Integer, SpellChecker> spellCheckerMap = null;
	
	public Set<SpellChecker> getSpellCheckerSet() {
		return spellCheckerSet;
	}

	public void setSpellCheckerSet(Set<SpellChecker> spellCheckerSet) {
		this.spellCheckerSet = spellCheckerSet;
	}

	public Map<Integer, SpellChecker> getSpellCheckerMap() {
		return spellCheckerMap;
	}

	public void setSpellCheckerMap(Map<Integer, SpellChecker> spellCheckerMap) {
		this.spellCheckerMap = spellCheckerMap;
	}

	public List<SpellChecker> getSpellCheckerList() {
		return spellCheckerList;
	}

	public void setSpellCheckerList(List<SpellChecker> spellCheckerList) {
		this.spellCheckerList = spellCheckerList;
	}

	public void check() {
		System.out.println("check method of Texteditor !");
		System.out.println("Collection object initialized:");
		System.out.println("List: "+spellCheckerList+"\nSet: "+spellCheckerSet+"\nMap: "+spellCheckerMap);
	}
	
}
