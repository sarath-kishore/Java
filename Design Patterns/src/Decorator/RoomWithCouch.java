package Decorator;

public class RoomWithCouch extends RoomDecorator{
    RoomWithCouch(Room room) {
        super(room);
        i =1;
    }
    int i;

    @Override
    public void printFurniture() {
        super.printFurniture();
        System.out.println("Room with couch " + i);
    }
}
