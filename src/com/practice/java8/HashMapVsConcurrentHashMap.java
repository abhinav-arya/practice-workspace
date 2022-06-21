package com.practice.java8;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class HashMapVsConcurrentHashMap {
	
	public static void hashmapDemo() {
		Map<Integer, String> map1 = new HashMap<Integer, String>();
		
		map1.put(1, "text-1");
		map1.put(2, "text-2");
		map1.put(3, "text-3");
		map1.put(4, "text-4");
		
		map1.forEach((k, v) -> System.out.println(k + " ==> " + v));
		System.out.println(map1.containsKey(3));
		System.out.println(map1.containsValue("text-5"));
		System.out.println(map1.getOrDefault(3, "-1"));
		map1.merge(2, "newText-2", (oldval, newval) -> oldval + newval); // output for this row is 2=text-2newText-2
		System.out.println(map1);
	}
	
	public static void concurrentHashmapDemo() {
		Map<Integer, String> cmap = new ConcurrentHashMap<Integer, String>();
		
		cmap.put(2, "String-2");
		cmap.put(3, "String-3");
		cmap.put(4, "String-4");
		cmap.put(5, "String-5");
		
		System.out.println(cmap);
	}

	public static void main(String[] args) {
		
		hashmapDemo();
		concurrentHashmapDemo();
	}
}
