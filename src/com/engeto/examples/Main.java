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
        try {
            listOfPlants.importFromFile("kvetiny.txt");
        }
        catch (PlantException e) {
            e.printStackTrace();

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        System.out.println("\nNacteno ze souboru: " + fileName + "\n");
        System.out.println(listOfPlants.getAll());
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

        listOfPlants.add(new Plant("Bazalka v kuchyni", "", LocalDate.of(2021, 9, 4),
                LocalDate.of(2021, 9, 4), 3));
        listOfPlants.add(new Plant("Růře červená"));


        listOfPlants.remo(2);
        System.out.println("\nPo upravach:\n");
        System.out.println(listOfPlants.getAll());
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");


        fileName = "vystup.txt";
        listOfPlants.exportToFile(fileName);

        try {
            listOfPlants.importFromFile(fileName);
        }
        catch (PlantException e) {
            e.printStackTrace();

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("\nZnovu načteno ze souboru: " + fileName + "\n");
        System.out.println(listOfPlants.getAll());
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

        System.out.println("\nTestovací načtení souborů s chybami\n");
        try {
            listOfPlants.importFromFile("kvetiny-spatne-datum.txt.");
        }
        catch (PlantException e) {
            e.printStackTrace();

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            listOfPlants.importFromFile("kvetiny-spatne-frekvence.txt");
        }
        catch (PlantException e) {
            e.printStackTrace();

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }
}
