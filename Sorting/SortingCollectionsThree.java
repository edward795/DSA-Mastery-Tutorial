import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingCollectionsThree {
    public static void main(String[] args) {
                List<Point> list=new ArrayList<Point>();
        list.add(new Point(12,11));
        list.add(new Point(3,4));
        list.add(new Point(5,6));
        list.add(new Point(8,9));
        list.add(new Point(5,6));
        printList(list);
        
        //Sorting list constainer using Comparable
        Collections.sort(list,new MyComparator());
        printList(list);
    }


    static void printList(List<Point> list){
        for(Point p:list)
            System.out.print("("+p.x+" : "+p.y+"),");
        System.out.println();
    }
}

class Point{
    int x,y;

    Point(int x,int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }
    
  
}

class MyComparator implements Comparator<Point>{
    public int compare(Point p1,Point p2){
        return p1.x-p2.x;
    }
}