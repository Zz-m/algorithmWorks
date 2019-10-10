package cn.denghanxi.s42;


import cn.denghanxi.s44.DirectedEdge;
import cn.denghanxi.s44.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * 深度优先搜索排序，支持前序、后序、逆后序
 */
public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre; //顶点的前序排列
    private Queue<Integer> post; //顶点的后序排列
    private Stack<Integer> reversePost; //顶点的逆后序排列

    /**
     * 有向图的排序
     * @param digraph 有向图
     */
    public DepthFirstOrder(Digraph digraph) {
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();
        marked = new boolean[digraph.v()];
        for (int i = 0; i < digraph.v(); i++)
            if (!marked[i]) dfs(digraph, i);
    }

    /**
     * 加权有向图的排序
     * @param edgeWeightedDigraph 加权有向图
     */
    public DepthFirstOrder(EdgeWeightedDigraph edgeWeightedDigraph) {
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();
        marked = new boolean[edgeWeightedDigraph.v()];
        for (int i = 0; i < edgeWeightedDigraph.v(); i++)
            if (!marked[i]) dfs(edgeWeightedDigraph, i);
    }

    private void dfs(Digraph digraph, int v) {
        pre.enqueue(v);
        marked[v] = true;
        for (int w : digraph.adj(v))
            if (!marked[w])
                dfs(digraph, w);
        post.enqueue(v);
        reversePost.push(v);
    }

    private void dfs(EdgeWeightedDigraph edgeWeightedDigraph, int v) {
        pre.enqueue(v);
        marked[v] = true;
        for (DirectedEdge edge : edgeWeightedDigraph.adj(v))
            if (!marked[edge.to()])
                dfs(edgeWeightedDigraph, edge.to());
        post.enqueue(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }
}
