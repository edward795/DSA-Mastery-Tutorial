import java.util.Arrays;

import utils.Print;

public class MergeWithoutExtraSpace {
    public static void main(String[] args) {
        int[] arr1=new int[]{1,3,5,7};
        int[] arr2=new int[]{0,2,6,8,9};
        int n=arr1.length;
        int m=arr2.length;

        System.out.println("Arrays after sorting:");
        mergeWithoutExtraSpace(arr1, arr2, n, m);
        Print pr=new Print();
        pr.printArray(arr1, n);
        pr.printArray(arr2, m);
    }
    //TC : O(nlogn)
    static void mergeWithoutExtraSpace(int[] arr1,int[] arr2,int n,int m){
        int i=0,j=0,k=n-1;

        while(i<=k && j<m){
            if(arr1[i]<arr2[j])
                i++;
            else{
                int temp=arr2[j];
                arr2[j]=arr1[k];
                arr1[k]=temp;
                k--;
                j++;
            }
        }


        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
