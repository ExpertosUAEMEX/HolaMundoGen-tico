/*
 * Copyright (C) 2018 cachubis
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
package Utils;

import Chromosomes.StringChromosome;
import java.util.Comparator;

/**
 *
 * @author cachubis
 */
public class Sort implements Comparator<StringChromosome>{

    @Override
    public int compare(StringChromosome o1, StringChromosome o2) {
        int resp =0;
        if (o1.getFitness()>o2.getFitness())
            resp=1;
        else if (o1.getFitness()<o2.getFitness())
            resp= -1;
        return resp;
    }

    
    }
