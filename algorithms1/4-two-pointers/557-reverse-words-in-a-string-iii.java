// 557. Reverse Words in a String III - https://leetcode.com/problems/reverse-words-in-a-string-iii/

class Solution {
    public String reverseWords(String s) {
        char[] sArr = s.toCharArray();
        int wordStartIndex = 0;
        int wordEndIndex = 0;
        for (int i = 0; i < sArr.length; i++){
            if(sArr[i]==' ' || i == sArr.length-1) {
                if (i == sArr.length-1)
                    reverseString(sArr, wordStartIndex, sArr.length-1);
                else
                    reverseString(sArr, wordStartIndex, wordEndIndex-1);
                wordStartIndex = i+1;
            }
            wordEndIndex++;
        }
        return new String(sArr);  
    }
    public void reverseString(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
}