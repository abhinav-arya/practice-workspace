package com.practice.singleton;

public class SomeLogger {

	private static SomeLogger instance = null;
	
	private SomeLogger() {
		// private constructor to ensure this class is not instantiated outside
	}
	
	public static SomeLogger getInstance() {
		
		if (instance == null) {
			
			// sync to ensure thread safety, only single thread allowed access
			synchronized (SomeLogger.class) {
				if (instance == null) {
					instance = new SomeLogger();
				}
			}
		}
		
		return instance;
	}
	
	public void logMessage(String str) {
		System.out.println("Message logged :: " + str + " :: End of Message");
	}
}
