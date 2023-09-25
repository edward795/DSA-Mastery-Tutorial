import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortByFrequency {
    public static void main(String[] args) {
        int[] arr=new int[]{5,5,4,6,4};
        System.out.println("After sorting by freq:");
        sortByFreq(arr, arr.length);
    }

    //TC : O(nlogn) - Hashing + Sorting
    // static ArrayList<Integer> sortByFreq(int[] arr,int n){
    //     HashMap<Integer,Integer> hm=new HashMap<>();
    //     for(int i=0;i<n;i++){
    //         hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
    //     }

    //     List<Map.Entry<Integer,Integer>> set=new ArrayList<Map.Entry<Integer,Integer>>(hm.entrySet());
    //     Collections.sort(set,new FreqComparator());

    //     ArrayList<Integer> ans=new ArrayList<>();
    //     for(int i=0;i<hm.size();i++){
    //         int count=set.get(i).getValue();
    //         while(count>=0){
    //             ans.add(set.get(i).getKey());
    //             count--;
    //         }
    //         hm.remove(set.get(i).getKey());
    //     }
    //     return ans;
    // }

    //Naive Soln :O(nlogn) - O(n)
    static void sortByFreq(int[] arr,int n){
        ArrayList<ele> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            ele e=new ele();
            e.count=0;
            e.index=i;
            e.value=arr[i];
            res.add(e);
        }

        Collections.sort(res,new ValueComparator());

        res.get(0).count=1;
        for(int i=1;i<n;i++){
            if(res.get(i).value==res.get(i-1).value){
                res.get(i).count+=1;
                res.get(i-1).count=-1;
                res.get(i).index=res.get(i-1).index;
            }else{
                res.get(i).count=1;
            }
        }

        Collections.sort(res,new CountComparator());
        
        int idx=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<res.get(i).count;j++){
                arr[idx++]=res.get(i).value;
            }
        }
    }
}


class ele{
    int count,index,value;

    public ele(){

    }

    public ele(int count,int index,int value){
        this.count=count;
        this.index=index;
        this.value=value;
    }
}


class CountComparator extends Comparator<ele>{
    public int compare(ele e1,ele e2){
        if(e1.count==e2.count){
            return e1.index-e2.index;
        }else{
            return e1.count-e2.count;
        }
    }
}


class ValueComparator extends Comparator<ele>{
    public int compare(ele e1,ele e2){
        return e1.value-e2.value;
    }
}

// class FreqComparator extends Comparator<Map.Entry<Integer,Integer>>{
//     public int compare(Map.Entry<Integer,Integer> o1,Map.Entry<Integer,Integer> o2){
//         if(o1.getValue()==o2.getValue()){
//             return o1.getKey()-o2.getKey();
//         }else{
//             return o1.getValue()-o2.getValue();
//         }
//     }
// }
