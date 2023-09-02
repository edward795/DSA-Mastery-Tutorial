package Arrays;
/**
 * Given a sorted array rearrange an array in maximum minimum 
 * Input: arr[] = {1, 2, 3, 4, 5, 6, 7} 
 *  Output: arr[] = {7, 1, 6, 2, 5, 3, 4}
 *
 * Input: arr[] = {1, 2, 3, 4, 5, 6} 
 * Output: arr[] = {6, 1, 5, 2, 4, 3} 
 */
public class ArrangeArrayAsMaxMin {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5,6};
        rearrange(arr);
        System.out.println("Array After rearranging:");
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }
    

    //O(n) - O(n)
    // static void rearrange(int[] arr){
    //     int n=arr.length;
    //     int l=0,r=n-1;
    //     int[] temp=arr.clone();
    //     boolean flag=true;
    //     for(int i=0;i<n;i++){
    //         if(flag){
    //             arr[i]=temp[r--];
    //         }else{
    //             arr[i]=temp[l++];
    //         }
    //         flag=!flag;
    //     }
    // } 
   
    //Efficient Soln : O(n) -O(1)
    static void rearrange(int[] arr){
        int n=arr.length;
        int min_idx=0,max_idx=n-1,max_ele=arr[n-1]+1;
        for(int i=0;i<n;i++){
            if(i%2==0){
                arr[i]+=(arr[max_idx]%max_ele)*max_ele;
                max_idx--;
            }else{
                arr[i]+=(arr[min_idx]%max_ele)*max_ele;
                min_idx++;
            }

        }

        for(int i=0;i<n;i++)
            arr[i]=arr[i]/max_ele;
    }
 }

