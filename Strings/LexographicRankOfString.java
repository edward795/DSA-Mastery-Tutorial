import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LexographicRankOfString {
    public static void main(String[] args) {
        String str="CBA";
        System.out.println("Lexographic Rank is:"+getLexographicRank(str));
    }

    //Naive Soln : O(n*n!) - O(r-l)
    // static int getLexographicRank(String input){
    //     ArrayList<String> arr=new ArrayList<>();

    //     permute(input,0,input.length()-1,arr);
    //     Collections.sort(arr,(a,b)->a.compareTo(b));

    //     for(int i=0;i<arr.size();i++){
    //         if(arr.get(i).equalsIgnoreCase(input)){
    //             return i+1;
    //         }
    //     }
    //     return -1;
    // }

    // static ArrayList<String> permute(String str,int len,int r,ArrayList<String> res){
    //     if(len==r){
    //         res.add(str);
    //     }else{
    //         for(int i=len;i<=r;i++){
    //             str=swap(str,len,i);
    //             permute(str,len+1,r,res);
    //             str=swap(str,len,i);
    //         }
    //     }
    //     return res;
    // }

    // static String swap(String str,int i,int j){
    //     char[] res=str.toCharArray();
    //     char temp=res[i];
    //     res[i]=res[j];
    //     res[j]=temp;
    //     return String.valueOf(res);
    // }

    //Efficient Solution :O(n) -O(CHAR)~=O(1)
    static int getLexographicRank(String str){
        int n=str.length();
        int[] count=new int[256];
        for(int i=0;i<n;i++)
            count[str.charAt(i)]++;

        for(int i=1;i<256;i++)
            count[i]+=count[i-1];

        int res=1,mul=factorial(n);
        for(int i=0;i<n;i++){
            mul=mul/(n-i);
            res+=count[str.charAt(i)-1]*mul;
            for(int j=str.charAt(i);j<256;j++)
                count[j]--;
        }
        return res;
    }

    static int factorial(int n){
        int fact=1;
        for(int i=1;i<=n;i++)
            fact*=i;
        return fact;
    }
}
