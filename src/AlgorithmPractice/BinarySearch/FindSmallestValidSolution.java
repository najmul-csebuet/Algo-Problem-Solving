package AlgorithmPractice.BinarySearch;

import java.util.Arrays;

public class FindSmallestValidSolution {
    public static void main(String[] args) {
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
}
