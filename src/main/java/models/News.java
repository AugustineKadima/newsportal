package models;

import java.util.ArrayList;

public class News {
    private int id;
    private String header;
    private String content;
    private String written_by;
    public static ArrayList<News> news = new ArrayList<>();

    public News(String header, String content, String written_by) {
        this.header = header;
        this.content = content;
        this.written_by = written_by;
        news.add(this);
        this.id = news.size();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWritten_by() {
        return written_by;
    }

    public void setWritten_by(String written_by) {
        this.written_by = written_by;
    }

    public static ArrayList<News> getNews() {
        return news;
    }

    public void setNews(ArrayList<News> news) {
        this.news = news;
    }
}
