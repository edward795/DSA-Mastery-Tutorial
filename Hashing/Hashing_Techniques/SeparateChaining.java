package Hashing_Techniques;
import java.util.ArrayList;
import java.util.LinkedList;

public class SeparateChaining{
    public static void main(String[] args) {
        int[] arr=new int[]{92,9,14,24,44,91};
        int n=arr.length,hashsize=10;
        System.out.println(separateChaining(arr, n, hashsize));
    }

    //TC : O(n)
    public static ArrayList<LinkedList<Integer>> separateChaining(int[] arr,int n,int hashsize){
        ArrayList<LinkedList<Integer>> h=new ArrayList<>();
        for(int i=0;i<hashsize;i++){
            h.add(new LinkedList<Integer>());
        }

        for(int i=0;i<n;i++){
            int key=i%hashsize;
            h.get(key).add(arr[i]);
        }

        return h;
    }
}