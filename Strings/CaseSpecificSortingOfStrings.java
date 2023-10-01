import java.util.Arrays;

public class CaseSpecificSortingOfStrings {
    public static void main(String[] args) {
        String str="defRTSersUXl";
        System.out.println("String after case specific sorting is "+sortSpecific(str));
    }

    //TC : O(n) - O(n)
    static String sortSpecific(String str){
        char[] chars=str.toCharArray();
        int lidx=0,uidx=0;
        for(char ch:chars){
            if(Character.isLowerCase(ch)) 
                lidx++;
            else
                uidx++;
        }
        int lowSize=lidx,upperSize=uidx;
        char[] lchars=new char[lowSize];
        char[] uchars=new char[upperSize];
        lidx=0;uidx=0;

        for(int i=0;i<str.length();i++){
            if(Character.isLowerCase(str.charAt(i)))
                lchars[lidx++]=str.charAt(i);
            else 
                uchars[uidx++]=str.charAt(i);
        }

        Arrays.sort(lchars);
        Arrays.sort(uchars);

        int midx=0;
        lidx=0;uidx=0;

        for(int i=0;i<chars.length;i++){
            if(Character.isLowerCase(chars[i])){
                chars[midx++]=lchars[lidx++];
            }else{
                chars[midx++]=uchars[uidx++];
            }
        }

        return new String(chars);
    }
}
