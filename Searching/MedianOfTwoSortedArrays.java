import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1=new int[]{10,20,30,40,50};
        int[] arr2=new int[]{5,15,25,35,45};
        System.out.println("Median of 2 sorted arrays:"+median(arr1, arr2));
    }
    
    //Naive Soln : O(n1+n2)(log(n1+n2))
    // static int median(int[] arr1,int[] arr2){
    //     int n1=arr1.length;
    //     int n2=arr2.length;

    //     int[] temp=new int[n1+n2];
    //     int k=0;

    //     for(int i:arr1)
    //         temp[k++]=i;

    //     for(int j:arr2) 
    //         temp[k++]=j;

    //     Arrays.sort(temp);
    //     int pos=(n1+n2);
    //     if(pos%2!=0)
    //         return temp[pos/2];
    //     else 
    //         return (temp[pos/2]+temp[pos/2-1])/2;
    // }
     
    //Efficient Soln :O(logn1)  Note: here we assume n1<=n2
     static double median(int[] a1,int[] a2){
        int n1=a1.length,n2=a2.length;
        int begin1=0,end1=n1-1;
        while(begin1<=end1){
            int i1=(begin1+end1)/2;
            int i2=(n1+n2+1)/2-i1;

            int min1=(i1==n1)?Integer.MAX_VALUE:a1[i1];
            int max1=(i1==0)?Integer.MIN_VALUE:a1[i1-1];

            int min2=(i2==n2)?Integer.MAX_VALUE:a2[i2];
            int max2=(i2==0)?Integer.MIN_VALUE:a2[i2-1];

            if(max1<=min2 && max2<=min1){
                if((n1+n2)%2==0){
                    return (double)(Math.max(max1,max2)+Math.min(min1,min2))/2;
                }else{
                    return (double)Math.max(max1,max2);
                }
            }else if(max1>min2)
                end1=i1-1;
            else 
                begin1=i1+1;
        }
        return -1l;
     }   
}
