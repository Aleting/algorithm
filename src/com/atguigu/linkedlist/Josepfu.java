package com.atguigu.linkedlist;

public class Josepfu {
	public static void main(String[] args) {
		//测试
		CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
		circleSingleLinkedList.addBoy(5);
		circleSingleLinkedList.showBoy();

		//测试小孩出圈
		circleSingleLinkedList.countBoy(1, 2, 5);
	}
}
//创建一个环形单向链表
class CircleSingleLinkedList{
	//创建的第一个节点，但是没有编号，意思是没有小孩
	private Boy first = new Boy(-1);
	public void addBoy(int nums) {
		//nums  做一个数据校验
		if (nums < 1) {
			System.out.println("nums的值不正确");
			return;
		}
		Boy curBoy = null;
		for (int i = 1; i <= nums; i++) {
			//根据编号，创建小孩节点
			Boy boy = new Boy(i);
			if (i == 1) {
				first = boy;
				first.setNext(first);
				curBoy = first;
			}else {
				curBoy.setNext(boy);
				boy.setNext(first);
				curBoy = boy;
			}
		}
		return;
	}

	//遍历当前环形列表
	public void showBoy() {
		if(first == null) {
			System.out.println("没有数据！");
			return;
		}
		Boy curBoy = first;
		while (true) {
			System.out.printf("小孩编号%d\n",curBoy.getNo());
			if (curBoy.getNext() == first) {
				break;
			}
			curBoy = curBoy.getNext();
		}
	}

	//根据用户输入，计算出小孩出圈的顺序
	public void countBoy(int startNo, int countNum, int nums) {
		//先对数据进行校验
		if (first == null|| startNo<1 || startNo>nums) {
			System.out.println("参数有误，请重新 输入");
			return;
		}
		//创建辅助指针
		Boy helper = first;
		while (true) {
			if (helper.getNext() == first) {
				break;
			}
			helper = helper.getNext();
		}
		//小孩报数前，先让first和helper移动k-1次
		for (int i = 0; i < startNo-1; i++) {
			first = first.getNext();
			helper = helper.getNext();
		}
		while (true) {
			if (helper == first) {
				break;
			}
			for (int i = 0; i < countNum-1; i++) {
				first = first.getNext();
				helper = helper.getNext();
			}
			//first指向的就是要出的
			System.out.printf("小孩%d出\n",first.getNo());
			first = first.getNext();
			helper.setNext(first);
		}
		System.out.printf("最后留在题中的小孩编号%d\n",first.getNo());
	}
}


//先创建一个boy
class Boy{
	private int no;
	private Boy next;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Boy getNext() {
		return next;
	}
	public void setNext(Boy next) {
		this.next = next;
	}
	public Boy(int no) {
		super();
		this.no = no;
	}

}