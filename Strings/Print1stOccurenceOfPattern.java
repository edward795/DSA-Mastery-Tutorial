public class Print1stOccurenceOfPattern {
    public static void main(String[] args) {
        String txt="geeksforgeeks";
        String pat="for";
        System.out.println("The 1st occurrence of pattern in string is : "+printOccurrence(txt, pat));
    }
    //TC : O((n-m+1)*m)
    static int printOccurrence(String str,String pat){
        int n=str.length(),m=pat.length();
        if(m==0) return -1;

        for(int i=0;i<n-m;i++){
            int j;
            for(j=0;j<m;j++){
                if(str.charAt(i+j)!=pat.charAt(j))
                    break;
            }
            if(j==m)
                return i;
        }
        return -1;
    }
}
