package me.yutao.question.linkedlists;

import me.yutao.ds.linkedlist.SingleLinkedList;
import me.yutao.ds.linkedlist.SingleLinkedListNode;

public class ReverseLinkedList<N> {
	
	private SingleLinkedListNode<N> reversedList;
	public void reverse(SingleLinkedListNode<N> head) {
		if (head == null) return;
		
		SingleLinkedListNode<N> next = head.getNext();
		
		head.setNext(reversedList);
		reversedList = head;
		reverse(next);
		
	}
	
	public SingleLinkedListNode<N> reverse2(SingleLinkedListNode<N> head) {
		if (head.getNext() == null) {
			return head;
		}
		SingleLinkedListNode<N> result;
		result = reverse2(head.getNext());
		head.getNext().setNext(head);
		head.setNext(null);
		
		return result;
	}
	
	public void print() {
		
		System.out.println(new SingleLinkedList<N>(reversedList).toString());
	}
	
	public static void main(String[] args) {
		Integer[] a = new Integer[]{1,2,3,4,5,6,7};
		
		SingleLinkedListNode<Integer> list= new SingleLinkedList<Integer>().generateList(a);
		System.out.println(new SingleLinkedList<Integer>(list).toString());
		ReverseLinkedList<Integer> rlist = new ReverseLinkedList<Integer>();
//		rlist.reverse(list);
//		rlist.print();
		SingleLinkedListNode<Integer> r = rlist.reverse2(list);
		System.out.println(new SingleLinkedList<Integer>(r).toString());
		
		
	}

}
