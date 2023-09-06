package Arrays;

/**
 * Game of Chocolates | Wythoff’s Game
 */
public class GameOfChocolates {
    public static void main(String[] args) {
        int A=1,B=2;
        System.out.println("Dolly or Bonty Should start the game? "+ (game(A, B)?"Dolly":"Bonty"));
    }
    //TC : O(1) - O(1)
    static boolean game(int a,int b){
        if(a>b){
            int temp=a;
            a=b;
            b=temp;
        }

        int k=b-a;
        long d=1+(int)Math.sqrt(5);
        d/=2;
        d*=k;
        int c=(int)d;
        
        return (a==c)?false:true;
    }
}
