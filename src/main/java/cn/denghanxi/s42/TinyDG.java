package cn.denghanxi.s42;

import edu.princeton.cs.introcs.In;

import java.io.File;

public class TinyDG {
    public static Digraph getTinyDG() {
        File currentDirFile = new File(".");
        return new Digraph(new In(TinyDG.class.getResource("/tinyDG.txt")));
    }
}
