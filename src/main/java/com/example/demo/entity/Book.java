package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Book {
    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment
    private Long id;
    @Column(length = 50, nullable = false)
    private String title;
    private int price;
    private int page;
}
