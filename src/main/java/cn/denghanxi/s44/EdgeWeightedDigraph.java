package cn.denghanxi.s44;

import edu.princeton.cs.algorithms.Bag;
import edu.princeton.cs.introcs.In;

/**
 * Created by dhx on 2018/7/4.
 * 加权有向图
 */
public class EdgeWeightedDigraph {

    private final int v; //vertex number
    private int e; //edges number
    private final Bag<DirectedEdge>[] adj;

    @SuppressWarnings("unchecked")
    public EdgeWeightedDigraph(int v) {
        this.v = v;
        adj = (Bag<DirectedEdge>[]) new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag<>();
        }
    }

    public EdgeWeightedDigraph(In in) {
        this(in.readInt());
        int e = in.readInt();
        for (int i = 0; i < e; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            addEdge(new DirectedEdge(v, w, weight));
        }
    }

    void addEdge(DirectedEdge edge) {
        int v = edge.from();
        adj[v].add(edge);
        e++;
    }

    //v点指出的边
    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public int v() {
        return v;
    }

    public int e() {
        return e;
    }

    Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> list = new Bag<>();
        for (int v = 0; v < this.v; v++) {
            for (DirectedEdge e : adj(v)) {
                list.add(e);
            }
        }
        return list;
    }

    public static EdgeWeightedDigraph tinyEWD() {
        return new EdgeWeightedDigraph(new In(EdgeWeightedDigraph.class.getResource("/tinyEWD.txt")));
    }

}
