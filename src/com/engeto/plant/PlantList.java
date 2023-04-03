package com.engeto.plant;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlantList {
    private List<Plant> dataList = new ArrayList<>();
    public void addAllFromFile(String filename) throws PlantException {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] items = line.split("   ");
                Plant plant = new Plant(items[0], items[1], LocalDate.parse(items[3]), LocalDate.parse(items[4]), items[2].indexOf(2));
                dataList.add(plant);
            }
        } catch (FileNotFoundException e) {
            throw new PlantException("Nepodačilo se nalézt soubor: " + filename + "!\n\"" + e.getLocalizedMessage()+"\"");
        }
    }

    public void add(Plant plant) {
        dataList.add(plant);
    }

    public void clear() {
        dataList.clear();
    }

    // kopije datalistu
    public List<Plant> getList() {
        return new ArrayList<>(dataList);
    }
}
