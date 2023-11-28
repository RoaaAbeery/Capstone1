package com.example.newcapstone.Model;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class Product {
    @NotEmpty(message = "id should not be empty")
    private String id;
    @Size(min = 3,message = "name must be more than 3")
    @NotEmpty(message = "name should not be empty")
    private String name;
    @Positive(message = "price should mbe positive number")
    @NotNull(message = " price should not be empty")
    private double price;
    @NotEmpty(message = "category ID should not be empty")
    private String categoryID;
    @NotEmpty(message = "discounts should not be empty")
    @Pattern(regexp = "^(WhiteFriday|BlackFriday|End of year discount|no discount)$")
     private String discounts;

}
