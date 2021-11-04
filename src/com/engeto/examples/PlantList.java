package com.engeto.examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class PlantList {
    private List<Plant> Plants = new ArrayList<>();


    public void add(Plant plant) {
        Plants.add(plant);
    }

    public void remo(int index) {
        Plants.remove(index);
    }

    public String getAll()  {
        String out = "";
        for (Plant item : Plants) out += item.getWateringInfo() + "\n-----------------------\n";
        return out;
    }
    public void importFromFile(String fileName) {
        // Vymaže dosavadní položky:
        Plants.clear();
        // Načte ze souboru nové položky:
        try (Scanner scanner = new Scanner(new File(fileName))) {
            int lineNumber = 0;
            while (scanner.hasNextLine()) {
                lineNumber++;
                String nextLine = scanner.nextLine();
                String[] items = nextLine.split("\t");
                if (items.length != 5) {
                    throw new PlantException("Nesprávný počet položek na řádku číslo: " + lineNumber + ": " + nextLine);
                }

                DateTimeFormatter pattern = DateTimeFormatter.ISO_LOCAL_DATE;
                LocalDate watering;
                LocalDate planted;
                try {
                    watering = LocalDate.parse(items[3], pattern);
                    planted = LocalDate.parse(items[4], pattern);
                } catch (DateTimeParseException ex) {
                    throw new PlantException("Nesprávný formát datumu:  na řádku číslo: "
                            +lineNumber+": "+nextLine+"!");

                }
                if (watering.isBefore(planted)) {
                    throw new PlantException("Chyba na řádku číslo: " + lineNumber + ": " + nextLine
                            + ".\n Datum zálivky je starší než datum zasazení.!");
                }
                int frequencyOfWatering = 0;
                try {
                    frequencyOfWatering = Integer.parseInt(items[2]);
                } catch (NumberFormatException ex) {
                    throw new PlantException("Nesprávný formát frekvence zálivek:  na řádku číslo: "
                            +lineNumber+": "+nextLine+"!");
                }



                if (frequencyOfWatering <= 0) {

                    throw new PlantException("Chyba na řádku číslo: " + lineNumber + ": " + nextLine
                            + ".\n Frekvence zálivky musí být větší než nula!");
                }

                Plants.add(new Plant(items[0], items[1], planted,
                  watering, frequencyOfWatering));
            }

        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (PlantException e) {
            e.printStackTrace();
        }



    }


    /**
     * Zapíše obsah seznamu do výstupního souboru.
     */
    public void exportToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new File(fileName))) {
            for (Plant plant : Plants) {
                String outputLine =
                        plant.getName() + "\t" + plant.getNote() + "\t" + plant.getFrequencyOfWatering() + "\t"
                        + plant.getWatering() + "\t" + plant.getPlanted();
                writer.println(outputLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
