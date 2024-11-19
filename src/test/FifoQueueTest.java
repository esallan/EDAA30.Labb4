package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import p1.FifoQueue;

class FifoQueueTest<E> {

	@Test
	void testSizeForEmptyQueue() {
		FifoQueue<E> queue = new FifoQueue<E>();
		queue.clear();
		assertEquals("", queue);
	}

}
