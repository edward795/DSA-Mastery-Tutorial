package TwoPointerApproach;

public class FindTripletsInSortedArray {
    public static void main(String[] args) {
        int[] arr=new int[]{2,5,8,12,30};
        int x=15;
        System.out.println("Does Triplet with sum "+x+" exists : "+isTriplet(arr, arr.length, x));
    }
    
    //Naive Soln : O(n^3)
    // static boolean isTriplet(int[] arr,int n,int x){
    //     for(int i=0;i<n-2;i++){
    //         for(int j=i+1;j<n-1;j++){
    //             for(int k=j+1;k<n;k++){
    //                 if(arr[i]+arr[j]+arr[k]==x) 
    //                     return true;
    //             }
    //         }
    //     }
    //     return false;
    // }

    //Efficient Soln : O(n^2)
    static boolean isTriplet(int[] arr,int n,int x){
        for(int i=0;i<n-2;i++){
            if(isPair(arr,arr.length,x-arr[i],i+1))
                return true;
        }
        return false;
    }

    static boolean isPair(int[] arr,int n,int x,int si){
        int i=si,j=n-1;
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
