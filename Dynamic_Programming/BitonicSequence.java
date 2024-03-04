package Dynamic_Programming;

public class BitonicSequence {
    public static void main(String[] args) {
        int[] arr=new int[]{1,11,2,10,4,5,2,1};
        int n=arr.length-1;
        System.out.println("The max length of bitonic seq : "+bitonicSeqLength(arr, n));
    }

    static int bitonicSeqLength(int[] arr,int n){
        int[] lis=new int[n];
        int[] lds=new int[n];
        lis[0]=1;
        for(int i=1;i<n;i++){
            lis[i]=(arr[i]>=arr[i-1])?lis[i-1]+1:1;
        }

        lds[n-1]=1;
        for(int i=n-2;i>=0;i--){
            lds[i]=(arr[i]>=arr[i+1])?lds[i+1]+1:1;
        }

        int res=1;
        for(int i=0;i<n;i++)
            res=Math.max(res,lis[i]+lds[i]-1);
        return res;
    }
}
