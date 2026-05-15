
public class ContactBookManager {
    private Contact[] contacts = new Contact[100];
    private int contactCount = 0;

    public int findContactbyName(String name) {
        for (int i = 0; i < contactCount; i++) {
            if (contacts[i].getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public int findContactbyEmail(String email) {
        for (int i = 0; i < contactCount; i++) {
            if (contacts[i].getEmail().equalsIgnoreCase(email)) {
                return i;
            }
        }
        return -1;
    }

    public int findContactbyPhoneNumber(String phoneNumber) {
        for (int i = 0; i < contactCount; i++) {
            if (contacts[i].getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
                return i;
            }
        }
        return -1;
    }

    public void viewContact(int contactIndex) {
        if (contactIndex >= 0 && contactIndex < contactCount) {
            System.out.println("Contact Details:");

            System.out.println(contacts[contactIndex]);
        } else {
            System.out.println("Invalid contact index.");
        }
    }

    public void viewAllContacts() {
        System.out.println("All Contact Details:");

        for (int i = 0; i < contactCount; i++) {
            System.out.println("Contact " + (i + 1) + ":");
            System.out.println(contacts[i]);
        }
    }

}
