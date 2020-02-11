package com.atguigu.search;

//顺序查找
public class OrderSearch {
	public static void main(String[] args) {
		int[] arr = {1,5,9,6,4,5,6,22,54};
		int index = orderFind(arr,5);
		if (index == -1) {
			System.out.println("No Find!");
		}else {
			System.out.println("?±?"+index);
		}
	}

	private static int orderFind(int[] arr, int i) {
		// TODO Auto-generated method stub
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] == i) {
				return j;
			}
		}
		return -1;
	}
	
}
