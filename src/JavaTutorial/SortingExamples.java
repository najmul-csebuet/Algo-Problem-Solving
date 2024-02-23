package JavaTutorial;

import java.util.Arrays;

public class SortingExamples {
    public static void main(String[] args) {
        int[] nums = {1, 20, 3};
        Arrays.sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
