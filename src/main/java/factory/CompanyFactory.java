package factory;

import model.Company;

public class CompanyFactory {

    private OfficeFactory officeFactory;
    private EmployeeFactory employeeFactory;

    public CompanyFactory(){
        this.officeFactory = OfficeFactory.getOfficeFactory();
        this.employeeFactory = EmployeeFactory.getEmployeeFactory();
    }






}
