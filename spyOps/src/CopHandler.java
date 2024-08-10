import java.util.HashMap;
import java.util.Map;

public class CopHandler {
    private static CopHandler instance;
    private CopHandler(){
        this.copDirectory = new HashMap<>();
    }
    public static CopHandler getInstance(){
        if(instance == null)
            instance = new CopHandler();

        return instance;
    }

    private void initialise(){
        System.out.println("CopHandler initialised...");
        Building.printLine();
    }

    public void reset(){
        copDirectory.clear();
        initialise();
    }


    private class Cops{
        int[] pos;
        char facing;
        String name;

        Cops(String name, int x, int y, char facing){
            this.pos = new int[]{x, y};
            this.facing = facing;
            this.name = name;
        }
    }

    Map<String, Cops> copDirectory;

    public boolean addCop(String name, int x, int y, char facing){
        if(validateRoom(x, y)){
            Cops entity = new Cops(name, x, y, facing);
            this.copDirectory.put(name, entity);
            Building.setLabel(x, y, 'C');
            setCopVisibility(x, y, facing);
            showCopPosition(name);
            return true;
        }

        return false;
    }

    private boolean validateRoom(int x, int y){
        return Building.validateRoom(x, y, 'C');
    }
    private void setCopVisibility(int curr_x, int curr_y, char facing){
        int next_x = curr_x + Building.nextPos.get(facing)[0];
        int next_y = curr_y + Building.nextPos.get(facing)[1];
        System.out.println("validating face: " + facing);
        if(validateRoom(next_x, next_y)){
            System.out.println("validated setting face: " + facing);
            Building.setLabel(next_x, next_y, 'F');
        }
    }

    public void showCops(){
        for(String name : copDirectory.keySet()){
            showCopPosition(name);
        }
        Building.printRoom();
    }
    private void showCopPosition(String name){
        Cops entity = copDirectory.get(name);
        System.out.println("Cop " + entity.name + " is at " + entity.pos[0] + ", " + entity.pos[1] + " facing " + entity.facing + ".");
        Building.printRoom();
    }
}
