package com.jgranados.driversproject.controllers.driver;

import com.jgranados.driversproject.CommonMvcTest;
import com.jgranados.driversproject.dto.drivers.DriverResponseDTO;
import com.jgranados.driversproject.entities.drivers.Driver;
import com.jgranados.driversproject.services.drivers.DriverService;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;


import java.util.Collections;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = {DriverController.class})
class DriverControllerTest extends CommonMvcTest {

    private static final int AGE = 28;
    private static final String NAME = "name";
    private static final long ID = 1L;

    @MockitoBean
    private DriverService driverService;

    @Test
    void testGetAllDrivers() throws Exception {
        // Arrange
        Driver driver = new Driver();
        driver.setId(ID);
        driver.setName(NAME);
        driver.setAge(AGE);

        DriverResponseDTO dto = new DriverResponseDTO(driver);

        when(driverService.findAll()).thenReturn(Collections.singletonList(driver));

        // Act
        mockMvc.perform(get("/v1/drivers"))
                .andExpect(status().isOk())
                .andExpect(result -> {
                    String body = result.getResponse().getContentAsString();

                    Assertions.assertThat(body).isEqualTo(objectMapper.writeValueAsString(Collections.singletonList(dto)));
                });


    }
}