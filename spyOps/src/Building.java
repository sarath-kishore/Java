import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Building {
    private static char grid[][];
    private int photoPos[];

    private static Building instance;

    public static Map<Character, int[]> nextPos;

    private Building(){
        nextPos = new HashMap<>();
        nextPos.put('N', new int[]{-1, 0});
        nextPos.put('W', new int[]{0, -1});
        nextPos.put('S', new int[]{+1, 0});
        nextPos.put('E', new int[]{0, +1});
    }

    private void initialise(int l, int b, int photo_x, int photo_y){
        grid = new char[l][b];
        photoPos = new int[]{photo_x, photo_y};
        setRoom();

        System.out.println("Building initialised...");
        printRoom();
    }

    public void reset(){
        Building.printLine();
        System.out.println("Reset initiated...");
        Building.printLine();

        Scanner in = new Scanner(System.in);
        System.out.println("Enter new dimensions for the room: (l, b)");
        int l = in.nextInt();
        int b = in.nextInt();

        System.out.println("Enter new co-ordinates for the photograph: (x, y)");
        int photo_x = in.nextInt();
        int photo_y = in.nextInt();

        System.out.println("Resetting room...");
        Building.printLine();

        initialise(l,b,photo_x, photo_y);

        InsectHandler.getInstance().reset();
        CopHandler.getInstance().reset();

        System.out.println("Reset complete...");
        Building.printLine();
        System.out.println("Welcome to spyOps!");
        Building.printLine();

    }

    private void setRoom(){
        for(int i=0; i<this.grid.length; i++){
            for(int j=0; j<this.grid[i].length; j++){
                grid[i][j] = 'O';
                if(i==photoPos[0] && j==photoPos[1]){
                    grid[i][j] = 'X';
                }
            }
        }
    }

    private static void setRoom(int new_l, int new_b){
        char[][] temp = new char[new_l][new_b];

        for(int i=0; i<temp.length; i++){
            for(int j=0; j<temp[i].length; j++){
                if(i<grid.length && j<grid[i].length)
                    temp[i][j] = grid[i][j];
                else
                    temp[i][j] = 'O';
            }
        }

        grid = temp;
    }
    public static boolean resizeRoom(int new_l, int new_b){

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(((j>=new_b) || (i>=new_l)) && grid[i][j] != 'O'){
                    System.out.println("Cannot resize room to the given dimensions. Assets found in the lost area.");
                    return false;
                }
            }
        }

        setRoom(new_l, new_b);
        printLine();
        System.out.println("Room has been resized!");
        printRoom();
        return true;
    }

    public static void setLabel(int x, int y, char label){
        grid[x][y] = label;
    }

    private static int[][] directions = new int[][]{{-1, 0}, {0, -1}, {+1, 0}, {0, +1}};

    public static boolean validateRoom(int x, int y, char label){
        int n = grid.length;
        int m = grid[0].length;
        if(x >= 0 && x < n && y>=0 && y<m){
            if(grid[x][y] == 'X' && label != 'C'){
                System.out.println("Mission Accomplished! Photograph found.");
//                Building.getInstance().reset();
                Main.isQuit = true;
                return false;
            }else if(grid[x][y] != 'O'){
                printObstacle(x,y, label);
                return false;
            }
            else if (grid[x][y] == 'O') {
                if(label == 'I')
                    return true;

                for (int[] side : directions) {
                    int next_x = x + side[0];
                    int next_y = y + side[1];
                    if (next_x >= 0 && next_x < n && next_y >= 0 && next_y < m && grid[next_x][next_y] != 'O'  && grid[next_x][next_y] != 'F' && grid[next_x][next_y] != label) {
                        // Obstacle found
                        System.out.println("Vicinity compromised! - " + next_x + ", " + next_y);
                        printObstacle(next_x, next_y, label);
                        return false;
                    }
                }
            }
            return true;
        }

        System.out.println("Hit a wall! Cannot move further.");
        printLine();
        return false;
    }

    private static void printObstacle(int x, int y, char label){
        if(grid[x][y] == 'I') {
            if(label == 'I')
                System.out.println("Another Insect present! Cannot move here.");
            else
                System.out.println("Under Insect surveillance! Cannot place Cop here.");
        }
        else if(grid[x][y] == 'C') {
            if(label == 'C')
                System.out.println("Another Cop found! Cannot move here.");
            else
                System.out.println("Cop found! Cannot place Insect here.");
        }
        else if(grid[x][y] == 'F')
            System.out.println("Under Cop surveillance! Cannot place Insect here.");
        else if(grid[x][y] == 'X' && label == 'C')
            System.out.println("Photo is here.");
        printLine();
    }

    public static void printLine(){
        System.out.println("-------------------------------------------------");
    }
    public static void printRoom(){
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                System.out.print(grid[i][j] + "\t");
            }
            System.out.println();
        }

        printLine();
    }

    public static Building getInstance(){
        if(instance == null) {
            instance = new Building();
        }

        return instance;
    }

}
