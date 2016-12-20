package com.dat.materialdrawerexperiment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import butterknife.Bind;
import butterknife.ButterKnife;

public class TestViewActivity extends AppCompatActivity {

    @Bind(R.id.cheque)
    protected WebView cheque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_view);
        ButterKnife.bind(this);
        cheque.loadUrl("file:///android_asset/template.html");
    }
}
