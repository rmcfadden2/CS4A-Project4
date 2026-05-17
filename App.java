import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        ContactBookManager manager = new ContactBookManager();

        boolean running = true;

        System.out.println("=================================");
        System.out.println("         ADDRESS BOOK");
        System.out.println("=================================");

        while(running)
        {
            // =====================================================
            // MENU
            // =====================================================
            System.out.println("\nChoose an option:");
            System.out.println("1.  Add Contact");
            System.out.println("2.  Edit Contact");
            System.out.println("3.  Delete Contact");
            System.out.println("4.  View Contact Details");
            System.out.println("5.  List All Contacts");
            System.out.println("6.  Search Contact");
            System.out.println("7.  Filter Contacts");
            System.out.println("8.  Assign Contact To Group");
            System.out.println("9.  Remove Contact From Group");
            System.out.println("10. Add Tag");
            System.out.println("11. Remove Tag");
            System.out.println("12. Save Contacts To File");
            System.out.println("13. List Contacts By Type");
            System.out.println("14. Show Contacts Missing Info");
            System.out.println("15. Display Group Contacts");
            System.out.println("16. Exit");

            System.out.print("\nEnter choice: ");

            int choice = input.nextInt();
            input.nextLine();

            switch(choice)
            {
                // =========================
                // ADD CONTACT
                // =========================
                case 1:
                {
                    System.out.println("\n1. Person");
                    System.out.println("2. Business");
                    System.out.println("3. Vendor");
                    System.out.println("4. Emergency");

                    System.out.print("Type: ");
                    int type = input.nextInt();
                    input.nextLine();

                    System.out.print("Name: ");
                    String name = input.nextLine();

                    System.out.print("Email: ");
                    String email = input.nextLine();

                    System.out.print("Phone: ");
                    String phone = input.nextLine();

                    System.out.print("City: ");
                    String city = input.nextLine();

                    System.out.print("Address: ");
                    String address = input.nextLine();

                    ArrayList<String> groups = new ArrayList<>();
                    ArrayList<String> tags = new ArrayList<>();

                    Contact contact = null;

                    if(type == 1)
                    {
                        System.out.print("Apartment Number: ");
                        String apt = input.nextLine();

                        System.out.print("Birthday: ");
                        String birthday = input.nextLine();

                        contact = new Person(name, email, phone, city, address, groups, tags, apt, birthday);
                    }
                    else if(type == 2)
                    {
                        System.out.print("Suite: ");
                        String suite = input.nextLine();

                        System.out.print("URL: ");
                        String url = input.nextLine();

                        contact = new Business(name, email, phone, city, address, groups, tags, suite, url);
                    }
                    else if(type == 3)
                    {
                        contact = new Vendor(name, email, phone, city, address, groups, tags);
                    }
                    else if(type == 4)
                    {
                        contact = new Emergency(name, email, phone, city, address, groups, tags);
                    }

                    if(contact != null && manager.addContact(contact))
                        System.out.println("Contact added.");
                    else
                        System.out.println("Failed to add contact.");

                    break;
                }

                // =========================
                // EDIT CONTACT
                // =========================
                case 2:
                {
                    System.out.print("Enter name: ");
                    String name = input.nextLine();

                    int index = manager.findContactbyName(name);

                    if(index == -1)
                    {
                        System.out.println("Not found.");
                        break;
                    }

                    Contact old = manager.getContact(index);

                    System.out.print("New Name: ");
                    String newName = input.nextLine();

                    System.out.print("New Email: ");
                    String newEmail = input.nextLine();

                    System.out.print("New Phone: ");
                    String newPhone = input.nextLine();

                    System.out.print("New City: ");
                    String newCity = input.nextLine();

                    System.out.print("New Address: ");
                    String newAddress = input.nextLine();

                    Contact updated = null;

                    if(old instanceof Person)
                    {
                        System.out.print("Apartment: ");
                        String apt = input.nextLine();

                        System.out.print("Birthday: ");
                        String birthday = input.nextLine();

                        updated = new Person(newName, newEmail, newPhone, newCity, newAddress,
                                old.getGroups(), old.getTags(), apt, birthday);
                    }
                    else if(old instanceof Business)
                    {
                        System.out.print("Suite: ");
                        String suite = input.nextLine();

                        System.out.print("URL: ");
                        String url = input.nextLine();

                        updated = new Business(newName, newEmail, newPhone, newCity, newAddress,
                                old.getGroups(), old.getTags(), suite, url);
                    }
                    else if(old instanceof Vendor)
                    {
                        updated = new Vendor(newName, newEmail, newPhone, newCity, newAddress,
                                old.getGroups(), old.getTags());
                    }
                    else if(old instanceof Emergency)
                    {
                        updated = new Emergency(newName, newEmail, newPhone, newCity, newAddress,
                                old.getGroups(), old.getTags());
                    }

                    if(manager.editContact(index, updated))
                        System.out.println("Updated.");
                    else
                        System.out.println("Failed.");

                    break;
                }

                // =====================================================
                // DELETE CONTACT
                // =====================================================
                case 3:
                {
                    System.out.print("Enter contact name to delete: ");
                    String name = input.nextLine();

                    if(manager.deleteContact(name))
                    {
                        System.out.println("Contact deleted.");
                    }
                    else
                    {
                        System.out.println("Delete failed.");
                    }

                    break;
                }

                // =====================================================
                // VIEW SINGLE CONTACT
                // =====================================================
                case 4:
                {
                    System.out.print("Enter contact name: ");
                    String name = input.nextLine();

                    int index = manager.findContactbyName(name);

                    manager.viewContact(index);

                    break;
                }

                // =====================================================
                // LIST ALL CONTACTS
                // =====================================================
                case 5:
                {
                    manager.viewAllContacts();
                    break;
                }

                // =====================================================
                // SEARCH CONTACT
                // =====================================================
                case 6:
                {
                    System.out.println("\nSearch by:");
                    System.out.println("1. Name");
                    System.out.println("2. Email");
                    System.out.println("3. Phone Number");

                    System.out.print("Choice: ");
                    int searchChoice = input.nextInt();
                    input.nextLine();

                    int index = -1;

                    switch(searchChoice)
                    {
                        case 1:
                        {
                            System.out.print("Enter name: ");
                            index = manager.findContactbyName(input.nextLine());
                            break;
                        }

                        case 2:
                        {
                            System.out.print("Enter email: ");
                            index = manager.findContactbyEmail(input.nextLine());
                            break;
                        }

                        case 3:
                        {
                            System.out.print("Enter phone number: ");
                            index = manager.findContactbyPhoneNumber(input.nextLine());
                            break;
                        }
                    }

                    manager.viewContact(index);

                    break;
                }

                // =====================================================
                // FILTER CONTACTS
                // =====================================================
                case 7:
                {
                    System.out.println("\nFilter by:");
                    System.out.println("1. Type");
                    System.out.println("2. Group");
                    System.out.println("3. Tag");
                    System.out.println("4. City");

                    System.out.print("Choice: ");
                    int filterChoice = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter filter value: ");
                    String filterValue = input.nextLine();

                    manager.viewFilteredContacts(filterChoice, filterValue);

                    break;
                }

                // =====================================================
                // ASSIGN GROUP
                // =====================================================
                case 8:
                {
                    System.out.print("Enter contact name: ");
                    String name = input.nextLine();

                    int index = manager.findContactbyName(name);

                    System.out.print("Enter group name: ");
                    String group = input.nextLine();

                    if(manager.assignGroup(index, group))
                    {
                        System.out.println("Group assigned.");
                    }
                    else
                    {
                        System.out.println("Assignment failed.");
                    }

                    break;
                }

                // =====================================================
                // REMOVE GROUP
                // =====================================================
                case 9:
                {
                    System.out.print("Enter contact name: ");
                    String name = input.nextLine();

                    int index = manager.findContactbyName(name);

                    System.out.print("Enter group name: ");
                    String group = input.nextLine();

                    if(manager.unassignGroup(index, group))
                    {
                        System.out.println("Group removed.");
                    }
                    else
                    {
                        System.out.println("Remove failed.");
                    }

                    break;
                }

                // =====================================================
                // ADD TAG
                // =====================================================
                case 10:
                {
                    System.out.print("Enter contact name: ");
                    String name = input.nextLine();

                    System.out.print("Enter tag: ");
                    String tag = input.nextLine();

                    if(manager.addTag(name, tag))
                    {
                        System.out.println("Tag added.");
                    }
                    else
                    {
                        System.out.println("Tag add failed.");
                    }

                    break;
                }

                // =====================================================
                // REMOVE TAG
                // =====================================================
                case 11:
                {
                    System.out.print("Enter contact name: ");
                    String name = input.nextLine();

                    System.out.print("Enter tag: ");
                    String tag = input.nextLine();

                    if(manager.removeTag(name, tag))
                    {
                        System.out.println("Tag removed.");
                    }
                    else
                    {
                        System.out.println("Tag remove failed.");
                    }

                    break;
                }

                // =====================================================
                // SAVE FILE
                // =====================================================
                case 12:
                {
                    manager.saveFile();
                    break;
                }

                // =====================================================
                // LIST BY TYPE
                // =====================================================
                case 13:
                {
                    System.out.print("Enter type (Person, Business, Vendor, Emergency): ");
                    String type = input.nextLine();

                    manager.viewFilteredContacts(1, type);

                    break;
                }

                // =====================================================
                // MISSING INFO REPORT
                // =====================================================
                case 14:
                {
                    manager.viewContactsMissingInfo();
                    break;
                }

                // =====================================================
                // DISPLAY GROUP CONTACTS
                // =====================================================
                case 15:
                {
                    System.out.print("Enter group name: ");
                    String group = input.nextLine();

                    manager.viewGroupContacts(group);

                    break;
                }

                // =====================================================
                // EXIT
                // =====================================================
                case 16:
                {
                    running = false;

                    System.out.println("Program ended.");

                    break;
                }

                // =====================================================
                // DEFAULT
                // =====================================================
                default:
                {
                    System.out.println("Invalid choice.");
                    break;
                }
            }
        }

        input.close();
    }
}
