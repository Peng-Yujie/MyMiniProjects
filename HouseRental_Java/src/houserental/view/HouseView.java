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
                    searchHouse();
                    break;
                case '3':
                    deleteHouse();
                    break;
                case '4':
                    modifyHouse();
                    break;
                case '5':
                    listHouses(); // List houses
                    break;
                case '6':
                    exit();
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
    // Search house: get the input from user and request search service from HouseService
    public void searchHouse() {
        System.out.println("--------------------Search House------------------");
        System.out.print("Please enter the id of the house: ");
        int id = Utility.readInt();
        if(houseService.search(id) != null) {
            System.out.println("--------------------House Found-------------------");
            System.out.printf("%-4s%-10s%-12s%-20s%-6s%-10s\n", "ID", "Name", "Phone", "Address", "Rent", "Status");
            System.out.println(houseService.search(id));
        } else {
            System.out.println("--------------------No such house-----------------");
        }
    }
    // Delete house: get the input from user and request delete service from HouseService
    public void deleteHouse() {
        System.out.println("--------------------Delete House------------------");
        System.out.print("Please enter the id of the house: ");
        int id = Utility.readInt();
        if(houseService.search(id) != null) {
            System.out.println("--------------------House Found-------------------");
            System.out.printf("%-4s%-10s%-12s%-20s%-6s%-10s\n", "ID", "Name", "Phone", "Address", "Rent", "Status");
            System.out.println(houseService.search(id));
            System.out.print("Are you sure to delete? ");
            char confirm = Utility.readConfirmSelection();
            if(confirm == 'Y') {
                if(houseService.delete(id)) {
                    System.out.println("--------------------Delete Success----------------");
                } else {
                    System.out.println("--------------------Delete Failed-----------------");
                }
            }
        } else {
            System.out.println("--------------------No such house-----------------");
        }

    }
    // Modify house: get the input from user and request modify service from HouseService
    public void modifyHouse(){
        System.out.println("--------------------Modify House------------------");
        System.out.print("Please enter the id of the house: ");
        int id = Utility.readInt();
        if(houseService.search(id) != null) {
            System.out.println(houseService.search(id));
            System.out.print("House found, are you sure to modify? ");
            char confirm = Utility.readConfirmSelection();
            // If user wants to keep the original value, set the value to null
            String name = null;
            String phone = null;
            String address = null;
            int rent = 0;
            String status = null;
            // Ask user to input the new value
            if(confirm == 'Y') {
                System.out.print("Name: ");
                name = Utility.readString(20);
                System.out.print("Phone: ");
                phone = Utility.readString(12);
                System.out.print("Address: ");
                address = Utility.readString(30);
                System.out.print("Rent: ");
                rent = Utility.readInt();
                System.out.print("Status: ");
                status = Utility.readString(10);
            }
            // Pass the new values to service
            if(houseService.modify(id, name, phone, address, rent, status)) {
                System.out.println("--------------------Modify Success----------------");
            } else {
                System.out.println("--------------------Modify Failed-----------------");
            }
        } else {
            System.out.println("--------------------No such house-----------------");
        }
    }
    // Display the houses
    public void listHouses() {

        System.out.println("--------------------House List--------------------");
        System.out.printf("%-4s%-10s%-12s%-20s%-6s%-10s\n", "ID", "Name", "Phone", "Address", "Rent", "Status");
        House[] houses = houseService.list(); // Get the houses
        for( House h : houses){
            if(h != null){
                System.out.println(h);
            }
        }
        System.out.println("------------------------End-----------------------");
    }
    public void exit(){
        loop = false;
    }
}
