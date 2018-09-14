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
import Utils.LevenshteinDistance;
import Utils.Sort;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JTextArea;
/**
 *
 * @author cachubis
 */
public class Genetic implements FitnessFunction {
    int numGene;
    int numChromosomes;
    ArrayList<StringChromosome> c ;
    String objective;
    public Genetic(int numGene,int numChromosomes, Object obj){
        this.numChromosomes=numChromosomes;
        this.numGene=numGene;
        population();
        objective=(String) obj;
    }
    public void population(){
        c = new ArrayList<>();
        for(int i=0; i<numChromosomes;i++){
            c.add(new StringChromosome(numGene));
            //System.out.println(c.get(i).getChromosome());       
        }
    }
    public void start(JTextArea ta){
        
        boolean flag=true;
        int f =0;
        while(flag){
            for (StringChromosome sc: c){
                    sc.setFitness(MaxFunction(sc.getChromosome(),objective));
            }
            Collections.sort(c,new Sort());
            if (c.get(0).getFitness()==0){
              ta.append("\t**** Chromosoma encontrado en la generación: "+f+" ****\n");
              ta.append("\t**** Fitness:  "+c.get(0).getFitness()+"\tChromosome: "+c.get(0).getChromosome()+" ****\n");
              ta.repaint();
              flag=false;
            }else{
                
                ta.append("******************** Generación "+f+" ******************** \n");
                //System.out.printf("******************** Generación %d ******************** \n",f);
                for(StringChromosome sc : c){
                  //  System.out.printf("Fitness: %d Chromosome: %s \n",sc.getFitness(),sc.getChromosome());
                    ta.append("Fitness: "+sc.getFitness()+"   Chromosome: "+sc.getChromosome()+"\n");
                    ta.repaint();
                }

                //"CRUZA";
                int j=0;
                for(int i=(int)(Math.floor(c.size()/2));i<c.size();i++){

                    c.get(i).setChromosome(GOperators.cruising(c.get(j).getChromosome(),c.get(j+1).getChromosome()));
                    j++;
                    //System.out.printf("Chromosome: %s \n",c.get(i).getChromosome());
                }

                //"MUTACION"
                for(int i=0;i<c.size()*0.3;i++){
                    c.get(i).setChromosome(GOperators.mutate(c.get(i).getChromosome()));
                }
                f++;
            }
            
            
        }
    }
    
  /*  public static void main(String[] args) {
        String s ="hellowworld";
        int population=200;
        Genetic g = new Genetic(s.length(),population,s);
        g.start();
    }*/

    @Override
    public int MaxFunction(Object guy, Object guyObj) {
        String s1 = (String)guy;
        String s2 = (String)guyObj;
        return LevenshteinDistance.computeLevenshteinDistance(s1, s2);
    }

    
    
}
