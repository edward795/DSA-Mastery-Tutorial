package Arrays;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr=new int[]{0,1,1,0,1,0};
        System.out.println("Max Count Of consecutive ones:"+maxCount(arr));
    }
    
    //Naive Soln : TC : O(n^2)
    // public static int maxCount(int[] arr){
    //     int n=arr.length;
    //     int res=0;
    //     for(int i=0;i<n;i++){
    //         int count=0;
    //         for(int j=i;j<n;j++){
    //             if(arr[j]==1)
    //                 count++;
    //             else break;
    //         }
    //         res=Math.max(res,count);
    //     }
    //     return res;
    // } 
    

    //Efficien soln : O(n)
    public static int maxCount(int[] arr){
        int n=arr.length;
        int res=0,curr=0;
        for(int i=0;i<n;i++){
            if(arr[i]==1) curr++;
            else{
                res=Math.max(res,curr);
                curr=0;
            }
        }
        return res;
    }
}
