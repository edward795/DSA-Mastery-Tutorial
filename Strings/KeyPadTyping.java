public class KeyPadTyping{

    public static void main(String[] args) {
        String str="geeks";
        System.out.println("Matching decimal repr as per telephone dialpad is "+printNumber(str, str.length()));
    }
    
    //TC : O(n)
    static String printNumber(String str,int n){
        String res="";
        for(int i=0;i<n;i++){
            if(str.charAt(i)=='a' || str.charAt(i)=='b' || str.charAt(i)=='c')
                res+="2";
            else if(str.charAt(i)=='d' || str.charAt(i)=='e' || str.charAt(i)=='f')
                res+="3";
            else if(str.charAt(i)=='g' || str.charAt(i)=='h' || str.charAt(i)=='i')
                res+="4";
            else if(str.charAt(i)=='j' || str.charAt(i)=='k' || str.charAt(i)=='l')
                res+="5";
            else if(str.charAt(i)=='m' || str.charAt(i)=='n' || str.charAt(i)=='o')
                res+="6";
            else if(str.charAt(i)=='p' || str.charAt(i)=='q' || str.charAt(i)=='r' || str.charAt(i)=='s')
                res+="7";
            else if(str.charAt(i)=='t' || str.charAt(i)=='u' || str.charAt(i)=='v')
                res+="8";
            else if(str.charAt(i)=='w' || str.charAt(i)=='x' || str.charAt(i)=='y' || str.charAt(i)=='z') 
                res+="9";
        }
        return res;
    }
}