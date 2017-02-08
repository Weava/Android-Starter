package com.appweava.androidstarterdomain.interactor;

/**
 * InitNotCalledException
 * <p>
 * Class description here
 */
public class InitNotCalledException extends IllegalArgumentException {

    public InitNotCalledException() {
        super("Please call init with non-null arguments before executing");
    }
}
