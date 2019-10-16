package cn.denghanxi.s51;

/**
 * 流量网络的边
 */
public class FlowEdge {
    private final int v; //边的起点
    private final int w; //边的终点
    private final double capacity; //边的容量
    private double flow; //边中已有流量

    public FlowEdge(int v, int w, double cap) {
        this.v = v;
        this.w = w;
        this.capacity = cap;
        this.flow = 0.0;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    public int other(int v) {
        if (v == this.v)
            return w;
        if (v == this.w)
            return this.v;
        throw new IllegalArgumentException("Not v or w");
    }

    public double capacity() {
        return capacity;
    }

    public double flow() {
        return flow;
    }

    //计算剩余网络的流量z
    public double residualFlowTo(int vertex) {
        if (vertex == v) return flow; //方向与流量方向相反，返回的是逆向边流量
        else if (vertex == w) return capacity - flow; //方向与流量方向相同，返回正向边流量
        else throw new IllegalArgumentException("Inconsistent edge");
    }

    public void addResidualFlowTo(int vertex, double delta) {
        if (vertex == v) flow -= delta;
        else if (vertex == w) flow += delta;
        else throw new IllegalArgumentException("Inconsistent edge");
    }

    @Override
    public String toString() {
        return String.format("%d->%d %.2f %.2f", v, w, capacity, flow);
    }
}
