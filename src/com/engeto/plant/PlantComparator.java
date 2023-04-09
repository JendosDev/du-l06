package com.engeto.plant;

import java.util.Comparator;

public class PlantComparator implements Comparator<Plant> {
    @Override
    public int compare(Plant o1, Plant o2) {
        return o1.getLastWateringDate().compareTo(o2.getLastWateringDate());
    }
}
