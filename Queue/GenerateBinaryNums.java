package Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class GenerateBinaryNums {
    public static void main(String[] args) {
        int n=5;
        generateBinary(n);
    }

    // static String decTBinary(int n){
    //     String res="";
    //     while(n!=0){
    //         int rem=n%2;
    //         res=rem+res;
    //         n=n/2;
    //     }
    //     return res;
    // }

    //Naive Soln : O(n^2) - O(1)
    // static void generateBinary(int n){
    //     for(int i=0;i<=n;i++){
    //         System.out.print(decTBinary(i)+" ");
    //     }
    // }

    //Efficient Soln : O(nlogn) - O(n)
    // static void generateBinary(int n){
    //     Queue<String> q=new ArrayDeque<>();
    //      q.offer("1");
    //     for(int i=0;i<n;i++){
    //         String res=q.poll();
    //         System.out.print(res+" ");

    //         q.add(res+"0");
    //         q.add(res+"1");
    //     }
    // }

    //TC : O(n)
    static void generateBinary(int n){
        for(int i=1;i<=n;i++){
            System.out.print(Integer.toBinaryString(i)+" ");
        }
    }
}
