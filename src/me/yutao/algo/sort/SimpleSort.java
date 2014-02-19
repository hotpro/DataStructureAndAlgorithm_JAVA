package me.yutao.algo.sort;

public class SimpleSort {
	
	private static int[] datas = new int[] {
		95, 45, 15, 78, 84, 51, 24, 12
	};
	
	public void selectionSort(int[] array) {
		int l = array.length;
		int i = 0, j = 0;
		for (; i < l; i++) {
			int min = i;
			for (j = i; j < l; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			swap(array, i, min);
		}
	}
	
	public void insertionSort(int[] array) {
		int l = array.length;
		for (int i = 1; i < l; i++) {
			int key = array[i];
			int j = i;
			while (j > 0 && array[j - 1] > key) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = key;
		}
	}
	
	public static void main(String[] args) {
		SimpleSort ss = new SimpleSort();
//		ss.selectionSort(datas);
		ss.insertionSort(datas);
		Utils.p(datas);
	}
	public void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
