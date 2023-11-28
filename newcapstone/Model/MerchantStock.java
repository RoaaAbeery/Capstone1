package com.example.newcapstone.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MerchantStock {
    @NotEmpty(message = "id should not be empty")
    private String id;
    @NotEmpty(message = "product id should not be empty")
    private String productid;
    @NotEmpty(message = "merchant id should not be empty")
    private String merchantid;
    @NotNull(message = "stock should not be empty")
    @Min(10)
    private int stock;
}
