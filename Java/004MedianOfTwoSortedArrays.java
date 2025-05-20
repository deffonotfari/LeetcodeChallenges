class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length)
                return findMedianSortedArrays(nums2, nums1);

            int left = 0;
            int right = nums1.length;

            while (left <= right){
                    final int partition1 = (left + right) / 2;
                    final int partition2 = (nums1.length + nums2.length + 1) / 2 - partition1;
                    final int maxLeft1 = partition1 == 0 ? Integer.MIN_VALUE : nums1[partition1 - 1];
                    final int maxLeft2 = partition2 == 0 ? Integer.MIN_VALUE : nums2[partition2 - 1];
                    final int minRight1 = partition1 == nums1.length ? Integer.MAX_VALUE : nums1[partition1];
                    final int minRight2 = partition2 == nums2.length ? Integer.MAX_VALUE : nums2[partition2];

                    if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1)
                        return (nums1.length + nums2.length) % 2 == 0
                            ? (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) * 0.5
                            : Math.max(maxLeft1, maxLeft2);
                    else if (maxLeft1 > minRight2)
                        right = partition1 - 1;
                    else
                        left = partition1 + 1;
        }

        throw new IllegalArgumentException();
    }
}
