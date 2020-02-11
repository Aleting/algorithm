package com.atguigu.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		//进行测试
		//先创建节点
		HeroNode heroNode1 = new HeroNode(1, "songjiang", "jishiwu");
		HeroNode heroNode2 = new HeroNode(2, "songjiang2", "jishiwu2");
		HeroNode heroNode3 = new HeroNode(3, "songjiang3", "jishiwu3");
		HeroNode heroNode4 = new HeroNode(4, "songjiang3", "jishiwu3");


		SingleLinkedList name = new SingleLinkedList();
		/*
		 * name.add(heroNode1); name.add(heroNode2); name.add(heroNode3);
		 */
		name.addByOrder(heroNode1);
		name.addByOrder(heroNode3);
		name.addByOrder(heroNode2);
		name.addByOrder(heroNode4);
		name.list();

		//name.deleteNo(3);
		/*
		 * HeroNode heroNode5 = new HeroNode(4, "儿子", "jishiwu2");
		 * name.update(heroNode5);
		 */
		//name.list();
		/*
		 * reversalList(name.getHead()); name.list();
		 * System.out.println(getLength(name.getHead()));
		 */
	}
	//获取链表长度
	public static int getLength(HeroNode head) {
		if (head.next == null) {
			return 0;
		}
		int length = 0;
		HeroNode cur = head.next;
		while (cur!=null) {
			length++;
			cur = cur.next;
		}
		return length;
	}

	//新浪面试题:
	//求单链表从 后面数的k的位置
	public static HeroNode getK(HeroNode head,int index) {
		if(head.next == null) {
			return null;
		}
		HeroNode cur = head.next;
		int length = getLength(head);
		if (index <= 0||index > length ) {
			return null;
		}
		for (int i = 0; i < length - index ; i++) {
			cur = cur.next;
		}
		return cur;
	}

	//腾讯面试题：单链表的翻转
	public static void reversalList(HeroNode head) {
		if (head.next == null || head.next.next == null) {
			return;
		}
		HeroNode cur = head.next;
		HeroNode next = null;
		HeroNode reverseHead = new HeroNode(0, "", "");
		while (cur != null) {
			next = cur.next;
			cur.next = reverseHead.next;
			reverseHead.next = cur;
			cur = next;
		}
		head.next = reverseHead.next;
		return;
	}
	//百度面试题，逆序打印大连表
	public static void reversePrint(HeroNode head) {
		if (head.next == null) {
			return;
		}
		Stack<HeroNode> stack = new Stack<HeroNode>();
		HeroNode cur = head.next;
		while (cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		while (stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}

}

//定义 SingleLinkedList 管理我们的英雄
class SingleLinkedList{
	//先初始化一个头结点
	private HeroNode head = new HeroNode(0, "", "");
	//添加节点到单向链表
	//找到最后节点，将信息添加到最后节点
	public HeroNode getHead() {
		return head;
	}
	public void setHead(HeroNode head) {
		this.head = head;
	}

	public void add(HeroNode heroNode) {
		//因为head节点不能动，因此我们需要一个辅助遍历temp
		HeroNode temp = head;
		while (true) {
			//找到链表最后一个元素
			if(temp.next == null) {
				break;
			}
			temp = temp.next;

		}
		temp.next = heroNode;
	}

	//显示链表
	public void list() {
		if (head.next == null) {
			System.out.println("链表为空！");
			return;
		}
		//因为head节点不能动，因此我们需要一个辅助遍历temp
		HeroNode temp = head.next;
		while (true) {
			System.out.println(temp);
			//找到链表最后一个元素
			if(temp.next == null) {
				break;
			}

			temp = temp.next;
		}
	}

	//修改节点的信息 ，根据no修改，即no不能修改
	public void update(HeroNode newHeroNode) {
		if (head.next == null) {
			System.out.println("链表为空");
		}
		HeroNode temp = head.next;
		boolean flag = false;
		while (true) {
			if (temp == null) {
				break;
			}
			if (newHeroNode.no == temp.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.name = newHeroNode.name;
			temp.nikename = newHeroNode.nikename;
		}else {
			System.out.println("没有找到要修改的no");
		}

	}

	//删除节点
	public void deleteNo(int no) {
		HeroNode temp = head;
		boolean flag = false;
		while (temp.next!=null) {
			if (temp.next.no == no) {
				temp.next = temp.next.next;
			}
			temp = temp.next;
		}
	}

	//按照顺序添加
	public void addByOrder(HeroNode heroNode) {
		HeroNode temp = head;
		boolean flag = false;
		while (true) {
			if (temp.next == null) {
				break;
			}
			if (temp.next.no > heroNode.no) {
				break;
			}else if(temp.next.no == heroNode.no){
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			System.out.printf("准备插入的%d英雄已经存在！",heroNode.no);
			System.out.println();
		}else {
			heroNode.next = temp.next;
			temp.next = heroNode;
		}
	}

}

//定义HeroNode，每个HeroNode 对象就是一个节点
class HeroNode{
	public int no;
	public String name;
	public String nikename;
	public HeroNode next;
	public HeroNode(int no, String name, String nikename) {
		super();
		this.no = no;
		this.name = name;
		this.nikename = nikename;
	}
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nikename=" + nikename + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}




}