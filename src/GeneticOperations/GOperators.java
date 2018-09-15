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
    /*Diccionario en ASCII*/
    public static final int[] dict = {
        32, 48, 49, 50, 51, 52, 53, 54, 55,
        56, 57, 65, 66, 67, 68, 69,
        70, 71, 72, 73, 74, 75, 76,
        77, 78, 79, 80, 81, 82, 83, 84,
        85, 86, 87, 88, 89, 90, 97, 98, 99,
        100, 101, 102, 103, 104, 105, 106,
        107, 108, 109, 110, 111, 112, 113,
        114, 115, 116, 117, 118, 119, 120,
        121, 122

    };

    public static String cruising(String s1, String s2) {
        int f = 0;
        String s = "";

        for (int i = 0; i < s1.length(); i += 2) {
            if (s1.length() % 2 == 0) {
                if (f == 1) {
                    s += s2.substring(i, i + 2);
                    f = 0;
                } else if (f == 0) {
                    s += s1.substring(i, i + 2);
                    f = 1;
                }
            } else {

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
        s = s.replace(s.charAt(r.nextInt(s.length())), (char) dict[ThreadLocalRandom.current().nextInt(dict.length)]);
        return s;
    }
}
