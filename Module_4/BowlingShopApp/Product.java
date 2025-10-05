/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Dupuis, J. (2025). CSI 505 Intermediate Java Programming. Bellevue University. Modified by A. Student 2025.
*/

package Module_4.BowlingShopApp;

// Superclass represents a generic product in the bowling shop.class
public class Product {
    // Unique product code (B100, S200).
    private String code = "";

    // Description of the product ("Black Widow 2.0").
    private String description = "";

    // Price of the product in USD.
    private double price = 0.0;

    // No-argument constructor initializes default values.
    public Product() {}

    // Accessor and mutator for product code.
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    // Accessor and mutator for product description.
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    // Accessor and mutator for product price.
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    // Returns formatted string with product details.
    @Override
    public String toString() {
        return "Product code: " + code + "\n" +
               "Description: " + description + "\n" +
               String.format("Price: $%,6.2f", price);
    }
}

