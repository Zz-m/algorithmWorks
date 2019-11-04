package cn.denghanxi.assignment.s53;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoggleSolverTest {

    private String[] dicCommon;
    private String[] dicAlg4;
    private BoggleBoard boggleBoardP100;
    private BoggleBoard boggleBoardP4x4;
    private BoggleBoard boggleBoardQ;

    @Before
    public void setUp() throws Exception {
        dicCommon = new In(BoggleSolverTest.class.getResource("/assignment/s53/boggle/dictionary-common.txt")).readAllStrings();
        dicAlg4 = new In(BoggleSolverTest.class.getResource("/assignment/s53/boggle/dictionary-algs4.txt")).readAllStrings();

        boggleBoardP100 = new BoggleBoard(BoggleSolverTest.class.getResource("/assignment/s53/boggle/board-points100.txt").toString());
        boggleBoardP4x4 = new BoggleBoard(BoggleSolverTest.class.getResource("/assignment/s53/boggle/board4x4.txt").toString());
        boggleBoardQ = new BoggleBoard(BoggleSolverTest.class.getResource("/assignment/s53/boggle/board-q.txt").toString());
    }

    @Test
    public void scoreOf() {
        BoggleSolver boggleSolver  = new BoggleSolver(dicCommon);
        assertEquals(0, boggleSolver.scoreOf("ASD"), boggleSolver.scoreOf("ASDS"));

        BoggleSolver boggleSolverAlg4 = new BoggleSolver(dicAlg4);
        assertEquals(11, boggleSolverAlg4.scoreOf("REMEMBER"));
    }

    @Test
    public void test100() {
        BoggleSolver boggleSolver  = new BoggleSolver(dicCommon);
        Iterable<String> strings = boggleSolver.getAllValidWords(boggleBoardP100);
        int score = 0;
        for (String s : strings) {
            StdOut.println(s);
            score += boggleSolver.scoreOf(s);
        }
        StdOut.println(score);
    }

    @Test
    public void test4x4() {
        BoggleSolver boggleSolver  = new BoggleSolver(dicAlg4);
        Iterable<String> strings = boggleSolver.getAllValidWords(boggleBoardP4x4);
        int score = 0;
        for (String s : strings) {
            StdOut.println(s);
            score += boggleSolver.scoreOf(s);
        }
        StdOut.println(score);
    }

    @Test
    public void testBoardQ() {
        BoggleSolver boggleSolver  = new BoggleSolver(dicAlg4);
        Iterable<String> strings = boggleSolver.getAllValidWords(boggleBoardQ);
        int score = 0;
        for (String s : strings) {
            StdOut.println(s);
            score += boggleSolver.scoreOf(s);
        }
        StdOut.println(score);
    }
}