package AlgorithmPractice.BinarySearch;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 5, 5, 5, 5, 5, 5, 5, 6};
        Arrays.sort(array);
        int searchFor = 5;

        builtinBinarySearch(array, searchFor);
        regularBinarySearch(array, searchFor);
        jumpBinarySearch(array, searchFor);

        firstOccurrence(array, searchFor);
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

    private static void firstOccurrence(int[] array, int searchFor) {
        // find first occurrence of searchFor in O(log(n)) time
        // we know the linear scan, but that is O(n)
        int low = 0, high = array.length - 1, position = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == searchFor) {
                // We found an occurrence, save it and move left to improve the result.
                position = mid;
                high = mid - 1;
            } else if (array[mid] < searchFor) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (position >= 0)
            System.out.println("First occurrence is at index: " + position);
        else {
            System.out.println("Seems not here.");
        }
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

    private static void jumpBinarySearch(int[] array, int searchFor) {
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
