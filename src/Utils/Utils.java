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

import java.util.ArrayList;

/**
 *
 * @author cachubis
 */
public class Utils {
    /*
        Separa un String en subcadenas de tamaño máximo = 9
    */
    public static ArrayList<String> splitString(String s){
        ArrayList<String> splitStrn = new ArrayList<>();
        for (int i=0;i<s.length();i+=9){
            if((s.length()-i-1)>9)
                splitStrn.add(s.substring(i, i+9));
            else{
                splitStrn.add(s.substring(i,s.length()));
            }
        }
        return splitStrn;
    }
    /*public static void main(String[] args) {
        ArrayList<String>lst=Utils.splitString("holamundosoydanielpapu");
        for(String s : lst){
            System.out.println(s);
        }
    }*/
}
