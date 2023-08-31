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
package objectives;

import es.udc.gii.common.eaf.problem.objective.ObjectiveFunction;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author balaz
 */
public class CubeObjective extends ObjectiveFunction {

    public static final int OBJECTIVE_FUNCTION = 0;

    @Override
    public List<Double> evaluate(double[] values) {

        double fitness = 0.0;
        double sideA = 0.0;
        double sideB = 0.0;
        double sideC = 0.0;
        List<Double> objectives = new ArrayList<Double>();

        sideA = (values[0] + 1) / 2 * 10.0;
        sideB = (values[1] + 1) / 2 * 10.0;
        sideC = (values[2] + 1) / 2 * 10.0;

        fitness = sideA * sideB * sideC;

        //for (int i = 0; i < values.length; i++) {
        //    fitness = (fitness * (values[i]+1) / 2 * 10.0);
        // }
        if (fitness > 500) {
            fitness = 500 - (fitness - 500);
        }

        objectives.add(OBJECTIVE_FUNCTION, fitness);

        return objectives;

    }

    @Override
    public void reset() {
    }

}
