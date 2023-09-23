package Hashing;

import java.util.HashSet;

public class countUnionOfTwoArrays {
    public static void main(String[] args) {
        int[] arr1=new int[]{15,20,5,15};
        int[] arr2=new int[]{15,15,15,20,10};

        System.out.println("Count of union of 2 array elements:"+union(arr1, arr2, arr1.length-1, arr2.length-1));
    }

    //Navie Soln :O(n^2)
    // static int union(int[] arr1,int[] arr2,int m,int n){
    //     int res=0;
    //     int[] temp=new int[m+n];
    //     for(int i=0;i<m;i++)
    //         temp[i]=arr1[i];

    //     for(int i=0;i<n;i++) 
    //         temp[i+m]=arr2[i];

    //     for(int i=0;i<m+n;i++){
    //         boolean flag=false;
    //         for(int j=0;j<i;j++){
    //             if(temp[i]==temp[j]){
    //                 flag=true;
    //                 break;
    //             }
    //         }

    //         if(flag==false) res++;
    //     }
    //     return res;
    // }
    
    //Efficient Solution : O(n)
    static int union(int[] arr1,int[] arr2,int m,int n){
        HashSet<Integer> h=new HashSet<>();
        for(int i=0;i<m;i++)
            h.add(arr1[i]); 

        for(int j=0;j<n;j++) 
            h.add(arr2[j]);

        return h.size();

    }


}
