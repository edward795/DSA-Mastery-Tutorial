package Strings;

import java.util.Arrays;

public class LeftMostNonRepeatingCharacter {
    public static void main(String[] args) {
        String str="geeksforgeeks";
        System.out.println("The 1st non-repeating character is at index : "+nonRepeating(str));
    }

    //Naive Soln :O(n^2)
    // static int nonRepeating(String str){
    //     for(int i=0;i<str.length();i++){
    //         boolean flag=false;
    //         for(int j=0;j<str.length();j++){
    //             if(i!=j && str.charAt(i)==str.charAt(j)){
    //                 flag=true;
    //                 break;
    //             }
    //         }
    //         if(flag==false) return i;
    //     }
    //     return -1;
    // }

    //Efficient Soln : O(n+CHAR) - O(1)
    // static int nonRepeating(String str){
    //     int[] count=new int[256];

    //     for(int i=0;i<str.length();i++){
    //         count[str.charAt(i)]++;
    //     }

    //     for(int i=0;i<str.length();i++){
    //         if(count[str.charAt(i)]==1) 
    //             return i;
    //     }
    //     return -1;
    // }

    //TC : O(n+CHAR) - O(1)
    static int nonRepeating(String str){
        int[] fIndex=new int[256];
        Arrays.fill(fIndex,-1);

        for(int i=0;i<str.length();i++){
            if(fIndex[str.charAt(i)]==-1)
                fIndex[str.charAt(i)]=i;
            else 
                fIndex[str.charAt(i)]=-2;
        }

        int res=Integer.MAX_VALUE;

        for(int i=0;i<256;i++){
            if(fIndex[i]>=0)
                res=Math.min(res,fIndex[i]);
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}
