package cn.denghanxi.s44;


import edu.princeton.cs.algorithms.Queue;
import edu.princeton.cs.algorithms.Stack;

/**
 * Bellman-Ford 最短路径算法，可以解决负权重边，并检测负权重环
 */
public class BellmanFordSP implements SP {

    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private boolean[] onQ; //该顶点是否在队列中
    private Queue<Integer> queue;
    private int cost; //relax()被调用次数
    private Iterable<DirectedEdge> cycle; //edgeTo[] 中是否有负权重环

    public BellmanFordSP(EdgeWeightedDigraph graph, int s) {
        distTo = new double[graph.v()];
        edgeTo = new DirectedEdge[graph.v()];
        onQ = new boolean[graph.v()];
        queue = new Queue<>();
        for (int i = 0; i < graph.v(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;
        queue.enqueue(s);
        onQ[s] = true;
        while (!queue.isEmpty() && !hasNegativeCycle()) {
            int v = queue.dequeue();
            onQ[v] = false;
            relax(graph, v);
        }
    }

    private void relax(EdgeWeightedDigraph graph, int v) {
        for (DirectedEdge edge : graph.adj(v)) {
            int w = edge.to();
            if (distTo[w] > distTo[v] + edge.weight()) {
                distTo[w] = distTo[v] + edge.weight();
                edgeTo[w] = edge;
                if (!onQ[w]) {
                    queue.enqueue(w);
                    onQ[w] = true;
                }
            }
            if (cost++ % graph.v() == 0) {
                findNegativeCycle();
            }
        }
    }

    @Override
    public double distTo(int v) {
        return distTo[v];
    }

    @Override
    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
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

    private void findNegativeCycle() {
        int v = edgeTo.length;
        EdgeWeightedDigraph spt = new EdgeWeightedDigraph(v);
        for (int i = 0; i < v; i++) {
            if (edgeTo[i] != null) {
                spt.addEdge(edgeTo[i]);
            }
        }
        EdgeWeightedDirectedCycle cf = new EdgeWeightedDirectedCycle(spt);
        cycle = cf.cycle();
    }

    public boolean hasNegativeCycle() {
        return cycle != null;
    }

    public Iterable<DirectedEdge> negativeCycle() {
        return cycle;
    }
}
