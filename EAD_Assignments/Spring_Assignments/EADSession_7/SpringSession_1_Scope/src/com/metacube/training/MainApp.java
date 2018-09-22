package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		
		TextEditor textEditorSingleton = (TextEditor)applicationContext.getBean("textEditorSingleton");
		TextEditor textEditorPrototype = (TextEditor)applicationContext.getBean("textEditorPrototype");
		textEditorSingleton.check();
		System.out.println("\nSetting another value in Singleton:\n");
		textEditorSingleton.setWord("Jaipur");
		TextEditor textEditorSingleton1 = (TextEditor)applicationContext.getBean("textEditorSingleton");
		textEditorSingleton1.check(); //Now the word here will be 'Jaipur' only, will not be affected by XML
		
		textEditorPrototype.check();
		System.out.println("\nSetting another value in Prototype:");
		textEditorPrototype.setWord("Jaipur");
		TextEditor textEditorPrototype1 = (TextEditor)applicationContext.getBean("textEditorPrototype");
		textEditorPrototype1.check(); //Now the word in this should be metacubian again
		
	}

}
