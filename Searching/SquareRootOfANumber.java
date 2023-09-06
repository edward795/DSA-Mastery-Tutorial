package Searching;

public class SquareRootOfANumber {
    public static void main(String[] args) {
        int n=100;
        System.out.println("Square Root Of the number:"+squareRoot(n));
    }
    
    //TC : O(n)
    // static int squareRoot(int n){
    //     int i=1;
    //     while(i*i<n){
    //         i++;
    //     }
    //     return i-1;
    // }
    

    //TC : O(logn)
    static int squareRoot(int n){
        int low=1,high=n-1,ans=-1;
        while(low<high){
            int mid=(low+high)/2;
            int mSq=mid*mid;
            if(mSq==n)
                return mid;
            else if(mSq>n)
                high=mid-1;
            else 
                low=mid+1;
                ans=mid;
        }
        return ans;
    }
}
