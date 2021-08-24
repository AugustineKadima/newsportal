import com.google.gson.Gson;
import dao.Sql2oDepartmentsDao;
import dao.Sql2oNewsDao;
import dao.Sql2oUsersDao;
import exceptions.ApiException;
import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static spark.Spark.post;

public class App {
    public static void main(String[] args) {
        Sql2oUsersDao usersDao;
        Sql2oDepartmentsDao departmentsDao;
        Sql2oNewsDao newsDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:~/jadle.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "sirkadima", "kadima123");

        usersDao = new Sql2oUsersDao(sql2o);
        departmentsDao = new Sql2oDepartmentsDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        conn = sql2o.open();

        post("/news/new", "application/json", (req, res) -> {
            //accept a request in format JSON from an app
            
            News news = gson.fromJson(req.body(), News.class);
            newsDao.add(news);
            res.status(201);
            res.type("application/json");
            return gson.toJson(news);
        });


    }
}
