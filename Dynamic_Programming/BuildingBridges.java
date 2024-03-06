package Dynamic_Programming;

import java.util.Arrays;
import java.util.Comparator;

public class BuildingBridges {
    public static void main(String[] args) {
        Pair[] p=new Pair[]{new Pair(6,2),new Pair(4,3),new Pair(2,6),new Pair(1,5)};
        System.out.println("The max value of possible bridges : "+maxBridges(p, p.length-1));
    }

    //TC : O(n*n)
    static int maxBridges(Pair[] cities,int n){
        int[] lis=new int[n];
        Arrays.fill(lis,1);
        
        Arrays.sort(cities,new Mycmp());

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(cities[i].south>=cities[j].south){
                    lis[i]=Math.max(lis[i],1+lis[j]);
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
    int north,south;

    Pair(int north,int south){
        this.north=north;
        this.south=south;
    }
}

class Mycmp implements Comparator<Pair>{
    public int compare(Pair p1,Pair p2){
        if(p1.north==p2.north)
            return p2.south-p2.south;
        return p1.north-p2.north;
    }
} 