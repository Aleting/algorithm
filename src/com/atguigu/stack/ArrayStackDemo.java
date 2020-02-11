package com.atguigu.stack;

import java.util.Scanner;

//链表模拟栈
public class ArrayStackDemo {
	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack(4);
		String keyString="";
		boolean loop = true;
		Scanner scanner = new Scanner(System.in);
		while(loop) {
			System.out.println("show:显示栈");
			System.out.println("exit:退出程序");
			System.out.println("push:表示添加数据到栈");
			System.out.println("pop:表示出栈");
			System.out.println("请输入你的选择");
			keyString=scanner.next();
			switch (keyString) {
				case "show":
					stack.list();
					break;
				case "push":
					System.out.println("请输入一个数");
					int value = scanner.nextInt();
					stack.push(value);
					break;
				case "pop":
					try {
						int res = stack.pop();
						System.out.printf("出栈的数据%d\n",res);
						break;
					} catch (Exception e) {
						e.printStackTrace();
					}

				case "exit":
					loop=false;
					break;
				default:
					break;
			}
		}
		System.out.print("程序推出了");
	}
}
class ArrayStack{
	private int maxSize;
	private int[] stack;
	private int top = -1;
	//构造器
	public ArrayStack(int maxSize) {
		super();
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
	}
	//栈满
	public boolean isFull() {
		return top==maxSize-1;
	}
	//栈空
	public boolean isEmpty() {
		return top == -1;
	}
	//入栈
	public void push(int value) {
		//先判断栈是否满
		if (isFull()) {
			System.out.println("栈满");
			return;
		}
		top++;
		stack[top]=value;
	}
	//出栈
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("栈空");
		}
		return stack[top--];
	}
	//显示栈的情况
	public void list() {
		if (isEmpty()) {
			System.out.println("栈空");
			return;
		}
		for (int i = top; i>=0; i--) {
			System.out.println("输出："+stack[i]);
		}
	}

}
