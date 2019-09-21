package cn.denghanxi.s41;

/**
 * 深度优先搜索
 */
public class DepthFirstSearch implements Search {

    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph g, int s) {
        marked = new boolean[g.V()];
        dfs(g, s);
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        count++;
        for (int w : g.adj(v))
            if (!marked[w])
                dfs(g, w);
    }

    @Override
    public boolean marked(int v) {
        return false;
    }

    @Override
    public int count() {
        return 0;
    }
}
