import java.util.Arrays;

public class TripletsWithZeroSum {
    public static void main(String[] args) {
        int[] arr=new int[]{0,-1,2,-3,1};
        System.out.println("The count of triplets are:"+tripletSum(arr));
    }
    //TC : O(n^3)
    // static int tripletSum(int[] arr){
    //     int n=arr.length;
    //     int count=0;
    //     for(int i=0;i<n-2;i++){
    //         for(int j=i+1;j<n-1;j++){
    //             for(int k=j+1;k<n;k++){
    //                 if(arr[i]+arr[j]+arr[k]==0){
    //                     count++;
    //                 }
    //             }
    //         }
    //     }
    //     return count;
    // }

    //TC : O(n^2)
    static int tripletSum(int[] arr){
        int n=arr.length;
        Arrays.sort(arr);
        int count=0;
        for(int i=0;i<n-2;i++){
            int l=i+1;
            int r=n-1;

            while(l<r){
                int curr_sum=arr[i]+arr[l]+arr[r];
                if(curr_sum==0)
                    count++;
                else if(curr_sum<0) 
                    l++;
                else 
                    r--;
            }
        }
        return count;
    }
    
}
