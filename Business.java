public class Business extends Contact {
    //Variables
    String suite;
    String URL;

    //Constructors
    protected Business() {
        super();

        suite = "UNK";
        URL = "UNK";
    }

    protected Business(String name, String email, String phoneNumber, String city, String address, String suite, String URL) {
        super(name, email, phoneNumber, "Buisness", city, address);

        this.suite = suite;
        this.URL = URL;
    }

    protected Business(String name, String email, String phoneNumber, String city, String address, String group, String tag, String suite, String URL) {
        super(name, email, phoneNumber, "Buisness", city, address, group, tag);

        this.suite = suite;
        this.URL = URL;
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
    public String toString() {
        return super.toString() + "\nAppartment Number: " + this.apartmentNumber + "\nBirthday: " + this.birthday;
    }
}
    
