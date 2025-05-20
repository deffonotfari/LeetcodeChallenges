class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] line = new int[nums.length + 1];
        int decr = 0;

        for (int[] query : queries) {
            final int left = query[0];
            final int right = query[1];

            ++line[left];
            --line[right + 1];
        }

        for (int i = 0; i < nums.length; ++i) {
            decr += line[i];
            if (decr < nums[i])
                return false;
        }

        return true;
    }
}
