package cn.denghanxi.s41;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdOut;

/**
 * 连通分量
 */
public class CC {

    private boolean[] marked;
    private int[] id;
    private int count;

    CC(Graph graph){
        marked = new boolean[graph.V()];
        id = new int[graph.V()];
        for (int s = 0; s < graph.V(); s++) {
            if (!marked[s]) {
                dfs(graph, s);
                count++;
            }
        }
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : graph.adj(v))
            if (!marked[w])
                dfs(graph, w);
    }

    // v, w 两个顶点是否连通
    boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    //连通分量数
    int count() {
        return count;
    }

    //v所在连通分量标识符 (0 -- count()-1)
    int id(int v) {
        return id[v];
    }

}
