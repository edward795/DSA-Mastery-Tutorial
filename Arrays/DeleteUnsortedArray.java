package Arrays;

import java.util.*;

public class DeleteUnsortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number:");
        int ele = sc.nextInt();
        delete(arr,ele);
        for(int i:arr)
            System.out.println(i);
    }
    //TC : O(n)
    public static void delete(int[] arr, int ele) {
        int idx=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==ele){
                idx=i;
                System.out.println("index found:"+idx);
                break;
            }
        }
        if(idx==arr.length) return;

        for(int j=idx+1;j<arr.length;j++)
            arr[j-1]=arr[j];

    }
    
}
