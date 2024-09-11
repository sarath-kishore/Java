package Decorator;

public class RoomWithTable extends RoomDecorator {
    RoomWithTable(Room room) {
        super(room);
        i = 1;
    }
int i;
    public void printFurniture(){
        super.printFurniture();
        System.out.println("Room with table " + i);
    }
}
