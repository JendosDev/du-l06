import com.engeto.plant.Plant;
import com.engeto.plant.PlantException;
import com.engeto.plant.PlantList;
import com.engeto.plant.Settings;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        PlantList list = new PlantList();
        try {
            list.addAllFromFile(Settings.getFilename());
        } catch (PlantException e) {
            System.err.println(e.getLocalizedMessage());
        }
        System.out.println(list.getList());

    }

    public static void mainObjects(String[] args) {

        Plant nephrolepis = new Plant("Nephrolepis", "Je to kapradina a je náročná na zálivku", LocalDate.of(2020, 8, 23), LocalDate.of(2023, 3, 30), 3);
        Plant marantha = new Plant("Marantha", "Krásná rostlina, která je příbuzná s kalateou", LocalDate.of(2017, 9, 14), LocalDate.of(2023, 4, 1), 4);

        System.out.println(nephrolepis);
        System.out.println(marantha);
    }
}