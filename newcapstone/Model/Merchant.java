package com.example.newcapstone.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Merchant {
    @NotNull(message = "id should not be empty")
    private String id;
    @NotNull(message = "name should not be empty")
    @Size(min = 3)
    private String name;
}
