class Solution {
    public String reorganizeString(String s) {

        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int max = 0;
        int maxIndex = 0;

        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
                maxIndex = i;
            }
        }
        if (max > (s.length() + 1) / 2) {
            return "";
        }

        char[] ans = new char[s.length()];
        int pos = 0;
        while (count[maxIndex] > 0) {
            ans[pos] = (char)(maxIndex + 'a');
            count[maxIndex]--;
            pos += 2;

            if (pos >= s.length()) {
                pos = 1;
            }
        }
        for (int i = 0; i < 26; i++) {

            while (count[i] > 0) {
                ans[pos] = (char)(i + 'a');
                count[i]--;

                pos += 2;

                if (pos >= s.length()) {
                    pos = 1;
                }
            }
        }

        return new String(ans);
    }
}