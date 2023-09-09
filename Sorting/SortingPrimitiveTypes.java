import java.util.Arrays;

public class SortingPrimitiveTypes {
    public static void main(String[] args) {
        int[] arr=new int[]{8,4,2,14,13,27,23,29}; 
        int n=arr.length;
        printArray(arr);

        //sort in a range
        Arrays.sort(arr,4,n-1);  
        printArray(arr);

        //sort completely
        Arrays.sort(arr);
        printArray(arr);
    }

    static void printArray(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
