package p1;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class FifoQueue<E> extends AbstractQueue<E> {
	// private LinkedList<E> elements;
	private Node<E> last;

	public FifoQueue() {
		// elements = new LinkedList<>();
		last = null;
	}

	public static class Node<E> {
		E element;
		Node<E> next;

		public Node(E element, Node<E> next) {
			this.element = element;
			this.next = null;
		}

	}

	private class QueueIterator implements Iterator<E> { // varför har inte QueueIterator "<E>"?
		private Node<E> currentNode;
		private boolean isFirstIteration;

		private QueueIterator() {
			if (last == null) {
				currentNode = null;
			} else {
				currentNode = last.next;
			}
			isFirstIteration = true;
		}

		@Override
		public boolean hasNext() {
			if (currentNode == null) {
				return false;
			}

			if (isFirstIteration == true) {
				return true;
			}

			return currentNode != last.next;
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException("NoSuchElementException");
			}
			Node<E> nextElement = currentNode.next;

			// last.next == currentNode.next Innebär att vi har gått igenom hela listan, och
			// den andra innebär att det endast finns en nod
			if (last.next == currentNode.next || last.next == last) {
				currentNode = null;
			} else {
				currentNode = nextElement;
			}

			return nextElement.element;
		}

	}

	public int size() {
		if (last == null)
			return 0;
		Node<E> current = last;
		int count = 1;
		while (current.next != last) {
			current = current.next;
			count++;
		}
		return count;

		// return elements.size();
	}

	public boolean offer(E e) {
		// elements.addLast(e);

		Node<E> newNode = new Node<>(e, null);
		if (last == null) {
			newNode.next = newNode;
			last = newNode;
		} else {
			newNode.next = last.next;
			last.next = newNode;
			last = newNode;
		}

		return true;
	}

	public E peek() {

		if (last == null) {
			return null;
		}
		Node<E> first = last.next;
		return first.element;
	}

	public E poll() {
		// elements.pollFirst();

		if (last == null) {
			return null;
		} else {
			Node<E> first = last.next;
			if (first == last) {
				last = null;
				return first.element;
			}
			Node<E> temp = first;
			last.next = first.next;
			return temp.element;
		}

	}

	public Iterator<E> iterator() {
		Iterator<E> iterator = new QueueIterator();
		return iterator;
	}

	// Förstår ej denna helt
	public void append(FifoQueue<E> otherQueue) {
		if (this == otherQueue) {
			throw new IllegalArgumentException("Köerna är likadana");
		}

		if (otherQueue.isEmpty()) {
			return;
		}
		
		
		while (otherQueue.size() != 0) {
			this.offer(otherQueue.poll());
		}
	}

//	public void append(FifoQueue<E> otherQueue) {
//	    if (this == otherQueue) {
//	        throw new IllegalArgumentException("Köerna är likadana");
//	    }
//
//	    if (otherQueue.isEmpty()) {
//	        return;
//	    }
//
//	    if (this.last == null) {
//	        this.last = otherQueue.last;
//	        this.last.next = otherQueue.last.next; 
//	    } else {
//	       
//	        Node<E> firstNodeOfOtherQueue = otherQueue.last.next;
//	        this.last.next = firstNodeOfOtherQueue;
//	        this.last = otherQueue.last;  
//	    }
//
//	    
//	    otherQueue.last = null;
//	}

}
