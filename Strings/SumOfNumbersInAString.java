public class SumOfNumbersInAString {
    public static void main(String[] args) {
        String str="12abc20yz68";
        System.out.println("Sum of digits is "+findSum(str));
    }

    //TC : O(n)
    static int findSum(String str){
        int sum=0;
        String temp="0";
        for(int i=0;i<str.length();i++){
            if(Character.isDigit(str.charAt(i))){
                temp+=str.charAt(i);
            }else{
                sum+=Integer.parseInt(temp);
                temp="0";
            }
        }
        return sum+Integer.parseInt(temp);
    }
}
