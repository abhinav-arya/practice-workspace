package com.practice.factorydesign;

public class SMSNotification implements Notification {

	@Override
	public void sendNotification() {
		System.out.print("SMS Notification Send...");
	}
}
