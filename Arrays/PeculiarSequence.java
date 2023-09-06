package Arrays;
/**
 * Given a number n where A[0]=n,without using loop,generate a sequence where 
 * A[i+1]=A[i]-5 & A[i+1]=A[i]+5 repated until A[i]=n
 * 
 * eg: 
 * i/p: 
 *      n=16
 * o/p: 
 *      16 11 6 1 -4 1 6 11 16
 */
public class PeculiarSequence {
    static int n=0;
    public static void main(String[] args) {
        n=16;
        System.out.println("Generated Pattern:");
        int[] arr=getPattern(n);
        for(int i=0;i<arr.length-1;i++)
            System.out.print(arr[i]+" ");
    }

    static int[] generatePattern(int[] arr,int i,int j,boolean flag){
        arr[j]=i;
        if(flag==false && i==n) return arr;
        if(flag){
            if(i-5>0)
                generatePattern(arr, i-5, j+1, true);
            else
                generatePattern(arr, i-5, j+1, false);
        }else{
            generatePattern(arr, i+5, j+1, flag);
        }

        return arr;
    }

    static int[] getPattern(int n){
        int[] arr=new int[2*((n/5)+2)];
        return generatePattern(arr,n,0,true);
    }
}
