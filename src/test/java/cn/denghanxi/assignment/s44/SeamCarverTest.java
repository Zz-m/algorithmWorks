package cn.denghanxi.assignment.s44;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.Picture;
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
        assertEquals(stringBuilder.toString(), "121211");
        seamCarver.removeHorizontalSeam(horizontalSeam);
    }

    @Test
    public void testVertical() {

        SeamCarver seamCarver = new SeamCarver(picture);
        int[] verticalSeam = seamCarver.findVerticalSeam();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < verticalSeam.length; i++) {
            stringBuilder.append(verticalSeam[i]);
        }
        assertEquals(stringBuilder.toString(), "44322");
        seamCarver.removeVerticalSeam(verticalSeam);
    }

}