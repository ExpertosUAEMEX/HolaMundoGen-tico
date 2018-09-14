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
package GeneticOperations;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author cachubis
 */
public class GOperators {

    private static Random r = new Random(System.currentTimeMillis());

    public static String cruising(String s1, String s2) {
        int f = 0;
        String s = "";
        
        for (int i = 0; i < s1.length(); i += 2) {
            if(s1.length()%2==0){
                if (f == 1) {
                    s += s2.substring(i, i + 2);
                    f = 0;
                } else if (f == 0) {
                    s += s1.substring(i, i + 2);
                    f = 1;
                }
            }else{

                if (i == s1.length() - 1) {
                    s += s1.charAt(i);
                } else if (f == 1) {
                    s += s2.substring(i, i + 2);
                    f = 0;
                } else if (f == 0) {
                    s += s1.substring(i, i + 2);
                    f = 1;
                }
            }
        }

        return s;
    }

    public static String mutate(String s) {
        s = s.replace(s.charAt(r.nextInt(s.length())), (char) ThreadLocalRandom.current().nextInt(97, 122));
        return s;
    }
}
