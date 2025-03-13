package com.jgranados.driversproject.dto.drivers;

import com.jgranados.driversproject.entities.drivers.Driver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DriverResponseDTOTest {
    private static final Long DRIVER_ID = 1L;
    private static final String DRIVER_NAME = "name";
    private static final int DRIVER_AGE = 2;


    @Test
    void testConstructor() {
        // Arrange
        Driver driver = new Driver();
        driver.setId(DRIVER_ID);
        driver.setName(DRIVER_NAME);
        driver.setAge(DRIVER_AGE);

        // Act
        DriverResponseDTO result = new DriverResponseDTO(driver);

        // Assert
        assertAll(
                () -> assertEquals(DRIVER_ID, result.getId()),
                () -> assertEquals(DRIVER_NAME, result.getName()),
                () -> assertEquals(DRIVER_AGE, result.getAge())
        );
    }

}