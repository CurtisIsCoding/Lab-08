package com.example.lab08;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomListTest {
    // helper method
    private CustomList makeList() {
        CustomList list = new CustomList();
        list.addCity(new City("Edmonton", "AB"));
        list.addCity(new City("Calgary", "AB"));
        return list;
    }

    @Test
    public void testHasCity() {
        CustomList list = new CustomList();
        City calgary = new City("Calgary", "AB");
        list.addCity(calgary);

        // This will fail at first, because hasCity() doesn't exist yet
        assertTrue(list.hasCity(calgary));
    }

    @Test
    public void testCountCities() {
        CustomList list = new CustomList();
        assertEquals(0, list.countCities());
        list.addCity(new City("Banff", "AB"));
        assertEquals(1, list.countCities());
        list.addCity(new City("Edmonton", "AB"));
        assertEquals(2, list.countCities());
    }

    @Test
    public void testDeleteCity_removesAndDecrements() {
        CustomList list = makeList();
        assertTrue(list.hasCity(new City("Calgary", "AB")));
        int before = list.countCities();
        list.deleteCity(new City("Calgary", "AB"));
        assertFalse(list.hasCity(new City("Calgary", "AB")));
        assertEquals(before - 1, list.countCities());
    }

    @Test
    public void testDeleteCity_throwsIfMissing() {
        CustomList list = makeList();
        assertThrows(IllegalArgumentException.class, () ->
                list.deleteCity(new City("AnotherCity", "AB"))
        );
    }

}
