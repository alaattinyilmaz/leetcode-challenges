// 567. Permutation in String - https://leetcode.com/problems/permutation-in-string/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;
        int[] permutationFrequencies = new int[26];
        for (int c = 0; c < s1.length(); c++) // Store all permutation string letter counts
            permutationFrequencies[s1.charAt(c) - 'a']++;
        int[] windowFrequencies;
        int left = 0;
        int right = 0;
        int windowSize = s1.length(); // Take windows as length of permutation string
        String window;
        boolean match = false;
        right = windowSize - left;  
        while(right <= s2.length()) {
            window = s2.substring(left, right); // Take windows from s2 string as the same size as permutation string
            windowFrequencies = new int[26]; // Taken window letter frequencies
            for (int w = 0; w < windowSize; w++)
                windowFrequencies[window.charAt(w) - 'a']++;
            match = true;
            // If all taken window letter frequencies are same with permutation frequencies these two substrings has the same letters at the same count
            for (int j = 0; j < windowSize; j++) {
                if (permutationFrequencies[window.charAt(j) - 'a'] != windowFrequencies[window.charAt(j) - 'a'])
                    match = false;
            }
            if (match == true)
                return true;
            // Sliding the window
            left++;
            right++;
        }
        return match;
    }
}