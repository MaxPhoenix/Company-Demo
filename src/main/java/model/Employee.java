package model;

import java.util.Date;
import java.util.Objects;

public class Employee {

    private int employeeId;
    private String firstName;
    private String lastName;
    private Date hiringDate;
    private Date firingDate;
    private boolean active;

    protected Employee(EmployeeBuilder employeeBuilder){
        this.employeeId = employeeBuilder.employeeId;
        this.firstName = employeeBuilder.firstName;
        this.lastName = employeeBuilder.lastName;
        this.hiringDate = employeeBuilder.hiringDate;
        this.firingDate = employeeBuilder.firingDate;
        this.active = employeeBuilder.active;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(Date hiringDate) {
        this.hiringDate = hiringDate;
    }

    public Date getFiringDate() {
        return firingDate;
    }

    public void setFiringDate(Date firingDate) {
        this.firingDate = firingDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", hiringDate=" + hiringDate +
                ", firingDate=" + firingDate +
                ", active=" + active +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }

    public static class EmployeeBuilder{
        private int employeeId;
        private String firstName;
        private String lastName;
        private Date hiringDate;
        private Date firingDate;
        private boolean active;

        public EmployeeBuilder(){

        }

        public EmployeeBuilder setEmployeeId(int employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public EmployeeBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public EmployeeBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public EmployeeBuilder setHiringDate(Date hiringDate) {
            this.hiringDate = hiringDate;
            return this;
        }

        public EmployeeBuilder setFiringDate(Date firingDate) {
            this.firingDate = firingDate;
            return this;
        }

        public EmployeeBuilder setActive(boolean active) {
            this.active = active;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }
    }

}
