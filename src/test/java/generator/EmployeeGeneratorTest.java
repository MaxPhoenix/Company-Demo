package generator;

import model.Employee;
import org.junit.*;

import java.lang.reflect.Field;
import java.util.List;

public class EmployeeGeneratorTest {


    @Before
    public void employeeFactorySetUp() throws NoSuchFieldException, IllegalAccessException {
        Field instance = EmployeeGenerator.class.getDeclaredField("employeeFactory");
        instance.setAccessible(true);
        instance.set(null, null);
    }

    @After
    public void employeeFactoryReset() throws NoSuchFieldException, IllegalAccessException {
        Field instance = EmployeeGenerator.class.getDeclaredField("employeeFactory");
        instance.setAccessible(true);
        instance.set(null, null);
    }

    @Test
    public void createEmployeesTest(){
        int amountOfEmployeesToCreate = 10;
        EmployeeGenerator employeeGenerator = EmployeeGenerator.getEmployeeGenerator();

        List<Employee> employees = employeeGenerator.getEmployeesForOffice(amountOfEmployeesToCreate);
        List<Employee> employees2 = employeeGenerator.getEmployeesForOffice(amountOfEmployeesToCreate);

        System.out.println(employees);

        Assert.assertNotEquals(employees, employees2);
        Assert.assertEquals(employeeGenerator.getEmployeeCount(), 21);

    }

    @Test
    public void singletonResetTest(){
        int amountOfEmployeesToCreate = 10;
        EmployeeGenerator employeeGenerator = EmployeeGenerator.getEmployeeGenerator();

        List<Employee> employees = employeeGenerator.getEmployeesForOffice(amountOfEmployeesToCreate);
        List<Employee> employees2 = employeeGenerator.getEmployeesForOffice(amountOfEmployeesToCreate);

        System.out.println(employees);

        Assert.assertNotEquals(employees, employees2);
        Assert.assertEquals(employeeGenerator.getEmployeeCount(), 21);

    }

}
