package com.asherpope.clearlyreformed

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.asherpope.clearlyreformed.presentation.WebViewPage
import com.asherpope.clearlyreformed.presentation.ui.theme.ClearlyReformedTheme

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
