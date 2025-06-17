package com.asalkar.healthyhub.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reports")
public class Report {

    @Id
    private String id;
    private String name;
    private String email;
    private String message;

    // Getters & Setters
}
