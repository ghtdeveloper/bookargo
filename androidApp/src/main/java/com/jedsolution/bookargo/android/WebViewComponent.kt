package com.jedsolution.bookargo.android

import android.annotation.SuppressLint
import android.webkit.WebView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebViewComponent() {
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                loadUrl("https://www.bookargo.com/")
                settings.javaScriptEnabled = true
            }
        },
        modifier = Modifier.fillMaxSize()
    )
}