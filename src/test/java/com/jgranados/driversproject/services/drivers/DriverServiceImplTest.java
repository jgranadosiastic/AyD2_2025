package com.jgranados.driversproject.services.drivers;

import com.jgranados.driversproject.dto.drivers.DriverResponseDTO;
import com.jgranados.driversproject.dto.drivers.NewDriverRequestDTO;
import com.jgranados.driversproject.entities.drivers.Driver;
import com.jgranados.driversproject.exceptions.DuplicatedEntityException;
import com.jgranados.driversproject.repositories.drivers.DriverRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DriverServiceImplTest {

    private static final String DRIVER_NAME = "name";
    private static final int DRIVER_AGE = 1;
    private static final String EXCEPTION_MESSAGE = "Driver with name: name already exists";

    @Mock
    DriverRepository driverRepository;
    @InjectMocks
    DriverServiceImpl serviceToTest;

    @Test
    void testCreateDriverWhenNameNotDuplicated() throws Exception {
        // Arrange
        NewDriverRequestDTO dto = new NewDriverRequestDTO(
                DRIVER_NAME, DRIVER_AGE
        );
        Driver driver = new Driver();
        driver.setName(DRIVER_NAME);
        driver.setAge(DRIVER_AGE);

        ArgumentCaptor<Driver> captor = ArgumentCaptor.forClass(Driver.class);

        when(driverRepository.existsByName(DRIVER_NAME))
                .thenReturn(false);
        when(driverRepository.save(captor.capture()))
                .thenReturn(driver);

        // Act
        DriverResponseDTO result = serviceToTest.createDriver(dto);

        // Assert
        assertAll(
                () -> assertEquals(DRIVER_NAME, captor.getValue().getName()),
                () -> assertEquals(DRIVER_AGE, captor.getValue().getAge()),
                () -> assertNotNull(result)
        );
    }

    @Test
    void testCreateDriverWhenNameDuplicated() throws Exception {
        // Arrange
        NewDriverRequestDTO dto = new NewDriverRequestDTO(
                DRIVER_NAME, DRIVER_AGE
        );

        when(driverRepository.existsByName(DRIVER_NAME))
                .thenReturn(true);

        // Assert
        DuplicatedEntityException ex = assertThrows(DuplicatedEntityException.class, () ->  serviceToTest.createDriver(dto));
        // assertEquals(EXCEPTION_MESSAGE, ex.getMessage());
        verify(driverRepository, times(0)).save(any(Driver.class));

    }

}