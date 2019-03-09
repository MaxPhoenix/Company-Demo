package generator;

public class CompanyFactory {

    private OfficeGenerator officeGenerator;
    private EmployeeGenerator employeeGenerator;

    public CompanyFactory(){
        this.officeGenerator = OfficeGenerator.getOfficeGenerator();
        this.employeeGenerator = EmployeeGenerator.getEmployeeGenerator();
    }






}
