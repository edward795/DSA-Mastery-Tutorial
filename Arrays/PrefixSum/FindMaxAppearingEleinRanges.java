package Arrays.PrefixSum;

public class FindMaxAppearingEleinRanges {
    public static void main(String[] args) {
        int[] l=new int[]{1,2,3};
        int[] r=new int[]{3,5,7};
        int[] arr=new int[10000];
        System.out.println("The max occurring element is : "+getMaxOccurringElement(arr,l,r));
    }
    
    //Efficient Soln : O(n) - O(k) say k=10000 here
    static int getMaxOccurringElement(int[] arr,int[] l,int[] r){
        int n=l.length;
        for(int i=0;i<n;i++){
            arr[l[i]]++;
            arr[r[i]+1]--;
        }
        int maxm=arr[0],res=0;
        for(int i=1;i<1000;i++){
            arr[i]+=arr[i-1];
            if(maxm<arr[i]){
                maxm=arr[i];
                res=i;
            }
        }
        return maxm;
    }
}
