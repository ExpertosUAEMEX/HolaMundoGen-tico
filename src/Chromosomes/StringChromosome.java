package Chromosomes;

import GeneticOperations.GOperators;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author cachubis
 */
public class StringChromosome {
    
    private int numGene;
    private String chromosome;

    public void setChromosome(String chromosome) {
        this.chromosome = chromosome;
    }
    private int fitness;

    public StringChromosome(int numGene) {
        this.numGene = numGene;
        generate();
    }

    public void setFitness(int fit) {
        this.fitness = fit;
    }

    public int getFitness() {
        return fitness;
    }

    public String getChromosome() {
        return chromosome;
    }

    private void generate() {
        chromosome = "";
        for (int i = 0; i < numGene; i++) {
            chromosome += (char) GOperators.dict[ThreadLocalRandom.current().nextInt(GOperators.dict.length)];
        }
    }

}
