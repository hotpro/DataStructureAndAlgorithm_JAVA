package com.ds.queue;

public class ArrayQueue<AT> implements IQueue<AT> {

	private static final int DEFAULT_CAPACITY = 2;
	private AT[] array;
	private int nItems,front,end;
	
	public ArrayQueue() {
		array = (AT[])new Object[DEFAULT_CAPACITY];
		nItems = 0;
		front = 0;
		end = 0;
	}

	@Override
	public void enqueue(AT item) {
		if (isFull()) {
			int oldsize = array.length;
			AT[] newArray = (AT[])new Object[oldsize*2];
			int split = oldsize - front;
			System.arraycopy(array, front, newArray, 0, split);
			System.arraycopy(array, 0, newArray, split, front);
			array = newArray;
			front = 0;
			end = oldsize;
		}
		end++;// chris: bug 1 what will happen if end == 0;
		// bug 2, end is a int, it should be (++end == array.length) ? 0 : end;
		array[end%array.length] = item;
		nItems++;
		
	}

	@Override
	public AT dequeue() {
		if (isEmpty()) {
			throw new RuntimeException("dequeue from an empty queue");
		}
		AT item = array[front%array.length];
		front++;
		nItems--;
		return item;
	}

	@Override
	public AT peekFront() {
		if (isEmpty()) {
			return null;
		}
		return array[front%array.length];
	}

	@Override
	public boolean isEmpty() {
		
		return nItems == 0;
	}
	
	private boolean isFull() {
		return nItems == array.length;
	}
	
	public static void main(String[] args) {
		ArrayQueue<Integer> aq = new ArrayQueue<Integer>();
		aq.enqueue(1);
		int i = aq.peekFront(); // bug
		// please refer to jdk ArrayBlockingQueue
		
		
	}

}
