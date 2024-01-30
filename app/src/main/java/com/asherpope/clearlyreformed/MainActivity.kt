package com.asherpope.clearlyreformed

import android.os.Bundle
import android.view.KeyEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.asherpope.clearlyreformed.presentation.WebViewPage
import com.asherpope.clearlyreformed.presentation.ui.theme.ClearlyReformedTheme

class MainActivity : ComponentActivity() {
    //val crWebView =
//    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
//        // Check whether the key event is the Back button and if there's history.
//        if (keyCode == KeyEvent.KEYCODE_BACK && myWebView.canGoBack()) {
//            myWebView.goBack()
//            return true
//        }
//        // If it isn't the Back button or there isn't web page history, bubble up to
//        // the default system behavior. Probably exit the activity.
//        return super.onKeyDown(keyCode, event)
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClearlyReformedTheme {
                WebViewPage(url = "https://clearlyreformed.org/")

            }
        }
    }
}
