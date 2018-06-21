package s43;

/**
 * Created by dhx on 2018/5/9.
 * 加权边
 */
public class Edge implements Comparable<Edge>{

    private int v;
    private int w;
    private double weight;

    public Edge(int v, int w, double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight(){
        return weight;
    }

    public int either(){
        return v;
    }

    public int other(int v) {
        return v == this.v ? w : this.v;
    }

    @Override
    public int compareTo(Edge that) {
        return Double.compare(this.weight, that.weight);
    }

    @Override
    public String toString() {
        return String.format("%d-%d %.2f", v, w, weight);
    }

    public static void main(String[] args) {
        Edge edge = new Edge(1, 7, 3.223);
        System.out.println(edge);
        System.out.println(edge.either());
        System.out.println(edge.other(1));
        System.out.println(edge.other(7));
    }
}
