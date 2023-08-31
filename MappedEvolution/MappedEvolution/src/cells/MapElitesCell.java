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
package cells;

import java.util.ArrayList;
import individual.MEIndividual;

/**
 *
 * @author balaz
 */
public class MapElitesCell {

    private ArrayList<Integer> location;
    private ArrayList<Double> cellValue;
    private MEIndividual fittest;
    private boolean isFilled;

    public MapElitesCell(ArrayList<Integer> location) {
        //this.location = new ArrayList<Integer>();
        this.location = new ArrayList(location);
        this.isFilled = false;
        this.fittest = null;
        //this.cellValue = new double[2];
    }
    
    public void setCellValue(ArrayList<Double> cellValue){
        this.cellValue = new ArrayList(cellValue);
    }
    public ArrayList<Double> getCellValue(){
        return this.cellValue;
    }

    public ArrayList<Integer> getLocation() {
        return location;
    }

    public MEIndividual getFittest() {
        return fittest;
    }


    public void fillCell(MEIndividual individual) {
        
        this.fittest = individual.clone();
    }

    public boolean isItFilled() {
        return fittest != null;
    }

}
