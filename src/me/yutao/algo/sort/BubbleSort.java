package me.yutao.algo.sort;
/**
 * bubble sort, sinking sort
 * @author yutao
 *
 */
public class BubbleSort {
	
	private static int[] datas = new int[] {
		95, 45, 15, 78, 84, 51, 24, 12
	};
	
	public void bubbleSort(int[] datas, int n) {
		boolean b = false;
		int c = n - 1;
		int temp;
		for (int i = 0; i < c; i++) {
			if (datas[i] > datas[i + 1]) {
				temp = datas[i];
				datas[i] = datas[i + 1];
				datas[i + 1] = temp;
				b = true;
			}
		}
		
		if (b) {
			bubbleSort(datas, n - 1);
		} else {
			return;
		}		
	}
	
	public void bubbleSort2(int datas[], int nnn) {
		int l = datas.length;
		
		int temp;
		for (int i = 0; i < l - 1; i++) {
			for (int j = 0; j < l - i - 1; j++) {
				boolean swap = false;
				if (datas[j] > datas[j + 1]) {
					temp = datas[j];
					datas[j] = datas[j + 1];
					datas[j + 1] = temp;
					swap = true;
				}
				if (!swap) {
					return;
				}
			}
		}
		
		
	}
	
	public static void main(String args[]) {
		BubbleSort bs = new BubbleSort();
		bs.bubbleSort2(datas, datas.length);
		Utils.p(datas);
	}

}
