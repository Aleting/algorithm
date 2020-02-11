package com.atguigu.search;

import java.util.ArrayList;
import java.util.List;

//二分查找
public class BinarySearch {
	public static void main(String[] args) {
		int arr[] = {1,2,6,9,40,56,78};
		int resIndex = binarySearch(arr, 0, arr.length, 1);
		List<Integer> resIndexList = binarySearch2(arr, 0, arr.length, 75);
	}
	
	public static int binarySearch(int[] arr,int left,int right,int findVal) {
		if (left > right) {
			return -1;
		}
		int mid = (left + right)/2;
		int midVal = arr[mid];
		if (findVal > midVal) {
			return binarySearch(arr, mid+1, right, findVal);
		}else if (findVal < midVal) {
			return binarySearch(arr, right, mid-1, findVal);
		}else {
			return mid;
		}
	}
	
	public static ArrayList<Integer> binarySearch2(int[] arr,int left,int right,int findVal) {
		if (left > right) {
			return new ArrayList<Integer>();
		}
		int mid = (left + right)/2;
		int midVal = arr[mid];
		if (findVal > midVal) {
			return binarySearch2(arr, mid+1, right, findVal);
		}else if (findVal < midVal) {
			return binarySearch2(arr, right, mid-1, findVal);
		}else {
			ArrayList<Integer> resIndexList = new ArrayList<Integer>();
			int temp = mid - 1;
			while (true) {
				if (temp < 0||arr[temp]!= findVal) {
					break;
				}
				resIndexList.add(temp);
				temp -= 1;
			}
			resIndexList.add(mid);
			
			temp = mid+1;
			while (true) {
				if (temp >arr.length -1||arr[temp]!= findVal) {
					break;
				}
				resIndexList.add(temp);
				temp += 1;
			}
			return resIndexList;
		}
	}
}
