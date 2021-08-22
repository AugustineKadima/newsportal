package models;

import java.util.Objects;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getAssociated_department() {
        return associated_department;
    }

    public void setAssociated_department(String associated_department) {
        this.associated_department = associated_department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id && name.equals(users.name) && position.equals(users.position) && roles.equals(users.roles) && associated_department.equals(users.associated_department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, position, roles, associated_department);
    }
}
