package generator;

import model.Office;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.List;

public class OfficeGeneratorTest {

    @Before
    public void OfficeGeneratorSetUp() throws NoSuchFieldException, IllegalAccessException {
        Field instance = OfficeGenerator.class.getDeclaredField("officeGenerator");
        instance.setAccessible(true);
        instance.set(null, null);
        Field instanceEmployee = EmployeeGenerator.class.getDeclaredField("employeeGenerator");
        instanceEmployee.setAccessible(true);
        instanceEmployee.set(null, null);
    }

    @After
    public void OfficeGeneratorReset() throws NoSuchFieldException, IllegalAccessException {
        Field instance = OfficeGenerator.class.getDeclaredField("officeGenerator");
        instance.setAccessible(true);
        instance.set(null, null);
        Field instanceEmployee = EmployeeGenerator.class.getDeclaredField("employeeGenerator");
        instanceEmployee.setAccessible(true);
        instanceEmployee.set(null, null);
    }

    @Test
    public void createOfficesTest(){
        int amountOfEmployeesToCreate = 2;
        OfficeGenerator officeGenerator = OfficeGenerator.getOfficeGenerator();
        EmployeeGenerator employeeGenerator = EmployeeGenerator.getEmployeeGenerator();

        List<Office> offices = officeGenerator.createCompanyOffices(amountOfEmployeesToCreate);
        for(Office office : offices)
            office.setOfficeEmployees(employeeGenerator.createOfficeEmployees(2));
        List<Office> offices2 = officeGenerator.createCompanyOffices(amountOfEmployeesToCreate);
        for(Office office2 : offices2)
            office2.setOfficeEmployees(employeeGenerator.createOfficeEmployees(2));


        System.out.println(offices);

        Assert.assertNotEquals(offices, offices2);
        Assert.assertEquals(officeGenerator.getOfficeCount(), 5);

    }

    @Test
    public void singletonResetTest(){
        int amountOfEmployeesToCreate = 2;
        OfficeGenerator officeGenerator = OfficeGenerator.getOfficeGenerator();
        EmployeeGenerator employeeGenerator = EmployeeGenerator.getEmployeeGenerator();

        List<Office> offices = officeGenerator.createCompanyOffices(amountOfEmployeesToCreate);
        for(Office office : offices)
            office.setOfficeEmployees(employeeGenerator.createOfficeEmployees(2));
        List<Office> offices2 = officeGenerator.createCompanyOffices(amountOfEmployeesToCreate);
        for(Office office2 : offices2)
            office2.setOfficeEmployees(employeeGenerator.createOfficeEmployees(2));

        System.out.println(offices);

        Assert.assertNotEquals(offices, offices2);
        Assert.assertEquals(officeGenerator.getOfficeCount(), 5);

    }
}
