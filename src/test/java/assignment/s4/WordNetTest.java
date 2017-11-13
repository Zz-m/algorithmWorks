package assignment.s4;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class WordNetTest {

    @Test
    public void testRead() {
        File currentDirFile = new File(".");
        String path = (currentDirFile.getAbsolutePath() + "/res/assignment/s42/wordnet/synsets100-subgraph.txt");
        In in = new In(path);
        while (true) {
            String inString = in.readLine();
            if (inString == null) break;
            String[] ss = inString.split(",");
            int key = Integer.parseInt(ss[0]);
            String[] values = ss[1].split(" ");
            Set<String> valuesSet = new HashSet<>();
            valuesSet.addAll(Arrays.asList(values));
            StdOut.print("key: " + key + " value: ");
            for (String s: values) {
                StdOut.print(" " + s + " ");
            }
            StdOut.println();
        }
        StdOut.println("---finish---");
    }

}