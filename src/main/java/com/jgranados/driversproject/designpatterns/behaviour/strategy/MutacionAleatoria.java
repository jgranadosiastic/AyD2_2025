package com.jgranados.driversproject.designpatterns.behaviour.strategy;

import java.util.Random;

import static com.jgranados.driversproject.designpatterns.behaviour.strategy.Individuo.MAX_VALOR_GEN;

public class MutacionAleatoria implements Mutable {
    @Override
    public Individuo mutar(Individuo individuo) {
        System.out.println("Mutacion Aleatoria");
        Random random = new Random();
        int gen = random.nextInt(individuo.size());
        int nuevoValor = random.nextInt(MAX_VALOR_GEN);

        individuo.getGenes()[gen] = nuevoValor;

        return individuo;
    }
}
