package models;

import java.util.ArrayList;

public class Departments{
    private String name;
    private int id;
    private String description;
    private int number_of_employees;
    public static ArrayList<Departments> allDepartments = new ArrayList<>();

    public Departments(String name, String description, int number_of_employees) {
        this.name = name;
        this.description = description;
        this.number_of_employees = number_of_employees;
        allDepartments.add(this);
        this.id = allDepartments.size();
    }
}
