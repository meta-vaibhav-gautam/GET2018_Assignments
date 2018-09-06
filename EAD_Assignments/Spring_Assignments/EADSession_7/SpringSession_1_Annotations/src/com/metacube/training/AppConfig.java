package com.metacube.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean(name = "textEditor")
	public TextEditor getTextEditor() {
		TextEditor textEditor = new TextEditor();
		textEditor.setWord("metacube");
		return textEditor;
	}

	@Bean
	public SpellChecker getSpellChecker() {
		return new SpellChecker();
	}

}
