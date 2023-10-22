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
        System.out.print("Please enter the id of the house(enter -1 to exit): ");
        int id = Utility.readInt();
        if(id == -1) {
            return;
        }
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
        System.out.print("Please enter the id of the house(enter -1 to exit): ");
        int id = Utility.readInt();
        if(id == -1) {
            return;
        }
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
    // Modify house: get the input from user, find the house and update the house
    public void modifyHouse(){
        System.out.println("--------------------Modify House------------------");
        System.out.print("Please enter the id of the house(enter -1 to exit): ");
        int id = Utility.readInt();
        if(id == -1) {
            return;
        }
        House h = houseService.search(id);
        if(h == null) {
            System.out.println("--------------------No such house-----------------");
            return;
        }
        System.out.println("--------------------House Found-------------------");
        System.out.printf("%-4s%-10s%-12s%-20s%-6s%-10s\n", "ID", "Name", "Phone", "Address", "Rent", "Status");
        System.out.println(h);
        System.out.printf("Name(%s): ", h.getName());
        // If the input is empty, keep the original value
        String name = Utility.readString(20, "");
        if(!name.isEmpty()) {
            h.setName(name);
        }
        System.out.printf("Phone(%s): ", h.getPhone());
        String phone = Utility.readString(12, "");
        if(!phone.isEmpty()) {
            h.setPhone(phone);
        }
        System.out.printf("Address(%s): ", h.getAddress());
        String address = Utility.readString(30, "");
        if(!address.isEmpty()) {
            h.setAddress(address);
        }
        System.out.printf("Rent(%d): ", h.getRent());
        int rent = Utility.readInt(-1);
        if(rent != -1) {
            h.setRent(rent);
        }
        System.out.printf("Status(%s): ", h.getStatus());
        String status = Utility.readString(10, "");
        if(!status.isEmpty()) {
            h.setStatus(status);
        }
        System.out.println("--------------------Modify Success----------------");
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
        System.out.print("Are you sure to exit? ");
        char confirm = Utility.readConfirmSelection();
        if(confirm == 'Y') {
            loop = false;
        }
    }
}
