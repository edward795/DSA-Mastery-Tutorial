import java.util.Arrays;

public class CountPairXY {


    /**
     * Given two arrays X[] and Y[] of positive integers, find a number of pairs such that x^y > y^x where x is an element from X[] and y is an element from Y[].
     */
    public static void main(String[] args) {
        int[] x=new int[]{2,1,6};
        int[] y=new int[]{1,5};
        int m=x.length,n=y.length;
        System.out.println("The count of pairs is:"+countPairXY(x, y, m, n));
    }
    
    //Naive Approach : O(M*N)
    // static int countPairXY(int[] x,int[] y,int m,int n){
    //     int count=0;
    //     for(int i=0;i<m;i++){
    //         for(int j=0;j<n;j++){
    //             if(Math.pow(x[i],y[j])>Math.pow(y[j],x[i])){
    //                 count++;
    //             }
    //         }
    //     }
    //     return count;
    // }


    static int count(int x,int Y[],int n,int NoOfY[]){
        if(x==0) return 0;

        if(x==1) return NoOfY[0];

        int idx=Arrays.binarySearch(Y,x);
        int ans;
        if(idx<0){
            idx=Math.abs(idx+1);
            ans=Y.length-idx;
        }else{
            while(idx<n && Y[idx]==x){
                idx++;
            }
            ans=Y.length-idx;
        }

        ans+=NoOfY[0]+NoOfY[1];
        if(x==2) 
            ans-=(NoOfY[3]+NoOfY[4]);

        if(x==3)
            ans+=NoOfY[2];

        return ans;
    }
    //Efficient Soln : O(logn + logm)
    static long countPairXY(int X[],int Y[],int m,int n){
        int NoOfY[]=new int[5];
        for(int i=0;i<n;i++){
            if(Y[i]<5)
             NoOfY[Y[i]]++;
        }

        Arrays.sort(Y);

        long total_pairs=0;
        for(int i=0;i<m;i++){
            total_pairs+=count(X[i],Y,n,NoOfY);
        }

        return total_pairs;
    }
}
