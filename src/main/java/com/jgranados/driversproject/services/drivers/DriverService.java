/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jgranados.driversproject.services.drivers;

import com.jgranados.driversproject.dto.drivers.DriverResponseDTO;
import com.jgranados.driversproject.dto.drivers.NewDriverRequestDTO;
import com.jgranados.driversproject.entities.drivers.Driver;
import com.jgranados.driversproject.exceptions.DuplicatedEntityException;

import java.util.List;

/**
 *
 * @author jose
 */
public interface DriverService {

    DriverResponseDTO createDriver(NewDriverRequestDTO newDriver) throws DuplicatedEntityException;

    List<Driver> findAll();
}
