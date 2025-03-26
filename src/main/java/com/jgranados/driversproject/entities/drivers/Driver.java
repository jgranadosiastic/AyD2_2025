package com.jgranados.driversproject.entities.drivers;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


/**
 *
 * @author jose
 */
@Entity(name = "driver")
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
public class Driver {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private int age;
}
