package me.yutao.ds.linkedlist;

public interface List<T> {
	// think about the method of contain

	public void addFirst(T item);
	public void addLast(T item);	
	
	public T getFirst();
	public T getLast();
	
	public T removeFirst();
	public T removeLast();

}
