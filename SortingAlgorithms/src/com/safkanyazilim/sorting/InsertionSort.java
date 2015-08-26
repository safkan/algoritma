package com.safkanyazilim.sorting;

public class InsertionSort {

	/**
	 * Sorts the array in-place in non-decreasing order.
	 * @param a the array to be sorted.
	 */
	public static void sort(int[] a) {
		for (int j = 1; j < a.length; j++) {
			int key = a[j];
			
			int i = j - 1;
			
			while (i >= 0 && a[i] > key) {
				a[i + 1] = a[i];
				i--;
			}
			
			a[i + 1] = key;
		}
	}
	
	
}
