package Strings;

import java.util.Arrays;

public class LeftMostRepeatingCharacter {
    public static void main(String[] args) {
        String str="grteeksforgeeks";
        System.out.println("Index of leftmost repeating character is : "+leftMostRepeating(str));
    }

    //Naive Soln : O(n^2)
    // static int leftMostRepeating(String str){
    //     for(int i=0;i<str.length();i++){
    //         for(int j=i+1;j<str.length();j++){
    //             if(str.charAt(i)==str.charAt(j)) 
    //                 return i;
    //         }
    //     }
    //     return -1;
    // }
    
    //Better Soln :O(n+CHAR) - O(n+CHAR)
    // static int leftMostRepeating(String str){
    //     int count[]=new int[256];
    //     for(int i=0;i<str.length();i++)
    //         count[str.charAt(i)]++; 

    //     for(int i=0;i<str.length();i++){
    //         if(count[str.charAt(i)]>0) 
    //             return i;
    //     }
    //     return -1;
    // }
    
    //Efficent Soln :O(n+CHAR) - O(1)
    // static int leftMostRepeating(String str){
    //     int[] findex=new int[256];
    //     Arrays.fill(findex,-1);
    //     int res=Integer.MAX_VALUE;
    //     for(int i=0;i<str.length();i++){
    //         int fi=findex[str.charAt(i)];
    //         if(fi==-1) 
    //             findex[str.charAt(i)]=i;
    //         else 
    //             res=Math.min(res,fi);
    //     }

    //     return (res==Integer.MAX_VALUE)?-1:res;
    // }
    

    //Efficient Soln :O(n+CHAR) - O(1)
    static int leftMostRepeating(String str){
        boolean[] visited=new boolean[256];
        int res=-1;
        for(int i=0;i<str.length();i++){
            if(visited[str.charAt(i)]){
                res=i;
                break;
            }
            else 
                visited[str.charAt(i)]=true;
        }
        return res;
    }
}
