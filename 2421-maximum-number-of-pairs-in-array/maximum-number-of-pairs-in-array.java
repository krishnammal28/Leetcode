import java.util.*;

class Solution {
    public int[] numberOfPairs(int[] nums) {
        int[] freq = new int[101]; 
        for (int num : nums) {
            freq[num]++;
        }

        int pairs = 0;
        int leftover = 0;

        for (int f : freq) {
            pairs += f / 2;
            leftover += f % 2;
        }

        return new int[]{pairs, leftover};
    }
}