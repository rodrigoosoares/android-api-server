package com.personal.androidapi.gateways.commons

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class HttpRequestQueue(context: Context) {

    companion object {
        @Volatile
        private var instance: HttpRequestQueue? = null

        fun getInstance(context: Context): HttpRequestQueue =
            instance ?: synchronized(this) {
                instance ?: HttpRequestQueue(context).also {
                    instance = it
                }
            }
    }

    val requestQueue: RequestQueue by lazy {
        Volley.newRequestQueue(context.applicationContext)
    }

    fun <T> add(req: Request<T>) {
        requestQueue.add(req)
    }
}