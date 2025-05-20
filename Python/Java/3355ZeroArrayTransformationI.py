class Solution(object):
    def isZeroArray(self, nums, queries):
        """
        :type nums: List[int]
        :type queries: List[List[int]]
        :rtype: bool
        """

        line = [0] * (len(nums) + 1)
        decr = 0

        for left, right in queries:
            line[left] += 1
            line[right + 1] -= 1

        for i, num in enumerate(nums):
            decr += line[i]
            if (decr < num):
                return False

        return True
        
