package Strings;

public class BasicStringFunctions {
    public static void main(String[] args) {
        String str="geeksforgeeks";
        System.out.println(str.length());
        System.out.println(str.substring(2));
        System.out.println(str.substring(2, 5));
        System.out.println(str.charAt(4));

        String s1="Apple";
        String s2="Apple";
        String s3=new String("Apple");
        System.out.println(s1==s2);
        System.out.println(s1==s3);
        System.out.println(s1.equals(s3));

        String large="geeksforgeeks";
        String small="geeks";
        System.out.println(large.compareTo(small)>0);
        System.out.println(small.compareTo(large)<0);
        System.out.println(small.compareTo(large)==0);

        
    }
}
