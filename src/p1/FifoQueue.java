package p1;

import java.lang.classfile.components.ClassPrinter.Node;
import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.LinkedList;

public class FifoQueue<E> extends AbstractQueue<E> {
	private LinkedList<E> elements;
	private Node<E> last;

	public FifoQueue() {
		elements = new LinkedList<>();
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

	public int size() {
		return elements.size();
	}

	public boolean offer(E e) {
		Node<E> newNode = new Node<>(e, null);
		if (last == null) {
			newNode.next = newNode;
			last = newNode;
		}else {
			newNode.next = last.next;
			last.next = newNode;
			last = newNode;
		}


		return true;

	}

	public E peek() {
		if (elements.isEmpty()) {
			return null;
		}

		return elements.getFirst();
	}

	public E poll() {
		if (elements.isEmpty()) {
			return null;
		}

		E firstElement = elements.getFirst();
		elements.pollFirst();
		return firstElement;
	}

	public Iterator<E> iterator() {
		Iterator<E> iterator = elements.iterator();
		return iterator;
	}

}
