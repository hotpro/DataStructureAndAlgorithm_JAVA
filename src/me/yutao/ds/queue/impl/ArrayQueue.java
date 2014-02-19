package me.yutao.ds.queue.impl;

import java.util.EmptyStackException;

import me.yutao.ds.queue.Queue;

public class ArrayQueue<T> implements Queue<T> {
	public static final int INIT_CAPACITY = 2;
	private Object[] array;
	private int size, front, putIndex;

	public ArrayQueue() {
		array = new Object[INIT_CAPACITY];
		size = 0;
		front = 0;
		putIndex = 0;
	}
	@Override
	public synchronized void enqueue(T item) {
		if (size == array.length) {
			int s = array.length;
			Object[] newArray = new Object[s + INIT_CAPACITY];
			int split = s - front;
			System.arraycopy(array, front, newArray, 0, split);
			System.arraycopy(array, 0, newArray, split, front);
			array = newArray;
			front = 0;
			putIndex = s;
		}
		array[putIndex] = item;
		putIndex = inc(putIndex);
		size++;
	}
	
	private int inc(int i) {
		return (++i == array.length) ? 0 : i;
	}

	@Override
	public synchronized T dequeue() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		
		T obj = (T)array[front];
		front = inc(front);
		size--;
		return obj;
	}

	@Override
	public synchronized T peekFront() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		
		T obj = (T)array[front];
		return obj;
	}

	@Override
	public synchronized boolean isEmpty() {
		return size == 0;
	}
	
	public static void main(String[] args) {
		ArrayQueue<Integer> aq = new ArrayQueue<Integer>();
		aq.enqueue(1);
		aq.enqueue(2);
		aq.enqueue(3);
		aq.enqueue(4);
		aq.enqueue(5);
		aq.enqueue(6);
		aq.enqueue(7);
		aq.dequeue();
		aq.dequeue();
		int i = aq.peekFront();
		System.out.println("i: " + i);
	}
}
