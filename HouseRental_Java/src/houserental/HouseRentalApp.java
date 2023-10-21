package houserental;

import houserental.view.HouseView;

public class HouseRentalApp {
    public static void main(String[] args){
        // main entrance
        new HouseView().mainMenu(); // anonymous object
        System.out.println("Exit successfully");
    }
}
