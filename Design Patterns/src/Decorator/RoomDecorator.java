package Decorator;

public abstract class RoomDecorator implements Room {
    private final Room room;

    RoomDecorator(Room room){
        this.room = room;
    }

    public void printFurniture(){
        room.printFurniture();
    }
}
