package generator;

import model.Company;
import model.Employee;
import model.Office;
import tools.Utils;

import java.util.ArrayList;
import java.util.List;

public class CompanyGenerator {

    private OfficeGenerator officeGenerator;
    private EmployeeGenerator employeeGenerator;
    private Company company;

    private static CompanyGenerator companyGenerator;

    private CompanyGenerator(){
        this.officeGenerator = OfficeGenerator.getOfficeGenerator();
        this.employeeGenerator = EmployeeGenerator.getEmployeeGenerator();
    }

    public static CompanyGenerator getCompanyGenerator(){
        if(companyGenerator == null){
            companyGenerator = new CompanyGenerator();
        }
        return companyGenerator;
    }

    public Company createCompany(int officesToCreate, int employyesToCreate){
        Company company;
        int randomAmountOfOffices = Utils.getRandomNumberInRange(0, officesToCreate);
        int randomAmountOfEmployees;
        List<Office> companyOffices = this.officeGenerator.createCompanyOffices(officesToCreate);
        List<Employee> officeEmployees = new ArrayList<>();
        for(Office office : companyOffices){
            randomAmountOfEmployees = Utils.getRandomNumberInRange(0,employyesToCreate);
            officeEmployees = employeeGenerator.createOfficeEmployees(randomAmountOfEmployees);
            office.setOfficeEmployees(officeEmployees);
        }
        company = new Company.CompanyBuilder()
                             .setCompanyId(1)
                             .setCompanyName("Company")
                             .setCompanyOffices(companyOffices)
                             .build();
        return company;
    }








}
