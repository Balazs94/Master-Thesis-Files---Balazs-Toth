/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithms;

//import MAPElites.ElitesMap.MAPElitesMap;
import BehavioralFeatures.BF;
import BehavioralFeatures.BFEH;
import ElitesMap.MAPElitesMap;
//import MAPElites.cell.MapElitesCell;
import cells.MapElitesCell;
import es.udc.gii.common.eaf.algorithm.EvolutionaryAlgorithm;
import es.udc.gii.common.eaf.algorithm.population.Individual;
import es.udc.gii.common.eaf.algorithm.population.Population;
import es.udc.gii.common.eaf.problem.Problem;
import java.util.ArrayList;
//import modules.evaluation.BehavioralFeatures.StaticBehavioralFeatures;
import individual.MEIndividual;
import org.apache.commons.configuration.Configuration;

/**
 *
 * @author balaz
 */
public class EvolutionaryAlgorithmWithMap extends EvolutionaryAlgorithm {

    //Algorithm
    private MAPElitesMap map;
    private int dimensions = 2;
    private int dimSize = 0;
    private String BF1;
    private String BF2;
    private String algorithmType = "GA";  //ME or GA

    //Behavioral features
    private final int geneA = 0;
    private final int geneB = 1;
    private int BF1MinValue;
    private int BF1MaxValue;
    private int BF2MinValue;
    private int BF2MaxValue;
    private double cellDiff1;
    private double cellDiff2;

    //For logging the last batch
    private boolean lastFlag;

    public EvolutionaryAlgorithmWithMap() {

    }

    @Override
    protected void init() {
        super.init();
        map = new MAPElitesMap(dimensions, dimSize, BF1MinValue, BF1MaxValue, BF2MinValue, BF2MaxValue);
        this.lastFlag = false;
        this.cellDiff1 = (BF1MaxValue - BF1MinValue) / dimSize;
        this.cellDiff2 = (BF2MaxValue - BF2MinValue) / dimSize;

    }

    @Override
    protected void evaluate(Problem problem, Population population) {
        super.evaluate(problem, population);

        evaluateBehavioralFeatures(population, map);
        map.fillFilledMap(map.getMap());

    }

    @Override
    protected void select(Population toPopulation) {
        super.select(toPopulation);
        if (this.getMaxEvaluations() <= this.getFEs()) {

        }
    }

    @Override
    protected void reproduce(Population population) {
        super.reproduce(population);
    }

    @Override
    protected void replace(Population toPopulation) {
        if (algorithmType == "ME") {
            //No operation
        } else {
            super.replace(toPopulation);
        }
    }

    @Override
    public String getAlgorithmID() {
        return "EvolutionaryAlgorithmWithMap";
    }

    protected void evaluateBehavioralFeatures(Population population, MAPElitesMap map) {
        BF behavioralFeatures = new BF();
        behavioralFeatures.evaluateBehavioralFeatures(population);

        for (Individual individual : population.getIndividuals()) {
            MEIndividual currentIndividual = (MEIndividual) individual;
            double BFValue1 = 0;
            double BFValue2 = 0;

            switch (BF1) {
                case "geneA":
                    BFValue1 = currentIndividual.getBehavioralFeatures().get(geneA);
                    break;
                case "geneB":
                    BFValue1 = currentIndividual.getBehavioralFeatures().get(geneB);
                    break;

            }

            switch (BF2) {
                case "geneA":
                    BFValue2 = currentIndividual.getBehavioralFeatures().get(geneA);
                    break;
                case "geneB":
                    BFValue2 = currentIndividual.getBehavioralFeatures().get(geneB);
                    break;

            }

            fillCell((MEIndividual) currentIndividual, BFValue1, BFValue2);

        }

    }

    protected void fillCell(MEIndividual individual, double BFValue1, double BFValue2) {
        for (MapElitesCell currentCell : map.getMap()) {

            ArrayList<Double> cellValue = currentCell.getCellValue();
            if (currentCell.isItFilled()) {

            }

            if ((cellValue.get(0) <= BFValue1 && BFValue1 <= cellValue.get(0) + cellDiff1) && (cellValue.get(1) <= BFValue2 && BFValue2 <= cellValue.get(1) + cellDiff2)) {
                if (!currentCell.isItFilled()) {

                    currentCell.fillCell(individual.clone());
                } else if (individual.getFitness() > currentCell.getFittest().getFitness()) {

                    currentCell.fillCell(individual.clone());

                }

                individual = null;
                currentCell = null;
                break;
            }
        }
    }

    public MAPElitesMap getMap() {
        return map;
    }

    @Override
    public void configure(Configuration conf) {
        super.configure(conf);

        //Algorithm settings
        if (conf.containsKey("AlgorythmType")) {
            this.algorithmType = conf.getString("AlgorithmType");
        }
        if (conf.containsKey("Dimensions")) {
            this.dimensions = conf.getInt("Dimensions");
        }
        if (conf.containsKey("DimensionSize")) {
            this.dimSize = conf.getInt("DimensionSize");
        }
        if (conf.containsKey("BF1MinValue")) {
            this.BF1MinValue = conf.getInt("BF1MinValue");
        }
        if (conf.containsKey("BF1MaxValue")) {
            this.BF1MaxValue = conf.getInt("BF1MaxValue");
        }
        if (conf.containsKey("BF2MinValue")) {
            this.BF2MinValue = conf.getInt("BF2MinValue");
        }
        if (conf.containsKey("BF2MaxValue")) {
            this.BF2MaxValue = conf.getInt("BF2MaxValue");
        }

        //BF1 settings
        if (conf.containsKey("BehavioralFeature1")) {
            this.BF1 = conf.getString("BehavioralFeature1");
        }
        //BF2 settings
        if (conf.containsKey("BehavioralFeature2")) {
            this.BF2 = conf.getString("BehavioralFeature2");

        }

    }

    public boolean readLastFlag() {
        return lastFlag;
    }

    public void setLastFlag() {
        this.lastFlag = true;
    }

}
