// 189. Rotate Array - https://leetcode.com/problems/rotate-array/

class Solution1 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    public void reverse(int[] nums, int start, int end)
    {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

class Solution2 {
    public void rotate(int[] nums, int k) {
        int[] nums2 = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            nums2[(i + k) % nums.length] = nums[i];
        for (int i = 0; i < nums.length; i++)
            nums[i] = nums2[i];
    }
}
