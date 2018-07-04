package s44;

import edu.princeton.cs.algorithms.Bag;
import edu.princeton.cs.introcs.In;

import java.util.Iterator;

/**
 * Created by dhx on 2018/7/4.
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

    Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    int v() {
        return v;
    }

    Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> list = new Bag<DirectedEdge>();
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

    public static void main(String[] args) {
        EdgeWeightedDigraph edgeWeightedDigraph = tinyEWD();
        System.out.println(edgeWeightedDigraph.e);
        System.out.println(edgeWeightedDigraph.v);
    }
}
