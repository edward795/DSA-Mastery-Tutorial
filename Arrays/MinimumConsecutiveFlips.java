package Arrays;

public class MinimumConsecutiveFlips {
    public static void main(String[] args) {
        int[] arr=new int[]{1,1,0,0,0,1}; 
        System.out.println("The minimum consecutive flips in the array are from:");
        getMinimumConsecutiveFlips(arr);
    }
    
    //Efficient soln : O(n)
    static void getMinimumConsecutiveFlips(int[] arr){
        int n=arr.length;
        for(int i=1;i<n;i++){
            if(arr[i]!=arr[i-1]){
                if(arr[i]!=arr[0]){
                    System.out.print("From "+i);
                }else{
                    System.out.println(" to "+(i-1));
                }
            }
        }

        if(arr[n-1]!=arr[0])
            System.out.println(" to "+(n-1));
    }
}
