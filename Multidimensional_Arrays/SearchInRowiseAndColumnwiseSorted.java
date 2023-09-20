package Multidimensional_Arrays;

public class SearchInRowiseAndColumnwiseSorted {
    public static void main(String[] args) {
        int[][] arr=new int[][]{{10,20,30,40},{15,25,35,45},{27,29,37,48},{32,33,39,50}};
        int key=29;
        findElement(arr, key);
    }

    //Naive Soln : O(n*m)
    // static void findElement(int[][] arr,int key){
    //     int n=arr.length,m=arr[0].length;
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<m;j++){
    //             if(arr[i][j]==key){
    //                 System.out.printf("Element Found at coordinates (%s,%s)",i,j);
    //             }
    //         }
    //     }
    //     System.out.println("Element not found");
    // }
    
    //Efficient Soln : O(R+C)
    static void findElement(int[][] mat,int key){
        int n=mat.length,m=mat[0].length;
        int rowp=0,colp=m-1;

        while(rowp<n && colp>=0){
            if(mat[rowp][colp]==key){
                System.out.printf("Element found at coordinates (%s %s)",rowp,colp);
                return;
            }else if(mat[rowp][colp]>key){
                colp--;
            }else{
                rowp++;
            }
        }
        System.out.println("Element not found");
    }
}
