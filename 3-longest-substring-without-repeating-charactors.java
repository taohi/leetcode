/**
 * Given a string,find the length of the longest substring without repeating characters.
 * 
 * Example 1:
 * 
 * Input:"abcabcbb"
 * Output:3
 * Explanation:The answer is"abc",with the length of 3.
 * Example 2:
 * 
 * Input:"bbbbb"
 * Output:1
 * Explanation:The answer is"b",with the length of 1.
 * Example 3:
 * 
 * Input:"pwwkew"
 * Output:3
 * Explanation:The answer is"wke",with the length of 3.
 * Note that the answer must be a substring,"pwke"is a subsequence and not a substring.
 **/


class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 1;
        int begin = 0;
        int end = 0;
        int currentDistance;

        if (s == null || s.equals(""))
            return 0;
        if (s.length() == 1)
            return 1;

        for (int i = 1; i < s.length(); i++) {
            int idx = s.indexOf(s.charAt(i), begin);
            if (idx <= end && idx >= 0) {
                begin = idx + 1;
                end = i;
            } else
                end += 1;
            currentDistance = end - begin + 1;
            if (maxLen < currentDistance)
                maxLen = currentDistance;
        }
        return maxLen;
    }
}   