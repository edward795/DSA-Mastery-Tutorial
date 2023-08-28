package Arrays;

import java.util.*;

public class InsertUnsortedArray {
    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0]=1;
        arr[1]=2;
        arr[2]=3;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number:");
        int ele = sc.nextInt();
        System.out.println("Enter the index at which to insert:");
        int pos=sc.nextInt();
        arr=insert(arr,ele,pos);
        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]);
    }
    //TC : O(n)
    public static int[] insert(int[] arr, int x,int pos) {
        if(pos==arr.length) return arr;
        int idx=pos-1;
        for(int i=idx;i<arr.length-1;i++){
            arr[i+1]=arr[i];
        }
        arr[idx]=x;
        return arr;
    }
    
}
