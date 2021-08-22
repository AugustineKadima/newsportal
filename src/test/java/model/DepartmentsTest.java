package model;

import models.Departments;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DepartmentsTest {

    @Test
    public void DepartmentClassExists(){
        Departments departments = new Departments(
                "ICT",
                "Tech team",
                12);
        Assertions.assertEquals(true, departments instanceof Departments);
    }

    @Test
    public void DepartmentVariablesAssignable(){
        Departments departments = new Departments(
                "ICT",
                "Tech team",
                12);
        departments.setName("Finance");
        departments.setDescription("Handle accounts");
        departments.setNumber_of_employees(3);
        Assertions.assertEquals("Finance", departments.getName());
        Assertions.assertEquals("Handle accounts", departments.getDescription());
        Assertions.assertEquals(3, departments.getNumber_of_employees());
    }

}
