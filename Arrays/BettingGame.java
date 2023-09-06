package Arrays;
/**
 * u are involved in a betting game whose rules are as follows :
a) if you win a round, the bet amount will be added to your sum and next bet amount will be $1;
b) if you lose a round, the bet amount will be reduced from your total sum and next bet will be twice the previous.
c) game ends when all the rounds are complete or you dont have sufficient sum.
 */
public class BettingGame {
    public static void main(String[] args) {
        String s="WLWWL";int sum=4;
        System.out.println("Balance after bet : "+betBalance(s, sum));
    }

    static int betBalance(String s,int bet){
        int balance=1,n=s.length();
        for(int i=0;i<n;i++){
            if("W".equals(s.charAt(i))){
                balance+=bet;
            }else{
                balance-=bet;
                bet*=2;
            }
             //If all trials are done or balance is less than bet amount
            if(balance<bet && i<n-2)
                balance=-1;
                break;
        }
        return balance;
    }
}
