package Recursion;

public class PermutationsOfString {
    public static void main(String[] args) {
        String s="ABC";
        System.out.println("Permutations of string are:");
        permute(s,0);
    }

    
    public static void permute(String s,int i){
        if(i==s.length()-1){
            System.out.println(s);
            return;
        }
        for(int j=i;j<s.length();j++){
            s=swap(s, i, j);
            permute(s,i+1);
            s=swap(s,i,j);
        }
    }

    public static String swap(String s,int i,int j){
        char[] arr=s.toCharArray();
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        return new String(arr);
    } 
}
