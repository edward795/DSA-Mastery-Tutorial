public class ComputingPower {
    public static void main(String[] args) {
       int x=2,y=6;
       System.out.println("Power of "+x+" raised to "+y+" is "+power(x,y));
    }
    
    //Naive Soln - O(n) -O(1)
    // public static int power(int x,int y){
    //     int res=1;
    //     for(int i=0;i<y;i++){
    //         res=res*x;
    //     }
    //     return res;
    // }

    //Efficient Soln-recursive - O(logn) - O(1)
    // public static int power(int x,int y){
    //     if(y==0) return 1;
    //     int temp=power(x,y/2);
    //     temp=temp*temp;
    //     if(y%2==0) 
    //         return temp;
    //     else 
    //         return temp*x;
    // }

    //Best Soln-Binary Exponentiation - O(logn) - O(1)
   public static int power(int x,int n){
        int res=1;
        while(n>0){
            if(n%2!=0)
                res=res*x;
            x=x*x;
            n=n/2;
        }
        return res;
    }
}
