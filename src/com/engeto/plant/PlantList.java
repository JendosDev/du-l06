package com.engeto.plant;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlantList {
    private final List<Plant> dataList = new ArrayList<>();
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
        } catch (IllegalArgumentException e) {
            throw new PlantException("Špatně zadaná položka na řádku "+lineNumber+": "+plants[1]+"\nŘádek: "+line+"\n\""+e.getLocalizedMessage()+"\"");
        }
    }

    public void fileWriter(String filename, String delimiter) throws PlantException {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)))) {
            for (Plant plant : dataList) {
                String rec =
                        plant.getName()+delimiter
                        +plant.getNotes()+delimiter
                        +plant.getFrequencyOfWatering()+delimiter
                        +plant.getPlantedDate()+delimiter
                        +plant.getLastWateringDate();
                writer.println(rec);
            }
        } catch (IOException e) {
            throw new PlantException("Došlo k chybě při zápisu do souboru "+filename+": "+e.getLocalizedMessage());
        }
    }

    public void add(Plant plant) {
        dataList.add(plant);
    }

    public List<Plant> getList() {
        return new ArrayList<>(dataList);
    }
}
