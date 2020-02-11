package com.atguigu.hashtab;

import java.util.Scanner;

public class HashTabDemo{
    public static void main(String[] args) {
        //创建哈希表
        HashTab hashTab = new HashTab(7);
        //写一个简单的菜单
        String key="";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add:添加雇员");
            System.out.println("list:显示雇员");
            System.out.println("exit:退出系统");
            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id=scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建雇员
                    Emp emp = new Emp(id,name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "exit":
                    scanner.close();
                    System.out.println("退出系统.....");
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }

    }
}
//创建hashtab表管理多条链表
class HashTab{
    private EmpLinkedList[] empLinkedListArray;
    private int size;//表示有多少条链表
    //构造器
    public HashTab(int size){
        //初始化empLinkedListArray
        empLinkedListArray = new EmpLinkedList[size];
    }
    //添加成员
    public void add(Emp emp){
        //根据员工的id，得到员工应该添加到那条链表
        int empLinkedNo =hashFun(emp.id);
        //将emp添加到对应的链表中
        empLinkedListArray[empLinkedNo].add(emp);
        //这是不要忘了初始化每个链表
        for (int i=0;i<size;i++){
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }
    //遍历所有的链表
    public void list(){
        for (int i=0;i<size;i++){
            empLinkedListArray[i].list();
        }
    }
    //编写一个散列
    public int hashFun(int id){
        return id % size;
    }
}


class Emp{
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

//创建EmpLinkedList，表示链表
class EmpLinkedList{
    //定义头指针
    private Emp head;
    //添加雇员到链表
    public void add(Emp emp){
        if (head==null){
            head=emp;
            return;
        }
        Emp curEmp  = head;
        while (true){
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }
    //遍历链表的信息
    public void list(){
        if (head==null){
            System.out.println("当前链表为空");
            return;
        }
        System.out.println("当前链表的信息为：");
        Emp curEmp = head;
        while (true){
            System.out.printf("=> id=%d name=%d\t",curEmp.id,curEmp.name);
            if (curEmp.next==null){
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }
}
