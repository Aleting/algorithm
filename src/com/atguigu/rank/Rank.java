package com.atguigu.rank;

import java.util.Arrays;

public class Rank {
	public static void main(String[] args) {
		int[] arr = new int[100000];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100000);
		}

		// 冒泡排序
		long start, end;
		start = System.currentTimeMillis();
		BubbleSort(arr);
		end = System.currentTimeMillis();
		System.out.printf(
				"冒泡排序:\n start time:" + start + ";\n end time:" + end + ";\n Run Time:" + (end - start) + "(ms)");
		// 选择排序
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100000);
		}
		start = System.currentTimeMillis();
		SelectSort(arr);
		end = System.currentTimeMillis();
		System.out.printf(
				"\n选择排序:\n start time:" + start + ";\n end time:" + end + ";\n Run Time:" + (end - start) + "(ms)");
		// 插入排序
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100000);
		}
		start = System.currentTimeMillis();
		insertSort(arr);
		end = System.currentTimeMillis();
		System.out.printf(
				"\n插入排序:\n start time:" + start + ";\n end time:" + end + ";\n Run Time:" + (end - start) + "(ms)"
				);
		// 希尔交换法
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100000);
		}
		start = System.currentTimeMillis();
		shellSort(arr);
		end = System.currentTimeMillis();
		System.out.printf(
				"\n希尔交换排序:\n start time:" + start + ";\n end time:" + end + ";\n Run Time:" + (end - start) + "(ms)");
		// 希尔移动法
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100000);
		}
		start = System.currentTimeMillis();
		shellSort(arr);
		end = System.currentTimeMillis();
		System.out.printf(
				"\n希尔移动排序:\n start time:" + start + ";\n end time:" + end + ";\n Run Time:" + (end - start) + "(ms)");
		// 快速法排序
		int[] arr2 = new int[1000000];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = (int) (Math.random() * 1000000);
		}
		start = System.currentTimeMillis();
		quickSort(arr2, 0, arr2.length-1);
		end = System.currentTimeMillis();
		System.out.printf(
				"\n快速法排序:\n start time:" + start + ";\n end time:" + end + ";\n Run Time:" + (end - start) + "(ms)");
		//归并排序
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = (int) (Math.random() * 1000000);
		}
		int[] temp = new int[arr2.length];
		start = System.currentTimeMillis();
		MergetSort(arr2, 0, arr2.length-1, temp);
		end = System.currentTimeMillis();
		System.out.printf(
				"\n归并排序:\n start time:" + start + ";\n end time:" + end + ";\n Run Time:" + (end - start) + "(ms)");
		//基数排序
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 10000);
		}
		start = System.currentTimeMillis();
		radixSort(arr);
		end = System.currentTimeMillis();
		System.out.printf(
				"\n基数排序:\n start time:" + start + ";\n end time:" + end + ";\n Run Time:" + (end - start) + "(ms)");
	}

	// 冒泡排序
	public static void BubbleSort(int[] arr) {
		int temp = 0; 
		boolean flagBoolean = false;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					flagBoolean = true;
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			/*
			 * System.out.printf("第%d次排序:\n",i+1); for (int j = 0; j < arr.length; j++) {
			 * System.out.printf(arr[j]+" "); } System.out.println();
			 */
			if (!flagBoolean) {
				break;
			} else {
				flagBoolean = false;
			}
		}
	}

	// 选择排序
	public static void SelectSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
				if (i != min) {
					int temp = arr[min];
					arr[min] = arr[i];
					arr[i] = temp;
				}
			}
		}
	}

	//插入排序
	  public static void insertSort(int[] array) {
			int i,j,temp;
			for(i=1;i<array.length;i++) {
				temp=array[i];
				for(j=i-1;j>=0;j--) {
					if(temp>array[j]) {
						break;
					}else {
						array[j+1]=array[j];
					}
				}
				array[j+1]=temp;
			}
		}
	// 希尔交换法
	public static void shellSort(int[] arr) {
		int length = arr.length;
		for (int grp = length / 2; grp > 0; grp /= 2) {
			for (int i = grp; i < arr.length; i++) {
				for (int j = i - grp; j >= 0; j -= grp) {
					if (arr[j] > arr[j + grp]) {
						int temp = arr[j];
						arr[j] = arr[j + grp];
						arr[j + grp] = temp;
					}
				}
			}
		}
	}

	// 希尔移位法
	public static void shellSort2(int[] arr) {
		int length = arr.length;
		for (int grp = length / 2; grp > 0; grp /= 2) {
			for (int i = grp; i < arr.length; i++) {
				int j = i;
				int temp = arr[j];
				if (arr[j] < arr[j - grp]) {
					while (j - grp >= 0 && temp < arr[j - grp]) {
						arr[j] = arr[j - grp];
						j -= grp;
					}
					arr[j] = temp;
				}
			}
		}
	}
	//快速排序
	public static void quickSort(int[] arr,int left,int right) {
		int l=left;
		int r = right;
		int temp= 0;
		int pivot = arr[(left+right)/2];
		while (l<r) {
			while (arr[l]<pivot) {
				l+=1;
			}
			while (arr[r]>pivot) {
				r -= 1;
			}
			if (l>=r) {
				break;
			}
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			
			if (arr[l] == pivot) {
				r-=1;
			}
			
			if (arr[r] == pivot) {
				l+=1;
			}
		}
		if (l==r) {
			l+=1;
			r-=1;
		}
		if (left<r) {
			quickSort(arr, left, r);
		}
		if (right>l) {
			quickSort(arr, l, right);
		}
	}
	//归并算法
	public static void Merget(int[] arr,int left,int mid,int right ,int[] temp) {
		int i = left;//初始化i
		int j = mid+1;
		int t = 0;//temp的索引
		//先把左右两边的数据按规则COPY到temp 
		while(i<=mid&&j<=right) {
			if (arr[i]<=arr[j]) {
				temp[t]=arr[i];
				t+=1;i+=1;			
			}else {
				temp[t]=arr[j];
				t+=1;j+=1;
			}
		}
		while (i<=mid) {
			temp[t] = arr[i];
			t+=1;i+=1;
		}
		
		while (j<=right) {
			temp[t] = arr[j];
			t+=1;j+=1;
		}
		
		t=0;
		int templeft = left;
		while(templeft<=right) {
			arr[templeft]=temp[t];
			t+=1;
			templeft+=1;
		}
		
	}
	public static void MergetSort(int[] arr,int left,int right ,int[] temp) {
		if (left<right) {
			int mid = (left+right)/2;
			MergetSort(arr, left, mid, temp);
			MergetSort(arr, mid+1, right, temp);
			Merget(arr, left, mid, right, temp);
		}
	}
	
	//基数排序
	public static void radixSort(int[] arr) {
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]>max) {
				max= arr[i];
			}
		}
		
		int maxLength = (max+"").length();
		int[][] bucket = new int[10][arr.length];
		int[] bucketElementCounts = new int[10];
		for (int i = 0,n=1; i < maxLength; i++,n*=10) {
			for (int j = 0; j < arr.length; j++) {
				int digitOfElement = arr[j]/n%10;
				bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[j];
				bucketElementCounts[digitOfElement]++;
				
			}
			int index = 0;
			for (int k = 0; k < bucketElementCounts.length; k++) {
				if (bucketElementCounts[k]!=0) {
					for (int l = 0; l < bucketElementCounts[k]; l++) {
						arr[index++] = bucket[k][l];
					}
					bucketElementCounts[k]=0;
				}
			}
		}
	}
}
