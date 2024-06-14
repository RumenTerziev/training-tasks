package org.example.hacker.house;

import java.util.List;
import java.util.Scanner;

import static org.example.hacker.util.IOUtils.getListFromInput;

public class HouseInputUtils {

    static HouseInput getHouseInput() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> houseCoords = getListFromInput(scanner);
        List<Integer> treesCoords = getListFromInput(scanner);
        List<Integer> fruitCounts = getListFromInput(scanner);
        List<Integer> appleDistancesOfFalling = getListFromInput(scanner);
        List<Integer> orangeDistancesOfFalling = getListFromInput(scanner);

        return new HouseInput(
                houseCoords.get(0),
                houseCoords.get(1),
                treesCoords.get(0),
                treesCoords.get(1),
                fruitCounts.get(0),
                fruitCounts.get(1),
                appleDistancesOfFalling,
                orangeDistancesOfFalling
        );
    }
}
