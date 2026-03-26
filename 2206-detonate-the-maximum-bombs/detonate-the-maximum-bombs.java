class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            long x1 = bombs[i][0], y1 = bombs[i][1], r1 = bombs[i][2];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                long dx = x1 - bombs[j][0], dy = y1 - bombs[j][1];
                if (dx * dx + dy * dy <= r1 * r1) graph.get(i).add(j);
            }
        }

        int max = 1;
        for (int i = 0; i < n; i++) max = Math.max(max, dfs(i, graph, new boolean[n]));
        return max;
    }

    private int dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        int count = 1;
        for (int nei : graph.get(node)) if (!visited[nei]) count += dfs(nei, graph, visited);
        return count;
    }
}
