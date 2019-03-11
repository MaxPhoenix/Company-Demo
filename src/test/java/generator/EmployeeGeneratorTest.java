package generator;

import model.Employee;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.lang.reflect.Field;
import java.util.List;

public class EmployeeGeneratorTest {


    @Before
    public void employeeGeneratorSetUp() throws NoSuchFieldException, IllegalAccessException {
        Field instance = EmployeeGenerator.class.getDeclaredField("employeeGenerator");
        instance.setAccessible(true);
        instance.set(null, null);
    }

    @After
    public void employeeGeneratorReset() throws NoSuchFieldException, IllegalAccessException {
        Field instance = EmployeeGenerator.class.getDeclaredField("employeeGenerator");
        instance.setAccessible(true);
        instance.set(null, null);
    }

    @Test
    public void createEmployeesTest() {
        int amountOfEmployeesToCreate = 10;
        EmployeeGenerator employeeGenerator = EmployeeGenerator.getEmployeeGenerator();

        List<Employee> employees = employeeGenerator.createOfficeEmployees(amountOfEmployeesToCreate);
        List<Employee> employees2 = employeeGenerator.createOfficeEmployees(amountOfEmployeesToCreate);

        System.out.println(employees);

        Assert.assertNotEquals(employees, employees2);
        Assert.assertEquals(employeeGenerator.getEmployeeCount(), 21);

    }

    @Test
    public void singletonResetTest() {
        int amountOfEmployeesToCreate = 10;
        EmployeeGenerator employeeGenerator = EmployeeGenerator.getEmployeeGenerator();

        List<Employee> employees = employeeGenerator.createOfficeEmployees(amountOfEmployeesToCreate);
        List<Employee> employees2 = employeeGenerator.createOfficeEmployees(amountOfEmployeesToCreate);

        System.out.println(employees);

        Assert.assertNotEquals(employees, employees2);
        Assert.assertEquals(employeeGenerator.getEmployeeCount(), 21);

    }
}