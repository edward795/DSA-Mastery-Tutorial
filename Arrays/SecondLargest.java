package Arrays;

public class SecondLargest {
    public static void main(String[] args) {
        int[] arr=new int[]{2,54,12,30,10,20,56};
        System.out.println("Second Largest Element:"+arr[getSecondLargest(arr)]);
    }
    
    //TC : O(n)
    // static int getLargest(int[] arr){
    //     int res=0;
    //     for(int i=1;i<arr.length;i++){
    //         if(arr[i]>arr[res])
    //             res=i;
    //     }
    //     return res;
    // }

    // static int getSecondLargest(int[] arr){
    //     int largest=getLargest(arr);
    //     int res=-1;
    //     for(int i=0;i<arr.length;i++){
    //         if(arr[i]!=arr[largest]){
    //             if(res==-1)
    //                 res=i;
    //             else if(arr[i]>arr[res])
    //                 res=i;
    //         }
    //     }
    //     return res;
    // }

    //Effificnet Soln : O(n)
    static int getSecondLargest(int[] arr){
        int res=-1,largest=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[largest]){
                res=largest;
                largest=i;
            }else if(arr[i]>arr[res] || res==-1){
                res=i;
            }
        }
        return res;
    }
}
