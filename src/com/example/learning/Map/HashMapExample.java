package com.example.learning.Map;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/*
 *This class is used to experiment various options available in hashmap and concurrent hashmaps 
 *@author Prabhu Ganapathilingam
 *@see documenation
 *@since Java 1.8
 *
 */
public class HashMapExample {

	public static void main(String[] args) {
		hashMapPutValues(); // call this method do some hashmap testing
		navigationalMap();
		hashMapByOrdering();
	}

	private static void hashMapByOrdering() {
		// TODO Auto-generated method stub
		ConcurrentNavigableMap<String, Integer> concurrentNavigableMap = new ConcurrentSkipListMap();
		concurrentNavigableMap.clear();
		concurrentNavigableMap.put("one", 1);
		concurrentNavigableMap.put("two", 2);
		concurrentNavigableMap.put("three", 3);
		concurrentNavigableMap.put("four", 4);
		// concurrentNavigableMap.computeIfAbsent("seven", );

		BiFunction<Integer, Integer, Integer> biFunction = createBiFunction();
		
		// concurrentNavigableMap.compute("ten", biFunction.apply(4, 6));
		concurrentNavigableMap.descendingKeySet().forEach((k) -> System.out.println(k));
		concurrentNavigableMap.descendingMap().forEach((k, v) -> System.out.println("key is " + k + " value is " + v));
		System.out.println("Entry set is ");
		concurrentNavigableMap.entrySet()
				.forEach((e) -> System.out.println("key is " + e.getKey() + " value is " + e.getValue()));
		System.out.println(concurrentNavigableMap.containsKey("one"));
		
		System.out.println("higher one is " +concurrentNavigableMap.navigableKeySet().higher("one"));
		System.out.println("first entry is "+concurrentNavigableMap.pollFirstEntry());
		System.out.println("first entry is "+concurrentNavigableMap.values().size());
		concurrentNavigableMap.values().parallelStream().collect(Collectors.toList());
		
	}

	private static BiFunction<Integer, Integer, Integer> createBiFunction() {
		// TODO Auto-generated method stub
		return new BiFunction<Integer, Integer, Integer>() {

			@Override
			public Integer apply(Integer t, Integer u) {
				// TODO Auto-generated method stub
				return t + u;
			}
		};

	}

	/**
	 * {@link} this method only contains 20 lines
	 */
	private static void navigationalMap() {
		ConcurrentNavigableMap<String, Integer> concurrentNavigableMap = new ConcurrentSkipListMap();
		concurrentNavigableMap.clear();
		concurrentNavigableMap.put("one", 1);
		concurrentNavigableMap.put("two", 2);
		concurrentNavigableMap.put("three", 3);
		concurrentNavigableMap.put("four", 4);
		System.out.println("first entry " + concurrentNavigableMap.firstEntry());
		System.out.println("first key " + concurrentNavigableMap.firstKey());
		ConcurrentNavigableMap<String, Integer> headMap = concurrentNavigableMap.headMap("two");
		printMap(headMap);
		ConcurrentNavigableMap<String, Integer> tailMap = concurrentNavigableMap.tailMap("two");
		printMap(tailMap);

		System.out.println(concurrentNavigableMap.ceilingEntry("two"));
		System.out.println(concurrentNavigableMap.ceilingKey("two"));

		// ConcurrentNavigableMap<String, Integer> subMap =
		// concurrentNavigableMap.subMap("two","four");
		// printMap(subMap);

	}

	/*
	 * method accepts concurrent navigable map
	 * 
	 * @param
	 */
	private static void printMap(ConcurrentMap<String, Integer> concurrentHashMap) {
		System.out.println("Print Map values using for each ");
		concurrentHashMap.forEach((k, v) -> System.out.println("key is " + k + " value is " + v));
	}

	private static void hashMapPutValues() {
		HashMap<String, Integer> hashMap = new HashMap<>();
		hashMap.clear();
		hashMap.put("five", 5);
		hashMap.put("six", 6);

		ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<String, Integer>();
		concurrentHashMap.clear(); // clear the values in the hashmap
		concurrentHashMap.put("one", 1);
		concurrentHashMap.put("two", 2);

		Object value = concurrentHashMap.get("one");
		// add the value to hash if absent
		concurrentHashMap.putIfAbsent("three", 3);
		printMap(concurrentHashMap);
	}

}
