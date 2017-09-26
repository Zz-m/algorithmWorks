package s41;

import edu.princeton.cs.algorithms.Queue;
import edu.princeton.cs.algorithms.Stack;
import edu.princeton.cs.introcs.StdOut;

/**
 * 广度优先搜索路径--最短路径
 */
public class BreadthFirstPaths implements Paths {

    private boolean[] marked;
    private int[] edgeTo;
    private final int s; //起点

    BreadthFirstPaths(Graph graph, int s) {
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        this.s = s;
        bsf(graph, s);
    }

    private void bsf(Graph graph, int s) {
        Queue<Integer> queue = new Queue<>();
        marked[s] = true;
        queue.enqueue(s);
        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            for (int w : graph.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.enqueue(w);
                }
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }

    public static void main(String[] args) {
//        Graph graph = TinyG.getTinyG();
        Graph graph = MediumG.getMediumG();
        int s = 1;
        Paths search = new BreadthFirstPaths(graph, s);

        for (int v = 0; v < graph.V(); v++) {
            StdOut.print(s + " to " + v + ": ");
            if (search.hasPathTo(v))
                for (int x : search.pathTo(v))
                    if (x == s) StdOut.print(x);
                    else StdOut.print("-" + x);
            StdOut.println();
        }
    }
}
