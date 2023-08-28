package Arrays;

public class CheckIfArrayisSorted {
    public static void main(String[] args) {
        int[] arr=new int[]{8,12,15};
        System.out.println("Array is sorted or not?"+isSorted(arr));
    }

    //Naive soln: O(n^2)
    // public static boolean isSorted(int[] arr){
    //     for(int i=0;i<arr.length;i++){
    //         for(int j=i+1;j<arr.length;j++){
    //             if(arr[j]<arr[i]) return false;
    //         }
    //     }
    //      return true;
    // }

    //Efficient Soln : o(n)
    public static boolean isSorted(int[] arr){
        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[i-1]) return false;
        }

        return true;
    }
}
