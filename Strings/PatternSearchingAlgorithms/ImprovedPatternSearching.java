package Strings.PatternSearchingAlgorithms;

public class ImprovedPatternSearching {
    public static void main(String[] args) {
        String txt="ABCABCDABCD";
        String pat="ABCD";
        System.out.println("Pattern found at indexes : ");
        patSearchDist(txt, pat);
    }

    //TC : O(n) - O(1)
    static int patSearchDist(String txt,String pat){
        int n=txt.length();
        int m=pat.length();
        for(int i=0;i<n-m;){
            int j;
            for(j=0;j<m;j++){
                if(txt.charAt(i+j)!=pat.charAt(j)) 
                    break;
            }
            if(j==m)
                System.out.println(i);
            if(j==0)
                i++;
            else 
                i+=j;
            
        }
        return -1;
    }
}
