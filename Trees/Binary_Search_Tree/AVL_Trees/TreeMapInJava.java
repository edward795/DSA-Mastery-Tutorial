package Trees.Binary_Search_Tree.AVL_Trees;

import java.util.TreeMap;

public class TreeMapInJava {
    public static void main(String[] args) {
        TreeMap<Integer,String> map=new TreeMap<Integer,String>();
        map.put(10,"geeks");
        map.put(12,"for");
        map.put(17,"apple");
        map.put(8,"grapes");
        map.remove(17);
        System.out.println(map.size());
        System.out.println(map.higherKey(10));
        System.out.println(map.lowerKey(13));
        System.out.println(map.floorKey(11));
        System.out.println(map.ceilingKey(15));

        System.out.println(map.higherEntry(10).getValue());
        System.out.println(map.lowerEntry(13).getValue());
        System.out.println(map.floorEntry(19).getValue());
        System.out.println(map.ceilingEntry(11).getValue());
    }
}
