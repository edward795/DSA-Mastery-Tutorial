package Bitwise_Operators;

public class OddOccurrenceInArray {
    public static void main(String[] args) {
        int arr[]=new int[]{4,3,4,4,4,5,5};
        System.out.println("Odd occurring ele:"+getOddOccurrence(arr));
    }
    
    //Naive Soln - O(n^2)
    // public static int getOddOccurrence(int[] arr){
    //     for(int i=0;i<arr.length;i++){
    //         int count=0;
    //         for(int j=0;j<arr.length;j++){
    //             if(arr[j]==arr[i]){
    //                 count++;
    //             }
    //         }

    //         if(count%2!=0) return arr[i];
    //     }
    //     return -1;
    // }
    
    //Efficient soln - O(n)
    public static int getOddOccurrence(int[] arr){
        int res=0;
        for(int i=0;i<arr.length;i++){
            res=res^arr[i];
        }
        return res;
    }
    
}