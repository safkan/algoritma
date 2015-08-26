package com.safkanyazilim.util.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.safkanyazilim.util.PriorityQueue;

public class PriorityQueueTest {

	private PriorityQueue priorityQueue;
	
	@Before
	public void setUp() throws Exception {
		this.priorityQueue = new PriorityQueue();
	}

	@Test
	public void testAddAndPoll() {
		this.priorityQueue.add("Mahmut", 2); 
		this.priorityQueue.add("Hamdi", 12);
		
		String firstOut = (String)this.priorityQueue.poll();
		String secondOut = (String)this.priorityQueue.poll();
		String thirdOut = (String)this.priorityQueue.poll();
		
		assertEquals("Hamdi", firstOut);
		assertEquals("Mahmut", secondOut);
		assertNull(thirdOut);
	}

	@Test
	public void testAddAndPollWith20Values() {
		int[] values = {2, 34, 41, 16, 4, 7, 78, 8, 9, 1,
				               67, 32, 11, 77, 5, 24, 87, 99, 0, 100};
		
		for (int i = 0; i < values.length; i++) {
			this.priorityQueue.add(String.valueOf(values[i]), values[i]);
		}

		String firstOut = (String)this.priorityQueue.poll();
		
		assertEquals("100", firstOut);
		
	}
		
	
	
	
}
