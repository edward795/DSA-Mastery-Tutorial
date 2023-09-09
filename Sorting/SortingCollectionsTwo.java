import java.util.*;
public class SortingCollectionsTwo {
    public static void main(String[] args) {
        List<Point> list=new ArrayList<Point>();
        list.add(new Point(12,11));
        list.add(new Point(3,4));
        list.add(new Point(5,6));
        list.add(new Point(8,9));
        list.add(new Point(5,6));
        System.out.println(list);
        
        //Sorting list constainer using Comparable
        Collections.sort(list);
        System.out.println(list);
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
}
