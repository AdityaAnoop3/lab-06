package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects.
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if it does not exist
     * @param city
     *   This is a candidate city to add
     */
    public void add(City city){
        if (cities.contains(city)){
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     *   Returns the sorted list
     */
    public List<City> getCities(){
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This method checks if a particular city is present in the list.
     * @param city
     *   The particular city to be checked.
     * @return
     *   Returns true if city is present and false otherwise.
     */
    public boolean hasCity(City city){
        return cities.contains(city);
    }

    /**
     * This method removes a city if it is present in the list.
     * Otherwise, it will throw an exception.
     * @param city
     *   This is the city to be removed.
     */
    public void removeCity(City city){
        if (hasCity(city)){
            cities.remove(city);
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    /**
     * This method returns the number of cities in the list
     * @return
     *   The number of cities in the list.
     */
    public int countCities(){
        return this.cities.size();
    }
}
