package Arrays;

public class LeftRotateArraydtimes {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5};
        System.out.println("Array after left rotating d times:");
        //d is the no of times you want to left rotate
        int d=3;
        leftRotateByd(arr,d);
        // while(d-->0)
        //     leftRotate(arr);
        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]+" ");
    }
    //Naive soln: O(n*d) -> as this function is getting called d times
    // public static void leftRotate(int[] arr){
    //     int temp=arr[0];
    //     int n=arr.length;
    //     for(int i=1;i<n;i++)
    //         arr[i-1]=arr[i];
    //     arr[n-1]=temp;
    // }

    //Better Soln - O(n) - O(d)
    // public static void leftRotateByd(int[] arr,int d){
    //     int n=arr.length;
    //     int[] temp=new int[d];

    //     for(int i=0;i<d;i++)
    //         temp[i]=arr[i];

    //     for(int i=d;i<n;i++)
    //         arr[i-d]=arr[i];

    //     for(int i=0;i<d;i++)
    //         arr[n+i-d]=temp[i];
    // }

    //Best Soln : O(n) - O(1)
    public static void leftRotateByd(int[] arr,int d){
        int n=arr.length;
        reverse(arr, 0,d-1);
        reverse(arr,d,n-1);
        reverse(arr,0,n-1);
    }


    public static void reverse(int[] arr,int low,int high){
        while(low<high){
            swap(arr,low,high);
            low++;
            high--;
        }
    }

    public static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
