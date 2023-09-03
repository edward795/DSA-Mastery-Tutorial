package Arrays;
/**
 * Note: All elements in the array are less than the no: of elements 'n'
 */
public class RearrangeArrayElements {
    public static void main(String[] args) {
        int[] arr=new int[]{1,0};
        System.out.println("Array after rearranging:");
        rearrange(arr);
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }
    static void rearrange(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++)
            arr[i]+=arr[arr[i]%n]*n;

        for(int i=0;i<n;i++)
            arr[i]=arr[i]/n;
    }
}
