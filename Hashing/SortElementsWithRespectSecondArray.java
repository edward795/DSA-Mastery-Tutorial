import java.util.HashMap;

public class SortElementsWithRespectSecondArray {
    public static void main(String[] args) {
        int[] arr1=new int[]{2,1,2,5,7,1,9,3,6,8,8};
        int[] arr2=new int[]{2,1,8,3};
        int[] res=sortBy2ndArray(arr1, arr2);

        for(int i=0;i<res.length;i++) 
            System.out.print(res[i]+" ");
    }

    //TC : O(n)
    static int[] sortBy2ndArray(int[] arr1,int[] arr2){
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<arr1.length;i++){
            hm.put(arr1[i],hm.getOrDefault(arr1[i], 0)+1);
        }

        int idx=0;
        int[] res=new int[arr1.length];
        for(int i=0;i<arr2.length;i++){
            if(hm.containsKey(arr2[i])){
                for(int j=0;j<hm.get(arr2[i]);j++){
                    res[idx++]=arr2[i];
                }
                hm.remove(arr2[i]);
            }
        }


        for(Integer i:hm.keySet()){
            for(int j=0;j<hm.get(i);j++){
                res[idx++]=i;
            }
        }
        return res;
    }
}

