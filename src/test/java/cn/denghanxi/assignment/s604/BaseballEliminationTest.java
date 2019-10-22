package cn.denghanxi.assignment.s604;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class BaseballEliminationTest {

    @Test
    public void simpleTest() {
        File file = new File(BaseballElimination.class.getResource("/assignment/s604/baseball/teams4.txt").getFile());
        BaseballElimination baseballElimination = new BaseballElimination(file.getPath());
//        BaseballElimination baseballElimination = new BaseballElimination("/tinyFN.txt");
        assertTrue(baseballElimination.isEliminated("Montreal"));
    }

    @Test
    public void testTeams12() {
        File file = new File(BaseballElimination.class.getResource("/assignment/s604/baseball/teams12.txt").getFile());
        BaseballElimination baseballElimination = new BaseballElimination(file.getPath());
        assertTrue(baseballElimination.isEliminated("Egypt"));
        for (String team : baseballElimination.teams()) {
            if (baseballElimination.isEliminated(team)) {
                StdOut.print(team + " is eliminated by the subset R = { ");
                for (String t : baseballElimination.certificateOfElimination(team)) {
                    StdOut.print(t + " ");
                }
                StdOut.println("}");
            }
            else {
                StdOut.println(team + " is not eliminated");
            }
        }
    }
}