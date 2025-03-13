/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.driversproject.services.drivers;

import com.jgranados.driversproject.dto.drivers.DriverResponseDTO;
import com.jgranados.driversproject.dto.drivers.NewDriverRequestDTO;
import com.jgranados.driversproject.entities.drivers.Driver;
import com.jgranados.driversproject.exceptions.DuplicatedEntityException;
import com.jgranados.driversproject.repositories.drivers.DriverRepository;

import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jose
 */
@Service
@Slf4j
@Transactional(rollbackFor = ServiceException.class)
public class DriverServiceImpl implements DriverService {

    private DriverRepository driverRepository;

    @Autowired
    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public DriverResponseDTO createDriver(NewDriverRequestDTO newDriver) throws DuplicatedEntityException {
        if (driverRepository.existsByName(newDriver.getName())) {
            throw new DuplicatedEntityException(String.format("Driver with name: %s already exists", newDriver.getName()));
        }
        Driver newDriverEntity = new Driver();
        newDriverEntity.setAge(newDriver.getAge());
        newDriverEntity.setName(newDriver.getName());

        newDriverEntity = driverRepository.save(newDriverEntity);

        return new DriverResponseDTO(newDriverEntity);
    }

    @Override
    public List<Driver> findAll() {
        return driverRepository.findAll();
    }
}
