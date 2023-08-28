package Arrays;

public class MoveAllZeroesToEnd {
    public static void main(String[] args) {
        int[] arr=new int[]{8,5,0,10,0,20};
        System.out.println("Array after swapping zeroes:");
        moveToEnd(arr);
        for(int i:arr)
            System.out.print(i+" ");
    }
    //Naive soln : O(n^2)
    // public static void moveToEnd(int[] arr){
    //     int n=arr.length;
    //     for(int i=0;i<n;i++){
    //        if(arr[i]==0){
    //         for(int j=i+1;j<n;j++){
    //             if(arr[j]!=0){
    //                 swap(arr,i,j);
    //             }
    //         }
    //        } 
    //     }
    // }

    public static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    
    //TC : O(n) - O(1)
    public static void moveToEnd(int[] arr){
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                swap(arr,count,i);
                count++;
            }
        }
    }
}
