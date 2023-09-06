package TwoPointerApproach;

public class FindPairWithSum {
    public static void main(String[] args) {
        int[] arr=new int[]{2,5,8,12,30};
        int x=17;
        System.out.println("Pair with sum "+x+" exists or not?"+isPair(arr,arr.length,x));
    }
     
    //TC : O(n^2)
    // boolean isPair(int[] arr,int n,int x){
    //     for(int i=0;i<n;i++){
    //         for(int j=i+1;j<n;j++){
    //             if(arr[i]+arr[j]==x) 
    //                 return true;
    //         }
    //     }
    //     return false;
    // }
    //Efficient Soln : O(n)
    static boolean isPair(int[] arr,int n,int x){
       int i=0,j=n-1;
       while(i<=j){
        if(arr[i]+arr[j]==x) 
            return true;
        else if(arr[i]+arr[j]>x) 
            j--;
        else 
            i++;
       }
       return false;
    }
}
