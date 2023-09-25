import java.util.HashSet;

public class SubarrayNoOfSum {
    public static void main(String[] args) {
        int[] arr=new int[]{10,2,-2,-20,10};
        int sum=-10;
        System.out.println("No of subarray with the sum -10 is "+getNoOfSubArraySum(arr, sum));
    }


    //Efficient Soln : O(n)
    static int getNoOfSubArraySum(int[] arr,int sum){
        int n=arr.length;
        int count=0;
        HashSet<Integer> h=new HashSet<>();
        int pre_sum=0;
        for(int i=0;i<n;i++){
            pre_sum+=arr[i];
            if(pre_sum==sum) 
                count++;
            if(h.contains(pre_sum)) 
                count++;
            h.add(pre_sum);
        }
        return count;
    }
    
}
