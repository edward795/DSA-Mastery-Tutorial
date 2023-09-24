package Hashing_Techniques;

public class QuadraticProbing {
    public static void main(String[] args) {
        int[] arr=new int[]{4,14,24,44};
        int[] res=quadraticProbing(arr, 11, arr.length);
        for(int i:res) 
            System.out.print(i+" ");
    }
    static int[] quadraticProbing(int[] arr,int hash_size,int array_size){
        int[] hash_table=new int[hash_size];
        for(int i=0;i<hash_size;i++)
            hash_table[i]=-1;

        for(int i=0;i<array_size;i++){
            if(hash_table[arr[i]%hash_size]==-1){
                hash_table[arr[i]%hash_size]=arr[i];
            }else{
                int k=arr[i]%hash_size;
                int power=0;
                boolean flag=true;
                while(hash_table[k+power*power]%hash_size!=-1){
                    if(hash_table[(k+power*power)%hash_size]==arr[i]){
                        flag=false;
                        break;
                    }
                    power++;
                }

                if(flag){
                    hash_table[(k+power*power)%hash_size]=arr[i];
                }
            }
        }
        return hash_table;
    }
}
