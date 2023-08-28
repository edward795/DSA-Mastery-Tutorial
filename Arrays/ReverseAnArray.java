package Arrays;

public class ReverseAnArray {
    public static void main(String[] args) {
        int[] arr=new int[]{8,12,15,78};
        System.out.println("Reversed Array:");
        getReverseArray(arr);
        for(int i:arr)
            System.out.print(i+" ");
    }
    
    //TC : O(n) - O(n)
    // public static int[] getReverseArray(int[] arr){
    //     int n=arr.length;
    //     int[] temp=new int[n];
    //     for(int i=0;i<n;i++)
    //         temp[i]=arr[n-i-1];
    //     return temp;
    // }

    //TCS : O(n) - O(n)
    // public static int[] getReverseArray(int[] arr){
    //     int n=arr.length;
    //     int[] temp=new int[n];
    //     int k=0;
    //     for(int i=n-1;i>=0;i--){
    //         temp[k++]=arr[i];
    //     }

    //     return temp;
    // }


    //2 pointer approach - O(n) - O(1)
    public static void getReverseArray(int[] arr){
        int low=0,high=arr.length-1;
        while(low<high){
            int temp=arr[low];
            arr[low]=arr[high];
            arr[high]=temp;
            low++;
            high--;
        }
    }
}
