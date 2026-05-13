class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        int n = nums.length, min = nums[0], max = nums[0];

        for (int x : nums) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        if (min == max) return 0;

        int size = Math.max(1, (max - min) / (n - 1));
        int buckets = (max - min) / size + 1;

        int[] bMin = new int[buckets];
        int[] bMax = new int[buckets];
        boolean[] used = new boolean[buckets];

        for (int x : nums) {
            int i = (x - min) / size;
            if (!used[i]) {
                bMin[i] = bMax[i] = x;
                used[i] = true;
            } else {
                bMin[i] = Math.min(bMin[i], x);
                bMax[i] = Math.max(bMax[i], x);
            }
        }

        int ans = 0, prev = min;

        for (int i = 0; i < buckets; i++) {
            if (!used[i]) continue;
            ans = Math.max(ans, bMin[i] - prev);
            prev = bMax[i];
        }

        return ans;
    }
}