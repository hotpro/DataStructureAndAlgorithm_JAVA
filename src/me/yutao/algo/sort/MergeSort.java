package me.yutao.algo.sort;

import java.util.Arrays;

public class MergeSort {
	private static int[] datas = new int[] {
		95, 45, 15, 78, 84, 51, 24, 12
	};
	
	public int[] merge(int[] left, int[] right) {
		int l = left.length;
		int r = right.length;
		int[] result = new int[l + r];
		int i = 0, j = 0, k = 0;
		
		while (i < l && j < r) {
			if (left[i] < right[j]) {
				result[k++] = left[i++];
			} else {
				result[k++] = right[j++];
			}
		}
		
		while (i < l) {
			result[k++] = left[i++];
		}
		
		while (j < l) {
			result[k++] = right[j++];
		}
		return result;
	}
	
	
	public int[] mergeSort(int[] source) {
		if (source.length == 1) {
			return source;
		}
		int l = source.length;
		int half = l / 2;
		int[] left = Arrays.copyOfRange(source, 0, half);
		int[] right = Arrays.copyOfRange(source, half, l);
		left = mergeSort(left);
		right = mergeSort(right);
		return merge(left, right);
	}
	
	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		int[] sorted = ms.mergeSort(datas);
		Utils.p(sorted);
	}

}
