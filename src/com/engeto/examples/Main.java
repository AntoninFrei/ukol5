package com.engeto.examples;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        PlantList listOfPlants = new PlantList();

        String fileName = "kvetiny.txt";
        listOfPlants.importFromFile("kvetiny.txt");
        System.out.println("\nNacteno ze souboru: " + fileName + "\n");
        System.out.println(listOfPlants.getAll());
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

        listOfPlants.add(new Plant("Bazalka v kuchyni", "", LocalDate.of(2021, 9, 4),
                LocalDate.of(2021, 9, 4), 3));
        listOfPlants.add(new Plant("Růře červená"));


       // System.out.println(listOfPlants.getAll());
        //System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        listOfPlants.remo(2);
        System.out.println("\nPo upravach:\n");
        System.out.println(listOfPlants.getAll());
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");


        fileName = "vystup.txt";
        listOfPlants.exportToFile(fileName);

        listOfPlants.importFromFile(fileName);
        System.out.println("\nZnovu načteno ze souboru: " + fileName + "\n");
        System.out.println(listOfPlants.getAll());
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");



    }
}
