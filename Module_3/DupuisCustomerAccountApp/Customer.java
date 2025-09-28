/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
Comprehensive Version (12th ed.). Pearson Education, Inc.
Dupuis, J. (2025). CSI 505 Intermediate Java Programming. Bellevue University. Modified by A. Student 2025.
*/

 package Module_3.DupuisCustomerAccountApp;

// Represents a customer with their basic contact information.
public class Customer {
    // Private data fields
    private String name; // Specifies name of the customer.
    private String address; // Specifies the address of the customer.
    private String city; // Specifies the city of the customer.
    private String zip; // specifies the zip code of the customer.

    // No-argument constructor initializes the default customer values.
    public Customer() {
        this.name = "Default Name";
        this.address = "Default Address";
        this.city = "Default City";
        this.zip = "00000";
    }

    // Argument constructor to initialize a customer using four data fields.
    public Customer(String name, String address, String city, String zip) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.zip = zip;
    }

    // Accessor methods for each field.
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public String getZip() { return zip; }

    // Returns a formatted string with customer details with all four fields on separate lines.
    @Override
    public String toString() {
        return name + "\n" + address + "\n" + city + "\n" + zip;
    }
}

