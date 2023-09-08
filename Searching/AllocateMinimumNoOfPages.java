public class AllocateMinimumNoOfPages {
    public static void main(String[] args) {
        int[] arr=new int[]{10,20,30,40};
        int k=2,n=arr.length;
        System.out.println("The minimum no of pages:"+minimumPages(arr, n, k));
    }
    

    //Naive Soln : O(n) - O(n) stack space for recursive call
    // static int minimumPages(int[] arr,int n,int k){
    //     if(k==1) return sum(arr,0,n-1);
    //     if(n==1) return arr[0];

    //     int res=Integer.MAX_VALUE;
    //     for(int i=1;i<n;i++){
    //         res=Math.min(res,Math.max(minimumPages(arr, i, k-1),sum(arr,i,n-1)));
    //     }
    //     return res;
    // }

    // static int sum(int[] arr,int start,int end){
    //     int sum=0;
    //     for(int i=start;i<=end;i++){
    //         sum+=arr[i];
    //     }
    //     return sum;
    // }
    
    //Efficient Soln : O(logn) - O(n)
    static int minimumPages(int[] arr,int n,int k){
        int sum=0,mx=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            mx=Math.max(mx,arr[i]);
        }


        int low=mx,high=sum,res=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(isFeasible(arr,n,k,mid)){
                res=mid;
                high=mid-1;
            }else
                low=mid+1;
        }
        return res;
    }

    static boolean isFeasible(int[] arr,int n,int k,int ans){
        int req=1,sum=0;
        for(int i=0;i<n;i++){
            if(sum+arr[i]>ans){
                req++;
                sum=arr[i];
            }else
                sum+=arr[i];
        }
        return (req<=k);
    }

}
