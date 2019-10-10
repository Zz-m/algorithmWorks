package cn.denghanxi.s41;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;

public class MediumG {
    private MediumG() {
    }

    public static Graph getMediumG() {
        return new Graph(new In(MediumG.class.getResource("/mediumG.txt")));
    }

}
