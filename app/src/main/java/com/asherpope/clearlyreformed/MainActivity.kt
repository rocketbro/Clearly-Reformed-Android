package com.asherpope.clearlyreformed

import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import com.asherpope.clearlyreformed.ui.theme.ClearlyReformedTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClearlyReformedTheme {
                WebViewPage(url = "https://clearlyreformed.org/")
            }
        }
    }
}

@Composable
fun WebViewPage(url: String) {
    
    // Adding a WebView inside AndroidView with fullscreen layout
    AndroidView(factory = {
        
        WebView(it).apply {
            
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            
            webViewClient = WebViewClient()
            loadUrl(url)
        }
    }, update = {
        it.loadUrl(url)
    })
}