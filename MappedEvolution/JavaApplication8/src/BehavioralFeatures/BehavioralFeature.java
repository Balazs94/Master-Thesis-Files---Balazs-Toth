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
package BehavioralFeatures;

import es.udc.gii.common.eaf.algorithm.population.Population;
import es.udc.gii.common.eaf.config.Configurable;
import individual.MEIndividual;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.configuration.Configuration;

/**
 *
 * @author balaz
 */
public abstract class BehavioralFeature implements Configurable, Serializable {
    
    
    
    
    public void evaluateBehavioralFeatures (Population population) {
    
    }
    
}
