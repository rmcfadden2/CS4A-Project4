import java.util.ArrayList;

public class Business extends Contact {
    //Variables
    String suite;
    String URL;

    //Constructors
    public Business() {
        super("Business");

        suite = "UNK";
        URL = "UNK";
    }

    public Business(String name, String email, String phoneNumber, String city, String address, String suite, String URL) {
        super(name, email, phoneNumber, "Buisness", city, address);

        this.suite = suite;
        this.URL = URL;
    }

    public Business(String name, String email, String phoneNumber, String city, String address, String group, String tag, String suite, String URL) {
        super(name, email, phoneNumber, "Business", city, address, group, tag);

        this.suite = suite;
        this.URL = URL;
    }

    public Business(String name, String email, String phoneNumber, String city, String address, ArrayList<String> group, ArrayList<String> tag, String suite, String URL) {
        super(name, email, phoneNumber, "Business", city, address, group, tag);

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
    public boolean hasMissingInfo()
    {
        return super.hasMissingInfo()
            || suite.equals("UNK")
            || URL.equals("UNK");
    }


    @Override
    public String toFile()
    {
        return super.toFile() + "|" + this.suite + "|" + this.URL;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSuite: " + this.suite + "\nURL: " + this.URL;
    }
} 
