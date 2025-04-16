/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.driversproject.designpatterns.creational.singleton;

/**
 *
 * @author jose
 */
public class Main {
    public static void main(String[] args) {
        //DBConnection dbCon = DBConnection.getInstance();
        DBConnection dbCon = DBConnection.init("aaa", "sss", "sss", "ffff");
        
        DBConnection dbCon2 = DBConnection.getInstance();
        dbCon2.imprimirDatos();
    }
}
