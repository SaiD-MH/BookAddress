package bookaddress;

import java.util.Scanner;

public class BookAddress {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ContactManager CM = new ContactManager();
        OUTER:
        while (true) {
            System.out.println(" Enter Operation Number : ");
            System.out.println("[1] - Add Contact ");
            System.out.println("[2] - View Contact ");
            System.out.println("[3] - Delete Contact ");
            System.out.println("[4] - Update Contact ");
            System.out.println("[5] - Search Contact ");
            System.out.println("[6] - Exit ");
            int opCode = sc.nextInt();
            switch (opCode) {
                case 1 -> CM.addContact();
                case 2 -> CM.viewContacts();
                case 3 -> CM.deleteContact();
                case 4 -> CM.updateContact();
                case 5 -> CM.searchContact();
                case 6 -> {
                    break OUTER;
                }
                default -> {
                }
            }
        }

    }

}
