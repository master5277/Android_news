package com.app.news.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.news.NewsInfo;
import com.app.news.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.MyHolder> {

    private List<NewsInfo.ResultBean.DataBean> mDataDTOList = new ArrayList<>();

    private Context mContext;

    public void setListData(List<NewsInfo.ResultBean.DataBean> listData)
    {
        this.mDataDTOList = listData;

        //这句话不可以少，一定要调用
        notifyDataSetChanged();
    }

    public NewsListAdapter(Context context)
    {
        this.mContext=context;
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
        NewsInfo.ResultBean.DataBean dataDTO = mDataDTOList.get(position);

        holder.title.setText(dataDTO.getTitle());
        holder.author_name.setText("来源"+dataDTO.getAuthor_name());
        holder.date.setText(dataDTO.getDate());


        //加载图片
        Glide.with(mContext).load(dataDTO.getThumbnail_pic_s()).error(R.mipmap.error_image).into(holder.thumbnail_pic_s);


        //点击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null!=mOnItemClickListener)
                {
                    mOnItemClickListener.onItemClick(dataDTO,position);
                }
            }
        });
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

    private onItemClickListener mOnItemClickListener;


    public void setmOnItemClickListener(onItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public interface onItemClickListener
    {
        void onItemClick(NewsInfo.ResultBean.DataBean dataBean,int position);
    }



}
