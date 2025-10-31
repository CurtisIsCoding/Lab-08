package com.example.lab08;

import java.util.ArrayList;
import java.util.List;

public class CustomList {
    private List<City> cities;

    public CustomList() {
        this.cities = new ArrayList<>();
    }

    public void addCity(City city) {
        cities.add(city);
    }

    // Will be implemented later using TDD (leave blank for now)
    // public boolean hasCity(City city) { ... }
    public boolean hasCity(City city){
        return cities.contains(city);
    }

    public int countCities() {
        return cities.size();
    }

    public void deleteCity(City target) {
        // error if not input
        if (target == null) {
            throw new IllegalArgumentException("City is null");
        }
        // Loop to find matches
        for (int i = 0; i < cities.size(); i++) {
            City c = cities.get(i);
            if (c.getCityName().equals(target.getCityName())
                    && c.getProvinceName().equals(target.getProvinceName())) {
                cities.remove(i); // removes the city
                return;
            }
        }
        // in case of no match
        throw new IllegalArgumentException("City not found: " + target.getCityName() + ", " + target.getProvinceName());
    }

}
