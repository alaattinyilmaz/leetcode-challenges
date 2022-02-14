// 283. Move Zeroes - https://leetcode.com/problems/move-zeroes/
class Solution {
    public void moveZeroes(int[] nums) {
        int nonZeroPtr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[nonZeroPtr++] = nums[i];
        }
        for (int k = nonZeroPtr; k < nums.length; k++) {
            nums[k] = 0;
        }
    }
}

class Solution2 {
    public void moveZeroes(int[] nums) {
        int[] ans = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                ans[right] = 0;
                right--;
            } else {
                ans[left] = nums[i];
                left++;
            }
        }
        for (int k = 0; k < ans.length;k++)
            nums[k] = ans[k];
    }
}