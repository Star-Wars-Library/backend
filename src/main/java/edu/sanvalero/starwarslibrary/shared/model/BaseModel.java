package edu.sanvalero.starwarslibrary.shared.model;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column
    String name;
}
