package Arrays.PrefixSum;

import java.util.HashMap;

/**
 * Program to find Largest subarray with equal number of 0s and 1s
 */
public class LongestSubArrayWith0sAnd1s {
    public static void main(String[] args) {
        int[] arr=new int[]{ 1, 0, 0, 1, 0, 1, 1 };
        getMaxSubArrayWithSum(arr);
    }

    //Naive Soln : O(n^2)
    // static void getMaxSubArrayWithSum(int[] arr){
    //     int n=arr.length;
    //     int sInd=0;
    //     int maxLen=0;
    //     for(int i=0;i<n;i++){
    //         int sum=(arr[0]==1)?1:-1;    
    //         for(int j=i+1;j<n;j++){
    //             sum=sum+(arr[j]==0?-1:arr[j]);
    //                 if(sum==0 && j-i+1>maxLen){
    //                     maxLen=j-i+1;
    //                     sInd=i;
    //                 } 
    //         }
    //     }
    //     System.out.println("Max length Sub Array equal no: of o's & 1's : arr["+sInd+".."+(sInd+maxLen-1)+"]");
    // }
    
    //Efficient Soln : Prefix Sum + Hashing : O(n)
    static void getMaxSubArrayWithSum(int[] arr){
        int n=arr.length;
        HashMap<Integer,Integer> hm=new HashMap<>();
        int sum=0;
        int max_len=0;
        int ending_index=0;

        for(int i=0;i<n;i++){
            arr[i]=(arr[i]==0)?-1:1;
        }

        for(int i=0;i<n;i++){
            sum+=arr[i];

            if(sum==0){
                max_len=i+1;
                ending_index=i;
            }

            if(hm.containsKey(sum)){
                if(max_len<i-hm.get(sum)){
                    max_len=i-hm.get(sum);
                    ending_index=i;
                }
            }else{
                hm.put(sum,i);
            }
        }

        int starting_index=ending_index-max_len+1;
        System.out.println("Max length Sub Array equal no: of o's & 1's : arr["+starting_index+".."+(ending_index)+"]");
    }
}
