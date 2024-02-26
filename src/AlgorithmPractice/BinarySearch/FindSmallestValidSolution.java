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

        findFirstTrueIndex(values);
        findLastFalseIndex(values);

        // Now let's solve this with jump technique
        useJumping(values);
    }

    private static void useJumping(boolean[] values) {
        int base = -1;
        for (int jump = values.length - 1; jump >= 1; jump /= 2) {
            while(base + jump < values.length && !values[base + jump]) {
                base += jump;
            }
        }

        if(values[base + 1]) {
            System.out.println("Smallest valid solution is at index: " + (base + 1));
        } else {
            System.out.println("Seems no solution.");
        }
    }

    private static void findLastFalseIndex(boolean[] values) {
        // let's find last false position
        int low = 0, high = values.length - 1, position = -1;
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
    }

    private static void findFirstTrueIndex(boolean[] values) {
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
    }
}
