public class AnagramPatternSearch{

    static final int CHAR=256;
    public static void main(String[] args) {
        String txt="geeksforgeeks";
        String pat="frog";  // anagram pattern in txt is 'forg'
        System.out.println("Is the pattern present as an anagram substrng of text?"+patternSearch(txt, pat));
    }

    //Naive Soln TC : O((n-m+1)*m)
    // static boolean patternSearch(String txt,String pat){
    //     int n=txt.length(),m=pat.length();
    //     for(int i=0;i<n-m;i++){
    //         if(areAnagram(txt, pat, i)) return true;
    //     }
    //     return false;
    // }

    // static boolean areAnagram(String txt,String pat,int j){
    //     int[] count=new int[256];
    //     for(int i=0;i<pat.length();i++){
    //         count[pat.charAt(i)]++;
    //         count[txt.charAt(i+j)]--;
    //     }

    //     for(int i=0;i<256;i++)
    //         if(count[i]!=0) return false; 

    //     return true;
    // }

    //Efficient Soln :O(n*CHAR) - O(CHAR)
    static boolean patternSearch(String txt,String pat){
        int n=txt.length(),m=pat.length();
        int[] cp=new int[CHAR];
        int[] ct=new int[CHAR];

        for(int i=0;i<m;i++){
            cp[pat.charAt(i)]++;
            ct[txt.charAt(i)]++;            
        }

        for(int i=m;i<n;i++){
            if(areSame(ct, cp)) return true; 
            ct[txt.charAt(i)]++;
            ct[txt.charAt(i-m)]--;
        }
        return false;
    }

    //TC :O(m)
    static boolean areSame(int[] ct,int[] cp){
        for(int i=0;i<CHAR;i++){
            if(cp[i]!=ct[i]) return false;
        }
        return true;
    }
}