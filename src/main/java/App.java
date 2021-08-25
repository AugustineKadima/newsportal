import com.google.gson.Gson;
import dao.Sql2oDepartmentsDao;
import dao.Sql2oNewsDao;
import dao.Sql2oUsersDao;
import exceptions.ApiException;
import models.Department;
import models.News;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        Connection conn;
        Sql2oNewsDao newsDao;
        Sql2oUsersDao userDao;
        Sql2oDepartmentsDao departmentDao;
        Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/news_portal",  "sirkadima", "kadima123");

        userDao = new Sql2oUsersDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        departmentDao = new Sql2oDepartmentsDao(sql2o);

        conn = sql2o.open();
        Gson gson = new Gson();

        //CREATE nEW(aDD uSER)
        post("/users/new", "application/json", (req, res) -> {
            User user = gson.fromJson(req.body(), User.class);
            userDao.add(user);
            res.status(201);
            return gson.toJson(user);
        });

        //GET ALL
        get("/users", "application/json", (req, res) -> {
            return gson.toJson(userDao.getAll());
        });

        //GET USER BY ID
        get("/users/:id", "application/json", (req, res) -> {
            int userId = Integer.parseInt(req.params("id"));
            User userToFind = userDao.findById(userId);
            return gson.toJson(userToFind);
        });

        //DELETE BY ID
        delete("users/:user_id", (req, res) -> {
            int user_id = Integer.parseInt(req.params("user_id"));
            User userToDelete = userDao.findById(user_id);
            userDao.deleteById(user_id);
            return gson.toJson(userToDelete);
        });

        //CREATE nEW(aDD DEPARTMENT)
        post("/departments/new", "application/json", (req, res) -> {
            Department department = gson.fromJson(req.body(), Department.class);
            departmentDao.add(department);
            res.status(201);
            return gson.toJson(department);
        });

        //GET ALL
        get("/departments", "application/json", (req, res) -> {
            return gson.toJson(departmentDao.getAll());
        });

        //GET Department BY ID
        get("/departments/:id", "application/json", (req, res) -> {
            int departmentId = Integer.parseInt(req.params("id"));
            Department departmentToFind = departmentDao.findById(departmentId);
            return gson.toJson(departmentToFind);
        });

        //DELETE BY ID
        delete("departments/:department_id", (req, res) -> {
            int department_id = Integer.parseInt(req.params("department_id"));
            Department departmentToDelete = departmentDao.findById(department_id);
            departmentDao.deleteById(department_id);
            return gson.toJson(departmentToDelete);
        });

//        ADD ROUTING FOR NEWS
    }
}
