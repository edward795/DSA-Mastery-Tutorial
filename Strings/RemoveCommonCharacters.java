import java.util.HashMap;

public class RemoveCommonCharacters {
    public static void main(String[] args) {
        String s1="aacdb";
        String s2="gafd";
        System.out.println("String formed after removing common characters : "+concatenateUncommon(s1, s2));
    }
    //TC : O(n)
    static String concatenateUncommon(String s1,String s2){
        HashMap<Character,Integer> h=new HashMap<>();
        for(int i=0;i<s1.length();i++)
            h.put(s1.charAt(i),h.getOrDefault(s1.charAt(i), 0)+1);

        String res="";
        for(int i=0;i<s2.length();i++){
            if(!h.containsKey(s2.charAt(i))){
                res+=s2.charAt(i);
            }else{
                h.put(s2.charAt(i),h.getOrDefault(s2.charAt(i), 0)+1);
            }
        }

        for(int i=0;i<s1.length();i++){
            if(h.get(s1.charAt(i))==1) 
                res+=s1.charAt(i);
        }
        return res;
    }
}
