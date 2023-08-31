/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BehavioralFeatures;

import es.udc.gii.common.eaf.algorithm.population.Individual;
import es.udc.gii.common.eaf.algorithm.population.Population;
import individual.MEIndividual;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.configuration.Configuration;

/**
 *
 * @author balaz
 */
public class BF extends BehavioralFeature {
    List<Double> features = new ArrayList<>();
    private List<?> individuals;
    @Override
    public void configure(Configuration conf) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void evaluateBehavioralFeatures(Population population){
        this.individuals = population.getIndividuals();

        for(Individual ind : population.getIndividuals()){
            MEIndividual currentIndividual = (MEIndividual) ind;
            double[]chromosome = currentIndividual.getChromosomeAt(0);
            double value1 = (chromosome[0] + 1) / 2 * 10.0;
            double value2 = (chromosome[1] + 1) / 2 * 10.0;
            features.add(value1);
            features.add(value2);
            currentIndividual.setBehavioralFeatures(new ArrayList<>(features));
            features.clear();


        
        }
        
    }
    
}
