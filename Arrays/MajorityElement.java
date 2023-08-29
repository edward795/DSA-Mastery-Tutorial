package Arrays;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr=new int[]{8,3,4,8,8};
        int n=arr.length;
        System.out.println("Majority Element is:"+getMajorityElement(arr,n));
    }
    
    //Naive Soln : TC : O(n^2)
    // static int getMajorityElement(int[] arr,int n){
    //     int res=-1;
    //     for(int i=0;i<n;i++){
    //         int count=0;
    //         for(int j=0;j<n;j++){
    //             if(arr[i]==arr[j])
    //                 count++;
    //         }
    //         if(count>n/2)
    //             res=arr[i];
    //     }
    //     return res;
    // }
    
    //Efficient Soln : Boyer-Moore Majority voting Algorithm - O(n)
    static int getMajorityElement(int[] arr,int n){
        int res=0,count=1;
        for(int i=1;i<n;i++){
            if(arr[res]==arr[i])
                count++;
            else
                count--;

            if(count==0){
                res=i;
                count=1;
            }
        }

        count=0;
        for(int i=0;i<n;i++){
            if(arr[res]==arr[i])
                count++;
        }

        if(count<=n/2) return -1; 
        
        return res;
    }
}
