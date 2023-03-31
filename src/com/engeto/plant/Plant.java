package com.engeto.plant;

import java.time.LocalDate;

public class Plant {
    private String name;
    private String notes;
    private LocalDate plantedDate;
    private LocalDate LastWateringDate;
    private int frequencyOfWatering;

    public Plant(String name, String notes, LocalDate plantedDate, LocalDate wateringDate, int frequencyOfWatering) {
        this.name = name;
        this.notes = notes;
        this.plantedDate = plantedDate;
        this.LastWateringDate = wateringDate;
        this.frequencyOfWatering = frequencyOfWatering;
    }

    public Plant(String notes, LocalDate wateringDate) {
        this.notes = "Prázdný řetězec";
        this.LastWateringDate = LocalDate.now();
    }

    public Plant(String notes, LocalDate wateringDate, int frequencyOfWatering) {
        this.notes = "Prázdný řetězec";
        this.plantedDate = LocalDate.now();
        this.LastWateringDate = LocalDate.now();
        this.frequencyOfWatering = 7;
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
        return LastWateringDate;
    }

    public void setLastWateringDate(LocalDate lastWateringDate) throws PlantException {
        this.LastWateringDate = lastWateringDate;
        if (LastWateringDate == plantedDate);
        else {
            throw new PlantException("Chyba! datum poslední zálivky a zasazení nejsou totožné");
        }
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
}
