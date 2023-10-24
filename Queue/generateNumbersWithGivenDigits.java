package Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class generateNumbersWithGivenDigits {
    public static void main(String[] args) {
        generateNumbers(10);
    }

    //Efficient Soln : O(n) -O(n)
    static void generateNumbers(int n){
        Queue<String> q=new ArrayDeque<>();
        q.offer("5");
        q.offer("6");
        for(int i=0;i<n;i++){
            String curr=q.peek();
            System.out.print(curr+" ");
            q.poll();
            q.offer(curr+"5");
            q.offer(curr+"6");
        }
    }
}
