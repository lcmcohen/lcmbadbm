package edu.touro.mco152.bm;

import java.text.DecimalFormat;

/**
 * Represents a single benchmark measurement taken during a disk read or write operation.
 * <p>
 * Each {@code DiskMark} captures the bandwidth at a specific point in the benchmark run,
 * as well as cumulative statistics (min, max, average) across all marks recorded so far.
 * Marks are intended to be plotted on a time-series graph where {@code markNum} is the
 * x-axis and {@code bwMbSec} is the y-axis.
 * </p>
 *
 * @author wolf
 * @version 1.0
 * @see DiskWorker
 */
public class DiskMark {

    static DecimalFormat df = new DecimalFormat("###.###");
    MarkType type;
    private int markNum = 0;       // x-axis
    private double bwMbSec = 0;    // y-axis
    private double cumMin = 0;
    private double cumMax = 0;
    private double cumAvg = 0;

    /**
     * Constructs a new {@code DiskMark} of the specified type.
     *
     * @param type the type of disk operation, either {@link MarkType#READ} or {@link MarkType#WRITE}
     */
    DiskMark(MarkType type) {
        this.type = type;
    }

    /**
     * Returns a human-readable summary of this mark, including its type,
     * mark number, current bandwidth, and cumulative average.
     *
     * @return a formatted string representation of this {@code DiskMark}
     */
    @Override
    public String toString() {
        return "Mark(" + type + "): " + getMarkNum() + " bwMbSec: " + getBwMbSecAsString() + " avg: " + getAvgAsString();
    }

    /**
     * Returns the current bandwidth formatted as a string.
     *
     * @return bandwidth in MB/sec, formatted with up to 3 decimal places
     */
    String getBwMbSecAsString() {
        return df.format(getBwMbSec());
    }

    /**
     * Returns the cumulative minimum bandwidth formatted as a string.
     *
     * @return cumulative minimum in MB/sec, formatted with up to 3 decimal places
     */
    String getMinAsString() {
        return df.format(getCumMin());
    }

    /**
     * Returns the cumulative maximum bandwidth formatted as a string.
     *
     * @return cumulative maximum in MB/sec, formatted with up to 3 decimal places
     */
    String getMaxAsString() {
        return df.format(getCumMax());
    }

    /**
     * Returns the cumulative average bandwidth formatted as a string.
     *
     * @return cumulative average in MB/sec, formatted with up to 3 decimal places
     */
    String getAvgAsString() {
        return df.format(getCumAvg());
    }

    /**
     * Returns the sequential mark number for this measurement (the x-axis value).
     *
     * @return the mark number
     */
    public int getMarkNum() {
        return markNum;
    }

    /**
     * Sets the sequential mark number for this measurement.
     *
     * @param markNum the mark number to set
     */
    public void setMarkNum(int markNum) {
        this.markNum = markNum;
    }

    /**
     * Returns the measured bandwidth for this mark in megabytes per second.
     *
     * @return bandwidth in MB/sec
     */
    public double getBwMbSec() {
        return bwMbSec;
    }

    /**
     * Sets the measured bandwidth for this mark.
     *
     * @param bwMbSec bandwidth in MB/sec to set
     */
    public void setBwMbSec(double bwMbSec) {
        this.bwMbSec = bwMbSec;
    }

    /**
     * Returns the cumulative average bandwidth across all marks so far.
     *
     * @return cumulative average in MB/sec
     */
    public double getCumAvg() {
        return cumAvg;
    }

    /**
     * Sets the cumulative average bandwidth.
     *
     * @param cumAvg cumulative average in MB/sec to set
     */
    public void setCumAvg(double cumAvg) {
        this.cumAvg = cumAvg;
    }

    /**
     * Returns the cumulative minimum bandwidth observed across all marks so far.
     *
     * @return cumulative minimum in MB/sec
     */
    public double getCumMin() {
        return cumMin;
    }

    /**
     * Sets the cumulative minimum bandwidth.
     *
     * @param cumMin cumulative minimum in MB/sec to set
     */
    public void setCumMin(double cumMin) {
        this.cumMin = cumMin;
    }

    /**
     * Returns the cumulative maximum bandwidth observed across all marks so far.
     *
     * @return cumulative maximum in MB/sec
     */
    public double getCumMax() {
        return cumMax;
    }

    /**
     * Sets the cumulative maximum bandwidth.
     *
     * @param cumMax cumulative maximum in MB/sec to set
     */
    public void setCumMax(double cumMax) {
        this.cumMax = cumMax;
    }

    /**
     * Enumerates the two possible types of disk benchmark operations.
     */
    public enum MarkType {READ, WRITE}
}
