/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objectives;

import es.udc.gii.common.eaf.problem.objective.ObjectiveFunction;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author balaz
 */
public class EggH extends ObjectiveFunction {

    public static final int OBJECTIVE_FUNCTION = 0;

    @Override
    public List<Double> evaluate(double[] values) {

        double fitness = Double.MAX_VALUE;
        double x1, x2;

        x1 = values[0] * 512;
        x2 = values[1] * 512;

        fitness =  (-(values[1] + 47.0) * Math.sin(Math.sqrt(Math.abs(values[1] + values[0] * 0.5 + 47.0)))
                    - values[0] * Math.sin(Math.sqrt(Math.abs(values[0] - (values[1] + 47.0)))));

        List<Double> objectives = new ArrayList<Double>();

        objectives.add(OBJECTIVE_FUNCTION, fitness);

        return objectives;

    }

    @Override
    public void reset() {

    }

}