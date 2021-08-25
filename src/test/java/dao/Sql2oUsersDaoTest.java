package dao;

import models.Department;
import models.News;
import models.User;
import org.junit.jupiter.api.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class Sql2oUsersDaoTest   {

    private static Connection conn;
    private static Sql2oUsersDao userDao;


    @BeforeEach
    void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/news_portal_test";
        Sql2o sql2o = new Sql2o(connectionString, "sirkadima", "kadima123");
        userDao = new Sql2oUsersDao(sql2o);
        conn = sql2o.open();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Clearing database");
        userDao.clearAll();
    }

    @AfterAll
    public static void shutDown() throws Exception {
        conn.close();
    }

    @Test
    public void add() {
        User user1 = new User("John", "Manager", "Manage doe", "Finance");
        userDao.add(user1);
        Assertions.assertEquals(userDao.getAll().get(0).getName(), "John");
    }

    @Test
    public void getAll() {
        User user = new User("John", "Manager", "Manage doe", "Finance");
        userDao.add(user);
        userDao.getAll();
        assertEquals(user, userDao.findById(user.getId()));
    }

    @Test
    public void findById() {
        userDao.clearAll();
        User user = new User("John", "Manager", "Manage doe", "Finance");
        User user1 = new User("Jane", "Assistant", "Manage doe", "Finance");
        userDao.add(user);
        userDao.add(user1);
        assertEquals(userDao.getAll().size(), 2);
    }



    @Test
    public void deleteById() {
        User user = new User("John", "Manager", "Manage doe", "Finance");
        User user1 = new User("Jane", "Assistant", "Manage doe", "Finance");
        userDao.add(user);
        userDao.add(user1);
        userDao.deleteById(user.getId());
        assertEquals(1,  userDao.getAll().size());
    }

    @Test
    public void clearAll() {
        User user = new User("John", "Manager", "Manage doe", "Finance");
        userDao.add(user);
        userDao.deleteById(user.getId());
        assertEquals(0,  userDao.getAll().size());
    }
}
