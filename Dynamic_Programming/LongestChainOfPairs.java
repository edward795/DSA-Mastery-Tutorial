package Dynamic_Programming;

import java.util.Arrays;
import java.util.Comparator;

public class LongestChainOfPairs {
    public static void main(String[] args) {
        Pair[] chains=new Pair[]{new Pair(2,24),new Pair(39,60),new Pair(15,28),new Pair(27,60),new Pair(50,90)};
        System.out.println("The max chain length : "+getLongestChainCount(chains, chains.length-1));
    }

    static int getLongestChainCount(Pair[] chains,int n){
        int[] lis=new int[n];
        Arrays.fill(lis,1);
        Arrays.sort(chains,new MyCmp());

        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                if(chains[i].x>chains[j].y){
                    lis[i]=Math.max(lis[i],1+lis[i]);
                }
            }
        }
        int max=lis[0];
        for(int i=0;i<n;i++) 
            max=Math.max(max,lis[i]);
        return max;
    }
}

class Pair{
    int x,y;

    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}

class MyCmp implements Comparator<Pair>{
    public int compare(Pair p1,Pair p2){
        return p1.x-p2.x;
    }
}
