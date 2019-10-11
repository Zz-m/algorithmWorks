package cn.denghanxi.assignment.s44;

import edu.princeton.cs.algs4.Picture;

import java.awt.Color;


/**
 * SeamCarver 算法，resizing图片
 */
public class SeamCarver {

    private int w;
    private int h;
    private Picture picture;
    private double[][] energyMap;

    // create a seam carver object based on the given picture
    public SeamCarver(Picture picture) {
        if (picture == null) throw new IllegalArgumentException("SeamCarver null");
        this.picture = copyPicture(picture);
        w = this.picture.width();
        h = this.picture.height();
        energyMap = computeEnergyMap(this.picture);
    }

    // current picture
    public Picture picture() {
        return copyPicture(picture);
    }

    // width of current picture
    public int width() {
        return w;
    }

    // height of current picture
    public int height() {
        return h;
    }

    // energy of pixel at column x and row y
    public double energy(int x, int y) {
        if (x < 0 || y < 0 || x >= w || y >= h)
            throw new IllegalArgumentException("energy out of range.");
        if (x == 0 || y == 0 || x == w - 1 || y == h - 1) return 1000.0;
        Color left = picture.get(x - 1, y);
        Color right = picture.get(x + 1, y);
        Color up = picture.get(x, y - 1);
        Color down = picture.get(x, y + 1);

        double deltaX2 = Math.pow(left.getRed() - right.getRed(), 2) +
                Math.pow(left.getGreen() - right.getGreen(), 2) +
                Math.pow(left.getBlue() - right.getBlue(), 2);
        double deltaY2 = Math.pow(up.getRed() - down.getRed(), 2) +
                Math.pow(up.getGreen() - down.getGreen(), 2) +
                Math.pow(up.getBlue() - down.getBlue(), 2);
        return Math.sqrt(deltaX2 + deltaY2);
    }

    // sequence of indices for horizontal seam
    public int[] findHorizontalSeam() {
        double[][] dist = computeEnergyMap(picture);
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (i != 0) {
                    double preDist = dist[i - 1][j];
                    if (j - 1 >= 0 && preDist > dist[i - 1][j - 1]) {
                        preDist = dist[i - 1][j - 1];
                    }
                    if (j + 1 < h && preDist > dist[i - 1][j + 1]) {
                        preDist = dist[i - 1][j + 1];
                    }
                    dist[i][j] = preDist + dist[i][j];
                }
            }
        }
        int[] path = new int[w];
        for (int i = w - 1; i >= 0; i--) {
            if (i == w - 1) {
                int minJ = 0;
                double minEnergy = Double.POSITIVE_INFINITY;
                for (int j = 0; j < h; j++) {
                    if (dist[i][j] < minEnergy) {
                        minEnergy = dist[i][j];
                        minJ = j;
                    }
                }
                path[w - 1] = minJ;
            } else {
                int curJ = path[i + 1];
                int targetJ = curJ;
                double curDist = dist[i][curJ];
                if (curJ - 1 >= 0 && dist[i][curJ - 1] < curDist) {
                    curDist = dist[i][curJ - 1];
                    targetJ = curJ - 1;
                }
                if (curJ + 1 < h && dist[i][curJ + 1] < curDist) {
                    curDist = dist[i][curJ + 1];
                    targetJ = curJ + 1;
                }
                path[i] = targetJ;
            }
        }

        return path;
    }

    // sequence of indices for vertical seam
    public int[] findVerticalSeam() {
        double[][] dist = computeEnergyMap(picture);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (i != 0) {
                    double preDist = dist[j][i - 1];
                    if (j - 1 >= 0 && dist[j - 1][i - 1] < preDist) {
                        preDist = dist[j - 1][i - 1];
                    }
                    if (j + 1 < w && dist[j + 1][i - 1] < preDist) {
                        preDist = dist[j + 1][i - 1];
                    }
                    dist[j][i] += preDist;
                }
            }
        }
        int[] path = new int[h];
        for (int i = h - 1; i >= 0; i--) {
            if (i == h - 1) {
                int minJ = 0;
                double minDist = Double.POSITIVE_INFINITY;
                for (int j = 0; j < w; j++) {
                    if (dist[j][i] < minDist) {
                        minJ = j;
                        minDist = dist[j][i];
                    }
                }
                path[h - 1] = minJ;
            } else {
                int curJ = path[i + 1];
                int targetJ = curJ;
                double curDist = dist[curJ][i];
                if (curJ - 1 >= 0 && dist[curJ - 1][i] < curDist) {
                    curDist = dist[curJ - 1][i];
                    targetJ = curJ - 1;
                }
                if (curJ + 1 < w && dist[curJ + 1][i] < curDist) {
                    curDist = dist[curJ + 1][i];
                    targetJ = curJ + 1;
                }
                path[i] = targetJ;
            }
        }

        return path;
    }

    // remove horizontal seam from current picture
    public void removeHorizontalSeam(int[] seam) {
        if (seam == null) throw new IllegalArgumentException("removeHorizontalSeam null");
        if (h < 2) throw new IllegalArgumentException("h < 2");
        if (seam.length != w) throw new IllegalArgumentException("seam.length != w");
        checkSeam(seam);

        Picture newPic = new Picture(picture.width(), picture.height() - 1);
        for (int i = 0; i < picture.width(); i++) {
            for (int j = 0; j < picture.height(); j++) {
                if (j < seam[i]) {
                    newPic.set(i, j, picture.get(i, j));
                } else if (j > seam[i]) {
                    newPic.set(i, j - 1, picture.get(i, j));
                }
            }
        }
        update(newPic);
    }

    // remove vertical seam from current picture
    public void removeVerticalSeam(int[] seam) {
        if (seam == null) throw new IllegalArgumentException("removeVerticalSeam null");
        if (w < 2) throw new IllegalArgumentException("w < 2");
        if (seam.length != h) throw new IllegalArgumentException("seam.length != h");
        checkSeam(seam);

        Picture newPic = new Picture(picture.width() - 1, picture.height());
        for (int i = 0; i < picture.height(); i++) {
            for (int j = 0; j < picture.width(); j++) {
                if (j < seam[i]) {
                    newPic.set(j, i, picture.get(j, i));
                } else if (j > seam[i]) {
                    newPic.set(j - 1, i, picture.get(j, i));
                }
            }
        }
        update(newPic);
    }

    private void checkSeam(int[] seam) {
        for (int i = 0; i < seam.length; i++) {
            if (i > 0) {
                if (seam[i] - seam[i - 1] > 1 || seam[i] - seam[i - 1] < -1)
                    throw new IllegalArgumentException("seam out of range");
            }
        }
    }

    private double[][] computeEnergyMap(Picture picture) {
        double[][] energyMap = new double[picture.width()][picture.height()];
        for (int i = 0; i < picture.width(); i++) {
            for (int j = 0; j < picture.height(); j++) {
                energyMap[i][j] = energy(i, j);
            }
        }
        return energyMap;
    }

    private void update(Picture picture) {
        this.picture = picture;
        this.w = picture.width();
        this.h = picture.height();
        this.energyMap = computeEnergyMap(picture);
    }

    private Picture copyPicture(Picture picture) {
        Picture newPic = new Picture(picture.width(), picture.height());
        for (int i = 0; i < picture.height(); i++) {
            for (int j = 0; j < picture.width(); j++) {
                newPic.set(j, i, picture.get(j, i));
            }
        }
        return newPic;
    }

}

