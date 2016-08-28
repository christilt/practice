public class Deque<E> {

	private Node<E> first;
	private Node<E> last;
	private int size;
	
	public void push(E element) {
		if (size == 0) {
			first = new Node<E>(element);
			last = first;
		} else {
			Node<E> temp = last;
			last = new Node<E>(element);
			last.previous = temp;
			temp.next = last;
		}
		size++;
	}

	public E pop() {
		Node<E> popped = last;
		last = last.previous;
		size--;
		return popped.element;
	}

	public E shift() {
		Node<E> shifted = first;
		first = first.next;
		size--;
		return shifted.element;
	}

	public void unshift(E element) {
		if (size == 0) {
			first = new Node<E>(element);
			last = first;
		} else {
			Node<E> temp = first;
			first = new Node<E>(element);
			first.next = temp;
			temp.previous = first;
		}
		size++;
	}

	private class Node<T> {
		private T element;
		private Node<T> next;
		private Node<T> previous;
		
		public Node(T element) {
			this.element = element;
		}
	}
	
}
