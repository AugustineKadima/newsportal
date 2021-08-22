package dao;

import models.News;

import java.util.List;

public interface INewsDao {

    //create
    void add(News news);

    //read
    List<News> getAll();


    //update


    //delete
    void deleteById(int id);
    void clearAll();
}
