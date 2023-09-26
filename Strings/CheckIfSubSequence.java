package Strings;

public class CheckIfSubSequence {
    public static void main(String[] args) {
        String s1="ABCD";
        String s2="AD";
        int n=s1.length(),m=s2.length();
        System.out.println("Does a subsequence exist ? "+isSubSequence(s1, s2,n,m));
    }

    //Naive Soln :(n+m) - O(1)
    // static boolean isSubSequence(String s1,String s2){
    //     int n=s1.length(),m=s2.length();

    //     int j=0;
    //     for(int i=0;i<n;i++){
    //         if(s1.charAt(i)==s2.charAt(j))
    //             j++;
    //     }

    //     return (j==m);
    // }
    
    //Recursive Soln : O(n+m) - O(n+m)
    static boolean isSubSequence(String s1,String s2,int n,int m){
        if(m==0) return true;
        if(n==0) return false; 
        if(s1.charAt(n-1)==s2.charAt(m-1)) 
            return isSubSequence(s1, s2, n-1, m-1);
        else 
            return isSubSequence(s1, s2, n-1, m);
    }
}
