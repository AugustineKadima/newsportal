package dao;

import models.Users;

import java.util.List;

public interface IUsersDao {
    //create
    void add(Users users);

    //read
    List<Users> getAll();


    //update


    //delete
    void deleteById(int id);
    void clearAll();
}
