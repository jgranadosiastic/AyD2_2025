/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jgranados.driversproject.services.drivers;

import com.jgranados.driversproject.dto.drivers.DriverResponseDTO;
import com.jgranados.driversproject.dto.drivers.NewDriverRequestDTO;
import com.jgranados.driversproject.dto.drivers.UpdateDriverRequestDTO;
import com.jgranados.driversproject.entities.drivers.Driver;
import com.jgranados.driversproject.exceptions.DuplicatedEntityException;
import com.jgranados.driversproject.exceptions.NotFoundException;

import java.util.List;

/**
 *
 * @author jose
 */
public interface DriverService {

    DriverResponseDTO createDriver(NewDriverRequestDTO newDriver) throws DuplicatedEntityException;

    List<Driver> findAll();

    void deleteDriver(Long id) throws NotFoundException;

    DriverResponseDTO updateDriver(Long id, UpdateDriverRequestDTO dataToUpdate) throws NotFoundException, DuplicatedEntityException;

    Driver findById(Long id) throws NotFoundException;
}
