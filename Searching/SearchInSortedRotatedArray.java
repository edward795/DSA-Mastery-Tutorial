public class SearchInSortedRotatedArray {
    public static void main(String[] args) {
        int[] arr=new int[]{10,20,30,40,50,8,9};
        System.out.println("Element found at index:"+search(arr, arr.length-1, 40));
    }
    
    //TC :O(n)
    // static int search(int[] arr,int n,int x){
    //     for(int i=0;i<n;i++)
    //         if(arr[i]==x) 
    //             return i;
    //     return -1;
    // }
    
    //TC : O(logn)
    static int search(int[] arr,int n,int x){
        int low=0,high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==x) 
                return mid;
            else if(arr[low]<=arr[mid]){
                if(x>=arr[low] && x<=arr[mid] )
                    high=mid-1;
                else 
                    low=mid+1;
            }else{
                if(x>=arr[mid] && x<=arr[high])
                    low=mid+1;
                else 
                    high=mid-1;
            }
        }
        return -1;
    }
}
