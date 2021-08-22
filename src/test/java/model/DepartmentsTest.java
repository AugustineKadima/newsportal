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


}
