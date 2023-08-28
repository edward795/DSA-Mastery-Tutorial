package Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr=new int[]{10,20,20,30,30,30};
        int size=removeDups(arr);
        for(int i=0;i<size;i++)
            System.out.print(arr[i]+" ");
    }
    
    //Naive Soln : O(n) - O(n)
    // public static int removeDups(int[] arr){
    //     int n=arr.length;
    //     int[] temp=new int[n];
    //     temp[0]=arr[0];
        
    //     int res=1;
    //     for(int i=1;i<n;i++){
    //         if(arr[res-1]!=arr[i]){
    //             temp[res++]=arr[i];
    //         }
    //     }

    //     for(int i=0;i<res;i++){
    //         arr[i]=temp[i];
    //     }

    //     return res;
    // }


    //Efficient Soln - O(n) - O(1)
    public static int removeDups(int[] arr){
        int res=1;
        for(int i=1;i<arr.length;i++){
            if(arr[res-1]!=arr[i]){
                arr[res]=arr[i];
                res++;
            }
        }
        return res;
    }
}
