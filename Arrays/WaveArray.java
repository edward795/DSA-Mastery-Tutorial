package Arrays;

import java.util.Arrays;

public class WaveArray {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5};
        getWaveArray(arr);
        System.out.println("Wave Array from source array is:");
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }
    //TC : O(n) if array is sorted else O(nlogn)
    public static void getWaveArray(int[] arr){
        //Arrays.sort(arr);
        int n=arr.length;
        for(int i=0;i+2<n;i+=2){
            int temp=arr[i];
            arr[i]=arr[i+1];
            arr[i+1]=temp;
        }
    }
}
