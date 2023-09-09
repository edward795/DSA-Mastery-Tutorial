import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingCollectionsOne {
    public static void main(String[] args) {
        Integer[] arr=new Integer[]{20,10,12,45,3};
        printArray(arr);
        
        //Sorting non-primitive Integer Array using Collections api
        Arrays.sort(arr,Collections.reverseOrder());
        printArray(arr);

        //Sorting Collections containers
        List<Integer> list=new ArrayList<>();
        list.add(20);
        list.add(12);
        list.add(45);
        list.add(3);
        list.add(1);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list,Collections.reverseOrder());
        System.out.println(list);
    }

    static void printArray(Integer[] arr){
        for(Integer i:arr)
            System.out.print(i+" ");
        System.out.println();
    }
}
