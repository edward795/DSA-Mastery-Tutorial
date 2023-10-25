package Queue;

public class CircularTourOfPetrolPumps {
    public static void main(String[] args) {
        int n=4;
        int[] petrol=new int[]{4,6,7,4};
        int[] distance=new int[]{6,5,3,5};
        System.out.println("The feasible starting point is "+getTheStartingPoint(n, petrol, distance));
    }

    //TC : O(n^2) - O(1)
    // static int getTheStartingPoint(int n,int[] petrol,int[] distance){
    //     for(int i=0;i<n;i++){
    //       boolean flag=true;
    //       if(petrol[i]>=distance[i]){
    //             int deficit=petrol[i]-distance[i];
    //         for(int j=i+1;j<n;j++){
    //             if(deficit+petrol[j]>=distance[j]){
    //                 flag=true;
    //             }else{
    //                 flag=false;
    //                 break;
    //             }
    //             deficit+=(petrol[j]-distance[j]);
    //         }
    //         if(flag) return i;
    //       }
    //     }
    //     return -1;
    // }

    //Efficient Soln  : O(n) - O(1)
    // static int getTheStartingPoint(int n,int[] petrol,int[] distance){
    //     int start=0,deficit=0,capacity=0;
    //     for(int i=0;i<n;i++){
    //         capacity+=petrol[i]-distance[i];
    //         if(capacity<0){
    //             start=i+1;
    //             deficit+=capacity;
    //             capacity=0;
    //         }
    //     }

    //     return deficit+capacity>=0?start:-1;
    // }


    //Best Soln  : O(n) - O(1) - the array inplace is being considered as queue by using start & end pointers
    static int getTheStartingPoint(int n,int[] petrol,int[] distance){
        int start=0,end=1;
        int curr_petrol=petrol[start]-distance[start];
        while(end!=start || curr_petrol<0){
            while(curr_petrol<0 && start!=end){
                curr_petrol-=petrol[start]-distance[start];
                start=(start+1)%n;
                if(start==0) return -1;
            }
            curr_petrol+=petrol[end]-distance[end];
            end=(end+1)%n;
        }
        return start;
    }
}
