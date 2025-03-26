/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.driversproject.dto.drivers;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

/**
 *
 * @author jose
 */
@Value
public class UpdateDriverRequestDTO {
   @NotBlank
   private final String name;
   @Min(18)
   private final int age;
}
