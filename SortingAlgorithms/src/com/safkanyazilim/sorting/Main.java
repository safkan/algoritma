package com.safkanyazilim.sorting;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		for (int size = 10; size < 100_000_000; size *= 2) {
			testTimeForSize(size);
		}
	}
	
	public static void testTimeForSize(int size) {
		int[] a = generateRandomIntArray(size);
		
		long start = System.currentTimeMillis();
		
		//HeapSort.sort(a);
		
		QuickSort.sort(a);
		
		//MergeSort.sort(a);
		
		//InsertionSort.sort(a);
		long end = System.currentTimeMillis();
		
		System.out.println("Time elapsed( " + size +" ): " + (end - start)/1000.0F);
	}
	
	
	public static int[] generateRandomIntArray(int size) {
		int[] a = new int[size];
		
		Random random = new Random();
		
		for (int i = 0; i < size; i++) {
			a[i] = random.nextInt();
		}
		
		return a;
	}

	public static int[] generateSortedIntArray(int size) {
		int[] a = new int[size];
		
		for (int i = 0; i < size; i++) {
			a[i] = i;
		}
		
		return a;
	}

	
	
}
