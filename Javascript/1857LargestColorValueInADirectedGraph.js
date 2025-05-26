/**
 * @param {string} colors
 * @param {number[][]} edges
 * @return {number}
 */
var largestPathValue = function(colors, edges) {
    let ans = 0;
    let processed = 0;
    const n = colors.length;
    const inDegrees = new Array(n).fill(0);
    const graph = new Array(n);
    const count = new Array(n);
    
    for (let i = 0; i < n; i++) {
        graph[i] = [];
        count[i] = new Array(26).fill(0);
    }
    
    for (const [u, v] of edges) {
        graph[u].push(v);
        inDegrees[v]++;
    }
    
    const queue = [];
    for (let i = 0; i < n; i++) {
        if (inDegrees[i] === 0) {
            queue.push(i);
        }
    }
    
    while (queue.length > 0) {
        const u = queue.shift();
        processed++;
        ans = Math.max(ans, ++count[u][colors.charCodeAt(u) - 'a'.charCodeAt(0)]);
        
        for (const v of graph[u]) {
            for (let i = 0; i < 26; i++) {
                count[v][i] = Math.max(count[v][i], count[u][i]);
            }
            if (--inDegrees[v] === 0) {
                queue.push(v);
            }
        }
    }
    
    return processed === n ? ans : -1;
};
