package dao;

import models.Department;
import models.News;
import models.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oUsersDaoTest  implements IUsersDao {

    private Connection conn;
    private Sql2oUsersDao usersDao;


    @BeforeAll
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "sirkadima", "kadima123");
        usersDao = new Sql2oUsersDao(sql2o);
        conn = sql2o.open();
    }

    @AfterAll
    public void tearDown() throws Exception {
        conn.close();
    }


    @Override
    public void add(User user) {

    }

    @Override
    public void addUserNewsDepartment(User user, News news, Department department) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public List<Department> getUserDepartment(int blackout_id) {
        return null;
    }

    @Override
    public List<User> getUserNews(int blackout_id) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void clearAll() {

    }
}
