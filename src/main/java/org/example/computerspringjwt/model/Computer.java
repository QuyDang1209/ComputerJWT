package org.example.computerspringjwt.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private String producer;
    private String type;

    private String url;




}
