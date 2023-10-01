public class ModifiedString {
    public static void main(String[] args) {
        String str="aabbbcc";
        System.out.println("no of modifications needed is "+countMods(str));
    }

    //TC : O(n)
    static int countMods(String str){
        int count=1,ans=0;
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==str.charAt(i-1)){
                count++;
            }else{
                ans+=(count-1)/2;
                count=1;
            }
        }
        return ans+(count-1)/2;
    }
}
