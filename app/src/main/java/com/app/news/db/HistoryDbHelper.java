package com.app.news.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.app.news.entity.Historyinfo;
import com.app.news.entity.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class HistoryDbHelper extends SQLiteOpenHelper {
    private static HistoryDbHelper sHelper;
    private static final String DB_NAME = "history.db";   //数据库名
    private static final int VERSION = 1;    //版本号

    //必须实现其中一个构方法
    public HistoryDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    //创建单例，供使用调用该类里面的的增删改查的方法
    public synchronized static HistoryDbHelper getInstance(Context context) {
        if (null == sHelper) {
            sHelper = new HistoryDbHelper(context, DB_NAME, null, VERSION);
        }
        return sHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建history_table表
        db.execSQL("create table history_table(history_id integer primary key autoincrement, " +
                "uniquekey text," +       //新闻ID
                "username text," +      //用户名
                "news_json text" +       //新闻数据
                ")");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

//    添加历史记录
    //TODO 在这里根据自己的业务需求，编写增删改查的方法，如下
    public int addHistory(String username, String uniquekey, String news_json) {

        //判断是否浏览过历史记录
        if (!isHistory(uniquekey))
        {

            //获取SQLiteDatabase实例
            SQLiteDatabase db = getWritableDatabase();
            ContentValues values = new ContentValues();
            //填充占位符
            values.put("username", username);
            values.put("uniquekey", uniquekey);
            values.put("news_json", news_json);
            String nullColumnHack = "values(null,?,?,?)";
            //执行
            int insert = (int) db.insert("history_table", nullColumnHack, values);
//        db.close();
            return insert;
        }
        return 0;
    }


    /**
     * username
     */
    @SuppressLint("Range")
    public boolean isHistory(String uniquekey) {
        //获取SQLiteDatabase实例
        SQLiteDatabase db = getReadableDatabase();
        String sql = "select history_id,uniquekey,username,news_json  from history_table where uniquekey=?";
        String[] selectionArgs = {uniquekey};
        Cursor cursor = db.rawQuery(sql, selectionArgs);
//        cursor.close();
//        db.close();
        return cursor.moveToNext();
    }


    /**
     * 查询历史记录
     */
    @SuppressLint("Range")
    public List<Historyinfo> queryHistoryListData(String username) {
        //获取SQLiteDatabase实例
        SQLiteDatabase db = getReadableDatabase();
        List<Historyinfo> list = new ArrayList<>();
        String sql;
        Cursor cursor;
        if (username==null)
        {
            sql = "select history_id,uniquekey,username,news_json  from history_table";
            cursor = db.rawQuery(sql,null);

        }else
        {
            sql = "select history_id,uniquekey,username,news_json  from history_table where username=?";
            cursor = db.rawQuery(sql, new String[]{username});
        }
//        String sql = "select history_id,uniquekey,username,news_json  from history_table where username=?";
//        cursor = db.rawQuery(sql, new String[]{username});
        while (cursor.moveToNext()) {
            int history_id = cursor.getInt(cursor.getColumnIndex("history_id"));
            String uniquekey = cursor.getString(cursor.getColumnIndex("uniquekey"));
            String userName = cursor.getString(cursor.getColumnIndex("username"));
            String news_json = cursor.getString(cursor.getColumnIndex("news_json"));
            list.add(new Historyinfo(history_id, uniquekey, userName, news_json));
        }
        ((Cursor) cursor).close();
//        db.close();
        return list;
    }
}
