class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                char c = board[i][j];

                if (c != '.') {

                    if (!set.add(c + "r" + i) ||
                        !set.add(c + "c" + j) ||
                        !set.add(c + "b" + i / 3 + j / 3))
                        return false;
                }
            }
        }

        return true;
    }
}