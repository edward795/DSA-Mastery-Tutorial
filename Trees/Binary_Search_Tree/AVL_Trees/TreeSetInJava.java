package Trees.Binary_Search_Tree.AVL_Trees;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetInJava {
    public static void main(String[] args) {
        TreeSet<String> t=new TreeSet<>();
        t.add("gfg");
        t.add("courses");
        t.add("ide");
        t.add("apple");
        System.out.println(t);
        Iterator<String> it=t.iterator();
        while(it.hasNext())
            System.out.println(it.next());
        
        for(String s:t)
            System.out.print(s+" ");

        TreeSet<Integer> set=new TreeSet<>();
        set.add(2);
        set.add(7);
        set.add(12);
        set.add(15);
        set.add(21);
        System.out.println();
        System.out.println(set.lower(9));
        System.out.println(set.higher(17));
        System.out.println(set.floor(13));
        System.out.println(set.ceiling(19));
    }
}
