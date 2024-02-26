package AlgorithmPractice.BinarySearch;

import java.util.Arrays;

public class LastOccurrence {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 5, 5, 5, 5, 5, 5, 5, 6};
        Arrays.sort(array);
        int searchFor = 5;

        lastOccurrence(array, searchFor);
    }

    private static void lastOccurrence(int[] array, int searchFor) {
        // find last occurrence of searchFor in O(log(n)) time
        // we know the linear scan, but that is O(n)
        int low = 0, high = array.length - 1, position = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == searchFor) {
                // We found an occurrence, save it and move right to improve the result.
                position = mid;
                low = mid + 1;
            } else if (array[mid] < searchFor) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (position >= 0)
            System.out.println("Last occurrence is at index: " + position);
        else {
            System.out.println("Seems not here.");
        }
    }
}
