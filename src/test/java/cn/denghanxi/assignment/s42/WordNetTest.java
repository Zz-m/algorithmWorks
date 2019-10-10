package cn.denghanxi.assignment.s42;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordNetTest {

    @Test
    public void testRead() {
        In in = new In(WordNetTest.class.getResource("/assignment/s42/wordnet/synsets100-subgraph.txt"));
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