package model;

import java.util.List;
import java.util.Objects;

public class Office {

    private int officeId;
    private String name;
    private List<Employee> officeEmployees;

    protected Office(OfficeBuilder officeBuilder){
        this.officeId = officeBuilder.officeId;
        this.name = officeBuilder.name;
        this.officeEmployees = officeBuilder.officeEmployees;
    }

    public boolean isBigOffice(){ return this.officeEmployees.size() > 10; }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getOfficeEmployees() {
        return officeEmployees;
    }

    public void setOfficeEmployees(List<Employee> officeEmployees) {
        this.officeEmployees = officeEmployees;
    }

    @Override
    public String toString() {
        return "Office{" +
                "officeId=" + officeId +
                ", name='" + name + '\'' +
                ", officeEmployees=" + officeEmployees +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Office office = (Office) o;
        return officeEmployees.equals(office.officeEmployees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(officeEmployees);
    }

    public static class OfficeBuilder{
        private int officeId;
        private String name;
        private List<Employee> officeEmployees;

        public OfficeBuilder(){

        }

        public OfficeBuilder setOfficeId(int officeId){
            this.officeId = officeId;
            return this;
        }

        public OfficeBuilder setName(String name){
            this.name = name;
            return this;
        }

        public OfficeBuilder setOfficeEmployees(List<Employee> employees){
            this.officeEmployees = employees;
            return this;
        }

        public Office build(){
            return new Office(this);
        }

    }
}
