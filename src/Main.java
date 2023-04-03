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

        Plant fialka1 = new Plant("Fialka", "je fialová a hezká", LocalDate.of(2021, 5, 12), LocalDate.of(2021, 1, 1), 3);
        Plant vanocnihvezda = new Plant("Vánoční hvězda", "", LocalDate.of(2021, 5, 10), LocalDate.of(2021, 4, 1), 4);
        Plant sukulent = new Plant("Sukulent", "v koupelně se nezalévá", LocalDate.of(2011, 3, 1), LocalDate.of(2011, 3, 1), 365);

        System.out.println(fialka1);
        System.out.println(sukulent);
    }
}