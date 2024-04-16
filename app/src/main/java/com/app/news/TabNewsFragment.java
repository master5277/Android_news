package com.app.news;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.PixelCopy;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TabNewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabNewsFragment extends Fragment {

    private String url = "http://v.juhe.cn/toutiao/index?key=6911b0031067c358d726152b31c1199a&type=";

    private static final String ARG_PARAM = "title";


    private String title;


    public TabNewsFragment() {
        // Required empty public constructor
    }


    public static TabNewsFragment newInstance(String param) {
        TabNewsFragment fragment = new TabNewsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, param);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab_news, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //获取数据
        getHttpData();
    }

    private void getHttpData() {

        //创建OkHttpClient对象
        OkHttpClient okHttpClient = new OkHttpClient();
        //构造Request对象
        Request request = new Request.Builder()
                .url(url+title)
                .get()
                .build();
        //通过OkHttpClient和Request对象来构建Call对象
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d("--------------------", "onFailure: "+e.toString());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String data = response.body().string();
                Log.d("-------------------", "onResponse: "+data);
            }
        });
    }
}