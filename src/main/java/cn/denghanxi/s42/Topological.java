package cn.denghanxi.s42;

import cn.denghanxi.s44.EdgeWeightedDigraph;

/**
 * 有向图的拓扑排序
 */
public class Topological {

    private Iterable<Integer> order; //顶点的拓扑排序

    /**
     * 有向图的拓扑排序
     * @param digraph 有向图
     */
    public Topological(Digraph digraph) {
        DirectedCycle cycleFinder = new DirectedCycle(digraph);
        if (!cycleFinder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(digraph);
            order = dfs.reversePost();
        }
    }

    /**
     * 对加权有向图的拓扑排序
     * @param graph 加权有向图
     */
    public Topological(EdgeWeightedDigraph graph) {
        DirectedCycle cycleFinder = new DirectedCycle(graph);
        if (!cycleFinder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(graph);
            order = dfs.reversePost();
        }
    }

    public Iterable<Integer> getOrder() {
        return order;
    }

    public boolean isDAG() {
        return order != null;
    }
}
