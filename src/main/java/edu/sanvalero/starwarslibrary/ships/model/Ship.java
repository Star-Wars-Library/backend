package edu.sanvalero.starwarslibrary.ships.model;

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
public class Ship extends BaseModel {
    @Column()
    String model;
    @Column()
    String constructor;
    @Column()
    float length;
}
