package com.safkanyazilim.util;

public class PriorityQueue {
	
	private Element[] a;
	private int queueSize;
	
	private static class Element {
		
		public Element(Object object, int priority) {
			this.object = object;
			this.priority = priority;
		}
		
		public Object object;
		public int priority;
	}
	
	
	public PriorityQueue() {
		this.a = new Element[10];
		this.queueSize = 0;
	}
	
	public int size() {
		return this.queueSize;
	}

	/**
	 * Retrieve the highest priority object in the queue. Null if queue is empty. 
	 * 
	 * @return highest priority object in the queue, null if empty.
	 */
	public Object poll() {
		if (this.queueSize == 0) {
			return null;
		}
		
		Element top = this.a[0];
		
		this.a[0] = this.a[this.queueSize - 1];
		this.a[this.queueSize - 1] = null; 
		
		this.queueSize--;
		
		this.maxHeapify(0, this.queueSize);
		
		return top.object;
	}
	
	/**
	 * Insert given object into the queue with given priority.
	 * @param object the object to be inserted
	 * @param priority the priority of the object
	 */
	public void add(Object object, int priority) {
		if (this.queueSize == this.a.length) {
			this.doubleQueueCapacity();
		}

		this.a[this.queueSize] = new Element(object, priority);
		
		this.queueSize++;
		
		int index = parent(this.queueSize - 1);  
		
		while (true) {
			this.maxHeapify(index, this.queueSize);
			
			if (index == 0) {
				break;
			}
			
			index = parent(index);
		}
	}
	
	
	
	private void doubleQueueCapacity() {
		Element[] newA = new Element[this.a.length * 2];
		
		System.arraycopy(this.a, 0, newA, 0, a.length);
		
		this.a = newA;
	}

	private static int left(int i) {
		return 2*i + 1;
	}
	
	private static int right(int i) {
		return 2*i + 2;
	}
	
	private static int parent(int i) {
		return (i - 1) / 2;
	}


	private void maxHeapify(int i, int heapSize) {
		int l = left(i);
		int r = right(i);
		int largest;
		
		if (l < heapSize && a[l].priority > a[i].priority) {
			largest = l;
		} else {
			largest = i;
		}
		
		if (r < heapSize && a[r].priority > a[largest].priority) {
			largest = r;
		}
		
		if (largest != i) {
			Element temp = a[i];
			a[i] = a[largest];
			a[largest] = temp;
			
			maxHeapify(largest, heapSize);
		}
	}

	
	
}
