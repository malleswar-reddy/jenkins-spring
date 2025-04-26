package com.jenkins.model;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table
public class Product {
    @Id
    private Long id;
    private String name;
}
