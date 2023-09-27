package Strings.PatternSearchingAlgorithms;

public class KMPAlgorithm{
    public static void main(String[] args) {
        String txt="ABCABCDABCD";  
        String pat="ABCD";
        System.out.println("Pattern found at indexes : ");
        KMPAlgoritm(txt, pat);
    }

    //Most Efficient pattern searching Algorithm : O(n)
    static void KMPAlgoritm(String txt,String pat){
        int n=txt.length(),m=pat.length();
        int[] lps=new int[m];

        fillLPS(pat, lps); 

        int i=0,j=0;
        while(i<n){
            if(pat.charAt(j)==txt.charAt(i)){
                i++;
                j++;
            }
            if(j==m){
                System.out.println(i-j);
                j=lps[j-1];
            }else if(i<n && pat.charAt(j)!=txt.charAt(i)){
                if(j==0) i++;
                else j=lps[j-1];
            }
        }
    }

    //Efficient Way to compute LPS Array : O(n)
    // static void fillLPS(String str,int[] lps){
    //     int n=str.length(),len=0;
    //     lps[0]=0;
    //     int i=1;
    //     while(i<n){
    //         if(str.charAt(i)==str.charAt(len)){
    //             len++;
    //             lps[i]=len;
    //             i++;
    //         }else{
    //             if(len==0){
    //                 lps[i]=0;
    //                 i++;
    //             }else{
    //                 len=lps[len-1];
    //             }
    //         }
    //     }
    // }


    //Naive implementation for LPS Array : (n^3)
    static void fillLPS(String str,int[] lps){
        for(int i=0;i<str.length();i++)
            lps[i]=longPropPrefixSuffix(str);
    }

    //TC : O(n^2)
    static int longPropPrefixSuffix(String str){
        int n=str.length();
        for(int len=n-1;len>0;len--){
            boolean flag=true;
            for(int i=0;i<len;i++){
                if(str.charAt(i)!=str.charAt(n-len+i)){
                    flag=false;
                }
            }
            if(flag==true) 
                return len;
        }
        return 0;
    }

}
