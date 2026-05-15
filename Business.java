public class Business extends Contact {
    //Variables
    String suite;
    String URL;

    //Constructors
    protected Business() {
        super("Business");

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
    public String getSuite() {
        return this.suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getURL() {
        return this.URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSuite: " + this.suite + "\nURL: " + this.URL;
    }
} 
