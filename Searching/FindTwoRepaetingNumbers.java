public class FindTwoRepaetingNumbers {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,1,3,4,3};
        System.out.println("The two repeating elements are:"+arr[0]+","+arr[1]);
    }

    //TC : O(n)
    static int[] twoRepeated(int[] arr){
        int n=arr.length;
        int[] res=new int[2];
        boolean first=false;

        for(int i=0;i<n;i++){
            if(arr[Math.abs(arr[i])]>0){
                arr[Math.abs(arr[i])]=-arr[Math.abs(arr[i])];
            }else{
                if(first==false){
                    res[0]=Math.abs(arr[i]);
                    first=true;
                }else{
                    res[1]=Math.abs(arr[i]);
                    break;
                }
            }
        }
        return res;
    }
}
