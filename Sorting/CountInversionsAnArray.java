public class CountInversionsAnArray{
    public static void main(String[] args) {
        int[] arr=new int[]{2,4,1,3,5};
        System.out.println("No of inversions in the Array is : "+countInversions(arr, arr.length));
    }
    

    //Naive Soln : O(n^2)
    // static int countInversions(int[] arr,int n){
    //     int count=0;
    //     for(int i=0;i<n;i++){
    //         for(int j=i+1;j<n;j++){
    //             if(arr[i]>arr[j])
    //                 count++;
    //         }
    //     }
    //     return count;
    // }
    
    //Efficient Soln :O(nlogn)
    static int countInversions(int[] arr,int n){
        return countInv(arr, 0, n-1);
    }
   
    static int countInv(int[] arr,int l,int r){
        int res=0;
        if(r>l){
            int mid=l+(r-l)/2;
            countInv(arr, l, mid);
            countInv(arr, mid+1, r);
            res+=countAndMerge(arr,l,mid,r);
        }
        return res;
    }

    static int countAndMerge(int[] arr,int l,int m,int r){
        int n1=m-l+1,n2=r-m;
        int[] left=new int[n1];
        int[] right=new int[n2];
        int res=0;

        for(int i=0;i<n1;i++) left[i]=arr[l+i];
        for(int i=0;i<n2;i++) right[i]=arr[m+i+1];

        int i=0,j=0,k=0;

        while(i<n1 && j<n2){
            if(left[i]<right[j]){
                arr[k++]=left[i];
                i++;
            }else{
                arr[k++]=right[j];
                res=res+(n2-i);
                j++;
            }
        }

        while(i<n1){
            arr[k++]=left[i];
            i++;
        }

        while(j<n2){
            arr[k++]=right[j];
            j++;
        }

        return res;
    }

}
