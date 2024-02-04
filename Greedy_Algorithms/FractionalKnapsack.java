package Greedy_Algorithms;
import java.lang.Comparable;
import java.util.Arrays;

public class FractionalKnapsack {
    public static void main(String[] args) {
        Item[] items=new Item[]{new Item(10,200),new Item(5,50),new Item(20,100)};
        System.out.println("Max KnapSack Capacity is : "+fracKnapSack(items, 15));
    }

    //TC : O(nlogn)
    static double fracKnapSack(Item[] arr,int W){
        Arrays.sort(arr);
        double res=0.0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].wt<=W){
                res=res+arr[i].value;
                W=W-arr[i].wt;
            }else{
                res=res+arr[i].value*(double)W/(double)arr[i].wt;
                break;
            }
        }
        return res;
    }
}


class Item extends Comparable<Item>{
    int wt,value;

    Item(int wt,int value){
        this.wt=wt;
        this.value=value;
    }
    public int compareTo(Item i){
        return this.wt*i.value-i.wt*this.value;
    }
}
