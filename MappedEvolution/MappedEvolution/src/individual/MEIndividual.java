/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package individual;

import es.udc.gii.common.eaf.algorithm.population.Individual;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author balaz
 */
public class MEIndividual extends Individual {

    private List<Double> behavioralFeatures = null;

    public List<Double> getBehavioralFeatures() {
        return this.behavioralFeatures;
    }

    public void setBehavioralFeatures(List<Double> behavioralFeatures) {
        this.behavioralFeatures = behavioralFeatures;
    }

    @Override
    public MEIndividual clone() {
        MEIndividual clone = null;
        clone = (MEIndividual) super.clone();
        if (behavioralFeatures != null) {
            List<Double> cloneDynamicFeatures = new ArrayList<>(behavioralFeatures);
            clone.setBehavioralFeatures(cloneDynamicFeatures);
        }
        if (behavioralFeatures != null) {
            List<Double> cloneStaticFeatures = new ArrayList<>(behavioralFeatures);
            clone.setBehavioralFeatures(cloneStaticFeatures);
        }
        return clone;
    }


}
