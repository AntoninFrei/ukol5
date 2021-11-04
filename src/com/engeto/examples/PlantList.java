package com.engeto.examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    public void importFromFile() {
        // Vymaže dosavadní položky:
        Plants.clear();
        // Načte ze souboru nové položky:
        try (Scanner scanner = new Scanner(new File("kvetiny.txt"))) {
            int lineNumber = 0;
            while (scanner.hasNextLine()) {
                lineNumber++;
                String nextLine = scanner.nextLine();
                String[] items = nextLine.split("\t");
                if (items.length != 5) {
                    System.out.println("Je to blbe");
                    throw new PlantException("Nesprávný počet položek na řádku číslo: " + lineNumber + ": " + nextLine);
                }

                System.out.println(nextLine);

                System.out.println(items[4]);
                DateTimeFormatter pattern = DateTimeFormatter.ISO_LOCAL_DATE;
                LocalDate planted = LocalDate.parse(items[3], pattern);
                LocalDate watering = LocalDate.parse(items[4], pattern);
                System.out.println(planted+"\n");
                int frequencyOfWatering = Integer.parseInt(items[2]);

                Plant xxx = new Plant(items[0], items[1], planted,
                  watering, frequencyOfWatering);
                Plants.add(xxx);
            }

        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (PlantException e) {
            e.printStackTrace();
        }



    }
}
