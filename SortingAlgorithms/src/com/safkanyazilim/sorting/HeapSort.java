package com.safkanyazilim.sorting;


public class HeapSort {

	/**
	 * Sorts the array in-place in non-decreasing order.
	 * @param a the array to be sorted.
	 */
	public static void sort(int[] a) {
		heapSort(a);
	}

	private static int left(int i) {
		return 2*i + 1;
	}
	
	private static int right(int i) {
		return 2*i + 2;
	}
	
	@SuppressWarnings("unused")
	private static int parent(int i) {
		return (i - 1) / 2;
	}
	
	private static void maxHeapify(int[] a, int i, int heapSize) {
		int l = left(i);
		int r = right(i);
		int largest;
		
		if (l < heapSize && a[l] > a[i]) {
			largest = l;
		} else {
			largest = i;
		}
		
		if (r < heapSize && a[r] > a[largest]) {
			largest = r;
		}
		
		if (largest != i) {
			int temp = a[i];
			a[i] = a[largest];
			a[largest] = temp;
			
			maxHeapify(a, largest, heapSize);
		}
	}
	
	private static void buildMaxHeap(int[] a) 
	{
		int heapSize = a.length;
		
		for (int i = a.length / 2 - 1; i >= 0; i--) {
			maxHeapify(a, i, heapSize);
		}
	}

	private static void heapSort(int[] a) {
		buildMaxHeap(a); 
		
		int heapSize = a.length;
		
		for (int i = a.length - 1; i > 0; i--) {
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			
			heapSize--;
			
			maxHeapify(a, 0, heapSize);
		}
		
	}
	
}
