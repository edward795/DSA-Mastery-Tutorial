public class smallestWindowOfPattern {
    public static void main(String[] args) {
        String txt="timetopractice";
        String pat="toc";
        System.out.println("The smallest window of String is "+smallestWindowsOfChars(txt, pat));
    }

    // static boolean containsAll(String substr,String pat){
    //     int[] count=new int[256];
    //     for(int i=0;i<substr.length();i++)
    //         count[substr.charAt(i)]++;
    //     for(int i=0;i<pat.length();i++) 
    //         {
    //         if(count[pat.charAt(i)]>0)
    //             count[pat.charAt(i)]--;
    //         }

    //     for(int i=0;i<256;i++)
    //         if(count[i]>0) 
    //             return false;
    //     return true;
    // }
    
    // //Naive Soln : O(n^3)
    // static String smallestWindowsOfChars(String txt,String pat){
    //     int n=txt.length();
    //     int min=Integer.MAX_VALUE;
    //     String minStr="";
    //     for(int i=0;i<n;i++){
    //         for(int j=i;j<n;j++){
    //             String subStr=txt.substring(i, j+1);
    //                 if(containsAll(subStr, pat)){
    //                     int currLen=subStr.length();
    //                     if(currLen<min){
    //                         min=currLen;
    //                         minStr=subStr;
    //                     }
    //                 }
    //         }
    //     }
    //     return minStr;
    // }

        //Efficient Soln : O(|txt|)
        static String smallestWindowsOfChars(String txt,String pat){
           int[] hash_pat=new int[256];
           int[] hash_txt=new int[256];
           
           for(int i=0;i<pat.length();i++)
               hash_pat[pat.charAt(i)]++;
               
           int start=0,start_index=-1,min_len=Integer.MAX_VALUE,count=0;
           for(int j=0;j<txt.length();j++){
               hash_txt[txt.charAt(j)]++;
               
               if(hash_pat[txt.charAt(j)]!=0 && hash_txt[txt.charAt(j)]<=hash_pat[txt.charAt(j)]){
                   count++;
               }
               
               if(count==pat.length()){
                   while(hash_txt[txt.charAt(start)]>hash_pat[txt.charAt(start)] ||
                       hash_pat[txt.charAt(start)]==0){
                           if(hash_txt[txt.charAt(start)]>hash_pat[txt.charAt(start)]){
                               hash_txt[txt.charAt(start)]--;
                           }
                           start++;
                       }
                       
                       int len_window=j-start+1;
                       if(min_len>len_window){
                           min_len=len_window;
                           start_index=start;
                       }
               }
           }
           
           if(start_index==-1) return "No such substrig!!";
           
           return txt.substring(start_index,start_index+min_len);
        }
}
