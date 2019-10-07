package cn.denghanxi.s44;

import edu.princeton.cs.algorithms.IndexMinPQ;
import edu.princeton.cs.algorithms.Stack;

/**
 * Dijkstra 最短路径算法
 */
public class DijkstraSP implements SP {

    private double[] distTo; //存储源点到每个顶点的距离
    private DirectedEdge[] edgeTo; //存储源点到每个顶点最短路径过的边
    private IndexMinPQ<Double> pq; //distTo跟v点关联的pq

    public DijkstraSP(EdgeWeightedDigraph graph, int s) {
        edgeTo = new DirectedEdge[graph.v()];
        distTo = new double[graph.v()];
        pq = new IndexMinPQ<>(graph.v());
        for (int i = 0; i < graph.v(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;
        pq.insert(s, 0.0);
        while (!pq.isEmpty()) {
            relax(graph, pq.delMin());
        }
    }

    @Override
    public double distTo(int v) {
        return distTo[v];
    }

    @Override
    public boolean hasPathTo(int v) {
        return distTo[v] != Double.POSITIVE_INFINITY;
    }

    @Override
    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<DirectedEdge> path = new Stack<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }
        return path;
    }

    private void relax(EdgeWeightedDigraph graph, int v) {
        for (DirectedEdge e : graph.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) {
                    pq.changeKey(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }

    private void relax(DirectedEdge e) {
        int v = e.from();
        int w = e.to();
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
        }
    }
}
