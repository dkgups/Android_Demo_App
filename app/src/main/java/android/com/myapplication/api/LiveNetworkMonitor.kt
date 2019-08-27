package android.com.myapplication.api

import android.content.Context
import android.net.ConnectivityManager

class LiveNetworkMonitor constructor(context: Context): NetworkMonitor{
    var applicationContext: Context=context
    override fun isConnected(): Boolean {
        var cm= applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var activeNetwork=cm.activeNetworkInfo
        return activeNetwork!=null && activeNetwork.isConnectedOrConnecting
    }
}