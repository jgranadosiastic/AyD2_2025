package com.jgranados.driversproject.designpatterns.behaviour.strategy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Main main = new Main();
        main.ejecutarMutacion();

    }

    public void ejecutarMutacion() {
        System.out.println("Mutacion a utilizar?");
        System.out.println("1. Aleatoria");
        System.out.println("2. Conmutativa");
        Scanner scanner = new Scanner(System.in);
        String opcion = scanner.nextLine();

        Mutable mutacionSeleccionada;
        if (opcion.equals("1")) {
            mutacionSeleccionada = new MutacionAleatoria();
        } else {
            mutacionSeleccionada = new MutacionConmutativa();
        }

        Individuo individuo = new Individuo(10);
        System.out.println("individuo no mutado: " + individuo);

        individuo = aplicarMutacion(individuo, mutacionSeleccionada);

        System.out.println("individuo no mutado: " + individuo);
    }

    public Individuo aplicarMutacion(Individuo individuo, Mutable mutacion) {
        return mutacion.mutar(individuo);
    }
}
