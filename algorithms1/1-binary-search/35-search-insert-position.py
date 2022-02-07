# 35 Search Insert Position - https://leetcode.com/problems/search-insert-position/

class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums) - 1
        while left <= right:
            pivot = (left + right) // 2
            if nums[pivot] == target:
                return pivot
            elif nums[pivot] > target:
                right = pivot - 1
            elif nums[pivot] < target:
                left = pivot + 1
        return left