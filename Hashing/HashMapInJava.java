package Hashing;

import java.util.HashMap;
import java.util.Map;

public class HashMapInJava {
    public static void main(String[] args) {
        HashMap<String,Integer> hm=new HashMap<>();
        hm.put("Apple",3);
        hm.put("orange",5);
        hm.put("grapes",10);
        hm.put("guava",12);

        if(hm.containsKey("Apple"))
            System.out.println("Apple is present");
        else 
            System.out.println("Apple is not present");

        hm.remove("Apple");
        System.out.println("size:"+hm.size()); 

        if(hm.containsValue(10)) 
            System.out.println("10 is present");
        else 
            System.out.println("10 is not present");


        System.out.println("No of guava is:"+hm.get("guava"));
        System.out.println("No of orange is:"+hm.get("orange"));

        //iterating through keys & values
        for(Map.Entry<String,Integer> i:hm.entrySet()){
            String key=i.getKey();
            Integer value=i.getValue();
            System.out.println(key+":"+value);
        }

        //iterating through keys alone
        for(String i:hm.keySet()) 
            System.out.print(i+",");
            
        //iterating through values
        for(Integer i:hm.values()) 
            System.out.print(i+",");
    }
}
