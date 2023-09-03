package Arrays;

public class MaxDifferenceIndex {
    public static void main(String[] args) {
        int[] arr=new int[]{ 9, 2, 3, 4, 5, 6, 7, 8, 18, 0 };
        System.out.println("Max diff indexes:"+getMaxDiffIndexes(arr));
    }

    //Naive Soln : O(n^2)
    // static int getMaxDiffIndexes(int[] arr){
    //     int n=arr.length;
    //     int res=-1;
    //     int j=0;
    //     for(int i=0;i<n;i++){
    //        j=n-1;
    //        while(j>i){
    //             if(arr[j]>arr[i] && res<(j-i))
    //                 res=j-i;
    //             j--;
    //        }
    //     }
    //     return res;
    // }
    //Efficient Soln : O(n) - O(n)
    static int getMaxDiffIndexes(int[] arr){
        int n=arr.length;
        
        int[] lMin=new int[n];
        lMin[0]=arr[0];
        int[] Rmax=new int[n];
        Rmax[n-1]=arr[n-1];

        for(int i=1;i<n;i++)
            lMin[i]=Math.min(lMin[i-1],arr[i]);

        for(int i=n-2;i>=0;i--)
            Rmax[i]=Math.max(Rmax[i+1],arr[i]);
        
        int i=0,j=0,maxDiff=-1;
        while(j<n && i<n){
            if(lMin[i]<=Rmax[i]){
                maxDiff=Math.max(maxDiff,j-i);
                j++;
            }else{
                i++;
            }
        }
        return maxDiff;
    }
}
