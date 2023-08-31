package objectives;

import es.udc.gii.common.eaf.problem.objective.ObjectiveFunction;
import java.util.ArrayList;
import java.util.List;


public class BaeleObjective extends ObjectiveFunction {

    public static final int OBJECTIVE_FUNCTION = 0;

    @Override
    public List<Double> evaluate(double[] values) {

        double fitness = Double.MAX_VALUE;
        double x1, x2;

        //x ~ [-4.5, 4.5]
        x1 = values[0] * 4.5;
        x2 = values[1] * 4.5;

        fitness = (1.5 - x1 * (1.0 - x2)) * (1.5 - x1 * (1.0 - x2)) + (2.25 - x1 * (1 - x2 * x2)) * (2.25 - x1 * (1 - x2 * x2)) + (2.625 - x1 * (1.0 - x2 * x2 * x2)) * (2.625 - x1 * (1.0 - x2 * x2 * x2));

        List<Double> objectives = new ArrayList<Double>();

        objectives.add(OBJECTIVE_FUNCTION, fitness);

        return objectives;

    }

    @Override
    public void reset() {

    }

}
