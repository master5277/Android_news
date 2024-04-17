package com.app.news;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NewsDetailsActivity extends AppCompatActivity {

    private NewsInfo.ResultBean.DataBean dataBean;
    private Toolbar toolbar;
    private WebView mWebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);


        //获取传递的数据
        dataBean = (NewsInfo.ResultBean.DataBean) getIntent().getSerializableExtra("dataDTO");

    }
}