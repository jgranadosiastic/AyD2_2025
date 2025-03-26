/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.driversproject.controllers.driver;

import com.jgranados.driversproject.dto.drivers.DriverResponseDTO;
import com.jgranados.driversproject.dto.drivers.NewDriverRequestDTO;
import com.jgranados.driversproject.dto.drivers.UpdateDriverRequestDTO;
import com.jgranados.driversproject.exceptions.ServiceException;
import com.jgranados.driversproject.services.drivers.DriverService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<DriverResponseDTO> createDriver(@RequestBody @Valid NewDriverRequestDTO newDriver) throws ServiceException {
        DriverResponseDTO responseDTO = driverService.createDriver(newDriver);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<DriverResponseDTO>> findAllDrivers() {
        List<DriverResponseDTO> dtos = driverService.findAll().stream()
                .map(DriverResponseDTO::new)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DriverResponseDTO> findById(@PathVariable Long id) throws ServiceException {
        DriverResponseDTO dto = new DriverResponseDTO(driverService.findById(id));

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long driverId)
            throws ServiceException {
        driverService.deleteDriver(driverId);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/{driverId}")
    public ResponseEntity<DriverResponseDTO> updateDriver(@PathVariable Long driverId,
                                                          @Valid @RequestBody UpdateDriverRequestDTO dataToUpdate)
            throws ServiceException {
        DriverResponseDTO responseDTO = driverService.updateDriver(driverId, dataToUpdate);

        return ResponseEntity.ok(responseDTO);
    }
}
