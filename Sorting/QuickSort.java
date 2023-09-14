import utils.Print;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr=new int[]{8,4,7,9,3,10,5};
        int n=arr.length;
        
        System.out.println("Array after sorting:");
        qSort(arr,0,n-1);

        Print pr=new Print();
        pr.printArray(arr, n);
        

    }

    //QuickSort using lomuto partition
    // static void qSort(int[] arr,int l,int h){
    //     if(l<h){
    //         int p=lomutoPartition(arr, l, h);
    //         qSort(arr,l,p-1);
    //         qSort(arr, p+1, h);
    //     }
    // }


    //QuickSort using Hoare's Partition
    static void qSort(int[] arr,int l,int h){
        if(l<h){
            int p=hoaresPartition(arr, l, h);
            qSort(arr, l, p);
            qSort(arr, p+1, h);
        }
    }

      //Lomuto Partition - O(n) -O(1)
      static int lomutoPartition(int[] arr,int l,int h){
        int pivot=arr[h];
        int i=l-1;
        for(int j=l;j<h;j++){
            if(arr[j]<pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,h);
        return i+1;
    }

    //Hoare's Partition : O(n) - O(1)
    static int hoaresPartition(int[] arr,int l, int h){
        int i=l-1,j=h+1;
        int pivot=arr[l];

        while(true){
            do{
                i++;
            }while(arr[i]<pivot);

            do{
                j--;
            }while(arr[j]>pivot);

            if(i>=j) return j;

            swap(arr,i,j);

        }
    }

    static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    
}
