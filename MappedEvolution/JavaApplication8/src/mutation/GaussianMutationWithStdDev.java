/*
 * Copyright (C) 2023 balaz
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package mutation;

import es.udc.gii.common.eaf.algorithm.EvolutionaryAlgorithm;
import es.udc.gii.common.eaf.algorithm.operator.reproduction.mutation.MutationOperator;
import es.udc.gii.common.eaf.algorithm.population.Individual;
import es.udc.gii.common.eaf.util.ConfWarning;
import es.udc.gii.common.eaf.util.EAFRandom;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.configuration.Configuration;

/**
 *
 * @author balaz
 */
public class GaussianMutationWithStdDev extends MutationOperator {

    private double mean = 0;
    private double standardDev = 0.3;
    private double gaussianValue = 0.0;

    public GaussianMutationWithStdDev() {

//        this.random = new Random(System.currentTimeMillis());
    }

    public GaussianMutationWithStdDev(int probability) {

        super(probability);

    }

    @Override
    protected List<Individual> mutation(EvolutionaryAlgorithm algorithm,
            Individual individual) {

        //Recorro todos los genes del chromosoma del individuo y los muto:
        double[] genes = individual.getChromosomeAt(0);
        double newValue, mutationGene, mean, standardDev, gaussianValue, value;
        Individual newIndividual = (Individual) individual.clone();
        List<Individual> mutated_individual = new ArrayList<Individual>();

//        mean = 0;
//        standardDev = 0.3;
//        gaussianValue = 0.0;
        for (int i = 0; i < genes.length; i++) {

            if (super.getProbability() >= EAFRandom.nextDouble() * 100) {
                gaussianValue = EAFRandom.nextGaussian() * this.standardDev + this.mean;

                mutationGene = genes[i];
                value = gaussianValue + mutationGene;
                genes[i] = checkBounds(algorithm, value);

            }
        }

        newIndividual.setChromosomeAt(0, genes);

        mutated_individual.add(newIndividual);
        return mutated_individual;

    }

    @Override
    public void configure(Configuration conf) {
        super.configure(conf);
        if (conf.containsKey("Mean")) {
            this.mean = conf.getDouble("Mean");
        }
        if (conf.containsKey("standardDev")) {
            this.standardDev = conf.getDouble("standardDev");
        }
        if (conf.containsKey("gaussianValue")) {
            this.gaussianValue = conf.getDouble("gaussianValue");
        }

    }

}
