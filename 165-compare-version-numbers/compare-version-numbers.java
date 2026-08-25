class Solution {

    public int compareVersion(String version1, String version2) {

        String[] a = version1.split("\\.");
        String[] b = version2.split("\\.");

        int n = Math.max(a.length, b.length);

        for (int i = 0; i < n; i++) {

            int num1 = 0;
            int num2 = 0;

            if (i < a.length) {
                num1 = Integer.parseInt(a[i]);
            }

            if (i < b.length) {
                num2 = Integer.parseInt(b[i]);
            }

            if (num1 > num2) {
                return 1;
            }

            if (num1 < num2) {
                return -1;
            }
        }

        return 0;
    }
}