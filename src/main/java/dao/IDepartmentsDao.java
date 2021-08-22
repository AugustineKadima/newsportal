package dao;

import models.Department;

import java.util.List;

public interface IDepartmentsDao {
    //create
    void add(Department departments);

    //read
    List<Department> getAll();


    //update


    //delete
    void deleteById(int id);
    void clearAll();
}
