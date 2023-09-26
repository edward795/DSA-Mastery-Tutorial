package Strings.PatternSearchingAlgorithms;

public class RabinKarpAlgorithm {

    public static final int d=256;
    public static void main(String[] args) {
        String txt="ABABABCD";
        String pat="ABAB";
        int q=101; //  a prime number
        System.out.println("Pattern Found at ");
        RabinKarp(txt, pat, q);
    }

    //TC : O((n-m+1)*m)
    static void RabinKarp(String txt,String pat,int q){
        int n=txt.length();
        int m=pat.length();

        int p=0,t=0,h=1;
        for(int i=0;i<m-1;i++) 
            h=(h*d)%q;

        for(int i=0;i<m;i++){
            p=(p*d+pat.charAt(i))%q;
            t=(t*d+txt.charAt(i))%q; 
        }
        for(int i=0;i<=n-m;i++){
            if(p==t){
                int j;
                for(j=0;j<m;j++){
                    if(txt.charAt(i+j)!=pat.charAt(j)) 
                        break;
                }

                if(j==m) 
                    System.out.println(i);
            }

            if(i<n-m){
                t=(d*(t-txt.charAt(i)*h)+txt.charAt(i+m))%q;
                if(t<0)
                    t=(t+q);
            }
        }
        
    }
}
