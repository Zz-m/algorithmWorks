package s41;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class MediumG {
    private MediumG() {
    }

    public static Graph getMediumG() {
        return new Graph(new In("F:\\MediumG.txt"));
    }

    public static void main(String[] args) {
        StdOut.println(getMediumG().E());
    }
}
