class Solution {
    public int minDistance(String a, String b) {
        int n = b.length();
        int[] dp = new int[n + 1];

        for (int j = 0; j <= n; j++) dp[j] = j;

        for (int i = 1; i <= a.length(); i++) {
            int prev = dp[0];
            dp[0] = i;

            for (int j = 1; j <= n; j++) {
                int temp = dp[j];

                if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[j] = prev;
                else
                    dp[j] = 1 + Math.min(prev, Math.min(dp[j], dp[j - 1]));

                prev = temp;
            }
        }

        return dp[n];
    }
}