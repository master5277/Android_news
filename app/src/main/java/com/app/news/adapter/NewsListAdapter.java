package com.app.news.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.news.NewsInfo;
import com.app.news.R;

import java.util.ArrayList;
import java.util.List;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.MyHolder> {

    private List<NewsInfo.ResultDTO.DataDTO> mDataDTOList = new ArrayList<>();

    public void setListData(List<NewsInfo.ResultDTO.DataDTO> listData)
    {
        this.mDataDTOList = listData;

        //这句话不可以少，一定要调用
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //加载布局文件
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_list_item, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        //绑定数据
        NewsInfo.ResultDTO.DataDTO dataDTO = mDataDTOList.get(position);

        holder.title.setText(dataDTO.getTitle());
        holder.author_name.setText("来源"+dataDTO.getAuthorName());
        holder.date.setText(dataDTO.getDate());


        //加载图片


    }

    @Override
    public int getItemCount() {
        return mDataDTOList.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder
    {
        ImageView thumbnail_pic_s;
        TextView title;
        TextView author_name;
        TextView date;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            thumbnail_pic_s = itemView.findViewById(R.id.thumbnail_pic_s);
            title = itemView.findViewById(R.id.title);
            author_name = itemView.findViewById(R.id.author_name);
            date = itemView.findViewById(R.id.date);
        }
    }
}
