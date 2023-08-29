package Arrays;

public class MaxLengthEvenOddSubArray {
    public static void main(String[] args) {
        int[] arr=new int[]{10,12,14,7,8};
        System.out.println("Max length of even odd sub array:"+getMaxLenEvenOddSubArray(arr));
    }
    
    //Naive soln : O(n^2)
    // static int getMaxLenEvenOddSubArray(int[] arr){
    //     int n=arr.length;
    //     int res=1;
    //     for(int i=0;i<n;i++){
    //         int curr=1;
    //         for(int j=i+1;j<n;j++){
    //             if((arr[i]%2==0 && arr[j]%2!=0) || (arr[i%2]!=0 && arr[j%2]==0))
    //                 curr++;
    //             else break;
    //         }
    //         res=Math.max(res,curr);
    //     }
    //     return res;
    // }
    
    //Efficient soln : O(n)
    static int getMaxLenEvenOddSubArray(int[] arr){
        int res=Integer.MIN_VALUE;
        int curr=1;
        int n=arr.length;
        for(int i=1;i<n;i++){
            if((arr[i-1]%2==0 && arr[i]%2!=0)||(arr[i-1]%2!=0 && arr[i]%2==0)){ 
                curr++;
                res=Math.max(res,curr);
            }
            else
                curr=1;
        }
        return res;
    }
}
