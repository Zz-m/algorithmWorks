package s42;

import edu.princeton.cs.algorithms.Stack;

/**
 * 有向图的环检测
 */
public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle; //有向环中的所有顶点（如果存在）
    private boolean[] onStack; //递归调用栈上的所有顶点

    public DirectedCycle(Digraph digraph) {
        onStack = new boolean[digraph.v()];
        edgeTo = new int[digraph.v()];
        marked = new boolean[digraph.v()];
        for (int v = 0; v < digraph.v(); v++)
            if (!marked[v]) dfs(digraph, v);
    }

    private void dfs(Digraph digraph, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : digraph.adj(v))
            if (this.hasCycle()) return;
            else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(digraph, w);
            } else if (onStack[w]) {
                cycle = new Stack<>();
                for (int x = v; x != w; x = edgeTo[x])
                    cycle.push(x);
                cycle.push(w);
                cycle.push(v);
            }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }
}
