public class CountOfTriangles {
    public static void main(String[] args) {
        int[] arr=new int[]{6,4,9,7,8};
        System.out.println("Count of triangles:"+findNoOfTriangles(arr, arr.length));
    }
    
    //O(n^3)
    static int findNoOfTriangles(int[] arr,int n){
       int count=0;
       for(int i=0;i<n-2;i++){
        int k=i+2;
        for(int j=i+1;j<n-1;j++){
            while(k<n && arr[i]+arr[j]>arr[k]) 
                k++;
            if(k>j) 
                count+=k-j-1;
        }
       } 
       return count;
    }
}
