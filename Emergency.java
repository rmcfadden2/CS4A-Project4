public class Emergency extends Contact{
    //Constructors
    protected Emergency() {
        super("Emergency");
    }

    protected Emergency(String name, String email, String phoneNumber, String city, String address) {
        super(name, email, phoneNumber, "Emergency", city, address);
    }

    protected Emergency(String name, String email, String phoneNumber, String city, String address, String group, String tag) {
        super(name, email, phoneNumber, "Emergency", city, address, group, tag);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}