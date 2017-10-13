package s42;

import edu.princeton.cs.introcs.In;

import java.io.File;

public class TinyDAG {
    public static Digraph getTinyDAG() {
        File currentDirFile = new File(".");
        return new Digraph(new In(currentDirFile.getAbsolutePath() + "/res/tinyDAG.txt"));
    }
}
