import java.util.Arrays;

public class UnionOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] a=new int[]{10,20,30,40,60};
        int[] b=new int[]{2,20,20,20};
        System.out.println("The union of arrays are:");
        unionOfArrays(a, b, a.length, b.length);
    }
    
    //Naive Solution : O(n^2)
    // static void unionOfArrays(int[] a,int[] b,int m,int n){
    //     int[] c=new int[m+n];

    //     for(int i=0;i<m;i++)
    //         c[i]=a[i];

    //     for(int i=0;i<n;i++)
    //         c[i+m]=b[i];

    //     Arrays.sort(c);
    //     for(int i=0;i<m+n;i++){
    //         if(i>0 && c[i]==c[i-1])
    //             continue;
    //         else
    //             System.out.print(c[i]+" ");
            
    //     }  
    // }

    //Efficient Solution : O(n)
    static void unionOfArrays(int[] a,int[] b,int m,int n){
        int i=0,j=0;
        while(i<m && j<n){
            if(i>0 && a[i]==a[i-1]) continue;
            if(j>0 && b[j]==b[j-1]) continue;
            
            if(a[i]<b[j]){
                System.out.print(a[i]+" ");
                i++;
            }
            else if(a[i]>b[j]){
                System.out.print(b[j]+" ");
                j++;
            }
            else{
                System.out.print(a[i]+" ");
                i++;
                j++;
            }
        }

        while(i<m){
            if(i>0 && a[i]!=a[i-1]){
                System.out.print(a[i]+" ");
                i++;
            }
        }

        while(j<n){
            if(j>0 && b[j]!=b[j-1]){
                System.out.print(b[j]+" ");
                j++;
            }
        }
    }
}
