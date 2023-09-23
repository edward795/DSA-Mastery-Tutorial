package Hashing;

import java.util.HashSet;

public class IntersectionOfTwoArrays{
    public static void main(String[] args) {
        int[] arr1=new int[]{10,15,20,15,30,30,5};
        int[] arr2=new int[]{30,5,30,80};

        System.out.println("The no of distinct common elements are:"+intersection(arr1, arr2, arr1.length, arr2.length));
    }

    //Time Complexity : O(n^2)
    // static int intersection(int[] arr1,int[] arr2,int m,int n){
    //     int res=0;
    //     for(int i=0;i<m;i++){
    //         boolean flag=false;
    //         for(int j=0;j<i-1;j++){
    //             if(arr1[i]==arr2[j])
    //                 flag=true;
    //                 continue;
    //         }

    //         for(int j=0;j<n;j++){
    //             if(arr1[i]==arr2[j]){
    //                 res++;
    //                 break;
    //             }
    //         }
    //     }
    //     return res;
    // }

    //O(n^2)
    // static int intersection(int[] arr1,int[] arr2,int m,int n){
    //     int res=0;
    //     for(int i=0;i<m;i++){
    //         if(i>0 && arr1[i]==arr1[i-1]) continue;
    //         for(int j=0;j<n;j++){
    //             if(j>0 && arr2[j]==arr2[j-1]) continue;

    //             if(arr1[i]==arr2[j]){
    //                 res++;
    //                 break;
    //             }
    //         }
    //     }
    //     return res;
    // }
    
    //Efficient Soln :O(n)
    static int intersection(int[] arr1,int[] arr2,int m,int n){
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<m;i++){
            set.add(arr1[i]);
        }

        int res=0;
        for(int i=0;i<n;i++){
            if(!set.add(arr2[i])) res++;
        }

        return res;
    }
}