/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import es.udc.gii.common.eaf.algorithm.EvolutionaryAlgorithm;
import es.udc.gii.common.eaf.facade.EAFFacade;
import es.udc.gii.common.eaf.stoptest.StopTest;
import es.udc.gii.common.eaf.util.EAFRandom;

/**
 *
 * @author balaz
 */
public class GA {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        EvolutionaryAlgorithm algorithm;
        StopTest stopTest;
        EAFFacade facade = new EAFFacade();
        System.out.println("Done");
        EAFRandom.init();
        System.out.println("Facade initialized.");
        algorithm = facade.createAlgorithm("C:/Users/balaz/Desktop/conf/GA.xml");
 //   algorithm = facade.createAlgorithm("C:/Users/balaz/Desktop/MAP-Elites-for-modular-robots/MAP-Elites/conf/de_GAWithMAP.xml");
        System.out.println("Algorithm created");
        stopTest = facade.createStopTest("C:/Users/balaz/Desktop/conf/GA.xml");
  //  stopTest = facade.createStopTest("C:/Users/balaz/Desktop/MAP-Elites-for-modular-robots/MAP-Elites/conf/de_GAWithMAP.xml"); 
        facade.resolve(stopTest, algorithm);
        System.out.println("Resolved");
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Execution time: " + executionTime + " milliseconds");

    }
}
