package me.yutao.ds.queue;

public interface Queue<T> {
	public void enqueue(T item);
	public T dequeue();
	public T peekFront();
	public boolean isEmpty();

}
