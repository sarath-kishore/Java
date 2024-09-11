package Decorator;

public class BasicRoom implements Room {
int i;
BasicRoom(){
    i = 1;
}
    @Override
    public void printFurniture() {
        System.out.println("Carpet " + i);
    }

}
