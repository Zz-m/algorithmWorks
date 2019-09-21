package cn.denghanxi.s41;

import edu.princeton.cs.algorithms.Bag;
import edu.princeton.cs.introcs.StdOut;

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

    public static void test(Graph graph, CC cc) {
        int m = cc.count();
        StdOut.println(m + " components");
        Bag<Integer>[] components = (Bag<Integer>[]) new Bag[m];
        for (int i = 0; i < m; i++)
            components[i] = new Bag<>();
        for (int v = 0; v < graph.V(); v++)
            components[cc.id(v)].add(v);
        for (int i = 0; i < m; i++) {
            for (int v : components[i])
                StdOut.print(v + " ");
            StdOut.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = TinyG.getTinyG();
        test(graph, new CC(graph));
        StdOut.println("--------------------");
        Graph graphMedium = MediumG.getMediumG();
        test(graphMedium, new CC(graphMedium));
    }
}
