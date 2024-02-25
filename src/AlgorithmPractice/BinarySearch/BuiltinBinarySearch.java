package AlgorithmPractice.BinarySearch;

import java.util.Arrays;

public class BuiltinBinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 5, 5, 5, 5, 5, 5, 5, 6};
        Arrays.sort(array);
        int searchFor = 5;

        builtinBinarySearch(array, searchFor);
    }

    private static void builtinBinarySearch(int[] array, int searchFor) {
        // Java Util Way
        int position = Arrays.binarySearch(array, searchFor);
        boolean found = position >= 0;
        if (found) {
            System.out.println("Found the key = " + searchFor);
        } else {
            System.out.println("Not found the key = " + searchFor);
        }
    }
}
