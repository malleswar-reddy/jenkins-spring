package com.jenkins.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    private Long id;
    private String name;
}
