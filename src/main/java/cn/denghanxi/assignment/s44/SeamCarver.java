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
        this.picture = picture;
        w = picture.width();
        h = picture.height();
        energyMap = computeEnergyMap(picture);
    }

    // current picture
    public Picture picture() {
        return picture;
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
        double totalEnergy = Double.POSITIVE_INFINITY;
        int[] path = null;

        for (int i = 0; i < h; i++) {
            double tmpTotalEnergy = 0.0;
            int[] tmpPath = new int[w];
            int tmpY = i;
            tmpTotalEnergy += energyMap[0][tmpY];
            tmpPath[0] = i;
            for (int j = 1; j < w; j++) {
                int nextY = tmpY;
                double tmpEnergy = energyMap[j][nextY];
                if (tmpY - 1 >= 0) {
                    if (tmpEnergy > energyMap[j][nextY - 1]) {
                        nextY = tmpY - 1;
                    }
                }
                if (tmpY + 1 < h) {
                    if (tmpEnergy > energyMap[j][nextY + 1]) {
                        nextY = tmpY + 1;
                    }
                }
                tmpY = nextY;
                tmpTotalEnergy += energyMap[j][tmpY];
                tmpPath[j] = tmpY;
            }
            if (totalEnergy > tmpTotalEnergy) {
                totalEnergy = tmpTotalEnergy;
                path = tmpPath;
            }
        }

        return path;
    }

    // sequence of indices for vertical seam
    public int[] findVerticalSeam() {
        double totalEnergy = Double.POSITIVE_INFINITY;
        int[] path = null;
        for (int i = 0; i < w; i++) {
            double tmpTotalEnergy = 0.0;
            int[] tmpPath = new int[h];
            int tmpX = i;
            tmpTotalEnergy += energyMap[tmpX][0];
            tmpPath[0] = i;
            for (int j = 1; j < h; j++) {
                int nextX = tmpX;
                double tmpEnergy = energyMap[nextX][j];
                if (tmpX - 1 >= 0) {
                    if (tmpEnergy > energyMap[nextX - 1][j]) {
                        nextX = tmpX - 1;
                    }
                }
                if (tmpX + 1 < w) {
                    if (tmpEnergy > energyMap[nextX + 1][j]) {
                        nextX = tmpX + 1;
                    }
                }
                tmpX = nextX;
                tmpTotalEnergy += energyMap[tmpX][j];
                tmpPath[j] = tmpX;
            }
            if (totalEnergy > tmpTotalEnergy) {
                totalEnergy = tmpTotalEnergy;
                path = tmpPath;
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
    }

    private void checkSeam(int[] seam) {
        for (int i = 0; i < seam.length; i++) {
            if (i > 0 && i < seam.length - 1) {
                if (seam[i] - seam[i + 1] > 1 || seam[i] - seam[i + 1] < -1)
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

}

