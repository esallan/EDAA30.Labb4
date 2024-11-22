package p1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class FifoQueueAppendTest<E> {

	@Test
	void testSizeForEmptyQueue() {
		var queue1 = new FifoQueue<String>();
		var queue2 = new FifoQueue<String>();

		queue1.append(queue2);
		assertEquals(0, queue1.size());
	}
	
	@Test
	void testEmptyQueueAddsANonEmptyQueue() {
		var queue1 = new FifoQueue<String>();
		var queue2 = new FifoQueue<String>();
		
		queue1.offer("1");
		queue1.offer("2");
		
		queue2.append(queue1);
		
		assertEquals(2, queue2.size());
		assertEquals(0, queue1.size());
	}
	
	@Test
	void testQueueAddsAEmptyQueue() {
		var queue1 = new FifoQueue<String>();
		var queue2 = new FifoQueue<String>();
		
		queue1.offer("1");
		queue1.offer("2");
		
		queue1.append(queue2);
		
		assertEquals(2, queue1.size());
		assertEquals(0, queue2.size());
	}
	
	@Test
	void testQueueAddsAnotherQueue() {
	    var queue1 = new FifoQueue<String>();
	    var queue2 = new FifoQueue<String>();
	    
	    queue1.offer("1");
	    queue1.offer("2");
	    
	    queue2.offer("3");
	    queue2.offer("4");
	    
	    queue1.append(queue2);
	    
	    // Efter att ha slagit ihop ska queue1 innehålla 4 element och queue2 vara tom
	    assertEquals(4, queue1.size());
	    assertEquals(0, queue2.size());
	}
	
	@Test
	void testQueueAddItSelf() {
	    var queue1 = new FifoQueue<String>();    
	    queue1.offer("1");
	    queue1.offer("2");
	    
	    assertThrows(IllegalArgumentException.class, () -> queue1.append(queue1));
	}

}
