package Arrays.WindowSlidingTechnique;
/**
 * Program to find M terms of a n-bonnacci sequence
 * M - No of terms -> m=8 -> 1s 8 terms
 * N - n-bonacci -> n=3 -> tribonacci
 * 
 * for any n-bonacci sequence 1st n-1 terms are 0 & nth term is 1 & you can 
 * find the remaining (n+1)th to m terms by taking the sum of previous n terms.
 */
public class BonacciSeries {
    public static void main(String[] args) {
        int m=8,n=4;
        System.out.println("The first "+m+" terms of "+n+"-bonnacci sequence are");
        bonaccisequence(m, n);
    }
    //Naive Soln : O(n^2)
    // static void bonaccisequence(int m,int n){
    //     int[] arr=new int[m];
    //     arr[n-1]=1;

    //     for(int i=n;i<m;i++){
    //         for(int j=i-n;j<i;j++){
    //             arr[i]+=arr[j];
    //         }
    //     }

    //     for(int j=0;j<m;j++)
    //         System.out.print(arr[j]+" ");
    // }
    
    //Sliding Window Technique : TC : O(n)
    static void bonaccisequence(int m,int n){
        int[] arr=new int[m];
        arr[n-1]=1;
        arr[n]=1;

        for(int i=n+1;i<m;i++){
            arr[i]=2*(arr[i-1])+arr[i-n-1];
        }

        for(int i=0;i<m;i++)
            System.out.print(arr[i]+" ");
    }
}
