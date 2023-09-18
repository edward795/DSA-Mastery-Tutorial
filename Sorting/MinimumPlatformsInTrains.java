import java.util.Arrays;

public class MinimumPlatformsInTrains {
    public static void main(String[] args) {
        int[] arrivals=new int[]{ 900, 940, 950, 1100, 1500, 1800};
        int[] departures=new int[]{910, 1200, 1120, 1130, 1900, 2000};

        System.out.println("The count of minimum platforms required:"+getMaxCounts(arrivals, departures));
    }

    //Naive Soln : O(n^2)
    // static int getMaxCounts(int[] arr,int[] dep){
    //     int res=Integer.MIN_VALUE;
    //     int curr=1;
    //     for(int i=0;i<arr.length;i++){
    //         for(int j=0;j<dep.length;j++){
    //             if(i!=j){
    //                 if(arr[i]>=arr[j] && dep[i]<=dep[j]) 
    //                     curr++;
    //             }
    //         }
    //         res=Math.max(curr,res);
    //     }
    //     return res;
    // }


    //Efficient Soln : TC : O(nlogn)
    static int getMaxCounts(int[] arr,int[] dep){
        Arrays.sort(arr);
        Arrays.sort(dep);

        int n=arr.length;
        int i=1,j=0;
        int res=1,curr=1;
        while(i<n && j<n){
            if(arr[i]<=dep[j]){
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
