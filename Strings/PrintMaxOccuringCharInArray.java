public class PrintMaxOccuringCharInArray {
    public static void main(String[] args) {
        String str="geeksforgeeks";
        System.out.println("Maximum occurring character is "+maxOccurringChar(str));
    }

    //TC : O(n)
    static char maxOccurringChar(String str){
        int[] count=new int[26];
        char max='\u0000';
        int mx=-1;

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=' '){
                count[str.charAt(i)-'a']++;
            }
        }

        for(int i=0;i<26;i++){
            if(count[i]>mx){
                mx=count[i];
                max=(char)(i+'a');
            }
        }
        return max;
    }
}
