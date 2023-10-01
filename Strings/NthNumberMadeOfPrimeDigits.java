public class NthNumberMadeOfPrimeDigits {
    public static void main(String[] args) {
        int n=10;
        System.out.println("nth prime number with 2,3,5,7 as digits are "+primeDigits(n));
    }

    //Naive Soln : O(n)
    // static int primeDigits(int n){
    //     int[] ans=new int[1000];
    //     int[] a=new int[]{2,3,5,7};
    //     ans[0]=2;
    //     ans[1]=3;
    //     ans[2]=5;
    //     ans[4]=7;

    //     int k=4;

    //     for(int i=22;i<2300;i++){
    //         int p=i,count=0,digits=0;
    //         while(p!=0){
    //             digits++;
    //             int r=p%10;
    //             p=p/10;
    //             for(int j=0;j<4;j++){
    //                 if(r==a[j]){
    //                     count++;
    //                     break;
    //                 }
    //             }
    //         }
    //         if(count==digits){
    //             ans[k++]=i;
    //         }else{
    //             continue;
    //         }
    //     }

    //     return ans[n-1];
    // }


    //Efficient Soln : O(n) - O(n)
    static String primeDigits(int n){
        String ans="";
        int rem=0;
        while(n>0){
            rem=n%4;
            switch(rem){
                case 1: 
                    ans+='2';
                    break;
                case 2:
                    ans+='3';
                    break;
                case 3: 
                    ans+='5';
                    break;
                case 0:
                    ans+='7';
                    break;
            }
            if(n%4==0)
                n--;
            n=n/4;
        }
        return new StringBuilder(ans).reverse().toString();
    }
}
