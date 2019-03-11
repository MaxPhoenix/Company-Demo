package config;

import generator.CompanyGenerator;
import model.Company;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("controllers")
@ComponentScan("services")
@ComponentScan("daos")
public class WebConfig {

    @Bean
    public CompanyGenerator companyGenerator(){
        return CompanyGenerator.getCompanyGenerator();
    }

    @Bean
    public Company companyMock(){
        int officesToCreate = 10;
        int employeesToCreatePerOffice = 15;
        return companyGenerator().createCompany(officesToCreate,employeesToCreatePerOffice);
    }
}
