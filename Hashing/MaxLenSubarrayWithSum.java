import java.util.HashMap;

public class MaxLenSubarrayWithSum {
    public static void main(String[] args) {
        int[] arr=new int[]{3,1,0,1,8,2,3,6};
        int sum=5;
        System.out.println("The max value length of subarray with given sum:"+maxLenSubarray(arr,sum));
    }
    
    //Naive soln :O(n^2)
    // static int maxLenSubarray(int[] arr,int sum){
    //     int n=arr.length;
    //     int res=Integer.MIN_VALUE;
    //     for(int i=0;i<n;i++){
    //         int curr_sum=0;
    //         for(int j=i;j<n;j++){
    //             curr_sum+=arr[j];
    //             if(curr_sum==sum){
    //                 res=Math.max(res,j-i+1);
    //             }
    //         }
    //     }
    //     return res;
    // }

    //Efficient Soln : O(n)
    static int maxLenSubarray(int[] arr,int sum){
        int n=arr.length;
        HashMap<Integer,Integer> h=new HashMap<>();
        int pre_sum=0,res=0;
        for(int i=0;i<n;i++){
            pre_sum+=arr[i];
            if(pre_sum==sum) res=i+1;
            if(h.containsKey(pre_sum)==false){
                h.put(pre_sum,i);
            }else if(h.containsKey(pre_sum)){
                res=Math.max(res,i-h.get(pre_sum));
            }
        }
        return res;
    }
}
