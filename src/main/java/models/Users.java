package models;

public class Users {
    private int id;
    private String name;
    private String position;
    private String roles;
    private String associated_department;

    public Users(int id, String name, String position, String roles, String associated_department) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.roles = roles;
        this.associated_department = associated_department;
    }
}
