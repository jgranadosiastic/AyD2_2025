/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.driversproject.controllers.driver;

import com.jgranados.driversproject.dto.drivers.DriverResponseDTO;
import com.jgranados.driversproject.dto.drivers.NewDriverRequestDTO;
import com.jgranados.driversproject.exceptions.ServiceException;
import com.jgranados.driversproject.services.drivers.DriverService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 */
@RestController
@RequestMapping("/v1/drivers")
public class DriverController {

    private DriverService driverService;

    @Autowired
    public DriverController(DriverService DriverService) {
        this.driverService = DriverService;
    }

    @PostMapping
    public ResponseEntity<DriverResponseDTO> createDriver(@RequestBody NewDriverRequestDTO newDriver) throws ServiceException {
        DriverResponseDTO responseDTO = driverService.createDriver(newDriver);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<DriverResponseDTO>> findAllDrivers() {
        List<DriverResponseDTO> dtos = driverService.findAll().stream()
                .map(DriverResponseDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

}
