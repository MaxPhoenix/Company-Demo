package controllers;

import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import services.CompanyService;

import java.util.List;

@RestController
@RequestMapping("company/")
@Scope("request")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    /**
     * Endpoint used for testing the retrieving of employees from big offices
     */
    @RequestMapping(value = "employees/bigOfficesEmployees", method = RequestMethod.GET)
    public List<Employee> getEmployeesFromBigOffices(){
        return this.companyService.getEmployeesFromBigOffices();
    }
    
    @RequestMapping(value = "employees/bigOffices", method = RequestMethod.GET)
    public List<Employee> getEmployeesFromBigOffices(@RequestParam String dateOrderCriteria, @RequestParam int antiquity){
        return this.companyService.getEmployeesFromBigOffices(dateOrderCriteria,antiquity);
    }

}
