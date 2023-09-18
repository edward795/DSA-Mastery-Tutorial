public class CloserToSort {
    public static void main(String[] args) {
        int[] arr=new int[]{3,2,10,4,4,0};
        int ele=2;

        System.out.println("Index of the ele "+ele+" in the array is:"+CloserToSort(arr, arr.length, ele));
    }

    static int CloserToSort(int[] arr,int n,int x){
        int low=0,high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==x) 
                return mid;
            else if(mid>low && arr[mid-1]==x)
                return mid-1;
            else if(mid<high && arr[mid+1]==x) 
                return mid+1;
            else if(arr[mid]>x)
                high=mid-1;
            else 
                low=mid+1;
        }
        return -1;
    }
}
