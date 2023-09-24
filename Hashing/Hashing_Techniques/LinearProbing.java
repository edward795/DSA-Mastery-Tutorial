package Hashing_Techniques;

public class LinearProbing {
    public static void main(String[] args) {
        int[] arr=new int[]{4,14,24,44};
        System.out.println("Hash Table after all the operations:");
        int[] res=LinearProbing(arr, 10, arr.length);
        for(int i=0;i<10;i++) 
            System.out.print(res[i]+" ");
    }
    
    static int[] LinearProbing(int[] arr,int hash_size,int array_size){
        int n=arr.length;
        int[] hash_table=new int[hash_size];
        for(int i=0;i<hash_size;i++)
            hash_table[i]=-1;

        for(int i=0;i<array_size;i++){
            if(hash_table[arr[i]%hash_size]==-1){
                hash_table[arr[i]%hash_size]=arr[i];
            }else{
                int counter=0;
                int k=arr[i]%hash_size;
                int flag=0;
                while(counter<hash_size && hash_table[k]!=-1){
                    if(hash_table[k]==arr[i]){
                        flag=1;
                        break;
                    }
                    k=(k+1)%hash_size;
                    counter++;
                }
                if(flag==0 && counter<hash_size)
                    hash_table[k]=arr[i];                
            }
        }
        return hash_table;
    }
}
