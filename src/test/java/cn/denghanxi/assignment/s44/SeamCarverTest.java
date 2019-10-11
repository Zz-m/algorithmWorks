package cn.denghanxi.assignment.s44;

import edu.princeton.cs.algs4.Picture;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.net.URI;
import java.net.URL;

import static org.junit.Assert.*;

public class SeamCarverTest {

    private Picture picture;

    @Before
    public void getPic() throws Exception {
        URL url = SeamCarverTest.class.getResource("/assignment/s44/seamcarving/6x5.png");
        this.picture = new Picture(new File(url.toURI()));
    }

    @Test
    public void simpleTest() {
        SeamCarver seamCarver = new SeamCarver(picture);
        assertEquals(6, seamCarver.picture().width());
        assertEquals(5, seamCarver.picture().height());
        assertEquals(1000.0, seamCarver.energy(0, 0), 0.1);
        assertEquals(237.35, seamCarver.energy(1, 1), 0.1);
        for (int i = 0; i < seamCarver.height(); i++) {
            for (int j = 0; j < seamCarver.width(); j++) {
                System.out.print(seamCarver.energy(j, i));
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    @Test
    public void testHorizontal() {
        SeamCarver seamCarver = new SeamCarver(picture);
        int[] horizontalSeam = seamCarver.findHorizontalSeam();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < horizontalSeam.length; i++) {
            stringBuilder.append(horizontalSeam[i]);
        }
        //算法首尾元素一定范围可变，都是正常的
        stringBuilder.deleteCharAt(0);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        assertEquals(stringBuilder.toString(), "2121");
        seamCarver.removeHorizontalSeam(horizontalSeam);
        assertEquals(6, seamCarver.picture().width());
        assertEquals(4, seamCarver.picture().height());
    }

    @Test
    public void testVertical() {

        SeamCarver seamCarver = new SeamCarver(picture);
        int[] verticalSeam = seamCarver.findVerticalSeam();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < verticalSeam.length; i++) {
            stringBuilder.append(verticalSeam[i]);
        }
        //算法首尾元素一定范围可变，都是正常的
        stringBuilder.deleteCharAt(0);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        assertEquals(stringBuilder.toString(), "432");
        seamCarver.removeVerticalSeam(verticalSeam);
        assertEquals(5, seamCarver.picture().width());
        assertEquals(5, seamCarver.picture().height());
    }

}