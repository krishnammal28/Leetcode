class Solution {
    public boolean isMatch(String s, String p) {
        return matchHelper(s, p, 0, 0);
    }

    private boolean matchHelper(String s, String p, int i, int j) {
        if (j == p.length()) return i == s.length();

        boolean firstMatch = (i < s.length() &&
                              (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {

            return matchHelper(s, p, i, j + 2) ||
                   (firstMatch && matchHelper(s, p, i + 1, j));
        } else {
            return firstMatch && matchHelper(s, p, i + 1, j + 1);
        }
    }
}
