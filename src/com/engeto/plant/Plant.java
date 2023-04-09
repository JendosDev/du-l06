package com.engeto.plant;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

public class Plant implements Comparable<Plant> {
    private String name;
    private String notes;
    private LocalDate plantedDate;
    private LocalDate lastWateringDate;
    private int frequencyOfWatering;

    public Plant(String name, String notes, LocalDate plantedDate, LocalDate lastWateringDate, int frequencyOfWatering) throws PlantException {
        this.name = name;
        this.notes = notes;
        this.plantedDate = plantedDate;
        this.lastWateringDate = lastWateringDate;
        this.frequencyOfWatering = frequencyOfWatering;
        setFrequencyOfWatering(frequencyOfWatering);

    }

    public Plant(String name, LocalDate plantedDate, int frequencyOfWatering) throws PlantException {
        this(name, "Prázdný řetězec", plantedDate, LocalDate.now(), frequencyOfWatering);
    }

    public Plant(String name) throws PlantException {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plant plant = (Plant) o;
        return getFrequencyOfWatering() == plant.getFrequencyOfWatering() && Objects.equals(getName(), plant.getName()) && Objects.equals(getNotes(), plant.getNotes()) && Objects.equals(getPlantedDate(), plant.getPlantedDate()) && Objects.equals(getLastWateringDate(), plant.getLastWateringDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public int compareTo(Plant o) {
        return getName().compareTo(o.getName());

    }
}
