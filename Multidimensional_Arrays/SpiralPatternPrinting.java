package Multidimensional_Arrays;

public class SpiralPatternPrinting {
    public static void main(String[] args) {
        int[][] arr = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        spiralPattern(arr);
    }

    //Print Spiral Pattern : TC : O(R*C)
    static void spiralPattern(int[][] arr) {
        int n = arr.length;
        int top = 0, left = 0, right = n - 1, bottom = n - 1;

        while (top <= bottom && left <= bottom) {
            for (int i = left; i <= right; i++)
                System.out.print(arr[top][i] + " ");
            top++;

            for (int i = top; i <= bottom; i++)
                System.out.print(arr[i][right] + " ");
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    System.out.print(arr[bottom][i] + " ");
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    System.out.print(arr[i][left] + " ");
                left++;
            }
        }
    }
}
