import java.util.HashMap;
import java.util.Map;

public class InsectHandler {
    private static InsectHandler instance;
    private InsectHandler(){
        this.insectDirectory = new HashMap<>();
    }

    public static InsectHandler getInstance(){
        if(instance == null)
            instance = new InsectHandler();

        return instance;
    }

    public void reset(){
        insectDirectory.clear();
        initialise();
    }

    private void initialise(){
        System.out.println("InsectHandler initialised...");
        Building.printLine();
    }

    private class Insects{
        int[] pos;
        char facing;
        String name;

        Insects(String name, int x, int y, char facing){
            this.pos = new int[]{x, y};
            this.facing = facing;
            this.name = name;
        }
    }

    private Map<String, Insects> insectDirectory;

    public boolean addInsect(String name, int x, int y, char facing){
        if(validateRoom(x, y)) {
            Insects entity = new Insects(name, x, y, facing);
            this.insectDirectory.put(name, entity);
            Building.setLabel(x, y, 'I');
            showInsectPosition(name);
            return true;
        }
//        System.out.println("Obstacle found! Cannot insert insect at this position.");
        return false;
    }

    public void showInsects(){
        for(String name : insectDirectory.keySet()){
            showInsectPosition(name);
        }
        Building.printRoom();
    }
    private void showInsectPosition(String name){
        Insects entity = insectDirectory.get(name);
        System.out.println("Insect " + entity.name + " is at " + entity.pos[0] + ", " + entity.pos[1] + " facing " + entity.facing + ".");
        Building.printRoom();
    }


    public boolean commandInsect(String name, String command){
        Insects entity = insectDirectory.get(name);
        if(entity == null)
        {
            System.out.println("Insect doesn't exist! Try again.");
            return false;
        }

        for(char com : command.toCharArray()){
            System.out.println("Executing command: " + com + " on Insect: " + name);
            if(com == 'L' || com == 'R'){
                setInsectFacing(entity, com);
            }else if(com == 'F'){
                if(!moveInsect(entity))
                    return false;
            }else{
                System.out.println("Invalid command! Try again.");
                return false;
            }
        }

        return true;
    }

    private boolean moveInsect(Insects entity){
        int curr_x = entity.pos[0];
        int curr_y = entity.pos[1];
        char facing = entity.facing;

        int next_x = curr_x + Building.nextPos.get(facing)[0];
        int next_y = curr_y + Building.nextPos.get(facing)[1];

        if(validateRoom(next_x, next_y)){
            entity.pos[0] = next_x;
            entity.pos[1] = next_y;
            Building.setLabel(curr_x, curr_y, 'O');
            Building.setLabel(next_x, next_y, 'I');
            showInsectPosition(entity.name);
            return true;
        }else{

        }

        return false;
    }


    private void setInsectFacing(Insects entity, char direction){
        Map<String, Character> directionFacing = new HashMap<>();
        directionFacing.put("N+L", 'W');
        directionFacing.put("N+R", 'E');
        directionFacing.put("E+L", 'N');
        directionFacing.put("E+R", 'S');
        directionFacing.put("S+L", 'E');
        directionFacing.put("S+R", 'W');
        directionFacing.put("W+L", 'S');
        directionFacing.put("W+R", 'N');

        entity.facing = directionFacing.get(entity.facing + "+" + direction);
        showInsectPosition(entity.name);
    }

    private boolean validateRoom(int x, int y){
        return Building.validateRoom(x, y, 'I');
    }


}
