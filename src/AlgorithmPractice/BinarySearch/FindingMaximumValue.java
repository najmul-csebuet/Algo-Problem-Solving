package AlgorithmPractice.BinarySearch;

public class FindingMaximumValue {
    public static void main(String[] args) {
        // first increasing and then decreasing
        /*
              -  <--- find this index which contains max value
             - -
            -   -
        */
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 60, 50, 35, 25, 15, 7};
        tryRegularBinarySearch(values);

        int[] values1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 60};
        tryRegularBinarySearch(values1);

        int[] values2 = {60, 50, 35, 25, 15, 7};
        tryRegularBinarySearch(values2);

        tryJumpingBinarySearch(values);
    }

    private static void tryJumpingBinarySearch(int[] values) {
        // if it is increasing, then continue jumping
        // stop when you see that seq is decreasing
        int base = 0;
    }

    private static void tryRegularBinarySearch(int[] values) {
        int low = 0, high = values.length - 1, position = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (foundMaxPoint(values, mid)) {
                position = mid;
                break;
            } else if (values[mid - 1] < values[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (position != -1) {
            System.out.println("Max value is: " + values[position]);
        } else {
            System.out.println("Max value not found.");
        }
    }

    private static boolean foundMaxPoint(int[] values, int mid) {
        if (mid == 0) {
            return values[mid] > values[mid + 1];
        }

        if (mid == values.length - 1) {
            return values[mid - 1] < values[mid];
        }

        return values[mid - 1] < values[mid] && values[mid] > values[mid + 1];
    }
}
