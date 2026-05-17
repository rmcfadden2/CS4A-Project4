import java.util.ArrayList;

public class Emergency extends Contact{
    //Constructors
    public Emergency() {
        super("Emergency");
    }

    public Emergency(String name, String email, String phoneNumber, String city, String address) {
        super(name, email, phoneNumber, "Emergency", city, address);
    }

    public Emergency(String name, String email, String phoneNumber, String city, String address, String group, String tag) {
        super(name, email, phoneNumber, "Emergency", city, address, group, tag);
    }

    public Emergency(String name, String email, String phoneNumber, String city, String address, ArrayList<String> group, ArrayList<String> tag) {
        super(name, email, phoneNumber, "Emergency", city, address, group, tag);
    }

    @Override
    public boolean hasMissingInfo()
    {
        return super.hasMissingInfo();
    }

    @Override
    public String toFile()
    {
        return super.toFile();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}