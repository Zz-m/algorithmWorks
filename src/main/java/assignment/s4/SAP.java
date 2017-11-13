package assignment.s4;

import edu.princeton.cs.algorithms.BreadthFirstDirectedPaths;
import edu.princeton.cs.algorithms.Digraph;

/**
 * shortest ancestral path
 * 两个顶点v,w。他们最近的共同祖先节点
 *
 * 目前解法，对两个source进行完整的BFS，从头遍历，找到都连接source并且距离之和最小的节点
 *
 * 优化：不用完整BFS，依次对两个source BFS ，找到共同的就停止？
 */
public class SAP {

    Digraph digraph;

    public SAP(Digraph digraph) {
        if (digraph == null) throw new IllegalArgumentException("constructor null");
        this.digraph = digraph;
    }

    public int length(int v, int w) {
        if (v < 0 || w < 0 || v >= digraph.V() || w > digraph.V()) throw new IllegalArgumentException("outOfRange");
        BreadthFirstDirectedPaths pathsToV = new BreadthFirstDirectedPaths(digraph, v);
        BreadthFirstDirectedPaths pathsToW = new BreadthFirstDirectedPaths(digraph, w);
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < digraph.V(); i++) {
            if (pathsToV.hasPathTo(i) && pathsToW.hasPathTo(i))
                if ((pathsToV.distTo(i) + pathsToW.distTo(i) < shortest))
                    shortest = pathsToV.distTo(i) + pathsToW.distTo(i);
        }
        if (shortest != Integer.MAX_VALUE) {
            return shortest;
        } else {
            return -1;
        }
    }

    public int ancestor(int v, int w) {
        if (v < 0 || w < 0 || v >= digraph.V() || w > digraph.V()) throw new IllegalArgumentException("outOfRange");
        BreadthFirstDirectedPaths pathsToV = new BreadthFirstDirectedPaths(digraph, v);
        BreadthFirstDirectedPaths pathsToW = new BreadthFirstDirectedPaths(digraph, w);
        int shortest = Integer.MAX_VALUE;
        int ancestor = -1;
        for (int i = 0; i < digraph.V(); i++) {
            if (pathsToV.hasPathTo(i) && pathsToW.hasPathTo(i))
                if ((pathsToV.distTo(i) + pathsToW.distTo(i) < shortest)) {
                    shortest = pathsToV.distTo(i) + pathsToW.distTo(i);
                    ancestor = i;
                }
        }
        return ancestor;
    }

    public int length(Iterable<Integer> v, Iterable<Integer> w) {
        for (int i : v) {
            if (i < 0 || i > digraph.V()) throw new IllegalArgumentException("outOfRange");
        }
        for (int i : w) {
            if (i < 0 || i > digraph.V()) throw new IllegalArgumentException("outOfRange");
        }
        BreadthFirstDirectedPaths pathsToV = new BreadthFirstDirectedPaths(digraph, v);
        BreadthFirstDirectedPaths pathsToW = new BreadthFirstDirectedPaths(digraph, w);
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < digraph.V(); i++) {
            if (pathsToV.hasPathTo(i) && pathsToW.hasPathTo(i))
                if ((pathsToV.distTo(i) + pathsToW.distTo(i) < shortest))
                    shortest = pathsToV.distTo(i) + pathsToW.distTo(i);
        }
        if (shortest != Integer.MAX_VALUE) {
            return shortest;
        } else {
            return -1;
        }
    }

    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        for (int i : v) {
            if (i < 0 || i > digraph.V()) throw new IllegalArgumentException("outOfRange");
        }
        for (int i : w) {
            if (i < 0 || i > digraph.V()) throw new IllegalArgumentException("outOfRange");
        }
        BreadthFirstDirectedPaths pathsToV = new BreadthFirstDirectedPaths(digraph, v);
        BreadthFirstDirectedPaths pathsToW = new BreadthFirstDirectedPaths(digraph, w);
        int shortest = Integer.MAX_VALUE;
        int ancestor = -1;
        for (int i = 0; i < digraph.V(); i++) {
            if (pathsToV.hasPathTo(i) && pathsToW.hasPathTo(i))
                if ((pathsToV.distTo(i) + pathsToW.distTo(i) < shortest)) {
                    shortest = pathsToV.distTo(i) + pathsToW.distTo(i);
                    ancestor = i;
                }
        }
        return ancestor;
    }

    public static void main(String[] args) {

    }

}
