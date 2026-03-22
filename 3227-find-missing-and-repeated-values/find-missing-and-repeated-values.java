class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        boolean[] seen = new boolean[n * n + 1];

        int repeat = -1, missing = -1;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {

                int num = grid[i][j];

                if(seen[num] == true) {
                    repeat = num;
                } else {
                    seen[num] = true;
                }
            }
        }

        for(int i = 1; i <= n * n; i++) {
            if(seen[i] == false) {
                missing = i;
            }
        }

        return new int[]{repeat, missing};
      
    }
}