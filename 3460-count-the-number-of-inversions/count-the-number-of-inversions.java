class Solution {
    public int numberOfPermutations(int n, int[][] requirements) {
        int MOD = 1000000007;

        int[] req = new int[n];
        for(int i = 0; i < n; i++) req[i] = -1;

        for(int[] r : requirements) {
            req[r[0]] = r[1];
        }

        int maxInv = 400;
        int[][] dp = new int[n + 1][maxInv + 1];

        dp[0][0] = 1;

        for(int i = 1; i <= n; i++) {
            for(int k = 0; k <= maxInv; k++) {
                for(int x = 0; x < i; x++) {
                    if(k - x >= 0) {
                        dp[i][k] = (dp[i][k] + dp[i-1][k-x]) % MOD;
                    }
                }
            }

            if(req[i-1] != -1) {
                int needed = req[i-1];
                for(int k = 0; k <= maxInv; k++) {
                    if(k != needed) dp[i][k] = 0;
                }
            }
        }

        int ans = 0;
        for(int k = 0; k <= maxInv; k++) {
            ans = (ans + dp[n][k]) % MOD;
        }

        return ans;
    }
}