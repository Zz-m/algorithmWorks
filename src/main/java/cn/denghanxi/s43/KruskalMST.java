package cn.denghanxi.s43;

import edu.princeton.cs.algorithms.MinPQ;
import edu.princeton.cs.algorithms.Queue;
import edu.princeton.cs.algorithms.UF;

/**
 * Created by dhx on 2018/6/20.
 */
public class KruskalMST implements MST {

    private Queue<Edge> mst = new Queue<>();

    public KruskalMST(EdgeWeightedGraph edgeWeightedGraph) {
        MinPQ<Edge> pq = new MinPQ<>();
        for (Edge edge : edgeWeightedGraph.edges())
            pq.insert(edge);

        UF uf = new UF(edgeWeightedGraph.v());
        while (!pq.isEmpty() && mst.size() < edgeWeightedGraph.v() - 1) {
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);
            if (!uf.connected(v, w)) {
                uf.union(v, w);
                mst.enqueue(e);
            }
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
}
