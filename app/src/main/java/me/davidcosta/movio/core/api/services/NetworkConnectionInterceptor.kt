package me.davidcosta.movio.core.api.services

import android.Manifest
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.annotation.RequiresPermission
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class NetworkConnectionInterceptor(
    private val context: Context
) : Interceptor {

    @RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isInternetAvailable(context)) {
            throw NoInternetException("Sem conexão com a internet")
        }

        return chain.proceed(chain.request())
    }

    @RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
    private fun isInternetAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val network = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
        return capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                || capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                || capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
    }
}

class NoInternetException(message: String) : IOException(message)
