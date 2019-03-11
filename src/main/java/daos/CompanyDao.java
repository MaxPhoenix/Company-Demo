package daos;

import model.Company;
import model.Employee;
import model.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Component
@Scope("request")
public class CompanyDao {

    @Autowired
    private Company companyMock;

    public List<Employee> getEmployeesFromBigOffices() {
        List<Employee> bigOfficesEmployees = new ArrayList<>();
        List<Office> companyOffices = this.companyMock.getCompanyOffices();
        
        for(Office office : companyOffices){
            if(office.isBigOffice()){
                bigOfficesEmployees.addAll(office.getOfficeEmployees());
            }
        }
        
        return bigOfficesEmployees;

    }


}
