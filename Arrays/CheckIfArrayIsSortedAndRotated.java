package Arrays;

public class CheckIfArrayIsSortedAndRotated {
    public static void main(String[] args) {
        int[] arr=new int[]{ 5, 1, 2, 3, 4 };
        // System.out.println("Is the array sorted & rotated?:"+(ascendingAndSorted(arr, arr.length-1)||descendingAndSorted(arr, arr.length-1))); 
        System.out.println("Is the arrays sorted & rotated?:"+isSortedAndRotataed(arr));
    }
    
    //Naive Soln:O(n)
    // static boolean ascendingAndSorted(int[] arr,int n){
    //     int i=0;
    //     while(i<n && arr[i]<arr[i+1]) 
    //         i++;

    //     if(i==n-1) return false;
    //     i++;

    //     while(i<n && arr[i]<arr[i+1])
    //         i++;
    //     if(i==n-1 && arr[n-1]<arr[0]) 
    //         return true;
    //     else
    //         return false;
    // }

    // static boolean descendingAndSorted(int[] arr,int n){
    //     int i=0;
    //     while(i<n && arr[i]>arr[i+1])
    //         i++;

    //     if(i==n-1) return false;
    //     i++;

    //     while(i<n && arr[i]>arr[i+1])
    //         i++;

    //     if(i==n-1 && arr[n-1]>arr[0])
    //         return true;
    //     else
    //         return false;
    // }

    //Efficient soln pivot check : O(n)
    // static boolean isSortedAndRotataed(int[] arr){
    //     int n=arr.length;
    //     int minEle=Integer.MIN_VALUE,minIndex=0;

    //     for(int i=0;i<n;i++){
    //         if(arr[i]<minEle){
    //             minEle=arr[i];
    //             minIndex=i;
    //         }
    //     }

    //     if(minIndex==0 || minIndex==n-1) return false;

    //     boolean flag1=true;
    //     for(int i=1;i<minIndex;i++){
    //         if(arr[i]<arr[i-1]){
    //             flag1=false;
    //             break;
    //         }
    //     }

    //     boolean flag2=true;
    //     for(int i=minIndex+1;i<n;i++){
    //         if(arr[i]>arr[i-1]){
    //             flag2=false;
    //             break;
    //         }
    //     }

    //     if(flag1 && flag2 && arr[n-1]<arr[0])
    //         return true;
    //     else 
    //         return false;
    // }

    static boolean isSortedAndRotataed(int[] arr){
        int n=arr.length;
        int x=0,y=0;

        for(int i=0;i<n-1;i++){
            if(arr[i]<arr[i+1]){
                x++;
            }else{
                y++;
            }
        }

        if(y==1){
            if(arr[n-1]<arr[0]){
                x++;
            }else{
                y++;
            }

            if(y==1) return true;
        }

        return false;
    }
}
