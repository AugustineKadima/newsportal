package dao;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class Sql2oDepartmentDaoTest {

    private Connection conn;
    private Sql2oUsersDao departmentDao;


    @BeforeAll
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "sirkadima", "kadima123");
        departmentDao = new Sql2oUsersDao(sql2o);
        conn = sql2o.open();
    }

    @AfterAll
    public void tearDown() throws Exception {
        conn.close();
    }
}
