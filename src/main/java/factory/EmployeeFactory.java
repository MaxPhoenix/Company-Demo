package factory;

import model.Employee;
import tools.Utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeFactory {

    private static EmployeeFactory employeeFactory;
    private int employeeCount = 1;

    private EmployeeFactory(){}

    public static EmployeeFactory getEmployeeFactory(){
        if(employeeFactory == null){
            employeeFactory = new EmployeeFactory();
        }
        return employeeFactory;
    }

    private final String [] employeesPossibleFirstNames = { "Adam", "Alex", "Aaron", "Ben", "Carl", "Dan", "David", "Edward", "Fred", "Frank", "George", "Hal", "Hank", "Ike", "John", "Jack", "Joe", "Larry", "Monte", "Matthew", "Mark", "Nathan", "Otto", "Paul", "Peter", "Roger", "Roger", "Steve", "Thomas", "Tim", "Ty", "Victor", "Walter"};
    private final String [] employeesPossibleLastNames = { "Anderson", "Ashwoon", "Aikin", "Bateman", "Bongard", "Bowers", "Boyd", "Cannon", "Cast", "Deitz", "Dewalt", "Ebner", "Frick", "Hancock", "Haworth", "Hesch", "Hoffman", "Kassing", "Knutson", "Lawless", "Lawicki", "Mccord", "McCormack", "Miller", "Myers", "Nugent", "Ortiz", "Orwig", "Ory", "Paiser", "Pak", "Pettigrew", "Quinn", "Quizoz", "Ramachandran", "Resnick", "Sagar", "Schickowski", "Schiebel", "Sellon", "Severson", "Shaffer", "Solberg", "Soloman", "Sonderling", "Soukup", "Soulis", "Stahl", "Sweeney", "Tandy", "Trebil", "Trusela", "Trussel", "Turco", "Uddin", "Uflan", "Ulrich", "Upson", "Vader", "Vail", "Valente", "Van Zandt", "Vanderpoel", "Ventotla", "Vogal", "Wagle", "Wagner", "Wakefield", "Weinstein", "Weiss", "Woo", "Yang", "Yates", "Yocum", "Zeaser", "Zeller", "Ziegler", "Bauer", "Baxster", "Casal", "Cataldi", "Caswell", "Celedon", "Chambers", "Chapman", "Christensen", "Darnell", "Davidson", "Davis", "DeLorenzo", "Dinkins", "Doran", "Dugelman", "Dugan", "Duffman", "Eastman", "Ferro", "Ferry", "Fletcher", "Fietzer", "Hylan", "Hydinger", "Illingsworth", "Ingram", "Irwin", "Jagtap", "Jenson", "Johnson", "Johnsen", "Jones", "Jurgenson", "Kalleg", "Kaskel", "Keller", "Leisinger", "LePage", "Lewis", "Linde", "Lulloff", "Maki", "Martin", "McGinnis", "Mills", "Moody", "Moore", "Napier", "Nelson", "Norquist", "Nuttle", "Olson", "Ostrander", "Reamer", "Reardon", "Reyes", "Rice", "Ripka", "Roberts", "Rogers", "Root", "Sandstrom", "Sawyer", "Schlicht", "Schmitt", "Schwager", "Schutz", "Schuster", "Tapia", "Thompson", "Tiernan", "Tisler" };

    public int getEmployeeCount() {
        return employeeCount;
    }

    public List<Employee> getEmployeesForOffice(int amountOfEmployees){
        List<Employee> listOfEmployees = new ArrayList<Employee>();
        Employee employee;
        String firstName;
        String lastName;
        Date minDate = new Date(2000-1900,0,1);
        Date maxDate = new Date();
        Date hiringDate;
        int employeeId;
        boolean active;

        int firstNameIndex;
        int lastNameIndex;
        int randomizerForEmployeeActiveSet;

        for(int i = 0; i < amountOfEmployees ; i++){
            randomizerForEmployeeActiveSet = Utils.getRandomNumberInRange(0,amountOfEmployees);
            firstNameIndex = Utils.getRandomNumberInRange(0,employeesPossibleFirstNames.length-1);
            lastNameIndex = Utils.getRandomNumberInRange(0,employeesPossibleLastNames.length-1);
            firstName = employeesPossibleFirstNames[firstNameIndex];
            lastName = employeesPossibleLastNames[lastNameIndex];
            hiringDate = Utils.getRandomDateInRange(minDate,maxDate);
            employeeId = employeeCount;
            active = randomizerForEmployeeActiveSet % 2 == 0;

            employee = new Employee.EmployeeBuilder()
                                   .setEmployeeId(employeeId)
                                   .setActive(active)
                                   .setFirstName(firstName)
                                   .setLastName(lastName)
                                   .setHiringDate(hiringDate)
                                   .build();
            employeeCount++;
            listOfEmployees.add(employee);
        }

        return listOfEmployees;
    }

}
