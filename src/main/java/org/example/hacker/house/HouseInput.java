package org.example.hacker.house;

import java.util.List;

public record HouseInput(
        int houseStartingPoint,
        int houseEndingPoint,
        int appleTreePosition,
        int orangeTreePosition,
        int applesCount,
        int orangesCount,
        List<Integer> appleFallingDistances,
        List<Integer> orangeFallingDistances
) {
}
