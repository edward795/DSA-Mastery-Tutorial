import java.util.Arrays;

public class IsomorphicStrings {
    public static void main(String[] args) {
        String str1="aab";
        String str2="xxy";
        System.out.println("Are the strings isomorphic? "+areIsomorphic(str1, str2));
    }

    //TC : O(|str1| + |str2|)
    static boolean areIsomorphic(String str1,String str2){
        if(str1.length()!=str2.length()) return false;

        int n=str1.length();
        boolean[] marked=new boolean[256];
        int[] map=new int[256];

        Arrays.fill(marked,false);
        Arrays.fill(map,-1);

        for(int i=0;i<n;i++){
            if(map[str1.charAt(i)]==-1){
                if(marked[str1.charAt(i)]==true) 
                    return false;
                marked[str1.charAt(i)]=true;
                map[str1.charAt(i)]=str2.charAt(i);
            }else if(map[str1.charAt(i)]!=str2.charAt(i)) 
                return false;
        }
        return true;
    }
}
