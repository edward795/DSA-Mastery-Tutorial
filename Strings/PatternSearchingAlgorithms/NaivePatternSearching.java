package Strings.PatternSearchingAlgorithms;

public class NaivePatternSearching {
    public static void main(String[] args) {
        String txt="ABABABCD";
        String pat="ABAB";
        System.out.println("Pattern Found at ");
        patSearching(txt, pat);
    }

    //TC : O((n-m+1)*m)
    static int patSearching(String txt,String pat){
        int n=txt.length();
        int m=pat.length();

        for(int i=0;i<n-m;i++){
            int j;
            for(j=0;j<m;j++){
                if(pat.charAt(j)!=txt.charAt(i+j))
                    break;
            }
            if(j==m) 
                System.out.println(i);;
        }
        return -1;
    }
}
