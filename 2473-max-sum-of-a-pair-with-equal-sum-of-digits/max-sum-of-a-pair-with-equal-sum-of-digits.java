import java.util.*;

class Solution {

    private int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public int maximumSum(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int ans = -1;

        for (int num : nums) {
            int sum = digitSum(num);

            if (!map.containsKey(sum)) {
                map.put(sum, new int[]{num, -1});
            } else {
                int[] top = map.get(sum);

                if (num > top[0]) {
                    top[1] = top[0];
                    top[0] = num;
                } else if (num > top[1]) {
                    top[1] = num;
                }

                map.put(sum, top);
            }
        }

        for (int[] top : map.values()) {
            if (top[1] != -1) {
                ans = Math.max(ans, top[0] + top[1]);
            }
        }

        return ans;
    }
}