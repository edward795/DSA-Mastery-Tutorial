import java.util.ArrayList;

public class Isogram {
    public static void main(String[] args) {
        String str="machine";
        System.out.println("Is the string isogram ? "+isIsogram(str));
    }

    //TC : O(n)
    static boolean isIsogram(String str){
        ArrayList<Character> arr=new ArrayList<>();
        char[] k=str.toCharArray();

        for(int i=0;i<k.length;i++){
            if(arr.contains(k[i]))
                return false;
            else 
                arr.add(k[i]);
        }
        return true;
    }
}
