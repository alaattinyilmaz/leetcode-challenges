// 167. Two Sum II - Input Array Is Sorted - https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

// It adds to the numbers from left and from right, if sum is smaller than target, 
// then we need a higher number to sum if sum is higher than target we need a smaller number to sum

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        int sum_res = 0;
        while (left < right) {
            if (numbers[left] + numbers[right] == target)
                return new int[]{left+1,right+1};
            else if (numbers[left] + numbers[right] < target)
                left++;
            else
                right--;
        }
        return new int[]{left+1,right+1};
    }
    
}

// O(nlogn)
class Solution2 {
    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0;
        int index2 = -1;
        for (index1 = 0; index1 < numbers.length; index1++) {
            index2 = binarySearch(numbers, target-numbers[index1]);
            if (index2 != -1 && index2 != index1)
                if (index2 > index1)
                    return new int[]{index1+1,index2+1};                
                else
                    return new int[]{index2+1,index1+1};
        }
        return new int[]{index1+1,index2+1};
    }
    
    public int binarySearch(int [] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        while (left <= right){
            int pivot = (left + right) / 2;
            if (numbers[pivot] == target)
                return pivot;
            else if (numbers[pivot] > target) { 
                right = pivot - 1;
            }
            else if (numbers[pivot] < target) {
                left = pivot + 1;
            }
        }
        return -1;
    }
    
}