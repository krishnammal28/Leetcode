import java.util.*;

class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = nums.length;
        int m = nums[0].length();
        int[] res = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int k = queries[q][0];
            int trim = queries[q][1];

            List<String[]> arr = new ArrayList<>();
            // [trimmedString, index]

            for (int i = 0; i < n; i++) {
                String t = nums[i].substring(m - trim);
                arr.add(new String[]{t, String.valueOf(i)});
            }

            arr.sort((a, b) -> {
                if (!a[0].equals(b[0])) return a[0].compareTo(b[0]);
                return Integer.parseInt(a[1]) - Integer.parseInt(b[1]);
            });

            res[q] = Integer.parseInt(arr.get(k - 1)[1]);
        }

        return res;
    }
}