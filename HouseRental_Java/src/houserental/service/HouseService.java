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
    // Search house: receive the id and return the house object
    public House search(int id){
        // Why this.houses[mid] is null in binary search?
        // Because the array is not full, so the last few elements are null
        // So binary search is not suitable for this situation
//        int l = 0, r = houses.length - 1;
//        while (l<=r){
//            int mid = l + (r-l)/2;
//            if(houses[mid].getId()==id){
//                return houses[mid];
//            } else if (houses[mid].getId()<id){
//                l = mid + 1;
//            } else {
//                r = mid - 1;
//            }
//        }
        // We can use sequential search instead
        for (House h : houses) {
            if (h.getId() == id) {
                return h;
            }
        }
        // If not found, return null
        return null;
    }
    // Delete house: receive the id and return the result
    public boolean delete(int id){
        // Find the house
        int i = 0;
        for(; i < houses.length; i++){
            if(houses[i].getId() == id){
                break;
            }
        }
        // If not found, return false
        if(i == houses.length){
            return false;
        }
        // If found, delete the house
        for(int j = i; j < houses.length - 1; j++){
            houses[j] = houses[j + 1];
        }
        houses[houses.length - 1] = null;
        return true;
    }
    // Modify house: receive the values and return the result
    public boolean modify(int id, String name, String phone, String address, int rent, String status){
        // Find the house
        int i = 0;
        for(; i < houses.length; i++){
            if(houses[i].getId() == id){
                break;
            }
        }
        // If not found, return false
        if(i == houses.length){
            return false;
        }
        // If found, modify the house
        // If the value is null, keep the original value
        houses[i].setName(name == null ? houses[i].getName() : name);
        houses[i].setPhone(phone == null ? houses[i].getPhone() : phone);
        houses[i].setAddress(address == null ? houses[i].getAddress() : address);
        houses[i].setRent(rent == 0 ? houses[i].getRent() : rent);
        houses[i].setStatus(status == null ? houses[i].getStatus() : status);
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
