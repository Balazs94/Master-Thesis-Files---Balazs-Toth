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
package selections;

import algorithms.EvolutionaryAlgorithmWithMap;
import es.udc.gii.common.eaf.algorithm.EvolutionaryAlgorithm;
import es.udc.gii.common.eaf.algorithm.operator.selection.SelectionOperator;
import es.udc.gii.common.eaf.algorithm.population.Individual;
import es.udc.gii.common.eaf.exception.OperatorException;
import es.udc.gii.common.eaf.util.EAFRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.configuration.Configuration;

/**
 *
 * @author balaz
 */
public class MESelection extends SelectionOperator {
    
    private int BATCH_SIZE;

    @Override
    protected Individual select(EvolutionaryAlgorithm algorithm, List<Individual> individuals) {

        int maxRandom = individuals.size() - 1;
        int selectedIndividual;

        selectedIndividual = (int) Math.round(EAFRandom.nextDouble() * maxRandom);

        return individuals.get(selectedIndividual);

    }

    @Override
    public List<Individual> operate(EvolutionaryAlgorithm algorithm,
            List<Individual> individuals) throws OperatorException {

        EvolutionaryAlgorithmWithMap MAPAlgorithm = (EvolutionaryAlgorithmWithMap) algorithm;

        Individual[] selected = null;

        if (individuals == null) {

            throw new OperatorException("Selection - "
                    + "Empty individuals");

        }

        selected = new Individual[10];

        for (int i = 0; i < selected.length; i++) {

            selected[i] = this.select(algorithm, MAPAlgorithm.getMap().getIndividuals());

        }

        return new ArrayList<Individual>(Arrays.asList(selected));
        

    }
    
    @Override
    public void configure(Configuration conf) {
        if (conf.containsKey("Population")) {
            this.BATCH_SIZE = conf.getInt("Size");

        }
    }
    
    

}
