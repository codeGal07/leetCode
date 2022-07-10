package leetcode.solutions.longestsubstring;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int count_max = 1;

        if (s.equals("")) {
            return 0;
        }
        StringBuilder substring = new StringBuilder(String.valueOf(s.charAt(0)));
        for (int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);
            if (!substring.toString().contains(String.valueOf(current))) {
                substring.append(current);
            } else {
                count_max = Math.max(substring.length(), count_max);
                int index = substring.indexOf(String.valueOf(current));
                substring = new StringBuilder(substring.substring(index+1));
                substring.append(current);
            }
            count_max = Math.max(substring.length(), count_max);
        }
        return count_max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        String s = "ababD";
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}