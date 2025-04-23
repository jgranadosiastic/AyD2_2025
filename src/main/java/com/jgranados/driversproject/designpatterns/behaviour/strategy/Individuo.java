package com.jgranados.driversproject.designpatterns.behaviour.strategy;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class Individuo {

    public static final int MAX_VALOR_GEN = 100;

    public int genes[];

    public Individuo(int cantidadGenes) {
        this.genes = new int[cantidadGenes];
        Random random = new Random();
        for (int i = 0; i < cantidadGenes; i++) {
            genes[i] = random.nextInt(MAX_VALOR_GEN);
        }
    }

    public String toString() {
        return Arrays.stream(genes).boxed().collect(Collectors.toList()).toString();
    }

    public int size() {
        return genes.length;
    }

    public int[] getGenes() {
        return genes;
    }
}
