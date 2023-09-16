import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeOveralappingIntervals {
    public static void main(String[] args) {
        Point[] arr=new Point[]{new Point(1,3),new Point(2,4),new Point(5,7),new Point(6,8)};

        System.out.println("New list after merging overlapping intervals:");
        MergeOveralappingIntervals(arr);
    }
    
    //Efficient Soln : O(nlogn)
    static void MergeOveralappingIntervals(Point[] arr){
        Arrays.sort(arr,new MyCmp());
        int res=0;
        for(int i=1;i<arr.length;i++){
            if(arr[res].y>=arr[i].x){
                arr[res].y=Math.max(arr[i].y,arr[res].y);
                arr[res].x=Math.min(arr[i].x,arr[res].x);
            }else{
                res++;
                arr[res]=arr[i];
            }
        }

        for(int i=0;i<=res;i++)
            System.out.print(arr[i].x+":"+arr[i].y+" ");
    }
}

class MyCmp implements Comparator<Point>{
    public int compare(Point p1,Point p2){
        return p1.x-p2.x;
    }
}
