package houserental.service;

import houserental.domain.House;

/**
 * This class is used to define the array of House objects and store the data
 * 1. Response for the request of HouseView
 * 2. Responsible for adding, deleting, modifying, listing and searching house
 * */
public class HouseService {
    private House[] houses; // To store the houses

    public HouseService(int size){
        houses = new House[size];
        // Initialize the first house for test
        houses[0] = new House(1, "Jack", "123456789", "Beijing", 1000, "Unoccupied");
    }
    // Add house: receive the house object and return the result
    public boolean add(House newHouse){
        // Find the first empty position
        int i = 0;
        for(; i < houses.length; i++){
            if(houses[i] == null){
                break;
            }
        }
        // If the array is full, return false
        if(i == houses.length){
            return false;
        }
        // If the array is not full, add the house
        newHouse.setId(i + 1); // Set the id
        houses[i] = newHouse;
        return true;
    }
    // Return the houses
    public House[] list(){
        return houses;
    }
    // Expand the array
    public void expand(){
        // Create a new array with double size
        House[] newHouses = new House[houses.length * 2];
        // Copy the data from old array to new array
        System.arraycopy(houses, 0, newHouses, 0, houses.length);
        // Replace the old array with new array
        houses = newHouses;
    }
}
