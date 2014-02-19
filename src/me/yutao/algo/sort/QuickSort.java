package me.yutao.algo.sort;

public class QuickSort {
	private static int[] datas = new int[] {
		95, 45, 15, 78, 84, 51, 24, 12
	};
	
//	public int[] quickSort(int[] source) {
//		if (source.length <= 1) {
//			return source;
//		}
//		int pivot;
//		int l = source.length;
//		int p = source[source.length / 2];
//		
//		int i = 0, j = source.length - 1;
//		while (source[i] < source[p]) {
//			i++;
//		}
//		
//		while (source[j] > source[p]) {
//			j--;
//		}
//		
//		if (j > i) {
//			int tmp = source[i];
//			
//		}
//	}
	
	public void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public int partition(int[] array, int begin, int end) {
		if (begin >= end) {
			return begin;
		}
		int p = begin + (end - begin) / 2;
		int pivot = array[p];
		swap(array, p, end);
		p = begin;
		
		for (int i = begin; i < end; i++) {
			if (array[i] <= pivot) {
				swap(array, p, i);
				p++;
			}
		}
		
		swap(array, p, end);
		
		return p;
	}
	
	public void quickSort(int[] array, int begin, int end) {
		if (end > begin) {
			int p = partition(array, begin, end);
			quickSort(array, begin, p - 1);
			quickSort(array, p + 1, end);
		}
	}
	
	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		qs.quickSort(datas, 0, datas.length - 1);
		Utils.p(datas);
	}

}
