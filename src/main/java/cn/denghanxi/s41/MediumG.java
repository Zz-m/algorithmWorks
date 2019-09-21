package cn.denghanxi.s41;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

import java.io.File;

public class MediumG {
    private MediumG() {
    }

    public static Graph getMediumG() {
        return new Graph(new In(MediumG.class.getResource("/mediumG.txt")));
    }

}
