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
package ElitesMap;

import es.udc.gii.common.eaf.algorithm.*;

import cells.MapElitesCell;
import es.udc.gii.common.eaf.algorithm.population.Individual;
import java.util.*;
import es.udc.gii.common.eaf.algorithm.population.Population;

/**
 *
 * @author balaz
 */
public class MAPElitesMap {

    private int dimensions;
    private int dimSize;
    private List<MapElitesCell> map;
    private List<MapElitesCell> filledMap;
    private List<Individual> individuals;
    private double BF1MinValue;
    private double BF1MaxValue;
    private double BF2MinValue;
    private double BF2MaxValue;
    private Population batch;

    public MAPElitesMap(int dimensions, int dimSize, double BF1MinValue, double BF1MaxValue, double BF2MinValue, double BF2MaxValue) {
        this.dimensions = dimensions;
        this.dimSize = dimSize;
        this.BF1MinValue = BF1MinValue;
        this.BF1MaxValue = BF1MaxValue;
        this.BF2MinValue = BF2MinValue;
        this.BF2MaxValue = BF2MaxValue;
        this.map = new ArrayList<MapElitesCell>();
        this.filledMap = new ArrayList<MapElitesCell>();
        this.individuals = new ArrayList<Individual>();
        fillMap();
        
    }

    public void fillMap() {

        //ArrayList<Integer> location = new ArrayList<Integer>();
        for (int i = 0; i < dimSize; i++) {
            for (int j = 0; j < dimSize; j++) {
                ArrayList<Integer> location = new ArrayList<Integer>();
                switch (dimensions) {
    
                    case 1:
                            location.add(i);
                            break;
                    case 2:
                            location.add(i);
                            location.add(j);
                            break;
                }

                    MapElitesCell cell = new MapElitesCell(location);
                    map.add(cell);
                    evaluateCell(cell);

                

            }

        }

    }

    public void fillFilledMap(List<MapElitesCell> map) {
        filledMap.clear();
        individuals.clear();

        for (MapElitesCell cell : map) {
            if (cell.isItFilled()) {
                filledMap.add(cell);
                individuals.add(cell.getFittest().clone());
            }
        }

    }

    private ArrayList evaluateCell(MapElitesCell cell) {
        ArrayList<Double> cellValue = new ArrayList<>();
        for (int i = 0; i < dimensions; i++) {
            if (i == 0){
            cellValue.add((BF1MaxValue - BF1MinValue) / dimSize * cell.getLocation().get(i));
            }else{
                cellValue.add((BF2MaxValue - BF2MinValue) / dimSize * cell.getLocation().get(i));
            }
            cell.setCellValue(cellValue);

        }
        return cellValue;
    }

    public List<MapElitesCell> getMap() {
        return map;
    }

    public List<MapElitesCell> getFilledMap() {
        return filledMap;
    }

    public List<Individual> getIndividuals() {
        return individuals;

    }
    
    public Population getBatch() {
        batch.addIndividuals(individuals);
        return batch;

    }

}
