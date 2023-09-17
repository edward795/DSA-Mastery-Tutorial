import java.util.Arrays;
import java.util.Comparator;

import utils.Print;

public class SortByAbsoluteDiffWithK {
    public static void main(String[] args) {
        int[] arr=new int[]{10,5,3,9,2};
        int k=7,n=arr.length;
        
        System.out.println("New Array after sorting:");
        sortABS(arr, n, k);
        Print pr=new Print();
        pr.printArray(arr, n);

    }

    static void sortABS(int[] arr,int n,int k){
        Pair[] p=new Pair[n];
        for(int i=0;i<n;i++){
            p[i]=new Pair(arr[i],Math.abs(arr[i]-k));
        } 
        
        //Using anonymous class syntax 
        Arrays.sort(p,new Comparator<Pair>(){
            @Override
            public int compare(Pair p1,Pair p2){
                return p1.y-p2.y;
            }
        });

        //Easy syntax using lambda
        // Arrays.sort(p,(p1,p2)->p1.y-p2.y);

        for(int i=0;i<n;i++){
            arr[i]=p[i].x;
        }
    }
}

class Pair{
    int x,y;
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}