import utils.Print;

public class CycleSorting {
        
    //count number of memory writes
    static int writes = 0;
    public static void main(String[] args) {
        int[] arr=new int[]{20,40,50,10,30};
        cycleSort(arr, arr.length);

        Print pr=new Print();
        pr.printArray(arr, arr.length);

        System.out.println("No of memory writes:"+writes);
    }
    
    //TC : O(n^2)
    public static void cycleSort(int arr[], int n)
    {

 
        for (int cst = 0; cst <= n - 2; cst++) {
            int item = arr[cst];
 
            // count all smaller elements on right side of item.
            int pos = cst;
            for (int i = cst + 1; i < n; i++)
                if (arr[i] < item)
                    pos++;
 
            // If item is already in correct position
            if (pos == cst)
                continue;
 
            // ignore all duplicate elements
            while (item == arr[pos])
                pos += 1;
 
            // swap item to its position
            if (pos != cst) {
                int temp = item;
                item = arr[pos];
                arr[pos] = temp;
                writes++;
            }
 
            // Rotate rest of the cycle
            while (pos != cst) {
                pos = cst;
 
                // Find position where we put the element
                for (int i = cst + 1; i < n; i++)
                    if (arr[i] < item)
                        pos += 1;
 
                // ignore all duplicate elements
                while (item == arr[pos])
                    pos += 1;
 
                // swap item to its position
                if (item != arr[pos]) {
                    int temp = item;
                    item = arr[pos];
                    arr[pos] = temp;
                    writes++;
                }
            }
        }
    }
}
