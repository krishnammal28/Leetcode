import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] f : flights) {
            graph[f[0]].add(new int[]{f[1], f[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, src, 0});

        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int node = curr[1];
            int step = curr[2];

            if (node == dst) return cost;

            if (step > k || step > stops[node]) continue;

            stops[node] = step;

            for (int[] nei : graph[node]) {
                pq.add(new int[]{cost + nei[1], nei[0], step + 1});
            }
        }

        return -1;
    }
}