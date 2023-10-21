package houserental.view;

import houserental.service.HouseService;
import houserental.domain.House;
import houserental.utils.Utility;

/**
 * Functions related to house
 * 1. Display the menu
 * 2. Get the input from user
 * 3. Request the service from HouseService
 * */
public class HouseView {
    private boolean loop = true; // Loop flag
    private char key = ' '; // Get the input from user
    private HouseService houseService = new HouseService(10); // Initialize the HouseService object
    public void mainMenu(){
        do{
            System.out.println("==========House Rental Management System==========");
            System.out.println("\t\t1. Add House");
            System.out.println("\t\t2. Search House");
            System.out.println("\t\t3. Delete House");
            System.out.println("\t\t4. Modify House");
            System.out.println("\t\t5. List Houses");
            System.out.println("\t\t6. Exit");
            System.out.print("Please enter your choice(1-6): ");
            key = Utility.readChar();
            switch (key){
                case '1':
                    addHouse();
                    break;
                case '2':
                    System.out.println("Search House"); // TODO: Search house method
                    break;
                case '3':
                    System.out.println("Delete House"); // TODO: Delete house method
                    break;
                case '4':
                    System.out.println("Modify House"); // TODO: Modify house method
                    break;
                case '5':
                    listHouses(); // List houses
                    break;
                case '6':
                    System.out.println("Exit"); // TODO: Exit method
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid input, please enter again");
            }
        }while(loop);
    }
    // Add house: get the input from user and request add service from HouseService
    public void addHouse() {
        System.out.println("---------------------Add House--------------------");
        System.out.print("Name: ");
        String name = Utility.readString(20);
        System.out.print("Phone: ");
        String phone = Utility.readString(12);
        System.out.print("Address: ");
        String address = Utility.readString(30);
        System.out.print("Rent: ");
        int rent = Utility.readInt();
        System.out.print("Status: ");
        String status = Utility.readString(10);
        // Create a House object
        House newHouse = new House(0, name, phone, address, rent, status);
        if(houseService.add(newHouse)) {
            System.out.println("--------------------Add Success-------------------");
        } else {
            System.out.println("--------------------Add Failed--------------------");
        }
    }
    // Display the houses
    public void listHouses() {

        System.out.println("--------------------House List--------------------");
        System.out.println("ID\t\tName\t\tPhone\t\tAddress\t\tRent\t\tStatus");
        House[] houses = houseService.list(); // Get the houses
        for( House h : houses){
            if(h != null){
                System.out.println(h);
            }
        }
        System.out.println("------------------------End-----------------------\n");
    }
}
