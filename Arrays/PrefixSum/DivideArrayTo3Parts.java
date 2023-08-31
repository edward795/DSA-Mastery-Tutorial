package Arrays.PrefixSum;

public class DivideArrayTo3Parts {

    static int ind1=-1,ind2=-1;
    public static void main(String[] args) {
        int[] arr=new int[]{1,3,4,0,4};
        int n=arr.length;
        System.out.println("Is it possible to divide array into 3 equal parts:?"+(findSplit(arr, n)==1));
        System.out.println("The indexes are:"+ind1+" "+ind2);

    }

    static int findSplit(int[] arr,int n){
        int totalSum=0;
        for(int i=0;i<arr.length;i++)
            totalSum+=arr[i];
        
        if(totalSum%3!=0) return 0;
        int preSum=0;

        int S1=totalSum/3,S2=2*S1;

        for(int i=0;i<n;i++){
            preSum+=arr[i];

            if(preSum==S1 && ind1==-1) 
                ind1=i;

            else if(preSum==S2 && ind1!=-1){
                ind2=i;
                break;
            }
        }

        if(ind1==-1 && ind2==-1) return 0;

        return 1;
    }

}
