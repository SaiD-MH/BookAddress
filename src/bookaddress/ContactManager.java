package bookaddress;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {

    private Contact contact;
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Contact> contactList = new ArrayList<Contact>();

    public ContactManager() {

        loadContacts();

    }

    public void loadContacts() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("database.ser"))) {
            contactList = (ArrayList<Contact>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found Error in database!");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading from the file: " + e.getMessage());
        }
    }

    public void saveContacts() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("database.ser"))) {
            oos.writeObject(contactList);
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }

    public void addContact() {

        try (FileOutputStream fos = new FileOutputStream("database.ser", true); ObjectOutputStream os = new ObjectOutputStream(fos);) {
            String name, mail, phone;

            System.out.println("Enter Contact Name :");
            name = sc.nextLine();
            System.out.println("Enter Contact PhoneNumber :");
            phone = sc.nextLine();
            System.out.println("Enter Contact Email Address :");
            mail = sc.nextLine();

            contact = new Contact(name, phone, mail);
            contactList.add(contact);
            saveContacts();
            System.out.println("Contact Added Succsufflly :)");
        } catch (Exception ex) {
            System.out.println("Can't added this contact !!!!!!!!!!");
            ex.printStackTrace();
        }

    }

    public void viewContacts() {

        //   System.out.println("Size" + contactList.size());
        if (contactList.size() == 0) {
            System.err.println("No Contacts to Display !");
        }

        int id = 1;
        for (Contact ct : contactList) {
            System.out.println("id : " + id++);
            System.out.println("Name : " + ct.getName());
            System.out.println("Phone Number : " + ct.getPhoneNumber());
            System.out.println("Email : " + ct.getEmailAddress());
            System.out.println("---------------------------------------");
        }

    }

    public void deleteContact() {

        viewContacts();

        System.out.println("Enter Contact You want to Delete: ");
        int id = sc.nextInt();

        if (id > contactList.size()) {
            System.err.println("You are kidding Goodbye !");
            return;
        }

        contactList.remove(id - 1);
        saveContacts();

    }

    public void updateContact() {

        viewContacts();

        System.out.println("Enter Contact You want to Update: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        if (id > contactList.size()) {
            System.err.println("You are kidding Goodbye !");
            return;
        }

        System.out.println("Enter Contact Name :");
        String name = sc.nextLine();

        System.out.println("Enter Contact Phone Number :");
        String Phone = sc.nextLine();

        System.out.println("Enter Contact mail :");
        String mail = sc.nextLine();

        contactList.get(id - 1).setName(name);
        contactList.get(id - 1).setPhoneNumber(Phone);
        contactList.get(id - 1).setEmailAddress(mail);

        saveContacts();
    }

    public void searchContact() {
        
        System.out.println("Enter any Name");
        String name = sc.nextLine();
        
        ArrayList<Contact>temp = new ArrayList<Contact>();
         for (Contact ct : contactList) {
            if(ct.getName().contains(name))
                temp.add(ct);
        }
         
         if(temp.size() == 0){
             System.err.println("Sorry , No Matched Results!");
         }
         else{
             
             Print(temp);
         }
        
        
    }

    public void Print(ArrayList<Contact> lst) {
        int id = 1;
        for (Contact ct : lst) {
            System.out.println("id : " + id++);
            System.out.println("Name : " + ct.getName());
            System.out.println("Phone Number : " + ct.getPhoneNumber());
            System.out.println("Email : " + ct.getEmailAddress());
            System.out.println("---------------------------------------");
        }
    }

}
