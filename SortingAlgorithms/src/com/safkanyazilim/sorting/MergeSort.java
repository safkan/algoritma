package com.safkanyazilim.sorting;

public class MergeSort {

	/**
	 * Sorts the array in-place in non-decreasing order.
	 * @param a the array to be sorted.
	 */
	public static void sort(int[] a) {
		mergeSort(a, 0, a.length - 1);
	}
	
	private static void mergeSort(int[] a, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			
			mergeSort(a, p, q);
			mergeSort(a, q + 1, r);
			merge(a, p, q, r);
		}
	}
	
	private static void merge(int[] a, int p, int q, int r) {
		int n1 = q - p +1;
		int n2 = r - q;
		
		int[] L = new int[n1 + 1];
		int[] R = new int[n2 + 1];
		
		for (int i = 0; i < n1; i++) {
			L[i] = a[p + i];
		}
		
		for (int j = 0; j < n2; j++) {
			R[j] = a[q + 1 + j];
		}
		
		L[n1] = Integer.MAX_VALUE; // 2^31 - 1
		R[n2] = Integer.MAX_VALUE;
		
		int i = 0;
		int j = 0;
		
		for (int k = p; k <= r; k++) {
			if (L[i] <= R[j]) {
				a[k] = L[i];
				i++;
			} else {
				a[k] = R[j];
				j++;
			} 
		}
		
	}
	
}
