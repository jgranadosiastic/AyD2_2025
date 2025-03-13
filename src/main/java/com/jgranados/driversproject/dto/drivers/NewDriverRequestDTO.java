/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.driversproject.dto.drivers;

import lombok.Value;

/**
 *
 * @author jose
 */
@Value
public class NewDriverRequestDTO {
   private final String name;
   private final int age;
}
