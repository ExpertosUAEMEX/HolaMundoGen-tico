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
package Subprocess;

import Genetic.Genetic;
import javax.swing.JTextArea;


/**
 *
 * @author cachubis
 */
public class Subprocess implements Runnable {
    private String givenStrng;
    private int population;
    private String result="";
    private JTextArea ta;
    public String getResult(){
        return result;
    }
    public Subprocess(String givenString,int population, JTextArea ta){
        this.givenStrng=givenString;
        this.ta=ta;
        this.population=population;
    }
    @Override
    public void run() {
        Genetic g = new Genetic(givenStrng.length(),population,givenStrng,ta);
        g.start();
        this.result=g.getRes();
        ta.append("Resultado de subproceso: "+this.result+"\n");
        ta.repaint();
    }
    
}
