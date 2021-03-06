package cn.denghanxi.s42;

public class DirectedDFS {
    private boolean[] marked;

    public DirectedDFS(Digraph digraph, int s) {
        marked = new boolean[digraph.v()];
        dfs(digraph, s);
    }

    public DirectedDFS(Digraph digraph, Iterable<Integer> sources) {
        marked = new boolean[digraph.v()];
        for (int s : sources) {
            if (!marked[s]) dfs(digraph, s);
        }
    }

    private void dfs(Digraph digraph, int v) {
        marked[v] = true;
        for (int w : digraph.adj(v))
            if (!marked[w]) dfs(digraph, w);
    }

    public boolean marked(int v) {
        return marked[v];
    }
}
