package Searching;

import java.util.stream.Stream;

public class SearchInInfiniteSortedArray {
    public static void main(String[] args) {
        // Stream<Integer> str=Stream.iterate(0,i->i+3);
        // int x=30;
        // Integer[] arr=str.toArray(Integer[]::new);
        int[] arr=new int[]{1,10,15,20,40,80,90,100,120,500};
        int x=90;
        System.out.println("The position of ele : "+search(arr, x));
    }

    //TC : O(logn)
    // static int search(int[] arr,int x){
    //     int i=0;
    //     while(true){
    //         if(arr[i]==x)
    //             return i;
    //         else if(arr[i]>x)
    //             return -1;

    //         i++;
    //     }
    // }
    
    //TC : O(logn) -> as we are multiplying by 2
    static int search(int[] arr,int x){
        if(arr[0]==x) 
            return 0;
        int i=1;
        while(arr[i]<x)
            i=i*2;
            if(arr[i]==x)
                return i; 
        return binarySearch(arr, 0, arr.length-1, i);
    }
    
    //TC : O(logn)
    static int binarySearch(int[] arr,int x,int low,int high){
        if(low>high) return -1;
        int mid=(low+high)/2;

        if(arr[mid]==x)
            return mid;
        else if(arr[mid]>x)
            return binarySearch(arr, x, low, mid-1);
        else 
            return binarySearch(arr, x, mid+1, high);
    }


}
