package cn.denghanxi.s604;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * 流量网络
 */
public class FlowNetWork {

    private int v;
    private int e;
    private Bag<FlowEdge>[] adj; //邻接表

    @SuppressWarnings("unchecked")
    public FlowNetWork(int v) {
        this.v = v;
        this.adj = (Bag<FlowEdge>[]) (new Bag[v]);
        for (int i = 0; i < v; i++) {
            this.adj[i] = new Bag<>();
        }
    }

    @SuppressWarnings("unchecked")
    public FlowNetWork(In in) {
        this.v = in.readInt();
        this.adj = (Bag<FlowEdge>[]) (new Bag[v]);
        for (int i = 0; i < v; i++) {
            this.adj[i] = new Bag<>();
        }
        int edgeNum = in.readInt();
        for (int i = 0; i < edgeNum; i++) {
            FlowEdge edge = new FlowEdge(in.readInt(), in.readInt(), in.readDouble());
            addEdge(edge);
        }
    }

    public int v() {
        return v;
    }

    public int e() {
        return e;
    }

    public void addEdge(FlowEdge edge) {
        Bag<FlowEdge> bag = adj[edge.from()];
        bag.add(edge);
        e++;
    }

    public Iterable<FlowEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<FlowEdge> edges() {
        Bag<FlowEdge> result = new Bag<>();
        for (Bag<FlowEdge> flowEdges : adj) {
            for (FlowEdge edge : flowEdges) {
                result.add(edge);
            }
        }
        return result;
    }

    public static FlowNetWork tinyFN() {
        return new FlowNetWork(new In(FlowNetWork.class.getResource("/tinyFN.txt")));
    }
}
