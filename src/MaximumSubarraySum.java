import static java.lang.Integer.max;

public class MaximumSubarraySum {
    public static void main(String[] args) {
        new MaximumSubarraySum().solve1(new int[]{-1, 2, 4, -3, 5, 2, -5, 2});
        new MaximumSubarraySum().solutionByKadane(new int[]{-1, 2, 4, -3, 5, 2, -5, 2});
        new MaximumSubarraySum().solutionByKadane(new int[]{-1, -2, -3});
    }

    // here sum will never be negative.
    // when sum is < 0, we are skipping that value and setting to 0
    private void solve1(int[] nums) {
        int best = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum < 0) {
                sum = 0;
            }
            best = max(best, sum);
        }
        System.out.println("Max sum: " + best);
    }

    // here sum can be negative.
    // we are taking either num or sum + num for sum's new value
    private void solutionByKadane(int[] nums) {
        int best = 0, sum = 0;
        for (int num : nums) {
            sum = max(num, sum + num);
            best = max(best, sum);
        }
        System.out.println("Max sum: " + best);
    }
}
