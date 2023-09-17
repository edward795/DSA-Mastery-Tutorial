import utils.Print;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr=new int[]{4,2,2,8,3,3,1};
        System.out.println("Elements after sorting:");
        countingSort(arr);
        Print pr=new Print();
        pr.printArray(arr, arr.length);
    }
    //TC : O(n+k) for all cases - where k is the max element in the array & the size of count array
    static void countingSort(int[] arr){
        int n=arr.length;
        int[] output=new int[n+1];

        int max=arr[0];
        for(int i=0;i<n;i++)
            max=Math.max(max,arr[i]);

        int[] count=new int[max+1];
        for(int i=0;i<n;i++)
            count[arr[i]]++;

        for(int i=1;i<=max;i++)
            count[i]+=count[i-1];

        for(int i=n-1;i>=0;i--){
            output[count[arr[i]]-1]=arr[i];
            count[arr[i]]--;
        }

        for(int i=0;i<n;i++){
            arr[i]=output[i];
        }
    }
}
