public class IntersectionOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] a = new int[] { 3, 5, 10, 10, 10, 15, 15, 20 };
        int[] b = new int[] { 5, 10, 10, 15, 30 };

        System.out.println("Intersection of 2 arrays:");
        intersection(a, b, a.length, b.length);

    }

    //Efficient Solution : O(n)
    static void intersection(int[] a,int[] b,int m,int n){
        int i=0,j=0;
        while(i<m && j<n){
            if(i>0 && a[i]==a[i-1]){
                i++;
                continue;
            }
            if(a[i]<b[j]) i++;
            else if(a[i]>b[j]) j++;
            else{
                System.out.print(a[i]+" ");
                i++;
                j++;
            }
        }
    }

    // Naive Solution : O(n^2)
    // static void intersection(int[] a, int[] b, int m, int n) {
    //     for (int i = 0; i < m; i++) {
    //         if (i > 0 && a[i] == a[i - 1]) {
    //             continue;
    //         }
    //         for (int j = 0; j < n; j++) {
    //             if (j > 0 && b[j] == b[j - 1])
    //                 continue;
    //             if (a[i] == b[j]) {
    //                 System.out.print(a[i] + " ");
    //             }
    //         }
    //     }
    // }
}
