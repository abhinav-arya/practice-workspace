package com.practice.java8;
import java.util.ArrayList;
import java.util.List;

/*
 * Predicates in Java are implemented with interfaces. Predicate<T> is a generic functional interface 
 * representing a single argument function that returns a boolean value. It is located in the 
 * java.util.function package. It contains a test(T t) method that evaluates the predicate on the given argument. 
 * It is a functional interface, which accepts an argument and returns a boolean. Usually, it used to apply 
 * in a filter for a collection of objects.
 */

import java.util.function.Predicate;

public class PredicateInterface {
	
	public static void simplePredicate() {
		System.out.println("\nsimplePredicate() :-");
		Predicate<Integer> isValidHour = hourValue -> hourValue < 24;
		
		System.out.println(isValidHour.test(25));
		System.out.println(isValidHour.test(21));
	}
	
	public static void andPredicate() {
		System.out.println("\nandPredicate() :-");
		
		Predicate<Integer> isEven = value -> value % 2 == 0;
		Predicate<Integer> lessThan50 = value -> value < 50;
		
		System.out.println(isEven.and(lessThan50).test(22));
	}
	
	public static void orPredicate() {
		System.out.println("\norPredicate() :-");
		
		Predicate<Integer> isEven = value -> value % 2 == 0;
		Predicate<Integer> lessThan50 = value -> value < 50;
		
		System.out.println(isEven.or(lessThan50).test(23));
	}
	
	public static void collectionPredicate() {
		System.out.println("\ncollectionsPredicate() :-");
		
		List<User> users = new ArrayList<User>();
		users.add(new User("111", "admin"));
		users.add(new User("222", "moderator"));
		users.add(new User("333", "admin"));
		users.add(new User("444", "contributor"));
		
		List<User> adminUsers = User.getFilteredObjects(users, (User userPredicate) -> userPredicate.getType().equals("admin"));
		for (User adminUser : adminUsers) {
			System.out.println(adminUser);
		}
	}

	public static void main(String[] args) {
		simplePredicate();
		andPredicate();
		orPredicate();
		collectionPredicate();
	}
}

class User {
	
	private String type;
	private String id;
	
	public User(String id, String type) {
		this.id = id;
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getId() {
		return this.id;
	}
	
	public static List<User> getFilteredObjects(List<User> users, Predicate<User> userPredicate) {
		
		List<User> resultSet = new ArrayList<User>();
		
		for (User user : users) {
			if (userPredicate.test(user)) {
				resultSet.add(user);
			}
		}
		
		return resultSet;
	}
	
	@Override 
	public String toString() {
		return ("ID = " + this.id + ", Type = " + this.type);
	}
}
