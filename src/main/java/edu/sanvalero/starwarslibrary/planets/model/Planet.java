package edu.sanvalero.starwarslibrary.planets.model;

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
public class Planet extends BaseModel {
    @Column(name = "mean_temperature")
    float meanTemperature;
    @Column()
    String terrain;
    @Column()
    String climate;
}
