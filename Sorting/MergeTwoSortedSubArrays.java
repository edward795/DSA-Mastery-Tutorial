public class MergeTwoSortedSubArrays {
    public static void main(String[] args) {
        int[] arr=new int[]{5,8,12,14,17};

        System.out.println("Array After sorting:");
        merge(arr, 0, arr.length-1, (arr.length-1)/2);
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }


    //TC : O(n)
    static void merge(int[] arr,int low,int high,int mid){
        int n1=mid-low+1,n2=high-mid;
        int[] left=new int[n1];
        int[] right=new int[n2];

        for(int i=0;i<n1;i++) left[i]=arr[low+i];
        for(int j=0;j<n2;j++) right[j]=arr[mid+j+1];

        int i=0,j=0,k=0;

        while(i<n1 && j<n2){
            if(left[i]<right[j]){
                arr[k++]=left[i];
                i++;
            }else{
                arr[k++]=right[j];
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
    }
}
