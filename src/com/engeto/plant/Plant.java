package com.engeto.plant;

import java.time.LocalDate;

public class Plant {
    private String name;
    private String notes;
    private LocalDate plantedDate;
    private LocalDate lastWateringDate;
    private int frequencyOfWatering;

    public Plant(String name, String notes, LocalDate plantedDate, LocalDate lastWateringDate, int frequencyOfWatering) {
        this.name = name;
        this.notes = notes;
        this.plantedDate = plantedDate;
        this.lastWateringDate = lastWateringDate;
        this.frequencyOfWatering = frequencyOfWatering;
    }

    public Plant(String name, LocalDate plantedDate, int frequencyOfWatering) {
        this(name, "Prázdný řetězec", plantedDate, LocalDate.now(), frequencyOfWatering);
    }

    public Plant(String name) {
        this(name, "Prázdný řetězec", LocalDate.now(), LocalDate.now(), 7);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getPlantedDate() {
        return plantedDate;
    }

    public void setPlantedDate(LocalDate plantedDate) {
        this.plantedDate = plantedDate;
    }

    public LocalDate getLastWateringDate() {
        return lastWateringDate;
    }

    public void setLastWateringDate(LocalDate lastWateringDate) throws PlantException {
        if (lastWateringDate.isBefore(plantedDate)) {
            throw new PlantException("Chyba! datum poslední zálivky a zasazení nejsou totožné.");
        }
        this.lastWateringDate = lastWateringDate;
    }

    public int getFrequencyOfWatering() {
        return frequencyOfWatering;
    }

    public void setFrequencyOfWatering(int frequencyOfWatering) throws PlantException {
        this.frequencyOfWatering = frequencyOfWatering;
        if (frequencyOfWatering <= 0) {
            throw new PlantException("Při frekvenci zalévání nastala chyba!");
        }
    }

    public String getWateringInfo() {
        return getName()+" "+ getLastWateringDate()+" "+getFrequencyOfWatering()+" "+getNotes();
    }

    @Override
    public String toString() {
        return getName()+" "+getNotes()+" "+getPlantedDate()+" "+getLastWateringDate()+" "+getFrequencyOfWatering();
    }
}
