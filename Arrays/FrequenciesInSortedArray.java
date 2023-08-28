package Arrays;

public class FrequenciesInSortedArray {
    public static void main(String[] args) {
        int[] arr=new int[]{10,10,10,30,30,40};
        System.out.println("Frequencies of numbers:");
        printFreq(arr);
    }

    //TC : O(n)
    public static void printFreq(int[] arr){
        int freq=1;  
        int n=arr.length;
        int i=1;
        while(i<n){
            while(i<n && arr[i-1]==arr[i]){
                freq++;
                i++;
            }
            System.out.println(arr[i-1]+":"+freq);
            i++;
            freq=1;
        }

        if(n==1||arr[n-1]!=arr[n-2])
            System.out.println(arr[n-1]+":"+1);
    }

}
