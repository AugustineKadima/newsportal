package model;

import models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void UsersClassInstantiates(){
        User user = new User(
                "Mercy",
                "Manager",
                "Manage a team of IT professionals",
                "ICT");
        Assertions.assertEquals(true, user instanceof User);
    }

    @Test
    public void UserVariablesAssignable(){
        User user = new User(
                "Mercy",
                "Manager",
                "Manage a team of IT professionals",
                "ICT");
        user.setName("John");
        user.setTitle("Assistant Technician");
        user.setAssociated_department("Electronics");
        user.setRoles("Fix bugs");
        Assertions.assertEquals("John", user.getName());
        Assertions.assertEquals("Assistant Technician", user.getTitle());
        Assertions.assertEquals("Electronics", user.getAssociated_department());
        Assertions.assertEquals("Fix bugs", user.getRoles());

    }

}
