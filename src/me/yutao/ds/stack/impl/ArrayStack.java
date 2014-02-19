package me.yutao.ds.stack.impl;

import java.util.ArrayList;
import java.util.EmptyStackException;

import me.yutao.ds.stack.Stack;
/*
 * remove arraylist, use array
 * add capacity
 * use EmptyStackExpection
 * 怎么做到类型安全的检查
 */

public class ArrayStack<T> implements Stack<T> {
	
	private static final int INIT_CAPACITY = 6;
	int size;
	Object[] array;
	
	public ArrayStack() {
		this.array = new Object[INIT_CAPACITY];
	}

	@Override
	public synchronized void push(T obj) {
		Object[] a = array;
		int s = size;
		if (s == a.length) {
			Object[] newArray = new Object[s + s << 1];
			System.arraycopy(a, 0, newArray, 0, s);
			array = a = newArray;
		}
		a[s] = obj;
		size = s + 1;
	}

	@Override
	public synchronized T pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		
		Object obj = array[size - 1];
		array[size - 1] = null;
		size = size - 1;
		return (T)obj;
	}

	@Override
	public synchronized T peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		
		Object obj = array[size - 1];
		return (T)obj;
	}

	@Override
	public synchronized boolean isEmpty() {
		return this.size == 0;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			if (i > 0) {
				sb.append(',');
			}
			sb.append('\"').append(this.array[i]).append('\"');
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		ArrayStack<Integer> as = new ArrayStack<Integer>();
		as.push(1);
		as.push(2);
		as.push(3);	
		as.push(4);
		as.push(5);
		as.push(6);
		as.push(7);
		System.out.println("as: " + as);
	}

}
