package p1;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import p1.FifoQueue.Node;

class FifoQueueTest<E> {

	@Test
	void testSizeForEmptyQueue() {
		var queue = new FifoQueue<>(); // istället för FifoQueue<String> queue =...
		assertEquals(0, queue.size()); // (Expected, Actual)
	}

	@Test
	void offerReturnTrue() {
		var queue = new FifoQueue<>();
		assertTrue(queue.offer("Test string")); // ger true om offer ger true
	}

	@Test
	void offerIncreaseQueue() {
		var queue = new FifoQueue<>();
		queue.offer("Test string");
		assertEquals(1, queue.size());
	}

	@Test
	void peekAndRetrievesTheHeadOfQueue() {
		var queue = new FifoQueue<>();
		queue.offer("test string");
		assertEquals("test string", queue.peek());
	}

	void peekSizeNotChanging() {
		var queue = new FifoQueue<>();
		queue.peek();
		assertEquals(0, queue.size());
	}

	@Test
	void peekReturnNullIfEmptyQueue() {
		var queue = new FifoQueue<>();
		assertEquals(null, queue.peek());
	}

	@Test
	void pollReturnsNullIfEmptyQueue() {
		var queue = new FifoQueue<>();
		assertEquals(null, queue.poll());
	}

	@Test
	void pollReturnsFirstObject() {
		var queue = new FifoQueue<>();
		queue.offer("testString");
		assertEquals("testString", queue.poll());
	}

	@Test
	void pollDeletesFirstObject() {
		var queue = new FifoQueue<>();
		queue.offer("test String");
		queue.poll();
		assertEquals(null, queue.poll());
	}

	

	@Test
	void nodeTestThatNextIsNull() {
		FifoQueue.Node<String> node = new FifoQueue.Node<String>("String", null);
		assertNull(node.next);
	}

	@Test
	void testIfCompletlyEmpty() {
		var queue = new FifoQueue<>();
		queue.offer("test1");
		queue.offer("test2");
		queue.poll();
		queue.poll();
		assertEquals(null, queue.poll());
	}
	
	@Test
	void testFirstInFirstOut() {
		var queue = new FifoQueue<String>();
		queue.offer("test1");
		queue.offer("test2");
		assertEquals("test1test2", queue.poll()+queue.poll());
	}
}
