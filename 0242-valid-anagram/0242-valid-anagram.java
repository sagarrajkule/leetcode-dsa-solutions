public class Solution {
    public boolean isAnagram(String s, String t) {
        // Early return if lengths don't match
        if (s.length() != t.length()) return false;

        // Frequency array for characters a-z (26 letters)
        int[] freq = new int[26];

        // Increment counts from first string, decrement from second
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        // If any frequency is not zero, it's not an anagram
        for (int count : freq) {
            if (count != 0) return false;
        }

        return true;
    }
}
