public class FindRepeatingElement {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,3,4};
        System.out.println("The repaeating element & count are:"+findRepeating(arr)[0]+","+findRepeating(arr)[1]);

    }
    
    //TC : O(logn)
    static int[] findRepeating(int[] arr){
        int n=arr.length;
        if((n-arr[n-1]-arr[0])==1) return new int[]{-1,-1};
        int low=0,high=n-1;

        while(low<high){
            int mid=(low+high)/2;
            if(arr[mid]>=mid+arr[0])
                low=mid+1;
            else 
                high=mid;
        }

        return new int[]{arr[low],n-(arr[n-1]-arr[0])};
    }
}
