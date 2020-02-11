package com.atguigu.linkedlist;

public class DoubleLinkedListDemo {
	public static void main(String[] args) {
		HeroNode2 heroNode1 = new HeroNode2(1, "songjiang", "jishiwu");
		HeroNode2 heroNode2 = new HeroNode2(2, "songjiang2", "jishiwu2");
		HeroNode2 heroNode3 = new HeroNode2(3, "songjiang3", "jishiwu3");
		HeroNode2 heroNode4 = new HeroNode2(4, "songjiang3", "jishiwu3");

		DoubleLinkedList name = new DoubleLinkedList();
		/*
		 * name.add(heroNode1); name.add(heroNode2); name.add(heroNode3);
		 */
		name.add(heroNode1);
		name.add(heroNode3);
		name.add(heroNode2);
		name.add(heroNode4);
		name.list();
	}
}
class DoubleLinkedList{
	private HeroNode2 head = new HeroNode2(0, "", "");
	//找到最后节点，将信息添加到最后节点
	public HeroNode2 getHead() {
		return head;
	}
	//显示链表
	public void list() {
		if (head.next == null) {
			System.out.println("链表为空！");
			return;
		}
		//因为head节点不能动，因此我们需要一个辅助遍历temp
		HeroNode2 temp = head.next;
		while (true) {
			System.out.println(temp);
			//找到链表最后一个元素
			if(temp.next == null) {
				break;
			}
			temp = temp.next;
		}
	}
	public void add(HeroNode2 heroNode) {
		//因为head节点不能动，因此我们需要一个辅助遍历temp
		HeroNode2 temp = head;
		while (true) {
			//找到链表最后一个元素
			if(temp.next == null) {
				break;
			}
			temp = temp.next;

		}
		temp.next = heroNode;
		heroNode.pre = temp;
	}
	//修改节点的信息 ，根据no修改，即no不能修改
	public void update(HeroNode2 newHeroNode) {
		if (head.next == null) {
			System.out.println("链表为空");
		}
		HeroNode2 temp = head.next;
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
		if (head.next == null) {
			System.out.println("链表为空，无法删除！");
			return;
		}
		HeroNode2 temp = head.next;
		boolean flag = false;
		while (true) {
			if (temp.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if(flag) {
			temp.next = temp.next.next;
			if (temp.next!=null) {
				temp.next.pre = temp.pre;
			}


		}else {
			System.out.println("节点不存在！");
		}
	}

}
//定义HeroNode，每个HeroNode 对象就是一个节点
class HeroNode2{
	public int no;
	public String name;
	public String nikename;
	public HeroNode2 next;
	public HeroNode2 pre;
	public HeroNode2(int no, String name, String nikename) {
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