public class FindSubStringsEndingWithOne{
    public static void main(String[] args) {
        String str="1101";
        System.out.println("The count of substrings that start with 1 & end with 1 is:"+countSubStrings(str));
    }

    //Naive Soln : O(n^2)
    // static int countSubStrings(String str){
    //     int n=str.length();
    //     int count=0;
    //     for(int i=0;i<n;i++){
    //         for(int j=i;j<n;j++){
    //             if(str.charAt(i)=='1' && str.charAt(j)=='1' && j>i){
    //                 count++;
    //             }
    //         }
    //     }
    //     return count;
    // }

    //Efficient Soln : O(n)
    static int countSubStrings(String str){
        int n=str.length();
        int count=0;
        for(int i=0;i<n;i++){
            if(str.charAt(i)=='1') 
                count++;
        }

        return count*(count-1)/2;
    }
}