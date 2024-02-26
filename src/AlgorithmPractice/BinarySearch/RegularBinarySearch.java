package AlgorithmPractice.BinarySearch;

import java.util.Arrays;

public class RegularBinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 5, 5, 5, 5, 5, 5, 5, 6};
        Arrays.sort(array);
        int searchFor = 5;

        regularBinarySearch(array, searchFor);
    }

    private static void regularBinarySearch(int[] array, int searchFor) {
        int low = 0, high = array.length - 1;
        while (low <= high) {
            var mid = low + ((high - low) >> 1);
            if (array[mid] == searchFor) {
                System.out.println("Found the key = " + searchFor);
                return;
            }
            if (searchFor < array[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println("Not found the key = " + searchFor);
    }
}
