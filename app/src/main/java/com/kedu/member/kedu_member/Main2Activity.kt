package com.kedu.member.kedu_member

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import im.delight.android.webview.AdvancedWebView
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity(), AdvancedWebView.Listener {
    override fun onDownloadRequested(url: String?, suggestedFilename: String?, mimeType: String?, contentLength: Long, contentDisposition: String?, userAgent: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onExternalPageRequest(url: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPageFinished(url: String?) {
        progressBar.visibility = View.GONE
    }

    override fun onPageError(errorCode: Int, description: String?, failingUrl: String?) {
        progressBar.visibility = View.GONE
    }

    override fun onPageStarted(url: String?, favicon: Bitmap?) {
    }

    private val url = BuildConfig.URL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        webview.setListener(this,this)
        webview.loadUrl(url)
//        webview.isVerticalScrollBarEnabled = false
//        webview.settings.domStorageEnabled = true
//        webview.settings.javaScriptEnabled = true
//        webview.settings.useWideViewPort = true

//        webview.webViewClient = MyWebViewClient()
    }

    override fun onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack()
        } else {
            super.onBackPressed()
        }
    }

    inner class MyWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            return false
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        webview.onActivityResult(requestCode, resultCode, data)
    }
}
