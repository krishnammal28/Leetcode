class Solution {

    public int[] searchRange(int[] nums, int target) {

        return new int[]{
            find(nums, target, true),
            find(nums, target, false)
        };
    }

    int find(int[] nums, int target, boolean first) {

        int l = 0, r = nums.length - 1, ans = -1;

        while (l <= r) {

            int m = (l + r) / 2;

            if (nums[m] == target) {
                ans = m;

                if (first)
                    r = m - 1;
                else
                    l = m + 1;

            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return ans;
    }
}