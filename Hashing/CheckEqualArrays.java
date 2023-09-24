import java.util.HashMap;
import java.util.Map;

public class CheckEqualArrays {
    public static void main(String[] args) {
        int[] arr1=new int[]{1,2,5,4,0};
        int[] arr2=new int[]{2,4,5,0,1};
        System.out.println("Are the two arrays equal ? "+equalArrays(arr1, arr2));
    }

    static boolean equalArrays(int[] arr1,int[] arr2){
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<arr1.length;i++){
            hm.put(arr1[i],hm.getOrDefault(arr1[i],0)+1);
        }

        for(int i=0;i<arr2.length;i++){
            hm.put(arr2[i],hm.getOrDefault(arr2[i],0)-1);
        }

        for(Integer i:hm.values()){
            if(i!=0) return false;
        }
        return true;
    }
}
