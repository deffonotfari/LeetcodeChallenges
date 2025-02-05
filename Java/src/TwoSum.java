import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * */


public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> n = new HashMap<>();

        for (int i = 0;; ++i) {
            int nums1 = nums[i];
            int nums2 = target - nums1;

            if (n.containsKey(nums2)) {
                return new int[] { n.get(nums2), i };
            }

            n.put(nums1, i);
        }
    }
}