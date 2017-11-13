package s42;

/**
 * Kosaraju 强连通算法
 */

public class KosarajuSCC {
    private boolean[] marked;
    private int[] id;
    private int count;

    public KosarajuSCC(Digraph digraph) {
        marked = new boolean[digraph.v()];
        id = new int[digraph.v()];
        DepthFirstOrder order = new DepthFirstOrder(digraph.reverse());

        for (int s : order.reversePost()) {
            if (!marked[s]) {
                dfs(digraph, s); count++;
            }
        }
    }

    private void dfs(Digraph digraph, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : digraph.adj(v)) {
            if (!marked[w]) {
                dfs(digraph, w);
            }
        }
    }

    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        boolean a = false;
        boolean b = false;
        System.out.println(!a && !b);
    }
}
