package com.asherpope.clearlyreformed.domain

import android.content.Context
import android.print.PrintAttributes
import android.print.PrintManager
import android.util.Log
import android.webkit.JavascriptInterface
import android.webkit.WebView

class JSInterface(private val context: Context, private val webView: WebView) {
    @JavascriptInterface
    fun sayHelloTo(name: String) {
        Log.i("dev", "Hello, $name!")
    }

    @JavascriptInterface
    fun createWebPrintJob() {
        // Get a PrintManager instance
        (context.getSystemService(Context.PRINT_SERVICE) as? PrintManager)?.let { printManager ->

            val jobName = "Clearly Reformed Document"

            // Get a print adapter instance
            val printAdapter = webView.createPrintDocumentAdapter(jobName)

            // Create a print job with name and adapter instance
            printManager.print(
                jobName,
                printAdapter,
                PrintAttributes.Builder().build()
            ).also { printJob ->

                // Save the job object for later status checking
                //printJobs += printJob
            }
        }
    }

    // Add more methods as needed...
}