import java.util.ArrayList;

public class Vendor extends Contact {
    //Constructors
    protected Vendor() {
        super("Vendor");
    }

    protected Vendor(String name, String email, String phoneNumber, String city, String address) {
        super(name, email, phoneNumber, "Vendor", city, address);
    }

    protected Vendor(String name, String email, String phoneNumber, String city, String address, String group, String tag) {
        super(name, email, phoneNumber, "Vendor", city, address, group, tag);
    }

    protected Vendor(String name, String email, String phoneNumber, String city, String address, ArrayList<String> group, ArrayList<String> tag) {
        super(name, email, phoneNumber, "Vendor", city, address, group, tag);
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