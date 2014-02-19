package me.yutao.ds.stack;

public interface Stack<T> {
	public void push(T obj);
	public T pop();
	public T peek();
	public boolean isEmpty();
}
