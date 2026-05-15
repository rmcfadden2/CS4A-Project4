import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ContactBookManager {

    private ArrayList<Contact> contactList;


    public ContactBookManager()
    {
        contactList = new ArrayList<>();

        loadFile();
    }


    // TEST FUNCTION
    public void Output()
    {
        for(Contact contact : contactList)
            System.out.println(contact.toString());
    }


    // TEST FUNCTION
    public void add()
    {
        contactList.add(new Person());
    }

    public boolean editContact(int originalContactIndex, Contact newContact)
    {
        try
        {
            contactList.set(originalContactIndex, newContact);

            if (!contactList.get(originalContactIndex).equals(newContact)) {
                return false;
            }
        }
        catch(IndexOutOfBoundsException e)
        {
            return false;
        }
        return true;
    }


    // input parameter 1: filterType:
    //      1 is Type
    //      2 is Group
    //      3 is Tag
    //
    // input parameter 2: typeName
    //      input the specific name you are filtering by
    //
    //  EX:
    //  - If you want to filter by type Person
    //      - call viewFilteredContacts(1, "Person");
    //  - If you want to filter by group Family
    //      - call viewFilteredContacts(2, "Family");
    public void viewFilteredContacts(int filterType, String typeName)
    {
        int i = 1;
        switch(filterType)
        {
            case 1:
                System.out.println("Showing all contacts in type " + typeName);
                for(Contact contact : contactList)
                {
                    if(contact.getType().equals(typeName))
                        System.out.println((i++) + contact.toString());
                }
                break;
            case 2:
                System.out.println("Showing all contacts in group " + typeName);
                for(Contact contact : contactList)
                {
                    ArrayList<String> groups = contact.getGroups();
                    for(String group : groups)
                    {
                        if(group.equals(typeName))
                        {
                            System.out.println((i++) + contact.toString());
                        }
                    }
                }
                break;
            case 3:
                System.out.println("Showing all contacts with tag " + typeName);
                for(Contact contact : contactList)
                {
                    ArrayList<String> tags = contact.getTags();
                    for(String tag : tags)
                    {
                        if(tag.equals(typeName))
                        {
                            System.out.println((i++) + contact.toString());
                        }
                    }
                }
                break;
        }
    }

    public void viewContactsMissingInfo()
    {
        System.out.println("Contacts Missing Info: ");
        int i = 0;
        for(Contact contact : contactList)
        {
            if(contact.hasMissingInfo())
            {
                System.out.println((++i) + " " + contact);
            }
        }
    }


    public void loadFile()
    {
        try {
            File file = new File("contactList.txt");
            Scanner scanner = new Scanner(file);


            // each line in the form of 
            // type|name|email|phoneNumber|city|address|groups|tags
            // Parts[0]|Parts[1]|Parts[2]|Parts[3]|Parts[4]|Parts[5]|Parts[6]|Part[7]
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);

                String[] parts = line.split("\\|");

                String[] groups = parts[6].split(",");
                ArrayList<String> groupList = new ArrayList<>(Arrays.asList(groups));

                String[] tags = parts[7].split(",");
                ArrayList<String> tagList = new ArrayList<>(Arrays.asList(tags));

                switch(parts[0])
                {
                    case "Person":
                        contactList.add(new Person(parts[1], parts[2], parts[3], parts[4], parts[5], groupList, tagList, parts[8], parts[9]));
                        break;
                    case "Business":
                        contactList.add(new Business(parts[1], parts[2], parts[3], parts[4], parts[5], groupList, tagList, parts[8], parts[9]));
                        break;
                    case "Vendor":
                        contactList.add(new Vendor(parts[1], parts[2], parts[3], parts[4], parts[5], groupList, tagList));
                        break;
                    case "Emergency":
                        contactList.add(new Emergency(parts[1], parts[2], parts[3], parts[4], parts[5], groupList, tagList));
                        break;
                    default:
                        continue;
                }
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }

    public void saveFile()
    {
        try {
            FileWriter writer = new FileWriter("contactList.txt");

            for(Contact contact : contactList)
            {
                writer.write(contact.toFile());
                writer.write(System.lineSeparator());
            }

            writer.close();

            System.out.println("File saved.");
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

}
