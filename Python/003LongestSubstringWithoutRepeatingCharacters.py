import collections

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        ans = 0
        count = collections.Counter()
        left = 0

        for right, c in enumerate(s):
            count[c] += 1
            while count[c] > 1:
                count[s[left]] -= 1
                left += 1
            ans = max(ans, right - left + 1)

        return ans
