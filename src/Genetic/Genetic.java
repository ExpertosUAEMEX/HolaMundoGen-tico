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
package Genetic;


import Chromosomes.StringChromosome;
import FitnesFunction.FitnessFunction;
import GeneticOperations.GOperators;
import Subprocess.Subprocess;
import Utils.LevenshteinDistance;
import Utils.Sort;
import Utils.Utils;
import java.awt.TextArea;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JTextArea;
/**
 *
 * @author cachubis
 */
public class Genetic implements FitnessFunction {
    private int numGene; 
    private int numChromosomes;
    private ArrayList<StringChromosome> c ;
    private String objective;
    private String res="";
    private JTextArea ta;
    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }
    public Genetic(int numGene,int numChromosomes, Object obj,JTextArea ta){
        this.ta=ta;
        this.numChromosomes=numChromosomes;
        this.numGene=numGene;
        population();//genera la población
        objective=(String) obj;//inicializa el string objetivo
    }
    public void population(){
        c = new ArrayList<>();
        for(int i=0; i<numChromosomes;i++){
            c.add(new StringChromosome(numGene));
            //System.out.println(c.get(i).getChromosome());       
        }
    }
    public void start(){
        
        boolean flag=true;
        int f =0;
        while(flag){
            for (StringChromosome sc: c){
                    sc.setFitness(MaxFunction(sc.getChromosome(),objective));
            }
            Collections.sort(c,new Sort());
            if (c.get(0).getFitness()==0){
              res=c.get(0).getChromosome();
              ta.append("\n\n\n\t\t***** Chromosoma encontrado en la generación: "+f+"*****\n");
              ta.append("\t\tChomosoma: "+c.get(0).getChromosome()+" Fitness: "+c.get(0).getFitness()+"\n");
              flag=false;
            }else{
                ta.append("\t\t****** Generación: "+f+" ******\n");
                ta.repaint();
                for(StringChromosome sc : c){
                    ta.append("Chromosoma: "+sc.getChromosome()+" | Fitness: "+sc.getFitness()+"\n");
                    ta.repaint();
                }
                //"CRUZA";
                int j=0;
                for(int i=(int)(Math.floor(c.size()/2));i<c.size();i++){
                    c.get(i).setChromosome(GOperators.cruising(c.get(j).getChromosome(),c.get(j+1).getChromosome()));
                    j++;
                }

                //"MUTACION"
                for(int i=0;i<c.size()*0.5;i++){
                    c.get(i).setChromosome(GOperators.mutate(c.get(i).getChromosome()));
                }
                f++;
            }
        }
    }
    
    public int MaxFunction(Object guy, Object guyObj) {
        String s1 = (String)guy;
        String s2 = (String)guyObj;
        return LevenshteinDistance.computeLevenshteinDistance(s1, s2);
    }
}
