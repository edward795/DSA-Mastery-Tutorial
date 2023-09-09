
import java.util.Arrays;

public class SortingNonPrimitivesOne {
    public static void main(String[] args) {
        Point[] arr=new Point[]{new Point(12,11),new Point(3,4),new Point(5,6),new Point(8,9),new Point(5,6)};
        printArray(arr);

        //sort using comparable
        Arrays.sort(arr);
        printArray(arr);
    }

    static void printArray(Point[] parr){
        for(Point p:parr){
            System.out.print("{"+p.x+":"+p.y+"}");
        }
        System.out.println();
    }
}


class Point implements Comparable<Point>{
    int x,y;

    Point(int x,int y){
        this.x=x;
        this.y=y;
    }

    public int compareTo(Point p){
        return this.x-p.x;
    }
}
