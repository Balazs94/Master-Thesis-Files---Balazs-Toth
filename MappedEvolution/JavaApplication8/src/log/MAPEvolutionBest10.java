/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class MAPEvolutionBest10 extends LogTool {

    public MAPEvolutionBest10() {
    }

    @Override
    public void update(Observable o, Object arg) {

        EvolutionaryAlgorithmWithMap algorithm = (EvolutionaryAlgorithmWithMap) o;
        String individual_str = null;
        MAPElitesMap map;
        List<MapElitesCell> cells;
        List<Individual> indList;

        super.update(o, arg);
        if (algorithm.getState() == EvolutionaryAlgorithm.FINAL_STATE) {
            individual_str += "";
            map = algorithm.getMap();
            indList = map.getIndividuals();
            Comparator<Individual> comp = Comparator.comparing(Individual::getFitness);
            indList.sort(comp);
            for (int i = 0; i < 10; i++) {
                Individual ind = indList.get(i);
                if (ind instanceof MEIndividual) {
                    MEIndividual meIndividual = (MEIndividual) ind;
                    individual_str += meIndividual.toString();
                    individual_str += "   FEATURES: " + meIndividual.getBehavioralFeatures().get(0) + ", " + meIndividual.getBehavioralFeatures().get(1);
                    super.getLog().println(individual_str);
                    super.getLog().println();
                    super.getLog().println();

                }

                super.getLog().println();
                super.getLog().println();
            }

        }
    }
}
