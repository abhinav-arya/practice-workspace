package com.practice.factorydesign;

public class NotificationFactory {
	
	public Notification getInstance(String notificationType) {
		
		SMSNotification smsNotification = null;
		EmailNotification emailNotification = null;
		
		switch (notificationType) {
		
		case"SMS":
			if (smsNotification == null)
				smsNotification = new SMSNotification();
			return smsNotification;
			
		case "Email": 
			if (emailNotification == null)
				emailNotification = new EmailNotification();
			return emailNotification;
		}
		
		return null;
	}
}
