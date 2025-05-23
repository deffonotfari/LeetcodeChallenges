class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long maxSum = 0;
        int changedCount = 0;
        int minChangeDifference = Integer.MAX_VALUE;

        for (final int num: nums) {
            int xorValue = num ^ k;
            maxSum += Math.max(num, xorValue);

            if (xorValue > num) {
                changedCount++;
            }

            minChangeDifference = Math.min(minChangeDifference, Math.abs(num - xorValue));
        }


        if (changedCount % 2 == 0) {
            return maxSum;
        }

        return maxSum - minChangeDifference;
    }
}
