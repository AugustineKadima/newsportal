package dao;

import models.Departments;

import java.util.List;

public interface IDepartmentsDao {
    //create
    void add(Departments departments);

    //read
    List<Departments> getAll();


    //update


    //delete
    void deleteById(int id);
    void clearAll();
}
