package edu.sanvalero.starwarslibrary.weapons.model;

import edu.sanvalero.starwarslibrary.shared.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data()
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Weapon extends BaseModel {
    @Column(name = "tech_level")
    String techLevel;
    @Column()
    int ammunition;
    @Column()
    float weight;
}
