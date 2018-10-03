package com.erop.formviewer.util;

import android.content.Context;
import android.net.ConnectivityManager;


/**
 * Created by Emmanuel Rop on 3/10/2018.
 */
public class Utils {
    public static boolean isConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnectedOrConnecting();
    }


}
