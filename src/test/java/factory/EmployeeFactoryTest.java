package factory;

import model.Employee;
import org.junit.*;

import java.lang.reflect.Field;
import java.util.List;

public class EmployeeFactoryTest {


    @Before
    public void employeeFactorySetUp() throws NoSuchFieldException, IllegalAccessException {
        Field instance = EmployeeFactory.class.getDeclaredField("employeeFactory");
        instance.setAccessible(true);
        instance.set(null, null);
    }

    @After
    public void employeeFactoryReset() throws NoSuchFieldException, IllegalAccessException {
        Field instance = EmployeeFactory.class.getDeclaredField("employeeFactory");
        instance.setAccessible(true);
        instance.set(null, null);
    }

    @Test
    public void createEmployeesTest(){
        int amountOfEmployeesToCreate = 10;
        EmployeeFactory employeeFactory = EmployeeFactory.getEmployeeFactory();

        List<Employee> employees = employeeFactory.getEmployeesForOffice(amountOfEmployeesToCreate);
        List<Employee> employees2 = employeeFactory.getEmployeesForOffice(amountOfEmployeesToCreate);

        System.out.println(employees);

        Assert.assertNotEquals(employees, employees2);
        Assert.assertEquals(employeeFactory.getEmployeeCount(), 21);

    }

    @Test
    public void singletonResetTest(){
        int amountOfEmployeesToCreate = 10;
        EmployeeFactory employeeFactory = EmployeeFactory.getEmployeeFactory();

        List<Employee> employees = employeeFactory.getEmployeesForOffice(amountOfEmployeesToCreate);
        List<Employee> employees2 = employeeFactory.getEmployeesForOffice(amountOfEmployeesToCreate);

        System.out.println(employees);

        Assert.assertNotEquals(employees, employees2);
        Assert.assertEquals(employeeFactory.getEmployeeCount(), 21);

    }

}
