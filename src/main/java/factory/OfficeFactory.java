package factory;

public class OfficeFactory {

    private static OfficeFactory officeFactory;

    private OfficeFactory(){}

    public static OfficeFactory getOfficeFactory(){
        if(officeFactory == null){
            officeFactory = new OfficeFactory();
        }
        return officeFactory;
    }

}
