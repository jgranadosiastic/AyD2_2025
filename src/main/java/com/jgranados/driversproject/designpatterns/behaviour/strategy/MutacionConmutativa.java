package com.jgranados.driversproject.designpatterns.behaviour.strategy;

import java.util.Random;

import static com.jgranados.driversproject.designpatterns.behaviour.strategy.Individuo.MAX_VALOR_GEN;

public class MutacionConmutativa implements Mutable {

    @Override
    public Individuo mutar(Individuo individuo) {
        System.out.println("Mutacion Conmutativa");
        Random random = new Random();
        int gen1 = random.nextInt(individuo.size());
        int gen2 = random.nextInt(individuo.size());

        int valGen1 = individuo.getGenes()[gen1];

        individuo.getGenes()[gen1] = individuo.getGenes()[gen2];
        individuo.getGenes()[gen2] = valGen1;

        return individuo;
    }
}
