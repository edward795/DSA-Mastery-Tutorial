package Arrays;
/**
 * Count frequencies of all elements in array in O(1) extra space and O(n) time
 * Given an unsorted array of n integers that can contain integers from 1 to n. 
 * Some elements can be repeated multiple times and some other elements can be absent from the array.
 */

public class FrequenciesOfLimitedRangeArray {
    public static void main(String[] args) {
        int[] arr=new int[]{2,3,3,2,5};
        int n=arr.length;
        getFreq(arr, n);
    }
    
    //Naive Soln : O(n) - O(n)
    // static void getFreq(int[] arr,int n){
    //     int[] hash=new int[n];
    //     for(int i=0;i<n;i++)
    //         hash[arr[i]-1]++;

    //     System.out.println("The frequencies are:");
    //     for(int i=0;i<n;i++)
    //         System.out.println((i+1)+"->"+hash[i]);
    // }
    
    //Efficient Sloln: O(n) - O(1)
    // static void getFreq(int[] arr,int n){
    //     for(int i=0;i<n;i++){

    //         if(arr[i]<=0) continue;

    //         int eleIndex=arr[i]-1;

    //         if(arr[eleIndex]>0){
    //             arr[i]=arr[eleIndex];
    //             arr[eleIndex]=-1;
    //         }else{
    //             arr[eleIndex]--;
    //             arr[i]=0;
    //             continue;
    //         }
    //     }
    //     System.out.println("The frequencies are:");
    //     for(int i=0;i<n;i++)
    //         System.out.println((i+1)+"->"+Math.abs(arr[i]));   
    // }
    
    //Efficient Soln : O(n) - O(1)
    static void getFreq(int[] arr,int n){
        for(int i=0;i<n;i++)
            arr[i]=arr[i]-1;

        for(int i=0;i<n;i++)
            arr[arr[i]%n]=arr[arr[i]%n]+n;

        System.out.println("The freq of elements in an array:");
        for(int i=0;i<n;i++)
            System.out.println((i+1)+"->"+arr[i]/n);
    }

}
