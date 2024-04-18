package com.app.news;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.app.news.adapter.NewsListAdapter;
import com.app.news.db.HistoryDbHelper;
import com.app.news.entity.Historyinfo;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class HistoryListActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;

    private NewsListAdapter mNewsListAdapter;

    private List<NewsInfo.ResultBean.DataBean> mDataDTOList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_list);

        //初始化控件
        recyclerView = findViewById(R.id.recyclerView);

        //初始化适配器
        mNewsListAdapter = new NewsListAdapter(this);
        //设置适配器
        recyclerView.setAdapter(mNewsListAdapter);

        //获取数据
        List<Historyinfo> historyinfoList = HistoryDbHelper.getInstance(HistoryListActivity.this).queryHistoryListData(null);


        Gson gson = new Gson();
        for (int i = 0; i < historyinfoList.size(); i++) {
            mDataDTOList.add(gson.fromJson(historyinfoList.get(i).getNews_json(),NewsInfo.ResultBean.DataBean.class));
        }

        //设置数据

        mNewsListAdapter.setListData(mDataDTOList);

        //recyclerView点击事件
        mNewsListAdapter.setmOnItemClickListener(new NewsListAdapter.onItemClickListener() {
            @Override
            public void onItemClick(NewsInfo.ResultBean.DataBean dataBean, int position) {
                Intent intent = new Intent(HistoryListActivity.this, NewsDetailsActivity.class);
                //传递对象的时候，该类一定要实现Serializable
                intent.putExtra("dataDTO",dataBean);
                startActivity(intent);
            }
        });

        //返回
        findViewById(R.id.toolbar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}