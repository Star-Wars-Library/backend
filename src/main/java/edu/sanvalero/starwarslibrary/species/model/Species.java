package edu.sanvalero.starwarslibrary.species.model;

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
public class Species extends BaseModel {
    @Column(name = "native_planet")
    long nativePlanet;
    @Column()
    String language;
    @Column(name="mean_height")
    float meanHeight;
    @Column(name="mean_lifespan")
    float meanLifespan;
}
