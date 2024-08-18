import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static boolean isQuit = false;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter number of floors in the building: ");
        int floorCount = in.nextInt();

        System.out.println("Enter number of spots in each floor: ");
        int spotCount = in.nextInt();

        System.out.println("Enter the spots under repair: (format-> floorID-spotID separated by comma. no whitespaces.)");
        String underRepair = in.next();

        List<String> spotsUnderRepair = Arrays.asList(underRepair.split(","));
        ParkingSystem parkingSystem = ParkingSystem.getInstance(floorCount, spotCount, spotsUnderRepair);

        while(!Main.isQuit){
            int choice = printMenu();
            switch(choice){
                case 1:
                    /* Add Vehicle */
                    addVehicle(in, parkingSystem);
                    break;
                case 2:
                    // Release Vehicle
                    releaseVehicle(in, parkingSystem);
                    break;
                case 3:
                    // Exit
                    Main.isQuit = true;
                    System.out.println("Parking Lot is closed!");
                    break;
                default:
                    // wrong choice. try again.
            }
        }

    }

    private static void addVehicle(Scanner in, ParkingSystem parkingSystem){
        System.out.println("Enter customer ID to add vehicle to the lot: ");
        parkingSystem.addVehicle(in.next());
    }

    private static void releaseVehicle(Scanner in, ParkingSystem parkingSystem){
        System.out.println("Enter spot ID and floor ID to release vehicle from the lot: (format-> floorID-spotID. no whitespaces.)");
        String str = in.next();
        int floorId = Integer.parseInt(str.split("-")[0]);
        int spotId = Integer.parseInt(str.split("-")[1]);
        parkingSystem.releaseVehicle(spotId, floorId);
    }

    private static int printMenu() {
        // add vehicle, release vehicle
        System.out.println("Select an action:");
        System.out.println("1. Add vehicle \t 2. Release vehicle \t 3. Exit");

        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();

        return choice;
    }
}