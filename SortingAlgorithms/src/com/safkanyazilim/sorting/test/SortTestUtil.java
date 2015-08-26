package com.safkanyazilim.sorting.test;

import static org.junit.Assert.fail;

import java.util.Random;

public class SortTestUtil {

	public static int[] generateRandomIntArray(int size) {
		int[] a = new int[size];
		
		Random random = new Random();
		
		for (int i = 0; i < size; i++) {
			a[i] = random.nextInt();
		}
		
		return a;
	}

	public static void verifyArrayIsInNondecreasingOrder(int[] array) {
		int lastValue = Integer.MIN_VALUE;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] < lastValue) {
				fail("Array element " + i + " is not in order. Value: " + array[i] + " last value was: " + lastValue);
			}
			
			lastValue = array[i];
		}
	}
	
}
