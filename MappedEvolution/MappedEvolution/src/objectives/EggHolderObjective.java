/*
 * Copyright (C) 2010 Grupo Integrado de Ingeniería
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
/*
 * SchwefelsProblemObjectiveFunction.java
 *
 * Created on 4 de julio de 2007, 19:35
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package objectives;


import es.udc.gii.common.eaf.problem.objective.ObjectiveFunction;
import java.util.ArrayList;
import java.util.List;


public class EggHolderObjective extends ObjectiveFunction {
    
    public static final int OBJECTIVE_FUNCTION = 0;


    @Override
    public List<Double> evaluate(double[] values) {

        double fitness = 0.0;

        for (int i = 0; i < values.length; i++) {
            values[i] = desnormalize(values[i]);
        }

        for (int i = 0; i < values.length - 1; i++) {
            fitness += (-(values[i + 1] + 47.0) * Math.sin(Math.sqrt(Math.abs(values[i + 1] + values[i] * 0.5 + 47.0)))
                    - values[i] * Math.sin(Math.sqrt(Math.abs(values[i] - (values[i + 1] + 47.0)))));
        }

        fitness -= (values.length == 2 ? -959.6406627106155 : -8247.22733990241795254);
        
        List<Double> objectives = new ArrayList<Double>();

        objectives.add(OBJECTIVE_FUNCTION, fitness);

        return objectives;

    }

    private double desnormalize(double value) {

        double new_value;

        new_value = value * 512.0;

        return new_value;

    }

    @Override
    public void reset() {
    }

  
}
