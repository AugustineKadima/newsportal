package dao;

import models.User;

import java.util.List;

public interface IUsersDao {
    //create
    void add(User user);

    //read
    List<User> getAll();


    //update


    //delete
    void deleteById(int id);
    void clearAll();
}
