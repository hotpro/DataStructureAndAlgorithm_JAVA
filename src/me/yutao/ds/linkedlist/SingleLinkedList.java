package me.yutao.ds.linkedlist;


public class SingleLinkedList<T> implements List<T> {
	private SingleLinkedListNode<T> head;
	public SingleLinkedList() {
	}
	
	public SingleLinkedList(SingleLinkedListNode<T> head) {
		this.head = head;
	}
	@Override
	public void addFirst(T item) {
		SingleLinkedListNode<T> node = new SingleLinkedListNode<T>(head, item);
		this.head = node;
	}

	@Override
	public void addLast(T item) {
		if (head == null) {
			head = new SingleLinkedListNode<T>(null, item);
			return;
		}
		SingleLinkedListNode<T> last = head;
		while (last.getNext() != null) {
			last = last.getNext();
		}
		
		SingleLinkedListNode<T> node = new SingleLinkedListNode<T>(null, item);
		last.setNext(node);
	}
	
	public SingleLinkedListNode<T> generateList(T[] array) {
		SingleLinkedList<T> list = new SingleLinkedList<T>();
		
		for (T t : array) {
			list.addLast(t);
		}
		
		return list.head;
	}

	@Override
	public T getFirst() {
		if (head == null) {
			return null;
		}
		
		return head.getData();
	}

	@Override
	public T getLast() {
		if (head == null) {
			return null;
		}
		
		SingleLinkedListNode<T> last = head;
		while (last.getNext() != null) {
			last = last.getNext();
		}
		
		return last.getData();
	}

	@Override
	public T removeFirst() {
		if (this.head == null) {
			return null;
		}
		
		T data = head.getData();
		head = head.getNext();
		return data;
	}

	@Override
	public T removeLast() {
		if (this.head == null) {
			return null;
		}
		
		SingleLinkedListNode<T> last = this.head;
		SingleLinkedListNode<T> pre = this.head;
		
		while (last.getNext() != null) {
			pre = last;
			last = last.getNext();
		}
		
		pre.setNext(null);
		return last.getData();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		SingleLinkedListNode<T> tmp = head;
		while (tmp != null) {
			sb.append(tmp.getData());
			if (tmp.getNext() != null) {
				sb.append("->");
			}
			tmp = tmp.getNext();
		}

		return sb.toString();
	}
	
	public static void main(String[] args) {
		SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
		list.addFirst(1);
		list.addFirst(3);
		list.addLast(5);
		list.addFirst(7);
		System.out.println(list);
		list.removeFirst();
		System.out.println(list);
		list.removeFirst();
		System.out.println(list);
		list.removeFirst();
		System.out.println(list);
		list.removeFirst();
		System.out.println(list);
		
//		Integer[] ds = {2,34,2,55};
//		SingleLinkedListNode<Integer> root = list.generateList(ds);
//		System.out.println(root);
	}
	

}
