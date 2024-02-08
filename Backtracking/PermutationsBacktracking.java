package Backtracking;

public class PermutationsBacktracking {
    public static void main(String[] args) {
        String str = "ABC";
        System.out.println("Permutations which do not contain AB are : ");
        permute(str, 0, str.length() - 1);
    }

    // Naive Soln : O(2^n)
    // static void permute(String str,int l,int r){
    // if(l==r){
    // if(!str.contains("AB")){
    // System.out.println(str);
    // return;
    // }
    // }else{
    // for(int i=l;i<=r;i++){
    // str=swap(str, l, i);
    // permute(str, l+1, r);
    // str=swap(str,l,i);
    // }
    // }
    // }

    static void permute(String str, int l, int r) {
        if (l == r) {
            System.out.println(str);
            return;
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    static String swap(String str, int i, int j) {
        char[] c = str.toCharArray();
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
        return new String(c);
    }

    boolean isSafe(String str, int l, int i, int r) {
        if (l != 0 && str.charAt(l - 1) == 'A' && str.charAt(i) == 'B')
            return false;

        if (r == (l + 1) && (str.charAt(i) == 'A' && str.charAt(l) == 'B')
                || r == l + 1 && l == i && (str.charAt(r) == 'B' && str.charAt(r) == 'A'))
            return false;

        return true;
    }
}
