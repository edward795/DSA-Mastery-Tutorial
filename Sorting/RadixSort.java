import utils.Print;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr=new int[]{319,212,6,8,100,50};
        int n=arr.length;
        System.out.println("Array after sorting:");
        RadixSort(arr, n);
        Print pr=new Print();
        pr.printArray(arr, arr.length);
    }
    
    //TC : O(d*(n+k)) d=no: Of digits of max number,b=base of that no: here its 10
    static void RadixSort(int[] arr,int n){
        int mx=getMax(arr, n);
        for(int exp=1;mx/exp>0;exp=exp*10)
            countingSort(arr, n, exp);
    }
    
    //TC : O(n+k)
    static void countingSort(int[] arr,int n,int exp){
        int mx=(int)getMax(arr, n);
        int[] count=new int[mx+1];
        int[] output=new int[n];
        
        for(int i=0;i<n;i++){
            count[(arr[i]/exp)%10]++;
        } 

        for(int i=1;i<mx;i++){
            count[i]+=count[i-1];
        }

        for(int i=n-1;i>=0;i--){
            output[count[(arr[i]/exp)%10]-1]=arr[i];
            count[(arr[i]/exp)%10]--;
        }

        for(int i=0;i<n;i++){
            arr[i]=output[i];
        }
    }

    static int getMax(int[] arr,int n){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,arr[i]);
        }
        return max;
    }
}
