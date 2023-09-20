package Multidimensional_Arrays;

import java.util.Arrays;

public class FindMedianPositionInRowWiseSortedMatrix {
    public static void main(String[] args) {
        int[][] arr=new int[][]{{1,10,20},{15,25,35},{5,30,40}};
        System.out.println("The median is:"+findMedian(arr));
    }
    
    //Naive soln : O(r*c*log(rc))
    // static int findMedian(int[][] arr){
    //     int n=arr.length,m=arr[0].length;
    //     int[] temp=new int[n*m];
    //     int k=0;
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<m;j++){
    //             temp[k++]=arr[i][j];
    //         }
    //     }

    //     Arrays.sort(temp);
    //     int len=temp.length%2==0?(temp.length/2-1):temp.length/2;

    //     if(temp.length%2==0){
    //         return (temp[len]+temp[len+1])/2;
    //     }else{
    //         return temp[len];
    //     }
    // }
    
    //Efficient Solution : O(32*n*log(m))
    static int findMedian(int[][] arr){
        int n=arr.length,m=arr[0].length;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            min=Math.min(min,arr[i][0]);
            max=Math.max(max,arr[i][m-1]);
        }

        int desired=(m*n+1)/2;
        while(min<max){
            int mid=min+(max-min)/2;
            int place=0;
            int get=0;

            for(int i=0;i<n;i++){
                get=Arrays.binarySearch(arr[i],mid);
                if(get<0)
                    get=Math.abs(get)-1;
                else{
                    while(get<arr[i].length && arr[i][get]==mid)
                        get+=1;
                }  
                place=place+get;
            }
            if(place<desired)
                min=mid+1;
            else 
                max=mid;
        }
        return min;
    }
}
