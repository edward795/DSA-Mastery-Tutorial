package Dynamic_Programming;

public class MinDeletionsToSortArray {
    public static void main(String[] args) {
        int[] arr=new int[]{5,10,3,6,7,8};
        int n=arr.length-1;
        System.out.println("Minimum deltions to make array sorted : "+(n-Lis(arr, n)));
    }

    //TC : O(n*n)
    // static int Lis(int[] arr,int n){
    //     int[] lis=new int[n];
    //     lis[0]=1;

    //     for(int i=1;i<n;i++){
    //         lis[i]=1;
    //         for(int j=0;j<i;j++){
    //             if(arr[j]<arr[i]){
    //                 lis[i]=Math.max(lis[i],lis[j]+1);
    //             }
    //         }
    //     }

    //     int res=lis[0];
    //     for(int i=0;i<n;i++){
    //         res=Math.max(res,lis[i]);
    //     }
    //     return res;
    // }


    //TC : O(nlogn)
    static int Lis(int[] arr,int n){
        int[] tail=new int[n];
        tail[0]=arr[0];
        int len=1;
        
        for(int i=1;i<n;i++){
            if(arr[i]>tail[len-1]){
                tail[len]=arr[i];
                len++;
            }else{
                int c=ceilIndex(tail,0,len-1,arr[i]);
                tail[c]=arr[i];
            }
        }
        return len;
    }

    static int ceilIndex(int[] tail,int low,int high,int ele){
        while(low<high){
            int mid=low+(high-low)/2;
            if(tail[mid]<ele) 
                low=mid+1;
            else 
                high=mid;
        }
        return high;
    }
}
