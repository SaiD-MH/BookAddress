package bookaddress;

import java.io.Serializable;

public class Contact implements Serializable {
      

    private String name;
    private String PhoneNumber;
    private String emailAddress;

    public Contact(String name, String PhoneNumber, String emailAddress) {
        this.name = name;
        this.PhoneNumber = PhoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Contact{" + "name=" + name + ", PhoneNumber=" + PhoneNumber + ", emailAddress=" + emailAddress + '}';
    }
    
    
}
