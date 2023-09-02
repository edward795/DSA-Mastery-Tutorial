package Arrays.WindowSlidingTechnique;

public class ReverseEverySubArrayOfSizeK {
    public static void main(String[] args) {
        int[] arr=new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int k=3;
        reverseSubArray(arr, k);
        System.out.println("After reversing all subarrays of size k:");
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }


    //Naive Soln : O(n^2) -It does not even handle boundary conditions ie : 
    //If k is not a multiple of n where n is the size of the array, for the last group we will have less than k elements left, we need to reverse all remaining elements. 
    //If k = 1, the array should remain unchanged. If k >= n, we reverse all elements present in the array.
    // static void reverseSubArray(int[] arr,int k){
    //     int n=arr.length;
    //     for(int i=0;i+k-1<n;i++){
    //         for(int j=0;j<k;j++){
    //             if(i+j<n-1){
    //                 reverse(arr,i,i+j);
    //             }else{
    //                 reverse(arr,i,n-1);
    //             }
    //         }
    //     }
    // }
   
    //Efficient Soln : O(n)
    static void reverseSubArray(int[] arr,int k){
        int n=arr.length;
        for(int i=0;i<n;i+=k){
            int l=i;
            int r=Math.min(i+k-1,n-1);
            reverse(arr, l, r);
        }
    }

    static void reverse(int[] arr,int l,int r){
        while(l<r){
            int temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            l++;
            r--;
        }
    }
}
