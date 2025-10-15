package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CityListTest {
    private CityList mockCityList(){
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity(){
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd(){
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException(){
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwestern Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities(){
        CityList cityList = mockCityList();
        assertEquals(0,mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity(){
        CityList cityList = mockCityList();
        assertTrue(cityList.hasCity(mockCity()));
        City city = new City("Toronto", "Ontario");
        assertFalse(cityList.hasCity(city));
    }

    @Test
    void testRemoveCity(){
        CityList cityList = mockCityList();
        City city = new City("Toronto", "Ontario");
        cityList.add(city);
        assertTrue(cityList.hasCity(city));
        cityList.removeCity(city);
        assertFalse(cityList.hasCity(city));
    }

    @Test
    void testRemoveCityException(){
        CityList cityList = mockCityList();
        City city = new City("Toronto", "Ontario");
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.removeCity(city);
        });
    }

    @Test
    void testCountCities(){
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());
        City city = new City("Toronto", "Ontario");
        cityList.add(city);
        assertEquals(2, cityList.countCities());
    }
}
