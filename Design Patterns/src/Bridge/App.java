package Bridge;

public class App {

    public static void main(String[] args) {
        var circle = new Circle(new Blue());
        circle.getType();
        circle.getColor().get();

        var square = new Square(new Red());
        square.getType();
        square.getColor().get();
    }

}
