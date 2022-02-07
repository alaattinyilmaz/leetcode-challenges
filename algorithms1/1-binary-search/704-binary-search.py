# 704 - Binary Search - https://leetcode.com/problems/binary-search/

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if len(nums) == 1 and nums[0] == target:
            return 0
        left, right = 0, len(nums)-1
        while left <= right:
            pivot = (left + right) // 2 
            if nums[pivot] == target:
                return pivot
            elif nums[pivot] > target:
                right = pivot - 1
            elif nums[pivot] < target:
                left = pivot + 1
        return -1
