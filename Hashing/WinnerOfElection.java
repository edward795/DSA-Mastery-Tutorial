import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WinnerOfElection {
    public static void main(String[] args) {
        String[] ballot=new String[]{"john","johny","jackie","johny","john","jackie","jamie","john","johny","jamie","johny","john"};
        int n=13;
        System.out.println("The winner of election : "+winner(ballot));
    }
    
    //Naive Soln : O(n^2)
    // static String winner(String[] arr){
    //     String res="";
    //     int mx=0,count=0;
    //     for(int i=0;i<arr.length;i++){
    //         for(int j=0;j<arr.length;j++){
    //             if(i!=j && arr[i].compareTo(arr[j])==0){
    //                 count++;
    //                  res=arr[i];
    //             }else{
    //                 if(count>mx){
    //                     mx=count;
    //                     if(arr[i].compareTo(arr[j])>0)
    //                         res=arr[j];
    //                     else 
    //                         res=arr[i];
    //                 }
    //             }
    //         }
    //     }
    //     return res;
    // }

    //Better Soln : O(nlogn)
    // static String winner(String[] arr){
    //     Arrays.sort(arr,(s1,s2)-> s1.compareTo(s2));
    //     String res="";
    //     int count=0,mx=0;
    //     for(int i=1;i<arr.length;i++){
    //         if(arr[i].compareTo(arr[i-1])==0){
    //             count++;
    //              res=arr[i-1];
    //         }else{
    //             if(count>mx){
    //                 mx=count;
    //                 if(arr[i-1].compareTo(arr[i])>0){
    //                     res=arr[i];
    //                 }else{
    //                     res=arr[i-1];
    //                 }
    //             }
    //         }
    //     }
    //     return res;
    // } 

    //Efficient Soln : O(n) - O(n)
    static String winner(String[] arr){
        HashMap<String,Integer> hm=new HashMap<>();
        String res="";
        int mx=0;
        for(int i=0;i<arr.length;i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }

        for(Map.Entry<String,Integer> i:hm.entrySet()){
            String key=i.getKey();
            int value=i.getValue();
            if(value>mx){
                mx=value;
                res=key;
            }else if(value==mx && res.compareTo(key)>0){
                res=key;
            }
        }

        return res+" : "+mx;
    }
}


// class StringComparator extends Comparator<String>{
//     public int compare(String s1,String s2){
//         return s1.compareTo(s2);
//     }
// }
