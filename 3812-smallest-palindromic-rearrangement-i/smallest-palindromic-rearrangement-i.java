import java.util.Arrays;

class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();

        // 1. Extract only the first half
        char[] firstHalf = s.substring(0, n / 2).toCharArray();

        // 2. Sort the first half to make it lexicographically smallest
        Arrays.sort(firstHalf);

        // 3. Build the first half as a StringBuilder
        StringBuilder result = new StringBuilder(new String(firstHalf));

        // 4. Append the middle character if the string length is odd
        if (n % 2 != 0) {
            result.append(s.charAt(n / 2));
        }

        // 5. Mirror the reversed sorted first half to complete the palindrome
        result.append(new StringBuilder(new String(firstHalf)).reverse());

        return result.toString();
    }
}