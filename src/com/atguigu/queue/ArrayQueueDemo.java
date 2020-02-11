package com.atguigu.queue;

import java.awt.Font;
import java.util.Scanner;

import javax.management.RuntimeErrorException;



public class ArrayQueueDemo {
	public static void main(String[] args) {
		ArrayQueue arrayQueue = new ArrayQueue(3);
		char key = ' ';//接收键盘输入
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while(loop) {
			System.out.println("s(show):显示队列");
			System.out.println("e(exit):退出程序");
			System.out.println("a(add):添加数据到队列");
			System.out.println("g(get):从队列中取出数据");
			System.out.println("h(head):查看队列头的数据");
			key = scanner.next().charAt(0);
			switch (key) {
				case 's':
					arrayQueue.showQueue();
					break;
				case 'e':
					scanner.close();
					loop = false;
					System.out.println("程序退出！");
					break;
				case 'a':
					System.out.println("输入一个数：");
					int value = scanner.nextInt();
					arrayQueue.addQueue(value);
					break;
				case 'g':
					try {
						int res = arrayQueue.getQueue();
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println(e.getMessage());
					}
					break;
				case 'h':
					try {
						System.out.println("第一个元素："+arrayQueue.headQueue());
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				default:
					break;
			}
		}

	}
}

//使用数组模拟队列编写一个ArrayQueue类
class ArrayQueue{
	private int maxSize;//表示数组的最大容量
	private int front;//队列头
	private int rear;//队列尾
	private int[] arr;//该数据用于存放数据

	//创建队列的构造器
	public ArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = -1;//指向队列头部，分析出front是指向队列头部的前一个位置
		rear = -1;//指向队列尾部。指向队列尾的数据(即就是队列最后一个数据)
	}

	//判断队列是否为漫
	public boolean isFull() {
		return  rear == maxSize - 1;
	}

	//判断队列是否为空
	public boolean isEmpty() {
		return rear == front;
	}

	//添加数据到队列
	public void addQueue(int n) {
		if (isFull()) {
			System.out.println("队列已满，不能加入！");
			return;
		}
		arr[++rear] = n;
	}

	//出队列，取数据
	public int getQueue() {
		//判断队列是否空
		if (isEmpty()) {
			throw new RuntimeException("队列为空！");
		}
		return arr[++front];
	}

	//显示队列的所有数据
	public void showQueue() {
		//遍历数组
		if (isEmpty()) {
			System.out.println("队列为空，没有数据！");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%d\n",i,arr[i]);
		}
	}

	//显示队列的头数据
	public int headQueue() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空");
		}
		return arr[front + 1];
	}
}