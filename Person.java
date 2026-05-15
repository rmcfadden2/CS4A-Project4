import java.util.ArrayList;

public class Person extends Contact {
    //Variables
    String apartmentNumber;
    String birthday;

    //Constructors
    protected Person() {
        super("Person");

        apartmentNumber = "UNK";
        birthday = "UNK";
    }

    protected Person(String name, String email, String phoneNumber, String city, String address, String apartmentNumber, String birthday) {
        super(name, email, phoneNumber, "Person", city, address);

        this.apartmentNumber = apartmentNumber;
        this.birthday = birthday;
    }

    protected Person(String name, String email, String phoneNumber, String city, String address, String group, String tag, String apartmentNumber, String birthday) {
        super(name, email, phoneNumber, "Person", city, address, group, tag);

        this.apartmentNumber = apartmentNumber;
        this.birthday = birthday;
    }

    protected Person(String name, String email, String phoneNumber, String city, String address, ArrayList<String> group, ArrayList<String> tag, String apartmentNumber, String birthday) {
        super(name, email, phoneNumber, "Person", city, address, group, tag);

        this.apartmentNumber = apartmentNumber;
        this.birthday = birthday;
    }

    //Getters and Setters
    public String getAppartmentNumber() {
        return this.apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean hasMissingInfo()
    {
        return super.hasMissingInfo()
            || apartmentNumber.equals("UNK")
            || birthday.equals("UNK");
    }

    @Override
    public String toFile()
    {
        return super.toFile() + "|" + this.apartmentNumber + "|" + this.birthday;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAppartment Number: " + this.apartmentNumber + "\nBirthday: " + this.birthday;
    }
}