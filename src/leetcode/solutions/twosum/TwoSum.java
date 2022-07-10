package leetcode.solutions.twosum;


import java.util.Arrays;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
        }
        return null;
    }

    public static void main(String args[]) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.print(Arrays.toString(twoSum(nums, target)));
    }
}





