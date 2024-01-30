package com.asherpope.clearlyreformed.presentation

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat.startActivity
import com.asherpope.clearlyreformed.domain.JSInterface


@Composable
fun WebViewPage(
    scriptMessage: ScriptMessage = viewModel(),
    url: String
) {
    // Adding a WebView inside AndroidView with fullscreen layout
    AndroidView(factory = {

        WebView(it).apply {

            val webView = this
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )

            settings.javaScriptEnabled = true
            val userAgent = System.getProperty("http.agent")
            settings.userAgentString = userAgent
            val jsInterface = JSInterface(webView.context, webView)
            webView.addJavascriptInterface(jsInterface, "JSI")

            webViewClient = CRWebViewClient()
            loadUrl(url)
        }
    }, update = { webView ->

        webView.loadUrl(url)
    })
}

class CRWebViewClient: WebViewClient() {
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        return super.shouldOverrideUrlLoading(view, request)
    }

    private val printJS = """
window.print = function() {
    //JSI.createWebPrintJob();
};
"""
    override fun onPageFinished(view: WebView?, url: String?) {
        view?.evaluateJavascript(printJS, null)
        super.onPageFinished(view, url)
    }
}