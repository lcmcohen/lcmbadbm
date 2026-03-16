/**
 * Core package for the jDiskMark disk benchmarking application. Contains application
 * entry point and configuration ({@link edu.touro.mco152.bm.App}), benchmark execution
 * on a background thread ({@link edu.touro.mco152.bm.DiskWorker}), per-iteration and
 * run data ({@link edu.touro.mco152.bm.DiskMark}), and shared utilities
 * ({@link edu.touro.mco152.bm.Util}). Persistence lives in
 * {@link edu.touro.mco152.bm.persist} and UI in {@link edu.touro.mco152.bm.ui}.
 */
package edu.touro.mco152.bm.persist;