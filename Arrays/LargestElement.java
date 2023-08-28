package Arrays;

public class LargestElement {
    public static void main(String[] args) {
        int[] arr=new int[]{2,54,12,30,10,20,56};
        System.out.println("Largest Elment:"+arr[getLargest(arr)]);
        
    }
    
    //TC : O(n^2)
    // public static int getLargest(int[] arr){
    //     int n=arr.length;
    //     for(int i=0;i<n;i++){
    //         boolean flag=true;
    //         for(int j=0;j<n;j++){
    //             if(arr[j]>arr[i]){
    //                 flag=false;
    //                 break;
    //             }
    //         }
    //          if(flag==true)
    //                 return i;
    //     }
    //     return -1;
    // }

    static int getLargest(int[] arr){
        int res=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[res])
                res=i;
        }
        return res;
    }
}
