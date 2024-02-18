package Backtracking;

public class LargestKSwaps {
    static String max="";
    public static void main(String[] args) {
        String str="1234567";
        int k=4;
        System.out.println("Largest number in k swaps : "+findMaximumNum(str, k));
    }

    //TC : O(n!/(n-k)!) - O(n)
    public static String findMaximumNum(String str,int k){
        char[] c=str.toCharArray();
        permuteStr(c, k);
        return max;
    }

    public static void permuteStr(char[] str,int k){
        if(k==0) return;
        for(int i=0;i<str.length-1;i++){
            for(int j=i+1;j<str.length;j++){
                if(str[i]<str[j]){
                    str=swap(str,i,j);
                    if(String.valueOf(str).compareTo(max)>0){
                        max=String.valueOf(str);
                    }
                    permuteStr(str, k-1);
                    str=swap(str,i,j);
                }
            }
        }
    }

    public static char[] swap(char[] arr,int i,int j){
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        return arr;
    }
}
