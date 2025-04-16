/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.driversproject.designpatterns.creational.singleton;

/**
 *
 * @author jose
 */
public class DBConnection {
    
    // Race condition

    private static DBConnection instance;

    private String dbName;
    private String url;
    private String userName;
    private String password;

    public DBConnection(String dbName, String url, String userName, String password) {
        this.dbName = dbName;
        this.url = url;
        this.userName = userName;
        this.password = password;
    }

    public static synchronized DBConnection init(String dbName, String url, String userName, String password) {
        if (instance == null) {
            instance = new DBConnection(dbName, url, userName, password);
        }

        return instance;
    }

    public static synchronized DBConnection getInstance() {

        // si instancia unica aun no se ha creado
        // hay que crearla
        // sino
        // return la unica instancia
        /*
        if (instance == null) {
            instance = new DBConnection(dbName, url, userName, password);
        }
        return instance;*/
        
        if (instance == null) {
            throw new IllegalArgumentException("El singleton debe ser iniciado con el metodo Init");
        }
        return instance;
    }

    public synchronized void imprimirDatos() {
        System.out.println("dbName: " + dbName);
        System.out.println("url: " + url);
        System.out.println("userName: " + userName);
        System.out.println("password: " + password);
    }
    
    public synchronized void setUrl(String newUrl) {
        url = newUrl;
    }
}
