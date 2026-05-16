import java.util.*;

public abstract class Contact {

    //Variables
    private String name;
    private String email;
    private String phoneNumber;
    private String type;
    private String city;
    private String address;
    private ArrayList<String> groups = new ArrayList<>();
    private ArrayList<String> tags = new ArrayList<>();

    //Constructors
    protected Contact(String type) {
        this.name = "UNK";
        this.email = "UNK";
        this.phoneNumber = "UNK";
        this.type = type;
        this.city = "UNK";
        this.address = "UNK";
    }

    protected Contact(String name, String email, String phoneNumber, String type, String city, String address) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.type = type;
        this.city = city;
        this.address = address;
    }

    //Constructor for adding a starting group and tag
    protected Contact(String name, String email, String phoneNumber, String type, String city, String address, String group, String tag) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.type = type;
        this.city = city;
        this.address = address;
        this.groups.add(group);
        this.tags.add(tag);
    }

    //Constructor for adding a multiple groups and tags
    protected Contact(String name, String email, String phoneNumber, String type, String city, String address, ArrayList<String> group, ArrayList<String> tag) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.type = type;
        this.city = city;
        this.address = address;
        this.groups = group;
        this.tags = tag;
    }

    //Getters and setters
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<String> getGroups() {
        return this.groups;
    }

    public void addGroup(String group) {
        this.groups.add(group);
    }

    public ArrayList<String> getTags() {
        return this.tags;
    }

    public void addTag(String tag) {
        this.tags.add(tag);
    }

    public void removeGroup(int index) {
        this.groups.remove(index);
    }

    public void removeTag(int index) {
        this.tags.remove(index);
    }

    public void removeLastGroup() {
        this.groups.remove(this.groups.size() - 1);
    }

    public void removeLastTag() {
        this.tags.remove(this.tags.size() - 1);
    }

    public int getNumberGroups() {
        return this.groups.size();
    }

    public int getNumberTags() {
        return this.tags.size();
    }

    public boolean hasMissingInfo()
    {
        return name.equals("UNK")
            || email.equals("UNK")
            || phoneNumber.equals("UNK")
            || city.equals("UNK")
            || address.equals("UNK")
            || groups.isEmpty()
            || tags.isEmpty();
    }

    // returns string in format for the file
    public String toFile()
    {
        String group = "";
        String tag = "";

        //Print out all groups
        for(int i = 0; i < groups.size(); i++) {
            group += groups.get(i);

            if(i < groups.size() - 1)
                group += ",";
            
        }

        //Print out all tags
        for(int i = 0; i < tags.size(); i++) {
            tag += tags.get(i);

            if(i <tags.size() - 1)
                tag += ",";
        }

        return this.type + "|" +
                this.name + "|" +
                this.email + "|" +
                this.phoneNumber + "|" +
                this.city + "|" +
                this.address + "|" +
                group + "|" +
                tag;


    }

    // /* Since individual contacts should be in charge of their own tags
    //    I'll put add and remove tag in Contact.java and let CBM
    //    handle/control which contact to change -MS*/
    // public boolean addTag(String name, String tag)
    // {
    //     if(tag == null || tag.isBlank())    // If tags is empty
    //     {
    //         return false;
    //     }

    //     if(tags.contains(tag))  // If tag already exists
    //     {
    //         return false;
    //     }

    //     tags.add(tag);      // Add custom tag
    //     return true;
    // }

    // public boolean removeTag(String name, String tag)
    // {
    //     // if person exists and list is not empty,
    //         // Remove tag

    //     // else
    //         // Person not found
    //         return false;
    // }

    @Override
    public String toString() {
        String group = "";
        String tag = "";

        //Print out all groups
        for(int i = 0; i < groups.size(); i++) {
            group += groups.get(i);

            if(i < groups.size() - 1)
                group += ", ";
            
        }

        //Print out all tags
        for(int i = 0; i < tags.size(); i++) {
            tag += tags.get(i);

            if(i <tags.size() - 1)
                tag += ", ";
        }

        return  "\nname: " + this.name +
                "\nEmail: " + this.email + 
                "\nPhone Number: " + this.phoneNumber + 
                "\nCity: " + this.city + 
                "\nAddress: " + this.address + 
                "\nType: " + this.type + 
                "\nGroups: " + group + 
                "\nTags: " + tag;
    }
}