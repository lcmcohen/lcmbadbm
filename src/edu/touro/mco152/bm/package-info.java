/**
 * The purpose of this program is to compute and provide some performance
 * information about the local disk drive associated with the user’s home
 * directory. It obtains this information by executing a series of write and/or
 * read operations against the disk and measuring the throughput over time. The
 * benchmarks to be executed are defined by allowing the user to select whether
 * to do a ‘read’, ‘write’ or ‘write-read’ benchmark and to indicate how
 * sizeable the benchmark test data should be as well as some other parameters.
 * A GUI is provided to request all of this information and to allow the user to
 * start, stop and monitor the benchmark. An X/Y graph is produced dynamically
 * during each ‘run to show the progress and disk performance. A history of runs
 * with all performance data is maintained in a persistent location and is
 * visible in the GUI, and any significant events or errors encountered are
 * presented in the GUI.
 */
package edu.touro.mco152.bm;
