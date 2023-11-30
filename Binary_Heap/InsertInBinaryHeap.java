package Binary_Heap;

public class InsertInBinaryHeap {
    public static void main(String[] args) {

    }
}

class MinHeap {
    int[] arr;
    int capacity;
    int size;

    MinHeap(int c) {
        arr = new int[c];
        capacity = c;
        size = 0;
    }

    int left(int i) {
        return 2 * i + 1;
    }

    int right(int i) {
        return 2 * i + 2;
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    // TC : O(log(size))
    void insert(int x) {
        if (size == capacity)
            return;
        arr[size++] = x;

        for (int i = size - 1; i != 0 && arr[parent(i)] > arr[i];) {
            swap(arr, i, parent(i));
            i = parent(i);
        }
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
