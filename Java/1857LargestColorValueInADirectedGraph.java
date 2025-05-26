class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int ans = 0;
        int processed = 0;
        int[] inDegrees = new int[colors.length()];
        List<Integer>[] graph = new List[colors.length()];
        int[][] count = new int[colors.length()][26];


        for (int i = 0; i < colors.length(); ++i) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge: edges){
            final int u = edge[0];
            final int v = edge[1];
            graph[u].add(v);
            ++inDegrees[v];
        }

        Queue<Integer> q = IntStream.range(0, colors.length())
                           .filter(i -> inDegrees[i] == 0)
                           .boxed()
                           .collect(Collectors.toCollection(ArrayDeque::new));

        while(!q.isEmpty()) {
            final int out = q.poll();
            ++processed;
            ans = Math.max(ans, ++count[out][colors.charAt(out) - 'a']);

            for (final int in: graph[out]) {
                for (int i = 0; i < 26; ++i) {
                    count[in][i] = Math.max(count[in][i], count[out][i]);
                }

                if(--inDegrees[in] == 0){
                    q.offer(in);
                }
            }
        }

        return processed == colors.length() ? ans : -1;
    }
}
