package Decorator;


public class House {

    public static void main(String[] args) {

        var room = new BasicRoom();
        room.printFurniture();

        System.out.println();

        // create a room with a carpet and a couch
        var couch = new RoomWithCouch(room);
        couch.printFurniture();
        System.out.println();

//        couch.i = 20;
        // create a room with a carpet, a couch and a table
        var table = new RoomWithTable(couch);
        table.printFurniture();
        System.out.println();
//
//        couch.i = 30;
//        couch.printFurniture();
//        System.out.println();
//
//        table.printFurniture();
//        System.out.println();
    }

}
