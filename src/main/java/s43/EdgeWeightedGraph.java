package s43;

import edu.princeton.cs.algorithms.Bag;
import edu.princeton.cs.introcs.In;

/**
 * Created by dhx on 2018/5/9.
 * 加权图
 */
public class EdgeWeightedGraph {

    private int v; //v vertex number
    private int e; //edges number
    private Bag<Edge>[] adj;

    public EdgeWeightedGraph(int v) {
        this.v = v;
        this.e = 0;
        adj = (Bag<Edge>[]) new Bag[v];
        for (int i = 0; i < v; i++)
            adj[i] = new Bag<>();
    }

    public EdgeWeightedGraph(In in){
        this.v = in.readInt();
        Edge edge = new Edge(in.readInt(), in.readInt(), in.readDouble());
        addEdge(edge);
    }

    public int v() {
        return v;
    }

    public int e() {
        return e; // number of edges
    }

    public void addEdge(Edge edge) {
        int v = edge.either();
        int w = edge.other(v);
        adj[v].add(edge);
        adj[w].add(edge);
        e++;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public Iterable<Edge> edges() {
        Bag<Edge> bag = new Bag<>();
        for (int i = 0; i < v; i++) {
            for (Edge e : adj(i))
                if (e.other(i) > i) bag.add(e);
        }
        return bag;
    }
}
