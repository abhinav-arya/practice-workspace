package com.practice.java8;

import java.lang.reflect.Constructor;
import java.util.List;

/*
 * Reflection is an API that is used to examine or modify the behavior of methods, classes, and interfaces at runtime.
 * - Reflection gives us information about the class to which an object belongs and also the methods of that class that 
 * can be executed by using the object.
 * - Through reflection, we can invoke methods at runtime irrespective of the access specifier used with them.
 */

// TO BE FIXED***

public class Reflection {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		ReflectionDemo refDemo = new ReflectionDemo();
		Class refClass = refDemo.getClass();
		Constructor refContr = refDemo.getClass().getDeclaredConstructor(null);
		Constructor[] refContrs = refClass.getConstructors();
		
		System.out.println(refDemo);
		System.out.println(refClass);
		System.out.println(refContr);
		for (Constructor constrloop : refContrs) {
			System.out.println(constrloop);
		}
	}
}

class ReflectionDemo {
	int x;
	int y;
	
	ReflectionDemo() {
		// just chill..
	}
	
	ReflectionDemo(int x, int y) {
		// Nah! Still chillin....
	}
	
	public void someMethod() {
		// Keep chillin...
	}
	
	public void anotherMethod() {
		// Wanna guess...?
	}
}
