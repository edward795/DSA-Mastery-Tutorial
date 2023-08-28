package Arrays;

public class LeaderInAnArray {
    public static void main(String[] args) {
        int[] arr=new int[]{7,10,4,10,6,5,2};
        System.out.println("Leader in array are:");
        printLeaders(arr);
    }
    

    //Naive soln : O(n^2)
    // public static void printLeaders(int[] arr){
    //     int n=arr.length;
    //     for(int i=0;i<n;i++){
    //         boolean flag=false;
    //         for(int j=i+1;j<n;j++){
    //             if(arr[j]>=arr[i])
    //                 flag=true;
    //         }
    //         if(flag==false)
    //             System.out.print(arr[i]+" ");
    //     }
    // }
    
    //TC : O(n)
    public static void printLeaders(int[] arr){
        int n=arr.length;
        int curr_leader=arr[n-1];
        System.out.print(curr_leader+" ");
        for(int i=n-2;i>=0;i--)
            if(curr_leader<arr[i]){
                curr_leader=arr[i];
                System.out.print(arr[i]+" ");
            }
    }
}
