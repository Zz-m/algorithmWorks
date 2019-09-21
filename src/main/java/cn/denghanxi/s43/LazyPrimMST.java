package cn.denghanxi.s43;

import edu.princeton.cs.algorithms.MinPQ;
import edu.princeton.cs.algorithms.Queue;

/**
 * Created by dhx on 2018/6/21.
 */
public class LazyPrimMST implements MST {

    private boolean[] marked; //MST vertices
    private Queue<Edge> mst = new Queue<>(); //MST edges
    private MinPQ<Edge> pq = new MinPQ<>(); //PQ of edges

    public LazyPrimMST(EdgeWeightedGraph edgeWeightedGraph) {
        marked = new boolean[edgeWeightedGraph.v()];
        visit(edgeWeightedGraph, 0);

        while (!pq.isEmpty() && mst.size() < edgeWeightedGraph.v() - 1) {
            Edge e =pq.delMin();
            int v = e.either(), w = e.other(v);
            if (marked[v] && marked[w]) continue;
            mst.enqueue(e);
            if (!marked[v]) visit(edgeWeightedGraph, v);
            if (!marked[w]) visit(edgeWeightedGraph, w);
        }
    }

    @Override
    public Iterable<Edge> edges() {
        return mst;
    }

    @Override
    public double weight() {
        double weight = 0.0;
        for (Edge edge : mst)
            weight += edge.weight();
        return weight;
    }

    private void visit(EdgeWeightedGraph edgeWeightedGraph, int vertex){
        marked[vertex] = true;
        for (Edge e : edgeWeightedGraph.adj(vertex))
            if (!marked[e.other(vertex)])
                pq.insert(e);
    }
}
