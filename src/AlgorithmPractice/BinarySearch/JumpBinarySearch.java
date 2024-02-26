package AlgorithmPractice.BinarySearch;

import java.util.Arrays;

public class JumpBinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 5, 5, 5, 5, 5, 5, 5, 6};
        Arrays.sort(array);
        int searchFor = 5;

        jumpBinarySearch(array, searchFor);
    }

    private static void jumpBinarySearch(int[] array, int searchFor) {

        // this version of BS searches for right most ans
        int base = 0;
        for (int jumpAmount = array.length / 2; jumpAmount >= 1; jumpAmount /= 2) {
            while (base + jumpAmount < array.length && array[base + jumpAmount] <= searchFor) {
                base += jumpAmount;
            }
        }

        if (array[base] == searchFor) {
            System.out.println("Found the key = " + searchFor);
        } else {
            System.out.println("Not found the key = " + searchFor);
        }
    }
}
