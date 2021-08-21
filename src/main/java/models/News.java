package models;

import java.util.ArrayList;

public class News {
    private int id;
    private String header;
    private String content;
    private String written_by;
    ArrayList<News> news = new ArrayList<>();

    public News(String header, String content, String written_by) {
        this.header = header;
        this.content = content;
        this.written_by = written_by;
        news.add(this);
        this.id = news.size();
    }
}
