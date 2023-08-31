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
package log;

import es.udc.gii.common.eaf.algorithm.EvolutionaryAlgorithm;
import es.udc.gii.common.eaf.algorithm.population.Individual;
import ElitesMap.MAPElitesMap;
import algorithms.EvolutionaryAlgorithmWithMap;
import cells.MapElitesCell;
import es.udc.gii.common.eaf.log.LogTool;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;
import individual.MEIndividual;

/**
 *
 * @author balaz
 */
public class MAPEvolutionLineLog extends LogTool {
    private int dimensionSize;

    public MAPEvolutionLineLog() {
    }

    @Override
    public void update(Observable o, Object arg) {

        EvolutionaryAlgorithmWithMap algorithm = (EvolutionaryAlgorithmWithMap) o;
        String individual_str = "";
        MAPElitesMap map;
        MapElitesCell cell;
        List<MapElitesCell> cells;
        int n = 0;

        super.update(o, arg);
        if (algorithm.getState() == EvolutionaryAlgorithm.FINAL_STATE) {
            map = algorithm.getMap();
            cells = map.getMap();

            for (MapElitesCell c : cells) {
                n++;

                if (c.isItFilled()) {
                    individual_str += c.getFittest().getFitness() + " ";
                } else {
                    individual_str += "100000" + " ";
                }
                if (n % 10 == 0) {
                        super.getLog().println(individual_str);
                        individual_str = "";
                    }


            }

            super.getLog().println();
            super.getLog().println();

        }
    }
       
}
