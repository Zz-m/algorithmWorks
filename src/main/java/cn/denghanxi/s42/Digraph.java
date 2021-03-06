package cn.denghanxi.s42;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Digraph {
    private final int v;
    private int e;
    private Bag<Integer>[] adj;

    public Digraph(int v) {
        this.v = v;
        this.e = 0;
        adj = (Bag<Integer>[]) new Bag[v];
        for (int i = 0; i < v; i++)
            adj[i] = new Bag<>();
    }

    public Digraph(In in) {
        try {
            this.v = in.readInt();
            if (this.v < 0) {
                throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
            } else {
                this.adj = (Bag[]) (new Bag[this.v]);

                for (int i = 0; i < this.v; ++i) {
                    this.adj[i] = new Bag();
                }

                int E;
                E = in.readInt();
                if (E < 0) {
                    throw new IllegalArgumentException("Number of edges in a Digraph must be nonnegative");
                } else {
                    for (int i = 0; i < E; ++i) {
                        int v = in.readInt();
                        int w = in.readInt();
                        this.addEdge(v, w);
                    }

                }
            }
        } catch (NoSuchElementException var6) {
            throw new InputMismatchException("Invalid input format in Digraph constructor");
        }
    }

    public int v() {
        return v;
    }

    public int e() {
        return e;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        e++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph reverse = new Digraph(v);
        for (int i = 0; i < v; i++)
            for (int w : adj(i))
                reverse.addEdge(w, i);
        return reverse;
    }
}
