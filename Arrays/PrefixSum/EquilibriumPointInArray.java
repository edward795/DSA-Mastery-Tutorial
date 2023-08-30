package Arrays.PrefixSum;

public class EquilibriumPointInArray {
    public static void main(String[] args) {
        int[] arr=new int[]{3,4,8,-9,20,6};
        System.out.println("Equilibrium point in an array:"+getEquilibriumPoint(arr));
    }
    
    //Naive Soln : O(n^2)
    // static boolean getEquilibriumPoint(int[] arr){
    //     int n=arr.length;
    //     for(int i=0;i<n;i++){
    //         int l_sum=0,r_sum=0;
    //         for(int j=0;j<i;j++)
    //             l_sum+=arr[i];

    //         for(int j=i+1;j<n;j++)
    //             r_sum+=arr[i];

    //         if(l_sum==r_sum) return true;
    //     }
    //     return false;
    // }

    //Efficient Soln : O(n)
    static boolean getEquilibriumPoint(int[] arr){
        int sum=0;
        int n=arr.length;
        for(int i=0;i<n;i++)
            sum+=arr[i];
        
        int l_sum=0;
        for(int i=0;i<n;i++){
            if(l_sum==sum-arr[i]) return true;
                l_sum+=arr[i];
                sum-=arr[i];
        }
        return false;
    }
}
