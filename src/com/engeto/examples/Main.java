package com.engeto.examples;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        PlantList listOfPlants = new PlantList();

//        list.importFromFile();
//        try {
//            list.importFromFile();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (PlantException e) {
//            e.printStackTrace();
//        }

//        Plant xxx = new Plant("ruze", "bila", LocalDate.of(2020, 5, 5),
//                LocalDate.of(2021, 5, 5), 7);
//        //List<Plant> Plants = new ArrayList<>();
//        PlantList listOfPlants = new PlantList();
//        listOfPlants.add(xxx);
//        listOfPlants.add(new Plant("pivonka", "cervena", LocalDate.of(2020, 5, 5),
//                LocalDate.of(2021, 5, 5), 7));
//        listOfPlants.add(new Plant("reze zelena"));
//        listOfPlants.add(new Plant("reze zelena2", LocalDate.of(2020, 12, 12), 7));
//        System.out.println(xxx.getWateringInfo());
//
//        System.out.println(listOfPlants.getAll());

        listOfPlants.importFromFile();
        System.out.println(listOfPlants.getAll());

        listOfPlants.add(new Plant("Bazalka v kuchyni", "", LocalDate.of(2021, 9, 4),
                LocalDate.of(2021, 9, 4), 3));
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println(listOfPlants.getAll());
        System.out.println("Ted Mazu");
        listOfPlants.remo(2);
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println(listOfPlants.getAll());

    }
}
