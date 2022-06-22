package edu.sanvalero.starwarslibrary.characters.model;

import edu.sanvalero.starwarslibrary.shared.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Data()
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Character extends BaseModel {
    @Column()
    String gender;
    @Column(name = "year_birth")
    LocalDate yearBirth;
    @Column(name = "force_sensitive")
    Boolean forceSensitive;
    @Column()
    long species;
    @Column()
    long ship;
    @Column()
    long weapon;
    @Column(name = "home_world")
    long homeWorld;
}
