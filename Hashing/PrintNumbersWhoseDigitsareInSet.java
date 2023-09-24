import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PrintNumbersWhoseDigitsareInSet {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,77,3,4,12,20,30,70};
        System.out.println("The numbers which contains digits 1,2 & 3 are : ");
        printNumbersInSet(arr, arr.length);
    }
    
    //Naive Soln : O(n^2)
    // static void printNumbersInSet(int[] arr,int n){
    //     for(int i=0;i<n;i++){
    //         if(isInSet(arr[i])) 
    //             System.out.print(arr[i]+" ");
    //     }
    // }

    // //function to check if a number contains digits 1,2 or 3
    // static boolean isInSet(int n){
    //     while(n>0){
    //         int rem=n%10;
    //         if(rem==1 || rem==2 || rem==3) return true;
    //         n=n/10;
    //     }
    //     return false;
    // }

    //Efficient Soln :O(n) - O(n) ~= O(10^6)
    static void printNumbersInSet(int[] arr,int n){
        HashMap<Integer,Integer> hm=new HashMap<>();
        findAll(hm);
        for(int i=0;i<n;i++){
            if(hm.containsKey(arr[i]))
                System.out.print(arr[i]+" ");
        }
    }
    public static void findAll(HashMap<Integer,Integer> mp)
        {
            int num=1,num2;
            ArrayList<Integer> a=new ArrayList<>(); 
            int j=1;
            
            //storing 1,2, and 3 in the list.
            a.add(j);
            a.add(j+1);
            a.add(j+2);
            
            mp.put(1,1);
            mp.put(2,1);
            mp.put(3,1);
            
            j=0;

            while(num<=1000000)
            {
                num2=a.get(j++);
                
                if((num2*10)+1<=1000000){
                    a.add((num2*10)+1);
                    mp.put(num2*10+1,1);
                }
                
                if((num2*10)+2<=1000000){
                    a.add((num2*10)+2);
                    //updating the value in map.
                    mp.put(num2*10+2,1);
                }
                
                num2=(num2*10)+3;
                if(num2<=1000000){
                    a.add(num2);
                    //updating the value in map.
                    mp.put(num2,1);
                }
                num=num2;
            }
    }
  

}
