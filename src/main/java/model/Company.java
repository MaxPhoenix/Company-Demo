package model;

import java.util.List;
import java.util.Objects;

public class Company {

    private String companyName;
    private int companyId;
    private List<Office> companyOffices;

    protected Company(CompanyBuilder companyBuilder) {
        this.companyName = companyBuilder.companyName;
        this.companyId = companyBuilder.companyId;
        this.companyOffices = companyBuilder.companyOffices;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public List<Office> getCompanyOffices() {
        return companyOffices;
    }

    public void setCompanyOffices(List<Office> companyOffices) {
        this.companyOffices = companyOffices;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", companyId=" + companyId +
                ", companyOffices=" + companyOffices +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return companyOffices.equals(company.companyOffices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyOffices);
    }

    public static class CompanyBuilder{
        private String companyName;
        private int companyId;
        private List<Office> companyOffices;

        public CompanyBuilder(){

        }

        public CompanyBuilder setCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public CompanyBuilder setCompanyId(int companyId) {
            this.companyId = companyId;
            return this;
        }

        public CompanyBuilder setCompanyOffices(List<Office> companyOffices) {
            this.companyOffices = companyOffices;
            return this;
        }

        public Company build(){
            return new Company(this);
        }
    }

}
