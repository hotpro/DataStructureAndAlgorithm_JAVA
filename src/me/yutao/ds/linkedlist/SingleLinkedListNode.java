package me.yutao.ds.linkedlist;

public class SingleLinkedListNode<T> {
	private SingleLinkedListNode<T> next;
	private T data;
	
	public SingleLinkedListNode(SingleLinkedListNode<T> next, T data) {
		this.next = next;
		this.data = data;
	}

	public SingleLinkedListNode<T> getNext() {
		return next;
	}

	public void setNext(SingleLinkedListNode<T> next) {
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}
