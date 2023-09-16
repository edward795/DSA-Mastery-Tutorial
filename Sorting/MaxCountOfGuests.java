import java.util.Arrays;

public class MaxCountOfGuests {
    public static void main(String[] args) {
        int[] arr=new int[]{900,940}; //arrival time
        int[] dep=new int[]{1000,1030}; //departure time
        System.out.println("The max value of guests that can be met:"+getMaxCounts(arr, dep));
    }
    
    //Efficient Soln :O(nlogn)
    static int getMaxCounts(int[] arr,int[] dep){
        int n=arr.length;
        Arrays.sort(arr);
        Arrays.sort(arr);
        
        int i=1,j=0,res=1,curr=1;
        while(i<n && j<n){
            if(arr[i]<=dep[i]){
                curr++;
                i++;
            }else{
                curr--;
                j++;
            }

            res=Math.max(res,curr);
        }
        return res;
    }
}
