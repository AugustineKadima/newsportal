package dao;

import models.Department;
import models.News;
import models.User;
import org.junit.jupiter.api.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Sql2oNewsDaoTest{

    private static Connection conn;
    private static Sql2oNewsDao newsDao;



    @BeforeEach
    void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/news_portal_test";
        Sql2o sql2o = new Sql2o(connectionString, "sirkadima", "kadima123");
        newsDao = new Sql2oNewsDao(sql2o);
        conn = sql2o.open();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Clearing database");
        newsDao.clearAll();
    }

    @AfterAll
    public static void shutDown() throws Exception {
        conn.close();
    }

    @Test
    public void add() {
        News news = new News("John", "Manager", "Manage doe");
        newsDao.add(news);
        Assertions.assertEquals(newsDao.getAll().get(0).getHeader(), "John");
    }

    @Test
    public void getAll() {
        News news = new News("John", "Manager", "Manage doe");
        newsDao.add(news);
        newsDao.getAll();
        assertEquals(news, newsDao.findById(news.getId()));
    }

    @Test
    public void findById() {
        newsDao.clearAll();
        News news = new News("John", "Manager", "Manage doe");
        News news1 = new News("War", "Disaster as war starts", "Manage doe");
        newsDao.add(news);
        newsDao.add(news1);
        assertEquals(newsDao.getAll().size(), 2);
    }



    @Test
    public void deleteById() {
        News news = new News("John", "Manager", "Manage doe");
        News news1 = new News("War", "Disaster as war starts", "Manage doe");
        newsDao.add(news);
        newsDao.add(news1);
        newsDao.deleteById(news.getId());
        assertEquals(1,  newsDao.getAll().size());
    }

    @Test
    public void clearAll() {
        News news = new News("Trial", "Manager tried in court", "Manage doe");
        newsDao.add(news);
        newsDao.deleteById(news.getId());
        assertEquals(0,  newsDao.getAll().size());
    }



}
