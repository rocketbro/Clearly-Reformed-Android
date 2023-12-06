package com.asherpope.clearlyreformed.domain

import android.content.Context
import android.util.Log
import android.webkit.JavascriptInterface

class JSInterface(private val context: Context) {
    @JavascriptInterface
    fun sayHelloTo(name: String) {
        Log.i("JSI", "Hello, $name!")
    }

    // Add more methods as needed...
}