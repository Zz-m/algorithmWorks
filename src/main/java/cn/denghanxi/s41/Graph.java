package cn.denghanxi.s41;

import edu.princeton.cs.algorithms.Bag;
import edu.princeton.cs.introcs.In;

/**
 * 图的简单实现，所有参数都没有做验证
 */
public class Graph {
    private final int V; //定点数目
    private int E; //边的数目
    private Bag<Integer>[] adj; //邻接表

    public Graph(int v) {
        this.V = v;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[v];
        for (int i = 0; i < v; i++)
            adj[i] = new Bag<>();
    }

    public Graph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public int V() {return V;} //获取顶点数
    public int E() {return E;} //获取边数

    /**
     * 添加一条边
     * @param v 边的一个顶点
     * @param w 边的另一个顶点
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    /**
     * 获取某个顶点的相邻顶点集合
     * @param v 顶点
     * @return 相邻集合
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
