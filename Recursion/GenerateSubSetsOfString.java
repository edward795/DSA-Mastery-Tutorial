package Recursion;

public class GenerateSubSetsOfString {
    public static void main(String[] args) {
        String str="ABC";
        System.out.println("The power set of a string are:");
        subsets(str,"",0);
    }
    //TC : O(2^n)
    public static void subsets(String s,String curr,int i){
        if(i==s.length()){
            System.out.println(curr);
            return;
        }

        subsets(s,curr,i+1);
        subsets(s,curr+s.charAt(i),i+1);
    } 
}
