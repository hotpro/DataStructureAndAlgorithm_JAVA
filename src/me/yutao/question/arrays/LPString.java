package me.yutao.question.arrays;
/**
 * Given a string S, find the longest palindromic substring in S.
 * http://leetcode.com/2011/11/longest-palindromic-substring-part-i.html
 * @author yutao
 *
 */
public class LPString {
	String reverse(String s) {
		char[] a = s.toCharArray();
		int l = a.length;
		for (int i = 0; i < l/2; i++) {
			char tmp = a[i];
			a[i] = a[l - i - 1];
			a[l - i - 1] = tmp;
		}
		
		return String.valueOf(a);
	}
	
	String lps(String s) {
		String s1 = s;
		String s2 = reverse(s1);
		
		int maxCommonCount = 0;
		int index = 0;
		int l1 = s1.length();
		int l2 = s2.length();
		char[] a1 = s1.toCharArray();
		char[] a2 = s2.toCharArray();
		for (int i = 0; i < l1; i++) {
			for (int j = 0; j < l2; j++) {
				if (a1[i] == a2[j]) {
					int m = i;
					int n = j;
					int commonCount = 0;
					for (; m < l1 && n < l2; m++, n++) {
						if (a1[m] == a2[n]) {
							commonCount++;
						} else {
							break;
						}
					}
					if (commonCount > maxCommonCount) {
						String subString = s1.substring(i, i + commonCount);
						if (subString.equals(reverse(subString))) {
							maxCommonCount = commonCount;
							index = i;	
						}
					}
				}
			}
		}
		String subString = s1.substring(index, index + maxCommonCount);
		return subString;
		
		
	}
	
	public String lps2(String s) {
		char[] a = s.toCharArray();
		int maxCommonCount = 0;
		int index = 0;
		int l = a.length;
		for (int i = 0; i < l - 1; i++) {
			for (int j = i + 1; j < l; j++) {
				String substring = s.substring(i, j + 1);
				if (substring.equals(reverse(substring))) {
					if ((j + 1 - i) > maxCommonCount) {
						maxCommonCount = j + 1 - i;
						index = i;
					}
				}
			}
		}
		return s.substring(index, index + maxCommonCount);
	}
	
	public String lps3(String s) {
		int n = s.length();
		char[] a = s.toCharArray();
		int index = 0;
		int maxCount = 1;
		boolean[][] table = new boolean[1000][1000];
		for (int i = 0; i < n; i++) {
			table[i][i] = true;
		}
		
		for (int i = 0; i < n - 1; i++) {
			if (a[i] == a[i+1]) {
				table[i][i+1] = true;
				index = i;
				maxCount = 2;
			}
		}
		
		for (int len = 3; len <= n; len++) {
			for (int i = 0; i < n - len + 1; i++) {
				int j = i + len - 1;
				if (a[i] == a[j] && table[i + 1][j - 1]) {
					index = i;
					maxCount = len;
				}
			}
		}
		
		return s.substring(index, index + maxCount);
	}
	
	public static void main(String[] args) {
		LPString lps = new LPString();
//		String s = "hel1o0";
//		System.out.println(lps.reverse(s));
//		String s1 = "caba";
//		System.out.println(lps.lps(s1));
//		
//		String s2 = "abacdfgdcaba";
//		System.out.println(lps.lps(s2));
		
//		String s3 = "121345643121";
//		System.out.println(lps.lps2(s3));
		
		String s4 = "121345643121";
		System.out.println(lps.lps3(s4));
		
	}
}
