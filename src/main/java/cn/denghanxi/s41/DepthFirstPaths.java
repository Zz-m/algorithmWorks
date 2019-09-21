package cn.denghanxi.s41;

import edu.princeton.cs.algorithms.Stack;
import edu.princeton.cs.introcs.StdOut;

public class DepthFirstPaths implements Paths {

    private boolean[] marked; //dfs是否到过该顶点
    private int[] edgeTo; //dfs 该顶点的上一个顶点
    private final int s; //source

    public DepthFirstPaths(Graph graph, int source) {
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        this.s = source;
        dfs(graph, s);
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        for (int w : graph.adj(v))
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(graph, w);
            }
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }

    public static void main(String[] args) {
//        Graph graph = TinyG.getTinyG();
        Graph graph = MediumG.getMediumG();
        int s = 1;
        Paths search = new DepthFirstPaths(graph, s);

        for (int v = 0; v < graph.V(); v++) {
            StdOut.print(s + " to " + v + ": ");
            if (search.hasPathTo(v))
                for (int x : search.pathTo(v))
                    if (x == s) StdOut.print(x);
                    else StdOut.print("-" + x);
            StdOut.println();
        }
    }
}