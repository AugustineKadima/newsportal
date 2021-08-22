package model;

import models.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DepartmentTest {

    @Test
    public void DepartmentClassExists(){
        Department department = new Department(
                "ICT",
                "Tech team",
                12);
        Assertions.assertEquals(true, department instanceof Department);
    }

    @Test
    public void DepartmentVariablesAssignable(){
        Department department = new Department(
                "ICT",
                "Tech team",
                12);
        department.setName("Finance");
        department.setDescription("Handle accounts");
        department.setNumber_of_employees(3);
        Assertions.assertEquals("Finance", department.getName());
        Assertions.assertEquals("Handle accounts", department.getDescription());
        Assertions.assertEquals(3, department.getNumber_of_employees());
    }

    @Test
    public void DepartmentsInstantiatesWithAnIdOf1(){
        Department.clearArray();
        Department department = new Department(
                "ICT",
                "Tech team",
                12);
        Assertions.assertEquals(1, department.getId());
    }

}
