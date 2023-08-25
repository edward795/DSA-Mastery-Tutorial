package Recursion;

public class SubSetSumProblem {
    public static void main(String[] args) {
        int[]  arr=new int[]{10,5,2,3,6};
        int sum=8;
        System.out.println("Subsets with given sum:"+subsetSum(arr, sum,0));

    }
    //TC : O(2^n)
    // public static int subsetSum(int[] arr,int sum,int i){
    //     if(i==arr.length)
    //         return (sum==0)?1:0;
    //     return subsetSum(arr,sum,i+1)+subsetSum(arr, sum-arr[i],i+1);
    // }

    public static int subsetSum(int[] arr,int sum,int n){
        if(n==0) 
            return sum==0?1:0; 
        return subsetSum(arr, sum, n-1)+subsetSum(arr, sum-arr[n-1], n-1);
    }
}
