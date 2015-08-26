package com.safkanyazilim.sorting.test;

import org.junit.Test;

import com.safkanyazilim.sorting.HeapSort;

public class HeapSortTest {

	@Test
	public void testHeapSort1000Elements() {
		int[] array = SortTestUtil.generateRandomIntArray(1000);
		
		HeapSort.sort(array);
		
		SortTestUtil.verifyArrayIsInNondecreasingOrder(array);
	}

	@Test
	public void testHeapSort10000Elements() {
		int[] array = SortTestUtil.generateRandomIntArray(10000);
		
		HeapSort.sort(array); 
		
		SortTestUtil.verifyArrayIsInNondecreasingOrder(array);
	}

}
