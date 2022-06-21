package com.practice.factorydesign;

public class EmailNotification implements Notification {

	@Override
	public void sendNotification() {
		System.out.print("Email Notification Sent...");
	}
}
