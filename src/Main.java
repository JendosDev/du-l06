import com.engeto.plant.Plant;
import com.engeto.plant.PlantException;
import com.engeto.plant.PlantList;
import com.engeto.settings.Settings;

import javax.xml.crypto.KeySelector;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {

    public static void main(String[] args) throws PlantException {
        List<Plant> plantList = new ArrayList<>();
        Set<LocalDate> plantedDate = new HashSet<>();

        Plant nephrolepis = new Plant("Nephrolepis", "Je to kapradina a je náročná na zálivku", LocalDate.of(2020, 8, 23), LocalDate.of(2023, 3, 30), 3);
        Plant marantha = new Plant("Marantha", "Krásná rostlina, která je příbuzná s kalateou", LocalDate.of(2017, 9, 14), LocalDate.of(2023 , 4, 1), 4);

        plantList.add(nephrolepis);
        plantList.add(marantha);

        // Řazení rostlin podle názvu
        plantList.sort(null);
        for (Plant plant : plantList) {
            System.out.println(plant.getName());
        }

        plantList.sort((p1, p2) -> p1.getLastWateringDate().compareTo(p2.getLastWateringDate()));
        for (Plant plant : plantList) {
            System.out.println(plant.getName() + " " + plant.getLastWateringDate());
        }

        // Analýza dnů, kdy byla rostlina zasazena
        for (Plant plant : plantList) {
            if (ChronoUnit.DAYS.between(plant.getLastWateringDate(), LocalDate.now()) <= 30) {
                plantedDate.add(plant.getLastWateringDate());
            }
        }
        for (LocalDate date : plantedDate) {
            System.out.println(date);
        }
    }
    public static void mainFile(String[] args) {
        PlantList list = new PlantList();
        try {
            list.addAllFromFile(Settings.getFilename());
        } catch (PlantException e) {
            System.err.println(e.getLocalizedMessage());
        }
        System.out.println(list.getList());

    }
}