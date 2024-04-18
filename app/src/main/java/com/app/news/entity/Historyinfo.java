package com.app.news.entity;

public class Historyinfo {
    private int history_id;
    private String uniquekey;
    private String username;
    private String news_json;

    public Historyinfo(int history_id, String uniquekey, String username, String news_json) {
        this.history_id = history_id;
        this.uniquekey = uniquekey;
        this.username = username;
        this.news_json = news_json;
    }

    public int getHistory_id() {
        return history_id;
    }

    public void setHistory_id(int history_id) {
        this.history_id = history_id;
    }

    public String getUniquekey() {
        return uniquekey;
    }

    public void setUniquekey(String uniquekey) {
        this.uniquekey = uniquekey;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNews_json() {
        return news_json;
    }

    public void setNews_json(String news_json) {
        this.news_json = news_json;
    }


}
