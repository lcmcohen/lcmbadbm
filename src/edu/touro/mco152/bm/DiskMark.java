package edu.touro.mco152.bm;

import java.text.DecimalFormat;

/**
 * this class represents the data for one benchmark test.
 *
 * this measures the in megabytes per second the read or write for single
 * benchmarking test. It also measures other statistics like the min, max, and avg
 * over all benchmark tests.
 *
 * there are also helper methods to help format the values for display in the UI.
 *
 * @author Reuvi Kupchik.
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

    /**
     * basic getter that returns the measured disk bandwidth for this mark.
     *
     * @return the bandwidth in megabytes per second.
     */
    public double getBwMbSec() {
        return bwMbSec;
    }

    /**
     * standard setter that sets the measured disk bandwidth for this mark
     *
     * @param bwMbSec is the bandwidth value in megabytes per second.
     */
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
