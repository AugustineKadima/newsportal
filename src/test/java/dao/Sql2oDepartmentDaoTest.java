package dao;

import models.Department;
import models.News;
import models.User;
import org.junit.jupiter.api.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oDepartmentDaoTest implements IDepartmentsDao {

    private Connection conn;
    private Sql2oDepartmentsDao departmentDao;


    @BeforeEach
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/news_portal_test'";
        Sql2o sql2o = new Sql2o(connectionString, "sirkadima", "kadima123");
        departmentDao = new Sql2oDepartmentsDao(sql2o);
        conn = sql2o.open();
    }

    @AfterEach
    public void tearDown() throws Exception {
        departmentDao.clearAll();
    }

    @AfterAll
    public void shutDown() throws Exception {
        conn.close();
    }


    @Override
    public void add(Department departments) {

    }

    @Override
    public void addDepartmentNewsUser(User user, News news, Department department) {

    }

    @Override
    public List<Department> getAll() {
        return null;
    }

    @Override
    public Department findById(int id) {
        return null;
    }

    @Override
    public List<User> getDepartmentUser(int blackout_id) {
        return null;
    }

    @Override
    public List<News> getDepartmentNews(int blackout_id) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void clearAll() {

    }
}
