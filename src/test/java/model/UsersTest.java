package model;

import models.Users;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UsersTest {

    @Test
    public void UsersClassInstantiates(){
        Users users = new Users(
                "Mercy",
                "Manager",
                "Manage a team of IT professionals",
                "ICT");
        Assertions.assertEquals(true, users instanceof Users);
    }

    @Test
    public void UserVariablesAssignable(){
        Users users = new Users(
                "Mercy",
                "Manager",
                "Manage a team of IT professionals",
                "ICT");
        users.setName("John");
        users.setPosition("Assistant Technician");
        users.setAssociated_department("Electronics");
        users.setRoles("Fix bugs");
        Assertions.assertEquals("John", users.getName());
        Assertions.assertEquals("Assistant Technician", users.getPosition());
        Assertions.assertEquals("Electronics", users.getAssociated_department());
        Assertions.assertEquals("Fix bugs", users.getRoles());
    }
}
