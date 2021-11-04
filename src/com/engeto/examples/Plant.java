package com.engeto.examples;

import java.time.LocalDate;

public class Plant {
    private String name;
    private String note;
    private LocalDate planted;
    private LocalDate watering;
    private  int frequencyOfWatering;

    public Plant(String name, String note, LocalDate planted, LocalDate watering, int frequencyOfWatering) {
        this.name = name;
        this.note = note;
        this.planted = planted;
        this.watering = watering;
        this.frequencyOfWatering = frequencyOfWatering;

    }

    public Plant(String name, LocalDate planted, int frequencyOfWatering) {
        this.name = name;
        this.note = "";
        this.planted = planted;
        this.watering = LocalDate.now();
        this.frequencyOfWatering = frequencyOfWatering;

    }

    public Plant(String name) {
        this.name = name;
        this.note = "";
        this.planted = LocalDate.now();
        this.watering = LocalDate.now();
        this.frequencyOfWatering = 7;

    }



    public void setName(String name) {
        this.name = name;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    public void setWatering(LocalDate watering) {
        this.watering = watering;
    }

    public void setFrequencyOfWatering(int frequencyOfWatering) {
        this.frequencyOfWatering = frequencyOfWatering;
    }

    public String getName() {
        return name;
    }

    public String getNote() {
        return note;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public LocalDate getWatering() {
        return watering;
    }

    public int getFrequencyOfWatering() {
        return frequencyOfWatering;
    }

    public String getWateringInfo()  {
        String out = "Jméno rostliny:\t\t\t" + this.name;
        out += "\nPoslední zálivka:\t\t" + this.watering;
        out += "\nPříští zálivka:\t\t\t" + this.watering.plusDays(this.frequencyOfWatering);
        return out;
    }

}
