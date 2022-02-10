// 3. Longest Substring Without Repeating Characters - https://leetcode.com/problems/longest-substring-without-repeating-characters/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int windowLength = 0;
        String window;
        while (right < s.length()) {
            window = s.substring(left, right); // Get the substring before this char (right)
            char ch = s.charAt(right);
            if (window.indexOf(ch) != -1) { // If this char seen before
                windowLength = right-left; // Take the string before this char
                left++; // Shorten the window from left until getting rid of repeating character
            } else {
                windowLength = right-left+1; // If not seen before, also count this element
                right++; // Enlarge the window to the right
            }
            if (windowLength > maxLength)
                maxLength = windowLength;
        }
        return maxLength;
    }
}