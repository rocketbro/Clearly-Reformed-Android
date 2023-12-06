package com.asherpope.clearlyreformed.presentation

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import com.asherpope.clearlyreformed.domain.JSInterface

@Composable
fun WebViewPage(url: String) {

    // Adding a WebView inside AndroidView with fullscreen layout
    AndroidView(factory = {

        WebView(it).apply {

            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )

            val jsInterface = JSInterface(this.context)
            val printJS = """
window.print = function() {
    JSI.sayHelloTo('Asher');
};
"""

            this.addJavascriptInterface(jsInterface, "JSI")

            webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    // Inject your script to be executed when window.print() is called
                    view?.evaluateJavascript(printJS, null)
                }
            }
            loadUrl(url)
        }
    }, update = { webView ->

        webView.loadUrl(url)
    })
}