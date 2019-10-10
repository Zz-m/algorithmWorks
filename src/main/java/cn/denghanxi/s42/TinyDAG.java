package cn.denghanxi.s42;

import edu.princeton.cs.algs4.In;

import java.io.File;

/**
 * 有向无环图
 */
public class TinyDAG {
    public static Digraph getTinyDAG() {
        File currentDirFile = new File(".");
        return new Digraph(new In(TinyDAG.class.getResource("/tinyDAG.txt")));
    }
}
