package edu.touro.mco152.bm;

import java.text.DecimalFormat;

/**
 * ֿReturns the progress of the DiskWorker in various formats.
 * This class holds variables that define the progress of the
 * read and write operations. It includes setters for each of
 * these variables, as well as getters.
 * The getters enable the variables to be returned as doubles
 * (their actual data type) or to be formatted into a string,
 * by use of the DecimalFormat class.
 */
public class DiskMark {

    static DecimalFormat df = new DecimalFormat("###.###");
    MarkType type;
    private int markNum = 0;       // x-axis
    private double bwMbSec = 0;    // y-axis
    private double cumMin = 0;
    private double cumMax = 0;
    private double cumAvg = 0;
    DiskMark(MarkType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Mark(" + type + "): " + getMarkNum() + " bwMbSec: " + getBwMbSecAsString() + " avg: " + getAvgAsString();
    }
    /**
     * Returns the megabytes per second of the operation as a string.
     * This method is a modified getter. It is used to get the double
     * value of the poorly named BwMbSec, which is the megabytes
     * processed per second. However, it returns it as a
     * formatted String, using the DecimalFormat class.
     * @return    a string representing the megabytes processed per second
    */
    String getBwMbSecAsString() {
        return df.format(getBwMbSec());
    }

    String getMinAsString() {
        return df.format(getCumMin());
    }

    String getMaxAsString() {
        return df.format(getCumMax());
    }

    String getAvgAsString() {
        return df.format(getCumAvg());
    }

    public int getMarkNum() {
        return markNum;
    }

    public void setMarkNum(int markNum) {
        this.markNum = markNum;
    }

    public double getBwMbSec() {
        return bwMbSec;
    }

    public void setBwMbSec(double bwMbSec) {
        this.bwMbSec = bwMbSec;
    }

    public double getCumAvg() {
        return cumAvg;
    }

    public void setCumAvg(double cumAvg) {
        this.cumAvg = cumAvg;
    }

    public double getCumMin() {
        return cumMin;
    }

    public void setCumMin(double cumMin) {
        this.cumMin = cumMin;
    }

    public double getCumMax() {
        return cumMax;
    }

    public void setCumMax(double cumMax) {
        this.cumMax = cumMax;
    }

    public enum MarkType {READ, WRITE}
}
