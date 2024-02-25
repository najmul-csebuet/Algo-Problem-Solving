package AlgorithmPractice.BinarySearch;

import java.util.Arrays;

public class RegularBinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 5, 5, 5, 5, 5, 5, 5, 6};
        Arrays.sort(array);
        int searchFor = 5;

        regularBinarySearch(array, searchFor);

        firstOccurrence(array, searchFor);
        lastOccurrence(array, searchFor);

        findSmallestValidSolution();
    }

    private static void findSmallestValidSolution() {
        // find the smallest index where values[k] == true
        boolean[] values = {false, false, false, true, true, true, true};
        // Hint: find first true or last false

        // let's find first true position
        int low = 0, high = values.length - 1, position = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (values[mid]) {
                position = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (position >= 0) {
            System.out.println("Smallest valid index is: " + position);
        } else {
            System.out.println("All solutions are false");
        }

        // let's find last false position
        low = 0;
        high = values.length - 1;
        position = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (!values[mid]) {
                position = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (position >= 0) {
            System.out.println("largest index where value is false: " + position);
        } else {
            System.out.println("All solutions are true");
        }


        // Now let's solve this with jump technique
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
