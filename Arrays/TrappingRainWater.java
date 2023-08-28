package Arrays;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr=new int[]{3,0,1,2,5};
        System.out.println("Max water that can be trapped:"+getMaxTrappedWater(arr));
    } 
    //Naive Soln: O(n^2) - O(1)
    // static int getMaxTrappedWater(int[] arr){
    //     int res=0;
    //     int n=arr.length;
    //     for(int i=1;i<n;i++){
    //         int lMax=arr[i];
    //         for(int j=0;j<i;j++)
    //             lMax=Math.max(lMax,arr[j]);
    //         int rMax=arr[i];
    //         for(int j=i+1;j<n;j++)
    //             rMax=Math.max(rMax,arr[j]);

    //         res=res+(Math.min(lMax,rMax)-arr[i]);
    //     }
    //     return res;
    // }
    
    //Efficient Soln - O(n) - O(n)
    static int getMaxTrappedWater(int[] arr){
        int res=0;
        int n=arr.length;
        int[] lMax=new int[n];
        int[] rMax=new int[n];

        lMax[0]=arr[0];
        for(int i=1;i<n;i++)
            lMax[i]=Math.max(lMax[i-1],arr[i-1]);

        rMax[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--)
            rMax[i]=Math.max(rMax[i+1],arr[i]);

        for(int i=1;i<n-1;i++)
            res=res+Math.min(lMax[i],rMax[i])-arr[i];

        return res;
    }
}
