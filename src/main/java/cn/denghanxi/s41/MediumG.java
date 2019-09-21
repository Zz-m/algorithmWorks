package cn.denghanxi.s41;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

import java.io.File;

public class MediumG {
    private MediumG() {
    }

    public static Graph getMediumG() {
        File currentDirFile = new File(".");
        System.out.println("ss");
        System.out.println(MediumG.class.getResource("/mediumG.txt"));
//        return new Graph(new In(MediumG.class.getResource("res/mediumG.txt")));
        return new Graph(new In(currentDirFile.getAbsolutePath() + "/res/mediumG.txt"));
    }

    public static void main(String[] args) {
        File currentDirFile = new File(".");
        StdOut.println(currentDirFile.getAbsolutePath() + "/res/mediumG.txt");

        StdOut.println(getMediumG().E());
    }
}
