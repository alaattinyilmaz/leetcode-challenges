# 278 First Bad Version https://leetcode.com/problems/first-bad-version/

# The isBadVersion API is already defined for you.
# def isBadVersion(version: int) -> bool:

class Solution:
    def firstBadVersion(self, n: int) -> int:
        if n == 1:
            return 1
        left, right = 1, n
        while left <= right:
            pivot = (left + right) // 2
            if isBadVersion(pivot):
                right = pivot - 1
            else:
                left = pivot + 1
        return left
