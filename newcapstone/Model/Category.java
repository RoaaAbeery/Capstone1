package com.example.newcapstone.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {
    @NotEmpty(message = "id should not be empty")
    private String id;
    @NotEmpty(message = "name should not be empty")
    @Size(min = 3)
    private String name;
}
