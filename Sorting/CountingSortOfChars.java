public class CountingSortOfChars {
    public static void main(String[] args) {
        String str="apple";
        System.out.println("New string after lexicographic sorting:"+sortLexicographically(str));
    }
    
    //TC : O(n)
    static String sortLexicographically(String st){
        char[] chars=st.toCharArray();
        int[] count=new int[256];
        char[] output=new char[chars.length];

        for(int i=0;i<chars.length;i++){
            count[chars[i]]++;
        }

        for(int i=1;i<256;i++){
            count[i]+=count[i-1];
        }

        for(int i=0;i<chars.length;i++){
            output[count[chars[i]]-1]=chars[i];
            count[chars[i]]--;
        }


        for(int i=0;i<chars.length;i++){
            chars[i]=output[i];
        }

        return new String(chars);
    }
}
