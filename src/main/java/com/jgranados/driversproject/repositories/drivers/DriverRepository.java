/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jgranados.driversproject.repositories.drivers;



import com.jgranados.driversproject.entities.drivers.Driver;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jose
 */
@Repository
public interface DriverRepository extends CrudRepository<Driver, Long>{
    
    @Override
    List<Driver> findAll();
    
    boolean existsByName(String name);
}
