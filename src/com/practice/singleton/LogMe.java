package com.practice.singleton;

public class LogMe {

	public static void main(String[] args) {
		SomeLogger logger = SomeLogger.getInstance();
		
		logger.logMessage("Connection Timed Out");
		logger.logMessage("Internal Server Error");
		
		
		// Test case: check if different instance is created
		SomeLogger logger2 = SomeLogger.getInstance();
		System.out.println(logger.hashCode() + " == " + logger2.hashCode());
		
		// Test case: check external initialization
		 // SomeLogger logger3 = new SomeLogger(); ==> not allowed
	}
}
