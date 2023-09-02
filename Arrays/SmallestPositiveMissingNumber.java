package Arrays;
public class SmallestPositiveMissingNumber {
    public static void main(String[] args) {
        int[] arr=new int[]{2, 3, 7, 6, 8, -1, -10, 15};
        System.out.println("The minimum +ve value in arr:"+getSmallestPositive(arr));
    }
    
    //Naive Soln : O(n^2)
    // static int getSmallestPositive(int[] arr){
    //     int n=arr.length;
    //     int maxPositive=Integer.MIN_VALUE;
    //     for(int i=0;i<n;i++)
    //         maxPositive=Math.max(arr[i],maxPositive);
        
    //     for(int i=1;i<maxPositive+1;i++){
    //         boolean flag=false;
    //         for(int j=0;j<n;j++){
    //             if(arr[j]==i)
    //                 flag=true;
    //         }
    //         if(flag==false) return i;
    //     }
    //     return -1;
    // }

    //Efficent Soln - O(n) - O(n)
    // static int getSmallestPositive(int[] arr){
    //     int n=arr.length;
    //     int N=100000;
    //     int maxEle=Integer.MIN_VALUE;
    //     boolean[] isPresent=new boolean[N];
    //     for(int i=0;i<n;i++){
    //         if(arr[i]>0){
    //             isPresent[arr[i]]=true;
    //         }
    //         maxEle=Math.max(maxEle,arr[i]);
    //     }

    //     for(int i=0;i<N;i++)
    //         if(!isPresent[i]) return i+1;
    //     return maxEle+1;
    // }
     
    //Efficient Soln :O(n) - O(1)
    // static int getSmallestPositive(int[] arr){
    //     int n=arr.length;
    //     int k=segregate(arr, n);
    //     for(int i=k;i<n;i++){
    //         if(Math.abs(arr[i])-1<n && arr[Math.abs(arr[i])-1]>0)
    //             arr[Math.abs(arr[i])-1]=-arr[Math.abs(arr[i])-1];
    //     }

    //     for(int i=0;i<n;i++)
    //         if(arr[i]>0)
    //             return i+1;
    //     return n+1;
    // }

    // static int segregate(int[] arr,int n){
    //     int k=0;
    //     for(int i=0;i<n;i++){
    //         if(arr[i]<0){
    //             swap(arr,k,i);
    //             k++;
    //         }
    //     }
    //     return k;
    // }

    // static void swap(int[] arr,int a,int b){
    //     int temp=arr[a];
    //     arr[a]=arr[b];
    //     arr[b]=temp;
    // }
    
    //Efficient Soln : O(n) -O(1)
    // static int getSmallestPositive(int[] arr){
    //     int n=arr.length;
    //     int ptr=0;

    //     for(int i=0;i<n;i++){
    //         if(arr[i]==1){
    //             ptr=1;
    //             break;
    //         }
    //     }

    //     if(ptr==0) return 1;

    //     for(int i=0;i<n;i++){
    //         if(arr[i]<=0 || arr[i]>n)
    //             arr[i]=1;
    //     }

    //     for(int i=0;i<n;i++){
    //         arr[(arr[i]-1)%n]+=n;
    //     }
    //     for(int i=0;i<n;i++){
    //         if(arr[i]<n) return i+1;
    //     }

    //     return n+1;
    // }
    
    //Efficient Sol - O(n) - O(1)
    // static int getSmallestPositive(int[] arr){
    //     int n=arr.length;
    //     for(int i=0;i<n;i++){
    //         while(arr[i]>=1 && arr[i]<=n && arr[arr[i]-1]!=arr[i]){
    //             int temp=arr[arr[i]-1];
    //             arr[arr[i]-1]=arr[i];
    //             arr[i]=temp;
    //         }
    //     }

    //     for(int i=0;i<n;i++)
    //         if(arr[i]!=i+1) 
    //             return i+1;

    //     return n+1;
    // }

    //Efficient Soln : sorting :O(nlogn) - O(1)
    static int getSmallestPositive(int[] arr){
        int n=arr.length;
        Arrays.sort(arr);
        int ans=1;
        for(int i=0;i<n;i++){
            if(ans==arr[i]) 
                ans++;
        }

        return ans;
    }
}
