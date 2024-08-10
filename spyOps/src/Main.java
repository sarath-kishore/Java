import java.util.Scanner;

public class Main {
    static boolean isQuit = false;
    public static void main(String[] args) {
//        Building building = Building.getInstance();
//        building.reset(5, 5, 4, 4);
//        InsectHandler insectHandler = InsectHandler.getInstance();
//        insectHandler.reset();
//        CopHandler copHandler = CopHandler.getInstance();
//        copHandler.reset();
//        insectHandler.addInsect("John", 0, 0, 'N');
//        copHandler.addCop("Rex", 2, 2, 'W');
//        insectHandler.commandInsect("John", "RRFLFF");
//        insectHandler.addInsect("Brown", 2, 1, 'N');
//        insectHandler.addInsect("Brown", 2, 3, 'E');
//        insectHandler.commandInsect("Brown", "FRF");
//        insectHandler.commandInsect("Dalton", "FRF");
//        Building.resizeRoom(6, 6);
//        Building.resizeRoom(5, 5);
//        Building.resizeRoom(2, 2);
        Building.getInstance().reset();

        while(!Main.isQuit){
            int choice = printMenu();
            switch(choice){
                case 1:
                    // Add insect
                    addInsect();
                    break;
                case 2:
                    // Add cop
                    addCop();
                    break;
                case 3:
                    // Command insect
//                    if(!commandInsect())
//                        isQuit
                    commandInsect();
                    break;
                case 4:
                    // Resize room
                    resizeRoom();
                    break;
                case 5:
                    // show insects
                    showInsects();
                    break;
                case 6:
                    showCops();
                    break;
                case 7:
                    // Restart game
                    Building.getInstance().reset();
                    break;
                case 8:
                    // Exit
                    Main.isQuit = true;
                    break;
                default:
                    // wrong choice. try again.
            }
        }

        Building.printLine();
        System.out.println("Thanks for playing!");
    }

    static int printMenu(){
        // add insect, add cop, command insect, resize room, restart game
        System.out.println("Select an action:");
        System.out.println("1. Add Insect \t 2. Add Cop \t 3. Command Insect \t 4. Resize room \t 5. Show Insects \t 6. Show Cops \t 7. Restart \t 8. Exit");

        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();

        return choice;
    }

    static void showInsects(){
        InsectHandler.getInstance().showInsects();
    }

    static void showCops(){
        CopHandler.getInstance().showCops();
    }
    static boolean addInsect(){
        System.out.println("Enter insect's name, (x, y) coordinates and its facing direction :");
        Scanner in = new Scanner(System.in);
        String name = in.next();
        int x = in.nextInt();
        int y = in.nextInt();
        String facing = in.next();
        return InsectHandler.getInstance().addInsect(name, x, y, facing.charAt(0));
    }

    static boolean addCop(){
        System.out.println("Enter cop's name and (x, y) coordinates and its facing direction :");
        Scanner in = new Scanner(System.in);
        String name = in.next();
        int x = in.nextInt();
        int y = in.nextInt();
        String facing = in.next();
        return CopHandler.getInstance().addCop(name, x, y, facing.charAt(0));
    }
    static boolean commandInsect(){
        System.out.println("Enter the insect name and the command:");
        Scanner in = new Scanner(System.in);
        String name = in.next();
        String command = in.next();
        return InsectHandler.getInstance().commandInsect(name, command);
    }
    static void resizeRoom(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter new length and breadth: ");
        int l = in.nextInt();
        int b = in.nextInt();
        Building.resizeRoom(l, b);
    }

//    static void reset(){
//
//
//    }

}