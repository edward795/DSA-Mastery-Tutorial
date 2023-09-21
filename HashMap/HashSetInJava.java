package HashMap;

import java.util.HashSet;
import java.util.Iterator;

//TC of all operations(search,insert,delete) is O(1)
public class HashSetInJava {
    public static void main(String[] args) {
        HashSet<String> set=new HashSet<>();
        set.add("apple");
        set.add("orange");
        set.add("pineapple");
        set.add("banana");

        Iterator<String> iter=set.iterator();
        while(iter.hasNext())
            System.out.print(iter.next() +",");

        System.out.println();
        System.out.println(set.size());
        set.remove("apple");
        System.out.println(set.size());

        for(String i:set) 
            System.out.print(i+",");

    }
}
