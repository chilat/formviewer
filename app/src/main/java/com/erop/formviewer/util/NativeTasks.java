package com.erop.formviewer.util;

/**
 * Created by Emmanuel Rop on 2/10/2018.
 */
public class NativeTasks {

    static {
        System.loadLibrary("native-lib");
    }

    public native static String getUrl();
}
