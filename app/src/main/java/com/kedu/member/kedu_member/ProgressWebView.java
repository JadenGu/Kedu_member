package com.kedu.member.kedu_member;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;


/**
 * Created by gurui on 15/2/4.
 */
public class ProgressWebView extends WebView {

    private ProgressBar progressbar;

    private String title;

    public ProgressWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        progressbar = new ProgressBar(context, null, android.R.attr.progressBarStyleHorizontal);
        progressbar.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, getPxFromDp(), 0, -6));
        addView(progressbar);
        getSettings().setJavaScriptEnabled(true);
        setWebChromeClient(new CustomChromeClient());
    }

    public void setProgressVisible(boolean visible) {
        progressbar.setVisibility(visible ? VISIBLE : GONE);
    }

    public void setProgress(int progress) {
        progressbar.setProgress(progress);
    }


    public static class CustomChromeClient extends WebChromeClient {

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (view instanceof ProgressWebView) {
                ProgressWebView progressWeb = (ProgressWebView) view;
                progressWeb.setProgressVisible(newProgress < 100);
                progressWeb.setProgress(newProgress);
            }
            super.onProgressChanged(view, newProgress);
        }
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        LayoutParams lp = (LayoutParams) progressbar.getLayoutParams();
        lp.x = l;
        lp.y = t;
        progressbar.setLayoutParams(lp);
        super.onScrollChanged(l, t, oldl, oldt);
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    private int getPxFromDp() {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (float) 4, getResources().getDisplayMetrics());
    }

}
