import java.util.Arrays;
import java.util.Comparator;

public class SortingNonPrimitivesTwo {
    public static void main(String[] args) {
        Point[] arr=new Point[]{new Point(12,11),new Point(3,4),new Point(5,6),new Point(8,9),new Point(5,6)};
        printArray(arr);

        //Sort using Comparator
        Arrays.sort(arr,new MyComparator());
        printArray(arr);

    }

    static void printArray(Point[] parr){
        for(Point p:parr){
            System.out.print("{"+p.x+":"+p.y+"} ");
        }
        System.out.println();
    }
}

class Point{
    int x,y;

    Point(int x,int y){
        this.x=x;
        this.y=y;
    }
}

class MyComparator implements Comparator<Point>{
    public int compare(Point p1,Point p2){
        return p1.x-p2.x;
    }
}