package generator;

import model.Office;
import tools.Utils;

import java.util.ArrayList;
import java.util.List;

public class OfficeGenerator {

    private static OfficeGenerator officeGenerator;
    private int officeCount = 1;

    private OfficeGenerator(){}

    public static OfficeGenerator getOfficeGenerator(){
        if(officeGenerator == null){
            officeGenerator = new OfficeGenerator();
        }
        return officeGenerator;
    }

    public int getOfficeCount() {
        return officeCount;

    }

    private final String [] officePossibleSectors = {"A","B","C"};

    public List<Office> createCompanyOffices(int amountOfOfficesToCreate){
       List<Office> offices = new ArrayList<Office>();
       Office office ;
       String officeNamePrefix = "Office ";
       String name;
       int possibleSectorIndex;
       int officeId;

       for(int i = 0; i < amountOfOfficesToCreate; i++ ){
           officeId = officeCount;
           possibleSectorIndex = Utils.getRandomNumberInRange(0,officePossibleSectors.length -1);
           name = officeNamePrefix + officeCount + officePossibleSectors[possibleSectorIndex];
           office = new Office.OfficeBuilder()
                              .setName(name)
                              .setOfficeId(officeId)
                              .build();
           offices.add(office);
           officeCount++;
       }

       return offices;
    }
}
