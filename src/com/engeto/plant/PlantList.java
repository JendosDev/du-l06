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
        long lineNumber = 0;
        String[] plants = new String[0];
        String line = "";
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {
            while (scanner.hasNextLine()) {
                lineNumber++;
                line = scanner.nextLine();
                plants = line.split("\t");
                if (plants.length != 5) throw new PlantException("Špatný počet položek na řádku číslo "+lineNumber);
                Plant plant = new Plant(plants[0], plants[1], LocalDate.parse(plants[3]), LocalDate.parse(plants[4]), Integer.parseInt(plants[2]));
                dataList.add(plant);
            }
        } catch (FileNotFoundException e) {
            throw new PlantException("Nepodařilo se nalézt soubor: " + filename + "!\n\"" + e.getLocalizedMessage()+"\"");
        } catch (NumberFormatException e) {
            throw new PlantException("Špatně zadané číslo na řádku "+lineNumber+": "+plants[1]+"\nŘádek: "+line+"\n\""+e.getLocalizedMessage()+"\"");
        }
    }

    public void add(Plant plant) {
        dataList.add(plant);
    }

    public List<Plant> getList() {
        return new ArrayList<>(dataList);
    }
}
