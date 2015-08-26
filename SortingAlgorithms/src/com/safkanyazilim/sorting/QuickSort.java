package com.safkanyazilim.sorting;

public class QuickSort {
	
	/**
	 * Sorts the array in-place in non-decreasing order.
	 * @param a the array to be sorted.
	 */
	public static void sort(int[] a) {
		quickSort(a, 0, a.length - 1);
	}
	
	private static void quickSort(int[] a, int p, int r) {
		while (p < r) {
			int q = partition(a, p, r);
			
			if (q - p < r - q) {
				quickSort(a, p, q - 1); 
				p = q + 1;
			} else {
				quickSort(a, q + 1, r);
				r = q - 1;
			}
			
		}
	}

	private static int partition(int[] a, int p, int r) {
		int x = a[r];
		
		int i = p - 1;
		
		for (int j = p; j < r; j++) {
			if (a[j] <= x) {
				i++;
				int swap = a[i];
				a[i] = a[j];
				a[j] = swap;
			}
		}
		
		int swap = a[i + 1];
		a[i + 1] = a[r];
		a[r] = swap;
		
		return i + 1;
	}
	
}
