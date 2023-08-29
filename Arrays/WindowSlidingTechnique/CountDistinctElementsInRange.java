package Arrays.WindowSlidingTechnique;

import java.util.Arrays;
import java.util.HashMap;

public class CountDistinctElementsInRange {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,1,3,4,2,3};
        int n=arr.length;
        int k=4;

        //Naive Soln - O(n*K^2)
        // for(int i=0;i<=n-k;i++){
        //     System.out.print(countWindowDistinct(Arrays.copyOfRange(arr,i,n), k)+" ");
        // }

        countWindowDistinct(arr,k);
    }
    //Naive Soln - O(n*K^2)
    // static int countWindowDistinct(int[] win,int k){
    //     int dis_count=0;
    //     for(int i=0;i<k;i++){
    //         int j;
    //         for(j=0;j<i;j++){
    //             if(win[i]==win[j])
    //                 break;
    //         }
    //         if(j==i)
    //             dis_count++;    
    //     }
    //     return dis_count;
    // }
    
    //Efficient Soln : Window Sliding Technique  - O(n) -O(n)
    static void countWindowDistinct(int[] arr,int k){
        int n=arr.length;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<k;i++)
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);

        System.out.print(hm.size()+" ");

        for(int i=k;i<n;i++){
            if(hm.get(arr[i-k])==1){
                hm.remove(arr[i-k]);
            }else{
                hm.put(arr[i-k],hm.getOrDefault(arr[i-k],0)-1);
            }

            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
            System.out.print(hm.size()+" ");
        }
    }
}
