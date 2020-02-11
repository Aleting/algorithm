package com.atguigu.sparsearray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class SparseArrayFile {
	public static void main(String[] args) throws IOException {
		//创建一个原始的二维数组
		//0:表示没有棋子，1表示黑子2表示篮子
		int chessArr1[][] = new int[11][11];
		chessArr1[1][2] = 1;
		chessArr1[2][3] = 2;
		//输出原始的二维数组
		System.out.println("原始的二维数组:");
		for(int[] row : chessArr1) {
			for(int data : row) {
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}

		//将二维数组转化为稀疏数组
		//1.先遍历原始的二维数组得到非0的个数
		int sum = 0;
		for(int i = 0;i < 11;i ++) {
			for(int j = 0;j < 11;j ++) {
				if(chessArr1[i][j] != 0) {
					sum++;
				}
			}
		}
		//2.创建对应的稀疏数组
		int sparseArr[][] = new int[sum+1][3];
		sparseArr[0][0] = 11;
		sparseArr[0][1] = 11;
		sparseArr[0][2] = sum;
		//遍历二维数组，将非0值存入稀疏数组
		int count = 0;
		for(int i = 0;i < 11;i ++) {
			for(int j = 0;j < 11;j ++) {
				if(chessArr1[i][j] != 0) {
					count++;
					sparseArr[count][0] = i;
					sparseArr[count][1] = j;
					sparseArr[count][2] = chessArr1[i][j];
				}
			}
		}
		//将稀疏矩阵的数据写入文件并输出
		System.out.println("得到的稀疏数组是:");
		File file = new File("map.data");
		FileWriter out = new FileWriter(file);
		for (int i = 0; i < sparseArr.length; i++) {
			out.write(sparseArr[i][0]+"\t"+sparseArr[i][1]+"\t"+sparseArr[i][2]+"\t\n");
			System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
		}
		out.close();

		//读取文件中的稀疏数组并还原成二维矩阵
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		int flag = 0;
		line = in.readLine();
		String[] temp = line.split("\t");
		int chessArr2[][] = new int[Integer.parseInt(temp[0])][Integer.parseInt(temp[1])];
		while ((line = in.readLine())!=null) {
			String[] temp2 = line.split("\t");
			chessArr2[Integer.parseInt(temp2[0])][Integer.parseInt(temp2[1])] = Integer.parseInt(temp2[2]);
		}
		in.close();

		//输出数组
		System.out.println("恢复的原始数组是:");
		for(int[] row : chessArr2) {
			for(int data : row) {
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
	}
}
