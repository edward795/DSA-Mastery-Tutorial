import java.util.HashMap;

public class MinimumIndexOfCharInPattern {
    public static void main(String[] args) {
        String txt="geeksforgeeks";
        String pat="set";
        System.out.println("The min index pattern is "+getMinIndexPattern(txt, pat));
    }

    //TC : O(n)
    static int getMinIndexPattern(String txt,String pat){
        int n=txt.length(),m=pat.length();
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            if(!hm.containsKey(txt.charAt(i))) 
                hm.put(txt.charAt(i),i);
        }

        int min=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            if(hm.containsKey(pat.charAt(i)) && hm.get(pat.charAt(i))<min){
                min=hm.get(pat.charAt(i));
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}
