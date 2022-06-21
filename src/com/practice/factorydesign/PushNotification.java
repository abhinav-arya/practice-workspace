package com.practice.factorydesign;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PushNotification {
	
	public static void main(String[] arg) {
		System.out.println("Select Notification Medium (SMS, SMEmail): ");
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		
		try {
			NotificationFactory notificationFactory = new NotificationFactory();
			notificationFactory.getInstance(reader.readLine()).sendNotification();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
