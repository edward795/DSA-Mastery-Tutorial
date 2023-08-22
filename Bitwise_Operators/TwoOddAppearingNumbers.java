package Bitwise_Operators;

public class TwoOddAppearingNumbers {
    public static void main(String[] args) {
        int[] arr=new int[]{3,4,3,4,5,4,4,6,7,7};
        int[] res=get2OddAppearingNumbers(arr);
        System.out.println("The 2 odd appearing numbers are:"+res[0]+" "+res[1]);
        
    }
    
    //Naive Soln - O(n^2)
    // public static int[] get2OddAppearingNumbers(int[] arr){
    //     int[] res=new int[2];
    //     int k=0;
    //     for(int i=0;i<arr.length;i++){
    //         int count=0;
    //         for(int j=0;j<arr.length;j++){
    //             if(arr[i]==arr[j]){
    //                 count++;
    //             }
    //         }
    //         if(count%2!=0){
    //             res[k++]=arr[i];
    //         }
    //     }
    //     return res;
    // }
    
    //Efficient Soln: O(n)
    public static int[] get2OddAppearingNumbers(int[] arr){
        int xor=0,res1=0,res2=0;
        for(int i=0;i<arr.length;i++){
            xor=xor^arr[i];
        }

        int sn=xor&~(xor-1);
        for(int i=0;i<arr.length;i++){
            if((arr[i]&sn)!=0){
                res1=res1^arr[i];
            }else{
                res2=res2^arr[i];
            }
        }

        return new int[]{res1,res2};
    }
}
