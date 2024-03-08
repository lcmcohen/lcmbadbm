package edu.touro.mco152.bm;

import java.text.DecimalFormat;

/**
 * Tracks and records progress as a disk read or write is being executed
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
    /**
     * Returns a string representation of this DiskMark object.
     *
     * @return a string representation of this DiskMark object
     */
    @Override
    public String toString() {
        return "Mark(" + type + "): " + getMarkNum() + " bwMbSec: " + getBwMbSecAsString() + " avg: " + getAvgAsString();
    }
    /**
     * Returns the bandwidth in megabytes per second as a formatted string.
     *
     * @return the bandwidth in megabytes per second as a formatted string
     */
    String getBwMbSecAsString() {
        return df.format(getBwMbSec());
    }
    /**
     * Returns the minimum cumulative value as a formatted string.
     *
     * @return the minimum cumulative value as a formatted string
     */
    String getMinAsString() {
        return df.format(getCumMin());
    }
    /**
     * Returns the maximum cumulative value as a formatted string.
     *
     * @return the maximum cumulative value as a formatted string
     */
    String getMaxAsString() {
        return df.format(getCumMax());
    }
    /**
     * Returns the average cumulative value as a formatted string.
     *
     * @return the average cumulative value as a formatted string
     */
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
     * Returns the bandwidth in megabytes per second
     *
     * @return the bandwidth in megabytes per second
     */
    public double getBwMbSec() {
        return bwMbSec;
    }
    /**
     * Sets the bandwidth in megabytes per second
     *
     * @param bwMbSec the bandwidth in megabytes per second to set
     */
    public void setBwMbSec(double bwMbSec) {
        this.bwMbSec = bwMbSec;
    }
    /**
     * Returns the cumulative average value.
     *
     * @return the cumulative average value
     */
    public double getCumAvg() {
        return cumAvg;
    }

    /**
     * Sets the cumulative average value.
     *
     * @param cumAvg the cumulative average value to set
     */
    public void setCumAvg(double cumAvg) {
        this.cumAvg = cumAvg;
    }

    /**
     * Returns the minimum cumulative value.
     *
     * @return the minimum cumulative value
     */
    public double getCumMin() {
        return cumMin;
    }
    /**
     * Sets the minimum cumulative value.
     *
     * @param cumMin the minimum cumulative value to set
     */
    public void setCumMin(double cumMin) {
        this.cumMin = cumMin;
    }

    /**
     * Returns the maximum cumulative value.
     *
     * @return the maximum cumulative value
     */
    public double getCumMax() {
        return cumMax;
    }
    /**
     * Sets the maximum cumulative value.
     *
     * @param cumMax the maximum cumulative value to set
     */
    public void setCumMax(double cumMax) {
        this.cumMax = cumMax;
    }
    /**
     * Enumeration representing the type of mark (READ or WRITE).
     */
    public enum MarkType {READ, WRITE}
}
