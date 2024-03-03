package Dynamic_Programming;

public class MaxSumOfLisArray {
    public static void main(String[] args) {
        int[] arr=new int[]{3,20,4,6,7,30};
        int n=arr.length-1;
        System.out.println("The max sum of LIS is "+maxSumOFLis(arr, n));
    }

    //TC : O(n*n)
    static int maxSumOFLis(int[] arr,int n){
        int[] lis=new int[n];
        lis[0]=arr[0];

        for(int i=0;i<n;i++){
            // lis[i]=arr[i];
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i])
                    lis[i]=Math.max(lis[i],arr[i]+lis[j]);
            }
        }
        int res=lis[0];
        for(int i=1;i<n;i++) 
            res=Math.max(res,lis[i]);
        return res;
    }   
}
