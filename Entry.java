package phonebook;

public class Entry {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String phoneNumber;

    Entry (String firstName, String lastName, String address, String city, String phoneNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setCity(city);
        setPhoneNumber(phoneNumber);
    }

    public void printEntry() {
        System.out.println(firstName + " " + lastName);
        System.out.println(address + ", " + city);
        System.out.println(phoneNumber);
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getAddress() {
        return address;
    }
    public String getCity() {
        return city;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
