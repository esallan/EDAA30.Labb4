
package p1;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class FifoQueueIteratorTest<E> {

	@Test
	void hasNextReturnsTrueIfListHasNodes() {
		var queue = new FifoQueue<>();
		queue.offer("1");
		queue.offer("2");
		assertTrue(queue.iterator().hasNext());
	}

	@Test
	void hasNextReturnsFalseIfEmptyList() {
		var queue = new FifoQueue<>();
		queue.offer("test");
		queue.clear();
		assertFalse(queue.iterator().hasNext());
	}

	@Test
	void hasNextReturnstTrueIfEmptyList() {
		var queue = new FifoQueue<>();
		queue.offer("test");
		assertTrue(queue.iterator().hasNext());
	}

	@Test
	void nextThrowsNoSuchElementExceptionOnEmptyList() {
		var queue = new FifoQueue<>();
		queue.clear();
		assertThrows(NoSuchElementException.class, () -> queue.iterator().next());
	}

	@Test
	void nextReturnsValueOfNextElementIfSuchExist() {
		var queue = new FifoQueue<>();
		queue.offer("testString");
		assertEquals("testString", queue.iterator().next());

	}

	@Test
	void nextDoesNotChangeTheList() {
		var queue = new FifoQueue<>();
		queue.offer("test1");
		queue.offer("test2");
		queue.iterator().next();
		assertEquals(2, queue.size());
	}

	@Test
	void twoIteratorsTest() {
		var queue = new FifoQueue<>();

		queue.offer("1");
		queue.offer("2");

		
		var iterator1 = queue.iterator();
		var iterator2 = queue.iterator();

		
		assertTrue(iterator1.hasNext());
		assertTrue(iterator2.hasNext());

		
		assertEquals("2", iterator1.next()); 
		assertEquals("2", iterator2.next()); 
	}

}
