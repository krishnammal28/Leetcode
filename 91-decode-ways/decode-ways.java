class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') return 0;

        int prev2 = 1; 
        int prev1 = 1; 

        for (int i = 1; i < n; i++) {
            int current = 0;

            char curr = s.charAt(i);
            char prev = s.charAt(i - 1);
            if (curr != '0') {
                current += prev1;
            }
            int twoDigit = (prev - '0') * 10 + (curr - '0');
            if (twoDigit >= 10 && twoDigit <= 26) {
                current += prev2;
            }

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}