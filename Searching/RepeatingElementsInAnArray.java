import java.util.Arrays;

public class RepeatingElementsInAnArray {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,4,7};
        System.out.println("Reapeating Element is: "+getRepeating(arr, arr.length));
    }
    

    //Super Naive Approach - O(n^2)
    // static int getRepeating(int[] arr,int n){
    //    for(int i=0;i<n;i++){
    //     for(int j=i+1;j<n;j++){
    //         if(arr[i]==arr[j])
    //             return arr[i];
    //     }
    //    }
    //    return -1;
    // }

    //Naive Approach - O(nlogn) using sorting
    // static int getRepeating(int[] arr,int n){
    //     Arrays.sort(arr);
    //     for(int i=1;i<n;i++){
    //         if(arr[i-1]==arr[i])
    //             return arr[i];
    //     }
    //     return -1;
    // }


    //Efficient Soln -O(n) - O(n)
    // static int getRepeating(int[] arr,int n){
    //     boolean[] visited=new boolean[n];
    //     for(int i=0;i<n;i++){
    //         if(visited[arr[i]])
    //             return arr[i];
    //         else 
    //             visited[arr[i]]=true;
    //     }
    //     return -1;
    // }
    
    //Efficient Soln : O(n) - using slow & fast pointers
    static int getRepeating(int[] arr,int n){
        int slow=arr[0],fast=arr[arr[0]];
        while(slow!=fast){
            slow=arr[slow];
            fast=arr[arr[fast]];
        }

        slow=arr[0];

        while(slow!=fast){
            slow=arr[slow];
            fast=arr[fast];
        }

        return slow;
    }
    
}
