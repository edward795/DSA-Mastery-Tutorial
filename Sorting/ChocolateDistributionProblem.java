import java.util.Arrays;

public class ChocolateDistributionProblem {
    public static void main(String[] args) {
        int[] arr=new int[]{7,3,2,4,9,12,56};
        int k=3; //k packets of chocolates

        System.out.println("Minimum difference of chocolate packets distributed:"+minDiff(arr, k));
    }

    //TC: O(nlogn)
    static int minDiff(int[] arr,int k){
        int n=arr.length;
        if(k>n) return -1;

        Arrays.sort(arr);

        int res=arr[k-1]-arr[0];
        for(int i=1;(i+k-1)<n;i++){
            res=Math.min(res,arr[i+k-1]-arr[i]);
        }
        return res;
    }
}
