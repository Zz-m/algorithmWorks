package cn.denghanxi.s604;

import edu.princeton.cs.algs4.Queue;

/**
 * Ford-Fulkerson 最大流量算法
 */
public class FordFulkerson {
    private boolean[] marked; //在剩余网络中，是否存在从s到v的路径
    private FlowEdge[] edgeTo; //从s到v的最短路径上的最后一条边
    private double value; //当前最大流

    public FordFulkerson(FlowNetWork graph, int s, int t) {
        while (hasAugmentingPath(graph, s, t)) {
            double bottle = Double.POSITIVE_INFINITY;
            for (int v = t; v != s; v = edgeTo[v].other(v))
                bottle = Math.min(bottle, edgeTo[v].residualFlowTo(v));

            for (int v = t; v != s; v = edgeTo[v].other(v))
                edgeTo[v].addResidualFlowTo(v, bottle);

            value += bottle;
        }
    }

    public double value() {
        return value;
    }

    public boolean inCut(int v) {
        return marked[v];
    }

    // 检测是否还有增广路径
    private boolean hasAugmentingPath(FlowNetWork graph, int s, int t) {
        marked = new boolean[graph.v()];
        edgeTo = new FlowEdge[graph.v()];
        Queue<Integer> q = new Queue<>();

        marked[s] = true;
        q.enqueue(s);
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (FlowEdge edge : graph.adj(v)) {
                int w = edge.other(v);
                if (edge.residualFlowTo(w) > 0 && !marked[w]) {
                    edgeTo[w] = edge;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
        return marked[t];
    }
}
