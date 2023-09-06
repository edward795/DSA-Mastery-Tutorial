


/**
 * Note: Binary Search Works on a Sorted Array only
 * @param arr
 * @return
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5};
        int x=3;
        System.out.println("Element present at index : "+BinarySearch(arr, arr.length-1, x));
    }
    
    // TC : O(logn) - O(1)
    static int BinarySearch(int[] arr,int n,int x){
        int low=0,high=n-1;
        while(low<high){
            int mid=(low+high)/2;
            if(arr[mid]==x)
                return mid;
            else if(arr[mid]>x)
                high=mid-1;
            else 
                low=mid+1;
        }
        return -1;
    }
    
    //TC : O(n) - O(n)
    static int recursiveBSearch(int[] arr,int low,int high,int x){
        if(low>high) return -1;

        int mid=(low+high)/2;
        if(arr[mid]==x)
            return mid;
        else if(arr[mid]>x)
            return recursiveBSearch(arr, low, mid-1, x);
        else
            return recursiveBSearch(arr, mid+1, high, x);
    }
}
