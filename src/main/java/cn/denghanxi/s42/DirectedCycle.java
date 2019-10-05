package cn.denghanxi.s42;

import cn.denghanxi.s44.DirectedEdge;
import cn.denghanxi.s44.EdgeWeightedDigraph;
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

    public DirectedCycle(EdgeWeightedDigraph edgeWeightedDigraph) {
        onStack = new boolean[edgeWeightedDigraph.v()];
        edgeTo = new int[edgeWeightedDigraph.v()];
        marked = new boolean[edgeWeightedDigraph.v()];
        for (int v = 0; v < edgeWeightedDigraph.v(); v++)
            if (!marked[v]) dfs(edgeWeightedDigraph, v);
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

    private void dfs(EdgeWeightedDigraph edgeWeightedDigraph, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (DirectedEdge edge : edgeWeightedDigraph.adj(v))
            if (this.hasCycle()) return;
            else if (!marked[edge.to()]) {
                edgeTo[edge.to()] = v;
                dfs(edgeWeightedDigraph, edge.to());
            } else if (onStack[edge.to()]) {
                cycle = new Stack<>();
                for (int x = v; x != edge.to(); x = edgeTo[x])
                    cycle.push(x);
                cycle.push(edge.to());
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
