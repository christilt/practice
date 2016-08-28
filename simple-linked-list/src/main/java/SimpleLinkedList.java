import java.util.NoSuchElementException;

public class SimpleLinkedList<E> {
	
	/* props to workwelldone */

	private Entry<E> head;
	private int size;

	public SimpleLinkedList() {
		this.size = 0;
	}

	public SimpleLinkedList(E[] inputArray) {
		if (inputArray == null || inputArray.length == 0) {
			this.size = 0;
		} else {
			for (E e : inputArray) push(e);
		}
	}

	public int size() {
		return this.size;
	}

	public E pop() {
		if (size == 0) throw new NoSuchElementException();
		E popped = head.element;
		this.head = this.head.nextEntry;
		size--;
		return popped;
	}

	public boolean push(E e) {
		if (e == null) return false;
		if (head == null) {
			head = new Entry<E> (e);
		} else {
			Entry<E> temp = new Entry<E> (e);
			temp.nextEntry = head;
			head = temp;
		}
		size++;
		return true;
	}

	@SuppressWarnings("unchecked")
	public void reverse() {
		int originalSize = size;
		Object[] temp = new Object[originalSize];
		for (int i = 0; i < originalSize; i++) temp[i] = pop();
		for (int i = 0; i < originalSize; i++) push((E)temp[i]);
	}

	public Object[] asArray(Class<?> c) {
		Object[] temp = new Object[size];
		for (int i = 0; i < size; i++) {
			Entry<E> next = head;
			temp[i] = next.element;
			head = next.nextEntry;
		}
		return temp;
	}

	private class Entry<El> {

		private El element;
		private Entry<El> nextEntry;

		public Entry(El e) {
			this.element = e;
		}
	}

}
