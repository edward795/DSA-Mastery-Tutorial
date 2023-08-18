public class LCM {
    public static void main(String[] args) {
        int a=12,b=15;
        System.out.println("Lcm of "+a+" and "+b+" : "+lcm(a,b));

    }
    //Naive soln
    // public static int lcm(int a,int b){
    //     int res=(int)Math.max(a,b);
    //     while(true){
    //         if(res%a==0 && res%b==0){
    //             return res;
    //         }
    //         res++;
    //     }
    // }

    //Efficient Soln 
    public static int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }

    public static int lcm(int a,int b){
        return (a*b)/gcd(a,b);
    }
}
