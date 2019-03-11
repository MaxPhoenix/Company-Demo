package services;

import daos.CompanyDao;
import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Component
@Scope("request")
public class CompanyService {

    @Autowired
    private CompanyDao companyDao;

    private int getEmployeeAntiquity(Employee employee) {
    	Date hiringDate = employee.getHiringDate();
    	Date currentDate = new Date();
    	Calendar a = getCalendar(hiringDate);
        Calendar b = getCalendar(currentDate);
        int antiquity = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
        if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH) || 
            (a.get(Calendar.MONTH) == b.get(Calendar.MONTH) && a.get(Calendar.DATE) > b.get(Calendar.DATE))) {
        	antiquity--;
        }
    	return antiquity;
    }
    
    private Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }
    
    public List<Employee> getEmployeesFromBigOffices() {
        return this.companyDao.getEmployeesFromBigOffices();
    }

	public List<Employee> getEmployeesFromBigOffices(String dateOrderCriteria, int antiquity) {
		 List<Employee> listOfEmployees = this.getEmployeesFromBigOffices();
		 List<Employee> filteredListOfEmployees = new ArrayList<>();
		 
		 for(Employee employee : listOfEmployees) {
			 if(getEmployeeAntiquity(employee) > antiquity ) {
				 filteredListOfEmployees.add(employee);
			 }
		 }
		 
		 Collections.sort(filteredListOfEmployees, (employee1, employee2) -> { 
			 boolean orderCriteria = true ;
			 if("ASC".equals(dateOrderCriteria)) {
				 orderCriteria = true;
			 }
			 else if("DESC".equals(dateOrderCriteria)) {
				 orderCriteria = false;
			 }
			 return orderCriteria ?
					 employee1.getHiringDate().compareTo( employee2.getHiringDate() ) :
				     employee2.getHiringDate().compareTo( employee1.getHiringDate() ) ; 
		 });
		 
		 return filteredListOfEmployees;
	}
}
