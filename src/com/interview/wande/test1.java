package com.interview.wande;


public class test1 {

    public void findTwoNumEqualS(int[] arr,int s){
        if(arr==null || arr.length<2) {
            return;
        }
        int firstIndex=0;
        int lastIndex=arr.length-1;
        int D=0;
        int flag = 0;

        while(true){
            D = arr[lastIndex]-arr[firstIndex];
            if(D == s){
                flag = 1;
                System.out.println("["+arr[firstIndex]+","+arr[lastIndex]+"]");
                firstIndex = 0;
            }
            if (D > s){
                firstIndex ++;
            }else {
                lastIndex --;
            }
            if (firstIndex == lastIndex){
                firstIndex = 0;
                lastIndex -- ;
            }
            if (lastIndex < 0){
                break;
            }
        }
        if (flag == 0){
            System.out.println("[-1,-1]");
        }
    }

    public static void main(String[] args) {
        test1 f=new test1();
        int[] array = new int[]{5,7,9,10,13};
        f.findTwoNumEqualS(array, 7);
    }
}
