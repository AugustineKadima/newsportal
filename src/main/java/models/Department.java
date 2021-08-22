package models;

import java.util.ArrayList;
import java.util.Objects;

public class Department {
    private String name;
    private int id;
    private String description;
    private int number_of_employees;
    public static ArrayList<Department> allDepartments = new ArrayList<>();

    public Department(String name, String description, int number_of_employees) {
        this.name = name;
        this.description = description;
        this.number_of_employees = number_of_employees;
        allDepartments.add(this);
        this.id = allDepartments.size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumber_of_employees() {
        return number_of_employees;
    }

    public void setNumber_of_employees(int number_of_employees) {
        this.number_of_employees = number_of_employees;
    }

    public static ArrayList<Department> getAllDepartments() {
        return allDepartments;
    }

    public static void setAllDepartments(ArrayList<Department> allDepartments) {
        Department.allDepartments = allDepartments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id && number_of_employees == that.number_of_employees && name.equals(that.name) && description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, description, number_of_employees);
    }

    public static void clearArray(){
        allDepartments.clear();
    }
}