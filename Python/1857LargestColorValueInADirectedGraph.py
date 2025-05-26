import collections

class Solution(object):
    def largestPathValue(self, colors, edges):
        """
        :type colors: str
        :type edges: List[List[int]]
        :rtype: int
        """
        n = len(colors)
        graph = [[] for _ in range(n)]
        in_degrees = [0] * n
        count = [[0] * 26 for _ in range(n)]
        q = collections.deque()

        # Build the graph and indegrees
        for u, v in edges:
            graph[u].append(v)
            in_degrees[v] += 1

        # Enqueue nodes with in-degree 0
        for i in range(n):
            if in_degrees[i] == 0:
                q.append(i)

        processed = 0
        max_color_val = 0

        while q:
            u = q.popleft()
            processed += 1
            u_color_idx = ord(colors[u]) - ord('a')
            count[u][u_color_idx] += 1
            max_color_val = max(max_color_val, count[u][u_color_idx])

            for v in graph[u]:
                for i in range(26):
                    if count[u][i] > count[v][i]:
                        count[v][i] = count[u][i]
                in_degrees[v] -= 1
                if in_degrees[v] == 0:
                    q.append(v)

        return max_color_val if processed == n else -1
