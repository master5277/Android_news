package com.app.news;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.app.news.db.HistoryDbHelper;
import com.google.gson.Gson;

public class NewsDetailsActivity extends AppCompatActivity {

    private NewsInfo.ResultBean.DataBean dataBean;
    private Toolbar toolbar;
    private WebView mWebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);


        toolbar = findViewById(R.id.toolbar);
        mWebView = findViewById(R.id.webView);

        //获取传递的数据
        dataBean = (NewsInfo.ResultBean.DataBean) getIntent().getSerializableExtra("dataDTO");

        //设置数据
        if (null!=dataBean)
        {
            toolbar.setTitle(dataBean.getTitle());
            mWebView.loadUrl(dataBean.getUrl());


            //添加历史记录
            String dataDTOJson = new Gson().toJson(dataBean);
            HistoryDbHelper.getInstance(NewsDetailsActivity.this).addHistory(null,dataBean.getUniquekey(),dataDTOJson);
        }

        //返回
        toolbar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });

//        //添加历史记录
//        String dataDTOJson = new Gson().toJson(dataBean);
//        HistoryDbHelper.getInstance(NewsDetailsActivity.this).addHistory(null,dataBean.getUniquekey(),dataDTOJson);
    }
}