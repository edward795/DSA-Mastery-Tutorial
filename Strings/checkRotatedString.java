public class checkRotatedString {
    public static void main(String[] args) {
        String str1="amazon";
        String str2="azonam";
        System.out.println("The String is a rotatioon of string 2 : "+checkRoatation(str1, str2));
    }

    //TC : O(n)
    static int checkRoatation(String str1,String str2){
        int n=str1.length();
        if(str1.length()!=str2.length()) return 0;
        char[] c=str1.toCharArray();
        char[] c1=new char[n];
        char[] c2=new char[n];

        for(int i=0;i<n-2;i++)
            c1[i]=c[i+2];

        c1[n-1]=c[1];
        c2[n-2]=c[0];

        for(int i=2;i<n;i++)
            c2[i]=c[i-2];
        c2[0]=c[n-1];
        c2[1]=c[n-2];
        
        char[] str2Char=str2.toCharArray();

        for(int i=0;i<n;i++){
            if(c1[i]!=str2Char[i] && c2[i]!=str2Char[i]) 
                return 0;
        }
        return 1;
    }
}
