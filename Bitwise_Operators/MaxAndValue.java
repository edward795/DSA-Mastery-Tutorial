package Bitwise_Operators;

public class MaxAndValue {
    public static void main(String[] args) {
        int[] arr=new int[]{4,8,12,16};
        System.out.println("Maximum and value of the pair of array  elements is:"+maxAndValue(arr));
    }

    //Naive Soln : O(n^2)
//    public static int maxAndValue(int[] arr){
//        int res=Integer.MIN_VALUE,n=arr.length;
//        for(int i=0;i<n;i++){
//            for(int j=i+1;j<n;j++){
//                res=Math.max(res,arr[i]&arr[j]);
//            }
//        }
//        return res;
//    }

    //Efficient Soln : O(n) - O(1)
    public static int maxAndValue(int[] arr){
        int res=0,count=0;
        for(int i=31;i>=0;i--){
            count=checkBitPatternCount(res|(1<<i),arr,arr.length);
            if(count>=2)
                res=res|(1<<i);
        }
        return res;
    }

    public static int checkBitPatternCount(int pattern,int[] arr,int n){
        int count=0;
        for(int i=0;i<n;i++){
            if((pattern&arr[i])==pattern)
                count++;
        }
        return count;
    }
}
