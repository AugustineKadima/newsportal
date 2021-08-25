package dao;

import models.Department;
import models.News;
import models.User;
import org.junit.jupiter.api.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Sql2oDepartmentDaoTest {
    private static Connection conn;
    private static Sql2oDepartmentsDao departmentsDao;

    @BeforeEach
    void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/news_portal_test";
        Sql2o sql2o = new Sql2o(connectionString, "sirkadima", "kadima123");
        departmentsDao = new Sql2oDepartmentsDao(sql2o);
        conn = sql2o.open();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Clearing database");
        departmentsDao.clearAll();
    }

    @AfterAll
    public static void shutDown() throws Exception {
        conn.close();
    }

    @Test
    public void add() {
        Department department = new Department("Finance", "Manage Finances", 8);
        departmentsDao.add(department);
        Assertions.assertEquals(departmentsDao.getAll().get(0).getName(), "Finance");
    }

    @Test
    public void getAll() {
        Department department = new Department("Finance", "Manage Finances", 8);
        departmentsDao.add(department);
        departmentsDao.getAll();
        assertEquals(department, departmentsDao.findById(department.getId()));
    }

    @Test
    public void findById() {
        departmentsDao.clearAll();
        Department department = new Department("Finance", "Manage Finances", 8);
        Department department1 = new Department("Swimming", "Swim like fish", 8);
        departmentsDao.add(department);
        departmentsDao.add(department1);
        assertEquals(departmentsDao.getAll().size(), 2);
    }



    @Test
    public void deleteById() {
        Department department = new Department("Finance", "Manage Finances", 8);
        Department department1 = new Department("Swimming", "Swim like fish", 8);
        departmentsDao.add(department);
        departmentsDao.add(department1);
        departmentsDao.deleteById(department.getId());
        assertEquals(1,  departmentsDao.getAll().size());
    }

    @Test
    public void clearAll() {
        Department department = new Department("Finance", "Manage Finances", 8);
        departmentsDao.add(department);
        departmentsDao.deleteById(department.getId());
        assertEquals(0,  departmentsDao.getAll().size());
    }

}
