package Arrays;
/**
 * Given n matchsticks and 2 players A & B,return how many matchsticks A should pick so that 
 * he is guaranteed to win else print not possible; 
 */
public class GameOfMatchSticks {
    public static void main(String[] args) {
        int n=48;
        System.out.println("No of matchsticks A should pick 1st to win? "+game(n));
    }

    static int game(int n){
        if(n%5>0) return n%5;
        else return -1;
    } 
}
