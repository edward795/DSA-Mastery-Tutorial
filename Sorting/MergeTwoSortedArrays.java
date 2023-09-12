import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1=new int[]{10,15,10};
        int[] arr2=new int[]{5,6,6,15};
        int m=arr1.length;
        int n=arr2.length;
        System.out.println("The merged array is:");
        int[] res=merge(arr1, arr2, m, n);
        for(int i=0;i<m+n;i++){
            System.out.print(res[i]+" ");
        }
    }
    
    //Naive Soln : O((m+n)log(m+n))
    // static int[] merge(int[] arr1,int[] arr2,int m,int n){
    //     int[] res=new int[m+n];
    //     for(int i=0;i<m;i++)
    //         res[i]=arr1[i];

    //     for(int i=0;i<n;i++)
    //         res[i+m]=arr2[i];

    //     Arrays.sort(res);
    //     return res;
    // }

    //Efficient Soln : O(m+n)
    static int[] merge(int[] arr1,int[] arr2,int m,int n){
        int i=0,j=0,k=0;
        int[] res=new int[m+n];
        while(i<m && j<n){
            if(arr1[i]<arr2[j]){
                res[k++]=arr1[i];
                i++;
            }else{
                res[k++]=arr2[j];
                j++;
            }
        }

        while(i<m){
            res[k++]=arr1[i];
            i++;
        }

        while(j<n){
            res[k++]=arr2[j];
            j++;
        }

        return res;
    }
}
