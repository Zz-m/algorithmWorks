package s42;


import edu.princeton.cs.algorithms.Queue;
import edu.princeton.cs.algorithms.Stack;

public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre; //顶点的前序排列
    private Queue<Integer> post; //顶点的后序排列
    private Stack<Integer> reversePost; //顶点的逆后序排列

    public DepthFirstOrder(Digraph digraph) {
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();
        marked = new boolean[digraph.v()];
        for (int i = 0; i < digraph.v(); i++)
            if (!marked[i]) dfs(digraph, i);
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
